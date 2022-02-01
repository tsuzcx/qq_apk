package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;

public class RecentMsgBoxItem
  extends RecentBaseData
{
  MessageRecord a;
  
  public RecentMsgBoxItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = paramQQAppInterface.a();
    if (localObject2 != null) {
      localObject1 = ((QQMessageFacade)localObject2).a(a(), a());
    }
    MsgSummary localMsgSummary;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = paramQQAppInterface.a();
      if ((localObject2 != null) && (localObject1 != null))
      {
        this.B = ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
        if (MsgProxyUtils.b((MessageRecord)localObject1)) {
          this.A = 3;
        }
        localMsgSummary = a();
        a((QQMessageFacade.Message)localObject1, a(), paramQQAppInterface, paramContext, localMsgSummary);
        localObject2 = ContactUtils.m(paramQQAppInterface, a());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ContactUtils.b(paramQQAppInterface, a(), false);
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = a();
        }
        this.jdField_a_of_type_JavaLangString = ((String)localObject2);
        if (a() != 7100) {
          break label222;
        }
      }
    }
    label222:
    for (this.C = 2130838652;; this.C = 0)
    {
      a(paramQQAppInterface);
      a(paramQQAppInterface, localMsgSummary);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      return;
      this.B = 0;
      break;
      this.B = 0;
      this.jdField_a_of_type_Long = 0L;
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.a = false;
      paramMsgSummary.d = null;
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(a(), a());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.jdField_a_of_type_Long > l);
    this.jdField_a_of_type_Long = l;
    paramMsgSummary.a = true;
    paramMsgSummary.d = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public long b()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */