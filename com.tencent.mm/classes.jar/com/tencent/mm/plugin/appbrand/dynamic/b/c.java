package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.model.z.b;
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
    final String str = paramd.gCz.getString("id", "");
    if (paramString.startsWith("wxfile://"))
    {
      paramd = AppBrandLocalMediaObjectManager.cm(str, paramString);
      if ((paramd == null) || (TextUtils.isEmpty(paramd.hLr)))
      {
        AppMethodBeat.o(121256);
        return null;
      }
      paramString = paramd.hLr;
      paramd = paramString;
      if (!paramString.startsWith("file://")) {
        paramd = "file://".concat(String.valueOf(paramString));
      }
      paramd = b.aEl().a(paramd, null);
    }
    for (;;)
    {
      AppMethodBeat.o(121256);
      return paramd;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramRect = b.aEl().a(paramString, null);
        if (paramRect == null)
        {
          b.aEl().a(new b.k()
          {
            public final String BN()
            {
              return "WxaWidgetIcon";
            }
            
            public final void F(Bitmap paramAnonymousBitmap)
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
            
            public final void aEt() {}
            
            public final void ox()
            {
              AppMethodBeat.i(121253);
              Bundle localBundle = new Bundle();
              localBundle.putString("id", str);
              localBundle.putInt("widgetState", 2103);
              h.a(i.bgs().Pc(str), localBundle, f.a.class, null);
              AppMethodBeat.o(121253);
            }
          }, paramString, null, null);
          paramd = paramRect;
        }
      }
      else
      {
        paramd = a.cM(str, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.c
 * JD-Core Version:    0.7.0.1
 */