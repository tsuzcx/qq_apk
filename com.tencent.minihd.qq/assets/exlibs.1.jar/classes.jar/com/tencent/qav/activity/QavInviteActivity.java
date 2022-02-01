package com.tencent.qav.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.app.QavChatHandler;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.ui.VideoControlUI.ConnectInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qav.QavSDK;
import com.tencent.qav.app.QavAppInterface;
import com.tencent.qav.bussiness.QavBussinessCtrl;
import com.tencent.qav.bussiness.QavBussinessObserver;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.session.QavSession;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import lil;
import lin;
import lip;
import lis;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class QavInviteActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String a = "key_peer_uin";
  public static final String b = "key_only_audio";
  private static final String jdField_c_of_type_JavaLangString = "QavInviteActivity";
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  public TextView a;
  private SmallScreenActivityPlugin jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = null;
  public VideoControlUI.ConnectInfo a;
  AutoBgImageView jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView;
  QavAppInterface jdField_a_of_type_ComTencentQavAppQavAppInterface = null;
  private QavBussinessCtrl jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl;
  private QavBussinessObserver jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver = new lil(this);
  private lip jdField_a_of_type_Lip = new lip(this);
  private lis jdField_a_of_type_Lis = new lis(this);
  public boolean a;
  Button jdField_b_of_type_AndroidWidgetButton;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  Button jdField_c_of_type_AndroidWidgetButton;
  boolean jdField_c_of_type_Boolean = false;
  Button d;
  public boolean d;
  
  public QavInviteActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void a()
  {
    if ((!this.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) || (!this.permissionManager.checkPermission("android.permission.CAMERA"))) {
      this.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 600), PermissionItem.init("android.permission.CAMERA", 600) }).requests(new lin(this));
    }
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(this, QavChatActivity.class);
    localIntent.addFlags(262144);
    localIntent.putExtra("key_peer_uin", this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a());
    localIntent.putExtra("key_only_audio", paramBoolean1);
    localIntent.putExtra("key_audio_accept", paramBoolean2);
    localIntent.putExtra("key_is_receiver", this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a());
    startActivity(localIntent);
    finish();
  }
  
  public static boolean a(Window paramWindow, boolean paramBoolean)
  {
    return false;
  }
  
  private void b()
  {
    Object localObject = getIntent();
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo = new VideoControlUI.ConnectInfo(((Intent)localObject).getStringExtra("key_peer_uin"), 0, true, ((Intent)localObject).getBooleanExtra("key_only_audio", true));
    }
    long l;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a()))
    {
      localObject = this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a();
      if (localObject == null) {
        break label107;
      }
      l = ((QavSession)localObject).jdField_a_of_type_Long;
      if (((QavSession)localObject).jdField_a_of_type_Int != 1) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo = new VideoControlUI.ConnectInfo(String.valueOf(l), 0, true, bool);
      return;
    }
    label107:
    AVLog.e("QavInviteActivity", "onCreate no valid session!");
    finish();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)findViewById(2131298339));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    d();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298295));
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    String str;
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b())
    {
      str = "邀请你语音通话";
      localTextView.setText(str);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131298350));
      if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b()) {
        break label205;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838705);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298347));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131298346));
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)findViewById(2131298349));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b()) {
        break label218;
      }
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      str = "邀请你视频通话";
      break;
      label205:
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130838710);
    }
    label218:
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void c(boolean paramBoolean)
  {
    if ((!this.jdField_d_of_type_Boolean) || (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.w("QavInviteActivity", 1, "updateHeadAndName");
      }
      Handler localHandler = QavChatHandler.a().a();
      localHandler.removeCallbacks(this.jdField_a_of_type_Lis);
      localHandler.post(this.jdField_a_of_type_Lis);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298341));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298342));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    c(false);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl != null) {
      this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a(), 1);
    }
  }
  
  void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl.d(false);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a(paramLong, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavInviteActivity", 2, "refuseVideoRequest", new Throwable("refuseVideoRequest"));
    }
    e();
    finish();
  }
  
  public void a(boolean paramBoolean)
  {
    if (a(getWindow(), paramBoolean)) {
      this.jdField_c_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b();
    this.jdField_a_of_type_Boolean = true;
    a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.b(), paramBoolean);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void doOnBackPressed()
  {
    boolean bool = true;
    QavSession localQavSession = QavBussinessCtrl.a().a();
    if (localQavSession == null) {}
    for (;;)
    {
      QavBussinessCtrl.a().c(this.jdField_a_of_type_ComTencentAvUiVideoControlUI$ConnectInfo.a(), bool);
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.a();
      }
      return;
      if (!localQavSession.f()) {
        bool = false;
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.doOnCreate(paramBundle);
    super.requestWindowFeature(1);
    super.getWindow().addFlags(67108864);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(2097152);
    super.getWindow().addFlags(128);
    super.getWindow().setSoftInputMode(18);
    setContentView(2130903454);
    a(true);
    b(false);
    a(super.getWindow());
    paramBundle = super.getAppRuntime();
    if (paramBundle == null)
    {
      Object localObject = BaseApplicationImpl.a();
      if (localObject != null)
      {
        QLog.d("QavInviteActivity", 1, "onCreate, 尝试同步获取AppRuntime");
        paramBundle = ((BaseApplicationImpl)localObject).a();
        localObject = new StringBuilder().append("onCreate, 同步获取AppRuntime结果");
        if (paramBundle != null) {
          bool = true;
        }
        QLog.d("QavInviteActivity", 1, bool);
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQavAppQavAppInterface = ((QavAppInterface)paramBundle);
      this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = QavBussinessCtrl.a();
      b();
      c();
      QavSDK.getInstance().addObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
      QavSDK.getInstance().addObserver(this.jdField_a_of_type_Lip);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin = SmallScreenActivityPlugin.a(this.jdField_a_of_type_ComTencentQavAppQavAppInterface);
      a();
      return true;
      QLog.d("QavInviteActivity", 1, "onCreate, BaseApplicationImpl.getApplication is null");
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentQavBussinessQavBussinessCtrl = null;
    QavSDK.getInstance().removeObserver(this.jdField_a_of_type_ComTencentQavBussinessQavBussinessObserver);
    QavSDK.getInstance().removeObserver(this.jdField_a_of_type_Lip);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenActivityPlugin.b();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    a(0L);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131298349: 
      b(0L, true);
      return;
    case 2131298350: 
      b(0L, false);
      return;
    case 2131298347: 
      e();
      return;
    }
    doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qav.activity.QavInviteActivity
 * JD-Core Version:    0.7.0.1
 */