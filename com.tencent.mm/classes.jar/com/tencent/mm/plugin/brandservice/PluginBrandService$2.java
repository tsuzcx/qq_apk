package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

final class PluginBrandService$2
  implements q
{
  PluginBrandService$2(PluginBrandService paramPluginBrandService) {}
  
  public final void onNewXmlReceived(String paramString, final Map<String, String> paramMap, final h.a parama)
  {
    AppMethodBeat.i(194845);
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194844);
        Object localObject = com.tencent.mm.plugin.biz.b.b.pfn;
        Map localMap = paramMap;
        h.a locala = parama;
        if (locala != null) {}
        for (localObject = locala.heO; (localObject == null) || (locala.heO.KHn == null) || (localMap == null); localObject = null)
        {
          Log.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
          AppMethodBeat.o(194844);
          return;
        }
        com.tencent.mm.plugin.biz.b.b.g(localMap, z.a(locala.heO.KHn));
        AppMethodBeat.o(194844);
      }
    }, 0L);
    AppMethodBeat.o(194845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.2
 * JD-Core Version:    0.7.0.1
 */