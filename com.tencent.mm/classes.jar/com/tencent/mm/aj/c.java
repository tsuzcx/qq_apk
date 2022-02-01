package com.tencent.mm.aj;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class c
{
  private static String Ag(long paramLong)
  {
    AppMethodBeat.i(150202);
    String str = new com.tencent.mm.b.p(paramLong) + "@qqim";
    AppMethodBeat.o(150202);
    return str;
  }
  
  public static Bitmap Ah(long paramLong)
  {
    AppMethodBeat.i(150206);
    Bitmap localBitmap = a(Ag(paramLong), false, -1, null);
    AppMethodBeat.o(150206);
    return localBitmap;
  }
  
  public static Bitmap LV(String paramString)
  {
    AppMethodBeat.i(150197);
    paramString = a(paramString + "@google", false, -1, null);
    AppMethodBeat.o(150197);
    return paramString;
  }
  
  private static String LW(String paramString)
  {
    AppMethodBeat.i(150198);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    AppMethodBeat.o(150198);
    return paramString;
  }
  
  public static void LX(String paramString)
  {
    AppMethodBeat.i(150199);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150199);
      return;
    }
    String str = paramString + "@fb";
    i locali2 = p.aYB().Mx(str);
    if ((locali2 != null) && (str.equals(locali2.getUsername())) && (3 == locali2.fuz))
    {
      AppMethodBeat.o(150199);
      return;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = str;
    locali1.fuz = 3;
    locali1.iKX = LW(paramString);
    locali1.iKW = LW(paramString);
    locali1.fv(true);
    locali1.cSx = 31;
    p.aYB().b(locali1);
    AppMethodBeat.o(150199);
  }
  
  public static Bitmap LY(String paramString)
  {
    AppMethodBeat.i(150200);
    paramString = a(paramString + "@fb", false, -1, null);
    AppMethodBeat.o(150200);
    return paramString;
  }
  
  public static long LZ(String paramString)
  {
    AppMethodBeat.i(150201);
    if (!as.bjr(paramString))
    {
      AppMethodBeat.o(150201);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = Util.getLong(paramString[0], -1L);
      AppMethodBeat.o(150201);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150201);
    }
    return -1L;
  }
  
  public static long Ma(String paramString)
  {
    AppMethodBeat.i(150203);
    if (!as.bjo(paramString))
    {
      AppMethodBeat.o(150203);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = Util.getLong(paramString[0], -1L);
      AppMethodBeat.o(150203);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(150203);
    }
    return -1L;
  }
  
  public static boolean Mb(String paramString)
  {
    AppMethodBeat.i(150205);
    if (paramString == null)
    {
      Log.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    if (!paramString.endsWith("@qqim"))
    {
      Log.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(150205);
      return false;
    }
    i locali = new i();
    locali.username = paramString;
    locali.fuz = 3;
    locali.cSx = 3;
    boolean bool = p.aYB().b(locali);
    AppMethodBeat.o(150205);
    return bool;
  }
  
  public static Bitmap Mc(String paramString)
  {
    AppMethodBeat.i(258493);
    paramString = a(paramString, false, -1, null);
    AppMethodBeat.o(258493);
    return paramString;
  }
  
  public static String Md(String paramString)
  {
    AppMethodBeat.i(184252);
    paramString = Me(paramString);
    AppMethodBeat.o(184252);
    return paramString;
  }
  
  public static String Me(String paramString)
  {
    AppMethodBeat.i(150211);
    if ((Util.isNullOrNil(paramString)) || (!g.aAf().azp()))
    {
      AppMethodBeat.o(150211);
      return null;
    }
    if (as.IG(paramString))
    {
      p.aYn();
      paramString = e.L(as.bjz(paramString), false);
      AppMethodBeat.o(150211);
      return paramString;
    }
    p.aYn();
    paramString = e.L(paramString, false);
    AppMethodBeat.o(150211);
    return paramString;
  }
  
  public static void Mf(String paramString)
  {
    AppMethodBeat.i(150212);
    i locali = p.aYB().Mx(paramString);
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
    locali.iKZ = 0;
    locali.cSx = 64;
    p.aYB().b(locali);
    AppMethodBeat.o(150212);
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt, b paramb)
  {
    AppMethodBeat.i(223530);
    if ((Util.isNullOrNil(paramString)) || (!g.aAf().azp()))
    {
      AppMethodBeat.o(223530);
      return null;
    }
    String str = paramString;
    if (as.IG(paramString)) {
      str = as.bjz(paramString);
    }
    paramString = str;
    if (ab.IN(str)) {
      paramString = "weixin";
    }
    paramString = p.aYD().b(paramString, paramBoolean, paramInt, paramb);
    AppMethodBeat.o(223530);
    return paramString;
  }
  
  public static i a(String paramString, cpl paramcpl)
  {
    AppMethodBeat.i(150213);
    i locali = new i();
    locali.cSx = -1;
    locali.username = paramString;
    locali.iKW = paramcpl.Lis;
    locali.iKX = paramcpl.Lir;
    Log.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aYt(), locali.aYu() });
    boolean bool;
    if (paramcpl.Mvi != 0)
    {
      bool = true;
      locali.fv(bool);
      if ((paramcpl.Mvd != 3) && (paramcpl.Mvd != 4)) {
        break label121;
      }
      locali.fuz = paramcpl.Mvd;
    }
    for (;;)
    {
      AppMethodBeat.o(150213);
      return locali;
      bool = false;
      break;
      label121:
      if (paramcpl.Mvd == 2)
      {
        locali.fuz = 3;
        if (!z.aTY().equals(paramString))
        {
          p.aYn();
          e.N(paramString, false);
          p.aYn();
          e.N(paramString, true);
          p.aYB().b(locali);
          p.aYD().Mg(paramString);
        }
      }
    }
  }
  
  public static boolean ap(String paramString, int paramInt)
  {
    AppMethodBeat.i(150207);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150207);
      return false;
    }
    i locali2 = p.aYB().Mx(paramString);
    if ((locali2 != null) && (paramString.equals(locali2.getUsername())) && (paramInt == locali2.fuz))
    {
      AppMethodBeat.o(150207);
      return true;
    }
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = new i();
    }
    locali1.username = paramString;
    locali1.fuz = paramInt;
    locali1.cSx = 3;
    boolean bool = p.aYB().b(locali1);
    AppMethodBeat.o(150207);
    return bool;
  }
  
  public static String ba(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150196);
    paramString1 = paramString1 + "?access_token=" + paramString2;
    AppMethodBeat.o(150196);
    return paramString1;
  }
  
  public static Bitmap e(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150209);
    if ((Util.isNullOrNil(paramString)) || (!g.aAf().azp()))
    {
      AppMethodBeat.o(150209);
      return null;
    }
    p.aYn();
    Object localObject = e.o(paramString, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new f();
      ((f)localObject).a(paramString, new f.c()
      {
        public final int dp(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(150195);
          this.iKa.sQ();
          Log.i("MicroMsg.AvatarLogic", "getHDHeadImage onSceneEnd: errType=%d, errCode=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
      paramString = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject, false, paramInt3);
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
    boolean bool = Mb(Ag(paramLong));
    AppMethodBeat.o(150204);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.c
 * JD-Core Version:    0.7.0.1
 */