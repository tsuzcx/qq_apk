import com.tencent.wstt.SSCM.SSCMTimer;
import com.tencent.wstt.SSCM.SSCMTimer.SSCMTimerObserver;
import com.tencent.wstt.SSCM.Utils;
import java.util.TimerTask;

public class luo
  extends TimerTask
{
  public luo(SSCMTimer paramSSCMTimer) {}
  
  public void run()
  {
    long l;
    int i;
    if (SSCMTimer.a(this.a))
    {
      l = Long.parseLong(Utils.a());
      if (l == -1L)
      {
        SSCMTimer.a(this.a, false);
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 0) {
        SSCMTimer.a(this.a, 0);
      }
      do
      {
        do
        {
          return;
          i = (int)(l - SSCMTimer.a(this.a));
          SSCMTimer.a(this.a, l);
          break;
          SSCMTimer.a(this.a, SSCMTimer.a(this.a) + SSCMTimer.b(this.a));
        } while (SSCMTimer.a(this.a) < 120000);
        SSCMTimer.b(this.a, 1);
        cancel();
      } while (SSCMTimer.a(this.a) == null);
      SSCMTimer.a(this.a).b(SSCMTimer.a(this.a));
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     luo
 * JD-Core Version:    0.7.0.1
 */