import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.data.RecommendTroopMsg;
import com.tencent.mobileqq.statistics.ReportController;

class gju
  implements View.OnClickListener
{
  gju(gjt paramgjt, RecommendTroopMsg paramRecommendTroopMsg) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopMsg.isTroop()) {
      RecommendTroopView.a(this.jdField_a_of_type_Gjt.a, this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopMsg.troop, this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopMsg.isRead);
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopMsg.isBusiness()) {
      return;
    }
    RecommendTroopView.a(this.jdField_a_of_type_Gjt.a, this.jdField_a_of_type_ComTencentMobileqqDataRecommendTroopMsg.rtbItem);
    ReportController.b(this.jdField_a_of_type_Gjt.a.a, "CliOper", "", "", "Grp_recommend", "Clk_grp_recommend", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gju
 * JD-Core Version:    0.7.0.1
 */