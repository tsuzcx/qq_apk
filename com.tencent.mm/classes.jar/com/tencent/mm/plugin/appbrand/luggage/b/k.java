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

public final class k
  extends c
{
  public final void a(String paramString, Map<String, String> paramMap, final a.c paramc)
  {
    AppMethodBeat.i(319890);
    b localb = b.bEY();
    paramc = new androidx.a.a.c.a() {};
    if (TextUtils.isEmpty(paramString))
    {
      paramc.apply(null);
      AppMethodBeat.o(319890);
      return;
    }
    b.q localq = new b.q(paramString, (byte)0);
    localb.oqp.oqK.post(new b.a(localb, localb, localq, paramc, paramString, paramMap));
    AppMethodBeat.o(319890);
  }
  
  public final Bitmap b(String paramString, Rect paramRect, final a.b paramb)
  {
    AppMethodBeat.i(319885);
    if (!match(paramString))
    {
      AppMethodBeat.o(319885);
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.bEY().a(paramString, paramRect);
      if (localBitmap == null) {
        b.bEY().a(new b.k()
        {
          public final void bFg() {}
          
          public final void bFh()
          {
            AppMethodBeat.i(319866);
            if (paramb == null)
            {
              AppMethodBeat.o(319866);
              return;
            }
            paramb.W(null);
            AppMethodBeat.o(319866);
          }
          
          public final String key()
          {
            AppMethodBeat.i(319868);
            String str = "WxaIcon" + hashCode();
            AppMethodBeat.o(319868);
            return str;
          }
          
          public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(319864);
            if (paramb == null)
            {
              AppMethodBeat.o(319864);
              return;
            }
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              paramb.W(null);
              AppMethodBeat.o(319864);
              return;
            }
            paramb.W(paramAnonymousBitmap);
            AppMethodBeat.o(319864);
          }
        }, paramString, null, paramRect);
      }
      AppMethodBeat.o(319885);
      return localBitmap;
    }
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(319879);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(319879);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(319879);
      return true;
    }
    AppMethodBeat.o(319879);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */