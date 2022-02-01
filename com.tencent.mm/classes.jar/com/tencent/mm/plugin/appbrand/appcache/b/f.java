package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import java.util.Map;

public enum f
  implements o
{
  static
  {
    AppMethodBeat.i(44381);
    iPU = new f("INSTANCE");
    iPV = new f[] { iPU };
    AppMethodBeat.o(44381);
  }
  
  private f() {}
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(44379);
    paramString = (String)paramMap.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
    if (!bt.isNullOrNil(paramString)) {
      g.en(paramString).j(new a()
      {
        private static Void Ey(String paramAnonymousString)
        {
          AppMethodBeat.i(44375);
          try
          {
            f.Ex(paramAnonymousString);
            AppMethodBeat.o(44375);
            return null;
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", paramAnonymousString, "process pbBase64", new Object[0]);
            }
          }
        }
      });
    }
    AppMethodBeat.o(44379);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.f
 * JD-Core Version:    0.7.0.1
 */