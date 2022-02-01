package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.Switch;
import fba;
import fbb;
import fbc;
import fbd;
import fbe;
import fbg;
import fbh;
import fbi;
import fbj;
import fbk;
import fbl;
import fbm;
import fbn;
import fbo;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class SoundAndVibrateActivity
  extends IphoneTitleBarActivity
{
  public static int a;
  public static String a;
  public static int b;
  float jdField_a_of_type_Float;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new LinkedHashMap();
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private final int jdField_c_of_type_Int = 1;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_d_of_type_Int = 0;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_e_of_type_Int = 1;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int jdField_f_of_type_Int = 2;
  private FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private final int g = 3;
  private final int h = 4;
  
  static
  {
    jdField_a_of_type_Int = AppSetting.jdField_e_of_type_Int;
    jdField_b_of_type_Int = AppSetting.jdField_f_of_type_Int;
    jdField_a_of_type_JavaLangString = "user_choose_";
  }
  
  private Uri a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165184);
    case 1: 
      return Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165186);
    case 2: 
      return Settings.System.DEFAULT_NOTIFICATION_URI;
    }
    Object localObject = ThemeUtil.getThemeVoiceRootPath();
    if (localObject != null)
    {
      localObject = new File((String)localObject + File.separatorChar + "message.mp3");
      if (((File)localObject).exists()) {
        return Uri.fromFile((File)localObject);
      }
    }
    return Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165186);
  }
  
  private void a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      fbo localfbo = (fbo)localIterator.next();
      if (localfbo.jdField_a_of_type_Int == paramInt)
      {
        localfbo.jdField_a_of_type_Boolean = true;
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(localfbo.jdField_a_of_type_JavaLangString);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      else
      {
        localfbo.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Uri localUri = a(paramInt1);
    a(paramInt1);
    SettingCloneUtil.writeValueForInt(this, this.app.a(), "sound_type", "qqsetting_notify_soundtype_key", paramInt2);
    if (a().booleanValue())
    {
      b();
      a(localUri);
    }
  }
  
  private void a(TextView paramTextView)
  {
    String str1 = getResources().getString(2131367761);
    int i = paramTextView.getCurrentTextColor();
    String str2 = paramTextView.getText() + str1;
    SpannableString localSpannableString = new SpannableString(str2);
    localSpannableString.setSpan(new fbd(this), str2.length() - str1.length(), str2.length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setClickable(false);
    paramTextView.setTextColor(i);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RoamSettingController.a(this.app, 1);
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131367765));
      VipUtils.a(this.app, "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
      return;
    }
    RoamSettingController.a(this.app, 2);
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131367766));
    VipUtils.a(this.app, "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
  }
  
  private void b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      a(paramInt, 2131165184);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
      return;
    case 1: 
      a(paramInt, 2131165186);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    case 2: 
      a(paramInt, jdField_a_of_type_Int);
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
      return;
    }
    a(paramInt, jdField_b_of_type_Int);
    ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
  }
  
  private void c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (RoamSettingController.a(this.app) == 0)
    {
      localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.app.d() != 0) {}
      for (;;)
      {
        localFormSwitchItem.setChecked(bool1);
        if (!this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break;
        }
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131367765));
        return;
        bool1 = false;
      }
    }
    FormSwitchItem localFormSwitchItem = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (RoamSettingController.a(this.app) == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      localFormSwitchItem.setChecked(bool1);
      break;
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a().setContentDescription(getString(2131367766));
  }
  
  private void d()
  {
    startActivity(new Intent(getActivity(), SpecailCareListActivity.class));
  }
  
  private void e()
  {
    if ((this.app.d() != 0) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      f();
      ActionSheet localActionSheet = ActionSheet.c(this);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        fbo localfbo = (fbo)localIterator.next();
        if (2131296422 == localfbo.jdField_a_of_type_Int) {
          localActionSheet.d(localfbo.jdField_a_of_type_JavaLangString);
        } else {
          localActionSheet.a(localfbo.jdField_a_of_type_JavaLangString, localfbo.jdField_a_of_type_Boolean);
        }
      }
      localActionSheet.a(new fbe(this, localActionSheet));
      localActionSheet.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    }
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private void g()
  {
    fbo localfbo1 = new fbo(this, 0, getResources().getString(2131367753), false);
    fbo localfbo2 = new fbo(this, 1, getResources().getString(2131367754), false);
    fbo localfbo3 = new fbo(this, 2, getResources().getString(2131367755), false);
    fbo localfbo4 = new fbo(this, 3, getResources().getString(2131367756), false);
    fbo localfbo5 = new fbo(this, 2131296422, getResources().getString(2131366375), false);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), localfbo1);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), localfbo2);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), localfbo3);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), localfbo4);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), localfbo5);
  }
  
  public Boolean a()
  {
    if ((!this.app.k()) && (!this.app.l()) && (this.app.m()) && ((this.app.a() == null) || (!this.app.a().e()))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.a());
    int j = this.app.d();
    int k = this.app.e();
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302162));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302168));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302163));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302169));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302166));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302165));
    Object localObject = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      i = 0;
      ((FormSimpleItem)localObject).setVisibility(i);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367748));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367751));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367749));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131367750));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302172));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302173));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302174));
      g();
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131302175));
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302164));
      if (k == 0) {
        break label916;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      a((View)this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getParent(), false);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
      if (this.app.c() != 0) {
        break label905;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      label341:
      if (j == 0) {
        break label1205;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
      i = SettingCloneUtil.readValueForInt(this, this.app.a(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
      if ((!localSharedPreferences.getBoolean(jdField_a_of_type_JavaLangString + this.app.a(), false)) && (i == jdField_b_of_type_Int))
      {
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putBoolean(jdField_a_of_type_JavaLangString + this.app.a(), true);
        ((SharedPreferences.Editor)localObject).commit();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (i != 2131165184) {
        break label959;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367753) + getString(2131369333));
      label581:
      if (this.app.b() != 0) {
        break label1171;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
      label599:
      localObject = ThemeUtil.getUserCurrentThemeId(this.app);
      if (((String)localObject).equals("1000")) {
        break label1251;
      }
      localObject = ThemeUtil.getThemeInfo(this, (String)localObject);
      if ((localObject == null) || (!((ThemeUtil.ThemeInfo)localObject).isVoiceTheme)) {
        break label1251;
      }
    }
    label905:
    label916:
    label959:
    label1251:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        if (localSharedPreferences.getBoolean("theme_voice_setting_" + this.app.a(), true)) {
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new fba(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new fbg(this));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new fbh(this));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new fbi(this));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new fbj(this));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new fbk(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new fbl(this));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new fbm(this));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new fbn(this, localSharedPreferences));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131302166));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302167));
        a(this.jdField_a_of_type_AndroidWidgetTextView);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new fbb(this));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new fbc(this));
        c();
        return;
        i = 8;
        break;
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label341;
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        a((View)this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.getParent(), true);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
        break label341;
        if (i == 2131165186)
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
          a(1);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367754) + getString(2131369333));
          break label581;
        }
        if (i == jdField_a_of_type_Int)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
          a(2);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367755) + getString(2131369333));
          break label581;
        }
        if (i == jdField_b_of_type_Int)
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
          a(3);
          SettingCloneUtil.writeValueForInt(this, this.app.a(), "sound_type", "qqsetting_notify_soundtype_key", jdField_b_of_type_Int);
          break label581;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
        a(1);
        break label581;
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
        break label599;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        continue;
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        continue;
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
    }
  }
  
  public void a(Uri paramUri)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      if (paramUri.getScheme().equals("file"))
      {
        paramUri = new FileInputStream(new File(paramUri.getPath()));
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramUri.getFD());
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        paramUri.close();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        return;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this, paramUri);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      }
      return;
    }
    catch (Exception paramUri) {}
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    Utils.a(this, paramView, paramBoolean);
  }
  
  public void a(SoundAndVibrateActivity.SoundStyle paramSoundStyle)
  {
    switch (fbf.a[paramSoundStyle.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367753) + getString(2131369333));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367754) + getString(2131369334));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367755) + getString(2131369334));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367756) + getString(2131369334));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367753) + getString(2131369334));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367754) + getString(2131369333));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367755) + getString(2131369334));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367756) + getString(2131369334));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367753) + getString(2131369334));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367754) + getString(2131369334));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367755) + getString(2131369333));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367756) + getString(2131369334));
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130842097));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367753) + getString(2131369334));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367754) + getString(2131369334));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367755) + getString(2131369334));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131367756) + getString(2131369333));
    ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904436);
    setTitle(2131367746);
    a();
    return false;
  }
  
  protected void doOnDestroy()
  {
    b();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity
 * JD-Core Version:    0.7.0.1
 */