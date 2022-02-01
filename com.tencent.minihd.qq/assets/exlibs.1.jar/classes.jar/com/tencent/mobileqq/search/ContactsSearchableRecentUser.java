package com.tencent.mobileqq.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ContactsSearchableRecentUser
  extends IContactSearchable
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public RecentUser a;
  private FriendManager jdField_a_of_type_ComTencentMobileqqModelFriendManager;
  public String a;
  private List jdField_a_of_type_JavaUtilList;
  public String b;
  private String c;
  private String d;
  
  @SuppressLint({"DefaultLocale"})
  public ContactsSearchableRecentUser(Context paramContext, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, long paramLong1, long paramLong2, Map paramMap)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.A = paramLong2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramRecentUser.displayName;
    a(paramRecentUser, paramMap);
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    this.b = this.jdField_a_of_type_JavaLangString;
    ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.toLowerCase();
    this.c = ChnToSpell.a(this.jdField_a_of_type_JavaLangString, 1).toLowerCase();
    this.d = ChnToSpell.a(this.jdField_a_of_type_JavaLangString, 2).toLowerCase();
    a();
  }
  
  public ContactsSearchableRecentUser(Context paramContext, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, long paramLong, Map paramMap)
  {
    this(paramContext, paramQQAppInterface, paramRecentUser, 0L, paramLong, paramMap);
  }
  
  private void a(RecentUser paramRecentUser, Map paramMap)
  {
    this.y = paramRecentUser.lastmsgtime;
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = paramRecentUser;
    this.jdField_a_of_type_ComTencentMobileqqModelFriendManager = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8));
    if (this.jdField_a_of_type_ComTencentMobileqqModelFriendManager == null) {}
    Object localObject;
    label705:
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            localObject = paramRecentUser.uin;
            i = paramRecentUser.type;
            switch (i)
            {
            default: 
              return;
            case 0: 
            case 1000: 
            case 1001: 
            case 1003: 
            case 1004: 
            case 1005: 
            case 1009: 
            case 1010: 
            case 1020: 
            case 1023: 
            case 1024: 
            case 1025: 
              paramMap = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c((String)localObject);
              if (!String.valueOf(AppConstants.ae).equals(localObject)) {
                break;
              }
              this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131367460);
              return;
            case 6000: 
              this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131362046);
              return;
            case 1008: 
              paramRecentUser = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
            }
          } while (paramRecentUser == null);
          paramRecentUser = paramRecentUser.a((String)localObject);
          if (paramRecentUser != null) {
            this.jdField_a_of_type_JavaLangString = paramRecentUser.name;
          }
          this.y = 0L;
          return;
          paramRecentUser = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(Long.parseLong((String)localObject));
          if ((paramRecentUser != null) && (paramRecentUser.name != null))
          {
            this.jdField_a_of_type_JavaLangString = paramRecentUser.name;
            return;
          }
          this.jdField_a_of_type_JavaLangString = ((String)localObject);
          return;
          paramRecentUser = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
          paramMap = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).c((String)localObject);
          if (paramMap != null)
          {
            this.jdField_a_of_type_JavaLangString = paramMap.name;
            return;
          }
          if (paramRecentUser != null)
          {
            this.jdField_a_of_type_JavaLangString = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, true);
            return;
          }
          this.jdField_a_of_type_JavaLangString = "";
          return;
          if (String.valueOf(AppConstants.ag).equals(localObject))
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367458);
            return;
          }
          if (String.valueOf(AppConstants.af).equals(localObject))
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131366652);
            return;
          }
          if (String.valueOf(9974L).equals(localObject))
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131369715);
            return;
          }
          if (String.valueOf(AppConstants.V).equals(localObject))
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131366665);
            return;
          }
          if (AppConstants.ac.equals(localObject))
          {
            this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367499);
            return;
          }
          if (i == 1000)
          {
            paramMap = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.g(paramRecentUser.troopUin);
            this.jdField_a_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, paramMap, paramRecentUser.troopUin, true);
            return;
          }
          if (i == 1004)
          {
            this.jdField_a_of_type_JavaLangString = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser.troopUin, paramRecentUser.uin);
            return;
          }
          if (paramMap != null) {
            if (!TextUtils.isEmpty(paramMap.remark)) {
              paramRecentUser = paramMap.remark;
            }
          }
          for (this.jdField_a_of_type_JavaLangString = paramRecentUser; (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.equals(localObject)); this.jdField_a_of_type_JavaLangString = paramRecentUser.displayName)
          {
            this.jdField_a_of_type_JavaLangString = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, true);
            return;
            paramRecentUser = paramMap.name;
            break label705;
          }
          paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a((String)localObject);
        } while (paramRecentUser == null);
        this.jdField_a_of_type_JavaLangString = paramRecentUser.troopname;
        return;
        paramRecentUser = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.a((String)localObject);
        this.jdField_a_of_type_JavaLangString = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
        if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals(""))) {
          this.jdField_a_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_AndroidContentContext, paramRecentUser);
        }
        this.jdField_a_of_type_JavaUtilList = ((List)paramMap.get(localObject));
        return;
      } while (!String.valueOf(AppConstants.ab).equals(localObject));
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131366037);
      return;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131367701);
      return;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363628);
      this.y = 0L;
      return;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363645);
      this.y = 0L;
      return;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131368649);
    } while (AppConstants.W.equals(localObject));
    paramRecentUser = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if (paramRecentUser != null) {}
    for (paramRecentUser = paramRecentUser.a((String)localObject);; paramRecentUser = null)
    {
      if (paramRecentUser != null) {}
      for (paramRecentUser = paramRecentUser.subname; !TextUtils.isEmpty(paramRecentUser); paramRecentUser = null)
      {
        paramMap = this.jdField_a_of_type_ComTencentMobileqqModelFriendManager.c(paramRecentUser);
        if (paramMap != null) {
          if (!TextUtils.isEmpty(paramMap.remark)) {
            paramMap = paramMap.remark;
          }
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramMap))
          {
            localObject = paramMap;
            if (!paramMap.equals(paramRecentUser)) {}
          }
          else
          {
            localObject = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentUser, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e);
            paramMap = paramRecentUser;
            if (localObject != null)
            {
              paramMap = paramRecentUser;
              if (((String)localObject).length() > 0) {
                paramMap = (Map)localObject;
              }
            }
            localObject = paramMap;
          }
          this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + " ( " + (String)localObject + " ) ");
          return;
          paramMap = paramMap.name;
          continue;
          paramMap = paramRecentUser;
        }
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131369374);
        return;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131369423);
        return;
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
    label171:
    label428:
    label444:
    label580:
    label600:
    label612:
    label746:
    label758:
    label892:
    label1150:
    for (;;)
    {
      long l;
      int i;
      int j;
      if (localIterator.hasNext())
      {
        Object localObject = (DiscussionMemberInfo)localIterator.next();
        String str1 = ((DiscussionMemberInfo)localObject).inteRemark;
        String str2 = ChnToSpell.a(str1, 1).toLowerCase();
        String str3 = ChnToSpell.a(str1, 2).toLowerCase();
        if ((str1 != null) && (str1.length() != 0))
        {
          if ((!str1.equals(paramString)) && ((str2 == null) || (!str2.equals(paramString))) && ((str3 == null) || (!str3.equals(paramString)))) {
            break label580;
          }
          if ((str1.equals(paramString)) || (str1.equals(str2))) {
            break label568;
          }
          l = 1125899906842624L + 4503599627370496L;
          if (this.z < l) {
            this.z = l;
          }
        }
        str1 = ((DiscussionMemberInfo)localObject).memberName;
        str2 = ChnToSpell.a(str1, 1).toLowerCase();
        str3 = ChnToSpell.a(str1, 2).toLowerCase();
        if ((str1 != null) && (str1.length() != 0))
        {
          if ((!str1.equals(paramString)) && ((str2 == null) || (!str2.equals(paramString))) && ((str3 == null) || (!str3.equals(paramString)))) {
            break label726;
          }
          if ((str1.equals(paramString)) || (str1.equals(str2))) {
            break label714;
          }
          l = 1125899906842624L + 4503599627370496L;
          if (this.z < l) {
            this.z = l;
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
            break label872;
          }
          if ((str1.equals(paramString)) || (str1.equals(str2))) {
            break label860;
          }
          l = 1125899906842624L + 4503599627370496L;
          if (this.z < l) {
            this.z = l;
          }
        }
        if (!TextUtils.isEmpty(((Friends)localObject).name))
        {
          localObject = ((Friends)localObject).name;
          str1 = ChnToSpell.a((String)localObject, 1).toLowerCase();
          str2 = ChnToSpell.a((String)localObject, 2).toLowerCase();
          if ((!((String)localObject).equals(paramString)) && ((str1 == null) || (!str1.equals(paramString))) && ((str2 == null) || (!str2.equals(paramString)))) {
            break label1018;
          }
          if ((((String)localObject).equals(paramString)) || (((String)localObject).equals(str1))) {
            break label1006;
          }
        }
        for (l = 1125899906842624L + 4503599627370496L;; l = 1125899906842624L + 9007199254740992L)
        {
          if (this.z >= l) {
            break label1016;
          }
          this.z = l;
          break;
          l = 1125899906842624L + 9007199254740992L;
          break label155;
          k = str1.indexOf(paramString);
          if (str2 != null)
          {
            i = str2.indexOf(paramString);
            if (str3 == null) {
              break label690;
            }
            j = str3.indexOf(paramString);
            if ((k < 0) && (i < 0) && (j < 0)) {
              break label693;
            }
            if ((k != 0) && (i != 0) && (j != 0)) {
              break label695;
            }
            l = 562949953421312L;
            if ((k >= 0) || (str1.equals(str2))) {
              break label703;
            }
          }
          for (l += 4503599627370496L;; l += 9007199254740992L)
          {
            if (this.z >= l) {
              break label712;
            }
            this.z = l;
            break;
            i = -1;
            break label600;
            j = -1;
            break label612;
            break;
            l = 281474976710656L;
            break label643;
          }
          break label171;
          l = 1125899906842624L + 9007199254740992L;
          break label278;
          k = str1.indexOf(paramString);
          if (str2 != null)
          {
            i = str2.indexOf(paramString);
            if (str3 == null) {
              break label836;
            }
            j = str3.indexOf(paramString);
            if ((k < 0) && (i < 0) && (j < 0)) {
              break label839;
            }
            if ((k != 0) && (i != 0) && (j != 0)) {
              break label841;
            }
            l = 562949953421312L;
            if ((k >= 0) || (str1.equals(str2))) {
              break label849;
            }
          }
          for (l += 4503599627370496L;; l += 9007199254740992L)
          {
            if (this.z >= l) {
              break label858;
            }
            this.z = l;
            break;
            i = -1;
            break label746;
            j = -1;
            break label758;
            break;
            l = 281474976710656L;
            break label789;
          }
          break label294;
          l = 1125899906842624L + 9007199254740992L;
          break label428;
          k = str1.indexOf(paramString);
          if (str2 != null)
          {
            i = str2.indexOf(paramString);
            if (str3 == null) {
              break label982;
            }
            j = str3.indexOf(paramString);
            if ((k < 0) && (i < 0) && (j < 0)) {
              break label985;
            }
            if ((k != 0) && (i != 0) && (j != 0)) {
              break label987;
            }
            l = 562949953421312L;
            if ((k >= 0) || (str1.equals(str2))) {
              break label995;
            }
          }
          for (l += 4503599627370496L;; l += 9007199254740992L)
          {
            if (this.z >= l) {
              break label1004;
            }
            this.z = l;
            break label444;
            break;
            i = -1;
            break label892;
            j = -1;
            break label904;
            break label444;
            l = 281474976710656L;
            break label935;
          }
          break label444;
        }
        continue;
        int k = ((String)localObject).indexOf(paramString);
        if (str1 == null) {
          break label1123;
        }
        i = str1.indexOf(paramString);
        if (str2 == null) {
          break label1128;
        }
        j = str2.indexOf(paramString);
        if ((k < 0) && (i < 0) && (j < 0)) {
          break label1131;
        }
        if ((k != 0) && (i != 0) && (j != 0)) {
          break label1133;
        }
        l = 562949953421312L;
        if ((k >= 0) || (((String)localObject).equals(str1))) {
          break label1141;
        }
      }
      for (l += 4503599627370496L;; l += 9007199254740992L)
      {
        if (this.z >= l) {
          break label1150;
        }
        this.z = l;
        break label26;
        break;
        i = -1;
        break label1038;
        j = -1;
        break label1050;
        break label26;
        l = 281474976710656L;
        break label1081;
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
      l = ContactSearchableDiscussion.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqModelFriendManager, paramString);
    } while (l == -1L);
    this.z = (l + 9007199254740992L + this.A);
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public RecentUser a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  }
  
  public String a()
  {
    return this.b;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    int j = -1;
    paramString = paramString.toLowerCase();
    long l;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() != 0)) {
      if ((this.jdField_a_of_type_JavaLangString.equals(paramString)) || ((this.c != null) && (this.c.equals(paramString))) || ((this.d != null) && (this.d.equals(paramString)))) {
        if ((!this.jdField_a_of_type_JavaLangString.equals(paramString)) && (!this.jdField_a_of_type_JavaLangString.equals(this.c))) {
          l = 1125899906842624L + 4503599627370496L;
        }
      }
    }
    for (;;)
    {
      this.z = l;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser != null) && (3000 == this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)) {
        b(paramString);
      }
      if (this.z != -9223372036854775808L)
      {
        this.z += this.A;
        return;
        l = 1125899906842624L + 9007199254740992L;
        continue;
        int k = this.jdField_a_of_type_JavaLangString.indexOf(paramString);
        int i;
        if (this.c != null)
        {
          i = this.c.indexOf(paramString);
          label199:
          if (this.d != null) {
            j = this.d.indexOf(paramString);
          }
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label306;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label281;
          }
        }
        label281:
        for (l = 562949953421312L;; l = 281474976710656L)
        {
          if ((k >= 0) || (this.jdField_a_of_type_JavaLangString.equals(this.c))) {
            break label289;
          }
          l += 4503599627370496L;
          break;
          i = -1;
          break label199;
        }
        label289:
        l += 9007199254740992L;
      }
      else
      {
        c(paramString);
        return;
      }
      label306:
      l = -9223372036854775808L;
    }
  }
  
  public int b()
  {
    return ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin).first).intValue();
  }
  
  public String b()
  {
    return "会话";
  }
  
  public String c()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactsSearchableRecentUser
 * JD-Core Version:    0.7.0.1
 */