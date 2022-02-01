package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.y;

final class PluginBrandService$6
  extends n.a
{
  PluginBrandService$6(PluginBrandService paramPluginBrandService) {}
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(209432);
    paramString = c.EIZ;
    if (c.eYK())
    {
      paramString = c.EIZ;
      if (c.eYL()) {
        break label56;
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramString = c.EIZ;
        c.eYN();
      }
      if (y.fpG()) {
        y.aaK(y.IoQ);
      }
      AppMethodBeat.o(209432);
      return;
      label56:
      bool = c.bNe().getBoolean("biz_time_preload_at_foreground", false);
      ad.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy foregroundPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.6
 * JD-Core Version:    0.7.0.1
 */