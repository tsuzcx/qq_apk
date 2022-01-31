package com.tencent.mm.openim.b;

import com.tencent.mm.ag.c;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class r
{
  public static int a(aib paramaib)
  {
    int i = paramaib.ret;
    paramaib = paramaib.tfr;
    ad localad = a(paramaib);
    y.i("MicroMsg.OpenIMContactLogic", "onGYNetEnd openim_processModContact user:%s nick:%s remark:%s, source:%d, sex%d, appId:%s, customDetail:%s, customDetailVisible:%d， type:%d, wordingId:%s", new Object[] { localad.field_username, localad.field_nickname, localad.field_conRemark, Integer.valueOf(localad.getSource()), Integer.valueOf(localad.sex), localad.field_openImAppid, localad.cCU, Integer.valueOf(localad.cCT), Integer.valueOf(localad.field_type), localad.field_descWordingId });
    ((j)g.r(j.class)).Fw().U(localad);
    ((b)g.r(b.class)).aJ(paramaib.app_id, paramaib.txg);
    b(paramaib);
    return i;
  }
  
  public static ad a(bbd parambbd)
  {
    Object localObject2 = ((j)g.r(j.class)).Fw().abl(parambbd.ePQ);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ad();
    }
    ((ad)localObject1).setUsername(parambbd.ePQ);
    ((ad)localObject1).dk(parambbd.nickname);
    ((ad)localObject1).setType(parambbd.type);
    ((ad)localObject1).df(parambbd.fGK);
    ((ad)localObject1).setSource(parambbd.source);
    ((ad)localObject1).dl(parambbd.txi);
    ((ad)localObject1).dm(parambbd.txj);
    ((ad)localObject1).dp(parambbd.txk);
    ((ad)localObject1).jdMethod_do(parambbd.txl);
    if (parambbd.txm == null)
    {
      localObject2 = "";
      ((ad)localObject1).dO((String)localObject2);
      if (parambbd.txm != null) {
        break label191;
      }
    }
    label191:
    for (int i = 0;; i = parambbd.txm.txn)
    {
      ((ad)localObject1).fw(i);
      ((ad)localObject1).dN(parambbd.svT);
      ((ad)localObject1).dt(parambbd.app_id);
      ((ad)localObject1).fm(parambbd.sex);
      ((ad)localObject1).ds(parambbd.txg);
      ((ad)localObject1).ft((int)bk.UX());
      return localObject1;
      localObject2 = parambbd.txm.kSY;
      break;
    }
  }
  
  public static void b(bbd parambbd)
  {
    int j = 1;
    String str2 = "";
    String str1 = "";
    h localh = o.Kh().kp(parambbd.ePQ);
    if (localh != null)
    {
      str2 = localh.JX();
      str1 = localh.JY();
    }
    localh = new h();
    localh.bcw = -1;
    localh.username = parambbd.ePQ;
    localh.ebS = parambbd.twX;
    localh.ebT = parambbd.twW;
    y.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", new Object[] { localh.getUsername(), localh.JX(), localh.JY() });
    if (!localh.JX().equals(str2))
    {
      o.JQ();
      d.B(parambbd.ePQ, true);
    }
    for (int i = 1;; i = 0)
    {
      if (!localh.JY().equals(str1))
      {
        o.JQ();
        d.B(parambbd.ePQ, false);
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          o.Kj().kb(parambbd.ePQ);
          o.Kh().a(localh);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.openim.b.r
 * JD-Core Version:    0.7.0.1
 */