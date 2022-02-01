package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.cm.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import java.util.List;

public final class t
  implements o
{
  public final WxaAttributes Ob(String paramString)
  {
    AppMethodBeat.i(44876);
    paramString = j.aZl().d(paramString, new String[0]);
    AppMethodBeat.o(44876);
    return paramString;
  }
  
  public final WxaAttributes Oc(String paramString)
  {
    AppMethodBeat.i(44877);
    paramString = j.aZl().e(paramString, new String[0]);
    AppMethodBeat.o(44877);
    return paramString;
  }
  
  public final e<WxaAttributes> Od(final String paramString)
  {
    AppMethodBeat.i(44879);
    paramString = g.eu(paramString).b(new a() {});
    AppMethodBeat.o(44879);
    return paramString;
  }
  
  public final void a(String paramString, final o.a parama)
  {
    AppMethodBeat.i(44878);
    x.a(paramString, false, new x.b() {});
    AppMethodBeat.o(44878);
  }
  
  public final void b(String paramString, final o.a parama)
  {
    AppMethodBeat.i(44880);
    x.a(paramString, true, new x.b() {});
    AppMethodBeat.o(44880);
  }
  
  public final void bf(List<String> paramList)
  {
    AppMethodBeat.i(44881);
    if (bu.ht(paramList))
    {
      AppMethodBeat.o(44881);
      return;
    }
    ae.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[] { bu.m(paramList, ", ") });
    x.a(paramList, n.a.kbS, null);
    AppMethodBeat.o(44881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */