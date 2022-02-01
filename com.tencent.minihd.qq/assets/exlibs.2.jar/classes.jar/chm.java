import com.tencent.biz.map.TroopNearByBigMapView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.tencentmap.mapsdk.map.MapController;

public class chm
  implements Runnable
{
  public chm(TroopNearByBigMapView paramTroopNearByBigMapView) {}
  
  public void run()
  {
    TroopNearByBigMapView.a(this.a).setZoom(TroopNearByBigMapView.a(this.a).getMaxZoomLevel() - 1);
    TroopNearByBigMapView.a(this.a, TroopNearByBigMapView.a(this.a), TroopNearByBigMapView.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chm
 * JD-Core Version:    0.7.0.1
 */