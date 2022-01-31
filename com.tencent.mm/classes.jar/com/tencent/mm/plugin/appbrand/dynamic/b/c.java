package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.i;
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
    AppMethodBeat.i(10772);
    paramd = a(paramd, paramString, null);
    AppMethodBeat.o(10772);
    return paramd;
  }
  
  public final Bitmap a(final d paramd, final String paramString, Rect paramRect, final e.a parama)
  {
    AppMethodBeat.i(10774);
    final String str = paramd.eGu.getString("id", "");
    if (paramString.startsWith("wxfile://"))
    {
      paramd = AppBrandLocalMediaObjectManager.bw(str, paramString);
      if ((paramd == null) || (TextUtils.isEmpty(paramd.fod)))
      {
        AppMethodBeat.o(10774);
        return null;
      }
      paramString = paramd.fod;
      paramd = paramString;
      if (!paramString.startsWith("file://")) {
        paramd = "file://".concat(String.valueOf(paramString));
      }
      paramd = b.acD().a(paramd, null);
    }
    for (;;)
    {
      AppMethodBeat.o(10774);
      return paramd;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramRect = b.acD().a(paramString, null);
        if (paramRect == null)
        {
          b.acD().a(new b.i()
          {
            public final void acG() {}
            
            public final void acH()
            {
              AppMethodBeat.i(10771);
              Bundle localBundle = new Bundle();
              localBundle.putString("id", str);
              localBundle.putInt("widgetState", 2103);
              f.a(i.azB().AY(str), localBundle, f.a.class, null);
              AppMethodBeat.o(10771);
            }
            
            public final String tX()
            {
              return "WxaWidgetIcon";
            }
            
            public final void w(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(10770);
              if ((parama == null) || (paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled()))
              {
                AppMethodBeat.o(10770);
                return;
              }
              parama.a(paramd);
              AppMethodBeat.o(10770);
            }
          }, paramString, null, null);
          paramd = paramRect;
        }
      }
      else
      {
        paramd = a.bP(str, paramString);
        continue;
      }
      paramd = paramRect;
    }
  }
  
  public final Bitmap a(d paramd, String paramString, e.a parama)
  {
    AppMethodBeat.i(10773);
    paramd = a(paramd, paramString, null, parama);
    AppMethodBeat.o(10773);
    return paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.c
 * JD-Core Version:    0.7.0.1
 */