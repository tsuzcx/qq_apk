import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.flaotaio.FloatHongbaoItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class gmg
  implements View.OnClickListener
{
  public gmg(FloatHongbaoItemBuilder paramFloatHongbaoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (!this.a.a(this.a.jdField_a_of_type_Long, l)) {}
    MessageForQQWalletMsg localMessageForQQWalletMsg;
    do
    {
      return;
      this.a.jdField_a_of_type_Long = l;
      localMessageForQQWalletMsg = (MessageForQQWalletMsg)((gmh)AIOUtils.a(paramView)).a;
    } while ((localMessageForQQWalletMsg == null) || (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) || (localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem == null));
    QQWalletTransferMsgElem localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
    String str3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 2) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)) {}
    for (int i = 1;; i = 0)
    {
      String str1 = str2;
      if (i != 0)
      {
        str1 = str2;
        if (!localMessageForQQWalletMsg.isSend()) {
          str1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        }
      }
      FloatHongbaoItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), localQQWalletTransferMsgElem.nativeAndroid, str3, str1, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramView = new Intent("action_for_item_click");
      paramView.putExtra("hongbao_sender_uin", FloatHongbaoItemBuilder.a(this.a, localMessageForQQWalletMsg));
      paramView.putExtra("wish_word", localQQWalletTransferMsgElem.title);
      paramView.putExtra("msg_uni_seq", localMessageForQQWalletMsg.uniseq);
      this.a.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramView);
      paramView = new Intent("circle_hb_opend");
      paramView.putExtra("nativeAndroid", localQQWalletTransferMsgElem.nativeAndroid);
      this.a.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gmg
 * JD-Core Version:    0.7.0.1
 */