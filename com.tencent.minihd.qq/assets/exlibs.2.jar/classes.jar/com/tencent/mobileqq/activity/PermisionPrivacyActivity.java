package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.DatingObserver;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.LightalkSwitchObserver;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import epa;
import epb;
import epc;
import epe;
import epf;
import epg;
import eph;
import epi;
import epj;
import epk;

public class PermisionPrivacyActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "Q.security";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new epi(this);
  public View a;
  public CompoundButton.OnCheckedChangeListener a;
  public CompoundButton a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new epg(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new epe(this);
  LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new epf(this);
  private ActivateFriendsManager jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager;
  private DatingManager jdField_a_of_type_ComTencentMobileqqDatingDatingManager;
  private DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new epk(this);
  private LightalkSwitchManager jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager;
  private LightalkSwitchObserver jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver = new epb(this);
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new epj(this);
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public QQProgressNotifier a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  View jdField_b_of_type_AndroidViewView;
  private CompoundButton jdField_b_of_type_AndroidWidgetCompoundButton;
  public FormSwitchItem b;
  View jdField_c_of_type_AndroidViewView;
  private CompoundButton jdField_c_of_type_AndroidWidgetCompoundButton;
  public FormSwitchItem c;
  public View d;
  public FormSwitchItem d;
  private View e;
  public FormSwitchItem e;
  public FormSwitchItem f;
  public FormSwitchItem g;
  public FormSwitchItem h;
  public FormSwitchItem i;
  
  public PermisionPrivacyActivity()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton = null;
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new eph(this);
  }
  
  private void a(int paramInt)
  {
    QQToast.a(getActivity(), paramInt, 0).b(getTitleBarHeight());
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void d()
  {
    this.jdField_d_of_type_AndroidViewView = findViewById(2131300480);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300479);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300484));
    Object localObject = (ContactSyncManager)this.app.getManager(40);
    if (((ContactSyncManager)localObject).d())
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((ContactSyncManager)localObject).c());
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131300486));
      this.jdField_c_of_type_AndroidWidgetCompoundButton = ((CompoundButton)findViewById(2131300488));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300489));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.app.c(false));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300490));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300491));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300492));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300493));
      localObject = ((FriendsManager)this.app.getManager(49)).b(this.app.a());
      if (!((Card)localObject).allowClick) {
        break label850;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label227:
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject).allowPeopleSee);
      ((CardHandler)this.app.a(2)).k();
      this.h = ((FormSwitchItem)findViewById(2131300494));
      this.h.setChecked(this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager.a(true));
      this.g = ((FormSwitchItem)findViewById(2131300495));
      this.g.setChecked(this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.b());
      this.i = ((FormSwitchItem)findViewById(2131300496));
      this.i.setChecked(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager.b());
      localObject = (TextView)findViewById(2131300497);
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      String str = getString(2131369262);
      epa localepa = new epa(this, this, "https://laidian.qq.com");
      SpannableString localSpannableString = new SpannableString(((TextView)localObject).getText());
      localSpannableString.setSpan(localepa, str.indexOf("了解详情"), str.length(), 17);
      ((TextView)localObject).setText(localSpannableString);
      if (this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager.a()) {
        break label871;
      }
      this.i.setVisibility(8);
      ((TextView)localObject).setVisibility(8);
      label437:
      this.f = ((FormSwitchItem)findViewById(2131300483));
      localObject = this.f;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b())) {
        break label887;
      }
    }
    label850:
    label871:
    label887:
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      localObject = (DatingHandler)this.app.a(40);
      if (localObject != null) {
        ((DatingHandler)localObject).a();
      }
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      b(this.app.p());
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setChecked(this.app.r());
      a(this.app.o());
      ThreadManager.b(new epc(this));
      this.jdField_b_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.f.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.g.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.h.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.i.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_e_of_type_AndroidViewView = findViewById(2131300482);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300481));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_AndroidViewView.setContentDescription("动态权限设置");
      this.jdField_a_of_type_AndroidViewView.setContentDescription("加好友设置");
      this.jdField_e_of_type_AndroidViewView.setContentDescription("管理陌生人");
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("可通过系统通讯录发起QQ聊天");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("对附近的人可见");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("向好友展示网络状态");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("允许附近的人赞我");
      this.f.setContentDescription("个性签名同步到说说");
      this.g.setContentDescription("接收约会消息");
      this.i.setContentDescription("接收来电消息");
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("连续登录天数对他人可见");
      return;
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label227;
      this.i.setVisibility(0);
      ((TextView)localObject).setVisibility(0);
      break label437;
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("title", getString(2131369106));
    startActivity(localIntent.putExtra("url", "https://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
    Utils.a(this, (View)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.getParent(), true);
  }
  
  void b()
  {
    String str = this.app.getSid();
    int j = this.app.a();
    str = "https://fwd.3g.qq.com:8080/forward.jsp?bid=589&sid=" + str + "&currAppid=" + String.valueOf(j);
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.app.a());
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("title", getString(2131367936));
    startActivity(localIntent.putExtra("url", str));
  }
  
  public void b(boolean paramBoolean) {}
  
  void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004951", "0X8004951", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004952", "0X8004952", 0, 0, "", "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904018);
    setTitle(2131369096);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager = ((DatingManager)this.app.getManager(67));
    this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchManager = ((LightalkSwitchManager)this.app.getManager(81));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqAppActivateFriendsActivateFriendsManager = ((ActivateFriendsManager)this.app.getManager(80));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    d();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver);
    this.app.r();
    this.app.s();
    this.app.c(true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqQcallLightalkSwitchObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    int j = ((FriendsManager)this.app.getManager(49)).b();
    if (j > 0) {}
    for (String str = j + "人";; str = "暂无")
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(str);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("收起不常联系好友 待收起" + j + "人");
      return;
    }
  }
  
  protected String setLastActivityName()
  {
    return getString(2131369096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity
 * JD-Core Version:    0.7.0.1
 */