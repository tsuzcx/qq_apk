package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class s
{
  public static int a(brp parambrp)
  {
    AppMethodBeat.i(151231);
    int i = parambrp.ret;
    parambrp = parambrp.LYS;
    as localas = a(parambrp);
    Log.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localas.field_username, localas.field_nickname, localas.field_conRemark, Integer.valueOf(localas.getSource()), Integer.valueOf(localas.fuA), localas.field_openImAppid, localas.fvb, Integer.valueOf(localas.fva), Integer.valueOf(localas.field_type), localas.field_descWordingId });
    ((l)g.af(l.class)).aSN().ao(localas);
    ((a)g.af(a.class)).bM(parambrp.app_id, parambrp.MBp);
    b(parambrp);
    AppMethodBeat.o(151231);
    return i;
  }
  
  public static as a(cvw paramcvw)
  {
    AppMethodBeat.i(151232);
    Object localObject2 = ((l)g.af(l.class)).aSN().Kn(paramcvw.jGZ);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new as();
    }
    ((as)localObject1).setUsername(paramcvw.jGZ);
    ((as)localObject1).setNickname(paramcvw.nickname);
    ((as)localObject1).setType(paramcvw.type);
    ((as)localObject1).BD(paramcvw.remark);
    ((as)localObject1).setSource(paramcvw.source);
    ((as)localObject1).BF(paramcvw.MBr);
    ((as)localObject1).BG(paramcvw.MBs);
    ((as)localObject1).BJ(paramcvw.MBt);
    ((as)localObject1).BI(paramcvw.MBu);
    if (paramcvw.MBv == null)
    {
      localObject2 = "";
      ((as)localObject1).Ck((String)localObject2);
      if (paramcvw.MBv != null) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = paramcvw.MBv.MBw)
    {
      ((as)localObject1).nr(i);
      ((as)localObject1).Cj(paramcvw.KHz);
      ((as)localObject1).BN(paramcvw.app_id);
      ((as)localObject1).nj(paramcvw.fuA);
      ((as)localObject1).BM(paramcvw.MBp);
      ((as)localObject1).no((int)Util.nowSecond());
      AppMethodBeat.o(151232);
      return localObject1;
      localObject2 = paramcvw.MBv.xKd;
      break;
    }
  }
  
  public static void b(cvw paramcvw)
  {
    int j = 1;
    AppMethodBeat.i(151233);
    String str2 = "";
    String str1 = "";
    i locali = p.aYB().Mx(paramcvw.jGZ);
    if (locali != null)
    {
      str2 = locali.aYt();
      str1 = locali.aYu();
    }
    locali = new i();
    locali.cSx = -1;
    locali.username = paramcvw.jGZ;
    locali.iKW = paramcvw.MBf;
    locali.iKX = paramcvw.MBe;
    Log.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aYt(), locali.aYu() });
    if (!locali.aYt().equals(str2))
    {
      p.aYn();
      e.N(paramcvw.jGZ, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!locali.aYu().equals(str1))
      {
        p.aYn();
        e.N(paramcvw.jGZ, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          p.aYD().Mg(paramcvw.jGZ);
          p.aYB().b(locali);
        }
        AppMethodBeat.o(151233);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.s
 * JD-Core Version:    0.7.0.1
 */