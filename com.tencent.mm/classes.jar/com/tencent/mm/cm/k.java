package com.tencent.mm.cm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;

public final class k
{
  public final byte[] mLock;
  
  public k()
  {
    AppMethodBeat.i(158422);
    this.mLock = new byte[1];
    AppMethodBeat.o(158422);
  }
  
  public final void done()
  {
    AppMethodBeat.i(158423);
    synchronized (this.mLock)
    {
      if (this.mLock[0] == -1)
      {
        this.mLock[0] = 1;
        this.mLock.notifyAll();
        j.i("MicroMsg.WxWaitingLock", "notify done %s", new Object[] { this });
      }
      AppMethodBeat.o(158423);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cm.k
 * JD-Core Version:    0.7.0.1
 */