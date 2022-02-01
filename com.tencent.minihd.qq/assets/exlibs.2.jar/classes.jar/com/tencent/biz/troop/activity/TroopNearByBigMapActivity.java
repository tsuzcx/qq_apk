package com.tencent.biz.troop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import coe;
import cof;
import com.tencent.biz.map.TroopNearByBigMapView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class TroopNearByBigMapActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "lat";
  private static final String b = "lon";
  private TroopNearByBigMapView jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView;
  private boolean jdField_a_of_type_Boolean = true;
  
  private void a()
  {
    if (this.leftView != null) {
      this.leftView.setVisibility(8);
    }
    setTitle(getString(2131365794));
    setRightButton(2131367454, new cof(this));
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, TroopNearByBigMapActivity.class);
    localIntent.putExtra("lat", paramInt1);
    localIntent.putExtra("lon", paramInt2);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2130968595, 2130968592);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("lat", 0);
    int j = getIntent().getIntExtra("lon", 0);
    this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView = new TroopNearByBigMapView(this, this.app, i, j);
    this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView.a();
    this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView.setMapLogicCallBack(new coe(this));
    setContentView(this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView.d();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView.e();
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    this.jdField_a_of_type_ComTencentBizMapTroopNearByBigMapView.c();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968596);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.troop.activity.TroopNearByBigMapActivity
 * JD-Core Version:    0.7.0.1
 */