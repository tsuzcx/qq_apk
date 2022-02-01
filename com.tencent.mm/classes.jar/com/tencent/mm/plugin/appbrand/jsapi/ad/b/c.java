package com.tencent.mm.plugin.appbrand.jsapi.ad.b;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.jsapi.ad.b.b.e;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;
import com.tencent.xweb.skia_canvas.IXWebWorkingHandler;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static boolean lBZ;
  private static SparseArray<SkiaCanvasApp> lCa;
  
  static
  {
    AppMethodBeat.i(220608);
    lBZ = false;
    lCa = new SparseArray();
    AppMethodBeat.o(220608);
  }
  
  public static SkiaCanvasApp F(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(220604);
    SkiaCanvasApp localSkiaCanvasApp = null;
    int i = -1;
    if ((paramc instanceof r))
    {
      i = paramc.hashCode();
      localSkiaCanvasApp = tU(i);
    }
    for (;;)
    {
      if (localSkiaCanvasApp == null) {
        ae.e("Luggage.XWebCanvasLogic", "id:%d app is null, err", new Object[] { Integer.valueOf(i) });
      }
      AppMethodBeat.o(220604);
      return localSkiaCanvasApp;
      if ((paramc instanceof z))
      {
        i = ((z)paramc).Ey().hashCode();
        localSkiaCanvasApp = tU(i);
      }
    }
  }
  
  private static void a(int paramInt, SkiaCanvasApp paramSkiaCanvasApp)
  {
    try
    {
      AppMethodBeat.i(220605);
      lCa.put(paramInt, paramSkiaCanvasApp);
      AppMethodBeat.o(220605);
      return;
    }
    finally
    {
      paramSkiaCanvasApp = finally;
      throw paramSkiaCanvasApp;
    }
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.f.b paramb, final com.tencent.mm.plugin.appbrand.f.a parama, final r paramr)
  {
    AppMethodBeat.i(139447);
    bqt();
    Object localObject = paramr.aYB();
    if (localObject != null)
    {
      localObject = (q)((i)localObject).P(q.class);
      if (localObject != null)
      {
        ((q)localObject).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220597);
            ae.i("Luggage.XWebCanvasLogic", "init resource loader");
            SkiaCanvasResourceLoader.setDelegate(new b(this.lCb, parama, paramr));
            AppMethodBeat.o(220597);
          }
        });
        AppMethodBeat.o(139447);
        return;
      }
      ae.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, fail");
    }
    AppMethodBeat.o(139447);
  }
  
  public static void a(i parami, final r paramr)
  {
    AppMethodBeat.i(220603);
    bqt();
    final q localq = (q)parami.P(q.class);
    if (localq != null)
    {
      localq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220600);
          if (this.coM == null)
          {
            ae.e("Luggage.XWebCanvasLogic", "postCreateJsRuntime, try init xweb canvas, but jsRuntime is null");
            AppMethodBeat.o(220600);
            return;
          }
          v localv = (v)this.coM.P(v.class);
          int i = paramr.hashCode();
          c.b(i, new SkiaCanvasApp(localv.getIsolatePtr(), localv.Nz(), new IXWebWorkingHandler()
          {
            public final boolean isRunOnWorkingThread()
            {
              AppMethodBeat.i(220599);
              boolean bool = c.3.this.lCc.Cw();
              AppMethodBeat.o(220599);
              return bool;
            }
            
            public final void post(Runnable paramAnonymous2Runnable)
            {
              AppMethodBeat.i(220598);
              if (c.3.this.lCc != null)
              {
                if (c.3.this.lCc.Cw())
                {
                  paramAnonymous2Runnable.run();
                  AppMethodBeat.o(220598);
                  return;
                }
                c.3.this.lCc.post(paramAnonymous2Runnable);
                AppMethodBeat.o(220598);
                return;
              }
              ae.e("Luggage.XWebCanvasLogic", "jsThreadAddon is null, error");
              AppMethodBeat.o(220598);
            }
          }));
          ae.i("Luggage.XWebCanvasLogic", "init id:%s %s", new Object[] { Integer.valueOf(i), c.tU(i) });
          AppMethodBeat.o(220600);
        }
      });
      parami = (com.tencent.mm.plugin.appbrand.jsruntime.m)parami.P(com.tencent.mm.plugin.appbrand.jsruntime.m.class);
      if (parami != null)
      {
        parami.a(new a(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220601);
            int i = this.cjR.hashCode();
            SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)c.ain().get(i);
            c.ain().remove(i);
            ae.i("Luggage.XWebCanvasLogic", "id:%s onJSContextDestroying %s", new Object[] { Integer.valueOf(i), localSkiaCanvasApp });
            localSkiaCanvasApp.onJSContextDestroying();
            AppMethodBeat.o(220601);
          }
        }));
        AppMethodBeat.o(220603);
        return;
      }
      ae.e("Luggage.XWebCanvasLogic", "addonDestroyListener is null, fail");
    }
    AppMethodBeat.o(220603);
  }
  
  private static void bqt()
  {
    AppMethodBeat.i(178852);
    if (!lBZ)
    {
      h.class.getClassLoader();
      j.vN("c++_shared");
      XWebLibraryLoader.initXWebLibraryLoader(new IXWebLibraryLoader()
      {
        public final boolean afterLoad()
        {
          AppMethodBeat.i(139446);
          h.class.getClassLoader();
          j.vN("skia-canvas-log-bridge");
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
          ae.i("Luggage.XWebCanvasLogic", "load %s", new Object[] { paramAnonymousString });
          try
          {
            h.class.getClassLoader();
            j.vN(paramAnonymousString);
            AppMethodBeat.o(139445);
            return true;
          }
          catch (Throwable localThrowable)
          {
            ae.e("Luggage.XWebCanvasLogic", "load %s fail, %s", new Object[] { paramAnonymousString, localThrowable });
            AppMethodBeat.o(139445);
          }
          return false;
        }
      });
      lBZ = true;
    }
    AppMethodBeat.o(178852);
  }
  
  public static String bqu()
  {
    AppMethodBeat.i(177201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.appbrand.y.d.VE("wxa_library/js_binding_skia.js"));
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(177201);
    return localObject;
  }
  
  public static List<com.tencent.mm.plugin.appbrand.jsapi.m> gV(boolean paramBoolean)
  {
    AppMethodBeat.i(139449);
    ae.i("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ad.b.a.a());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ad.b.a.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ad.b.a.c());
    }
    for (;;)
    {
      AppMethodBeat.o(139449);
      return localArrayList;
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ad.b.b.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.ad.b.b.d());
      localArrayList.add(new e());
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(139448);
    AppMethodBeat.o(139448);
  }
  
  public static SkiaCanvasApp tU(int paramInt)
  {
    try
    {
      AppMethodBeat.i(220606);
      SkiaCanvasApp localSkiaCanvasApp = (SkiaCanvasApp)lCa.get(paramInt);
      AppMethodBeat.o(220606);
      return localSkiaCanvasApp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
      AppMethodBeat.i(220602);
      run();
      AppMethodBeat.o(220602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.b.c
 * JD-Core Version:    0.7.0.1
 */