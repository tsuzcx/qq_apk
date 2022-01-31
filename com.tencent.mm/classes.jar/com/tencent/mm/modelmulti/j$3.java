package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class j$3
  implements ap.a
{
  private int fIY = 0;
  private long fIZ = 0L;
  private int fJa = 0;
  
  j$3(j paramj) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(58381);
    Object localObject2 = new c();
    if (!g.RG())
    {
      ab.e(j.b(this.fIW), "syncRespHandler acc is not ready STOP :%s", new Object[] { j.c(this.fIW) });
      j.d(this.fIW);
      AppMethodBeat.o(58381);
      return false;
    }
    if (j.e(this.fIW))
    {
      ((c)localObject2).bV(this.fIW);
      j.d(this.fIW);
      AppMethodBeat.o(58381);
      return false;
    }
    if ((j.c(this.fIW) == null) || (j.c(this.fIW).wiN.wFU == null) || (j.c(this.fIW).wiN.wFU.jJv == null))
    {
      ab.e(j.b(this.fIW), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { j.c(this.fIW) });
      ((c)localObject2).bV(this.fIW);
      j.d(this.fIW);
      AppMethodBeat.o(58381);
      return false;
    }
    Object localObject1 = j.c(this.fIW).wiN.wFU.jJv;
    ((c)localObject2).bT(this.fIW);
    this.fJa += 1;
    long l1 = bo.aoy();
    int i = 0;
    while (i < 5)
    {
      if (this.fIY < ((LinkedList)localObject1).size())
      {
        ab.v(j.b(this.fIW), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.fIY), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((ud)((LinkedList)localObject1).get(this.fIY)).wMC), Integer.valueOf(((ud)((LinkedList)localObject1).get(this.fIY)).wMD.getILen()) });
        ((LinkedList)localObject1).size();
        if (!((c)localObject2).a((ud)((LinkedList)localObject1).get(this.fIY), false)) {
          ab.w(j.b(this.fIW), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.fIY) });
        }
        this.fIY += 1;
      }
      if (this.fIY >= ((LinkedList)localObject1).size())
      {
        this.fIZ += bo.hl(l1);
        l2 = bo.hl(j.f(this.fIW));
        ab.i(j.b(this.fIW), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.fIY), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.fIZ), Integer.valueOf(this.fJa), j.c(this.fIW) });
        this.fIW.a(j.c(this.fIW));
        ((c)localObject2).bU(this.fIW);
        i = bo.g((Integer)e.a((int)this.fIZ, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
        e.qrI.idkeyStat(99L, i, 1L, false);
        i = bo.g((Integer)e.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
        e.qrI.idkeyStat(99L, i, 1L, false);
        localObject2 = e.qrI;
        int j;
        int k;
        int m;
        int n;
        if (b.foreground)
        {
          l1 = 241L;
          ((e)localObject2).idkeyStat(99L, l1, 1L, false);
          e.qrI.idkeyStat(99L, j.g(this.fIW), 1L, false);
          e.qrI.idkeyStat(99L, 0L, 1L, false);
          localObject2 = e.qrI;
          j = ((LinkedList)localObject1).size();
          k = j.g(this.fIW);
          m = j.c(this.fIW).wiN.wBX;
          l1 = this.fIZ;
          n = this.fJa;
          localObject1 = j.h(this.fIW);
          if (!b.foreground) {
            break label987;
          }
        }
        label987:
        for (i = 1;; i = 2)
        {
          ((e)localObject2).e(12063, new Object[] { Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(n), localObject1, Integer.valueOf(i) });
          j.d(this.fIW);
          AppMethodBeat.o(58381);
          return false;
          l1 = 242L;
          break;
        }
      }
      long l2 = bo.hl(l1);
      if (l2 > 500L)
      {
        ab.d(j.b(this.fIW), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.fIY), j.c(this.fIW) });
        this.fIZ += bo.hl(l1);
        AppMethodBeat.o(58381);
        return true;
      }
      i += 1;
    }
    this.fIZ += bo.hl(l1);
    AppMethodBeat.o(58381);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j.3
 * JD-Core Version:    0.7.0.1
 */