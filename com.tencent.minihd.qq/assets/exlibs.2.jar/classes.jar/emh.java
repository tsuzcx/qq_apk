import android.os.Bundle;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.observer.GameCenterObserver;

public class emh
  extends GameCenterObserver
{
  public emh(NearbyActivity paramNearbyActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    NearbyActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     emh
 * JD-Core Version:    0.7.0.1
 */