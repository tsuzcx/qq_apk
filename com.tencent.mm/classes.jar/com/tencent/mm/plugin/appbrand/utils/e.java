package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class e
{
  private static final String lyR;
  private static ConcurrentMap<String, Boolean> pKA;
  private static Map<String, List<a>> pKB;
  
  static
  {
    AppMethodBeat.i(135346);
    pKA = new ConcurrentHashMap();
    pKB = new HashMap();
    String str2 = b.aSL();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    lyR = str1;
    FilePathGenerator.checkMkdir(str1);
    AppMethodBeat.o(135346);
  }
  
  private static String Ta(String paramString)
  {
    AppMethodBeat.i(135342);
    String str = null;
    if (!Util.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(135342);
    return str;
  }
  
  public static void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString1, final String paramString2, final a parama)
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
      if (parame == null)
      {
        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label256;
        }
        b(parama);
        AppMethodBeat.o(135337);
        return;
        parame = parame.getFileSystem().adL(paramString1);
        if ((parame == null) || (!parame.ifE())) {
          break;
        }
        parame = parame.bOF();
        Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", new Object[] { parame });
        if ((!ei(paramString2, parame)) || (parama == null)) {
          break;
        }
        parama.dR(parame);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      parame = ani(paramString1);
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", new Object[] { parame });
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135334);
          if (!e.pKB.containsKey(this.val$url)) {
            e.pKB.put(this.val$url, new ArrayList());
          }
          ((List)e.pKB.get(this.val$url)).add(parama);
          AppMethodBeat.o(135334);
        }
      });
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135335);
          e.N(this.val$url, paramString2, parame);
          AppMethodBeat.o(135335);
        }
      }, "AppBrandLiveFileLoadHelperThread");
      AppMethodBeat.o(135337);
      return;
    }
    if (!b(parame, paramString1, paramString2, parama)) {
      b(parama);
    }
    label256:
    AppMethodBeat.o(135337);
  }
  
  private static String ani(String paramString)
  {
    AppMethodBeat.i(135341);
    paramString = Ta(paramString);
    paramString = String.format("%s%s", new Object[] { lyR, paramString });
    AppMethodBeat.o(135341);
    return paramString;
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(135338);
    if (parama != null) {
      parama.dR(null);
    }
    AppMethodBeat.o(135338);
  }
  
  private static boolean b(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(135339);
    Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (parame == null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
      AppMethodBeat.o(135339);
      return false;
    }
    if (!(parame instanceof j))
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(135339);
      return false;
    }
    AppBrandRuntime localAppBrandRuntime = ((j)parame).getRuntime();
    if (localAppBrandRuntime == null)
    {
      Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
      AppMethodBeat.o(135339);
      return false;
    }
    parame = ani(paramString1);
    Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", new Object[] { parame });
    q localq = new q(parame);
    if (!localq.ifE())
    {
      paramString1 = aa.l(localAppBrandRuntime, paramString1);
      if ((paramString1 == null) || (paramString1.isRecycled())) {}
    }
    else
    {
      try
      {
        BitmapUtil.saveBitmapToImage(paramString1, 100, Bitmap.CompressFormat.PNG, parame, true);
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        if (!ei(paramString2, parame)) {
          break label336;
        }
        if (parama == null) {
          break label359;
        }
        parama.dR(parame);
        AppMethodBeat.o(135339);
        return true;
      }
      catch (IOException parame)
      {
        Log.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", new Object[] { parame });
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
    Log.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(localq.cFq()) });
    label359:
    AppMethodBeat.o(135339);
    return false;
  }
  
  private static void eh(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(135340);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135336);
        e.ej(this.val$url, paramString2);
        AppMethodBeat.o(135336);
      }
    });
    AppMethodBeat.o(135340);
  }
  
  private static boolean ei(String paramString1, String paramString2)
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
  
  public static abstract interface a
  {
    public abstract void dR(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.e
 * JD-Core Version:    0.7.0.1
 */