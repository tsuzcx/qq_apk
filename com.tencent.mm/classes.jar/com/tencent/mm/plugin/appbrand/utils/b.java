package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b
{
  private static final String hsx;
  private static ConcurrentMap<String, Boolean> laM;
  private static Map<String, List<a>> laN;
  
  static
  {
    AppMethodBeat.i(135346);
    laM = new ConcurrentHashMap();
    laN = new HashMap();
    String str2 = com.tencent.mm.loader.j.b.aph();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    hsx = str1;
    l.aFC(str1);
    AppMethodBeat.o(135346);
  }
  
  private static String Rt(String paramString)
  {
    AppMethodBeat.i(135341);
    paramString = zw(paramString);
    paramString = String.format("%s%s", new Object[] { hsx, paramString });
    AppMethodBeat.o(135341);
    return paramString;
  }
  
  public static void a(final c paramc, String paramString1, final String paramString2, final a parama)
  {
    int i = 1;
    AppMethodBeat.i(135337);
    if (bs.isNullOrNil(paramString1))
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
      ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", new Object[] { paramString1 });
      if (paramc == null)
      {
        ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
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
        paramc = paramc.DH().IS(paramString1);
        if ((paramc == null) || (!paramc.exists())) {
          break;
        }
        paramc = q.B(paramc.fxV());
        ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", new Object[] { paramc });
        if ((!dD(paramString2, paramc)) || (parama == null)) {
          break;
        }
        parama.Jr(paramc);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      paramc = Rt(paramString1);
      ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", new Object[] { paramc });
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135334);
          if (!b.laN.containsKey(this.val$url)) {
            b.laN.put(this.val$url, new ArrayList());
          }
          ((List)b.laN.get(this.val$url)).add(parama);
          AppMethodBeat.o(135334);
        }
      });
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(135335);
          b.I(this.val$url, paramString2, paramc);
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
  
  private static void b(a parama)
  {
    AppMethodBeat.i(135338);
    if (parama != null) {
      parama.Jr(null);
    }
    AppMethodBeat.o(135338);
  }
  
  private static boolean b(c paramc, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(135339);
    ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
      AppMethodBeat.o(135339);
      return false;
    }
    if (!(paramc instanceof h))
    {
      ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(135339);
      return false;
    }
    AppBrandRuntime localAppBrandRuntime = ((h)paramc).getRuntime();
    if (localAppBrandRuntime == null)
    {
      ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
      AppMethodBeat.o(135339);
      return false;
    }
    paramc = Rt(paramString1);
    ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", new Object[] { paramc });
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
        f.a(paramString1, 100, Bitmap.CompressFormat.PNG, paramc, true);
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        if (!dD(paramString2, paramc)) {
          break label336;
        }
        if (parama == null) {
          break label359;
        }
        parama.Jr(paramc);
        AppMethodBeat.o(135339);
        return true;
      }
      catch (IOException paramc)
      {
        ac.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramc });
        return false;
      }
      finally
      {
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        AppMethodBeat.o(135339);
      }
    }
    ac.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
    AppMethodBeat.o(135339);
    return false;
    label336:
    ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(locale.delete()) });
    label359:
    AppMethodBeat.o(135339);
    return false;
  }
  
  private static void dC(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(135340);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135336);
        b.dE(this.val$url, paramString2);
        AppMethodBeat.o(135336);
      }
    });
    AppMethodBeat.o(135340);
  }
  
  private static boolean dD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(135343);
    if (bs.isNullOrNil(paramString1))
    {
      ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
      AppMethodBeat.o(135343);
      return true;
    }
    paramString2 = g.getMD5(paramString2);
    ac.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(135343);
    return bool;
  }
  
  private static String zw(String paramString)
  {
    AppMethodBeat.i(135342);
    String str = null;
    if (!bs.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(135342);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void Jr(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b
 * JD-Core Version:    0.7.0.1
 */