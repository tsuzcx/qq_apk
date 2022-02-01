package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentCallItem
  extends RecentBaseData
{
  public static final int J = 0;
  public static final int K = 1;
  public static final int L = 2;
  public static final int M = 3;
  public static final int N = 4;
  public static final int O = 5;
  public static final int P = 6;
  private static final String g = RecentCallItem.class.getSimpleName();
  protected QCallRecent a;
  public long b;
  
  public RecentCallItem(QCallRecent paramQCallRecent)
  {
    this.jdField_b_of_type_Long = 0L;
    if (paramQCallRecent == null) {
      throw new NullPointerException("call is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = paramQCallRecent;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallTime;
  }
  
  public QCallRecent a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    PhoneContactManager localPhoneContactManager = null;
    String str1 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
    FriendManager localFriendManager = (FriendManager)paramQQAppInterface.getManager(8);
    Friends localFriends;
    if (localFriendManager == null) {
      localFriends = null;
    }
    label52:
    int i;
    switch (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type)
    {
    default: 
      this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str2, true);
    case 1008: 
    case 1006: 
    case 1021: 
    case 0: 
    case 8: 
    case 1000: 
    case 1001: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1009: 
    case 1020: 
    case 1022: 
    case 1023: 
    case 1024: 
    case 1025: 
    case 4000: 
      for (;;)
      {
        this.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallMsg;
        if (localFriends == null) {
          break label1293;
        }
        i = localFriends.getNetWorkType();
        this.z = i;
        if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type != 3000) {
          break label1345;
        }
        i = j;
        switch (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface))
        {
        default: 
          if ((this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.time <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())) {
            break;
          }
          i = 1;
        case 2: 
          this.C = i;
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallTime;
          if ((this.jdField_a_of_type_Long == 0L) && (QLog.isColorLevel())) {
            QLog.d(g, 2, "zsw RecentCallItem| mDisplayTime = " + this.jdField_a_of_type_Long);
          }
          if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
            this.jdField_b_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type != 3000) {
            this.B = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.missedCallCount;
          }
          if (QLog.isDevelopLevel()) {
            QLog.i(g, 4, "update mAuthenIconId=" + this.C + ";mUnreadNum=" + this.B + ";mStatus=" + this.z);
          }
          i = this.G & 0xFFFF0FFF;
          if (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo()) {
            break label1452;
          }
          i |= 0x3000;
          this.G = i;
          paramQQAppInterface = new StringBuilder("和");
          paramQQAppInterface.append(this.jdField_a_of_type_JavaLangString);
          paramQQAppInterface.append("的");
          if ((!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isMissedCall()) || (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())) {
            break label1461;
          }
          paramQQAppInterface.append("未接");
          if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type != 3000) {
            break label1493;
          }
          paramQQAppInterface.append("群组电话，点击进入通话详情页面 按钮");
          this.c = paramQQAppInterface.toString();
          return;
          localFriends = localFriendManager.c(str2);
          break label52;
          localObject1 = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
          paramContext = str1;
          if (localObject1 != null) {
            paramContext = ((PublicAccountDataManager)localObject1).a(str2);
          }
          if (paramContext != null)
          {
            this.jdField_a_of_type_JavaLangString = paramContext.name;
            continue;
            str1 = ContactUtils.d(paramQQAppInterface, str2);
            localPhoneContactManager = (PhoneContactManager)paramQQAppInterface.getManager(10);
            paramContext = (Context)localObject1;
            if (localPhoneContactManager != null) {
              paramContext = localPhoneContactManager.c(str2);
            }
            if (paramContext != null)
            {
              this.jdField_a_of_type_JavaLangString = paramContext.name;
            }
            else if (str1 != null)
            {
              this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str1, true);
            }
            else
            {
              this.jdField_a_of_type_JavaLangString = str2;
              continue;
              paramContext = (CircleManager)paramQQAppInterface.getManager(34);
              localObject1 = paramContext.a(str2);
              if ((paramContext != null) && (localObject1 != null))
              {
                this.jdField_a_of_type_JavaLangString = paramContext.a((CircleBuddy)localObject1);
              }
              else
              {
                this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str2, true);
                continue;
                if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type == 8)
                {
                  this.H = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.extraType;
                  this.f = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.bindId;
                  this.I = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.bindType;
                }
                if (AppConstants.ae.equals(str2))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131367460);
                }
                else if (AppConstants.ag.equals(str2))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131367458);
                }
                else if (AppConstants.af.equals(str2))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131366652);
                }
                else if (AppConstants.V.equals(str2))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131366665);
                }
                else if (AppConstants.ac.equals(str2))
                {
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131367499);
                }
                else if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type == 1000)
                {
                  if (localFriendManager != null) {
                    this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, str2, localFriendManager.g(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.troopUin), this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.troopUin, true);
                  }
                }
                else
                {
                  if (localFriends != null) {
                    if (!TextUtils.isEmpty(localFriends.remark)) {
                      paramContext = localFriends.remark;
                    }
                  }
                  for (this.jdField_a_of_type_JavaLangString = paramContext; (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.equals(str2)); this.jdField_a_of_type_JavaLangString = "")
                  {
                    this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str2, true);
                    break;
                    paramContext = localFriends.name;
                    break label1062;
                  }
                  this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363729);
                }
              }
            }
          }
          break;
        }
      }
    case 3000: 
      label253:
      this.jdField_a_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, str2);
      label336:
      label599:
      label619:
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject1 = localObject2;
        if (localFriendManager != null) {
          localObject1 = localFriendManager.a(str2);
        }
        this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramContext, (DiscussionInfo)localObject1);
      }
      label541:
      label1062:
      if (localFriendManager != null)
      {
        i = localFriendManager.c(str2);
        if (i <= 0) {
          break;
        }
      }
      break;
    }
    for (paramContext = "(" + i + ")";; paramContext = "")
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramContext;
      break;
      localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
      paramContext = localPhoneContactManager;
      if (localObject1 != null) {
        paramContext = ((PhoneContactManager)localObject1).b(str2);
      }
      if (paramContext != null)
      {
        this.jdField_a_of_type_JavaLangString = paramContext.name;
        break;
      }
      this.jdField_a_of_type_JavaLangString = str2;
      break;
      label1293:
      i = 0;
      break label253;
      i = 3;
      break label336;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.time > 0L) && (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend()))
      {
        i = 1;
        break label336;
      }
      i = 2;
      break label336;
      i = 2;
      break label336;
      i = 2;
      break label336;
      label1345:
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface) == 5)
      {
        i = 4;
        break label336;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface) == 6)
      {
        i = 5;
        break label336;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.getState(paramQQAppInterface) == 7)
      {
        i = 6;
        break label336;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isMissedCall()) || (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isLastCallRealMissed))
      {
        i = j;
        if (!this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend()) {
          break label336;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())
      {
        i = 2;
        break label336;
      }
      i = 1;
      break label336;
      label1452:
      i |= 0x4000;
      break label541;
      label1461:
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isSend())
      {
        paramQQAppInterface.append("已拨");
        break label599;
      }
      paramQQAppInterface.append("已接");
      break label599;
      label1493:
      if (this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo())
      {
        paramQQAppInterface.append("视频电话，点击进入通话详情页面 按钮");
        break label619;
      }
      paramQQAppInterface.append("QQ电话，点击进入通话详情页面 按钮");
      break label619;
    }
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    if ((paramQCallRecent != null) && (paramQCallRecent.uin.equals(this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin))) {
      this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent = paramQCallRecent;
    }
  }
  
  public long b()
  {
    return 0L;
  }
  
  public int c()
  {
    return this.z;
  }
  
  public int d()
  {
    return this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentCallItem
 * JD-Core Version:    0.7.0.1
 */