package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.c.a;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  public static void a(String paramString, int paramInt, c.a parama)
  {
    AppMethodBeat.i(73458);
    int i = -1;
    if (parama == c.a.lZt)
    {
      i = 7;
      if ((b.brt()) && (!com.tencent.mm.plugin.expt.c.d.bsQ()))
      {
        if (parama != c.a.lZt) {
          break label143;
        }
        h.qsU.idkeyStat(932L, 91L, 1L, false);
      }
    }
    for (;;)
    {
      ab.i("HellFrontBackReport", "habbyge-mali, report 切换-前后台(3): " + i + " / " + paramString + " 未登录");
      ab.i("HellFrontBackReport", "habbyge-mali, report 切换-前后台(3): " + i + " / " + paramString);
      com.tencent.mm.plugin.expt.c.d.bsP().a(paramString, parama, paramInt);
      AppMethodBeat.o(73458);
      return;
      if (parama != c.a.lZu) {
        break;
      }
      i = 8;
      break;
      label143:
      if (parama == c.a.lZu) {
        h.qsU.idkeyStat(932L, 92L, 1L, false);
      }
    }
  }
  
  static void a(String paramString, c.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(73459);
    com.tencent.mm.plugin.expt.c.d.bsP().a(paramString, parama, paramInt, paramLong);
    AppMethodBeat.o(73459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.d
 * JD-Core Version:    0.7.0.1
 */