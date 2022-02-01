package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.cn.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.e;
import java.util.List;

public final class s
  implements m
{
  public final WxaAttributes Ka(String paramString)
  {
    AppMethodBeat.i(44876);
    paramString = j.aVu().d(paramString, new String[0]);
    AppMethodBeat.o(44876);
    return paramString;
  }
  
  public final WxaAttributes Kb(String paramString)
  {
    AppMethodBeat.i(44877);
    paramString = j.aVu().e(paramString, new String[0]);
    AppMethodBeat.o(44877);
    return paramString;
  }
  
  public final e<WxaAttributes> Kc(final String paramString)
  {
    AppMethodBeat.i(44879);
    paramString = g.eo(paramString).b(new a() {});
    AppMethodBeat.o(44879);
    return paramString;
  }
  
  public final void a(String paramString, final m.a parama)
  {
    AppMethodBeat.i(44878);
    w.a(paramString, false, new w.b() {});
    AppMethodBeat.o(44878);
  }
  
  public final void b(String paramString, final m.a parama)
  {
    AppMethodBeat.i(44880);
    w.a(paramString, true, new w.b() {});
    AppMethodBeat.o(44880);
  }
  
  public final void bb(List<String> paramList)
  {
    AppMethodBeat.i(44881);
    if (bs.gY(paramList))
    {
      AppMethodBeat.o(44881);
      return;
    }
    ac.i("MicroMsg.AppBrand.WxaAttrExportService", "batchSync list %s", new Object[] { bs.n(paramList, ", ") });
    w.a(paramList, n.a.jEB, null);
    AppMethodBeat.o(44881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s
 * JD-Core Version:    0.7.0.1
 */