package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.e.a;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  public static void a(String paramString, int paramInt, long paramLong, e.a parama)
  {
    AppMethodBeat.i(184362);
    int i = -1;
    if (parama == e.a.qPh)
    {
      i = 7;
      if ((b.cnC()) && (!com.tencent.mm.plugin.expt.g.d.crm()))
      {
        if (parama != e.a.qPh) {
          break label132;
        }
        g.yhR.idkeyStat(932L, 91L, 1L, false);
      }
    }
    for (;;)
    {
      ad.i("HABBYGE-MALI.HellFrontBackReport", "report 切换-前后台(3): %d, %s 未登录", new Object[] { Integer.valueOf(i), paramString });
      ad.i("HABBYGE-MALI.HellFrontBackReport", "report 切换-前后台(3): %d, %s", new Object[] { Integer.valueOf(i), paramString });
      com.tencent.mm.plugin.expt.g.d.crl().b(paramString, parama, paramInt, paramLong);
      AppMethodBeat.o(184362);
      return;
      if (parama != e.a.qPi) {
        break;
      }
      i = 8;
      break;
      label132:
      if (parama == e.a.qPi) {
        g.yhR.idkeyStat(932L, 92L, 1L, false);
      }
    }
  }
  
  static void a(String paramString, e.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122040);
    com.tencent.mm.plugin.expt.g.d.crl().a(paramString, parama, paramInt, paramLong);
    AppMethodBeat.o(122040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.d
 * JD-Core Version:    0.7.0.1
 */