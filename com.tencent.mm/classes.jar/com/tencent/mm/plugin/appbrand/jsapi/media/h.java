package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends c
{
  private static final int CTRL_INDEX = 528;
  private static final String NAME = "compressImage";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(139870);
    if (parame == null)
    {
      Log.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
      AppMethodBeat.o(139870);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(139870);
      return;
    }
    final String str = paramJSONObject.optString("src");
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
      parame.j(paramInt, h("fail:data src is null", null));
      AppMethodBeat.o(139870);
      return;
    }
    if (parame.getFileSystem() == null)
    {
      Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
      parame.j(paramInt, h("fail:runtime fileSystem is null", null));
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
      Log.w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
      i = 80;
    }
    Log.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", new Object[] { Integer.valueOf(i), str });
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139867);
        if ((!Util.isNullOrNil(str)) && (str.startsWith("wxfile://"))) {}
        com.tencent.mm.plugin.appbrand.jsapi.e locale;
        for (Object localObject = new h.b((byte)0);; localObject = new h.d((byte)0))
        {
          localObject = ((h.c)localObject).a(parame, str, i);
          if ((this.fjN.get() == null) || (!((com.tencent.mm.plugin.appbrand.jsapi.e)this.fjN.get()).isRunning())) {
            break label256;
          }
          locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.fjN.get();
          if ((((h.a)localObject).success) || (!Util.isNullOrNil(((h.a)localObject).result))) {
            break;
          }
          Log.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
          locale.j(paramInt, h.this.h("fail:compress image fail", null));
          AppMethodBeat.o(139867);
          return;
        }
        if (!((h.a)localObject).success)
        {
          Log.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", new Object[] { ((h.a)localObject).result });
          locale.j(paramInt, h.this.h(((h.a)localObject).result, null));
          AppMethodBeat.o(139867);
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((h.a)localObject).result);
        locale.j(paramInt, h.this.m("ok", localHashMap));
        AppMethodBeat.o(139867);
        return;
        label256:
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
        AppMethodBeat.o(139867);
      }
    }, String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", new Object[] { str, Integer.valueOf(i) }), 10);
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
    public final h.a a(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString, int paramInt)
    {
      AppMethodBeat.i(139868);
      r localr = parame.getFileSystem();
      if (localr == null)
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:fileSystem is null");
        parame = new h.a(false, "fail:runtime fileSystem is null");
        AppMethodBeat.o(139868);
        return parame;
      }
      q localq = parame.getFileSystem().adL(paramString);
      if (localq == null)
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
        parame = new h.a(false, "fail:file doesn't exist");
        AppMethodBeat.o(139868);
        return parame;
      }
      paramString = null;
      try
      {
        localOptions = new BitmapFactory.Options();
        localBitmap = e.a.a((e)parame.K(e.class)).decodeFile(localq.bOF(), localOptions);
        if (localBitmap == null)
        {
          Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          parame = new h.a(false, "fail:decode image fail");
          AppMethodBeat.o(139868);
          return parame;
        }
        if (!a.a(localOptions)) {
          break label304;
        }
        parame = "jpg";
      }
      catch (OutOfMemoryError parame)
      {
        try
        {
          BitmapFactory.Options localOptions;
          Bitmap localBitmap;
          if (a.a(localOptions)) {}
          for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
          {
            BitmapUtil.saveBitmapToImage(localBitmap, paramInt, paramString, str, true);
            if (a.a(localOptions)) {
              com.tencent.mm.plugin.appbrand.l.b.dt(localq.bOF(), str);
            }
            paramString = new i();
            if (localr.a(new q(str), parame, false, paramString) == m.nMR) {
              break label317;
            }
            Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
            parame = new h.a(false, "fail:create tmp file fail");
            AppMethodBeat.o(139868);
            return parame;
            parame = "png";
            break;
          }
          Log.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
          parame = new h.a(true, (String)paramString.value);
          AppMethodBeat.o(139868);
          return parame;
        }
        catch (Exception parame)
        {
          for (;;)
          {
            String str;
            paramString = str;
          }
        }
        parame = parame;
        Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { parame });
        parame = new h.a(false, "fail:compress image OOM");
        AppMethodBeat.o(139868);
        return parame;
      }
      catch (NullPointerException parame)
      {
        label304:
        label317:
        Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { parame });
        parame = new h.a(false, "fail:compress image NPE");
        AppMethodBeat.o(139868);
        return parame;
      }
      catch (Exception parame) {}
      str = com.tencent.mm.loader.j.b.aSX() + "microMsg.tmp." + System.currentTimeMillis() + "." + parame;
      Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { parame });
      u.deleteFile(paramString);
      parame = new h.a(false, "fail:compress image exception");
      AppMethodBeat.o(139868);
      return parame;
    }
  }
  
  static abstract interface c
  {
    public abstract h.a a(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString, int paramInt);
  }
  
  static final class d
    implements h.c
  {
    public final h.a a(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString, int paramInt)
    {
      AppMethodBeat.i(139869);
      if ((parame == null) || (!(parame instanceof v)))
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
        parame = new h.a(false, "fail:internal error invalid js component");
        AppMethodBeat.o(139869);
        return parame;
      }
      r localr = parame.getFileSystem();
      if (localr == null)
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
        parame = new h.a(false, "fail:runtime fileSystem is null");
        AppMethodBeat.o(139869);
        return parame;
      }
      InputStream localInputStream = bl.f(((v)parame).getRuntime(), paramString);
      if (localInputStream == null)
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
        parame = new h.a(false, "fail:file doesn't exist");
        AppMethodBeat.o(139869);
        return parame;
      }
      paramString = null;
      try
      {
        localOptions = new BitmapFactory.Options();
        localBitmap = e.a.a((e)parame.K(e.class)).b(localInputStream, localOptions);
        if (localBitmap == null)
        {
          Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          parame = new h.a(false, "fail:decode image fail");
          AppMethodBeat.o(139869);
          return parame;
        }
        if (!a.a(localOptions)) {
          break label333;
        }
        parame = "jpg";
      }
      catch (OutOfMemoryError parame)
      {
        try
        {
          BitmapFactory.Options localOptions;
          Bitmap localBitmap;
          if (a.a(localOptions)) {}
          for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
          {
            BitmapUtil.saveBitmapToImage(localBitmap, paramInt, paramString, str, true);
            if (a.a(localOptions)) {
              com.tencent.mm.plugin.appbrand.l.b.b(localInputStream, str);
            }
            paramString = new i();
            if (localr.a(new q(str), parame, false, paramString) == m.nMR) {
              break label346;
            }
            Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
            parame = new h.a(false, "fail:create tmp file fail");
            AppMethodBeat.o(139869);
            return parame;
            parame = "png";
            break;
          }
          Log.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
          parame = new h.a(true, (String)paramString.value);
          AppMethodBeat.o(139869);
          return parame;
        }
        catch (Exception parame)
        {
          for (;;)
          {
            String str;
            paramString = str;
          }
        }
        parame = parame;
        Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { parame });
        parame = new h.a(false, "fail:compress image OOM");
        AppMethodBeat.o(139869);
        return parame;
      }
      catch (NullPointerException parame)
      {
        Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { parame });
        parame = new h.a(false, "fail:compress image NPE");
        AppMethodBeat.o(139869);
        return parame;
      }
      catch (Exception parame) {}
      str = com.tencent.mm.loader.j.b.aSX() + "microMsg.tmp." + System.currentTimeMillis() + "." + parame;
      label333:
      label346:
      Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { parame });
      u.deleteFile(paramString);
      parame = new h.a(false, "fail:compress image exception");
      AppMethodBeat.o(139869);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h
 * JD-Core Version:    0.7.0.1
 */