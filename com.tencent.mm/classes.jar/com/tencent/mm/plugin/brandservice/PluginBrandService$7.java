package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import java.util.Map;

final class PluginBrandService$7
  implements p
{
  PluginBrandService$7(PluginBrandService paramPluginBrandService) {}
  
  public final void onNewXmlReceived(String paramString, final Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(5546);
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5545);
        com.tencent.mm.plugin.brandservice.b.b localb = com.tencent.mm.plugin.brandservice.b.b.mSC;
        com.tencent.mm.plugin.brandservice.b.b.R(paramMap);
        AppMethodBeat.o(5545);
      }
    }, 0L);
    AppMethodBeat.o(5546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.7
 * JD-Core Version:    0.7.0.1
 */