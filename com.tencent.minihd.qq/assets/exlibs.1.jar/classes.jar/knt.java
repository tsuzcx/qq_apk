import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView;
import com.tencent.mobileqq.troop.widget.NearbyTroopsMapView.NearbyTroopsMapViewObserver;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;

public class knt
  extends Handler
{
  public knt(NearbyTroopsMapView paramNearbyTroopsMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    do
    {
      do
      {
        return;
        if (paramMessage.what != 3) {
          break;
        }
      } while (NearbyTroopsMapView.a(this.a) == null);
      NearbyTroopsMapView.a(this.a, NearbyTroopsMapView.a(this.a));
      return;
    } while ((paramMessage.obj == null) || (this.a.a == null));
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 0: 
      paramMessage = (GeoPoint)paramMessage.obj;
      this.a.a.a(paramMessage);
      return;
    case 1: 
      paramMessage = (GeoPoint)paramMessage.obj;
      this.a.a.b(paramMessage);
      return;
    }
    paramMessage = (Point)paramMessage.obj;
    int i = paramMessage.x;
    int j = paramMessage.y;
    this.a.a.a(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     knt
 * JD-Core Version:    0.7.0.1
 */