package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;

public class RecentItemPcDataLine
  extends RecentUserBaseData
{
  public RecentItemPcDataLine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private CharSequence a(String paramString, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, MsgSummary paramMsgSummary)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = new SpannableStringBuilder();
      if (paramBoolean1)
      {
        paramCharSequence.append("F ");
        paramCharSequence.append(paramString);
      }
    }
    for (paramMsgSummary.g = 0;; paramMsgSummary.g = 1)
    {
      if (!paramBoolean1) {
        break label76;
      }
      paramMsgSummary.f = 2;
      return paramCharSequence;
      if (!paramBoolean2) {
        break;
      }
      paramCharSequence.append("S ");
      break;
    }
    label76:
    if (paramBoolean2)
    {
      paramMsgSummary.f = 1;
      return paramCharSequence;
    }
    paramMsgSummary.f = 0;
    return paramCharSequence;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    QQMessageFacade.Message localMessage = null;
    Object localObject = paramQQAppInterface.a();
    if (localObject != null) {
      localMessage = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
    }
    if (localMessage != null)
    {
      this.jdField_a_of_type_Long = localMessage.time;
      localObject = paramQQAppInterface.a();
      if (localObject != null) {
        this.B = ((ConversationFacade)localObject).a(localMessage.frienduin, localMessage.istroop);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = paramContext.getString(2131362046);
      }
      localObject = a();
      a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, (MsgSummary)localObject);
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject);
      this.c = ("与我的电脑的会话 [有" + this.B + "条未读消息] " + this.b + " " + ((MsgSummary)localObject).b);
      return;
      this.B = 0;
      continue;
      this.B = 0;
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    boolean bool3 = false;
    DataLineHandler localDataLineHandler = (DataLineHandler)paramQQAppInterface.a(8);
    if ((localDataLineHandler != null) && (localDataLineHandler.a()))
    {
      this.jdField_a_of_type_Long = localDataLineHandler.a();
      paramMsgSummary.b = paramContext.getString(2131362127);
    }
    label90:
    label223:
    label253:
    do
    {
      return;
      if ((paramMessage == null) || (paramMessage.msg == null)) {
        break;
      }
      paramQQAppInterface = paramQQAppInterface.a().a().a(paramMessage.msgId);
      boolean bool1;
      boolean bool2;
      if (paramQQAppInterface == null)
      {
        bool1 = false;
        if (paramQQAppInterface != null) {
          break label195;
        }
        bool2 = bool3;
        if (paramMessage.msgtype != -1000) {
          break label353;
        }
        paramQQAppInterface = paramMessage.getMessageText();
        if (paramQQAppInterface == null) {
          break label253;
        }
        if (!bool1) {
          break label223;
        }
        paramMessage = "F " + paramQQAppInterface;
      }
      for (;;)
      {
        paramMsgSummary.b = a(null, bool1, bool2, new QQText(paramMessage, 1, 16), paramMsgSummary);
        return;
        if ((paramQQAppInterface.hasFailed()) && (!paramQQAppInterface.hasSendingOrRecving()) && (!paramQQAppInterface.hasWaiting()))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        bool2 = bool3;
        if (!paramQQAppInterface.isSendFromLocal()) {
          break label90;
        }
        bool2 = bool3;
        if (!paramQQAppInterface.hasSendingOrRecving()) {
          break label90;
        }
        bool2 = true;
        break label90;
        paramMessage = paramQQAppInterface;
        if (bool2) {
          paramMessage = "S " + paramQQAppInterface;
        }
      }
      paramContext = new StringBuffer();
      if (bool1)
      {
        paramContext.append("F ");
        if (paramQQAppInterface == null) {
          break label347;
        }
      }
      for (paramMessage = paramQQAppInterface.toString().trim();; paramMessage = "")
      {
        paramContext.append(paramMessage);
        try
        {
          paramMsgSummary.b = a(null, bool1, bool2, new QQText(paramContext, 1, 16), paramMsgSummary);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
        if (!bool2) {
          break;
        }
        paramContext.append("S ");
        break;
      }
      if (paramMessage.msgtype == -2000)
      {
        paramMsgSummary.b = a(paramContext.getString(2131366789), bool1, bool2, null, paramMsgSummary);
        return;
      }
      if (paramMessage.msgtype == -2005)
      {
        paramMsgSummary.b = a(paramContext.getString(2131367594), bool1, bool2, null, paramMsgSummary);
        return;
      }
      if (paramMessage.msgtype == -2009)
      {
        paramMsgSummary.b = a(paramContext.getString(2131368383), bool1, bool2, null, paramMsgSummary);
        return;
      }
      if (paramMessage.msgtype == -2335)
      {
        paramMsgSummary.b = a(paramContext.getString(2131367594), bool1, bool2, null, paramMsgSummary);
        return;
      }
    } while (paramMessage.msgtype != -2015);
    label195:
    label347:
    label353:
    paramMsgSummary.b = "";
    return;
    paramMsgSummary.b = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemPcDataLine
 * JD-Core Version:    0.7.0.1
 */