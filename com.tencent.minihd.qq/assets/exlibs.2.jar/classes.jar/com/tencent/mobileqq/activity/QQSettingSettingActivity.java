package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiHelper;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;
import euw;
import eux;
import euy;
import eva;
import evb;
import evc;
import protocol.KQQConfig.UpgradeInfo;

public class QQSettingSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "QQSetting2Activity";
  private static final boolean jdField_a_of_type_Boolean = true;
  private long jdField_a_of_type_Long = 0L;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new evc(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new eva(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new evb(this);
  SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new eux(this);
  private UpgradeDetailWrapper jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new euw(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  TextView d = null;
  public TextView e = null;
  
  public QQSettingSettingActivity()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)this.app.getManager(35)).a("100190.100191");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
    }
  }
  
  private void c()
  {
    int i = 1;
    View localView = findViewById(2131300513);
    Drawable localDrawable = BaseApplication.getContext().getResources().getDrawable(2130841955);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper != null) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.iUpgradeType > 0) && (this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper.a.bNewSwitch == 1)) {}
      while (i != 0)
      {
        a(localView, 0, localDrawable);
        return;
        i = 0;
      }
      a(localView, 8, localDrawable);
      return;
    }
    a(localView, 8, localDrawable);
  }
  
  private void c(Card paramCard) {}
  
  private void d()
  {
    View localView = findViewById(2131300509);
    if (QQWiFiHelper.a(getApplicationContext(), this.app.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQSetting2Activity", 2, "[bobo] 显示QQWiFi入口");
      }
      localView.setVisibility(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQSetting2Activity", 2, "[bobo] 隐藏QQWiFi入口");
    }
    localView.setVisibility(8);
  }
  
  public void a()
  {
    if (!NetworkUtil.e(this))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      QQToast.a(this, getString(2131368894), 0).b(getTitleBarHeight());
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.a(36);
    if (localSecSvcHandler != null)
    {
      localSecSvcHandler.b();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = findViewById(paramInt1);
    if (localView == null) {
      return;
    }
    TextView localTextView = (TextView)localView.findViewById(2131300440);
    localTextView.setText(paramInt2);
    localTextView.setContentDescription(getString(paramInt2));
    if (paramInt3 > 0) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
    }
    localView.setBackgroundResource(2130838103);
    localView.setOnClickListener(this);
    if (paramInt1 == 2131300506)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
      this.d = localTextView;
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297942));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131297004));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297941));
      return;
    }
    if (paramInt1 == 2131300507)
    {
      localView.findViewById(2131297004).setVisibility(8);
      localView.findViewById(2131297941).setVisibility(8);
      this.e = ((TextView)localView.findViewById(2131297942));
      this.e.setText(getString(2131368934));
      this.e.setVisibility(0);
      return;
    }
    if (paramInt1 == 2131300509)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView).d(30).a();
      b();
      localView.findViewById(2131297004).setVisibility(8);
      localView.findViewById(2131297941).setVisibility(8);
      ((TextView)localView.findViewById(2131297942)).setVisibility(8);
      return;
    }
    if (paramInt1 == 2131300502)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300441));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131300442));
      return;
    }
    localView.setContentDescription(getString(paramInt2));
  }
  
  public void a(View paramView, int paramInt, Drawable paramDrawable)
  {
    View localView2 = paramView.findViewById(2131300444);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = ((ViewStub)paramView.findViewById(2131300443)).inflate();
    }
    localView1.setVisibility(paramInt);
    paramView = (ImageView)localView1.findViewById(2131300438);
    paramView.setVisibility(0);
    paramView.setImageDrawable(paramDrawable);
  }
  
  void a(Card paramCard)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCard.lLoginDays + "天");
    if (paramCard.lLoginDays >= FriendProfileCardActivity.jdField_a_of_type_Long)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840451);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-155129);
      paramCard = String.format(getString(2131362018), new Object[] { Long.valueOf(paramCard.lLoginDays) });
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramCard);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130840450);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-5855578);
    paramCard = String.format(getString(2131362019), new Object[] { Long.valueOf(paramCard.lLoginDays) });
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramCard);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.app != null)
      {
        FriendManager localFriendManager = (FriendManager)this.app.getManager(8);
        if (localFriendManager != null) {
          c(localFriendManager.a(paramString));
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("QQSetting2Activity", 2, "updateQQLevelInfo Exception!");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    if (paramBoolean)
    {
      EquipmentLockImpl.a().a(this.app, this, this.app.a(), true);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131368862));
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840291);
      return;
    }
    EquipmentLockImpl.a().a(this.app, this, this.app.a(), false);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131368861));
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840290);
  }
  
  void b(Card paramCard)
  {
    if ((paramCard.lLoginDays == 1L) || (paramCard.lLoginDays == 0L))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842129);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131367945), new Object[] { Integer.valueOf((int)FriendProfileCardActivity.jdField_a_of_type_Long) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131367945), new Object[] { Integer.valueOf((int)FriendProfileCardActivity.jdField_a_of_type_Long) }));
    }
    do
    {
      return;
      if ((paramCard.lLoginDays > 1L) && (paramCard.lLoginDays < FriendProfileCardActivity.jdField_a_of_type_Long))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842129);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131367946), new Object[] { Integer.valueOf((int)paramCard.lLoginDays), Integer.valueOf((int)(FriendProfileCardActivity.jdField_a_of_type_Long - paramCard.lLoginDays)) }));
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131367946), new Object[] { Integer.valueOf((int)paramCard.lLoginDays), Integer.valueOf((int)(FriendProfileCardActivity.jdField_a_of_type_Long - paramCard.lLoginDays)) }));
        return;
      }
    } while (paramCard.lLoginDays < FriendProfileCardActivity.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842128);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getString(2131367947), new Object[] { Integer.valueOf((int)paramCard.lLoginDays) }));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(getString(2131367947), new Object[] { Integer.valueOf((int)paramCard.lLoginDays) }));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 0) && ((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      a(paramIntent.getExtras().getBoolean("auth_dev_open", false));
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904019);
    setTitle(2131366002);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300501));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLeftText(getString(2131369101));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131369101));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    a(2131300502, 2131369092, 0, 2130838153);
    a(2131300503, 2131369093, 0, 2130838156);
    a(2131300504, 2131369117, 0, 2130838153);
    a(2131300505, 2131369096, 0, 2130838156);
    a(2131300506, 2131369097, 0, 2130838155);
    a(2131300507, 2131368933, 0, 2130838155);
    a(2131300508, 2131369099, 0, 2130838153);
    a(2131300513, 2131369100, 0, 2130838151);
    a(2131300509, 2131369104, 0, 2130838151);
    d();
    paramBundle = this.app.b(this.app.a());
    if (paramBundle != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon width =" + paramBundle.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "doOnCreate setIcon height =" + paramBundle.getMinimumHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(paramBundle, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeDetailWrapper = UpgradeController.a().a();
    c();
    a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131300498));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300499));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300500));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    a(this.app.a());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b();
    ThreadManager.a().post(new euy(this));
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    Drawable localDrawable = this.app.b(this.app.a());
    if (localDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon width =" + localDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onAccountChanged setIcon height =" + localDrawable.getMinimumHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
    a();
    a(this.app.a());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131300510: 
    case 2131300511: 
    case 2131300512: 
    default: 
    case 2131300501: 
    case 2131300503: 
    case 2131300504: 
    case 2131300505: 
    case 2131300506: 
    case 2131300507: 
    case 2131300508: 
    case 2131300509: 
      do
      {
        return;
        startActivity(new Intent(this, AccountManageActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_manage_acc", 0, 0, "", "", "", "");
        return;
        startActivity(new Intent(getActivity(), NotifyPushSettingActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_notifications", 0, 0, "", "", "", "");
        return;
        startActivity(new Intent(getActivity(), QQSettingMsgHistoryActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
        return;
        startActivity(new Intent(getActivity(), PermisionPrivacyActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_privacy_safe", 0, 0, "", "", "", "");
        return;
        startActivityForResult(new Intent(getActivity(), LoginInfoActivity.class), 0);
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "My_settab_safe", 0, 0, "", "", "", "");
        return;
        startActivity(new Intent(this, SecurityDetectActivity.class));
        return;
        startActivity(new Intent(getActivity(), AssistantSettingActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_accessibility", 0, 0, "", "", "", "");
        return;
      } while (!ProfileActivity.a(this.jdField_a_of_type_Long, System.currentTimeMillis()));
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramView = new Intent(this, QQWiFiPluginInstallActivity.class);
      paramView.putExtra("key_is_qqwifi", true);
      startActivity(paramView);
      ((RedTouchManager)this.app.getManager(35)).b("100190.100191");
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_qqwifi", 0, 0, "", "", "", "");
      return;
    case 2131300513: 
      startActivity(new Intent(getActivity(), AboutActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_about", 0, 0, "", "", "", "");
      return;
    }
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.app.a());
    paramView.putExtra("url", "https://ti.qq.com/xman/self.html?_wv=1027&adtag=setting&_bid=297");
    paramView.putExtra("hide_more_button", true);
    startActivity(paramView);
    ReportController.b(this.app, "CliOper", "", "", "0X800487F", "0X800487F", 0, 0, "", "", "", "");
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Drawable localDrawable = this.app.b(this.app.a());
    if (localDrawable != null)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon width =" + localDrawable.getMinimumWidth());
        QLog.d("QQSetting2Activity", 2, "onPostThemeChanged setIcon height =" + localDrawable.getMinimumHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(localDrawable, (int)(DeviceInfoUtil.a() * 40.0F), (int)(DeviceInfoUtil.a() * 40.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingSettingActivity
 * JD-Core Version:    0.7.0.1
 */