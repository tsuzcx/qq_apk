package com.tencent.mm.ipcinvoker;

import java.util.Map;

final class b$2
  implements Runnable
{
  b$2(b paramb, b.a parama, String paramString) {}
  
  public final void run()
  {
    com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", new Object[] { Integer.valueOf(this.dGv.hashCode()), Long.valueOf(Thread.currentThread().getId()) });
    if (!this.dGv.dGB) {
      return;
    }
    synchronized (this.dGv)
    {
      if (!this.dGv.dGB) {
        return;
      }
    }
    this.dGv.dGB = false;
    this.dGv.notifyAll();
    this.dGv.dGC = null;
    synchronized (b.a(this.dGx))
    {
      b.a(this.dGx).remove(this.dGw);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.b.2
 * JD-Core Version:    0.7.0.1
 */