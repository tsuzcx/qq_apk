package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class u
{
  public static int axA()
  {
    AppMethodBeat.i(42796);
    g.agS();
    Integer localInteger = (Integer)g.agR().agA().get(7, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42796);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42796);
    return i;
  }
  
  public static long axB()
  {
    AppMethodBeat.i(42797);
    g.agS();
    Long localLong = (Long)g.agR().agA().get(147457, null);
    if (localLong == null)
    {
      AppMethodBeat.o(42797);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(42797);
    return l;
  }
  
  public static int axC()
  {
    AppMethodBeat.i(42798);
    g.agS();
    Integer localInteger = (Integer)g.agR().agA().get(40, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42798);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42798);
    return i;
  }
  
  public static int axD()
  {
    AppMethodBeat.i(42799);
    g.agS();
    Integer localInteger = (Integer)g.agR().agA().get(339975, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42799);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42799);
    return i;
  }
  
  public static String axE()
  {
    AppMethodBeat.i(163507);
    g.agS();
    String str = (String)g.agR().agA().get(ah.a.GTQ, "");
    ac.i("MicroMsg.ConfigStorageLogic", "get my finder username %s", new Object[] { str });
    AppMethodBeat.o(163507);
    return str;
  }
  
  public static boolean axF()
  {
    AppMethodBeat.i(42800);
    if ((axC() & 0x4000) != 0)
    {
      AppMethodBeat.o(42800);
      return true;
    }
    AppMethodBeat.o(42800);
    return false;
  }
  
  public static boolean axG()
  {
    AppMethodBeat.i(42801);
    if ((axC() & 0x8000) != 0)
    {
      AppMethodBeat.o(42801);
      return true;
    }
    AppMethodBeat.o(42801);
    return false;
  }
  
  public static void axH()
  {
    AppMethodBeat.i(42802);
    int i = axC();
    g.agS();
    g.agR().agA().set(40, Integer.valueOf(i | 0x8000));
    AppMethodBeat.o(42802);
  }
  
  public static int axI()
  {
    AppMethodBeat.i(42803);
    g.agS();
    Integer localInteger = (Integer)g.agR().agA().get(34, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42803);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42803);
    return i;
  }
  
  public static boolean axJ()
  {
    AppMethodBeat.i(42804);
    if ((axA() & 0x40) != 0)
    {
      AppMethodBeat.o(42804);
      return true;
    }
    AppMethodBeat.o(42804);
    return false;
  }
  
  public static boolean axK()
  {
    AppMethodBeat.i(42805);
    if ((axA() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(axA()) });
      AppMethodBeat.o(42805);
      return bool;
    }
  }
  
  public static boolean axL()
  {
    AppMethodBeat.i(42806);
    g.agS();
    g.agR().agA().faa();
    if (axD() == 1)
    {
      AppMethodBeat.o(42806);
      return true;
    }
    AppMethodBeat.o(42806);
    return false;
  }
  
  public static boolean axM()
  {
    AppMethodBeat.i(42807);
    g.agS();
    g.agR().agA().faa();
    if (axD() == 2)
    {
      AppMethodBeat.o(42807);
      return true;
    }
    AppMethodBeat.o(42807);
    return false;
  }
  
  public static boolean axN()
  {
    AppMethodBeat.i(42808);
    g.agS();
    g.agR().agA().faa();
    if (axD() == 4)
    {
      AppMethodBeat.o(42808);
      return true;
    }
    AppMethodBeat.o(42808);
    return false;
  }
  
  public static boolean axO()
  {
    AppMethodBeat.i(42809);
    if ((axI() & 0x20) == 0)
    {
      AppMethodBeat.o(42809);
      return true;
    }
    AppMethodBeat.o(42809);
    return false;
  }
  
  public static boolean axP()
  {
    AppMethodBeat.i(42810);
    if ((axA() & 0x1000) != 0)
    {
      AppMethodBeat.o(42810);
      return true;
    }
    AppMethodBeat.o(42810);
    return false;
  }
  
  public static boolean axQ()
  {
    AppMethodBeat.i(42811);
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().alJ("@t.qq.com");
    if ((localbu != null) && (localbu.isEnable()))
    {
      AppMethodBeat.o(42811);
      return true;
    }
    AppMethodBeat.o(42811);
    return false;
  }
  
  public static boolean axR()
  {
    AppMethodBeat.i(42812);
    if ((axI() & 0x2) == 0)
    {
      AppMethodBeat.o(42812);
      return true;
    }
    AppMethodBeat.o(42812);
    return false;
  }
  
  public static boolean axS()
  {
    AppMethodBeat.i(42813);
    if ((axI() & 0x10) == 0)
    {
      AppMethodBeat.o(42813);
      return true;
    }
    AppMethodBeat.o(42813);
    return false;
  }
  
  public static boolean axT()
  {
    AppMethodBeat.i(42814);
    if ((axI() & 0x80) == 0)
    {
      AppMethodBeat.o(42814);
      return true;
    }
    AppMethodBeat.o(42814);
    return false;
  }
  
  public static boolean axU()
  {
    AppMethodBeat.i(42815);
    if ((axI() & 0x80000) == 0)
    {
      AppMethodBeat.o(42815);
      return true;
    }
    AppMethodBeat.o(42815);
    return false;
  }
  
  public static boolean axV()
  {
    AppMethodBeat.i(42816);
    if ((axI() & 0x40000) == 0)
    {
      AppMethodBeat.o(42816);
      return true;
    }
    AppMethodBeat.o(42816);
    return false;
  }
  
  public static boolean axW()
  {
    AppMethodBeat.i(42817);
    if ((axI() & 0x2000) == 0)
    {
      AppMethodBeat.o(42817);
      return true;
    }
    AppMethodBeat.o(42817);
    return false;
  }
  
  public static boolean axX()
  {
    AppMethodBeat.i(42818);
    if ((axI() & 0x10000) == 0)
    {
      AppMethodBeat.o(42818);
      return true;
    }
    AppMethodBeat.o(42818);
    return false;
  }
  
  public static boolean axY()
  {
    AppMethodBeat.i(42819);
    if ((axI() & 0x8000000) == 0)
    {
      AppMethodBeat.o(42819);
      return true;
    }
    AppMethodBeat.o(42819);
    return false;
  }
  
  public static boolean axZ()
  {
    AppMethodBeat.i(42820);
    g.agS();
    String str = (String)g.agR().agA().get(65825, null);
    if (bs.isNullOrNil(str))
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
      long l = bs.g(Long.valueOf(bs.getLong(str, 0L)));
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
  
  public static int axv()
  {
    AppMethodBeat.i(42790);
    g.agS();
    Integer localInteger = (Integer)g.agR().agA().get(9, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42790);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42790);
    return i;
  }
  
  public static String axw()
  {
    AppMethodBeat.i(42792);
    g.agS();
    String str = (String)g.agR().agA().get(2, null);
    AppMethodBeat.o(42792);
    return str;
  }
  
  public static String axx()
  {
    AppMethodBeat.i(42793);
    g.agS();
    String str = (String)g.agR().agA().get(42, null);
    AppMethodBeat.o(42793);
    return str;
  }
  
  public static String axy()
  {
    AppMethodBeat.i(42794);
    g.agS();
    String str = (String)g.agR().agA().get(4, null);
    AppMethodBeat.o(42794);
    return str;
  }
  
  public static String axz()
  {
    AppMethodBeat.i(42795);
    String str = axx();
    if (!bs.isNullOrNil(str))
    {
      AppMethodBeat.o(42795);
      return str;
    }
    str = axw();
    AppMethodBeat.o(42795);
    return str;
  }
  
  public static boolean aya()
  {
    AppMethodBeat.i(42821);
    if ((axI() & 0x1) == 0)
    {
      AppMethodBeat.o(42821);
      return true;
    }
    AppMethodBeat.o(42821);
    return false;
  }
  
  public static boolean ayb()
  {
    AppMethodBeat.i(42822);
    if ((axA() & 0x20000) == 0)
    {
      AppMethodBeat.o(42822);
      return true;
    }
    AppMethodBeat.o(42822);
    return false;
  }
  
  public static ai ayc()
  {
    AppMethodBeat.i(42823);
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(axw());
    if ((localai != null) && ((int)localai.fLJ > 0))
    {
      AppMethodBeat.o(42823);
      return localai;
    }
    localai = new ai();
    g.agS();
    String str1 = (String)g.agR().agA().get(2, null);
    g.agS();
    String str2 = (String)g.agR().agA().get(4, null);
    localai.setUsername(str1);
    localai.qj(str2);
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().ag(localai);
    localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str1);
    AppMethodBeat.o(42823);
    return localai;
  }
  
  public static boolean ayd()
  {
    AppMethodBeat.i(42825);
    g.agS();
    if (new p(bs.m((Integer)g.agR().agA().get(9, null))).longValue() != 0L)
    {
      AppMethodBeat.o(42825);
      return true;
    }
    AppMethodBeat.o(42825);
    return false;
  }
  
  public static Boolean aye()
  {
    AppMethodBeat.i(42829);
    if (!g.agM())
    {
      ac.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(42829);
      return localObject;
    }
    g.agS();
    Object localObject = (String)g.agR().agA().get(6, null);
    g.agS();
    if ((bs.l((Boolean)g.agR().agA().get(340241, null)) == true) && (!bs.isNullOrNil((String)localObject))) {
      if (!((String)localObject).startsWith("+")) {
        break label144;
      }
    }
    label144:
    for (localObject = az.ajo((String)localObject);; localObject = "86")
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
  
  public static Map<String, String> ayf()
  {
    AppMethodBeat.i(42830);
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", axw());
    g.agS();
    localHashMap.put("login_user_name", (String)g.agR().agA().get(ah.a.GQW, null));
    g.agS();
    localHashMap.put("last_avatar_path", (String)g.agR().agA().get(ah.a.GQX, null));
    g.agS();
    localHashMap.put("last_login_bind_mobile", (String)g.agR().agA().get(6, null));
    g.agS();
    localHashMap.put("last_login_bind_email", (String)g.agR().agA().get(5, null));
    g.agS();
    localHashMap.put("last_login_bind_qq", String.valueOf(g.agR().agA().get(9, null)));
    g.agS();
    localHashMap.put("last_login_use_voice", String.valueOf(g.agR().agA().get(40, null)));
    localHashMap.put("last_bind_info", ay.hnA.aw("last_bind_info", ""));
    AppMethodBeat.o(42830);
    return localHashMap;
  }
  
  public static int ayg()
  {
    AppMethodBeat.i(178863);
    int i = ((a)g.ab(a.class)).ZY().getInt("AssociateChatRoomDisableFuncFlag", 31);
    AppMethodBeat.o(178863);
    return i;
  }
  
  public static boolean f(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(42826);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ac.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
      AppMethodBeat.o(42826);
      return false;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && ((ai.aMZ(paramString2)) || (ai.aNb(paramString2))))
    {
      AppMethodBeat.o(42826);
      return false;
    }
    paramString2 = new BitmapFactory.Options();
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ac.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label214;
      }
      ac.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
      AppMethodBeat.o(42826);
      return true;
      if (i.aSp(paramString1) < 65536L)
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
        ac.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d1 + ", height = " + d2);
        i = 1;
      }
    }
    label214:
    double d1 = paramString2.outWidth;
    double d2 = paramString2.outHeight;
    if ((d1 / d2 >= 2.5D) || (d2 / d1 >= 2.5D))
    {
      long l = i.aSp(paramString1);
      if (l < 26214400L)
      {
        ac.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
        AppMethodBeat.o(42826);
        return true;
      }
      ac.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
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
    g.agS();
    String str = bs.nullAsNil((String)g.agR().agA().get(5, null));
    AppMethodBeat.o(42791);
    return str;
  }
  
  public static boolean nM(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  public static void o(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42827);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    g.agS();
    if (g.agR() != null)
    {
      g.agS();
      if (g.agR().agA() != null)
      {
        g.agS();
        g.agR().agA().set(327682, localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(42827);
  }
  
  public static void p(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42828);
    paramMap.clear();
    g.agS();
    if (g.agR() != null)
    {
      g.agS();
      if (g.agR().agA() != null) {}
    }
    else
    {
      ac.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      AppMethodBeat.o(42828);
      return;
    }
    g.agS();
    Object localObject = (String)g.agR().agA().get(327682, null);
    if (localObject == null)
    {
      AppMethodBeat.o(42828);
      return;
    }
    localObject = ((String)localObject).split("\n");
    if (localObject.length % 2 != 0)
    {
      ac.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(localObject.length));
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
  
  public static boolean wh(String paramString)
  {
    AppMethodBeat.i(42789);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42789);
      return false;
    }
    String str = axw();
    if ((str == null) || (str.length() <= 0))
    {
      ac.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
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