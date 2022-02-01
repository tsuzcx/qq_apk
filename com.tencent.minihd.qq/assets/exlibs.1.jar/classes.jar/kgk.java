import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity.MyBarListAdapter;
import com.tencent.mobileqq.troop.data.TroopBarMyBar;

public class kgk
  implements DialogInterface.OnClickListener
{
  public kgk(TroopBarPublishBarSelectActivity paramTroopBarPublishBarSelectActivity, TroopBarMyBar paramTroopBarMyBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity$MyBarListAdapter.notifyDataSetChanged();
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_selected_item", this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarMyBar);
    paramDialogInterface.putExtra("key_drop_media_data", this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.b);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kgk
 * JD-Core Version:    0.7.0.1
 */