package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class c
{
  private static final String iIN;
  private static ConcurrentMap<String, Boolean> mJI;
  private static Map<String, List<c.a>> mJJ;
  
  static
  {
    AppMethodBeat.i(135346);
    mJI = new ConcurrentHashMap();
    mJJ = new HashMap();
    String str2 = b.aKJ();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    iIN = str1;
    FilePathGenerator.checkMkdir(str1);
    AppMethodBeat.o(135346);
  }
  
  private static String LI(String paramString)
  {
    AppMethodBeat.i(135342);
    String str = null;
    if (!Util.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(135342);
    return str;
  }
  
  public static void a(f paramf, String paramString1, String paramString2, c.a parama)
  {
    int i = 1;
    AppMethodBeat.i(135337);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(135337);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(135337);
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", new Object[] { paramString1 });
      if (paramf == null)
      {
        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label259;
        }
        b(parama);
        AppMethodBeat.o(135337);
        return;
        paramf = paramf.getFileSystem().VY(paramString1);
        if ((paramf == null) || (!paramf.exists())) {
          break;
        }
        paramf = aa.z(paramf.her());
        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", new Object[] { paramf });
        if ((!dX(paramString2, paramf)) || (parama == null)) {
          break;
        }
        parama.Wz(paramf);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      paramf = afG(paramString1);
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", new Object[] { paramf });
      MMHandlerThread.postToMainThread(new c.1(paramString1, parama));
      ThreadPool.post(new c.2(paramString1, paramString2, paramf), "AppBrandLiveFileLoadHelperThread");
      AppMethodBeat.o(135337);
      return;
    }
    if (!b(paramf, paramString1, paramString2, parama)) {
      b(parama);
    }
    label259:
    AppMethodBeat.o(135337);
  }
  
  private static String afG(String paramString)
  {
    AppMethodBeat.i(135341);
    paramString = LI(paramString);
    paramString = String.format("%s%s", new Object[] { iIN, paramString });
    AppMethodBeat.o(135341);
    return paramString;
  }
  
  private static void b(c.a parama)
  {
    AppMethodBeat.i(135338);
    if (parama != null) {
      parama.Wz(null);
    }
    AppMethodBeat.o(135338);
  }
  
  private static boolean b(f paramf, String paramString1, String paramString2, c.a parama)
  {
    AppMethodBeat.i(135339);
    Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramf == null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
      AppMethodBeat.o(135339);
      return false;
    }
    if (!(paramf instanceof k))
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(135339);
      return false;
    }
    AppBrandRuntime localAppBrandRuntime = ((k)paramf).getRuntime();
    if (localAppBrandRuntime == null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
      AppMethodBeat.o(135339);
      return false;
    }
    paramf = afG(paramString1);
    Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", new Object[] { paramf });
    o localo = new o(paramf);
    if (!localo.exists())
    {
      paramString1 = z.k(localAppBrandRuntime, paramString1);
      if ((paramString1 == null) || (paramString1.isRecycled())) {}
    }
    else
    {
      try
      {
        BitmapUtil.saveBitmapToImage(paramString1, 100, Bitmap.CompressFormat.PNG, paramf, true);
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        if (!dX(paramString2, paramf)) {
          break label336;
        }
        if (parama == null) {
          break label359;
        }
        parama.Wz(paramf);
        AppMethodBeat.o(135339);
        return true;
      }
      catch (IOException paramf)
      {
        Log.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramf });
        return false;
      }
      finally
      {
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        AppMethodBeat.o(135339);
      }
    }
    Log.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
    AppMethodBeat.o(135339);
    return false;
    label336:
    Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(localo.delete()) });
    label359:
    AppMethodBeat.o(135339);
    return false;
  }
  
  private static void dW(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(135340);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135336);
        c.dY(this.val$url, paramString2);
        AppMethodBeat.o(135336);
      }
    });
    AppMethodBeat.o(135340);
  }
  
  private static boolean dX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(135343);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
      AppMethodBeat.o(135343);
      return true;
    }
    paramString2 = g.getMD5(paramString2);
    Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(135343);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c
 * JD-Core Version:    0.7.0.1
 */