import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import java.util.Observable;
import java.util.Observer;

public class goh
  implements Observer
{
  public goh(MainAssistObserver paramMainAssistObserver) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new goi(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     goh
 * JD-Core Version:    0.7.0.1
 */