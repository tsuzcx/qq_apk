package com.tencent.mm.plugin.lite;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Map;

public final class c
  implements p
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(217152);
    ad.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
    if ((!paramMap.containsKey(".sysmsg.mmlite.pkg_cdn_url")) || (!paramMap.containsKey(".sysmsg.mmlite.app_id")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_ecsda_pubkey")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_md5")))
    {
      AppMethodBeat.o(217152);
      return null;
    }
    paramString = new com.tencent.mm.plugin.boots.a.g();
    paramString.appId = ((String)paramMap.get(".sysmsg.mmlite.app_id"));
    paramString.gHx = ((String)paramMap.get(".sysmsg.mmlite.pkg_cdn_url"));
    paramString.nUg = ((String)paramMap.get(".sysmsg.mmlite.pkg_md5"));
    paramString.nUi = ((String)paramMap.get(".sysmsg.mmlite.pkg_ecsda_pubkey"));
    b.uXY.a(paramString, "debug", new com.tencent.mm.plugin.lite.logic.a()
    {
      public final void a(com.tencent.mm.plugin.lite.d.b paramAnonymousb)
      {
        AppMethodBeat.i(217151);
        Bundle localBundle = new Bundle();
        localBundle.putString("appId", paramAnonymousb.field_appId);
        ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.lite.a.a.class)).a(aj.getContext(), localBundle, null);
        AppMethodBeat.o(217151);
      }
      
      public final void cXf() {}
    });
    AppMethodBeat.o(217152);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c
 * JD-Core Version:    0.7.0.1
 */