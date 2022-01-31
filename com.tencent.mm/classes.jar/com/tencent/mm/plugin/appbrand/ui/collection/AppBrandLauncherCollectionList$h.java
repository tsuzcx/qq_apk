package com.tencent.mm.plugin.appbrand.ui.collection;

import a.a.v;
import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class AppBrandLauncherCollectionList$h
  implements Runnable
{
  AppBrandLauncherCollectionList$h(AppBrandLauncherCollectionList paramAppBrandLauncherCollectionList, boolean paramBoolean, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(135061);
    List localList = ((af)g.E(af.class)).a(2147483647, af.a.hcJ);
    if (localList == null) {
      localList = (List)v.BMx;
    }
    for (;;)
    {
      this.iRN.runOnUiThread((Runnable)new AppBrandLauncherCollectionList.h.a(localList, this));
      AppMethodBeat.o(135061);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList.h
 * JD-Core Version:    0.7.0.1
 */