package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.biz.game.GamePushServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import hgq;
import hgr;
import hgs;
import hgt;
import hgu;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class BrowserAppInterface
  extends AppInterface
{
  public static final AtomicBoolean a;
  public static final String b;
  public int a;
  long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new hgq(this);
  public Intent a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  public boolean a;
  public boolean b;
  
  static
  {
    jdField_b_of_type_JavaLangString = BrowserAppInterface.class.getSimpleName();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public BrowserAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
  }
  
  public static String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private void a(Intent paramIntent)
  {
    try
    {
      MsfServiceSdk.get().unRegisterMsfService();
      MsfServiceSdk.get().unbindMsfService();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("qq_mode_foreground=");
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("qq_mode_foreground", false)))
        {
          bool = true;
          QLog.d((String)localObject, 2, bool);
        }
      }
      else
      {
        localObject = new hgr(this);
        bool = WebProcessManager.b();
        WebProcessManager.b(false);
        if ((paramIntent == null) || (!paramIntent.getBooleanExtra("qq_mode_foreground", false))) {
          break label152;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "restart web process");
        }
        paramIntent = new Intent();
        paramIntent.setAction("com.tencent.mobileqq.webprocess.restart_web_process");
        BaseApplicationImpl.getContext().sendBroadcast(paramIntent);
        ThreadManager.b((Runnable)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      boolean bool;
      for (;;)
      {
        localException.printStackTrace();
        continue;
        bool = false;
      }
      label152:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "exit web process");
      }
      if (bool)
      {
        paramIntent = new Intent();
        paramIntent.setAction("com.tencent.mobileqq.webprocess.report");
        BaseApplicationImpl.getContext().sendBroadcast(paramIntent);
      }
      ThreadManager.b(localException);
    }
  }
  
  public static boolean a(String paramString, ArrayList paramArrayList)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true)))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(ArrayList paramArrayList, Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      bool1 = true;
      return bool1;
    }
    paramContext = MobileQQ.getMobileQQ().getProcessName();
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (paramContext.equals(paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  private void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getPackageName());
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void c()
  {
    QbSdk.setTbsLogClient(new hgs(this, BaseApplicationImpl.getContext()));
  }
  
  public int a()
  {
    return 0;
  }
  
  public EntityManagerFactory a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public BaseApplication a()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public String a()
  {
    return getAccount();
  }
  
  public void a()
  {
    Context localContext = BaseApplication.getContext();
    Object localObject = (ConnectivityManager)localContext.getSystemService("connectivity");
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } while ((localObject == null) || (!((NetworkInfo)localObject).isConnected()) || (((NetworkInfo)localObject).getType() != 1) || (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)));
    long l = System.currentTimeMillis();
    QbSdk.setTbsListener(new hgt(this, localContext.getSharedPreferences(localContext.getPackageName() + "_preferences", 4), l));
    if (QLog.isColorLevel()) {
      QLog.d("TBS_update", 2, "tbs start download");
    }
    TbsDownloader.startDownload(BaseApplication.getContext());
  }
  
  public String b()
  {
    return ((TicketManager)getManager(2)).getVkey(getAccount());
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush.GameStatusPush" };
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { GamePushServlet.class };
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    b();
    paramBundle = BaseApplication.getContext();
    c();
    String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.tbs_switch.name(), "0|1");
    if (str.charAt(0) != '1')
    {
      QbSdk.reset(paramBundle);
      this.jdField_a_of_type_Boolean = false;
      if ((!paramBundle.getSharedPreferences("mobileQQ", 4).getBoolean("isTbsEnabled", true)) || (str.charAt(2) != '1'))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TBS_update", 2, "tbs force system webview");
        }
        QbSdk.forceSysWebView();
      }
      paramBundle = getAccount();
      if (!TextUtils.isEmpty(paramBundle)) {
        break label135;
      }
    }
    label135:
    for (paramBundle = null;; paramBundle = "QQ:" + paramBundle)
    {
      QbSdk.setCurrentID(paramBundle);
      return;
      this.jdField_a_of_type_Boolean = true;
      break;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_b_of_type_JavaLangString, 2, "unregisterReceiver: ", localIllegalArgumentException);
    }
  }
  
  protected void onRunningBackground(Bundle paramBundle)
  {
    super.onRunningBackground(paramBundle);
    ThreadManager.b(new hgu(this));
  }
  
  protected void onRunningForeground()
  {
    super.onRunningForeground();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentIntent = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BrowserAppInterface
 * JD-Core Version:    0.7.0.1
 */