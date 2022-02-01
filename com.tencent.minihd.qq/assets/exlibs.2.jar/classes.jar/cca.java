import android.support.v4.view.ViewPager;
import com.tencent.biz.addContactTroopView.TroopCardBanner;
import java.util.TimerTask;

public class cca
  extends TimerTask
{
  public cca(TroopCardBanner paramTroopCardBanner) {}
  
  public void run()
  {
    TroopCardBanner.a(this.a).post(new ccb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cca
 * JD-Core Version:    0.7.0.1
 */