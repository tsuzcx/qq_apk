package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandDesktopViewStorageHelper;", "", "()V", "TAG", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache;", "asyncPreloadData", "", "obtainCollectionStorage", "obtainUsageStorage", "release", "plugin-appbrand-integration_release"})
public final class c
{
  private static e mzD;
  private static b mzE;
  public static final c mzF;
  
  static
  {
    AppMethodBeat.i(187485);
    mzF = new c();
    AppMethodBeat.o(187485);
  }
  
  public static void bzz()
  {
    AppMethodBeat.i(187483);
    com.tencent.e.h.JZN.aT((Runnable)a.mzG);
    AppMethodBeat.o(187483);
  }
  
  public static void release()
  {
    AppMethodBeat.i(187484);
    com.tencent.d.f.h.fCP();
    mzD = null;
    mzE = null;
    AppMethodBeat.o(187484);
  }
  
  public final e bzx()
  {
    try
    {
      AppMethodBeat.i(187481);
      if (mzD == null)
      {
        localObject1 = (ai)g.ab(ai.class);
        if (localObject1 != null) {
          mzD = new e((ai)localObject1);
        }
      }
      Object localObject1 = mzD;
      AppMethodBeat.o(187481);
      return localObject1;
    }
    finally {}
  }
  
  public final b bzy()
  {
    try
    {
      AppMethodBeat.i(187482);
      if (mzE == null)
      {
        localObject1 = (ah)g.ab(ah.class);
        if (localObject1 != null) {
          mzE = new b((ah)localObject1);
        }
      }
      Object localObject1 = mzE;
      AppMethodBeat.o(187482);
      return localObject1;
    }
    finally {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a mzG;
    
    static
    {
      AppMethodBeat.i(187480);
      mzG = new a();
      AppMethodBeat.o(187480);
    }
    
    public final void run()
    {
      AppMethodBeat.i(187479);
      Object localObject = c.mzF.bzx();
      if (localObject != null) {
        ((e)localObject).bzv();
      }
      localObject = c.mzF.bzy();
      if (localObject != null)
      {
        ((b)localObject).bzv();
        AppMethodBeat.o(187479);
        return;
      }
      AppMethodBeat.o(187479);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.c
 * JD-Core Version:    0.7.0.1
 */