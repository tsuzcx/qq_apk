package com.tencent.mm.plugin.appbrand.jsapi.v.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a.i;
import com.tencent.mm.plugin.appbrand.e.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.xweb.skia_canvas.XWebImageLoader;
import com.tencent.xweb.skia_canvas.XWebLibraryLoader;

public final class c
{
  private static boolean iit = false;
  
  public static void a(com.tencent.mm.plugin.appbrand.e.b paramb, a parama, r paramr)
  {
    AppMethodBeat.i(154464);
    if (!iit)
    {
      k.a("c++_shared", i.class.getClassLoader());
      XWebLibraryLoader.initXWebLibraryLoader(new c.1());
      iit = true;
    }
    XWebImageLoader.initImageLoader(new b(paramb, parama, paramr));
    AppMethodBeat.o(154464);
  }
  
  public static void release()
  {
    AppMethodBeat.i(154465);
    XWebImageLoader.resetImageLoader();
    AppMethodBeat.o(154465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a.c
 * JD-Core Version:    0.7.0.1
 */