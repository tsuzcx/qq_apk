package com.tencent.mobileqq.dating;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import appoint.define.appoint_define.LocaleInfo;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import hzw;
import hzx;
import hzy;
import hzz;
import iaa;
import iab;
import iac;
import iad;
import iae;
import iaf;
import iag;
import iai;
import iaj;
import iak;
import ial;
import iam;
import ian;
import iap;
import iar;
import java.util.HashSet;
import java.util.Set;

public class DatingDestinationActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final String a = "is_select_mode";
  public static final int b = 1;
  public static final String b = "dating_destination_select_type";
  public static final int c = 2;
  public static final String c = "dating_destination_result";
  public static final int d = 3;
  private static final String jdField_d_of_type_JavaLangString = "DatingDestinationActivity";
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new iaa(this);
  private View jdField_a_of_type_AndroidViewView = null;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private appoint_define.LocaleInfo jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = null;
  private CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new iac(this);
  private ConditionSearchManager.IConfigListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener = new iad(this);
  private ConditionSearchManager jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager;
  private DatingObserver jdField_a_of_type_ComTencentMobileqqDatingDatingObserver = new iab(this);
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
  private XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  private ian jdField_a_of_type_Ian = null;
  private iap jdField_a_of_type_Iap;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  public boolean a;
  private View jdField_b_of_type_AndroidViewView = null;
  private appoint_define.LocaleInfo jdField_b_of_type_AppointDefineAppoint_define$LocaleInfo = null;
  private ByteStringMicro jdField_b_of_type_ComTencentMobileqqPbByteStringMicro = null;
  private XListView jdField_b_of_type_ComTencentWidgetXListView;
  private boolean jdField_b_of_type_Boolean = false;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView = null;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean = false;
  private View jdField_f_of_type_AndroidViewView = null;
  private String jdField_f_of_type_JavaLangString = null;
  private boolean jdField_f_of_type_Boolean = true;
  private String jdField_g_of_type_JavaLangString = null;
  private boolean jdField_g_of_type_Boolean = false;
  private String h = null;
  
  public DatingDestinationActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private appoint_define.LocaleInfo a(Intent paramIntent)
  {
    switch (this.jdField_e_of_type_Int)
    {
    case 0: 
    case 1: 
    default: 
      return null;
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("dating_destination_result");
    if (arrayOfByte != null)
    {
      paramIntent = new appoint_define.LocaleInfo();
      try
      {
        paramIntent.mergeFrom(arrayOfByte);
        return paramIntent;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (!QLog.isColorLevel()) {
          return paramIntent;
        }
      }
      QLog.e("DatingDestinationActivity", 2, "loadSelectVal parse array fail, ask developer who call here", localInvalidProtocolBufferMicroException);
      this.jdField_e_of_type_Int = 0;
      return null;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("DatingDestinationActivity", 2, "intent data is null, ask developer who call here");
      }
      this.jdField_e_of_type_Int = 0;
      return null;
    }
    return paramIntent;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilSet.add("北京");
    this.jdField_a_of_type_JavaUtilSet.add("天津");
    this.jdField_a_of_type_JavaUtilSet.add("重庆");
    this.jdField_a_of_type_JavaUtilSet.add("上海");
    this.jdField_a_of_type_JavaUtilSet.add("北京市");
    this.jdField_a_of_type_JavaUtilSet.add("天津市");
    this.jdField_a_of_type_JavaUtilSet.add("重庆市");
    this.jdField_a_of_type_JavaUtilSet.add("上海市");
  }
  
  private void a(appoint_define.LocaleInfo paramLocaleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "doSelectDestination:" + paramLocaleInfo.str_name.get());
    }
    Intent localIntent = getIntent();
    localIntent.putExtra("dating_destination_select_type", 3);
    localIntent.putExtra("dating_destination_result", paramLocaleInfo.toByteArray());
    setResult(-1, localIntent);
    finish();
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "doSelectHometown");
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004F31", "0X8004F31", 0, 0, "", "", "", "");
    paramString = getIntent();
    paramString.putExtra("dating_destination_select_type", 2);
    if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo != null) {
      paramString.putExtra("dating_destination_result", this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.toByteArray());
    }
    setResult(-1, paramString);
    finish();
  }
  
  private void a(String paramString, ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "executeSearch:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_g_of_type_Boolean);
      if (!paramString.equals(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131369243));
        this.jdField_e_of_type_Boolean = false;
        if (!this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = true;
          addObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
        }
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_b_of_type_ComTencentMobileqqPbByteStringMicro = null;
        this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        ((DatingHandler)this.app.a(40)).a(paramString, this.jdField_f_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqPbByteStringMicro);
        this.jdField_f_of_type_Boolean = true;
        this.jdField_g_of_type_Boolean = true;
        return;
      }
    } while ((paramByteStringMicro == this.jdField_b_of_type_ComTencentMobileqqPbByteStringMicro) || (this.jdField_e_of_type_Boolean));
    ((DatingHandler)this.app.a(40)).a(paramString, this.jdField_f_of_type_JavaLangString, paramByteStringMicro);
    l();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = true;
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      localStringBuilder.append(paramArrayOfString[i]);
      if (i != paramArrayOfString.length - 1) {
        localStringBuilder.append("-");
      }
      i += 1;
    }
    localSharedPreferences.edit().putString("qq_dating_destination_homecode", paramString).putString("qq_dating_destination_hometown", localStringBuilder.toString()).commit();
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if ((paramArrayOfString.length > 2) && (!TextUtils.isEmpty(paramArrayOfString[2]))) {}
    for (this.h = paramArrayOfString[2];; this.h = paramArrayOfString[1]) {
      do
      {
        if (this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo == null) {
          this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo = new appoint_define.LocaleInfo();
        }
        if ((paramArrayOfString.length > 0) && (!TextUtils.isEmpty(paramArrayOfString[0]))) {
          this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_country.set(paramArrayOfString[0]);
        }
        if ((paramArrayOfString.length > 1) && (!TextUtils.isEmpty(paramArrayOfString[1]))) {
          this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_province.set(paramArrayOfString[1]);
        }
        if ((paramArrayOfString.length > 2) && (!TextUtils.isEmpty(paramArrayOfString[2]))) {
          this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_city.set(paramArrayOfString[2]);
        }
        if ((paramArrayOfString.length > 3) && (!TextUtils.isEmpty(paramArrayOfString[3]))) {
          this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_region.set(paramArrayOfString[3]);
        }
        if ((paramArrayOfString.length <= 1) || (TextUtils.isEmpty(paramArrayOfString[1])) || (!b(paramArrayOfString[1]))) {
          break;
        }
        this.h = paramArrayOfString[1];
        this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_city.set(paramArrayOfString[1]);
        if ((paramArrayOfString.length <= 2) || (TextUtils.isEmpty(paramArrayOfString[2]))) {
          break;
        }
        this.jdField_a_of_type_AppointDefineAppoint_define$LocaleInfo.str_region.set(paramArrayOfString[2]);
        return;
      } while ((paramArrayOfString.length <= 1) || (TextUtils.isEmpty(paramArrayOfString[1])));
    }
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    String str = localSharedPreferences.getString("qq_dating_destination_homecode", "");
    if ((TextUtils.isEmpty(str)) || (!str.equals(paramString))) {}
    do
    {
      return false;
      paramString = localSharedPreferences.getString("qq_dating_destination_hometown", "");
    } while (TextUtils.isEmpty(paramString));
    a(paramString.split("-"));
    return true;
  }
  
  private void b()
  {
    setTitle("目的地");
    ((TextView)findViewById(2131297348)).setText("目的地");
    this.jdField_c_of_type_AndroidViewView = findViewById(2131297347);
    Object localObject1 = (TextView)findViewById(2131297357);
    Object localObject2 = getIntent().getExtras().getString("leftViewText");
    ((TextView)localObject1).setText((CharSequence)localObject2);
    ((TextView)localObject1).setContentDescription("返回" + (String)localObject2 + "按钮");
    ((TextView)localObject1).setOnClickListener(this);
    getWindow().setBackgroundDrawable(getResources().getDrawable(2130837687));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131296742);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130837687);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299933));
    localObject1 = getLayoutInflater().inflate(2130903874, null, false);
    this.jdField_f_of_type_AndroidViewView = ((View)localObject1).findViewById(2131299923);
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      localObject2 = this.jdField_f_of_type_AndroidViewView.findViewById(2131299924);
      if ((this.jdField_e_of_type_Int != 1) && (this.jdField_e_of_type_Int != 0)) {
        break label318;
      }
    }
    label318:
    for (int i = 0;; i = 4)
    {
      ((View)localObject2).setVisibility(i);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131299925);
      this.jdField_e_of_type_AndroidViewView = ((View)localObject1).findViewById(2131299922);
      this.jdField_e_of_type_AndroidViewView.setContentDescription("输入你想去的地方 搜索栏 连按两次来编辑");
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.a((View)localObject1);
      this.jdField_a_of_type_Ian = new ian(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ian);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new hzw(this));
      return;
    }
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    d();
    f();
    h();
  }
  
  private void d()
  {
    ThreadManager.b(new iae(this));
  }
  
  private void e()
  {
    if (TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {}
    String[] arrayOfString;
    do
    {
      return;
      arrayOfString = this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this.jdField_g_of_type_JavaLangString.split("-"));
    } while (arrayOfString == null);
    a(this.jdField_g_of_type_JavaLangString, arrayOfString);
    a(arrayOfString);
    g();
  }
  
  private void f()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.f();
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "load home info from server");
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "hometown:" + this.h);
    }
    if ("中国".equals(this.h)) {
      return;
    }
    runOnUiThread(new iaf(this));
  }
  
  private void h()
  {
    ThreadManager.b(new iag(this));
  }
  
  private void i()
  {
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    int i = this.jdField_c_of_type_AndroidViewView.getHeight();
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject1);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130904393);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    ((TranslateAnimation)localObject2).setFillAfter(true);
    iai localiai = new iai(this, (TranslateAnimation)localObject1, localDialog, i, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(localiai);
    ((TranslateAnimation)localObject2).setAnimationListener(localiai);
    localDialog.setOnDismissListener(new iaj(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131299473));
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131369835);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new iar(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131299465));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new iak(this));
    localObject1 = (Button)localDialog.findViewById(2131299461);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new ial(this, localDialog));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131297286));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131297284));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new iam(this, localDialog));
    this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131302032));
    this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130837687);
    this.jdField_d_of_type_AndroidViewView = localDialog.getLayoutInflater().inflate(2130903876, null, false);
    this.jdField_b_of_type_ComTencentWidgetXListView.b(this.jdField_d_of_type_AndroidViewView);
    this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_Iap = new iap(this);
    this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Iap);
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new hzx(this, localInputMethodManager));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(new hzy(this, localDialog));
    this.jdField_b_of_type_ComTencentWidgetXListView.setOnScrollListener(new hzz(this));
    if (1 == OfflineDownloader.a(getApplicationContext())) {}
    for (this.jdField_b_of_type_Boolean = true;; this.jdField_b_of_type_Boolean = false)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004F33", "0X8004F33", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void j()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "doSelectNoRestraint");
    }
    Intent localIntent = getIntent();
    localIntent.putExtra("dating_destination_select_type", 1);
    localIntent.putExtra("dating_destination_result", "");
    setResult(-1, localIntent);
    finish();
  }
  
  private void l()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131297004).setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131299928).setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131299929).setVisibility(8);
  }
  
  private void m()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131297004).setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131299928).setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131299929).setVisibility(0);
  }
  
  private void n()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131297004).setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131299928).setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.findViewById(2131299929).setVisibility(8);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903878);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)this.app.getManager(57));
    paramBundle = getIntent();
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("is_select_mode", false);
    this.jdField_e_of_type_Int = paramBundle.getIntExtra("dating_destination_select_type", 0);
    this.jdField_b_of_type_AppointDefineAppoint_define$LocaleInfo = a(paramBundle);
    a();
    b();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqDatingDatingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.d(this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_e_of_type_AndroidViewView.requestFocus();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299922: 
      i();
      return;
    case 2131299923: 
      k();
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingDestinationActivity
 * JD-Core Version:    0.7.0.1
 */