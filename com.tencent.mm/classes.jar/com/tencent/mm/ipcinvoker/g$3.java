package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$3
  implements Runnable
{
  g$3(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(114038);
    b localb = b.PK();
    String str = this.eDZ;
    if (e.lZ(str))
    {
      com.tencent.mm.ipcinvoker.h.b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", new Object[] { str });
      AppMethodBeat.o(114038);
      return;
    }
    localb.lW(str);
    AppMethodBeat.o(114038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.g.3
 * JD-Core Version:    0.7.0.1
 */