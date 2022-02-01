package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.storage.u;
import java.util.Map;

final class PluginBrandService$8
  implements p
{
  PluginBrandService$8(PluginBrandService paramPluginBrandService) {}
  
  public final void onNewXmlReceived(String paramString, final Map<String, String> paramMap, final f.a parama)
  {
    AppMethodBeat.i(5548);
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(5547);
        u.d(paramMap, parama);
        AppMethodBeat.o(5547);
      }
    }, 0L);
    AppMethodBeat.o(5548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.8
 * JD-Core Version:    0.7.0.1
 */