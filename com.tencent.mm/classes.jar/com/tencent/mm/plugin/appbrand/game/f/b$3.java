package com.tencent.mm.plugin.appbrand.game.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.ac;

final class b$3
  implements IPCRunCgi.a
{
  b$3(b paramb) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
  {
    AppMethodBeat.i(45169);
    ac.i("MicroMsg.WAGameCanvasSecurityGuard", "hy: trigger upload with data: %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    AppMethodBeat.o(45169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.b.3
 * JD-Core Version:    0.7.0.1
 */