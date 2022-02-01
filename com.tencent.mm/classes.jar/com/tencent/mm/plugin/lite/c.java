package com.tencent.mm.plugin.lite;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.plugin.lite.d.e;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Map;

public final class c
  implements p
{
  public final e.b a(final String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(217761);
    ae.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
    if ((!paramMap.containsKey(".sysmsg.mmlite.pkg_cdn_url")) || (!paramMap.containsKey(".sysmsg.mmlite.app_id")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_ecsda_pubkey")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_md5")))
    {
      AppMethodBeat.o(217761);
      return null;
    }
    parama = new com.tencent.mm.plugin.boots.a.g();
    parama.appId = ((String)paramMap.get(".sysmsg.mmlite.app_id"));
    parama.gKg = ((String)paramMap.get(".sysmsg.mmlite.pkg_cdn_url"));
    parama.nZM = ((String)paramMap.get(".sysmsg.mmlite.pkg_md5"));
    parama.nZO = ((String)paramMap.get(".sysmsg.mmlite.pkg_ecsda_pubkey"));
    paramString = new String[2];
    if ((paramMap.containsKey(".sysmsg.mmlite.entry")) && (!((String)paramMap.get(".sysmsg.mmlite.entry")).isEmpty()))
    {
      ae.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml entry:" + (String)paramMap.get(".sysmsg.mmlite.entry"));
      paramString = com.tencent.mm.plugin.lite.f.b.bx((String)paramMap.get(".sysmsg.mmlite.entry"), false);
    }
    for (;;)
    {
      b.vjN.a(parama, "debug", new com.tencent.mm.plugin.lite.logic.a()
      {
        public final void a(e paramAnonymouse)
        {
          AppMethodBeat.i(217760);
          Bundle localBundle = new Bundle();
          localBundle.putString("appId", paramAnonymouse.field_appId);
          if (paramString[0] != null) {
            localBundle.putString("path", paramString[0]);
          }
          if (paramString[1] != null) {
            localBundle.putString("query", paramString[1]);
          }
          ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.lite.a.a.class)).a(ak.getContext(), localBundle, false, null);
          AppMethodBeat.o(217760);
        }
        
        public final void cZO() {}
      });
      AppMethodBeat.o(217761);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c
 * JD-Core Version:    0.7.0.1
 */