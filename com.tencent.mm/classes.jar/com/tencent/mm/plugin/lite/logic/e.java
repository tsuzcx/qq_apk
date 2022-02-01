package com.tencent.mm.plugin.lite.logic;

import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class e
  implements s
{
  public final g.b a(final String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(271380);
    Log.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
    if ((!paramMap.containsKey(".sysmsg.mmlite.pkg_cdn_url")) || (!paramMap.containsKey(".sysmsg.mmlite.app_id")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_ecsda_pubkey")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_md5")))
    {
      AppMethodBeat.o(271380);
      return null;
    }
    parama = new g();
    parama.appId = ((String)paramMap.get(".sysmsg.mmlite.app_id"));
    parama.mOI = ((String)paramMap.get(".sysmsg.mmlite.pkg_cdn_url"));
    parama.vyS = ((String)paramMap.get(".sysmsg.mmlite.pkg_md5"));
    parama.egI = ((String)paramMap.get(".sysmsg.mmlite.pkg_ecsda_pubkey"));
    paramString = new String[2];
    if ((paramMap.containsKey(".sysmsg.mmlite.entry")) && (!((String)paramMap.get(".sysmsg.mmlite.entry")).isEmpty()))
    {
      Log.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml entry:" + (String)paramMap.get(".sysmsg.mmlite.entry"));
      paramString = com.tencent.mm.plugin.lite.b.b.cn((String)paramMap.get(".sysmsg.mmlite.entry"), false);
    }
    for (;;)
    {
      c.KaN.a(parama, "debug", new com.tencent.mm.plugin.lite.api.b()
      {
        public final void b(WxaLiteAppInfo paramAnonymousWxaLiteAppInfo)
        {
          AppMethodBeat.i(271364);
          Bundle localBundle = new Bundle();
          localBundle.putString("appId", paramAnonymousWxaLiteAppInfo.appId);
          if (paramString[0] != null) {
            localBundle.putString("path", paramString[0]);
          }
          if (paramString[1] != null) {
            localBundle.putString("query", paramString[1]);
          }
          ((com.tencent.mm.plugin.lite.api.c)h.ax(com.tencent.mm.plugin.lite.api.c.class)).a(MMApplicationContext.getContext(), localBundle, false, true, null);
          AppMethodBeat.o(271364);
        }
        
        public final void csy() {}
      });
      AppMethodBeat.o(271380);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.e
 * JD-Core Version:    0.7.0.1
 */