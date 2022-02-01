package com.tencent.mm.api;

import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;

public final class b
{
  private static String[] cQV = null;
  private static Boolean cQW = null;
  
  private static void Kj()
  {
    AppMethodBeat.i(116347);
    try
    {
      String str = ((a)g.ab(a.class)).acL().getValue("BizEnableWxPicUrl");
      ae.i("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList, urlList: %s", new Object[] { str });
      if (!bu.isNullOrNil(str))
      {
        cQV = str.split(";");
        ae.d("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList, CDN_URL_LIST.length: %d", new Object[] { Integer.valueOf(cQV.length) });
      }
      AppMethodBeat.o(116347);
      return;
    }
    catch (com.tencent.mm.model.b localb)
    {
      ae.w("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList fail, AccountNotReady");
      AppMethodBeat.o(116347);
      return;
    }
    catch (Exception localException)
    {
      ae.d("MicroMsg.BizImageStrategy", "alvinluo initCdnUrlList error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(116347);
    }
  }
  
  public static boolean Kk()
  {
    AppMethodBeat.i(116353);
    if ((j.IS_FLAVOR_RED) || (j.DEBUG))
    {
      AppMethodBeat.o(116353);
      return true;
    }
    if (cQW == null) {
      Kl();
    }
    boolean bool = cQW.booleanValue();
    AppMethodBeat.o(116353);
    return bool;
  }
  
  public static void Kl()
  {
    AppMethodBeat.i(116354);
    cQW = Boolean.valueOf(Km());
    AppMethodBeat.o(116354);
  }
  
  private static boolean Km()
  {
    AppMethodBeat.i(116355);
    if ((j.IS_FLAVOR_RED) || (j.DEBUG))
    {
      AppMethodBeat.o(116355);
      return true;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qBm, 0);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.BizImageStrategy", "alvinluo updateWxPicOpenStatus config: %d, isOpen: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(116355);
      return bool;
    }
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(116345);
    if ((paramBoolean) && (hj(paramInt))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString = l(paramString, paramBoolean);
      AppMethodBeat.o(116345);
      return paramString;
    }
  }
  
  public static boolean eA(String paramString)
  {
    AppMethodBeat.i(116350);
    try
    {
      boolean bool = bu.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(116350);
        return false;
      }
      bool = ey(paramString);
      if (!bool)
      {
        AppMethodBeat.o(116350);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bu.isNullOrNil(paramString))
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
  
  private static String eB(String paramString)
  {
    AppMethodBeat.i(116351);
    if ((cQV == null) || (cQV.length == 0))
    {
      ae.d("MicroMsg.BizImageStrategy", "addWXPicURLIfNecessary, cdn url is null");
      Kj();
    }
    if (!ey(paramString))
    {
      ae.d("MicroMsg.BizImageStrategy", "addWXPicURLIfNecessary, is not cdn url");
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
      if (!bu.isNullOrNil(str))
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
  
  public static boolean eC(String paramString)
  {
    AppMethodBeat.i(116352);
    try
    {
      boolean bool = bu.isNullOrNil(paramString);
      if (bool)
      {
        AppMethodBeat.o(116352);
        return false;
      }
      bool = ey(paramString);
      if (!bool)
      {
        AppMethodBeat.o(116352);
        return false;
      }
      paramString = Uri.parse(paramString).getQueryParameter("tp");
      if (!bu.isNullOrNil(paramString))
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
  
  private static boolean ey(String paramString)
  {
    AppMethodBeat.i(116348);
    if ((cQV != null) && (cQV.length > 0) && (!bu.isNullOrNil(paramString)))
    {
      String[] arrayOfString = cQV;
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
  
  private static String ez(String paramString)
  {
    AppMethodBeat.i(116349);
    if ((cQV == null) || (cQV.length == 0))
    {
      ae.d("MicroMsg.BizImageStrategy", "addWebpURLIfNecessary, cdn url is null");
      Kj();
    }
    if (!ey(paramString))
    {
      ae.d("MicroMsg.BizImageStrategy", "addWebpURLIfNecessary, is not cdn url");
      AppMethodBeat.o(116349);
      return paramString;
    }
    try
    {
      Object localObject = Uri.parse(paramString);
      String str1 = ((Uri)localObject).getQueryParameter("wxtype");
      boolean bool = bu.isNullOrNil(str1);
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
      if (!bu.isNullOrNil(str2))
      {
        bool = str2.equals("webp");
        if (bool)
        {
          AppMethodBeat.o(116349);
          return paramString;
        }
      }
      if (!bu.isNullOrNil(str1))
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
  
  private static boolean hj(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4);
  }
  
  public static String l(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(116346);
    String str;
    if ((Kk()) && (paramBoolean)) {
      str = eB(paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(116346);
      return str;
      str = paramString;
      if (t.aJf()) {
        str = ez(paramString);
      }
    }
  }
  
  public static String t(String paramString, int paramInt)
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