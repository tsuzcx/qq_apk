package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import exn;
import exo;
import exq;
import exs;
import exv;
import exw;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterPhoneNumActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "RegisterPhoneNumActivity";
  private Handler jdField_a_of_type_AndroidOsHandler = new exn(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new exw(this);
  private boolean jdField_a_of_type_Boolean = true;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private TextView c;
  
  private String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.e)) {
          break label170;
        }
        if ("853".equals(this.e))
        {
          break label170;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.e)) {
            i = 0;
          }
        }
        if (!"86".equals(this.e)) {
          break label162;
        }
        j = paramString.length();
        if (j == 11) {
          break label162;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label145;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.e);
      if (bool)
      {
        i = 9;
        continue;
        label145:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label162:
        continue;
        label170:
        i = 6;
      }
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new exv(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean a()
  {
    this.d = a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString());
    if (this.d == null)
    {
      a(2131366866, 1);
      return false;
    }
    if (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      a(2131366844, 1);
      return false;
    }
    return true;
  }
  
  private void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.d);
    localIntent.putExtra("key", this.e);
    localIntent.putExtra("key_register_now_account", this.f);
    localIntent.putExtra("key_register_tel", paramString1);
    localIntent.putExtra("key_register_smscode", paramString2);
    startActivity(localIntent);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297971));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297972));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new exo(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131297974));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new exq(this));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300133));
    this.c.setText(getString(2131366915) + "+" + this.e);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298086));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131300134));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void c(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_AndroidOsHandler.post(new exs(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void d()
  {
    if (!a()) {
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(2131365730, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "RegisterPhoneNumActivity.startQueryAccount countryCode=" + this.e + " phoneNum=" + this.d);
      }
      ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.e, this.d, this.jdField_a_of_type_MqqObserverAccountObserver);
      a(2131366848);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void g()
  {
    if (!a()) {
      return;
    }
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber((byte)2, this.e, this.d, Long.valueOf(AppSetting.a), this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.d);
    localIntent.putExtra("key", this.e);
    localIntent.putExtra("key_register_now_account", this.f);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_b_of_type_Boolean);
    startActivity(localIntent);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((a(paramEditable.toString()) != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.e = paramIntent.getStringExtra("k_code");
      this.c.setText(str + " +" + this.e);
      try
      {
        if ((a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904072));
    setTitle(2131366874);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.f = paramBundle.getStringExtra("key_register_now_account");
    }
    this.app.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    e();
    this.app.a(getClass());
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((paramCompoundButton == this.jdField_a_of_type_AndroidWidgetCheckBox) && (paramBoolean) && (a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString()) != null))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131300133: 
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
      return;
    }
    d();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */