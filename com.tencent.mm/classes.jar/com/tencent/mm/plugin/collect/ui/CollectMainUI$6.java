package com.tencent.mm.plugin.collect.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.ui.widget.b.e.c;

final class CollectMainUI$6
  implements e.c
{
  CollectMainUI$6(CollectMainUI paramCollectMainUI) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(41257);
    if (CollectMainUI.d(this.kSz) != null)
    {
      CollectMainUI.dE(CollectMainUI.d(this.kSz).username, CollectMainUI.d(this.kSz).iFJ);
      h.qsU.e(15387, new Object[] { Integer.valueOf(3) });
    }
    AppMethodBeat.o(41257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.6
 * JD-Core Version:    0.7.0.1
 */