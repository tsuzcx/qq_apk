package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import evh;
import evi;
import evj;
import evk;
import evl;
import evm;
import mqq.app.Constants.LogoutReason;

public class QzoneWrapperActivity
  extends BaseActivity
  implements View.OnClickListener, QQTabHost.OnTabSelectionListener
{
  private static int jdField_a_of_type_Int = 0;
  public static final String a = "uin";
  public static final String b = "_";
  public static final String c = "com.tencent.qzone.wrapper_";
  public static final String d = "com.tencent.qzone.wrapper_2131301973";
  public static final String e = "com.tencent.qzone.wrapper_2131301974";
  public static final String f = "com.tencent.qzone.wrapper_2131301975";
  public static final String g = "com.tencent.qzone.wrapper_2131301976";
  public static final String h = "com.tencent.qzone.wrapper_2131301977";
  public static final String i = "com.tencent.qzone.wrapper.selected.clear";
  public static final String j = "com.tencent.qzone.update.bubble.myfeed";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QZoneObserver jdField_a_of_type_ComTencentMobileqqObserverQZoneObserver = new evk(this);
  private boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = { 2131301973, 2131301974, 2131301975, 2131301976, 2131301977 };
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.qzone.wrapper_2131301973", "com.tencent.qzone.wrapper_2131301974", "com.tencent.qzone.wrapper_2131301975", "com.tencent.qzone.wrapper_2131301976", "com.tencent.qzone.wrapper_2131301977" };
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  int[] jdField_b_of_type_ArrayOfInt = { 2130841529, 2130841532, 2130841531, 2130841530, 2130841528 };
  private final String[] jdField_b_of_type_ArrayOfJavaLangString = { "com.tencent.qzone.update.bubble.myfeed" };
  int[] c = { 2131365689, 2131365690, 2131365691, 2131365692, 2131365693 };
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  private void a(View paramView)
  {
    d();
    paramView.post(new evj(this, paramView));
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    String str;
    if (paramInt > 0) {
      if (paramInt > 99)
      {
        str = "99+";
        paramTextView.setText(str);
        paramTextView.setVisibility(0);
      }
    }
    for (;;)
    {
      jdField_a_of_type_Int = paramInt;
      return;
      str = String.valueOf(paramInt);
      break;
      paramTextView.setVisibility(4);
    }
  }
  
  private void c()
  {
    QZoneManager localQZoneManager = (QZoneManager)this.app.getManager(9);
    if (localQZoneManager != null) {
      localQZoneManager.b(2);
    }
  }
  
  private void d()
  {
    int k = 0;
    while (k < this.jdField_a_of_type_ArrayOfInt.length)
    {
      findViewById(this.jdField_a_of_type_ArrayOfInt[k]).setSelected(false);
      k += 1;
    }
  }
  
  private void e()
  {
    QZoneHelper.a(this.app, this);
  }
  
  private void f()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.app.a();
    localUserInfo.b = this.app.c();
    localUserInfo.c = this.app.getSid();
    QZoneHelper.a(this, localUserInfo, this.app.getAccount(), 0, -1);
  }
  
  private void g()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.app.a();
    localUserInfo.b = this.app.c();
    localUserInfo.c = this.app.getSid();
    QZoneHelper.b(this, localUserInfo, Long.valueOf(this.app.getLongAccountUin()), 0, -1);
  }
  
  private void h()
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.app.a();
    String str2 = this.app.c();
    String str1 = str2;
    if (StringUtil.b(str2)) {
      str1 = this.app.c();
    }
    localUserInfo.b = str1;
    localUserInfo.c = this.app.getSid();
    QZoneHelper.a(this, localUserInfo, Long.valueOf(this.app.getLongAccountUin()), 0, 0, -1);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QZoneHelper.b(this, this.app.getAccount(), -1);
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      ((QZoneManagerImp)this.app.getManager(9)).a(true);
      return;
      if (b() > 0) {
        this.app.a().sendBroadcast(new Intent("com.tencent.qq.syncManualRefreshQzoneFeed"));
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new evl(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    String[] arrayOfString = this.jdField_b_of_type_ArrayOfJavaLangString;
    int m = arrayOfString.length;
    int k = 0;
    while (k < m)
    {
      localIntentFilter.addAction(arrayOfString[k]);
      k += 1;
    }
    registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new evm(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int m = arrayOfString.length;
    int k = 0;
    while (k < m)
    {
      localIntentFilter.addAction(arrayOfString[k]);
      k += 1;
    }
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void m()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      Button localButton = new Button(this);
      localButton.setOnClickListener(new evh(this));
      localButton.setText("Test");
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localButton);
    }
  }
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost)
  {
    i();
  }
  
  public void a(QzoneWrapperActivity.QzoneWrapperItemsEnum paramQzoneWrapperItemsEnum)
  {
    paramQzoneWrapperItemsEnum = findViewById(QzoneWrapperActivity.QzoneWrapperItemsEnum.access$000(paramQzoneWrapperItemsEnum));
    if (paramQzoneWrapperItemsEnum == null) {
      return;
    }
    d();
    paramQzoneWrapperItemsEnum.post(new evi(this, paramQzoneWrapperItemsEnum));
  }
  
  protected void addTopLayout() {}
  
  protected boolean alwaysShowRightView()
  {
    return true;
  }
  
  int b()
  {
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.app.getManager(9);
    if (localQZoneManagerImp != null) {
      return localQZoneManagerImp.a(0);
    }
    return 0;
  }
  
  public void b()
  {
    QZoneHelper.a(this, this.app.getAccount(), 0);
  }
  
  public int c()
  {
    QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)this.app.getManager(9);
    if (localQZoneManagerImp != null) {
      return localQZoneManagerImp.a(1);
    }
    return 0;
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    reLayoutClipParams(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetFrameLayout);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904374);
    l();
    k();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131301971));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131301978));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131301972));
    int k = 0;
    while (k < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramBundle = findViewById(this.jdField_a_of_type_ArrayOfInt[k]);
      ((ImageView)paramBundle.findViewById(2131300466)).setImageResource(this.jdField_b_of_type_ArrayOfInt[k]);
      ((TextView)paramBundle.findViewById(2131300467)).setText(this.c[k]);
      if (2131301973 == this.jdField_a_of_type_ArrayOfInt[k])
      {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131299987));
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          a(this.jdField_a_of_type_AndroidWidgetTextView, c());
        }
      }
      paramBundle.setOnClickListener(this);
      k += 1;
    }
    reLayoutClipParams(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_b_of_type_AndroidWidgetFrameLayout);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    m();
    j();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    clearTabStack();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onClick(View paramView)
  {
    a(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131301973: 
      b();
      return;
    case 2131301974: 
      e();
      return;
    case 2131301975: 
      f();
      return;
    case 2131301976: 
      g();
      return;
    }
    h();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void rightPanelEmpty()
  {
    super.rightPanelEmpty();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QzoneWrapperActivity
 * JD-Core Version:    0.7.0.1
 */