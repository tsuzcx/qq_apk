package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
final class AppBrandCollectionDisplayVerticalList$b
  implements k.a
{
  AppBrandCollectionDisplayVerticalList$b(AppBrandCollectionDisplayVerticalList paramAppBrandCollectionDisplayVerticalList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(135008);
    if ((j.e("batch", paramString)) && (3 == paramm.htj) && ((paramm.obj instanceof Long))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppBrandCollectionDisplayVerticalList.a(this.iRw);
      AppMethodBeat.o(135008);
      return;
    }
    AppBrandCollectionDisplayVerticalList.g(this.iRw);
    AppMethodBeat.o(135008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList.b
 * JD-Core Version:    0.7.0.1
 */