package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.am.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.cnq;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.protocal.protobuf.dln;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.w
{
  public static boolean a(am paramam)
  {
    AppMethodBeat.i(20539);
    if ((paramam == null) || (bt.isNullOrNil(paramam.field_username)))
    {
      if (paramam == null) {}
      for (paramam = "-1";; paramam = paramam.field_username)
      {
        ad.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paramam });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    ba.aBQ();
    Object localObject = com.tencent.mm.model.c.azp().aTp(paramam.field_username);
    if (bt.cC((byte[])localObject))
    {
      paramam = paramam.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        ad.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paramam, Integer.valueOf(i) });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    try
    {
      localObject = (bzp)new bzp().parseFrom((byte[])localObject);
      ba.aBQ();
      com.tencent.mm.model.c.azp().aTq(paramam.field_username);
      if (localObject == null)
      {
        ad.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        AppMethodBeat.o(20539);
        return false;
      }
    }
    catch (Exception localException)
    {
      bzp localbzp;
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localbzp = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paramam, localbzp, false);
      AppMethodBeat.o(20539);
      return bool;
    }
  }
  
  public final void a(zu paramzu, byte[] paramArrayOfByte, boolean paramBoolean, com.tencent.mm.plugin.messenger.foundation.a.z paramz)
  {
    AppMethodBeat.i(20538);
    switch (paramzu.FYU)
    {
    default: 
      ad.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramzu.FYU);
    }
    label301:
    label1882:
    label2152:
    do
    {
      AppMethodBeat.o(20538);
      return;
      paramzu = (bpz)new bpz().parseFrom(paramArrayOfByte);
      paramArrayOfByte = new com.tencent.mm.plugin.account.friend.a.p();
      paramArrayOfByte.username = paramzu.nDo;
      paramArrayOfByte.jdT = paramzu.GKD;
      paramArrayOfByte.cRf = ((int)bt.aQJ());
      com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(paramArrayOfByte);
      AppMethodBeat.o(20538);
      return;
      paramzu = (cab)new cab().parseFrom(paramArrayOfByte);
      if (1 == paramzu.GUU)
      {
        ba.aBQ();
        paramArrayOfByte = com.tencent.mm.model.c.azy();
        paramz = com.tencent.mm.platformtools.z.a(paramzu.GbY);
        if (paramzu.DeleteFlag == 1)
        {
          paramBoolean = true;
          if (paramzu.GUV != 1) {
            break label301;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.h(paramz, paramBoolean, bool);
          AppMethodBeat.o(20538);
          return;
          paramBoolean = false;
          break;
        }
      }
      ad.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramzu.GUU);
      AppMethodBeat.o(20538);
      return;
      paramzu = (bzk)new bzk().parseFrom(paramArrayOfByte);
      if (paramzu != null)
      {
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramzu.GbY + " nickname:" + paramzu.GKC);
        paramz = com.tencent.mm.platformtools.z.a(paramzu.GbY);
        ba.aBQ();
        paramArrayOfByte = com.tencent.mm.model.c.azp().Bf(paramz);
        paramArrayOfByte.setUsername(paramz);
        paramArrayOfByte.sT(com.tencent.mm.platformtools.z.a(paramzu.GKC));
        paramArrayOfByte.sU(com.tencent.mm.platformtools.z.a(paramzu.Gbr));
        paramArrayOfByte.sV(com.tencent.mm.platformtools.z.a(paramzu.Gbs));
        paramArrayOfByte.kf(paramzu.jdc);
        paramArrayOfByte.sR(com.tencent.mm.platformtools.z.a(paramzu.GTS));
        paramArrayOfByte.sX(com.tencent.mm.platformtools.z.a(paramzu.GTU));
        paramArrayOfByte.sY(com.tencent.mm.platformtools.z.a(paramzu.GTT));
        paramArrayOfByte.kh(paramzu.GaH);
        paramz = new i();
        paramz.dDp = -1;
        paramz.username = paramArrayOfByte.field_username;
        paramz.hMW = paramzu.FVp;
        paramz.hMX = paramzu.FVo;
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramz.getUsername(), paramz.aEq(), paramz.aEr() });
        paramz.eB(true);
        if ((paramzu.GUi != 3) && (paramzu.GUi != 4)) {
          break label773;
        }
        paramArrayOfByte.ke(paramzu.GUi);
        paramz.ePj = paramzu.GUi;
      }
      for (;;)
      {
        com.tencent.mm.ak.p.aEx().b(paramz);
        ba.aBQ();
        com.tencent.mm.model.c.azp().af(paramArrayOfByte);
        paramz = ag.aFZ().DD(paramArrayOfByte.field_username);
        paramz.field_username = paramArrayOfByte.field_username;
        paramz.field_brandList = paramzu.jdm;
        paramzu = paramzu.GOb;
        if (paramzu != null)
        {
          paramz.field_brandFlag = paramzu.jdq;
          paramz.field_brandInfo = paramzu.jds;
          paramz.field_brandIconURL = paramzu.jdt;
          paramz.field_extInfo = paramzu.jdr;
          paramz.field_attrSyncVersion = null;
          ad.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", new Object[] { paramz.field_extInfo });
        }
        if (!ag.aFZ().g(paramz)) {
          ag.aFZ().f(paramz);
        }
        AppMethodBeat.o(20538);
        return;
        if (paramzu.GUi == 2)
        {
          paramArrayOfByte.ke(3);
          paramz.ePj = 3;
          paramArrayOfByte.ke(3);
          if (!u.aAm().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.ak.p.aEk();
            com.tencent.mm.ak.e.L(paramArrayOfByte.field_username, false);
            com.tencent.mm.ak.p.aEk();
            com.tencent.mm.ak.e.L(paramArrayOfByte.field_username, true);
            com.tencent.mm.ak.p.aEz().CU(paramArrayOfByte.field_username);
          }
        }
      }
      paramzu = (aty)new aty().parseFrom(paramArrayOfByte);
      switch (paramzu.GrZ)
      {
      case 2: 
      case 3: 
      default: 
        ad.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramzu.GrZ);
        AppMethodBeat.o(20538);
        return;
      case 1: 
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(17, Integer.valueOf(paramzu.xcI));
        AppMethodBeat.o(20538);
        return;
      }
      AppMethodBeat.o(20538);
      return;
      paramzu = (dln)new dln().parseFrom(paramArrayOfByte);
      if (paramzu != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bt.nullAsNil(paramzu.nDo).length() <= 0) {
          break label1039;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (am.aSN(paramzu.nDo)) {
          break label1044;
        }
        ad.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      ba.aBQ();
      paramArrayOfByte = com.tencent.mm.model.c.azp().Bf(paramzu.nDo);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.gfj == 0))
      {
        paramArrayOfByte = new am(paramzu.nDo);
        paramArrayOfByte.sR(paramzu.FVn);
        paramArrayOfByte.kh(1);
        paramArrayOfByte.acN();
        ba.aBQ();
        if (com.tencent.mm.model.c.azp().ah(paramArrayOfByte) == -1)
        {
          ad.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        paramArrayOfByte = paramArrayOfByte.field_username;
        if (paramArrayOfByte == null) {
          ad.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
      }
      for (;;)
      {
        paramArrayOfByte = new wi();
        paramArrayOfByte.dKF.opType = 1;
        paramArrayOfByte.dKF.dDy = paramzu.nDo;
        paramArrayOfByte.dKF.dDz = paramzu.HgN;
        paramArrayOfByte.dKF.dDA = paramzu.GaO;
        com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!paramArrayOfByte.endsWith("@t.qq.com"))
        {
          ad.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
        else
        {
          paramz = new i();
          paramz.username = paramArrayOfByte;
          paramz.ePj = 3;
          paramz.dDp = 3;
          com.tencent.mm.ak.p.aEx().b(paramz);
          continue;
          if (!bt.nullAsNil(paramzu.FVn).equals(bt.nullAsNil(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.sR(paramzu.FVn);
            ba.aBQ();
            if (com.tencent.mm.model.c.azp().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              ad.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
      paramzu = (cnq)new cnq().parseFrom(paramArrayOfByte);
      if (paramzu != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bt.nullAsNil(paramzu.nDo).length() <= 0) {
          break label1411;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (am.aSP(paramzu.nDo)) {
          break label1416;
        }
        ad.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      ba.aBQ();
      paramArrayOfByte = com.tencent.mm.model.c.azp().Bf(paramzu.nDo);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.gfj == 0))
      {
        paramArrayOfByte = new am(paramzu.nDo);
        paramArrayOfByte.acN();
        paramArrayOfByte.sT(paramzu.FVn);
        paramArrayOfByte.sR(paramzu.FVn);
        paramArrayOfByte.kh(4);
        ba.aBQ();
        if (com.tencent.mm.model.c.azp().ah(paramArrayOfByte) == -1)
        {
          ad.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        com.tencent.mm.ak.c.CP(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new pj();
        paramArrayOfByte.dDu.opType = 1;
        paramArrayOfByte.dDu.dDy = paramzu.nDo;
        paramArrayOfByte.dDu.dDz = paramzu.HgN;
        paramArrayOfByte.dDu.dDA = paramzu.GaO;
        com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!bt.nullAsNil(paramzu.FVn).equals(bt.nullAsNil(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.sT(paramzu.FVn);
          paramArrayOfByte.sR(paramzu.FVn);
          ba.aBQ();
          if (com.tencent.mm.model.c.azp().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            ad.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
      paramzu = (bzh)new bzh().parseFrom(paramArrayOfByte);
      if (paramzu != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bt.nullAsNil(paramzu.nDo).length() <= 0) {
          break label1956;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new am();
        paramArrayOfByte.setUsername(paramzu.nDo);
        paramArrayOfByte.setType(paramzu.nEf);
        paramArrayOfByte.kf(paramzu.jdc);
        paramArrayOfByte.tq(RegionCodeDecoder.bf(paramzu.jdl, paramzu.jdd, paramzu.jde));
        paramArrayOfByte.tk(paramzu.jdf);
        paramz = new i();
        paramz.dDp = -1;
        paramz.username = paramzu.nDo;
        paramz.hMW = paramzu.FVp;
        paramz.hMX = paramzu.FVo;
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramz.getUsername(), paramz.aEq(), paramz.aEr() });
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramzu.GUi + " hd:" + paramzu.GUj);
        if (paramzu.GUj == 0) {
          break label1961;
        }
        paramBoolean = true;
        paramz.eB(paramBoolean);
        if ((paramzu.GUi != 3) && (paramzu.GUi != 4)) {
          break label1966;
        }
        paramArrayOfByte.ke(paramzu.GUi);
        paramz.ePj = paramzu.GUi;
      }
      for (;;)
      {
        com.tencent.mm.ak.p.aEx().b(paramz);
        ba.aBQ();
        com.tencent.mm.model.c.azp().ae(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1694;
        paramBoolean = false;
        break label1882;
        if (paramzu.GUi == 2)
        {
          paramArrayOfByte.ke(3);
          paramz.ePj = 3;
          com.tencent.mm.ak.p.aEk();
          com.tencent.mm.ak.e.L(paramzu.nDo, false);
          com.tencent.mm.ak.p.aEk();
          com.tencent.mm.ak.e.L(paramzu.nDo, true);
          com.tencent.mm.ak.p.aEz().CU(paramzu.nDo);
        }
        else
        {
          paramArrayOfByte.ke(3);
          paramz.ePj = 3;
        }
      }
      paramz = (cap)new cap().parseFrom(paramArrayOfByte);
      if (paramz != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramzu = u.aAm();
        j = paramz.GVf;
        if (j != 2) {
          break label2349;
        }
        paramzu = am.aSZ(paramzu);
        ba.aBQ();
        paramArrayOfByte = (String)com.tencent.mm.model.c.ajl().get(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramz.GVi)))
        {
          com.tencent.mm.ak.p.aEk();
          com.tencent.mm.ak.e.L(paramzu, true);
          ba.aBQ();
          paramArrayOfByte = com.tencent.mm.model.c.ajl();
          if (j != 2) {
            break label2370;
          }
          i = 12553;
          paramArrayOfByte.set(i, paramz.GVi);
          paramBoolean = true;
        }
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramz.GVi, paramz.FVo, paramz.FVp });
        paramArrayOfByte = new i();
        paramArrayOfByte.username = paramzu;
        paramArrayOfByte.hMX = paramz.FVo;
        paramArrayOfByte.hMW = paramz.FVp;
        if (!bt.isNullOrNil(paramArrayOfByte.aEr()))
        {
          if (j != 1) {
            break label2378;
          }
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(59, Boolean.TRUE);
        }
      }
      for (;;)
      {
        paramArrayOfByte.eB(false);
        paramArrayOfByte.dDp = 56;
        if (!bt.isNullOrNil(paramz.GVi)) {
          paramArrayOfByte.eB(true);
        }
        com.tencent.mm.ak.p.aEx().b(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.ak.f().a(paramzu, new f.c()
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
        ba.aBQ();
        paramArrayOfByte = (String)com.tencent.mm.model.c.ajl().get(12297, null);
        break label2105;
        i = 12297;
        break label2152;
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(60, Boolean.TRUE);
      }
      paramz = (dtw)new dtw().parseFrom(paramArrayOfByte);
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s", new Object[] { Integer.valueOf(paramz.GOa.jdn), Integer.valueOf(paramz.GOa.HvJ), Integer.valueOf(paramz.GOa.HvK) });
      ba.aBQ();
      String str = (String)com.tencent.mm.model.c.ajl().get(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(20538);
        return;
      }
      if (com.tencent.mm.plugin.sns.b.o.zbT != null) {
        com.tencent.mm.plugin.sns.b.o.zbT.a(str, paramz.GOa);
      }
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", new Object[] { Integer.valueOf(paramz.HGP.HyR) });
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str, paramz.HGP);
      paramArrayOfByte = com.tencent.mm.am.g.eS(u.aAm());
      paramzu = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramzu = new com.tencent.mm.api.c();
      }
      paramzu.field_username = str;
      paramzu.field_brandList = paramz.jdm;
      if ((paramzu.Ko()) && (paramzu.bX(false) != null) && (paramzu.bX(false).KP() != null) && (!bt.isNullOrNil(paramzu.Kv())))
      {
        paramzu.field_enterpriseFather = paramzu.Kv();
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramzu.field_enterpriseFather });
      }
      if (!ag.aFZ().g(paramzu)) {
        ag.aFZ().f(paramzu);
      }
      int i = paramz.HGy;
      int j = paramz.HGz;
      int k = paramz.HGA;
      ad.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(135175, Integer.valueOf(i));
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(135176, Integer.valueOf(j));
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(135177, Integer.valueOf(k));
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(144385, Integer.valueOf(paramz.HGE));
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ivh, Integer.valueOf(paramz.Gua));
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(339975, Integer.valueOf(paramz.HGM));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramz.HGM), Integer.valueOf(paramz.Gua) });
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Itl, bt.bI(paramz.ePI, ""));
      ad.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramz.ePI });
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(147457, Long.valueOf(paramz.HGN));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", new Object[] { Long.valueOf(paramz.HGN) });
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.IJG, Integer.valueOf(paramz.Hgy));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(paramz.Hgy) });
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.IJH, paramz.HGT);
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.BindXMail:%s", new Object[] { paramz.HGT });
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.IFV, Long.valueOf(paramz.HGQ));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PaySetting:%s", new Object[] { Long.toBinaryString(paramz.HGQ) });
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.IxH, paramz.HGO);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.IGi, Integer.valueOf(paramz.HGR));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PayBindMobileTransfer:%s", new Object[] { Integer.valueOf(paramz.HGR) });
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJN, paramz.GUX);
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffix:%s", new Object[] { paramz.GUX });
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJS, Integer.valueOf(paramz.Hqw));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(paramz.Hqw) });
      com.tencent.mm.plugin.patmsg.c.eC(str, paramz.Hqw);
      paramzu = new i();
      paramzu.dDp = -1;
      paramzu.username = str;
      paramzu.hMX = paramz.FVo;
      paramzu.hMW = paramz.FVp;
      paramzu.eB(true);
      paramzu.ePj = 3;
      ad.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramzu.getUsername(), paramzu.aEq(), paramzu.aEr() });
      com.tencent.mm.ak.p.aEx().b(paramzu);
      paramzu = paramz.GUt;
      paramArrayOfByte = paramz.GUu;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(274433, paramArrayOfByte);
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(274434, paramzu);
      if (paramz.FvA != null)
      {
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(286721, paramz.FvA.FDA);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(286722, paramz.FvA.FDB);
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(286723, paramz.FvA.FDC);
      }
      if ((paramz.HGK != null) && (paramz.HGK.Hcl != null) && (paramz.HGK.Hcl.getILen() > 0))
      {
        ad.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramz.HGK.Hcl.getILen()) });
        paramzu = new xh();
        paramzu.dLE.dLF = paramz.HGK;
        com.tencent.mm.sdk.b.a.IbL.l(paramzu);
      }
      AppMethodBeat.o(20538);
      return;
      try
      {
        i = com.tencent.mm.b.o.t(paramArrayOfByte, 0);
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        AppMethodBeat.o(20538);
        return;
      }
      catch (InterruptedException paramzu)
      {
        ad.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramzu, "", new Object[0]);
        AppMethodBeat.o(20538);
        return;
      }
      paramzu = (ccf)new ccf().parseFrom(paramArrayOfByte);
      ad.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramzu.ugm), Long.valueOf(paramzu.xbt) });
      if (com.tencent.mm.model.w.zU(paramzu.ukj))
      {
        paramArrayOfByte = new sb();
        paramArrayOfByte.dGD.msgId = paramzu.xbt;
        com.tencent.mm.sdk.b.a.IbL.l(paramArrayOfByte);
      }
      AppMethodBeat.o(20538);
      return;
      paramzu = new ty();
      paramzu.dIv.data = paramArrayOfByte;
      com.tencent.mm.sdk.b.a.IbL.l(paramzu);
      AppMethodBeat.o(20538);
      return;
      paramzu = (czx)new czx().parseFrom(paramArrayOfByte);
    } while (paramzu == null);
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
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().lX(paramzu.nDo, paramzu.xbo);
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