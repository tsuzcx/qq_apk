package com.tencent.mm.plugin.appbrand.jsapi.ai.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader;
import java.util.ArrayList;
import java.util.List;

public final class d
{
  private static boolean pKp;
  private static SparseArray<SkiaCanvasApp> pKq;
  
  static
  {
    AppMethodBeat.i(228753);
    pKp = false;
    pKq = new SparseArray();
    AppMethodBeat.o(228753);
  }
  
  public static SkiaCanvasApp Bt(int paramInt)
  {
    try
    {
      AppMethodBeat.i(228733);
      SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)pKq.get(paramInt);
      AppMethodBeat.o(228733);
      return localSkiaCanvasApp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static SkiaCanvasApp J(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(228729);
    SkiaCanvasApp localSkiaCanvasApp = null;
    int i = -1;
    if ((parame instanceof com.tencent.mm.plugin.appbrand.v))
    {
      i = parame.hashCode();
      localSkiaCanvasApp = Bt(i);
    }
    for (;;)
    {
      if (localSkiaCanvasApp == null) {
        Log.e("Luggage.XWebCanvasLogic", "id:%d app is null, err", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(228729);
      return localSkiaCanvasApp;
      if ((parame instanceof ad))
      {
        i = ((ad)parame).QW().hashCode();
        localSkiaCanvasApp = Bt(i);
      }
    }
  }
  
  private static void a(int paramInt, SkiaCanvasApp paramSkiaCanvasApp)
  {
    try
    {
      AppMethodBeat.i(228730);
      pKq.put(paramInt, paramSkiaCanvasApp);
      AppMethodBeat.o(228730);
      return;
    }
    finally
    {
      paramSkiaCanvasApp = finally;
      throw paramSkiaCanvasApp;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.f.b paramb, final com.tencent.mm.plugin.appbrand.f.a parama, final com.tencent.mm.plugin.appbrand.v paramv)
  {
    AppMethodBeat.i(139447);
    bYs();
    Object localObject = paramv.getJsRuntime();
    if (localObject != null)
    {
      localObject = (q)((i)localObject).Q(q.class);
      if (localObject != null)
      {
        ((q)localObject).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(226715);
            Log.i("Luggage.XWebCanvasLogic", "init resource loader");
            SkiaCanvasResourceLoader.setDelegate(new c(this.pKr, parama, paramv));
            AppMethodBeat.o(226715);
          }
        });
        AppMethodBeat.o(139447);
        return;
      }
      Log.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, fail");
    }
    AppMethodBeat.o(139447);
  }
  
  public static void a(i parami, final com.tencent.mm.plugin.appbrand.v paramv)
  {
    AppMethodBeat.i(228726);
    bYs();
    final q localq = (q)parami.Q(q.class);
    if (localq != null)
    {
      localq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226418);
          if (this.cAh == null)
          {
            Log.e("Luggage.XWebCanvasLogic", "postCreateJsRuntime, try init xweb canvas, but jsRuntime is null");
            AppMethodBeat.o(226418);
            return;
          }
          com.tencent.mm.plugin.appbrand.m.v localv = (com.tencent.mm.plugin.appbrand.m.v)this.cAh.Q(com.tencent.mm.plugin.appbrand.m.v.class);
          int i = paramv.hashCode();
          d.b(i, new SkiaCanvasApp(localv.getIsolatePtr(), localv.acn(), new IXWebWorkingHandler()
          {
            public final boolean isRunOnWorkingThread()
            {
              AppMethodBeat.i(224755);
              boolean bool = d.3.this.czh.OF();
              AppMethodBeat.o(224755);
              return bool;
            }
            
            public final void post(Runnable paramAnonymous2Runnable)
            {
              AppMethodBeat.i(224754);
              if (d.3.this.czh != null)
              {
                if (d.3.this.czh.OF())
                {
                  paramAnonymous2Runnable.run();
                  AppMethodBeat.o(224754);
                  return;
                }
                d.3.this.czh.post(paramAnonymous2Runnable);
                AppMethodBeat.o(224754);
                return;
              }
              Log.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, error");
              AppMethodBeat.o(224754);
            }
          }));
          Log.i("Luggage.XWebCanvasLogic", "init id:%s %s", new Object[] { Integer.valueOf(i), d.Bt(i) });
          AppMethodBeat.o(226418);
        }
      });
      parami = (m)parami.Q(m.class);
      if (parami != null)
      {
        parami.a(new a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(225143);
            int i = this.cue.hashCode();
            SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)d.aFW().get(i);
            d.aFW().remove(i);
            Log.i("Luggage.XWebCanvasLogic", "id:%s onJSContextDestroying %s", new Object[] { Integer.valueOf(i), localSkiaCanvasApp });
            localSkiaCanvasApp.onJSContextDestroying();
            AppMethodBeat.o(225143);
          }
        }));
        AppMethodBeat.o(228726);
        return;
      }
      Log.e("Luggage.XWebCanvasLogic", "addonDestroyListener is null, fail");
    }
    AppMethodBeat.o(228726);
  }
  
  private static void bYs()
  {
    AppMethodBeat.i(178852);
    if (!pKp)
    {
      h.class.getClassLoader();
      j.KW("c++_shared");
      XWebLibraryLoader.initXWebLibraryLoader(new d.1());
      pKp = true;
    }
    AppMethodBeat.o(178852);
  }
  
  public static String bYt()
  {
    AppMethodBeat.i(177201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.appbrand.ac.d.anc("wxa_library/js_binding_skia.js"));
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(177201);
    return localObject;
  }
  
  public static List<o> iO(boolean paramBoolean)
  {
    AppMethodBeat.i(139449);
    Log.i("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ai.b.a.a());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ai.b.a.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ai.b.a.c());
    }
    for (;;)
    {
      AppMethodBeat.o(139449);
      return localArrayList;
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ai.b.b.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ai.b.b.d());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ai.b.b.e());
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
      AppMethodBeat.i(222391);
      run();
      AppMethodBeat.o(222391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.b.d
 * JD-Core Version:    0.7.0.1
 */