package com.tencent.mm.cm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;

public final class k
{
  public final byte[] eFQ;
  
  public k()
  {
    AppMethodBeat.i(123369);
    this.eFQ = new byte[1];
    AppMethodBeat.o(123369);
  }
  
  public final void done()
  {
    AppMethodBeat.i(123370);
    synchronized (this.eFQ)
    {
      if (this.eFQ[0] == -1)
      {
        this.eFQ[0] = 1;
        this.eFQ.notifyAll();
        j.i("MicroMsg.WxWaitingLock", "notify done %s", new Object[] { this });
      }
      AppMethodBeat.o(123370);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cm.k
 * JD-Core Version:    0.7.0.1
 */