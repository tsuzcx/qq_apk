package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

final class j$a
  implements j.b
{
  public final com.tencent.mm.vending.j.a i(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(139873);
    paramAppBrandRuntime = paramAppBrandRuntime.Fl().MP(paramString);
    if (paramAppBrandRuntime == null)
    {
      AppMethodBeat.o(139873);
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(w.B(paramAppBrandRuntime.fTh()), localOptions);
    paramString = new j.c((byte)0);
    paramString.width = localOptions.outWidth;
    paramString.height = localOptions.outHeight;
    paramString.type = com.tencent.luggage.e.a.a.e(localOptions);
    if (com.tencent.luggage.e.a.a.d(localOptions)) {}
    for (paramAppBrandRuntime = com.tencent.luggage.e.a.a.gy(com.tencent.luggage.e.a.a.df(w.B(paramAppBrandRuntime.fTh())));; paramAppBrandRuntime = "up")
    {
      paramString.cpm = paramAppBrandRuntime;
      paramAppBrandRuntime = com.tencent.mm.vending.j.a.N(j.e.kYH, paramString);
      AppMethodBeat.o(139873);
      return paramAppBrandRuntime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.j.a
 * JD-Core Version:    0.7.0.1
 */