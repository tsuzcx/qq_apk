package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.utils.SMSBodyObserver;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dhm;
import dhn;
import dho;
import dhp;
import dhq;
import dhr;
import dhs;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.observer.WtloginObserver;

public class AuthDevVerifyCodeActivity
  extends RegisterBaseActivity
  implements TextWatcher, View.OnClickListener, SMSBodyObserver
{
  public static final int a = 60;
  public static final String a = "mobile_type";
  public static final int b = 1000;
  public static final int c = -1;
  public static final int d = 0;
  public static final int e = 1;
  private static final String g = "Q.devlock.AuthDevVerifyCodeActivity";
  private static final String h = "UserBehavior";
  private static final String i = "Manually";
  private static final String jdField_j_of_type_JavaLangString = "Push";
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new dhm(this);
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new dhp(this);
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new dho(this);
  private boolean jdField_a_of_type_Boolean = false;
  private TextView b;
  protected String b;
  protected String c = null;
  protected int f = -1;
  private int jdField_j_of_type_Int;
  private int k = 60;
  
  public AuthDevVerifyCodeActivity()
  {
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler = new dhn(this);
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.k = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131366883) + "(" + this.k + ")");
    this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void c()
  {
    if (!NetworkUtil.e(this))
    {
      QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
      return;
    }
    Object localObject1 = "";
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
    if (localObject2 != null)
    {
      localObject2 = localObject2.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
    }
    if ((localObject1 != null) && (((String)localObject1).length() > 0))
    {
      localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to submitSms smsCode=" + (String)localObject1);
        }
        m = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver, (String)localObject1);
        if (m == 0)
        {
          g();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.submitSms failed ret=" + m);
        }
        a(2131366867, 1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.begin to CheckDevLockSms smsCode=" + (String)localObject1);
      }
      int m = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject2, (String)localObject1, null, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (m == 0)
      {
        g();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "commitSmsCode.CheckDevLockSms failed ret=" + m);
      }
      a(2131366867, 1);
      return;
    }
    a(2131366881, 0);
  }
  
  private void d()
  {
    if (!NetworkUtil.e(this)) {
      QQToast.a(this, getString(2131365730), 0).b(getTitleBarHeight());
    }
    int m;
    do
    {
      String str;
      do
      {
        return;
        str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        if (this.f != -1) {
          EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.f);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to refreshDevLockSms");
        }
        m = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        if (m == 0)
        {
          a(2131366848);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.refreshDevLockSms failed ret=" + m);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.begin to AskDevLockSms");
      }
      m = EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
      if (m == 0)
      {
        a(2131366848);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "startGetVerifyCode.AskDevLockSms failed ret=" + m);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dhq(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dhr(this));
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().length() >= 4)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void handleMessage(String paramString1, String paramString2)
  {
    runOnUiThread(new dhs(this, paramString1, paramString2));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299117: 
      c();
      return;
    }
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903924);
    super.setTitle(2131366880);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.app;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getAppRuntime());
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      super.finish();
      return;
    }
    paramBundle = super.getIntent();
    this.jdField_a_of_type_Boolean = paramBundle.getExtras().getBoolean("from_login");
    this.d = paramBundle.getExtras().getString("phone_num");
    this.e = paramBundle.getExtras().getString("country_code");
    this.f = paramBundle.getExtras().getInt("mobile_type", -1);
    this.j = paramBundle.getExtras().getInt("seq");
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevVerifyCodeActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.j + " phoneNum=" + this.d);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300113));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)super.findViewById(2131298086));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131299117));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131366882, new Object[] { this.d }));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131300115));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131366883));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131365737));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131366883));
    this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.j);
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
    h();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity
 * JD-Core Version:    0.7.0.1
 */