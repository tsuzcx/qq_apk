package com.tencent.mm.br;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class d$10
  implements b
{
  d$10(String paramString) {}
  
  public final void j(Exception paramException)
  {
    AppMethodBeat.i(133705);
    ae.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.FEQ });
    ae.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramException });
    AppMethodBeat.o(133705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.br.d.10
 * JD-Core Version:    0.7.0.1
 */