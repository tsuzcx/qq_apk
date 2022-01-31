package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.i;
import java.io.File;

final class c$a
  implements c.b
{
  public final com.tencent.mm.vending.j.a h(i parami, String paramString)
  {
    parami = parami.Zl().rx(paramString);
    if (parami == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(parami.getAbsolutePath(), localOptions);
    paramString = new c.c((byte)0);
    paramString.width = localOptions.outWidth;
    paramString.height = localOptions.outHeight;
    paramString.type = com.tencent.mm.plugin.appbrand.v.a.b(localOptions);
    if (com.tencent.mm.plugin.appbrand.v.a.a(localOptions)) {}
    for (parami = com.tencent.mm.plugin.appbrand.v.a.mz(com.tencent.mm.plugin.appbrand.v.a.wF(parami.getAbsolutePath()));; parami = "up")
    {
      paramString.fNK = parami;
      return com.tencent.mm.vending.j.a.r(c.e.gwk, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c.a
 * JD-Core Version:    0.7.0.1
 */