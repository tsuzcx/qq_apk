package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.storage.y;
import java.util.Map;

final class PluginBrandService$8
  implements q
{
  PluginBrandService$8(PluginBrandService paramPluginBrandService) {}
  
  public final void onNewXmlReceived(String paramString, final Map<String, String> paramMap, final e.a parama)
  {
    AppMethodBeat.i(5546);
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5545);
        y.c(paramMap, parama);
        AppMethodBeat.o(5545);
      }
    }, 0L);
    AppMethodBeat.o(5546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.8
 * JD-Core Version:    0.7.0.1
 */