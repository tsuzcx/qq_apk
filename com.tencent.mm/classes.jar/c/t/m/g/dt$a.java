package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;

final class dt$a
  extends Handler
{
  volatile boolean a = false;
  
  private dt$a(dt paramdt, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @SuppressLint({"NewApi", "MissingPermission"})
  public final void handleMessage(Message arg1)
  {
    if (!this.b.a) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((this.b.d == null) || (!this.b.d.a(1000L)))
        {
          ??? = this.b.c.e;
          if (??? == null) {}
        }
      }
      catch (Throwable ???)
      {
        j.a("TxNewCellProvider", "handler cell message error.", ???);
        continue;
      }
      try
      {
        ??? = this.b.c.e.getAllCellInfo();
        if (this.b.h != null)
        {
          j.a("TxNewCellProvider", 6, "timer notify");
          this.b.h.onCellInfoChanged(???);
        }
        synchronized (this.b.b)
        {
          if ((this.b.g != null) && (!this.a)) {
            sendEmptyMessageDelayed(0, 30000L);
          }
          return;
        }
      }
      catch (Throwable ???)
      {
        j.a("TxNewCellProvider", "cannot get cellinfo", ???);
        ??? = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.g.dt.a
 * JD-Core Version:    0.7.0.1
 */