import android.view.View;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dfy
  implements ActionSheet.OnButtonClickListener
{
  public dfy(AddRequestActivity paramAddRequestActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app.a()).longValue();
      AddRequestActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.app, "CliOper", "", "", "Verification_msg", "Vfc_shield_clk", 0, 0, "", "", "", "");
      break;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity, 2131367328, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAddRequestActivity.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfy
 * JD-Core Version:    0.7.0.1
 */