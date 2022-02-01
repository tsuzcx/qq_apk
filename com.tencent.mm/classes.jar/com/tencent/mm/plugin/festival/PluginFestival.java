package com.tencent.mm.plugin.festival;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class PluginFestival
  extends f
  implements c, com.tencent.mm.plugin.festival.a.b
{
  public final void configure(g paramg) {}
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(260910);
    if (paramg.bbA())
    {
      Log.i("MicroMsg.PluginFestival", "execute");
      h.b(com.tencent.mm.plugin.festival.a.a.class, new com.tencent.mm.plugin.festival.b.b());
    }
    AppMethodBeat.o(260910);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(260896);
    alias(com.tencent.mm.plugin.festival.a.b.class);
    AppMethodBeat.o(260896);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(260915);
    Log.i("MicroMsg.PluginFestival", "onAccountInitialized");
    paramc = com.tencent.mm.plugin.festival.b.a.Are;
    com.tencent.mm.plugin.festival.b.a.execute();
    AppMethodBeat.o(260915);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(260920);
    Log.i("MicroMsg.PluginFestival", "onAccountRelease");
    AppMethodBeat.o(260920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.PluginFestival
 * JD-Core Version:    0.7.0.1
 */