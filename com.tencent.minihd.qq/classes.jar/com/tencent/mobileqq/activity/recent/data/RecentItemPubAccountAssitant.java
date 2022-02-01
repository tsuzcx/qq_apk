package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantManager;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.ArrayList;
import java.util.List;

public class RecentItemPubAccountAssitant
  extends RecentUserBaseData
{
  public RecentItemPubAccountAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.A = 0;
  }
  
  public void a(Context paramContext)
  {
    if (this.B > 0)
    {
      this.jdField_c_of_type_JavaLangCharSequence = String.format(paramContext.getString(2131363644), new Object[] { Integer.valueOf(this.B) });
      this.E = paramContext.getResources().getColor(2131427997);
      return;
    }
    this.jdField_c_of_type_JavaLangCharSequence = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.z = 0;
    PubAccountAssistantData localPubAccountAssistantData = PubAccountAssistantManager.a().a(paramQQAppInterface);
    if ((localPubAccountAssistantData == null) || (TextUtils.isEmpty(localPubAccountAssistantData.mUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(localPubAccountAssistantData.mUin, 1008);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
    {
      this.z = 4;
      return;
    }
    this.z = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363628);
    }
    MsgSummary localMsgSummary = null;
    Object localObject2 = null;
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    Object localObject1 = localMsgSummary;
    if (localQQMessageFacade != null)
    {
      PubAccountAssistantManager localPubAccountAssistantManager = PubAccountAssistantManager.a();
      PubAccountAssistantData localPubAccountAssistantData = localPubAccountAssistantManager.a(paramQQAppInterface);
      localObject2 = localPubAccountAssistantManager;
      localObject1 = localMsgSummary;
      if (localPubAccountAssistantData != null)
      {
        localObject1 = localQQMessageFacade.a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType);
        localObject2 = localPubAccountAssistantManager;
      }
    }
    localMsgSummary = a();
    if (localObject1 != null)
    {
      this.B = ((PubAccountAssistantManager)localObject2).a(localQQMessageFacade);
      this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = PubAccountAssistantManager.a().a(((QQMessageFacade.Message)localObject1).frienduin);
      if (localObject1 != null)
      {
        MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, (String)localObject2, true, false);
        int i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == -3006) || (i == -5004))
        {
          localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
          localMsgSummary.b = "";
          localObject2 = XMLMessageUtils.a((MessageRecord)localObject1);
          if ((localObject2 != null) && (((PAMessage)localObject2).items != null) && (((PAMessage)localObject2).items.size() != 0)) {
            break label345;
          }
          a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        }
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(localMsgSummary.b)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
      {
        localMsgSummary.jdField_a_of_type_JavaLangCharSequence = null;
        localMsgSummary.b = paramContext.getString(2131363637);
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, localMsgSummary);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      a(paramContext);
      if (this.jdField_a_of_type_Long == 0L) {
        break;
      }
      this.jdField_c_of_type_JavaLangString = String.format("进入服务助手界面，有%d条未读消息。", new Object[] { Integer.valueOf(this.B) });
      return;
      label345:
      localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
      if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null)) {
        localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
      }
      for (;;)
      {
        localMsgSummary.b = ((CharSequence)localObject1);
        break;
      }
      this.B = 0;
      this.jdField_a_of_type_Long = 0L;
    }
    this.jdField_c_of_type_JavaLangString = paramContext.getString(2131363637);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    if (this.B > 0) {
      this.b = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.jdField_a_of_type_Boolean = false;
      paramMsgSummary.d = null;
    }
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {}
    PubAccountAssistantData localPubAccountAssistantData;
    do
    {
      do
      {
        return;
        localPubAccountAssistantData = PubAccountAssistantManager.a().a(paramQQAppInterface);
      } while ((localPubAccountAssistantData == null) || (TextUtils.isEmpty(localPubAccountAssistantData.mUin)) || (this.jdField_a_of_type_Long >= localPubAccountAssistantData.mLastDraftTime));
      localObject = ((QQMessageFacade)localObject).a(localPubAccountAssistantData.mUin, 1008);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.jdField_a_of_type_Boolean = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = ContactUtils.a(paramQQAppInterface, localPubAccountAssistantData.mUin, true);
    paramMsgSummary.d = new QQText(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPubAccountAssitant
 * JD-Core Version:    0.7.0.1
 */