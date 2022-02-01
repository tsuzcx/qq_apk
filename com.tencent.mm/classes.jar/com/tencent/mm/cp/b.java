package com.tencent.mm.cp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  private long agWG;
  private final byte[] mLock;
  
  public b()
  {
    AppMethodBeat.i(158417);
    this.mLock = new byte[1];
    this.agWG = -1L;
    AppMethodBeat.o(158417);
  }
  
  public final void done()
  {
    AppMethodBeat.i(158419);
    synchronized (this.mLock)
    {
      if (this.mLock[0] != 0)
      {
        this.mLock[0] = 0;
        this.agWG = -1L;
        this.mLock.notifyAll();
        l.d("MicroMsg.WxConsumedLock", "notify done %s", new Object[] { this });
      }
      AppMethodBeat.o(158419);
      return;
    }
  }
  
  public final void jPW()
  {
    AppMethodBeat.i(158418);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mLock[0] == 0)
        {
          this.mLock[0] = 1;
          this.agWG = Thread.currentThread().getId();
          l.d("MicroMsg.WxConsumedLock", "lock %s", new Object[] { this });
          AppMethodBeat.o(158418);
          return;
        }
        try
        {
          if (this.agWG != Thread.currentThread().getId())
          {
            l.d("MicroMsg.WxConsumedLock", "lock waiting %s", new Object[] { this });
            this.mLock.wait();
            l.d("MicroMsg.WxConsumedLock", "unlock waiting %s", new Object[] { this });
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.printErrStackTrace("MicroMsg.WxConsumedLock", localInterruptedException, "", new Object[0]);
        }
      }
      l.d("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", new Object[] { this });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cp.b
 * JD-Core Version:    0.7.0.1
 */