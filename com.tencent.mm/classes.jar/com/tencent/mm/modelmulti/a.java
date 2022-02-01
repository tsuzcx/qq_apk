package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.al.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cun;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.deq;
import com.tencent.mm.protocal.protobuf.dga;
import com.tencent.mm.protocal.protobuf.dof;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.u
{
  public static boolean a(ai paramai)
  {
    AppMethodBeat.i(20539);
    if ((paramai == null) || (bs.isNullOrNil(paramai.field_username)))
    {
      if (paramai == null) {}
      for (paramai = "-1";; paramai = paramai.field_username)
      {
        ac.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paramai });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    az.ayM();
    Object localObject = com.tencent.mm.model.c.awB().aNy(paramai.field_username);
    if (bs.cv((byte[])localObject))
    {
      paramai = paramai.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        ac.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paramai, Integer.valueOf(i) });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    try
    {
      localObject = (bva)new bva().parseFrom((byte[])localObject);
      az.ayM();
      com.tencent.mm.model.c.awB().aNz(paramai.field_username);
      if (localObject == null)
      {
        ac.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        AppMethodBeat.o(20539);
        return false;
      }
    }
    catch (Exception localException)
    {
      bva localbva;
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localbva = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paramai, localbva, false);
      AppMethodBeat.o(20539);
      return bool;
    }
  }
  
  public final void a(xv paramxv, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(20538);
    switch (paramxv.ErL)
    {
    default: 
      ac.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramxv.ErL);
    }
    label301:
    label1882:
    label2152:
    do
    {
      AppMethodBeat.o(20538);
      return;
      paramxv = (blp)new blp().parseFrom(paramArrayOfByte);
      paramArrayOfByte = new com.tencent.mm.plugin.account.friend.a.p();
      paramArrayOfByte.username = paramxv.ncR;
      paramArrayOfByte.iKK = paramxv.Fbe;
      paramArrayOfByte.cGa = ((int)bs.aNx());
      com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(paramArrayOfByte);
      AppMethodBeat.o(20538);
      return;
      paramxv = (bvm)new bvm().parseFrom(paramArrayOfByte);
      if (1 == paramxv.Flm)
      {
        az.ayM();
        paramArrayOfByte = com.tencent.mm.model.c.awJ();
        paramx = z.a(paramxv.EuE);
        if (paramxv.DeleteFlag == 1)
        {
          paramBoolean = true;
          if (paramxv.Fln != 1) {
            break label301;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.f(paramx, paramBoolean, bool);
          AppMethodBeat.o(20538);
          return;
          paramBoolean = false;
          break;
        }
      }
      ac.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramxv.Flm);
      AppMethodBeat.o(20538);
      return;
      paramxv = (buv)new buv().parseFrom(paramArrayOfByte);
      if (paramxv != null)
      {
        ac.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramxv.EuE + " nickname:" + paramxv.Fbd);
        paramx = z.a(paramxv.EuE);
        az.ayM();
        paramArrayOfByte = com.tencent.mm.model.c.awB().aNt(paramx);
        paramArrayOfByte.setUsername(paramx);
        paramArrayOfByte.qj(z.a(paramxv.Fbd));
        paramArrayOfByte.qk(z.a(paramxv.EtY));
        paramArrayOfByte.ql(z.a(paramxv.EtZ));
        paramArrayOfByte.jH(paramxv.iJT);
        paramArrayOfByte.qh(z.a(paramxv.Fkk));
        paramArrayOfByte.qn(z.a(paramxv.Fkm));
        paramArrayOfByte.qo(z.a(paramxv.Fkl));
        paramArrayOfByte.jJ(paramxv.Etq);
        paramx = new i();
        paramx.drx = -1;
        paramx.username = paramArrayOfByte.field_username;
        paramx.huE = paramxv.Eog;
        paramx.huF = paramxv.Eof;
        ac.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramx.getUsername(), paramx.aBo(), paramx.aBp() });
        paramx.ez(true);
        if ((paramxv.FkA != 3) && (paramxv.FkA != 4)) {
          break label773;
        }
        paramArrayOfByte.jG(paramxv.FkA);
        paramx.exK = paramxv.FkA;
      }
      for (;;)
      {
        com.tencent.mm.aj.p.aBw().b(paramx);
        az.ayM();
        com.tencent.mm.model.c.awB().af(paramArrayOfByte);
        paramx = af.aCW().AE(paramArrayOfByte.field_username);
        paramx.field_username = paramArrayOfByte.field_username;
        paramx.field_brandList = paramxv.iKd;
        paramxv = paramxv.Fex;
        if (paramxv != null)
        {
          paramx.field_brandFlag = paramxv.iKh;
          paramx.field_brandInfo = paramxv.iKj;
          paramx.field_brandIconURL = paramxv.iKk;
          paramx.field_extInfo = paramxv.iKi;
          paramx.field_attrSyncVersion = null;
          ac.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", new Object[] { paramx.field_extInfo });
        }
        if (!af.aCW().g(paramx)) {
          af.aCW().f(paramx);
        }
        AppMethodBeat.o(20538);
        return;
        if (paramxv.FkA == 2)
        {
          paramArrayOfByte.jG(3);
          paramx.exK = 3;
          paramArrayOfByte.jG(3);
          if (!com.tencent.mm.model.u.axw().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.aj.p.aBh();
            com.tencent.mm.aj.e.L(paramArrayOfByte.field_username, false);
            com.tencent.mm.aj.p.aBh();
            com.tencent.mm.aj.e.L(paramArrayOfByte.field_username, true);
            com.tencent.mm.aj.p.aBy().zV(paramArrayOfByte.field_username);
          }
        }
      }
      paramxv = (aqc)new aqc().parseFrom(paramArrayOfByte);
      switch (paramxv.EIY)
      {
      case 2: 
      case 3: 
      default: 
        ac.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramxv.EIY);
        AppMethodBeat.o(20538);
        return;
      case 1: 
        az.ayM();
        com.tencent.mm.model.c.agA().set(17, Integer.valueOf(paramxv.vVH));
        AppMethodBeat.o(20538);
        return;
      }
      AppMethodBeat.o(20538);
      return;
      paramxv = (dga)new dga().parseFrom(paramArrayOfByte);
      if (paramxv != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bs.nullAsNil(paramxv.ncR).length() <= 0) {
          break label1039;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (ai.aMZ(paramxv.ncR)) {
          break label1044;
        }
        ac.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      az.ayM();
      paramArrayOfByte = com.tencent.mm.model.c.awB().aNt(paramxv.ncR);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.fLJ == 0))
      {
        paramArrayOfByte = new ai(paramxv.ncR);
        paramArrayOfByte.qh(paramxv.Eoe);
        paramArrayOfByte.jJ(1);
        paramArrayOfByte.aal();
        az.ayM();
        if (com.tencent.mm.model.c.awB().ah(paramArrayOfByte) == -1)
        {
          ac.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        paramArrayOfByte = paramArrayOfByte.field_username;
        if (paramArrayOfByte == null) {
          ac.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
      }
      for (;;)
      {
        paramArrayOfByte = new vp();
        paramArrayOfByte.dys.opType = 1;
        paramArrayOfByte.dys.drG = paramxv.ncR;
        paramArrayOfByte.dys.drH = paramxv.FwI;
        paramArrayOfByte.dys.drI = paramxv.Etx;
        com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!paramArrayOfByte.endsWith("@t.qq.com"))
        {
          ac.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
        else
        {
          paramx = new i();
          paramx.username = paramArrayOfByte;
          paramx.exK = 3;
          paramx.drx = 3;
          com.tencent.mm.aj.p.aBw().b(paramx);
          continue;
          if (!bs.nullAsNil(paramxv.Eoe).equals(bs.nullAsNil(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.qh(paramxv.Eoe);
            az.ayM();
            if (com.tencent.mm.model.c.awB().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              ac.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
      paramxv = (ciq)new ciq().parseFrom(paramArrayOfByte);
      if (paramxv != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bs.nullAsNil(paramxv.ncR).length() <= 0) {
          break label1411;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (ai.aNb(paramxv.ncR)) {
          break label1416;
        }
        ac.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      az.ayM();
      paramArrayOfByte = com.tencent.mm.model.c.awB().aNt(paramxv.ncR);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.fLJ == 0))
      {
        paramArrayOfByte = new ai(paramxv.ncR);
        paramArrayOfByte.aal();
        paramArrayOfByte.qj(paramxv.Eoe);
        paramArrayOfByte.qh(paramxv.Eoe);
        paramArrayOfByte.jJ(4);
        az.ayM();
        if (com.tencent.mm.model.c.awB().ah(paramArrayOfByte) == -1)
        {
          ac.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        com.tencent.mm.aj.c.zQ(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new pa();
        paramArrayOfByte.drC.opType = 1;
        paramArrayOfByte.drC.drG = paramxv.ncR;
        paramArrayOfByte.drC.drH = paramxv.FwI;
        paramArrayOfByte.drC.drI = paramxv.Etx;
        com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!bs.nullAsNil(paramxv.Eoe).equals(bs.nullAsNil(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.qj(paramxv.Eoe);
          paramArrayOfByte.qh(paramxv.Eoe);
          az.ayM();
          if (com.tencent.mm.model.c.awB().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            ac.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
      paramxv = (bus)new bus().parseFrom(paramArrayOfByte);
      if (paramxv != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bs.nullAsNil(paramxv.ncR).length() <= 0) {
          break label1956;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new ai();
        paramArrayOfByte.setUsername(paramxv.ncR);
        paramArrayOfByte.setType(paramxv.ndI);
        paramArrayOfByte.jH(paramxv.iJT);
        paramArrayOfByte.qG(RegionCodeDecoder.aW(paramxv.iKc, paramxv.iJU, paramxv.iJV));
        paramArrayOfByte.qA(paramxv.iJW);
        paramx = new i();
        paramx.drx = -1;
        paramx.username = paramxv.ncR;
        paramx.huE = paramxv.Eog;
        paramx.huF = paramxv.Eof;
        ac.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramx.getUsername(), paramx.aBo(), paramx.aBp() });
        ac.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramxv.FkA + " hd:" + paramxv.FkB);
        if (paramxv.FkB == 0) {
          break label1961;
        }
        paramBoolean = true;
        paramx.ez(paramBoolean);
        if ((paramxv.FkA != 3) && (paramxv.FkA != 4)) {
          break label1966;
        }
        paramArrayOfByte.jG(paramxv.FkA);
        paramx.exK = paramxv.FkA;
      }
      for (;;)
      {
        com.tencent.mm.aj.p.aBw().b(paramx);
        az.ayM();
        com.tencent.mm.model.c.awB().ae(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1694;
        paramBoolean = false;
        break label1882;
        if (paramxv.FkA == 2)
        {
          paramArrayOfByte.jG(3);
          paramx.exK = 3;
          com.tencent.mm.aj.p.aBh();
          com.tencent.mm.aj.e.L(paramxv.ncR, false);
          com.tencent.mm.aj.p.aBh();
          com.tencent.mm.aj.e.L(paramxv.ncR, true);
          com.tencent.mm.aj.p.aBy().zV(paramxv.ncR);
        }
        else
        {
          paramArrayOfByte.jG(3);
          paramx.exK = 3;
        }
      }
      paramx = (bvz)new bvz().parseFrom(paramArrayOfByte);
      if (paramx != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramxv = com.tencent.mm.model.u.axw();
        j = paramx.Flw;
        if (j != 2) {
          break label2349;
        }
        paramxv = ai.aNh(paramxv);
        az.ayM();
        paramArrayOfByte = (String)com.tencent.mm.model.c.agA().get(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramx.Flz)))
        {
          com.tencent.mm.aj.p.aBh();
          com.tencent.mm.aj.e.L(paramxv, true);
          az.ayM();
          paramArrayOfByte = com.tencent.mm.model.c.agA();
          if (j != 2) {
            break label2370;
          }
          i = 12553;
          paramArrayOfByte.set(i, paramx.Flz);
          paramBoolean = true;
        }
        ac.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramx.Flz, paramx.Eof, paramx.Eog });
        paramArrayOfByte = new i();
        paramArrayOfByte.username = paramxv;
        paramArrayOfByte.huF = paramx.Eof;
        paramArrayOfByte.huE = paramx.Eog;
        if (!bs.isNullOrNil(paramArrayOfByte.aBp()))
        {
          if (j != 1) {
            break label2378;
          }
          az.ayM();
          com.tencent.mm.model.c.agA().set(59, Boolean.TRUE);
        }
      }
      for (;;)
      {
        paramArrayOfByte.ez(false);
        paramArrayOfByte.drx = 56;
        if (!bs.isNullOrNil(paramx.Flz)) {
          paramArrayOfByte.ez(true);
        }
        com.tencent.mm.aj.p.aBw().b(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.aj.f().a(paramxv, new f.c()
          {
            public final int dd(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              return 0;
            }
          });
        }
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        az.ayM();
        paramArrayOfByte = (String)com.tencent.mm.model.c.agA().get(12297, null);
        break label2105;
        i = 12297;
        break label2152;
        az.ayM();
        com.tencent.mm.model.c.agA().set(60, Boolean.TRUE);
      }
      paramx = (dof)new dof().parseFrom(paramArrayOfByte);
      ac.i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s", new Object[] { Integer.valueOf(paramx.Few.iKe), Integer.valueOf(paramx.Few.FLb), Integer.valueOf(paramx.Few.FLc) });
      az.ayM();
      String str = (String)com.tencent.mm.model.c.agA().get(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(20538);
        return;
      }
      if (com.tencent.mm.plugin.sns.b.o.xMb != null) {
        com.tencent.mm.plugin.sns.b.o.xMb.a(str, paramx.Few);
      }
      ac.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", new Object[] { Integer.valueOf(paramx.FWb.FOg) });
      ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str, paramx.FWb);
      paramArrayOfByte = com.tencent.mm.al.f.dX(com.tencent.mm.model.u.axw());
      paramxv = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramxv = new com.tencent.mm.api.c();
      }
      paramxv.field_username = str;
      paramxv.field_brandList = paramx.iKd;
      if ((paramxv.IO()) && (paramxv.bV(false) != null) && (paramxv.bV(false).Jq() != null) && (!bs.isNullOrNil(paramxv.IV())))
      {
        paramxv.field_enterpriseFather = paramxv.IV();
        ac.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramxv.field_enterpriseFather });
      }
      if (!af.aCW().g(paramxv)) {
        af.aCW().f(paramxv);
      }
      int i = paramx.FVK;
      int j = paramx.FVL;
      int k = paramx.FVM;
      ac.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      az.ayM();
      com.tencent.mm.model.c.agA().set(135175, Integer.valueOf(i));
      az.ayM();
      com.tencent.mm.model.c.agA().set(135176, Integer.valueOf(j));
      az.ayM();
      com.tencent.mm.model.c.agA().set(135177, Integer.valueOf(k));
      az.ayM();
      com.tencent.mm.model.c.agA().set(144385, Integer.valueOf(paramx.FVQ));
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GIP, Integer.valueOf(paramx.EKX));
      az.ayM();
      com.tencent.mm.model.c.agA().set(339975, Integer.valueOf(paramx.FVY));
      ac.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramx.FVY), Integer.valueOf(paramx.EKX) });
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GGT, bs.bG(paramx.eyk, ""));
      ac.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramx.eyk });
      az.ayM();
      com.tencent.mm.model.c.agA().set(147457, Long.valueOf(paramx.FVZ));
      ac.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", new Object[] { Long.valueOf(paramx.FVZ) });
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GTq, Long.valueOf(paramx.FWc));
      ac.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PaySetting:%s", new Object[] { Long.toBinaryString(paramx.FWc) });
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GLp, paramx.FWa);
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GTD, Integer.valueOf(paramx.FWd));
      ac.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PayBindMobileTransfer:%s", new Object[] { Integer.valueOf(paramx.FWd) });
      paramxv = new i();
      paramxv.drx = -1;
      paramxv.username = str;
      paramxv.huF = paramx.Eof;
      paramxv.huE = paramx.Eog;
      paramxv.ez(true);
      paramxv.exK = 3;
      ac.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramxv.getUsername(), paramxv.aBo(), paramxv.aBp() });
      com.tencent.mm.aj.p.aBw().b(paramxv);
      paramxv = paramx.FkL;
      paramArrayOfByte = paramx.FkM;
      az.ayM();
      com.tencent.mm.model.c.agA().set(274433, paramArrayOfByte);
      az.ayM();
      com.tencent.mm.model.c.agA().set(274434, paramxv);
      if (paramx.DQl != null)
      {
        az.ayM();
        com.tencent.mm.model.c.agA().set(286721, paramx.DQl.DYe);
        az.ayM();
        com.tencent.mm.model.c.agA().set(286722, paramx.DQl.DYf);
        az.ayM();
        com.tencent.mm.model.c.agA().set(286723, paramx.DQl.DYg);
      }
      if ((paramx.FVW != null) && (paramx.FVW.Fsf != null) && (paramx.FVW.Fsf.getILen() > 0))
      {
        ac.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramx.FVW.Fsf.getILen()) });
        paramxv = new wo();
        paramxv.dzs.dzt = paramx.FVW;
        com.tencent.mm.sdk.b.a.GpY.l(paramxv);
      }
      AppMethodBeat.o(20538);
      return;
      try
      {
        i = com.tencent.mm.b.o.t(paramArrayOfByte, 0);
        ac.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        AppMethodBeat.o(20538);
        return;
      }
      catch (InterruptedException paramxv)
      {
        ac.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramxv, "", new Object[0]);
        AppMethodBeat.o(20538);
        return;
      }
      paramxv = (bxo)new bxo().parseFrom(paramArrayOfByte);
      ac.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramxv.tit), Long.valueOf(paramxv.vTQ) });
      if (w.wX(paramxv.tlK))
      {
        paramArrayOfByte = new rp();
        paramArrayOfByte.duC.msgId = paramxv.vTQ;
        com.tencent.mm.sdk.b.a.GpY.l(paramArrayOfByte);
      }
      AppMethodBeat.o(20538);
      return;
      paramxv = new tg();
      paramxv.dwl.data = paramArrayOfByte;
      com.tencent.mm.sdk.b.a.GpY.l(paramxv);
      AppMethodBeat.o(20538);
      return;
      paramxv = (cun)new cun().parseFrom(paramArrayOfByte);
    } while (paramxv == null);
    label773:
    label1039:
    label1044:
    label1694:
    label1956:
    label1961:
    label1966:
    label2105:
    label2370:
    label2378:
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().lz(paramxv.ncR, paramxv.Ewu);
    label1411:
    label1416:
    label2349:
    AppMethodBeat.o(20538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.a
 * JD-Core Version:    0.7.0.1
 */