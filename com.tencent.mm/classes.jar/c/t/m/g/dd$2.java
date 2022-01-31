package c.t.m.g;

import java.util.Timer;
import java.util.TimerTask;

final class dd$2
  extends TimerTask
{
  dd$2(Timer paramTimer) {}
  
  public final void run()
  {
    try
    {
      this.a.cancel();
      return;
    }
    catch (Throwable localThrowable)
    {
      da.a("CC_", "timer cancel error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     c.t.m.g.dd.2
 * JD-Core Version:    0.7.0.1
 */