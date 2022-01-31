package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.vending.b.b;

public final class a
  implements r
{
  private static final a.a mcw = new a.a((byte)0);
  
  public static b a(c paramc)
  {
    return mcw.aj(paramc);
  }
  
  public static void a(axd paramaxd, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramaxd == null)
    {
      y.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      return;
    }
    String str1 = aa.a(paramaxd.sQs);
    String str2 = bk.pm(paramaxd.ttu);
    if ((bk.bl(str1)) && (bk.bl(str2)))
    {
      y.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      return;
    }
    y.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", new Object[] { paramaxd.sQs, paramaxd.ttx, paramaxd.tty });
    Object localObject1 = ((j)g.r(j.class)).Fw().abl(str1);
    if ((localObject1 != null) && (str1.equals(((ao)localObject1).field_encryptUsername)))
    {
      y.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((ad)localObject1).cug();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ad(str1);
      }
      ((ad)localObject3).setUsername(str1);
      ((ad)localObject3).cZ(paramaxd.ffm);
      ((ad)localObject3).setType(paramaxd.sPr & paramaxd.sPs);
      if ((paramBoolean1) && (localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).dBe > 0))
      {
        y.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((ao)localObject2).field_type), Integer.valueOf(((ao)localObject3).field_type) });
        ((ad)localObject3).setType(((ao)localObject3).field_type | ((ao)localObject2).field_type);
      }
      label314:
      long l;
      label322:
      label628:
      boolean bool;
      label872:
      int i;
      if (!bk.bl(str2))
      {
        ((ad)localObject3).dq(str2);
        if (localObject2 != null) {
          break label1200;
        }
        l = 0L;
        ((ad)localObject3).dBe = l;
        ((ad)localObject3).dk(aa.a(paramaxd.tmw));
        ((ad)localObject3).dl(aa.a(paramaxd.sQa));
        ((ad)localObject3).dm(aa.a(paramaxd.sQb));
        ((ad)localObject3).fm(paramaxd.ffh);
        ((ad)localObject3).fp(paramaxd.sPx);
        ((ad)localObject3).dg(aa.a(paramaxd.tto));
        ((ad)localObject3).fq(paramaxd.sPB);
        ((ad)localObject3).fr(paramaxd.ffl);
        ((ad)localObject3).dF(RegionCodeDecoder.ao(paramaxd.ffq, paramaxd.ffi, paramaxd.ffj));
        ((ad)localObject3).dz(paramaxd.ffk);
        ((ad)localObject3).fi(paramaxd.tpg);
        ((ad)localObject3).dE(paramaxd.tph);
        ((ad)localObject3).setSource(paramaxd.swS);
        ((ad)localObject3).fh(paramaxd.tpk);
        ((ad)localObject3).dn(paramaxd.tpj);
        if (s.ia(paramaxd.tpi)) {
          ((ad)localObject3).dD(paramaxd.tpi);
        }
        if (((ad)localObject3).cud()) {
          ((ad)localObject3).ft((int)bk.UX());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((ad)localObject3).dN(paramString);
        }
        ((ad)localObject3).df(aa.a(paramaxd.tsS));
        ((ad)localObject3).jdMethod_do(aa.a(paramaxd.tsU));
        ((ad)localObject3).dp(aa.a(paramaxd.tsT));
        ((ad)localObject3).dr(paramaxd.sQu);
        ((ad)localObject3).dG(paramaxd.sxZ);
        ((ad)localObject3).dH(paramaxd.ttE);
        if (bk.bE(paramArrayOfByte)) {
          break label1212;
        }
        ((j)g.r(j.class)).Fw().x(str1, paramArrayOfByte);
        ((ad)localObject3).fk(paramaxd.ttD);
        if ((paramaxd.ttz != null) && (paramaxd.ttz.svV != null))
        {
          ((ad)localObject3).dI(paramaxd.ttz.svV.sBf);
          ((ad)localObject3).dJ(paramaxd.ttz.svV.sBg);
          ((ad)localObject3).dK(paramaxd.ttz.svV.sBh);
        }
        if ((localObject2 != null) && (!com.tencent.mm.n.a.gR(((ao)localObject2).field_type))) {
          com.tencent.mm.n.a.gR(((ao)localObject3).field_type);
        }
        if (s.hU(str1)) {
          ((ad)localObject3).AQ();
        }
        if (((ad)localObject3).cua()) {
          ((ad)localObject3).AT();
        }
        ((ad)localObject3).dL(paramaxd.cCO);
        ((ad)localObject3).fv(paramaxd.ttI);
        int j = (int)((com.tencent.mm.n.a)localObject3).dBe;
        localObject1 = ((ao)localObject3).field_nickname;
        String str3 = ((ad)localObject3).vo();
        int k = ((ao)localObject3).field_deleteFlag;
        int m = ((ao)localObject3).field_type;
        int n = paramaxd.sPr;
        int i1 = paramaxd.sPs;
        int i2 = ((ao)localObject3).cCv;
        int i3 = ((ao)localObject3).cCy;
        String str4 = paramaxd.ffq;
        String str5 = paramaxd.ffi;
        String str6 = paramaxd.ffj;
        int i4 = ((ad)localObject3).getSource();
        String str7 = ((ao)localObject3).field_contactLabelIds;
        if (paramaxd.sxZ != null) {
          break label1236;
        }
        bool = true;
        if (paramaxd.sxZ != null) {
          break label1242;
        }
        i = 0;
        label882:
        if (paramaxd.sxZ != null) {
          break label1254;
        }
        paramString = "";
        label893:
        y.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)", new Object[] { str1, str2, Integer.valueOf(j), localObject1, str3, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), str4, str5, str6, Integer.valueOf(i4), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        mcw.a((ad)localObject3, (ad)localObject2, paramaxd, paramArrayOfByte, paramBoolean2);
        if (bk.bl(str2)) {
          break label1265;
        }
        ((j)g.r(j.class)).Fw().b(str2, (ad)localObject3);
      }
      for (;;)
      {
        mcw.b((ad)localObject3, (ad)localObject2, paramaxd, paramArrayOfByte, paramBoolean2);
        if ((((ao)localObject3).field_type & 0x800) == 0) {
          break label1289;
        }
        if ((localObject2 != null) && ((((ao)localObject2).field_type & 0x800) == (((ao)localObject3).field_type & 0x800))) {
          break;
        }
        ((j)g.r(j.class)).FB().abB(((ao)localObject3).field_username);
        return;
        if ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).dBe <= 0)) {
          break label314;
        }
        ((ad)localObject3).dq(((ao)localObject2).field_encryptUsername);
        break label314;
        label1200:
        l = (int)((com.tencent.mm.n.a)localObject2).dBe;
        break label322;
        label1212:
        ((j)g.r(j.class)).Fw().abq(str1);
        break label628;
        label1236:
        bool = false;
        break label872;
        label1242:
        i = paramaxd.sxZ.length();
        break label882;
        label1254:
        paramString = bk.aac(paramaxd.sxZ);
        break label893;
        label1265:
        ((j)g.r(j.class)).Fw().U((ad)localObject3);
      }
      label1289:
      if ((localObject2 != null) && ((((ao)localObject2).field_type & 0x800) == (((ao)localObject3).field_type & 0x800))) {
        break;
      }
      ((j)g.r(j.class)).FB().abC(((ao)localObject3).field_username);
      return;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final void a(qv paramqv, byte[] paramArrayOfByte, boolean paramBoolean, t paramt)
  {
    switch (paramqv.sOA)
    {
    default: 
      return;
    case 2: 
    case 17: 
      paramqv = (axd)new axd().aH(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        a(paramqv, "", paramArrayOfByte, false, paramBoolean);
        return;
        paramArrayOfByte = null;
      }
    }
    paramqv = (sr)new sr().aH(paramArrayOfByte);
    paramArrayOfByte = aa.a(paramqv.sQs);
    y.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
    ((j)g.r(j.class)).FB().abu(paramArrayOfByte);
    s.hn(paramArrayOfByte);
    u.b(4, paramqv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a
 * JD-Core Version:    0.7.0.1
 */