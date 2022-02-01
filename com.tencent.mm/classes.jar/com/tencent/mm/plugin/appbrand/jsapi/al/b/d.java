package com.tencent.mm.plugin.appbrand.jsapi.al.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.af.n;
import com.tencent.mm.plugin.appbrand.jsapi.al.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.plugin.appbrand.n.m.a;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  private static boolean sPi;
  private static SparseArray<SkiaCanvasApp> sPj;
  
  static
  {
    AppMethodBeat.i(327076);
    sPi = false;
    sPj = new SparseArray();
    AppMethodBeat.o(327076);
  }
  
  public static SkiaCanvasApp BG(int paramInt)
  {
    try
    {
      AppMethodBeat.i(327059);
      SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)sPj.get(paramInt);
      AppMethodBeat.o(327059);
      return localSkiaCanvasApp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static SkiaCanvasApp L(f paramf)
  {
    AppMethodBeat.i(327050);
    SkiaCanvasApp localSkiaCanvasApp = null;
    int i = -1;
    if ((paramf instanceof y))
    {
      i = paramf.hashCode();
      localSkiaCanvasApp = BG(i);
    }
    for (;;)
    {
      if (localSkiaCanvasApp == null) {
        Log.e("Luggage.XWebCanvasLogic", "id:%d app is null, err", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(327050);
      return localSkiaCanvasApp;
      if ((paramf instanceof ad))
      {
        i = ((ad)paramf).ari().hashCode();
        localSkiaCanvasApp = BG(i);
      }
    }
  }
  
  private static void a(int paramInt, SkiaCanvasApp paramSkiaCanvasApp)
  {
    try
    {
      AppMethodBeat.i(327056);
      sPj.put(paramInt, paramSkiaCanvasApp);
      AppMethodBeat.o(327056);
      return;
    }
    finally
    {
      paramSkiaCanvasApp = finally;
      throw paramSkiaCanvasApp;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.f.b paramb, final com.tencent.mm.plugin.appbrand.f.a parama, final y paramy)
  {
    AppMethodBeat.i(139447);
    cyI();
    Object localObject = paramy.getJsRuntime();
    if (localObject != null)
    {
      localObject = (q)((i)localObject).Z(q.class);
      if (localObject != null)
      {
        ((q)localObject).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(327039);
            Log.i("Luggage.XWebCanvasLogic", "init resource loader");
            SkiaCanvasResourceLoader.setDelegate(new c(d.this, parama, paramy));
            AppMethodBeat.o(327039);
          }
        });
        AppMethodBeat.o(139447);
        return;
      }
      Log.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, fail");
    }
    AppMethodBeat.o(139447);
  }
  
  public static void a(i parami, final y paramy)
  {
    AppMethodBeat.i(327043);
    cyI();
    final q localq = (q)parami.Z(q.class);
    if (localq != null)
    {
      localq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327040);
          if (d.this == null)
          {
            Log.e("Luggage.XWebCanvasLogic", "postCreateJsRuntime, try init xweb canvas, but jsRuntime is null");
            AppMethodBeat.o(327040);
            return;
          }
          v localv = (v)d.this.Z(v.class);
          int i = paramy.hashCode();
          d.b(i, new SkiaCanvasApp(localv.getIsolatePtr(), localv.aEn(), new IXWebWorkingHandler()
          {
            public final boolean isRunOnWorkingThread()
            {
              AppMethodBeat.i(327067);
              boolean bool = d.3.this.erH.aoN();
              AppMethodBeat.o(327067);
              return bool;
            }
            
            public final void post(Runnable paramAnonymous2Runnable)
            {
              AppMethodBeat.i(327062);
              if (d.3.this.erH != null)
              {
                if (d.3.this.erH.aoN())
                {
                  paramAnonymous2Runnable.run();
                  AppMethodBeat.o(327062);
                  return;
                }
                d.3.this.erH.post(paramAnonymous2Runnable);
                AppMethodBeat.o(327062);
                return;
              }
              Log.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, error");
              AppMethodBeat.o(327062);
            }
          }));
          Log.i("Luggage.XWebCanvasLogic", "init id:%s %s", new Object[] { Integer.valueOf(i), d.BG(i) });
          AppMethodBeat.o(327040);
        }
      });
      parami = (m)parami.Z(m.class);
      if (parami != null)
      {
        parami.a(new a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(327036);
            int i = d.this.hashCode();
            SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)d.aYV().get(i);
            d.aYV().remove(i);
            Log.i("Luggage.XWebCanvasLogic", "id:%s onJSContextDestroying %s", new Object[] { Integer.valueOf(i), localSkiaCanvasApp });
            localSkiaCanvasApp.onJSContextDestroying();
            AppMethodBeat.o(327036);
          }
        }));
        AppMethodBeat.o(327043);
        return;
      }
      Log.e("Luggage.XWebCanvasLogic", "addonDestroyListener is null, fail");
    }
    AppMethodBeat.o(327043);
  }
  
  private static void cyI()
  {
    AppMethodBeat.i(178852);
    if (!sPi)
    {
      h.class.getClassLoader();
      k.DA("c++_shared");
      XWebLibraryLoader.initXWebLibraryLoader(new d.1());
      sPi = true;
    }
    AppMethodBeat.o(178852);
  }
  
  public static String cyJ()
  {
    AppMethodBeat.i(177201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.appbrand.af.d.ags("wxa_library/js_binding_skia.js"));
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(177201);
    return localObject;
  }
  
  public static List<p> jU(boolean paramBoolean)
  {
    AppMethodBeat.i(139449);
    Log.i("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.al.b.a.a());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.al.b.a.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.al.b.a.c());
    }
    for (;;)
    {
      AppMethodBeat.o(139449);
      return localArrayList;
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.al.b.b.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.al.b.b.d());
      localArrayList.add(new e());
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(139448);
    AppMethodBeat.o(139448);
  }
  
  static final class a
    extends n
    implements m.a
  {
    a(Runnable paramRunnable)
    {
      super();
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(327018);
      run();
      AppMethodBeat.o(327018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.b.d
 * JD-Core Version:    0.7.0.1
 */