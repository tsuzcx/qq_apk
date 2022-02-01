package com.tencent.mm.plugin.expt.hellhound.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.f.a;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  public static void a(String paramString, int paramInt, long paramLong, f.a parama)
  {
    AppMethodBeat.i(184362);
    int i = -1;
    if (parama == f.a.zxz)
    {
      i = 7;
      if ((b.isMMProcess()) && (!com.tencent.mm.plugin.expt.pageflow.d.dNb()))
      {
        if (parama != f.a.zxz) {
          break label132;
        }
        h.OAn.idkeyStat(932L, 91L, 1L, false);
      }
    }
    for (;;)
    {
      Log.i("HABBYGE-MALI.HellFrontBackReport", "report 切换-前后台(3): %d, %s 未登录", new Object[] { Integer.valueOf(i), paramString });
      Log.i("HABBYGE-MALI.HellFrontBackReport", "report 切换-前后台(3): %d, %s", new Object[] { Integer.valueOf(i), paramString });
      com.tencent.mm.plugin.expt.pageflow.d.dNa().b(paramString, parama, paramInt, paramLong);
      AppMethodBeat.o(184362);
      return;
      if (parama != f.a.zxA) {
        break;
      }
      i = 8;
      break;
      label132:
      if (parama == f.a.zxA) {
        h.OAn.idkeyStat(932L, 92L, 1L, false);
      }
    }
  }
  
  static void a(String paramString, f.a parama, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122040);
    com.tencent.mm.plugin.expt.pageflow.d.dNa().a(paramString, parama, paramInt, paramLong);
    AppMethodBeat.o(122040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.c.d
 * JD-Core Version:    0.7.0.1
 */