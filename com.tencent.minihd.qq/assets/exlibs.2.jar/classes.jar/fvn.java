import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class fvn
  implements View.OnClickListener
{
  public fvn(PAMultiItemBuilder paramPAMultiItemBuilder) {}
  
  public void onClick(View paramView)
  {
    fvo localfvo = (fvo)paramView.getTag();
    paramView = AIOUtils.a(paramView);
    if ((localfvo == null) || (!(paramView instanceof MessageForPubAccount))) {
      if (QLog.isColorLevel()) {
        QLog.d(ChatItemBuilder.a, 2, "PAMultiItemBuilder onClickListener holder = " + localfvo + ", msg = " + paramView);
      }
    }
    MessageForPubAccount localMessageForPubAccount;
    do
    {
      return;
      localMessageForPubAccount = (MessageForPubAccount)paramView;
      if ((localMessageForPubAccount.mPAMessage != null) && (localMessageForPubAccount.mPAMessage.items != null) && (!localMessageForPubAccount.mPAMessage.items.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(ChatItemBuilder.a, 2, "PAMultiItemBuilder onClickListener mPAMessage or items is empty !");
    return;
    PAMessage.Item localItem = (PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(localfvo.jdField_c_of_type_Int);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface)) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "mp_msg_msgpic_click", "aio_morpic_click", localfvo.jdField_c_of_type_Int + 1, 0, "", "", Long.toString(localMessageForPubAccount.mPAMessage.mMsgId), "");
    }
    label228:
    JumpAction localJumpAction;
    int i;
    if (TextUtils.isEmpty(localItem.a_actionData))
    {
      paramView = localItem.actionData;
      if (TextUtils.isEmpty(paramView)) {
        break label753;
      }
      localJumpAction = JumpParser.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramView);
      if (localJumpAction != null) {
        break label535;
      }
      if (localItem.appId != 0L) {
        break label446;
      }
      i = 0;
      label272:
      if (i == 0) {
        break label480;
      }
      if (PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localItem.nativeJumpString, localItem.appId, paramView)) {
        break label451;
      }
      PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localfvo.a, localfvo.b, localfvo.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      label359:
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
    }
    for (;;)
    {
      long l = localMessageForPubAccount.mPAMessage.mMsgId;
      if (l <= 0L) {
        break;
      }
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(l), "", "", "");
      return;
      paramView = localItem.a_actionData;
      break label228;
      label446:
      i = 1;
      break label272;
      label451:
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
      break label359;
      label480:
      PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localfvo.a, localfvo.b, localfvo.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      break label359;
      label535:
      if (TextUtils.isEmpty(localJumpAction.a()))
      {
        if (!PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localItem.nativeJumpString, localItem.appId, paramView))
        {
          PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localfvo.a, localfvo.b, localfvo.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
          break label359;
        }
        PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        break label359;
      }
      if (!localJumpAction.b())
      {
        PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localfvo.a, localfvo.b, localfvo.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        break label359;
      }
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
      break label359;
      label753:
      PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localfvo.a, localfvo.b, localfvo.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fvn
 * JD-Core Version:    0.7.0.1
 */