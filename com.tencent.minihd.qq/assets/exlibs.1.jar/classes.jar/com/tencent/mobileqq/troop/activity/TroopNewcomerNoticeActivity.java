package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import kif;

public class TroopNewcomerNoticeActivity
  extends QQBrowserActivity
  implements View.OnClickListener
{
  public static final String a = "troop_friend_uin";
  public static final String b = "https://web.qun.qq.com/mannounce/portal.html#gc=%s";
  protected boolean a;
  public String c = "";
  protected View e = null;
  
  public TroopNewcomerNoticeActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131296993);
    if (this.e == null) {
      this.e = LayoutInflater.from(this).inflate(2130903707, null);
    }
    this.e.findViewById(2131299370).setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localRelativeLayout.addView(this.e, localLayoutParams);
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams()).addRule(2, 2131299369);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.o = false;
    this.c = getIntent().getStringExtra("troop_friend_uin");
    if (!TextUtils.isEmpty(this.c))
    {
      super.getIntent().putExtra("url", String.format("https://web.qun.qq.com/mannounce/portal.html#gc=%s", new Object[] { this.c }));
      super.doOnCreate(paramBundle);
      a();
      a(false);
    }
    try
    {
      ((View)findViewById(2131297347).getParent()).setVisibility(8);
      return true;
      super.finish();
      return false;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.d("TroopNewcomerNoticeActivity", 1, "titleBar visiable gone.");
      }
    }
  }
  
  protected boolean onBackEvent()
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.b(new kif(this));
    finish();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ReportController.a(null, "P_CliOper", "Grp_bulletin", "", "AIOchat", "Clk_iknow", 0, 0, this.c, "", "", "");
    onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopNewcomerNoticeActivity
 * JD-Core Version:    0.7.0.1
 */