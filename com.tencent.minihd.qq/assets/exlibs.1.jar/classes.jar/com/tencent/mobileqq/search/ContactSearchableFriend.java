package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;

public class ContactSearchableFriend
  extends IContactSearchable
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  private String jdField_a_of_type_JavaLangString;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong)
  {
    this(paramContext, paramQQAppInterface, paramFriends, paramString, 0L, paramLong);
  }
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableFriend(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    this.A = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ChnToSpell.a(paramContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.length() != 0))
    {
      this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 1).toLowerCase();
      this.c = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 2).toLowerCase();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.name != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.length() != 0))
    {
      this.d = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 1).toLowerCase();
      this.jdField_e_of_type_JavaLangString = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 2).toLowerCase();
    }
    a();
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0);
    if (localMessage != null) {
      return localMessage.time;
    }
    return 0L;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public Friends a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends;
  }
  
  public String a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    switch (this.jdField_e_of_type_Int)
    {
    default: 
      localObject2 = null;
    case 0: 
    case 2: 
      do
      {
        do
        {
          return localObject2;
          if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject1 = str1;
            }
            for (;;)
            {
              localObject1 = String.format("%s", new Object[] { localObject1 });
              this.f = e();
              return localObject1;
            }
          }
          return str2;
          localObject2 = localObject1;
        } while (str1 == null);
        localObject2 = localObject1;
      } while (str1.length() == 0);
      localObject1 = String.format("%s", new Object[] { localObject1 });
      this.f = str1;
      return localObject1;
    case 1: 
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        localObject1 = String.format("%s", new Object[] { localObject1 });
        this.f = str1;
        return localObject1;
      }
      localObject1 = String.format("%s", new Object[] { str1 });
      this.f = e();
      return localObject1;
    }
    if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
    {
      localObject1 = String.format("%s", new Object[] { ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends) });
      this.f = ((String)localObject2);
      return localObject1;
    }
    return localObject2;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    String str1;
    String str2;
    label44:
    String str3;
    label63:
    String str4;
    label82:
    String str5;
    String str6;
    String str7;
    String str8;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name == null) {
        break label592;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin == null) {
        break label598;
      }
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias == null) {
        break label604;
      }
      str4 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
      str5 = this.b;
      str6 = this.c;
      str7 = this.d;
      str8 = this.jdField_e_of_type_JavaLangString;
      paramString = paramString.toLowerCase();
      l2 = -9223372036854775808L;
      this.z = -9223372036854775808L;
      l1 = l2;
      if (str1 != null)
      {
        l1 = l2;
        if (str1.length() != 0)
        {
          if ((!str1.equals(paramString)) && ((str5 == null) || (!str5.equals(paramString))) && ((str6 == null) || (!str6.equals(paramString)))) {
            break label622;
          }
          if ((str1.equals(paramString)) || (str1.equals(str5))) {
            break label610;
          }
          l1 = 1125899906842624L + 4503599627370496L;
          label209:
          l2 = l1 + 0L;
          l1 = l2;
          if (this.z < l2)
          {
            this.z = l2;
            this.jdField_e_of_type_Int = 2;
            l1 = l2;
          }
        }
      }
      if ((str2 == null) || (str2.length() == 0)) {
        break label1084;
      }
      if ((!str2.equals(paramString)) && ((str7 == null) || (!str7.equals(paramString))) && ((str8 == null) || (!str8.equals(paramString)))) {
        break label767;
      }
      if ((str2.equals(paramString)) || (str2.equals(str7))) {
        break label746;
      }
      l1 = 4503599627370496L + 1125899906842624L;
      label322:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        break label758;
      }
      l1 += 0L;
      label341:
      l2 = l1;
      if (this.z < l1)
      {
        this.z = l1;
        this.jdField_e_of_type_Int = 1;
      }
    }
    label441:
    label1081:
    label1084:
    for (long l2 = l1;; l2 = l1)
    {
      long l3 = l2;
      if (str4 != null)
      {
        l3 = l2;
        if (str4.length() != 0)
        {
          if (!str4.equals(paramString)) {
            break label922;
          }
          l1 = 1125899906842624L + 9007199254740992L;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
            break label913;
          }
          l1 += 0L;
          l3 = l1;
          if (this.z < l1)
          {
            this.z = l1;
            this.jdField_e_of_type_Int = 3;
            l3 = l1;
          }
        }
      }
      if (1 != this.jdField_a_of_type_ComTencentMobileqqDataFriends.cSpecialFlag)
      {
        l1 = l3;
        if (str3 != null)
        {
          if (!str3.equals(paramString)) {
            break label997;
          }
          l1 = 1125899906842624L + 9007199254740992L;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
            break label988;
          }
          l1 += 0L;
        }
      }
      for (;;)
      {
        if (this.z < l1)
        {
          this.z = l1;
          this.jdField_e_of_type_Int = 0;
        }
        if (this.z != -9223372036854775808L) {
          this.z += this.A;
        }
        return;
        str1 = null;
        break;
        label592:
        str2 = null;
        break label44;
        label598:
        str3 = null;
        break label63;
        label604:
        str4 = null;
        break label82;
        label610:
        l1 = 1125899906842624L + 9007199254740992L;
        break label209;
        label622:
        int k = str1.indexOf(paramString);
        int j;
        if (str5 != null)
        {
          i = str5.indexOf(paramString);
          if (str6 == null) {
            break label722;
          }
          j = str6.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label725;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label727;
          }
          l1 = 562949953421312L;
          if ((k >= 0) || (str1.equals(str5))) {
            break label735;
          }
        }
        label722:
        label725:
        label727:
        label735:
        for (l1 += 4503599627370496L;; l1 += 9007199254740992L)
        {
          l2 = l1 + 0L;
          break;
          i = -1;
          break label642;
          j = -1;
          break label654;
          break;
          l1 = 281474976710656L;
          break label685;
        }
        label746:
        l1 = 9007199254740992L + 1125899906842624L;
        break label322;
        label758:
        l1 += 0L;
        break label341;
        label767:
        k = str2.indexOf(paramString);
        if (str7 != null)
        {
          i = str7.indexOf(paramString);
          if (str8 == null) {
            break label880;
          }
          j = str8.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label1081;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label885;
          }
          l1 = 562949953421312L;
          label830:
          if ((k >= 0) || (str2.equals(str7))) {
            break label893;
          }
        }
        label880:
        label885:
        label893:
        for (l1 = 4503599627370496L + l1;; l1 = 9007199254740992L + l1)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
            break label904;
          }
          l1 += 0L;
          break;
          i = -1;
          break label787;
          j = -1;
          break label799;
          l1 = 281474976710656L;
          break label830;
        }
        l1 += 0L;
        break label341;
        l1 += 0L;
        break label441;
        l1 = l2;
        if (str4.indexOf(paramString) < 0) {
          break label441;
        }
        l1 = 281474976710656L + 9007199254740992L;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)))
        {
          l1 += 0L;
          break label441;
        }
        l1 += 0L;
        break label441;
        label988:
        l1 += 0L;
        continue;
        label997:
        int i = str3.indexOf(paramString);
        l1 = l3;
        if (i >= 0)
        {
          if (i == 0) {}
          for (l1 = 562949953421312L;; l1 = 281474976710656L)
          {
            l1 += 9007199254740992L;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
              break label1072;
            }
            l1 += 0L;
            break;
          }
          l1 += 0L;
        }
      }
      break label341;
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    if (this.f != null) {
      return String.format("(%s)", new Object[] { this.f });
    }
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableFriend
 * JD-Core Version:    0.7.0.1
 */