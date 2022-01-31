package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "which", "", "remove"})
final class AppBrandCollectionVerticalSortList$c
  implements DragSortListView.l
{
  AppBrandCollectionVerticalSortList$c(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(135041);
    c localc = AppBrandCollectionVerticalSortList.a(this.iRI);
    if (localc != null)
    {
      localc.pE(paramInt);
      AppMethodBeat.o(135041);
      return;
    }
    AppMethodBeat.o(135041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList.c
 * JD-Core Version:    0.7.0.1
 */