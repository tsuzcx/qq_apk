package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static Map<String, a> hkJ = null;
  private static Map<String, String> hkK = null;
  private static String hkL = null;
  
  public static boolean azj()
  {
    AppMethodBeat.i(43008);
    if ((!ac.eFq()) && (!ac.eFu().equals("en")))
    {
      AppMethodBeat.o(43008);
      return true;
    }
    AppMethodBeat.o(43008);
    return false;
  }
  
  public static boolean azk()
  {
    AppMethodBeat.i(43009);
    boolean bool = bt.iP(aj.getContext());
    AppMethodBeat.o(43009);
    return bool;
  }
  
  public static boolean azl()
  {
    AppMethodBeat.i(43010);
    if ((u.aqF() == 0) && (bt.iP(aj.getContext())))
    {
      AppMethodBeat.o(43010);
      return false;
    }
    AppMethodBeat.o(43010);
    return true;
  }
  
  public static boolean azm()
  {
    return false;
  }
  
  public static boolean azn()
  {
    AppMethodBeat.i(43011);
    if (!ac.eFu().equals("zh_CN"))
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
  
  public static boolean azo()
  {
    AppMethodBeat.i(197134);
    boolean bool = bt.iP(aj.getContext());
    AppMethodBeat.o(197134);
    return bool;
  }
  
  public static a bh(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43014);
    try
    {
      String str = ac.eFu();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(hkL)) {}
      }
      else
      {
        localObject1 = str;
        hkJ = null;
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
    if ((hkJ == null) || (hkK == null))
    {
      hkL = (String)localObject2;
      yH(paramString2);
    }
    paramString1 = (a)hkJ.get(paramString1.toUpperCase() + (String)hkK.get(paramString1.toUpperCase()));
    AppMethodBeat.o(43014);
    return paramString1;
  }
  
  public static String bi(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43018);
    try
    {
      String str = ac.eFu();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(hkL)) {}
      }
      else
      {
        localObject1 = str;
        hkJ = null;
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
    if (hkJ == null)
    {
      hkL = (String)localObject2;
      yH(paramString2);
    }
    paramString2 = hkJ.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).hkN.equals(paramString1))
      {
        paramString1 = ((a)localObject1).hkO;
        AppMethodBeat.o(43018);
        return paramString1;
      }
    }
    AppMethodBeat.o(43018);
    return "";
  }
  
  public static String bj(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43019);
    try
    {
      String str = ac.eFu();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(hkL)) {}
      }
      else
      {
        localObject1 = str;
        hkJ = null;
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
    if (hkJ == null)
    {
      hkL = (String)localObject2;
      yH(paramString2);
    }
    paramString2 = hkJ.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).hkN.equals(paramString1))
      {
        paramString1 = ((a)localObject1).hkM;
        AppMethodBeat.o(43019);
        return paramString1;
      }
    }
    AppMethodBeat.o(43019);
    return "";
  }
  
  private static void yH(String paramString)
  {
    AppMethodBeat.i(43013);
    hkJ = new HashMap();
    hkK = new HashMap();
    String[] arrayOfString1 = bt.nullAsNil(paramString).trim().split(",");
    int i = 0;
    while (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      if (arrayOfString2.length < 4)
      {
        ad.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", new Object[] { arrayOfString1[i].trim() });
        i += 1;
      }
      else
      {
        RegionCodeDecoder.eMO();
        String str = RegionCodeDecoder.getLocName(arrayOfString2[0]);
        paramString = str;
        if (bt.isNullOrNil(str)) {
          paramString = arrayOfString2[2];
        }
        if (!ac.eFs()) {}
        for (paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], arrayOfString2[3].charAt(0));; paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], a.yG(paramString)))
        {
          hkJ.put(paramString.hkM + paramString.hkN, paramString);
          hkK.put(paramString.hkM, paramString.hkN);
          break;
        }
      }
    }
    AppMethodBeat.o(43013);
  }
  
  public static List<a> yI(String paramString)
  {
    localObject1 = null;
    AppMethodBeat.i(43015);
    try
    {
      String str = ac.eFu();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(hkL)) {}
      }
      else
      {
        localObject1 = str;
        hkJ = null;
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
    if (hkJ == null)
    {
      hkL = (String)localObject2;
      yH(paramString);
    }
    paramString = new ArrayList(hkJ.values());
    AppMethodBeat.o(43015);
    return paramString;
  }
  
  public static boolean yJ(String paramString)
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
  
  public static String yK(String paramString)
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
  
  public static boolean yL(String paramString)
  {
    AppMethodBeat.i(43020);
    if ((!bt.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(43020);
      return true;
    }
    AppMethodBeat.o(43020);
    return false;
  }
  
  public static boolean yM(String paramString)
  {
    AppMethodBeat.i(43021);
    if ((!bt.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(paramString)))
    {
      AppMethodBeat.o(43021);
      return true;
    }
    AppMethodBeat.o(43021);
    return false;
  }
  
  public static final class a
  {
    public String hkM;
    public String hkN;
    public String hkO;
    public String hkP;
    public int hkQ;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.hkM = paramString1;
      this.hkN = paramString2;
      this.hkO = paramString3;
      this.hkP = paramString4;
      this.hkQ = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ax.b
 * JD-Core Version:    0.7.0.1
 */