package com.tencent.mm.aw;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
{
  private static String[] cQl = null;
  
  public static String FB(String paramString)
  {
    AppMethodBeat.i(150771);
    String str = paramString;
    if (aIN()) {
      str = eu(paramString);
    }
    AppMethodBeat.o(150771);
    return str;
  }
  
  public static String FC(String paramString)
  {
    AppMethodBeat.i(150780);
    try
    {
      boolean bool = et(paramString);
      if (!bool)
      {
        AppMethodBeat.o(150780);
        return null;
      }
      paramString = Uri.parse(paramString).getQueryParameter("wxtype").toLowerCase();
      bool = bt.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150780);
        return null;
      }
      paramString = paramString.toLowerCase();
      AppMethodBeat.o(150780);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150780);
    }
    return null;
  }
  
  private static void Kb()
  {
    AppMethodBeat.i(150773);
    try
    {
      String str = ((a)g.ab(a.class)).acA().getValue("BizEnableWebpUrl");
      ad.i("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[] { str });
      if (!bt.isNullOrNil(str))
      {
        cQl = str.split(";");
        ad.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(cQl.length) });
      }
      AppMethodBeat.o(150773);
      return;
    }
    catch (b localb)
    {
      ad.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
      AppMethodBeat.o(150773);
      return;
    }
    catch (Exception localException)
    {
      ad.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(150773);
    }
  }
  
  public static boolean aIN()
  {
    AppMethodBeat.i(150772);
    if (cQl == null) {
      Kb();
    }
    if ((Build.VERSION.SDK_INT >= 14) && (cQl != null) && (cQl.length > 0) && (ae.gcP.gab == 1))
    {
      AppMethodBeat.o(150772);
      return true;
    }
    AppMethodBeat.o(150772);
    return false;
  }
  
  private static int aIO()
  {
    AppMethodBeat.i(150777);
    Context localContext = aj.getContext();
    if (ay.isWifi(localContext))
    {
      AppMethodBeat.o(150777);
      return 1;
    }
    if (ay.is5G(localContext))
    {
      AppMethodBeat.o(150777);
      return 5;
    }
    if (ay.is4G(localContext))
    {
      AppMethodBeat.o(150777);
      return 4;
    }
    if (ay.is3G(localContext))
    {
      AppMethodBeat.o(150777);
      return 3;
    }
    if (ay.is2G(localContext))
    {
      AppMethodBeat.o(150777);
      return 2;
    }
    AppMethodBeat.o(150777);
    return 0;
  }
  
  private static boolean et(String paramString)
  {
    AppMethodBeat.i(150774);
    if ((cQl != null) && (cQl.length > 0) && (!bt.isNullOrNil(paramString)))
    {
      String[] arrayOfString = cQl;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.startsWith(arrayOfString[i]))
        {
          AppMethodBeat.o(150774);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(150774);
    return false;
  }
  
  private static String eu(String paramString)
  {
    AppMethodBeat.i(150775);
    if ((cQl == null) || (cQl.length == 0))
    {
      ad.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
      Kb();
    }
    if (!et(paramString))
    {
      ad.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
      AppMethodBeat.o(150775);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = bt.isNullOrNil(str1);
      if (bool)
      {
        AppMethodBeat.o(150775);
        return paramString;
      }
      str1 = str1.toLowerCase();
      if (!str1.equals("gif"))
      {
        bool = str1.contains("gif");
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(150775);
        return paramString;
      }
      String str2 = ((Uri)localObject).getQueryParameter("tp");
      if (!bt.isNullOrNil(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(150775);
          return paramString;
        }
      }
      if (!bt.isNullOrNil(str1))
      {
        localObject = ((Uri)localObject).buildUpon().appendQueryParameter("tp", "webp").build().toString();
        AppMethodBeat.o(150775);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(150775);
      return paramString;
    }
    AppMethodBeat.o(150775);
    return paramString;
  }
  
  public static boolean ev(String paramString)
  {
    AppMethodBeat.i(150776);
    try
    {
      boolean bool = bt.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150776);
        return false;
      }
      bool = et(paramString);
      if (!bool)
      {
        AppMethodBeat.o(150776);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bt.isNullOrNil(paramString))
      {
        bool = paramString.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(150776);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150776);
      return false;
    }
    AppMethodBeat.o(150776);
    return false;
  }
  
  public static String pC(int paramInt)
  {
    AppMethodBeat.i(150778);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(aIO()), Integer.valueOf(2) });
    AppMethodBeat.o(150778);
    return str;
  }
  
  public static String pD(int paramInt)
  {
    AppMethodBeat.i(150779);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(aIO()), Integer.valueOf(1) });
    AppMethodBeat.o(150779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.t
 * JD-Core Version:    0.7.0.1
 */