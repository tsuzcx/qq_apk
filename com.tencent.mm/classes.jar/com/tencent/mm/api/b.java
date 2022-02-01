package com.tencent.mm.api;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;

public final class b
{
  private static String[] cHZ = null;
  private static Boolean cIa = null;
  
  private static void IS()
  {
    AppMethodBeat.i(116347);
    try
    {
      String str = ((a)g.ab(a.class)).Zd().getValue("BizEnableWxPicUrl");
      ad.i("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList, urlList: %s", new Object[] { str });
      if (!bt.isNullOrNil(str))
      {
        cHZ = str.split(";");
        ad.d("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(cHZ.length) });
      }
      AppMethodBeat.o(116347);
      return;
    }
    catch (com.tencent.mm.model.b localb)
    {
      ad.w("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList fail, AccountNotReady");
      AppMethodBeat.o(116347);
      return;
    }
    catch (Exception localException)
    {
      ad.d("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(116347);
    }
  }
  
  public static boolean IT()
  {
    AppMethodBeat.i(116353);
    if ((h.IS_FLAVOR_RED) || (h.DEBUG))
    {
      AppMethodBeat.o(116353);
      return true;
    }
    if (cIa == null) {
      IU();
    }
    boolean bool = cIa.booleanValue();
    AppMethodBeat.o(116353);
    return bool;
  }
  
  public static void IU()
  {
    AppMethodBeat.i(116354);
    cIa = Boolean.valueOf(IV());
    AppMethodBeat.o(116354);
  }
  
  private static boolean IV()
  {
    AppMethodBeat.i(116355);
    if ((h.IS_FLAVOR_RED) || (h.DEBUG))
    {
      AppMethodBeat.o(116355);
      return true;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmI, 0);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.BizImageStrategy", "alvinluo updateWxPicOpenStatus config: %d, isOpen: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(116355);
      return bool;
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(116345);
    if ((paramBoolean) && (hs(paramInt))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString = l(paramString, paramBoolean);
      AppMethodBeat.o(116345);
      return paramString;
    }
  }
  
  private static boolean dI(String paramString)
  {
    AppMethodBeat.i(116348);
    if ((cHZ != null) && (cHZ.length > 0) && (!bt.isNullOrNil(paramString)))
    {
      String[] arrayOfString = cHZ;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (paramString.startsWith(arrayOfString[i]))
        {
          AppMethodBeat.o(116348);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(116348);
    return false;
  }
  
  private static String dJ(String paramString)
  {
    AppMethodBeat.i(116349);
    if ((cHZ == null) || (cHZ.length == 0))
    {
      ad.d("MicroMsg.BizImageStrategy", "addWebpURLIfNecessary, cdn url is null");
      IS();
    }
    if (!dI(paramString))
    {
      ad.d("MicroMsg.BizImageStrategy", "addWebpURLIfNecessary, is not cdn url");
      AppMethodBeat.o(116349);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = bt.isNullOrNil(str1);
      if (bool)
      {
        AppMethodBeat.o(116349);
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
        AppMethodBeat.o(116349);
        return paramString;
      }
      String str2 = ((Uri)localObject).getQueryParameter("tp");
      if (!bt.isNullOrNil(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(116349);
          return paramString;
        }
      }
      if (!bt.isNullOrNil(str1))
      {
        localObject = ((Uri)localObject).buildUpon().appendQueryParameter("tp", "webp").build().toString();
        AppMethodBeat.o(116349);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(116349);
      return paramString;
    }
    AppMethodBeat.o(116349);
    return paramString;
  }
  
  public static boolean dK(String paramString)
  {
    AppMethodBeat.i(116350);
    try
    {
      boolean bool = bt.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(116350);
        return false;
      }
      bool = dI(paramString);
      if (!bool)
      {
        AppMethodBeat.o(116350);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bt.isNullOrNil(paramString))
      {
        bool = paramString.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(116350);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(116350);
      return false;
    }
    AppMethodBeat.o(116350);
    return false;
  }
  
  private static String dL(String paramString)
  {
    AppMethodBeat.i(116351);
    if ((cHZ == null) || (cHZ.length == 0))
    {
      ad.d("MicroMsg.BizImageStrategy", "addWXPicURLIfNecessary, cdn url is null");
      IS();
    }
    if (!dI(paramString))
    {
      ad.d("MicroMsg.BizImageStrategy", "addWXPicURLIfNecessary, is not cdn url");
      AppMethodBeat.o(116351);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool;
      if (str != null)
      {
        str = str.toLowerCase();
        if (!str.equals("gif"))
        {
          bool = str.contains("gif");
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(116351);
          return paramString;
        }
      }
      str = ((Uri)localObject).getQueryParameter("tp");
      if (!bt.isNullOrNil(str))
      {
        bool = str.equals("wxpic");
        if (bool)
        {
          AppMethodBeat.o(116351);
          return paramString;
        }
      }
      localObject = ((Uri)localObject).buildUpon().appendQueryParameter("tp", "wxpic").build().toString();
      AppMethodBeat.o(116351);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(116351);
    }
    return paramString;
  }
  
  public static boolean dM(String paramString)
  {
    AppMethodBeat.i(116352);
    try
    {
      boolean bool = bt.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(116352);
        return false;
      }
      bool = dI(paramString);
      if (!bool)
      {
        AppMethodBeat.o(116352);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bt.isNullOrNil(paramString))
      {
        bool = paramString.equals("wxpic");
        if (bool)
        {
          AppMethodBeat.o(116352);
          return true;
        }
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(116352);
      return false;
    }
    AppMethodBeat.o(116352);
    return false;
  }
  
  private static boolean hs(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
  }
  
  public static String l(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116346);
    String str;
    if ((IT()) && (paramBoolean)) {
      str = dL(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(116346);
      return str;
      str = paramString;
      if (q.ayM()) {
        str = dJ(paramString);
      }
    }
  }
  
  public static String q(String paramString, int paramInt)
  {
    AppMethodBeat.i(116344);
    paramString = a(paramString, paramInt, true);
    AppMethodBeat.o(116344);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.api.b
 * JD-Core Version:    0.7.0.1
 */