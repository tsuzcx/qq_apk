import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troopbar.TroopBarDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.widget.Switch;

public class cot
  implements DialogInterface.OnClickListener
{
  public cot(TroopBarDetailActivity paramTroopBarDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      TroopBarDetailActivity.a(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
      this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.a.isConfirmed = true;
      TroopBarDetailActivity.b(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.a);
      this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.g = false;
    }
    while (paramInt != 1) {
      return;
    }
    TroopBarDetailActivity.a(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.a.isConfirmed = true;
    TroopBarDetailActivity.b(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.a);
    this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cot
 * JD-Core Version:    0.7.0.1
 */