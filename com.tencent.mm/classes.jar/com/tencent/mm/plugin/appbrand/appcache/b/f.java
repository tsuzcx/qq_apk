package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.c.a;
import java.util.Map;

public enum f
  implements p
{
  static
  {
    AppMethodBeat.i(44381);
    jMY = new f("INSTANCE");
    jMZ = new f[] { jMY };
    AppMethodBeat.o(44381);
  }
  
  private f() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(44379);
    paramString = (String)paramMap.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
    if (!bu.isNullOrNil(paramString)) {
      g.eu(paramString).j(new a()
      {
        private static Void Mv(String paramAnonymousString)
        {
          AppMethodBeat.i(44375);
          try
          {
            f.Mu(paramAnonymousString);
            AppMethodBeat.o(44375);
            return null;
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", paramAnonymousString, "process pbBase64", new Object[0]);
            }
          }
        }
      });
    }
    AppMethodBeat.o(44379);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.f
 * JD-Core Version:    0.7.0.1
 */