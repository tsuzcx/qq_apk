package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;

final class CleanNewUI$6
  implements c
{
  CleanNewUI$6(CleanNewUI paramCleanNewUI) {}
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, HashSet<String> paramHashSet, HashMap<String, Long> paramHashMap)
  {
    AppMethodBeat.i(18818);
    CleanNewUI.a(this.kIY, bo.aoy());
    CleanNewUI localCleanNewUI = this.kIY;
    j.bhb().kGr = paramLong1;
    j.bhb().kGs = paramLong2;
    j.bhb().kGt = paramLong3;
    j.bhb().kHe = paramHashMap;
    j.bhb().kGS = paramHashSet;
    al.d(new CleanNewUI.8(localCleanNewUI, paramLong1));
    h.qsU.idkeyStat(714L, 53L, 1L, false);
    paramLong1 = CleanNewUI.g(this.kIY) - CleanNewUI.h(this.kIY);
    paramLong2 = CleanNewUI.i(this.kIY) - CleanNewUI.j(this.kIY);
    ab.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", new Object[] { Long.valueOf(CleanNewUI.g(this.kIY)), Long.valueOf(CleanNewUI.h(this.kIY)), Long.valueOf(paramLong1), Long.valueOf(CleanNewUI.i(this.kIY)), Long.valueOf(CleanNewUI.j(this.kIY)), Long.valueOf(paramLong2), Long.valueOf(paramLong1 + paramLong2) });
    h.qsU.e(14556, new Object[] { Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.h(this.kIY)), Long.valueOf(CleanNewUI.g(this.kIY)), Long.valueOf(paramLong1) });
    h.qsU.e(14556, new Object[] { Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.j(this.kIY)), Long.valueOf(CleanNewUI.i(this.kIY)), Long.valueOf(paramLong2) });
    h.qsU.e(14556, new Object[] { Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(paramLong1 + paramLong2) });
    AppMethodBeat.o(18818);
  }
  
  public final void dW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18817);
    if (!CleanNewUI.f(this.kIY)) {
      this.kIY.dZ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(18817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.6
 * JD-Core Version:    0.7.0.1
 */