package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.newfriend.ContactRecommendActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.ContactBindServlet;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import fnk;
import fnl;
import fnm;
import fnn;
import fno;
import fnp;
import fnq;
import fnr;
import mqq.observer.WtloginObserver;

public class VerifyPhoneNumActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = "VerifyPhoneNumActivity";
  public Dialog a;
  private Handler jdField_a_of_type_AndroidOsHandler = new fnk(this);
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new fnp(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected QQToastNotifier a;
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new fno(this);
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler();
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f = null;
  
  private void b()
  {
    this.leftView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302393));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302394));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131302392));
    try
    {
      if ((this.d != null) && (this.d.length() > 4))
      {
        String str = "***" + this.d.substring(this.d.length() - 4, this.d.length());
        str = getString(2131366895, new Object[] { this.jdField_b_of_type_JavaLangString, str, this.e });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("uin", this.e);
    localIntent.putExtra("password", this.f);
    localIntent.putExtra("tab_index", 1);
    localIntent.addFlags(131072);
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    ContactBindServlet.b(this.app, this.jdField_a_of_type_ArrayOfByte, this.e);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 4, "startLogin");
    }
    PhoneNumLoginImpl.a().a(true);
    int i = PhoneNumLoginImpl.a().b(this.app, this.c, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerifyPhoneNumActivity", 4, "startLogin.GetStViaSMSVerifyLogin ret =" + i);
      }
      j();
      c();
    }
  }
  
  private void f()
  {
    Handler localHandler = this.app.a(LoginActivity.class);
    if (localHandler != null) {
      localHandler.sendEmptyMessage(20140325);
    }
    startActivity(new Intent(this, ContactRecommendActivity.class));
    overridePendingTransition(2130968641, 0);
    finish();
  }
  
  private void g()
  {
    Object localObject = this.app.a(LoginActivity.class);
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessage(20140325);
    }
    localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", 1);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void h()
  {
    ((PhoneContactManager)this.app.getManager(10)).f();
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new fnq(this));
  }
  
  private void j()
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new fnr(this));
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new fnl(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new fnm(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(str, getTitleBarHeight(), 0, paramInt);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
    if (isFinishing()) {
      return;
    }
    if (!PhoneNumLoginImpl.a().a())
    {
      QLog.d("VerifyPhoneNumActivity", 4, "onAccountChanged not phonenum login");
      return;
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    if (this.jdField_a_of_type_Boolean)
    {
      this.app.a(new fnn(this));
      return;
    }
    LoginActivity.a(this.app, this.app.getAccount());
    g();
    j();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302393: 
      i();
      d();
      return;
    case 2131302394: 
      i();
      e();
      return;
    }
    c();
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)setContentViewB(2130904510));
    setTitle(2131366894);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("phonenum");
    this.c = getIntent().getStringExtra("key");
    this.d = getIntent().getStringExtra("key_register_binduin");
    this.e = getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = getIntent().getByteArrayExtra("key_register_sign");
    this.f = getIntent().getStringExtra("key_register_password");
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    b();
    setRightButton(2131365736, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a();
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */