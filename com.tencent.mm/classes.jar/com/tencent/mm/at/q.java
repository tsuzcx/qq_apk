package com.tencent.mm.at;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
{
  private static String[] fGT = null;
  
  public static boolean ahJ()
  {
    AppMethodBeat.i(78405);
    if (fGT == null) {
      ahK();
    }
    if ((Build.VERSION.SDK_INT >= 14) && (fGT != null) && (fGT.length > 0) && (ac.erF.epF == 1))
    {
      AppMethodBeat.o(78405);
      return true;
    }
    AppMethodBeat.o(78405);
    return false;
  }
  
  private static void ahK()
  {
    AppMethodBeat.i(78406);
    try
    {
      String str = ((a)g.E(a.class)).Nq().getValue("BizEnableWebpUrl");
      ab.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[] { str });
      if (!bo.isNullOrNil(str))
      {
        fGT = str.split(";");
        ab.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(fGT.length) });
      }
      AppMethodBeat.o(78406);
      return;
    }
    catch (b localb)
    {
      ab.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
      AppMethodBeat.o(78406);
      return;
    }
    catch (Exception localException)
    {
      ab.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(78406);
    }
  }
  
  private static int ahL()
  {
    AppMethodBeat.i(78410);
    Context localContext = ah.getContext();
    if (at.isWifi(localContext))
    {
      AppMethodBeat.o(78410);
      return 1;
    }
    if (at.is4G(localContext))
    {
      AppMethodBeat.o(78410);
      return 4;
    }
    if (at.is3G(localContext))
    {
      AppMethodBeat.o(78410);
      return 3;
    }
    if (at.is2G(localContext))
    {
      AppMethodBeat.o(78410);
      return 2;
    }
    AppMethodBeat.o(78410);
    return 0;
  }
  
  public static String lD(int paramInt)
  {
    AppMethodBeat.i(78411);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(ahL()), Integer.valueOf(2) });
    AppMethodBeat.o(78411);
    return str;
  }
  
  public static String lE(int paramInt)
  {
    AppMethodBeat.i(78412);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(ahL()), Integer.valueOf(1) });
    AppMethodBeat.o(78412);
    return str;
  }
  
  public static String ts(String paramString)
  {
    AppMethodBeat.i(151567);
    String str = paramString;
    if (ahJ()) {
      str = tu(paramString);
    }
    AppMethodBeat.o(151567);
    return str;
  }
  
  private static boolean tt(String paramString)
  {
    AppMethodBeat.i(78407);
    if ((fGT != null) && (fGT.length > 0) && (!bo.isNullOrNil(paramString)))
    {
      String[] arrayOfString = fGT;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.startsWith(arrayOfString[i]))
        {
          AppMethodBeat.o(78407);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(78407);
    return false;
  }
  
  public static String tu(String paramString)
  {
    AppMethodBeat.i(78408);
    if ((fGT == null) || (fGT.length == 0))
    {
      ab.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
      ahK();
    }
    if (!tt(paramString))
    {
      ab.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
      AppMethodBeat.o(78408);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = bo.isNullOrNil(str1);
      if (bool)
      {
        AppMethodBeat.o(78408);
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
        AppMethodBeat.o(78408);
        return paramString;
      }
      String str2 = ((Uri)localObject).getQueryParameter("tp");
      if (!bo.isNullOrNil(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(78408);
          return paramString;
        }
      }
      if (!bo.isNullOrNil(str1))
      {
        localObject = ((Uri)localObject).buildUpon().appendQueryParameter("tp", "webp").build().toString();
        AppMethodBeat.o(78408);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(78408);
      return paramString;
    }
    AppMethodBeat.o(78408);
    return paramString;
  }
  
  public static boolean tv(String paramString)
  {
    AppMethodBeat.i(78409);
    try
    {
      boolean bool = bo.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(78409);
        return false;
      }
      bool = tt(paramString);
      if (!bool)
      {
        AppMethodBeat.o(78409);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bo.isNullOrNil(paramString))
      {
        bool = paramString.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(78409);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(78409);
      return false;
    }
    AppMethodBeat.o(78409);
    return false;
  }
  
  public static String tw(String paramString)
  {
    AppMethodBeat.i(78413);
    try
    {
      boolean bool = tt(paramString);
      if (!bool)
      {
        AppMethodBeat.o(78413);
        return null;
      }
      paramString = Uri.parse(paramString).getQueryParameter("wxtype").toLowerCase();
      bool = bo.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(78413);
        return null;
      }
      paramString = paramString.toLowerCase();
      AppMethodBeat.o(78413);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(78413);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.at.q
 * JD-Core Version:    0.7.0.1
 */