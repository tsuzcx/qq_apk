package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.ab
{
  private static final b.a EUN;
  
  static
  {
    AppMethodBeat.i(116874);
    EUN = new b.a((byte)0);
    AppMethodBeat.o(116874);
  }
  
  public static com.tencent.mm.vending.b.b addContactAssembler(f paramf)
  {
    AppMethodBeat.i(116871);
    paramf = EUN.add(paramf);
    AppMethodBeat.o(116871);
    return paramf;
  }
  
  public static void processModContact(cyb paramcyb, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(187862);
    if (paramcyb == null)
    {
      Log.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      AppMethodBeat.o(187862);
      return;
    }
    if (!Util.isNullOrNil(paramcyb.Tad)) {}
    String str2;
    for (String str1 = paramcyb.Tad;; str1 = z.a(paramcyb.SrH))
    {
      str2 = Util.nullAsNil(paramcyb.TGl);
      if ((!Util.isNullOrNil(str1)) || (!Util.isNullOrNil(str2))) {
        break;
      }
      Log.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      AppMethodBeat.o(187862);
      return;
    }
    Log.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s modContactScene %s ", new Object[] { paramcyb.SrH, paramcyb.TGo, paramcyb.TGp, Integer.valueOf(paramInt) });
    Object localObject1 = ((n)h.ae(n.class)).bbL().bwj(str1);
    if (localObject1 != null) {
      Log.i("MicroMsg.ContactSyncExtension", "oldContact.getEncryptUsername() :%s %s", new Object[] { ((ax)localObject1).field_encryptUsername, Integer.valueOf((int)((d)localObject1).jxt) });
    }
    while ((!com.tencent.mm.model.ab.PO(str1)) && (localObject1 != null) && (str1.equals(((ax)localObject1).field_encryptUsername)))
    {
      Log.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      AppMethodBeat.o(187862);
      return;
      Log.i("MicroMsg.ContactSyncExtension", "oldContact is null ");
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((as)localObject1).hyf();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new as(str1);
      }
      ((as)localObject3).setUsername(str1);
      ((as)localObject3).Iq(paramcyb.mVD);
      ((as)localObject3).setType(paramcyb.Sqc & paramcyb.Sqd);
      int j;
      int i;
      if ((paramBoolean1) && (localObject2 != null) && ((int)((d)localObject2).jxt > 0))
      {
        Log.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((ax)localObject2).field_type), Integer.valueOf(((ax)localObject3).field_type) });
        j = 0;
        i = j;
        if ((((ax)localObject3).field_type & 0x1) == 0)
        {
          i = j;
          if ((((ax)localObject2).field_type & 0x1) == 1)
          {
            i = 1;
            Log.i("MicroMsg.ContactSyncExtension", "processModContact resetNoContact!!");
          }
        }
        ((as)localObject3).setType(((ax)localObject3).field_type | ((ax)localObject2).field_type);
        if (i != 0) {
          ((as)localObject3).axl();
        }
      }
      long l;
      label475:
      boolean bool;
      if (!Util.isNullOrNil(str2))
      {
        ((as)localObject3).Iy(str2);
        if (localObject2 != null) {
          break label1596;
        }
        l = 0L;
        ((as)localObject3).jxt = l;
        ((as)localObject3).setNickname(z.a(paramcyb.TtX));
        ((as)localObject3).It(z.a(paramcyb.SqW));
        ((as)localObject3).Iu(z.a(paramcyb.SqX));
        ((as)localObject3).pw(paramcyb.mVy);
        ((as)localObject3).pz(paramcyb.Sqi);
        ((as)localObject3).Is(z.a(paramcyb.TGf));
        ((as)localObject3).pA(paramcyb.Sqm);
        ((as)localObject3).pB(paramcyb.mVC);
        ((as)localObject3).IP(RegionCodeDecoder.bl(paramcyb.mVH, paramcyb.mVz, paramcyb.mVA));
        ((as)localObject3).IJ(paramcyb.mVB);
        ((as)localObject3).ps(paramcyb.TxF);
        ((as)localObject3).IO(paramcyb.TxG);
        if ((paramcyb.Cqs == 9) && (!Util.isNullOrNil(paramcyb.TGy)))
        {
          Log.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
          paramcyb.Cqs = 14;
        }
        ((as)localObject3).setSource(paramcyb.Cqs);
        ((as)localObject3).pr(paramcyb.TxJ);
        ((as)localObject3).Iv(paramcyb.TxI);
        ((as)localObject3).IC(paramcyb.TGy);
        ((as)localObject3).Ez(paramcyb.hDC);
        Log.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s ChatroomBusinessType:%s", new Object[] { ((ax)localObject3).field_username, Util.secPrint(((ax)localObject3).field_nickname), ((ax)localObject3).field_sourceExtInfo, Integer.valueOf(paramcyb.Cqs), Long.valueOf(paramcyb.hDC) });
        if (com.tencent.mm.model.ab.Rd(paramcyb.TxH)) {
          ((as)localObject3).IN(paramcyb.TxH);
        }
        if (((as)localObject3).hyb()) {
          ((as)localObject3).pC((int)Util.nowSecond());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((as)localObject3).IX(paramString);
        }
        Log.i("MicroMsg.ContactSyncExtension", "remark (%s -> %s), remarkpyshort:%s, nickname:%s, pyinitial:%s, quanpin:%s", new Object[] { ((ax)localObject3).field_conRemark, z.a(paramcyb.TFz), z.a(paramcyb.TFA), Util.secPrint(z.a(paramcyb.TtX)), z.a(paramcyb.SqW), z.a(paramcyb.SqX) });
        ((as)localObject3).Ir(z.a(paramcyb.TFz));
        ((as)localObject3).Iw(z.a(paramcyb.TFB));
        ((as)localObject3).Ix(z.a(paramcyb.TFA));
        ((as)localObject3).Iz(paramcyb.SrJ);
        ((as)localObject3).IQ(paramcyb.RIC);
        ((as)localObject3).IR(paramcyb.TGu);
        if (Util.isNullOrNil(paramArrayOfByte)) {
          break label1608;
        }
        ((n)h.ae(n.class)).bbL().G(str1, paramArrayOfByte);
        label965:
        ((as)localObject3).pu(paramcyb.DeleteFlag);
        if ((paramcyb.TGq != null) && (paramcyb.TGq.RIW != null))
        {
          ((as)localObject3).IS(paramcyb.TGq.RIW.RQE);
          ((as)localObject3).IT(paramcyb.TGq.RIW.RQF);
          ((as)localObject3).IU(paramcyb.TGq.RIW.RQG);
        }
        if ((localObject2 != null) && (!d.rk(((ax)localObject2).field_type))) {
          d.rk(((ax)localObject3).field_type);
        }
        if (com.tencent.mm.model.ab.QX(str1)) {
          ((as)localObject3).axx();
        }
        if (((as)localObject3).hxX()) {
          ((as)localObject3).axA();
        }
        ((as)localObject3).IV(paramcyb.hDv);
        ((as)localObject3).pE(paramcyb.ExtFlag);
        ((as)localObject3).setFromType(paramInt);
        i = (int)((d)localObject3).jxt;
        localObject1 = Util.secPrint(((ax)localObject3).field_nickname);
        String str3 = ((as)localObject3).api();
        j = ((ax)localObject3).field_deleteFlag;
        int k = ((ax)localObject3).field_type;
        int m = paramcyb.Sqc;
        int n = paramcyb.Sqd;
        int i1 = ((ax)localObject3).hDg;
        int i2 = ((ax)localObject3).hDj;
        String str4 = paramcyb.mVH;
        String str5 = paramcyb.mVz;
        String str6 = paramcyb.mVA;
        int i3 = ((as)localObject3).getSource();
        String str7 = ((ax)localObject3).field_contactLabelIds;
        if (paramcyb.RIC != null) {
          break label1649;
        }
        bool = true;
        label1219:
        if (paramcyb.RIC != null) {
          break label1655;
        }
        paramInt = 0;
        label1229:
        if (paramcyb.RIC != null) {
          break label1667;
        }
        paramString = "";
        label1240:
        Log.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s) verifyFlag:%d", new Object[] { str1, str2, Integer.valueOf(i), localObject1, str3, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str4, str5, str6, Integer.valueOf(i3), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString, Integer.valueOf(paramcyb.TxF) });
        EUN.a((as)localObject3, (as)localObject2, paramcyb, paramArrayOfByte, paramBoolean2);
        a.g((as)localObject3);
        if (Util.isNullOrNil(str2)) {
          break label1678;
        }
        ((n)h.ae(n.class)).bbL().d(str2, (as)localObject3);
        label1459:
        EUN.b((as)localObject3, (as)localObject2, paramcyb, paramArrayOfByte, paramBoolean2);
        if ((((ax)localObject3).field_type & 0x800) == 0) {
          break label1702;
        }
        if ((localObject2 == null) || ((((ax)localObject2).field_type & 0x800) != (((ax)localObject3).field_type & 0x800))) {
          ((n)h.ae(n.class)).bbR().bwD(((ax)localObject3).field_username);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", new Object[] { str1, Boolean.valueOf(((as)localObject3).ayi()) });
        AppMethodBeat.o(187862);
        return;
        if ((localObject2 == null) || ((int)((d)localObject2).jxt <= 0)) {
          break;
        }
        ((as)localObject3).Iy(((ax)localObject2).field_encryptUsername);
        break;
        label1596:
        l = (int)((d)localObject2).jxt;
        break label475;
        label1608:
        ((n)h.ae(n.class)).bbL().bwo(str1);
        Log.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", new Object[] { str1 });
        break label965;
        label1649:
        bool = false;
        break label1219;
        label1655:
        paramInt = paramcyb.RIC.length();
        break label1229;
        label1667:
        paramString = Util.secPrint(paramcyb.RIC);
        break label1240;
        label1678:
        ((n)h.ae(n.class)).bbL().au((as)localObject3);
        break label1459;
        label1702:
        if ((localObject2 == null) || ((((ax)localObject2).field_type & 0x800) != (((ax)localObject3).field_type & 0x800))) {
          ((n)h.ae(n.class)).bbR().bwE(((ax)localObject3).field_username);
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static void removeContactAssembler(f paramf)
  {
    AppMethodBeat.i(169106);
    EUN.remove(paramf);
    AppMethodBeat.o(169106);
  }
  
  public final void a(abu paramabu, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(116872);
    switch (paramabu.SnG)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116872);
      return;
      paramabu = (cyb)new cyb().parseFrom(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        processModContact(paramabu, "", paramArrayOfByte, false, paramBoolean, 0);
        AppMethodBeat.o(116872);
        return;
        paramArrayOfByte = null;
      }
      paramabu = (afq)new afq().parseFrom(paramArrayOfByte);
      paramArrayOfByte = z.a(paramabu.SrH);
      Log.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((n)h.ae(n.class)).bbR().bwv(paramArrayOfByte);
      com.tencent.mm.model.ab.Qo(paramArrayOfByte);
      af.b(4, paramabu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */