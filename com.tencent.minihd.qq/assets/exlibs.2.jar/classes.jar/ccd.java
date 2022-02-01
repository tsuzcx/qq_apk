import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.addContactTroopView.TroopCardGroup;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

public class ccd
  implements View.OnClickListener
{
  public ccd(TroopCardGroup paramTroopCardGroup) {}
  
  public void onClick(View paramView)
  {
    this.a.a(TroopCardGroup.a(this.a).str_transfer_url.get());
    ReportController.b(this.a.a, "P_CliOper", "Grp_find", "", "grptab", "Clk_more", 0, 0, "", TroopCardGroup.a(this.a).title_bar.str_desc.get(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ccd
 * JD-Core Version:    0.7.0.1
 */