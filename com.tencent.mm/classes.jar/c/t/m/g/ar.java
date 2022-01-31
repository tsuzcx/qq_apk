package c.t.m.g;

import android.os.SystemClock;

final class ar
  implements Runnable
{
  ar(aq paramaq, ak paramak, long paramLong) {}
  
  public final void run()
  {
    boolean bool2 = false;
    try
    {
      an localan = this.a.a();
      this.a.k = (SystemClock.elapsedRealtime() - this.b);
      this.a.a(false);
      boolean bool1 = bool2;
      if (localan.a == 0)
      {
        int i = localan.c;
        bool1 = bool2;
        if (i == 200) {
          bool1 = true;
        }
      }
      return;
    }
    catch (Throwable localThrowable) {}finally
    {
      aq.a(this.c, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.g.ar
 * JD-Core Version:    0.7.0.1
 */