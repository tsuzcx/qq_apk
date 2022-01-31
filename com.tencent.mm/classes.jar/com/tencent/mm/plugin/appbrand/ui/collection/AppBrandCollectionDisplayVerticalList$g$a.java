package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$refreshDataList$workerRunner$1$1$1"})
final class AppBrandCollectionDisplayVerticalList$g$a
  implements Runnable
{
  AppBrandCollectionDisplayVerticalList$g$a(List paramList, AppBrandCollectionDisplayVerticalList.g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(135014);
    Object localObject;
    if (this.iRB.isEmpty())
    {
      FragmentActivity localFragmentActivity = this.iRC.iRw.getActivity();
      localObject = localFragmentActivity;
      if (!(localFragmentActivity instanceof com.tencent.mm.plugin.appbrand.ui.launcher.a)) {
        localObject = null;
      }
      localObject = (com.tencent.mm.plugin.appbrand.ui.launcher.a)localObject;
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.ui.launcher.a)localObject).eP(false);
      }
    }
    for (;;)
    {
      localObject = (Runnable)this.iRC.iRA.invoke();
      if (localObject == null) {
        break;
      }
      ((Runnable)localObject).run();
      AppMethodBeat.o(135014);
      return;
      localObject = AppBrandCollectionDisplayVerticalList.b(this.iRC.iRw);
      if (localObject == null) {
        a.f.b.j.ebi();
      }
      ((j)localObject).aL(this.iRB);
      if (this.iRC.iRz)
      {
        localObject = AppBrandCollectionDisplayVerticalList.b(this.iRC.iRw);
        if (localObject == null) {
          a.f.b.j.ebi();
        }
        ((j)localObject).an(0, this.iRB.size());
      }
      else
      {
        localObject = AppBrandCollectionDisplayVerticalList.b(this.iRC.iRw);
        if (localObject == null) {
          a.f.b.j.ebi();
        }
        ((j)localObject).ap(0, this.iRB.size());
      }
    }
    AppMethodBeat.o(135014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.g.a
 * JD-Core Version:    0.7.0.1
 */