package com.tencent.mobileqq.activity;

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
import evd;
import eve;

public class QQSpaceCleanActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpDownloadUtil.DownloadInfoListener
{
  public static final String a = "QQSpaceCleanActivity";
  public static final String b = "https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean";
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public Long a;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  public String c;
  private boolean c;
  
  public QQSpaceCleanActivity()
  {
    this.jdField_c_of_type_JavaLangString = "腾讯手机管家";
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo.b == 0)
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramDownloadInfo.e);
      if ((NetworkUtil.e(this)) && (this.jdField_a_of_type_JavaLangLong.longValue() > 0L))
      {
        paramDownloadInfo = new Bundle();
        paramDownloadInfo.putString("_filename_from_dlg", this.jdField_c_of_type_JavaLangString);
        paramDownloadInfo.putLong("_filesize_from_dlg", this.jdField_a_of_type_JavaLangLong.longValue());
        UniformDownloadMgr.a().b("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", paramDownloadInfo);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    }
    runOnUiThread(new eve(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904401);
    setTitle(2131367914);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131302084));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131302085);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302083));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302082));
    ((TextView)findViewById(2131297357)).setText(2131369117);
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_c_of_type_Boolean)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_Boolean = JumpQqPimSecureUtil.a(this);
    this.jdField_b_of_type_Boolean = JumpQqPimSecureUtil.b(this);
    String str;
    if (!this.jdField_a_of_type_Boolean)
    {
      str = "Enter SpaceCleanpage not install secure";
      if (UniformDownloadMgr.a().a("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean"))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368964);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", str, 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131367917);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367916);
      continue;
      str = "Enter SpaceCleanpage install secure";
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131367918);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131367919);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_c_of_type_Boolean == true) {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.a(new evd(this));
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131368964);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ReportController.b(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", "click on bluebtn download", 0, 0, "", "", "", "");
      return;
    }
    JumpQqPimSecureUtil.a(this, "mobileqq", 9502721);
    ReportController.b(null, "P_CliOper", "Safe_SpaceClean", "", "SpaceClean_", "click on bluebtn run_clean", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSpaceCleanActivity
 * JD-Core Version:    0.7.0.1
 */