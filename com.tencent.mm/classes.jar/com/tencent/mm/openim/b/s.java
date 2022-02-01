package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public final class s
{
  public static int a(bzl parambzl)
  {
    AppMethodBeat.i(151231);
    int i = parambzl.ret;
    parambzl = parambzl.Tim;
    as localas = b(parambzl);
    Log.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localas.field_username, localas.field_nickname, localas.field_conRemark, Integer.valueOf(localas.getSource()), Integer.valueOf(localas.sex), localas.field_openImAppid, localas.hDA, Integer.valueOf(localas.hDz), Integer.valueOf(localas.field_type), localas.field_descWordingId });
    ((n)h.ae(n.class)).bbL().au(localas);
    ((a)h.ae(a.class)).bQ(parambzl.app_id, parambzl.TMW);
    c(parambzl);
    a(parambzl);
    AppMethodBeat.o(151231);
    return i;
  }
  
  public static void a(dfg paramdfg)
  {
    AppMethodBeat.i(226709);
    com.tencent.mm.openim.e.e locale;
    if (paramdfg.myd != null)
    {
      locale = new com.tencent.mm.openim.e.e();
      locale.field_openIMUsername = paramdfg.myd;
      if (paramdfg.RLN == null) {
        break label71;
      }
    }
    label71:
    for (paramdfg = paramdfg.RLN;; paramdfg = "")
    {
      locale.field_finder_username = paramdfg;
      h.aHH();
      ((PluginOpenIM)h.ag(PluginOpenIM.class)).getFinderInfoStg().a(locale);
      AppMethodBeat.o(226709);
      return;
    }
  }
  
  public static as b(dfg paramdfg)
  {
    AppMethodBeat.i(151232);
    Object localObject2 = ((n)h.ae(n.class)).bbL().RG(paramdfg.myd);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new as();
    }
    ((as)localObject1).setUsername(paramdfg.myd);
    ((as)localObject1).setNickname(paramdfg.nickname);
    ((as)localObject1).setType(paramdfg.type);
    ((as)localObject1).Ir(paramdfg.remark);
    ((as)localObject1).setSource(paramdfg.source);
    ((as)localObject1).It(paramdfg.TMY);
    ((as)localObject1).Iu(paramdfg.TMZ);
    ((as)localObject1).Ix(paramdfg.TNa);
    ((as)localObject1).Iw(paramdfg.TNb);
    if (paramdfg.TNc == null)
    {
      localObject2 = "";
      ((as)localObject1).IY((String)localObject2);
      if (paramdfg.TNc != null) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = paramdfg.TNc.TNd)
    {
      ((as)localObject1).pF(i);
      ((as)localObject1).IX(paramdfg.RIS);
      ((as)localObject1).IB(paramdfg.app_id);
      ((as)localObject1).pw(paramdfg.sex);
      ((as)localObject1).IA(paramdfg.TMW);
      ((as)localObject1).pC((int)Util.nowSecond());
      AppMethodBeat.o(151232);
      return localObject1;
      localObject2 = paramdfg.TNc.COk;
      break;
    }
  }
  
  public static void c(dfg paramdfg)
  {
    int j = 1;
    AppMethodBeat.i(151233);
    String str2 = "";
    String str1 = "";
    j localj = q.bhP().TS(paramdfg.myd);
    if (localj != null)
    {
      str2 = localj.bhH();
      str1 = localj.bhI();
    }
    localj = new j();
    localj.cUP = -1;
    localj.username = paramdfg.myd;
    localj.lBd = paramdfg.TMM;
    localj.lBe = paramdfg.TML;
    Log.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { localj.getUsername(), localj.bhH(), localj.bhI() });
    if (!localj.bhH().equals(str2))
    {
      q.bhz();
      com.tencent.mm.am.f.P(paramdfg.myd, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!localj.bhI().equals(str1))
      {
        q.bhz();
        com.tencent.mm.am.f.P(paramdfg.myd, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          q.bhR().TB(paramdfg.myd);
          q.bhP().b(localj);
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