package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import java.util.Map;

final class PluginBrandService$9
  implements q
{
  PluginBrandService$9(PluginBrandService paramPluginBrandService) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(5548);
    b.a("BrandServiceWorkerThread", new PluginBrandService.9.1(this, paramMap, parama), 0L);
    AppMethodBeat.o(5548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.9
 * JD-Core Version:    0.7.0.1
 */