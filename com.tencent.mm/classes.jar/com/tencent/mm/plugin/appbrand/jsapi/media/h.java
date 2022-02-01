package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 528;
  private static final String NAME = "compressImage";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(139870);
    if (paramc == null)
    {
      ad.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
      AppMethodBeat.o(139870);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(139870);
      return;
    }
    final String str = paramJSONObject.optString("src");
    if (bt.isNullOrNil(str))
    {
      ad.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
      paramc.h(paramInt, e("fail:data src is null", null));
      AppMethodBeat.o(139870);
      return;
    }
    if (paramc.Fg() == null)
    {
      ad.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
      paramc.h(paramInt, e("fail:runtime fileSystem is null", null));
      AppMethodBeat.o(139870);
      return;
    }
    int j = paramJSONObject.optInt("quality", 80);
    final int i;
    if (j > 0)
    {
      i = j;
      if (j <= 100) {}
    }
    else
    {
      ad.w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
      i = 80;
    }
    ad.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", new Object[] { Integer.valueOf(i), str });
    com.tencent.mm.sdk.g.b.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139867);
        if ((!bt.isNullOrNil(str)) && (str.startsWith("wxfile://"))) {}
        c localc;
        for (Object localObject = new h.b((byte)0);; localObject = new h.d((byte)0))
        {
          localObject = ((h.c)localObject).a(paramc, str, i);
          if ((this.cZC.get() == null) || (!((c)this.cZC.get()).isRunning())) {
            break label256;
          }
          localc = (c)this.cZC.get();
          if ((((h.a)localObject).success) || (!bt.isNullOrNil(((h.a)localObject).result))) {
            break;
          }
          ad.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
          localc.h(paramInt, h.this.e("fail:compress image fail", null));
          AppMethodBeat.o(139867);
          return;
        }
        if (!((h.a)localObject).success)
        {
          ad.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", new Object[] { ((h.a)localObject).result });
          localc.h(paramInt, h.this.e(((h.a)localObject).result, null));
          AppMethodBeat.o(139867);
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((h.a)localObject).result);
        localc.h(paramInt, h.this.m("ok", localHashMap));
        AppMethodBeat.o(139867);
        return;
        label256:
        ad.w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
        AppMethodBeat.o(139867);
      }
    }, String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", new Object[] { str, Integer.valueOf(i) }));
    AppMethodBeat.o(139870);
  }
  
  static final class a
  {
    String result;
    boolean success;
    
    public a(boolean paramBoolean, String paramString)
    {
      this.success = paramBoolean;
      this.result = paramString;
    }
  }
  
  static final class b
    implements h.c
  {
    public final h.a a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(139868);
      p localp = paramc.Fg();
      if (localp == null)
      {
        ad.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:fileSystem is null");
        paramc = new h.a(false, "fail:runtime fileSystem is null");
        AppMethodBeat.o(139868);
        return paramc;
      }
      com.tencent.mm.vfs.e locale = paramc.Fg().Mj(paramString);
      if (locale == null)
      {
        ad.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
        paramc = new h.a(false, "fail:file doesn't exist");
        AppMethodBeat.o(139868);
        return paramc;
      }
      paramString = null;
      try
      {
        localOptions = new BitmapFactory.Options();
        localBitmap = e.a.a((e)paramc.K(e.class)).decodeFile(com.tencent.mm.vfs.q.B(locale.fOK()), localOptions);
        if (localBitmap == null)
        {
          ad.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          paramc = new h.a(false, "fail:decode image fail");
          AppMethodBeat.o(139868);
          return paramc;
        }
        if (!com.tencent.luggage.e.a.a.d(localOptions)) {
          break label310;
        }
        paramc = "jpg";
      }
      catch (OutOfMemoryError paramc)
      {
        try
        {
          BitmapFactory.Options localOptions;
          Bitmap localBitmap;
          if (com.tencent.luggage.e.a.a.d(localOptions)) {}
          for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
          {
            g.a(localBitmap, paramInt, paramString, str, true);
            if (com.tencent.luggage.e.a.a.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.l.b.cT(com.tencent.mm.vfs.q.B(locale.fOK()), str);
            }
            paramString = new com.tencent.mm.plugin.appbrand.z.i();
            if (localp.a(new com.tencent.mm.vfs.e(str), paramc, false, paramString) == l.jMv) {
              break label323;
            }
            ad.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
            paramc = new h.a(false, "fail:create tmp file fail");
            AppMethodBeat.o(139868);
            return paramc;
            paramc = "png";
            break;
          }
          ad.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
          paramc = new h.a(true, (String)paramString.value);
          AppMethodBeat.o(139868);
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
        ad.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramc });
        paramc = new h.a(false, "fail:compress image OOM");
        AppMethodBeat.o(139868);
        return paramc;
      }
      catch (NullPointerException paramc)
      {
        label310:
        label323:
        ad.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramc });
        paramc = new h.a(false, "fail:compress image NPE");
        AppMethodBeat.o(139868);
        return paramc;
      }
      catch (Exception paramc) {}
      str = com.tencent.mm.loader.j.b.asg() + "microMsg.tmp." + System.currentTimeMillis() + "." + paramc;
      ad.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramc });
      com.tencent.mm.vfs.i.deleteFile(paramString);
      paramc = new h.a(false, "fail:compress image exception");
      AppMethodBeat.o(139868);
      return paramc;
    }
  }
  
  static abstract interface c
  {
    public abstract h.a a(c paramc, String paramString, int paramInt);
  }
  
  static final class d
    implements h.c
  {
    public final h.a a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(139869);
      if ((paramc == null) || (!(paramc instanceof com.tencent.mm.plugin.appbrand.q)))
      {
        ad.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
        paramc = new h.a(false, "fail:internal error invalid js component");
        AppMethodBeat.o(139869);
        return paramc;
      }
      p localp = paramc.Fg();
      if (localp == null)
      {
        ad.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
        paramc = new h.a(false, "fail:runtime fileSystem is null");
        AppMethodBeat.o(139869);
        return paramc;
      }
      InputStream localInputStream = bf.f(((com.tencent.mm.plugin.appbrand.q)paramc).getRuntime(), paramString);
      if (localInputStream == null)
      {
        ad.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
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
          ad.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          paramc = new h.a(false, "fail:decode image fail");
          AppMethodBeat.o(139869);
          return paramc;
        }
        if (!com.tencent.luggage.e.a.a.d(localOptions)) {
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
          if (com.tencent.luggage.e.a.a.d(localOptions)) {}
          for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
          {
            g.a(localBitmap, paramInt, paramString, str, true);
            if (com.tencent.luggage.e.a.a.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.l.b.b(localInputStream, str);
            }
            paramString = new com.tencent.mm.plugin.appbrand.z.i();
            if (localp.a(new com.tencent.mm.vfs.e(str), paramc, false, paramString) == l.jMv) {
              break label346;
            }
            ad.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
            paramc = new h.a(false, "fail:create tmp file fail");
            AppMethodBeat.o(139869);
            return paramc;
            paramc = "png";
            break;
          }
          ad.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
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
        ad.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramc });
        paramc = new h.a(false, "fail:compress image OOM");
        AppMethodBeat.o(139869);
        return paramc;
      }
      catch (NullPointerException paramc)
      {
        ad.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramc });
        paramc = new h.a(false, "fail:compress image NPE");
        AppMethodBeat.o(139869);
        return paramc;
      }
      catch (Exception paramc) {}
      str = com.tencent.mm.loader.j.b.asg() + "microMsg.tmp." + System.currentTimeMillis() + "." + paramc;
      label333:
      label346:
      ad.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramc });
      com.tencent.mm.vfs.i.deleteFile(paramString);
      paramc = new h.a(false, "fail:compress image exception");
      AppMethodBeat.o(139869);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h
 * JD-Core Version:    0.7.0.1
 */