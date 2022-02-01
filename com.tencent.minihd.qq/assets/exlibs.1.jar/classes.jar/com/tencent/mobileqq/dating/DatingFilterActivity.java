package com.tencent.mobileqq.dating;

import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import ibq;
import ibr;
import ibs;

public class DatingFilterActivity
  extends DatingExtraActivity
  implements View.OnClickListener
{
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 0;
  private static final int jdField_e_of_type_Int = 1;
  private static final int f = 2;
  public int a;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new ibs(this);
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new ibr(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new ibq(this);
  public IphonePickerView a;
  private DatingFilters jdField_a_of_type_ComTencentMobileqqDatingDatingFilters;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public ActionSheet a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private View jdField_c_of_type_AndroidViewView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    ((DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296635)).a = true;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130903932, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.h);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener);
      if (Build.VERSION.SDK_INT >= 11) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
        if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.e);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.f);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
        }
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("IphoneTitleBarActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  private String[] a()
  {
    String[] arrayOfString = new String[4];
    switch (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.d)
    {
    default: 
      switch (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.h)
      {
      }
      break;
    }
    for (;;)
    {
      arrayOfString[2] = (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.f + "," + this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.e);
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.i >= 0) {
        break label199;
      }
      arrayOfString[3] = "0";
      return arrayOfString;
      arrayOfString[0] = "2";
      break;
      arrayOfString[0] = "1";
      break;
      arrayOfString[0] = "0";
      break;
      arrayOfString[1] = "0";
      continue;
      arrayOfString[1] = "18";
      continue;
      arrayOfString[1] = "23";
      continue;
      arrayOfString[1] = "27";
      continue;
      arrayOfString[1] = "35";
    }
    label199:
    switch (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.i)
    {
    default: 
      arrayOfString[3] = "9999";
      return arrayOfString;
    case 0: 
      arrayOfString[3] = "0";
      return arrayOfString;
    case 1: 
      arrayOfString[3] = "1";
      return arrayOfString;
    case 2: 
      arrayOfString[3] = "2";
      return arrayOfString;
    case 3: 
      arrayOfString[3] = "3";
      return arrayOfString;
    case 4: 
      arrayOfString[3] = "4";
      return arrayOfString;
    case 5: 
      arrayOfString[3] = "5";
      return arrayOfString;
    case 6: 
      arrayOfString[3] = "6";
      return arrayOfString;
    case 7: 
      arrayOfString[3] = "7";
      return arrayOfString;
    case 8: 
      arrayOfString[3] = "8";
      return arrayOfString;
    case 9: 
      arrayOfString[3] = "9";
      return arrayOfString;
    case 10: 
      arrayOfString[3] = "10";
      return arrayOfString;
    case 11: 
      arrayOfString[3] = "777";
      return arrayOfString;
    case 12: 
      arrayOfString[3] = "888";
      return arrayOfString;
    case 13: 
      arrayOfString[3] = "999";
      return arrayOfString;
    }
    arrayOfString[3] = "9999";
    return arrayOfString;
  }
  
  private void b()
  {
    String str = "不限";
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) {
      str = DatingUtil.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo, this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.j);
    }
    FormSimpleItem localFormSimpleItem = this.e;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.g == 5) {}
    for (int i = 0;; i = 8)
    {
      localFormSimpleItem.setVisibility(i);
      this.e.setRightText(str);
      return;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.i < 1) {}
    for (String str = "不限";; str = com.tencent.mobileqq.util.NearbyProfileUtil.d[this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.i])
    {
      this.d.setRightText(str);
      return;
    }
  }
  
  private void d()
  {
    String str4 = "全部 按钮";
    String str5 = "女 按钮";
    String str1 = "男 按钮";
    String str3;
    String str2;
    if (this.jdField_a_of_type_AndroidViewView.isSelected())
    {
      str3 = "（已选定）" + "全部 按钮";
      str2 = str5;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(str3);
      this.jdField_c_of_type_AndroidViewView.setContentDescription(str2);
      this.jdField_b_of_type_AndroidViewView.setContentDescription(str1);
      return;
      if (this.jdField_c_of_type_AndroidViewView.isSelected())
      {
        str2 = "（已选定）" + "女 按钮";
        str3 = str4;
      }
      else
      {
        str2 = str5;
        str3 = str4;
        if (this.jdField_b_of_type_AndroidViewView.isSelected())
        {
          str1 = "（已选定）" + "男 按钮";
          str2 = str5;
          str3 = str4;
        }
      }
    }
  }
  
  void a()
  {
    FormSimpleItem localFormSimpleItem;
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.d == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      this.jdField_c_of_type_AndroidViewView.setSelected(false);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427938));
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427375));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427375));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838482, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838480, 0, 0, 0);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.g != 5) {
        break label437;
      }
    }
    label437:
    for (String str = getString(2131369932);; str = getString(2131369755))
    {
      localFormSimpleItem.setLeftText(str);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(DatingFilters.b[this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.e]);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(DatingFilters.c[this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.f]);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(DatingFilters.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.h]);
      b();
      c();
      d();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.d == 1)
      {
        this.jdField_a_of_type_AndroidViewView.setSelected(false);
        this.jdField_c_of_type_AndroidViewView.setSelected(false);
        this.jdField_b_of_type_AndroidViewView.setSelected(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838483, 0, 0, 0);
        this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838480, 0, 0, 0);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427375));
        this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427375));
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427938));
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.d != 2) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setSelected(false);
      this.jdField_c_of_type_AndroidViewView.setSelected(true);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838482, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838481, 0, 0, 0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427375));
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427938));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427375));
      break;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramInt1 = paramIntent.getIntExtra("param_id", 0);
      paramIntent.getStringExtra("param_name");
      paramIntent.getStringExtra("param_tag");
      paramIntent.getIntExtra("param_tag_bg", 0);
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.i = paramInt1;
      c();
    }
    while ((paramInt1 != 2) || (paramInt2 != -1)) {
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.j = paramIntent.getIntExtra("dating_destination_select_type", 1);
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.j == 1) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
    }
    for (;;)
    {
      b();
      return;
      paramIntent = paramIntent.getByteArrayExtra("dating_destination_result");
      try
      {
        appoint_define.LocaleInfo localLocaleInfo = new appoint_define.LocaleInfo();
        localLocaleInfo.mergeFrom(paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = localLocaleInfo;
      }
      catch (Exception paramIntent)
      {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.setTheme(2131559068);
    super.doOnCreate(paramBundle);
    super.setContentView(2130903897);
    super.setTitle(2131369820);
    super.setRightButton(2131367064, this);
    super.setLeftButton(2131365736, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300003);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300001);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131299999);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300002));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300000));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300006));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300004));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300007));
    this.d = ((FormSimpleItem)findViewById(2131300008));
    this.e = ((FormSimpleItem)findViewById(2131300005));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.d.setRightTextColor(2);
    this.e.setRightTextColor(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters = ((DatingFilters)getIntent().getParcelableExtra("filter"));
    if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters == null)
    {
      paramBundle = DatingFilters.a(this, this.app.a());
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters = paramBundle;
      }
    }
    a();
    return true;
  }
  
  protected boolean onBackEvent()
  {
    super.finish();
    overridePendingTransition(0, 2130968596);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131300007: 
    case 2131300006: 
    case 2131300004: 
    case 2131300005: 
    case 2131300008: 
    case 2131297358: 
    case 2131297360: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_Int = 0;
          a(this.jdField_a_of_type_Int);
          return;
          this.jdField_a_of_type_Int = 1;
          a(this.jdField_a_of_type_Int);
          return;
          this.jdField_a_of_type_Int = 2;
          a(this.jdField_a_of_type_Int);
          return;
          if (this.jdField_a_of_type_AndroidContentIntent == null)
          {
            this.jdField_a_of_type_AndroidContentIntent = new Intent(this, DatingDestinationActivity.class);
            this.jdField_a_of_type_AndroidContentIntent.putExtra("is_select_mode", true);
            this.jdField_a_of_type_AndroidContentIntent.putExtra("dating_destination_select_type", this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.j);
            if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) {
              this.jdField_a_of_type_AndroidContentIntent.putExtra("dating_destination_result", this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray());
            }
          }
          for (;;)
          {
            startActivityForResult(this.jdField_a_of_type_AndroidContentIntent, 2);
            return;
            this.jdField_a_of_type_AndroidContentIntent.setClass(this, DatingDestinationActivity.class);
          }
          paramView = new Intent(this, JobSelectionActivity.class);
          paramView.putExtra("param_id", this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.i);
          paramView.putExtra("param_need_no_limit", true);
          startActivityForResult(paramView, 1);
          return;
          onBackEvent();
          return;
          paramView = new Intent();
          paramView.putExtra("key_filter_value", this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters);
          setResult(-1, paramView);
          super.finish();
          overridePendingTransition(0, 2130968596);
          paramView = a();
          a("0X8004955", paramView[0], paramView[1], paramView[2], paramView[3]);
        } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.g != 5);
        b("0X8004F3B");
      } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == null);
      b("0X8004F3C");
      return;
    case 2131300003: 
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.d = 0;
      a();
      return;
    case 2131300001: 
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.d = 1;
      a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingFilters.d = 2;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingFilterActivity
 * JD-Core Version:    0.7.0.1
 */