package com.tencent.mm.plugin.appbrand.jsapi.ag.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  private static boolean mJx;
  private static SparseArray<SkiaCanvasApp> mJy;
  
  static
  {
    AppMethodBeat.i(215828);
    mJx = false;
    mJy = new SparseArray();
    AppMethodBeat.o(215828);
  }
  
  public static SkiaCanvasApp G(f paramf)
  {
    AppMethodBeat.i(215824);
    SkiaCanvasApp localSkiaCanvasApp = null;
    int i = -1;
    if ((paramf instanceof s))
    {
      i = paramf.hashCode();
      localSkiaCanvasApp = xT(i);
    }
    for (;;)
    {
      if (localSkiaCanvasApp == null) {
        Log.e("Luggage.XWebCanvasLogic", "id:%d app is null, err", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(215824);
      return localSkiaCanvasApp;
      if ((paramf instanceof ac))
      {
        i = ((ac)paramf).NY().hashCode();
        localSkiaCanvasApp = xT(i);
      }
    }
  }
  
  private static void a(int paramInt, SkiaCanvasApp paramSkiaCanvasApp)
  {
    try
    {
      AppMethodBeat.i(215825);
      mJy.put(paramInt, paramSkiaCanvasApp);
      AppMethodBeat.o(215825);
      return;
    }
    finally
    {
      paramSkiaCanvasApp = finally;
      throw paramSkiaCanvasApp;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.f.b paramb, final com.tencent.mm.plugin.appbrand.f.a parama, final s params)
  {
    AppMethodBeat.i(139447);
    bMb();
    Object localObject = params.getJsRuntime();
    if (localObject != null)
    {
      localObject = (q)((i)localObject).R(q.class);
      if (localObject != null)
      {
        ((q)localObject).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215817);
            Log.i("Luggage.XWebCanvasLogic", "init resource loader");
            SkiaCanvasResourceLoader.setDelegate(new c(this.mJz, parama, params));
            AppMethodBeat.o(215817);
          }
        });
        AppMethodBeat.o(139447);
        return;
      }
      Log.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, fail");
    }
    AppMethodBeat.o(139447);
  }
  
  public static void a(i parami, final s params)
  {
    AppMethodBeat.i(215823);
    bMb();
    final q localq = (q)parami.R(q.class);
    if (localq != null)
    {
      localq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215820);
          if (this.cAZ == null)
          {
            Log.e("Luggage.XWebCanvasLogic", "postCreateJsRuntime, try init xweb canvas, but jsRuntime is null");
            AppMethodBeat.o(215820);
            return;
          }
          v localv = (v)this.cAZ.R(v.class);
          int i = params.hashCode();
          d.b(i, new SkiaCanvasApp(localv.getIsolatePtr(), localv.XK(), new IXWebWorkingHandler()
          {
            public final boolean isRunOnWorkingThread()
            {
              AppMethodBeat.i(215819);
              boolean bool = d.3.this.cAg.LO();
              AppMethodBeat.o(215819);
              return bool;
            }
            
            public final void post(Runnable paramAnonymous2Runnable)
            {
              AppMethodBeat.i(215818);
              if (d.3.this.cAg != null)
              {
                if (d.3.this.cAg.LO())
                {
                  paramAnonymous2Runnable.run();
                  AppMethodBeat.o(215818);
                  return;
                }
                d.3.this.cAg.post(paramAnonymous2Runnable);
                AppMethodBeat.o(215818);
                return;
              }
              Log.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, error");
              AppMethodBeat.o(215818);
            }
          }));
          Log.i("Luggage.XWebCanvasLogic", "init id:%s %s", new Object[] { Integer.valueOf(i), d.xT(i) });
          AppMethodBeat.o(215820);
        }
      });
      parami = (m)parami.R(m.class);
      if (parami != null)
      {
        parami.a(new d.a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215821);
            int i = this.cvO.hashCode();
            SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)d.ayD().get(i);
            d.ayD().remove(i);
            Log.i("Luggage.XWebCanvasLogic", "id:%s onJSContextDestroying %s", new Object[] { Integer.valueOf(i), localSkiaCanvasApp });
            localSkiaCanvasApp.onJSContextDestroying();
            AppMethodBeat.o(215821);
          }
        }));
        AppMethodBeat.o(215823);
        return;
      }
      Log.e("Luggage.XWebCanvasLogic", "addonDestroyListener is null, fail");
    }
    AppMethodBeat.o(215823);
  }
  
  private static void bMb()
  {
    AppMethodBeat.i(178852);
    if (!mJx)
    {
      h.class.getClassLoader();
      j.Ed("c++_shared");
      XWebLibraryLoader.initXWebLibraryLoader(new d.1());
      mJx = true;
    }
    AppMethodBeat.o(178852);
  }
  
  public static String bMc()
  {
    AppMethodBeat.i(177201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/js_binding_skia.js"));
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(177201);
    return localObject;
  }
  
  public static List<p> hU(boolean paramBoolean)
  {
    AppMethodBeat.i(139449);
    Log.i("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.a());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.a.c());
    }
    for (;;)
    {
      AppMethodBeat.o(139449);
      return localArrayList;
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ag.b.b.d());
      localArrayList.add(new e());
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(139448);
    AppMethodBeat.o(139448);
  }
  
  public static SkiaCanvasApp xT(int paramInt)
  {
    try
    {
      AppMethodBeat.i(215826);
      SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)mJy.get(paramInt);
      AppMethodBeat.o(215826);
      return localSkiaCanvasApp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.b.d
 * JD-Core Version:    0.7.0.1
 */