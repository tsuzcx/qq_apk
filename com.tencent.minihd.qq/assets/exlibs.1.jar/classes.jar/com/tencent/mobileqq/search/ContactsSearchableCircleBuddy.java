package com.tencent.mobileqq.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.utils.ChnToSpell;

public class ContactsSearchableCircleBuddy
  extends IContactSearchable
{
  public static final int a = 0;
  public static boolean a = false;
  public static final int b = 1;
  public static boolean b = false;
  public static final int c = 2;
  private static final int jdField_d_of_type_Int = 0;
  private static final int jdField_e_of_type_Int = 1;
  private static final int jdField_f_of_type_Int = 2;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CircleBuddy jdField_a_of_type_ComTencentMobileqqDataCircleBuddy;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private String jdField_e_of_type_JavaLangString;
  private String jdField_f_of_type_JavaLangString;
  private int g;
  private int h;
  
  public ContactsSearchableCircleBuddy(Context paramContext, QQAppInterface paramQQAppInterface, CircleBuddy paramCircleBuddy, long paramLong, int paramInt, String paramString)
  {
    this(paramContext, paramQQAppInterface, paramCircleBuddy, 0L, paramLong, paramInt, paramString);
  }
  
  public ContactsSearchableCircleBuddy(Context paramContext, QQAppInterface paramQQAppInterface, CircleBuddy paramCircleBuddy, long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy = paramCircleBuddy;
    this.A = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.h = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    ChnToSpell.a(paramContext);
    if ((paramCircleBuddy.remark != null) && (paramCircleBuddy.remark.length() != 0))
    {
      this.jdField_b_of_type_JavaLangString = ChnToSpell.a(paramCircleBuddy.remark, 1);
      this.c = ChnToSpell.a(paramCircleBuddy.remark, 2);
    }
    if ((paramCircleBuddy.nickName != null) && (paramCircleBuddy.nickName.length() != 0))
    {
      this.d = ChnToSpell.a(paramCircleBuddy.nickName, 1);
      this.e = ChnToSpell.a(paramCircleBuddy.nickName, 2);
    }
    a();
  }
  
  public int a()
  {
    return 0;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin, 1021);
    long l = 0L;
    if (localMessage != null) {
      l = localMessage.time;
    }
    return l;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public CircleBuddy a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy;
  }
  
  public String a()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName;
    if (TextUtils.isEmpty(str1))
    {
      this.f = null;
      return str2;
    }
    this.f = str2;
    return str1;
  }
  
  public void a(String paramString)
  {
    String str1;
    String str2;
    label44:
    String str3;
    String str4;
    String str5;
    String str6;
    long l2;
    long l1;
    long l4;
    long l3;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.remark.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName == null) {
        break label201;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.nickName.toLowerCase();
      String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin);
      str3 = this.jdField_b_of_type_JavaLangString;
      str4 = this.c;
      str5 = this.d;
      str6 = this.e;
      paramString = paramString.toLowerCase();
      l2 = -9223372036854775808L;
      this.z = -9223372036854775808L;
      l1 = 0L;
      l4 = l1;
      l3 = l2;
      if (str1 == null) {
        break label378;
      }
      l4 = l1;
      l3 = l2;
      if (str1.length() == 0) {
        break label378;
      }
      if (!str1.equals(paramString)) {
        break label207;
      }
      l2 = 1125899906842624L;
      l1 = 9007199254740992L;
    }
    label201:
    label207:
    int k;
    int i;
    label286:
    int j;
    for (;;)
    {
      l4 = l1;
      l3 = l2;
      if (l2 <= this.z) {
        break label378;
      }
      this.z = (0L + l2 + l1 + this.A);
      jdField_a_of_type_Boolean = true;
      jdField_b_of_type_Boolean = true;
      this.g = 2;
      return;
      str1 = null;
      break;
      str2 = null;
      break label44;
      if (((str3 != null) && (str3.equals(paramString))) || ((str4 != null) && (str4.equals(paramString))))
      {
        l2 = 1125899906842624L;
        if (!str1.equals(str3)) {
          l1 = 4503599627370496L;
        } else {
          l1 = 9007199254740992L;
        }
      }
      else
      {
        k = str1.indexOf(paramString);
        if (str3 != null)
        {
          i = str3.indexOf(paramString);
          if (str4 == null) {
            break label357;
          }
          j = str4.indexOf(paramString);
          label298:
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label360;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label362;
          }
        }
        label357:
        label360:
        label362:
        for (l2 = 562949953421312L;; l2 = 281474976710656L)
        {
          if ((k >= 0) || (str1.equals(str3))) {
            break label370;
          }
          l1 = 4503599627370496L;
          break;
          i = -1;
          break label286;
          j = -1;
          break label298;
          break;
        }
        label370:
        l1 = 9007199254740992L;
      }
    }
    label378:
    if ((str2 != null) && (str2.length() != 0))
    {
      if (!str2.equals(paramString)) {
        break label485;
      }
      l2 = 1125899906842624L;
      l1 = 9007199254740992L;
    }
    for (;;)
    {
      label410:
      if (l2 > this.z) {
        if (!TextUtils.isEmpty(str1)) {
          break label646;
        }
      }
      label646:
      for (this.z = (l2 + 0L);; this.z = (l2 + 0L))
      {
        this.z += l1;
        this.g = 1;
        if (this.z == -9223372036854775808L) {
          break;
        }
        this.z += this.A;
        jdField_a_of_type_Boolean = true;
        jdField_b_of_type_Boolean = true;
        return;
        label485:
        if ((str5.equals(paramString)) || (str6.equals(paramString)))
        {
          l2 = 1125899906842624L;
          if (!str2.equals(str5))
          {
            l1 = 4503599627370496L;
            break label410;
          }
          l1 = 9007199254740992L;
          break label410;
        }
        k = str2.indexOf(paramString);
        if (str5 != null)
        {
          i = str5.indexOf(paramString);
          label554:
          if (str6 == null) {
            break label625;
          }
          j = str6.indexOf(paramString);
          label566:
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label657;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label630;
          }
        }
        label625:
        label630:
        for (l2 = 562949953421312L;; l2 = 281474976710656L)
        {
          if ((k >= 0) || (str2.equals(str5))) {
            break label638;
          }
          l1 = 4503599627370496L;
          break;
          i = -1;
          break label554;
          j = -1;
          break label566;
        }
        label638:
        l1 = 9007199254740992L;
        break label410;
      }
      label657:
      l1 = l4;
      l2 = l3;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    switch (this.h)
    {
    default: 
      return "人脉圈";
    case 0: 
      return "人脉圈";
    case 1: 
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public String c()
  {
    if (!TextUtils.isEmpty(this.f)) {
      return String.format("(%s)", new Object[] { this.f });
    }
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactsSearchableCircleBuddy
 * JD-Core Version:    0.7.0.1
 */