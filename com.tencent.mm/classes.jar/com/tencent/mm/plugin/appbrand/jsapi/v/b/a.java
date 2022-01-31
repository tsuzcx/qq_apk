package com.tencent.mm.plugin.appbrand.jsapi.v.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.o;
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

public final class a
{
  private static final String fqs;
  private static ConcurrentMap<String, Boolean> iiv;
  private static Map<String, List<a.a>> iiw;
  
  static
  {
    AppMethodBeat.i(140035);
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
    AppMethodBeat.o(140035);
  }
  
  public static void a(final c paramc, String paramString1, final String paramString2, a.a parama)
  {
    int i = 1;
    AppMethodBeat.i(140027);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(140027);
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, url:%s", new Object[] { paramString1 });
      if (paramc == null)
      {
        ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, component is null");
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label259;
        }
        a(parama);
        AppMethodBeat.o(140027);
        return;
        paramc = paramc.wX().zg(paramString1);
        if ((paramc == null) || (!paramc.exists())) {
          break;
        }
        paramc = paramc.getAbsolutePath();
        ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, localPath:%s", new Object[] { paramc });
        if (!cy(paramString2, paramc)) {
          break;
        }
        parama.BO(paramc);
      }
    }
    if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
    {
      ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, url:%s", new Object[] { paramString1 });
      paramc = qz(paramString1);
      paramc = String.format("%s%s", new Object[] { fqs, paramc });
      ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, localPath:%s", new Object[] { paramc });
      al.d(new a.1(paramString1, parama));
      com.tencent.mm.sdk.g.d.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(140025);
          a.G(this.val$url, paramString2, paramc);
          AppMethodBeat.o(140025);
        }
      }, "AppBrandLiveFileLoadHelperThread");
      AppMethodBeat.o(140027);
      return;
    }
    if (!b(paramc, paramString1, paramString2, parama)) {
      a(parama);
    }
    label259:
    AppMethodBeat.o(140027);
  }
  
  private static void a(a.a parama)
  {
    AppMethodBeat.i(140028);
    if (parama != null) {
      parama.BO(null);
    }
    AppMethodBeat.o(140028);
  }
  
  private static boolean b(c paramc, String paramString1, String paramString2, a.a parama)
  {
    AppMethodBeat.i(140029);
    ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url:%s", new Object[] { paramString1 });
    if (paramc == null)
    {
      ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, component is null");
      AppMethodBeat.o(140029);
      return false;
    }
    if (!(paramc instanceof h))
    {
      ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, can not get runtime from component");
      AppMethodBeat.o(140029);
      return false;
    }
    paramc = ((h)paramc).getRuntime();
    if (paramc == null)
    {
      ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, runtime is null");
      AppMethodBeat.o(140029);
      return false;
    }
    String str = qz(paramString1);
    str = String.format("%s%s", new Object[] { fqs, str });
    ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, localPath:%s", new Object[] { str });
    File localFile = new File(str);
    if (!localFile.exists())
    {
      paramc = t.j(paramc, paramString1);
      if ((paramc == null) || (paramc.isRecycled())) {}
    }
    else
    {
      try
      {
        com.tencent.mm.sdk.platformtools.d.a(paramc, 100, Bitmap.CompressFormat.PNG, str, true);
        if ((paramc != null) && (!paramc.isRecycled()))
        {
          ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
        }
        if (!cy(paramString2, str)) {
          break label361;
        }
        if (parama == null) {
          break label384;
        }
        parama.BO(str);
        AppMethodBeat.o(140029);
        return true;
      }
      catch (IOException paramString1)
      {
        ab.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramString1 });
        return false;
      }
      finally
      {
        if ((paramc != null) && (!paramc.isRecycled()))
        {
          ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
        }
        AppMethodBeat.o(140029);
      }
    }
    ab.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, no bitmap in the given url");
    AppMethodBeat.o(140029);
    return false;
    label361:
    ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, file exists but md5 not valid, deleted:%b", new Object[] { Boolean.valueOf(localFile.delete()) });
    label384:
    AppMethodBeat.o(140029);
    return false;
  }
  
  private static void cx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140030);
    al.d(new a.3(paramString1, paramString2));
    AppMethodBeat.o(140030);
  }
  
  private static boolean cy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(140032);
    if (bo.isNullOrNil(paramString1))
    {
      ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
      AppMethodBeat.o(140032);
      return true;
    }
    paramString2 = g.getMD5(paramString2);
    ab.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(140032);
    return bool;
  }
  
  private static String qz(String paramString)
  {
    AppMethodBeat.i(140031);
    String str = null;
    if (!bo.isNullOrNil(paramString)) {
      str = g.w(paramString.getBytes());
    }
    AppMethodBeat.o(140031);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b.a
 * JD-Core Version:    0.7.0.1
 */