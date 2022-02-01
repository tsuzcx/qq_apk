package com.tencent.mm.cp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;

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
        l.i("MicroMsg.WxWaitingLock", "notify done %s", new Object[] { this });
      }
      AppMethodBeat.o(158423);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cp.k
 * JD-Core Version:    0.7.0.1
 */