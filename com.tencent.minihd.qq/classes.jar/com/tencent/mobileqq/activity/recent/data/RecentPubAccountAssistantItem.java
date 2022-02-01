package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import java.util.List;

public class RecentPubAccountAssistantItem
  extends RecentBaseData
{
  private PubAccountAssistantData a;
  
  public RecentPubAccountAssistantItem(PubAccountAssistantData paramPubAccountAssistantData)
  {
    if (paramPubAccountAssistantData == null) {
      throw new NullPointerException("PubAccountAssistantData is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataPubAccountAssistantData = paramPubAccountAssistantData;
    this.A = 3;
  }
  
  public int a()
  {
    return PubAccountAssistantManager.a().a(a());
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPubAccountAssistantData.mLastMsgTime;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPubAccountAssistantData.mUin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    String str = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject3 = a();
    int i = a();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject1).a((String)localObject3, i);; localMessage = null)
    {
      Object localObject2;
      if (localMessage != null)
      {
        this.jdField_a_of_type_Long = localMessage.time;
        localObject1 = paramQQAppInterface.a();
        if (localObject1 != null)
        {
          this.B = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
          localObject1 = (PublicAccountDataManager)paramQQAppInterface.getManager(54);
          if (localObject1 == null) {
            break label476;
          }
          localObject2 = ((PublicAccountDataManager)localObject1).a((String)localObject3);
          if (localObject2 == null) {
            break label476;
          }
          localObject1 = ((PublicAccountInfo)localObject2).name;
          str = ((PublicAccountInfo)localObject2).summary;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = localObject3;
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject2);
        localObject2 = a();
        if (localMessage != null)
        {
          int j = localMessage.msgtype;
          if ((j != -3006) && (j != -5004)) {
            a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          }
        }
        else
        {
          label196:
          if ((TextUtils.isEmpty(((MsgSummary)localObject2).b)) && (TextUtils.isEmpty(((MsgSummary)localObject2).c)))
          {
            if (str != null) {
              break label473;
            }
            str = "";
          }
        }
        label473:
        for (;;)
        {
          ((MsgSummary)localObject2).b = str;
          a(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject2);
          a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
          this.c = String.format("与%s的会话，有%d条未读消息", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.B) });
          return;
          this.B = 0;
          break;
          this.jdField_a_of_type_Long = 0L;
          this.B = 0;
          break;
          ((MsgSummary)localObject2).b = "";
          localObject3 = XMLMessageUtils.a(localMessage);
          if ((localObject3 == null) || (((PAMessage)localObject3).items == null) || (((PAMessage)localObject3).items.size() == 0))
          {
            a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
            break label196;
          }
          localObject1 = ((PAMessage.Item)((PAMessage)localObject3).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject3).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList != null)) {
            localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList.get(0);
          }
          for (;;)
          {
            ((MsgSummary)localObject2).b = ((CharSequence)localObject1);
            break;
          }
        }
        label476:
        localObject1 = null;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPubAccountAssistantData.mLastDraftTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem
 * JD-Core Version:    0.7.0.1
 */