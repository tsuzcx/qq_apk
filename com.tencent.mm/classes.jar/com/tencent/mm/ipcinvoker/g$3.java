package com.tencent.mm.ipcinvoker;

final class g$3
  implements Runnable
{
  g$3(String paramString) {}
  
  public final void run()
  {
    b localb = b.BT();
    String str = this.dGw;
    if (e.fE(str))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", new Object[] { str });
      return;
    }
    localb.fB(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.g.3
 * JD-Core Version:    0.7.0.1
 */