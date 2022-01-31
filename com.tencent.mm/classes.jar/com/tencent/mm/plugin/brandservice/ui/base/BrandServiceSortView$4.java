package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.sortview.c;
import java.util.List;

final class BrandServiceSortView$4
  implements Runnable
{
  BrandServiceSortView$4(BrandServiceSortView paramBrandServiceSortView, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(14061);
    ab.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog run");
    List localList = this.jVl.getDatas();
    if ((this.lU >= 0) && (localList != null) && (this.lU < localList.size()))
    {
      localList.remove(this.lU);
      this.jVl.getAdapter().refresh();
      AppMethodBeat.o(14061);
      return;
    }
    ab.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog run refresh all");
    this.jVl.refresh();
    AppMethodBeat.o(14061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.4
 * JD-Core Version:    0.7.0.1
 */