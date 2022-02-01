package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.c.a;
import java.util.Map;

public enum f
  implements o
{
  static
  {
    AppMethodBeat.i(44381);
    jqe = new f("INSTANCE");
    jqf = new f[] { jqe };
    AppMethodBeat.o(44381);
  }
  
  private f() {}
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(44379);
    paramString = (String)paramMap.get(".sysmsg.WeAppSyncCommand.Base64JsonContent");
    if (!bs.isNullOrNil(paramString)) {
      g.eo(paramString).j(new a()
      {
        private static Void IB(String paramAnonymousString)
        {
          AppMethodBeat.i(44375);
          try
          {
            f.IA(paramAnonymousString);
            AppMethodBeat.o(44375);
            return null;
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.AppBrand.PredownloadXmlProcessor", paramAnonymousString, "process pbBase64", new Object[0]);
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