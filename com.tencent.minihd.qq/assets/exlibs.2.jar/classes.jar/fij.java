import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberTitleActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.statistics.ReportController;

public class fij
  implements View.OnClickListener
{
  public fij(TroopMemberCardActivity paramTroopMemberCardActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof TroopMemberCardActivity.ViewHolder))) {}
    do
    {
      return;
      paramView = (TroopMemberCardActivity.ViewHolder)paramView;
      if (paramView.a == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f("Clk_account");
        return;
      }
      if (paramView.a == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f("Clk_name");
        return;
      }
      if (paramView.a == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f("Clk_recentsaid");
        return;
      }
      if (paramView.a == 4)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.f("Clk_set");
        return;
      }
    } while (paramView.a != 2);
    paramView = (TextView)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131302352);
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.getManager(50);
    int i = localTroopManager.a();
    if (((i & 0x4) == 0) && ("5.5.0".equals("5.9.3")))
    {
      localTroopManager.a(i | 0x4);
      paramView.setVisibility(8);
    }
    paramView = TroopMemberTitleActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.levelName, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitleExpire);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivityForResult(paramView, 7);
    paramView = "2";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 2) {
      paramView = "1";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_manage", "", "mber_title", "Clk_per_title", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c, paramView, "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole == 3) {
        paramView = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fij
 * JD-Core Version:    0.7.0.1
 */