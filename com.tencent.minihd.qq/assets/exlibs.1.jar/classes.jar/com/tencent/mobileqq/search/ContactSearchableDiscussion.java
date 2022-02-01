package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Iterator;
import java.util.List;

public class ContactSearchableDiscussion
  extends IContactSearchable
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int jdField_c_of_type_Int = 2;
  private static final int jdField_d_of_type_Int = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DiscussionInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
  private FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String jdField_d_of_type_JavaLangString;
  private int e;
  private int f = 0;
  
  @SuppressLint({"DefaultLocale"})
  public ContactSearchableDiscussion(Context paramContext, QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo, int paramInt1, long paramLong1, long paramLong2, int paramInt2, List paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.A = paramLong2;
    this.e = paramInt1;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131366007);
    ChnToSpell.a(paramContext);
    if ((paramDiscussionInfo.discussionName != null) && (paramDiscussionInfo.discussionName.length() != 0))
    {
      this.b = ChnToSpell.a(paramDiscussionInfo.discussionName, 1).toLowerCase();
      this.c = ChnToSpell.a(paramDiscussionInfo.discussionName, 2).toLowerCase();
    }
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    a();
  }
  
  public ContactSearchableDiscussion(Context paramContext, QQAppInterface paramQQAppInterface, DiscussionInfo paramDiscussionInfo, int paramInt, long paramLong, List paramList)
  {
    this(paramContext, paramQQAppInterface, paramDiscussionInfo, paramInt, 0L, paramLong, 2, paramList);
  }
  
  public static long a(List paramList, FriendManager paramFriendManager, String paramString)
  {
    paramString = paramString.trim().split("\\s+");
    long l1;
    if ((paramString.length < 2) || (paramList == null)) {
      l1 = -1L;
    }
    label640:
    label643:
    label659:
    for (;;)
    {
      return l1;
      int k = paramString.length;
      int j = 0;
      l1 = 0L;
      label59:
      long l2;
      if (j < k)
      {
        String str1 = paramString[j];
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (DiscussionMemberInfo)localIterator.next();
          String str2 = ((DiscussionMemberInfo)localObject).inteRemark;
          String str3 = ChnToSpell.a(str2, 1).toLowerCase();
          String str4 = ChnToSpell.a(str2, 2).toLowerCase();
          if (!TextUtils.isEmpty(str2))
          {
            i = str2.indexOf(str1);
            int m = str3.indexOf(str1);
            int n = str4.indexOf(str1);
            if ((i >= 0) || (m >= 0) || (n >= 0)) {
              if ((i == 0) || (m == 0) || (n == 0))
              {
                l2 = 562949953421312L;
                label177:
                l1 = l2 + l1;
                i = 1;
                label186:
                if (i != 0) {
                  break label643;
                }
                str2 = ((DiscussionMemberInfo)localObject).memberName;
                str3 = ChnToSpell.a(str2, 1).toLowerCase();
                str4 = ChnToSpell.a(str2, 2).toLowerCase();
                if (TextUtils.isEmpty(str2)) {
                  break label643;
                }
                m = str2.indexOf(str1);
                n = str3.indexOf(str1);
                int i1 = str4.indexOf(str1);
                if ((m < 0) && (n < 0) && (i1 < 0)) {
                  break label643;
                }
                if ((m != 0) && (n != 0) && (i1 != 0)) {
                  break label598;
                }
                l2 = 562949953421312L;
                label289:
                l1 += l2;
                i = 1;
                label298:
                if (i != 0) {
                  break label640;
                }
                localObject = paramFriendManager.a(((DiscussionMemberInfo)localObject).memberUin);
                if ((localObject == null) || (!((Friends)localObject).isFriend())) {
                  break label640;
                }
                if (TextUtils.isEmpty(((Friends)localObject).remark)) {
                  break label637;
                }
                str2 = ((Friends)localObject).remark;
                str3 = ChnToSpell.a(str2, 1).toLowerCase();
                str4 = ChnToSpell.a(str2, 2).toLowerCase();
                if (TextUtils.isEmpty(str2)) {
                  break label637;
                }
                m = str2.indexOf(str1);
                n = str3.indexOf(str1);
                i1 = str4.indexOf(str1);
                if ((m < 0) && (n < 0) && (i1 < 0)) {
                  break label637;
                }
                if ((m != 0) && (n != 0) && (i1 != 0)) {
                  break label606;
                }
                l2 = 562949953421312L;
                label438:
                l1 += l2;
                i = 1;
                label447:
                if ((i != 0) || (TextUtils.isEmpty(((Friends)localObject).name))) {
                  break label634;
                }
                localObject = ((Friends)localObject).name;
                str2 = ChnToSpell.a((String)localObject, 1).toLowerCase();
                str3 = ChnToSpell.a((String)localObject, 2).toLowerCase();
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  break label634;
                }
                m = ((String)localObject).indexOf(str1);
                n = str2.indexOf(str1);
                i1 = str3.indexOf(str1);
                if ((m < 0) && (n < 0) && (i1 < 0)) {
                  break label634;
                }
                if ((m != 0) && (n != 0) && (i1 != 0)) {
                  break label614;
                }
                l2 = 562949953421312L;
                label561:
                l1 += l2;
                i = 1;
                label570:
                if (i == 0) {
                  break label622;
                }
                i = 1;
                label576:
                if (i != 0) {
                  break label625;
                }
              }
            }
          }
        }
      }
      for (int i = 0;; i = 1)
      {
        if (i != 0) {
          break label659;
        }
        return -1L;
        l2 = 281474976710656L;
        break label177;
        label598:
        l2 = 281474976710656L;
        break label289;
        label606:
        l2 = 281474976710656L;
        break label438;
        label614:
        l2 = 281474976710656L;
        break label561;
        label622:
        break label59;
        label625:
        j += 1;
        break;
        label634:
        break label570;
        label637:
        break label447;
        break label570;
        break label298;
        i = 0;
        break label186;
        i = 0;
        break label576;
      }
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    ChnToSpell.a(this.jdField_a_of_type_AndroidContentContext);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label26:
    label155:
    label182:
    label316:
    label450:
    label844:
    label1229:
    label1238:
    for (;;)
    {
      Object localObject;
      long l;
      label477:
      label612:
      label624:
      int i;
      int j;
      if (localIterator.hasNext())
      {
        localObject = (DiscussionMemberInfo)localIterator.next();
        String str1 = ((DiscussionMemberInfo)localObject).inteRemark;
        String str2 = ChnToSpell.a(str1, 1).toLowerCase();
        String str3 = ChnToSpell.a(str1, 2).toLowerCase();
        if ((str1 != null) && (str1.length() != 0))
        {
          if ((!str1.equals(paramString)) && ((str2 == null) || (!str2.equals(paramString))) && ((str3 == null) || (!str3.equals(paramString)))) {
            break label624;
          }
          if ((str1.equals(paramString)) || (str1.equals(str2))) {
            break label612;
          }
          l = 1125899906842624L + 4503599627370496L;
          if (this.z < l)
          {
            this.z = l;
            this.f = 2;
            this.d = str1;
          }
        }
        str1 = ((DiscussionMemberInfo)localObject).memberName;
        str2 = ChnToSpell.a(str1, 1).toLowerCase();
        str3 = ChnToSpell.a(str1, 2).toLowerCase();
        if ((str1 != null) && (str1.length() != 0))
        {
          if ((!str1.equals(paramString)) && ((str2 == null) || (!str2.equals(paramString))) && ((str3 == null) || (!str3.equals(paramString)))) {
            break label781;
          }
          if ((str1.equals(paramString)) || (str1.equals(str2))) {
            break label769;
          }
          l = 1125899906842624L + 4503599627370496L;
          if (this.z < l)
          {
            this.z = l;
            this.f = 2;
            this.d = str1;
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a(((DiscussionMemberInfo)localObject).memberUin);
        if ((localObject == null) || (!((Friends)localObject).isFriend())) {
          continue;
        }
        if (!TextUtils.isEmpty(((Friends)localObject).remark))
        {
          str1 = ((Friends)localObject).remark;
          str2 = ChnToSpell.a(str1, 1).toLowerCase();
          str3 = ChnToSpell.a(str1, 2).toLowerCase();
          if ((!str1.equals(paramString)) && ((str2 == null) || (!str2.equals(paramString))) && ((str3 == null) || (!str3.equals(paramString)))) {
            break label938;
          }
          if ((str1.equals(paramString)) || (str1.equals(str2))) {
            break label926;
          }
          l = 1125899906842624L + 4503599627370496L;
          if (this.z < l)
          {
            this.z = l;
            this.f = 2;
            this.d = str1;
          }
        }
        if (!TextUtils.isEmpty(((Friends)localObject).name))
        {
          localObject = ((Friends)localObject).name;
          str1 = ChnToSpell.a((String)localObject, 1).toLowerCase();
          str2 = ChnToSpell.a((String)localObject, 2).toLowerCase();
          if ((!((String)localObject).equals(paramString)) && ((str1 == null) || (!str1.equals(paramString))) && ((str2 == null) || (!str2.equals(paramString)))) {
            break label1095;
          }
          if ((((String)localObject).equals(paramString)) || (((String)localObject).equals(str1))) {
            break label1083;
          }
        }
        for (l = 1125899906842624L + 4503599627370496L;; l = 1125899906842624L + 9007199254740992L)
        {
          if (this.z >= l) {
            break label1093;
          }
          this.z = l;
          this.f = 2;
          this.d = ((String)localObject);
          break;
          l = 1125899906842624L + 9007199254740992L;
          break label155;
          k = str1.indexOf(paramString);
          if (str2 != null)
          {
            i = str2.indexOf(paramString);
            if (str3 == null) {
              break label745;
            }
            j = str3.indexOf(paramString);
            if ((k < 0) && (i < 0) && (j < 0)) {
              break label748;
            }
            if ((k != 0) && (i != 0) && (j != 0)) {
              break label750;
            }
            l = 562949953421312L;
            if ((k >= 0) || (str1.equals(str2))) {
              break label758;
            }
          }
          label745:
          label748:
          label750:
          label758:
          for (l += 4503599627370496L;; l += 9007199254740992L)
          {
            if (this.z >= l) {
              break label767;
            }
            this.z = l;
            this.f = 2;
            this.d = str1;
            break;
            i = -1;
            break label644;
            j = -1;
            break label656;
            break;
            l = 281474976710656L;
            break label687;
          }
          label767:
          break label182;
          l = 1125899906842624L + 9007199254740992L;
          break label289;
          k = str1.indexOf(paramString);
          if (str2 != null)
          {
            i = str2.indexOf(paramString);
            if (str3 == null) {
              break label902;
            }
            j = str3.indexOf(paramString);
            if ((k < 0) && (i < 0) && (j < 0)) {
              break label905;
            }
            if ((k != 0) && (i != 0) && (j != 0)) {
              break label907;
            }
            l = 562949953421312L;
            if ((k >= 0) || (str1.equals(str2))) {
              break label915;
            }
          }
          for (l += 4503599627370496L;; l += 9007199254740992L)
          {
            if (this.z >= l) {
              break label924;
            }
            this.z = l;
            this.f = 2;
            this.d = str1;
            break;
            i = -1;
            break label801;
            j = -1;
            break label813;
            break;
            l = 281474976710656L;
            break label844;
          }
          break label316;
          l = 1125899906842624L + 9007199254740992L;
          break label450;
          k = str1.indexOf(paramString);
          if (str2 != null)
          {
            i = str2.indexOf(paramString);
            if (str3 == null) {
              break label1059;
            }
            j = str3.indexOf(paramString);
            if ((k < 0) && (i < 0) && (j < 0)) {
              break label1062;
            }
            if ((k != 0) && (i != 0) && (j != 0)) {
              break label1064;
            }
            l = 562949953421312L;
            label1001:
            if ((k >= 0) || (str1.equals(str2))) {
              break label1072;
            }
          }
          for (l += 4503599627370496L;; l += 9007199254740992L)
          {
            if (this.z >= l) {
              break label1081;
            }
            this.z = l;
            this.f = 2;
            this.d = str1;
            break label477;
            break;
            i = -1;
            break label958;
            j = -1;
            break label970;
            break label477;
            l = 281474976710656L;
            break label1001;
          }
          break label477;
        }
        continue;
        int k = ((String)localObject).indexOf(paramString);
        if (str1 == null) {
          break label1211;
        }
        i = str1.indexOf(paramString);
        label1115:
        if (str2 == null) {
          break label1216;
        }
        j = str2.indexOf(paramString);
        label1127:
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label1219;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label1221;
        }
        l = 562949953421312L;
        if ((k >= 0) || (((String)localObject).equals(str1))) {
          break label1229;
        }
      }
      for (l += 4503599627370496L;; l += 9007199254740992L)
      {
        if (this.z >= l) {
          break label1238;
        }
        this.z = l;
        this.f = 2;
        this.d = ((String)localObject);
        break label26;
        break;
        i = -1;
        break label1115;
        j = -1;
        break label1127;
        break label26;
        l = 281474976710656L;
        break label1158;
      }
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  private void c(String paramString)
  {
    if (this.z != -9223372036854775808L) {}
    long l;
    do
    {
      return;
      l = a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqModelFriendManager, paramString);
    } while (l == -1L);
    this.z = (l + 0L + 9007199254740992L + this.A);
    this.f = 3;
  }
  
  public int a()
  {
    return 0;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin, 3000);
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
  
  public DiscussionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
  }
  
  public String a()
  {
    return ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo);
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    int j = -1;
    String str1 = paramString.toLowerCase();
    String str2;
    String str3;
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName != null)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.discussionName.toLowerCase();
      str2 = this.b;
      str3 = this.c;
      if ((paramString == null) || (paramString.length() == 0)) {
        break label303;
      }
      if ((!paramString.equals(str1)) && ((str2 == null) || (!str2.equals(str1))) && ((str3 == null) || (!str3.equals(str1)))) {
        break label177;
      }
      if ((paramString.equals(str1)) || (paramString.equals(str2))) {
        break label165;
      }
      l = 1125899906842624L + 4503599627370496L;
      label118:
      this.f = 1;
    }
    for (;;)
    {
      this.z = l;
      b(str1);
      if (this.z != -9223372036854775808L)
      {
        this.z += this.A;
        return;
        paramString = null;
        break;
        label165:
        l = 1125899906842624L + 9007199254740992L;
        break label118;
        label177:
        int k = paramString.indexOf(str1);
        int i;
        if (str2 != null)
        {
          i = str2.indexOf(str1);
          label198:
          if (str3 != null) {
            j = str3.indexOf(str1);
          }
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label303;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label277;
          }
          l = 562949953421312L;
          label242:
          if ((k >= 0) || (paramString.equals(str2))) {
            break label285;
          }
        }
        label277:
        label285:
        for (l += 4503599627370496L;; l += 9007199254740992L)
        {
          this.f = 1;
          break;
          i = -1;
          break label198;
          l = 281474976710656L;
          break label242;
        }
      }
      c(str1);
      return;
      label303:
      l = -9223372036854775808L;
    }
  }
  
  public int b()
  {
    return 101;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    if (this.f == 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return String.format("(%d)", new Object[] { Integer.valueOf(this.e) });
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableDiscussion
 * JD-Core Version:    0.7.0.1
 */