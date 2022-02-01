package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import efe;
import eff;
import efh;
import java.util.ArrayList;
import java.util.List;

public class JoinDiscussionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = -161;
  private static final int d = -160;
  public long a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public DiscussionHandler a;
  private eff jdField_a_of_type_Eff;
  private efh jdField_a_of_type_Efh;
  public String a;
  public ArrayList a;
  public List a;
  int jdField_b_of_type_Int = 0;
  public long b;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  String jdField_b_of_type_JavaLangString;
  public int c;
  public String c;
  public String d;
  public String e = "";
  public String f = "";
  
  public JoinDiscussionActivity()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297893));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297894));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297895));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297896));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297897));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131297899));
  }
  
  private void c()
  {
    setTitle("加入讨论组");
    setRightButton(2131365736, this);
    this.leftView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new efe(this));
  }
  
  private void d()
  {
    if (NetworkUtil.e(this))
    {
      startTitleProgress();
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(this.jdField_a_of_type_JavaLangString);
      }
      while ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.length() <= 0)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.b(this.jdField_b_of_type_JavaLangString);
      return;
    }
    a(0, -160);
  }
  
  public void a()
  {
    if (NetworkUtil.e(this))
    {
      startTitleProgress();
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
      return;
    }
    a(1, -160);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    stopTitleProgress();
    String str = "";
    switch (paramInt2)
    {
    default: 
      if (paramInt1 == 1) {
        str = "加入讨论组失败，请稍后重试";
      }
      break;
    }
    for (;;)
    {
      QQToast.a(this, str, 0).b(getTitleBarHeight());
      return;
      str = "讨论组不存在";
      continue;
      str = "讨论组人数已达上限";
      continue;
      str = "非法讨论组链接";
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      str = "网络错误，请稍后重试";
      continue;
      if (paramInt1 == 0) {
        str = "获取讨论组信息失败，请稍后重试";
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903350);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_Efh = new efh(this, null);
    this.jdField_a_of_type_Eff = new eff(this, null);
    addObserver(this.jdField_a_of_type_Efh);
    addObserver(this.jdField_a_of_type_Eff);
    this.jdField_b_of_type_Int = paramBundle.getInt(ScannerActivity.o);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("sig");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("innerSig");
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      paramBundle = this.jdField_b_of_type_JavaLangString.toUpperCase();
      if ((this.jdField_b_of_type_JavaLangString != null) && (!paramBundle.startsWith("HTTP://")) && (!paramBundle.startsWith("HTTPS://"))) {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.endsWith("#flyticket"))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, this.jdField_a_of_type_JavaLangString.length() - "#flyticket".length());
    }
    b();
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = ((DiscussionHandler)this.app.a(6));
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Efh);
    removeObserver(this.jdField_a_of_type_Eff);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130968584);
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */