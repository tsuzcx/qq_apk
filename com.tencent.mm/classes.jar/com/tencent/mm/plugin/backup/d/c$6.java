package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.k;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$6
  implements f
{
  c$6(c paramc) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(17251);
    com.tencent.mm.plugin.backup.g.b.b(3, c.h(this.jBL));
    ab.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:".concat(String.valueOf(paramString)));
      b.aTr().aSL().jyN = -5;
      this.jBL.rf(-5);
      AppMethodBeat.o(17251);
      return;
    }
    paramString = (k)paramm;
    paramm = paramString.jGg;
    if (!b.aTr().jyF.equals(paramm.ID))
    {
      ab.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
      b.aTr().aSL().jyN = -5;
      this.jBL.rf(-5);
      AppMethodBeat.o(17251);
      return;
    }
    b.aTr().aSL().jyV = paramm.jJK;
    this.jBL.bYu = paramString.jGg.jJN.jJD;
    label381:
    long l;
    if (paramString.jGg.jJN.jJG.toLowerCase().contains("ios"))
    {
      c.a(this.jBL, 1);
      c.a(this.jBL, paramString.jGg.jJR);
      c.b(this.jBL, com.tencent.mm.vfs.e.avI(com.tencent.mm.kernel.g.RL().Rs()));
      b.aTr().aSL().jyW = c.i(this.jBL);
      c.b(this.jBL, paramString.jGg.jJT);
      ab.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d], dbSize[%d], and wait old mobile's pushData", new Object[] { Long.valueOf(paramString.jGg.jJQ), Long.valueOf(paramString.jGg.jJR), Long.valueOf(c.i(this.jBL)) });
      if ((c.j(this.jBL)) && (c.f(this.jBL)))
      {
        paramm = h.qsU;
        if ((!c.k(this.jBL)) && (c.l(this.jBL) != 1)) {
          break label644;
        }
        paramInt1 = 66;
        paramm.idkeyStat(485L, paramInt1, 1L, false);
      }
      if (paramString.jGg.jJP != 3) {
        break label650;
      }
      paramInt1 = 1;
      label406:
      if (paramInt1 == 0) {
        break label655;
      }
      c.c(this.jBL, true);
      ab.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
      label426:
      paramString = new PLong();
      paramm = new PLong();
      aw.aaz();
      com.tencent.mm.plugin.backup.b.g.a(paramString, paramm, com.tencent.mm.model.c.getAccPath());
      l = c.m(this.jBL);
      if (c.m(this.jBL) * 0.1D <= 524288000.0D) {
        break label667;
      }
    }
    label644:
    label650:
    label655:
    label667:
    for (double d = 524288000.0D;; d = c.m(this.jBL) * 0.1D)
    {
      l = d + l;
      this.jBL.jBH = l;
      if (paramm.value >= l) {
        break label684;
      }
      ab.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[] { Long.valueOf(paramm.value), Long.valueOf(l), Long.valueOf(c.m(this.jBL)) });
      h.qsU.e(11787, new Object[] { Integer.valueOf(5) });
      b.aTr().aTs().stop();
      b.aTr().aSL().jyN = -13;
      this.jBL.rf(-13);
      h.qsU.idkeyStat(485L, 5L, 1L, false);
      AppMethodBeat.o(17251);
      return;
      c.a(this.jBL, 2);
      break;
      paramInt1 = 65;
      break label381;
      paramInt1 = 0;
      break label406;
      c.c(this.jBL, false);
      break label426;
    }
    label684:
    c.c(this.jBL, bo.aoy());
    com.tencent.mm.plugin.backup.g.b.aUn();
    AppMethodBeat.o(17251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.6
 * JD-Core Version:    0.7.0.1
 */