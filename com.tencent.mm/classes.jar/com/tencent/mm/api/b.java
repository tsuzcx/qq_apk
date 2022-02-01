package com.tencent.mm.api;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.h;

public final class b
{
  private static String[] cFg = null;
  private static Boolean cFh = null;
  
  private static void IB()
  {
    AppMethodBeat.i(116347);
    try
    {
      String str = ((a)g.ab(a.class)).ZY().getValue("BizEnableWxPicUrl");
      ac.i("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList, urlList: %s", new Object[] { str });
      if (!bs.isNullOrNil(str))
      {
        cFg = str.split(";");
        ac.d("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(cFg.length) });
      }
      AppMethodBeat.o(116347);
      return;
    }
    catch (com.tencent.mm.model.b localb)
    {
      ac.w("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList fail, AccountNotReady");
      AppMethodBeat.o(116347);
      return;
    }
    catch (Exception localException)
    {
      ac.d("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(116347);
    }
  }
  
  public static boolean IC()
  {
    AppMethodBeat.i(116353);
    if ((h.IS_FLAVOR_RED) || (h.DEBUG))
    {
      AppMethodBeat.o(116353);
      return true;
    }
    if (cFh == null) {
      ID();
    }
    boolean bool = cFh.booleanValue();
    AppMethodBeat.o(116353);
    return bool;
  }
  
  public static void ID()
  {
    AppMethodBeat.i(116354);
    cFh = Boolean.valueOf(IE());
    AppMethodBeat.o(116354);
  }
  
  private static boolean IE()
  {
    AppMethodBeat.i(116355);
    if ((h.IS_FLAVOR_RED) || (h.DEBUG))
    {
      AppMethodBeat.o(116355);
      return true;
    }
    int i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pQi, 0);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.BizImageStrategy", "alvinluo updateWxPicOpenStatus config: %d, isOpen: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(116355);
      return bool;
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(116345);
    if ((paramBoolean) && (hb(paramInt))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString = l(paramString, paramBoolean);
      AppMethodBeat.o(116345);
      return paramString;
    }
  }
  
  private static String dA(String paramString)
  {
    AppMethodBeat.i(116351);
    if ((cFg == null) || (cFg.length == 0))
    {
      ac.d("MicroMsg.BizImageStrategy", "addWXPicURLIfNecessary, cdn url is null");
      IB();
    }
    if (!dx(paramString))
    {
      ac.d("MicroMsg.BizImageStrategy", "addWXPicURLIfNecessary, is not cdn url");
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
      if (!bs.isNullOrNil(str))
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
  
  public static boolean dB(String paramString)
  {
    AppMethodBeat.i(116352);
    try
    {
      boolean bool = bs.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(116352);
        return false;
      }
      bool = dx(paramString);
      if (!bool)
      {
        AppMethodBeat.o(116352);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bs.isNullOrNil(paramString))
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
  
  private static boolean dx(String paramString)
  {
    AppMethodBeat.i(116348);
    if ((cFg != null) && (cFg.length > 0) && (!bs.isNullOrNil(paramString)))
    {
      String[] arrayOfString = cFg;
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
  
  private static String dy(String paramString)
  {
    AppMethodBeat.i(116349);
    if ((cFg == null) || (cFg.length == 0))
    {
      ac.d("MicroMsg.BizImageStrategy", "addWebpURLIfNecessary, cdn url is null");
      IB();
    }
    if (!dx(paramString))
    {
      ac.d("MicroMsg.BizImageStrategy", "addWebpURLIfNecessary, is not cdn url");
      AppMethodBeat.o(116349);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = bs.isNullOrNil(str1);
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
      if (!bs.isNullOrNil(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(116349);
          return paramString;
        }
      }
      if (!bs.isNullOrNil(str1))
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
  
  public static boolean dz(String paramString)
  {
    AppMethodBeat.i(116350);
    try
    {
      boolean bool = bs.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(116350);
        return false;
      }
      bool = dx(paramString);
      if (!bool)
      {
        AppMethodBeat.o(116350);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bs.isNullOrNil(paramString))
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
  
  private static boolean hb(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
  }
  
  public static String l(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116346);
    String str;
    if ((IC()) && (paramBoolean)) {
      str = dA(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(116346);
      return str;
      str = paramString;
      if (q.aFE()) {
        str = dy(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.b
 * JD-Core Version:    0.7.0.1
 */