package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.luggage.bridge.impl.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.a;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.a.b.p;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.InputStream;
import java.util.Map;

public final class l
  extends c
{
  public final void a(String paramString, Map<String, String> paramMap, final a.c paramc)
  {
    AppMethodBeat.i(197290);
    b localb = b.aDV();
    paramc = new android.arch.a.c.a() {};
    if (TextUtils.isEmpty(paramString))
    {
      paramc.apply(null);
      AppMethodBeat.o(197290);
      return;
    }
    b.p localp = new b.p(paramString, (byte)0);
    localb.hKM.hLh.post(new b.a(localb, localb, localp, paramc, paramString, paramMap));
    AppMethodBeat.o(197290);
  }
  
  public final Bitmap b(String paramString, Rect paramRect, final a.b paramb)
  {
    AppMethodBeat.i(197289);
    if (!match(paramString))
    {
      AppMethodBeat.o(197289);
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.aDV().a(paramString, paramRect);
      if (localBitmap == null) {
        b.aDV().a(new b.k()
        {
          public final String BM()
          {
            AppMethodBeat.i(197286);
            String str = "WxaIcon" + hashCode();
            AppMethodBeat.o(197286);
            return str;
          }
          
          public final void E(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(197284);
            if (paramb == null)
            {
              AppMethodBeat.o(197284);
              return;
            }
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              paramb.M(null);
              AppMethodBeat.o(197284);
              return;
            }
            paramb.M(paramAnonymousBitmap);
            AppMethodBeat.o(197284);
          }
          
          public final void aEd() {}
          
          public final void ox()
          {
            AppMethodBeat.i(197285);
            if (paramb == null)
            {
              AppMethodBeat.o(197285);
              return;
            }
            paramb.M(null);
            AppMethodBeat.o(197285);
          }
        }, paramString, null, paramRect);
      }
      AppMethodBeat.o(197289);
      return localBitmap;
    }
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(197288);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(197288);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(197288);
      return true;
    }
    AppMethodBeat.o(197288);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */