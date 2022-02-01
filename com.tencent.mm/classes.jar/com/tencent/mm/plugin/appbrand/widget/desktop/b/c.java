package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandDesktopViewStorageHelper;", "", "()V", "TAG", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache;", "asyncPreloadData", "", "obtainCollectionStorage", "obtainUsageStorage", "release", "plugin-appbrand-integration_release"})
public final class c
{
  private static e nft;
  private static b nfu;
  public static final c nfv;
  
  static
  {
    AppMethodBeat.i(223988);
    nfv = new c();
    AppMethodBeat.o(223988);
  }
  
  public static void bEv()
  {
    AppMethodBeat.i(223986);
    com.tencent.e.h.MqF.aP((Runnable)a.nfw);
    AppMethodBeat.o(223986);
  }
  
  public static void release()
  {
    AppMethodBeat.i(223987);
    com.tencent.d.f.h.fYG();
    nft = null;
    nfu = null;
    AppMethodBeat.o(223987);
  }
  
  public final e bEt()
  {
    try
    {
      AppMethodBeat.i(223984);
      if (nft == null)
      {
        localObject1 = (ai)g.ab(ai.class);
        if (localObject1 != null) {
          nft = new e((ai)localObject1);
        }
      }
      Object localObject1 = nft;
      AppMethodBeat.o(223984);
      return localObject1;
    }
    finally {}
  }
  
  public final b bEu()
  {
    try
    {
      AppMethodBeat.i(223985);
      if (nfu == null)
      {
        localObject1 = (ah)g.ab(ah.class);
        if (localObject1 != null) {
          nfu = new b((ah)localObject1);
        }
      }
      Object localObject1 = nfu;
      AppMethodBeat.o(223985);
      return localObject1;
    }
    finally {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a nfw;
    
    static
    {
      AppMethodBeat.i(223983);
      nfw = new a();
      AppMethodBeat.o(223983);
    }
    
    public final void run()
    {
      AppMethodBeat.i(223982);
      Object localObject = c.nfv.bEt();
      if (localObject != null) {
        ((e)localObject).bEr();
      }
      localObject = c.nfv.bEu();
      if (localObject != null)
      {
        ((b)localObject).bEr();
        AppMethodBeat.o(223982);
        return;
      }
      AppMethodBeat.o(223982);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.c
 * JD-Core Version:    0.7.0.1
 */