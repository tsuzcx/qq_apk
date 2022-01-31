package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class a
{
  private static final String eak;
  private static ConcurrentMap<String, Boolean> grR = new ConcurrentHashMap();
  private static Map<String, List<a>> grS = new HashMap();
  
  static
  {
    String str2 = com.tencent.mm.compatible.util.e.bkH;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    eak = str1;
    h.Vu(str1);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2, a parama)
  {
    int i = 1;
    if (bk.bl(paramString1)) {}
    label119:
    do
    {
      for (;;)
      {
        return;
        if (!paramString1.startsWith("wxfile://")) {
          break;
        }
        y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, url:%s", new Object[] { paramString1 });
        if (paramc == null)
        {
          y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, component is null");
          i = 0;
        }
        for (;;)
        {
          if (i != 0) {
            break label119;
          }
          a(parama);
          return;
          paramc = paramc.Zl().rx(paramString1);
          if ((paramc == null) || (!paramc.exists())) {
            break;
          }
          paramc = paramc.getAbsolutePath();
          y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleWxfile, localPath:%s", new Object[] { paramc });
          if (!bC(paramString2, paramc)) {
            break;
          }
          parama.ud(paramc);
        }
      }
      if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
      {
        y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, url:%s", new Object[] { paramString1 });
        paramc = jH(paramString1);
        paramc = String.format("%s%s", new Object[] { eak, paramc });
        y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handleNetworkFile, localPath:%s", new Object[] { paramc });
        ai.d(new a.1(paramString1, parama));
        com.tencent.mm.sdk.f.e.post(new a.2(paramString1, paramString2, paramc), "AppBrandLiveFileLoadHelperThread");
        return;
      }
    } while (b(paramc, paramString1, paramString2, parama));
    a(parama);
  }
  
  private static void a(a parama)
  {
    if (parama != null) {
      parama.ud(null);
    }
  }
  
  private static boolean b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2, a parama)
  {
    y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramc == null) {
      y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, component is null");
    }
    File localFile;
    for (;;)
    {
      return false;
      if (!(paramc instanceof f))
      {
        y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, can not get runtime from component");
        return false;
      }
      paramc = ((f)paramc).getRuntime();
      if (paramc == null)
      {
        y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, runtime is null");
        return false;
      }
      String str = jH(paramString1);
      str = String.format("%s%s", new Object[] { eak, str });
      y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, localPath:%s", new Object[] { str });
      localFile = new File(str);
      if (!localFile.exists())
      {
        paramc = p.i(paramc, paramString1);
        if ((paramc == null) || (paramc.isRecycled())) {
          break;
        }
      }
      else
      {
        try
        {
          com.tencent.mm.sdk.platformtools.c.a(paramc, 100, Bitmap.CompressFormat.PNG, str, true);
          if ((paramc != null) && (!paramc.isRecycled())) {
            paramc.recycle();
          }
          if (!bC(paramString2, str)) {
            break label264;
          }
          if (parama != null)
          {
            parama.ud(str);
            return true;
          }
        }
        catch (IOException paramString1)
        {
          y.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramString1 });
          return false;
        }
        finally
        {
          if ((paramc != null) && (!paramc.isRecycled())) {
            paramc.recycle();
          }
        }
      }
    }
    y.e("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, no bitmap in the given url");
    return false;
    label264:
    y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(localFile.delete()) });
    return false;
  }
  
  private static void bB(String paramString1, String paramString2)
  {
    ai.d(new a.3(paramString1, paramString2));
  }
  
  private static boolean bC(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1))
    {
      y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid target nil, no check");
      return true;
    }
    paramString2 = g.bQ(paramString2);
    y.i("MicroMsg.AppBrand.AppBrandLiveFileLoadHelper.javayhu", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    return paramString1.equals(paramString2);
  }
  
  private static String jH(String paramString)
  {
    String str = null;
    if (!bk.bl(paramString)) {
      str = g.o(paramString.getBytes());
    }
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void ud(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a
 * JD-Core Version:    0.7.0.1
 */