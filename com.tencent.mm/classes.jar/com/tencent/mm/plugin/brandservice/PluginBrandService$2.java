package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.biz.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

final class PluginBrandService$2
  implements q
{
  PluginBrandService$2(PluginBrandService paramPluginBrandService) {}
  
  public final void onNewXmlReceived(String paramString, final Map<String, String> paramMap, final e.a parama)
  {
    AppMethodBeat.i(208381);
    b.a("BrandServiceWorkerThread", new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208380);
        Object localObject = a.nUu;
        Map localMap = paramMap;
        e.a locala = parama;
        if (locala != null) {}
        for (localObject = locala.gte; (localObject == null) || (locala.gte.FNI == null) || (localMap == null); localObject = null)
        {
          ae.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
          AppMethodBeat.o(208380);
          return;
        }
        a.f(localMap, z.a(locala.gte.FNI));
        AppMethodBeat.o(208380);
      }
    }, 0L);
    AppMethodBeat.o(208381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.PluginBrandService.2
 * JD-Core Version:    0.7.0.1
 */