package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.launcher.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class AppBrandCollectionDisplayVerticalList$l
  implements Runnable
{
  AppBrandCollectionDisplayVerticalList$l(AppBrandCollectionDisplayVerticalList paramAppBrandCollectionDisplayVerticalList) {}
  
  public final void run()
  {
    AppMethodBeat.i(51183);
    FragmentActivity localFragmentActivity = this.mNv.getActivity();
    Object localObject = localFragmentActivity;
    if (!(localFragmentActivity instanceof a)) {
      localObject = null;
    }
    localObject = (a)localObject;
    if (localObject != null)
    {
      ((a)localObject).hF(false);
      AppMethodBeat.o(51183);
      return;
    }
    AppMethodBeat.o(51183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.l
 * JD-Core Version:    0.7.0.1
 */