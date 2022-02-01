import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.troop.activity.AbsReplyActivity;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;
import java.util.ArrayList;

public class kce
  implements DialogInterface.OnClickListener
{
  public kce(AbsReplyActivity paramAbsReplyActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.m();
      return;
    case 2: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new kcf(this), 200L);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.l();
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.o();
      return;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
      return;
    case 5: 
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_AndroidOsHandler.postDelayed(new kcg(this), 200L);
      return;
    case 6: 
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.b.clear();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.l();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.b.clear();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetPublishItemContainer.a();
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqTroopActivityAbsReplyActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kce
 * JD-Core Version:    0.7.0.1
 */