package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.c;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class s
{
  public static int a(anc paramanc)
  {
    AppMethodBeat.i(78887);
    int i = paramanc.ret;
    paramanc = paramanc.xdC;
    ad localad = a(paramanc);
    ab.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localad.field_username, localad.field_nickname, localad.field_conRemark, Integer.valueOf(localad.getSource()), Integer.valueOf(localad.dqC), localad.field_openImAppid, localad.dre, Integer.valueOf(localad.drd), Integer.valueOf(localad.field_type), localad.field_descWordingId });
    ((j)g.E(j.class)).YA().X(localad);
    ((b)g.E(b.class)).bc(paramanc.app_id, paramanc.xxm);
    b(paramanc);
    AppMethodBeat.o(78887);
    return i;
  }
  
  public static ad a(bid parambid)
  {
    AppMethodBeat.i(78888);
    Object localObject2 = ((j)g.E(j.class)).YA().arw(parambid.gfL);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ad();
    }
    ((ad)localObject1).setUsername(parambid.gfL);
    ((ad)localObject1).jp(parambid.nickname);
    ((ad)localObject1).setType(parambid.type);
    ((ad)localObject1).jn(parambid.hKa);
    ((ad)localObject1).setSource(parambid.cpt);
    ((ad)localObject1).jq(parambid.xxo);
    ((ad)localObject1).jr(parambid.xxp);
    ((ad)localObject1).ju(parambid.xxq);
    ((ad)localObject1).jt(parambid.xxr);
    if (parambid.xxs == null)
    {
      localObject2 = "";
      ((ad)localObject1).jU((String)localObject2);
      if (parambid.xxs != null) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = parambid.xxs.xxt)
    {
      ((ad)localObject1).hH(i);
      ((ad)localObject1).jT(parambid.wpd);
      ((ad)localObject1).jy(parambid.app_id);
      ((ad)localObject1).hy(parambid.dqC);
      ((ad)localObject1).jx(parambid.xxm);
      ((ad)localObject1).hE((int)bo.aox());
      AppMethodBeat.o(78888);
      return localObject1;
      localObject2 = parambid.xxs.nqY;
      break;
    }
  }
  
  public static void b(bid parambid)
  {
    int j = 1;
    AppMethodBeat.i(78889);
    String str2 = "";
    String str1 = "";
    h localh = o.adg().rj(parambid.gfL);
    if (localh != null)
    {
      str2 = localh.acX();
      str1 = localh.acY();
    }
    localh = new h();
    localh.bsY = -1;
    localh.username = parambid.gfL;
    localh.fsk = parambid.xxc;
    localh.fsl = parambid.xxb;
    ab.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.acX(), localh.acY() });
    if (!localh.acX().equals(str2))
    {
      o.acQ();
      d.F(parambid.gfL, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!localh.acY().equals(str1))
      {
        o.acQ();
        d.F(parambid.gfL, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          o.adi().qU(parambid.gfL);
          o.adg().b(localh);
        }
        AppMethodBeat.o(78889);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.openim.b.s
 * JD-Core Version:    0.7.0.1
 */