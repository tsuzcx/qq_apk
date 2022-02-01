package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class PluginAppBrand$3
  implements com.tencent.mm.kernel.api.g
{
  PluginAppBrand$3(PluginAppBrand paramPluginAppBrand) {}
  
  public final void aDv()
  {
    AppMethodBeat.i(317718);
    ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).initialize();
    AppMethodBeat.o(317718);
  }
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(317723);
    ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).shutdown();
    ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEI().exit();
    AppMethodBeat.o(317723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.PluginAppBrand.3
 * JD-Core Version:    0.7.0.1
 */