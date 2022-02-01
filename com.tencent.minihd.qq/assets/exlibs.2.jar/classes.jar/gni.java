import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.flaotaio.TroopFloatChatPie;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;

public class gni
  extends MessageObserver
{
  public gni(TroopFloatChatPie paramTroopFloatChatPie) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2131365770, 1).a();
    }
    for (;;)
    {
      this.a.s();
      return;
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2131365769, 1).a();
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      return;
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        MultiMsgManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 1)
    {
      if (!((FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).f(paramString1)) {
        break label247;
      }
      if (paramInt2 != 108) {
        break label183;
      }
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "已经不再公开群里了", 1).a();
    }
    for (;;)
    {
      this.a.a(196608);
      return;
      label183:
      if (paramInt2 == 102)
      {
        this.a.s();
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131365771, 1).a();
      }
      else if (paramString2.length() > 0)
      {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramString2, 1).a();
        continue;
        switch (paramInt2)
        {
        default: 
          break;
        case 1: 
        case 2: 
        case 101: 
        case 102: 
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2131365770, 1).a();
          break;
        case 3: 
        case 103: 
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 2131365769, 1).a();
          break;
        case 130: 
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364054);
          }
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramString1, 1).a();
          break;
        case 131: 
          label247:
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364055);
          }
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramString1, 1).a();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    MultiMsgManager.a().b("send struct msg  ");
    MultiMsgManager.a().c();
    MultiMsgManager.a().a("all cost time ");
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.a(131072);
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    this.a.a(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gni
 * JD-Core Version:    0.7.0.1
 */