package com.tencent.mobileqq.activity.main;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.CallTabUnreadListener;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSigObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.dating.DateEventManager;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.observer.SdCardChangeListener;
import com.tencent.mobileqq.observer.VipGifObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mqq.shared_file_accessor.LogUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.util.QZoneLogTags;
import gno;
import gnp;
import gnq;
import gnr;
import gns;
import gnt;
import gnu;
import gnx;
import gny;
import gnz;
import goa;
import gob;
import goc;
import god;
import goe;
import gof;
import gog;
import goh;
import goj;
import gok;
import gol;
import java.io.File;
import java.io.PrintStream;
import java.util.Observer;
import java.util.Timer;
import mqq.app.AppRuntime;
import protocol.KQQConfig.UpgradeInfo;

public class MainAssistObserver
{
  static final long jdField_a_of_type_Long = 1728000000L;
  public int a;
  public Handler a;
  public SplashActivity a;
  private CallTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener = new gnr(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new gns(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gog(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new goj(this);
  private MsgTabUnreadListener jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener = new gnq(this);
  private SecSigObserver jdField_a_of_type_ComTencentMobileqqAppSecSigObserver = new gnu(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new gol(this);
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new gnp(this);
  private GetRedPointExObserver jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new god(this);
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new gok(this);
  public SdCardChangeListener a;
  private VipGifObserver jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver = new gob(this);
  public MainAcitivityReportHelper a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private Observer jdField_a_of_type_JavaUtilObserver = new goh(this);
  public final int b = 0;
  
  public MainAssistObserver(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener = null;
    this.jdField_a_of_type_AndroidOsHandler = new gnz(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.qzone.update.bubble.myfeed");
    localIntent.putExtra("com.tencent.qzone.update.bubble.myfeed", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.sendBroadcast(localIntent);
  }
  
  private boolean a()
  {
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null))
    {
      bool2 = false;
      return bool2;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
    if (localQZoneManagerImp != null)
    {
      if ((localQZoneManagerImp.a(0) > 0) || (localQZoneManagerImp.a(5) > 0)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(QZoneLogTags.b + "MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localQZoneManagerImp.a(0) + " TYPE_ZEBRA_ALBUM:" + localQZoneManagerImp.a(5));
        return bool1;
      }
    }
    return false;
  }
  
  private boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getPackageManager();
    try
    {
      long l = new File(((PackageManager)localObject).getApplicationInfo(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getPackageName(), 0).sourceDir).lastModified();
      if (System.currentTimeMillis() - l >= 1728000000L)
      {
        localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 0);
        ((QQCustomDialog)localObject).setTitle("debug版过期了不能用，请下最新版本");
        ((QQCustomDialog)localObject).setPositiveButton("ok", new gnx(this));
        ((QQCustomDialog)localObject).setOnDismissListener(new gny(this, paramQQAppInterface));
        ((QQCustomDialog)localObject).show();
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return false;
  }
  
  private int c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
    if (localQZoneManagerImp != null) {
      return localQZoneManagerImp.a(0);
    }
    return 0;
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.d();
  }
  
  private void n()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback...");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {}
    QQAppInterface localQQAppInterface;
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
      localQQMessageFacade = localQQAppInterface.a();
    } while (localQQMessageFacade == null);
    int i = localQQMessageFacade.e();
    a(32, 16, Integer.valueOf(i));
    Object localObject = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.a().sendBroadcast((Intent)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback.msgNum.." + i);
    }
    localObject = localQQAppInterface.a();
    i = 0;
    if (localObject != null) {
      i = ((QCallFacade)localObject).a();
    }
    BadgeUtils.a(localQQAppInterface.a(), i + localQQMessageFacade.e());
  }
  
  int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    DatingManager localDatingManager = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(67);
    if (localDatingManager != null) {
      return localDatingManager.a().a();
    }
    return 0;
  }
  
  public UpgradeDetailWrapper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppMsgTabUnreadListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCallTabUnreadListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(this.jdField_a_of_type_ComTencentMobileqqAppSecSigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(45)).b();
    Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(35);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(((RedTouchManager)localObject).a());
    this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener = new SdCardChangeListener(this.jdField_a_of_type_AndroidOsHandler);
    ThreadManager.b().postDelayed(new gno(this), 1000L);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.MEDIA_MOUNTED");
    ((IntentFilter)localObject).addAction("android.intent.action.MEDIA_UNMOUNTED");
    ((IntentFilter)localObject).addAction("android.intent.action.MEDIA_REMOVED");
    ((IntentFilter)localObject).addAction("android.intent.action.MEDIA_EJECT");
    ((IntentFilter)localObject).addDataScheme("file");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener, (IntentFilter)localObject);
      if (Build.VERSION.RELEASE.startsWith("L"))
      {
        System.out.println("SecShell : art L");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, localException.getMessage());
        }
      }
      l();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt1, paramInt2, paramObject);
  }
  
  public void a(int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.a(paramInt, paramRedTypeInfo);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    SystemUtil.a(BaseApplicationImpl.getContext());
    if ((AppSetting.a == 537032257) && (b(paramQQAppInterface))) {
      return bool2;
    }
    if (NotificationActivity.a == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getAppRuntime().isLogin()) {
        if (GesturePWDUtils.getSplashLock(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getAppRuntime().getAccount()))
        {
          GesturePWDUtils.setStartFromSplash(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, true);
          bool1 = false;
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, LoginActivity.class));
        return bool1;
        GesturePWDUtils.mEnterFromSplash = false;
        bool1 = false;
        continue;
        GesturePWDUtils.mEnterFromSplash = false;
      }
    }
    return false;
  }
  
  int b()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
    if (localQZoneManagerImp != null)
    {
      int j = localQZoneManagerImp.a(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d(QZoneLogTags.b + "MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localQZoneManagerImp.a(1));
        i = j;
      }
    }
    return i;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(this.jdField_a_of_type_ComTencentMobileqqAppSecSigObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqObserverSdCardChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverVipGifObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a(45)).c();
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(35);
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.c(localRedTouchManager.a());
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) {
      LogUtil.timeLogEnd(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, null, null, null, null, "activity-show", null, false, null);
    }
    ThreadManager.a().schedule(new goe(this), 500L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
      if (this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper != null) {
        this.jdField_a_of_type_ComTencentMobileqqStatisticsMainAcitivityReportHelper.c(localQQAppInterface);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
    }
  }
  
  public void e()
  {
    new Timer().schedule(new gof(this), 500L);
  }
  
  public void f()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType <= 0) || (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch != 1)) {
        break label106;
      }
    }
    for (;;)
    {
      if ((i != 0) && (!ConfigHandler.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iNewTimeStamp))) {}
      ThreadManager.a(new gnt(this, localQQAppInterface));
      return;
      label106:
      i = 0;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = null;
    int i = b();
    a(i);
    int j = c();
    if (i > 0)
    {
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(5);
      localRedTypeInfo.red_content.set(i + "");
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    }
    for (;;)
    {
      a(36, localRedTypeInfo);
      return;
      if (j > 0)
      {
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(0);
        localRedTypeInfo.red_content.set("");
        localRedTypeInfo.red_desc.set("");
      }
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    Object localObject = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(66);
    int j = ((TroopRedTouchManager)localObject).a();
    int k = ((TroopRedTouchManager)localObject).b();
    localObject = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(35)).a();
    if ((localObject != null) && (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 5)) {}
    for (int i = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.get());; i = 0)
    {
      i = k + (i + b());
      if (i > 0)
      {
        localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(5);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set(i + "");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("{'cn':'#FF0000'}");
      }
      for (;;)
      {
        a(34, (BusinessInfoCheckUpdate.RedTypeInfo)localObject);
        return;
        if (localObject == null) {
          if ((j > 0) || (a()))
          {
            BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            localRedTypeInfo.red_type.set(0);
            localRedTypeInfo.red_content.set("");
            localRedTypeInfo.red_desc.set("");
            localObject = localRedTypeInfo;
            if (QLog.isColorLevel())
            {
              QLog.d(QZoneLogTags.b + "MainAssistObserver", 2, "except qzone other redPointNums: " + j);
              localObject = localRedTypeInfo;
            }
          }
          else
          {
            localObject = null;
          }
        }
      }
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app;
    f();
    Object localObject = localQQAppInterface.a();
    if (localObject != null)
    {
      a(32, 16, Integer.valueOf(((QQMessageFacade)localObject).e()));
      localObject = new Intent("com.tencent.qq.syncQQMessage");
      localQQAppInterface.a().sendBroadcast((Intent)localObject);
    }
    localObject = (QCallFacade)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(37);
    if (localObject != null)
    {
      a(36, 16, Integer.valueOf(((QCallFacade)localObject).a()));
      localObject = new Intent("com.tencent.qq.syncQQMessage");
      localQQAppInterface.a().sendBroadcast((Intent)localObject);
    }
    g();
  }
  
  public void j()
  {
    if (GesturePWDUtils.getStartFromSplash(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "gesturepwd auto islock true.");
      }
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, GesturePWDUnlockActivity.class);
      ((Intent)localObject).putExtra("key_gesture_from_splash", true);
      com.tencent.mobileqq.app.BaseActivity.sNotShowLockScreen = true;
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.startActivity((Intent)localObject);
    }
    GesturePWDUtils.setStartFromSplash(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, false);
    String str;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null) && (GesturePWDUtils.getGestureUnlockFailed(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a())))
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131368448);
      if (GesturePWDUtils.getGestureUnlockFailedType(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity) != 1) {
        break label171;
      }
    }
    label171:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131368449);; localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131368450))
    {
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, str, (String)localObject, 2131365736, 2131368447, new goa(this), new goc(this)).show();
      return;
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app != null))
    {
      QZoneManager localQZoneManager = (QZoneManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(9);
      if (localQZoneManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SplashActivity", 2, "click leba.test if get qzone unread.");
        }
        localQZoneManager.b(2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a.b();
      }
    }
  }
  
  public void l()
  {
    System.out.println("consolidateMethod");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver
 * JD-Core Version:    0.7.0.1
 */