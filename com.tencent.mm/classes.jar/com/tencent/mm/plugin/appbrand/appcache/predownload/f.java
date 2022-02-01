package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Map;

public enum f
  implements p
{
  static
  {
    AppMethodBeat.i(44381);
    kPf = new f("INSTANCE");
    kPg = new f[] { kPf };
    AppMethodBeat.o(44381);
  }
  
  private f() {}
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(44379);
    paramString = (String)paramMap.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
    if (!Util.isNullOrNil(paramString)) {
      g.ey(paramString).j(new a()
      {
        private static Void VD(String paramAnonymousString)
        {
          AppMethodBeat.i(44375);
          try
          {
            f.VC(paramAnonymousString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.f
 * JD-Core Version:    0.7.0.1
 */