package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vfs.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class c
{
  private static final String hNI;
  private static ConcurrentMap<String, Boolean> lCk;
  private static Map<String, List<c.a>> lCl;
  
  static
  {
    AppMethodBeat.i(135346);
    lCk = new ConcurrentHashMap();
    lCl = new HashMap();
    String str2 = com.tencent.mm.loader.j.b.asj();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    hNI = str1;
    n.aMy(str1);
    AppMethodBeat.o(135346);
  }
  
  private static String CX(String paramString)
  {
    AppMethodBeat.i(135342);
    String str = null;
    if (!bu.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(135342);
    return str;
  }
  
  private static String VK(String paramString)
  {
    AppMethodBeat.i(135341);
    paramString = CX(paramString);
    paramString = String.format("%s%s", new Object[] { hNI, paramString });
    AppMethodBeat.o(135341);
    return paramString;
  }
  
  public static void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, final String paramString2, final c.a parama)
  {
    int i = 1;
    AppMethodBeat.i(135337);
    if (bu.isNullOrNil(paramString1))
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
      ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", new Object[] { paramString1 });
      if (paramc == null)
      {
        ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
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
        paramc = paramc.Fl().MP(paramString1);
        if ((paramc == null) || (!paramc.exists())) {
          break;
        }
        paramc = com.tencent.mm.vfs.w.B(paramc.fTh());
        ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", new Object[] { paramc });
        if ((!dH(paramString2, paramc)) || (parama == null)) {
          break;
        }
        parama.Nr(paramc);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      paramc = VK(paramString1);
      ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", new Object[] { paramc });
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135334);
          if (!c.lCl.containsKey(this.val$url)) {
            c.lCl.put(this.val$url, new ArrayList());
          }
          ((List)c.lCl.get(this.val$url)).add(parama);
          AppMethodBeat.o(135334);
        }
      });
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135335);
          c.H(this.val$url, paramString2, paramc);
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
  
  private static void b(c.a parama)
  {
    AppMethodBeat.i(135338);
    if (parama != null) {
      parama.Nr(null);
    }
    AppMethodBeat.o(135338);
  }
  
  private static boolean b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2, c.a parama)
  {
    AppMethodBeat.i(135339);
    ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
      AppMethodBeat.o(135339);
      return false;
    }
    if (!(paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.h))
    {
      ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(135339);
      return false;
    }
    AppBrandRuntime localAppBrandRuntime = ((com.tencent.mm.plugin.appbrand.jsapi.h)paramc).getRuntime();
    if (localAppBrandRuntime == null)
    {
      ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
      AppMethodBeat.o(135339);
      return false;
    }
    paramc = VK(paramString1);
    ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", new Object[] { paramc });
    k localk = new k(paramc);
    if (!localk.exists())
    {
      paramString1 = com.tencent.mm.plugin.appbrand.page.w.k(localAppBrandRuntime, paramString1);
      if ((paramString1 == null) || (paramString1.isRecycled())) {}
    }
    else
    {
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(paramString1, 100, Bitmap.CompressFormat.PNG, paramc, true);
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        if (!dH(paramString2, paramc)) {
          break label336;
        }
        if (parama == null) {
          break label359;
        }
        parama.Nr(paramc);
        AppMethodBeat.o(135339);
        return true;
      }
      catch (IOException paramc)
      {
        ae.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramc });
        return false;
      }
      finally
      {
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        AppMethodBeat.o(135339);
      }
    }
    ae.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
    AppMethodBeat.o(135339);
    return false;
    label336:
    ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(localk.delete()) });
    label359:
    AppMethodBeat.o(135339);
    return false;
  }
  
  private static void dG(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(135340);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135336);
        c.dI(this.val$url, paramString2);
        AppMethodBeat.o(135336);
      }
    });
    AppMethodBeat.o(135340);
  }
  
  private static boolean dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(135343);
    if (bu.isNullOrNil(paramString1))
    {
      ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
      AppMethodBeat.o(135343);
      return true;
    }
    paramString2 = g.getMD5(paramString2);
    ae.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(135343);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c
 * JD-Core Version:    0.7.0.1
 */