package com.tencent.mm.cm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class j
{
  public final byte[] eFQ;
  
  public j()
  {
    AppMethodBeat.i(115295);
    this.eFQ = new byte[1];
    AppMethodBeat.o(115295);
  }
  
  public final void dTh()
  {
    AppMethodBeat.i(115296);
    synchronized (this.eFQ)
    {
      if (this.eFQ[0] != 0) {
        ab.i("MicroMsg.WxTimeoutLock", "no need lock %s", new Object[] { this });
      }
      for (;;)
      {
        AppMethodBeat.o(115296);
        return;
        try
        {
          this.eFQ.wait(3000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          ab.printErrStackTrace("MicroMsg.WxTimeoutLock", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cm.j
 * JD-Core Version:    0.7.0.1
 */