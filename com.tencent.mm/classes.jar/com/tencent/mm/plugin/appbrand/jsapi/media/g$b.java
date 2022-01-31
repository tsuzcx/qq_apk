package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

final class g$b
  implements g.c
{
  public final g.a a(c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(114354);
    o localo = paramc.wX();
    if (localo == null)
    {
      ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:fileSystem is null");
      paramc = new g.a(false, "fail:runtime fileSystem is null");
      AppMethodBeat.o(114354);
      return paramc;
    }
    File localFile = paramc.wX().zg(paramString);
    if (localFile == null)
    {
      ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
      paramc = new g.a(false, "fail:file doesn't exist");
      AppMethodBeat.o(114354);
      return paramc;
    }
    paramString = null;
    try
    {
      localOptions = new BitmapFactory.Options();
      localBitmap = d.a.a((d)paramc.q(d.class)).decodeFile(localFile.getAbsolutePath(), localOptions);
      if (localBitmap == null)
      {
        ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
        paramc = new g.a(false, "fail:decode image fail");
        AppMethodBeat.o(114354);
        return paramc;
      }
      if (!a.b(localOptions)) {
        break label303;
      }
      paramc = "jpg";
    }
    catch (OutOfMemoryError paramc)
    {
      try
      {
        BitmapFactory.Options localOptions;
        Bitmap localBitmap;
        if (a.b(localOptions)) {}
        for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
        {
          com.tencent.mm.sdk.platformtools.d.a(localBitmap, paramInt, paramString, str, true);
          if (a.b(localOptions)) {
            b.bZ(localFile.getAbsolutePath(), str);
          }
          paramString = new com.tencent.mm.plugin.appbrand.s.j();
          if (localo.a(new File(str), paramc, false, paramString) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA) {
            break label316;
          }
          ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
          paramc = new g.a(false, "fail:create tmp file fail");
          AppMethodBeat.o(114354);
          return paramc;
          paramc = "png";
          break;
        }
        ab.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
        paramc = new g.a(true, (String)paramString.value);
        AppMethodBeat.o(114354);
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
      ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramc });
      paramc = new g.a(false, "fail:compress image OOM");
      AppMethodBeat.o(114354);
      return paramc;
    }
    catch (NullPointerException paramc)
    {
      label303:
      label316:
      ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramc });
      paramc = new g.a(false, "fail:compress image NPE");
      AppMethodBeat.o(114354);
      return paramc;
    }
    catch (Exception paramc) {}
    str = com.tencent.mm.compatible.util.e.esr + "microMsg.tmp." + System.currentTimeMillis() + "." + paramc;
    ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramc });
    com.tencent.mm.a.e.deleteFile(paramString);
    paramc = new g.a(false, "fail:compress image exception");
    AppMethodBeat.o(114354);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.g.b
 * JD-Core Version:    0.7.0.1
 */