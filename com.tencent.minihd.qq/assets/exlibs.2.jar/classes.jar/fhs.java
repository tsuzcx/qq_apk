import android.view.View;
import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fhs
  implements ActionSheet.OnButtonClickListener
{
  public fhs(TroopManageActivity paramTroopManageActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.getActivity()))
    {
      TroopManageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity, paramInt + 1);
      TroopManageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity, 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.a = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.a.a(2, this.jdField_a_of_type_ComTencentMobileqqActivityTroopManageActivity.getString(2131365730), 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fhs
 * JD-Core Version:    0.7.0.1
 */