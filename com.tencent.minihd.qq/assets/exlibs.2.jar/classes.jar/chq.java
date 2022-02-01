import android.os.Handler;
import android.os.Message;
import com.tencent.biz.map.TroopNearByBigMapView;
import com.tencent.biz.map.TroopNearByBigMapView.IMapLogicCallBack;
import java.lang.ref.WeakReference;

public class chq
  extends Handler
{
  private WeakReference a = null;
  
  public chq(TroopNearByBigMapView paramTroopNearByBigMapView)
  {
    this.a = new WeakReference(paramTroopNearByBigMapView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TroopNearByBigMapView localTroopNearByBigMapView = (TroopNearByBigMapView)this.a.get();
    if (localTroopNearByBigMapView == null) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          TroopNearByBigMapView.c(localTroopNearByBigMapView);
          return;
        }
      } while (TroopNearByBigMapView.a(localTroopNearByBigMapView) == null);
      TroopNearByBigMapView.a(localTroopNearByBigMapView).a();
      return;
    } while (TroopNearByBigMapView.a(localTroopNearByBigMapView) == null);
    TroopNearByBigMapView.a(localTroopNearByBigMapView).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chq
 * JD-Core Version:    0.7.0.1
 */