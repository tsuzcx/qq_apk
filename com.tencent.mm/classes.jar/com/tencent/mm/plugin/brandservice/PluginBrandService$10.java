package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import java.util.Map;

final class PluginBrandService$10
  implements q
{
  PluginBrandService$10(PluginBrandService paramPluginBrandService) {}
  
  public final void onNewXmlReceived(String paramString, final Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(208389);
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208388);
        a locala = a.obW;
        a.Y(paramMap);
        AppMethodBeat.o(208388);
      }
    }, 0L);
    AppMethodBeat.o(208389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.10
 * JD-Core Version:    0.7.0.1
 */