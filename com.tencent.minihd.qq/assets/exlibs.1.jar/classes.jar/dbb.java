import android.view.View;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dbb
  implements ActionSheet.OnButtonClickListener
{
  public dbb(DevicePttItemBuilder paramDevicePttItemBuilder, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    if ((this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt != null))
    {
      paramView = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (;;)
    {
      if (paramView != null) {
        ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a().a(DeviceMsgHandle.d, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.url, Long.parseLong(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), paramView.uniseq, paramView.istroop);
      }
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder.a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dbb
 * JD-Core Version:    0.7.0.1
 */