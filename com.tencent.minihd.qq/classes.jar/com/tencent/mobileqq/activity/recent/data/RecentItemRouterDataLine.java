package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class RecentItemRouterDataLine
  extends RecentUserBaseData
{
  public RecentItemRouterDataLine(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private QQMessageFacade.Message a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      if (localMessage != null)
      {
        paramQQAppInterface = localMessage;
        if (localMessage.msgtype != 0) {}
      }
      else
      {
        return null;
      }
    }
    else
    {
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
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
        paramCharSequence = new SpannableStringBuilder(paramCharSequence.toString());
      }
    }
    for (paramMsgSummary.g = 0;; paramMsgSummary.g = 1)
    {
      if (!paramBoolean1) {
        break label90;
      }
      paramMsgSummary.f = 2;
      return paramCharSequence;
      if (!paramBoolean2) {
        break;
      }
      paramCharSequence.append("S ");
      break;
    }
    label90:
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
    this.B = 0;
    this.jdField_a_of_type_Long = 0L;
    RouterHandler localRouterHandler = (RouterHandler)paramQQAppInterface.a(50);
    Object localObject2 = a(paramQQAppInterface);
    Object localObject1 = localObject2;
    QQMessageFacade localQQMessageFacade;
    String str;
    if (localObject2 == null)
    {
      localQQMessageFacade = paramQQAppInterface.a();
      str = MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, 6002);
      localObject2 = localRouterHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if (localObject2 != null) {
        break label238;
      }
      localObject1 = new QQMessageFacade.Message();
      ((QQMessageFacade.Message)localObject1).extInt = 0;
      ((QQMessageFacade.Message)localObject1).time = MessageCache.a();
      ((QQMessageFacade.Message)localObject1).msgtype = 0;
    }
    for (;;)
    {
      localQQMessageFacade.a.put(str, localObject1);
      this.jdField_a_of_type_JavaLangString = localRouterHandler.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin));
      this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = a();
      a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      a(paramQQAppInterface);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
      this.c = ("与我的路由的会话 [有" + this.B + "条未读消息] " + this.b + " " + ((MsgSummary)localObject2).b);
      return;
      label238:
      if (localQQMessageFacade == null) {
        break;
      }
      localObject1 = localObject2;
      if (localQQMessageFacade.a.containsKey(str))
      {
        localQQMessageFacade.a.remove(str);
        localObject1 = localObject2;
      }
    }
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    boolean bool2 = false;
    if (paramMessage != null)
    {
      paramInt = paramMessage.extInt;
      if (paramInt != 4) {
        break label466;
      }
    }
    label207:
    label466:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      if (paramMessage.msgtype == -1000)
      {
        paramQQAppInterface = paramMessage.getMessageText();
        if (paramQQAppInterface != null) {
          if (bool1) {
            paramQQAppInterface = "F " + paramQQAppInterface;
          }
        }
      }
      for (;;)
      {
        paramMsgSummary.b = a(null, bool1, bool2, new QQText(paramQQAppInterface, 1, 16), paramMsgSummary);
        for (;;)
        {
          if (paramMessage != null) {
            QLog.d("RecentItemRouterDataLine", 2, "msg info: " + paramMessage.extInt + ":" + paramMessage.msgtype + "msgSummary.strContent:" + paramMsgSummary.b);
          }
          return;
          if (!bool2) {
            break label463;
          }
          paramQQAppInterface = "S " + paramQQAppInterface;
          break;
          paramContext = new StringBuffer();
          if (bool1)
          {
            paramContext.append("F ");
            if (paramQQAppInterface == null) {
              break label283;
            }
          }
          for (paramQQAppInterface = paramQQAppInterface.toString().trim();; paramQQAppInterface = "")
          {
            for (;;)
            {
              paramContext.append(paramQQAppInterface);
              try
              {
                paramMsgSummary.b = a(null, bool1, bool2, new QQText(paramContext, 1, 16), paramMsgSummary);
              }
              catch (Exception paramQQAppInterface)
              {
                paramQQAppInterface.printStackTrace();
              }
            }
            break;
            if (!bool2) {
              break label207;
            }
            paramContext.append("S ");
            break label207;
          }
          if (paramMessage.msgtype == -2000)
          {
            paramMsgSummary.b = a(paramContext.getString(2131366789), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2005)
          {
            paramMsgSummary.b = a(paramContext.getString(2131367594), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2009)
          {
            paramMsgSummary.b = a(paramContext.getString(2131368383), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2335)
          {
            paramMsgSummary.b = a(paramContext.getString(2131367594), bool1, bool2, null, paramMsgSummary);
          }
          else if (paramMessage.msgtype == -2015)
          {
            paramMsgSummary.b = "";
            continue;
            paramMsgSummary.b = "";
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemRouterDataLine
 * JD-Core Version:    0.7.0.1
 */