package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.c.azg;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.qw;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class o$a$1
  implements am.a
{
  o$a$1(o.a parama) {}
  
  public final boolean tC()
  {
    if ((g.DK()) && (!a.CW()))
    {
      g.DQ();
      if (g.DP() != null)
      {
        g.DQ();
        if (g.DP().Dz() != null) {
          break label108;
        }
      }
    }
    Object localObject = this.etV.etT;
    boolean bool1 = g.DK();
    boolean bool2 = a.CW();
    g.DQ();
    y.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", new Object[] { localObject, Boolean.valueOf(bool1), Boolean.valueOf(bool2), g.DP() });
    this.etV.etS.iU(0);
    return false;
    label108:
    localObject = this.etV.etR.sIl.hPT;
    c localc = new c();
    localc.bp(this.etV.etT);
    long l1 = bk.UY();
    long l2;
    do
    {
      if (this.etV.esB >= ((LinkedList)localObject).size()) {
        break;
      }
      ((LinkedList)localObject).size();
      if (!localc.a((qv)((LinkedList)localObject).get(this.etV.esB), false)) {
        f.nEG.a(99L, 46L, 1L, false);
      }
      o.a locala = this.etV;
      locala.esB += 1;
      l2 = bk.co(l1);
      y.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", new Object[] { this.etV.etT, Long.valueOf(l2), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(this.etV.esB - 1) });
    } while (l2 < 500L);
    localc.bq(this.etV.etT);
    if (this.etV.esB < ((LinkedList)localObject).size())
    {
      y.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", new Object[] { this.etV.etT, Long.valueOf(bk.co(l1)), Integer.valueOf(((LinkedList)localObject).size()), Integer.valueOf(this.etV.esB - 1) });
      return true;
    }
    o.a(this.etV.etQ, this.etV.etR, this.etV.etT);
    this.etV.etS.iU(((LinkedList)localObject).size());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.o.a.1
 * JD-Core Version:    0.7.0.1
 */