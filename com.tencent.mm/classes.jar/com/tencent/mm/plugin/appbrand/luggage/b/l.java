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
import com.tencent.mm.sdk.platformtools.ao;
import java.io.InputStream;
import java.util.Map;

public final class l
  extends c
{
  public final void a(String paramString, Map<String, String> paramMap, final a.c paramc)
  {
    AppMethodBeat.i(193397);
    b localb = b.aAS();
    paramc = new android.arch.a.c.a() {};
    if (TextUtils.isEmpty(paramString))
    {
      paramc.apply(null);
      AppMethodBeat.o(193397);
      return;
    }
    b.p localp = new b.p(paramString, (byte)0);
    localb.hsu.hsP.post(new b.a(localb, localb, localp, paramc, paramString, paramMap));
    AppMethodBeat.o(193397);
  }
  
  public final Bitmap b(String paramString, Rect paramRect, final a.b paramb)
  {
    AppMethodBeat.i(193396);
    if (!match(paramString))
    {
      AppMethodBeat.o(193396);
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.aAS().a(paramString, paramRect);
      if (localBitmap == null) {
        b.aAS().a(new b.k()
        {
          public final String Ap()
          {
            AppMethodBeat.i(193393);
            String str = "WxaIcon" + hashCode();
            AppMethodBeat.o(193393);
            return str;
          }
          
          public final void E(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(193391);
            if (paramb == null)
            {
              AppMethodBeat.o(193391);
              return;
            }
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              paramb.M(null);
              AppMethodBeat.o(193391);
              return;
            }
            paramb.M(paramAnonymousBitmap);
            AppMethodBeat.o(193391);
          }
          
          public final void aBa() {}
          
          public final void of()
          {
            AppMethodBeat.i(193392);
            if (paramb == null)
            {
              AppMethodBeat.o(193392);
              return;
            }
            paramb.M(null);
            AppMethodBeat.o(193392);
          }
        }, paramString, null, paramRect);
      }
      AppMethodBeat.o(193396);
      return localBitmap;
    }
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(193395);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(193395);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(193395);
      return true;
    }
    AppMethodBeat.o(193395);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */