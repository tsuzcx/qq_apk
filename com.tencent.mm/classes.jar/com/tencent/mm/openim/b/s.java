package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

public final class s
{
  public static int a(axh paramaxh)
  {
    AppMethodBeat.i(151231);
    int i = paramaxh.ret;
    paramaxh = paramaxh.Dwn;
    af localaf = a(paramaxh);
    ad.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localaf.field_username, localaf.field_nickname, localaf.field_conRemark, Integer.valueOf(localaf.getSource()), Integer.valueOf(localaf.evp), localaf.field_openImAppid, localaf.evS, Integer.valueOf(localaf.evR), Integer.valueOf(localaf.field_type), localaf.field_descWordingId });
    ((k)g.ab(k.class)).apM().ae(localaf);
    ((b)g.ab(b.class)).bs(paramaxh.app_id, paramaxh.DSK);
    b(paramaxh);
    AppMethodBeat.o(151231);
    return i;
  }
  
  public static af a(bvm parambvm)
  {
    AppMethodBeat.i(151232);
    Object localObject2 = ((k)g.ab(k.class)).apM().aHY(parambvm.hNH);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new af();
    }
    ((af)localObject1).setUsername(parambvm.hNH);
    ((af)localObject1).nd(parambvm.nickname);
    ((af)localObject1).setType(parambvm.type);
    ((af)localObject1).nb(parambvm.iaz);
    ((af)localObject1).setSource(parambvm.dep);
    ((af)localObject1).ne(parambvm.DSM);
    ((af)localObject1).nf(parambvm.DSN);
    ((af)localObject1).ni(parambvm.DSO);
    ((af)localObject1).nh(parambvm.DSP);
    if (parambvm.DSQ == null)
    {
      localObject2 = "";
      ((af)localObject1).nJ((String)localObject2);
      if (parambvm.DSQ != null) {
        break label201;
      }
    }
    label201:
    for (int i = 0;; i = parambvm.DSQ.DSR)
    {
      ((af)localObject1).jR(i);
      ((af)localObject1).nI(parambvm.CxM);
      ((af)localObject1).nm(parambvm.app_id);
      ((af)localObject1).jJ(parambvm.evp);
      ((af)localObject1).nl(parambvm.DSK);
      ((af)localObject1).jO((int)bt.aGK());
      AppMethodBeat.o(151232);
      return localObject1;
      localObject2 = parambvm.DSQ.saB;
      break;
    }
  }
  
  public static void b(bvm parambvm)
  {
    int j = 1;
    AppMethodBeat.i(151233);
    String str2 = "";
    String str1 = "";
    i locali = p.auF().we(parambvm.hNH);
    if (locali != null)
    {
      str2 = locali.aux();
      str1 = locali.auy();
    }
    locali = new i();
    locali.dtM = -1;
    locali.username = parambvm.hNH;
    locali.gUf = parambvm.DSz;
    locali.gUg = parambvm.DSy;
    ad.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { locali.getUsername(), locali.aux(), locali.auy() });
    if (!locali.aux().equals(str2))
    {
      p.auq();
      e.K(parambvm.hNH, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!locali.auy().equals(str1))
      {
        p.auq();
        e.K(parambvm.hNH, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          p.auH().vP(parambvm.hNH);
          p.auF().b(locali);
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