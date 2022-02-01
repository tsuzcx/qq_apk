package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.io.InputStream;

final class j$d
  implements j.b
{
  public final com.tencent.mm.vending.j.a i(AppBrandRuntime paramAppBrandRuntime, String paramString)
  {
    AppMethodBeat.i(139874);
    paramString = bg.f(paramAppBrandRuntime, paramString);
    j.c localc;
    boolean bool;
    if (paramString != null)
    {
      paramString.mark(0);
      paramAppBrandRuntime = new BitmapFactory.Options();
      paramAppBrandRuntime.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramString, new Rect(), paramAppBrandRuntime);
      localc = new j.c((byte)0);
      localc.width = paramAppBrandRuntime.outWidth;
      localc.height = paramAppBrandRuntime.outHeight;
      localc.type = com.tencent.luggage.e.a.a.e(paramAppBrandRuntime);
      bool = com.tencent.luggage.e.a.a.d(paramAppBrandRuntime);
    }
    try
    {
      paramString.reset();
      label92:
      if (bool) {}
      for (paramAppBrandRuntime = com.tencent.luggage.e.a.a.gy(com.tencent.luggage.e.a.a.m(paramString));; paramAppBrandRuntime = "up")
      {
        localc.cpm = paramAppBrandRuntime;
        bu.d(paramString);
        paramAppBrandRuntime = com.tencent.mm.vending.j.a.N(j.e.kYH, localc);
        AppMethodBeat.o(139874);
        return paramAppBrandRuntime;
      }
      paramAppBrandRuntime = com.tencent.mm.vending.j.a.el(j.e.kYF);
      AppMethodBeat.o(139874);
      return paramAppBrandRuntime;
    }
    catch (IOException paramAppBrandRuntime)
    {
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.j.d
 * JD-Core Version:    0.7.0.1
 */