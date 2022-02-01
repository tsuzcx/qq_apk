package com.tencent.mm.av;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class q
{
  private static String[] cFg = null;
  
  public static String Cx(String paramString)
  {
    AppMethodBeat.i(150771);
    String str = paramString;
    if (aFE()) {
      str = dy(paramString);
    }
    AppMethodBeat.o(150771);
    return str;
  }
  
  public static String Cy(String paramString)
  {
    AppMethodBeat.i(150780);
    try
    {
      boolean bool = dx(paramString);
      if (!bool)
      {
        AppMethodBeat.o(150780);
        return null;
      }
      paramString = Uri.parse(paramString).getQueryParameter("wxtype").toLowerCase();
      bool = bs.isNullOrNil(paramString);
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
  
  private static void IB()
  {
    AppMethodBeat.i(150773);
    try
    {
      String str = ((a)g.ab(a.class)).ZY().getValue("BizEnableWebpUrl");
      ac.i("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[] { str });
      if (!bs.isNullOrNil(str))
      {
        cFg = str.split(";");
        ac.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(cFg.length) });
      }
      AppMethodBeat.o(150773);
      return;
    }
    catch (b localb)
    {
      ac.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
      AppMethodBeat.o(150773);
      return;
    }
    catch (Exception localException)
    {
      ac.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(150773);
    }
  }
  
  public static boolean aFE()
  {
    AppMethodBeat.i(150772);
    if (cFg == null) {
      IB();
    }
    if ((Build.VERSION.SDK_INT >= 14) && (cFg != null) && (cFg.length > 0) && (ae.fJo.fGC == 1))
    {
      AppMethodBeat.o(150772);
      return true;
    }
    AppMethodBeat.o(150772);
    return false;
  }
  
  private static int aFF()
  {
    AppMethodBeat.i(150777);
    Context localContext = ai.getContext();
    if (ax.isWifi(localContext))
    {
      AppMethodBeat.o(150777);
      return 1;
    }
    if (ax.is4G(localContext))
    {
      AppMethodBeat.o(150777);
      return 4;
    }
    if (ax.is3G(localContext))
    {
      AppMethodBeat.o(150777);
      return 3;
    }
    if (ax.is2G(localContext))
    {
      AppMethodBeat.o(150777);
      return 2;
    }
    AppMethodBeat.o(150777);
    return 0;
  }
  
  private static boolean dx(String paramString)
  {
    AppMethodBeat.i(150774);
    if ((cFg != null) && (cFg.length > 0) && (!bs.isNullOrNil(paramString)))
    {
      String[] arrayOfString = cFg;
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
  
  private static String dy(String paramString)
  {
    AppMethodBeat.i(150775);
    if ((cFg == null) || (cFg.length == 0))
    {
      ac.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
      IB();
    }
    if (!dx(paramString))
    {
      ac.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
      AppMethodBeat.o(150775);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = bs.isNullOrNil(str1);
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
      if (!bs.isNullOrNil(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(150775);
          return paramString;
        }
      }
      if (!bs.isNullOrNil(str1))
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
  
  public static boolean dz(String paramString)
  {
    AppMethodBeat.i(150776);
    try
    {
      boolean bool = bs.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150776);
        return false;
      }
      bool = dx(paramString);
      if (!bool)
      {
        AppMethodBeat.o(150776);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bs.isNullOrNil(paramString))
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
  
  public static String oZ(int paramInt)
  {
    AppMethodBeat.i(150778);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(aFF()), Integer.valueOf(2) });
    AppMethodBeat.o(150778);
    return str;
  }
  
  public static String pa(int paramInt)
  {
    AppMethodBeat.i(150779);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(aFF()), Integer.valueOf(1) });
    AppMethodBeat.o(150779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.q
 * JD-Core Version:    0.7.0.1
 */