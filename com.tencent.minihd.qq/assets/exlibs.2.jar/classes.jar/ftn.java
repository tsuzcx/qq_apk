import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class ftn
  implements ActionSheet.OnButtonClickListener
{
  public ftn(FileItemBuilder paramFileItemBuilder, MessageForFile paramMessageForFile, BaseChatItemLayout paramBaseChatItemLayout, ftq paramftq, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.uniseq, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L) != -1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_AndroidOsHandler.post(new fto(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status = 1002;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_Ftq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.status, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ftn
 * JD-Core Version:    0.7.0.1
 */