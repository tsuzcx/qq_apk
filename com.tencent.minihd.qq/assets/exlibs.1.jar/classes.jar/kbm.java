import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class kbm
  implements ActionSheet.OnButtonClickListener
{
  public kbm(AbsPublishActivity paramAbsPublishActivity, int paramInt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.c.setText(2131363899);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.c.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.getString(2131363930));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.c.setSelected(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a();
      return;
      if (paramInt < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = ((TroopBarPageEntity.TypeListEntity)this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.c.setText(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity.name);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.c.setSelected(true);
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.c.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.getString(2131363931, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsPublishActivity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity.name }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kbm
 * JD-Core Version:    0.7.0.1
 */