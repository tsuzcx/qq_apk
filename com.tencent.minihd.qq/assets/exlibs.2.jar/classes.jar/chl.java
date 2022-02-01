import NearbyGroup.RspGetAreaList;
import com.tencent.biz.map.TroopNearByBigMapView;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import java.util.ArrayList;

public class chl
  extends LBSObserver
{
  public chl(TroopNearByBigMapView paramTroopNearByBigMapView) {}
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2)
  {
    if (TroopNearByBigMapView.a(this.a)) {}
    do
    {
      do
      {
        return;
        TroopNearByBigMapView.a(this.a).sendEmptyMessage(3);
      } while ((!paramBoolean1) || (paramRspGetAreaList == null) || (paramRspGetAreaList.vGroupArea == null));
      paramRspGetAreaList = paramRspGetAreaList.vGroupArea;
      TroopNearByBigMapView.a(this.a).a(paramRspGetAreaList, paramBoolean2);
    } while ((paramRspGetAreaList == null) || (paramRspGetAreaList.size() <= 0) || (!TroopNearByBigMapView.b(this.a)) || ((TroopNearByBigMapView.a(this.a) == 0) && (TroopNearByBigMapView.b(this.a) == 0)));
    TroopNearByBigMapView.a(this.a, false);
    TroopNearByBigMapView.a(this.a, TroopNearByBigMapView.a(this.a), TroopNearByBigMapView.b(this.a));
    TroopNearByBigMapView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chl
 * JD-Core Version:    0.7.0.1
 */