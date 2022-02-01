package com.tencent.mm.plugin.appbrand.ui.collection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.b;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onFinish"})
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
        AppBrandCollectionDisplayVerticalList.f(paramCharSequence, (b)1.oaP);
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