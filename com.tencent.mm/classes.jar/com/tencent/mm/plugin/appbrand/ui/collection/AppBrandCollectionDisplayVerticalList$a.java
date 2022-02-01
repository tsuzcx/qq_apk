package com.tencent.mm.plugin.appbrand.ui.collection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
final class AppBrandCollectionDisplayVerticalList$a
  implements k.a
{
  AppBrandCollectionDisplayVerticalList$a(AppBrandCollectionDisplayVerticalList paramAppBrandCollectionDisplayVerticalList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(51172);
    if ((p.i("batch", paramString)) && (3 == paramm.duP) && ((paramm.obj instanceof Long))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppBrandCollectionDisplayVerticalList.a(this.mNv);
      AppMethodBeat.o(51172);
      return;
    }
    AppBrandCollectionDisplayVerticalList.h(this.mNv);
    AppMethodBeat.o(51172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.a
 * JD-Core Version:    0.7.0.1
 */