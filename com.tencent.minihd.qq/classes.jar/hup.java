import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;

public final class hup
  implements Runnable
{
  public hup(TencentLocationRequest paramTencentLocationRequest) {}
  
  public void run()
  {
    if (BaseApplicationImpl.a().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
      TencentLocationManager.getInstance(BaseApplicationImpl.getContext()).requestLocationUpdates(this.a, SosoInterface.a(), ThreadManager.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hup
 * JD-Core Version:    0.7.0.1
 */