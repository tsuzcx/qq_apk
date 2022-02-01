package com.tencent.mm.plugin.appbrand.ui.collection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.b;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFinish"})
final class AppBrandCollectionDisplayVerticalList$j
  implements h.b
{
  AppBrandCollectionDisplayVerticalList$j(AppBrandCollectionDisplayVerticalList paramAppBrandCollectionDisplayVerticalList) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(175223);
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if (paramCharSequence != null) {
        AppBrandCollectionDisplayVerticalList.e(paramCharSequence, (b)1.mIz);
      }
    }
    AppMethodBeat.o(175223);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.j
 * JD-Core Version:    0.7.0.1
 */