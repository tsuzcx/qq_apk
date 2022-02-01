package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class u
{
  public static int aqF()
  {
    AppMethodBeat.i(42790);
    g.afC();
    Integer localInteger = (Integer)g.afB().afk().get(9, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42790);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42790);
    return i;
  }
  
  public static String aqG()
  {
    AppMethodBeat.i(42792);
    g.afC();
    String str = (String)g.afB().afk().get(2, null);
    AppMethodBeat.o(42792);
    return str;
  }
  
  public static String aqH()
  {
    AppMethodBeat.i(42793);
    g.afC();
    String str = (String)g.afB().afk().get(42, null);
    AppMethodBeat.o(42793);
    return str;
  }
  
  public static String aqI()
  {
    AppMethodBeat.i(42794);
    g.afC();
    String str = (String)g.afB().afk().get(4, null);
    AppMethodBeat.o(42794);
    return str;
  }
  
  public static String aqJ()
  {
    AppMethodBeat.i(42795);
    String str = aqH();
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(42795);
      return str;
    }
    str = aqG();
    AppMethodBeat.o(42795);
    return str;
  }
  
  public static int aqK()
  {
    AppMethodBeat.i(42796);
    g.afC();
    Integer localInteger = (Integer)g.afB().afk().get(7, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42796);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42796);
    return i;
  }
  
  public static long aqL()
  {
    AppMethodBeat.i(42797);
    g.afC();
    Long localLong = (Long)g.afB().afk().get(147457, null);
    if (localLong == null)
    {
      AppMethodBeat.o(42797);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(42797);
    return l;
  }
  
  public static int aqM()
  {
    AppMethodBeat.i(42798);
    g.afC();
    Integer localInteger = (Integer)g.afB().afk().get(40, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42798);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42798);
    return i;
  }
  
  public static int aqN()
  {
    AppMethodBeat.i(42799);
    g.afC();
    Integer localInteger = (Integer)g.afB().afk().get(339975, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42799);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42799);
    return i;
  }
  
  public static String aqO()
  {
    AppMethodBeat.i(163507);
    g.afC();
    String str = (String)g.afB().afk().get(ae.a.FvW, "");
    ad.i("MicroMsg.ConfigStorageLogic", "get my finder username %s", new Object[] { str });
    AppMethodBeat.o(163507);
    return str;
  }
  
  public static boolean aqP()
  {
    AppMethodBeat.i(42800);
    if ((aqM() & 0x4000) != 0)
    {
      AppMethodBeat.o(42800);
      return true;
    }
    AppMethodBeat.o(42800);
    return false;
  }
  
  public static boolean aqQ()
  {
    AppMethodBeat.i(42801);
    if ((aqM() & 0x8000) != 0)
    {
      AppMethodBeat.o(42801);
      return true;
    }
    AppMethodBeat.o(42801);
    return false;
  }
  
  public static void aqR()
  {
    AppMethodBeat.i(42802);
    int i = aqM();
    g.afC();
    g.afB().afk().set(40, Integer.valueOf(i | 0x8000));
    AppMethodBeat.o(42802);
  }
  
  public static int aqS()
  {
    AppMethodBeat.i(42803);
    g.afC();
    Integer localInteger = (Integer)g.afB().afk().get(34, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42803);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42803);
    return i;
  }
  
  public static boolean aqT()
  {
    AppMethodBeat.i(42804);
    if ((aqK() & 0x40) != 0)
    {
      AppMethodBeat.o(42804);
      return true;
    }
    AppMethodBeat.o(42804);
    return false;
  }
  
  public static boolean aqU()
  {
    AppMethodBeat.i(42805);
    if ((aqK() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(aqK()) });
      AppMethodBeat.o(42805);
      return bool;
    }
  }
  
  public static boolean aqV()
  {
    AppMethodBeat.i(42806);
    g.afC();
    g.afB().afk().eKy();
    if (aqN() == 1)
    {
      AppMethodBeat.o(42806);
      return true;
    }
    AppMethodBeat.o(42806);
    return false;
  }
  
  public static boolean aqW()
  {
    AppMethodBeat.i(42807);
    g.afC();
    g.afB().afk().eKy();
    if (aqN() == 2)
    {
      AppMethodBeat.o(42807);
      return true;
    }
    AppMethodBeat.o(42807);
    return false;
  }
  
  public static boolean aqX()
  {
    AppMethodBeat.i(42808);
    g.afC();
    g.afB().afk().eKy();
    if (aqN() == 4)
    {
      AppMethodBeat.o(42808);
      return true;
    }
    AppMethodBeat.o(42808);
    return false;
  }
  
  public static boolean aqY()
  {
    AppMethodBeat.i(42809);
    if ((aqS() & 0x20) == 0)
    {
      AppMethodBeat.o(42809);
      return true;
    }
    AppMethodBeat.o(42809);
    return false;
  }
  
  public static boolean aqZ()
  {
    AppMethodBeat.i(42810);
    if ((aqK() & 0x1000) != 0)
    {
      AppMethodBeat.o(42810);
      return true;
    }
    AppMethodBeat.o(42810);
    return false;
  }
  
  public static boolean ara()
  {
    AppMethodBeat.i(42811);
    br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().agP("@t.qq.com");
    if ((localbr != null) && (localbr.isEnable()))
    {
      AppMethodBeat.o(42811);
      return true;
    }
    AppMethodBeat.o(42811);
    return false;
  }
  
  public static boolean arb()
  {
    AppMethodBeat.i(42812);
    if ((aqS() & 0x2) == 0)
    {
      AppMethodBeat.o(42812);
      return true;
    }
    AppMethodBeat.o(42812);
    return false;
  }
  
  public static boolean arc()
  {
    AppMethodBeat.i(42813);
    if ((aqS() & 0x10) == 0)
    {
      AppMethodBeat.o(42813);
      return true;
    }
    AppMethodBeat.o(42813);
    return false;
  }
  
  public static boolean ard()
  {
    AppMethodBeat.i(42814);
    if ((aqS() & 0x80) == 0)
    {
      AppMethodBeat.o(42814);
      return true;
    }
    AppMethodBeat.o(42814);
    return false;
  }
  
  public static boolean are()
  {
    AppMethodBeat.i(42815);
    if ((aqS() & 0x80000) == 0)
    {
      AppMethodBeat.o(42815);
      return true;
    }
    AppMethodBeat.o(42815);
    return false;
  }
  
  public static boolean arf()
  {
    AppMethodBeat.i(42816);
    if ((aqS() & 0x40000) == 0)
    {
      AppMethodBeat.o(42816);
      return true;
    }
    AppMethodBeat.o(42816);
    return false;
  }
  
  public static boolean arg()
  {
    AppMethodBeat.i(42817);
    if ((aqS() & 0x2000) == 0)
    {
      AppMethodBeat.o(42817);
      return true;
    }
    AppMethodBeat.o(42817);
    return false;
  }
  
  public static boolean arh()
  {
    AppMethodBeat.i(42818);
    if ((aqS() & 0x10000) == 0)
    {
      AppMethodBeat.o(42818);
      return true;
    }
    AppMethodBeat.o(42818);
    return false;
  }
  
  public static boolean ari()
  {
    AppMethodBeat.i(42819);
    if ((aqS() & 0x8000000) == 0)
    {
      AppMethodBeat.o(42819);
      return true;
    }
    AppMethodBeat.o(42819);
    return false;
  }
  
  public static boolean arj()
  {
    AppMethodBeat.i(42820);
    g.afC();
    String str = (String)g.afB().afk().get(65825, null);
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
      long l = bt.f(Long.valueOf(bt.getLong(str, 0L)));
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
  
  public static boolean ark()
  {
    AppMethodBeat.i(42821);
    if ((aqS() & 0x1) == 0)
    {
      AppMethodBeat.o(42821);
      return true;
    }
    AppMethodBeat.o(42821);
    return false;
  }
  
  public static boolean arl()
  {
    AppMethodBeat.i(42822);
    if ((aqK() & 0x20000) == 0)
    {
      AppMethodBeat.o(42822);
      return true;
    }
    AppMethodBeat.o(42822);
    return false;
  }
  
  public static af arm()
  {
    AppMethodBeat.i(42823);
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(aqG());
    if ((localaf != null) && ((int)localaf.fId > 0))
    {
      AppMethodBeat.o(42823);
      return localaf;
    }
    localaf = new af();
    g.afC();
    String str1 = (String)g.afB().afk().get(2, null);
    g.afC();
    String str2 = (String)g.afB().afk().get(4, null);
    localaf.setUsername(str1);
    localaf.nd(str2);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().af(localaf);
    localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str1);
    AppMethodBeat.o(42823);
    return localaf;
  }
  
  public static boolean arn()
  {
    AppMethodBeat.i(42825);
    g.afC();
    if (new p(bt.l((Integer)g.afB().afk().get(9, null))).longValue() != 0L)
    {
      AppMethodBeat.o(42825);
      return true;
    }
    AppMethodBeat.o(42825);
    return false;
  }
  
  public static Boolean aro()
  {
    AppMethodBeat.i(42829);
    if (!g.afw())
    {
      ad.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(42829);
      return localObject;
    }
    g.afC();
    Object localObject = (String)g.afB().afk().get(6, null);
    g.afC();
    if ((bt.l((Boolean)g.afB().afk().get(340241, null)) == true) && (!bt.isNullOrNil((String)localObject))) {
      if (!((String)localObject).startsWith("+")) {
        break label144;
      }
    }
    label144:
    for (localObject = ba.aew((String)localObject);; localObject = "86")
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
  
  public static Map<String, String> arp()
  {
    AppMethodBeat.i(42830);
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", aqG());
    g.afC();
    localHashMap.put("login_user_name", (String)g.afB().afk().get(ae.a.Ftd, null));
    g.afC();
    localHashMap.put("last_avatar_path", (String)g.afB().afk().get(ae.a.Fte, null));
    g.afC();
    localHashMap.put("last_login_bind_mobile", (String)g.afB().afk().get(6, null));
    g.afC();
    localHashMap.put("last_login_bind_email", (String)g.afB().afk().get(5, null));
    g.afC();
    localHashMap.put("last_login_bind_qq", String.valueOf(g.afB().afk().get(9, null)));
    g.afC();
    localHashMap.put("last_login_use_voice", String.valueOf(g.afB().afk().get(40, null)));
    localHashMap.put("last_bind_info", ay.gNa.ao("last_bind_info", ""));
    AppMethodBeat.o(42830);
    return localHashMap;
  }
  
  public static int arq()
  {
    AppMethodBeat.i(178863);
    int i = ((a)g.ab(a.class)).Zd().getInt("AssociateChatRoomDisableFuncFlag", 31);
    AppMethodBeat.o(178863);
    return i;
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
    if ((paramString2 != null) && (paramString2.length() > 0) && ((af.aHE(paramString2)) || (af.aHG(paramString2))))
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
      if (i.aMN(paramString1) < 65536L)
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
      long l = i.aMN(paramString1);
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
    g.afC();
    String str = bt.nullAsNil((String)g.afB().afk().get(5, null));
    AppMethodBeat.o(42791);
    return str;
  }
  
  public static boolean mY(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  public static void p(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42827);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    g.afC();
    if (g.afB() != null)
    {
      g.afC();
      if (g.afB().afk() != null)
      {
        g.afC();
        g.afB().afk().set(327682, localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(42827);
  }
  
  public static void q(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42828);
    paramMap.clear();
    g.afC();
    if (g.afB() != null)
    {
      g.afC();
      if (g.afB().afk() != null) {}
    }
    else
    {
      ad.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      AppMethodBeat.o(42828);
      return;
    }
    g.afC();
    Object localObject = (String)g.afB().afk().get(327682, null);
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
  
  public static boolean se(String paramString)
  {
    AppMethodBeat.i(42789);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42789);
      return false;
    }
    String str = aqG();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.u
 * JD-Core Version:    0.7.0.1
 */