package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class b
{
  public static boolean U(String paramString, int paramInt)
  {
    AppMethodBeat.i(77843);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77843);
      return false;
    }
    h localh2 = o.adg().rj(paramString);
    if ((localh2 != null) && (paramString.equals(localh2.getUsername())) && (paramInt == localh2.dqB))
    {
      AppMethodBeat.o(77843);
      return true;
    }
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = new h();
    }
    localh1.username = paramString;
    localh1.dqB = paramInt;
    localh1.bsY = 3;
    boolean bool = o.adg().b(localh1);
    AppMethodBeat.o(77843);
    return bool;
  }
  
  public static h a(String paramString, bdt parambdt)
  {
    AppMethodBeat.i(77849);
    h localh = new h();
    localh.bsY = -1;
    localh.username = paramString;
    localh.fsk = parambdt.wJr;
    localh.fsl = parambdt.wJq;
    ab.i("MicroMsg.AvatarLogic", "dkhurl contact %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.acX(), localh.acY() });
    boolean bool;
    if (parambdt.xtp != 0)
    {
      bool = true;
      localh.cM(bool);
      if ((parambdt.xtk != 3) && (parambdt.xtk != 4)) {
        break label121;
      }
      localh.dqB = parambdt.xtk;
    }
    for (;;)
    {
      AppMethodBeat.o(77849);
      return localh;
      bool = false;
      break;
      label121:
      if (parambdt.xtk == 2)
      {
        localh.dqB = 3;
        if (!r.Zn().equals(paramString))
        {
          o.acQ();
          d.F(paramString, false);
          o.acQ();
          d.F(paramString, true);
          o.adg().b(localh);
          o.adi().qU(paramString);
        }
      }
    }
  }
  
  public static String ax(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77832);
    paramString1 = paramString1 + "?access_token=" + paramString2;
    AppMethodBeat.o(77832);
    return paramString1;
  }
  
  public static Bitmap b(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(77846);
    if ((bo.isNullOrNil(paramString)) || (!g.RJ().QU()))
    {
      AppMethodBeat.o(77846);
      return null;
    }
    if (!g.RL().Rx())
    {
      paramString = o.acQ().bZ(ah.getContext());
      AppMethodBeat.o(77846);
      return paramString;
    }
    String str = paramString;
    if (ad.nM(paramString)) {
      str = ad.ark(paramString);
    }
    paramString = o.adi().c(str, paramBoolean, paramInt);
    AppMethodBeat.o(77846);
    return paramString;
  }
  
  public static Bitmap d(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(77845);
    if ((bo.isNullOrNil(paramString)) || (!g.RJ().QU()))
    {
      AppMethodBeat.o(77845);
      return null;
    }
    o.acQ();
    Object localObject = d.q(paramString, paramInt1, paramInt2);
    if (localObject == null)
    {
      localObject = new e();
      ((e)localObject).a(paramString, new b.1((e)localObject));
      paramString = b(paramString, false, paramInt3);
      AppMethodBeat.o(77845);
      return paramString;
    }
    paramString = (String)localObject;
    if (paramInt3 > 5) {
      paramString = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject, false, paramInt3);
    }
    AppMethodBeat.o(77845);
    return paramString;
  }
  
  public static boolean d(long paramLong, int paramInt)
  {
    AppMethodBeat.i(77840);
    if (paramInt != 3)
    {
      AppMethodBeat.o(77840);
      return false;
    }
    boolean bool = qQ(gA(paramLong));
    AppMethodBeat.o(77840);
    return bool;
  }
  
  private static String gA(long paramLong)
  {
    AppMethodBeat.i(77838);
    String str = new p(paramLong) + "@qqim";
    AppMethodBeat.o(77838);
    return str;
  }
  
  public static Bitmap gB(long paramLong)
  {
    AppMethodBeat.i(77842);
    Bitmap localBitmap = b(gA(paramLong), false, -1);
    AppMethodBeat.o(77842);
    return localBitmap;
  }
  
  public static Bitmap qK(String paramString)
  {
    AppMethodBeat.i(77833);
    paramString = b(paramString + "@google", false, -1);
    AppMethodBeat.o(77833);
    return paramString;
  }
  
  private static String qL(String paramString)
  {
    AppMethodBeat.i(77834);
    paramString = "http://graph.facebook.com/" + paramString + "/picture";
    AppMethodBeat.o(77834);
    return paramString;
  }
  
  public static void qM(String paramString)
  {
    AppMethodBeat.i(77835);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77835);
      return;
    }
    String str = paramString + "@fb";
    h localh2 = o.adg().rj(str);
    if ((localh2 != null) && (str.equals(localh2.getUsername())) && (3 == localh2.dqB))
    {
      AppMethodBeat.o(77835);
      return;
    }
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = new h();
    }
    localh1.username = str;
    localh1.dqB = 3;
    localh1.fsl = qL(paramString);
    localh1.fsk = qL(paramString);
    localh1.cM(true);
    localh1.bsY = 31;
    o.adg().b(localh1);
    AppMethodBeat.o(77835);
  }
  
  public static Bitmap qN(String paramString)
  {
    AppMethodBeat.i(77836);
    paramString = b(paramString + "@fb", false, -1);
    AppMethodBeat.o(77836);
    return paramString;
  }
  
  public static long qO(String paramString)
  {
    AppMethodBeat.i(77837);
    if (!ad.arh(paramString))
    {
      AppMethodBeat.o(77837);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bo.getLong(paramString[0], -1L);
      AppMethodBeat.o(77837);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(77837);
    }
    return -1L;
  }
  
  public static long qP(String paramString)
  {
    AppMethodBeat.i(77839);
    if (!ad.are(paramString))
    {
      AppMethodBeat.o(77839);
      return -1L;
    }
    paramString = paramString.split("@");
    try
    {
      long l = bo.getLong(paramString[0], -1L);
      AppMethodBeat.o(77839);
      return l;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(77839);
    }
    return -1L;
  }
  
  public static boolean qQ(String paramString)
  {
    AppMethodBeat.i(77841);
    if (paramString == null)
    {
      ab.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(77841);
      return false;
    }
    if (!paramString.endsWith("@qqim"))
    {
      ab.w("MicroMsg.AvatarLogic", "setQQAvatarImgFlag failed : invalid username");
      AppMethodBeat.o(77841);
      return false;
    }
    h localh = new h();
    localh.username = paramString;
    localh.dqB = 3;
    localh.bsY = 3;
    boolean bool = o.adg().b(localh);
    AppMethodBeat.o(77841);
    return bool;
  }
  
  public static Bitmap qR(String paramString)
  {
    AppMethodBeat.i(156855);
    paramString = b(paramString, false, -1);
    AppMethodBeat.o(156855);
    return paramString;
  }
  
  public static String qS(String paramString)
  {
    AppMethodBeat.i(77847);
    if ((bo.isNullOrNil(paramString)) || (!g.RJ().QU()))
    {
      AppMethodBeat.o(77847);
      return null;
    }
    if (!g.RL().Rx())
    {
      AppMethodBeat.o(77847);
      return null;
    }
    if (ad.nM(paramString))
    {
      o.acQ();
      paramString = d.D(ad.ark(paramString), false);
      AppMethodBeat.o(77847);
      return paramString;
    }
    o.acQ();
    paramString = d.D(paramString, false);
    AppMethodBeat.o(77847);
    return paramString;
  }
  
  public static void qT(String paramString)
  {
    AppMethodBeat.i(77848);
    h localh = o.adg().rj(paramString);
    if (localh == null)
    {
      AppMethodBeat.o(77848);
      return;
    }
    if (!paramString.equals(localh.getUsername()))
    {
      AppMethodBeat.o(77848);
      return;
    }
    localh.fsn = 0;
    localh.bsY = 64;
    o.adg().b(localh);
    AppMethodBeat.o(77848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ah.b
 * JD-Core Version:    0.7.0.1
 */