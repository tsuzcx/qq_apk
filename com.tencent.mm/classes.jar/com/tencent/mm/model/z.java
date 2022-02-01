package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.bd.k;
import com.tencent.mm.contact.d;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cj;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class z
{
  private static int lsw = -1;
  
  public static boolean PD(String paramString)
  {
    AppMethodBeat.i(42789);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42789);
      return false;
    }
    String str = bcZ();
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
  
  public static boolean PE(String paramString)
  {
    AppMethodBeat.i(239316);
    boolean bool = bdh().equals(paramString);
    AppMethodBeat.o(239316);
    return bool;
  }
  
  public static k.b PF(String paramString)
  {
    AppMethodBeat.i(239349);
    paramString = new k(paramString);
    ((n)h.ae(n.class)).bbK().d(paramString);
    AppMethodBeat.o(239349);
    return paramString;
  }
  
  public static String PG(String paramString)
  {
    AppMethodBeat.i(239358);
    HashMap localHashMap = new HashMap();
    r(localHashMap);
    if (localHashMap.containsKey(paramString))
    {
      paramString = (String)localHashMap.get(paramString);
      AppMethodBeat.o(239358);
      return paramString;
    }
    AppMethodBeat.o(239358);
    return null;
  }
  
  public static void aK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(239356);
    HashMap localHashMap = new HashMap();
    r(localHashMap);
    localHashMap.put(paramString1, paramString2);
    q(localHashMap);
    AppMethodBeat.o(239356);
  }
  
  public static boolean awX()
  {
    AppMethodBeat.i(239319);
    boolean bool = uJ(bdf());
    AppMethodBeat.o(239319);
    return bool;
  }
  
  public static int bcY()
  {
    AppMethodBeat.i(42790);
    h.aHH();
    Integer localInteger = (Integer)h.aHG().aHp().b(9, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42790);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42790);
    return i;
  }
  
  public static String bcZ()
  {
    AppMethodBeat.i(42792);
    h.aHH();
    String str = (String)h.aHG().aHp().b(2, null);
    AppMethodBeat.o(42792);
    return str;
  }
  
  public static boolean bdA()
  {
    AppMethodBeat.i(42814);
    if ((bdn() & 0x80) == 0)
    {
      AppMethodBeat.o(42814);
      return true;
    }
    AppMethodBeat.o(42814);
    return false;
  }
  
  public static boolean bdB()
  {
    AppMethodBeat.i(239335);
    h.aHH();
    boolean bool = Util.nullAsFalse((Boolean)h.aHG().aHp().b(8200, null));
    AppMethodBeat.o(239335);
    return bool;
  }
  
  public static boolean bdC()
  {
    AppMethodBeat.i(42815);
    if ((bdn() & 0x80000) == 0)
    {
      AppMethodBeat.o(42815);
      return true;
    }
    AppMethodBeat.o(42815);
    return false;
  }
  
  public static boolean bdD()
  {
    AppMethodBeat.i(42816);
    if ((bdn() & 0x40000) == 0)
    {
      AppMethodBeat.o(42816);
      return true;
    }
    AppMethodBeat.o(42816);
    return false;
  }
  
  public static boolean bdE()
  {
    AppMethodBeat.i(42817);
    if ((bdn() & 0x2000) == 0)
    {
      AppMethodBeat.o(42817);
      return true;
    }
    AppMethodBeat.o(42817);
    return false;
  }
  
  public static boolean bdF()
  {
    AppMethodBeat.i(42818);
    if ((bdn() & 0x10000) == 0)
    {
      AppMethodBeat.o(42818);
      return true;
    }
    AppMethodBeat.o(42818);
    return false;
  }
  
  public static boolean bdG()
  {
    AppMethodBeat.i(42819);
    if ((bdn() & 0x8000000) == 0)
    {
      AppMethodBeat.o(42819);
      return true;
    }
    AppMethodBeat.o(42819);
    return false;
  }
  
  public static boolean bdH()
  {
    AppMethodBeat.i(42820);
    h.aHH();
    String str = (String)h.aHG().aHp().b(65825, null);
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
  
  public static boolean bdI()
  {
    AppMethodBeat.i(239340);
    h.aHH();
    if (Util.nullAsNil((Integer)h.aHG().aHp().b(17, null)) == 1)
    {
      AppMethodBeat.o(239340);
      return true;
    }
    AppMethodBeat.o(239340);
    return false;
  }
  
  public static boolean bdJ()
  {
    AppMethodBeat.i(42821);
    if ((bdn() & 0x1) == 0)
    {
      AppMethodBeat.o(42821);
      return true;
    }
    AppMethodBeat.o(42821);
    return false;
  }
  
  public static boolean bdK()
  {
    AppMethodBeat.i(42822);
    if ((bdd() & 0x20000) == 0)
    {
      AppMethodBeat.o(42822);
      return true;
    }
    AppMethodBeat.o(42822);
    return false;
  }
  
  public static int bdL()
  {
    AppMethodBeat.i(239344);
    h.aHH();
    int i = Util.nullAs((Integer)h.aHG().aHp().b(8201, null), 22);
    AppMethodBeat.o(239344);
    return i;
  }
  
  public static int bdM()
  {
    AppMethodBeat.i(239346);
    h.aHH();
    int i = Util.nullAs((Integer)h.aHG().aHp().b(8208, null), 8);
    AppMethodBeat.o(239346);
    return i;
  }
  
  public static as bdN()
  {
    AppMethodBeat.i(42823);
    as localas = ((n)h.ae(n.class)).bbL().RG(bcZ());
    if ((localas != null) && ((int)localas.jxt > 0))
    {
      AppMethodBeat.o(42823);
      return localas;
    }
    localas = new as();
    h.aHH();
    String str1 = (String)h.aHG().aHp().b(2, null);
    h.aHH();
    String str2 = (String)h.aHG().aHp().b(4, null);
    localas.setUsername(str1);
    localas.setNickname(str2);
    ((n)h.ae(n.class)).bbL().av(localas);
    localas = ((n)h.ae(n.class)).bbL().RG(str1);
    AppMethodBeat.o(42823);
    return localas;
  }
  
  public static boolean bdO()
  {
    AppMethodBeat.i(42825);
    h.aHH();
    if (new p(Util.nullAsNil((Integer)h.aHG().aHp().b(9, null))).longValue() != 0L)
    {
      AppMethodBeat.o(42825);
      return true;
    }
    AppMethodBeat.o(42825);
    return false;
  }
  
  public static void bdP()
  {
    AppMethodBeat.i(239364);
    h.aHH();
    h.aHG().aHp().i(348167, Integer.valueOf(1));
    AppMethodBeat.o(239364);
  }
  
  public static void bdQ()
  {
    AppMethodBeat.i(239366);
    h.aHH();
    h.aHG().aHp().i(348169, Integer.valueOf(1));
    AppMethodBeat.o(239366);
  }
  
  public static int bdR()
  {
    AppMethodBeat.i(239369);
    h.aHH();
    int i = ((Integer)h.aHG().aHp().b(348169, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(239369);
    return i;
  }
  
  public static Boolean bdS()
  {
    AppMethodBeat.i(42829);
    if (!h.aHB())
    {
      Log.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(42829);
      return localObject;
    }
    h.aHH();
    Object localObject = (String)h.aHG().aHp().b(6, null);
    h.aHH();
    if ((Util.nullAsFalse((Boolean)h.aHG().aHp().b(340241, null)) == true) && (!Util.isNullOrNil((String)localObject))) {
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
  
  public static void bdT()
  {
    AppMethodBeat.i(239376);
    int i = bdf();
    h.aHH();
    h.aHG().aHp().i(40, Integer.valueOf(i & 0xFFFF7FFF));
    AppMethodBeat.o(239376);
  }
  
  public static Map<String, String> bdU()
  {
    AppMethodBeat.i(42830);
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", bcZ());
    h.aHH();
    localHashMap.put("login_user_name", (String)h.aHG().aHp().get(ar.a.VuG, null));
    h.aHH();
    localHashMap.put("last_avatar_path", (String)h.aHG().aHp().get(ar.a.VuH, null));
    h.aHH();
    localHashMap.put("last_login_bind_mobile", (String)h.aHG().aHp().b(6, null));
    h.aHH();
    localHashMap.put("last_login_bind_email", (String)h.aHG().aHp().b(5, null));
    h.aHH();
    localHashMap.put("last_login_bind_qq", String.valueOf(h.aHG().aHp().b(9, null)));
    h.aHH();
    localHashMap.put("last_login_use_voice", String.valueOf(h.aHG().aHp().b(40, null)));
    localHashMap.put("last_bind_info", bg.ltv.aD("last_bind_info", ""));
    AppMethodBeat.o(42830);
    return localHashMap;
  }
  
  public static int bdV()
  {
    AppMethodBeat.i(178863);
    int i = ((a)h.ae(a.class)).axc().getInt("AssociateChatRoomDisableFuncFlag", 31);
    AppMethodBeat.o(178863);
    return i;
  }
  
  public static String bda()
  {
    AppMethodBeat.i(42793);
    h.aHH();
    String str = (String)h.aHG().aHp().b(42, null);
    AppMethodBeat.o(42793);
    return str;
  }
  
  public static String bdb()
  {
    AppMethodBeat.i(42794);
    h.aHH();
    String str = Util.nullAsNil((String)h.aHG().aHp().b(4, null));
    AppMethodBeat.o(42794);
    return str;
  }
  
  public static String bdc()
  {
    AppMethodBeat.i(42795);
    String str = bda();
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(42795);
      return str;
    }
    str = bcZ();
    AppMethodBeat.o(42795);
    return str;
  }
  
  public static int bdd()
  {
    AppMethodBeat.i(42796);
    h.aHH();
    Integer localInteger = (Integer)h.aHG().aHp().b(7, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42796);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42796);
    return i;
  }
  
  public static long bde()
  {
    AppMethodBeat.i(42797);
    h.aHH();
    Long localLong = (Long)h.aHG().aHp().b(147457, null);
    if (localLong == null)
    {
      AppMethodBeat.o(42797);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(42797);
    return l;
  }
  
  public static int bdf()
  {
    AppMethodBeat.i(42798);
    h.aHH();
    Integer localInteger = (Integer)h.aHG().aHp().b(40, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42798);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42798);
    return i;
  }
  
  public static int bdg()
  {
    AppMethodBeat.i(42799);
    h.aHH();
    Integer localInteger = (Integer)h.aHG().aHp().b(339975, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42799);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42799);
    return i;
  }
  
  public static String bdh()
  {
    AppMethodBeat.i(163507);
    h.aHH();
    String str = h.aHG().aHp().get(ar.a.VxX, "").toString();
    AppMethodBeat.o(163507);
    return str;
  }
  
  public static String bdi()
  {
    AppMethodBeat.i(239312);
    h.aHH();
    String str = h.aHG().aHp().get(ar.a.Vyd, "").toString();
    AppMethodBeat.o(239312);
    return str;
  }
  
  public static boolean bdj()
  {
    int i = -1;
    int j = lsw;
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
  
  public static boolean bdk()
  {
    AppMethodBeat.i(42800);
    if ((bdf() & 0x4000) != 0)
    {
      AppMethodBeat.o(42800);
      return true;
    }
    AppMethodBeat.o(42800);
    return false;
  }
  
  public static boolean bdl()
  {
    AppMethodBeat.i(42801);
    if ((bdf() & 0x8000) != 0)
    {
      AppMethodBeat.o(42801);
      return true;
    }
    AppMethodBeat.o(42801);
    return false;
  }
  
  public static void bdm()
  {
    AppMethodBeat.i(42802);
    int i = bdf();
    h.aHH();
    h.aHG().aHp().i(40, Integer.valueOf(i | 0x8000));
    AppMethodBeat.o(42802);
  }
  
  public static int bdn()
  {
    AppMethodBeat.i(42803);
    h.aHH();
    Integer localInteger = (Integer)h.aHG().aHp().b(34, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42803);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42803);
    return i;
  }
  
  public static boolean bdo()
  {
    AppMethodBeat.i(42804);
    if ((bdd() & 0x40) != 0)
    {
      AppMethodBeat.o(42804);
      return true;
    }
    AppMethodBeat.o(42804);
    return false;
  }
  
  public static boolean bdp()
  {
    AppMethodBeat.i(42805);
    if ((bdd() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(bdd()) });
      AppMethodBeat.o(42805);
      return bool;
    }
  }
  
  public static boolean bdq()
  {
    AppMethodBeat.i(42806);
    h.aHH();
    h.aHG().aHp().hxT();
    if (bdg() == 1)
    {
      AppMethodBeat.o(42806);
      return true;
    }
    AppMethodBeat.o(42806);
    return false;
  }
  
  public static boolean bdr()
  {
    AppMethodBeat.i(42807);
    h.aHH();
    h.aHG().aHp().hxT();
    if (bdg() == 2)
    {
      AppMethodBeat.o(42807);
      return true;
    }
    AppMethodBeat.o(42807);
    return false;
  }
  
  public static boolean bds()
  {
    AppMethodBeat.i(42808);
    h.aHH();
    h.aHG().aHp().hxT();
    if (bdg() == 4)
    {
      AppMethodBeat.o(42808);
      return true;
    }
    AppMethodBeat.o(42808);
    return false;
  }
  
  public static boolean bdt()
  {
    AppMethodBeat.i(239329);
    if (bdg() == 0)
    {
      AppMethodBeat.o(239329);
      return true;
    }
    AppMethodBeat.o(239329);
    return false;
  }
  
  public static boolean bdu()
  {
    AppMethodBeat.i(239331);
    h.aHH();
    int i = ((Integer)h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.ConfigStorageLogic", "isCNPayWalletRegion() walletRegion:%s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(239331);
      return true;
    }
    AppMethodBeat.o(239331);
    return false;
  }
  
  public static boolean bdv()
  {
    AppMethodBeat.i(42809);
    if ((bdn() & 0x20) == 0)
    {
      AppMethodBeat.o(42809);
      return true;
    }
    AppMethodBeat.o(42809);
    return false;
  }
  
  public static boolean bdw()
  {
    AppMethodBeat.i(42810);
    if ((bdd() & 0x1000) != 0)
    {
      AppMethodBeat.o(42810);
      return true;
    }
    AppMethodBeat.o(42810);
    return false;
  }
  
  public static boolean bdx()
  {
    AppMethodBeat.i(42811);
    cj localcj = ((n)h.ae(n.class)).bbU().aPi("@t.qq.com");
    if ((localcj != null) && (localcj.isEnable()))
    {
      AppMethodBeat.o(42811);
      return true;
    }
    AppMethodBeat.o(42811);
    return false;
  }
  
  public static boolean bdy()
  {
    AppMethodBeat.i(42812);
    if ((bdn() & 0x2) == 0)
    {
      AppMethodBeat.o(42812);
      return true;
    }
    AppMethodBeat.o(42812);
    return false;
  }
  
  public static boolean bdz()
  {
    AppMethodBeat.i(42813);
    if ((bdn() & 0x10) == 0)
    {
      AppMethodBeat.o(42813);
      return true;
    }
    AppMethodBeat.o(42813);
    return false;
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
    if ((paramString2 != null) && (paramString2.length() > 0) && ((as.bvH(paramString2)) || (as.bvJ(paramString2))))
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
      if (u.bBQ(paramString1) < 65536L)
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
      long l = u.bBQ(paramString1);
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
    h.aHH();
    String str = Util.nullAsNil((String)h.aHG().aHp().b(5, null));
    AppMethodBeat.o(42791);
    return str;
  }
  
  private static void q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42827);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    h.aHH();
    if (h.aHG() != null)
    {
      h.aHH();
      if (h.aHG().aHp() != null)
      {
        h.aHH();
        h.aHG().aHp().i(327682, localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(42827);
  }
  
  private static void r(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42828);
    paramMap.clear();
    h.aHH();
    if (h.aHG() != null)
    {
      h.aHH();
      if (h.aHG().aHp() != null) {}
    }
    else
    {
      Log.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      AppMethodBeat.o(42828);
      return;
    }
    h.aHH();
    Object localObject = (String)h.aHG().aHp().b(327682, null);
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
  
  public static void uI(int paramInt)
  {
    AppMethodBeat.i(239314);
    Log.printInfoStack("MicroMsg.ConfigStorageLogic", "[setAuthDeviceFlag] flag=%s", new Object[] { Integer.valueOf(paramInt) });
    lsw = paramInt;
    AppMethodBeat.o(239314);
  }
  
  public static boolean uJ(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.z
 * JD-Core Version:    0.7.0.1
 */