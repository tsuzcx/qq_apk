package com.tencent.mm.plugin.appbrand.jsapi.z.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.z.b.b.e;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;
import com.tencent.xweb.skia_canvas.SkiaCanvasLogic;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import com.tencent.xweb.skia_canvas.resource_loader.SkiaCanvasResourceLoader;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static boolean laB = false;
  
  public static void D(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177200);
    blY();
    SkiaCanvasLogic.nativeInitJSBinding(paramLong1, paramLong2);
    AppMethodBeat.o(177200);
  }
  
  public static String NZ(String paramString)
  {
    AppMethodBeat.i(177202);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.format(";bindingUpdate(\"skiacanvas\", \"%s\");", new Object[] { paramString }));
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(177202);
    return paramString;
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.g.b paramb, final com.tencent.mm.plugin.appbrand.g.a parama, final com.tencent.mm.plugin.appbrand.q paramq)
  {
    AppMethodBeat.i(139447);
    blY();
    Object localObject = paramq.aUV();
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)((i)localObject).P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(206720);
            ac.i("Luggage.XWebCanvasLogic", "init resource loader");
            SkiaCanvasResourceLoader.setDelegate(new b(this.laC, parama, paramq));
            AppMethodBeat.o(206720);
          }
        });
      }
    }
    AppMethodBeat.o(139447);
  }
  
  private static void blY()
  {
    AppMethodBeat.i(178852);
    if (!laB)
    {
      h.class.getClassLoader();
      j.sC("c++_shared");
      XWebLibraryLoader.initXWebLibraryLoader(new IXWebLibraryLoader()
      {
        public final boolean afterLoad()
        {
          AppMethodBeat.i(139446);
          h.class.getClassLoader();
          j.sC("skia-canvas-log-bridge");
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
          ac.i("Luggage.XWebCanvasLogic", "load %s", new Object[] { paramAnonymousString });
          try
          {
            h.class.getClassLoader();
            j.sC(paramAnonymousString);
            AppMethodBeat.o(139445);
            return true;
          }
          catch (Throwable localThrowable)
          {
            ac.e("Luggage.XWebCanvasLogic", "load %s fail, %s", new Object[] { paramAnonymousString, localThrowable });
            AppMethodBeat.o(139445);
          }
          return false;
        }
      });
      laB = true;
      SkiaCanvasLogic.init();
    }
    AppMethodBeat.o(178852);
  }
  
  public static String blZ()
  {
    AppMethodBeat.i(177201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.appbrand.z.d.Rn("wxa_library/js_binding_skia.js"));
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(177201);
    return localObject;
  }
  
  public static List<m> gO(boolean paramBoolean)
  {
    AppMethodBeat.i(139449);
    ac.i("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.z.b.a.a());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.z.b.a.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.z.b.a.c());
    }
    for (;;)
    {
      AppMethodBeat.o(139449);
      return localArrayList;
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.z.b.b.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.z.b.b.d());
      localArrayList.add(new e());
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(139448);
    AppMethodBeat.o(139448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b.c
 * JD-Core Version:    0.7.0.1
 */