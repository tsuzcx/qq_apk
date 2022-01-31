package com.tencent.mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ax.a;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;

final class PluginAuth$1
  implements ax.a
{
  PluginAuth$1(PluginAuth paramPluginAuth) {}
  
  public final void a(j.h paramh, j.i parami)
  {
    AppMethodBeat.i(123486);
    aa.a(parami.wil, true);
    this.jyi.getHandleAuthResponseCallbacks().a(paramh, parami, true);
    AppMethodBeat.o(123486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auth.PluginAuth.1
 * JD-Core Version:    0.7.0.1
 */