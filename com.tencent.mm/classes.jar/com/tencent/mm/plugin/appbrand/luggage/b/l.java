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
import com.tencent.mm.plugin.appbrand.g.a.b;
import com.tencent.mm.plugin.appbrand.g.a.c;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.InputStream;
import java.util.Map;

public final class l
  extends c
{
  public final void a(String paramString, Map<String, String> paramMap, final a.c paramc)
  {
    AppMethodBeat.i(194481);
    b localb = b.aub();
    paramc = new android.arch.a.c.a() {};
    if (TextUtils.isEmpty(paramString))
    {
      paramc.apply(null);
      AppMethodBeat.o(194481);
      return;
    }
    b.p localp = new b.p(paramString, (byte)0);
    localb.gRU.gSp.post(new b.a(localb, localb, localp, paramc, paramString, paramMap));
    AppMethodBeat.o(194481);
  }
  
  public final Bitmap b(String paramString, Rect paramRect, final a.b paramb)
  {
    AppMethodBeat.i(194480);
    if (!match(paramString))
    {
      AppMethodBeat.o(194480);
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.aub().a(paramString, paramRect);
      if (localBitmap == null) {
        b.aub().a(new b.k()
        {
          public final String AL()
          {
            AppMethodBeat.i(194477);
            String str = "WxaIcon" + hashCode();
            AppMethodBeat.o(194477);
            return str;
          }
          
          public final void E(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(194475);
            if (paramb == null)
            {
              AppMethodBeat.o(194475);
              return;
            }
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              paramb.M(null);
              AppMethodBeat.o(194475);
              return;
            }
            paramb.M(paramAnonymousBitmap);
            AppMethodBeat.o(194475);
          }
          
          public final void auj() {}
          
          public final void nV()
          {
            AppMethodBeat.i(194476);
            if (paramb == null)
            {
              AppMethodBeat.o(194476);
              return;
            }
            paramb.M(null);
            AppMethodBeat.o(194476);
          }
        }, paramString, null, paramRect);
      }
      AppMethodBeat.o(194480);
      return localBitmap;
    }
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(194479);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(194479);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(194479);
      return true;
    }
    AppMethodBeat.o(194479);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */