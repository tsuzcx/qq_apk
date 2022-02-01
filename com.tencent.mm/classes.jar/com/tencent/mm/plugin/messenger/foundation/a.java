package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;

public final class a
  implements u
{
  private static final a uGk;
  
  static
  {
    AppMethodBeat.i(116874);
    uGk = new a((byte)0);
    AppMethodBeat.o(116874);
  }
  
  public static com.tencent.mm.vending.b.b addContactAssembler(c paramc)
  {
    AppMethodBeat.i(116871);
    paramc = uGk.bs(paramc);
    AppMethodBeat.o(116871);
    return paramc;
  }
  
  public static void processModContact(bva parambva, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(116873);
    if (parambva == null)
    {
      ac.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      AppMethodBeat.o(116873);
      return;
    }
    String str1 = z.a(parambva.EuE);
    String str2 = bs.nullAsNil(parambva.FkK);
    if ((bs.isNullOrNil(str1)) && (bs.isNullOrNil(str2)))
    {
      ac.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      AppMethodBeat.o(116873);
      return;
    }
    ac.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s", new Object[] { parambva.EuE, parambva.FkN, parambva.FkO });
    Object localObject1 = ((k)g.ab(k.class)).awB().aNu(str1);
    if ((localObject1 != null) && (str1.equals(((av)localObject1).field_encryptUsername)))
    {
      ac.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      AppMethodBeat.o(116873);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((ai)localObject1).fak();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ai(str1);
      }
      ((ai)localObject3).setUsername(str1);
      ((ai)localObject3).qg(parambva.iJY);
      ((ai)localObject3).setType(parambva.Etk & parambva.Etl);
      if ((paramBoolean1) && (localObject2 != null) && ((int)((com.tencent.mm.n.b)localObject2).fLJ > 0))
      {
        ac.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((av)localObject2).field_type), Integer.valueOf(((av)localObject3).field_type) });
        ((ai)localObject3).setType(((av)localObject3).field_type | ((av)localObject2).field_type);
      }
      long l;
      label342:
      boolean bool;
      label788:
      label1007:
      int i;
      if (!bs.isNullOrNil(str2))
      {
        ((ai)localObject3).qp(str2);
        if (localObject2 != null) {
          break label1373;
        }
        l = 0L;
        ((ai)localObject3).fLJ = l;
        ((ai)localObject3).qj(z.a(parambva.Fbd));
        ((ai)localObject3).qk(z.a(parambva.EtY));
        ((ai)localObject3).ql(z.a(parambva.EtZ));
        ((ai)localObject3).jH(parambva.iJT);
        ((ai)localObject3).jJ(parambva.Etq);
        ((ai)localObject3).qi(z.a(parambva.FkE));
        ((ai)localObject3).jK(parambva.Etu);
        ((ai)localObject3).jL(parambva.iJX);
        ((ai)localObject3).qG(RegionCodeDecoder.aW(parambva.iKc, parambva.iJU, parambva.iJV));
        ((ai)localObject3).qA(parambva.iJW);
        ((ai)localObject3).jD(parambva.Feq);
        ((ai)localObject3).qF(parambva.Fer);
        if ((parambva.sVo == 9) && (!bs.isNullOrNil(parambva.FkX)))
        {
          ac.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
          parambva.sVo = 14;
        }
        ((ai)localObject3).setSource(parambva.sVo);
        ((ai)localObject3).jC(parambva.Feu);
        ((ai)localObject3).qm(parambva.Fet);
        ((ai)localObject3).qt(parambva.FkX);
        ((ai)localObject3).os(parambva.eyr);
        ac.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s ChatroomBusinessType:%s", new Object[] { ((av)localObject3).field_username, bs.aLJ(((av)localObject3).field_nickname), ((av)localObject3).field_sourceExtInfo, Integer.valueOf(parambva.sVo), Long.valueOf(parambva.eyr) });
        if (w.xx(parambva.Fes)) {
          ((ai)localObject3).qE(parambva.Fes);
        }
        if (((ai)localObject3).fah()) {
          ((ai)localObject3).jM((int)bs.aNx());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((ai)localObject3).qO(paramString);
        }
        ac.i("MicroMsg.ContactSyncExtension", "remark (%s -> %s)", new Object[] { ((av)localObject3).field_conRemark, z.a(parambva.Fkk) });
        ((ai)localObject3).qh(z.a(parambva.Fkk));
        ((ai)localObject3).qn(z.a(parambva.Fkm));
        ((ai)localObject3).qo(z.a(parambva.Fkl));
        ((ai)localObject3).qq(parambva.EuG);
        ((ai)localObject3).qH(parambva.DPS);
        ((ai)localObject3).qI(parambva.FkT);
        if (bs.cv(paramArrayOfByte)) {
          break label1385;
        }
        ((k)g.ab(k.class)).awB().A(str1, paramArrayOfByte);
        ((ai)localObject3).jF(parambva.DeleteFlag);
        if ((parambva.FkP != null) && (parambva.FkP.DQl != null))
        {
          ((ai)localObject3).qJ(parambva.FkP.DQl.DYe);
          ((ai)localObject3).qK(parambva.FkP.DQl.DYf);
          ((ai)localObject3).qL(parambva.FkP.DQl.DYg);
        }
        if (w.xr(str1)) {
          ((ai)localObject3).aao();
        }
        if (((ai)localObject3).fad()) {
          ((ai)localObject3).aar();
        }
        ((ai)localObject3).qM(parambva.eyk);
        ((ai)localObject3).jO(parambva.ExtFlag);
        int j = (int)((com.tencent.mm.n.b)localObject3).fLJ;
        localObject1 = ((av)localObject3).field_nickname;
        String str3 = ((ai)localObject3).Tp();
        int k = ((av)localObject3).field_deleteFlag;
        int m = ((av)localObject3).field_type;
        int n = parambva.Etk;
        int i1 = parambva.Etl;
        int i2 = ((av)localObject3).exQ;
        int i3 = ((av)localObject3).exT;
        String str4 = parambva.iKc;
        String str5 = parambva.iJU;
        String str6 = parambva.iJV;
        int i4 = ((ai)localObject3).getSource();
        String str7 = ((av)localObject3).field_contactLabelIds;
        if (parambva.DPS != null) {
          break label1426;
        }
        bool = true;
        if (parambva.DPS != null) {
          break label1432;
        }
        i = 0;
        label1017:
        if (parambva.DPS != null) {
          break label1444;
        }
        paramString = "";
        label1028:
        ac.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s)", new Object[] { str1, str2, Integer.valueOf(j), localObject1, str3, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), str4, str5, str6, Integer.valueOf(i4), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(i), paramString });
        uGk.a((ai)localObject3, (ai)localObject2, parambva, paramArrayOfByte, paramBoolean2);
        com.tencent.mm.n.a.g((ai)localObject3);
        if (bs.isNullOrNil(str2)) {
          break label1455;
        }
        ((k)g.ab(k.class)).awB().d(str2, (ai)localObject3);
        label1236:
        uGk.b((ai)localObject3, (ai)localObject2, parambva, paramArrayOfByte, paramBoolean2);
        if ((((av)localObject3).field_type & 0x800) == 0) {
          break label1479;
        }
        if ((localObject2 == null) || ((((av)localObject2).field_type & 0x800) != (((av)localObject3).field_type & 0x800))) {
          ((k)g.ab(k.class)).awG().aNO(((av)localObject3).field_username);
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", new Object[] { str1, Boolean.valueOf(((ai)localObject3).aaK()) });
        AppMethodBeat.o(116873);
        return;
        if ((localObject2 == null) || ((int)((com.tencent.mm.n.b)localObject2).fLJ <= 0)) {
          break;
        }
        ((ai)localObject3).qp(((av)localObject2).field_encryptUsername);
        break;
        label1373:
        l = (int)((com.tencent.mm.n.b)localObject2).fLJ;
        break label342;
        label1385:
        ((k)g.ab(k.class)).awB().aNz(str1);
        ac.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", new Object[] { str1 });
        break label788;
        label1426:
        bool = false;
        break label1007;
        label1432:
        i = parambva.DPS.length();
        break label1017;
        label1444:
        paramString = bs.aLJ(parambva.DPS);
        break label1028;
        label1455:
        ((k)g.ab(k.class)).awB().af((ai)localObject3);
        break label1236;
        label1479:
        if ((localObject2 == null) || ((((av)localObject2).field_type & 0x800) != (((av)localObject3).field_type & 0x800))) {
          ((k)g.ab(k.class)).awG().aNP(((av)localObject3).field_username);
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static void removeContactAssembler(c paramc)
  {
    AppMethodBeat.i(169106);
    uGk.remove(paramc);
    AppMethodBeat.o(169106);
  }
  
  public final void a(xv paramxv, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(116872);
    switch (paramxv.ErL)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116872);
      return;
      paramxv = (bva)new bva().parseFrom(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        processModContact(paramxv, "", paramArrayOfByte, false, paramBoolean);
        AppMethodBeat.o(116872);
        return;
        paramArrayOfByte = null;
      }
      paramxv = (aav)new aav().parseFrom(paramArrayOfByte);
      paramArrayOfByte = z.a(paramxv.EuE);
      ac.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((k)g.ab(k.class)).awG().aNG(paramArrayOfByte);
      w.wJ(paramArrayOfByte);
      y.b(4, paramxv);
    }
  }
  
  static final class a
    extends com.tencent.mm.cn.a<c>
    implements c
  {
    public final void a(final ai paramai1, final ai paramai2, final bva parambva, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116869);
      a(new com.tencent.mm.cn.a.a() {});
      AppMethodBeat.o(116869);
    }
    
    public final void b(final ai paramai1, final ai paramai2, final bva parambva, final byte[] paramArrayOfByte, final boolean paramBoolean)
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