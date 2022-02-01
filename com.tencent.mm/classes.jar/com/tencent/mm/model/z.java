package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.contact.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ci;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class z
{
  private static int iCB = -1;
  
  public static boolean Im(String paramString)
  {
    AppMethodBeat.i(42789);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42789);
      return false;
    }
    String str = aTY();
    if ((str == null) || (str.length() <= 0))
    {
      Log.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
      AppMethodBeat.o(42789);
      return false;
    }
    boolean bool = str.equals(paramString);
    AppMethodBeat.o(42789);
    return bool;
  }
  
  public static boolean In(String paramString)
  {
    AppMethodBeat.i(225915);
    boolean bool = aUg().equals(paramString);
    AppMethodBeat.o(225915);
    return bool;
  }
  
  public static k.b Io(String paramString)
  {
    AppMethodBeat.i(225923);
    paramString = new k(paramString);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(paramString);
    AppMethodBeat.o(225923);
    return paramString;
  }
  
  public static String Ip(String paramString)
  {
    AppMethodBeat.i(225925);
    HashMap localHashMap = new HashMap();
    z(localHashMap);
    if (localHashMap.containsKey(paramString))
    {
      paramString = (String)localHashMap.get(paramString);
      AppMethodBeat.o(225925);
      return paramString;
    }
    AppMethodBeat.o(225925);
    return null;
  }
  
  public static void aH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225924);
    HashMap localHashMap = new HashMap();
    z(localHashMap);
    localHashMap.put(paramString1, paramString2);
    y(localHashMap);
    AppMethodBeat.o(225924);
  }
  
  public static int aTX()
  {
    AppMethodBeat.i(42790);
    g.aAi();
    Integer localInteger = (Integer)g.aAh().azQ().get(9, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42790);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42790);
    return i;
  }
  
  public static String aTY()
  {
    AppMethodBeat.i(42792);
    g.aAi();
    String str = (String)g.aAh().azQ().get(2, null);
    AppMethodBeat.o(42792);
    return str;
  }
  
  public static String aTZ()
  {
    AppMethodBeat.i(42793);
    g.aAi();
    String str = (String)g.aAh().azQ().get(42, null);
    AppMethodBeat.o(42793);
    return str;
  }
  
  public static boolean aUA()
  {
    AppMethodBeat.i(42815);
    if ((aUl() & 0x80000) == 0)
    {
      AppMethodBeat.o(42815);
      return true;
    }
    AppMethodBeat.o(42815);
    return false;
  }
  
  public static boolean aUB()
  {
    AppMethodBeat.i(42816);
    if ((aUl() & 0x40000) == 0)
    {
      AppMethodBeat.o(42816);
      return true;
    }
    AppMethodBeat.o(42816);
    return false;
  }
  
  public static boolean aUC()
  {
    AppMethodBeat.i(42817);
    if ((aUl() & 0x2000) == 0)
    {
      AppMethodBeat.o(42817);
      return true;
    }
    AppMethodBeat.o(42817);
    return false;
  }
  
  public static boolean aUD()
  {
    AppMethodBeat.i(42818);
    if ((aUl() & 0x10000) == 0)
    {
      AppMethodBeat.o(42818);
      return true;
    }
    AppMethodBeat.o(42818);
    return false;
  }
  
  public static boolean aUE()
  {
    AppMethodBeat.i(42819);
    if ((aUl() & 0x8000000) == 0)
    {
      AppMethodBeat.o(42819);
      return true;
    }
    AppMethodBeat.o(42819);
    return false;
  }
  
  public static boolean aUF()
  {
    AppMethodBeat.i(42820);
    g.aAi();
    String str = (String)g.aAh().azQ().get(65825, null);
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(42820);
      return false;
    }
    if (str.equals("0"))
    {
      AppMethodBeat.o(42820);
      return false;
    }
    try
    {
      long l = Util.nullAsNil(Long.valueOf(Util.getLong(str, 0L)));
      if (l == 0L)
      {
        AppMethodBeat.o(42820);
        return false;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(42820);
      return false;
    }
    AppMethodBeat.o(42820);
    return true;
  }
  
  public static boolean aUG()
  {
    AppMethodBeat.i(225920);
    g.aAi();
    if (Util.nullAsNil((Integer)g.aAh().azQ().get(17, null)) == 1)
    {
      AppMethodBeat.o(225920);
      return true;
    }
    AppMethodBeat.o(225920);
    return false;
  }
  
  public static boolean aUH()
  {
    AppMethodBeat.i(42821);
    if ((aUl() & 0x1) == 0)
    {
      AppMethodBeat.o(42821);
      return true;
    }
    AppMethodBeat.o(42821);
    return false;
  }
  
  public static boolean aUI()
  {
    AppMethodBeat.i(42822);
    if ((aUc() & 0x20000) == 0)
    {
      AppMethodBeat.o(42822);
      return true;
    }
    AppMethodBeat.o(42822);
    return false;
  }
  
  public static int aUJ()
  {
    AppMethodBeat.i(225921);
    g.aAi();
    int i = Util.nullAs((Integer)g.aAh().azQ().get(8201, null), 22);
    AppMethodBeat.o(225921);
    return i;
  }
  
  public static int aUK()
  {
    AppMethodBeat.i(225922);
    g.aAi();
    int i = Util.nullAs((Integer)g.aAh().azQ().get(8208, null), 8);
    AppMethodBeat.o(225922);
    return i;
  }
  
  public static as aUL()
  {
    AppMethodBeat.i(42823);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(aTY());
    if ((localas != null) && ((int)localas.gMZ > 0))
    {
      AppMethodBeat.o(42823);
      return localas;
    }
    localas = new as();
    g.aAi();
    String str1 = (String)g.aAh().azQ().get(2, null);
    g.aAi();
    String str2 = (String)g.aAh().azQ().get(4, null);
    localas.setUsername(str1);
    localas.setNickname(str2);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().ap(localas);
    localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str1);
    AppMethodBeat.o(42823);
    return localas;
  }
  
  public static boolean aUM()
  {
    AppMethodBeat.i(42825);
    g.aAi();
    if (new p(Util.nullAsNil((Integer)g.aAh().azQ().get(9, null))).longValue() != 0L)
    {
      AppMethodBeat.o(42825);
      return true;
    }
    AppMethodBeat.o(42825);
    return false;
  }
  
  public static void aUN()
  {
    AppMethodBeat.i(225926);
    g.aAi();
    g.aAh().azQ().set(348167, Integer.valueOf(1));
    AppMethodBeat.o(225926);
  }
  
  public static void aUO()
  {
    AppMethodBeat.i(225927);
    g.aAi();
    g.aAh().azQ().set(348169, Integer.valueOf(1));
    AppMethodBeat.o(225927);
  }
  
  public static int aUP()
  {
    AppMethodBeat.i(225928);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(348169, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(225928);
    return i;
  }
  
  public static Boolean aUQ()
  {
    AppMethodBeat.i(42829);
    if (!g.aAc())
    {
      Log.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(42829);
      return localObject;
    }
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(6, null);
    g.aAi();
    if ((Util.nullAsFalse((Boolean)g.aAh().azQ().get(340241, null)) == true) && (!Util.isNullOrNil((String)localObject))) {
      if (!((String)localObject).startsWith("+")) {
        break label144;
      }
    }
    label144:
    for (localObject = PhoneFormater.extractCountryCode((String)localObject);; localObject = "86")
    {
      if (localObject == "86")
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(42829);
        return localObject;
      }
      localObject = Boolean.TRUE;
      AppMethodBeat.o(42829);
      return localObject;
      localObject = Boolean.FALSE;
      AppMethodBeat.o(42829);
      return localObject;
    }
  }
  
  public static void aUR()
  {
    AppMethodBeat.i(225929);
    int i = aUe();
    g.aAi();
    g.aAh().azQ().set(40, Integer.valueOf(i & 0xFFFF7FFF));
    AppMethodBeat.o(225929);
  }
  
  public static Map<String, String> aUS()
  {
    AppMethodBeat.i(42830);
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", aTY());
    g.aAi();
    localHashMap.put("login_user_name", (String)g.aAh().azQ().get(ar.a.Ogq, null));
    g.aAi();
    localHashMap.put("last_avatar_path", (String)g.aAh().azQ().get(ar.a.Ogr, null));
    g.aAi();
    localHashMap.put("last_login_bind_mobile", (String)g.aAh().azQ().get(6, null));
    g.aAi();
    localHashMap.put("last_login_bind_email", (String)g.aAh().azQ().get(5, null));
    g.aAi();
    localHashMap.put("last_login_bind_qq", String.valueOf(g.aAh().azQ().get(9, null)));
    g.aAi();
    localHashMap.put("last_login_use_voice", String.valueOf(g.aAh().azQ().get(40, null)));
    localHashMap.put("last_bind_info", bf.iDu.aA("last_bind_info", ""));
    AppMethodBeat.o(42830);
    return localHashMap;
  }
  
  public static int aUT()
  {
    AppMethodBeat.i(178863);
    int i = ((a)g.af(a.class)).aqJ().getInt("AssociateChatRoomDisableFuncFlag", 31);
    AppMethodBeat.o(178863);
    return i;
  }
  
  public static String aUa()
  {
    AppMethodBeat.i(42794);
    g.aAi();
    String str = Util.nullAsNil((String)g.aAh().azQ().get(4, null));
    AppMethodBeat.o(42794);
    return str;
  }
  
  public static String aUb()
  {
    AppMethodBeat.i(42795);
    String str = aTZ();
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(42795);
      return str;
    }
    str = aTY();
    AppMethodBeat.o(42795);
    return str;
  }
  
  public static int aUc()
  {
    AppMethodBeat.i(42796);
    g.aAi();
    Integer localInteger = (Integer)g.aAh().azQ().get(7, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42796);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42796);
    return i;
  }
  
  public static long aUd()
  {
    AppMethodBeat.i(42797);
    g.aAi();
    Long localLong = (Long)g.aAh().azQ().get(147457, null);
    if (localLong == null)
    {
      AppMethodBeat.o(42797);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(42797);
    return l;
  }
  
  public static int aUe()
  {
    AppMethodBeat.i(42798);
    g.aAi();
    Integer localInteger = (Integer)g.aAh().azQ().get(40, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42798);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42798);
    return i;
  }
  
  public static int aUf()
  {
    AppMethodBeat.i(42799);
    g.aAi();
    Integer localInteger = (Integer)g.aAh().azQ().get(339975, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42799);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42799);
    return i;
  }
  
  public static String aUg()
  {
    AppMethodBeat.i(163507);
    g.aAi();
    String str = g.aAh().azQ().get(ar.a.OjG, "").toString();
    AppMethodBeat.o(163507);
    return str;
  }
  
  public static boolean aUh()
  {
    int i = -1;
    int j = iCB;
    if (-1 == j) {}
    while (i == 0)
    {
      return true;
      if ((j & 0x1) != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    return false;
  }
  
  public static boolean aUi()
  {
    AppMethodBeat.i(42800);
    if ((aUe() & 0x4000) != 0)
    {
      AppMethodBeat.o(42800);
      return true;
    }
    AppMethodBeat.o(42800);
    return false;
  }
  
  public static boolean aUj()
  {
    AppMethodBeat.i(42801);
    if ((aUe() & 0x8000) != 0)
    {
      AppMethodBeat.o(42801);
      return true;
    }
    AppMethodBeat.o(42801);
    return false;
  }
  
  public static void aUk()
  {
    AppMethodBeat.i(42802);
    int i = aUe();
    g.aAi();
    g.aAh().azQ().set(40, Integer.valueOf(i | 0x8000));
    AppMethodBeat.o(42802);
  }
  
  public static int aUl()
  {
    AppMethodBeat.i(42803);
    g.aAi();
    Integer localInteger = (Integer)g.aAh().azQ().get(34, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42803);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42803);
    return i;
  }
  
  public static boolean aUm()
  {
    AppMethodBeat.i(42804);
    if ((aUc() & 0x40) != 0)
    {
      AppMethodBeat.o(42804);
      return true;
    }
    AppMethodBeat.o(42804);
    return false;
  }
  
  public static boolean aUn()
  {
    AppMethodBeat.i(42805);
    if ((aUc() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aUc()) });
      AppMethodBeat.o(42805);
      return bool;
    }
  }
  
  public static boolean aUo()
  {
    AppMethodBeat.i(42806);
    g.aAi();
    g.aAh().azQ().gBI();
    if (aUf() == 1)
    {
      AppMethodBeat.o(42806);
      return true;
    }
    AppMethodBeat.o(42806);
    return false;
  }
  
  public static boolean aUp()
  {
    AppMethodBeat.i(42807);
    g.aAi();
    g.aAh().azQ().gBI();
    if (aUf() == 2)
    {
      AppMethodBeat.o(42807);
      return true;
    }
    AppMethodBeat.o(42807);
    return false;
  }
  
  public static boolean aUq()
  {
    AppMethodBeat.i(42808);
    g.aAi();
    g.aAh().azQ().gBI();
    if (aUf() == 4)
    {
      AppMethodBeat.o(42808);
      return true;
    }
    AppMethodBeat.o(42808);
    return false;
  }
  
  public static boolean aUr()
  {
    AppMethodBeat.i(225917);
    if (aUf() == 0)
    {
      AppMethodBeat.o(225917);
      return true;
    }
    AppMethodBeat.o(225917);
    return false;
  }
  
  public static boolean aUs()
  {
    AppMethodBeat.i(225918);
    g.aAi();
    int i = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.ConfigStorageLogic", "isCNPayWalletRegion() walletRegion:%s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(225918);
      return true;
    }
    AppMethodBeat.o(225918);
    return false;
  }
  
  public static boolean aUt()
  {
    AppMethodBeat.i(42809);
    if ((aUl() & 0x20) == 0)
    {
      AppMethodBeat.o(42809);
      return true;
    }
    AppMethodBeat.o(42809);
    return false;
  }
  
  public static boolean aUu()
  {
    AppMethodBeat.i(42810);
    if ((aUc() & 0x1000) != 0)
    {
      AppMethodBeat.o(42810);
      return true;
    }
    AppMethodBeat.o(42810);
    return false;
  }
  
  public static boolean aUv()
  {
    AppMethodBeat.i(42811);
    ci localci = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY("@t.qq.com");
    if ((localci != null) && (localci.isEnable()))
    {
      AppMethodBeat.o(42811);
      return true;
    }
    AppMethodBeat.o(42811);
    return false;
  }
  
  public static boolean aUw()
  {
    AppMethodBeat.i(42812);
    if ((aUl() & 0x2) == 0)
    {
      AppMethodBeat.o(42812);
      return true;
    }
    AppMethodBeat.o(42812);
    return false;
  }
  
  public static boolean aUx()
  {
    AppMethodBeat.i(42813);
    if ((aUl() & 0x10) == 0)
    {
      AppMethodBeat.o(42813);
      return true;
    }
    AppMethodBeat.o(42813);
    return false;
  }
  
  public static boolean aUy()
  {
    AppMethodBeat.i(42814);
    if ((aUl() & 0x80) == 0)
    {
      AppMethodBeat.o(42814);
      return true;
    }
    AppMethodBeat.o(42814);
    return false;
  }
  
  public static boolean aUz()
  {
    AppMethodBeat.i(225919);
    g.aAi();
    boolean bool = Util.nullAsFalse((Boolean)g.aAh().azQ().get(8200, null));
    AppMethodBeat.o(225919);
    return bool;
  }
  
  public static boolean aqE()
  {
    AppMethodBeat.i(225916);
    boolean bool = rP(aUe());
    AppMethodBeat.o(225916);
    return bool;
  }
  
  public static boolean f(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(42826);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
      AppMethodBeat.o(42826);
      return false;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && ((as.bjm(paramString2)) || (as.bjo(paramString2))))
    {
      AppMethodBeat.o(42826);
      return false;
    }
    paramString2 = new BitmapFactory.Options();
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label214;
      }
      Log.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
      AppMethodBeat.o(42826);
      return true;
      if (s.boW(paramString1) < 65536L)
      {
        i = 1;
      }
      else
      {
        paramString2.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(paramString1, paramString2);
        d1 = paramString2.outWidth;
        d2 = paramString2.outHeight;
        if ((d1 >= 100.0D) || (d2 >= 100.0D)) {
          break;
        }
        Log.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d1 + ", height = " + d2);
        i = 1;
      }
    }
    label214:
    double d1 = paramString2.outWidth;
    double d2 = paramString2.outHeight;
    if ((d1 / d2 >= 2.5D) || (d2 / d1 >= 2.5D))
    {
      long l = s.boW(paramString1);
      if (l < 26214400L)
      {
        Log.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
        AppMethodBeat.o(42826);
        return true;
      }
      Log.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
      AppMethodBeat.o(42826);
      return false;
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(42826);
      return true;
    }
    AppMethodBeat.o(42826);
    return false;
  }
  
  public static String getUserBindEmail()
  {
    AppMethodBeat.i(42791);
    g.aAi();
    String str = Util.nullAsNil((String)g.aAh().azQ().get(5, null));
    AppMethodBeat.o(42791);
    return str;
  }
  
  public static void rO(int paramInt)
  {
    AppMethodBeat.i(225914);
    Log.printInfoStack("MicroMsg.ConfigStorageLogic", "[setAuthDeviceFlag] flag=%s", new Object[] { Integer.valueOf(paramInt) });
    iCB = paramInt;
    AppMethodBeat.o(225914);
  }
  
  public static boolean rP(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  private static void y(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42827);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    g.aAi();
    if (g.aAh() != null)
    {
      g.aAi();
      if (g.aAh().azQ() != null)
      {
        g.aAi();
        g.aAh().azQ().set(327682, localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(42827);
  }
  
  private static void z(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42828);
    paramMap.clear();
    g.aAi();
    if (g.aAh() != null)
    {
      g.aAi();
      if (g.aAh().azQ() != null) {}
    }
    else
    {
      Log.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      AppMethodBeat.o(42828);
      return;
    }
    g.aAi();
    Object localObject = (String)g.aAh().azQ().get(327682, null);
    if (localObject == null)
    {
      AppMethodBeat.o(42828);
      return;
    }
    localObject = ((String)localObject).split("\n");
    if (localObject.length % 2 != 0)
    {
      Log.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(localObject.length));
      AppMethodBeat.o(42828);
      return;
    }
    int i = 0;
    while (i < localObject.length)
    {
      paramMap.put(localObject[i], localObject[(i + 1)]);
      i += 2;
    }
    AppMethodBeat.o(42828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.z
 * JD-Core Version:    0.7.0.1
 */