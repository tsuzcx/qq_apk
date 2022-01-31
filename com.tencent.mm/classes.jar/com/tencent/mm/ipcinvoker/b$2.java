package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class b$2
  implements Runnable
{
  b$2(b paramb, b.a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(114009);
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", new Object[] { Integer.valueOf(this.eDY.hashCode()), Long.valueOf(Thread.currentThread().getId()) });
    if (!this.eDY.eEd)
    {
      AppMethodBeat.o(114009);
      return;
    }
    synchronized (this.eDY)
    {
      if (!this.eDY.eEd)
      {
        AppMethodBeat.o(114009);
        return;
      }
      this.eDY.eEd = false;
      this.eDY.notifyAll();
      this.eDY.eEe = null;
    }
    synchronized (b.a(this.eEa))
    {
      b.a(this.eEa).remove(this.eDZ);
      AppMethodBeat.o(114009);
      return;
      localObject2 = finally;
      AppMethodBeat.o(114009);
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.2
 * JD-Core Version:    0.7.0.1
 */