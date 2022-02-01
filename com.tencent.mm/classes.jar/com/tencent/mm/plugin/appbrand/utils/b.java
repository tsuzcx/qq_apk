package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b
{
  private static final String hKP;
  private static ConcurrentMap<String, Boolean> lxM;
  private static Map<String, List<b.a>> lxN;
  
  static
  {
    AppMethodBeat.i(135346);
    lxM = new ConcurrentHashMap();
    lxN = new HashMap();
    String str2 = com.tencent.mm.loader.j.b.arU();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    hKP = str1;
    m.aLc(str1);
    AppMethodBeat.o(135346);
  }
  
  private static String Cv(String paramString)
  {
    AppMethodBeat.i(135342);
    String str = null;
    if (!bt.isNullOrNil(paramString)) {
      str = com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(135342);
    return str;
  }
  
  private static String UZ(String paramString)
  {
    AppMethodBeat.i(135341);
    paramString = Cv(paramString);
    paramString = String.format("%s%s", new Object[] { hKP, paramString });
    AppMethodBeat.o(135341);
    return paramString;
  }
  
  public static void a(final c paramc, String paramString1, final String paramString2, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(135337);
    if (bt.isNullOrNil(paramString1))
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
      ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", new Object[] { paramString1 });
      if (paramc == null)
      {
        ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
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
        paramc = paramc.Fg().Mj(paramString1);
        if ((paramc == null) || (!paramc.exists())) {
          break;
        }
        paramc = q.B(paramc.fOK());
        ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", new Object[] { paramc });
        if ((!dF(paramString2, paramc)) || (parama == null)) {
          break;
        }
        parama.MK(paramc);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      paramc = UZ(paramString1);
      ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", new Object[] { paramc });
      aq.f(new b.1(paramString1, parama));
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135335);
          b.H(this.val$url, paramString2, paramc);
          AppMethodBeat.o(135335);
        }
      }, "AppBrandLiveFileLoadHelperThread");
      AppMethodBeat.o(135337);
      return;
    }
    if (!b(paramc, paramString1, paramString2, parama)) {
      b(parama);
    }
    label259:
    AppMethodBeat.o(135337);
  }
  
  private static void b(b.a parama)
  {
    AppMethodBeat.i(135338);
    if (parama != null) {
      parama.MK(null);
    }
    AppMethodBeat.o(135338);
  }
  
  private static boolean b(c paramc, String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(135339);
    ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
      AppMethodBeat.o(135339);
      return false;
    }
    if (!(paramc instanceof h))
    {
      ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(135339);
      return false;
    }
    AppBrandRuntime localAppBrandRuntime = ((h)paramc).getRuntime();
    if (localAppBrandRuntime == null)
    {
      ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
      AppMethodBeat.o(135339);
      return false;
    }
    paramc = UZ(paramString1);
    ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", new Object[] { paramc });
    e locale = new e(paramc);
    if (!locale.exists())
    {
      paramString1 = x.k(localAppBrandRuntime, paramString1);
      if ((paramString1 == null) || (paramString1.isRecycled())) {}
    }
    else
    {
      try
      {
        com.tencent.mm.sdk.platformtools.g.a(paramString1, 100, Bitmap.CompressFormat.PNG, paramc, true);
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        if (!dF(paramString2, paramc)) {
          break label336;
        }
        if (parama == null) {
          break label359;
        }
        parama.MK(paramc);
        AppMethodBeat.o(135339);
        return true;
      }
      catch (IOException paramc)
      {
        ad.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramc });
        return false;
      }
      finally
      {
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        AppMethodBeat.o(135339);
      }
    }
    ad.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
    AppMethodBeat.o(135339);
    return false;
    label336:
    ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(locale.delete()) });
    label359:
    AppMethodBeat.o(135339);
    return false;
  }
  
  private static void dE(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(135340);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135336);
        b.dG(this.val$url, paramString2);
        AppMethodBeat.o(135336);
      }
    });
    AppMethodBeat.o(135340);
  }
  
  private static boolean dF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(135343);
    if (bt.isNullOrNil(paramString1))
    {
      ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
      AppMethodBeat.o(135343);
      return true;
    }
    paramString2 = com.tencent.mm.b.g.getMD5(paramString2);
    ad.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(135343);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b
 * JD-Core Version:    0.7.0.1
 */