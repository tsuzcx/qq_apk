package com.tencent.mobileqq.app;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import mqq.app.Constants.LogoutReason;

public abstract class Frame
{
  private View jdField_a_of_type_AndroidViewView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  public QQAppInterface a;
  protected boolean a;
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
  
  public ContentResolver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getContentResolver();
  }
  
  public Resources a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    return null;
  }
  
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public Object a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService(paramString);
  }
  
  protected String a()
  {
    return null;
  }
  
  public String a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt);
  }
  
  public String a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt, new Object[] { paramString });
  }
  
  public void a() {}
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramIntent);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(Configuration paramConfiguration) {}
  
  void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  protected void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.post(paramRunnable);
    }
  }
  
  protected void a(Constants.LogoutReason paramLogoutReason) {}
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    if (Conversation.c())
    {
      Conversation.h();
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    j();
  }
  
  public void b(Runnable paramRunnable)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(paramRunnable);
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void d() {}
  
  public abstract void e();
  
  protected void f() {}
  
  protected void g()
  {
    f();
    j();
    e();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.Frame
 * JD-Core Version:    0.7.0.1
 */