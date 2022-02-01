package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import java.util.List;

public final class t
  implements n
{
  public final WxaAttributes Nt(String paramString)
  {
    AppMethodBeat.i(44876);
    paramString = j.aYP().d(paramString, new String[0]);
    AppMethodBeat.o(44876);
    return paramString;
  }
  
  public final WxaAttributes Nu(String paramString)
  {
    AppMethodBeat.i(44877);
    paramString = j.aYP().e(paramString, new String[0]);
    AppMethodBeat.o(44877);
    return paramString;
  }
  
  public final e<WxaAttributes> Nv(final String paramString)
  {
    AppMethodBeat.i(44879);
    paramString = g.er(paramString).b(new a() {});
    AppMethodBeat.o(44879);
    return paramString;
  }
  
  public final void a(String paramString, final com.tencent.mm.plugin.appbrand.service.n.a parama)
  {
    AppMethodBeat.i(44878);
    x.a(paramString, false, new x.b() {});
    AppMethodBeat.o(44878);
  }
  
  public final void b(String paramString, final com.tencent.mm.plugin.appbrand.service.n.a parama)
  {
    AppMethodBeat.i(44880);
    x.a(paramString, true, new x.b() {});
    AppMethodBeat.o(44880);
  }
  
  public final void bd(List<String> paramList)
  {
    AppMethodBeat.i(44881);
    if (bt.hj(paramList))
    {
      AppMethodBeat.o(44881);
      return;
    }
    ad.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[] { bt.m(paramList, ", ") });
    x.a(paramList, n.a.jYD, null);
    AppMethodBeat.o(44881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */