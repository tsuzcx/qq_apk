package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;

final class CleanNewUI$6
  implements c
{
  CleanNewUI$6(CleanNewUI paramCleanNewUI) {}
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, HashSet<String> paramHashSet, HashMap<String, Long> paramHashMap)
  {
    CleanNewUI.a(this.iDR, bk.UY());
    CleanNewUI localCleanNewUI = this.iDR;
    j.aEb().iBk = paramLong1;
    j.aEb().iBl = paramLong2;
    j.aEb().iBm = paramLong3;
    j.aEb().iBX = paramHashMap;
    j.aEb().iBL = paramHashSet;
    ai.d(new CleanNewUI.8(localCleanNewUI, paramLong1));
    h.nFQ.a(714L, 53L, 1L, false);
    paramLong1 = CleanNewUI.g(this.iDR) - CleanNewUI.h(this.iDR);
    paramLong2 = CleanNewUI.i(this.iDR) - CleanNewUI.j(this.iDR);
    y.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.g(this.iDR)), Long.valueOf(CleanNewUI.h(this.iDR)), Long.valueOf(paramLong1), Long.valueOf(CleanNewUI.i(this.iDR)), Long.valueOf(CleanNewUI.j(this.iDR)), Long.valueOf(paramLong2), Long.valueOf(paramLong1 + paramLong2) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.h(this.iDR)), Long.valueOf(CleanNewUI.g(this.iDR)), Long.valueOf(paramLong1) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.j(this.iDR)), Long.valueOf(CleanNewUI.i(this.iDR)), Long.valueOf(paramLong2) });
    h.nFQ.f(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramLong1 + paramLong2) });
  }
  
  public final void cy(int paramInt1, int paramInt2)
  {
    if (!CleanNewUI.f(this.iDR)) {
      this.iDR.cB(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.6
 * JD-Core Version:    0.7.0.1
 */