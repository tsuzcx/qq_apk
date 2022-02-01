package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.bridge.a.a;
import com.tencent.luggage.bridge.a.a.1;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.ad;

final class PluginAppBrand$6
  implements Runnable
{
  PluginAppBrand$6(PluginAppBrand paramPluginAppBrand, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(44138);
    k localk = new k(this.cTI);
    if (a.cgW != null)
    {
      ad.e("Luggage.LuggageBoot", "do not setup more than once.");
      AppMethodBeat.o(44138);
      return;
    }
    a.cgW = localk;
    localk.a(new a.1());
    AppMethodBeat.o(44138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.6
 * JD-Core Version:    0.7.0.1
 */