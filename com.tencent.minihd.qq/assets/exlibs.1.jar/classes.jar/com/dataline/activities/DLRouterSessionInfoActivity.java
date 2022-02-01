package com.dataline.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.dataline.util.DLRouterSessionListAdapter;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.XListView;
import p;
import q;

public class DLRouterSessionInfoActivity
  extends IphoneTitleBarActivity
{
  public static String a;
  public static String b = "sSelfUin";
  long jdField_a_of_type_Long = 0L;
  public ViewGroup a;
  private DLRouterSessionListAdapter jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter;
  public ScrollerRunnable a;
  public XListView a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.DLRouterSessionInfoActivity";
  }
  
  public DLRouterSessionInfoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new q(this), 10L);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_Long = Long.parseLong(paramBundle.getStringExtra("uin"));
    long l = paramBundle.getLongExtra(b, 0L);
    getWindow().setBackgroundDrawableResource(2131427366);
    setContentView(2130903248);
    setTitle(2131362300);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131297466));
    this.jdField_a_of_type_AndroidViewViewGroup.setTag(2131296424, "n/a");
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter = new DLRouterSessionListAdapter(this.app, LayoutInflater.from(this), this.jdField_a_of_type_Long, l, this);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131297467));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter);
    paramBundle = LayoutInflater.from(this).inflate(2130903177, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130840064));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new p(this));
    return true;
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComDatalineUtilDLRouterSessionListAdapter.a();
    LiteActivity.a(this, this.jdField_a_of_type_AndroidViewViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.DLRouterSessionInfoActivity
 * JD-Core Version:    0.7.0.1
 */