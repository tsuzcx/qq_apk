package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;

final class c
  implements e
{
  public final Bitmap a(d paramd, String paramString)
  {
    AppMethodBeat.i(121254);
    paramd = a(paramd, paramString, null);
    AppMethodBeat.o(121254);
    return paramd;
  }
  
  public final Bitmap a(final d paramd, final String paramString, Rect paramRect, final e.a parama)
  {
    AppMethodBeat.i(121256);
    final String str = paramd.kbe.getString("id", "");
    if (paramString.startsWith("wxfile://"))
    {
      paramd = AppBrandLocalMediaObjectManager.cF(str, paramString);
      if ((paramd == null) || (TextUtils.isEmpty(paramd.lwh)))
      {
        AppMethodBeat.o(121256);
        return null;
      }
      paramString = paramd.lwh;
      paramd = paramString;
      if (!paramString.startsWith("file://")) {
        paramd = "file://".concat(String.valueOf(paramString));
      }
      paramd = b.bhh().a(paramd, null);
    }
    for (;;)
    {
      AppMethodBeat.o(121256);
      return paramd;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramRect = b.bhh().a(paramString, null);
        if (paramRect == null)
        {
          b.bhh().a(new b.k()
          {
            public final void G(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(121252);
              if ((parama == null) || (paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
              {
                AppMethodBeat.o(121252);
                return;
              }
              parama.a(paramd);
              AppMethodBeat.o(121252);
            }
            
            public final void bhq() {}
            
            public final void bhr()
            {
              AppMethodBeat.i(121253);
              Bundle localBundle = new Bundle();
              localBundle.putString("id", str);
              localBundle.putInt("widgetState", 2103);
              j.a(i.bNh().agb(str), localBundle, f.a.class, null);
              AppMethodBeat.o(121253);
            }
            
            public final String key()
            {
              return "WxaWidgetIcon";
            }
          }, paramString, null, null);
          paramd = paramRect;
        }
      }
      else
      {
        paramd = a.dk(str, paramString);
        continue;
      }
      paramd = paramRect;
    }
  }
  
  public final Bitmap a(d paramd, String paramString, e.a parama)
  {
    AppMethodBeat.i(121255);
    paramd = a(paramd, paramString, null, parama);
    AppMethodBeat.o(121255);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.c
 * JD-Core Version:    0.7.0.1
 */