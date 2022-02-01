package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;

public final class a
  implements u
{
  private static final a txM;
  
  static
  {
    AppMethodBeat.i(116874);
    txM = new a((byte)0);
    AppMethodBeat.o(116874);
  }
  
  public static com.tencent.mm.vending.b.b addContactAssembler(c paramc)
  {
    AppMethodBeat.i(116871);
    paramc = txM.bv(paramc);
    AppMethodBeat.o(116871);
    return paramc;
  }
  
  public static void processModContact(bqj parambqj, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116873);
    if (parambqj == null)
    {
      ad.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      AppMethodBeat.o(116873);
      return;
    }
    String str1 = z.a(parambqj.Dby);
    String str2 = bt.nullAsNil(parambqj.DOt);
    if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)))
    {
      ad.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      AppMethodBeat.o(116873);
      return;
    }
    ad.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", new Object[] { parambqj.Dby, parambqj.DOw, parambqj.DOx });
    Object localObject1 = ((k)g.ab(k.class)).apM().aHZ(str1);
    if ((localObject1 != null) && (str1.equals(((au)localObject1).field_encryptUsername)))
    {
      ad.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      AppMethodBeat.o(116873);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((af)localObject1).eKI();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new af(str1);
      }
      ((af)localObject3).setUsername(str1);
      ((af)localObject3).na(parambqj.ijR);
      ((af)localObject3).setType(parambqj.Dan & parambqj.Dao);
      if ((paramBoolean1) && (localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fId > 0))
      {
        ad.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((au)localObject2).field_type), Integer.valueOf(((au)localObject3).field_type) });
        ((af)localObject3).setType(((au)localObject3).field_type | ((au)localObject2).field_type);
      }
      long l;
      label342:
      boolean bool;
      label788:
      label1007:
      int i;
      if (!bt.isNullOrNil(str2))
      {
        ((af)localObject3).nj(str2);
        if (localObject2 != null) {
          break label1373;
        }
        l = 0L;
        ((af)localObject3).fId = l;
        ((af)localObject3).nd(z.a(parambqj.DFJ));
        ((af)localObject3).ne(z.a(parambqj.Dbb));
        ((af)localObject3).nf(z.a(parambqj.Dbc));
        ((af)localObject3).jJ(parambqj.ijM);
        ((af)localObject3).jL(parambqj.Dat);
        ((af)localObject3).nc(z.a(parambqj.DOn));
        ((af)localObject3).jM(parambqj.Dax);
        ((af)localObject3).jN(parambqj.ijQ);
        ((af)localObject3).nA(RegionCodeDecoder.aT(parambqj.ijV, parambqj.ijN, parambqj.ijO));
        ((af)localObject3).nu(parambqj.ijP);
        ((af)localObject3).jF(parambqj.DIV);
        ((af)localObject3).nz(parambqj.DIW);
        if ((parambqj.rNz == 9) && (!bt.isNullOrNil(parambqj.DOG)))
        {
          ad.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
          parambqj.rNz = 14;
        }
        ((af)localObject3).setSource(parambqj.rNz);
        ((af)localObject3).jE(parambqj.DIZ);
        ((af)localObject3).ng(parambqj.DIY);
        ((af)localObject3).nn(parambqj.DOG);
        ((af)localObject3).kQ(parambqj.evU);
        ad.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s ChatroomBusinessType:%s", new Object[] { ((au)localObject3).field_username, bt.aGs(((au)localObject3).field_nickname), ((au)localObject3).field_sourceExtInfo, Integer.valueOf(parambqj.rNz), Long.valueOf(parambqj.evU) });
        if (w.tu(parambqj.DIX)) {
          ((af)localObject3).ny(parambqj.DIX);
        }
        if (((af)localObject3).eKF()) {
          ((af)localObject3).jO((int)bt.aGK());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((af)localObject3).nI(paramString);
        }
        ad.i("MicroMsg.ContactSyncExtension", "remark (%s -> %s)", new Object[] { ((au)localObject3).field_conRemark, z.a(parambqj.DNT) });
        ((af)localObject3).nb(z.a(parambqj.DNT));
        ((af)localObject3).nh(z.a(parambqj.DNV));
        ((af)localObject3).ni(z.a(parambqj.DNU));
        ((af)localObject3).nk(parambqj.DbA);
        ((af)localObject3).nB(parambqj.Cxw);
        ((af)localObject3).nC(parambqj.DOC);
        if (bt.cw(paramArrayOfByte)) {
          break label1385;
        }
        ((k)g.ab(k.class)).apM().A(str1, paramArrayOfByte);
        ((af)localObject3).jH(parambqj.DeleteFlag);
        if ((parambqj.DOy != null) && (parambqj.DOy.CxP != null))
        {
          ((af)localObject3).nD(parambqj.DOy.CxP.CFE);
          ((af)localObject3).nE(parambqj.DOy.CxP.CFF);
          ((af)localObject3).nF(parambqj.DOy.CxP.CFG);
        }
        if (w.to(str1)) {
          ((af)localObject3).Zt();
        }
        if (((af)localObject3).eKB()) {
          ((af)localObject3).Zw();
        }
        ((af)localObject3).nG(parambqj.evN);
        ((af)localObject3).jQ(parambqj.ExtFlag);
        int j = (int)((com.tencent.mm.n.b)localObject3).fId;
        localObject1 = ((au)localObject3).field_nickname;
        String str3 = ((af)localObject3).Sw();
        int k = ((au)localObject3).field_deleteFlag;
        int m = ((au)localObject3).field_type;
        int n = parambqj.Dan;
        int i1 = parambqj.Dao;
        int i2 = ((au)localObject3).evu;
        int i3 = ((au)localObject3).evx;
        String str4 = parambqj.ijV;
        String str5 = parambqj.ijN;
        String str6 = parambqj.ijO;
        int i4 = ((af)localObject3).getSource();
        String str7 = ((au)localObject3).field_contactLabelIds;
        if (parambqj.Cxw != null) {
          break label1426;
        }
        bool = true;
        if (parambqj.Cxw != null) {
          break label1432;
        }
        i = 0;
        label1017:
        if (parambqj.Cxw != null) {
          break label1444;
        }
        paramString = "";
        label1028:
        ad.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)", new Object[] { str1, str2, Integer.valueOf(j), localObject1, str3, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), str4, str5, str6, Integer.valueOf(i4), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        txM.a((af)localObject3, (af)localObject2, parambqj, paramArrayOfByte, paramBoolean2);
        com.tencent.mm.n.a.g((af)localObject3);
        if (bt.isNullOrNil(str2)) {
          break label1455;
        }
        ((k)g.ab(k.class)).apM().d(str2, (af)localObject3);
        label1236:
        txM.b((af)localObject3, (af)localObject2, parambqj, paramArrayOfByte, paramBoolean2);
        if ((((au)localObject3).field_type & 0x800) == 0) {
          break label1479;
        }
        if ((localObject2 == null) || ((((au)localObject2).field_type & 0x800) != (((au)localObject3).field_type & 0x800))) {
          ((k)g.ab(k.class)).apR().aIt(((au)localObject3).field_username);
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", new Object[] { str1, Boolean.valueOf(((af)localObject3).ZP()) });
        AppMethodBeat.o(116873);
        return;
        if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fId <= 0)) {
          break;
        }
        ((af)localObject3).nj(((au)localObject2).field_encryptUsername);
        break;
        label1373:
        l = (int)((com.tencent.mm.n.b)localObject2).fId;
        break label342;
        label1385:
        ((k)g.ab(k.class)).apM().aIe(str1);
        ad.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", new Object[] { str1 });
        break label788;
        label1426:
        bool = false;
        break label1007;
        label1432:
        i = parambqj.Cxw.length();
        break label1017;
        label1444:
        paramString = bt.aGs(parambqj.Cxw);
        break label1028;
        label1455:
        ((k)g.ab(k.class)).apM().ae((af)localObject3);
        break label1236;
        label1479:
        if ((localObject2 == null) || ((((au)localObject2).field_type & 0x800) != (((au)localObject3).field_type & 0x800))) {
          ((k)g.ab(k.class)).apR().aIu(((au)localObject3).field_username);
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static void removeContactAssembler(c paramc)
  {
    AppMethodBeat.i(169106);
    txM.remove(paramc);
    AppMethodBeat.o(169106);
  }
  
  public final void a(xd paramxd, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(116872);
    switch (paramxd.CYY)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116872);
      return;
      paramxd = (bqj)new bqj().parseFrom(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        processModContact(paramxd, "", paramArrayOfByte, false, paramBoolean);
        AppMethodBeat.o(116872);
        return;
        paramArrayOfByte = null;
      }
      paramxd = (zw)new zw().parseFrom(paramArrayOfByte);
      paramArrayOfByte = z.a(paramxd.Dby);
      ad.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((k)g.ab(k.class)).apR().aIl(paramArrayOfByte);
      w.sG(paramArrayOfByte);
      y.b(4, paramxd);
    }
  }
  
  static final class a
    extends com.tencent.mm.co.a<c>
    implements c
  {
    public final void a(final af paramaf1, final af paramaf2, final bqj parambqj, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116869);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(116869);
    }
    
    public final void b(final af paramaf1, final af paramaf2, final bqj parambqj, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116870);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(116870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a
 * JD-Core Version:    0.7.0.1
 */