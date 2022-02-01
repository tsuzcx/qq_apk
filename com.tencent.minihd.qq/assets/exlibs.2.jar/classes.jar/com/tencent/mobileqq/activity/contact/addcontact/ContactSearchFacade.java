package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.PhoneCodeUtils;
import com.tencent.qphone.base.util.QLog;
import gga;

public class ContactSearchFacade
{
  public static final int a = 80000000;
  public static final String a;
  private static int[] jdField_a_of_type_ArrayOfInt = { 80000000 };
  public static final int b = 80000001;
  private static int[] jdField_b_of_type_ArrayOfInt = { 80000001 };
  public static final int c = 80000002;
  private static int[] c = { 80000002 };
  public static final int d = 80000003;
  private static int[] d = { 80000000, 80000001, 80000002 };
  private ContactSearchFacade.ISearchListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new gga(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_b_of_type_JavaLangString;
  private int e;
  private int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = ContactSearchFacade.class.getName();
  }
  
  public ContactSearchFacade(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = PhoneCodeUtils.a(paramQQAppInterface.getApplication());
  }
  
  final void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(ContactSearchFacade.ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = paramISearchListener;
  }
  
  public boolean a(String paramString)
  {
    a();
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_b_of_type_JavaLangString, 2, 0, null);
    return true;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    a();
    this.f = paramInt;
    int[] arrayOfInt = null;
    switch (paramInt)
    {
    }
    while (arrayOfInt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "warning! wrong request type = " + paramInt);
      }
      return false;
      arrayOfInt = jdField_a_of_type_ArrayOfInt;
      continue;
      arrayOfInt = jdField_b_of_type_ArrayOfInt;
      continue;
      arrayOfInt = c;
      continue;
      arrayOfInt = d;
    }
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramString, this.jdField_b_of_type_JavaLangString, 3, this.e, arrayOfInt);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "searchFriend nextPage = " + this.e);
    }
    return true;
  }
  
  public final void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  public void c()
  {
    this.e = 0;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade$ISearchListener = null;
    this.e = 0;
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade
 * JD-Core Version:    0.7.0.1
 */