package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class r
{
  public static boolean ZA()
  {
    AppMethodBeat.i(59754);
    if ((Zr() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Zr()) });
      AppMethodBeat.o(59754);
      return bool;
    }
  }
  
  public static boolean ZB()
  {
    AppMethodBeat.i(59755);
    g.RM();
    g.RL().Ru().dww();
    if (Zu() == 1)
    {
      AppMethodBeat.o(59755);
      return true;
    }
    AppMethodBeat.o(59755);
    return false;
  }
  
  public static boolean ZC()
  {
    AppMethodBeat.i(59756);
    g.RM();
    g.RL().Ru().dww();
    if (Zu() == 2)
    {
      AppMethodBeat.o(59756);
      return true;
    }
    AppMethodBeat.o(59756);
    return false;
  }
  
  public static boolean ZD()
  {
    AppMethodBeat.i(59757);
    g.RM();
    g.RL().Ru().dww();
    if (Zu() == 4)
    {
      AppMethodBeat.o(59757);
      return true;
    }
    AppMethodBeat.o(59757);
    return false;
  }
  
  public static boolean ZE()
  {
    AppMethodBeat.i(59758);
    if ((Zy() & 0x20) == 0)
    {
      AppMethodBeat.o(59758);
      return true;
    }
    AppMethodBeat.o(59758);
    return false;
  }
  
  public static boolean ZF()
  {
    AppMethodBeat.i(59759);
    if ((Zr() & 0x1000) != 0)
    {
      AppMethodBeat.o(59759);
      return true;
    }
    AppMethodBeat.o(59759);
    return false;
  }
  
  public static boolean ZG()
  {
    AppMethodBeat.i(59760);
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YI().TL("@t.qq.com");
    if ((localbq != null) && (localbq.isEnable()))
    {
      AppMethodBeat.o(59760);
      return true;
    }
    AppMethodBeat.o(59760);
    return false;
  }
  
  public static boolean ZH()
  {
    AppMethodBeat.i(59761);
    if ((Zy() & 0x2) == 0)
    {
      AppMethodBeat.o(59761);
      return true;
    }
    AppMethodBeat.o(59761);
    return false;
  }
  
  public static boolean ZI()
  {
    AppMethodBeat.i(59762);
    if ((Zy() & 0x10) == 0)
    {
      AppMethodBeat.o(59762);
      return true;
    }
    AppMethodBeat.o(59762);
    return false;
  }
  
  public static boolean ZJ()
  {
    AppMethodBeat.i(59763);
    if ((Zy() & 0x80) == 0)
    {
      AppMethodBeat.o(59763);
      return true;
    }
    AppMethodBeat.o(59763);
    return false;
  }
  
  public static boolean ZK()
  {
    AppMethodBeat.i(59764);
    if ((Zy() & 0x80000) == 0)
    {
      AppMethodBeat.o(59764);
      return true;
    }
    AppMethodBeat.o(59764);
    return false;
  }
  
  public static boolean ZL()
  {
    AppMethodBeat.i(59765);
    if ((Zy() & 0x40000) == 0)
    {
      AppMethodBeat.o(59765);
      return true;
    }
    AppMethodBeat.o(59765);
    return false;
  }
  
  public static boolean ZM()
  {
    AppMethodBeat.i(59766);
    if ((Zy() & 0x2000) == 0)
    {
      AppMethodBeat.o(59766);
      return true;
    }
    AppMethodBeat.o(59766);
    return false;
  }
  
  public static boolean ZN()
  {
    AppMethodBeat.i(59767);
    if ((Zy() & 0x10000) == 0)
    {
      AppMethodBeat.o(59767);
      return true;
    }
    AppMethodBeat.o(59767);
    return false;
  }
  
  public static boolean ZO()
  {
    AppMethodBeat.i(59768);
    if ((Zy() & 0x8000000) == 0)
    {
      AppMethodBeat.o(59768);
      return true;
    }
    AppMethodBeat.o(59768);
    return false;
  }
  
  public static boolean ZP()
  {
    AppMethodBeat.i(59769);
    g.RM();
    String str = (String)g.RL().Ru().get(65825, null);
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(59769);
      return false;
    }
    if (str.equals("0"))
    {
      AppMethodBeat.o(59769);
      return false;
    }
    try
    {
      long l = bo.c(Long.valueOf(bo.getLong(str, 0L)));
      if (l == 0L)
      {
        AppMethodBeat.o(59769);
        return false;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(59769);
      return false;
    }
    AppMethodBeat.o(59769);
    return true;
  }
  
  public static boolean ZQ()
  {
    AppMethodBeat.i(59770);
    if ((Zy() & 0x1) == 0)
    {
      AppMethodBeat.o(59770);
      return true;
    }
    AppMethodBeat.o(59770);
    return false;
  }
  
  public static boolean ZR()
  {
    AppMethodBeat.i(59771);
    if ((Zr() & 0x20000) == 0)
    {
      AppMethodBeat.o(59771);
      return true;
    }
    AppMethodBeat.o(59771);
    return false;
  }
  
  public static ad ZS()
  {
    AppMethodBeat.i(59772);
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(Zn());
    if ((localad != null) && ((int)localad.euF > 0))
    {
      AppMethodBeat.o(59772);
      return localad;
    }
    localad = new ad();
    g.RM();
    String str1 = (String)g.RL().Ru().get(2, null);
    g.RM();
    String str2 = (String)g.RL().Ru().get(4, null);
    localad.setUsername(str1);
    localad.jp(str2);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().Y(localad);
    localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(str1);
    AppMethodBeat.o(59772);
    return localad;
  }
  
  public static boolean ZT()
  {
    AppMethodBeat.i(59774);
    g.RM();
    if (new p(bo.g((Integer)g.RL().Ru().get(9, null))).longValue() != 0L)
    {
      AppMethodBeat.o(59774);
      return true;
    }
    AppMethodBeat.o(59774);
    return false;
  }
  
  public static Boolean ZU()
  {
    AppMethodBeat.i(59778);
    if (!g.RG())
    {
      ab.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(59778);
      return localObject;
    }
    g.RM();
    Object localObject = (String)g.RL().Ru().get(6, null);
    g.RM();
    if ((bo.e((Boolean)g.RL().Ru().get(340241, null)) == true) && (!bo.isNullOrNil((String)localObject))) {
      if (!((String)localObject).startsWith("+")) {
        break label135;
      }
    }
    label135:
    for (localObject = com.tencent.mm.sdk.platformtools.av.RC((String)localObject);; localObject = "86")
    {
      if (localObject == "86")
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(59778);
        return localObject;
      }
      localObject = Boolean.TRUE;
      AppMethodBeat.o(59778);
      return localObject;
      localObject = Boolean.FALSE;
      AppMethodBeat.o(59778);
      return localObject;
    }
  }
  
  public static Map<String, String> ZV()
  {
    AppMethodBeat.i(59779);
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", Zn());
    g.RM();
    localHashMap.put("login_user_name", (String)g.RL().Ru().get(ac.a.yJS, null));
    g.RM();
    localHashMap.put("last_avatar_path", (String)g.RL().Ru().get(ac.a.yJT, null));
    g.RM();
    localHashMap.put("last_login_bind_mobile", (String)g.RL().Ru().get(6, null));
    g.RM();
    localHashMap.put("last_login_bind_email", (String)g.RL().Ru().get(5, null));
    g.RM();
    localHashMap.put("last_login_bind_qq", String.valueOf(g.RL().Ru().get(9, null)));
    g.RM();
    localHashMap.put("last_login_use_voice", String.valueOf(g.RL().Ru().get(40, null)));
    localHashMap.put("last_bind_info", av.flM.Y("last_bind_info", ""));
    AppMethodBeat.o(59779);
    return localHashMap;
  }
  
  public static int Zm()
  {
    AppMethodBeat.i(59740);
    g.RM();
    Integer localInteger = (Integer)g.RL().Ru().get(9, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(59740);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(59740);
    return i;
  }
  
  public static String Zn()
  {
    AppMethodBeat.i(59742);
    g.RM();
    String str = (String)g.RL().Ru().get(2, null);
    AppMethodBeat.o(59742);
    return str;
  }
  
  public static String Zo()
  {
    AppMethodBeat.i(59743);
    g.RM();
    String str = (String)g.RL().Ru().get(42, null);
    AppMethodBeat.o(59743);
    return str;
  }
  
  public static String Zp()
  {
    AppMethodBeat.i(59744);
    g.RM();
    String str = (String)g.RL().Ru().get(4, null);
    AppMethodBeat.o(59744);
    return str;
  }
  
  public static String Zq()
  {
    AppMethodBeat.i(59745);
    String str = Zo();
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(59745);
      return str;
    }
    str = Zn();
    AppMethodBeat.o(59745);
    return str;
  }
  
  public static int Zr()
  {
    AppMethodBeat.i(59746);
    g.RM();
    Integer localInteger = (Integer)g.RL().Ru().get(7, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(59746);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(59746);
    return i;
  }
  
  public static long Zs()
  {
    AppMethodBeat.i(59747);
    g.RM();
    Long localLong = (Long)g.RL().Ru().get(147457, null);
    if (localLong == null)
    {
      AppMethodBeat.o(59747);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(59747);
    return l;
  }
  
  public static int Zt()
  {
    AppMethodBeat.i(59748);
    g.RM();
    Integer localInteger = (Integer)g.RL().Ru().get(40, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(59748);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(59748);
    return i;
  }
  
  public static int Zu()
  {
    AppMethodBeat.i(59749);
    g.RM();
    Integer localInteger = (Integer)g.RL().Ru().get(339975, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(59749);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(59749);
    return i;
  }
  
  public static boolean Zv()
  {
    AppMethodBeat.i(59750);
    if ((Zt() & 0x4000) != 0)
    {
      AppMethodBeat.o(59750);
      return true;
    }
    AppMethodBeat.o(59750);
    return false;
  }
  
  public static boolean Zw()
  {
    AppMethodBeat.i(59751);
    if ((Zt() & 0x8000) != 0)
    {
      AppMethodBeat.o(59751);
      return true;
    }
    AppMethodBeat.o(59751);
    return false;
  }
  
  public static void Zx()
  {
    AppMethodBeat.i(59752);
    int i = Zt();
    g.RM();
    g.RL().Ru().set(40, Integer.valueOf(i | 0x8000));
    AppMethodBeat.o(59752);
  }
  
  public static int Zy()
  {
    AppMethodBeat.i(59753);
    g.RM();
    Integer localInteger = (Integer)g.RL().Ru().get(34, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(59753);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(59753);
    return i;
  }
  
  public static boolean Zz()
  {
    AppMethodBeat.i(141740);
    if ((Zr() & 0x40) != 0)
    {
      AppMethodBeat.o(141740);
      return true;
    }
    AppMethodBeat.o(141740);
    return false;
  }
  
  public static boolean g(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(59775);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
      AppMethodBeat.o(59775);
      return false;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && ((ad.arc(paramString2)) || (ad.are(paramString2))))
    {
      AppMethodBeat.o(59775);
      return false;
    }
    paramString2 = new BitmapFactory.Options();
    int i;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      ab.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label214;
      }
      ab.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
      AppMethodBeat.o(59775);
      return true;
      if (com.tencent.mm.vfs.e.avI(paramString1) < 65536L)
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
        ab.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d1 + ", height = " + d2);
        i = 1;
      }
    }
    label214:
    double d1 = paramString2.outWidth;
    double d2 = paramString2.outHeight;
    if ((d1 / d2 >= 2.5D) || (d2 / d1 >= 2.5D))
    {
      long l = com.tencent.mm.vfs.e.avI(paramString1);
      if (l < 26214400L)
      {
        ab.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
        AppMethodBeat.o(59775);
        return true;
      }
      ab.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
      AppMethodBeat.o(59775);
      return false;
    }
    if (!paramBoolean)
    {
      AppMethodBeat.o(59775);
      return true;
    }
    AppMethodBeat.o(59775);
    return false;
  }
  
  public static String getUserBindEmail()
  {
    AppMethodBeat.i(59741);
    g.RM();
    String str = bo.nullAsNil((String)g.RL().Ru().get(5, null));
    AppMethodBeat.o(59741);
    return str;
  }
  
  public static boolean kt(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  public static void m(Map<String, String> paramMap)
  {
    AppMethodBeat.i(59776);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    g.RM();
    if (g.RL() != null)
    {
      g.RM();
      if (g.RL().Ru() != null)
      {
        g.RM();
        g.RL().Ru().set(327682, localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(59776);
  }
  
  public static void n(Map<String, String> paramMap)
  {
    AppMethodBeat.i(59777);
    paramMap.clear();
    g.RM();
    if (g.RL() != null)
    {
      g.RM();
      if (g.RL().Ru() != null) {}
    }
    else
    {
      ab.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      AppMethodBeat.o(59777);
      return;
    }
    g.RM();
    Object localObject = (String)g.RL().Ru().get(327682, null);
    if (localObject == null)
    {
      AppMethodBeat.o(59777);
      return;
    }
    localObject = ((String)localObject).split("\n");
    if (localObject.length % 2 != 0)
    {
      ab.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(localObject.length));
      AppMethodBeat.o(59777);
      return;
    }
    int i = 0;
    while (i < localObject.length)
    {
      paramMap.put(localObject[i], localObject[(i + 1)]);
      i += 2;
    }
    AppMethodBeat.o(59777);
  }
  
  public static boolean nB(String paramString)
  {
    AppMethodBeat.i(59739);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(59739);
      return false;
    }
    String str = Zn();
    if ((str == null) || (str.length() <= 0))
    {
      ab.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
      AppMethodBeat.o(59739);
      return false;
    }
    boolean bool = str.equals(paramString);
    AppMethodBeat.o(59739);
    return bool;
  }
  
  public static j.b u(int paramInt, String paramString)
  {
    AppMethodBeat.i(59773);
    switch (paramInt)
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz().c(paramString);
      AppMethodBeat.o(59773);
      return paramString;
      paramString = new com.tencent.mm.az.j(paramString, 2);
      continue;
      paramString = new com.tencent.mm.az.j(paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.r
 * JD-Core Version:    0.7.0.1
 */