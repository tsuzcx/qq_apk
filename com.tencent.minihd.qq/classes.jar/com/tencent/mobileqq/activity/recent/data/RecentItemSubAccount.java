package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemSubAccount
  extends RecentUserBaseData
{
  public RecentItemSubAccount(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.A = 1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    MsgSummary localMsgSummary = a();
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131368649);
    Object localObject1 = SubAccountControll.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
    if (localObject1 != null)
    {
      localMsgSummary.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      localMsgSummary.g = 1;
    }
    localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (this.B = ((ConversationFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; this.B = 7000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "RecentItemSubAccount.update mUser.uin=" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin + " mUser.type=" + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type + " mUnreadNum=" + this.B);
      }
      if (!AppConstants.W.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_a_of_type_Long = a();
      this.G |= 0x1;
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      this.c = String.format("%s%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangCharSequence });
      return;
      this.B = 0;
    }
    long l1 = ((SubAccountManager)paramQQAppInterface.getManager(59)).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
    long l2 = a();
    if (a() == 9223372036854775804L)
    {
      label288:
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_a_of_type_Long = l1;
      localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
      if (localObject1 == null) {
        break label587;
      }
    }
    label579:
    label587:
    for (localObject1 = ((FriendManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
    {
      Object localObject2;
      label352:
      int i;
      if ((localObject1 != null) && (((Friends)localObject1).name != null))
      {
        localObject2 = ((Friends)localObject1).name;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {}
        }
        else
        {
          String str = ContactUtils.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = str;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
        }
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + " ( " + (String)localObject2 + " ) ");
        if ((paramQQAppInterface.e) && (paramQQAppInterface.a != null) && (paramQQAppInterface.a.b()))
        {
          localObject1 = (FriendListHandler)paramQQAppInterface.a(1);
          if (localObject1 != null) {
            ((FriendListHandler)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          }
          paramQQAppInterface.e = false;
        }
        i = this.G & 0xFFFFFF0F;
        if (a() != 9223372036854775804L) {
          break label579;
        }
        i |= 0x20;
      }
      for (;;)
      {
        this.G = i;
        break;
        l1 = Math.max(l2, l1);
        break label288;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
        break label352;
        i |= 0x10;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount
 * JD-Core Version:    0.7.0.1
 */