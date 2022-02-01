package com.tencent.mm.plugin.lite.b;

import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.plugin.lite.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class g
  implements p
{
  public final h.b a(final String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(198887);
    Log.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml subtype: %s values: %s", new Object[] { paramString, paramMap.toString() });
    if ((!paramMap.containsKey(".sysmsg.mmlite.pkg_cdn_url")) || (!paramMap.containsKey(".sysmsg.mmlite.app_id")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_ecsda_pubkey")) || (!paramMap.containsKey(".sysmsg.mmlite.pkg_md5")))
    {
      AppMethodBeat.o(198887);
      return null;
    }
    parama = new com.tencent.mm.plugin.boots.a.g();
    parama.appId = ((String)paramMap.get(".sysmsg.mmlite.app_id"));
    parama.pkK = ((String)paramMap.get(".sysmsg.mmlite.pkg_cdn_url"));
    parama.pkL = ((String)paramMap.get(".sysmsg.mmlite.pkg_md5"));
    parama.crh = ((String)paramMap.get(".sysmsg.mmlite.pkg_ecsda_pubkey"));
    paramString = new String[2];
    if ((paramMap.containsKey(".sysmsg.mmlite.entry")) && (!((String)paramMap.get(".sysmsg.mmlite.entry")).isEmpty()))
    {
      Log.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml entry:" + (String)paramMap.get(".sysmsg.mmlite.entry"));
      paramString = b.bM((String)paramMap.get(".sysmsg.mmlite.entry"), false);
    }
    for (;;)
    {
      e.yEE.a(parama, "debug", new com.tencent.mm.plugin.lite.launch.a()
      {
        public final void a(WxaLiteAppInfo paramAnonymousWxaLiteAppInfo)
        {
          AppMethodBeat.i(198886);
          Bundle localBundle = new Bundle();
          localBundle.putString("appId", paramAnonymousWxaLiteAppInfo.appId);
          if (paramString[0] != null) {
            localBundle.putString("path", paramString[0]);
          }
          if (paramString[1] != null) {
            localBundle.putString("query", paramString[1]);
          }
          ((com.tencent.mm.plugin.lite.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).a(MMApplicationContext.getContext(), localBundle, false, null);
          AppMethodBeat.o(198886);
        }
        
        public final void dTu() {}
      });
      AppMethodBeat.o(198887);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.g
 * JD-Core Version:    0.7.0.1
 */