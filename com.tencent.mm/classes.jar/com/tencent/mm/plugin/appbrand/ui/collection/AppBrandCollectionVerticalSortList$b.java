package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "from", "", "to", "drop"})
final class AppBrandCollectionVerticalSortList$b
  implements DragSortListView.h
{
  AppBrandCollectionVerticalSortList$b(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
  
  public final void dp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135040);
    Object localObject = AppBrandCollectionVerticalSortList.a(this.iRI);
    if (localObject != null)
    {
      localObject = ((c)localObject).pE(paramInt1);
      if (localObject != null)
      {
        c localc = AppBrandCollectionVerticalSortList.a(this.iRI);
        if (localc != null)
        {
          localc.insert(localObject, paramInt2);
          AppMethodBeat.o(135040);
          return;
        }
        AppMethodBeat.o(135040);
        return;
      }
    }
    AppMethodBeat.o(135040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList.b
 * JD-Core Version:    0.7.0.1
 */