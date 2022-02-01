package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.ims.AccountSecurityInfo.AccSecInfoResponse;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.qphone.base.util.QLog;
import ezj;
import mqq.observer.BusinessObserver;

public class SecurityDetectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, BusinessObserver
{
  public static final int a = 1;
  public static final String a = "SecurityDetectActivity";
  public static final int b = 2;
  public static final String b = "SecurityDetectActivity";
  public static final int c = 3;
  public static final String c = "PimscureStatus";
  public static final int d = 4;
  public static final String d = "AccountStatus";
  public static final int e = 5;
  public static final String e = "LastDetectTime";
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int i = 9;
  public static final int j = 500;
  public static final int k = 1000;
  public static final int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 0;
  public static final int p = 1;
  private Handler jdField_a_of_type_AndroidOsHandler = new ezj(this, Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private boolean jdField_a_of_type_Boolean = false;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout = null;
  private boolean jdField_b_of_type_Boolean = true;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout = null;
  private boolean jdField_c_of_type_Boolean = false;
  private String f = null;
  private String g = null;
  private int q = 0;
  private int r = 0;
  private int s = -1;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904396);
    setTitle(2131368933);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302042));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302047));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setFocusable(false);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302052));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302057));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, 1, 0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, 1000L);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9, 500L);
    this.jdField_b_of_type_Boolean = true;
    ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "SecurityDetectActivity", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    Object localObject;
    if ((!this.jdField_b_of_type_Boolean) && ((this.s == 2131302052) || (this.s == 2131302042))) {
      if (this.s == 2131302052)
      {
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, 0, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1000L);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      this.s = -1;
      return;
      ((ProgressBar)findViewById(2131302044)).setVisibility(0);
      findViewById(2131302043).setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (this.s == 2131302042) {}
      for (int i1 = 0;; i1 = 1)
      {
        localObject = ((Handler)localObject).obtainMessage(1, i1, 0);
        break;
      }
      if (this.s == 2131302047)
      {
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 0, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 1000L);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    this.s = i1;
    switch (i1)
    {
    case 2131302042: 
    default: 
      return;
    case 2131302047: 
      startActivity(new Intent(this, SecurityLoginDetectActivity.class));
      ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on login_detect", 0, 0, "", "", "", "");
      return;
    case 2131302052: 
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.a());
      String str = this.g;
      if (str != null)
      {
        paramView = str;
        if (!str.equals("")) {}
      }
      else
      {
        paramView = "https://aq.qq.com/cn2/message_center/wireless/mobile_mc_risk_index?source_id=2948&uin=";
      }
      startActivity(localIntent.putExtra("url", paramView + this.app.a()));
      ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on account_security_detect", 0, 0, "", "", "", "");
      return;
    }
    JumpQqPimSecureUtil.a(this, "mobileqq", 8716289);
    ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on qqpimsecure_run_scan", 0, 0, "", "", "", "");
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((!paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("SecurityDetectActivity", 2, "onReceive: onReceive Observer package:MobileQQ fail");
    }
    AccountSecurityInfo.AccSecInfoResponse localAccSecInfoResponse;
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      localAccSecInfoResponse = new AccountSecurityInfo.AccSecInfoResponse();
    }
    try
    {
      localAccSecInfoResponse.mergeFrom(paramBundle);
      if (localAccSecInfoResponse.u32_valid.has()) {
        this.r = localAccSecInfoResponse.u32_valid.get();
      }
      if (localAccSecInfoResponse.str_wording.has()) {
        this.f = localAccSecInfoResponse.str_wording.get();
      }
      if (localAccSecInfoResponse.str_AccInfoUrl.has()) {
        this.g = localAccSecInfoResponse.str_AccInfoUrl.get();
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.d("SecurityDetectActivity", 2, "onReceive: InvalidProtocolBufferMicroException");
          continue;
          paramInt = 2130837746;
          continue;
          paramBundle.setText(2131368954);
          paramBundle.setTextColor(getResources().getColor(2131427973));
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(8, 1000L);
    }
    paramBundle = findViewById(2131302053);
    if (paramBundle != null)
    {
      paramBundle.setVisibility(0);
      if (this.r == 0) {
        break label395;
      }
      paramInt = 2130837623;
      paramBundle.setBackgroundResource(paramInt);
      if (this.jdField_c_of_type_Boolean)
      {
        paramBundle = findViewById(2131302060);
        if (paramBundle != null) {
          paramBundle.setVisibility(8);
        }
      }
    }
    paramBundle = (ProgressBar)findViewById(2131302054);
    if (paramBundle != null)
    {
      paramBundle.setVisibility(8);
      if (this.jdField_c_of_type_Boolean) {
        ((ProgressBar)findViewById(2131302061)).setVisibility(0);
      }
    }
    paramBundle = (TextView)findViewById(2131302055);
    if (paramBundle != null)
    {
      if (this.r != 0)
      {
        paramBundle.setText(2131368955);
        paramBundle.setTextColor(getResources().getColor(2131427999));
        if (this.f != null) {
          paramBundle.setText(this.f);
        }
        paramBundle.setVisibility(0);
      }
    }
    else
    {
      paramBundle = (ImageView)findViewById(2131302056);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setFocusable(true);
      if (!this.jdField_c_of_type_Boolean) {
        break label426;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
      return;
    }
    label395:
    label426:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityDetectActivity
 * JD-Core Version:    0.7.0.1
 */