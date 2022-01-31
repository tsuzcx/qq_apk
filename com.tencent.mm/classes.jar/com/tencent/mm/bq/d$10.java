package com.tencent.mm.bq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$10
  implements b
{
  d$10(String paramString) {}
  
  public final void c(Exception paramException)
  {
    AppMethodBeat.i(114694);
    ab.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.wgS });
    ab.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramException });
    AppMethodBeat.o(114694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bq.d.10
 * JD-Core Version:    0.7.0.1
 */