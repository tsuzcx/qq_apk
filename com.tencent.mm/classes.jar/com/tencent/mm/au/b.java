package com.tencent.mm.au;

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
  private static Map<String, a> oLg = null;
  private static Map<String, String> oLh = null;
  private static String oLi = null;
  
  private static void OA(String paramString)
  {
    AppMethodBeat.i(43013);
    oLg = new HashMap();
    oLh = new HashMap();
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
        RegionCodeDecoder.jcF();
        localObject = RegionCodeDecoder.getLocName(arrayOfString2[0]);
        paramString = (String)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramString = arrayOfString2[2];
        }
        if (!LocaleUtil.isTraditionalChineseAppLang()) {}
        for (paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], arrayOfString2[3].charAt(0));; paramString = new a(arrayOfString2[0], arrayOfString2[1], paramString, arrayOfString2[3], a.Oz(paramString)))
        {
          oLg.put(paramString.oLj + paramString.oLk, paramString);
          oLh.put(paramString.oLj, paramString.oLk);
          break;
        }
      }
    }
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      paramString = (a)oLg.get("US" + "1");
      localObject = new HashMap();
      oLg = (Map)localObject;
      ((Map)localObject).put("US" + "1", paramString);
      localObject = new HashMap();
      oLh = (Map)localObject;
      ((Map)localObject).put(paramString.oLj, paramString.oLk);
    }
    AppMethodBeat.o(43013);
  }
  
  public static List<a> OB(String paramString)
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
        if (str.equals(oLi)) {}
      }
      else
      {
        localObject1 = str;
        oLg = null;
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
    if (oLg == null)
    {
      oLi = (String)localObject2;
      OA(paramString);
    }
    paramString = new ArrayList(oLg.values());
    AppMethodBeat.o(43015);
    return paramString;
  }
  
  public static boolean OC(String paramString)
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
  
  public static String OD(String paramString)
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
  
  public static boolean OE(String paramString)
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
  
  public static boolean OF(String paramString)
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
  
  public static a bH(String paramString1, String paramString2)
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
        if (str.equals(oLi)) {}
      }
      else
      {
        localObject1 = str;
        oLg = null;
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
    if ((oLg == null) || (oLh == null))
    {
      oLi = (String)localObject2;
      OA(paramString2);
    }
    paramString1 = (a)oLg.get(paramString1.toUpperCase() + (String)oLh.get(paramString1.toUpperCase()));
    if (WeChatSomeFeatureSwitch.onlyUSMobile()) {
      paramString1 = (a)oLg.get("US" + (String)oLh.get("US"));
    }
    AppMethodBeat.o(43014);
    return paramString1;
  }
  
  public static String bI(String paramString1, String paramString2)
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
        if (str.equals(oLi)) {}
      }
      else
      {
        localObject1 = str;
        oLg = null;
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
    if (oLg == null)
    {
      oLi = (String)localObject2;
      OA(paramString2);
    }
    paramString2 = oLg.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).oLk.equals(paramString1))
      {
        paramString1 = ((a)localObject1).oLl;
        AppMethodBeat.o(43018);
        return paramString1;
      }
    }
    AppMethodBeat.o(43018);
    return "";
  }
  
  public static String bJ(String paramString1, String paramString2)
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
        if (str.equals(oLi)) {}
      }
      else
      {
        localObject1 = str;
        oLg = null;
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
    if (oLg == null)
    {
      oLi = (String)localObject2;
      OA(paramString2);
    }
    paramString2 = oLg.values().iterator();
    while (paramString2.hasNext())
    {
      localObject1 = (a)paramString2.next();
      if (((a)localObject1).oLk.equals(paramString1))
      {
        paramString1 = ((a)localObject1).oLj;
        AppMethodBeat.o(43019);
        return paramString1;
      }
    }
    AppMethodBeat.o(43019);
    return "";
  }
  
  public static boolean bKI()
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
  
  public static boolean bKJ()
  {
    AppMethodBeat.i(231018);
    if ((Util.isOverseasUser(MMApplicationContext.getContext())) && (WeChatBrands.AppInfo.current().isMainland()))
    {
      AppMethodBeat.o(231018);
      return true;
    }
    AppMethodBeat.o(231018);
    return false;
  }
  
  public static boolean bKK()
  {
    AppMethodBeat.i(43010);
    if ((z.bAL() == 0) && (Util.isOverseasUser(MMApplicationContext.getContext())))
    {
      AppMethodBeat.o(43010);
      return false;
    }
    AppMethodBeat.o(43010);
    return true;
  }
  
  public static boolean bKL()
  {
    return false;
  }
  
  public static boolean bKM()
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
  
  public static boolean isOverseasUser()
  {
    AppMethodBeat.i(369544);
    boolean bool = Util.isOverseasUser(MMApplicationContext.getContext());
    AppMethodBeat.o(369544);
    return bool;
  }
  
  public static final class a
  {
    public String oLj;
    public String oLk;
    public String oLl;
    public String oLm;
    public int oLn;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
    {
      this.oLj = paramString1;
      this.oLk = paramString2;
      this.oLl = paramString3;
      this.oLm = paramString4;
      this.oLn = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.au.b
 * JD-Core Version:    0.7.0.1
 */