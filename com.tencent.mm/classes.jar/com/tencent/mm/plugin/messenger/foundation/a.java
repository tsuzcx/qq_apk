package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.w
{
  private static final a vJg;
  
  static
  {
    AppMethodBeat.i(116874);
    vJg = new a((byte)0);
    AppMethodBeat.o(116874);
  }
  
  public static com.tencent.mm.vending.b.b addContactAssembler(d paramd)
  {
    AppMethodBeat.i(116871);
    paramd = vJg.bu(paramd);
    AppMethodBeat.o(116871);
    return paramd;
  }
  
  public static void processModContact(bzp parambzp, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(217579);
    if (parambzp == null)
    {
      ad.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      AppMethodBeat.o(217579);
      return;
    }
    if (!bt.isNullOrNil(parambzp.GtU)) {}
    String str2;
    for (String str1 = parambzp.GtU;; str1 = com.tencent.mm.platformtools.z.a(parambzp.GbY))
    {
      str2 = bt.nullAsNil(parambzp.GUs);
      if ((!bt.isNullOrNil(str1)) || (!bt.isNullOrNil(str2))) {
        break;
      }
      ad.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      AppMethodBeat.o(217579);
      return;
    }
    ad.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s modContactScene %s", new Object[] { parambzp.GbY, parambzp.GUv, parambzp.GUw, Integer.valueOf(paramInt) });
    Object localObject1 = ((l)g.ab(l.class)).azp().aTl(str1);
    if ((localObject1 != null) && (str1.equals(((aw)localObject1).field_encryptUsername)))
    {
      ad.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      AppMethodBeat.o(217579);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((am)localObject1).fqn();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new am(str1);
      }
      ((am)localObject3).setUsername(str1);
      ((am)localObject3).sQ(parambzp.jdh);
      ((am)localObject3).setType(parambzp.GaB & parambzp.GaC);
      if ((paramBoolean1) && (localObject2 != null) && ((int)((com.tencent.mm.o.b)localObject2).gfj > 0))
      {
        ad.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((aw)localObject2).field_type), Integer.valueOf(((aw)localObject3).field_type) });
        ((am)localObject3).setType(((aw)localObject3).field_type | ((aw)localObject2).field_type);
      }
      long l;
      label369:
      boolean bool;
      if (!bt.isNullOrNil(str2))
      {
        ((am)localObject3).sZ(str2);
        if (localObject2 != null) {
          break label1407;
        }
        l = 0L;
        ((am)localObject3).gfj = l;
        ((am)localObject3).sT(com.tencent.mm.platformtools.z.a(parambzp.GKC));
        ((am)localObject3).sU(com.tencent.mm.platformtools.z.a(parambzp.Gbr));
        ((am)localObject3).sV(com.tencent.mm.platformtools.z.a(parambzp.Gbs));
        ((am)localObject3).kf(parambzp.jdc);
        ((am)localObject3).kh(parambzp.GaH);
        ((am)localObject3).sS(com.tencent.mm.platformtools.z.a(parambzp.GUm));
        ((am)localObject3).ki(parambzp.GaL);
        ((am)localObject3).kj(parambzp.jdg);
        ((am)localObject3).tq(RegionCodeDecoder.bf(parambzp.jdl, parambzp.jdd, parambzp.jde));
        ((am)localObject3).tk(parambzp.jdf);
        ((am)localObject3).kb(parambzp.GNU);
        ((am)localObject3).tp(parambzp.GNV);
        if ((parambzp.tRT == 9) && (!bt.isNullOrNil(parambzp.GUF)))
        {
          ad.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
          parambzp.tRT = 14;
        }
        ((am)localObject3).setSource(parambzp.tRT);
        ((am)localObject3).ka(parambzp.GNY);
        ((am)localObject3).sW(parambzp.GNX);
        ((am)localObject3).td(parambzp.GUF);
        ((am)localObject3).qs(parambzp.ePP);
        ad.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s ChatroomBusinessType:%s", new Object[] { ((aw)localObject3).field_username, bt.aRp(((aw)localObject3).field_nickname), ((aw)localObject3).field_sourceExtInfo, Integer.valueOf(parambzp.tRT), Long.valueOf(parambzp.ePP) });
        if (com.tencent.mm.model.w.Av(parambzp.GNW)) {
          ((am)localObject3).to(parambzp.GNW);
        }
        if (((am)localObject3).fqk()) {
          ((am)localObject3).kk((int)bt.aQJ());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((am)localObject3).ty(paramString);
        }
        ad.i("MicroMsg.ContactSyncExtension", "remark (%s -> %s)", new Object[] { ((aw)localObject3).field_conRemark, com.tencent.mm.platformtools.z.a(parambzp.GTS) });
        ((am)localObject3).sR(com.tencent.mm.platformtools.z.a(parambzp.GTS));
        ((am)localObject3).sX(com.tencent.mm.platformtools.z.a(parambzp.GTU));
        ((am)localObject3).sY(com.tencent.mm.platformtools.z.a(parambzp.GTT));
        ((am)localObject3).ta(parambzp.Gca);
        ((am)localObject3).tr(parambzp.Fvh);
        ((am)localObject3).ts(parambzp.GUB);
        if (bt.cC(paramArrayOfByte)) {
          break label1419;
        }
        ((l)g.ab(l.class)).azp().B(str1, paramArrayOfByte);
        label815:
        ((am)localObject3).kd(parambzp.DeleteFlag);
        if ((parambzp.GUx != null) && (parambzp.GUx.FvA != null))
        {
          ((am)localObject3).tt(parambzp.GUx.FvA.FDA);
          ((am)localObject3).tu(parambzp.GUx.FvA.FDB);
          ((am)localObject3).tv(parambzp.GUx.FvA.FDC);
        }
        if (com.tencent.mm.model.w.Ap(str1)) {
          ((am)localObject3).acQ();
        }
        if (((am)localObject3).fqg()) {
          ((am)localObject3).acT();
        }
        ((am)localObject3).tw(parambzp.ePI);
        ((am)localObject3).km(parambzp.ExtFlag);
        ((am)localObject3).setFromType(paramInt);
        int i = (int)((com.tencent.mm.o.b)localObject3).gfj;
        localObject1 = ((aw)localObject3).field_nickname;
        String str3 = ((am)localObject3).VE();
        int j = ((aw)localObject3).field_deleteFlag;
        int k = ((aw)localObject3).field_type;
        int m = parambzp.GaB;
        int n = parambzp.GaC;
        int i1 = ((aw)localObject3).ePp;
        int i2 = ((aw)localObject3).ePs;
        String str4 = parambzp.jdl;
        String str5 = parambzp.jdd;
        String str6 = parambzp.jde;
        int i3 = ((am)localObject3).getSource();
        String str7 = ((aw)localObject3).field_contactLabelIds;
        if (parambzp.Fvh != null) {
          break label1460;
        }
        bool = true;
        label1041:
        if (parambzp.Fvh != null) {
          break label1466;
        }
        paramInt = 0;
        label1051:
        if (parambzp.Fvh != null) {
          break label1478;
        }
        paramString = "";
        label1062:
        ad.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)", new Object[] { str1, str2, Integer.valueOf(i), localObject1, str3, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str4, str5, str6, Integer.valueOf(i3), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString });
        vJg.a((am)localObject3, (am)localObject2, parambzp, paramArrayOfByte, paramBoolean2);
        com.tencent.mm.o.a.g((am)localObject3);
        if (bt.isNullOrNil(str2)) {
          break label1489;
        }
        ((l)g.ab(l.class)).azp().d(str2, (am)localObject3);
        label1270:
        vJg.b((am)localObject3, (am)localObject2, parambzp, paramArrayOfByte, paramBoolean2);
        if ((((aw)localObject3).field_type & 0x800) == 0) {
          break label1513;
        }
        if ((localObject2 == null) || ((((aw)localObject2).field_type & 0x800) != (((aw)localObject3).field_type & 0x800))) {
          ((l)g.ab(l.class)).azv().aTF(((aw)localObject3).field_username);
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", new Object[] { str1, Boolean.valueOf(((am)localObject3).adn()) });
        AppMethodBeat.o(217579);
        return;
        if ((localObject2 == null) || ((int)((com.tencent.mm.o.b)localObject2).gfj <= 0)) {
          break;
        }
        ((am)localObject3).sZ(((aw)localObject2).field_encryptUsername);
        break;
        label1407:
        l = (int)((com.tencent.mm.o.b)localObject2).gfj;
        break label369;
        label1419:
        ((l)g.ab(l.class)).azp().aTq(str1);
        ad.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", new Object[] { str1 });
        break label815;
        label1460:
        bool = false;
        break label1041;
        label1466:
        paramInt = parambzp.Fvh.length();
        break label1051;
        label1478:
        paramString = bt.aRp(parambzp.Fvh);
        break label1062;
        label1489:
        ((l)g.ab(l.class)).azp().af((am)localObject3);
        break label1270;
        label1513:
        if ((localObject2 == null) || ((((aw)localObject2).field_type & 0x800) != (((aw)localObject3).field_type & 0x800))) {
          ((l)g.ab(l.class)).azv().aTG(((aw)localObject3).field_username);
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static void removeContactAssembler(d paramd)
  {
    AppMethodBeat.i(169106);
    vJg.remove(paramd);
    AppMethodBeat.o(169106);
  }
  
  public final void a(zu paramzu, byte[] paramArrayOfByte, boolean paramBoolean, com.tencent.mm.plugin.messenger.foundation.a.z paramz)
  {
    AppMethodBeat.i(116872);
    switch (paramzu.FYU)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116872);
      return;
      paramzu = (bzp)new bzp().parseFrom(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        processModContact(paramzu, "", paramArrayOfByte, false, paramBoolean, 0);
        AppMethodBeat.o(116872);
        return;
        paramArrayOfByte = null;
      }
      paramzu = (acv)new acv().parseFrom(paramArrayOfByte);
      paramArrayOfByte = com.tencent.mm.platformtools.z.a(paramzu.GbY);
      ad.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((l)g.ab(l.class)).azv().aTx(paramArrayOfByte);
      com.tencent.mm.model.w.zG(paramArrayOfByte);
      aa.b(4, paramzu);
    }
  }
  
  static final class a
    extends com.tencent.mm.cn.a<d>
    implements d
  {
    public final void a(final am paramam1, final am paramam2, final bzp parambzp, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116869);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(116869);
    }
    
    public final void b(final am paramam1, final am paramam2, final bzp parambzp, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116870);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(116870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a
 * JD-Core Version:    0.7.0.1
 */