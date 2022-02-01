package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.e.a;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
{
  public static void a(String paramString, int paramInt, long paramLong, e.a parama)
  {
    AppMethodBeat.i(184362);
    int i = -1;
    if (parama == e.a.qiu)
    {
      i = 7;
      if ((b.ciE()) && (!com.tencent.mm.plugin.expt.d.d.clP()))
      {
        if (parama != e.a.qiu) {
          break label132;
        }
        h.wUl.idkeyStat(932L, 91L, 1L, false);
      }
    }
    for (;;)
    {
      ac.i("HellFrontBackReport", "habbyge-mali, report 切换-前后台(3): %d, %s 未登录", new Object[] { Integer.valueOf(i), paramString });
      ac.i("HellFrontBackReport", "habbyge-mali, report 切换-前后台(3): %d, %s", new Object[] { Integer.valueOf(i), paramString });
      com.tencent.mm.plugin.expt.d.d.clO().b(paramString, parama, paramInt, paramLong);
      AppMethodBeat.o(184362);
      return;
      if (parama != e.a.qiv) {
        break;
      }
      i = 8;
      break;
      label132:
      if (parama == e.a.qiv) {
        h.wUl.idkeyStat(932L, 92L, 1L, false);
      }
    }
  }
  
  static void a(String paramString, e.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122040);
    com.tencent.mm.plugin.expt.d.d.clO().a(paramString, parama, paramInt, paramLong);
    AppMethodBeat.o(122040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.d
 * JD-Core Version:    0.7.0.1
 */