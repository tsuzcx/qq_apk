package com.tencent.mm.plugin.appbrand.widget.desktop.b;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandDesktopViewStorageHelper;", "", "()V", "TAG", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandCollectionStorageWithCache;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/helper/AppBrandUsageStorageWithCache;", "asyncPreloadData", "", "obtainCollectionStorage", "obtainUsageStorage", "release", "plugin-appbrand-integration_release"})
public final class c
{
  private static e nal;
  private static b nam;
  public static final c nan;
  
  static
  {
    AppMethodBeat.i(189716);
    nan = new c();
    AppMethodBeat.o(189716);
  }
  
  public static void bDD()
  {
    AppMethodBeat.i(189714);
    com.tencent.e.h.LTJ.aS((Runnable)a.nao);
    AppMethodBeat.o(189714);
  }
  
  public static void release()
  {
    AppMethodBeat.i(189715);
    com.tencent.d.f.h.fUh();
    nal = null;
    nam = null;
    AppMethodBeat.o(189715);
  }
  
  public final e bDB()
  {
    try
    {
      AppMethodBeat.i(189712);
      if (nal == null)
      {
        localObject1 = (ai)g.ab(ai.class);
        if (localObject1 != null) {
          nal = new e((ai)localObject1);
        }
      }
      Object localObject1 = nal;
      AppMethodBeat.o(189712);
      return localObject1;
    }
    finally {}
  }
  
  public final b bDC()
  {
    try
    {
      AppMethodBeat.i(189713);
      if (nam == null)
      {
        localObject1 = (ah)g.ab(ah.class);
        if (localObject1 != null) {
          nam = new b((ah)localObject1);
        }
      }
      Object localObject1 = nam;
      AppMethodBeat.o(189713);
      return localObject1;
    }
    finally {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a nao;
    
    static
    {
      AppMethodBeat.i(189711);
      nao = new a();
      AppMethodBeat.o(189711);
    }
    
    public final void run()
    {
      AppMethodBeat.i(189710);
      Object localObject = c.nan.bDB();
      if (localObject != null) {
        ((e)localObject).bDz();
      }
      localObject = c.nan.bDC();
      if (localObject != null)
      {
        ((b)localObject).bDz();
        AppMethodBeat.o(189710);
        return;
      }
      AppMethodBeat.o(189710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.b.c
 * JD-Core Version:    0.7.0.1
 */