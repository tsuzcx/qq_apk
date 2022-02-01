package com.tencent.mm.cm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class j
{
  public final byte[] mLock;
  
  public j()
  {
    AppMethodBeat.i(125332);
    this.mLock = new byte[1];
    AppMethodBeat.o(125332);
  }
  
  public final void fWM()
  {
    AppMethodBeat.i(125333);
    synchronized (this.mLock)
    {
      if (this.mLock[0] != 0) {
        ae.i("MicroMsg.WxTimeoutLock", "no need lock %s", new Object[] { this });
      }
      for (;;)
      {
        AppMethodBeat.o(125333);
        return;
        try
        {
          this.mLock.wait(3000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ae.printErrStackTrace("MicroMsg.WxTimeoutLock", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cm.j
 * JD-Core Version:    0.7.0.1
 */