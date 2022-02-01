import android.content.Context;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.flaotaio.StrangerFloatChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;

public class gmy
  extends MessageObserver
{
  public gmy(StrangerFloatChatPie paramStrangerFloatChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
      return;
    }
    if (paramInt1 == 1004) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      this.a.a(196608);
      return;
      paramString1 = String.format(this.a.jdField_a_of_type_AndroidContentContext.getString(2131366068), new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramString1, 0).a();
      continue;
      if (paramInt1 == 1000) {
        switch (paramInt2)
        {
        default: 
          break;
        case 102: 
        case 103: 
        case 104: 
          paramString1 = String.format(this.a.jdField_a_of_type_AndroidContentContext.getString(2131366069), new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramString1, 0).a();
          break;
        }
      } else if (paramInt1 == 1020) {
        switch (paramInt2)
        {
        default: 
          break;
        case 40: 
        case 102: 
        case 103: 
        case 104: 
          paramString1 = (HotChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
          paramString1 = String.format(this.a.jdField_a_of_type_AndroidContentContext.getString(2131363252), new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d });
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramString1, 0).a();
          break;
        }
      } else if (paramInt1 == 1006) {
        switch (paramInt2)
        {
        default: 
          break;
        case 1600: 
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131366127), 0).a();
          break;
        case 1601: 
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131366127), 0).a();
          break;
        case 1602: 
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131366128), 0).a();
          break;
        }
      } else if (paramInt1 == 1022) {
        switch (paramInt2)
        {
        default: 
          break;
        case 16: 
          ChatActivityFacade.c(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          break;
        }
      } else if (paramInt1 == 1023) {
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "errorCode" + paramInt2, 0).a();
      } else if (paramInt1 == 1025) {
        switch (paramInt2)
        {
        default: 
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "errorCode" + paramInt2, 0).a();
          break;
        case 55: 
          QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, "已屏蔽的临时会话", 0).a();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
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
 * Qualified Name:     gmy
 * JD-Core Version:    0.7.0.1
 */