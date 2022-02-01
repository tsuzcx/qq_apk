import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class gab
  extends MessageObserver
{
  public gab(DiscussChatPie paramDiscussChatPie) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussChatPie", 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussChatPie", 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler != null) && ((paramSendMessageHandler instanceof MessageForStructing)) && ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction))) {
        MultiMsgManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramInt1, paramLong2, false);
      }
    }
    if (paramInt1 == 3000) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      this.a.a(196608);
      return;
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131366401, 1).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      continue;
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131366402, 1).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      continue;
      DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, "发送失败", this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131367793), new gac(this, paramString1), null).show();
      continue;
      try
      {
        if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
          DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, "发送失败", this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366404), new gad(this, paramString1), null).show();
        }
      }
      catch (Throwable paramString1) {}
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
    this.a.j = true;
    this.a.a(131072);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1) {
      this.a.F();
    }
  }
  
  protected void d(boolean paramBoolean, String paramString)
  {
    this.a.a(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gab
 * JD-Core Version:    0.7.0.1
 */