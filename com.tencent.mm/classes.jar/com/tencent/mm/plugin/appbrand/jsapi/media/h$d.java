package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.InputStream;

final class h$d
  implements h.c
{
  public final h.a a(c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(139869);
    if ((paramc == null) || (!(paramc instanceof r)))
    {
      ae.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
      paramc = new h.a(false, "fail:internal error invalid js component");
      AppMethodBeat.o(139869);
      return paramc;
    }
    q localq = paramc.Fl();
    if (localq == null)
    {
      ae.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
      paramc = new h.a(false, "fail:runtime fileSystem is null");
      AppMethodBeat.o(139869);
      return paramc;
    }
    InputStream localInputStream = bg.f(((r)paramc).getRuntime(), paramString);
    if (localInputStream == null)
    {
      ae.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
      paramc = new h.a(false, "fail:file doesn't exist");
      AppMethodBeat.o(139869);
      return paramc;
    }
    paramString = null;
    try
    {
      localOptions = new BitmapFactory.Options();
      localBitmap = e.a.a((e)paramc.K(e.class)).b(localInputStream, localOptions);
      if (localBitmap == null)
      {
        ae.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
        paramc = new h.a(false, "fail:decode image fail");
        AppMethodBeat.o(139869);
        return paramc;
      }
      if (!a.d(localOptions)) {
        break label333;
      }
      paramc = "jpg";
    }
    catch (OutOfMemoryError paramc)
    {
      try
      {
        BitmapFactory.Options localOptions;
        Bitmap localBitmap;
        if (a.d(localOptions)) {}
        for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
        {
          h.a(localBitmap, paramInt, paramString, str, true);
          if (a.d(localOptions)) {
            com.tencent.mm.plugin.appbrand.l.b.b(localInputStream, str);
          }
          paramString = new i();
          if (localq.a(new k(str), paramc, false, paramString) == m.jPM) {
            break label346;
          }
          ae.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
          paramc = new h.a(false, "fail:create tmp file fail");
          AppMethodBeat.o(139869);
          return paramc;
          paramc = "png";
          break;
        }
        ae.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
        paramc = new h.a(true, (String)paramString.value);
        AppMethodBeat.o(139869);
        return paramc;
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          String str;
          paramString = str;
        }
      }
      paramc = paramc;
      ae.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramc });
      paramc = new h.a(false, "fail:compress image OOM");
      AppMethodBeat.o(139869);
      return paramc;
    }
    catch (NullPointerException paramc)
    {
      ae.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramc });
      paramc = new h.a(false, "fail:compress image NPE");
      AppMethodBeat.o(139869);
      return paramc;
    }
    catch (Exception paramc) {}
    str = com.tencent.mm.loader.j.b.asv() + "microMsg.tmp." + System.currentTimeMillis() + "." + paramc;
    label333:
    label346:
    ae.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramc });
    o.deleteFile(paramString);
    paramc = new h.a(false, "fail:compress image exception");
    AppMethodBeat.o(139869);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h.d
 * JD-Core Version:    0.7.0.1
 */