package com.tencent.mm.modelimage;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
{
  private static String[] hcw = null;
  
  public static String Om(String paramString)
  {
    AppMethodBeat.i(150771);
    String str = paramString;
    if (bKj()) {
      str = hz(paramString);
    }
    AppMethodBeat.o(150771);
    return str;
  }
  
  public static String On(String paramString)
  {
    AppMethodBeat.i(150780);
    try
    {
      boolean bool = hy(paramString);
      if (!bool)
      {
        AppMethodBeat.o(150780);
        return null;
      }
      paramString = Uri.parse(paramString).getQueryParameter("wxtype").toLowerCase();
      bool = Util.isNullOrNil(paramString);
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
  
  private static void aAE()
  {
    AppMethodBeat.i(150773);
    try
    {
      String str = ((a)h.ax(a.class)).aRC().getValue("BizEnableWebpUrl");
      Log.i("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[] { str });
      if (!Util.isNullOrNil(str))
      {
        hcw = str.split(";");
        Log.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(hcw.length) });
      }
      AppMethodBeat.o(150773);
      return;
    }
    catch (b localb)
    {
      Log.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
      AppMethodBeat.o(150773);
      return;
    }
    catch (Exception localException)
    {
      Log.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(150773);
    }
  }
  
  public static boolean bKj()
  {
    AppMethodBeat.i(150772);
    if (hcw == null) {
      aAE();
    }
    if ((Build.VERSION.SDK_INT >= 14) && (hcw != null) && (hcw.length > 0) && (af.lYj.lVp == 1))
    {
      AppMethodBeat.o(150772);
      return true;
    }
    AppMethodBeat.o(150772);
    return false;
  }
  
  private static int bKk()
  {
    AppMethodBeat.i(150777);
    Context localContext = MMApplicationContext.getContext();
    if (NetStatusUtil.isWifi(localContext))
    {
      AppMethodBeat.o(150777);
      return 1;
    }
    if (NetStatusUtil.is5G(localContext))
    {
      AppMethodBeat.o(150777);
      return 5;
    }
    if (NetStatusUtil.is4G(localContext))
    {
      AppMethodBeat.o(150777);
      return 4;
    }
    if (NetStatusUtil.is3G(localContext))
    {
      AppMethodBeat.o(150777);
      return 3;
    }
    if (NetStatusUtil.is2G(localContext))
    {
      AppMethodBeat.o(150777);
      return 2;
    }
    AppMethodBeat.o(150777);
    return 0;
  }
  
  public static boolean hA(String paramString)
  {
    AppMethodBeat.i(150776);
    try
    {
      boolean bool = Util.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(150776);
        return false;
      }
      bool = hy(paramString);
      if (!bool)
      {
        AppMethodBeat.o(150776);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!Util.isNullOrNil(paramString))
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
  
  private static boolean hy(String paramString)
  {
    AppMethodBeat.i(150774);
    if ((hcw != null) && (hcw.length > 0) && (!Util.isNullOrNil(paramString)))
    {
      String[] arrayOfString = hcw;
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
  
  private static String hz(String paramString)
  {
    AppMethodBeat.i(150775);
    if ((hcw == null) || (hcw.length == 0))
    {
      Log.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
      aAE();
    }
    if (!hy(paramString))
    {
      Log.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
      AppMethodBeat.o(150775);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = Util.isNullOrNil(str1);
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
      if (!Util.isNullOrNil(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(150775);
          return paramString;
        }
      }
      if (!Util.isNullOrNil(str1))
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
  
  public static String wy(int paramInt)
  {
    AppMethodBeat.i(150778);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(bKk()), Integer.valueOf(2) });
    AppMethodBeat.o(150778);
    return str;
  }
  
  public static String wz(int paramInt)
  {
    AppMethodBeat.i(150779);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(bKk()), Integer.valueOf(1) });
    AppMethodBeat.o(150779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.u
 * JD-Core Version:    0.7.0.1
 */