package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.i;
import java.io.File;

final class h$a
  implements h.b
{
  public final com.tencent.mm.vending.j.a h(i parami, String paramString)
  {
    AppMethodBeat.i(114359);
    parami = parami.wX().zg(paramString);
    if (parami == null)
    {
      AppMethodBeat.o(114359);
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(parami.getAbsolutePath(), localOptions);
    paramString = new h.c((byte)0);
    paramString.width = localOptions.outWidth;
    paramString.height = localOptions.outHeight;
    paramString.type = com.tencent.luggage.e.a.a.c(localOptions);
    if (com.tencent.luggage.e.a.a.b(localOptions)) {}
    for (parami = com.tencent.luggage.e.a.a.ft(com.tencent.luggage.e.a.a.bY(parami.getAbsolutePath()));; parami = "up")
    {
      paramString.hha = parami;
      parami = com.tencent.mm.vending.j.a.C(h.e.hSf, paramString);
      AppMethodBeat.o(114359);
      return parami;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h.a
 * JD-Core Version:    0.7.0.1
 */