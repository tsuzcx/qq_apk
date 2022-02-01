import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;

public class fzw
  implements DialogInterface.OnClickListener
{
  public fzw(DeviceMsgChatPie paramDeviceMsgChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DevVideoMsgProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.K);
    this.a.K = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fzw
 * JD-Core Version:    0.7.0.1
 */