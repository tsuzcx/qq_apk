package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandDesktopViewStorageHelper;", "", "()V", "TAG", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache;", "asyncPreloadData", "", "obtainCollectionStorage", "obtainUsageStorage", "release", "plugin-appbrand-integration_release"})
public final class c
{
  private static e lXB;
  private static b lXC;
  public static final c lXD;
  
  static
  {
    AppMethodBeat.i(196524);
    lXD = new c();
    AppMethodBeat.o(196524);
  }
  
  public static void bsz()
  {
    AppMethodBeat.i(196522);
    com.tencent.e.h.Iye.aQ((Runnable)a.lXE);
    AppMethodBeat.o(196522);
  }
  
  public static void release()
  {
    AppMethodBeat.i(196523);
    com.tencent.d.f.h.fmz();
    lXB = null;
    lXC = null;
    AppMethodBeat.o(196523);
  }
  
  public final e bsx()
  {
    try
    {
      AppMethodBeat.i(196520);
      if (lXB == null)
      {
        localObject1 = (ai)g.ab(ai.class);
        if (localObject1 != null) {
          lXB = new e((ai)localObject1);
        }
      }
      Object localObject1 = lXB;
      AppMethodBeat.o(196520);
      return localObject1;
    }
    finally {}
  }
  
  public final b bsy()
  {
    try
    {
      AppMethodBeat.i(196521);
      if (lXC == null)
      {
        localObject1 = (ah)g.ab(ah.class);
        if (localObject1 != null) {
          lXC = new b((ah)localObject1);
        }
      }
      Object localObject1 = lXC;
      AppMethodBeat.o(196521);
      return localObject1;
    }
    finally {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a lXE;
    
    static
    {
      AppMethodBeat.i(196519);
      lXE = new a();
      AppMethodBeat.o(196519);
    }
    
    public final void run()
    {
      AppMethodBeat.i(196518);
      Object localObject = c.lXD.bsx();
      if (localObject != null) {
        ((e)localObject).bsv();
      }
      localObject = c.lXD.bsy();
      if (localObject != null)
      {
        ((b)localObject).bsv();
        AppMethodBeat.o(196518);
        return;
      }
      AppMethodBeat.o(196518);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.c
 * JD-Core Version:    0.7.0.1
 */