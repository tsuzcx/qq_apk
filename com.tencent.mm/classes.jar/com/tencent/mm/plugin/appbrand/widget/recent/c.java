package com.tencent.mm.plugin.appbrand.widget.recent;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandDesktopViewStorageHelper;", "", "()V", "TAG", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "asyncPreloadData", "", "obtainCollectionStorage", "obtainUsageStorage", "release", "plugin-appbrand-integration_release"})
public final class c
{
  private static j oBR;
  private static b oBS;
  public static final c oBT;
  
  static
  {
    AppMethodBeat.i(229660);
    oBT = new c();
    AppMethodBeat.o(229660);
  }
  
  public static void ccR()
  {
    AppMethodBeat.i(229658);
    h.RTc.aY((Runnable)a.oBU);
    AppMethodBeat.o(229658);
  }
  
  public static void release()
  {
    AppMethodBeat.i(229659);
    Log.i("MicroMsg.AppBrandDesktopDataHelper", "onAccountRelease");
    oBR = null;
    oBS = null;
    AppMethodBeat.o(229659);
  }
  
  public final j ccP()
  {
    try
    {
      AppMethodBeat.i(229656);
      if (oBR == null)
      {
        localObject1 = (ah)g.af(ah.class);
        if (localObject1 != null) {
          oBR = new j((ah)localObject1);
        }
      }
      Object localObject1 = oBR;
      AppMethodBeat.o(229656);
      return localObject1;
    }
    finally {}
  }
  
  public final b ccQ()
  {
    try
    {
      AppMethodBeat.i(229657);
      if (oBS == null)
      {
        localObject1 = (ag)g.af(ag.class);
        if (localObject1 != null) {
          oBS = new b((ag)localObject1);
        }
      }
      Object localObject1 = oBS;
      AppMethodBeat.o(229657);
      return localObject1;
    }
    finally {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a oBU;
    
    static
    {
      AppMethodBeat.i(229655);
      oBU = new a();
      AppMethodBeat.o(229655);
    }
    
    public final void run()
    {
      AppMethodBeat.i(229654);
      Object localObject = c.oBT.ccP();
      if (localObject != null) {
        ((j)localObject).ccN();
      }
      localObject = c.oBT.ccQ();
      if (localObject != null)
      {
        ((b)localObject).ccN();
        AppMethodBeat.o(229654);
        return;
      }
      AppMethodBeat.o(229654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.c
 * JD-Core Version:    0.7.0.1
 */