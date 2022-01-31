package com.tencent.mm.cm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  private long AZx;
  private final byte[] eFQ;
  
  public b()
  {
    AppMethodBeat.i(123364);
    this.eFQ = new byte[1];
    this.AZx = -1L;
    AppMethodBeat.o(123364);
  }
  
  public final void dTf()
  {
    AppMethodBeat.i(123365);
    for (;;)
    {
      synchronized (this.eFQ)
      {
        if (this.eFQ[0] == 0)
        {
          this.eFQ[0] = 1;
          this.AZx = Thread.currentThread().getId();
          j.i("MicroMsg.WxConsumedLock", "lock %s", new Object[] { this });
          AppMethodBeat.o(123365);
          return;
        }
        try
        {
          if (this.AZx != Thread.currentThread().getId())
          {
            j.i("MicroMsg.WxConsumedLock", "lock waiting %s", new Object[] { this });
            this.eFQ.wait();
            j.d("MicroMsg.WxConsumedLock", "unlock waiting %s", new Object[] { this });
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.printErrStackTrace("MicroMsg.WxConsumedLock", localInterruptedException, "", new Object[0]);
        }
      }
      j.d("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", new Object[] { this });
    }
  }
  
  public final void done()
  {
    AppMethodBeat.i(123366);
    synchronized (this.eFQ)
    {
      if (this.eFQ[0] != 0)
      {
        this.eFQ[0] = 0;
        this.AZx = -1L;
        this.eFQ.notifyAll();
        j.i("MicroMsg.WxConsumedLock", "notify done %s", new Object[] { this });
      }
      AppMethodBeat.o(123366);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cm.b
 * JD-Core Version:    0.7.0.1
 */