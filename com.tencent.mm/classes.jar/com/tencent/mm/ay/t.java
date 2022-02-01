package com.tencent.mm.ay;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.b;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class t
{
  private static String[] eYW = null;
  
  public static String Wm(String paramString)
  {
    AppMethodBeat.i(150771);
    String str = paramString;
    if (bmq()) {
      str = fW(paramString);
    }
    AppMethodBeat.o(150771);
    return str;
  }
  
  public static String Wn(String paramString)
  {
    AppMethodBeat.i(150780);
    try
    {
      boolean bool = fV(paramString);
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
  
  private static void YK()
  {
    AppMethodBeat.i(150773);
    try
    {
      String str = ((a)h.ae(a.class)).axc().getValue("BizEnableWebpUrl");
      Log.i("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[] { str });
      if (!Util.isNullOrNil(str))
      {
        eYW = str.split(";");
        Log.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(eYW.length) });
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
  
  public static boolean bmq()
  {
    AppMethodBeat.i(150772);
    if (eYW == null) {
      YK();
    }
    if ((Build.VERSION.SDK_INT >= 14) && (eYW != null) && (eYW.length > 0) && (af.juS.jrZ == 1))
    {
      AppMethodBeat.o(150772);
      return true;
    }
    AppMethodBeat.o(150772);
    return false;
  }
  
  private static int bmr()
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
  
  private static boolean fV(String paramString)
  {
    AppMethodBeat.i(150774);
    if ((eYW != null) && (eYW.length > 0) && (!Util.isNullOrNil(paramString)))
    {
      String[] arrayOfString = eYW;
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
  
  private static String fW(String paramString)
  {
    AppMethodBeat.i(150775);
    if ((eYW == null) || (eYW.length == 0))
    {
      Log.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
      YK();
    }
    if (!fV(paramString))
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
  
  public static boolean fX(String paramString)
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
      bool = fV(paramString);
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
  
  public static String wt(int paramInt)
  {
    AppMethodBeat.i(150778);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(bmr()), Integer.valueOf(2) });
    AppMethodBeat.o(150778);
    return str;
  }
  
  public static String wu(int paramInt)
  {
    AppMethodBeat.i(150779);
    String str = String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(bmr()), Integer.valueOf(1) });
    AppMethodBeat.o(150779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.t
 * JD-Core Version:    0.7.0.1
 */