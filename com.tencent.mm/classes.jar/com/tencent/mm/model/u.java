package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.bb.k;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class u
{
  private static String hEZ = null;
  
  public static boolean aAA()
  {
    AppMethodBeat.i(42805);
    if ((aAq() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aAq()) });
      AppMethodBeat.o(42805);
      return bool;
    }
  }
  
  public static boolean aAB()
  {
    AppMethodBeat.i(42806);
    g.ajD();
    g.ajC().ajl().fqc();
    if (aAt() == 1)
    {
      AppMethodBeat.o(42806);
      return true;
    }
    AppMethodBeat.o(42806);
    return false;
  }
  
  public static boolean aAC()
  {
    AppMethodBeat.i(42807);
    g.ajD();
    g.ajC().ajl().fqc();
    if (aAt() == 2)
    {
      AppMethodBeat.o(42807);
      return true;
    }
    AppMethodBeat.o(42807);
    return false;
  }
  
  public static boolean aAD()
  {
    AppMethodBeat.i(42808);
    g.ajD();
    g.ajC().ajl().fqc();
    if (aAt() == 4)
    {
      AppMethodBeat.o(42808);
      return true;
    }
    AppMethodBeat.o(42808);
    return false;
  }
  
  public static boolean aAE()
  {
    AppMethodBeat.i(192515);
    if (aAt() == 0)
    {
      AppMethodBeat.o(192515);
      return true;
    }
    AppMethodBeat.o(192515);
    return false;
  }
  
  public static boolean aAF()
  {
    AppMethodBeat.i(192516);
    g.ajD();
    int i = ((Integer)g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(-1))).intValue();
    ad.i("MicroMsg.ConfigStorageLogic", "isCNPayWalletRegion() walletRegion:%s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(192516);
      return true;
    }
    AppMethodBeat.o(192516);
    return false;
  }
  
  public static boolean aAG()
  {
    AppMethodBeat.i(42809);
    if ((aAy() & 0x20) == 0)
    {
      AppMethodBeat.o(42809);
      return true;
    }
    AppMethodBeat.o(42809);
    return false;
  }
  
  public static boolean aAH()
  {
    AppMethodBeat.i(42810);
    if ((aAq() & 0x1000) != 0)
    {
      AppMethodBeat.o(42810);
      return true;
    }
    AppMethodBeat.o(42810);
    return false;
  }
  
  public static boolean aAI()
  {
    AppMethodBeat.i(42811);
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().aqy("@t.qq.com");
    if ((localca != null) && (localca.isEnable()))
    {
      AppMethodBeat.o(42811);
      return true;
    }
    AppMethodBeat.o(42811);
    return false;
  }
  
  public static boolean aAJ()
  {
    AppMethodBeat.i(42812);
    if ((aAy() & 0x2) == 0)
    {
      AppMethodBeat.o(42812);
      return true;
    }
    AppMethodBeat.o(42812);
    return false;
  }
  
  public static boolean aAK()
  {
    AppMethodBeat.i(42813);
    if ((aAy() & 0x10) == 0)
    {
      AppMethodBeat.o(42813);
      return true;
    }
    AppMethodBeat.o(42813);
    return false;
  }
  
  public static boolean aAL()
  {
    AppMethodBeat.i(42814);
    if ((aAy() & 0x80) == 0)
    {
      AppMethodBeat.o(42814);
      return true;
    }
    AppMethodBeat.o(42814);
    return false;
  }
  
  public static boolean aAM()
  {
    AppMethodBeat.i(192517);
    g.ajD();
    boolean bool = bt.o((Boolean)g.ajC().ajl().get(8200, null));
    AppMethodBeat.o(192517);
    return bool;
  }
  
  public static boolean aAN()
  {
    AppMethodBeat.i(42815);
    if ((aAy() & 0x80000) == 0)
    {
      AppMethodBeat.o(42815);
      return true;
    }
    AppMethodBeat.o(42815);
    return false;
  }
  
  public static boolean aAO()
  {
    AppMethodBeat.i(42816);
    if ((aAy() & 0x40000) == 0)
    {
      AppMethodBeat.o(42816);
      return true;
    }
    AppMethodBeat.o(42816);
    return false;
  }
  
  public static boolean aAP()
  {
    AppMethodBeat.i(42817);
    if ((aAy() & 0x2000) == 0)
    {
      AppMethodBeat.o(42817);
      return true;
    }
    AppMethodBeat.o(42817);
    return false;
  }
  
  public static boolean aAQ()
  {
    AppMethodBeat.i(42818);
    if ((aAy() & 0x10000) == 0)
    {
      AppMethodBeat.o(42818);
      return true;
    }
    AppMethodBeat.o(42818);
    return false;
  }
  
  public static boolean aAR()
  {
    AppMethodBeat.i(42819);
    if ((aAy() & 0x8000000) == 0)
    {
      AppMethodBeat.o(42819);
      return true;
    }
    AppMethodBeat.o(42819);
    return false;
  }
  
  public static boolean aAS()
  {
    AppMethodBeat.i(42820);
    g.ajD();
    String str = (String)g.ajC().ajl().get(65825, null);
    if (bt.isNullOrNil(str))
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
      long l = bt.g(Long.valueOf(bt.getLong(str, 0L)));
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
  
  public static boolean aAT()
  {
    AppMethodBeat.i(192518);
    g.ajD();
    if (bt.n((Integer)g.ajC().ajl().get(17, null)) == 1)
    {
      AppMethodBeat.o(192518);
      return true;
    }
    AppMethodBeat.o(192518);
    return false;
  }
  
  public static boolean aAU()
  {
    AppMethodBeat.i(42821);
    if ((aAy() & 0x1) == 0)
    {
      AppMethodBeat.o(42821);
      return true;
    }
    AppMethodBeat.o(42821);
    return false;
  }
  
  public static boolean aAV()
  {
    AppMethodBeat.i(42822);
    if ((aAq() & 0x20000) == 0)
    {
      AppMethodBeat.o(42822);
      return true;
    }
    AppMethodBeat.o(42822);
    return false;
  }
  
  public static int aAW()
  {
    AppMethodBeat.i(192519);
    g.ajD();
    int i = bt.a((Integer)g.ajC().ajl().get(8201, null), 22);
    AppMethodBeat.o(192519);
    return i;
  }
  
  public static int aAX()
  {
    AppMethodBeat.i(192520);
    g.ajD();
    int i = bt.a((Integer)g.ajC().ajl().get(8208, null), 8);
    AppMethodBeat.o(192520);
    return i;
  }
  
  public static am aAY()
  {
    AppMethodBeat.i(42823);
    am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(aAm());
    if ((localam != null) && ((int)localam.gfj > 0))
    {
      AppMethodBeat.o(42823);
      return localam;
    }
    localam = new am();
    g.ajD();
    String str1 = (String)g.ajC().ajl().get(2, null);
    g.ajD();
    String str2 = (String)g.ajC().ajl().get(4, null);
    localam.setUsername(str1);
    localam.sT(str2);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().ag(localam);
    localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(str1);
    AppMethodBeat.o(42823);
    return localam;
  }
  
  public static boolean aAZ()
  {
    AppMethodBeat.i(42825);
    g.ajD();
    if (new p(bt.n((Integer)g.ajC().ajl().get(9, null))).longValue() != 0L)
    {
      AppMethodBeat.o(42825);
      return true;
    }
    AppMethodBeat.o(42825);
    return false;
  }
  
  public static int aAl()
  {
    AppMethodBeat.i(42790);
    g.ajD();
    Integer localInteger = (Integer)g.ajC().ajl().get(9, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42790);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42790);
    return i;
  }
  
  public static String aAm()
  {
    AppMethodBeat.i(42792);
    g.ajD();
    String str = (String)g.ajC().ajl().get(2, null);
    AppMethodBeat.o(42792);
    return str;
  }
  
  public static String aAn()
  {
    AppMethodBeat.i(42793);
    g.ajD();
    String str = (String)g.ajC().ajl().get(42, null);
    AppMethodBeat.o(42793);
    return str;
  }
  
  public static String aAo()
  {
    AppMethodBeat.i(42794);
    g.ajD();
    String str = (String)g.ajC().ajl().get(4, null);
    AppMethodBeat.o(42794);
    return str;
  }
  
  public static String aAp()
  {
    AppMethodBeat.i(42795);
    String str = aAn();
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(42795);
      return str;
    }
    str = aAm();
    AppMethodBeat.o(42795);
    return str;
  }
  
  public static int aAq()
  {
    AppMethodBeat.i(42796);
    g.ajD();
    Integer localInteger = (Integer)g.ajC().ajl().get(7, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42796);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42796);
    return i;
  }
  
  public static long aAr()
  {
    AppMethodBeat.i(42797);
    g.ajD();
    Long localLong = (Long)g.ajC().ajl().get(147457, null);
    if (localLong == null)
    {
      AppMethodBeat.o(42797);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(42797);
    return l;
  }
  
  public static int aAs()
  {
    AppMethodBeat.i(42798);
    g.ajD();
    Integer localInteger = (Integer)g.ajC().ajl().get(40, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42798);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42798);
    return i;
  }
  
  public static int aAt()
  {
    AppMethodBeat.i(42799);
    g.ajD();
    Integer localInteger = (Integer)g.ajC().ajl().get(339975, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42799);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42799);
    return i;
  }
  
  public static String aAu()
  {
    AppMethodBeat.i(163507);
    if (bt.isNullOrNil(hEZ))
    {
      g.ajD();
      hEZ = (String)g.ajC().ajl().get(al.a.IGw, "");
    }
    String str = hEZ;
    AppMethodBeat.o(163507);
    return str;
  }
  
  public static boolean aAv()
  {
    AppMethodBeat.i(42800);
    if ((aAs() & 0x4000) != 0)
    {
      AppMethodBeat.o(42800);
      return true;
    }
    AppMethodBeat.o(42800);
    return false;
  }
  
  public static boolean aAw()
  {
    AppMethodBeat.i(42801);
    if ((aAs() & 0x8000) != 0)
    {
      AppMethodBeat.o(42801);
      return true;
    }
    AppMethodBeat.o(42801);
    return false;
  }
  
  public static void aAx()
  {
    AppMethodBeat.i(42802);
    int i = aAs();
    g.ajD();
    g.ajC().ajl().set(40, Integer.valueOf(i | 0x8000));
    AppMethodBeat.o(42802);
  }
  
  public static int aAy()
  {
    AppMethodBeat.i(42803);
    g.ajD();
    Integer localInteger = (Integer)g.ajC().ajl().get(34, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42803);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42803);
    return i;
  }
  
  public static boolean aAz()
  {
    AppMethodBeat.i(42804);
    if ((aAq() & 0x40) != 0)
    {
      AppMethodBeat.o(42804);
      return true;
    }
    AppMethodBeat.o(42804);
    return false;
  }
  
  public static void aBa()
  {
    AppMethodBeat.i(192524);
    g.ajD();
    g.ajC().ajl().set(348167, Integer.valueOf(1));
    AppMethodBeat.o(192524);
  }
  
  public static void aBb()
  {
    AppMethodBeat.i(192525);
    g.ajD();
    g.ajC().ajl().set(348169, Integer.valueOf(1));
    AppMethodBeat.o(192525);
  }
  
  public static int aBc()
  {
    AppMethodBeat.i(192526);
    g.ajD();
    int i = ((Integer)g.ajC().ajl().get(348169, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(192526);
    return i;
  }
  
  public static Boolean aBd()
  {
    AppMethodBeat.i(42829);
    if (!g.ajx())
    {
      ad.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(42829);
      return localObject;
    }
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(6, null);
    g.ajD();
    if ((bt.o((Boolean)g.ajC().ajl().get(340241, null)) == true) && (!bt.isNullOrNil((String)localObject))) {
      if (!((String)localObject).startsWith("+")) {
        break label144;
      }
    }
    label144:
    for (localObject = ba.aob((String)localObject);; localObject = "86")
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
  
  public static void aBe()
  {
    AppMethodBeat.i(192527);
    int i = aAs();
    g.ajD();
    g.ajC().ajl().set(40, Integer.valueOf(i & 0xFFFF7FFF));
    AppMethodBeat.o(192527);
  }
  
  public static Map<String, String> aBf()
  {
    AppMethodBeat.i(42830);
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", aAm());
    g.ajD();
    localHashMap.put("login_user_name", (String)g.ajC().ajl().get(al.a.IDt, null));
    g.ajD();
    localHashMap.put("last_avatar_path", (String)g.ajC().ajl().get(al.a.IDu, null));
    g.ajD();
    localHashMap.put("last_login_bind_mobile", (String)g.ajC().ajl().get(6, null));
    g.ajD();
    localHashMap.put("last_login_bind_email", (String)g.ajC().ajl().get(5, null));
    g.ajD();
    localHashMap.put("last_login_bind_qq", String.valueOf(g.ajC().ajl().get(9, null)));
    g.ajD();
    localHashMap.put("last_login_use_voice", String.valueOf(g.ajC().ajl().get(40, null)));
    localHashMap.put("last_bind_info", az.hFS.ax("last_bind_info", ""));
    AppMethodBeat.o(42830);
    return localHashMap;
  }
  
  public static int aBg()
  {
    AppMethodBeat.i(178863);
    int i = ((a)g.ab(a.class)).acA().getInt("AssociateChatRoomDisableFuncFlag", 31);
    AppMethodBeat.o(178863);
    return i;
  }
  
  public static void aE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192522);
    HashMap localHashMap = new HashMap();
    q(localHashMap);
    localHashMap.put(paramString1, paramString2);
    p(localHashMap);
    AppMethodBeat.o(192522);
  }
  
  public static boolean acv()
  {
    AppMethodBeat.i(192514);
    boolean bool = om(aAs());
    AppMethodBeat.o(192514);
    return bool;
  }
  
  public static boolean f(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(42826);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ad.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
      AppMethodBeat.o(42826);
      return false;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && ((am.aSN(paramString2)) || (am.aSP(paramString2))))
    {
      AppMethodBeat.o(42826);
      return false;
    }
    paramString2 = new BitmapFactory.Options();
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ad.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label214;
      }
      ad.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
      AppMethodBeat.o(42826);
      return true;
      if (i.aYo(paramString1) < 65536L)
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
        ad.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d1 + ", height = " + d2);
        i = 1;
      }
    }
    label214:
    double d1 = paramString2.outWidth;
    double d2 = paramString2.outHeight;
    if ((d1 / d2 >= 2.5D) || (d2 / d1 >= 2.5D))
    {
      long l = i.aYo(paramString1);
      if (l < 26214400L)
      {
        ad.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
        AppMethodBeat.o(42826);
        return true;
      }
      ad.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
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
    g.ajD();
    String str = bt.nullAsNil((String)g.ajC().ajl().get(5, null));
    AppMethodBeat.o(42791);
    return str;
  }
  
  public static boolean om(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  private static void p(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42827);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    g.ajD();
    if (g.ajC() != null)
    {
      g.ajD();
      if (g.ajC().ajl() != null)
      {
        g.ajD();
        g.ajC().ajl().set(327682, localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(42827);
  }
  
  private static void q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42828);
    paramMap.clear();
    g.ajD();
    if (g.ajC() != null)
    {
      g.ajD();
      if (g.ajC().ajl() != null) {}
    }
    else
    {
      ad.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      AppMethodBeat.o(42828);
      return;
    }
    g.ajD();
    Object localObject = (String)g.ajC().ajl().get(327682, null);
    if (localObject == null)
    {
      AppMethodBeat.o(42828);
      return;
    }
    localObject = ((String)localObject).split("\n");
    if (localObject.length % 2 != 0)
    {
      ad.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(localObject.length));
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
  
  public static boolean za(String paramString)
  {
    AppMethodBeat.i(42789);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42789);
      return false;
    }
    String str = aAm();
    if ((str == null) || (str.length() <= 0))
    {
      ad.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
      AppMethodBeat.o(42789);
      return false;
    }
    boolean bool = str.equals(paramString);
    AppMethodBeat.o(42789);
    return bool;
  }
  
  public static k.b zb(String paramString)
  {
    AppMethodBeat.i(192521);
    paramString = new k(paramString);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azo().c(paramString);
    AppMethodBeat.o(192521);
    return paramString;
  }
  
  public static String zc(String paramString)
  {
    AppMethodBeat.i(192523);
    HashMap localHashMap = new HashMap();
    q(localHashMap);
    if (localHashMap.containsKey(paramString))
    {
      paramString = (String)localHashMap.get(paramString);
      AppMethodBeat.o(192523);
      return paramString;
    }
    AppMethodBeat.o(192523);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.u
 * JD-Core Version:    0.7.0.1
 */