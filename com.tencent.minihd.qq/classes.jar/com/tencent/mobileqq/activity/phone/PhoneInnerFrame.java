package com.tencent.mobileqq.activity.phone;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import grc;

public class PhoneInnerFrame
  extends InnerFrame
{
  private int jdField_a_of_type_Int = 0;
  private BaseActivityView.IPhoneContext jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext;
  private BaseActivityView jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView;
  private ContactListView jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView;
  private PhoneLaunchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView;
  private PhoneMatchView jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  public boolean a;
  
  public PhoneInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public PhoneInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PhoneInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Intent paramIntent, BaseActivityView paramBaseActivityView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != paramBaseActivityView)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null)
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = paramBaseActivityView;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a(paramIntent, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.b();
      }
      setContentView(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView);
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = new PhoneMatchView(a(), this.jdField_a_of_type_Int);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView);
  }
  
  private void c(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = new PhoneLaunchView(a(), this.jdField_a_of_type_Int);
    }
    a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = new ContactListView(getContext(), this.jdField_a_of_type_Int);
    }
    a(null, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView);
  }
  
  public ForwardOperations a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.a;
    }
    return null;
  }
  
  protected BaseActivityView.IPhoneContext a()
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.b();
    }
    this.jdField_a_of_type_Boolean = true;
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a().overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getComponent().getClassName();
    if (str.equals(ContactListView.class.getName()))
    {
      h();
      return;
    }
    if (str.equals(PhoneLaunchActivity.class.getName()))
    {
      c(paramIntent);
      return;
    }
    if (str.equals(PhoneMatchView.class.getName()))
    {
      b(null);
      return;
    }
    a().startActivityForResult(paramIntent, paramInt);
  }
  
  public final BaseActivityView.IPhoneContext b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext = a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView$IPhoneContext;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.c();
    }
    this.jdField_a_of_type_Boolean = false;
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("key_req_type");
    }
    g();
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new grc(this);
      b().a().registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    ((PhoneContactManager)b().a().getManager(10)).c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView.d();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
      removeAllViews();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      b().a().unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView.e();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = null;
    }
    super.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneContactListView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneMatchView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhonePhoneLaunchView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBaseActivityView = null;
    super.d();
  }
  
  public void f()
  {
    a().a(0);
  }
  
  public void g()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)b().a().getManager(10);
    switch (localPhoneContactManagerImp.b())
    {
    case 5: 
    default: 
      h();
      return;
    case 0: 
    case 4: 
    case 6: 
    case 7: 
      h();
      return;
    case 1: 
    case 2: 
      c(null);
      return;
    }
    if (localPhoneContactManagerImp.h())
    {
      h();
      return;
    }
    b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneInnerFrame
 * JD-Core Version:    0.7.0.1
 */