package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cai;
import caj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private static final String jdField_a_of_type_JavaLangString = "activity_titile_name";
  private static final int jdField_b_of_type_Int = 0;
  private static final String jdField_b_of_type_JavaLangString = "group_code";
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 2;
  private static final int e = 3;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private caj jdField_a_of_type_Caj;
  private JoinGroupHandler jdField_a_of_type_ComTencentBizJoinGroupHandler;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  
  public JoinGroupTransitActivity()
  {
    this.d = "";
  }
  
  private void a()
  {
    try
    {
      this.c = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.c)) {
        finish();
      }
      this.jdField_a_of_type_Caj = new caj(this);
      JumpAction localJumpAction = JumpParser.a(this.app, this, this.c);
      this.d = localJumpAction.a("activity_titile_name");
      this.jdField_a_of_type_Long = Long.valueOf(localJumpAction.a("group_code")).longValue();
      this.jdField_a_of_type_Int = Integer.valueOf(localJumpAction.a("subsource_id")).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler = new JoinGroupHandler(this, this.app, this.jdField_a_of_type_Int, this.d, new cai(this));
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler.a();
    this.jdField_a_of_type_Caj.sendEmptyMessage(0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizJoinGroupHandler.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */