package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;

public final class c
{
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(190710);
    if ((bt.isNullOrNil(paramString)) || (!g.afz().aeI()))
    {
      AppMethodBeat.o(190710);
      return null;
    }
    String str = paramString;
    if (af.st(paramString)) {
      str = af.aHM(paramString);
    }
    paramString = str;
    if (w.sz(str)) {
      paramString = "weixin";
    }
    paramString = p.auH().b(paramString, paramBoolean, paramInt, paramb);
    AppMethodBeat.o(190710);
    return paramString;
  }
  
  public static i a(String paramString, bqj parambqj)
  {
    AppMethodBeat.i(150213);
    i locali = new i();
    locali.dtM = -1;
    locali.username = paramString;
    locali.gUf = parambqj.CVw;
    locali.gUg = parambqj.CVv;
    ad.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aux(), locali.auy() });
    boolean bool;
    if (parambqj.DOo != 0)
    {
      bool = true;
      locali.ee(bool);
      if ((parambqj.DOj != 3) && (parambqj.DOj != 4)) {
        break label121;
      }
      locali.evo = parambqj.DOj;
    }
    for (;;)
    {
      AppMethodBeat.o(150213);
      return locali;
      bool = false;
      break;
      label121:
      if (parambqj.DOj == 2)
      {
        locali.evo = 3;
        if (!u.aqG().equals(paramString))
        {
          p.auq();
          e.K(paramString, false);
          p.auq();
          e.K(paramString, true);
          p.auF().b(locali);
          p.auH().vP(paramString);
        }
      }
    }
  }
  
  public static String aN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150196);
    paramString1 = paramString1 + "?access_token=" + paramString2;
    AppMethodBeat.o(150196);
    return paramString1;
  }
  
  public static boolean ac(String paramString, int paramInt)
  {
    AppMethodBeat.i(150207);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150207);
      return false;
    }
    i locali2 = p.auF().we(paramString);
    if ((locali2 != null) && (paramString.equals(locali2.getUsername())) && (paramInt == locali2.evo))
    {
      AppMethodBeat.o(150207);
      return true;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = paramString;
    locali1.evo = paramInt;
    locali1.dtM = 3;
    boolean bool = p.auF().b(locali1);
    AppMethodBeat.o(150207);
    return bool;
  }
  
  public static Bitmap e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150209);
    if ((bt.isNullOrNil(paramString)) || (!g.afz().aeI()))
    {
      AppMethodBeat.o(150209);
      return null;
    }
    p.auq();
    Object localObject = e.m(paramString, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new f();
      ((f)localObject).a(paramString, new f.c()
      {
        public final int dd(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(150195);
          this.gTj.auu();
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
      paramString = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject, false, paramInt3);
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
    boolean bool = vK(ma(paramLong));
    AppMethodBeat.o(150204);
    return bool;
  }
  
  private static String ma(long paramLong)
  {
    AppMethodBeat.i(150202);
    String str = new com.tencent.mm.b.p(paramLong) + "@qqim";
    AppMethodBeat.o(150202);
    return str;
  }
  
  public static Bitmap mb(long paramLong)
  {
    AppMethodBeat.i(150206);
    Bitmap localBitmap = a(ma(paramLong), false, -1, null);
    AppMethodBeat.o(150206);
    return localBitmap;
  }
  
  public static Bitmap vE(String paramString)
  {
    AppMethodBeat.i(150197);
    paramString = a(paramString + "@google", false, -1, null);
    AppMethodBeat.o(150197);
    return paramString;
  }
  
  private static String vF(String paramString)
  {
    AppMethodBeat.i(150198);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    AppMethodBeat.o(150198);
    return paramString;
  }
  
  public static void vG(String paramString)
  {
    AppMethodBeat.i(150199);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150199);
      return;
    }
    String str = paramString + "@fb";
    i locali2 = p.auF().we(str);
    if ((locali2 != null) && (str.equals(locali2.getUsername())) && (3 == locali2.evo))
    {
      AppMethodBeat.o(150199);
      return;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = str;
    locali1.evo = 3;
    locali1.gUg = vF(paramString);
    locali1.gUf = vF(paramString);
    locali1.ee(true);
    locali1.dtM = 31;
    p.auF().b(locali1);
    AppMethodBeat.o(150199);
  }
  
  public static Bitmap vH(String paramString)
  {
    AppMethodBeat.i(150200);
    paramString = a(paramString + "@fb", false, -1, null);
    AppMethodBeat.o(150200);
    return paramString;
  }
  
  public static long vI(String paramString)
  {
    AppMethodBeat.i(150201);
    if (!af.aHJ(paramString))
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
  
  public static long vJ(String paramString)
  {
    AppMethodBeat.i(150203);
    if (!af.aHG(paramString))
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
  
  public static boolean vK(String paramString)
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
    locali.evo = 3;
    locali.dtM = 3;
    boolean bool = p.auF().b(locali);
    AppMethodBeat.o(150205);
    return bool;
  }
  
  public static Bitmap vL(String paramString)
  {
    AppMethodBeat.i(203564);
    paramString = a(paramString, false, -1, null);
    AppMethodBeat.o(203564);
    return paramString;
  }
  
  public static String vM(String paramString)
  {
    AppMethodBeat.i(184252);
    paramString = vN(paramString);
    AppMethodBeat.o(184252);
    return paramString;
  }
  
  public static String vN(String paramString)
  {
    AppMethodBeat.i(150211);
    if ((bt.isNullOrNil(paramString)) || (!g.afz().aeI()))
    {
      AppMethodBeat.o(150211);
      return null;
    }
    if (af.st(paramString))
    {
      p.auq();
      paramString = e.I(af.aHM(paramString), false);
      AppMethodBeat.o(150211);
      return paramString;
    }
    p.auq();
    paramString = e.I(paramString, false);
    AppMethodBeat.o(150211);
    return paramString;
  }
  
  public static void vO(String paramString)
  {
    AppMethodBeat.i(150212);
    i locali = p.auF().we(paramString);
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
    locali.gUi = 0;
    locali.dtM = 64;
    p.auF().b(locali);
    AppMethodBeat.o(150212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.c
 * JD-Core Version:    0.7.0.1
 */