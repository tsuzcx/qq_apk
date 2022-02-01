import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PAGameItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class fvk
  implements View.OnClickListener
{
  public fvk(PAGameItemBuilder paramPAGameItemBuilder) {}
  
  public void onClick(View paramView)
  {
    fvm localfvm = (fvm)paramView.getTag();
    paramView = AIOUtils.a(paramView);
    if ((localfvm == null) || (!(paramView instanceof MessageForPubAccount))) {
      if (QLog.isColorLevel()) {
        QLog.d(ChatItemBuilder.a, 2, "PAGameItemBuilder onClickListener holder = " + localfvm + ", msg = " + paramView);
      }
    }
    do
    {
      return;
      paramView = (MessageForPubAccount)paramView;
      if ((paramView.mPAMessage != null) && (paramView.mPAMessage.items != null) && (!paramView.mPAMessage.items.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(ChatItemBuilder.a, 2, "PAGameItemBuilder onClickListener mPAMessage or items is empty !");
    return;
    PASingleItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, localfvm.a, localfvm.b, localfvm.c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fvk
 * JD-Core Version:    0.7.0.1
 */