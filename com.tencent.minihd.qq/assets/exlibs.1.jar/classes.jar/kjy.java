import android.app.Activity;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import java.util.TimerTask;

public class kjy
  extends TimerTask
{
  public kjy(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.runOnUiThread(new kjz(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kjy
 * JD-Core Version:    0.7.0.1
 */