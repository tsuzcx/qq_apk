package com.tencent.mm.plugin.fav.ui.detail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;

final class BaseFavDetailReportUI$3
  implements Runnable
{
  BaseFavDetailReportUI$3(BaseFavDetailReportUI paramBaseFavDetailReportUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(74319);
    this.mzK.mzH.mtl = (((ae)g.G(ae.class)).getFavItemInfoStorage().vU((int)this.mzK.mzH.msZ) + 1);
    h.a(this.mzK.mzH);
    AppMethodBeat.o(74319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI.3
 * JD-Core Version:    0.7.0.1
 */