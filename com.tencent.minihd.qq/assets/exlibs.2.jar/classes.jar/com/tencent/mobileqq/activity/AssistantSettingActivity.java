package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.PreDownloadStrategyAlpha;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import cooperation.qqwifi.QQWiFiHelper;
import cooperation.qzone.LocalMultiProcConfig;
import dge;
import dgf;
import dgg;
import dgh;
import dgi;
import dgj;
import dgk;
import dgl;
import dgm;
import dgn;
import dgo;
import dgp;
import dgq;
import dgr;

public class AssistantSettingActivity
  extends IphoneTitleBarActivity
{
  public static int a = 0;
  static final int jdField_b_of_type_Int = 1;
  static final int jdField_c_of_type_Int = 1000;
  static final int jdField_d_of_type_Int = 0;
  static final int jdField_e_of_type_Int = 1;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new dgj(this);
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  private FormSwitchItem i;
  private FormSwitchItem j;
  private FormSwitchItem k;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public AssistantSettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new dgi(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296776));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131296775));
    this.c = ((FormSwitchItem)findViewById(2131296772));
    this.d = ((FormSwitchItem)findViewById(2131296773));
    this.e = ((FormSwitchItem)findViewById(2131296778));
    this.f = ((FormSwitchItem)findViewById(2131296779));
    this.i = ((FormSwitchItem)findViewById(2131296780));
    this.j = ((FormSwitchItem)findViewById(2131296782));
    this.g = ((FormSwitchItem)findViewById(2131296774));
    this.h = ((FormSwitchItem)findViewById(2131296777));
    this.k = ((FormSwitchItem)findViewById(2131296783));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131296770);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296771);
    if (PredownloadTest.a) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    if (PreDownloadStrategyAlpha.g == 0L)
    {
      this.c.setVisibility(0);
      if (!MagicfaceViewController.a()) {
        break label721;
      }
      this.d.setVisibility(0);
    }
    for (;;)
    {
      boolean bool = SettingCloneUtil.readValue(this, null, getString(2131366269), "qqsetting_screenshot_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new dge(this));
      bool = LocalMultiProcConfig.a(getString(2131366828), false);
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new dgk(this));
      }
      bool = SettingCloneUtil.readValue(this, null, getString(2131366260), "qqsetting_auto_receive_pic_key", true);
      this.c.setChecked(bool);
      this.c.setOnCheckedChangeListener(new dgl(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131366260), "qqsetting_auto_receive_magic_face_key", true);
      this.d.setChecked(bool);
      this.d.setOnCheckedChangeListener(new dgm(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131366308), "qqsetting_enter_sendmsg_key", false);
      this.e.setChecked(bool);
      this.e.setOnCheckedChangeListener(new dgn(this));
      bool = SettingCloneUtil.readValue(this, this.app.a(), null, "qqsetting_all_contacts_key", false);
      this.f.setChecked(bool);
      this.f.setOnCheckedChangeListener(new dgo(this));
      bool = SettingCloneUtil.readValue(this, null, null, "qqsetting_clear_memory_key", true);
      this.j.setChecked(bool);
      this.j.setOnCheckedChangeListener(new dgp(this));
      bool = QQWiFiHelper.b(this, this.app.a());
      this.i.setChecked(bool);
      this.i.setOnCheckedChangeListener(new dgq(this));
      bool = ConfigHandler.a(this.app, false);
      this.g.setChecked(bool);
      this.g.setOnCheckedChangeListener(new dgr(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131368414), "qqsetting_notify_icon_key", false);
      this.h.setChecked(bool);
      this.h.setOnCheckedChangeListener(new dgf(this));
      findViewById(2131296781).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new dgg(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new dgh(this));
      this.jdField_a_of_type_AndroidViewView.setContentDescription("流量统计");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("摇动手机截屏");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("空间动态浏览无图模式");
      this.c.setContentDescription("2G/3G/4G下自动接收图片");
      this.e.setContentDescription("回车键发送消息");
      this.g.setContentDescription("WiFi下自动在后台下载新版本");
      this.f.setContentDescription("联系人列表按字母排列");
      this.h.setContentDescription("系统通知栏显示QQ图标");
      this.j.setContentDescription("内存低时自动清理内存");
      this.k.setContentDescription("在底部菜单展示通话功能");
      return;
      this.c.setVisibility(8);
      break;
      label721:
      this.d.setVisibility(8);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903089);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      finish();
      return false;
    }
    setTitle(2131366267);
    this.jdField_a_of_type_JavaLangString = this.app.a();
    setVolumeControlStream(3);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      dismissDialog(1);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131366676));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  protected String setLastActivityName()
  {
    return getString(2131366267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity
 * JD-Core Version:    0.7.0.1
 */