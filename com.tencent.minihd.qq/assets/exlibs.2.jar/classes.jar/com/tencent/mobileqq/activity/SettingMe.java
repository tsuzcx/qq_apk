package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;
import mqq.app.Constants.LogoutReason;
import mqq.app.MyFragment;

public class SettingMe
  extends BaseActivity
  implements QQTabHost.OnTabSelectionListener
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private QQSettingMe jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe;
  private boolean jdField_a_of_type_Boolean = true;
  private FrameLayout b;
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe = new QQSettingMe(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.f();
  }
  
  private void c()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(2131302159);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
    this.b = ((FrameLayout)findViewById(2131302160));
    localFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a, localFrameLayout.getChildCount() - 1);
    reLayoutClipParams(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.b);
  }
  
  private void d()
  {
    if (getResources().getConfiguration().orientation == 1) {
      return;
    }
    setContaierViewId(2131302160);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.m();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.n();
  }
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost) {}
  
  protected void addTopLayout() {}
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    reLayoutClipParams(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.b);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904433);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this);
    b();
    c();
    d();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.c();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a(this.app);
    MyFragment localMyFragment = (MyFragment)getTopFragment();
    if ((localMyFragment != null) && (!(localMyFragment.getBasePadAct() instanceof AccountManageActivity))) {
      openDefualtRightPage();
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  protected void openDefualtRightPage()
  {
    d();
  }
  
  public void rightPanelEmpty()
  {
    super.rightPanelEmpty();
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.l();
  }
  
  protected boolean willRemoveLastFragment()
  {
    return getResources().getConfiguration().orientation != 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingMe
 * JD-Core Version:    0.7.0.1
 */