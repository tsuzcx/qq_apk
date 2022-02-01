import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.data.TroopMemberCard;

public class fia
  implements View.OnClickListener
{
  public fia(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    Object localObject;
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    case 4: 
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, ChatActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
      localIntent.putExtra("PREVIOUS_WINDOW", TroopMemberCardActivity.class.getName());
      localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        localIntent.putExtra("uintype", 0);
      }
      for (;;)
      {
        paramView = "";
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
        }
        localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f;
        }
        localIntent.putExtra("uinname", (String)localObject);
        localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c);
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d);
        localIntent.addFlags(67108864);
        localIntent.putExtra("cSpecialFlag", 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity(localIntent);
        return;
        localIntent.putExtra("uintype", 1000);
      }
    case 5: 
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        paramView = null;
      }
      for (;;)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, i, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e, (String)localObject, null, true, paramView, true, true, null, null);
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d;
        i = 1000;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fia
 * JD-Core Version:    0.7.0.1
 */