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
    AppMethodBeat.i(258606);
    if (paramg.aIE())
    {
      Log.i("MicroMsg.PluginFestival", "execute");
      h.b(com.tencent.mm.plugin.festival.a.a.class, new com.tencent.mm.plugin.festival.b.b());
    }
    AppMethodBeat.o(258606);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(258603);
    alias(com.tencent.mm.plugin.festival.a.b.class);
    AppMethodBeat.o(258603);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(258611);
    Log.i("MicroMsg.PluginFestival", "onAccountInitialized");
    paramc = com.tencent.mm.plugin.festival.b.a.wUv;
    com.tencent.mm.plugin.festival.b.a.execute();
    AppMethodBeat.o(258611);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(258613);
    Log.i("MicroMsg.PluginFestival", "onAccountRelease");
    AppMethodBeat.o(258613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.festival.PluginFestival
 * JD-Core Version:    0.7.0.1
 */