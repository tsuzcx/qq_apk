package com.tencent.mm.plugin.appbrand.jsapi.aa.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.h;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.skia_canvas.IXWebLibraryLoader;
import com.tencent.xweb.skia_canvas.SkiaCanvasLogic;
import com.tencent.xweb.skia_canvas.XWebImageLoader;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  private static boolean kzm = false;
  
  public static void H(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(177200);
    bfe();
    SkiaCanvasLogic.nativeInitJSBinding(paramLong1, paramLong2);
    AppMethodBeat.o(177200);
  }
  
  public static String JS(String paramString)
  {
    AppMethodBeat.i(177202);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.format(";bindingUpdate(\"skiacanvas\", \"%s\");", new Object[] { paramString }));
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(177202);
    return paramString;
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.g.b paramb, com.tencent.mm.plugin.appbrand.g.a parama, q paramq)
  {
    AppMethodBeat.i(139447);
    bfe();
    XWebImageLoader.initImageLoader(new b(paramb, parama, paramq));
    AppMethodBeat.o(139447);
  }
  
  private static void bfe()
  {
    AppMethodBeat.i(178852);
    if (!kzm)
    {
      h.class.getClassLoader();
      j.pq("c++_shared");
      XWebLibraryLoader.initXWebLibraryLoader(new IXWebLibraryLoader()
      {
        public final boolean afterLoad()
        {
          AppMethodBeat.i(139446);
          h.class.getClassLoader();
          j.pq("skia-canvas-log-bridge");
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
            j.pq(paramAnonymousString);
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
      kzm = true;
      SkiaCanvasLogic.init();
    }
    AppMethodBeat.o(178852);
  }
  
  public static String bff()
  {
    AppMethodBeat.i(177201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(com.tencent.mm.plugin.appbrand.aa.d.Ne("wxa_library/js_binding_skia.js"));
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(177201);
    return localObject;
  }
  
  public static List<m> gs(boolean paramBoolean)
  {
    AppMethodBeat.i(139449);
    ad.i("Luggage.XWebCanvasLogic", "createCavnasJsApis useCoverView:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean)
    {
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.aa.b.a.a());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.aa.b.a.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.aa.b.a.c());
    }
    for (;;)
    {
      AppMethodBeat.o(139449);
      return localArrayList;
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.b());
      localArrayList.add(new com.tencent.mm.plugin.appbrand.jsapi.aa.b.b.d());
      localArrayList.add(new e());
    }
  }
  
  public static void release()
  {
    AppMethodBeat.i(139448);
    XWebImageLoader.resetImageLoader();
    AppMethodBeat.o(139448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.b.c
 * JD-Core Version:    0.7.0.1
 */