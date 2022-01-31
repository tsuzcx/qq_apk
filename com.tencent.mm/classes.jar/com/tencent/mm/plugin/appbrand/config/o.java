package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.appbrand.service.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.e;
import java.util.List;

public final class o
  implements i
{
  public final WxaAttributes Ae(String paramString)
  {
    AppMethodBeat.i(129876);
    paramString = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString, new String[0]);
    AppMethodBeat.o(129876);
    return paramString;
  }
  
  public final WxaAttributes Af(String paramString)
  {
    AppMethodBeat.i(129877);
    paramString = com.tencent.mm.plugin.appbrand.app.g.auF().e(paramString, new String[0]);
    AppMethodBeat.o(129877);
    return paramString;
  }
  
  public final e<WxaAttributes> Ag(String paramString)
  {
    AppMethodBeat.i(129879);
    paramString = com.tencent.mm.cm.g.cT(paramString).b(new o.2(this, paramString));
    AppMethodBeat.o(129879);
    return paramString;
  }
  
  public final void a(String paramString, i.a parama)
  {
    AppMethodBeat.i(129878);
    s.a(paramString, false, new o.1(this, parama));
    AppMethodBeat.o(129878);
  }
  
  public final void aC(List<String> paramList)
  {
    AppMethodBeat.i(129881);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(129881);
      return;
    }
    ab.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[] { bo.d(paramList, ", ") });
    s.a(paramList, k.a.hjl);
    AppMethodBeat.o(129881);
  }
  
  public final void b(String paramString, i.a parama)
  {
    AppMethodBeat.i(129880);
    if (bo.isNullOrNil(paramString))
    {
      if (parama != null) {
        parama.d(null);
      }
      AppMethodBeat.o(129880);
      return;
    }
    al localal = new al();
    new ak(localal.oNc.getLooper()).post(new o.3(this, parama, paramString, localal));
    AppMethodBeat.o(129880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */