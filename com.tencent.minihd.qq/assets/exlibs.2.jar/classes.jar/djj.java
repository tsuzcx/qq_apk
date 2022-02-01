import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class djj
  implements ActionSheet.OnButtonClickListener
{
  djj(dji paramdji, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    do
    {
      for (;;)
      {
        return;
        ReportController.b(this.jdField_a_of_type_Dji.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Dji.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
        paramView = (StrangerHandler)this.jdField_a_of_type_Dji.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(28);
        ArrayList localArrayList = new ArrayList();
        try
        {
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_Dji.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
          paramView.b(localArrayList);
          if (this.jdField_a_of_type_Dji.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
            this.jdField_a_of_type_Dji.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_Dji.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0);
          }
          this.jdField_a_of_type_Dji.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        catch (NumberFormatException paramView) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatActivity", 2, "delete Stranger parseLong() error", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     djj
 * JD-Core Version:    0.7.0.1
 */