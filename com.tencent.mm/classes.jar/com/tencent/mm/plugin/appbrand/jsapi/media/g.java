package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 528;
  private static final String NAME = "compressImage";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(139870);
    if (paramc == null)
    {
      ac.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
      AppMethodBeat.o(139870);
      return;
    }
    if (paramJSONObject == null)
    {
      ac.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(139870);
      return;
    }
    final String str = paramJSONObject.optString("src");
    if (bs.isNullOrNil(str))
    {
      ac.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
      paramc.h(paramInt, e("fail:data src is null", null));
      AppMethodBeat.o(139870);
      return;
    }
    if (paramc.DH() == null)
    {
      ac.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
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
      ac.w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
      i = 80;
    }
    ac.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", new Object[] { Integer.valueOf(i), str });
    com.tencent.mm.sdk.g.b.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139867);
        if ((!bs.isNullOrNil(str)) && (str.startsWith("wxfile://"))) {}
        c localc;
        for (Object localObject = new g.b((byte)0);; localObject = new g.d((byte)0))
        {
          localObject = ((g.c)localObject).a(paramc, str, i);
          if ((this.cOm.get() == null) || (!((c)this.cOm.get()).isRunning())) {
            break label256;
          }
          localc = (c)this.cOm.get();
          if ((((g.a)localObject).success) || (!bs.isNullOrNil(((g.a)localObject).result))) {
            break;
          }
          ac.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
          localc.h(paramInt, g.this.e("fail:compress image fail", null));
          AppMethodBeat.o(139867);
          return;
        }
        if (!((g.a)localObject).success)
        {
          ac.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", new Object[] { ((g.a)localObject).result });
          localc.h(paramInt, g.this.e(((g.a)localObject).result, null));
          AppMethodBeat.o(139867);
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((g.a)localObject).result);
        localc.h(paramInt, g.this.k("ok", localHashMap));
        AppMethodBeat.o(139867);
        return;
        label256:
        ac.w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
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
    implements g.c
  {
    public final g.a a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(139868);
      p localp = paramc.DH();
      if (localp == null)
      {
        ac.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:fileSystem is null");
        paramc = new g.a(false, "fail:runtime fileSystem is null");
        AppMethodBeat.o(139868);
        return paramc;
      }
      e locale = paramc.DH().IS(paramString);
      if (locale == null)
      {
        ac.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
        paramc = new g.a(false, "fail:file doesn't exist");
        AppMethodBeat.o(139868);
        return paramc;
      }
      paramString = null;
      try
      {
        localOptions = new BitmapFactory.Options();
        localBitmap = d.a.a((d)paramc.K(d.class)).decodeFile(com.tencent.mm.vfs.q.B(locale.fxV()), localOptions);
        if (localBitmap == null)
        {
          ac.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          paramc = new g.a(false, "fail:decode image fail");
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
            f.a(localBitmap, paramInt, paramString, str, true);
            if (com.tencent.luggage.e.a.a.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.m.b.cR(com.tencent.mm.vfs.q.B(locale.fxV()), str);
            }
            paramString = new com.tencent.mm.plugin.appbrand.z.i();
            if (localp.a(new e(str), paramc, false, paramString) == l.jsB) {
              break label323;
            }
            ac.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
            paramc = new g.a(false, "fail:create tmp file fail");
            AppMethodBeat.o(139868);
            return paramc;
            paramc = "png";
            break;
          }
          ac.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
          paramc = new g.a(true, (String)paramString.value);
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
        ac.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramc });
        paramc = new g.a(false, "fail:compress image OOM");
        AppMethodBeat.o(139868);
        return paramc;
      }
      catch (NullPointerException paramc)
      {
        label310:
        label323:
        ac.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramc });
        paramc = new g.a(false, "fail:compress image NPE");
        AppMethodBeat.o(139868);
        return paramc;
      }
      catch (Exception paramc) {}
      str = com.tencent.mm.loader.j.b.aps() + "microMsg.tmp." + System.currentTimeMillis() + "." + paramc;
      ac.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramc });
      com.tencent.mm.vfs.i.deleteFile(paramString);
      paramc = new g.a(false, "fail:compress image exception");
      AppMethodBeat.o(139868);
      return paramc;
    }
  }
  
  static abstract interface c
  {
    public abstract g.a a(c paramc, String paramString, int paramInt);
  }
  
  static final class d
    implements g.c
  {
    public final g.a a(c paramc, String paramString, int paramInt)
    {
      AppMethodBeat.i(139869);
      if ((paramc == null) || (!(paramc instanceof com.tencent.mm.plugin.appbrand.q)))
      {
        ac.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
        paramc = new g.a(false, "fail:internal error invalid js component");
        AppMethodBeat.o(139869);
        return paramc;
      }
      p localp = paramc.DH();
      if (localp == null)
      {
        ac.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
        paramc = new g.a(false, "fail:runtime fileSystem is null");
        AppMethodBeat.o(139869);
        return paramc;
      }
      InputStream localInputStream = be.f(((com.tencent.mm.plugin.appbrand.q)paramc).getRuntime(), paramString);
      if (localInputStream == null)
      {
        ac.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
        paramc = new g.a(false, "fail:file doesn't exist");
        AppMethodBeat.o(139869);
        return paramc;
      }
      paramString = null;
      try
      {
        localOptions = new BitmapFactory.Options();
        localBitmap = d.a.a((d)paramc.K(d.class)).b(localInputStream, localOptions);
        if (localBitmap == null)
        {
          ac.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          paramc = new g.a(false, "fail:decode image fail");
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
            f.a(localBitmap, paramInt, paramString, str, true);
            if (com.tencent.luggage.e.a.a.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.m.b.b(localInputStream, str);
            }
            paramString = new com.tencent.mm.plugin.appbrand.z.i();
            if (localp.a(new e(str), paramc, false, paramString) == l.jsB) {
              break label346;
            }
            ac.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
            paramc = new g.a(false, "fail:create tmp file fail");
            AppMethodBeat.o(139869);
            return paramc;
            paramc = "png";
            break;
          }
          ac.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
          paramc = new g.a(true, (String)paramString.value);
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
        ac.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramc });
        paramc = new g.a(false, "fail:compress image OOM");
        AppMethodBeat.o(139869);
        return paramc;
      }
      catch (NullPointerException paramc)
      {
        ac.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramc });
        paramc = new g.a(false, "fail:compress image NPE");
        AppMethodBeat.o(139869);
        return paramc;
      }
      catch (Exception paramc) {}
      str = com.tencent.mm.loader.j.b.aps() + "microMsg.tmp." + System.currentTimeMillis() + "." + paramc;
      label333:
      label346:
      ac.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramc });
      com.tencent.mm.vfs.i.deleteFile(paramString);
      paramc = new g.a(false, "fail:compress image exception");
      AppMethodBeat.o(139869);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.g
 * JD-Core Version:    0.7.0.1
 */