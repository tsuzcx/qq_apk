package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends d
{
  private static final int CTRL_INDEX = 528;
  private static final String NAME = "compressImage";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(139870);
    if (paramf == null)
    {
      Log.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
      AppMethodBeat.o(139870);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
      paramf.i(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(139870);
      return;
    }
    final String str = paramJSONObject.optString("src");
    if (Util.isNullOrNil(str))
    {
      Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
      paramf.i(paramInt, h("fail:data src is null", null));
      AppMethodBeat.o(139870);
      return;
    }
    if (paramf.getFileSystem() == null)
    {
      Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
      paramf.i(paramInt, h("fail:runtime fileSystem is null", null));
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
        f localf;
        for (Object localObject = new h.b((byte)0);; localObject = new h.d((byte)0))
        {
          localObject = ((h.c)localObject).a(paramf, str, i);
          if ((this.dre.get() == null) || (!((f)this.dre.get()).isRunning())) {
            break label256;
          }
          localf = (f)this.dre.get();
          if ((((h.a)localObject).success) || (!Util.isNullOrNil(((h.a)localObject).result))) {
            break;
          }
          Log.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
          localf.i(paramInt, h.this.h("fail:compress image fail", null));
          AppMethodBeat.o(139867);
          return;
        }
        if (!((h.a)localObject).success)
        {
          Log.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", new Object[] { ((h.a)localObject).result });
          localf.i(paramInt, h.this.h(((h.a)localObject).result, null));
          AppMethodBeat.o(139867);
          return;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("tempFilePath", ((h.a)localObject).result);
        localf.i(paramInt, h.this.n("ok", localHashMap));
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
    public final h.a a(f paramf, String paramString, int paramInt)
    {
      AppMethodBeat.i(139868);
      q localq = paramf.getFileSystem();
      if (localq == null)
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:fileSystem is null");
        paramf = new h.a(false, "fail:runtime fileSystem is null");
        AppMethodBeat.o(139868);
        return paramf;
      }
      o localo = paramf.getFileSystem().VY(paramString);
      if (localo == null)
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
        paramf = new h.a(false, "fail:file doesn't exist");
        AppMethodBeat.o(139868);
        return paramf;
      }
      paramString = null;
      try
      {
        localOptions = new BitmapFactory.Options();
        localBitmap = e.a.a((e)paramf.M(e.class)).decodeFile(aa.z(localo.her()), localOptions);
        if (localBitmap == null)
        {
          Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          paramf = new h.a(false, "fail:decode image fail");
          AppMethodBeat.o(139868);
          return paramf;
        }
        if (!a.d(localOptions)) {
          break label310;
        }
        paramf = "jpg";
      }
      catch (OutOfMemoryError paramf)
      {
        try
        {
          BitmapFactory.Options localOptions;
          Bitmap localBitmap;
          if (a.d(localOptions)) {}
          for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
          {
            BitmapUtil.saveBitmapToImage(localBitmap, paramInt, paramString, str, true);
            if (a.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.l.b.dk(aa.z(localo.her()), str);
            }
            paramString = new i();
            if (localq.a(new o(str), paramf, false, paramString) == m.kSu) {
              break label323;
            }
            Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
            paramf = new h.a(false, "fail:create tmp file fail");
            AppMethodBeat.o(139868);
            return paramf;
            paramf = "png";
            break;
          }
          Log.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
          paramf = new h.a(true, (String)paramString.value);
          AppMethodBeat.o(139868);
          return paramf;
        }
        catch (Exception paramf)
        {
          for (;;)
          {
            String str;
            paramString = str;
          }
        }
        paramf = paramf;
        Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramf });
        paramf = new h.a(false, "fail:compress image OOM");
        AppMethodBeat.o(139868);
        return paramf;
      }
      catch (NullPointerException paramf)
      {
        label310:
        label323:
        Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramf });
        paramf = new h.a(false, "fail:compress image NPE");
        AppMethodBeat.o(139868);
        return paramf;
      }
      catch (Exception paramf) {}
      str = com.tencent.mm.loader.j.b.aKV() + "microMsg.tmp." + System.currentTimeMillis() + "." + paramf;
      Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramf });
      com.tencent.mm.vfs.s.deleteFile(paramString);
      paramf = new h.a(false, "fail:compress image exception");
      AppMethodBeat.o(139868);
      return paramf;
    }
  }
  
  static abstract interface c
  {
    public abstract h.a a(f paramf, String paramString, int paramInt);
  }
  
  static final class d
    implements h.c
  {
    public final h.a a(f paramf, String paramString, int paramInt)
    {
      AppMethodBeat.i(139869);
      if ((paramf == null) || (!(paramf instanceof com.tencent.mm.plugin.appbrand.s)))
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
        paramf = new h.a(false, "fail:internal error invalid js component");
        AppMethodBeat.o(139869);
        return paramf;
      }
      q localq = paramf.getFileSystem();
      if (localq == null)
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
        paramf = new h.a(false, "fail:runtime fileSystem is null");
        AppMethodBeat.o(139869);
        return paramf;
      }
      InputStream localInputStream = bg.f(((com.tencent.mm.plugin.appbrand.s)paramf).getRuntime(), paramString);
      if (localInputStream == null)
      {
        Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
        paramf = new h.a(false, "fail:file doesn't exist");
        AppMethodBeat.o(139869);
        return paramf;
      }
      paramString = null;
      try
      {
        localOptions = new BitmapFactory.Options();
        localBitmap = e.a.a((e)paramf.M(e.class)).b(localInputStream, localOptions);
        if (localBitmap == null)
        {
          Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
          paramf = new h.a(false, "fail:decode image fail");
          AppMethodBeat.o(139869);
          return paramf;
        }
        if (!a.d(localOptions)) {
          break label333;
        }
        paramf = "jpg";
      }
      catch (OutOfMemoryError paramf)
      {
        try
        {
          BitmapFactory.Options localOptions;
          Bitmap localBitmap;
          if (a.d(localOptions)) {}
          for (paramString = Bitmap.CompressFormat.JPEG;; paramString = Bitmap.CompressFormat.PNG)
          {
            BitmapUtil.saveBitmapToImage(localBitmap, paramInt, paramString, str, true);
            if (a.d(localOptions)) {
              com.tencent.mm.plugin.appbrand.l.b.b(localInputStream, str);
            }
            paramString = new i();
            if (localq.a(new o(str), paramf, false, paramString) == m.kSu) {
              break label346;
            }
            Log.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
            paramf = new h.a(false, "fail:create tmp file fail");
            AppMethodBeat.o(139869);
            return paramf;
            paramf = "png";
            break;
          }
          Log.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", new Object[] { str, paramString.value });
          paramf = new h.a(true, (String)paramString.value);
          AppMethodBeat.o(139869);
          return paramf;
        }
        catch (Exception paramf)
        {
          for (;;)
          {
            String str;
            paramString = str;
          }
        }
        paramf = paramf;
        Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", new Object[] { paramf });
        paramf = new h.a(false, "fail:compress image OOM");
        AppMethodBeat.o(139869);
        return paramf;
      }
      catch (NullPointerException paramf)
      {
        Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", new Object[] { paramf });
        paramf = new h.a(false, "fail:compress image NPE");
        AppMethodBeat.o(139869);
        return paramf;
      }
      catch (Exception paramf) {}
      str = com.tencent.mm.loader.j.b.aKV() + "microMsg.tmp." + System.currentTimeMillis() + "." + paramf;
      label333:
      label346:
      Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", new Object[] { paramf });
      com.tencent.mm.vfs.s.deleteFile(paramString);
      paramf = new h.a(false, "fail:compress image exception");
      AppMethodBeat.o(139869);
      return paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h
 * JD-Core Version:    0.7.0.1
 */