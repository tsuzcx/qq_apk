package mqq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public abstract class MobileQQ
  extends BaseApplication
{
  public static final String KEY_UIN = "uin";
  private static final int MSG_ACCOUNT = 1;
  protected static final int MSG_LAST_UIN = 3;
  private static final int MSG_MONITOR = 2;
  private static final String[] PERMS = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  private static final String PREF_KEY = "currentAccount";
  private static final String PREF_SHARE = "share";
  private static final String PROPERTY_NAME = "Properties";
  public static final int STATE_EMPTY = 1;
  public static final int STATE_INITING = 2;
  public static final int STATE_READY = 3;
  public static String processName;
  private static volatile boolean sHasPhonePermission;
  private static volatile boolean sHasSDCardPermission;
  public static String sInjectResult = null;
  public static MobileQQ sMobileQQ;
  private boolean accountChanged;
  private final List<WeakReference<BaseActivity>> activitys = new ArrayList();
  protected final ArrayList<WeakReference<AppActivity>> appActivities = new ArrayList();
  private Runnable doExit = new Runnable()
  {
    public void run()
    {
      MobileQQ.this.closeAllActivitys();
      if ((MobileQQ.this.activitys.isEmpty()) && (MobileQQ.this.appActivities.isEmpty()))
      {
        MobileQQ.this.delStateFile();
        localObject1 = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
        MobileQQ.this.sendBroadcast((Intent)localObject1);
        if (MobileQQ.this.getProcessName().endsWith(":video"))
        {
          MobileQQ.this.mService.msfSub.unbindMsfService();
          MobileQQ.this.mAppRuntime.onDestroy();
        }
        MobileQQ.this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            if (MobileQQ.this.stopMSF)
            {
              MobileQQ.this.mService.msfSub.stopMsfService();
              MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.minihd.qq:MSF");
            }
            if (QLog.isColorLevel())
            {
              QLog.i("mqq", 2, String.format("Application(%s) exit.", new Object[] { MobileQQ.processName }));
              QLog.i("mqq", 2, "===========================================================");
            }
            System.exit(0);
          }
        }, 300L);
        return;
      }
      Object localObject1 = new StringBuffer();
      Iterator localIterator = MobileQQ.this.activitys.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (BaseActivity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      localIterator = MobileQQ.this.appActivities.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (AppActivity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("mqq", 2, "do exit ->" + ((StringBuffer)localObject1).toString());
      }
      ((StringBuffer)localObject1).delete(0, ((StringBuffer)localObject1).length());
      MobileQQ.this.mHandler.postDelayed(this, 50L);
    }
  };
  private boolean isCrashed;
  public boolean isPCActive = false;
  private AppRuntime mAppRuntime;
  final Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = 0;
      boolean bool = true;
      switch (paramAnonymousMessage.what)
      {
      }
      Object localObject;
      do
      {
        return;
        i = paramAnonymousMessage.arg1;
        if (paramAnonymousMessage.arg2 == 1) {}
        for (;;)
        {
          MobileQQ.this.dispatchAccountEvent(null, i, bool, (String)paramAnonymousMessage.obj);
          return;
          bool = false;
        }
        BaseApplication.monitor.setProcessName(MobileQQ.processName);
        try
        {
          BaseApplication.monitor.start();
          return;
        }
        catch (Throwable paramAnonymousMessage)
        {
          QLog.d("mqq", 1, "", paramAnonymousMessage);
          return;
        }
        paramAnonymousMessage = (String)paramAnonymousMessage.obj;
        localObject = MobileQQ.this;
        if (Build.VERSION.SDK_INT > 10) {
          i = 4;
        }
        localObject = ((MobileQQ)localObject).getSharedPreferences("Last_Login", i);
      } while (((SharedPreferences)localObject).getString("uin", "").equals(paramAnonymousMessage));
      ((SharedPreferences)localObject).edit().putString("uin", paramAnonymousMessage).commit();
    }
  };
  private volatile AtomicInteger mRuntimeState = new AtomicInteger(1);
  private MainService mService;
  private final Properties properties = new Properties();
  private Bundle savedInstanceState;
  List<SimpleAccount> sortAccountList = null;
  private boolean stopMSF = false;
  
  private void exit(final boolean paramBoolean1, boolean paramBoolean2)
  {
    this.stopMSF = paramBoolean2;
    Object localObject;
    if (getProcessName().endsWith(":video"))
    {
      localObject = this.mService.msfSub;
      if (paramBoolean1) {
        break label71;
      }
    }
    label71:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ((MsfServiceSdk)localObject).unRegisterMsfService(Boolean.valueOf(paramBoolean2));
      localObject = new Runnable()
      {
        public void run()
        {
          try
          {
            if (MobileQQ.this.mAppRuntime == null) {
              MobileQQ.this.waitAppRuntime(null);
            }
            if (!MobileQQ.this.getProcessName().endsWith(":video"))
            {
              MobileQQ.this.mAppRuntime.onDestroy();
              if (!paramBoolean1) {
                MobileQQ.this.mService.msfSub.unRegisterMsfService();
              }
              MobileQQ.this.mService.msfSub.unbindMsfService();
            }
            if (MobileQQ.this.isCrashed)
            {
              MobileQQ.this.delStateFile();
              Intent localIntent = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
              MobileQQ.this.sendBroadcast(localIntent);
              if (QLog.isColorLevel())
              {
                QLog.i("mqq", 2, String.format("Application(%s) exit.", new Object[] { MobileQQ.processName }));
                QLog.i("mqq", 2, "===========================================================");
              }
              if (MobileQQ.this.getProcessName().endsWith(":video")) {
                MobileQQ.this.mAppRuntime.onDestroy();
              }
              System.exit(0);
              return;
            }
            MobileQQ.this.doExit.run();
            return;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "exit" + localException.getMessage());
            }
          }
        }
      };
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break;
      }
      this.mHandler.postAtFrontOfQueue((Runnable)localObject);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  public static MobileQQ getMobileQQ()
  {
    return sMobileQQ;
  }
  
  public static String getShortUinStr(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 4);
    return paramString.substring(0, 4);
  }
  
  public static boolean killProcess(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!paramContext.hasNext())
      {
        do
        {
          return false;
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (paramContext == null);
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (!localRunningAppProcessInfo.processName.equals(paramString));
    Process.killProcess(localRunningAppProcessInfo.pid);
    return true;
  }
  
  private void loadProperites()
  {
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    Object localObject6 = null;
    for (;;)
    {
      try
      {
        localFileInputStream = openFileInput("Properties");
        localObject6 = localFileInputStream;
        localObject7 = localFileInputStream;
        localObject8 = localFileInputStream;
        localObject1 = localFileInputStream;
        this.properties.load(localFileInputStream);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        FileInputStream localFileInputStream;
        Object localObject2 = localObject6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject6;
        QLog.d("mqq", 2, "can not loadProperites => file not found");
        localObject2 = localObject6;
        localFileNotFoundException.printStackTrace();
        if (localObject6 == null) {
          continue;
        }
        try
        {
          localObject6.close();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      catch (IOException localIOException6)
      {
        Object localObject3 = localObject7;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localObject7;
        QLog.d("mqq", 2, "can not loadProperites => IOException");
        localObject3 = localObject7;
        localIOException6.printStackTrace();
        if (localObject7 == null) {
          continue;
        }
        try
        {
          localObject7.close();
          return;
        }
        catch (IOException localIOException3)
        {
          localIOException3.printStackTrace();
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject4 = localObject8;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject4 = localObject8;
        QLog.d("mqq", 2, "can not loadProperites ");
        localObject4 = localObject8;
        localException.printStackTrace();
        if (localObject8 == null) {
          continue;
        }
        try
        {
          localObject8.close();
          return;
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localIOException4 == null) {
          break label195;
        }
      }
      try
      {
        localFileInputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return;
      }
    }
    try
    {
      localIOException4.close();
      label195:
      throw localObject5;
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        localIOException5.printStackTrace();
      }
    }
  }
  
  /* Error */
  private void restoreBundle()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 322
    //   4: invokevirtual 326	mqq/app/MobileQQ:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual 331	java/io/File:exists	()Z
    //   12: ifeq +77 -> 89
    //   15: aconst_null
    //   16: astore_1
    //   17: aconst_null
    //   18: astore_3
    //   19: new 333	java/io/FileInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 336	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 339	java/io/FileInputStream:available	()I
    //   32: newarray byte
    //   34: astore_1
    //   35: aload_2
    //   36: aload_1
    //   37: invokevirtual 343	java/io/FileInputStream:read	([B)I
    //   40: pop
    //   41: invokestatic 349	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   44: astore_3
    //   45: aload_3
    //   46: aload_1
    //   47: iconst_0
    //   48: aload_1
    //   49: arraylength
    //   50: invokevirtual 353	android/os/Parcel:unmarshall	([BII)V
    //   53: aload_3
    //   54: iconst_0
    //   55: invokevirtual 356	android/os/Parcel:setDataPosition	(I)V
    //   58: aload_0
    //   59: aload_3
    //   60: invokevirtual 360	android/os/Parcel:readBundle	()Landroid/os/Bundle;
    //   63: putfield 150	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   66: aload_3
    //   67: invokevirtual 363	android/os/Parcel:recycle	()V
    //   70: aload_0
    //   71: getfield 150	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   74: ldc_w 365
    //   77: invokevirtual 370	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   80: pop
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 371	java/io/FileInputStream:close	()V
    //   89: return
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 299	java/io/IOException:printStackTrace	()V
    //   95: return
    //   96: astore_1
    //   97: aload_3
    //   98: astore_2
    //   99: aload_1
    //   100: astore_3
    //   101: aload_2
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 372	java/lang/Throwable:printStackTrace	()V
    //   107: aload_2
    //   108: astore_1
    //   109: aload_0
    //   110: new 367	android/os/Bundle
    //   113: dup
    //   114: invokespecial 373	android/os/Bundle:<init>	()V
    //   117: putfield 150	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   120: aload_2
    //   121: ifnull -32 -> 89
    //   124: aload_2
    //   125: invokevirtual 371	java/io/FileInputStream:close	()V
    //   128: return
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 299	java/io/IOException:printStackTrace	()V
    //   134: return
    //   135: astore_2
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 371	java/io/FileInputStream:close	()V
    //   144: aload_2
    //   145: athrow
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 299	java/io/IOException:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_3
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: astore_2
    //   159: goto -23 -> 136
    //   162: astore_3
    //   163: goto -62 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	MobileQQ
    //   16	33	1	arrayOfByte	byte[]
    //   90	2	1	localIOException1	IOException
    //   96	4	1	localThrowable1	Throwable
    //   102	7	1	localObject1	Object
    //   129	12	1	localIOException2	IOException
    //   146	2	1	localIOException3	IOException
    //   156	1	1	localObject2	Object
    //   7	118	2	localObject3	Object
    //   135	21	2	localObject4	Object
    //   158	1	2	localObject5	Object
    //   18	86	3	localObject6	Object
    //   154	4	3	localObject7	Object
    //   162	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   85	89	90	java/io/IOException
    //   19	28	96	java/lang/Throwable
    //   124	128	129	java/io/IOException
    //   19	28	135	finally
    //   103	107	135	finally
    //   109	120	135	finally
    //   140	144	146	java/io/IOException
    //   28	81	154	finally
    //   28	81	162	java/lang/Throwable
  }
  
  public void QQProcessExit(boolean paramBoolean)
  {
    exit(false, paramBoolean);
  }
  
  void addActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.add(0, new WeakReference(paramBaseActivity));
  }
  
  void closeAllActivitys()
  {
    int i = this.activitys.size();
    QLog.d("mqq", 1, "closeAllActivitys...BaseActivity count: " + i);
    i -= 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = (WeakReference)this.activitys.get(i);
      if (localObject != null)
      {
        localObject = (BaseActivity)((WeakReference)localObject).get();
        label71:
        if (localObject != null) {
          break label98;
        }
        this.activitys.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject = null;
        break label71;
        label98:
        if (!((Activity)localObject).isFinishing()) {
          ((Activity)localObject).finish();
        } else {
          this.activitys.remove(i);
        }
      }
    }
    i = this.appActivities.size();
    QLog.d("mqq", 1, "closeAllActivitys...AppActivity count: " + i);
    i -= 1;
    if (i >= 0)
    {
      localObject = (WeakReference)this.appActivities.get(i);
      if (localObject != null)
      {
        localObject = (AppActivity)((WeakReference)localObject).get();
        label193:
        if (localObject != null) {
          break label218;
        }
        this.appActivities.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        localObject = null;
        break label193;
        label218:
        if (!((Activity)localObject).isFinishing()) {
          ((Activity)localObject).finish();
        } else {
          this.appActivities.remove(i);
        }
      }
    }
  }
  
  public void crashed()
  {
    this.isCrashed = true;
  }
  
  void createNewRuntime(final SimpleAccount paramSimpleAccount, final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt, final String paramString)
  {
    QLog.d("MobileQQ", 1, "createNewRuntime" + paramBoolean2 + paramBoolean1 + paramInt + paramString);
    paramSimpleAccount = new Runnable()
    {
      public void run()
      {
        if (MobileQQ.this.mAppRuntime == null) {}
        for (int i = 1;; i = 0)
        {
          localObject1 = MobileQQ.this.createRuntime(MobileQQ.processName);
          if (localObject1 != null) {
            break;
          }
          QLog.i("mqq", 1, MobileQQ.processName + " needn't AppRuntime!");
          return;
        }
        ((AppRuntime)localObject1).init(MobileQQ.this, MobileQQ.this.mService, paramSimpleAccount);
        if (!MobileQQ.this.getProcessName().endsWith(":video")) {
          ((AppRuntime)localObject1).getService().msfSub.registerMsfService();
        }
        boolean bool1;
        long l3;
        long l1;
        long l2;
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          bool1 = true;
          if (paramInt != 2) {
            bool1 = ((AppRuntime)localObject1).canAutoLogin(paramSimpleAccount.getUin());
          }
          if (MobileQQ.this.savedInstanceState != null)
          {
            boolean bool2 = true;
            if (paramInt != 2) {
              bool2 = MobileQQ.this.savedInstanceState.getBoolean("isLogin");
            }
            QLog.d("MobileQQ", 1, "createNewRuntime" + bool2 + MobileQQ.getShortUinStr(paramSimpleAccount.getUin()));
            if (((bool2) && (bool1)) || (paramBoolean1)) {
              ((AppRuntime)localObject1).setLogined();
            }
            MobileQQ.access$702(MobileQQ.this, ((AppRuntime)localObject1).isLogin());
            if (!((AppRuntime)localObject1).isLogin()) {
              break label717;
            }
            if (MobileQQ.this.mAppRuntime != null)
            {
              MobileQQ.this.mAppRuntime.logout(Constants.LogoutReason.switchAccount, true);
              MobileQQ.this.mAppRuntime.onDestroy();
            }
            if (paramBoolean2)
            {
              localObject2 = MobileQQ.this.getFirstSimpleAccount();
              l3 = System.currentTimeMillis();
              l1 = l3;
              if (localObject2 != null) {
                l2 = l3;
              }
            }
          }
        }
        try
        {
          long l4 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(((SimpleAccount)localObject2).getUin() + Constants.Key._logintime));
          l1 = l3;
          if (l3 <= l4)
          {
            l3 = l4 + 1L;
            l1 = l3;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              l2 = l3;
              QLog.d("mqq", 2, "CNR account savetime => system time is error..shit");
              l1 = l3;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label537:
            localException.printStackTrace();
            l1 = l2;
          }
        }
        Object localObject2 = ((AppRuntime)localObject1).getAccount();
        if ((localObject2 != null) && (MobileQQ.this.getProcessName().equals(MobileQQ.this.getPackageName())))
        {
          localObject2 = MobileQQ.this.mHandler.obtainMessage(3, localObject2);
          MobileQQ.this.mHandler.sendMessageDelayed((Message)localObject2, 1000L);
        }
        MobileQQ.this.setProperty(((AppRuntime)localObject1).getAccount() + Constants.Key._logintime, String.valueOf(l1));
        ((AppRuntime)localObject1).onCreate(MobileQQ.this.savedInstanceState);
        MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
        Object localObject1 = MobileQQ.this.mHandler.obtainMessage(1);
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          ((Message)localObject1).arg2 = i;
          ((Message)localObject1).arg1 = paramInt;
          ((Message)localObject1).obj = paramString;
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break label757;
          }
          MobileQQ.this.mHandler.handleMessage((Message)localObject1);
          return;
          if ((paramBoolean1) || (bool1))
          {
            ((AppRuntime)localObject1).setLogined();
            break;
          }
          QLog.d("MobileQQ", 1, "createNewRuntime" + bool1);
          break;
          if (paramSimpleAccount != null)
          {
            QLog.d("MobileQQ", 1, "CNR account != null and account.isLogined =" + paramSimpleAccount.isLogined());
            break;
          }
          QLog.d("MobileQQ", 1, "CNR account == null");
          break;
          label717:
          if (MobileQQ.this.mAppRuntime != null) {
            break label537;
          }
          ((AppRuntime)localObject1).onCreate(MobileQQ.this.savedInstanceState);
          MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
          break label537;
        }
        label757:
        MobileQQ.this.mHandler.sendMessage((Message)localObject1);
      }
    };
    if (this.mAppRuntime == null)
    {
      paramSimpleAccount.run();
      return;
    }
    this.mHandler.post(paramSimpleAccount);
  }
  
  public abstract AppRuntime createRuntime(String paramString);
  
  void delStateFile()
  {
    this.savedInstanceState = null;
    File localFile = getFileStreamPath("savedInstanceState");
    if (localFile.exists())
    {
      if (!localFile.delete()) {
        break label70;
      }
      if (QLog.isColorLevel()) {
        QLog.i("mqq", 2, "delete file " + localFile.getPath() + " success.");
      }
    }
    label70:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("mqq", 2, "delete file " + localFile.getPath() + " failed.");
  }
  
  void dispatchAccountEvent(Constants.LogoutReason paramLogoutReason, int paramInt, boolean paramBoolean, String paramString)
  {
    boolean bool2 = true;
    int j = this.activitys.size();
    int i;
    label27:
    Object localObject;
    if (paramLogoutReason != null)
    {
      i = 1;
      j -= 1;
      if (j < 0) {
        break label191;
      }
      localObject = null;
      if (j < this.activitys.size()) {
        localObject = (WeakReference)this.activitys.get(j);
      }
      if (localObject != null) {
        break label85;
      }
    }
    for (;;)
    {
      j -= 1;
      break label27;
      i = 0;
      break;
      label85:
      localObject = (BaseActivity)((WeakReference)localObject).get();
      if (localObject == null)
      {
        this.activitys.remove(j);
      }
      else if (i == 0)
      {
        ((BaseActivity)localObject).setAppRuntime(this.mAppRuntime);
        if (this.accountChanged)
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
          ((BaseActivity)localObject).onAccountChanged();
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
          ((BaseActivity)localObject).onAccoutChangeFailed();
        }
      }
      else
      {
        QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
        ((BaseActivity)localObject).onLogout(paramLogoutReason);
      }
    }
    label191:
    j = this.appActivities.size() - 1;
    if (j >= 0)
    {
      localObject = (AppActivity)((WeakReference)this.appActivities.get(j)).get();
      if (localObject == null) {
        this.appActivities.remove(j);
      }
      for (;;)
      {
        j -= 1;
        break;
        if (i == 0)
        {
          ((AppActivity)localObject).setAppRuntime(this.mAppRuntime);
          if (this.accountChanged)
          {
            QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
            ((AppActivity)localObject).onAccountChanged();
          }
          else
          {
            QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
            ((AppActivity)localObject).onAccoutChangeFailed();
          }
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
          ((AppActivity)localObject).onLogout(paramLogoutReason);
        }
      }
    }
    paramLogoutReason = this.mAppRuntime;
    if ((AppActivity.sResumeCount <= 0) && (BaseActivity.sResumeCount <= 0))
    {
      bool1 = true;
      paramLogoutReason.isBackground_Pause = bool1;
      paramLogoutReason = this.mAppRuntime;
      if (ApplicationLifeController.getController().getVisibleActivityCount() > 0) {
        break label502;
      }
    }
    label502:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramLogoutReason.isBackground_Stop = bool1;
      if (getPackageName().equals(getProcessName()))
      {
        if (i != 0) {
          break label508;
        }
        if (this.accountChanged)
        {
          paramLogoutReason = new Intent("mqq.intent.action.ACCOUNT_CHANGED");
          paramLogoutReason.putExtra("account", this.mAppRuntime.getAccount());
          paramLogoutReason.putExtra("type", paramInt);
          sendBroadcast(paramLogoutReason);
          if (!paramBoolean)
          {
            paramLogoutReason = new Intent("mqq.intent.action.EXIT_" + getMobileQQ().getPackageName());
            paramLogoutReason.putExtra("K_EXCEP", paramString);
            sendBroadcast(paramLogoutReason);
          }
        }
      }
      return;
      bool1 = false;
      break;
    }
    label508:
    sendBroadcast(new Intent("mqq.intent.action.LOGOUT"));
  }
  
  /* Error */
  public final void doInit(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: iconst_1
    //   5: iconst_2
    //   6: invokevirtual 558	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   17: invokevirtual 562	mqq/app/MobileQQ:isNeedMSF	(Ljava/lang/String;)Z
    //   20: istore_2
    //   21: ldc_w 306
    //   24: iconst_1
    //   25: new 394	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 395	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 564
    //   35: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   41: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   53: ldc_w 566
    //   56: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   59: ifne +370 -> 429
    //   62: iload_2
    //   63: ifeq +366 -> 429
    //   66: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   69: ldc_w 568
    //   72: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   75: ifne +42 -> 117
    //   78: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   81: ldc 162
    //   83: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   86: ifne +31 -> 117
    //   89: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   92: ldc_w 570
    //   95: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   98: ifne +19 -> 117
    //   101: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   104: ldc_w 572
    //   107: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   110: ifne +7 -> 117
    //   113: aload_0
    //   114: invokespecial 574	mqq/app/MobileQQ:restoreBundle	()V
    //   117: aload_0
    //   118: new 168	mqq/app/MainService
    //   121: dup
    //   122: aload_0
    //   123: aload_0
    //   124: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   127: invokevirtual 578	mqq/app/MobileQQ:getAppId	(Ljava/lang/String;)I
    //   130: aload_0
    //   131: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   134: invokevirtual 581	mqq/app/MobileQQ:getBootBroadcastName	(Ljava/lang/String;)Ljava/lang/String;
    //   137: iload_1
    //   138: invokespecial 584	mqq/app/MainService:<init>	(Lmqq/app/MobileQQ;ILjava/lang/String;Z)V
    //   141: putfield 137	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   144: aload_0
    //   145: invokevirtual 160	mqq/app/MobileQQ:getProcessName	()Ljava/lang/String;
    //   148: ldc 162
    //   150: invokevirtual 166	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   153: ifne +13 -> 166
    //   156: aload_0
    //   157: getfield 137	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   160: getfield 172	mqq/app/MainService:msfSub	Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   163: invokevirtual 587	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:initMsfService	()V
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: astore 4
    //   171: aload_0
    //   172: getfield 150	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   175: ifnull +61 -> 236
    //   178: aload_0
    //   179: getfield 150	mqq/app/MobileQQ:savedInstanceState	Landroid/os/Bundle;
    //   182: getstatic 592	mqq/app/Constants$Key:currentAccount	Lmqq/app/Constants$Key;
    //   185: invokevirtual 593	mqq/app/Constants$Key:toString	()Ljava/lang/String;
    //   188: invokevirtual 596	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 5
    //   193: aload_3
    //   194: astore 4
    //   196: aload 5
    //   198: ifnull +38 -> 236
    //   201: aload 5
    //   203: invokestatic 602	com/tencent/qphone/base/remote/SimpleAccount:parseSimpleAccount	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   206: astore 4
    //   208: ldc_w 306
    //   211: iconst_1
    //   212: new 394	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 395	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 604
    //   222: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload 4
    //   227: invokevirtual 607	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 4
    //   238: astore_3
    //   239: aload 4
    //   241: ifnonnull +163 -> 404
    //   244: aload_0
    //   245: invokevirtual 610	mqq/app/MobileQQ:getAllAccounts	()Ljava/util/List;
    //   248: astore_3
    //   249: aload_3
    //   250: ifnull +259 -> 509
    //   253: aload_3
    //   254: iconst_0
    //   255: invokeinterface 411 2 0
    //   260: checkcast 598	com/tencent/qphone/base/remote/SimpleAccount
    //   263: astore 4
    //   265: aload 4
    //   267: astore_3
    //   268: aload 4
    //   270: ifnonnull +134 -> 404
    //   273: ldc_w 306
    //   276: iconst_1
    //   277: ldc_w 612
    //   280: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: ldc 39
    //   286: iconst_0
    //   287: invokevirtual 616	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   290: astore 6
    //   292: aload 4
    //   294: astore_3
    //   295: aload 6
    //   297: ifnull +107 -> 404
    //   300: aload 6
    //   302: ldc 36
    //   304: aconst_null
    //   305: invokeinterface 621 3 0
    //   310: astore 5
    //   312: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +31 -> 346
    //   318: ldc_w 306
    //   321: iconst_1
    //   322: new 394	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 395	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 623
    //   332: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload 5
    //   337: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload 4
    //   348: astore_3
    //   349: aload 5
    //   351: ifnull +53 -> 404
    //   354: aload 6
    //   356: invokeinterface 627 1 0
    //   361: ldc 36
    //   363: invokeinterface 632 2 0
    //   368: invokeinterface 635 1 0
    //   373: pop
    //   374: new 598	com/tencent/qphone/base/remote/SimpleAccount
    //   377: dup
    //   378: invokespecial 636	com/tencent/qphone/base/remote/SimpleAccount:<init>	()V
    //   381: astore_3
    //   382: aload_3
    //   383: aload 5
    //   385: invokevirtual 639	com/tencent/qphone/base/remote/SimpleAccount:setUin	(Ljava/lang/String;)V
    //   388: aload_3
    //   389: invokevirtual 642	com/tencent/qphone/base/remote/SimpleAccount:isLogined	()Z
    //   392: pop
    //   393: aload_3
    //   394: ldc_w 644
    //   397: iconst_1
    //   398: invokestatic 647	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   401: invokevirtual 651	com/tencent/qphone/base/remote/SimpleAccount:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   404: iconst_0
    //   405: istore_1
    //   406: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   409: ldc_w 653
    //   412: invokevirtual 269	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   415: ifeq +5 -> 420
    //   418: iconst_1
    //   419: istore_1
    //   420: aload_0
    //   421: aload_3
    //   422: iconst_0
    //   423: iload_1
    //   424: iconst_5
    //   425: aconst_null
    //   426: invokevirtual 655	mqq/app/MobileQQ:createNewRuntime	(Lcom/tencent/qphone/base/remote/SimpleAccount;ZZILjava/lang/String;)V
    //   429: aload_0
    //   430: new 522	android/content/Intent
    //   433: dup
    //   434: new 394	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 395	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 657
    //   444: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: getstatic 559	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   450: invokevirtual 401	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 407	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokespecial 527	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   459: invokevirtual 545	mqq/app/MobileQQ:sendBroadcast	(Landroid/content/Intent;)V
    //   462: aload_0
    //   463: getfield 115	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   466: astore_3
    //   467: aload_3
    //   468: monitorenter
    //   469: aload_0
    //   470: getfield 115	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   473: iconst_3
    //   474: invokevirtual 660	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   477: aload_0
    //   478: getfield 115	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   481: invokevirtual 665	java/lang/Object:notifyAll	()V
    //   484: aload_3
    //   485: monitorexit
    //   486: ldc_w 306
    //   489: iconst_1
    //   490: ldc_w 667
    //   493: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload_0
    //   497: getfield 120	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   500: iconst_2
    //   501: ldc2_w 668
    //   504: invokevirtual 673	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   507: pop
    //   508: return
    //   509: aconst_null
    //   510: astore 4
    //   512: goto -247 -> 265
    //   515: astore 4
    //   517: aload_3
    //   518: monitorexit
    //   519: aload 4
    //   521: athrow
    //   522: astore_3
    //   523: ldc_w 306
    //   526: iconst_1
    //   527: ldc_w 675
    //   530: aload_3
    //   531: invokestatic 679	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   534: new 681	java/lang/RuntimeException
    //   537: dup
    //   538: aload_3
    //   539: invokespecial 684	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   542: athrow
    //   543: astore 4
    //   545: aload_0
    //   546: getfield 115	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   549: astore_3
    //   550: aload_3
    //   551: monitorenter
    //   552: aload_0
    //   553: getfield 115	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   556: iconst_3
    //   557: invokevirtual 660	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   560: aload_0
    //   561: getfield 115	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   564: invokevirtual 665	java/lang/Object:notifyAll	()V
    //   567: aload_3
    //   568: monitorexit
    //   569: ldc_w 306
    //   572: iconst_1
    //   573: ldc_w 667
    //   576: invokestatic 312	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload_0
    //   580: getfield 120	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   583: iconst_2
    //   584: ldc2_w 668
    //   587: invokevirtual 673	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   590: pop
    //   591: aload 4
    //   593: athrow
    //   594: astore 4
    //   596: aload_3
    //   597: monitorexit
    //   598: aload 4
    //   600: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	this	MobileQQ
    //   0	601	1	paramBoolean	boolean
    //   20	43	2	bool	boolean
    //   522	17	3	localThrowable	Throwable
    //   169	342	4	localObject2	Object
    //   515	5	4	localObject3	Object
    //   543	49	4	localObject4	Object
    //   594	5	4	localObject5	Object
    //   191	193	5	str	String
    //   290	65	6	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   469	486	515	finally
    //   517	519	515	finally
    //   13	62	522	java/lang/Throwable
    //   66	117	522	java/lang/Throwable
    //   117	166	522	java/lang/Throwable
    //   171	193	522	java/lang/Throwable
    //   201	236	522	java/lang/Throwable
    //   244	249	522	java/lang/Throwable
    //   253	265	522	java/lang/Throwable
    //   273	292	522	java/lang/Throwable
    //   300	346	522	java/lang/Throwable
    //   354	404	522	java/lang/Throwable
    //   406	418	522	java/lang/Throwable
    //   420	429	522	java/lang/Throwable
    //   429	462	522	java/lang/Throwable
    //   13	62	543	finally
    //   66	117	543	finally
    //   117	166	543	finally
    //   171	193	543	finally
    //   201	236	543	finally
    //   244	249	543	finally
    //   253	265	543	finally
    //   273	292	543	finally
    //   300	346	543	finally
    //   354	404	543	finally
    //   406	418	543	finally
    //   420	429	543	finally
    //   429	462	543	finally
    //   523	543	543	finally
    //   552	569	594	finally
    //   596	598	594	finally
  }
  
  public boolean doesHasPhonePermission()
  {
    if (!sHasPhonePermission)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label42;
      }
      if ((context == null) || (context.checkSelfPermission(PERMS[1]) != 0)) {}
    }
    label42:
    for (sHasPhonePermission = true;; sHasPhonePermission = true) {
      return sHasPhonePermission;
    }
  }
  
  public boolean doesHasSDCardPermission()
  {
    if (!sHasSDCardPermission)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label42;
      }
      if ((context == null) || (context.checkSelfPermission(PERMS[0]) != 0)) {}
    }
    label42:
    for (sHasSDCardPermission = true;; sHasSDCardPermission = true) {
      return sHasSDCardPermission;
    }
  }
  
  public List<SimpleAccount> getAllAccounts()
  {
    if (this.sortAccountList == null)
    {
      ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList();
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.sortAccountList = localArrayList;
      }
    }
    if ((this.sortAccountList != null) && (this.sortAccountList.size() > 0))
    {
      Collections.sort(this.sortAccountList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l1 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          long l2 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime));
          if ((paramAnonymousSimpleAccount1 != null) && (QLog.isColorLevel())) {
            QLog.d("mqq", 2, "a1.getUin() = " + paramAnonymousSimpleAccount1.getUin() + ";key.time = " + l1);
          }
          if ((paramAnonymousSimpleAccount2 != null) && (QLog.isColorLevel())) {
            QLog.d("mqq", 2, "a2.getUin() = " + paramAnonymousSimpleAccount2.getUin() + ";key.time = " + l2);
          }
          if (l2 > l1) {
            return 1;
          }
          return -1;
        }
      });
      return Collections.unmodifiableList(this.sortAccountList);
    }
    if (QLog.isColorLevel()) {
      QLog.w("mqq", 2, "Account list is NULL!");
    }
    return null;
  }
  
  public List<SimpleAccount> getAllNotSynAccountList()
  {
    return this.sortAccountList;
  }
  
  public abstract int getAppId(String paramString);
  
  public AppRuntime getAppRuntime(String paramString)
    throws AccountNotMatchException
  {
    AppRuntime localAppRuntime = waitAppRuntime(null);
    if ((paramString != null) && (paramString.equals(localAppRuntime.getAccount()))) {}
    while (paramString == localAppRuntime.getAccount()) {
      return localAppRuntime;
    }
    throw new AccountNotMatchException(localAppRuntime.getAccount(), paramString);
  }
  
  public abstract String getBootBroadcastName(String paramString);
  
  public SimpleAccount getFirstSimpleAccount()
  {
    List localList = getAllAccounts();
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    return (SimpleAccount)localList.get(0);
  }
  
  public String getProcessName()
  {
    if (processName == null)
    {
      Object localObject = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == Process.myPid()) {
            processName = localRunningAppProcessInfo.processName;
          }
        }
      }
      if (processName == null) {
        processName = getApplicationInfo().name;
      }
    }
    return processName;
  }
  
  public String getProperty(String paramString)
  {
    return this.properties.getProperty(paramString);
  }
  
  public int getVisibleActivityCount()
  {
    return ApplicationLifeController.getController().getVisibleActivityCount();
  }
  
  public abstract boolean isNeedMSF(String paramString);
  
  public boolean isRuntimeReady()
  {
    return this.mRuntimeState.get() == 3;
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean) {}
  
  public void onCreate()
  {
    sMobileQQ = this;
    if (this.activitys != null) {
      Collections.synchronizedList(this.activitys);
    }
    ApplicationLifeController.getController();
    super.onCreate();
  }
  
  public void otherProcessExit(boolean paramBoolean)
  {
    exit(paramBoolean, false);
  }
  
  public List<SimpleAccount> refreAccountList()
  {
    ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList();
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.sortAccountList = localArrayList;
    }
    if ((this.sortAccountList != null) && (this.sortAccountList.size() > 0))
    {
      Collections.sort(this.sortAccountList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          if (MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime)) > l) {
            return 1;
          }
          return -1;
        }
      });
      return Collections.unmodifiableList(this.sortAccountList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "refreAccountList Account list is NULL!");
    }
    return this.sortAccountList;
  }
  
  void removeActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.remove(new WeakReference(paramBaseActivity));
  }
  
  public void reportPCActive(String paramString, int paramInt) {}
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if ((this.mAppRuntime != null) && (this.mAppRuntime.getAccount() != null) && (this.mAppRuntime.getAccount().length() > 0)) {
      this.mAppRuntime.setAutoLogin(paramBoolean);
    }
  }
  
  public void setProperty(String paramString1, String paramString2)
  {
    this.properties.setProperty(paramString1, paramString2);
    paramString2 = null;
    paramString1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = openFileOutput("Properties", 0);
        paramString1 = localFileOutputStream;
        paramString2 = localFileOutputStream;
        this.properties.store(localFileOutputStream, null);
        paramString1 = localFileOutputStream;
        paramString2 = localFileOutputStream;
        localFileOutputStream.flush();
      }
      catch (Exception localException)
      {
        FileOutputStream localFileOutputStream;
        paramString2 = paramString1;
        localException.printStackTrace();
        if (paramString1 == null) {
          continue;
        }
        try
        {
          paramString1.close();
          return;
        }
        catch (IOException paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
      }
      finally
      {
        if (paramString2 == null) {
          break label89;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    try
    {
      paramString2.close();
      label89:
      throw paramString1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public void setSortAccountList(List<SimpleAccount> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          if (MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime)) > l) {
            return 1;
          }
          return -1;
        }
      });
      this.sortAccountList = paramList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "sort AccountList" + this.sortAccountList);
    }
  }
  
  public void startService()
  {
    if (this.mService != null) {
      this.mService.start();
    }
  }
  
  public long string2Long(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long number is empty");
      }
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long catch exception");
      }
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public AppRuntime waitAppRuntime(BaseActivity arg1)
  {
    int i = this.mRuntimeState.get();
    if (i != 3) {
      if (i == 1)
      {
        QLog.e("mqq", 1, "waitInit when empty: ", new RuntimeException(""));
        doInit(true);
      }
    }
    synchronized (this.mRuntimeState)
    {
      i = this.mRuntimeState.get();
      if (i == 2) {}
      try
      {
        this.mRuntimeState.wait();
        return this.mAppRuntime;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          QLog.e("mqq", 1, "waitInit failed", localInterruptedException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.MobileQQ
 * JD-Core Version:    0.7.0.1
 */