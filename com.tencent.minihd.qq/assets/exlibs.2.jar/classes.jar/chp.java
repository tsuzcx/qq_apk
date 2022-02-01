import android.widget.Button;
import com.tencent.biz.map.TroopNearByBigMapView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView.NearbyTroopsMapViewObserver;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class chp
  implements NearbyTroopsMapView.NearbyTroopsMapViewObserver
{
  public chp(TroopNearByBigMapView paramTroopNearByBigMapView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    GeoPoint localGeoPoint = TroopNearByBigMapView.a(this.a).getMapCenter();
    TroopNearByBigMapView.a(this.a, localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
    if (paramInt2 != TroopNearByBigMapView.a(this.a).getMaxZoomLevel() - 1)
    {
      TroopNearByBigMapView.a(this.a).setVisibility(0);
      TroopNearByBigMapView.b(this.a).setVisibility(8);
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    TroopNearByBigMapView.a(this.a, paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    if ((paramGeoPoint.getLatitudeE6() != TroopNearByBigMapView.a(this.a)) || (paramGeoPoint.getLongitudeE6() != TroopNearByBigMapView.b(this.a)))
    {
      TroopNearByBigMapView.a(this.a).setVisibility(0);
      TroopNearByBigMapView.b(this.a).setVisibility(8);
    }
  }
  
  public void b(GeoPoint paramGeoPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chp
 * JD-Core Version:    0.7.0.1
 */