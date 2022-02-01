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
    final String str = paramd.mBj.getString("id", "");
    if (paramString.startsWith("wxfile://"))
    {
      paramd = AppBrandLocalMediaObjectManager.cY(str, paramString);
      if ((paramd == null) || (TextUtils.isEmpty(paramd.onG)))
      {
        AppMethodBeat.o(121256);
        return null;
      }
      paramString = paramd.onG;
      paramd = paramString;
      if (!paramString.startsWith("file://")) {
        paramd = "file://".concat(String.valueOf(paramString));
      }
      paramd = b.bEY().a(paramd, null);
    }
    for (;;)
    {
      AppMethodBeat.o(121256);
      return paramd;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramRect = b.bEY().a(paramString, null);
        if (paramRect == null)
        {
          b.bEY().a(new b.k()
          {
            public final void bFg() {}
            
            public final void bFh()
            {
              AppMethodBeat.i(121253);
              Bundle localBundle = new Bundle();
              localBundle.putString("id", str);
              localBundle.putInt("widgetState", 2103);
              j.a(i.cnw().YX(str), localBundle, f.a.class, null);
              AppMethodBeat.o(121253);
            }
            
            public final String key()
            {
              return "WxaWidgetIcon";
            }
            
            public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
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
          }, paramString, null, null);
          paramd = paramRect;
        }
      }
      else
      {
        paramd = a.dD(str, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.c
 * JD-Core Version:    0.7.0.1
 */