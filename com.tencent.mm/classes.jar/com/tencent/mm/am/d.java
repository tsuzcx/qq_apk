package com.tencent.mm.am;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class d
{
  private static String Gn(long paramLong)
  {
    AppMethodBeat.i(150202);
    String str = new p(paramLong) + "@qqim";
    AppMethodBeat.o(150202);
    return str;
  }
  
  public static Bitmap Go(long paramLong)
  {
    AppMethodBeat.i(150206);
    Bitmap localBitmap = a(Gn(paramLong), false, -1, null);
    AppMethodBeat.o(150206);
    return localBitmap;
  }
  
  public static void TA(String paramString)
  {
    AppMethodBeat.i(150212);
    j localj = q.bhP().TS(paramString);
    if (localj == null)
    {
      AppMethodBeat.o(150212);
      return;
    }
    if (!paramString.equals(localj.getUsername()))
    {
      AppMethodBeat.o(150212);
      return;
    }
    localj.lBg = 0;
    localj.cUP = 64;
    q.bhP().b(localj);
    AppMethodBeat.o(150212);
  }
  
  public static Bitmap Tq(String paramString)
  {
    AppMethodBeat.i(150197);
    paramString = a(paramString + "@google", false, -1, null);
    AppMethodBeat.o(150197);
    return paramString;
  }
  
  private static String Tr(String paramString)
  {
    AppMethodBeat.i(150198);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    AppMethodBeat.o(150198);
    return paramString;
  }
  
  public static void Ts(String paramString)
  {
    AppMethodBeat.i(150199);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150199);
      return;
    }
    String str = paramString + "@fb";
    j localj2 = q.bhP().TS(str);
    if ((localj2 != null) && (str.equals(localj2.getUsername())) && (3 == localj2.hDc))
    {
      AppMethodBeat.o(150199);
      return;
    }
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = new j();
    }
    localj1.username = str;
    localj1.hDc = 3;
    localj1.lBe = Tr(paramString);
    localj1.lBd = Tr(paramString);
    localj1.gg(true);
    localj1.cUP = 31;
    q.bhP().b(localj1);
    AppMethodBeat.o(150199);
  }
  
  public static Bitmap Tt(String paramString)
  {
    AppMethodBeat.i(150200);
    paramString = a(paramString + "@fb", false, -1, null);
    AppMethodBeat.o(150200);
    return paramString;
  }
  
  public static long Tu(String paramString)
  {
    AppMethodBeat.i(150201);
    if (!as.bvM(paramString))
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
  
  public static long Tv(String paramString)
  {
    AppMethodBeat.i(150203);
    if (!as.bvJ(paramString))
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
  
  public static boolean Tw(String paramString)
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
    j localj = new j();
    localj.username = paramString;
    localj.hDc = 3;
    localj.cUP = 3;
    boolean bool = q.bhP().b(localj);
    AppMethodBeat.o(150205);
    return bool;
  }
  
  public static Bitmap Tx(String paramString)
  {
    AppMethodBeat.i(293054);
    paramString = a(paramString, false, -1, null);
    AppMethodBeat.o(293054);
    return paramString;
  }
  
  public static String Ty(String paramString)
  {
    AppMethodBeat.i(184252);
    paramString = Tz(paramString);
    AppMethodBeat.o(184252);
    return paramString;
  }
  
  public static String Tz(String paramString)
  {
    AppMethodBeat.i(150211);
    if ((Util.isNullOrNil(paramString)) || (!h.aHE().aGM()))
    {
      AppMethodBeat.o(150211);
      return null;
    }
    if (as.PY(paramString))
    {
      q.bhz();
      paramString = f.N(as.bvW(paramString), false);
      AppMethodBeat.o(150211);
      return paramString;
    }
    q.bhz();
    paramString = f.N(paramString, false);
    AppMethodBeat.o(150211);
    return paramString;
  }
  
  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt, c paramc)
  {
    AppMethodBeat.i(242736);
    if ((Util.isNullOrNil(paramString)) || (!h.aHE().aGM()))
    {
      AppMethodBeat.o(242736);
      return null;
    }
    String str = paramString;
    if (as.PY(paramString)) {
      str = as.bvW(paramString);
    }
    paramString = str;
    if (ab.Qg(str)) {
      paramString = "weixin";
    }
    paramString = q.bhR().b(paramString, paramBoolean, paramInt, paramc);
    AppMethodBeat.o(242736);
    return paramString;
  }
  
  public static j a(String paramString, cyb paramcyb, as paramas)
  {
    AppMethodBeat.i(293055);
    j localj = new j();
    localj.cUP = -1;
    localj.username = paramString;
    localj.lBd = paramcyb.SjJ;
    localj.lBe = paramcyb.SjI;
    Log.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s], ImgFlag:%s", new Object[] { localj.getUsername(), localj.bhH(), localj.bhI(), Integer.valueOf(paramcyb.TGb) });
    boolean bool;
    if (paramcyb.TGg != 0)
    {
      bool = true;
      localj.gg(bool);
      if ((paramcyb.TGb != 3) && (paramcyb.TGb != 4)) {
        break label142;
      }
      localj.hDc = paramcyb.TGb;
    }
    for (;;)
    {
      AppMethodBeat.o(293055);
      return localj;
      bool = false;
      break;
      label142:
      if (paramcyb.TGb == 2)
      {
        localj.hDc = 3;
        a(paramString, localj);
      }
      else if ((paramas != null) && (com.tencent.mm.contact.d.rk(paramas.field_type)) && (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.KHQ, 1) == 1))
      {
        paramas = q.bhP().TS(paramString);
        if ((paramas != null) && (!Util.isNullOrNil(paramcyb.SjJ)) && (!Util.isEqual(paramas.bhI(), paramcyb.SjJ)))
        {
          Log.i("MicroMsg.AvatarLogic", "parseFromModContact old_smallImageUrl:%s, old_flag:%s", new Object[] { Util.nullAs(paramas.bhI(), ""), Integer.valueOf(paramas.hDc) });
          a(paramString, localj);
        }
      }
    }
  }
  
  private static void a(String paramString, j paramj)
  {
    AppMethodBeat.i(293056);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(293056);
      return;
    }
    if (!z.bcZ().equals(paramString))
    {
      q.bhz();
      f.P(paramString, false);
      q.bhz();
      f.P(paramString, true);
      q.bhP().b(paramj);
      q.bhR().TB(paramString);
    }
    AppMethodBeat.o(293056);
  }
  
  public static boolean aH(String paramString, int paramInt)
  {
    AppMethodBeat.i(150207);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150207);
      return false;
    }
    j localj2 = q.bhP().TS(paramString);
    if ((localj2 != null) && (paramString.equals(localj2.getUsername())) && (paramInt == localj2.hDc))
    {
      AppMethodBeat.o(150207);
      return true;
    }
    j localj1 = localj2;
    if (localj2 == null) {
      localj1 = new j();
    }
    localj1.username = paramString;
    localj1.hDc = paramInt;
    localj1.cUP = 3;
    boolean bool = q.bhP().b(localj1);
    AppMethodBeat.o(150207);
    return bool;
  }
  
  public static String bf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150196);
    paramString1 = paramString1 + "?access_token=" + paramString2;
    AppMethodBeat.o(150196);
    return paramString1;
  }
  
  public static Bitmap f(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(150209);
    if ((Util.isNullOrNil(paramString)) || (!h.aHE().aGM()))
    {
      AppMethodBeat.o(150209);
      return null;
    }
    q.bhz();
    Object localObject = f.p(paramString, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new g();
      ((g)localObject).a(paramString, new g.c()
      {
        public final int dL(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(150195);
          this.lAf.qE();
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
  
  public static boolean f(long paramLong, int paramInt)
  {
    AppMethodBeat.i(150204);
    if (paramInt != 3)
    {
      AppMethodBeat.o(150204);
      return false;
    }
    boolean bool = Tw(Gn(paramLong));
    AppMethodBeat.o(150204);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.d
 * JD-Core Version:    0.7.0.1
 */