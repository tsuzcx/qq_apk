import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.map.TroopNearByBigMapView;
import com.tencent.mobileqq.statistics.ReportController;

public class cho
  implements View.OnClickListener
{
  public cho(TroopNearByBigMapView paramTroopNearByBigMapView) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(TroopNearByBigMapView.a(this.a), "P_CliOper", "Grp_nearby", "", "nearbygrp_map", "Clk_back", 0, 0, "", "", "", "");
    TroopNearByBigMapView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cho
 * JD-Core Version:    0.7.0.1
 */