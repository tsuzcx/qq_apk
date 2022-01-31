package com.tencent.mm.at;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
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
  private static Map<String, b.a> esb = null;
  private static Map<String, String> esc = null;
  private static String esd = null;
  
  public static List<b.a> C(Context paramContext, String paramString)
  {
    localContext1 = null;
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (paramContext != null)
      {
        localContext2 = paramContext;
        localContext1 = paramContext;
        if (paramContext.equals(esd)) {}
      }
      else
      {
        localContext1 = paramContext;
        esb = null;
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
    if (esb == null)
    {
      esd = localContext2;
      mz(paramString);
    }
    return new ArrayList(esb.values());
  }
  
  public static boolean Pb()
  {
    return (!x.cqF()) && (!x.cqJ().equals("en"));
  }
  
  public static boolean Pc()
  {
    return bk.fV(ae.getContext());
  }
  
  public static boolean Pd()
  {
    return (q.Gi() != 0) || (!bk.fV(ae.getContext()));
  }
  
  public static boolean Pe()
  {
    if (!x.cqJ().equals("zh_CN")) {}
    TimeZone localTimeZone1;
    TimeZone localTimeZone2;
    do
    {
      return true;
      localTimeZone1 = TimeZone.getDefault();
      localTimeZone2 = TimeZone.getTimeZone("GMT+08:00");
    } while (localTimeZone1.getRawOffset() != localTimeZone2.getRawOffset());
    return false;
  }
  
  public static boolean Pf()
  {
    return bk.fV(ae.getContext());
  }
  
  public static b.a i(Context paramContext, String paramString1, String paramString2)
  {
    localContext1 = null;
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (paramContext != null)
      {
        localContext2 = paramContext;
        localContext1 = paramContext;
        if (paramContext.equals(esd)) {}
      }
      else
      {
        localContext1 = paramContext;
        esb = null;
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
    if ((esb == null) || (esc == null))
    {
      esd = localContext2;
      mz(paramString2);
    }
    return (b.a)esb.get(paramString1.toUpperCase() + (String)esc.get(paramString1.toUpperCase()));
  }
  
  public static String j(Context paramContext, String paramString1, String paramString2)
  {
    localContext1 = null;
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (paramContext != null)
      {
        localContext2 = paramContext;
        localContext1 = paramContext;
        if (paramContext.equals(esd)) {}
      }
      else
      {
        localContext1 = paramContext;
        esb = null;
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
    if (esb == null)
    {
      esd = localContext2;
      mz(paramString2);
    }
    paramContext = esb.values().iterator();
    while (paramContext.hasNext())
    {
      paramString2 = (b.a)paramContext.next();
      if (paramString2.esf.equals(paramString1)) {
        return paramString2.esg;
      }
    }
    return "";
  }
  
  public static String k(Context paramContext, String paramString1, String paramString2)
  {
    localContext1 = null;
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      if (paramContext != null)
      {
        localContext2 = paramContext;
        localContext1 = paramContext;
        if (paramContext.equals(esd)) {}
      }
      else
      {
        localContext1 = paramContext;
        esb = null;
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
    if (esb == null)
    {
      esd = localContext2;
      mz(paramString2);
    }
    paramContext = esb.values().iterator();
    while (paramContext.hasNext())
    {
      paramString2 = (b.a)paramContext.next();
      if (paramString2.esf.equals(paramString1)) {
        return paramString2.ese;
      }
    }
    return "";
  }
  
  public static boolean mA(String paramString)
  {
    return (paramString != null) && (paramString.length() > 1) && (paramString.startsWith("+")) && (!paramString.startsWith("+86"));
  }
  
  public static String mB(String paramString)
  {
    if ((paramString.startsWith("+886")) || (paramString.startsWith("+86"))) {
      return "zh-TW";
    }
    if ((paramString.startsWith("+852")) || (paramString.startsWith("+853"))) {
      return "zh-HK";
    }
    if (paramString.startsWith("+81")) {
      return "ja";
    }
    if (paramString.startsWith("+82")) {
      return "ko";
    }
    if (paramString.startsWith("+66")) {
      return "th";
    }
    if (paramString.startsWith("+84")) {
      return "vi";
    }
    if (paramString.startsWith("+62")) {
      return "id";
    }
    if (paramString.startsWith("+55")) {
      return "pt";
    }
    if (paramString.startsWith("+34")) {
      return "es-419";
    }
    return "en";
  }
  
  public static boolean mC(String paramString)
  {
    return (!bk.bl(paramString)) && (new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(paramString));
  }
  
  public static boolean mD(String paramString)
  {
    return (!bk.bl(paramString)) && (new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(paramString));
  }
  
  private static void mz(String paramString)
  {
    esb = new HashMap();
    esc = new HashMap();
    String[] arrayOfString = bk.pm(paramString).trim().split(",");
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString = arrayOfString[i].trim().split(":");
      if (paramString.length < 4)
      {
        y.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", paramString);
        i += 1;
      }
      else
      {
        if (!x.cqH()) {}
        for (paramString = new b.a(paramString[0], paramString[1], paramString[2], paramString[3], paramString[3].charAt(0));; paramString = new b.a(paramString[0], paramString[1], paramString[2], paramString[3], a.my(paramString[2])))
        {
          esb.put(paramString.ese + paramString.esf, paramString);
          esc.put(paramString.ese, paramString.esf);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.b
 * JD-Core Version:    0.7.0.1
 */