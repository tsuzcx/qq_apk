import android.content.Intent;
import android.view.View;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fzx
  implements ActionSheet.OnButtonClickListener
{
  public fzx(DeviceMsgChatPie paramDeviceMsgChatPie, int paramInt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = (SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      DeviceInfo localDeviceInfo = paramView.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.v();
        label87:
        if (localDeviceInfo != null)
        {
          if (localDeviceInfo.isAdmin != 1) {
            break label178;
          }
          paramInt = 3;
          label103:
          SmartDeviceReport.a(null, "Usr_LiteApp_Open", paramInt, 0, localDeviceInfo.productId);
          if (localDeviceInfo.userStatus != 10) {
            break label183;
          }
        }
      }
      label178:
      label183:
      for (paramInt = i;; paramInt = 4)
      {
        SmartDeviceReport.a(null, "Usr_LiteApp_Open_Online", paramInt, 0, localDeviceInfo.productId);
        SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_Menu", 2, 0, this.jdField_a_of_type_Int);
        break;
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localDeviceInfo);
        break label87;
        paramInt = 4;
        break label103;
      }
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, DeviceMsgSettingActivity.class);
      paramView.putExtra("din", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramView.putExtra("pid", this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.cf);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      SmartDeviceReport.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildDeviceMsgChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Usr_AIO_Menu", 3, 0, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fzx
 * JD-Core Version:    0.7.0.1
 */