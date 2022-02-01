package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public enum l
{
  public final int code;
  public final Class<? extends y> tWA;
  public final Class<? extends ad> tWB;
  @Deprecated
  public final int tWz;
  
  static
  {
    AppMethodBeat.i(48433);
    tWw = new l("WASERVICE", 0, 1, 2147483647, com.tencent.mm.plugin.appbrand.service.c.class, ah.class);
    tWx = new l("WAGAME", 1, 2, 2, com.tencent.mm.plugin.appbrand.game.c.class, d.class);
    tWy = new l("NIL", 2, 0, 0, null, null);
    tWC = new l[] { tWw, tWx, tWy };
    AppMethodBeat.o(48433);
  }
  
  private l(int paramInt1, int paramInt2, Class<? extends y> paramClass, Class<? extends ad> paramClass1)
  {
    AppMethodBeat.i(318543);
    this.code = paramInt1;
    if (this.code == 2) {}
    for (this.tWz = cJY();; this.tWz = paramInt2)
    {
      this.tWA = paramClass;
      this.tWB = paramClass1;
      AppMethodBeat.o(318543);
      return;
    }
  }
  
  public static int cJY()
  {
    AppMethodBeat.i(318558);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLj, 2);
    Log.i("AppBrandServiceType", "getGameTaskExptNum exp:%d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(318558);
      return 2;
    }
    AppMethodBeat.o(318558);
    return i;
  }
  
  public static l g(LuggageServiceType paramLuggageServiceType)
  {
    AppMethodBeat.i(318547);
    if (paramLuggageServiceType == LuggageServiceType.eux)
    {
      paramLuggageServiceType = tWy;
      AppMethodBeat.o(318547);
      return paramLuggageServiceType;
    }
    if (paramLuggageServiceType == LuggageServiceType.euw)
    {
      paramLuggageServiceType = tWx;
      AppMethodBeat.o(318547);
      return paramLuggageServiceType;
    }
    if (paramLuggageServiceType == LuggageServiceType.euv)
    {
      paramLuggageServiceType = tWw;
      AppMethodBeat.o(318547);
      return paramLuggageServiceType;
    }
    paramLuggageServiceType = new IllegalStateException("unknown type:" + paramLuggageServiceType.name());
    AppMethodBeat.o(318547);
    throw paramLuggageServiceType;
  }
  
  public static l kO(boolean paramBoolean)
  {
    if (paramBoolean) {
      return tWx;
    }
    return tWw;
  }
  
  public static LuggageServiceType r(l paraml)
  {
    if (paraml == tWw) {
      return LuggageServiceType.euv;
    }
    if (paraml == tWx) {
      return LuggageServiceType.euw;
    }
    return LuggageServiceType.eux;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.l
 * JD-Core Version:    0.7.0.1
 */