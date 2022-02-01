package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static Map<String, a> igZ = null;
  private static Map<String, String> iha = null;
  private static String ihb = null;
  
  private static void Gs(String paramString)
  {
    AppMethodBeat.i(43013);
    igZ = new HashMap();
    iha = new HashMap();
    String[] arrayOfString1 = bu.nullAsNil(paramString).trim().split(",");
    int i = 0;
    while (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      if (arrayOfString2.length < 4)
      {
        ae.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", new Object[] { arrayOfString1[i].trim() });
        i += 1;
      }
      else
      {
        RegionCodeDecoder.fwA();
        String str = RegionCodeDecoder.getLocName(arrayOfString2[0]);
        paramString = str;
        if (bu.isNullOrNil(str)) {
          paramString = arrayOfString2[2];
        }
        if (!ad.fok()) {}
        for (paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], arrayOfString2[3].charAt(0));; paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], a.Gr(paramString)))
        {
          igZ.put(paramString.ihc + paramString.ihd, paramString);
          iha.put(paramString.ihc, paramString.ihd);
          break;
        }
      }
    }
    AppMethodBeat.o(43013);
  }
  
  public static List<a> Gt(String paramString)
  {
    localObject1 = null;
    AppMethodBeat.i(43015);
    try
    {
      String str = ad.fom();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(ihb)) {}
      }
      else
      {
        localObject1 = str;
        igZ = null;
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
    if (igZ == null)
    {
      ihb = (String)localObject2;
      Gs(paramString);
    }
    paramString = new ArrayList(igZ.values());
    AppMethodBeat.o(43015);
    return paramString;
  }
  
  public static boolean Gu(String paramString)
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
  
  public static String Gv(String paramString)
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
  
  public static boolean Gw(String paramString)
  {
    AppMethodBeat.i(43020);
    if ((!bu.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(43020);
      return true;
    }
    AppMethodBeat.o(43020);
    return false;
  }
  
  public static boolean Gx(String paramString)
  {
    AppMethodBeat.i(43021);
    if ((!bu.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(paramString)))
    {
      AppMethodBeat.o(43021);
      return true;
    }
    AppMethodBeat.o(43021);
    return false;
  }
  
  public static boolean aJB()
  {
    AppMethodBeat.i(43008);
    if ((!ad.foi()) && (!ad.fom().equals("en")))
    {
      AppMethodBeat.o(43008);
      return true;
    }
    AppMethodBeat.o(43008);
    return false;
  }
  
  public static boolean aJC()
  {
    AppMethodBeat.i(213417);
    boolean bool = bu.jq(ak.getContext());
    AppMethodBeat.o(213417);
    return bool;
  }
  
  public static boolean aJD()
  {
    AppMethodBeat.i(43010);
    if ((v.aAB() == 0) && (bu.jq(ak.getContext())))
    {
      AppMethodBeat.o(43010);
      return false;
    }
    AppMethodBeat.o(43010);
    return true;
  }
  
  public static boolean aJE()
  {
    return false;
  }
  
  public static boolean aJF()
  {
    AppMethodBeat.i(43011);
    if (!ad.fom().equals("zh_CN"))
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
  
  public static boolean aJG()
  {
    AppMethodBeat.i(224499);
    boolean bool = bu.jq(ak.getContext());
    AppMethodBeat.o(224499);
    return bool;
  }
  
  public static a bq(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43014);
    try
    {
      String str = ad.fom();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(ihb)) {}
      }
      else
      {
        localObject1 = str;
        igZ = null;
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
    if ((igZ == null) || (iha == null))
    {
      ihb = (String)localObject2;
      Gs(paramString2);
    }
    paramString1 = (a)igZ.get(paramString1.toUpperCase() + (String)iha.get(paramString1.toUpperCase()));
    AppMethodBeat.o(43014);
    return paramString1;
  }
  
  public static String br(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43018);
    try
    {
      String str = ad.fom();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(ihb)) {}
      }
      else
      {
        localObject1 = str;
        igZ = null;
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
    if (igZ == null)
    {
      ihb = (String)localObject2;
      Gs(paramString2);
    }
    paramString2 = igZ.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).ihd.equals(paramString1))
      {
        paramString1 = ((a)localObject1).ihe;
        AppMethodBeat.o(43018);
        return paramString1;
      }
    }
    AppMethodBeat.o(43018);
    return "";
  }
  
  public static String bs(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43019);
    try
    {
      String str = ad.fom();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(ihb)) {}
      }
      else
      {
        localObject1 = str;
        igZ = null;
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
    if (igZ == null)
    {
      ihb = (String)localObject2;
      Gs(paramString2);
    }
    paramString2 = igZ.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).ihd.equals(paramString1))
      {
        paramString1 = ((a)localObject1).ihc;
        AppMethodBeat.o(43019);
        return paramString1;
      }
    }
    AppMethodBeat.o(43019);
    return "";
  }
  
  public static final class a
  {
    public String ihc;
    public String ihd;
    public String ihe;
    public String ihf;
    public int ihg;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.ihc = paramString1;
      this.ihd = paramString2;
      this.ihe = paramString3;
      this.ihf = paramString4;
      this.ihg = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.b
 * JD-Core Version:    0.7.0.1
 */