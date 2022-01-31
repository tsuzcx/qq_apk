package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.o;
import com.tencent.mm.ay.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public final class q
{
  public static boolean GA()
  {
    return (Gn() & 0x1000) != 0;
  }
  
  public static boolean GB()
  {
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com");
    return (localbq != null) && (localbq.isEnable());
  }
  
  public static boolean GC()
  {
    return (Gu() & 0x2) == 0;
  }
  
  public static boolean GD()
  {
    return (Gu() & 0x10) == 0;
  }
  
  public static boolean GE()
  {
    return (Gu() & 0x80) == 0;
  }
  
  public static boolean GF()
  {
    g.DQ();
    return bk.d((Boolean)g.DP().Dz().get(8200, null));
  }
  
  public static boolean GG()
  {
    return (Gu() & 0x80000) == 0;
  }
  
  public static boolean GH()
  {
    return (Gu() & 0x40000) == 0;
  }
  
  public static boolean GI()
  {
    return (Gu() & 0x2000) == 0;
  }
  
  public static boolean GJ()
  {
    return (Gu() & 0x10000) == 0;
  }
  
  public static boolean GK()
  {
    return (Gu() & 0x8000000) == 0;
  }
  
  public static boolean GL()
  {
    g.DQ();
    String str = (String)g.DP().Dz().get(65825, null);
    if (bk.bl(str)) {
      return false;
    }
    if (str.equals("0")) {
      return false;
    }
    try
    {
      long l = bk.c(Long.valueOf(bk.getLong(str, 0L)));
      if (l == 0L) {
        return false;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return true;
  }
  
  public static boolean GM()
  {
    return (Gu() & 0x1) == 0;
  }
  
  public static boolean GN()
  {
    return (Gn() & 0x20000) == 0;
  }
  
  public static int GO()
  {
    g.DQ();
    return bk.a((Integer)g.DP().Dz().get(8201, null), 22);
  }
  
  public static int GP()
  {
    g.DQ();
    return bk.a((Integer)g.DP().Dz().get(8208, null), 8);
  }
  
  public static ad GQ()
  {
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(Gj());
    if ((localad != null) && ((int)localad.dBe > 0)) {
      return localad;
    }
    localad = new ad();
    g.DQ();
    String str1 = (String)g.DP().Dz().get(2, null);
    g.DQ();
    String str2 = (String)g.DP().Dz().get(4, null);
    localad.setUsername(str1);
    localad.dk(str2);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().V(localad);
    return ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str1);
  }
  
  public static boolean GR()
  {
    g.DQ();
    return new o(bk.g((Integer)g.DP().Dz().get(9, null))).longValue() != 0L;
  }
  
  public static Boolean GS()
  {
    if (!g.DK())
    {
      y.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      return Boolean.valueOf(false);
    }
    g.DQ();
    String str = (String)g.DP().Dz().get(6, null);
    g.DQ();
    if ((Boolean.valueOf(bk.d((Boolean)g.DP().Dz().get(340241, null))).booleanValue() == true) && (!bk.bl(str))) {
      if (!str.startsWith("+")) {
        break label112;
      }
    }
    label112:
    for (str = ar.Ga(str);; str = "86")
    {
      if (str == "86") {
        return Boolean.valueOf(false);
      }
      return Boolean.valueOf(true);
      return Boolean.valueOf(false);
    }
  }
  
  public static Map<String, String> GT()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", Gj());
    g.DQ();
    localHashMap.put("login_user_name", (String)g.DP().Dz().get(ac.a.uze, null));
    g.DQ();
    localHashMap.put("last_avatar_path", (String)g.DP().Dz().get(ac.a.uzf, null));
    g.DQ();
    localHashMap.put("last_login_bind_mobile", (String)g.DP().Dz().get(6, null));
    g.DQ();
    localHashMap.put("last_login_bind_email", (String)g.DP().Dz().get(5, null));
    g.DQ();
    localHashMap.put("last_login_bind_qq", String.valueOf(g.DP().Dz().get(9, null)));
    g.DQ();
    localHashMap.put("last_login_use_voice", String.valueOf(g.DP().Dz().get(40, null)));
    return localHashMap;
  }
  
  public static int Gi()
  {
    g.DQ();
    Integer localInteger = (Integer)g.DP().Dz().get(9, null);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static String Gj()
  {
    g.DQ();
    return (String)g.DP().Dz().get(2, null);
  }
  
  public static String Gk()
  {
    g.DQ();
    return (String)g.DP().Dz().get(42, null);
  }
  
  public static String Gl()
  {
    g.DQ();
    return (String)g.DP().Dz().get(4, null);
  }
  
  public static String Gm()
  {
    String str = Gk();
    if (!bk.bl(str)) {
      return str;
    }
    return Gj();
  }
  
  public static int Gn()
  {
    g.DQ();
    Integer localInteger = (Integer)g.DP().Dz().get(7, null);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static long Go()
  {
    g.DQ();
    Long localLong = (Long)g.DP().Dz().get(147457, null);
    if (localLong == null) {
      return 0L;
    }
    return localLong.longValue();
  }
  
  public static int Gp()
  {
    g.DQ();
    Integer localInteger = (Integer)g.DP().Dz().get(40, null);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static int Gq()
  {
    g.DQ();
    Integer localInteger = (Integer)g.DP().Dz().get(339975, null);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static boolean Gr()
  {
    return (Gp() & 0x4000) != 0;
  }
  
  public static boolean Gs()
  {
    return (Gp() & 0x8000) != 0;
  }
  
  public static void Gt()
  {
    int i = Gp();
    g.DQ();
    g.DP().Dz().o(40, Integer.valueOf(i | 0x8000));
  }
  
  public static int Gu()
  {
    g.DQ();
    Integer localInteger = (Integer)g.DP().Dz().get(34, null);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public static boolean Gv()
  {
    if ((Gn() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Gn()) });
      return bool;
    }
  }
  
  public static boolean Gw()
  {
    g.DQ();
    g.DP().Dz().mC(true);
    return Gq() == 1;
  }
  
  public static boolean Gx()
  {
    g.DQ();
    g.DP().Dz().mC(true);
    return Gq() == 2;
  }
  
  public static boolean Gy()
  {
    g.DQ();
    g.DP().Dz().mC(true);
    return Gq() == 4;
  }
  
  public static boolean Gz()
  {
    return (Gu() & 0x20) == 0;
  }
  
  public static boolean g(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      y.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
    }
    label193:
    do
    {
      do
      {
        return false;
      } while ((paramString2 != null) && (paramString2.length() > 0) && ((ad.aaR(paramString2)) || (ad.aaT(paramString2))));
      paramString2 = new BitmapFactory.Options();
      int i;
      if ((paramString1 == null) || (paramString1.length() == 0))
      {
        y.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label193;
        }
        y.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
        return true;
        if (com.tencent.mm.vfs.e.aeQ(paramString1) < 65536L)
        {
          i = 1;
        }
        else
        {
          paramString2.inJustDecodeBounds = true;
          MMBitmapFactory.decodeFile(paramString1, paramString2, null, 0, new int[0]);
          d1 = paramString2.outWidth;
          d2 = paramString2.outHeight;
          if ((d1 >= 100.0D) || (d2 >= 100.0D)) {
            break;
          }
          y.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d1 + ", height = " + d2);
          i = 1;
        }
      }
      double d1 = paramString2.outWidth;
      double d2 = paramString2.outHeight;
      if ((d1 / d2 >= 2.5D) || (d2 / d1 >= 2.5D))
      {
        long l = com.tencent.mm.vfs.e.aeQ(paramString1);
        if (l < 26214400L)
        {
          y.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
          return true;
        }
        y.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", new Object[] { Double.valueOf(2.5D), Long.valueOf(l) });
        return false;
      }
    } while (paramBoolean);
    return true;
  }
  
  public static boolean gS(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return false;
    }
    String str = Gj();
    if ((str == null) || (str.length() <= 0))
    {
      y.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
      return false;
    }
    return str.equals(paramString);
  }
  
  public static String getUserBindEmail()
  {
    g.DQ();
    return bk.pm((String)g.DP().Dz().get(5, null));
  }
  
  public static boolean hH(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  public static void i(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    g.DQ();
    if (g.DP() != null)
    {
      g.DQ();
      if (g.DP().Dz() != null)
      {
        g.DQ();
        g.DP().Dz().o(327682, localStringBuilder.toString());
      }
    }
  }
  
  public static void j(Map<String, String> paramMap)
  {
    paramMap.clear();
    g.DQ();
    if (g.DP() != null)
    {
      g.DQ();
      if (g.DP().Dz() != null) {}
    }
    else
    {
      y.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
    }
    for (;;)
    {
      return;
      g.DQ();
      Object localObject = (String)g.DP().Dz().get(327682, null);
      if (localObject != null)
      {
        localObject = ((String)localObject).split("\n");
        if (localObject.length % 2 != 0)
        {
          y.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(localObject.length));
          return;
        }
        int i = 0;
        while (i < localObject.length)
        {
          paramMap.put(localObject[i], localObject[(i + 1)]);
          i += 2;
        }
      }
    }
  }
  
  public static i.b n(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      paramString = null;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(paramString);
      return paramString;
      paramString = new i(paramString, 2);
      continue;
      paramString = new i(paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.q
 * JD-Core Version:    0.7.0.1
 */