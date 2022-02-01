package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HttpDownloadUtil.DownloadInfoListener;
import com.tencent.mobileqq.utils.JumpQqPimSecureUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import ezk;
import ezl;
import org.json.JSONException;
import org.json.JSONObject;

public class SecurityPickproofActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.DownloadInfoListener
{
  public static final String a = "https://qqwx.qq.com/s?aid=index&g_f=436";
  public static final String b = "https://qqwx.qq.com/s?aid=index&g_f=442";
  public static final String c = "https://qqwx.qq.com/s?aid=index&g_f=460";
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public Long a;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  public String d;
  private boolean d;
  public String e = "腾讯手机管家";
  private String f = "";
  
  public SecurityPickproofActivity()
  {
    this.jdField_d_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=436";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    this.jdField_d_of_type_Boolean = false;
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("isSecurityPayOpen", JumpQqPimSecureUtil.f(this));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private void a()
  {
    if (getIntent().hasExtra("fromSecurityPay")) {
      this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("fromSecurityPay", false);
    }
    String str;
    if (getIntent().hasExtra("options"))
    {
      str = getIntent().getStringExtra("options");
      if (str == null) {}
    }
    try
    {
      this.jdField_d_of_type_Boolean = new JSONObject(str).getBoolean("fromSecurityPay");
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_d_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=442";
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jump_securityPay", 0, 0, "", "", "", "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("SecurityPickproofActivity", 2, "fromSecurityPay = " + this.jdField_d_of_type_Boolean);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_d_of_type_Boolean) {
      setTitle(2131369595);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302084));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131302085);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302083));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302082));
      return;
      setTitle(2131369587);
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131369599);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369596);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369592);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131369599);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369596);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369592);
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramDownloadInfo.e);
      if ((NetworkUtil.e(this)) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", this.e);
        paramDownloadInfo.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        UniformDownloadMgr.a().b(this.jdField_d_of_type_JavaLangString, paramDownloadInfo);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    }
    runOnUiThread(new ezl(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904399);
    a();
    b();
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.c)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = JumpQqPimSecureUtil.a(this);
    if ((this.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_d_of_type_JavaLangString = "https://qqwx.qq.com/s?aid=index&g_f=460";
    }
    this.jdField_b_of_type_Boolean = JumpQqPimSecureUtil.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      if (UniformDownloadMgr.a().a(this.jdField_d_of_type_JavaLangString))
      {
        this.c = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368964);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369596);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131367917);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369590);
        return;
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131369593);
      }
    }
    if ((JumpQqPimSecureUtil.c(this)) || ((this.jdField_d_of_type_Boolean) && (!JumpQqPimSecureUtil.e(this))))
    {
      if (UniformDownloadMgr.a().a(this.jdField_d_of_type_JavaLangString))
      {
        this.c = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368964);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_d_of_type_Boolean)
      {
        if (JumpQqPimSecureUtil.d(this))
        {
          c();
          return;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131369596);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131369600);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369601);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131369593);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369591);
      return;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131369594);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131369592);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.c == true) {
      finish();
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result", a().toString());
      setResult(-1, localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      this.f = this.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
      if ((this.jdField_a_of_type_Boolean) && (!JumpQqPimSecureUtil.c(this)) && ((!this.jdField_d_of_type_Boolean) || (JumpQqPimSecureUtil.e(this)))) {
        break label317;
      }
      if ((this.jdField_d_of_type_Boolean) && (JumpQqPimSecureUtil.d(this)))
      {
        JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
        return;
      }
      ThreadManager.a(new ezk(this));
      this.c = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368964);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      if ("https://qqwx.qq.com/s?aid=index&g_f=442".equals(this.jdField_d_of_type_JavaLangString))
      {
        ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_update", 0, 0, "", "", "", "");
        return;
      }
    } while (!"https://qqwx.qq.com/s?aid=index&g_f=460".equals(this.jdField_d_of_type_JavaLangString));
    ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "Safe_SecurityPay_click_download_not_install", 0, 0, "", "", "", "");
    return;
    if (JumpQqPimSecureUtil.c(this))
    {
      ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_update_mini", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_download_not_install", 0, 0, "", "", "", "");
    return;
    label317:
    if (this.jdField_d_of_type_Boolean)
    {
      JumpQqPimSecureUtil.a(this, "mobileqq", 11862017);
      ReportController.b(null, "P_CliOper", "Safe_SecurityPay", "", "Safe_SecurityPay_", "click_jumpPimsecure", 0, 0, "", "", "", "");
      return;
    }
    JumpQqPimSecureUtil.a(this, "mobileqq", 9109505);
    ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof_", "click_jumpPimsecure", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SecurityPickproofActivity
 * JD-Core Version:    0.7.0.1
 */