package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.IOException;
import java.io.InputStream;

final class c$d
  implements c.b
{
  public final com.tencent.mm.vending.j.a h(i parami, String paramString)
  {
    paramString = aq.d(parami, paramString);
    c.c localc;
    boolean bool;
    if (paramString != null)
    {
      paramString.mark(0);
      parami = new BitmapFactory.Options();
      parami.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramString, new Rect(), parami);
      localc = new c.c((byte)0);
      localc.width = parami.outWidth;
      localc.height = parami.outHeight;
      localc.type = com.tencent.mm.plugin.appbrand.v.a.b(parami);
      bool = com.tencent.mm.plugin.appbrand.v.a.a(parami);
    }
    try
    {
      paramString.reset();
      label87:
      if (bool) {}
      for (parami = com.tencent.mm.plugin.appbrand.v.a.mz(com.tencent.mm.plugin.appbrand.v.a.x(paramString));; parami = "up")
      {
        localc.fNK = parami;
        bk.b(paramString);
        return com.tencent.mm.vending.j.a.r(c.e.gwk, localc);
      }
      return com.tencent.mm.vending.j.a.ck(c.e.gwi);
    }
    catch (IOException parami)
    {
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c.d
 * JD-Core Version:    0.7.0.1
 */