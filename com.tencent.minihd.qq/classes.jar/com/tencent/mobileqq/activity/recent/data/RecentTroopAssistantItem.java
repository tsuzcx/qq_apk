package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentTroopAssistantItem
  extends RecentBaseData
{
  public static final int K = 0;
  public static final int L = 1;
  public static final int M = 4;
  public int J;
  private TroopAssistantData a;
  
  public RecentTroopAssistantItem(TroopAssistantData paramTroopAssistantData)
  {
    if (paramTroopAssistantData == null) {
      throw new NullPointerException("TroopAssistantData is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData = paramTroopAssistantData;
    this.A = 3;
  }
  
  public int a()
  {
    return 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.lastmsgtime;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.troopUin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    String str = a();
    int j = a();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a(str, j);; localMessage = null)
    {
      label90:
      int i;
      if (localMessage != null)
      {
        this.jdField_a_of_type_Long = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.B = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
          if ((TroopNotificationHelper.a(str)) || (TroopNotificationHelper.d(str)))
          {
            this.jdField_c_of_type_JavaLangCharSequence = BaseApplicationImpl.getContext().getString(2131366202);
            this.E = paramContext.getResources().getColor(2131427997);
          }
          i = this.G & 0xFFFFF0FF;
          localObject1 = (FriendManager)paramQQAppInterface.getManager(8);
          if ((localObject1 == null) || (!((FriendManager)localObject1).f(str))) {
            break label443;
          }
          localObject1 = ((FriendManager)localObject1).a(str);
          if (localObject1 == null) {
            break label437;
          }
        }
      }
      Object localObject3;
      label437:
      for (localObject1 = ((OpenTroopInfo)localObject1).troopName;; localObject1 = null)
      {
        localObject3 = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject2;
        this.G = i;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label499;
        }
        this.jdField_a_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, str, true);
        label231:
        localObject3 = a();
        if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
          localMessage.nickName = localMessage.senderuin;
        }
        a(localMessage, j, paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        if ((TextUtils.isEmpty(((MsgSummary)localObject3).b)) && (TextUtils.isEmpty(((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          ((MsgSummary)localObject3).b = ((CharSequence)localObject2);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, (MsgSummary)localObject3);
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        this.jdField_c_of_type_JavaLangString = String.format("与%s群的会话，有%d条未读消息", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.B) });
        if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) || (localMessage == null) || (localObject3 == null) || (!AnonymousChatHelper.a(localMessage))) {
          break;
        }
        this.b = ((MsgSummary)localObject3).a(paramContext, paramContext.getResources().getString(2131363837), -1);
        return;
        this.B = 0;
        break label90;
        this.jdField_a_of_type_Long = 0L;
        this.B = 0;
        break label90;
      }
      label443:
      if (localObject1 != null) {}
      for (localObject1 = ((FriendManager)localObject1).a(str);; localObject1 = null)
      {
        if (localObject1 != null)
        {
          localObject3 = ((TroopInfo)localObject1).troopname;
          localObject2 = ((TroopInfo)localObject1).troopmemo;
        }
        for (localObject1 = localObject3;; localObject1 = null)
        {
          i |= 0x100;
          localObject3 = localObject1;
          localObject1 = localObject2;
          break;
          label499:
          this.jdField_a_of_type_JavaLangString = ((String)localObject3);
          break label231;
        }
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.lastdrafttime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem
 * JD-Core Version:    0.7.0.1
 */