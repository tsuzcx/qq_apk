package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public final class s
{
  public static int a(bft parambft)
  {
    AppMethodBeat.i(151231);
    int i = parambft.ret;
    parambft = parambft.GUA;
    an localan = a(parambft);
    ae.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localan.field_username, localan.field_nickname, localan.field_conRemark, Integer.valueOf(localan.getSource()), Integer.valueOf(localan.eQV), localan.field_openImAppid, localan.eRy, Integer.valueOf(localan.eRx), Integer.valueOf(localan.field_type), localan.field_descWordingId });
    ((l)g.ab(l.class)).azF().am(localan);
    ((a)g.ab(a.class)).bB(parambft.app_id, parambft.Hss);
    b(parambft);
    AppMethodBeat.o(151231);
    return i;
  }
  
  public static an a(cfp paramcfp)
  {
    AppMethodBeat.i(151232);
    Object localObject2 = ((l)g.ab(l.class)).azF().BH(paramcfp.iKt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new an();
    }
    ((an)localObject1).setUsername(paramcfp.iKt);
    ((an)localObject1).to(paramcfp.nickname);
    ((an)localObject1).setType(paramcfp.type);
    ((an)localObject1).tm(paramcfp.iWF);
    ((an)localObject1).setSource(paramcfp.doj);
    ((an)localObject1).tp(paramcfp.Hsu);
    ((an)localObject1).tq(paramcfp.Hsv);
    ((an)localObject1).tt(paramcfp.Hsw);
    ((an)localObject1).ts(paramcfp.Hsx);
    if (paramcfp.Hsy == null)
    {
      localObject2 = "";
      ((an)localObject1).tU((String)localObject2);
      if (paramcfp.Hsy != null) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = paramcfp.Hsy.Hsz)
    {
      ((an)localObject1).kp(i);
      ((an)localObject1).tT(paramcfp.FNU);
      ((an)localObject1).tx(paramcfp.app_id);
      ((an)localObject1).kh(paramcfp.eQV);
      ((an)localObject1).tw(paramcfp.Hss);
      ((an)localObject1).km((int)bu.aRi());
      AppMethodBeat.o(151232);
      return localObject1;
      localObject2 = paramcfp.Hsy.urL;
      break;
    }
  }
  
  public static void b(cfp paramcfp)
  {
    int j = 1;
    AppMethodBeat.i(151233);
    String str2 = "";
    String str1 = "";
    i locali = p.aEN().DL(paramcfp.iKt);
    if (locali != null)
    {
      str2 = locali.aEG();
      str1 = locali.aEH();
    }
    locali = new i();
    locali.dEu = -1;
    locali.username = paramcfp.iKt;
    locali.hPP = paramcfp.Hsh;
    locali.hPQ = paramcfp.Hsg;
    ae.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aEG(), locali.aEH() });
    if (!locali.aEG().equals(str2))
    {
      p.aEA();
      e.L(paramcfp.iKt, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!locali.aEH().equals(str1))
      {
        p.aEA();
        e.L(paramcfp.iKt, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          p.aEP().Dw(paramcfp.iKt);
          p.aEN().b(locali);
        }
        AppMethodBeat.o(151233);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.s
 * JD-Core Version:    0.7.0.1
 */