import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.qphone.base.util.QLog;

public class fwa
  implements View.OnClickListener
{
  public fwa(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    if (QQWalletMsgItemBuilder.a(this.a)) {}
    label525:
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if (this.a.a(this.a.jdField_a_of_type_Long, l))
      {
        this.a.jdField_a_of_type_Long = l;
        MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)((fwb)AIOUtils.a(paramView)).a;
        Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        QQWalletTransferMsgElem localQQWalletTransferMsgElem;
        Object localObject2;
        if ((localMessageForQQWalletMsg != null) && (localMessageForQQWalletMsg.mQQWalletTransferMsg != null))
        {
          localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletTransferMsg.elem;
          localObject2 = null;
        }
        for (;;)
        {
          for (;;)
          {
            if (localQQWalletTransferMsgElem == null) {
              break label525;
            }
            int i;
            Object localObject3;
            if (TextUtils.isEmpty(localQQWalletTransferMsgElem.actionsPriority))
            {
              QQWalletMsgItemBuilder.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.linkUrl);
              return;
              if ((localMessageForQQWalletMsg != null) && (localMessageForQQWalletMsg.mQQWalletRedPacketMsg != null))
              {
                if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 2) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1004) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001)) {}
                for (i = 1;; i = 0)
                {
                  localObject2 = localObject1;
                  if (i != 0)
                  {
                    localObject2 = localObject1;
                    if (!localMessageForQQWalletMsg.isSend()) {
                      localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                    }
                  }
                  localQQWalletTransferMsgElem = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem;
                  localObject3 = localMessageForQQWalletMsg.mQQWalletRedPacketMsg.authkey;
                  localObject1 = localObject2;
                  localObject2 = localObject3;
                  break;
                }
              }
            }
            else
            {
              localObject3 = localQQWalletTransferMsgElem.actionsPriority.split("\\|");
              int k = 0;
              i = j;
              j = k;
              while (j < localObject3.length)
              {
                if (!TextUtils.isEmpty(localObject3[j])) {
                  break label319;
                }
                j += 1;
              }
              break;
              try
              {
                label319:
                k = Integer.valueOf(localObject3[j]).intValue();
                if (k == 1)
                {
                  if (QQWalletMsgItemBuilder.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.linkUrl)) {
                    break;
                  }
                  i = -1;
                }
              }
              catch (Exception localException)
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        for (;;)
                        {
                          if (QLog.isDevelopLevel()) {
                            localException.printStackTrace();
                          }
                          k = i;
                          if (QLog.isColorLevel())
                          {
                            QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "QQWalletMsgItemBuilder failed to convert String:" + localObject3[j] + " to Interger,", localException);
                            k = i;
                          }
                        }
                        if (k != 2) {
                          break;
                        }
                      } while (!QQWalletMsgItemBuilder.b(this.a, paramView.getContext(), localQQWalletTransferMsgElem.jumpUrl));
                      return;
                    } while (k != 3);
                    if ((localMessageForQQWalletMsg == null) || (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null)) {
                      break;
                    }
                  } while (!QQWalletMsgItemBuilder.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.nativeAndroid, (String)localObject2, (String)localObject1));
                  return;
                } while (!QQWalletMsgItemBuilder.a(this.a, paramView.getContext(), localQQWalletTransferMsgElem.nativeAndroid, (String)localObject2, (String)localObject1));
                return;
              }
            }
          }
          localObject2 = null;
          localQQWalletTransferMsgElem = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fwa
 * JD-Core Version:    0.7.0.1
 */