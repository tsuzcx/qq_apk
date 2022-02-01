import android.view.View;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fgz
  implements ActionSheet.OnButtonClickListener
{
  public fgz(TroopInfoActivity paramTroopInfoActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r;
    switch (paramInt)
    {
    default: 
      paramInt = -1;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.aM != this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.k();
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        if (((i == 0) || (1 == i) || (2 == i)) && ((paramInt == 0) || (1 == paramInt) || (2 == paramInt))) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.app, "P_CliOper", "Grp_create", "", "edit_data", "modify_type", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.c, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.a), String.valueOf(i), String.valueOf(paramInt));
        }
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c(1);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r = 1;
        paramInt = 1;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r = 0;
        paramInt = 0;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r == 4)) {}
        for (;;)
        {
          paramInt = 2;
          break;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.a.r = 2;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.c(2);
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fgz
 * JD-Core Version:    0.7.0.1
 */