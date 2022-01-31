package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.f;
import com.tencent.mm.plugin.appbrand.appusage.f.b;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class AppBrandCollectionVerticalSortList$d
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandCollectionVerticalSortList$d(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(135045);
    paramMenuItem = f.haW;
    paramMenuItem = f.awS();
    if (paramMenuItem == null) {
      j.ebi();
    }
    c localc = AppBrandCollectionVerticalSortList.a(this.iRI);
    if (localc == null) {
      j.ebi();
    }
    paramMenuItem.a((List)localc.iRT, (f.b)new AppBrandCollectionVerticalSortList.d.1(this));
    AppMethodBeat.o(135045);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList.d
 * JD-Core Version:    0.7.0.1
 */