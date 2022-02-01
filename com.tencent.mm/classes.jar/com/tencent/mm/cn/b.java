package com.tencent.mm.cn;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  private long JHQ;
  private final byte[] mLock;
  
  public b()
  {
    AppMethodBeat.i(158417);
    this.mLock = new byte[1];
    this.JHQ = -1L;
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
        this.JHQ = -1L;
        this.mLock.notifyAll();
        j.i("MicroMsg.WxConsumedLock", "notify done %s", new Object[] { this });
      }
      AppMethodBeat.o(158419);
      return;
    }
  }
  
  public final void fBb()
  {
    AppMethodBeat.i(158418);
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mLock[0] == 0)
        {
          this.mLock[0] = 1;
          this.JHQ = Thread.currentThread().getId();
          j.i("MicroMsg.WxConsumedLock", "lock %s", new Object[] { this });
          AppMethodBeat.o(158418);
          return;
        }
        try
        {
          if (this.JHQ != Thread.currentThread().getId())
          {
            j.i("MicroMsg.WxConsumedLock", "lock waiting %s", new Object[] { this });
            this.mLock.wait();
            j.d("MicroMsg.WxConsumedLock", "unlock waiting %s", new Object[] { this });
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          ac.printErrStackTrace("MicroMsg.WxConsumedLock", localInterruptedException, "", new Object[0]);
        }
      }
      j.d("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", new Object[] { this });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cn.b
 * JD-Core Version:    0.7.0.1
 */