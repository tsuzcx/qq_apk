package com.tencent.mm.av;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

public final class t
{
  private static String[] cQV = null;
  
  public static String Gd(String paramString)
  {
    AppMethodBeat.i(150771);
    String str = paramString;
    if (aJf()) {
      str = ez(paramString);
    }
    AppMethodBeat.o(150771);
    return str;
  }
  
  public static String Ge(String paramString)
  {
    AppMethodBeat.i(150780);
    try
    {
      boolean bool = ey(paramString);
      if (!bool)
      {
        AppMethodBeat.o(150780);
        return null;
      }
      paramString = Uri.parse(paramString).getQueryParameter("wxtype").toLowerCase();
      bool = bu.isNullOrNil(paramString);
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
  
  private static void Kj()
  {
    AppMethodBeat.i(150773);
    try
    {
      String str = ((a)g.ab(a.class)).acL().getValue("BizEnableWebpUrl");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[] { str });
      if (!bu.isNullOrNil(str))
      {
        cQV = str.split(";");
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(cQV.length) });
      }
      AppMethodBeat.o(150773);
      return;
    }
    catch (b localb)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
      AppMethodBeat.o(150773);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(150773);
    }
  }
  
  public static boolean aJf()
  {
    AppMethodBeat.i(150772);
    if (cQV == null) {
      Kj();
    }
    if ((Build.VERSION.SDK_INT >= 14) && (cQV != null) && (cQV.length > 0) && (com.tencent.mm.compatible.deviceinfo.ae.geX.gck == 1))
    {
      AppMethodBeat.o(150772);
      return true;
    }
    AppMethodBeat.o(150772);
    return false;
  }
  
  private static int aJg()
  {
    AppMethodBeat.i(150777);
    Context localContext = ak.getContext();
    if (az.isWifi(localContext))
    {
      AppMethodBeat.o(150777);
      return 1;
    }
    if (az.is5G(localContext))
    {
      AppMethodBeat.o(150777);
      return 5;
    }
    if (az.is4G(localContext))
    {
      AppMethodBeat.o(150777);
      return 4;
    }
    if (az.is3G(localContext))
    {
      AppMethodBeat.o(150777);
      return 3;
    }
    if (az.is2G(localContext))
    {
      AppMethodBeat.o(150777);
      return 2;
    }
    AppMethodBeat.o(150777);
    return 0;
  }
  
  public static boolean eA(String paramString)
  {
    AppMethodBeat.i(150776);
    try
    {
      boolean bool = bu.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150776);
        return false;
      }
      bool = ey(paramString);
      if (!bool)
      {
        AppMethodBeat.o(150776);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bu.isNullOrNil(paramString))
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
  
  private static boolean ey(String paramString)
  {
    AppMethodBeat.i(150774);
    if ((cQV != null) && (cQV.length > 0) && (!bu.isNullOrNil(paramString)))
    {
      String[] arrayOfString = cQV;
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
  
  private static String ez(String paramString)
  {
    AppMethodBeat.i(150775);
    if ((cQV == null) || (cQV.length == 0))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
      Kj();
    }
    if (!ey(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
      AppMethodBeat.o(150775);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = bu.isNullOrNil(str1);
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
      if (!bu.isNullOrNil(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(150775);
          return paramString;
        }
      }
      if (!bu.isNullOrNil(str1))
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
  
  public static String pF(int paramInt)
  {
    AppMethodBeat.i(150778);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(aJg()), Integer.valueOf(2) });
    AppMethodBeat.o(150778);
    return str;
  }
  
  public static String pG(int paramInt)
  {
    AppMethodBeat.i(150779);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(aJg()), Integer.valueOf(1) });
    AppMethodBeat.o(150779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.t
 * JD-Core Version:    0.7.0.1
 */