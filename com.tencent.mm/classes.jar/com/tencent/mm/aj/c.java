package com.tencent.mm.aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;

public final class c
{
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(192602);
    if ((bs.isNullOrNil(paramString)) || (!g.agP().afY()))
    {
      AppMethodBeat.o(192602);
      return null;
    }
    String str = paramString;
    if (ai.ww(paramString)) {
      str = ai.aNh(paramString);
    }
    paramString = str;
    if (w.wC(str)) {
      paramString = "weixin";
    }
    paramString = p.aBy().b(paramString, paramBoolean, paramInt, paramb);
    AppMethodBeat.o(192602);
    return paramString;
  }
  
  public static i a(String paramString, bva parambva)
  {
    AppMethodBeat.i(150213);
    i locali = new i();
    locali.drx = -1;
    locali.username = paramString;
    locali.huE = parambva.Eog;
    locali.huF = parambva.Eof;
    ac.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aBo(), locali.aBp() });
    boolean bool;
    if (parambva.FkF != 0)
    {
      bool = true;
      locali.ez(bool);
      if ((parambva.FkA != 3) && (parambva.FkA != 4)) {
        break label121;
      }
      locali.exK = parambva.FkA;
    }
    for (;;)
    {
      AppMethodBeat.o(150213);
      return locali;
      bool = false;
      break;
      label121:
      if (parambva.FkA == 2)
      {
        locali.exK = 3;
        if (!u.axw().equals(paramString))
        {
          p.aBh();
          e.L(paramString, false);
          p.aBh();
          e.L(paramString, true);
          p.aBw().b(locali);
          p.aBy().zV(paramString);
        }
      }
    }
  }
  
  public static String aV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150196);
    paramString1 = paramString1 + "?access_token=" + paramString2;
    AppMethodBeat.o(150196);
    return paramString1;
  }
  
  public static boolean ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(150207);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150207);
      return false;
    }
    i locali2 = p.aBw().Ak(paramString);
    if ((locali2 != null) && (paramString.equals(locali2.getUsername())) && (paramInt == locali2.exK))
    {
      AppMethodBeat.o(150207);
      return true;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = paramString;
    locali1.exK = paramInt;
    locali1.drx = 3;
    boolean bool = p.aBw().b(locali1);
    AppMethodBeat.o(150207);
    return bool;
  }
  
  public static Bitmap e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150209);
    if ((bs.isNullOrNil(paramString)) || (!g.agP().afY()))
    {
      AppMethodBeat.o(150209);
      return null;
    }
    p.aBh();
    Object localObject = e.m(paramString, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new f();
      ((f)localObject).a(paramString, new f.c()
      {
        public final int dd(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(150195);
          this.htI.aBl();
          ac.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
    boolean bool = zQ(pO(paramLong));
    AppMethodBeat.o(150204);
    return bool;
  }
  
  private static String pO(long paramLong)
  {
    AppMethodBeat.i(150202);
    String str = new com.tencent.mm.b.p(paramLong) + "@qqim";
    AppMethodBeat.o(150202);
    return str;
  }
  
  public static Bitmap pP(long paramLong)
  {
    AppMethodBeat.i(150206);
    Bitmap localBitmap = a(pO(paramLong), false, -1, null);
    AppMethodBeat.o(150206);
    return localBitmap;
  }
  
  public static Bitmap zK(String paramString)
  {
    AppMethodBeat.i(150197);
    paramString = a(paramString + "@google", false, -1, null);
    AppMethodBeat.o(150197);
    return paramString;
  }
  
  private static String zL(String paramString)
  {
    AppMethodBeat.i(150198);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    AppMethodBeat.o(150198);
    return paramString;
  }
  
  public static void zM(String paramString)
  {
    AppMethodBeat.i(150199);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150199);
      return;
    }
    String str = paramString + "@fb";
    i locali2 = p.aBw().Ak(str);
    if ((locali2 != null) && (str.equals(locali2.getUsername())) && (3 == locali2.exK))
    {
      AppMethodBeat.o(150199);
      return;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = str;
    locali1.exK = 3;
    locali1.huF = zL(paramString);
    locali1.huE = zL(paramString);
    locali1.ez(true);
    locali1.drx = 31;
    p.aBw().b(locali1);
    AppMethodBeat.o(150199);
  }
  
  public static Bitmap zN(String paramString)
  {
    AppMethodBeat.i(150200);
    paramString = a(paramString + "@fb", false, -1, null);
    AppMethodBeat.o(150200);
    return paramString;
  }
  
  public static long zO(String paramString)
  {
    AppMethodBeat.i(150201);
    if (!ai.aNe(paramString))
    {
      AppMethodBeat.o(150201);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bs.getLong(paramString[0], -1L);
      AppMethodBeat.o(150201);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150201);
    }
    return -1L;
  }
  
  public static long zP(String paramString)
  {
    AppMethodBeat.i(150203);
    if (!ai.aNb(paramString))
    {
      AppMethodBeat.o(150203);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bs.getLong(paramString[0], -1L);
      AppMethodBeat.o(150203);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150203);
    }
    return -1L;
  }
  
  public static boolean zQ(String paramString)
  {
    AppMethodBeat.i(150205);
    if (paramString == null)
    {
      ac.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    if (!paramString.endsWith("@qqim"))
    {
      ac.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    i locali = new i();
    locali.username = paramString;
    locali.exK = 3;
    locali.drx = 3;
    boolean bool = p.aBw().b(locali);
    AppMethodBeat.o(150205);
    return bool;
  }
  
  public static Bitmap zR(String paramString)
  {
    AppMethodBeat.i(210346);
    paramString = a(paramString, false, -1, null);
    AppMethodBeat.o(210346);
    return paramString;
  }
  
  public static String zS(String paramString)
  {
    AppMethodBeat.i(184252);
    paramString = zT(paramString);
    AppMethodBeat.o(184252);
    return paramString;
  }
  
  public static String zT(String paramString)
  {
    AppMethodBeat.i(150211);
    if ((bs.isNullOrNil(paramString)) || (!g.agP().afY()))
    {
      AppMethodBeat.o(150211);
      return null;
    }
    if (ai.ww(paramString))
    {
      p.aBh();
      paramString = e.J(ai.aNh(paramString), false);
      AppMethodBeat.o(150211);
      return paramString;
    }
    p.aBh();
    paramString = e.J(paramString, false);
    AppMethodBeat.o(150211);
    return paramString;
  }
  
  public static void zU(String paramString)
  {
    AppMethodBeat.i(150212);
    i locali = p.aBw().Ak(paramString);
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
    locali.huH = 0;
    locali.drx = 64;
    p.aBw().b(locali);
    AppMethodBeat.o(150212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c
 * JD-Core Version:    0.7.0.1
 */