package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;

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
  
  public final Bitmap a(d paramd, String paramString, Rect paramRect, e.a parama)
  {
    AppMethodBeat.i(121256);
    String str = paramd.gzS.getString("id", "");
    if (paramString.startsWith("wxfile://"))
    {
      paramd = AppBrandLocalMediaObjectManager.cl(str, paramString);
      if ((paramd == null) || (TextUtils.isEmpty(paramd.hIy)))
      {
        AppMethodBeat.o(121256);
        return null;
      }
      paramString = paramd.hIy;
      paramd = paramString;
      if (!paramString.startsWith("file://")) {
        paramd = "file://".concat(String.valueOf(paramString));
      }
      paramd = b.aDV().a(paramd, null);
    }
    for (;;)
    {
      AppMethodBeat.o(121256);
      return paramd;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramRect = b.aDV().a(paramString, null);
        if (paramRect == null)
        {
          b.aDV().a(new c.1(this, parama, paramd, paramString, str), paramString, null, null);
          paramd = paramRect;
        }
      }
      else
      {
        paramd = a.cK(str, paramString);
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