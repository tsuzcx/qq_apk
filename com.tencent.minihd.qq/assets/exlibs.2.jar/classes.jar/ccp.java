import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.addContactTroopView.TroopCardXingquBuluo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item3;

class ccp
  implements View.OnClickListener
{
  ccp(cco paramcco, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = (searchtab.Item3)TroopCardXingquBuluo.a(this.jdField_a_of_type_Cco.a).get(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Cco.a.a(paramView.str_transfer_url.get());
    ReportController.b(this.jdField_a_of_type_Cco.a.a, "P_CliOper", "Grp_find", "", "grptab", "Clk_tribe", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ccp
 * JD-Core Version:    0.7.0.1
 */