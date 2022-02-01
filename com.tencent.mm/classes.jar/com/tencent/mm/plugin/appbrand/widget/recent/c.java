package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandDesktopViewStorageHelper;", "", "()V", "TAG", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "asyncPreloadData", "", "obtainCollectionStorage", "obtainUsageStorage", "release", "plugin-appbrand-integration_release"})
public final class c
{
  private static b rEA;
  public static final c rEB;
  private static i rEz;
  
  static
  {
    AppMethodBeat.i(277053);
    rEB = new c();
    AppMethodBeat.o(277053);
  }
  
  public static void cqg()
  {
    AppMethodBeat.i(277049);
    com.tencent.e.h.ZvG.bf((Runnable)a.rEC);
    AppMethodBeat.o(277049);
  }
  
  public static void release()
  {
    AppMethodBeat.i(277051);
    Log.i("MicroMsg.AppBrandDesktopDataHelper", "onAccountRelease");
    rEz = null;
    rEA = null;
    AppMethodBeat.o(277051);
  }
  
  public final i cqe()
  {
    try
    {
      AppMethodBeat.i(277047);
      if (rEz == null)
      {
        localObject1 = (ah)com.tencent.mm.kernel.h.ae(ah.class);
        if (localObject1 != null) {
          rEz = new i((ah)localObject1);
        }
      }
      Object localObject1 = rEz;
      AppMethodBeat.o(277047);
      return localObject1;
    }
    finally {}
  }
  
  public final b cqf()
  {
    try
    {
      AppMethodBeat.i(277048);
      if (rEA == null)
      {
        localObject1 = (ag)com.tencent.mm.kernel.h.ae(ag.class);
        if (localObject1 != null) {
          rEA = new b((ag)localObject1);
        }
      }
      Object localObject1 = rEA;
      AppMethodBeat.o(277048);
      return localObject1;
    }
    finally {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a rEC;
    
    static
    {
      AppMethodBeat.i(279897);
      rEC = new a();
      AppMethodBeat.o(279897);
    }
    
    public final void run()
    {
      AppMethodBeat.i(279896);
      Object localObject = c.rEB.cqe();
      if (localObject != null) {
        ((i)localObject).a((l)h.rEK);
      }
      localObject = c.rEB.cqf();
      if (localObject != null)
      {
        ((b)localObject).a((l)h.rEJ);
        AppMethodBeat.o(279896);
        return;
      }
      AppMethodBeat.o(279896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.c
 * JD-Core Version:    0.7.0.1
 */