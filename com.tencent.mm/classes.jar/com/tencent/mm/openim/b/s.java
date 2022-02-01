package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public final class s
{
  public static int a(bfd parambfd)
  {
    AppMethodBeat.i(151231);
    int i = parambfd.ret;
    parambfd = parambfd.GBa;
    am localam = a(parambfd);
    ad.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localam.field_username, localam.field_nickname, localam.field_conRemark, Integer.valueOf(localam.getSource()), Integer.valueOf(localam.ePk), localam.field_openImAppid, localam.ePN, Integer.valueOf(localam.ePM), Integer.valueOf(localam.field_type), localam.field_descWordingId });
    ((l)g.ab(l.class)).azp().af(localam);
    ((b)g.ab(b.class)).bB(parambfd.app_id, parambfd.GYR);
    b(parambfd);
    AppMethodBeat.o(151231);
    return i;
  }
  
  public static am a(cev paramcev)
  {
    AppMethodBeat.i(151232);
    Object localObject2 = ((l)g.ab(l.class)).azp().Bf(paramcev.iHA);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new am();
    }
    ((am)localObject1).setUsername(paramcev.iHA);
    ((am)localObject1).sT(paramcev.nickname);
    ((am)localObject1).setType(paramcev.type);
    ((am)localObject1).sR(paramcev.iTM);
    ((am)localObject1).setSource(paramcev.dnh);
    ((am)localObject1).sU(paramcev.GYT);
    ((am)localObject1).sV(paramcev.GYU);
    ((am)localObject1).sY(paramcev.GYV);
    ((am)localObject1).sX(paramcev.GYW);
    if (paramcev.GYX == null)
    {
      localObject2 = "";
      ((am)localObject1).tz((String)localObject2);
      if (paramcev.GYX != null) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = paramcev.GYX.GYY)
    {
      ((am)localObject1).kn(i);
      ((am)localObject1).ty(paramcev.Fvw);
      ((am)localObject1).tc(paramcev.app_id);
      ((am)localObject1).kf(paramcev.ePk);
      ((am)localObject1).tb(paramcev.GYR);
      ((am)localObject1).kk((int)bt.aQJ());
      AppMethodBeat.o(151232);
      return localObject1;
      localObject2 = paramcev.GYX.ugo;
      break;
    }
  }
  
  public static void b(cev paramcev)
  {
    int j = 1;
    AppMethodBeat.i(151233);
    String str2 = "";
    String str1 = "";
    i locali = p.aEx().Dj(paramcev.iHA);
    if (locali != null)
    {
      str2 = locali.aEq();
      str1 = locali.aEr();
    }
    locali = new i();
    locali.dDp = -1;
    locali.username = paramcev.iHA;
    locali.hMW = paramcev.GYG;
    locali.hMX = paramcev.GYF;
    ad.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aEq(), locali.aEr() });
    if (!locali.aEq().equals(str2))
    {
      p.aEk();
      e.L(paramcev.iHA, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!locali.aEr().equals(str1))
      {
        p.aEk();
        e.L(paramcev.iHA, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          p.aEz().CU(paramcev.iHA);
          p.aEx().b(locali);
        }
        AppMethodBeat.o(151233);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.s
 * JD-Core Version:    0.7.0.1
 */