package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.g;
import com.tencent.mm.openim.e.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

public final class v
{
  public static int a(coq paramcoq)
  {
    AppMethodBeat.i(151231);
    int i = paramcoq.ret;
    paramcoq = paramcoq.aavF;
    au localau = c(paramcoq);
    Log.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localau.field_username, localau.field_nickname, localau.field_conRemark, Integer.valueOf(localau.getSource()), Integer.valueOf(localau.sex), localau.field_openImAppid, localau.kav, Integer.valueOf(localau.kau), Integer.valueOf(localau.field_type), localau.field_descWordingId });
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().aA(localau);
    ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cb(paramcoq.app_id, paramcoq.abdn);
    d(paramcoq);
    a(paramcoq);
    b(paramcoq);
    AppMethodBeat.o(151231);
    return i;
  }
  
  public static void a(dxi paramdxi)
  {
    AppMethodBeat.i(235822);
    if (paramdxi.psp != null)
    {
      i locali = new i();
      locali.field_openIMUsername = paramdxi.psp;
      locali.field_openIMSnsFlag = paramdxi.NlD;
      com.tencent.mm.kernel.h.baF();
      ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getSnsFlagStg().a(locali);
    }
    AppMethodBeat.o(235822);
  }
  
  public static void b(dxi paramdxi)
  {
    AppMethodBeat.i(235826);
    g localg;
    if (paramdxi.psp != null)
    {
      localg = new g();
      localg.field_openIMUsername = paramdxi.psp;
      if (paramdxi.YIZ == null) {
        break label71;
      }
    }
    label71:
    for (paramdxi = paramdxi.YIZ;; paramdxi = "")
    {
      localg.field_finder_username = paramdxi;
      com.tencent.mm.kernel.h.baF();
      ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getFinderInfoStg().a(localg);
      AppMethodBeat.o(235826);
      return;
    }
  }
  
  public static au c(dxi paramdxi)
  {
    AppMethodBeat.i(151232);
    Object localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramdxi.psp);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new au();
    }
    ((au)localObject1).setUsername(paramdxi.psp);
    ((au)localObject1).setNickname(paramdxi.nickname);
    ((au)localObject1).setType(paramdxi.type);
    ((au)localObject1).AW(paramdxi.remark);
    ((au)localObject1).setSource(paramdxi.source);
    ((au)localObject1).AY(paramdxi.abdp);
    ((au)localObject1).AZ(paramdxi.abdq);
    ((au)localObject1).Bc(paramdxi.abdr);
    ((au)localObject1).Bb(paramdxi.abds);
    if (paramdxi.abdt == null)
    {
      localObject2 = "";
      ((au)localObject1).BD((String)localObject2);
      if (paramdxi.abdt != null) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = paramdxi.abdt.abdu)
    {
      ((au)localObject1).pE(i);
      ((au)localObject1).BC(paramdxi.YFT);
      ((au)localObject1).Bg(paramdxi.app_id);
      ((au)localObject1).pv(paramdxi.sex);
      ((au)localObject1).Bf(paramdxi.abdn);
      ((au)localObject1).pB((int)Util.nowSecond());
      AppMethodBeat.o(151232);
      return localObject1;
      localObject2 = paramdxi.abdt.IIu;
      break;
    }
  }
  
  public static void d(dxi paramdxi)
  {
    int j = 1;
    AppMethodBeat.i(151233);
    String str2 = "";
    String str1 = "";
    com.tencent.mm.modelavatar.j localj = q.bFE().LS(paramdxi.psp);
    if (localj != null)
    {
      str2 = localj.bFw();
      str1 = localj.bFx();
    }
    localj = new com.tencent.mm.modelavatar.j();
    localj.eQp = -1;
    localj.username = paramdxi.psp;
    localj.osM = paramdxi.abdd;
    localj.osN = paramdxi.abdc;
    Log.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { localj.getUsername(), localj.bFw(), localj.bFx() });
    if (!localj.bFw().equals(str2))
    {
      q.bFp();
      AvatarStorage.T(paramdxi.psp, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!localj.bFx().equals(str1))
      {
        q.bFp();
        AvatarStorage.T(paramdxi.psp, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          q.bFG().LB(paramdxi.psp);
          q.bFE().b(localj);
        }
        AppMethodBeat.o(151233);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.v
 * JD-Core Version:    0.7.0.1
 */