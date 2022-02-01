import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class dqk
  implements Runnable
{
  dqk(dqj paramdqj, boolean paramBoolean) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_Dqj.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ArrayOfAndroidViewView[4];
    if ((localView != null) && (this.jdField_a_of_type_Dqj.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
    {
      ((TextView)localView.findViewById(2131297001)).setText(this.jdField_a_of_type_Dqj.jdField_a_of_type_JavaLangString);
      TextView localTextView = (TextView)localView.findViewById(2131297409);
      localTextView.setText(this.jdField_a_of_type_Dqj.b);
      localTextView.setMaxLines(3);
      this.jdField_a_of_type_Dqj.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a(true);
      this.jdField_a_of_type_Dqj.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(true);
      this.jdField_a_of_type_Dqj.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localView, 0, this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Dqj.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.a(localView, this.jdField_a_of_type_Dqj.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqk
 * JD-Core Version:    0.7.0.1
 */