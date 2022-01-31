package c.t.m.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class dn$a
  extends Handler
{
  volatile boolean a = false;
  
  private dn$a(dn paramdn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    super.handleMessage(???);
    if (!this.b.a) {
      return;
    }
    synchronized (dn.a(this.b))
    {
      if ((dn.b(this.b) != null) && (!this.a)) {
        sendEmptyMessageDelayed(0, 30000L);
      }
      ??? = en.a(dn.c(this.b));
      dn.a(this.b, ???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.dn.a
 * JD-Core Version:    0.7.0.1
 */