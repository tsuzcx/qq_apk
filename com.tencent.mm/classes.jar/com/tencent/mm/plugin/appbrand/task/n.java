package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public enum n
{
  public final int code;
  @Deprecated
  public final int qRV;
  public final Class<? extends v> qRW;
  public final Class<? extends ad> qRX;
  
  static
  {
    AppMethodBeat.i(48433);
    qRS = new n("WASERVICE", 0, 1, 2147483647, com.tencent.mm.plugin.appbrand.service.c.class, ah.class);
    qRT = new n("WAGAME", 1, 2, 2, com.tencent.mm.plugin.appbrand.game.c.class, d.class);
    qRU = new n("NIL", 2, 0, 0, null, null);
    qRY = new n[] { qRS, qRT, qRU };
    AppMethodBeat.o(48433);
  }
  
  private n(int paramInt1, int paramInt2, Class<? extends v> paramClass, Class<? extends ad> paramClass1)
  {
    AppMethodBeat.i(281995);
    this.code = paramInt1;
    if (this.code == 2) {}
    for (this.qRV = cje();; this.qRV = paramInt2)
    {
      this.qRW = paramClass;
      this.qRX = paramClass1;
      AppMethodBeat.o(281995);
      return;
    }
  }
  
  public static int cje()
  {
    AppMethodBeat.i(281998);
    int i = ((b)h.ae(b.class)).a(b.a.vxH, 2);
    Log.i("AppBrandServiceType", "getGameTaskExptNum exp:%d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(281998);
      return 2;
    }
    AppMethodBeat.o(281998);
    return i;
  }
  
  public static n g(LuggageServiceType paramLuggageServiceType)
  {
    AppMethodBeat.i(281996);
    if (paramLuggageServiceType == LuggageServiceType.cBR)
    {
      paramLuggageServiceType = qRU;
      AppMethodBeat.o(281996);
      return paramLuggageServiceType;
    }
    if (paramLuggageServiceType == LuggageServiceType.cBQ)
    {
      paramLuggageServiceType = qRT;
      AppMethodBeat.o(281996);
      return paramLuggageServiceType;
    }
    if (paramLuggageServiceType == LuggageServiceType.cBP)
    {
      paramLuggageServiceType = qRS;
      AppMethodBeat.o(281996);
      return paramLuggageServiceType;
    }
    paramLuggageServiceType = new IllegalStateException("unknown type:" + paramLuggageServiceType.name());
    AppMethodBeat.o(281996);
    throw paramLuggageServiceType;
  }
  
  public static n jA(boolean paramBoolean)
  {
    if (paramBoolean) {
      return qRT;
    }
    return qRS;
  }
  
  public static LuggageServiceType r(n paramn)
  {
    if (paramn == qRS) {
      return LuggageServiceType.cBP;
    }
    if (paramn == qRT) {
      return LuggageServiceType.cBQ;
    }
    return LuggageServiceType.cBR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.n
 * JD-Core Version:    0.7.0.1
 */