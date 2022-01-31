package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class AppBrandCollectionVerticalSortList$e
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandCollectionVerticalSortList$e(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(135046);
    paramMenuItem = this.iRI.getActivity();
    if (paramMenuItem != null) {
      paramMenuItem.finish();
    }
    AppMethodBeat.o(135046);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList.e
 * JD-Core Version:    0.7.0.1
 */