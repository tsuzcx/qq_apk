package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import ghl;
import ghm;

public class ContactRecommendActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "ContactRecommendActivity";
  private static final boolean jdField_a_of_type_Boolean = true;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private BaseNewFriendView.INewFriendContext jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext;
  private RecommendListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView;
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext = new ghl(this);
  }
  
  private void c()
  {
    setContentBackgroundResource(2130837687);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    setTitle(2131366045);
    this.leftView.setVisibility(8);
    setRightHighlightButton(2131368841, new ghm(this));
    enableRightHighlight(true);
    localObject = getIntent();
    ((Intent)localObject).putExtra("key_work_mode", 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView = new RecommendListView(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.a((Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView);
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    localIntent.putExtra("tab_index", 1);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    overridePendingTransition(2130968641, 0);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    b();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.h();
    super.doOnDestroy();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.d();
  }
  
  protected void doOnStop()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendRecommendListView.g();
    super.doOnStop();
  }
  
  public void onBackPressed()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.ContactRecommendActivity
 * JD-Core Version:    0.7.0.1
 */