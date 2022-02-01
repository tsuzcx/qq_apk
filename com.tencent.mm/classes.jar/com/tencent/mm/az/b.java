package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
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
  private static Map<String, a> lSu = null;
  private static Map<String, String> lSv = null;
  private static String lSw = null;
  
  private static void WB(String paramString)
  {
    AppMethodBeat.i(43013);
    lSu = new HashMap();
    lSv = new HashMap();
    String[] arrayOfString1 = Util.nullAsNil(paramString).trim().split(",");
    int i = 0;
    Object localObject;
    while (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      if (arrayOfString2.length < 4)
      {
        Log.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", new Object[] { arrayOfString1[i].trim() });
        i += 1;
      }
      else
      {
        RegionCodeDecoder.hAC();
        localObject = RegionCodeDecoder.getLocName(arrayOfString2[0]);
        paramString = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString = arrayOfString2[2];
        }
        if (!LocaleUtil.isTraditionalChineseAppLang()) {}
        for (paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], arrayOfString2[3].charAt(0));; paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], a.WA(paramString)))
        {
          lSu.put(paramString.lSx + paramString.lSy, paramString);
          lSv.put(paramString.lSx, paramString.lSy);
          break;
        }
      }
    }
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      paramString = (a)lSu.get("US" + "1");
      localObject = new HashMap();
      lSu = (Map)localObject;
      ((Map)localObject).put("US" + "1", paramString);
      localObject = new HashMap();
      lSv = (Map)localObject;
      ((Map)localObject).put(paramString.lSx, paramString.lSy);
    }
    AppMethodBeat.o(43013);
  }
  
  public static List<a> WC(String paramString)
  {
    localObject1 = null;
    AppMethodBeat.i(43015);
    try
    {
      String str = LocaleUtil.getApplicationLanguage();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(lSw)) {}
      }
      else
      {
        localObject1 = str;
        lSu = null;
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
    if (lSu == null)
    {
      lSw = (String)localObject2;
      WB(paramString);
    }
    paramString = new ArrayList(lSu.values());
    AppMethodBeat.o(43015);
    return paramString;
  }
  
  public static boolean WD(String paramString)
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
  
  public static String WE(String paramString)
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
  
  public static boolean WF(String paramString)
  {
    AppMethodBeat.i(43020);
    if ((!Util.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("AT,BE,BG,CY,CZ,HR,DK,EE,FI,FR,DE,GR,HU,IE,IT,LV,RO,LT,LU,MT,NL,PL,PT,SK,SI,ES,SE,GB,IS,LI,NO,CH,TR".split(","))).contains(paramString.toUpperCase())))
    {
      AppMethodBeat.o(43020);
      return true;
    }
    AppMethodBeat.o(43020);
    return false;
  }
  
  public static boolean WG(String paramString)
  {
    AppMethodBeat.i(43021);
    if ((!Util.isNullOrNil(paramString)) && (new HashSet(Arrays.asList("43,32,359,357,420,385,45,372,358,33,49,30,36,353,39,371,40,370,352,356,31,48,351,421,386,34,46,44,354,423,47,41,90".split(","))).contains(paramString)))
    {
      AppMethodBeat.o(43021);
      return true;
    }
    AppMethodBeat.o(43021);
    return false;
  }
  
  public static boolean bmW()
  {
    AppMethodBeat.i(43008);
    if ((!LocaleUtil.isChineseAppLang()) && (!LocaleUtil.getApplicationLanguage().equals("en")))
    {
      AppMethodBeat.o(43008);
      return true;
    }
    AppMethodBeat.o(43008);
    return false;
  }
  
  public static boolean bmX()
  {
    AppMethodBeat.i(292573);
    if ((Util.isOverseasUser(MMApplicationContext.getContext())) && (WeChatBrands.AppInfo.current().isMainland()))
    {
      AppMethodBeat.o(292573);
      return true;
    }
    AppMethodBeat.o(292573);
    return false;
  }
  
  public static boolean bmY()
  {
    AppMethodBeat.i(43010);
    if ((z.bcY() == 0) && (Util.isOverseasUser(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(43010);
      return false;
    }
    AppMethodBeat.o(43010);
    return true;
  }
  
  public static boolean bmZ()
  {
    return false;
  }
  
  public static boolean bna()
  {
    AppMethodBeat.i(43011);
    if (!LocaleUtil.getApplicationLanguage().equals("zh_CN"))
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
  
  public static a bw(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43014);
    try
    {
      String str = LocaleUtil.getApplicationLanguage();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(lSw)) {}
      }
      else
      {
        localObject1 = str;
        lSu = null;
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
    if ((lSu == null) || (lSv == null))
    {
      lSw = (String)localObject2;
      WB(paramString2);
    }
    paramString1 = (a)lSu.get(paramString1.toUpperCase() + (String)lSv.get(paramString1.toUpperCase()));
    if (WeChatSomeFeatureSwitch.onlyUSMobile()) {
      paramString1 = (a)lSu.get("US" + (String)lSv.get("US"));
    }
    AppMethodBeat.o(43014);
    return paramString1;
  }
  
  public static String bx(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43018);
    try
    {
      String str = LocaleUtil.getApplicationLanguage();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(lSw)) {}
      }
      else
      {
        localObject1 = str;
        lSu = null;
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
    if (lSu == null)
    {
      lSw = (String)localObject2;
      WB(paramString2);
    }
    paramString2 = lSu.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).lSy.equals(paramString1))
      {
        paramString1 = ((a)localObject1).lSz;
        AppMethodBeat.o(43018);
        return paramString1;
      }
    }
    AppMethodBeat.o(43018);
    return "";
  }
  
  public static String by(String paramString1, String paramString2)
  {
    localObject1 = null;
    AppMethodBeat.i(43019);
    try
    {
      String str = LocaleUtil.getApplicationLanguage();
      if (str != null)
      {
        localObject2 = str;
        localObject1 = str;
        if (str.equals(lSw)) {}
      }
      else
      {
        localObject1 = str;
        lSu = null;
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
    if (lSu == null)
    {
      lSw = (String)localObject2;
      WB(paramString2);
    }
    paramString2 = lSu.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).lSy.equals(paramString1))
      {
        paramString1 = ((a)localObject1).lSx;
        AppMethodBeat.o(43019);
        return paramString1;
      }
    }
    AppMethodBeat.o(43019);
    return "";
  }
  
  public static boolean isOverseasUser()
  {
    AppMethodBeat.i(292928);
    boolean bool = Util.isOverseasUser(MMApplicationContext.getContext());
    AppMethodBeat.o(292928);
    return bool;
  }
  
  public static final class a
  {
    public String lSA;
    public int lSB;
    public String lSx;
    public String lSy;
    public String lSz;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.lSx = paramString1;
      this.lSy = paramString2;
      this.lSz = paramString3;
      this.lSA = paramString4;
      this.lSB = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.az.b
 * JD-Core Version:    0.7.0.1
 */