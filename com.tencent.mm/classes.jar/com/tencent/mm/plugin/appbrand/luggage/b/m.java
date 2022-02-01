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
import com.tencent.mm.modelappbrand.a.b.q;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.io.InputStream;
import java.util.Map;

public final class m
  extends c
{
  public final void a(String paramString, Map<String, String> paramMap, final a.c paramc)
  {
    AppMethodBeat.i(219350);
    b localb = b.aXY();
    paramc = new android.arch.a.c.a() {};
    if (TextUtils.isEmpty(paramString))
    {
      paramc.apply(null);
      AppMethodBeat.o(219350);
      return;
    }
    b.q localq = new b.q(paramString, (byte)0);
    localb.iIK.iJf.post(new b.a(localb, localb, localq, paramc, paramString, paramMap));
    AppMethodBeat.o(219350);
  }
  
  public final Bitmap b(String paramString, Rect paramRect, final a.b paramb)
  {
    AppMethodBeat.i(219349);
    if (!match(paramString))
    {
      AppMethodBeat.o(219349);
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.aXY().a(paramString, paramRect);
      if (localBitmap == null) {
        b.aXY().a(new b.k()
        {
          public final void I(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(219344);
            if (paramb == null)
            {
              AppMethodBeat.o(219344);
              return;
            }
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              paramb.Q(null);
              AppMethodBeat.o(219344);
              return;
            }
            paramb.Q(paramAnonymousBitmap);
            AppMethodBeat.o(219344);
          }
          
          public final String Lb()
          {
            AppMethodBeat.i(219346);
            String str = "WxaIcon" + hashCode();
            AppMethodBeat.o(219346);
            return str;
          }
          
          public final void aYg() {}
          
          public final void oD()
          {
            AppMethodBeat.i(219345);
            if (paramb == null)
            {
              AppMethodBeat.o(219345);
              return;
            }
            paramb.Q(null);
            AppMethodBeat.o(219345);
          }
        }, paramString, null, paramRect);
      }
      AppMethodBeat.o(219349);
      return localBitmap;
    }
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(219348);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(219348);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(219348);
      return true;
    }
    AppMethodBeat.o(219348);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */