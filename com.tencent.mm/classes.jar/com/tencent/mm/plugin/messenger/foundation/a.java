package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.vending.b.b;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.x
{
  private static final a vVk;
  
  static
  {
    AppMethodBeat.i(116874);
    vVk = new a((byte)0);
    AppMethodBeat.o(116874);
  }
  
  public static b addContactAssembler(d paramd)
  {
    AppMethodBeat.i(116871);
    paramd = vVk.bu(paramd);
    AppMethodBeat.o(116871);
    return paramd;
  }
  
  public static void processModContact(caj paramcaj, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(211748);
    if (paramcaj == null)
    {
      ae.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      AppMethodBeat.o(211748);
      return;
    }
    if (!bu.isNullOrNil(paramcaj.GNt)) {}
    String str2;
    for (String str1 = paramcaj.GNt;; str1 = z.a(paramcaj.GuF))
    {
      str2 = bu.nullAsNil(paramcaj.HnT);
      if ((!bu.isNullOrNil(str1)) || (!bu.isNullOrNil(str2))) {
        break;
      }
      ae.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      AppMethodBeat.o(211748);
      return;
    }
    ae.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s modContactScene %s", new Object[] { paramcaj.GuF, paramcaj.HnW, paramcaj.HnX, Integer.valueOf(paramInt) });
    Object localObject1 = ((l)g.ab(l.class)).azF().aUM(str1);
    if ((localObject1 != null) && (str1.equals(((aw)localObject1).field_encryptUsername)))
    {
      ae.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      AppMethodBeat.o(211748);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((an)localObject1).fun();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new an(str1);
      }
      ((an)localObject3).setUsername(str1);
      ((an)localObject3).tl(paramcaj.jga);
      ((an)localObject3).setType(paramcaj.Gti & paramcaj.Gtj);
      if ((paramBoolean1) && (localObject2 != null) && ((int)((c)localObject2).ght > 0))
      {
        ae.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((aw)localObject2).field_type), Integer.valueOf(((aw)localObject3).field_type) });
        ((an)localObject3).setType(((aw)localObject3).field_type | ((aw)localObject2).field_type);
      }
      long l;
      label369:
      boolean bool;
      if (!bu.isNullOrNil(str2))
      {
        ((an)localObject3).tu(str2);
        if (localObject2 != null) {
          break label1418;
        }
        l = 0L;
        ((an)localObject3).ght = l;
        ((an)localObject3).to(z.a(paramcaj.Hed));
        ((an)localObject3).tp(z.a(paramcaj.GtY));
        ((an)localObject3).tq(z.a(paramcaj.GtZ));
        ((an)localObject3).kh(paramcaj.jfV);
        ((an)localObject3).kj(paramcaj.Gto);
        ((an)localObject3).tn(z.a(paramcaj.HnN));
        ((an)localObject3).kk(paramcaj.Gts);
        ((an)localObject3).kl(paramcaj.jfZ);
        ((an)localObject3).tL(RegionCodeDecoder.bg(paramcaj.jge, paramcaj.jfW, paramcaj.jfX));
        ((an)localObject3).tF(paramcaj.jfY);
        ((an)localObject3).kd(paramcaj.Hhu);
        ((an)localObject3).tK(paramcaj.Hhv);
        if ((paramcaj.ucK == 9) && (!bu.isNullOrNil(paramcaj.Hog)))
        {
          ae.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
          paramcaj.ucK = 14;
        }
        ((an)localObject3).setSource(paramcaj.ucK);
        ((an)localObject3).kc(paramcaj.Hhy);
        ((an)localObject3).tr(paramcaj.Hhx);
        ((an)localObject3).ty(paramcaj.Hog);
        ((an)localObject3).qF(paramcaj.eRA);
        ae.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s ChatroomBusinessType:%s", new Object[] { ((aw)localObject3).field_username, bu.aSM(((aw)localObject3).field_nickname), ((aw)localObject3).field_sourceExtInfo, Integer.valueOf(paramcaj.ucK), Long.valueOf(paramcaj.eRA) });
        if (com.tencent.mm.model.x.Bf(paramcaj.Hhw)) {
          ((an)localObject3).tJ(paramcaj.Hhw);
        }
        if (((an)localObject3).fuk()) {
          ((an)localObject3).km((int)bu.aRi());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((an)localObject3).tT(paramString);
        }
        ae.i("MicroMsg.ContactSyncExtension", "remark (%s -> %s)", new Object[] { ((aw)localObject3).field_conRemark, z.a(paramcaj.Hnt) });
        ((an)localObject3).tm(z.a(paramcaj.Hnt));
        ((an)localObject3).ts(z.a(paramcaj.Hnv));
        ((an)localObject3).tt(z.a(paramcaj.Hnu));
        ((an)localObject3).tv(paramcaj.GuH);
        ((an)localObject3).tM(paramcaj.FNF);
        ((an)localObject3).tN(paramcaj.Hoc);
        if (bu.cF(paramArrayOfByte)) {
          break label1430;
        }
        ((l)g.ab(l.class)).azF().B(str1, paramArrayOfByte);
        label815:
        ((an)localObject3).kf(paramcaj.DeleteFlag);
        if ((paramcaj.HnY != null) && (paramcaj.HnY.FNY != null))
        {
          ((an)localObject3).tO(paramcaj.HnY.FNY.FVV);
          ((an)localObject3).tP(paramcaj.HnY.FNY.FVW);
          ((an)localObject3).tQ(paramcaj.HnY.FNY.FVX);
        }
        if (com.tencent.mm.model.x.AZ(str1)) {
          ((an)localObject3).adb();
        }
        if (((an)localObject3).fug()) {
          ((an)localObject3).adf();
        }
        ((an)localObject3).tR(paramcaj.eRt);
        ((an)localObject3).ko(paramcaj.ExtFlag);
        ((an)localObject3).setFromType(paramInt);
        int i = (int)((c)localObject3).ght;
        localObject1 = ((aw)localObject3).field_nickname;
        String str3 = ((an)localObject3).VM();
        int j = ((aw)localObject3).field_deleteFlag;
        int k = ((aw)localObject3).field_type;
        int m = paramcaj.Gti;
        int n = paramcaj.Gtj;
        int i1 = ((aw)localObject3).eRa;
        int i2 = ((aw)localObject3).eRd;
        String str4 = paramcaj.jge;
        String str5 = paramcaj.jfW;
        String str6 = paramcaj.jfX;
        int i3 = ((an)localObject3).getSource();
        String str7 = ((aw)localObject3).field_contactLabelIds;
        if (paramcaj.FNF != null) {
          break label1471;
        }
        bool = true;
        label1041:
        if (paramcaj.FNF != null) {
          break label1477;
        }
        paramInt = 0;
        label1051:
        if (paramcaj.FNF != null) {
          break label1489;
        }
        paramString = "";
        label1062:
        ae.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s) verifyFlag:%d", new Object[] { str1, str2, Integer.valueOf(i), localObject1, str3, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str4, str5, str6, Integer.valueOf(i3), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString, Integer.valueOf(paramcaj.Hhu) });
        vVk.a((an)localObject3, (an)localObject2, paramcaj, paramArrayOfByte, paramBoolean2);
        com.tencent.mm.contact.a.g((an)localObject3);
        if (bu.isNullOrNil(str2)) {
          break label1500;
        }
        ((l)g.ab(l.class)).azF().d(str2, (an)localObject3);
        label1281:
        vVk.b((an)localObject3, (an)localObject2, paramcaj, paramArrayOfByte, paramBoolean2);
        if ((((aw)localObject3).field_type & 0x800) == 0) {
          break label1524;
        }
        if ((localObject2 == null) || ((((aw)localObject2).field_type & 0x800) != (((aw)localObject3).field_type & 0x800))) {
          ((l)g.ab(l.class)).azL().aVg(((aw)localObject3).field_username);
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", new Object[] { str1, Boolean.valueOf(((an)localObject3).ady()) });
        AppMethodBeat.o(211748);
        return;
        if ((localObject2 == null) || ((int)((c)localObject2).ght <= 0)) {
          break;
        }
        ((an)localObject3).tu(((aw)localObject2).field_encryptUsername);
        break;
        label1418:
        l = (int)((c)localObject2).ght;
        break label369;
        label1430:
        ((l)g.ab(l.class)).azF().aUR(str1);
        ae.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", new Object[] { str1 });
        break label815;
        label1471:
        bool = false;
        break label1041;
        label1477:
        paramInt = paramcaj.FNF.length();
        break label1051;
        label1489:
        paramString = bu.aSM(paramcaj.FNF);
        break label1062;
        label1500:
        ((l)g.ab(l.class)).azF().am((an)localObject3);
        break label1281;
        label1524:
        if ((localObject2 == null) || ((((aw)localObject2).field_type & 0x800) != (((aw)localObject3).field_type & 0x800))) {
          ((l)g.ab(l.class)).azL().aVh(((aw)localObject3).field_username);
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static void removeContactAssembler(d paramd)
  {
    AppMethodBeat.i(169106);
    vVk.remove(paramd);
    AppMethodBeat.o(169106);
  }
  
  public final void a(zx paramzx, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(116872);
    switch (paramzx.Gru)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116872);
      return;
      paramzx = (caj)new caj().parseFrom(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        processModContact(paramzx, "", paramArrayOfByte, false, paramBoolean, 0);
        AppMethodBeat.o(116872);
        return;
        paramArrayOfByte = null;
      }
      paramzx = (ade)new ade().parseFrom(paramArrayOfByte);
      paramArrayOfByte = z.a(paramzx.GuF);
      ae.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((l)g.ab(l.class)).azL().aUY(paramArrayOfByte);
      com.tencent.mm.model.x.Aq(paramArrayOfByte);
      ab.b(4, paramzx);
    }
  }
  
  static final class a
    extends com.tencent.mm.cm.a<d>
    implements d
  {
    public final void a(final an paraman1, final an paraman2, final caj paramcaj, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116869);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(116869);
    }
    
    public final void b(final an paraman1, final an paraman2, final caj paramcaj, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116870);
      a(new com.tencent.mm.cm.a.a() {});
      AppMethodBeat.o(116870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a
 * JD-Core Version:    0.7.0.1
 */