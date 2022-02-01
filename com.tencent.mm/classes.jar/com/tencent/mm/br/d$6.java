package com.tencent.mm.br;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class d$6
  implements b
{
  d$6(String paramString) {}
  
  public final void j(Exception paramException)
  {
    AppMethodBeat.i(133701);
    ae.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", new Object[] { this.FEQ });
    ae.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", new Object[] { paramException });
    AppMethodBeat.o(133701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.br.d.6
 * JD-Core Version:    0.7.0.1
 */