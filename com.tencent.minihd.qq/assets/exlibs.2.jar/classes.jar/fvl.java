import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAGameItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class fvl
  implements View.OnClickListener
{
  public fvl(PAGameItemBuilder paramPAGameItemBuilder) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - PAGameItemBuilder.a(this.a)) < 1000L) {}
    fvm localfvm;
    do
    {
      do
      {
        do
        {
          return;
          PAGameItemBuilder.a(this.a, l);
          localfvm = (fvm)paramView.getTag();
          paramView = AIOUtils.a(paramView);
        } while ((localfvm == null) || (!(paramView instanceof MessageForPubAccount)));
        paramView = (MessageForPubAccount)paramView;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.items != null) && (!paramView.mPAMessage.items.isEmpty())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(ChatItemBuilder.a, 2, "PAGameItemBuilder onClickListener mPAMessage or items is empty !");
      return;
      PAMessage.Item localItem = (PAMessage.Item)paramView.mPAMessage.items.get(localfvm.c);
      if (localItem != null) {
        PAGameItemBuilder.a(this.a, localItem);
      }
    } while (!(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface));
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "mp_msg_game_xiazai_click", "aio_game_xiazai_click", localfvm.c + 1, 0, "", "", Long.toString(paramView.mPAMessage.mMsgId), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fvl
 * JD-Core Version:    0.7.0.1
 */