package com.tencent.mm.plugin.messenger.foundation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.vending.b.b;

public final class a
  implements x
{
  private static final a zpp;
  
  static
  {
    AppMethodBeat.i(116874);
    zpp = new a((byte)0);
    AppMethodBeat.o(116874);
  }
  
  public static b addContactAssembler(d paramd)
  {
    AppMethodBeat.i(116871);
    paramd = zpp.add(paramd);
    AppMethodBeat.o(116871);
    return paramd;
  }
  
  public static void processModContact(cpl paramcpl, String paramString, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(187478);
    if (paramcpl == null)
    {
      Log.f("MicroMsg.ContactSyncExtension", "unable to parse mod contact");
      AppMethodBeat.o(187478);
      return;
    }
    if (!Util.isNullOrNil(paramcpl.LRy)) {}
    String str2;
    for (String str1 = paramcpl.LRy;; str1 = z.a(paramcpl.Lqk))
    {
      str2 = Util.nullAsNil(paramcpl.Mvn);
      if ((!Util.isNullOrNil(str1)) || (!Util.isNullOrNil(str2))) {
        break;
      }
      Log.e("MicroMsg.ContactSyncExtension", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
      AppMethodBeat.o(187478);
      return;
    }
    Log.i("MicroMsg.ContactSyncExtension", "username %s mobileHash %s mobileFullHash %s modContactScene %s ", new Object[] { paramcpl.Lqk, paramcpl.Mvq, paramcpl.Mvr, Integer.valueOf(paramInt) });
    Object localObject1 = ((l)g.af(l.class)).aSN().bjL(str1);
    if ((!com.tencent.mm.model.ab.Iw(str1)) && (localObject1 != null) && (str1.equals(((ax)localObject1).field_encryptUsername)))
    {
      Log.w("MicroMsg.ContactSyncExtension", "cat's replace user with stranger  user:%s", new Object[] { str1 });
      AppMethodBeat.o(187478);
      return;
    }
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((as)localObject1).gBT();
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new as(str1);
      }
      ((as)localObject3).setUsername(str1);
      ((as)localObject3).BC(paramcpl.ked);
      ((as)localObject3).setType(paramcpl.LoG & paramcpl.LoH);
      if ((paramBoolean1) && (localObject2 != null) && ((int)((c)localObject2).gMZ > 0))
      {
        Log.w("MicroMsg.ContactSyncExtension", "processModContact Fuck GETCONTACT can't give the REAL_TYPE (mariohuang), user:%s old:%d get:%d", new Object[] { str1, Integer.valueOf(((ax)localObject2).field_type), Integer.valueOf(((ax)localObject3).field_type) });
        ((as)localObject3).setType(((ax)localObject3).field_type | ((ax)localObject2).field_type);
      }
      long l;
      label377:
      boolean bool;
      if (!Util.isNullOrNil(str2))
      {
        ((as)localObject3).BK(str2);
        if (localObject2 != null) {
          break label1467;
        }
        l = 0L;
        ((as)localObject3).gMZ = l;
        ((as)localObject3).setNickname(z.a(paramcpl.Mjj));
        ((as)localObject3).BF(z.a(paramcpl.LpA));
        ((as)localObject3).BG(z.a(paramcpl.LpB));
        ((as)localObject3).nj(paramcpl.kdY);
        ((as)localObject3).nl(paramcpl.LoM);
        ((as)localObject3).BE(z.a(paramcpl.Mvh));
        ((as)localObject3).nm(paramcpl.LoQ);
        ((as)localObject3).nn(paramcpl.kec);
        ((as)localObject3).Cb(RegionCodeDecoder.bq(paramcpl.keh, paramcpl.kdZ, paramcpl.kea));
        ((as)localObject3).BV(paramcpl.keb);
        ((as)localObject3).nf(paramcpl.MmK);
        ((as)localObject3).Ca(paramcpl.MmL);
        if ((paramcpl.xub == 9) && (!Util.isNullOrNil(paramcpl.MvA)))
        {
          Log.i("MicroMsg.ContactSyncExtension", "fix addContactScene!");
          paramcpl.xub = 14;
        }
        ((as)localObject3).setSource(paramcpl.xub);
        ((as)localObject3).ne(paramcpl.MmO);
        ((as)localObject3).BH(paramcpl.MmN);
        ((as)localObject3).BO(paramcpl.MvA);
        ((as)localObject3).yy(paramcpl.fvd);
        Log.i("MicroMsg.ContactSyncExtension", "username:%s nickname:%s SourceExtInfo:%s source:%s ChatroomBusinessType:%s", new Object[] { ((ax)localObject3).field_username, Util.secPrint(((ax)localObject3).field_nickname), ((ax)localObject3).field_sourceExtInfo, Integer.valueOf(paramcpl.xub), Long.valueOf(paramcpl.fvd) });
        if (com.tencent.mm.model.ab.JK(paramcpl.MmM)) {
          ((as)localObject3).BZ(paramcpl.MmM);
        }
        if (((as)localObject3).gBQ()) {
          ((as)localObject3).no((int)Util.nowSecond());
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((as)localObject3).Cj(paramString);
        }
        Log.i("MicroMsg.ContactSyncExtension", "remark (%s -> %s), remarkpyshort:%s, nickname:%s, pyinitial:%s, quanpin:%s", new Object[] { ((ax)localObject3).field_conRemark, z.a(paramcpl.MuI), z.a(paramcpl.MuJ), z.a(paramcpl.Mjj), z.a(paramcpl.LpA), z.a(paramcpl.LpB) });
        ((as)localObject3).BD(z.a(paramcpl.MuI));
        ((as)localObject3).BI(z.a(paramcpl.MuK));
        ((as)localObject3).BJ(z.a(paramcpl.MuJ));
        ((as)localObject3).BL(paramcpl.Lqm);
        ((as)localObject3).Cc(paramcpl.KHk);
        ((as)localObject3).Cd(paramcpl.Mvw);
        if (Util.isNullOrNil(paramArrayOfByte)) {
          break label1479;
        }
        ((l)g.af(l.class)).aSN().B(str1, paramArrayOfByte);
        label864:
        ((as)localObject3).nh(paramcpl.DeleteFlag);
        if ((paramcpl.Mvs != null) && (paramcpl.Mvs.KHD != null))
        {
          ((as)localObject3).Ce(paramcpl.Mvs.KHD.KPG);
          ((as)localObject3).Cf(paramcpl.Mvs.KHD.KPH);
          ((as)localObject3).Cg(paramcpl.Mvs.KHD.KPI);
        }
        if (com.tencent.mm.model.ab.JE(str1)) {
          ((as)localObject3).aqZ();
        }
        if (((as)localObject3).gBM()) {
          ((as)localObject3).arc();
        }
        ((as)localObject3).Ch(paramcpl.fuW);
        ((as)localObject3).nq(paramcpl.ExtFlag);
        ((as)localObject3).setFromType(paramInt);
        int i = (int)((c)localObject3).gMZ;
        localObject1 = ((ax)localObject3).field_nickname;
        String str3 = ((as)localObject3).ajA();
        int j = ((ax)localObject3).field_deleteFlag;
        int k = ((ax)localObject3).field_type;
        int m = paramcpl.LoG;
        int n = paramcpl.LoH;
        int i1 = ((ax)localObject3).fuE;
        int i2 = ((ax)localObject3).fuH;
        String str4 = paramcpl.keh;
        String str5 = paramcpl.kdZ;
        String str6 = paramcpl.kea;
        int i3 = ((as)localObject3).getSource();
        String str7 = ((ax)localObject3).field_contactLabelIds;
        if (paramcpl.KHk != null) {
          break label1520;
        }
        bool = true;
        label1090:
        if (paramcpl.KHk != null) {
          break label1526;
        }
        paramInt = 0;
        label1100:
        if (paramcpl.KHk != null) {
          break label1538;
        }
        paramString = "";
        label1111:
        Log.i("MicroMsg.ContactSyncExtension", "processModContact:user[%s,%s] id:%d nick:%s pin:%s delflag:%d type:%d [%d,%d] contype:%d notify:%d region[%s,%s,%s] src:%d LabelIDList:%s fromGetContactService:%b remark_Description:(%s,%s,%s) verifyFlag:%d", new Object[] { str1, str2, Integer.valueOf(i), localObject1, str3, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), str4, str5, str6, Integer.valueOf(i3), str7, Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Integer.valueOf(paramInt), paramString, Integer.valueOf(paramcpl.MmK) });
        zpp.a((as)localObject3, (as)localObject2, paramcpl, paramArrayOfByte, paramBoolean2);
        com.tencent.mm.contact.a.g((as)localObject3);
        if (Util.isNullOrNil(str2)) {
          break label1549;
        }
        ((l)g.af(l.class)).aSN().d(str2, (as)localObject3);
        label1330:
        zpp.b((as)localObject3, (as)localObject2, paramcpl, paramArrayOfByte, paramBoolean2);
        if ((((ax)localObject3).field_type & 0x800) == 0) {
          break label1573;
        }
        if ((localObject2 == null) || ((((ax)localObject2).field_type & 0x800) != (((ax)localObject3).field_type & 0x800))) {
          ((l)g.af(l.class)).aST().bke(((ax)localObject3).field_username);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.ContactSyncExtension", "operationModSnsBlackContact username:%s isSnsBlackContact:%s", new Object[] { str1, Boolean.valueOf(((as)localObject3).arB()) });
        AppMethodBeat.o(187478);
        return;
        if ((localObject2 == null) || ((int)((c)localObject2).gMZ <= 0)) {
          break;
        }
        ((as)localObject3).BK(((ax)localObject2).field_encryptUsername);
        break;
        label1467:
        l = (int)((c)localObject2).gMZ;
        break label377;
        label1479:
        ((l)g.af(l.class)).aSN().bjQ(str1);
        Log.e("MicroMsg.ContactSyncExtension", "[processModContact] cmdBuf is null! user:%s", new Object[] { str1 });
        break label864;
        label1520:
        bool = false;
        break label1090;
        label1526:
        paramInt = paramcpl.KHk.length();
        break label1100;
        label1538:
        paramString = Util.secPrint(paramcpl.KHk);
        break label1111;
        label1549:
        ((l)g.af(l.class)).aSN().ao((as)localObject3);
        break label1330;
        label1573:
        if ((localObject2 == null) || ((((ax)localObject2).field_type & 0x800) != (((ax)localObject3).field_type & 0x800))) {
          ((l)g.af(l.class)).aST().bkf(((ax)localObject3).field_username);
        }
      }
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  public static void removeContactAssembler(d paramd)
  {
    AppMethodBeat.i(169106);
    zpp.remove(paramd);
    AppMethodBeat.o(169106);
  }
  
  public final void a(abn paramabn, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(116872);
    switch (paramabn.Lms)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(116872);
      return;
      paramabn = (cpl)new cpl().parseFrom(paramArrayOfByte);
      if (paramBoolean) {}
      for (;;)
      {
        processModContact(paramabn, "", paramArrayOfByte, false, paramBoolean, 0);
        AppMethodBeat.o(116872);
        return;
        paramArrayOfByte = null;
      }
      paramabn = (afh)new afh().parseFrom(paramArrayOfByte);
      paramArrayOfByte = z.a(paramabn.Lqk);
      Log.i("MicroMsg.ContactSyncExtension", "processDelContact user:%s", new Object[] { paramArrayOfByte });
      ((l)g.af(l.class)).aST().bjW(paramArrayOfByte);
      com.tencent.mm.model.ab.IV(paramArrayOfByte);
      com.tencent.mm.plugin.messenger.foundation.a.ab.b(4, paramabn);
    }
  }
  
  static final class a
    extends com.tencent.mm.co.a<d>
    implements d
  {
    public final void a(final as paramas1, final as paramas2, final cpl paramcpl, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116869);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(116869);
    }
    
    public final void b(final as paramas1, final as paramas2, final cpl paramcpl, final byte[] paramArrayOfByte, final boolean paramBoolean)
    {
      AppMethodBeat.i(116870);
      a(new com.tencent.mm.co.a.a() {});
      AppMethodBeat.o(116870);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a
 * JD-Core Version:    0.7.0.1
 */