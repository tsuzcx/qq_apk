package com.tencent.mm.au;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public final class b
{
  private static Map<String, b.a> fHO = null;
  private static Map<String, String> fHP = null;
  private static String fHQ = null;
  
  public static List<b.a> G(Context paramContext, String paramString)
  {
    localContext1 = null;
    AppMethodBeat.i(59958);
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (paramContext != null)
      {
        localContext2 = paramContext;
        localContext1 = paramContext;
        if (paramContext.equals(fHQ)) {}
      }
      else
      {
        localContext1 = paramContext;
        fHO = null;
        localContext2 = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Context localContext2 = localContext1;
      }
    }
    if (fHO == null)
    {
      fHQ = localContext2;
      tJ(paramString);
    }
    paramContext = new ArrayList(fHO.values());
    AppMethodBeat.o(59958);
    return paramContext;
  }
  
  public static boolean aic()
  {
    AppMethodBeat.i(59951);
    if ((!aa.dsC()) && (!aa.dsG().equals("en")))
    {
      AppMethodBeat.o(59951);
      return true;
    }
    AppMethodBeat.o(59951);
    return false;
  }
  
  public static boolean aid()
  {
    AppMethodBeat.i(59952);
    boolean bool = bo.hl(ah.getContext());
    AppMethodBeat.o(59952);
    return bool;
  }
  
  public static boolean aie()
  {
    AppMethodBeat.i(59953);
    if ((r.Zm() == 0) && (bo.hl(ah.getContext())))
    {
      AppMethodBeat.o(59953);
      return false;
    }
    AppMethodBeat.o(59953);
    return true;
  }
  
  public static boolean aif()
  {
    return false;
  }
  
  public static boolean aig()
  {
    AppMethodBeat.i(59954);
    if (!aa.dsG().equals("zh_CN"))
    {
      AppMethodBeat.o(59954);
      return true;
    }
    TimeZone localTimeZone1 = TimeZone.getDefault();
    TimeZone localTimeZone2 = TimeZone.getTimeZone("GMT+08:00");
    if (localTimeZone1.getRawOffset() != localTimeZone2.getRawOffset())
    {
      AppMethodBeat.o(59954);
      return true;
    }
    AppMethodBeat.o(59954);
    return false;
  }
  
  public static boolean aih()
  {
    AppMethodBeat.i(156801);
    boolean bool = bo.hl(ah.getContext());
    AppMethodBeat.o(156801);
    return bool;
  }
  
  public static b.a k(Context paramContext, String paramString1, String paramString2)
  {
    localContext1 = null;
    AppMethodBeat.i(59957);
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (paramContext != null)
      {
        localContext2 = paramContext;
        localContext1 = paramContext;
        if (paramContext.equals(fHQ)) {}
      }
      else
      {
        localContext1 = paramContext;
        fHO = null;
        localContext2 = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Context localContext2 = localContext1;
      }
    }
    if ((fHO == null) || (fHP == null))
    {
      fHQ = localContext2;
      tJ(paramString2);
    }
    paramContext = (b.a)fHO.get(paramString1.toUpperCase() + (String)fHP.get(paramString1.toUpperCase()));
    AppMethodBeat.o(59957);
    return paramContext;
  }
  
  public static String l(Context paramContext, String paramString1, String paramString2)
  {
    localContext1 = null;
    AppMethodBeat.i(59961);
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (paramContext != null)
      {
        localContext2 = paramContext;
        localContext1 = paramContext;
        if (paramContext.equals(fHQ)) {}
      }
      else
      {
        localContext1 = paramContext;
        fHO = null;
        localContext2 = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Context localContext2 = localContext1;
      }
    }
    if (fHO == null)
    {
      fHQ = localContext2;
      tJ(paramString2);
    }
    paramContext = fHO.values().iterator();
    while (paramContext.hasNext())
    {
      paramString2 = (b.a)paramContext.next();
      if (paramString2.fHS.equals(paramString1))
      {
        paramContext = paramString2.fHT;
        AppMethodBeat.o(59961);
        return paramContext;
      }
    }
    AppMethodBeat.o(59961);
    return "";
  }
  
  public static String m(Context paramContext, String paramString1, String paramString2)
  {
    localContext1 = null;
    AppMethodBeat.i(59962);
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (paramContext != null)
      {
        localContext2 = paramContext;
        localContext1 = paramContext;
        if (paramContext.equals(fHQ)) {}
      }
      else
      {
        localContext1 = paramContext;
        fHO = null;
        localContext2 = paramContext;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Context localContext2 = localContext1;
      }
    }
    if (fHO == null)
    {
      fHQ = localContext2;
      tJ(paramString2);
    }
    paramContext = fHO.values().iterator();
    while (paramContext.hasNext())
    {
      paramString2 = (b.a)paramContext.next();
      if (paramString2.fHS.equals(paramString1))
      {
        paramContext = paramString2.fHR;
        AppMethodBeat.o(59962);
        return paramContext;
      }
    }
    AppMethodBeat.o(59962);
    return "";
  }
  
  private static void tJ(String paramString)
  {
    AppMethodBeat.i(59956);
    fHO = new HashMap();
    fHP = new HashMap();
    String[] arrayOfString = bo.nullAsNil(paramString).trim().split(",");
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString = arrayOfString[i].trim().split(":");
      if (paramString.length < 4)
      {
        ab.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", new Object[] { arrayOfString[i].trim() });
        i += 1;
      }
      else
      {
        if (!aa.dsE()) {}
        for (paramString = new b.a(paramString[0], paramString[1], paramString[2], paramString[3], paramString[3].charAt(0));; paramString = new b.a(paramString[0], paramString[1], paramString[2], paramString[3], a.tI(paramString[2])))
        {
          fHO.put(paramString.fHR + paramString.fHS, paramString);
          fHP.put(paramString.fHR, paramString.fHS);
          break;
        }
      }
    }
    AppMethodBeat.o(59956);
  }
  
  public static boolean tK(String paramString)
  {
    AppMethodBeat.i(59959);
    if ((paramString != null) && (paramString.length() > 1) && (paramString.startsWith("+")) && (!paramString.startsWith("+86")))
    {
      AppMethodBeat.o(59959);
      return true;
    }
    AppMethodBeat.o(59959);
    return false;
  }
  
  public static String tL(String paramString)
  {
    AppMethodBeat.i(59960);
    if ((paramString.startsWith("+886")) || (paramString.startsWith("+86")))
    {
      AppMethodBeat.o(59960);
      return "zh-TW";
    }
    if ((paramString.startsWith("+852")) || (paramString.startsWith("+853")))
    {
      AppMethodBeat.o(59960);
      return "zh-HK";
    }
    if (paramString.startsWith("+81"))
    {
      AppMethodBeat.o(59960);
      return "ja";
    }
    if (paramString.startsWith("+82"))
    {
      AppMethodBeat.o(59960);
      return "ko";
    }
    if (paramString.startsWith("+66"))
    {
      AppMethodBeat.o(59960);
      return "th";
    }
    if (paramString.startsWith("+84"))
    {
      AppMethodBeat.o(59960);
      return "vi";
    }
    if (paramString.startsWith("+62"))
    {
      AppMethodBeat.o(59960);
      return "id";
    }
    if (paramString.startsWith("+55"))
    {
      AppMethodBeat.o(59960);
      return "pt";
    }
    if (paramString.startsWith("+34"))
    {
      AppMethodBeat.o(59960);
      return "es-419";
    }
    AppMethodBeat.o(59960);
    return "en";
  }
  
  public static boolean tM(String paramString)
  {
    AppMethodBeat.i(59963);
    if ((!bo.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(59963);
      return true;
    }
    AppMethodBeat.o(59963);
    return false;
  }
  
  public static boolean tN(String paramString)
  {
    AppMethodBeat.i(59964);
    if ((!bo.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(paramString)))
    {
      AppMethodBeat.o(59964);
      return true;
    }
    AppMethodBeat.o(59964);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.au.b
 * JD-Core Version:    0.7.0.1
 */