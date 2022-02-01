package com.tencent.mm.plugin.appbrand.jsapi.ac.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.jsapi.ac.b.b.e;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;
import com.tencent.xweb.skia_canvas.SkiaCanvasLogic;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static boolean lxB;
  private static final a lxC;
  
  static
  {
    AppMethodBeat.i(186909);
    lxB = false;
    lxC = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186907);
        ad.i("Luggage.XWebCanvasLogic", "onJSContextDestroying");
        SkiaCanvasLogic.onJSContextDestroying();
        AppMethodBeat.o(186907);
      }
    });
    AppMethodBeat.o(186909);
  }
  
  public static void D(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177200);
    bpJ();
    SkiaCanvasLogic.init(paramLong1, paramLong2);
    AppMethodBeat.o(177200);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.f.b paramb, final com.tencent.mm.plugin.appbrand.f.a parama, final com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(139447);
    bpJ();
    i locali = paramq.aYh();
    if (locali != null)
    {
      com.tencent.mm.plugin.appbrand.jsruntime.q localq = (com.tencent.mm.plugin.appbrand.jsruntime.q)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localq != null) {
        localq.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186906);
            ad.i("Luggage.XWebCanvasLogic", "init resource loader");
            SkiaCanvasResourceLoader.setDelegate(new b(this.lxD, parama, paramq));
            AppMethodBeat.o(186906);
          }
        });
      }
      for (;;)
      {
        paramb = (com.tencent.mm.plugin.appbrand.jsruntime.m)locali.P(com.tencent.mm.plugin.appbrand.jsruntime.m.class);
        if (paramb == null) {
          break;
        }
        paramb.a(lxC);
        AppMethodBeat.o(139447);
        return;
        ad.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, fail");
      }
      ad.e("Luggage.XWebCanvasLogic", "addonDestroyListener is null, fail");
    }
    AppMethodBeat.o(139447);
  }
  
  private static void bpJ()
  {
    AppMethodBeat.i(178852);
    if (!lxB)
    {
      h.class.getClassLoader();
      j.vr("c++_shared");
      XWebLibraryLoader.initXWebLibraryLoader(new IXWebLibraryLoader()
      {
        public final boolean afterLoad()
        {
          AppMethodBeat.i(139446);
          h.class.getClassLoader();
          j.vr("skia-canvas-log-bridge");
          AppMethodBeat.o(139446);
          return true;
        }
        
        public final boolean beforeLoad()
        {
          return false;
        }
        
        public final boolean load(String paramAnonymousString)
        {
          AppMethodBeat.i(139445);
          ad.i("Luggage.XWebCanvasLogic", "load %s", new Object[] { paramAnonymousString });
          try
          {
            h.class.getClassLoader();
            j.vr(paramAnonymousString);
            AppMethodBeat.o(139445);
            return true;
          }
          catch (Throwable localThrowable)
          {
            ad.e("Luggage.XWebCanvasLogic", "load %s fail, %s", new Object[] { paramAnonymousString, localThrowable });
            AppMethodBeat.o(139445);
          }
          return false;
        }
      });
      lxB = true;
      SkiaCanvasLogic.init();
    }
    AppMethodBeat.o(178852);
  }
  
  public static String bpK()
  {
    AppMethodBeat.i(177201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.appbrand.z.d.UT("wxa_library/js_binding_skia.js"));
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(177201);
    return localObject;
  }
  
  public static List<com.tencent.mm.plugin.appbrand.jsapi.m> gV(boolean paramBoolean)
  {
    AppMethodBeat.i(139449);
    ad.i("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ac.b.a.a());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ac.b.a.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ac.b.a.c());
    }
    for (;;)
    {
      AppMethodBeat.o(139449);
      return localArrayList;
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ac.b.b.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ac.b.b.d());
      localArrayList.add(new e());
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(139448);
    AppMethodBeat.o(139448);
  }
  
  static final class a
    extends l
    implements m.a
  {
    a(Runnable paramRunnable)
    {
      super();
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(186908);
      run();
      AppMethodBeat.o(186908);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b.c
 * JD-Core Version:    0.7.0.1
 */