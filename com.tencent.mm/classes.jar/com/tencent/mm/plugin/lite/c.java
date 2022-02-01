package com.tencent.mm.plugin.lite;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Map;

public final class c
  implements o
{
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(205675);
    ac.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
    if ((!paramMap.containsKey(".sysmsg.mmlite.pkg_cdn_url")) || (!paramMap.containsKey(".sysmsg.mmlite.app_id")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_ecsda_pubkey")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_md5")))
    {
      AppMethodBeat.o(205675);
      return null;
    }
    paramString = new com.tencent.mm.plugin.boots.a.g();
    paramString.appId = ((String)paramMap.get(".sysmsg.mmlite.app_id"));
    paramString.gnO = ((String)paramMap.get(".sysmsg.mmlite.pkg_cdn_url"));
    paramString.ntk = ((String)paramMap.get(".sysmsg.mmlite.pkg_md5"));
    paramString.ntm = ((String)paramMap.get(".sysmsg.mmlite.pkg_ecsda_pubkey"));
    b.tVw.a(paramString, "debug", new com.tencent.mm.plugin.lite.logic.a()
    {
      public final void a(com.tencent.mm.plugin.lite.d.b paramAnonymousb)
      {
        AppMethodBeat.i(205674);
        Bundle localBundle = new Bundle();
        localBundle.putString("appId", paramAnonymousb.field_appId);
        ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.lite.a.a.class)).a(ai.getContext(), localBundle, null);
        AppMethodBeat.o(205674);
      }
      
      public final void cOG() {}
    });
    AppMethodBeat.o(205675);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c
 * JD-Core Version:    0.7.0.1
 */