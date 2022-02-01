package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.pluginsdk.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.r;

final class PluginBrandService$8
  extends q.a
{
  PluginBrandService$8(PluginBrandService paramPluginBrandService) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(301474);
    paramString = r.acDM;
    r.emm();
    AppMethodBeat.o(301474);
  }
  
  public final void onAppForeground(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(301470);
    paramString = r.acDM;
    r.eml();
    paramString = c.XNm;
    if (c.iGw())
    {
      paramString = c.XNm;
      if (c.iGx()) {
        break label59;
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramString = c.XNm;
        c.iGz();
      }
      paramString = af.acGt;
      af.ayG(1);
      AppMethodBeat.o(301470);
      return;
      label59:
      bool = c.atj().getBoolean("biz_time_preload_at_foreground", false);
      Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy foregroundPreloadEnable %b", new Object[] { Boolean.valueOf(bool) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.8
 * JD-Core Version:    0.7.0.1
 */