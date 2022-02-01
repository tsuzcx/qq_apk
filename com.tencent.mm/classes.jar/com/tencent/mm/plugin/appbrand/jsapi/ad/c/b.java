package com.tencent.mm.plugin.appbrand.jsapi.ad.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
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

public final class b
{
  private static final String hNI;
  private static ConcurrentMap<String, Boolean> lCk;
  private static Map<String, List<a>> lCl;
  
  static
  {
    AppMethodBeat.i(139476);
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
    AppMethodBeat.o(139476);
  }
  
  private static String CX(String paramString)
  {
    AppMethodBeat.i(139472);
    String str = null;
    if (!bu.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(139472);
    return str;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(139469);
    if (parama != null) {
      parama.Nr(null);
    }
    AppMethodBeat.o(139469);
  }
  
  public static void a(final c paramc, String paramString1, final String paramString2, final a parama)
  {
    int i = 1;
    AppMethodBeat.i(139468);
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(139468);
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, url:%s", new Object[] { paramString1 });
      if (paramc == null)
      {
        ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, component is null");
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
        paramc = paramc.Fl().MP(paramString1);
        if ((paramc == null) || (!paramc.exists())) {
          break;
        }
        paramc = com.tencent.mm.vfs.w.B(paramc.fTh());
        ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, localPath:%s", new Object[] { paramc });
        if (!dH(paramString2, paramc)) {
          break;
        }
        parama.Nr(paramc);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      paramc = CX(paramString1);
      paramc = String.format("%s%s", new Object[] { hNI, paramc });
      ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, localPath:%s", new Object[] { paramc });
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139465);
          if (!b.lCl.containsKey(this.val$url)) {
            b.lCl.put(this.val$url, new ArrayList());
          }
          ((List)b.lCl.get(this.val$url)).add(parama);
          AppMethodBeat.o(139465);
        }
      });
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(139466);
          b.H(this.val$url, paramString2, paramc);
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
    ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, component is null");
      AppMethodBeat.o(139470);
      return false;
    }
    if (!(paramc instanceof com.tencent.mm.plugin.appbrand.jsapi.h))
    {
      ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(139470);
      return false;
    }
    paramc = ((com.tencent.mm.plugin.appbrand.jsapi.h)paramc).getRuntime();
    if (paramc == null)
    {
      ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, runtime is null");
      AppMethodBeat.o(139470);
      return false;
    }
    String str = CX(paramString1);
    str = String.format("%s%s", new Object[] { hNI, str });
    ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, localPath:%s", new Object[] { str });
    k localk = new k(str);
    if (!localk.exists())
    {
      paramc = com.tencent.mm.plugin.appbrand.page.w.k(paramc, paramString1);
      if ((paramc == null) || (paramc.isRecycled())) {}
    }
    else
    {
      try
      {
        com.tencent.mm.sdk.platformtools.h.a(paramc, 100, Bitmap.CompressFormat.PNG, str, true);
        if ((paramc != null) && (!paramc.isRecycled()))
        {
          ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
        }
        if (!dH(paramString2, str)) {
          break label362;
        }
        if (parama == null) {
          break label385;
        }
        parama.Nr(str);
        AppMethodBeat.o(139470);
        return true;
      }
      catch (IOException paramString1)
      {
        ae.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramString1 });
        return false;
      }
      finally
      {
        if ((paramc != null) && (!paramc.isRecycled()))
        {
          ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
        }
        AppMethodBeat.o(139470);
      }
    }
    ae.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, no bitmap in the given url");
    AppMethodBeat.o(139470);
    return false;
    label362:
    ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(localk.delete()) });
    label385:
    AppMethodBeat.o(139470);
    return false;
  }
  
  private static void dG(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(139471);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139467);
        b.dI(this.val$url, paramString2);
        AppMethodBeat.o(139467);
      }
    });
    AppMethodBeat.o(139471);
  }
  
  private static boolean dH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(139473);
    if (bu.isNullOrNil(paramString1))
    {
      ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
      AppMethodBeat.o(139473);
      return true;
    }
    paramString2 = g.getMD5(paramString2);
    ae.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(139473);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void Nr(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c.b
 * JD-Core Version:    0.7.0.1
 */