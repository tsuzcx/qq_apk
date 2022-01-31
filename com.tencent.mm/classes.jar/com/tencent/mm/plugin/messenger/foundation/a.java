package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.wr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.vending.b.b;

public final class a
  implements r
{
  private static final a.a oCY;
  
  static
  {
    AppMethodBeat.i(1023);
    oCY = new a.a((byte)0);
    AppMethodBeat.o(1023);
  }
  
  public static b a(c paramc)
  {
    AppMethodBeat.i(1020);
    paramc = oCY.at(paramc);
    AppMethodBeat.o(1020);
    return paramc;
  }
  
  public static void a(bdt parambdt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(1022);
    if (parambdt == null)
    {
      ab.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      AppMethodBeat.o(1022);
      return;
    }
    String str1 = aa.a(parambdt.wOT);
    String str2 = bo.nullAsNil(parambdt.xtu);
    if ((bo.isNullOrNil(str1)) && (bo.isNullOrNil(str2)))
    {
      ab.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      AppMethodBeat.o(1022);
      return;
    }
    ab.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", new Object[] { parambdt.wOT, parambdt.xtx, parambdt.xty });
    Object localObject1 = ((j)g.E(j.class)).YA().arw(str1);
    if ((localObject1 != null) && (str1.equals(((aq)localObject1).field_encryptUsername)))
    {
      ab.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      AppMethodBeat.o(1022);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((ad)localObject1).dwF();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ad(str1);
      }
      ((ad)localObject3).setUsername(str1);
      ((ad)localObject3).jm(parambdt.gwU);
      ((ad)localObject3).setType(parambdt.wNK & parambdt.wNL);
      if ((paramBoolean1) && (localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).euF > 0))
      {
        ab.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((aq)localObject2).field_type), Integer.valueOf(((aq)localObject3).field_type) });
        ((ad)localObject3).setType(((aq)localObject3).field_type | ((aq)localObject2).field_type);
      }
      long l;
      label346:
      label740:
      boolean bool;
      label959:
      int i;
      if (!bo.isNullOrNil(str2))
      {
        ((ad)localObject3).jv(str2);
        if (localObject2 != null) {
          break label1321;
        }
        l = 0L;
        ((ad)localObject3).euF = l;
        ((ad)localObject3).jp(aa.a(parambdt.xmi));
        ((ad)localObject3).jq(aa.a(parambdt.wOv));
        ((ad)localObject3).jr(aa.a(parambdt.wOw));
        ((ad)localObject3).hy(parambdt.gwP);
        ((ad)localObject3).hA(parambdt.wNQ);
        ((ad)localObject3).jo(aa.a(parambdt.xto));
        ((ad)localObject3).hB(parambdt.wNU);
        ((ad)localObject3).hC(parambdt.gwT);
        ((ad)localObject3).jL(RegionCodeDecoder.aF(parambdt.gwY, parambdt.gwQ, parambdt.gwR));
        ((ad)localObject3).jF(parambdt.gwS);
        ((ad)localObject3).hu(parambdt.xpe);
        ((ad)localObject3).jK(parambdt.xpf);
        if ((parambdt.niK == 9) && (!bo.isNullOrNil(parambdt.xtH)))
        {
          ab.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
          parambdt.niK = 14;
        }
        ((ad)localObject3).setSource(parambdt.niK);
        ((ad)localObject3).ht(parambdt.xpi);
        ((ad)localObject3).js(parambdt.xph);
        ((ad)localObject3).jz(parambdt.xtH);
        ab.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s", new Object[] { ((aq)localObject3).field_username, ((aq)localObject3).field_nickname, ((aq)localObject3).field_sourceExtInfo, Integer.valueOf(parambdt.niK) });
        if (t.oJ(parambdt.xpg)) {
          ((ad)localObject3).jJ(parambdt.xpg);
        }
        if (((ad)localObject3).dwC()) {
          ((ad)localObject3).hE((int)bo.aox());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((ad)localObject3).jT(paramString);
        }
        ((ad)localObject3).jn(aa.a(parambdt.xsT));
        ((ad)localObject3).jt(aa.a(parambdt.xsV));
        ((ad)localObject3).ju(aa.a(parambdt.xsU));
        ((ad)localObject3).jw(parambdt.wOV);
        ((ad)localObject3).jM(parambdt.woO);
        ((ad)localObject3).jN(parambdt.xtD);
        if (bo.ce(paramArrayOfByte)) {
          break label1333;
        }
        ((j)g.E(j.class)).YA().F(str1, paramArrayOfByte);
        ((ad)localObject3).hw(parambdt.DeleteFlag);
        if ((parambdt.xtz != null) && (parambdt.xtz.wpi != null))
        {
          ((ad)localObject3).jO(parambdt.xtz.wpi.wvz);
          ((ad)localObject3).jP(parambdt.xtz.wpi.wvA);
          ((ad)localObject3).jQ(parambdt.xtz.wpi.wvB);
        }
        if (t.oD(str1)) {
          ((ad)localObject3).NG();
        }
        if (((ad)localObject3).dwz()) {
          ((ad)localObject3).NJ();
        }
        ((ad)localObject3).jR(parambdt.dqY);
        ((ad)localObject3).hG(parambdt.ExtFlag);
        int j = (int)((com.tencent.mm.n.a)localObject3).euF;
        localObject1 = ((aq)localObject3).field_nickname;
        String str3 = ((ad)localObject3).Hu();
        int k = ((aq)localObject3).field_deleteFlag;
        int m = ((aq)localObject3).field_type;
        int n = parambdt.wNK;
        int i1 = parambdt.wNL;
        int i2 = ((aq)localObject3).dqH;
        int i3 = ((aq)localObject3).dqK;
        String str4 = parambdt.gwY;
        String str5 = parambdt.gwQ;
        String str6 = parambdt.gwR;
        int i4 = ((ad)localObject3).getSource();
        String str7 = ((aq)localObject3).field_contactLabelIds;
        if (parambdt.woO != null) {
          break label1374;
        }
        bool = true;
        if (parambdt.woO != null) {
          break label1380;
        }
        i = 0;
        label969:
        if (parambdt.woO != null) {
          break label1392;
        }
        paramString = "";
        label980:
        ab.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)", new Object[] { str1, str2, Integer.valueOf(j), localObject1, str3, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), str4, str5, str6, Integer.valueOf(i4), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        oCY.a((ad)localObject3, (ad)localObject2, parambdt, paramArrayOfByte, paramBoolean2);
        if (bo.isNullOrNil(str2)) {
          break label1403;
        }
        ((j)g.E(j.class)).YA().c(str2, (ad)localObject3);
        label1183:
        oCY.b((ad)localObject3, (ad)localObject2, parambdt, paramArrayOfByte, paramBoolean2);
        if ((((aq)localObject3).field_type & 0x800) == 0) {
          break label1427;
        }
        if ((localObject2 == null) || ((((aq)localObject2).field_type & 0x800) != (((aq)localObject3).field_type & 0x800))) {
          ((j)g.E(j.class)).YF().arN(((aq)localObject3).field_username);
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", new Object[] { str1, Boolean.valueOf(((ad)localObject3).NZ()) });
        AppMethodBeat.o(1022);
        return;
        if ((localObject2 == null) || ((int)((com.tencent.mm.n.a)localObject2).euF <= 0)) {
          break;
        }
        ((ad)localObject3).jv(((aq)localObject2).field_encryptUsername);
        break;
        label1321:
        l = (int)((com.tencent.mm.n.a)localObject2).euF;
        break label346;
        label1333:
        ((j)g.E(j.class)).YA().arB(str1);
        ab.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", new Object[] { str1 });
        break label740;
        label1374:
        bool = false;
        break label959;
        label1380:
        i = parambdt.woO.length();
        break label969;
        label1392:
        paramString = bo.aqg(parambdt.woO);
        break label980;
        label1403:
        ((j)g.E(j.class)).YA().X((ad)localObject3);
        break label1183;
        label1427:
        if ((localObject2 == null) || ((((aq)localObject2).field_type & 0x800) != (((aq)localObject3).field_type & 0x800))) {
          ((j)g.E(j.class)).YF().arO(((aq)localObject3).field_username);
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public final void a(ud paramud, byte[] paramArrayOfByte, boolean paramBoolean, u paramu)
  {
    AppMethodBeat.i(1021);
    switch (paramud.wMC)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(1021);
      return;
      paramud = (bdt)new bdt().parseFrom(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        a(paramud, "", paramArrayOfByte, false, paramBoolean);
        AppMethodBeat.o(1021);
        return;
        paramArrayOfByte = null;
      }
      paramud = (wr)new wr().parseFrom(paramArrayOfByte);
      paramArrayOfByte = aa.a(paramud.wOT);
      ab.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((j)g.E(j.class)).YF().arF(paramArrayOfByte);
      t.nW(paramArrayOfByte);
      v.b(4, paramud);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a
 * JD-Core Version:    0.7.0.1
 */