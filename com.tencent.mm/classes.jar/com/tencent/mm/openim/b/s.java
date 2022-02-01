package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public final class s
{
  public static int a(baz parambaz)
  {
    AppMethodBeat.i(151231);
    int i = parambaz.ret;
    parambaz = parambaz.ERI;
    ai localai = a(parambaz);
    ac.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localai.field_username, localai.field_nickname, localai.field_conRemark, Integer.valueOf(localai.getSource()), Integer.valueOf(localai.exL), localai.field_openImAppid, localai.eyp, Integer.valueOf(localai.eyo), Integer.valueOf(localai.field_type), localai.field_descWordingId });
    ((k)g.ab(k.class)).awB().af(localai);
    ((b)g.ab(b.class)).bA(parambaz.app_id, parambaz.Fpg);
    b(parambaz);
    AppMethodBeat.o(151231);
    return i;
  }
  
  public static ai a(cae paramcae)
  {
    AppMethodBeat.i(151232);
    Object localObject2 = ((k)g.ab(k.class)).awB().aNt(paramcae.iod);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ai();
    }
    ((ai)localObject1).setUsername(paramcae.iod);
    ((ai)localObject1).qj(paramcae.nickname);
    ((ai)localObject1).setType(paramcae.type);
    ((ai)localObject1).qh(paramcae.iAC);
    ((ai)localObject1).setSource(paramcae.dbL);
    ((ai)localObject1).qk(paramcae.Fpi);
    ((ai)localObject1).ql(paramcae.Fpj);
    ((ai)localObject1).qo(paramcae.Fpk);
    ((ai)localObject1).qn(paramcae.Fpl);
    if (paramcae.Fpm == null)
    {
      localObject2 = "";
      ((ai)localObject1).qP((String)localObject2);
      if (paramcae.Fpm != null) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = paramcae.Fpm.Fpn)
    {
      ((ai)localObject1).jP(i);
      ((ai)localObject1).qO(paramcae.DQi);
      ((ai)localObject1).qs(paramcae.app_id);
      ((ai)localObject1).jH(paramcae.exL);
      ((ai)localObject1).qr(paramcae.Fpg);
      ((ai)localObject1).jM((int)bs.aNx());
      AppMethodBeat.o(151232);
      return localObject1;
      localObject2 = paramcae.Fpm.tiv;
      break;
    }
  }
  
  public static void b(cae paramcae)
  {
    int j = 1;
    AppMethodBeat.i(151233);
    String str2 = "";
    String str1 = "";
    i locali = p.aBw().Ak(paramcae.iod);
    if (locali != null)
    {
      str2 = locali.aBo();
      str1 = locali.aBp();
    }
    locali = new i();
    locali.drx = -1;
    locali.username = paramcae.iod;
    locali.huE = paramcae.FoV;
    locali.huF = paramcae.FoU;
    ac.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aBo(), locali.aBp() });
    if (!locali.aBo().equals(str2))
    {
      p.aBh();
      e.L(paramcae.iod, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!locali.aBp().equals(str1))
      {
        p.aBh();
        e.L(paramcae.iod, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          p.aBy().zV(paramcae.iod);
          p.aBw().b(locali);
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