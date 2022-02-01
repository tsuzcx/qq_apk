package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandDesktopViewStorageHelper;", "", "()V", "TAG", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "asyncPreloadData", "", "obtainCollectionStorage", "obtainUsageStorage", "release", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c uPM;
  private static i uPN;
  private static b uPO;
  
  static
  {
    AppMethodBeat.i(324074);
    uPM = new c();
    AppMethodBeat.o(324074);
  }
  
  public static void cSL()
  {
    AppMethodBeat.i(324058);
    com.tencent.threadpool.h.ahAA.bn(c..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(324058);
  }
  
  private static final void cSM()
  {
    AppMethodBeat.i(324070);
    Object localObject = uPM.cSJ();
    if (localObject != null) {
      ((i)localObject).a((l)h.uPX);
    }
    localObject = uPM.cSK();
    if (localObject != null) {
      ((b)localObject).a((l)h.uPW);
    }
    AppMethodBeat.o(324070);
  }
  
  public static void release()
  {
    AppMethodBeat.i(324063);
    Log.i("MicroMsg.AppBrandDesktopDataHelper", "onAccountRelease");
    uPN = null;
    uPO = null;
    AppMethodBeat.o(324063);
  }
  
  public final i cSJ()
  {
    try
    {
      AppMethodBeat.i(324083);
      if (uPN == null)
      {
        localObject1 = (ag)com.tencent.mm.kernel.h.ax(ag.class);
        if (localObject1 != null) {
          uPN = new i((ag)localObject1);
        }
      }
      Object localObject1 = uPN;
      AppMethodBeat.o(324083);
      return localObject1;
    }
    finally {}
  }
  
  public final b cSK()
  {
    try
    {
      AppMethodBeat.i(324087);
      if (uPO == null)
      {
        localObject1 = (af)com.tencent.mm.kernel.h.ax(af.class);
        if (localObject1 != null) {
          uPO = new b((af)localObject1);
        }
      }
      Object localObject1 = uPO;
      AppMethodBeat.o(324087);
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.c
 * JD-Core Version:    0.7.0.1
 */