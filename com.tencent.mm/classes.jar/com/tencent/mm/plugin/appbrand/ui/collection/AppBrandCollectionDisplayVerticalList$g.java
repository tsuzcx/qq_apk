package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class AppBrandCollectionDisplayVerticalList$g
  implements Runnable
{
  AppBrandCollectionDisplayVerticalList$g(AppBrandCollectionDisplayVerticalList paramAppBrandCollectionDisplayVerticalList, boolean paramBoolean, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(135015);
    List localList = AppBrandCollectionDisplayVerticalList.aMS();
    this.iRw.runOnUiThread((Runnable)new AppBrandCollectionDisplayVerticalList.g.a(localList, this));
    AppMethodBeat.o(135015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.g
 * JD-Core Version:    0.7.0.1
 */