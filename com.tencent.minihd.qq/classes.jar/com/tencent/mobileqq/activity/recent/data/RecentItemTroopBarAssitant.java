package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.ArrayList;
import java.util.List;

public class RecentItemTroopBarAssitant
  extends RecentUserBaseData
{
  public RecentItemTroopBarAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.A = 3;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.b = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.z = 0;
    TroopBarData localTroopBarData = TroopBarAssistantManager.a().a(paramQQAppInterface);
    if ((localTroopBarData == null) || (TextUtils.isEmpty(localTroopBarData.mUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(localTroopBarData.mUin, 1008);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
    {
      this.z = 4;
      return;
    }
    this.z = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    label327:
    do
    {
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = paramContext.getString(2131363645);
      }
      MsgSummary localMsgSummary = null;
      Object localObject2 = null;
      QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
      Object localObject1 = localMsgSummary;
      if (localQQMessageFacade != null)
      {
        TroopBarAssistantManager localTroopBarAssistantManager = TroopBarAssistantManager.a();
        TroopBarData localTroopBarData = localTroopBarAssistantManager.a(paramQQAppInterface);
        localObject2 = localTroopBarAssistantManager;
        localObject1 = localMsgSummary;
        if (localTroopBarData != null)
        {
          localObject1 = localQQMessageFacade.a(localTroopBarData.mUin, 1008);
          localObject2 = localTroopBarAssistantManager;
        }
      }
      localMsgSummary = a();
      if (localObject1 != null)
      {
        this.B = ((TroopBarAssistantManager)localObject2).a(localQQMessageFacade);
        this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
        localObject2 = ((TroopBarAssistantManager)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin);
        if (localObject1 != null)
        {
          MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, (String)localObject2, true, false);
          int i = ((QQMessageFacade.Message)localObject1).msgtype;
          if ((i == -3006) || (i == -5004))
          {
            localMsgSummary.c = "";
            localMsgSummary.b = "";
            localObject2 = XMLMessageUtils.a((MessageRecord)localObject1);
            if ((localObject2 != null) && (((PAMessage)localObject2).items != null) && (((PAMessage)localObject2).items.size() != 0)) {
              break label327;
            }
            a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          }
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(localMsgSummary.b)) && (TextUtils.isEmpty(localMsgSummary.c)))
        {
          localMsgSummary.jdField_a_of_type_JavaLangCharSequence = null;
          localMsgSummary.b = paramContext.getString(2131363646);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        a(paramContext);
        if (this.B != 0) {
          break;
        }
        this.c = paramContext.getString(2131363650);
        return;
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
      if (this.B == 1)
      {
        this.c = String.format(paramContext.getString(2131363649), new Object[] { "一" });
        return;
      }
      if (this.B == 2)
      {
        this.c = String.format(paramContext.getString(2131363649), new Object[] { "两" });
        return;
      }
    } while (this.B <= 0);
    this.c = String.format(paramContext.getString(2131363649), new Object[] { Integer.toString(this.B) });
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
    TroopBarData localTroopBarData;
    do
    {
      do
      {
        return;
        localTroopBarData = TroopBarAssistantManager.a().a(paramQQAppInterface);
      } while ((localTroopBarData == null) || (TextUtils.isEmpty(localTroopBarData.mUin)) || (this.jdField_a_of_type_Long >= localTroopBarData.mLastDraftTime));
      localObject = ((QQMessageFacade)localObject).a(localTroopBarData.mUin, 1008);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.jdField_a_of_type_Boolean = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = ContactUtils.a(paramQQAppInterface, localTroopBarData.mUin, true);
    paramMsgSummary.d = new QQText(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopBarAssitant
 * JD-Core Version:    0.7.0.1
 */