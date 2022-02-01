package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import efa;

public class InterestSwitchEditActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "param_interest_switch";
  public static final String b = "param_music_switch";
  public static final String c = "param_recent_activity_switch";
  public static final String d = "param_star_switch";
  public static final String e = "param_joined_group_switch";
  public static final String f = "param_ktv_switch";
  public static final String g = "param_eat_switch";
  public static final String h = "param_interest_switch_changed";
  public static final String i = "param_music_switch_changed";
  public static final String j = "param_recent_activity_switch_changed";
  public static final String k = "param_star_switch_changed";
  public static final String l = "param_joined_group_switch_changed";
  public static final String m = "param_ktv_switch_changed";
  public static final String n = "param_eat_switch_changed";
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new efa(this);
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private FormSwitchItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSwitchItem e;
  private FormSwitchItem f;
  private FormSwitchItem g;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
    }
    label36:
    label54:
    label72:
    label90:
    label126:
    do
    {
      break label126;
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music == 0)
      {
        this.b.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity != 0) {
          break label171;
        }
        this.c.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star != 0) {
          break label193;
        }
        this.d.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop != 0) {
          break label215;
        }
        this.e.setChecked(true);
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv != 0) {
          break label237;
        }
        this.f.setChecked(true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat != 0) {
          break label259;
        }
        this.g.setChecked(true);
        return;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        break;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) {
          break label36;
        }
        this.b.setChecked(false);
        break label36;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity) {
          break label54;
        }
        this.c.setChecked(false);
        break label54;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star) {
          break label72;
        }
        this.d.setChecked(false);
        break label72;
        if (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop) {
          break label90;
        }
        this.e.setChecked(false);
        break label90;
        if (1 == this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv) {
          this.f.setChecked(false);
        }
      }
    } while (1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat);
    label171:
    label193:
    label215:
    label237:
    this.g.setChecked(false);
    label259:
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903989);
    this.app.a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    setTitle("兴趣爱好展示设置");
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131300369));
    this.b = ((FormSwitchItem)findViewById(2131300370));
    this.c = ((FormSwitchItem)findViewById(2131300371));
    this.d = ((FormSwitchItem)findViewById(2131300372));
    this.e = ((FormSwitchItem)findViewById(2131300373));
    this.f = ((FormSwitchItem)findViewById(2131300374));
    this.g = ((FormSwitchItem)findViewById(2131300375));
    int i2 = getIntent().getIntExtra("param_eat_switch", -1);
    int i3 = getIntent().getIntExtra("param_interest_switch", -1);
    int i4 = getIntent().getIntExtra("param_joined_group_switch", -1);
    int i5 = getIntent().getIntExtra("param_ktv_switch", -1);
    int i6 = getIntent().getIntExtra("param_music_switch", -1);
    int i7 = getIntent().getIntExtra("param_recent_activity_switch", -1);
    int i8 = getIntent().getIntExtra("param_star_switch", -1);
    if ((-1 != i2) || (-1 != i3) || (-1 != i4) || (-1 != i5) || (-1 != i6) || (-1 != i7) || (-1 != i8)) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataCard = new Card();
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat = ((short)i2);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest = ((short)i3);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop = ((short)i4);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv = ((short)i5);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music = ((short)i6);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity = ((short)i7);
        this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star = ((short)i8);
        a();
        return true;
      }
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        QQToast.a(BaseApplicationImpl.a, 2131365941, 0).b(getTitleBarHeight());
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.g();
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.c(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void finish()
  {
    int i2 = 0;
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label385;
      }
      i1 = 0;
      localIntent.putExtra("param_interest_switch", i1);
      if (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
        break label390;
      }
      i1 = 0;
      label49:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_interest) {
        localIntent.putExtra("param_interest_switch_changed", true);
      }
      if (!this.b.a()) {
        break label395;
      }
      i1 = 0;
      label80:
      localIntent.putExtra("param_music_switch", i1);
      if (!this.b.a()) {
        break label400;
      }
      i1 = 0;
      label100:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_music) {
        localIntent.putExtra("param_music_switch_changed", true);
      }
      if (!this.c.a()) {
        break label405;
      }
      i1 = 0;
      label131:
      localIntent.putExtra("param_recent_activity_switch", i1);
      if (!this.c.a()) {
        break label410;
      }
      i1 = 0;
      label151:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_recent_activity) {
        localIntent.putExtra("param_recent_activity_switch_changed", true);
      }
      if (!this.d.a()) {
        break label415;
      }
      i1 = 0;
      label182:
      localIntent.putExtra("param_star_switch", i1);
      if (!this.d.a()) {
        break label420;
      }
      i1 = 0;
      label202:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_star) {
        localIntent.putExtra("param_star_switch_changed", true);
      }
      if (!this.e.a()) {
        break label425;
      }
      i1 = 0;
      label233:
      localIntent.putExtra("param_joined_group_switch", i1);
      if (!this.e.a()) {
        break label430;
      }
      i1 = 0;
      label253:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_joined_troop) {
        localIntent.putExtra("param_joined_group_switch_changed", true);
      }
      if (!this.f.a()) {
        break label435;
      }
      i1 = 0;
      label284:
      localIntent.putExtra("param_ktv_switch", i1);
      if (!this.f.a()) {
        break label440;
      }
      i1 = 0;
      label304:
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_ktv) {
        localIntent.putExtra("param_ktv_switch_changed", true);
      }
      if (!this.g.a()) {
        break label445;
      }
      i1 = 0;
      label335:
      localIntent.putExtra("param_eat_switch", i1);
      if (!this.g.a()) {
        break label450;
      }
    }
    label385:
    label390:
    label395:
    label400:
    label405:
    label410:
    label415:
    label420:
    label425:
    label430:
    label435:
    label440:
    label445:
    label450:
    for (int i1 = i2;; i1 = 1)
    {
      if (i1 != this.jdField_a_of_type_ComTencentMobileqqDataCard.switch_eat) {
        localIntent.putExtra("param_eat_switch_changed", true);
      }
      setResult(-1, localIntent);
      super.finish();
      return;
      i1 = 1;
      break;
      i1 = 1;
      break label49;
      i1 = 1;
      break label80;
      i1 = 1;
      break label100;
      i1 = 1;
      break label131;
      i1 = 1;
      break label151;
      i1 = 1;
      break label182;
      i1 = 1;
      break label202;
      i1 = 1;
      break label233;
      i1 = 1;
      break label253;
      i1 = 1;
      break label284;
      i1 = 1;
      break label304;
      i1 = 1;
      break label335;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InterestSwitchEditActivity
 * JD-Core Version:    0.7.0.1
 */