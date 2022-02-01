package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.af;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;

public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.ab
{
  private static final a KQm;
  
  static
  {
    AppMethodBeat.i(116874);
    KQm = new a((byte)0);
    AppMethodBeat.o(116874);
  }
  
  public static com.tencent.mm.vending.b.b addContactAssembler(f paramf)
  {
    AppMethodBeat.i(116871);
    paramf = KQm.add(paramf);
    AppMethodBeat.o(116871);
    return paramf;
  }
  
  public static void processModContact(dph paramdph, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(288660);
    if (paramdph == null)
    {
      Log.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      AppMethodBeat.o(288660);
      return;
    }
    if (!Util.isNullOrNil(paramdph.aanb)) {}
    String str2;
    for (String str1 = paramdph.aanb;; str1 = w.a(paramdph.ZqL))
    {
      str2 = Util.nullAsNil(paramdph.aaVR);
      if ((!Util.isNullOrNil(str1)) || (!Util.isNullOrNil(str2))) {
        break;
      }
      Log.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      AppMethodBeat.o(288660);
      return;
    }
    Log.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s modContactScene %s ", new Object[] { paramdph.ZqL, paramdph.aaVU, paramdph.aaVV, Integer.valueOf(paramInt) });
    Object localObject1 = ((n)h.ax(n.class)).bzA().bxw(str1);
    if (localObject1 != null) {
      Log.i("MicroMsg.ContactSyncExtension", "oldContact.getEncryptUsername() :%s %s", new Object[] { ((az)localObject1).field_encryptUsername, Integer.valueOf((int)((d)localObject1).maN) });
    }
    while ((!au.bwE(str1)) && (localObject1 != null) && (str1.equals(((az)localObject1).field_encryptUsername)))
    {
      Log.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      AppMethodBeat.o(288660);
      return;
      Log.i("MicroMsg.ContactSyncExtension", "oldContact is null ");
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((au)localObject1).iZL();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new au(str1);
      }
      ((au)localObject3).setUsername(str1);
      ((au)localObject3).AV(paramdph.pSk);
      ((au)localObject3).setType(paramdph.ZoY & paramdph.ZoZ);
      int j;
      int i;
      if ((paramBoolean1) && (localObject2 != null) && ((int)((d)localObject2).maN > 0))
      {
        Log.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((az)localObject2).field_type), Integer.valueOf(((az)localObject3).field_type) });
        j = 0;
        i = j;
        if ((((az)localObject3).field_type & 0x1) == 0)
        {
          i = j;
          if ((((az)localObject2).field_type & 0x1) == 1)
          {
            i = 1;
            Log.i("MicroMsg.ContactSyncExtension", "processModContact resetNoContact!!");
          }
        }
        ((au)localObject3).setType(((az)localObject3).field_type | ((az)localObject2).field_type);
        if (i != 0) {
          ((au)localObject3).aRL();
        }
      }
      long l;
      label475:
      boolean bool;
      if (!Util.isNullOrNil(str2))
      {
        ((au)localObject3).Bd(str2);
        if (localObject2 != null) {
          break label1596;
        }
        l = 0L;
        ((au)localObject3).maN = l;
        ((au)localObject3).setNickname(w.a(paramdph.aaIz));
        ((au)localObject3).AY(w.a(paramdph.ZpX));
        ((au)localObject3).AZ(w.a(paramdph.ZpY));
        ((au)localObject3).pv(paramdph.pSf);
        ((au)localObject3).py(paramdph.Zpe);
        ((au)localObject3).AX(w.a(paramdph.aaVL));
        ((au)localObject3).pz(paramdph.Zpi);
        ((au)localObject3).pA(paramdph.pSj);
        ((au)localObject3).Bu(RegionCodeDecoder.bI(paramdph.pSo, paramdph.pSg, paramdph.pSh));
        ((au)localObject3).Bo(paramdph.pSi);
        ((au)localObject3).pr(paramdph.aaMm);
        ((au)localObject3).Bt(paramdph.aaMn);
        if ((paramdph.IcB == 9) && (!Util.isNullOrNil(paramdph.aaWe)))
        {
          Log.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
          paramdph.IcB = 14;
        }
        ((au)localObject3).setSource(paramdph.IcB);
        ((au)localObject3).pq(paramdph.aaMq);
        ((au)localObject3).Ba(paramdph.aaMp);
        ((au)localObject3).Bh(paramdph.aaWe);
        ((au)localObject3).gP(paramdph.kax);
        Log.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s ChatroomBusinessType:%s", new Object[] { ((az)localObject3).field_username, Util.secPrint(((az)localObject3).field_nickname), ((az)localObject3).field_sourceExtInfo, Integer.valueOf(paramdph.IcB), Long.valueOf(paramdph.kax) });
        if (com.tencent.mm.model.ab.Jb(paramdph.aaMo)) {
          ((au)localObject3).Bs(paramdph.aaMo);
        }
        if (((au)localObject3).iZI()) {
          ((au)localObject3).pB((int)Util.nowSecond());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((au)localObject3).BC(paramString);
        }
        Log.i("MicroMsg.ContactSyncExtension", "remark (%s -> %s), remarkpyshort:%s, nickname:%s, pyinitial:%s, quanpin:%s", new Object[] { ((az)localObject3).field_conRemark, w.a(paramdph.aaVg), w.a(paramdph.aaVh), Util.secPrint(w.a(paramdph.aaIz)), w.a(paramdph.ZpX), w.a(paramdph.ZpY) });
        ((au)localObject3).AW(w.a(paramdph.aaVg));
        ((au)localObject3).Bb(w.a(paramdph.aaVi));
        ((au)localObject3).Bc(w.a(paramdph.aaVh));
        ((au)localObject3).Be(paramdph.ZqN);
        ((au)localObject3).Bv(paramdph.crB);
        ((au)localObject3).Bw(paramdph.aaWa);
        if (Util.isNullOrNil(paramArrayOfByte)) {
          break label1608;
        }
        ((n)h.ax(n.class)).bzA().K(str1, paramArrayOfByte);
        label965:
        ((au)localObject3).pt(paramdph.DeleteFlag);
        if ((paramdph.aaVW != null) && (paramdph.aaVW.YGk != null))
        {
          ((au)localObject3).Bx(paramdph.aaVW.YGk.YNT);
          ((au)localObject3).By(paramdph.aaVW.YGk.YNU);
          ((au)localObject3).Bz(paramdph.aaVW.YGk.YNV);
        }
        if ((localObject2 != null) && (!d.rs(((az)localObject2).field_type))) {
          d.rs(((az)localObject3).field_type);
        }
        if (com.tencent.mm.model.ab.IV(str1)) {
          ((au)localObject3).aRZ();
        }
        if (((au)localObject3).iZC()) {
          ((au)localObject3).aSc();
        }
        ((au)localObject3).BA(paramdph.kaq);
        ((au)localObject3).pD(paramdph.ExtFlag);
        ((au)localObject3).setFromType(paramInt);
        i = (int)((d)localObject3).maN;
        localObject1 = Util.secPrint(((az)localObject3).field_nickname);
        String str3 = ((au)localObject3).aJu();
        j = ((az)localObject3).field_deleteFlag;
        int k = ((az)localObject3).field_type;
        int m = paramdph.ZoY;
        int n = paramdph.ZoZ;
        int i1 = ((az)localObject3).kac;
        int i2 = ((az)localObject3).kaf;
        String str4 = paramdph.pSo;
        String str5 = paramdph.pSg;
        String str6 = paramdph.pSh;
        int i3 = ((au)localObject3).getSource();
        String str7 = ((az)localObject3).field_contactLabelIds;
        if (paramdph.crB != null) {
          break label1649;
        }
        bool = true;
        label1219:
        if (paramdph.crB != null) {
          break label1655;
        }
        paramInt = 0;
        label1229:
        if (paramdph.crB != null) {
          break label1667;
        }
        paramString = "";
        label1240:
        Log.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s) verifyFlag:%d", new Object[] { str1, str2, Integer.valueOf(i), localObject1, str3, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str4, str5, str6, Integer.valueOf(i3), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString, Integer.valueOf(paramdph.aaMm) });
        KQm.a((au)localObject3, (au)localObject2, paramdph, paramArrayOfByte, paramBoolean2);
        com.tencent.mm.contact.a.h((au)localObject3);
        if (Util.isNullOrNil(str2)) {
          break label1678;
        }
        ((n)h.ax(n.class)).bzA().e(str2, (au)localObject3);
        label1459:
        KQm.b((au)localObject3, (au)localObject2, paramdph, paramArrayOfByte, paramBoolean2);
        if ((((az)localObject3).field_type & 0x800) == 0) {
          break label1702;
        }
        if ((localObject2 == null) || ((((az)localObject2).field_type & 0x800) != (((az)localObject3).field_type & 0x800))) {
          ((n)h.ax(n.class)).bzG().bxT(((az)localObject3).field_username);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", new Object[] { str1, Boolean.valueOf(((au)localObject3).aSL()) });
        AppMethodBeat.o(288660);
        return;
        if ((localObject2 == null) || ((int)((d)localObject2).maN <= 0)) {
          break;
        }
        ((au)localObject3).Bd(((az)localObject2).field_encryptUsername);
        break;
        label1596:
        l = (int)((d)localObject2).maN;
        break label475;
        label1608:
        ((n)h.ax(n.class)).bzA().bxB(str1);
        Log.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", new Object[] { str1 });
        break label965;
        label1649:
        bool = false;
        break label1219;
        label1655:
        paramInt = paramdph.crB.length();
        break label1229;
        label1667:
        paramString = Util.secPrint(paramdph.crB);
        break label1240;
        label1678:
        ((n)h.ax(n.class)).bzA().aA((au)localObject3);
        break label1459;
        label1702:
        if ((localObject2 == null) || ((((az)localObject2).field_type & 0x800) != (((az)localObject3).field_type & 0x800))) {
          ((n)h.ax(n.class)).bzG().bxU(((az)localObject3).field_username);
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static void removeContactAssembler(f paramf)
  {
    AppMethodBeat.i(169106);
    KQm.remove(paramf);
    AppMethodBeat.o(169106);
  }
  
  public final void a(adw paramadw, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(116872);
    switch (paramadw.Zmc)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116872);
      return;
      paramadw = (dph)new dph().parseFrom(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        processModContact(paramadw, "", paramArrayOfByte, false, paramBoolean, 0);
        AppMethodBeat.o(116872);
        return;
        paramArrayOfByte = null;
      }
      paramadw = (aid)new aid().parseFrom(paramArrayOfByte);
      paramArrayOfByte = w.a(paramadw.ZqL);
      Log.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((n)h.ax(n.class)).bzG().bxK(paramArrayOfByte);
      paramae = ((n)h.ax(n.class)).bzA().JE(paramArrayOfByte);
      KQm.a(paramae, paramadw);
      com.tencent.mm.model.ab.IU(paramArrayOfByte);
      af.b(4, paramadw);
    }
  }
  
  static final class a
    extends com.tencent.mm.cp.a<f>
    implements f
  {
    public final void a(final au paramau, final aid paramaid)
    {
      AppMethodBeat.i(288658);
      a(new a.a() {});
      AppMethodBeat.o(288658);
    }
    
    public final void a(final au paramau1, final au paramau2, final dph paramdph, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116869);
      a(new a.a() {});
      AppMethodBeat.o(116869);
    }
    
    public final void b(final au paramau1, final au paramau2, final dph paramdph, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116870);
      a(new a.a() {});
      AppMethodBeat.o(116870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.b
 * JD-Core Version:    0.7.0.1
 */