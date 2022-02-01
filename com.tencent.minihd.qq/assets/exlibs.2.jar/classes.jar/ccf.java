import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.addContactTroopView.TroopCardGroup;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.Item1;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

class ccf
  implements View.OnClickListener
{
  ccf(cce paramcce, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = (searchtab.Item1)TroopCardGroup.a(this.jdField_a_of_type_Cce.a).get(this.jdField_a_of_type_Int);
    TroopCardGroup.a(this.jdField_a_of_type_Cce.a, paramView);
    ReportController.b(this.jdField_a_of_type_Cce.a.a, "P_CliOper", "Grp_find", "", "grptab", "Clk_grpdata", 0, 0, String.valueOf(paramView.uint64_group_code.get()), TroopCardGroup.a(this.jdField_a_of_type_Cce.a).title_bar.str_desc.get(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ccf
 * JD-Core Version:    0.7.0.1
 */