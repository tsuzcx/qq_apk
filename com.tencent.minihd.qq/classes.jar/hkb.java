import com.tencent.mobileqq.app.GuardManager;
import java.util.TimerTask;

public class hkb
  extends TimerTask
{
  private hkb(GuardManager paramGuardManager) {}
  
  public void run()
  {
    if (GuardManager.b(this.a)) {
      this.a.b(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hkb
 * JD-Core Version:    0.7.0.1
 */