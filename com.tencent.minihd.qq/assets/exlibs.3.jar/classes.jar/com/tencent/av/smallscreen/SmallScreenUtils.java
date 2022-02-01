package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import bzd;
import com.tencent.av.VideoController;
import com.tencent.av.utils.ArrayUtils;
import com.tencent.av.utils.SeqUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.monitor.PhoneStatusTools;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class SmallScreenUtils
{
  public static final int a = 200;
  public static final String a = "SmallScreenUtils";
  public static final String[] a = { "vivo Y51A", "2014011" };
  public static final int b = 400;
  public static final String b = "com.tencent.av.smallscreen";
  static String[] b = { "com.qzone.preview.BasePictureViewer", "com.qzone.preview.LocalPictureViewer", "com.qzone.preview.QzonePictureViewer", "com.qzone.preview.QZoneVideoFloatActivity", "com.tencent.mobileqq.activity.FriendProfileImageActivity", "com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity", "com.tencent.mobileqq.activity.photo.PhotoPreviewActivity", "com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity", "com.tencent.av.gaudio.GaInviteDialogActivity", "com.tencent.av.ui.MultiIncomingCallsActivity", "com.tencent.av.ui.GAudioMembersCtrlActivity", "com.tencent.av.ui.VideoInviteActivity", "com.tencent.mobileqq.activity.selectmember.SelectMemberActivity", "cooperation.qzone.QzonePicturePluginProxyActivity", "com.tencent.av.utils.PopupDialog", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity", "com.miui.permcenter.permissions.AppPermissionsEditorActivity", "com.meizu.safe.security.AppSecActivity", "com.android.settings.Settings$AppDrawOverlaySettingsActivity" };
  public static final int c = 24;
  public static final String c = "pref_show_dialog_video";
  public static final int d = 0;
  public static final String d = "pref_show_dialog_audio";
  public static final int e = 3;
  public static final String e = "is_video";
  static int f = -1;
  static int g = -1;
  private static final int h = 5;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    default: 
      return 2130968680;
    case 1: 
      return 2130968677;
    case 2: 
      return 2130968678;
    case 3: 
      return 2130968676;
    case 4: 
      return 2130968675;
    case 5: 
      return 2130968674;
    case 6: 
      return 2130968682;
    case 7: 
      return 2130968683;
    case 8: 
      return 2130968681;
    }
    return 2130968679;
  }
  
  /* Error */
  public static int a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 109	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 4
    //   6: ldc 111
    //   8: invokestatic 117	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   11: astore 5
    //   13: new 119	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   20: ldc 122
    //   22: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 130	android/content/Context:getPackageName	()Ljava/lang/String;
    //   29: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 132
    //   34: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 6
    //   42: aload 4
    //   44: aload 5
    //   46: iconst_1
    //   47: anewarray 35	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: ldc 137
    //   54: aastore
    //   55: aload 6
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 143	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull +174 -> 240
    //   69: aload 5
    //   71: astore 4
    //   73: aload 5
    //   75: invokeinterface 149 1 0
    //   80: ifeq +160 -> 240
    //   83: aload 5
    //   85: astore 4
    //   87: aload 5
    //   89: iconst_0
    //   90: invokeinterface 152 2 0
    //   95: istore_3
    //   96: iload_3
    //   97: ifne +66 -> 163
    //   100: iconst_0
    //   101: istore_2
    //   102: aload 5
    //   104: astore 4
    //   106: ldc 10
    //   108: iconst_1
    //   109: new 119	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   116: ldc 154
    //   118: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_3
    //   122: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc 159
    //   127: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_2
    //   131: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: ldc 161
    //   136: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 167	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: iload_2
    //   146: istore_1
    //   147: aload 5
    //   149: ifnull +12 -> 161
    //   152: aload 5
    //   154: invokeinterface 170 1 0
    //   159: iload_2
    //   160: istore_1
    //   161: iload_1
    //   162: ireturn
    //   163: iconst_2
    //   164: istore_2
    //   165: goto -63 -> 102
    //   168: astore 6
    //   170: aconst_null
    //   171: astore 5
    //   173: aload 5
    //   175: astore 4
    //   177: ldc 10
    //   179: iconst_1
    //   180: ldc 172
    //   182: aload 6
    //   184: invokestatic 175	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload 5
    //   189: astore 4
    //   191: aload_0
    //   192: iload_1
    //   193: invokestatic 177	com/tencent/av/smallscreen/SmallScreenUtils:b	(Landroid/content/Context;I)I
    //   196: istore_2
    //   197: iload_2
    //   198: istore_1
    //   199: aload 5
    //   201: ifnull -40 -> 161
    //   204: aload 5
    //   206: invokeinterface 170 1 0
    //   211: iload_2
    //   212: ireturn
    //   213: astore_0
    //   214: aconst_null
    //   215: astore 4
    //   217: aload 4
    //   219: ifnull +10 -> 229
    //   222: aload 4
    //   224: invokeinterface 170 1 0
    //   229: aload_0
    //   230: athrow
    //   231: astore_0
    //   232: goto -15 -> 217
    //   235: astore 6
    //   237: goto -64 -> 173
    //   240: iconst_0
    //   241: istore_2
    //   242: goto -97 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramContext	Context
    //   0	245	1	paramInt	int
    //   101	141	2	i	int
    //   95	27	3	j	int
    //   4	219	4	localObject1	Object
    //   11	194	5	localObject2	Object
    //   40	16	6	str	String
    //   168	15	6	localThrowable1	Throwable
    //   235	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	64	168	java/lang/Throwable
    //   0	64	213	finally
    //   73	83	231	finally
    //   87	96	231	finally
    //   106	145	231	finally
    //   177	187	231	finally
    //   191	197	231	finally
    //   73	83	235	java/lang/Throwable
    //   87	96	235	java/lang/Throwable
    //   106	145	235	java/lang/Throwable
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a(paramString);
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      int i = localSharedPreferences.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "getPrefShowDialog result = " + i);
      }
      return i;
    }
  }
  
  static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("com.tencent.av.smallscreen" + paramString, 0);
  }
  
  public static void a(Context paramContext)
  {
    QLog.d("SmallScreenUtils", 1, "avideo actionOff");
    Intent localIntent = new Intent(paramContext, SmallScreenService.class);
    try
    {
      paramContext.stopService(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SmallScreenUtils", 2, "actionOff e = " + paramContext);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("isResume", paramBoolean);
    paramContext.sendBroadcast(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "sendHideSmallScreenBroadcast:" + paramBoolean);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    QLog.d("SmallScreenUtils", 1, "avideo actionOn isNeedStartDialog = " + paramBoolean1);
    Object localObject = new Intent(paramContext, SmallScreenService.class);
    try
    {
      paramContext.stopService((Intent)localObject);
      paramContext.startService((Intent)localObject);
      boolean bool = b(BaseApplicationImpl.getContext());
      if (!bool) {}
      if (!QLog.isColorLevel()) {
        break label125;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "actionOn e = " + localException);
        }
      }
      if (!a(paramContext, paramBoolean1, paramString, paramBoolean2)) {
        break label235;
      }
      ReportController.b(null, "CliOper", "", "", "0X80057D8", "0X80057D8", 0, 0, "", "", "", "");
      localException.j = false;
      return;
      localException.j = true;
    }
    QLog.d("SmallScreenUtils", 2, "actionOn isFloatWindowOpAllowed : " + a(paramContext) + ", isCalling : " + PhoneStatusTools.e(paramContext) + ", isHome : " + e(paramContext));
    label125:
    localObject = QavBussinessCtrl.a().a();
    if (localObject == null)
    {
      com.tencent.qav.log.AVLog.e("SmallScreenUtils", "actionOn session is null.");
      return;
    }
    label235:
  }
  
  public static void a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    boolean bool;
    label49:
    label64:
    AnimationSet localAnimationSet;
    if (paramView != null)
    {
      localObject = paramView.getTag(2131296448);
      if (localObject != null) {
        break label190;
      }
      bool = false;
      if ((!paramBoolean2) || (!bool)) {
        break label236;
      }
      localObject = paramView.getTag(2131296447);
      if (localObject != null) {
        break label203;
      }
      bool = false;
      if ((paramView.getVisibility() != 0) || (!bool)) {
        break label216;
      }
      bool = true;
      if (bool != paramBoolean1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenUtils", 2, "startSetVisibleAnimation isVisible = " + paramBoolean1);
        }
        localAnimationSet = new AnimationSet(true);
        if (!paramBoolean1) {
          break label222;
        }
      }
    }
    label190:
    label203:
    label216:
    label222:
    for (Object localObject = new AlphaAnimation(0.0F, 1.0F);; localObject = new AlphaAnimation(1.0F, 0.0F))
    {
      ((AlphaAnimation)localObject).setDuration(400L);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.setAnimationListener(new bzd(paramView, paramBoolean1));
      paramView.startAnimation(localAnimationSet);
      paramView.setVisibility(0);
      paramView.setTag(2131296447, Boolean.valueOf(paramBoolean1));
      paramView.setTag(2131296448, Boolean.valueOf(paramBoolean2));
      return;
      bool = ((Boolean)localObject).booleanValue();
      break;
      bool = ((Boolean)localObject).booleanValue();
      break label49;
      bool = false;
      break label64;
    }
    label236:
    paramView.clearAnimation();
    if (paramBoolean1) {}
    for (;;)
    {
      paramView.setVisibility(i);
      break;
      i = 8;
    }
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a(paramString).edit();
    if (paramBoolean) {}
    for (paramString = "pref_show_dialog_video";; paramString = "pref_show_dialog_audio")
    {
      localEditor.putInt(paramString, paramInt).commit();
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenUtils", 2, "setPrefShowDialog value = " + paramInt);
      }
      return;
    }
  }
  
  public static boolean a()
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equals(str))
      {
        QLog.w("SmallScreenUtils", 1, "useTypeToast, model[" + Build.MODEL + "]");
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(long paramLong, QavAppInterface paramQavAppInterface, int paramInt)
  {
    SmallScreenService.g = false;
    if ((paramQavAppInterface != null) && (paramQavAppInterface.getApplication() != null) && (paramQavAppInterface.a() != null) && (QavBussinessCtrl.a().a() != null))
    {
      long l = QavBussinessCtrl.a().a().a;
      Intent localIntent = new Intent("tencent.video.v2q.SmallScreenState");
      localIntent.setPackage(paramQavAppInterface.getApplication().getPackageName());
      localIntent.putExtra("SmallScreenState", paramInt);
      SeqUtil.a(localIntent, paramLong);
      localIntent.putExtra("uin", String.valueOf(l));
      paramQavAppInterface.a().sendBroadcast(localIntent);
      if (QLog.isDevelopLevel()) {
        QLog.w("SmallScreenUtils", 1, "sendSmallScreenStateBroadcast, state[" + paramInt + "], seq[" + paramLong + "]");
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    if ((a(paramContext, 24, false)) || (a())) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    if (b()) {}
    for (;;)
    {
      return false;
      if (c()) {
        paramInt = a(paramContext, paramInt);
      }
      while (paramInt == 0)
      {
        return true;
        int i = b(paramContext, paramInt);
        paramInt = i;
        if (!paramBoolean)
        {
          paramInt = i;
          if (i != 0) {
            if (e()) {
              paramInt = 0;
            } else {
              paramInt = 2;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().queryIntentActivities(new Intent(paramString), 65536).size() > 0;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      return true;
    }
    if (b()) {
      return false;
    }
    if (a(paramContext)) {
      return false;
    }
    if (PhoneStatusTools.e(paramContext)) {
      return false;
    }
    if (e(paramContext)) {
      return false;
    }
    if (f(paramContext)) {
      return false;
    }
    if (a(paramString, paramBoolean2) >= 5) {
      return false;
    }
    paramString = new Intent(paramContext, SmallScreenDialogActivity.class);
    paramString.addFlags(268435456);
    paramString.addFlags(536870912);
    paramString.addFlags(67108864);
    paramString.addFlags(131072);
    paramString.putExtra("is_video", paramBoolean2);
    paramContext.startActivity(paramString);
    return true;
  }
  
  @TargetApi(23)
  public static int b(Context paramContext, int paramInt)
  {
    do
    {
      for (;;)
      {
        try
        {
          if (d())
          {
            boolean bool = Settings.canDrawOverlays(paramContext);
            if (bool)
            {
              i = 0;
              k = i;
              m = i;
            }
          }
        }
        catch (InvocationTargetException paramContext)
        {
          Object localObject;
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenUtils", 2, "checkOp_Common InvocationTargetException", paramContext);
          }
          return 2;
          int i = j;
          continue;
        }
        catch (Exception paramContext)
        {
          int m = 0;
          int k = m;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("SmallScreenUtils", 2, "checkOp_Common Exception", paramContext);
          return m;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            m = i;
            QLog.w("SmallScreenUtils", 1, "checkOp_Common canDrawOve rlays, op[" + paramInt + "], result[" + i + "]");
            k = i;
          }
          return k;
        }
        catch (Exception paramContext)
        {
          continue;
          j = 0;
          continue;
        }
        i = 2;
      }
      localObject = paramContext.getSystemService("appops");
      paramContext = Class.forName("android.app.AppOpsManager").getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localObject, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramContext.getApplicationInfo().uid), paramContext.getPackageName() });
      if (paramContext == null) {
        break label315;
      }
      j = ((Integer)paramContext).intValue();
      if (3 != j) {
        break label279;
      }
      i = Build.VERSION.SDK_INT;
      if (i >= 23) {
        break label279;
      }
      i = 0;
      k = i;
      m = i;
    } while (!QLog.isColorLevel());
    m = i;
    QLog.w("SmallScreenUtils", 1, "checkOp_Common suc, op[" + paramInt + "], mode[" + j + "], result[" + i + "]");
    return i;
  }
  
  public static boolean b()
  {
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = VideoController.a(paramContext);
    if (((Build.MANUFACTURER.equals("Xiaomi")) && (Build.MODEL.equals("HM NOTE 1TD"))) || (Build.MODEL.equals("MI 3C")) || (Build.MODEL.equals("HM NOTE 1S"))) {}
    for (int i = 1; (bool) && (i == 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean c()
  {
    return (Build.VERSION.SDK_INT >= 24) && (Build.MANUFACTURER.equalsIgnoreCase("vivo"));
  }
  
  public static boolean c(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
  }
  
  @TargetApi(23)
  static boolean d()
  {
    if (f == -1)
    {
      f = 0;
      if (Build.VERSION.SDK_INT < 28) {
        break label32;
      }
      f = 1;
    }
    while (f == 1)
    {
      return true;
      label32:
      if (Build.VERSION.SDK_INT < 23) {}
    }
    return false;
  }
  
  public static boolean d(Context paramContext)
  {
    boolean bool2 = false;
    String str = paramContext.getPackageName();
    for (;;)
    {
      try
      {
        localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        List localList = localActivityManager.getRunningTasks(1);
        localRunningAppProcessInfo = null;
        paramContext = localRunningAppProcessInfo;
        if (localList != null)
        {
          paramContext = localRunningAppProcessInfo;
          if (localList.size() > 0) {
            paramContext = ((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity;
          }
        }
        if ((paramContext == null) || (!paramContext.getPackageName().startsWith(str))) {
          break label260;
        }
        if (!QLog.isDevelopLevel()) {
          break label265;
        }
        QLog.d("SmallScreenUtils", 2, "isAppOnForeground componentName = " + paramContext);
      }
      catch (Throwable paramContext)
      {
        ActivityManager localActivityManager;
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        bool1 = bool2;
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("SmallScreenUtils", 2, "isAppOnForeground e = " + paramContext);
        return false;
      }
      if (bool1)
      {
        paramContext = localActivityManager.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          if (paramContext.hasNext())
          {
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if ((localRunningAppProcessInfo.importance != 100) || (!localRunningAppProcessInfo.processName.startsWith(str))) {
              continue;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SmallScreenUtils", 2, "isAppOnForeground appProcess.processName = " + localRunningAppProcessInfo.processName);
            }
            bool1 = true;
            return bool1;
          }
        }
        bool1 = false;
        continue;
      }
      continue;
      label260:
      boolean bool1 = false;
      continue;
      label265:
      bool1 = true;
    }
  }
  
  static boolean e()
  {
    if (g == -1)
    {
      g = 0;
      if ((Build.MANUFACTURER.equals("vivo")) && (!"vivo X6D".equalsIgnoreCase(Build.MODEL)) && (!"vivo X6D".equalsIgnoreCase(Build.MODEL))) {
        break label56;
      }
    }
    while (g == 1)
    {
      return true;
      label56:
      g = 1;
    }
    return false;
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool4;
    try
    {
      List localList = paramContext.getPackageManager().queryIntentActivities(new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.HOME"), 0);
      bool2 = bool4;
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if (paramContext != null)
      {
        bool2 = bool4;
        paramContext = paramContext.iterator();
        bool2 = bool1;
        bool3 = bool1;
        if (paramContext.hasNext())
        {
          bool2 = bool1;
          String str = ((ActivityManager.RunningTaskInfo)paramContext.next()).topActivity.getClassName();
          bool2 = bool1;
          Iterator localIterator = localList.iterator();
          do
          {
            bool2 = bool1;
            if (!localIterator.hasNext()) {
              break;
            }
            bool2 = bool1;
            bool3 = ((ResolveInfo)localIterator.next()).activityInfo.name.equals(str);
          } while (!bool3);
          bool1 = true;
          for (;;)
          {
            if (bool1) {
              return bool1;
            }
            break;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.av.AVLog.e("SmallScreenUtils", paramContext.getMessage());
      return bool2;
    }
    return bool3;
  }
  
  public static boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenUtils", 2, "isSupportSmallScreen result = " + true);
    }
    return true;
  }
  
  public static boolean f(Context paramContext)
  {
    boolean bool1;
    if (paramContext == null)
    {
      bool1 = false;
      return bool1;
    }
    label121:
    do
    {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
        if ((paramContext == null) || (paramContext.size() <= 0)) {
          break label121;
        }
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity;
      }
      catch (Throwable paramContext)
      {
        boolean bool2;
        return false;
      }
      bool2 = ArrayUtils.contains(b, paramContext.getClassName());
      bool1 = bool2;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("SmallScreenUtils", 1, "checkTopActivityHideSmallScreen, topActivity[" + paramContext.getClassName() + "], check[" + bool2 + "]");
      return bool2;
      paramContext = null;
    } while (paramContext != null);
    return false;
  }
  
  public static boolean g()
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {}
    boolean bool1;
    try
    {
      bool1 = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      if (Build.DEVICE.equals("mx2"))
      {
        bool2 = true;
        return bool2;
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            bool1 = false;
          }
          bool2 = bool3;
        } while (Build.DEVICE.equals("mx"));
        bool2 = bool3;
      } while (Build.DEVICE.equals("m9"));
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenUtils
 * JD-Core Version:    0.7.0.1
 */