package com.tencent.qav.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qav.QavSDK;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.session.QavSession;
import com.tencent.qav.session.QavSession.SessionStatus;
import com.tencent.qav.ui.C2CVideoLayer;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import lig;
import lij;
import lik;
import mqq.app.AppRuntime;

public class QavChatActivity
  extends BaseActivity
{
  public static final int a = -1;
  public static final String a = "isMakingAcall";
  public static final int b = 0;
  public static final String b = "key_peer_uin";
  public static final int c = 1;
  public static final String c = "key_peer_uintype";
  public static final int d = 2;
  public static final String d = "key_only_audio";
  public static final int e = 3;
  public static final String e = "key_audio_accept";
  public static final int f = 4;
  public static final String f = "key_is_receiver";
  public static final int g = 5;
  private static final String jdField_g_of_type_JavaLangString = "QavChatActivity";
  private Handler jdField_a_of_type_AndroidOsHandler;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private GLRootView jdField_a_of_type_ComTencentAvOpenglUiGLRootView;
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = null;
  private VideoControlUI.ConnectInfo jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo;
  public VideoControlUI a;
  QavAppInterface jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
  private QavBussinessCtrl jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
  private QavBussinessObserver jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver = new lig(this);
  private C2CVideoLayer jdField_a_of_type_ComTencentQavUiC2CVideoLayer;
  public boolean a;
  public boolean b;
  boolean c = false;
  private boolean d = false;
  private boolean e;
  private boolean f;
  private boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int = -1;
  private boolean jdField_h_of_type_Boolean = false;
  private int i;
  
  public QavChatActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public static void a(Window paramWindow)
  {
    try
    {
      paramWindow.addFlags(WindowManager.LayoutParams.class.getField("FLAG_NEEDS_MENU_KEY").getInt(null));
      return;
    }
    catch (NoSuchFieldException paramWindow)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("set_FLAG_NEEDS_MENU_KEY", 2, "Not exist FLAG_NEEDS_MENU_KEY filed", paramWindow);
      return;
    }
    catch (IllegalAccessException paramWindow)
    {
      while (!QLog.isDevelopLevel()) {}
      QLog.d("set_FLAG_NEEDS_MENU_KEY", 2, "Could not access FLAG_NEEDS_MENU_KEY", paramWindow);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a(paramString, paramBoolean);
    if (!paramBoolean) {
      a(true, true);
    }
    for (;;)
    {
      d(true);
      e(false);
      return;
      a(false, false);
    }
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298352));
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI = new DoubleVideoCtrlUI(this.jdField_a_of_type_ComTencentQavAppQavAppInterface, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)findViewById(2131298330));
    this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer = new C2CVideoLayer(this, this.jdField_a_of_type_ComTencentAvUiVideoControlUI);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer);
  }
  
  private void b(long paramLong)
  {
    if (this.jdField_h_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_h_of_type_Boolean = true;
    } while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong);
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.b(paramString, paramBoolean);
    if (!paramBoolean) {
      a(true, true);
    }
    for (;;)
    {
      d(true);
      e(false);
      return;
      a(false, false);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lij(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.b(String.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a()), 0);
    a(false, false);
    c(false);
    d(false);
    e(false);
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a(paramBoolean);
    this.f = paramBoolean;
    c();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a() == 0) {}
    for (int j = 1;; j = 0)
    {
      this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a(j);
      this.i = j;
      c();
      return;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    QavBussinessCtrl localQavBussinessCtrl = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localQavBussinessCtrl.b(bool);
      this.g = paramBoolean;
      c();
      return;
    }
  }
  
  public void BtnOnClick(View paramView)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(0L, paramView);
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public SmallScreenActivityPlugin a()
  {
    return this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer.b();
  }
  
  public void a(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.d(false);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a(paramLong, this.jdField_b_of_type_Boolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a(getWindow(), paramBoolean)) {
      this.c = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    long l = BaseApplicationImpl.a.a().getLongAccountUin();
    this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer.a(String.valueOf(l), String.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a()));
    this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer.a(paramBoolean1, paramBoolean2, false);
    QavSession localQavSession = QavBussinessCtrl.a().a();
    if (localQavSession != null) {
      if (!localQavSession.f)
      {
        paramBoolean1 = bool;
        if (!localQavSession.jdField_h_of_type_Boolean) {}
      }
      else
      {
        paramBoolean1 = true;
      }
    }
    for (this.e = paramBoolean1;; this.e = paramBoolean1)
    {
      c();
      return;
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQavUiC2CVideoLayer.a(paramBoolean);
    QavSession localQavSession = QavBussinessCtrl.a().a();
    if (localQavSession != null) {
      if ((localQavSession.f) || (localQavSession.jdField_h_of_type_Boolean)) {
        paramBoolean = true;
      }
    }
    for (this.e = paramBoolean;; this.e = paramBoolean)
    {
      c();
      return;
      paramBoolean = false;
      break;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.requestWindowFeature(1);
    super.getWindow().addFlags(67108864);
    super.setContentView(2130903455);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    a(true);
    b(false);
    a(super.getWindow());
    a(0);
    Object localObject = super.getAppRuntime();
    paramBundle = (Bundle)localObject;
    boolean bool1;
    if (localObject == null)
    {
      paramBundle = BaseApplicationImpl.a();
      if (paramBundle == null) {
        break label229;
      }
      QLog.d("QavChatActivity", 1, "onCreate, 尝试同步获取AppRuntime");
      paramBundle = paramBundle.a();
      localObject = new StringBuilder().append("onCreate, 同步获取AppRuntime结果");
      if (paramBundle == null) {
        break label224;
      }
      bool1 = true;
      QLog.d("QavChatActivity", 1, bool1);
    }
    for (;;)
    {
      if (paramBundle != null) {
        break label244;
      }
      com.tencent.av.AVLog.d("QavChatActivity", "onCreate, appRuntime is null exit");
      paramBundle = super.getString(2131362814) + " 0x05";
      Toast.makeText(super.getBaseContext(), paramBundle, 0).show();
      this.jdField_b_of_type_Boolean = true;
      finish();
      return false;
      label224:
      bool1 = false;
      break;
      label229:
      QLog.d("QavChatActivity", 1, "onCreate, BaseApplicationImpl.getApplication is null");
      paramBundle = (Bundle)localObject;
    }
    label244:
    this.jdField_a_of_type_ComTencentQavAppQavAppInterface = ((QavAppInterface)paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = QavChatHandler.a().b();
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = QavBussinessCtrl.a();
    QavSDK.getInstance().addObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
    paramBundle = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
    boolean bool3;
    if ((paramBundle == null) || (paramBundle.jdField_a_of_type_ComTencentQavSessionQavSession$SessionStatus == QavSession.SessionStatus.BE_INVITING))
    {
      paramBundle = getIntent();
      localObject = paramBundle.getStringExtra("key_peer_uin");
      int j = paramBundle.getIntExtra("key_peer_uintype", 0);
      bool1 = paramBundle.getBooleanExtra("key_only_audio", false);
      boolean bool2 = paramBundle.getBooleanExtra("key_is_receiver", false);
      bool3 = paramBundle.getBooleanExtra("key_audio_accept", false);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo = new VideoControlUI.ConnectInfo((String)localObject, j, bool2, bool1);
      b();
      c();
      if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a()) {
        a((String)localObject, this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b());
      }
    }
    label524:
    label531:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = SmallScreenActivityPlugin.a(this.jdField_a_of_type_ComTencentQavAppQavAppInterface);
      return true;
      if (!bool1)
      {
        b((String)localObject, bool3);
      }
      else
      {
        b((String)localObject, bool1);
        continue;
        paramBundle = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
        if (paramBundle != null)
        {
          this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo = new VideoControlUI.ConnectInfo(String.valueOf(paramBundle.jdField_a_of_type_Long), 0, paramBundle.jdField_b_of_type_Boolean, paramBundle.c);
          label473:
          b();
          c();
          if (!paramBundle.f) {
            break label524;
          }
          a(true, false);
        }
        for (;;)
        {
          if (!paramBundle.jdField_h_of_type_Boolean) {
            break label531;
          }
          c(true);
          break;
          com.tencent.qav.log.AVLog.e("QavChatActivity", "onCreate no valid session!");
          finish();
          break label473;
          a(false, false);
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    a(5);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(0L);
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
    }
    QavSDK.getInstance().removeObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    a(0);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    a(3);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(2);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(0L);
    }
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.d(true);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    QavSession localQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
    if (localQavSession != null)
    {
      if (localQavSession.f) {
        a(true, false);
      }
      if (localQavSession.jdField_h_of_type_Boolean) {
        c(true);
      }
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    a(1);
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(0L);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    a(4);
    a(0L);
    b(0L);
  }
  
  public void finish()
  {
    super.finish();
    if (!this.jdField_b_of_type_Boolean)
    {
      QavSession localQavSession = null;
      if (this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl != null) {
        localQavSession = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
      }
      if (localQavSession == null) {}
      for (int j = 8;; j = localQavSession.jdField_b_of_type_Int)
      {
        overridePendingTransition(0, SmallScreenUtils.a(j));
        return;
      }
    }
    overridePendingTransition(2130968688, 2130968687);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavChatActivity", 2, "life_onWindowFocusChanged, hasFocus[" + paramBoolean + "], nfonWindowFocus[" + this.jdField_a_of_type_Boolean);
    }
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    super.getWindow().getDecorView().postDelayed(new lik(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.activity.QavChatActivity
 * JD-Core Version:    0.7.0.1
 */