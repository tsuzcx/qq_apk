package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
final class AppBrandLauncherCollectionList$c
  implements k.a
{
  AppBrandLauncherCollectionList$c(AppBrandLauncherCollectionList paramAppBrandLauncherCollectionList) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(135054);
    if (("batch".equals(paramString)) && (3 == paramm.htj) && ((paramm.obj instanceof Long))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.iRN.runOnUiThread((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(135051);
            Object localObject = AppBrandLauncherCollectionList.b(this.iRO.iRN);
            if (localObject == null) {
              j.ebi();
            }
            ((h)localObject).setLayoutFrozen(true);
            localObject = AppBrandLauncherCollectionList.e(this.iRO.iRN);
            if (localObject == null) {
              j.ebi();
            }
            ((b)localObject).setTouchEnabled(false);
            AppMethodBeat.o(135051);
          }
        });
        AppBrandLauncherCollectionList.a(this.iRN, (a)new AppBrandLauncherCollectionList.c.2(this));
      }
      AppMethodBeat.o(135054);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList.c
 * JD-Core Version:    0.7.0.1
 */