package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public final class b
{
  private static Map<String, a> hLm = null;
  private static Map<String, String> hLn = null;
  private static String hLo = null;
  
  private static void CM(String paramString)
  {
    AppMethodBeat.i(43013);
    hLm = new HashMap();
    hLn = new HashMap();
    String[] arrayOfString1 = bs.nullAsNil(paramString).trim().split(",");
    int i = 0;
    while (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      if (arrayOfString2.length < 4)
      {
        ac.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", new Object[] { arrayOfString1[i].trim() });
        i += 1;
      }
      else
      {
        RegionCodeDecoder.fcs();
        String str = RegionCodeDecoder.getLocName(arrayOfString2[0]);
        paramString = str;
        if (bs.isNullOrNil(str)) {
          paramString = arrayOfString2[2];
        }
        if (!ab.eUM()) {}
        for (paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], arrayOfString2[3].charAt(0));; paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], a.CL(paramString)))
        {
          hLm.put(paramString.hLp + paramString.hLq, paramString);
          hLn.put(paramString.hLp, paramString.hLq);
          break;
        }
      }
    }
    AppMethodBeat.o(43013);
  }
  
  public static List<a> CN(String paramString)
  {
    localObject1 = null;
    AppMethodBeat.i(43015);
    try
    {
      String str = ab.eUO();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(hLo)) {}
      }
      else
      {
        localObject1 = str;
        hLm = null;
        localObject2 = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject1;
      }
    }
    if (hLm == null)
    {
      hLo = (String)localObject2;
      CM(paramString);
    }
    paramString = new ArrayList(hLm.values());
    AppMethodBeat.o(43015);
    return paramString;
  }
  
  public static boolean CO(String paramString)
  {
    AppMethodBeat.i(43016);
    if ((paramString != null) && (paramString.length() > 1) && (paramString.startsWith("+")) && (!paramString.startsWith("+86")))
    {
      AppMethodBeat.o(43016);
      return true;
    }
    AppMethodBeat.o(43016);
    return false;
  }
  
  public static String CP(String paramString)
  {
    AppMethodBeat.i(43017);
    if ((paramString.startsWith("+886")) || (paramString.startsWith("+86")))
    {
      AppMethodBeat.o(43017);
      return "zh-TW";
    }
    if ((paramString.startsWith("+852")) || (paramString.startsWith("+853")))
    {
      AppMethodBeat.o(43017);
      return "zh-HK";
    }
    if (paramString.startsWith("+81"))
    {
      AppMethodBeat.o(43017);
      return "ja";
    }
    if (paramString.startsWith("+82"))
    {
      AppMethodBeat.o(43017);
      return "ko";
    }
    if (paramString.startsWith("+66"))
    {
      AppMethodBeat.o(43017);
      return "th";
    }
    if (paramString.startsWith("+84"))
    {
      AppMethodBeat.o(43017);
      return "vi";
    }
    if (paramString.startsWith("+62"))
    {
      AppMethodBeat.o(43017);
      return "id";
    }
    if (paramString.startsWith("+55"))
    {
      AppMethodBeat.o(43017);
      return "pt";
    }
    if (paramString.startsWith("+34"))
    {
      AppMethodBeat.o(43017);
      return "es-419";
    }
    AppMethodBeat.o(43017);
    return "en";
  }
  
  public static boolean CQ(String paramString)
  {
    AppMethodBeat.i(43020);
    if ((!bs.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(43020);
      return true;
    }
    AppMethodBeat.o(43020);
    return false;
  }
  
  public static boolean CR(String paramString)
  {
    AppMethodBeat.i(43021);
    if ((!bs.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(paramString)))
    {
      AppMethodBeat.o(43021);
      return true;
    }
    AppMethodBeat.o(43021);
    return false;
  }
  
  public static boolean aGa()
  {
    AppMethodBeat.i(43008);
    if ((!ab.eUK()) && (!ab.eUO().equals("en")))
    {
      AppMethodBeat.o(43008);
      return true;
    }
    AppMethodBeat.o(43008);
    return false;
  }
  
  public static boolean aGb()
  {
    AppMethodBeat.i(194040);
    boolean bool = bs.ja(ai.getContext());
    AppMethodBeat.o(194040);
    return bool;
  }
  
  public static boolean aGc()
  {
    AppMethodBeat.i(43010);
    if ((u.axv() == 0) && (bs.ja(ai.getContext())))
    {
      AppMethodBeat.o(43010);
      return false;
    }
    AppMethodBeat.o(43010);
    return true;
  }
  
  public static boolean aGd()
  {
    return false;
  }
  
  public static boolean aGe()
  {
    AppMethodBeat.i(43011);
    if (!ab.eUO().equals("zh_CN"))
    {
      AppMethodBeat.o(43011);
      return true;
    }
    TimeZone localTimeZone1 = TimeZone.getDefault();
    TimeZone localTimeZone2 = TimeZone.getTimeZone("GMT+08:00");
    if (localTimeZone1.getRawOffset() != localTimeZone2.getRawOffset())
    {
      AppMethodBeat.o(43011);
      return true;
    }
    AppMethodBeat.o(43011);
    return false;
  }
  
  public static boolean aGf()
  {
    AppMethodBeat.i(210243);
    boolean bool = bs.ja(ai.getContext());
    AppMethodBeat.o(210243);
    return bool;
  }
  
  public static a bp(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43014);
    try
    {
      String str = ab.eUO();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(hLo)) {}
      }
      else
      {
        localObject1 = str;
        hLm = null;
        localObject2 = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject1;
      }
    }
    if ((hLm == null) || (hLn == null))
    {
      hLo = (String)localObject2;
      CM(paramString2);
    }
    paramString1 = (a)hLm.get(paramString1.toUpperCase() + (String)hLn.get(paramString1.toUpperCase()));
    AppMethodBeat.o(43014);
    return paramString1;
  }
  
  public static String bq(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43018);
    try
    {
      String str = ab.eUO();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(hLo)) {}
      }
      else
      {
        localObject1 = str;
        hLm = null;
        localObject2 = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject1;
      }
    }
    if (hLm == null)
    {
      hLo = (String)localObject2;
      CM(paramString2);
    }
    paramString2 = hLm.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).hLq.equals(paramString1))
      {
        paramString1 = ((a)localObject1).hLr;
        AppMethodBeat.o(43018);
        return paramString1;
      }
    }
    AppMethodBeat.o(43018);
    return "";
  }
  
  public static String br(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43019);
    try
    {
      String str = ab.eUO();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(hLo)) {}
      }
      else
      {
        localObject1 = str;
        hLm = null;
        localObject2 = str;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject1;
      }
    }
    if (hLm == null)
    {
      hLo = (String)localObject2;
      CM(paramString2);
    }
    paramString2 = hLm.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).hLq.equals(paramString1))
      {
        paramString1 = ((a)localObject1).hLp;
        AppMethodBeat.o(43019);
        return paramString1;
      }
    }
    AppMethodBeat.o(43019);
    return "";
  }
  
  public static final class a
  {
    public String hLp;
    public String hLq;
    public String hLr;
    public String hLs;
    public int hLt;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.hLp = paramString1;
      this.hLq = paramString2;
      this.hLr = paramString3;
      this.hLs = paramString4;
      this.hLt = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.b
 * JD-Core Version:    0.7.0.1
 */