package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import elg;
import elh;
import eli;
import elj;
import elk;

public class NearPeopleFilterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final long a = 20000L;
  static final String jdField_a_of_type_JavaLangString = "NearPeopleFilterActivity";
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 1000;
  private static final int j = 0;
  private static final int k = 1;
  int jdField_a_of_type_Int = 0;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new elk(this);
  Handler jdField_a_of_type_AndroidOsHandler = new elg(this);
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new elh(this);
  private ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = new elj(this);
  IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new eli(this);
  public IphonePickerView a;
  public FormSimpleItem a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public ActionSheet a;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "0", "0", "0", "0" };
  int jdField_b_of_type_Int = 4;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public FormSimpleItem b;
  String jdField_b_of_type_JavaLangString = "不限";
  public int c;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public int d;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  int jdField_e_of_type_Int = 0;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  public int i;
  
  public NearPeopleFilterActivity()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  private void a(int paramInt)
  {
    this.i = paramInt;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this);
    ((DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296635)).a = true;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)getLayoutInflater().inflate(2130903932, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
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
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.jdField_d_of_type_Int);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(1);
      }
      catch (Throwable localThrowable)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("NearPeopleFilterActivity", 2, localThrowable.getMessage());
      }
    }
  }
  
  public static void a(Activity paramActivity, NearPeopleFilterActivity.NearPeopleFilters paramNearPeopleFilters, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters = paramNearPeopleFilters;
    if (paramNearPeopleFilters == null)
    {
      localNearPeopleFilters = new NearPeopleFilterActivity.NearPeopleFilters();
      localNearPeopleFilters.k = 0;
      localNearPeopleFilters.l = 0;
      localNearPeopleFilters.j = 4;
      localNearPeopleFilters.i = 0;
    }
    paramNearPeopleFilters = new Intent(paramActivity, NearPeopleFilterActivity.class);
    paramNearPeopleFilters.putExtra("gender", localNearPeopleFilters.i);
    paramNearPeopleFilters.putExtra("time", localNearPeopleFilters.j);
    paramNearPeopleFilters.putExtra("age", localNearPeopleFilters.k);
    paramNearPeopleFilters.putExtra("xingzuo", localNearPeopleFilters.l);
    paramNearPeopleFilters.putExtra("key_career", localNearPeopleFilters.m);
    paramNearPeopleFilters.putExtra("key_hometown_country", localNearPeopleFilters.c[0]);
    paramNearPeopleFilters.putExtra("key_hometown_province", localNearPeopleFilters.c[1]);
    paramNearPeopleFilters.putExtra("key_hometown_city", localNearPeopleFilters.c[2]);
    paramNearPeopleFilters.putExtra("key_hometown_string", localNearPeopleFilters.jdField_a_of_type_JavaLangString);
    paramActivity.startActivityForResult(paramNearPeopleFilters, paramInt);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
      this.jdField_c_of_type_AndroidViewView.setSelected(false);
      this.jdField_b_of_type_AndroidViewView.setSelected(false);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427938));
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427375));
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131427375));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838482, 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130838480, 0, 0, 0);
      if (this.jdField_b_of_type_Int != 1) {
        break label602;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setSelected(true);
      this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
      this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
      this.f.setSelected(false);
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427938));
      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
      this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
      this.f.setBackgroundColor(getResources().getColor(2131427375));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(NearPeopleFilterActivity.NearPeopleFilters.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(NearPeopleFilterActivity.NearPeopleFilters.b[this.jdField_d_of_type_Int]);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(com.tencent.mobileqq.util.NearbyProfileUtil.d[this.jdField_e_of_type_Int]);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(Integer.valueOf(this.jdField_e_of_type_Int));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(this.jdField_b_of_type_JavaLangString);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(this.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("年龄" + NearPeopleFilterActivity.NearPeopleFilters.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int] + ", 触摸两次选择");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("星座" + NearPeopleFilterActivity.NearPeopleFilters.b[this.jdField_d_of_type_Int] + ", 触摸两次选择");
      return;
      if (this.jdField_a_of_type_Int == 1)
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
      if (this.jdField_a_of_type_Int != 2) {
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
      label602:
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(true);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
        this.f.setSelected(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427938));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
        this.f.setBackgroundColor(getResources().getColor(2131427375));
      }
      else if (this.jdField_b_of_type_Int == 3)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(true);
        this.f.setSelected(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427938));
        this.f.setBackgroundColor(getResources().getColor(2131427375));
      }
      else if ((this.jdField_b_of_type_Int == 4) || (this.jdField_b_of_type_Int == 0))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setSelected(false);
        this.jdField_e_of_type_AndroidWidgetTextView.setSelected(false);
        this.f.setSelected(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundColor(getResources().getColor(2131427375));
        this.f.setBackgroundColor(getResources().getColor(2131427938));
      }
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 1);
    int m = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a();
    if (m != 0)
    {
      m = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(m);
      if (QLog.isColorLevel()) {
        QLog.d("NearPeopleFilterActivity", 2, "startLocationSelectActivity | update result = " + m);
      }
      if (m == 2)
      {
        QQToast.a(this, 2131367328, 0).b(getTitleBarHeight());
        return;
      }
      if (m == 0)
      {
        a(getString(2131369485));
        this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      a(getString(2131369485));
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    String[] arrayOfString2 = (String[])this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag();
    String[] arrayOfString1;
    if (arrayOfString2 != null)
    {
      arrayOfString1 = arrayOfString2;
      if (arrayOfString2.length == 4) {}
    }
    else
    {
      arrayOfString1 = new String[4];
      arrayOfString1[0] = "0";
      arrayOfString1[1] = "0";
      arrayOfString1[2] = "0";
      arrayOfString1[3] = "0";
    }
    localIntent.putExtra("param_location", arrayOfString1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(arrayOfString1));
    startActivityForResult(localIntent, 1);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      localObject = paramIntent.getStringExtra("param_name");
      paramInt1 = paramIntent.getIntExtra("param_id", -1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      this.jdField_e_of_type_Int = paramInt1;
      return;
    } while (paramInt2 != -1);
    Object localObject = paramIntent.getStringArrayExtra("param_location");
    paramIntent = paramIntent.getStringExtra("param_location_param");
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramIntent);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(localObject);
    this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject);
    this.jdField_b_of_type_JavaLangString = paramIntent;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.setTheme(2131559068);
    super.doOnCreate(paramBundle);
    super.setContentView(2130903967);
    super.setTitle(2131369819);
    super.setRightButton(2131367064, this);
    super.setLeftButton(2131365736, this);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131300003);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131300001);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131299999);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300002));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300000));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300289));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300290));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300291));
    this.f = ((TextView)findViewById(2131300292));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131299748));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131297922));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131298049));
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131300272));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(57));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
    paramBundle = new NearPeopleFilterActivity.NearPeopleFilters();
    paramBundle.i = getIntent().getIntExtra("gender", 0);
    paramBundle.j = getIntent().getIntExtra("time", 0);
    paramBundle.k = getIntent().getIntExtra("age", 0);
    paramBundle.l = getIntent().getIntExtra("xingzuo", 0);
    paramBundle.m = getIntent().getIntExtra("key_career", 0);
    paramBundle.c[0] = getIntent().getStringExtra("key_hometown_country");
    paramBundle.c[1] = getIntent().getStringExtra("key_hometown_province");
    paramBundle.c[2] = getIntent().getStringExtra("key_hometown_city");
    paramBundle.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("key_hometown_string");
    this.jdField_a_of_type_Int = paramBundle.i;
    this.jdField_b_of_type_Int = paramBundle.j;
    this.jdField_c_of_type_Int = paramBundle.k;
    this.jdField_d_of_type_Int = paramBundle.l;
    this.jdField_e_of_type_Int = paramBundle.m;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramBundle.c;
    if (!TextUtils.isEmpty(paramBundle.jdField_a_of_type_JavaLangString)) {}
    for (this.jdField_b_of_type_JavaLangString = paramBundle.jdField_a_of_type_JavaLangString;; this.jdField_b_of_type_JavaLangString = "不限")
    {
      if (TextUtils.isEmpty(paramBundle.c[0])) {
        paramBundle.c[0] = "0";
      }
      if (TextUtils.isEmpty(paramBundle.c[1])) {
        paramBundle.c[0] = "0";
      }
      if (TextUtils.isEmpty(paramBundle.c[2])) {
        paramBundle.c[0] = "0";
      }
      a();
      return true;
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
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
      return;
    case 2131299748: 
      this.i = 0;
      a(this.i);
      return;
    case 2131297922: 
      this.i = 1;
      a(this.i);
      return;
    case 2131297358: 
      onBackEvent();
      return;
    case 2131297360: 
      paramView = new Intent();
      paramView.putExtra("gender", this.jdField_a_of_type_Int);
      paramView.putExtra("time", this.jdField_b_of_type_Int);
      paramView.putExtra("age", this.jdField_c_of_type_Int);
      paramView.putExtra("xingzuo", this.jdField_d_of_type_Int);
      paramView.putExtra("key_career", this.jdField_e_of_type_Int);
      paramView.putExtra("key_hometown_country", this.jdField_a_of_type_ArrayOfJavaLangString[0]);
      paramView.putExtra("key_hometown_province", this.jdField_a_of_type_ArrayOfJavaLangString[1]);
      paramView.putExtra("key_hometown_city", this.jdField_a_of_type_ArrayOfJavaLangString[2]);
      paramView.putExtra("key_hometown_string", this.jdField_b_of_type_JavaLangString);
      setResult(-1, paramView);
      super.finish();
      overridePendingTransition(0, 2130968596);
      return;
    case 2131300003: 
      this.jdField_a_of_type_Int = 0;
      a();
      return;
    case 2131300001: 
      this.jdField_a_of_type_Int = 1;
      a();
      return;
    case 2131299999: 
      this.jdField_a_of_type_Int = 2;
      a();
      return;
    case 2131300289: 
      this.jdField_b_of_type_Int = 1;
      a();
      return;
    case 2131300290: 
      this.jdField_b_of_type_Int = 2;
      a();
      return;
    case 2131300291: 
      this.jdField_b_of_type_Int = 3;
      a();
      return;
    case 2131300292: 
      this.jdField_b_of_type_Int = 4;
      a();
      return;
    case 2131298049: 
      paramView = new Intent(this, JobSelectionActivity.class);
      if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag() instanceof Integer))) {
        paramView.putExtra("param_id", (Integer)this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getTag());
      }
      paramView.putExtra("param_need_no_limit", true);
      startActivityForResult(paramView, 2);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearPeopleFilterActivity
 * JD-Core Version:    0.7.0.1
 */