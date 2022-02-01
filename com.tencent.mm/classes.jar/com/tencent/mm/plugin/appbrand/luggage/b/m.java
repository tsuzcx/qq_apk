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
import com.tencent.mm.sdk.platformtools.aq;
import java.io.InputStream;
import java.util.Map;

public final class m
  extends c
{
  public final void a(String paramString, Map<String, String> paramMap, final a.c paramc)
  {
    AppMethodBeat.i(207776);
    b localb = b.aEl();
    paramc = new android.arch.a.c.a() {};
    if (TextUtils.isEmpty(paramString))
    {
      paramc.apply(null);
      AppMethodBeat.o(207776);
      return;
    }
    b.p localp = new b.p(paramString, (byte)0);
    localb.hNF.hOa.post(new b.a(localb, localb, localp, paramc, paramString, paramMap));
    AppMethodBeat.o(207776);
  }
  
  public final Bitmap b(String paramString, Rect paramRect, final a.b paramb)
  {
    AppMethodBeat.i(207775);
    if (!match(paramString))
    {
      AppMethodBeat.o(207775);
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.aEl().a(paramString, paramRect);
      if (localBitmap == null) {
        b.aEl().a(new b.k()
        {
          public final String BN()
          {
            AppMethodBeat.i(207772);
            String str = "WxaIcon" + hashCode();
            AppMethodBeat.o(207772);
            return str;
          }
          
          public final void F(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(207770);
            if (paramb == null)
            {
              AppMethodBeat.o(207770);
              return;
            }
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              paramb.N(null);
              AppMethodBeat.o(207770);
              return;
            }
            paramb.N(paramAnonymousBitmap);
            AppMethodBeat.o(207770);
          }
          
          public final void aEt() {}
          
          public final void ox()
          {
            AppMethodBeat.i(207771);
            if (paramb == null)
            {
              AppMethodBeat.o(207771);
              return;
            }
            paramb.N(null);
            AppMethodBeat.o(207771);
          }
        }, paramString, null, paramRect);
      }
      AppMethodBeat.o(207775);
      return localBitmap;
    }
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(207774);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(207774);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(207774);
      return true;
    }
    AppMethodBeat.o(207774);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */