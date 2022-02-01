import com.tencent.mobileqq.PermissionsDialog.PermissionsDialog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.permission.PermissionCallback;

public class fpj
  implements PermissionCallback
{
  public fpj(PlusPanel paramPlusPanel, SplashActivity paramSplashActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, paramInt, paramArrayOfString, new fpk(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = (HotChatManager)PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).getManager(58);
    if ((PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).jdField_a_of_type_Int == 1) && (!paramArrayOfString.d(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).jdField_a_of_type_JavaLangString))) {
      PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel);
    }
    for (;;)
    {
      ReportController.b(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), "CliOper", "", "", "0X800407F", "0X800407F", 0, 0, "", "", "", "");
      return;
      PlusPanelUtils.a(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a());
      if (PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel) != null) {
        PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel).a().setCanLock(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fpj
 * JD-Core Version:    0.7.0.1
 */