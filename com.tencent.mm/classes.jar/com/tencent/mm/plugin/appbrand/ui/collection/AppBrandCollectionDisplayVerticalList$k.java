package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.launcher.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class AppBrandCollectionDisplayVerticalList$k
  implements Runnable
{
  AppBrandCollectionDisplayVerticalList$k(AppBrandCollectionDisplayVerticalList paramAppBrandCollectionDisplayVerticalList) {}
  
  public final void run()
  {
    AppMethodBeat.i(135019);
    FragmentActivity localFragmentActivity = this.iRw.getActivity();
    Object localObject = localFragmentActivity;
    if (!(localFragmentActivity instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    if (localObject != null)
    {
      ((a)localObject).eP(false);
      AppMethodBeat.o(135019);
      return;
    }
    AppMethodBeat.o(135019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.k
 * JD-Core Version:    0.7.0.1
 */