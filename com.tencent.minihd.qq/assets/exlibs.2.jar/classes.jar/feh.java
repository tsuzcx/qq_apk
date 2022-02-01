import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.util.Pair;

public class feh
  implements DialogInterface.OnClickListener
{
  public feh(SubAccountSettingActivity paramSubAccountSettingActivity, SubAccountControll paramSubAccountControll, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountControll.a((String)this.jdField_a_of_type_ComTencentUtilPair.first, ((Integer)this.jdField_a_of_type_ComTencentUtilPair.second).intValue(), true);
    if (!SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.app))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.setTitle("");
      SubAccountAssistantForward.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     feh
 * JD-Core Version:    0.7.0.1
 */