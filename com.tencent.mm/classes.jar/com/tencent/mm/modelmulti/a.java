package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.x
{
  public static boolean a(an paraman)
  {
    AppMethodBeat.i(20539);
    if ((paraman == null) || (bu.isNullOrNil(paraman.field_username)))
    {
      if (paraman == null) {}
      for (paraman = "-1";; paraman = paraman.field_username)
      {
        ae.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paraman });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azF().aUQ(paraman.field_username);
    if (bu.cF((byte[])localObject))
    {
      paraman = paraman.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        ae.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paraman, Integer.valueOf(i) });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    try
    {
      localObject = (caj)new caj().parseFrom((byte[])localObject);
      bc.aCg();
      com.tencent.mm.model.c.azF().aUR(paraman.field_username);
      if (localObject == null)
      {
        ae.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        AppMethodBeat.o(20539);
        return false;
      }
    }
    catch (Exception localException)
    {
      caj localcaj;
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localcaj = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paraman, localcaj, false);
      AppMethodBeat.o(20539);
      return bool;
    }
  }
  
  public final void a(zx paramzx, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(20538);
    switch (paramzx.Gru)
    {
    default: 
      ae.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramzx.Gru);
    }
    label301:
    label1882:
    label2152:
    do
    {
      AppMethodBeat.o(20538);
      return;
      paramzx = (bqt)new bqt().parseFrom(paramArrayOfByte);
      paramArrayOfByte = new com.tencent.mm.plugin.account.friend.a.p();
      paramArrayOfByte.username = paramzx.nIJ;
      paramArrayOfByte.jgM = paramzx.Hee;
      paramArrayOfByte.cRP = ((int)bu.aRi());
      com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(paramArrayOfByte);
      AppMethodBeat.o(20538);
      return;
      paramzx = (cav)new cav().parseFrom(paramArrayOfByte);
      if (1 == paramzx.Hov)
      {
        bc.aCg();
        paramArrayOfByte = com.tencent.mm.model.c.azO();
        paramaa = z.a(paramzx.GuF);
        if (paramzx.DeleteFlag == 1)
        {
          paramBoolean = true;
          if (paramzx.How != 1) {
            break label301;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.h(paramaa, paramBoolean, bool);
          AppMethodBeat.o(20538);
          return;
          paramBoolean = false;
          break;
        }
      }
      ae.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramzx.Hov);
      AppMethodBeat.o(20538);
      return;
      paramzx = (cae)new cae().parseFrom(paramArrayOfByte);
      if (paramzx != null)
      {
        ae.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramzx.GuF + " nickname:" + paramzx.Hed);
        paramaa = z.a(paramzx.GuF);
        bc.aCg();
        paramArrayOfByte = com.tencent.mm.model.c.azF().BH(paramaa);
        paramArrayOfByte.setUsername(paramaa);
        paramArrayOfByte.to(z.a(paramzx.Hed));
        paramArrayOfByte.tp(z.a(paramzx.GtY));
        paramArrayOfByte.tq(z.a(paramzx.GtZ));
        paramArrayOfByte.kh(paramzx.jfV);
        paramArrayOfByte.tm(z.a(paramzx.Hnt));
        paramArrayOfByte.ts(z.a(paramzx.Hnv));
        paramArrayOfByte.tt(z.a(paramzx.Hnu));
        paramArrayOfByte.kj(paramzx.Gto);
        paramaa = new i();
        paramaa.dEu = -1;
        paramaa.username = paramArrayOfByte.field_username;
        paramaa.hPP = paramzx.GnO;
        paramaa.hPQ = paramzx.GnN;
        ae.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramaa.getUsername(), paramaa.aEG(), paramaa.aEH() });
        paramaa.eD(true);
        if ((paramzx.HnJ != 3) && (paramzx.HnJ != 4)) {
          break label773;
        }
        paramArrayOfByte.kg(paramzx.HnJ);
        paramaa.eQU = paramzx.HnJ;
      }
      for (;;)
      {
        com.tencent.mm.aj.p.aEN().b(paramaa);
        bc.aCg();
        com.tencent.mm.model.c.azF().am(paramArrayOfByte);
        paramaa = ag.aGp().Ef(paramArrayOfByte.field_username);
        paramaa.field_username = paramArrayOfByte.field_username;
        paramaa.field_brandList = paramzx.jgf;
        paramzx = paramzx.HhB;
        if (paramzx != null)
        {
          paramaa.field_brandFlag = paramzx.jgj;
          paramaa.field_brandInfo = paramzx.jgl;
          paramaa.field_brandIconURL = paramzx.jgm;
          paramaa.field_extInfo = paramzx.jgk;
          paramaa.field_attrSyncVersion = null;
          ae.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", new Object[] { paramaa.field_extInfo });
        }
        if (!ag.aGp().g(paramaa)) {
          ag.aGp().f(paramaa);
        }
        AppMethodBeat.o(20538);
        return;
        if (paramzx.HnJ == 2)
        {
          paramArrayOfByte.kg(3);
          paramaa.eQU = 3;
          paramArrayOfByte.kg(3);
          if (!v.aAC().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.aj.p.aEA();
            com.tencent.mm.aj.e.L(paramArrayOfByte.field_username, false);
            com.tencent.mm.aj.p.aEA();
            com.tencent.mm.aj.e.L(paramArrayOfByte.field_username, true);
            com.tencent.mm.aj.p.aEP().Dw(paramArrayOfByte.field_username);
          }
        }
      }
      paramzx = (auo)new auo().parseFrom(paramArrayOfByte);
      switch (paramzx.GLx)
      {
      case 2: 
      case 3: 
      default: 
        ae.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramzx.GLx);
        AppMethodBeat.o(20538);
        return;
      case 1: 
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(17, Integer.valueOf(paramzx.xsz));
        AppMethodBeat.o(20538);
        return;
      }
      AppMethodBeat.o(20538);
      return;
      paramzx = (dmk)new dmk().parseFrom(paramArrayOfByte);
      if (paramzx != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bu.nullAsNil(paramzx.nIJ).length() <= 0) {
          break label1039;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (an.aUn(paramzx.nIJ)) {
          break label1044;
        }
        ae.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      bc.aCg();
      paramArrayOfByte = com.tencent.mm.model.c.azF().BH(paramzx.nIJ);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.ght == 0))
      {
        paramArrayOfByte = new an(paramzx.nIJ);
        paramArrayOfByte.tm(paramzx.GnM);
        paramArrayOfByte.kj(1);
        paramArrayOfByte.acY();
        bc.aCg();
        if (com.tencent.mm.model.c.azF().ao(paramArrayOfByte) == -1)
        {
          ae.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        paramArrayOfByte = paramArrayOfByte.field_username;
        if (paramArrayOfByte == null) {
          ae.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
      }
      for (;;)
      {
        paramArrayOfByte = new wm();
        paramArrayOfByte.dLU.opType = 1;
        paramArrayOfByte.dLU.dED = paramzx.nIJ;
        paramArrayOfByte.dLU.dEE = paramzx.HAn;
        paramArrayOfByte.dLU.dEF = paramzx.Gtv;
        com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!paramArrayOfByte.endsWith("@t.qq.com"))
        {
          ae.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
        else
        {
          paramaa = new i();
          paramaa.username = paramArrayOfByte;
          paramaa.eQU = 3;
          paramaa.dEu = 3;
          com.tencent.mm.aj.p.aEN().b(paramaa);
          continue;
          if (!bu.nullAsNil(paramzx.GnM).equals(bu.nullAsNil(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.tm(paramzx.GnM);
            bc.aCg();
            if (com.tencent.mm.model.c.azF().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              ae.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
      paramzx = (cok)new cok().parseFrom(paramArrayOfByte);
      if (paramzx != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bu.nullAsNil(paramzx.nIJ).length() <= 0) {
          break label1411;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (an.aUp(paramzx.nIJ)) {
          break label1416;
        }
        ae.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      bc.aCg();
      paramArrayOfByte = com.tencent.mm.model.c.azF().BH(paramzx.nIJ);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.ght == 0))
      {
        paramArrayOfByte = new an(paramzx.nIJ);
        paramArrayOfByte.acY();
        paramArrayOfByte.to(paramzx.GnM);
        paramArrayOfByte.tm(paramzx.GnM);
        paramArrayOfByte.kj(4);
        bc.aCg();
        if (com.tencent.mm.model.c.azF().ao(paramArrayOfByte) == -1)
        {
          ae.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        com.tencent.mm.aj.c.Dr(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new pk();
        paramArrayOfByte.dEz.opType = 1;
        paramArrayOfByte.dEz.dED = paramzx.nIJ;
        paramArrayOfByte.dEz.dEE = paramzx.HAn;
        paramArrayOfByte.dEz.dEF = paramzx.Gtv;
        com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!bu.nullAsNil(paramzx.GnM).equals(bu.nullAsNil(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.to(paramzx.GnM);
          paramArrayOfByte.tm(paramzx.GnM);
          bc.aCg();
          if (com.tencent.mm.model.c.azF().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            ae.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
      paramzx = (cab)new cab().parseFrom(paramArrayOfByte);
      if (paramzx != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bu.nullAsNil(paramzx.nIJ).length() <= 0) {
          break label1956;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new an();
        paramArrayOfByte.setUsername(paramzx.nIJ);
        paramArrayOfByte.setType(paramzx.nJA);
        paramArrayOfByte.kh(paramzx.jfV);
        paramArrayOfByte.tL(RegionCodeDecoder.bg(paramzx.jge, paramzx.jfW, paramzx.jfX));
        paramArrayOfByte.tF(paramzx.jfY);
        paramaa = new i();
        paramaa.dEu = -1;
        paramaa.username = paramzx.nIJ;
        paramaa.hPP = paramzx.GnO;
        paramaa.hPQ = paramzx.GnN;
        ae.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramaa.getUsername(), paramaa.aEG(), paramaa.aEH() });
        ae.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramzx.HnJ + " hd:" + paramzx.HnK);
        if (paramzx.HnK == 0) {
          break label1961;
        }
        paramBoolean = true;
        paramaa.eD(paramBoolean);
        if ((paramzx.HnJ != 3) && (paramzx.HnJ != 4)) {
          break label1966;
        }
        paramArrayOfByte.kg(paramzx.HnJ);
        paramaa.eQU = paramzx.HnJ;
      }
      for (;;)
      {
        com.tencent.mm.aj.p.aEN().b(paramaa);
        bc.aCg();
        com.tencent.mm.model.c.azF().al(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1694;
        paramBoolean = false;
        break label1882;
        if (paramzx.HnJ == 2)
        {
          paramArrayOfByte.kg(3);
          paramaa.eQU = 3;
          com.tencent.mm.aj.p.aEA();
          com.tencent.mm.aj.e.L(paramzx.nIJ, false);
          com.tencent.mm.aj.p.aEA();
          com.tencent.mm.aj.e.L(paramzx.nIJ, true);
          com.tencent.mm.aj.p.aEP().Dw(paramzx.nIJ);
        }
        else
        {
          paramArrayOfByte.kg(3);
          paramaa.eQU = 3;
        }
      }
      paramaa = (cbj)new cbj().parseFrom(paramArrayOfByte);
      if (paramaa != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramzx = v.aAC();
        j = paramaa.HoG;
        if (j != 2) {
          break label2349;
        }
        paramzx = an.aUA(paramzx);
        bc.aCg();
        paramArrayOfByte = (String)com.tencent.mm.model.c.ajA().get(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramaa.HoJ)))
        {
          com.tencent.mm.aj.p.aEA();
          com.tencent.mm.aj.e.L(paramzx, true);
          bc.aCg();
          paramArrayOfByte = com.tencent.mm.model.c.ajA();
          if (j != 2) {
            break label2370;
          }
          i = 12553;
          paramArrayOfByte.set(i, paramaa.HoJ);
          paramBoolean = true;
        }
        ae.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramaa.HoJ, paramaa.GnN, paramaa.GnO });
        paramArrayOfByte = new i();
        paramArrayOfByte.username = paramzx;
        paramArrayOfByte.hPQ = paramaa.GnN;
        paramArrayOfByte.hPP = paramaa.GnO;
        if (!bu.isNullOrNil(paramArrayOfByte.aEH()))
        {
          if (j != 1) {
            break label2378;
          }
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(59, Boolean.TRUE);
        }
      }
      for (;;)
      {
        paramArrayOfByte.eD(false);
        paramArrayOfByte.dEu = 56;
        if (!bu.isNullOrNil(paramaa.HoJ)) {
          paramArrayOfByte.eD(true);
        }
        com.tencent.mm.aj.p.aEN().b(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.aj.f().a(paramzx, new f.c()
          {
            public final int df(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              return 0;
            }
          });
        }
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        bc.aCg();
        paramArrayOfByte = (String)com.tencent.mm.model.c.ajA().get(12297, null);
        break label2105;
        i = 12297;
        break label2152;
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(60, Boolean.TRUE);
      }
      paramaa = (dut)new dut().parseFrom(paramArrayOfByte);
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s", new Object[] { Integer.valueOf(paramaa.HhA.jgg), Integer.valueOf(paramaa.HhA.HPm), Integer.valueOf(paramaa.HhA.HPn) });
      bc.aCg();
      String str = (String)com.tencent.mm.model.c.ajA().get(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(20538);
        return;
      }
      if (com.tencent.mm.plugin.sns.b.o.zsw != null) {
        com.tencent.mm.plugin.sns.b.o.zsw.a(str, paramaa.HhA);
      }
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", new Object[] { Integer.valueOf(paramaa.IaC.HSC) });
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str, paramaa.IaC);
      paramArrayOfByte = com.tencent.mm.al.g.eX(v.aAC());
      paramzx = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramzx = new com.tencent.mm.api.c();
      }
      paramzx.field_username = str;
      paramzx.field_brandList = paramaa.jgf;
      if ((paramzx.Kw()) && (paramzx.bX(false) != null) && (paramzx.bX(false).KX() != null) && (!bu.isNullOrNil(paramzx.KD())))
      {
        paramzx.field_enterpriseFather = paramzx.KD();
        ae.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramzx.field_enterpriseFather });
      }
      if (!ag.aGp().g(paramzx)) {
        ag.aGp().f(paramzx);
      }
      int i = paramaa.Ial;
      int j = paramaa.Iam;
      int k = paramaa.Ian;
      ae.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(135175, Integer.valueOf(i));
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(135176, Integer.valueOf(j));
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(135177, Integer.valueOf(k));
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(144385, Integer.valueOf(paramaa.Iar));
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.IPF, Integer.valueOf(paramaa.GNz));
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(339975, Integer.valueOf(paramaa.Iaz));
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramaa.Iaz), Integer.valueOf(paramaa.GNz) });
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.INH, bu.bI(paramaa.eRt, ""));
      ae.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramaa.eRt });
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(147457, Long.valueOf(paramaa.IaA));
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", new Object[] { Long.valueOf(paramaa.IaA) });
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.Jem, Integer.valueOf(paramaa.HzY));
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(paramaa.HzY) });
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.Jen, paramaa.IaG);
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.BindXMail:%s", new Object[] { paramaa.IaG });
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.Jav, Long.valueOf(paramaa.IaD));
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PaySetting:%s", new Object[] { Long.toBinaryString(paramaa.IaD) });
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.ISf, paramaa.IaB);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.JaI, Integer.valueOf(paramaa.IaE));
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PayBindMobileTransfer:%s", new Object[] { Integer.valueOf(paramaa.IaE) });
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jet, paramaa.Hoy);
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffix:%s", new Object[] { paramaa.Hoy });
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jez, Integer.valueOf(paramaa.HJY));
      ae.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(paramaa.HJY) });
      com.tencent.mm.plugin.patmsg.c.eK(str, paramaa.HJY);
      paramzx = new i();
      paramzx.dEu = -1;
      paramzx.username = str;
      paramzx.hPQ = paramaa.GnN;
      paramzx.hPP = paramaa.GnO;
      paramzx.eD(true);
      paramzx.eQU = 3;
      ae.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramzx.getUsername(), paramzx.aEG(), paramzx.aEH() });
      com.tencent.mm.aj.p.aEN().b(paramzx);
      paramzx = paramaa.HnU;
      paramArrayOfByte = paramaa.HnV;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(274433, paramArrayOfByte);
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(274434, paramzx);
      if (paramaa.FNY != null)
      {
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(286721, paramaa.FNY.FVV);
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(286722, paramaa.FNY.FVW);
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(286723, paramaa.FNY.FVX);
      }
      if ((paramaa.Iax != null) && (paramaa.Iax.HvL != null) && (paramaa.Iax.HvL.getILen() > 0))
      {
        ae.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramaa.Iax.HvL.getILen()) });
        paramzx = new xl();
        paramzx.dMT.dMU = paramaa.Iax;
        com.tencent.mm.sdk.b.a.IvT.l(paramzx);
      }
      AppMethodBeat.o(20538);
      return;
      try
      {
        i = com.tencent.mm.b.o.t(paramArrayOfByte, 0);
        ae.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        AppMethodBeat.o(20538);
        return;
      }
      catch (InterruptedException paramzx)
      {
        ae.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramzx, "", new Object[0]);
        AppMethodBeat.o(20538);
        return;
      }
      paramzx = (ccz)new ccz().parseFrom(paramArrayOfByte);
      ae.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramzx.urJ), Long.valueOf(paramzx.xrk) });
      if (com.tencent.mm.model.x.AE(paramzx.uvG))
      {
        paramArrayOfByte = new sc();
        paramArrayOfByte.dHJ.msgId = paramzx.xrk;
        com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfByte);
      }
      AppMethodBeat.o(20538);
      return;
      paramzx = new tz();
      paramzx.dJz.data = paramArrayOfByte;
      com.tencent.mm.sdk.b.a.IvT.l(paramzx);
      AppMethodBeat.o(20538);
      return;
      paramzx = (dar)new dar().parseFrom(paramArrayOfByte);
    } while (paramzx == null);
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
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().me(paramzx.nIJ, paramzx.xrf);
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