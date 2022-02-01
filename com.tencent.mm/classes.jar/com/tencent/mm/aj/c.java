package com.tencent.mm.aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.an;

public final class c
{
  public static Bitmap Dl(String paramString)
  {
    AppMethodBeat.i(150197);
    paramString = a(paramString + "@google", false, -1, null);
    AppMethodBeat.o(150197);
    return paramString;
  }
  
  private static String Dm(String paramString)
  {
    AppMethodBeat.i(150198);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    AppMethodBeat.o(150198);
    return paramString;
  }
  
  public static void Dn(String paramString)
  {
    AppMethodBeat.i(150199);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150199);
      return;
    }
    String str = paramString + "@fb";
    i locali2 = p.aEN().DL(str);
    if ((locali2 != null) && (str.equals(locali2.getUsername())) && (3 == locali2.eQU))
    {
      AppMethodBeat.o(150199);
      return;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = str;
    locali1.eQU = 3;
    locali1.hPQ = Dm(paramString);
    locali1.hPP = Dm(paramString);
    locali1.eD(true);
    locali1.dEu = 31;
    p.aEN().b(locali1);
    AppMethodBeat.o(150199);
  }
  
  public static Bitmap Do(String paramString)
  {
    AppMethodBeat.i(150200);
    paramString = a(paramString + "@fb", false, -1, null);
    AppMethodBeat.o(150200);
    return paramString;
  }
  
  public static long Dp(String paramString)
  {
    AppMethodBeat.i(150201);
    if (!an.aUs(paramString))
    {
      AppMethodBeat.o(150201);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bu.getLong(paramString[0], -1L);
      AppMethodBeat.o(150201);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150201);
    }
    return -1L;
  }
  
  public static long Dq(String paramString)
  {
    AppMethodBeat.i(150203);
    if (!an.aUp(paramString))
    {
      AppMethodBeat.o(150203);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bu.getLong(paramString[0], -1L);
      AppMethodBeat.o(150203);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150203);
    }
    return -1L;
  }
  
  public static boolean Dr(String paramString)
  {
    AppMethodBeat.i(150205);
    if (paramString == null)
    {
      ae.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    if (!paramString.endsWith("@qqim"))
    {
      ae.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    i locali = new i();
    locali.username = paramString;
    locali.eQU = 3;
    locali.dEu = 3;
    boolean bool = p.aEN().b(locali);
    AppMethodBeat.o(150205);
    return bool;
  }
  
  public static Bitmap Ds(String paramString)
  {
    AppMethodBeat.i(224404);
    paramString = a(paramString, false, -1, null);
    AppMethodBeat.o(224404);
    return paramString;
  }
  
  public static String Dt(String paramString)
  {
    AppMethodBeat.i(184252);
    paramString = Du(paramString);
    AppMethodBeat.o(184252);
    return paramString;
  }
  
  public static String Du(String paramString)
  {
    AppMethodBeat.i(150211);
    if ((bu.isNullOrNil(paramString)) || (!g.ajP().aiZ()))
    {
      AppMethodBeat.o(150211);
      return null;
    }
    if (an.Ac(paramString))
    {
      p.aEA();
      paramString = e.J(an.aUA(paramString), false);
      AppMethodBeat.o(150211);
      return paramString;
    }
    p.aEA();
    paramString = e.J(paramString, false);
    AppMethodBeat.o(150211);
    return paramString;
  }
  
  public static void Dv(String paramString)
  {
    AppMethodBeat.i(150212);
    i locali = p.aEN().DL(paramString);
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
    locali.hPS = 0;
    locali.dEu = 64;
    p.aEN().b(locali);
    AppMethodBeat.o(150212);
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(218658);
    if ((bu.isNullOrNil(paramString)) || (!g.ajP().aiZ()))
    {
      AppMethodBeat.o(218658);
      return null;
    }
    String str = paramString;
    if (an.Ac(paramString)) {
      str = an.aUA(paramString);
    }
    paramString = str;
    if (x.Ai(str)) {
      paramString = "weixin";
    }
    paramString = p.aEP().b(paramString, paramBoolean, paramInt, paramb);
    AppMethodBeat.o(218658);
    return paramString;
  }
  
  public static i a(String paramString, caj paramcaj)
  {
    AppMethodBeat.i(150213);
    i locali = new i();
    locali.dEu = -1;
    locali.username = paramString;
    locali.hPP = paramcaj.GnO;
    locali.hPQ = paramcaj.GnN;
    ae.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aEG(), locali.aEH() });
    boolean bool;
    if (paramcaj.HnO != 0)
    {
      bool = true;
      locali.eD(bool);
      if ((paramcaj.HnJ != 3) && (paramcaj.HnJ != 4)) {
        break label121;
      }
      locali.eQU = paramcaj.HnJ;
    }
    for (;;)
    {
      AppMethodBeat.o(150213);
      return locali;
      bool = false;
      break;
      label121:
      if (paramcaj.HnJ == 2)
      {
        locali.eQU = 3;
        if (!v.aAC().equals(paramString))
        {
          p.aEA();
          e.L(paramString, false);
          p.aEA();
          e.L(paramString, true);
          p.aEN().b(locali);
          p.aEP().Dw(paramString);
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
  
  public static boolean al(String paramString, int paramInt)
  {
    AppMethodBeat.i(150207);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150207);
      return false;
    }
    i locali2 = p.aEN().DL(paramString);
    if ((locali2 != null) && (paramString.equals(locali2.getUsername())) && (paramInt == locali2.eQU))
    {
      AppMethodBeat.o(150207);
      return true;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = paramString;
    locali1.eQU = paramInt;
    locali1.dEu = 3;
    boolean bool = p.aEN().b(locali1);
    AppMethodBeat.o(150207);
    return bool;
  }
  
  public static Bitmap e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150209);
    if ((bu.isNullOrNil(paramString)) || (!g.ajP().aiZ()))
    {
      AppMethodBeat.o(150209);
      return null;
    }
    p.aEA();
    Object localObject = e.o(paramString, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new f();
      ((f)localObject).a(paramString, new f.c()
      {
        public final int df(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(150195);
          this.hOT.sN();
          ae.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
      paramString = h.a((Bitmap)localObject, false, paramInt3);
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
    boolean bool = Dr(sa(paramLong));
    AppMethodBeat.o(150204);
    return bool;
  }
  
  private static String sa(long paramLong)
  {
    AppMethodBeat.i(150202);
    String str = new com.tencent.mm.b.p(paramLong) + "@qqim";
    AppMethodBeat.o(150202);
    return str;
  }
  
  public static Bitmap sb(long paramLong)
  {
    AppMethodBeat.i(150206);
    Bitmap localBitmap = a(sa(paramLong), false, -1, null);
    AppMethodBeat.o(150206);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c
 * JD-Core Version:    0.7.0.1
 */