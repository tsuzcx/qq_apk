package com.tencent.mm.plugin.appbrand.t;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b
{
  private static final String fqs;
  private static ConcurrentMap<String, Boolean> iiv;
  private static Map<String, List<b.a>> iiw;
  
  static
  {
    AppMethodBeat.i(87406);
    iiv = new ConcurrentHashMap();
    iiw = new HashMap();
    String str2 = e.eQz;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    fqs = str1;
    j.akQ(str1);
    AppMethodBeat.o(87406);
  }
  
  private static String Fo(String paramString)
  {
    AppMethodBeat.i(87401);
    paramString = qz(paramString);
    paramString = String.format("%s%s", new Object[] { fqs, paramString });
    AppMethodBeat.o(87401);
    return paramString;
  }
  
  public static void a(c paramc, String paramString1, String paramString2, b.a parama)
  {
    int i = 1;
    AppMethodBeat.i(87397);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(87397);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(87397);
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", new Object[] { paramString1 });
      if (paramc == null)
      {
        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label255;
        }
        b(parama);
        AppMethodBeat.o(87397);
        return;
        paramc = paramc.wX().zg(paramString1);
        if ((paramc == null) || (!paramc.exists())) {
          break;
        }
        paramc = paramc.getAbsolutePath();
        ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", new Object[] { paramc });
        if ((!cy(paramString2, paramc)) || (parama == null)) {
          break;
        }
        parama.BO(paramc);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      paramc = Fo(paramString1);
      ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", new Object[] { paramc });
      al.d(new b.1(paramString1, parama));
      com.tencent.mm.sdk.g.d.post(new b.2(paramString1, paramString2, paramc), "AppBrandLiveFileLoadHelperThread");
      AppMethodBeat.o(87397);
      return;
    }
    if (!b(paramc, paramString1, paramString2, parama)) {
      b(parama);
    }
    label255:
    AppMethodBeat.o(87397);
  }
  
  private static void b(b.a parama)
  {
    AppMethodBeat.i(87398);
    if (parama != null) {
      parama.BO(null);
    }
    AppMethodBeat.o(87398);
  }
  
  private static boolean b(c paramc, String paramString1, String paramString2, b.a parama)
  {
    AppMethodBeat.i(87399);
    ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
      AppMethodBeat.o(87399);
      return false;
    }
    if (!(paramc instanceof h))
    {
      ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(87399);
      return false;
    }
    i locali = ((h)paramc).getRuntime();
    if (locali == null)
    {
      ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
      AppMethodBeat.o(87399);
      return false;
    }
    paramc = Fo(paramString1);
    ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", new Object[] { paramc });
    File localFile = new File(paramc);
    if (!localFile.exists())
    {
      paramString1 = t.j(locali, paramString1);
      if ((paramString1 == null) || (paramString1.isRecycled())) {}
    }
    else
    {
      try
      {
        com.tencent.mm.sdk.platformtools.d.a(paramString1, 100, Bitmap.CompressFormat.PNG, paramc, true);
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        if (!cy(paramString2, paramc)) {
          break label335;
        }
        if (parama == null) {
          break label358;
        }
        parama.BO(paramc);
        AppMethodBeat.o(87399);
        return true;
      }
      catch (IOException paramc)
      {
        ab.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramc });
        return false;
      }
      finally
      {
        if ((paramString1 != null) && (!paramString1.isRecycled()))
        {
          ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "bitmap recycle %s", new Object[] { paramString1 });
          paramString1.recycle();
        }
        AppMethodBeat.o(87399);
      }
    }
    ab.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
    AppMethodBeat.o(87399);
    return false;
    label335:
    ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(localFile.delete()) });
    label358:
    AppMethodBeat.o(87399);
    return false;
  }
  
  private static void cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87400);
    al.d(new b.3(paramString1, paramString2));
    AppMethodBeat.o(87400);
  }
  
  private static boolean cy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(87403);
    if (bo.isNullOrNil(paramString1))
    {
      ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
      AppMethodBeat.o(87403);
      return true;
    }
    paramString2 = g.getMD5(paramString2);
    ab.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(87403);
    return bool;
  }
  
  private static String qz(String paramString)
  {
    AppMethodBeat.i(87402);
    String str = null;
    if (!bo.isNullOrNil(paramString)) {
      str = g.w(paramString.getBytes());
    }
    AppMethodBeat.o(87402);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.b
 * JD-Core Version:    0.7.0.1
 */