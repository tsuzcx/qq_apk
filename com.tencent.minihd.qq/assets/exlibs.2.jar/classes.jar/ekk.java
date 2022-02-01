import android.view.View;
import android.view.View.OnClickListener;
import cannon.Visitor;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.mobileqq.statistics.ReportController;

class ekk
  implements View.OnClickListener
{
  ekk(ekj paramekj, Visitor paramVisitor) {}
  
  public void onClick(View paramView)
  {
    paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_Ekj.a, 1, String.valueOf(this.jdField_a_of_type_CannonVisitor.uin), null, 3003, 0, this.jdField_a_of_type_CannonVisitor.name, null, null, MayKnowManActivity.a(this.jdField_a_of_type_Ekj.a));
    this.jdField_a_of_type_Ekj.a.startActivity(paramView);
    ReportController.b(this.jdField_a_of_type_Ekj.a.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_frdoffer_add", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ekk
 * JD-Core Version:    0.7.0.1
 */