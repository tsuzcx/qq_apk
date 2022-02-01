package com.tencent.mm.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.k;
import com.tencent.mm.b.p;
import com.tencent.mm.contact.d;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cm;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class z
{
  private static int ojU = -1;
  
  public static k.b IA(String paramString)
  {
    AppMethodBeat.i(242041);
    paramString = new k(paramString);
    ((n)h.ax(n.class)).bzz().d(paramString);
    AppMethodBeat.o(242041);
    return paramString;
  }
  
  public static String IB(String paramString)
  {
    AppMethodBeat.i(242049);
    HashMap localHashMap = new HashMap();
    y(localHashMap);
    if (localHashMap.containsKey(paramString))
    {
      paramString = (String)localHashMap.get(paramString);
      AppMethodBeat.o(242049);
      return paramString;
    }
    AppMethodBeat.o(242049);
    return null;
  }
  
  public static boolean Iy(String paramString)
  {
    AppMethodBeat.i(42789);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(42789);
      return false;
    }
    String str = bAM();
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
  
  public static boolean Iz(String paramString)
  {
    AppMethodBeat.i(241953);
    boolean bool = bAW().equals(paramString);
    AppMethodBeat.o(241953);
    return bool;
  }
  
  public static boolean aRx()
  {
    AppMethodBeat.i(241954);
    boolean bool = uW(bAU());
    AppMethodBeat.o(241954);
    return bool;
  }
  
  public static void aU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242046);
    HashMap localHashMap = new HashMap();
    y(localHashMap);
    localHashMap.put(paramString1, paramString2);
    x(localHashMap);
    AppMethodBeat.o(242046);
  }
  
  public static int bAL()
  {
    AppMethodBeat.i(42790);
    h.baF();
    Integer localInteger = (Integer)h.baE().ban().d(9, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42790);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42790);
    return i;
  }
  
  public static String bAM()
  {
    AppMethodBeat.i(42792);
    h.baF();
    String str = (String)h.baE().ban().d(2, null);
    AppMethodBeat.o(42792);
    return str;
  }
  
  public static String bAN()
  {
    AppMethodBeat.i(42793);
    h.baF();
    String str = (String)h.baE().ban().d(42, null);
    AppMethodBeat.o(42793);
    return str;
  }
  
  public static String bAO()
  {
    AppMethodBeat.i(42794);
    h.baF();
    String str = Util.nullAsNil((String)h.baE().ban().d(4, null));
    AppMethodBeat.o(42794);
    return str;
  }
  
  public static String bAP()
  {
    AppMethodBeat.i(42795);
    String str = bAN();
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(42795);
      return str;
    }
    str = bAM();
    AppMethodBeat.o(42795);
    return str;
  }
  
  public static int bAQ()
  {
    AppMethodBeat.i(42796);
    h.baF();
    Integer localInteger = (Integer)h.baE().ban().d(7, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42796);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42796);
    return i;
  }
  
  public static long bAR()
  {
    AppMethodBeat.i(42797);
    h.baF();
    Long localLong = (Long)h.baE().ban().d(147457, null);
    if (localLong == null)
    {
      AppMethodBeat.o(42797);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(42797);
    return l;
  }
  
  public static long bAS()
  {
    AppMethodBeat.i(241904);
    h.baF();
    Long localLong = (Long)h.baE().ban().get(at.a.adhU, null);
    if (localLong == null)
    {
      AppMethodBeat.o(241904);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(241904);
    return l;
  }
  
  public static boolean bAT()
  {
    AppMethodBeat.i(241914);
    if ((bAR() & 0x0) != 0L)
    {
      AppMethodBeat.o(241914);
      return true;
    }
    AppMethodBeat.o(241914);
    return false;
  }
  
  public static int bAU()
  {
    AppMethodBeat.i(42798);
    h.baF();
    Integer localInteger = (Integer)h.baE().ban().d(40, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42798);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42798);
    return i;
  }
  
  public static int bAV()
  {
    AppMethodBeat.i(42799);
    h.baF();
    Integer localInteger = (Integer)h.baE().ban().d(339975, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42799);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42799);
    return i;
  }
  
  public static String bAW()
  {
    AppMethodBeat.i(163507);
    h.baF();
    String str = h.baE().ban().get(at.a.acZR, "").toString();
    AppMethodBeat.o(163507);
    return str;
  }
  
  public static String bAX()
  {
    AppMethodBeat.i(241930);
    h.baF();
    String str = h.baE().ban().get(at.a.acZY, "").toString();
    AppMethodBeat.o(241930);
    return str;
  }
  
  public static void bAY()
  {
    AppMethodBeat.i(241935);
    Log.d("MicroMsg.ConfigStorageLogic", "clearLastAuthDeviceFlag:%s", new Object[] { Util.getStack() });
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt("PREF_KEY_LAST_AUTH_FLAG", -1);
    AppMethodBeat.o(241935);
  }
  
  public static int bAZ()
  {
    AppMethodBeat.i(241937);
    int i = ojU;
    if (-1 == i) {
      try
      {
        i = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).getInt("PREF_KEY_LAST_AUTH_FLAG", -1);
        if (i == -1)
        {
          AppMethodBeat.o(241937);
          return -1;
        }
        i = uV(i);
        AppMethodBeat.o(241937);
        return i;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ConfigStorageLogic", localThrowable, "getLastAuthDeviceFlagErr", new Object[0]);
        AppMethodBeat.o(241937);
        return -1;
      }
    }
    i = uV(i);
    AppMethodBeat.o(241937);
    return i;
  }
  
  public static boolean bBA()
  {
    AppMethodBeat.i(242017);
    h.baF();
    if (Util.nullAsNil((Integer)h.baE().ban().d(17, null)) == 1)
    {
      AppMethodBeat.o(242017);
      return true;
    }
    AppMethodBeat.o(242017);
    return false;
  }
  
  public static boolean bBB()
  {
    AppMethodBeat.i(42821);
    if ((bBf() & 0x1) == 0)
    {
      AppMethodBeat.o(42821);
      return true;
    }
    AppMethodBeat.o(42821);
    return false;
  }
  
  public static boolean bBC()
  {
    AppMethodBeat.i(42822);
    if ((bAQ() & 0x20000) == 0)
    {
      AppMethodBeat.o(42822);
      return true;
    }
    AppMethodBeat.o(42822);
    return false;
  }
  
  public static int bBD()
  {
    AppMethodBeat.i(242027);
    h.baF();
    int i = Util.nullAs((Integer)h.baE().ban().d(8201, null), 22);
    AppMethodBeat.o(242027);
    return i;
  }
  
  public static int bBE()
  {
    AppMethodBeat.i(242029);
    h.baF();
    int i = Util.nullAs((Integer)h.baE().ban().d(8208, null), 8);
    AppMethodBeat.o(242029);
    return i;
  }
  
  public static au bBF()
  {
    AppMethodBeat.i(42823);
    au localau = ((n)h.ax(n.class)).bzA().JE(bAM());
    if ((localau != null) && ((int)localau.maN > 0))
    {
      AppMethodBeat.o(42823);
      return localau;
    }
    localau = new au();
    h.baF();
    String str1 = (String)h.baE().ban().d(2, null);
    h.baF();
    String str2 = (String)h.baE().ban().d(4, null);
    localau.setUsername(str1);
    localau.setNickname(str2);
    ((n)h.ax(n.class)).bzA().aB(localau);
    localau = ((n)h.ax(n.class)).bzA().JE(str1);
    AppMethodBeat.o(42823);
    return localau;
  }
  
  public static boolean bBG()
  {
    AppMethodBeat.i(42825);
    h.baF();
    if (new p(Util.nullAsNil((Integer)h.baE().ban().d(9, null))).longValue() != 0L)
    {
      AppMethodBeat.o(42825);
      return true;
    }
    AppMethodBeat.o(42825);
    return false;
  }
  
  public static void bBH()
  {
    AppMethodBeat.i(242068);
    h.baF();
    h.baE().ban().B(348167, Integer.valueOf(1));
    AppMethodBeat.o(242068);
  }
  
  public static void bBI()
  {
    AppMethodBeat.i(242077);
    h.baF();
    h.baE().ban().B(348169, Integer.valueOf(1));
    AppMethodBeat.o(242077);
  }
  
  public static int bBJ()
  {
    AppMethodBeat.i(242081);
    h.baF();
    int i = ((Integer)h.baE().ban().d(348169, Integer.valueOf(0))).intValue();
    AppMethodBeat.o(242081);
    return i;
  }
  
  public static Boolean bBK()
  {
    AppMethodBeat.i(42829);
    if (!h.baz())
    {
      Log.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(42829);
      return localObject;
    }
    h.baF();
    Object localObject = (String)h.baE().ban().d(6, null);
    h.baF();
    if ((Util.nullAsFalse((Boolean)h.baE().ban().d(340241, null)) == true) && (!Util.isNullOrNil((String)localObject))) {
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
  
  public static void bBL()
  {
    AppMethodBeat.i(242090);
    int i = bAU();
    h.baF();
    h.baE().ban().B(40, Integer.valueOf(i & 0xFFFF7FFF));
    AppMethodBeat.o(242090);
  }
  
  public static Map<String, String> bBM()
  {
    AppMethodBeat.i(42830);
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_weixin_username", bAM());
    h.baF();
    localHashMap.put("login_user_name", (String)h.baE().ban().get(at.a.acWp, null));
    localHashMap.put("last_login_nick_name", bAO());
    h.baC();
    localHashMap.put("last_login_uin", b.aZs());
    h.baF();
    localHashMap.put("last_avatar_path", (String)h.baE().ban().get(at.a.acWq, null));
    h.baF();
    localHashMap.put("last_login_bind_mobile", (String)h.baE().ban().d(6, null));
    h.baF();
    localHashMap.put("last_login_bind_email", (String)h.baE().ban().d(5, null));
    h.baF();
    localHashMap.put("last_login_bind_qq", String.valueOf(h.baE().ban().d(9, null)));
    h.baF();
    localHashMap.put("last_login_use_voice", String.valueOf(h.baE().ban().d(40, null)));
    localHashMap.put("last_bind_info", bg.okT.aM("last_bind_info", ""));
    AppMethodBeat.o(42830);
    return localHashMap;
  }
  
  public static int bBN()
  {
    AppMethodBeat.i(178863);
    int i = ((a)h.ax(a.class)).aRC().getInt("AssociateChatRoomDisableFuncFlag", 31);
    AppMethodBeat.o(178863);
    return i;
  }
  
  public static int bBa()
  {
    AppMethodBeat.i(241942);
    int i = ojU;
    if (-1 == i) {
      try
      {
        h.baF();
        i = h.baE().ban().getInt(at.a.acZl, -1);
        if (i == -1)
        {
          AppMethodBeat.o(241942);
          return -1;
        }
        i = uV(i);
        AppMethodBeat.o(241942);
        return i;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.ConfigStorageLogic", localThrowable, "getAuthDeviceFlagErr", new Object[0]);
        AppMethodBeat.o(241942);
        return -1;
      }
    }
    i = uV(i);
    AppMethodBeat.o(241942);
    return i;
  }
  
  public static boolean bBb()
  {
    AppMethodBeat.i(241952);
    if (bBa() == 0)
    {
      AppMethodBeat.o(241952);
      return true;
    }
    AppMethodBeat.o(241952);
    return false;
  }
  
  public static boolean bBc()
  {
    AppMethodBeat.i(42800);
    if ((bAU() & 0x4000) != 0)
    {
      AppMethodBeat.o(42800);
      return true;
    }
    AppMethodBeat.o(42800);
    return false;
  }
  
  public static boolean bBd()
  {
    AppMethodBeat.i(42801);
    if ((bAU() & 0x8000) != 0)
    {
      AppMethodBeat.o(42801);
      return true;
    }
    AppMethodBeat.o(42801);
    return false;
  }
  
  public static void bBe()
  {
    AppMethodBeat.i(42802);
    int i = bAU();
    h.baF();
    h.baE().ban().B(40, Integer.valueOf(i | 0x8000));
    AppMethodBeat.o(42802);
  }
  
  public static int bBf()
  {
    AppMethodBeat.i(42803);
    h.baF();
    Integer localInteger = (Integer)h.baE().ban().d(34, null);
    if (localInteger == null)
    {
      AppMethodBeat.o(42803);
      return 0;
    }
    int i = localInteger.intValue();
    AppMethodBeat.o(42803);
    return i;
  }
  
  public static boolean bBg()
  {
    AppMethodBeat.i(42804);
    if ((bAQ() & 0x40) != 0)
    {
      AppMethodBeat.o(42804);
      return true;
    }
    AppMethodBeat.o(42804);
    return false;
  }
  
  public static boolean bBh()
  {
    AppMethodBeat.i(42805);
    if ((bAQ() & 0x40000) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(bAQ()) });
      AppMethodBeat.o(42805);
      return bool;
    }
  }
  
  public static boolean bBi()
  {
    AppMethodBeat.i(42806);
    h.baF();
    h.baE().ban().iZy();
    if (bAV() == 1)
    {
      AppMethodBeat.o(42806);
      return true;
    }
    AppMethodBeat.o(42806);
    return false;
  }
  
  public static boolean bBj()
  {
    AppMethodBeat.i(42807);
    h.baF();
    h.baE().ban().iZy();
    if (bAV() == 2)
    {
      AppMethodBeat.o(42807);
      return true;
    }
    AppMethodBeat.o(42807);
    return false;
  }
  
  public static boolean bBk()
  {
    AppMethodBeat.i(42808);
    h.baF();
    h.baE().ban().iZy();
    if (bAV() == 4)
    {
      AppMethodBeat.o(42808);
      return true;
    }
    AppMethodBeat.o(42808);
    return false;
  }
  
  public static boolean bBl()
  {
    AppMethodBeat.i(241967);
    if (bAV() == 0)
    {
      AppMethodBeat.o(241967);
      return true;
    }
    AppMethodBeat.o(241967);
    return false;
  }
  
  public static boolean bBm()
  {
    AppMethodBeat.i(241970);
    h.baF();
    int i = ((Integer)h.baE().ban().get(at.a.acNa, Integer.valueOf(-1))).intValue();
    Log.i("MicroMsg.ConfigStorageLogic", "isCNPayWalletRegion() walletRegion:%s", new Object[] { Integer.valueOf(i) });
    if ((i == 0) || (i == 1))
    {
      AppMethodBeat.o(241970);
      return true;
    }
    AppMethodBeat.o(241970);
    return false;
  }
  
  public static boolean bBn()
  {
    AppMethodBeat.i(42809);
    if ((bBf() & 0x20) == 0)
    {
      AppMethodBeat.o(42809);
      return true;
    }
    AppMethodBeat.o(42809);
    return false;
  }
  
  public static boolean bBo()
  {
    AppMethodBeat.i(42810);
    if ((bAQ() & 0x1000) != 0)
    {
      AppMethodBeat.o(42810);
      return true;
    }
    AppMethodBeat.o(42810);
    return false;
  }
  
  public static boolean bBp()
  {
    AppMethodBeat.i(42811);
    cm localcm = ((n)h.ax(n.class)).bzJ().aMh("@t.qq.com");
    if ((localcm != null) && (localcm.isEnable()))
    {
      AppMethodBeat.o(42811);
      return true;
    }
    AppMethodBeat.o(42811);
    return false;
  }
  
  public static boolean bBq()
  {
    AppMethodBeat.i(42812);
    if ((bBf() & 0x2) == 0)
    {
      AppMethodBeat.o(42812);
      return true;
    }
    AppMethodBeat.o(42812);
    return false;
  }
  
  public static boolean bBr()
  {
    AppMethodBeat.i(42813);
    if ((bBf() & 0x10) == 0)
    {
      AppMethodBeat.o(42813);
      return true;
    }
    AppMethodBeat.o(42813);
    return false;
  }
  
  public static boolean bBs()
  {
    AppMethodBeat.i(42814);
    if ((bBf() & 0x80) == 0)
    {
      AppMethodBeat.o(42814);
      return true;
    }
    AppMethodBeat.o(42814);
    return false;
  }
  
  public static boolean bBt()
  {
    AppMethodBeat.i(241989);
    h.baF();
    boolean bool = Util.nullAsFalse((Boolean)h.baE().ban().d(8200, null));
    AppMethodBeat.o(241989);
    return bool;
  }
  
  public static boolean bBu()
  {
    AppMethodBeat.i(42815);
    if ((bBf() & 0x80000) == 0)
    {
      AppMethodBeat.o(42815);
      return true;
    }
    AppMethodBeat.o(42815);
    return false;
  }
  
  public static boolean bBv()
  {
    AppMethodBeat.i(42816);
    if ((bBf() & 0x40000) == 0)
    {
      AppMethodBeat.o(42816);
      return true;
    }
    AppMethodBeat.o(42816);
    return false;
  }
  
  public static boolean bBw()
  {
    AppMethodBeat.i(42817);
    if ((bBf() & 0x2000) == 0)
    {
      AppMethodBeat.o(42817);
      return true;
    }
    AppMethodBeat.o(42817);
    return false;
  }
  
  public static boolean bBx()
  {
    AppMethodBeat.i(42818);
    if ((bBf() & 0x10000) == 0)
    {
      AppMethodBeat.o(42818);
      return true;
    }
    AppMethodBeat.o(42818);
    return false;
  }
  
  public static boolean bBy()
  {
    AppMethodBeat.i(42819);
    if ((bBf() & 0x8000000) == 0)
    {
      AppMethodBeat.o(42819);
      return true;
    }
    AppMethodBeat.o(42819);
    return false;
  }
  
  public static boolean bBz()
  {
    AppMethodBeat.i(42820);
    h.baF();
    String str = (String)h.baE().ban().d(65825, null);
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
  
  public static String getUserBindEmail()
  {
    AppMethodBeat.i(42791);
    h.baF();
    String str = Util.nullAsNil((String)h.baE().ban().d(5, null));
    AppMethodBeat.o(42791);
    return str;
  }
  
  public static boolean h(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(42826);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      Log.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
      AppMethodBeat.o(42826);
      return false;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && ((au.bwL(paramString2)) || (au.bwN(paramString2))))
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
      if (y.bEl(paramString1) < 65536L)
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
      long l = y.bEl(paramString1);
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
  
  public static void uU(int paramInt)
  {
    AppMethodBeat.i(241940);
    Log.printInfoStack("MicroMsg.ConfigStorageLogic", "[setAuthDeviceFlag] flag=%s", new Object[] { Integer.valueOf(paramInt) });
    ojU = paramInt;
    h.baF();
    h.baE().ban().set(at.a.acZl, Integer.valueOf(paramInt));
    MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt("PREF_KEY_LAST_AUTH_FLAG", paramInt);
    AppMethodBeat.o(241940);
  }
  
  private static int uV(int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      return 0;
    }
    return 1;
  }
  
  public static boolean uW(int paramInt)
  {
    return (paramInt & 0x2000) != 0;
  }
  
  private static void x(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42827);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    h.baF();
    if (h.baE() != null)
    {
      h.baF();
      if (h.baE().ban() != null)
      {
        h.baF();
        h.baE().ban().B(327682, localStringBuilder.toString());
      }
    }
    AppMethodBeat.o(42827);
  }
  
  private static void y(Map<String, String> paramMap)
  {
    AppMethodBeat.i(42828);
    paramMap.clear();
    h.baF();
    if (h.baE() != null)
    {
      h.baF();
      if (h.baE().ban() != null) {}
    }
    else
    {
      Log.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
      AppMethodBeat.o(42828);
      return;
    }
    h.baF();
    Object localObject = (String)h.baE().ban().d(327682, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.z
 * JD-Core Version:    0.7.0.1
 */