package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import eyh;
import eyi;
import eyk;
import eyl;
import eym;
import eyn;
import eyq;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterSendUpSms
  extends RegisterBaseActivity
{
  public static final int a = 60;
  private static final String jdField_a_of_type_JavaLangString = "RegisterSendUpSms";
  public static final int b = 1000;
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new eyq(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new eyn(this);
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private String jdField_b_of_type_JavaLangString = null;
  private int jdField_c_of_type_Int = 60;
  private String jdField_c_of_type_JavaLangString = null;
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new eyi(this, paramString));
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131366914) + "(" + this.jdField_c_of_type_Int + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131302012));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131302013));
    String str = getResources().getString(2131366899, new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new eyh(this));
  }
  
  private void d()
  {
    this.app.a(RegisterPhoneNumActivity.class).sendEmptyMessage(103);
    finish();
  }
  
  private void g()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131366835));
    localQQCustomDialog.setMessage(getString(2131366869));
    eyk localeyk = new eyk(this);
    eyl localeyl = new eyl(this);
    localQQCustomDialog.setPositiveButton(2131365737, localeyk);
    localQQCustomDialog.setNegativeButton(2131365736, localeyl);
    localQQCustomDialog.show();
  }
  
  private void h()
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new eym(this));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904385));
    setTitle(2131366874);
    this.d = getIntent().getStringExtra("phonenum");
    this.e = getIntent().getStringExtra("key");
    this.f = getIntent().getStringExtra("key_register_now_account");
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("key_register_tel");
    this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("key_register_smscode");
    c();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    e();
    i();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */