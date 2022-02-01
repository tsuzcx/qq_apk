package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.ba.k;
import com.tencent.mm.contact.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cb;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class v
{
  private static String hHR = null;
  
  public static int aAB()
  {
    AppMethodBeat.i(42790);
    g.ajS();
    Integer localInteger = (Integer)g.ajR().ajA().get(9, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42790);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42790);
    return i;
  }
  
  public static String aAC()
  {
    AppMethodBeat.i(42792);
    g.ajS();
    String str = (String)g.ajR().ajA().get(2, null);
    AppMethodBeat.o(42792);
    return str;
  }
  
  public static String aAD()
  {
    AppMethodBeat.i(42793);
    g.ajS();
    String str = (String)g.ajR().ajA().get(42, null);
    AppMethodBeat.o(42793);
    return str;
  }
  
  public static String aAE()
  {
    AppMethodBeat.i(42794);
    g.ajS();
    String str = (String)g.ajR().ajA().get(4, null);
    AppMethodBeat.o(42794);
    return str;
  }
  
  public static String aAF()
  {
    AppMethodBeat.i(42795);
    String str = aAD();
    if (!bu.isNullOrNil(str))
    {
      AppMethodBeat.o(42795);
      return str;
    }
    str = aAC();
    AppMethodBeat.o(42795);
    return str;
  }
  
  public static int aAG()
  {
    AppMethodBeat.i(42796);
    g.ajS();
    Integer localInteger = (Integer)g.ajR().ajA().get(7, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42796);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42796);
    return i;
  }
  
  public static long aAH()
  {
    AppMethodBeat.i(42797);
    g.ajS();
    Long localLong = (Long)g.ajR().ajA().get(147457, null);
    if (localLong == null)
    {
      AppMethodBeat.o(42797);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(42797);
    return l;
  }
  
  public static int aAI()
  {
    AppMethodBeat.i(42798);
    g.ajS();
    Integer localInteger = (Integer)g.ajR().ajA().get(40, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42798);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42798);
    return i;
  }
  
  public static int aAJ()
  {
    AppMethodBeat.i(42799);
    g.ajS();
    Integer localInteger = (Integer)g.ajR().ajA().get(339975, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42799);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42799);
    return i;
  }
  
  public static String aAK()
  {
    AppMethodBeat.i(163507);
    if (bu.isNullOrNil(hHR))
    {
      g.ajS();
      hHR = (String)g.ajR().ajA().get(am.a.JaW, "");
    }
    String str = hHR;
    AppMethodBeat.o(163507);
    return str;
  }
  
  public static boolean aAL()
  {
    AppMethodBeat.i(42800);
    if ((aAI() & 0x4000) != 0)
    {
      AppMethodBeat.o(42800);
      return true;
    }
    AppMethodBeat.o(42800);
    return false;
  }
  
  public static boolean aAM()
  {
    AppMethodBeat.i(42801);
    if ((aAI() & 0x8000) != 0)
    {
      AppMethodBeat.o(42801);
      return true;
    }
    AppMethodBeat.o(42801);
    return false;
  }
  
  public static void aAN()
  {
    AppMethodBeat.i(42802);
    int i = aAI();
    g.ajS();
    g.ajR().ajA().set(40, Integer.valueOf(i | 0x8000));
    AppMethodBeat.o(42802);
  }
  
  public static int aAO()
  {
    AppMethodBeat.i(42803);
    g.ajS();
    Integer localInteger = (Integer)g.ajR().ajA().get(34, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42803);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42803);
    return i;
  }
  
  public static boolean aAP()
  {
    AppMethodBeat.i(42804);
    if ((aAG() & 0x40) != 0)
    {
      AppMethodBeat.o(42804);
      return true;
    }
    AppMethodBeat.o(42804);
    return false;
  }
  
  public static boolean aAQ()
  {
    AppMethodBeat.i(42805);
    if ((aAG() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aAG()) });
      AppMethodBeat.o(42805);
      return bool;
    }
  }
  
  public static boolean aAR()
  {
    AppMethodBeat.i(42806);
    g.ajS();
    g.ajR().ajA().fuc();
    if (aAJ() == 1)
    {
      AppMethodBeat.o(42806);
      return true;
    }
    AppMethodBeat.o(42806);
    return false;
  }
  
  public static boolean aAS()
  {
    AppMethodBeat.i(42807);
    g.ajS();
    g.ajR().ajA().fuc();
    if (aAJ() == 2)
    {
      AppMethodBeat.o(42807);
      return true;
    }
    AppMethodBeat.o(42807);
    return false;
  }
  
  public static boolean aAT()
  {
    AppMethodBeat.i(42808);
    g.ajS();
    g.ajR().ajA().fuc();
    if (aAJ() == 4)
    {
      AppMethodBeat.o(42808);
      return true;
    }
    AppMethodBeat.o(42808);
    return false;
  }
  
  public static boolean aAU()
  {
    AppMethodBeat.i(213389);
    if (aAJ() == 0)
    {
      AppMethodBeat.o(213389);
      return true;
    }
    AppMethodBeat.o(213389);
    return false;
  }
  
  public static boolean aAV()
  {
    AppMethodBeat.i(213390);
    g.ajS();
    int i = ((Integer)g.ajR().ajA().get(am.a.IPF, Integer.valueOf(-1))).intValue();
    ae.i("MicroMsg.ConfigStorageLogic", "isCNPayWalletRegion() walletRegion:%s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(213390);
      return true;
    }
    AppMethodBeat.o(213390);
    return false;
  }
  
  public static boolean aAW()
  {
    AppMethodBeat.i(42809);
    if ((aAO() & 0x20) == 0)
    {
      AppMethodBeat.o(42809);
      return true;
    }
    AppMethodBeat.o(42809);
    return false;
  }
  
  public static boolean aAX()
  {
    AppMethodBeat.i(42810);
    if ((aAG() & 0x1000) != 0)
    {
      AppMethodBeat.o(42810);
      return true;
    }
    AppMethodBeat.o(42810);
    return false;
  }
  
  public static boolean aAY()
  {
    AppMethodBeat.i(42811);
    cb localcb = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD("@t.qq.com");
    if ((localcb != null) && (localcb.isEnable()))
    {
      AppMethodBeat.o(42811);
      return true;
    }
    AppMethodBeat.o(42811);
    return false;
  }
  
  public static boolean aAZ()
  {
    AppMethodBeat.i(42812);
    if ((aAO() & 0x2) == 0)
    {
      AppMethodBeat.o(42812);
      return true;
    }
    AppMethodBeat.o(42812);
    return false;
  }
  
  public static boolean aBa()
  {
    AppMethodBeat.i(42813);
    if ((aAO() & 0x10) == 0)
    {
      AppMethodBeat.o(42813);
      return true;
    }
    AppMethodBeat.o(42813);
    return false;
  }
  
  public static boolean aBb()
  {
    AppMethodBeat.i(42814);
    if ((aAO() & 0x80) == 0)
    {
      AppMethodBeat.o(42814);
      return true;
    }
    AppMethodBeat.o(42814);
    return false;
  }
  
  public static boolean aBc()
  {
    AppMethodBeat.i(213391);
    g.ajS();
    boolean bool = bu.o((Boolean)g.ajR().ajA().get(8200, null));
    AppMethodBeat.o(213391);
    return bool;
  }
  
  public static boolean aBd()
  {
    AppMethodBeat.i(42815);
    if ((aAO() & 0x80000) == 0)
    {
      AppMethodBeat.o(42815);
      return true;
    }
    AppMethodBeat.o(42815);
    return false;
  }
  
  public static boolean aBe()
  {
    AppMethodBeat.i(42816);
    if ((aAO() & 0x40000) == 0)
    {
      AppMethodBeat.o(42816);
      return true;
    }
    AppMethodBeat.o(42816);
    return false;
  }
  
  public static boolean aBf()
  {
    AppMethodBeat.i(42817);
    if ((aAO() & 0x2000) == 0)
    {
      AppMethodBeat.o(42817);
      return true;
    }
    AppMethodBeat.o(42817);
    return false;
  }
  
  public static boolean aBg()
  {
    AppMethodBeat.i(42818);
    if ((aAO() & 0x10000) == 0)
    {
      AppMethodBeat.o(42818);
      return true;
    }
    AppMethodBeat.o(42818);
    return false;
  }
  
  public static boolean aBh()
  {
    AppMethodBeat.i(42819);
    if ((aAO() & 0x8000000) == 0)
    {
      AppMethodBeat.o(42819);
      return true;
    }
    AppMethodBeat.o(42819);
    return false;
  }
  
  public static boolean aBi()
  {
    AppMethodBeat.i(42820);
    g.ajS();
    String str = (String)g.ajR().ajA().get(65825, null);
    if (bu.isNullOrNil(str))
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
      long l = bu.i(Long.valueOf(bu.getLong(str, 0L)));
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
  
  public static boolean aBj()
  {
    AppMethodBeat.i(213392);
    g.ajS();
    if (bu.o((Integer)g.ajR().ajA().get(17, null)) == 1)
    {
      AppMethodBeat.o(213392);
      return true;
    }
    AppMethodBeat.o(213392);
    return false;
  }
  
  public static boolean aBk()
  {
    AppMethodBeat.i(42821);
    if ((aAO() & 0x1) == 0)
    {
      AppMethodBeat.o(42821);
      return true;
    }
    AppMethodBeat.o(42821);
    return false;
  }
  
  public static boolean aBl()
  {
    AppMethodBeat.i(42822);
    if ((aAG() & 0x20000) == 0)
    {
      AppMethodBeat.o(42822);
      return true;
    }
    AppMethodBeat.o(42822);
    return false;
  }
  
  public static int aBm()
  {
    AppMethodBeat.i(213393);
    g.ajS();
    int i = bu.a((Integer)g.ajR().ajA().get(8201, null), 22);
    AppMethodBeat.o(213393);
    return i;
  }
  
  public static int aBn()
  {
    AppMethodBeat.i(213394);
    g.ajS();
    int i = bu.a((Integer)g.ajR().ajA().get(8208, null), 8);
    AppMethodBeat.o(213394);
    return i;
  }
  
  public static an aBo()
  {
    AppMethodBeat.i(42823);
    an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(aAC());
    if ((localan != null) && ((int)localan.ght > 0))
    {
      AppMethodBeat.o(42823);
      return localan;
    }
    localan = new an();
    g.ajS();
    String str1 = (String)g.ajR().ajA().get(2, null);
    g.ajS();
    String str2 = (String)g.ajR().ajA().get(4, null);
    localan.setUsername(str1);
    localan.to(str2);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().an(localan);
    localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(str1);
    AppMethodBeat.o(42823);
    return localan;
  }
  
  public static boolean aBp()
  {
    AppMethodBeat.i(42825);
    g.ajS();
    if (new p(bu.o((Integer)g.ajR().ajA().get(9, null))).longValue() != 0L)
    {
      AppMethodBeat.o(42825);
      return true;
    }
    AppMethodBeat.o(42825);
    return false;
  }
  
  public static void aBq()
  {
    AppMethodBeat.i(213398);
    g.ajS();
    g.ajR().ajA().set(348167, Integer.valueOf(1));
    AppMethodBeat.o(213398);
  }
  
  public static void aBr()
  {
    AppMethodBeat.i(213399);
    g.ajS();
    g.ajR().ajA().set(348169, Integer.valueOf(1));
    AppMethodBeat.o(213399);
  }
  
  public static int aBs()
  {
    AppMethodBeat.i(213400);
    g.ajS();
    int i = ((Integer)g.ajR().ajA().get(348169, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(213400);
    return i;
  }
  
  public static Boolean aBt()
  {
    AppMethodBeat.i(42829);
    if (!g.ajM())
    {
      ae.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(42829);
      return localObject;
    }
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(6, null);
    g.ajS();
    if ((bu.o((Boolean)g.ajR().ajA().get(340241, null)) == true) && (!bu.isNullOrNil((String)localObject))) {
      if (!((String)localObject).startsWith("+")) {
        break label144;
      }
    }
    label144:
    for (localObject = com.tencent.mm.sdk.platformtools.bb.apd((String)localObject);; localObject = "86")
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
  
  public static void aBu()
  {
    AppMethodBeat.i(213401);
    int i = aAI();
    g.ajS();
    g.ajR().ajA().set(40, Integer.valueOf(i & 0xFFFF7FFF));
    AppMethodBeat.o(213401);
  }
  
  public static Map<String, String> aBv()
  {
    AppMethodBeat.i(42830);
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", aAC());
    g.ajS();
    localHashMap.put("login_user_name", (String)g.ajR().ajA().get(am.a.IXT, null));
    g.ajS();
    localHashMap.put("last_avatar_path", (String)g.ajR().ajA().get(am.a.IXU, null));
    g.ajS();
    localHashMap.put("last_login_bind_mobile", (String)g.ajR().ajA().get(6, null));
    g.ajS();
    localHashMap.put("last_login_bind_email", (String)g.ajR().ajA().get(5, null));
    g.ajS();
    localHashMap.put("last_login_bind_qq", String.valueOf(g.ajR().ajA().get(9, null)));
    g.ajS();
    localHashMap.put("last_login_use_voice", String.valueOf(g.ajR().ajA().get(40, null)));
    localHashMap.put("last_bind_info", bb.hIK.ay("last_bind_info", ""));
    AppMethodBeat.o(42830);
    return localHashMap;
  }
  
  public static int aBw()
  {
    AppMethodBeat.i(178863);
    int i = ((a)g.ab(a.class)).acL().getInt("AssociateChatRoomDisableFuncFlag", 31);
    AppMethodBeat.o(178863);
    return i;
  }
  
  public static void aF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213396);
    HashMap localHashMap = new HashMap();
    x(localHashMap);
    localHashMap.put(paramString1, paramString2);
    w(localHashMap);
    AppMethodBeat.o(213396);
  }
  
  public static boolean acG()
  {
    AppMethodBeat.i(213388);
    boolean bool = op(aAI());
    AppMethodBeat.o(213388);
    return bool;
  }
  
  public static boolean f(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(42826);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ae.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
      AppMethodBeat.o(42826);
      return false;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && ((an.aUn(paramString2)) || (an.aUp(paramString2))))
    {
      AppMethodBeat.o(42826);
      return false;
    }
    paramString2 = new BitmapFactory.Options();
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ae.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label214;
      }
      ae.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
      AppMethodBeat.o(42826);
      return true;
      if (o.aZR(paramString1) < 65536L)
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
        ae.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d1 + ", height = " + d2);
        i = 1;
      }
    }
    label214:
    double d1 = paramString2.outWidth;
    double d2 = paramString2.outHeight;
    if ((d1 / d2 >= 2.5D) || (d2 / d1 >= 2.5D))
    {
      long l = o.aZR(paramString1);
      if (l < 26214400L)
      {
        ae.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
        AppMethodBeat.o(42826);
        return true;
      }
      ae.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
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
    g.ajS();
    String str = bu.nullAsNil((String)g.ajR().ajA().get(5, null));
    AppMethodBeat.o(42791);
    return str;
  }
  
  public static boolean op(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  private static void w(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42827);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    g.ajS();
    if (g.ajR() != null)
    {
      g.ajS();
      if (g.ajR().ajA() != null)
      {
        g.ajS();
        g.ajR().ajA().set(327682, localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(42827);
  }
  
  private static void x(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42828);
    paramMap.clear();
    g.ajS();
    if (g.ajR() != null)
    {
      g.ajS();
      if (g.ajR().ajA() != null) {}
    }
    else
    {
      ae.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      AppMethodBeat.o(42828);
      return;
    }
    g.ajS();
    Object localObject = (String)g.ajR().ajA().get(327682, null);
    if (localObject == null)
    {
      AppMethodBeat.o(42828);
      return;
    }
    localObject = ((String)localObject).split("\n");
    if (localObject.length % 2 != 0)
    {
      ae.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(localObject.length));
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
  
  public static boolean zK(String paramString)
  {
    AppMethodBeat.i(42789);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42789);
      return false;
    }
    String str = aAC();
    if ((str == null) || (str.length() <= 0))
    {
      ae.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
      AppMethodBeat.o(42789);
      return false;
    }
    boolean bool = str.equals(paramString);
    AppMethodBeat.o(42789);
    return bool;
  }
  
  public static k.b zL(String paramString)
  {
    AppMethodBeat.i(213395);
    paramString = new k(paramString);
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(paramString);
    AppMethodBeat.o(213395);
    return paramString;
  }
  
  public static String zM(String paramString)
  {
    AppMethodBeat.i(213397);
    HashMap localHashMap = new HashMap();
    x(localHashMap);
    if (localHashMap.containsKey(paramString))
    {
      paramString = (String)localHashMap.get(paramString);
      AppMethodBeat.o(213397);
      return paramString;
    }
    AppMethodBeat.o(213397);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.v
 * JD-Core Version:    0.7.0.1
 */