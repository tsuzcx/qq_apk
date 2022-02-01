package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;

public final class c
{
  public static Bitmap CJ(String paramString)
  {
    AppMethodBeat.i(150197);
    paramString = a(paramString + "@google", false, -1, null);
    AppMethodBeat.o(150197);
    return paramString;
  }
  
  private static String CK(String paramString)
  {
    AppMethodBeat.i(150198);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    AppMethodBeat.o(150198);
    return paramString;
  }
  
  public static void CL(String paramString)
  {
    AppMethodBeat.i(150199);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150199);
      return;
    }
    String str = paramString + "@fb";
    i locali2 = p.aEx().Dj(str);
    if ((locali2 != null) && (str.equals(locali2.getUsername())) && (3 == locali2.ePj))
    {
      AppMethodBeat.o(150199);
      return;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = str;
    locali1.ePj = 3;
    locali1.hMX = CK(paramString);
    locali1.hMW = CK(paramString);
    locali1.eB(true);
    locali1.dDp = 31;
    p.aEx().b(locali1);
    AppMethodBeat.o(150199);
  }
  
  public static Bitmap CM(String paramString)
  {
    AppMethodBeat.i(150200);
    paramString = a(paramString + "@fb", false, -1, null);
    AppMethodBeat.o(150200);
    return paramString;
  }
  
  public static long CN(String paramString)
  {
    AppMethodBeat.i(150201);
    if (!am.aSS(paramString))
    {
      AppMethodBeat.o(150201);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bt.getLong(paramString[0], -1L);
      AppMethodBeat.o(150201);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150201);
    }
    return -1L;
  }
  
  public static long CO(String paramString)
  {
    AppMethodBeat.i(150203);
    if (!am.aSP(paramString))
    {
      AppMethodBeat.o(150203);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bt.getLong(paramString[0], -1L);
      AppMethodBeat.o(150203);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150203);
    }
    return -1L;
  }
  
  public static boolean CP(String paramString)
  {
    AppMethodBeat.i(150205);
    if (paramString == null)
    {
      ad.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    if (!paramString.endsWith("@qqim"))
    {
      ad.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    i locali = new i();
    locali.username = paramString;
    locali.ePj = 3;
    locali.dDp = 3;
    boolean bool = p.aEx().b(locali);
    AppMethodBeat.o(150205);
    return bool;
  }
  
  public static Bitmap CQ(String paramString)
  {
    AppMethodBeat.i(221217);
    paramString = a(paramString, false, -1, null);
    AppMethodBeat.o(221217);
    return paramString;
  }
  
  public static String CR(String paramString)
  {
    AppMethodBeat.i(184252);
    paramString = CS(paramString);
    AppMethodBeat.o(184252);
    return paramString;
  }
  
  public static String CS(String paramString)
  {
    AppMethodBeat.i(150211);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.ajA().aiK()))
    {
      AppMethodBeat.o(150211);
      return null;
    }
    if (am.zs(paramString))
    {
      p.aEk();
      paramString = e.J(am.aSZ(paramString), false);
      AppMethodBeat.o(150211);
      return paramString;
    }
    p.aEk();
    paramString = e.J(paramString, false);
    AppMethodBeat.o(150211);
    return paramString;
  }
  
  public static void CT(String paramString)
  {
    AppMethodBeat.i(150212);
    i locali = p.aEx().Dj(paramString);
    if (locali == null)
    {
      AppMethodBeat.o(150212);
      return;
    }
    if (!paramString.equals(locali.getUsername()))
    {
      AppMethodBeat.o(150212);
      return;
    }
    locali.hMZ = 0;
    locali.dDp = 64;
    p.aEx().b(locali);
    AppMethodBeat.o(150212);
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(195208);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.ajA().aiK()))
    {
      AppMethodBeat.o(195208);
      return null;
    }
    String str = paramString;
    if (am.zs(paramString)) {
      str = am.aSZ(paramString);
    }
    paramString = str;
    if (w.zy(str)) {
      paramString = "weixin";
    }
    paramString = p.aEz().b(paramString, paramBoolean, paramInt, paramb);
    AppMethodBeat.o(195208);
    return paramString;
  }
  
  public static i a(String paramString, bzp parambzp)
  {
    AppMethodBeat.i(150213);
    i locali = new i();
    locali.dDp = -1;
    locali.username = paramString;
    locali.hMW = parambzp.FVp;
    locali.hMX = parambzp.FVo;
    ad.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aEq(), locali.aEr() });
    boolean bool;
    if (parambzp.GUn != 0)
    {
      bool = true;
      locali.eB(bool);
      if ((parambzp.GUi != 3) && (parambzp.GUi != 4)) {
        break label121;
      }
      locali.ePj = parambzp.GUi;
    }
    for (;;)
    {
      AppMethodBeat.o(150213);
      return locali;
      bool = false;
      break;
      label121:
      if (parambzp.GUi == 2)
      {
        locali.ePj = 3;
        if (!u.aAm().equals(paramString))
        {
          p.aEk();
          e.L(paramString, false);
          p.aEk();
          e.L(paramString, true);
          p.aEx().b(locali);
          p.aEz().CU(paramString);
        }
      }
    }
  }
  
  public static String aW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150196);
    paramString1 = paramString1 + "?access_token=" + paramString2;
    AppMethodBeat.o(150196);
    return paramString1;
  }
  
  public static boolean ak(String paramString, int paramInt)
  {
    AppMethodBeat.i(150207);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150207);
      return false;
    }
    i locali2 = p.aEx().Dj(paramString);
    if ((locali2 != null) && (paramString.equals(locali2.getUsername())) && (paramInt == locali2.ePj))
    {
      AppMethodBeat.o(150207);
      return true;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = paramString;
    locali1.ePj = paramInt;
    locali1.dDp = 3;
    boolean bool = p.aEx().b(locali1);
    AppMethodBeat.o(150207);
    return bool;
  }
  
  public static Bitmap e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150209);
    if ((bt.isNullOrNil(paramString)) || (!com.tencent.mm.kernel.g.ajA().aiK()))
    {
      AppMethodBeat.o(150209);
      return null;
    }
    p.aEk();
    Object localObject = e.o(paramString, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new f();
      ((f)localObject).a(paramString, new f.c()
      {
        public final int df(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(150195);
          this.hMa.sN();
          ad.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          AppMethodBeat.o(150195);
          return 0;
        }
      });
      paramString = a(paramString, false, paramInt3, null);
      AppMethodBeat.o(150209);
      return paramString;
    }
    paramString = (String)localObject;
    if (paramInt3 > 5) {
      paramString = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, false, paramInt3);
    }
    AppMethodBeat.o(150209);
    return paramString;
  }
  
  public static boolean e(long paramLong, int paramInt)
  {
    AppMethodBeat.i(150204);
    if (paramInt != 3)
    {
      AppMethodBeat.o(150204);
      return false;
    }
    boolean bool = CP(rN(paramLong));
    AppMethodBeat.o(150204);
    return bool;
  }
  
  private static String rN(long paramLong)
  {
    AppMethodBeat.i(150202);
    String str = new com.tencent.mm.b.p(paramLong) + "@qqim";
    AppMethodBeat.o(150202);
    return str;
  }
  
  public static Bitmap rO(long paramLong)
  {
    AppMethodBeat.i(150206);
    Bitmap localBitmap = a(rN(paramLong), false, -1, null);
    AppMethodBeat.o(150206);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.c
 * JD-Core Version:    0.7.0.1
 */