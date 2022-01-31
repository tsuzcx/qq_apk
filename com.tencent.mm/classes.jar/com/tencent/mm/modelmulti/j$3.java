package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class j$3
  implements am.a
{
  private int etl = 0;
  private long etm = 0L;
  private int etn = 0;
  
  j$3(j paramj) {}
  
  public final boolean tC()
  {
    Object localObject2 = new c();
    if (!g.DK())
    {
      y.e(j.b(this.etj), "syncRespHandler acc is not ready STOP :%s", new Object[] { j.c(this.etj) });
      j.d(this.etj);
      return false;
    }
    if (j.e(this.etj))
    {
      ((c)localObject2).br(this.etj);
      j.d(this.etj);
      return false;
    }
    if ((j.c(this.etj) == null) || (j.c(this.etj).sqj.sIl == null) || (j.c(this.etj).sqj.sIl.hPT == null))
    {
      y.e(j.b(this.etj), "syncRespHandler CmdList is null! Stop Processing :%s", new Object[] { j.c(this.etj) });
      ((c)localObject2).br(this.etj);
      j.d(this.etj);
      return false;
    }
    Object localObject1 = j.c(this.etj).sqj.sIl.hPT;
    ((c)localObject2).bp(this.etj);
    this.etn += 1;
    long l1 = bk.UY();
    int i = 0;
    while (i < 5)
    {
      if (this.etl < ((LinkedList)localObject1).size())
      {
        y.v(j.b(this.etj), "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.etl), Integer.valueOf(((LinkedList)localObject1).size()), Integer.valueOf(((qv)((LinkedList)localObject1).get(this.etl)).sOA), Integer.valueOf(((qv)((LinkedList)localObject1).get(this.etl)).sOB.tFK) });
        ((LinkedList)localObject1).size();
        if (!((c)localObject2).a((qv)((LinkedList)localObject1).get(this.etl), false)) {
          y.w(j.b(this.etj), "DoCmd Failed index:%d", new Object[] { Integer.valueOf(this.etl) });
        }
        this.etl += 1;
      }
      if (this.etl >= ((LinkedList)localObject1).size())
      {
        this.etm += bk.co(l1);
        l2 = bk.co(j.f(this.etj));
        y.i(j.b(this.etj), "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", new Object[] { Integer.valueOf(this.etl), Integer.valueOf(((LinkedList)localObject1).size()), Long.valueOf(l2), Long.valueOf(this.etm), Integer.valueOf(this.etn), j.c(this.etj) });
        this.etj.a(j.c(this.etj));
        ((c)localObject2).bq(this.etj);
        i = bk.g((Integer)f.a((int)this.etm, new int[] { 100, 300, 1000, 3000 }, new Integer[] { Integer.valueOf(240), Integer.valueOf(239), Integer.valueOf(238), Integer.valueOf(237), Integer.valueOf(236) }));
        f.nEG.a(99L, i, 1L, false);
        i = bk.g((Integer)f.a(((LinkedList)localObject1).size(), new int[] { 0, 1, 2, 3, 5, 10 }, new Integer[] { Integer.valueOf(249), Integer.valueOf(248), Integer.valueOf(247), Integer.valueOf(246), Integer.valueOf(245), Integer.valueOf(244), Integer.valueOf(243) }));
        f.nEG.a(99L, i, 1L, false);
        localObject2 = f.nEG;
        int j;
        int k;
        int m;
        int n;
        if (b.foreground)
        {
          l1 = 241L;
          ((f)localObject2).a(99L, l1, 1L, false);
          f.nEG.a(99L, j.g(this.etj), 1L, false);
          f.nEG.a(99L, 0L, 1L, false);
          localObject2 = f.nEG;
          j = ((LinkedList)localObject1).size();
          k = j.g(this.etj);
          m = j.c(this.etj).sqj.sFD;
          l1 = this.etm;
          n = this.etn;
          localObject1 = j.h(this.etj);
          if (!b.foreground) {
            break label962;
          }
        }
        label962:
        for (i = 1;; i = 2)
        {
          ((f)localObject2).f(12063, new Object[] { Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l1), Integer.valueOf(n), localObject1, Integer.valueOf(i) });
          j.d(this.etj);
          return false;
          l1 = 242L;
          break;
        }
      }
      long l2 = bk.co(l1);
      if (l2 > 500L)
      {
        y.d(j.b(this.etj), "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", new Object[] { Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(this.etl), j.c(this.etj) });
        this.etm += bk.co(l1);
        return true;
      }
      i += 1;
    }
    this.etm += bk.co(l1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j.3
 * JD-Core Version:    0.7.0.1
 */