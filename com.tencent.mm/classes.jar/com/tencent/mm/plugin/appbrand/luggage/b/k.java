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
    AppMethodBeat.i(243671);
    b localb = b.bhh();
    paramc = new androidx.a.a.c.a() {};
    if (TextUtils.isEmpty(paramString))
    {
      paramc.apply(null);
      AppMethodBeat.o(243671);
      return;
    }
    b.q localq = new b.q(paramString, (byte)0);
    localb.lyO.lzj.post(new b.a(localb, localb, localq, paramc, paramString, paramMap));
    AppMethodBeat.o(243671);
  }
  
  public final Bitmap b(String paramString, Rect paramRect, final a.b paramb)
  {
    AppMethodBeat.i(243670);
    if (!dq(paramString))
    {
      AppMethodBeat.o(243670);
      return null;
    }
    if (paramRect != null) {}
    for (paramRect = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());; paramRect = null)
    {
      Bitmap localBitmap = b.bhh().a(paramString, paramRect);
      if (localBitmap == null) {
        b.bhh().a(new b.k()
        {
          public final void G(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(244686);
            if (paramb == null)
            {
              AppMethodBeat.o(244686);
              return;
            }
            if ((paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
            {
              paramb.O(null);
              AppMethodBeat.o(244686);
              return;
            }
            paramb.O(paramAnonymousBitmap);
            AppMethodBeat.o(244686);
          }
          
          public final void bhq() {}
          
          public final void bhr()
          {
            AppMethodBeat.i(244688);
            if (paramb == null)
            {
              AppMethodBeat.o(244688);
              return;
            }
            paramb.O(null);
            AppMethodBeat.o(244688);
          }
          
          public final String key()
          {
            AppMethodBeat.i(244689);
            String str = "WxaIcon" + hashCode();
            AppMethodBeat.o(244689);
            return str;
          }
        }, paramString, null, paramRect);
      }
      AppMethodBeat.o(243670);
      return localBitmap;
    }
  }
  
  public final boolean dq(String paramString)
  {
    AppMethodBeat.i(243669);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(243669);
      return false;
    }
    paramString = paramString.toLowerCase();
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(243669);
      return true;
    }
    AppMethodBeat.o(243669);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */