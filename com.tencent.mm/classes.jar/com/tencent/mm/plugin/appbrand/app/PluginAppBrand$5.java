package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;

final class PluginAppBrand$5
  implements com.tencent.mm.kernel.api.g
{
  PluginAppBrand$5(PluginAppBrand paramPluginAppBrand) {}
  
  public final void BN()
  {
    AppMethodBeat.i(154848);
    ((e)com.tencent.mm.kernel.g.E(e.class)).initialize();
    AppMethodBeat.o(154848);
  }
  
  public final void br(boolean paramBoolean)
  {
    AppMethodBeat.i(154849);
    ((e)com.tencent.mm.kernel.g.E(e.class)).shutdown();
    ((e)com.tencent.mm.kernel.g.E(e.class)).ack().exit();
    AppMethodBeat.o(154849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.5
 * JD-Core Version:    0.7.0.1
 */