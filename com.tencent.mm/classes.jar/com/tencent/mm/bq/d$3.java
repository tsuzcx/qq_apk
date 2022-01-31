package com.tencent.mm.bq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$3
  implements b
{
  d$3(String paramString) {}
  
  public final void c(Exception paramException)
  {
    AppMethodBeat.i(114687);
    ab.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", new Object[] { this.wgS });
    ab.e("MicroMsg.PluginHelper", "start activity failed,%s", new Object[] { paramException });
    AppMethodBeat.o(114687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bq.d.3
 * JD-Core Version:    0.7.0.1
 */