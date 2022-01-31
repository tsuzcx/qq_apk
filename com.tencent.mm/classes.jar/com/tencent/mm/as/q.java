package com.tencent.mm.as;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
{
  private static String[] eqs = null;
  
  public static boolean OQ()
  {
    if (eqs == null) {
      OR();
    }
    if ((Build.VERSION.SDK_INT >= 14) && (eqs != null) && (eqs.length > 0) && (com.tencent.mm.compatible.e.q.dyn.dxH == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.WebpUtil", "isSupportWebp: %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  private static void OR()
  {
    try
    {
      String str = ((a)g.r(a.class)).AA().getValue("BizEnableWebpUrl");
      y.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[] { str });
      if (!bk.bl(str))
      {
        eqs = str.split(";");
        y.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(eqs.length) });
      }
      return;
    }
    catch (b localb)
    {
      y.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
      return;
    }
    catch (Exception localException)
    {
      y.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[] { localException.getMessage() });
    }
  }
  
  private static int OS()
  {
    Context localContext = ae.getContext();
    if (aq.isWifi(localContext)) {
      return 1;
    }
    if (aq.is4G(localContext)) {
      return 4;
    }
    if (aq.is3G(localContext)) {
      return 3;
    }
    if (aq.is2G(localContext)) {
      return 2;
    }
    return 0;
  }
  
  public static String iP(int paramInt)
  {
    return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(OS()), Integer.valueOf(2) });
  }
  
  public static String iQ(int paramInt)
  {
    return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(paramInt), Integer.valueOf(OS()), Integer.valueOf(1) });
  }
  
  private static boolean mn(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (eqs != null)
    {
      bool1 = bool2;
      if (eqs.length > 0)
      {
        bool1 = bool2;
        if (!bk.bl(paramString))
        {
          arrayOfString = eqs;
          j = arrayOfString.length;
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (paramString.startsWith(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String mo(String paramString)
  {
    if ((eqs == null) || (eqs.length == 0))
    {
      y.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
      OR();
    }
    if (!mn(paramString)) {
      y.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
    }
    for (;;)
    {
      return paramString;
      try
      {
        Object localObject = Uri.parse(paramString);
        String str1 = ((Uri)localObject).getQueryParameter("wxtype");
        if (!bk.bl(str1))
        {
          str1 = str1.toLowerCase();
          y.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, wxtype:%s", new Object[] { str1 });
          if ((!str1.equals("gif")) && (!str1.contains("gif")))
          {
            String str2 = ((Uri)localObject).getQueryParameter("tp");
            if (((bk.bl(str2)) || (!str2.equals("webp"))) && (!bk.bl(str1)))
            {
              localObject = ((Uri)localObject).buildUpon().appendQueryParameter("tp", "webp").build().toString();
              y.d("MicroMsg.WebpUtil", "webpURL: %s", new Object[] { localObject });
              return localObject;
            }
          }
        }
      }
      catch (Exception localException) {}
    }
    return paramString;
  }
  
  public static boolean mp(String paramString)
  {
    try
    {
      if (bk.bl(paramString)) {
        return false;
      }
      if (mn(paramString))
      {
        paramString = Uri.parse(paramString).getQueryParameter("tp");
        if (!bk.bl(paramString))
        {
          boolean bool = paramString.equals("webp");
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static String mq(String paramString)
  {
    try
    {
      if (!mn(paramString)) {
        return null;
      }
      paramString = Uri.parse(paramString).getQueryParameter("wxtype").toLowerCase();
      if (!bk.bl(paramString))
      {
        paramString = paramString.toLowerCase();
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.as.q
 * JD-Core Version:    0.7.0.1
 */