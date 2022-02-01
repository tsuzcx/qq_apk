package com.tencent.mm.plugin.appbrand.jsapi.aa.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final String gRX;
  private static ConcurrentMap<String, Boolean> kzv;
  private static Map<String, List<a>> kzw;
  
  static
  {
    AppMethodBeat.i(139476);
    kzv = new ConcurrentHashMap();
    kzw = new HashMap();
    String str2 = com.tencent.mm.loader.j.b.aih();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    gRX = str1;
    l.aAk(str1);
    AppMethodBeat.o(139476);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(139469);
    if (parama != null) {
      parama.Fn(null);
    }
    AppMethodBeat.o(139469);
  }
  
  public static void a(final c paramc, String paramString1, final String paramString2, final a parama)
  {
    int i = 1;
    AppMethodBeat.i(139468);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(139468);
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, url:%s", new Object[] { paramString1 });
      if (paramc == null)
      {
        ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, component is null");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label266;
        }
        a(parama);
        AppMethodBeat.o(139468);
        return;
        paramc = paramc.Ee().EP(paramString1);
        if ((paramc == null) || (!paramc.exists())) {
          break;
        }
        paramc = q.B(paramc.fhU());
        ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, localPath:%s", new Object[] { paramc });
        if (!dr(paramString2, paramc)) {
          break;
        }
        parama.Fn(paramc);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      paramc = vq(paramString1);
      paramc = String.format("%s%s", new Object[] { gRX, paramc });
      ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, localPath:%s", new Object[] { paramc });
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139465);
          if (!b.kzw.containsKey(this.val$url)) {
            b.kzw.put(this.val$url, new ArrayList());
          }
          ((List)b.kzw.get(this.val$url)).add(parama);
          AppMethodBeat.o(139465);
        }
      });
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139466);
          b.I(this.val$url, paramString2, paramc);
          AppMethodBeat.o(139466);
        }
      }, "AppBrandLiveFileLoadHelperThread");
      AppMethodBeat.o(139468);
      return;
    }
    if (!b(paramc, paramString1, paramString2, parama)) {
      a(parama);
    }
    label266:
    AppMethodBeat.o(139468);
  }
  
  private static boolean b(c paramc, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(139470);
    ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, component is null");
      AppMethodBeat.o(139470);
      return false;
    }
    if (!(paramc instanceof h))
    {
      ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(139470);
      return false;
    }
    paramc = ((h)paramc).getRuntime();
    if (paramc == null)
    {
      ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, runtime is null");
      AppMethodBeat.o(139470);
      return false;
    }
    String str = vq(paramString1);
    str = String.format("%s%s", new Object[] { gRX, str });
    ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, localPath:%s", new Object[] { str });
    e locale = new e(str);
    if (!locale.exists())
    {
      paramc = w.k(paramc, paramString1);
      if ((paramc == null) || (paramc.isRecycled())) {}
    }
    else
    {
      try
      {
        f.a(paramc, 100, Bitmap.CompressFormat.PNG, str, true);
        if ((paramc != null) && (!paramc.isRecycled()))
        {
          ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
        }
        if (!dr(paramString2, str)) {
          break label362;
        }
        if (parama == null) {
          break label385;
        }
        parama.Fn(str);
        AppMethodBeat.o(139470);
        return true;
      }
      catch (IOException paramString1)
      {
        ad.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramString1 });
        return false;
      }
      finally
      {
        if ((paramc != null) && (!paramc.isRecycled()))
        {
          ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
        }
        AppMethodBeat.o(139470);
      }
    }
    ad.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, no bitmap in the given url");
    AppMethodBeat.o(139470);
    return false;
    label362:
    ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(locale.delete()) });
    label385:
    AppMethodBeat.o(139470);
    return false;
  }
  
  private static void dq(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(139471);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139467);
        b.ds(this.val$url, paramString2);
        AppMethodBeat.o(139467);
      }
    });
    AppMethodBeat.o(139471);
  }
  
  private static boolean dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(139473);
    if (bt.isNullOrNil(paramString1))
    {
      ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
      AppMethodBeat.o(139473);
      return true;
    }
    paramString2 = g.getMD5(paramString2);
    ad.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(139473);
    return bool;
  }
  
  private static String vq(String paramString)
  {
    AppMethodBeat.i(139472);
    String str = null;
    if (!bt.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(139472);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void Fn(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c.b
 * JD-Core Version:    0.7.0.1
 */