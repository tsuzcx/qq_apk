package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$refreshDataList$workerRunner$1$1$1"})
final class AppBrandLauncherCollectionList$h$a
  implements Runnable
{
  AppBrandLauncherCollectionList$h$a(List paramList, AppBrandLauncherCollectionList.h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(135060);
    Object localObject;
    if (this.iRB.isEmpty())
    {
      localObject = this.iRS.iRN.getActivity();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.launcher.IFolderActivityContext");
        AppMethodBeat.o(135060);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.plugin.appbrand.ui.launcher.a)localObject).eP(false);
    }
    for (;;)
    {
      localObject = (Runnable)this.iRS.iRA.invoke();
      if (localObject == null) {
        break;
      }
      ((Runnable)localObject).run();
      AppMethodBeat.o(135060);
      return;
      localObject = AppBrandLauncherCollectionList.a(this.iRS.iRN);
      if (localObject == null) {
        j.ebi();
      }
      ((a)localObject).iRT.clear();
      localObject = AppBrandLauncherCollectionList.a(this.iRS.iRN);
      if (localObject == null) {
        j.ebi();
      }
      ((a)localObject).iRT.addAll((Collection)this.iRB);
      if (this.iRS.iRz)
      {
        localObject = AppBrandLauncherCollectionList.a(this.iRS.iRN);
        if (localObject == null) {
          j.ebi();
        }
        ((a)localObject).an(0, this.iRB.size());
      }
      else
      {
        localObject = AppBrandLauncherCollectionList.a(this.iRS.iRN);
        if (localObject == null) {
          j.ebi();
        }
        ((a)localObject).ap(0, this.iRB.size());
      }
    }
    AppMethodBeat.o(135060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList.h.a
 * JD-Core Version:    0.7.0.1
 */