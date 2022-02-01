import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.troopbar.TroopBarDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.Switch;

public class coh
  implements CompoundButton.OnCheckedChangeListener
{
  public coh(TroopBarDetailActivity paramTroopBarDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, View paramView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.e)
    {
      this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.e = true;
      return;
    }
    label49:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 1)
    {
      TroopBarDetailActivity.a(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state_id.get() != 5) {
        break label248;
      }
      str = this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.getString(2131363642);
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state.get() == 1) {
        break label250;
      }
    }
    label248:
    label250:
    for (paramCompoundButton = this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.getString(2131367642);; paramCompoundButton = this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity.getString(2131367671))
    {
      paramCompoundButton = String.format(str, new Object[] { paramCompoundButton });
      this.jdField_a_of_type_AndroidViewView.setContentDescription(paramCompoundButton);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 2)
      {
        if (paramBoolean)
        {
          TroopBarDetailActivity.b(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
          break label49;
        }
        TroopBarDetailActivity.a(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        break label49;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.confirm_flag.get() == 3)
      {
        if (!paramBoolean)
        {
          TroopBarDetailActivity.b(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
          break label49;
        }
        TroopBarDetailActivity.a(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
        break label49;
      }
      TroopBarDetailActivity.a(this.jdField_a_of_type_ComTencentBizTroopbarTroopBarDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, paramBoolean);
      break label49;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     coh
 * JD-Core Version:    0.7.0.1
 */