package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Map;

public enum f
  implements s
{
  static
  {
    AppMethodBeat.i(44381);
    qIT = new f("INSTANCE");
    qIU = new f[] { qIT };
    AppMethodBeat.o(44381);
  }
  
  private f() {}
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(44379);
    paramString = (String)paramMap.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
    if (!Util.isNullOrNil(paramString)) {
      g.ha(paramString).j(new a()
      {
        private static Void VI(String paramAnonymousString)
        {
          AppMethodBeat.i(44375);
          try
          {
            f.VH(paramAnonymousString);
            AppMethodBeat.o(44375);
            return null;
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", paramAnonymousString, "process pbBase64", new Object[0]);
            }
          }
        }
      });
    }
    AppMethodBeat.o(44379);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.f
 * JD-Core Version:    0.7.0.1
 */