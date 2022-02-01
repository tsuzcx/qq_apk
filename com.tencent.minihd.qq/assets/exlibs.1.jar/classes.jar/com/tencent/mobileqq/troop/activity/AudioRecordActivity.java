package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import kcq;
import kcr;

public class AudioRecordActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int a = 1291845632;
  public static final String a = "audio_info";
  public static final int b = 60000;
  protected static final String b = "audio_max_length";
  protected static final String c = "from";
  protected static final String d = "bid";
  protected static final String e = "fromflag";
  protected static final String f = "publish";
  protected Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private CommonListenPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel;
  private CommonRecordSoundPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel;
  private AudioInfo jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
  private RelativeLayout b = null;
  public int c = 0;
  public String g = null;
  public String h = null;
  public String i = null;
  
  public AudioRecordActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new kcr(this);
  }
  
  protected void a(Resources paramResources, View paramView)
  {
    paramView.setBackgroundDrawable(paramResources.getDrawable(2130841714));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903556);
    this.b = ((RelativeLayout)findViewById(2131296742));
    this.c = getIntent().getIntExtra("audio_max_length", 60000);
    this.g = getIntent().getStringExtra("from");
    if ((this.g != null) && (this.g.equals("publish")))
    {
      this.h = getIntent().getStringExtra("bid");
      this.i = getIntent().getStringExtra("fromflag");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298769));
    a(getResources(), this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramBundle = LayoutInflater.from(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel = ((CommonRecordSoundPanel)paramBundle.inflate(2130903502, null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(this.app, this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setTimeOutTime(this.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel = ((CommonListenPanel)paramBundle.inflate(2130903501, null));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.a(this.app, this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298770);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    paramBundle = AnimationUtils.loadAnimation(this, 2130968586);
    paramBundle.setAnimationListener(new kcq(this));
    this.b.startAnimation(paramBundle);
    return true;
  }
  
  public void finish()
  {
    super.finish();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842237);
    overridePendingTransition(0, 2130968584);
  }
  
  public boolean onBackEvent()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.a();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    setResult(0);
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.f();
  }
  
  public void onPause()
  {
    super.onPause();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.e();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AudioRecordActivity
 * JD-Core Version:    0.7.0.1
 */