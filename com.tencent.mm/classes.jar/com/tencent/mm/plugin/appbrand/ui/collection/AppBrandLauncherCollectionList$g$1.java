package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.s;
import java.util.HashSet;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class AppBrandLauncherCollectionList$g$1
  implements Runnable
{
  AppBrandLauncherCollectionList$g$1(AppBrandLauncherCollectionList.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(135058);
    AppBrandLauncherCollectionList.aMU();
    if (this.iRR.iRN.isAdded()) {
      AppBrandLauncherCollectionList.d(this.iRR.iRN);
    }
    HashSet localHashSet = new HashSet();
    Object localObject = AppBrandLauncherCollectionList.a(this.iRR.iRN);
    if (localObject == null) {
      a.f.b.j.ebi();
    }
    localObject = ((Iterable)((a)localObject).iRT).iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((LocalUsageInfo)((Iterator)localObject).next()).username);
    }
    s.a(a.a.j.m((Iterable)localHashSet), k.a.hji);
    AppMethodBeat.o(135058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList.g.1
 * JD-Core Version:    0.7.0.1
 */