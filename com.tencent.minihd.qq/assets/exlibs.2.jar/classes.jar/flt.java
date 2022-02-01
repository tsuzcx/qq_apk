import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class flt
  implements ActionSheet.OnButtonClickListener
{
  public flt(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), ChatActivity.class);
      paramView.putExtra("uintype", 0);
      paramView.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      paramView.putExtra("uinname", ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, this.jdField_a_of_type_JavaLangString));
      paramView.putExtra("entrance", 2);
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.startActivity(paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C51", "0X8004C51", 0, 0, "", "", "", "");
      continue;
      paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_JavaLangString, 1);
      paramView.g = 59;
      paramView.i = 2;
      ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), paramView);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C52", "0X8004C52", 0, 0, "", "", "", "");
      continue;
      if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity()))
      {
        paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.a(1);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.jdField_a_of_type_JavaLangString);
        paramView.a((short)1, localArrayList, false);
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C53", "0X8004C53", 0, 0, "", "", "", "");
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(2131369864, 1);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(this.jdField_a_of_type_JavaLangString);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C54", "0X8004C54", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     flt
 * JD-Core Version:    0.7.0.1
 */