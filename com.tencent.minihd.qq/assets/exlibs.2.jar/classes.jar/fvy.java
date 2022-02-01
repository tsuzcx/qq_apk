import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fvy
  implements ActionSheet.OnButtonClickListener
{
  public fvy(PttItemBuilder paramPttItemBuilder, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    paramView = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
    if (paramView != null) {}
    try
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, paramView.uniseq, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    catch (RuntimeException paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder.jdField_a_of_type_AndroidContentContext, paramView.getMessage(), 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fvy
 * JD-Core Version:    0.7.0.1
 */