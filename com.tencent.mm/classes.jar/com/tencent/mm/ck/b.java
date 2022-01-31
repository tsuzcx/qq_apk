package com.tencent.mm.ck;

import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  private final byte[] dIn = new byte[1];
  private long wDg = -1L;
  
  public final void cNA()
  {
    for (;;)
    {
      synchronized (this.dIn)
      {
        if (this.dIn[0] == 0)
        {
          this.dIn[0] = 1;
          this.wDg = Thread.currentThread().getId();
          k.i("MicroMsg.WxConsumedLock", "lock %s", new Object[] { this });
          return;
        }
        try
        {
          if (this.wDg != Thread.currentThread().getId())
          {
            k.i("MicroMsg.WxConsumedLock", "lock waiting %s", new Object[] { this });
            this.dIn.wait();
            k.d("MicroMsg.WxConsumedLock", "unlock waiting %s", new Object[] { this });
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          y.printErrStackTrace("MicroMsg.WxConsumedLock", localInterruptedException, "", new Object[0]);
        }
      }
      k.d("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", new Object[] { this });
    }
  }
  
  public final void done()
  {
    synchronized (this.dIn)
    {
      if (this.dIn[0] != 0)
      {
        this.dIn[0] = 0;
        this.wDg = -1L;
        this.dIn.notifyAll();
        k.i("MicroMsg.WxConsumedLock", "notify done %s", new Object[] { this });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ck.b
 * JD-Core Version:    0.7.0.1
 */