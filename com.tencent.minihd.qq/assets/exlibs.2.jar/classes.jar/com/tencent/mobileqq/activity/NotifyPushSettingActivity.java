package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import cooperation.qzone.LocalMultiProcConfig;
import eny;
import enz;
import eoa;
import eob;
import eoc;
import eod;
import eoe;
import eof;
import eog;
import eoh;
import eoi;
import eoj;
import eok;
import eol;
import eom;
import eon;

public class NotifyPushSettingActivity
  extends IphoneTitleBarActivity
{
  private static final int jdField_a_of_type_Int = 10000;
  private static final int jdField_b_of_type_Int = 10001;
  public static final String b = "click_notifylight_count";
  public static final String c = "LED_light";
  public BroadcastReceiver a;
  private Handler jdField_a_of_type_AndroidOsHandler = new eoe(this);
  private View jdField_a_of_type_AndroidViewView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new eod(this);
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean = true;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  private FormSwitchItem h;
  
  public NotifyPushSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new eof(this);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "click_notifylight_count");
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298072);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298063));
    this.h = ((FormSwitchItem)findViewById(2131298069));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131298062);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131298065));
    this.c = ((FormSwitchItem)findViewById(2131298066));
    this.d = ((FormSwitchItem)findViewById(2131298067));
    this.e = ((FormSwitchItem)findViewById(2131298068));
    this.f = ((FormSwitchItem)findViewById(2131297719));
    this.g = ((FormSwitchItem)findViewById(2131298070));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298064));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new eny(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298071));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new eog(this));
    boolean bool7;
    if (this.app != null)
    {
      if (this.app.a().getSharedPreferences("com.tencent.mobileqq_preferences", 0).getBoolean("spcial_care_qq_setting", true)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130841955));
      }
      boolean bool1 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131366821), "qqsetting_notify_showcontent_key", true);
      boolean bool2 = SettingCloneUtil.readValue(this, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false);
      boolean bool3 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131366822), "qqsetting_notify_blncontrol_key", true);
      boolean bool4 = SettingCloneUtil.readValue(this, null, null, "qqsetting_show_badgeunread_key", true);
      boolean bool5 = LocalMultiProcConfig.a(getString(2131366826) + this.jdField_a_of_type_JavaLangString, true);
      boolean bool6 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131367905), "qqsetting_receivemsg_whenexit_key", true);
      bool7 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, getString(2131367906), "qqsetting_lock_screen_whenexit_key", true);
      boolean bool8 = SettingCloneUtil.readValue(this, this.jdField_a_of_type_JavaLangString, null, "qqsetting_pcactive_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new eoh(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      this.h.setChecked(bool2);
      this.h.setOnCheckedChangeListener(new eoi(this));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool3);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new eoj(this));
      this.c.setChecked(bool4);
      this.c.setOnCheckedChangeListener(new eok(this));
      if (!BadgeUtils.a()) {
        break label812;
      }
      this.c.setVisibility(0);
      label485:
      this.d.setChecked(bool5);
      this.d.setOnCheckedChangeListener(new eol(this));
      this.e.setChecked(bool6);
      this.e.setOnCheckedChangeListener(new eom(this));
      this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      CardHandler localCardHandler = (CardHandler)this.app.a(2);
      this.g.setChecked(bool8);
      this.g.setOnCheckedChangeListener(new eon(this, localCardHandler));
      if (localCardHandler != null) {
        localCardHandler.j();
      }
      if (!SettingCloneUtil.readValue(this.app.getApplication(), this.app.getAccount(), null, "pcactive_config", false)) {
        break label824;
      }
      this.g.setVisibility(0);
    }
    for (;;)
    {
      this.f.setChecked(bool7);
      this.f.setOnCheckedChangeListener(new enz(this));
      this.f.setContentDescription("锁屏显示消息弹框");
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new eoa(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new eob(this));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("声音");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知内显示消息内容");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("通知时指示灯闪烁");
      this.d.setContentDescription("与我相关的动态");
      this.e.setContentDescription("退出后仍接收消息通知");
      this.h.setContentDescription("夜间防骚扰模式");
      this.g.setContentDescription("PC离线时自动启动QQ手机版");
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131369132));
      this.jdField_a_of_type_AndroidViewView.setContentDescription("群消息设置");
      ((ConfigHandler)this.app.a(4)).c();
      return;
      QLog.d("IphoneTitleBarActivity", 1, "App is null, can't display 'new' flag for SpecialCare");
      break;
      label812:
      this.c.setVisibility(8);
      break label485;
      label824:
      this.g.setVisibility(8);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt(paramString + "click_notifylight_count", 0);
    paramContext.putInt(paramString + "LED_light", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    paramContext.putInt(paramString + "click_notifylight_count", 0);
    paramContext.putInt(paramString + "LED_light", 0);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    int i = paramContext.getInt(paramString1, 0);
    paramContext.edit().putInt(paramString1, i + 1).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + paramString2;
    paramContext.getSharedPreferences("mobileQQ", 0).edit().putInt(paramString1, paramInt).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new eoc(paramQQAppInterface, paramString));
  }
  
  private void a(String paramString)
  {
    try
    {
      boolean bool = SettingCloneUtil.readValue(this, paramString, null, "qqsetting_pcactive_key", false);
      this.jdField_a_of_type_Boolean = true;
      this.g.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return b(paramContext, paramString, "click_notifylight_count");
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = paramString1 + paramString2;
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(paramString1, 0);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    a(paramContext, paramString, "click_notifylight_count");
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, "LED_light", paramInt);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903388);
    setTitle(2131366689);
    if (this.app != null) {
      this.jdField_a_of_type_JavaLangString = this.app.a();
    }
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
    paramBundle.addAction("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.app != null) {
      this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
    if (BadgeUtils.a()) {
      BadgeUtils.c();
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    Intent localIntent = new Intent("tencent.notify.activity.setting");
    this.app.a().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify2");
  }
  
  protected String setLastActivityName()
  {
    return getString(2131366689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPushSettingActivity
 * JD-Core Version:    0.7.0.1
 */