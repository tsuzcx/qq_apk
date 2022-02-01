package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.u
{
  public static boolean a(com.tencent.mm.storage.af paramaf)
  {
    AppMethodBeat.i(20539);
    if ((paramaf == null) || (bt.isNullOrNil(paramaf.field_username)))
    {
      if (paramaf == null) {}
      for (paramaf = "-1";; paramaf = paramaf.field_username)
      {
        ad.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paramaf });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    az.arV();
    Object localObject = com.tencent.mm.model.c.apM().aId(paramaf.field_username);
    if (bt.cw((byte[])localObject))
    {
      paramaf = paramaf.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        ad.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paramaf, Integer.valueOf(i) });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    try
    {
      localObject = (bqj)new bqj().parseFrom((byte[])localObject);
      az.arV();
      com.tencent.mm.model.c.apM().aIe(paramaf.field_username);
      if (localObject == null)
      {
        ad.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        AppMethodBeat.o(20539);
        return false;
      }
    }
    catch (Exception localException)
    {
      bqj localbqj;
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localbqj = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paramaf, localbqj, false);
      AppMethodBeat.o(20539);
      return bool;
    }
  }
  
  public final void a(xd paramxd, byte[] paramArrayOfByte, boolean paramBoolean, x paramx)
  {
    AppMethodBeat.i(20538);
    switch (paramxd.CYY)
    {
    default: 
      ad.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramxd.CYY);
    }
    label301:
    label1882:
    label2152:
    do
    {
      AppMethodBeat.o(20538);
      return;
      paramxd = (bhx)new bhx().parseFrom(paramArrayOfByte);
      paramArrayOfByte = new com.tencent.mm.plugin.account.friend.a.p();
      paramArrayOfByte.username = paramxd.mAQ;
      paramArrayOfByte.ikD = paramxd.DFK;
      paramArrayOfByte.cIT = ((int)bt.aGK());
      com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(paramArrayOfByte);
      AppMethodBeat.o(20538);
      return;
      paramxd = (bqv)new bqv().parseFrom(paramArrayOfByte);
      if (1 == paramxd.DOV)
      {
        az.arV();
        paramArrayOfByte = com.tencent.mm.model.c.apU();
        paramx = z.a(paramxd.Dby);
        if (paramxd.DeleteFlag == 1)
        {
          paramBoolean = true;
          if (paramxd.DOW != 1) {
            break label301;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.e(paramx, paramBoolean, bool);
          AppMethodBeat.o(20538);
          return;
          paramBoolean = false;
          break;
        }
      }
      ad.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramxd.DOV);
      AppMethodBeat.o(20538);
      return;
      paramxd = (bqe)new bqe().parseFrom(paramArrayOfByte);
      if (paramxd != null)
      {
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramxd.Dby + " nickname:" + paramxd.DFJ);
        paramx = z.a(paramxd.Dby);
        az.arV();
        paramArrayOfByte = com.tencent.mm.model.c.apM().aHY(paramx);
        paramArrayOfByte.setUsername(paramx);
        paramArrayOfByte.nd(z.a(paramxd.DFJ));
        paramArrayOfByte.ne(z.a(paramxd.Dbb));
        paramArrayOfByte.nf(z.a(paramxd.Dbc));
        paramArrayOfByte.jJ(paramxd.ijM);
        paramArrayOfByte.nb(z.a(paramxd.DNT));
        paramArrayOfByte.nh(z.a(paramxd.DNV));
        paramArrayOfByte.ni(z.a(paramxd.DNU));
        paramArrayOfByte.jL(paramxd.Dat);
        paramx = new i();
        paramx.dtM = -1;
        paramx.username = paramArrayOfByte.field_username;
        paramx.gUf = paramxd.CVw;
        paramx.gUg = paramxd.CVv;
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramx.getUsername(), paramx.aux(), paramx.auy() });
        paramx.ee(true);
        if ((paramxd.DOj != 3) && (paramxd.DOj != 4)) {
          break label773;
        }
        paramArrayOfByte.jI(paramxd.DOj);
        paramx.evo = paramxd.DOj;
      }
      for (;;)
      {
        com.tencent.mm.ak.p.auF().b(paramx);
        az.arV();
        com.tencent.mm.model.c.apM().ae(paramArrayOfByte);
        paramx = com.tencent.mm.am.af.awe().wy(paramArrayOfByte.field_username);
        paramx.field_username = paramArrayOfByte.field_username;
        paramx.field_brandList = paramxd.ijW;
        paramxd = paramxd.DJc;
        if (paramxd != null)
        {
          paramx.field_brandFlag = paramxd.ika;
          paramx.field_brandInfo = paramxd.ikc;
          paramx.field_brandIconURL = paramxd.ikd;
          paramx.field_extInfo = paramxd.ikb;
          paramx.field_attrSyncVersion = null;
          ad.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", new Object[] { paramx.field_extInfo });
        }
        if (!com.tencent.mm.am.af.awe().g(paramx)) {
          com.tencent.mm.am.af.awe().f(paramx);
        }
        AppMethodBeat.o(20538);
        return;
        if (paramxd.DOj == 2)
        {
          paramArrayOfByte.jI(3);
          paramx.evo = 3;
          paramArrayOfByte.jI(3);
          if (!com.tencent.mm.model.u.aqG().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.ak.p.auq();
            com.tencent.mm.ak.e.K(paramArrayOfByte.field_username, false);
            com.tencent.mm.ak.p.auq();
            com.tencent.mm.ak.e.K(paramArrayOfByte.field_username, true);
            com.tencent.mm.ak.p.auH().vP(paramArrayOfByte.field_username);
          }
        }
      }
      paramxd = (amy)new amy().parseFrom(paramArrayOfByte);
      switch (paramxd.DnY)
      {
      case 2: 
      case 3: 
      default: 
        ad.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramxd.DnY);
        AppMethodBeat.o(20538);
        return;
      case 1: 
        az.arV();
        com.tencent.mm.model.c.afk().set(17, Integer.valueOf(paramxd.uMR));
        AppMethodBeat.o(20538);
        return;
      }
      AppMethodBeat.o(20538);
      return;
      paramxd = (dao)new dao().parseFrom(paramArrayOfByte);
      if (paramxd != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bt.nullAsNil(paramxd.mAQ).length() <= 0) {
          break label1039;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (com.tencent.mm.storage.af.aHE(paramxd.mAQ)) {
          break label1044;
        }
        ad.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      az.arV();
      paramArrayOfByte = com.tencent.mm.model.c.apM().aHY(paramxd.mAQ);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.fId == 0))
      {
        paramArrayOfByte = new com.tencent.mm.storage.af(paramxd.mAQ);
        paramArrayOfByte.nb(paramxd.CVu);
        paramArrayOfByte.jL(1);
        paramArrayOfByte.Zq();
        az.arV();
        if (com.tencent.mm.model.c.apM().ag(paramArrayOfByte) == -1)
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
        paramArrayOfByte = new vf();
        paramArrayOfByte.dAG.opType = 1;
        paramArrayOfByte.dAG.dtV = paramxd.mAQ;
        paramArrayOfByte.dAG.dtW = paramxd.DZN;
        paramArrayOfByte.dAG.dtX = paramxd.DaA;
        com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!paramArrayOfByte.endsWith("@t.qq.com"))
        {
          ad.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
        else
        {
          paramx = new i();
          paramx.username = paramArrayOfByte;
          paramx.evo = 3;
          paramx.dtM = 3;
          com.tencent.mm.ak.p.auF().b(paramx);
          continue;
          if (!bt.nullAsNil(paramxd.CVu).equals(bt.nullAsNil(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.nb(paramxd.CVu);
            az.arV();
            if (com.tencent.mm.model.c.apM().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              ad.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
      paramxd = (cdn)new cdn().parseFrom(paramArrayOfByte);
      if (paramxd != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bt.nullAsNil(paramxd.mAQ).length() <= 0) {
          break label1411;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (com.tencent.mm.storage.af.aHG(paramxd.mAQ)) {
          break label1416;
        }
        ad.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      az.arV();
      paramArrayOfByte = com.tencent.mm.model.c.apM().aHY(paramxd.mAQ);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.fId == 0))
      {
        paramArrayOfByte = new com.tencent.mm.storage.af(paramxd.mAQ);
        paramArrayOfByte.Zq();
        paramArrayOfByte.nd(paramxd.CVu);
        paramArrayOfByte.nb(paramxd.CVu);
        paramArrayOfByte.jL(4);
        az.arV();
        if (com.tencent.mm.model.c.apM().ag(paramArrayOfByte) == -1)
        {
          ad.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        com.tencent.mm.ak.c.vK(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new or();
        paramArrayOfByte.dtR.opType = 1;
        paramArrayOfByte.dtR.dtV = paramxd.mAQ;
        paramArrayOfByte.dtR.dtW = paramxd.DZN;
        paramArrayOfByte.dtR.dtX = paramxd.DaA;
        com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!bt.nullAsNil(paramxd.CVu).equals(bt.nullAsNil(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.nd(paramxd.CVu);
          paramArrayOfByte.nb(paramxd.CVu);
          az.arV();
          if (com.tencent.mm.model.c.apM().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            ad.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
      paramxd = (bqb)new bqb().parseFrom(paramArrayOfByte);
      if (paramxd != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bt.nullAsNil(paramxd.mAQ).length() <= 0) {
          break label1956;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new com.tencent.mm.storage.af();
        paramArrayOfByte.setUsername(paramxd.mAQ);
        paramArrayOfByte.setType(paramxd.mBH);
        paramArrayOfByte.jJ(paramxd.ijM);
        paramArrayOfByte.nA(RegionCodeDecoder.aT(paramxd.ijV, paramxd.ijN, paramxd.ijO));
        paramArrayOfByte.nu(paramxd.ijP);
        paramx = new i();
        paramx.dtM = -1;
        paramx.username = paramxd.mAQ;
        paramx.gUf = paramxd.CVw;
        paramx.gUg = paramxd.CVv;
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramx.getUsername(), paramx.aux(), paramx.auy() });
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramxd.DOj + " hd:" + paramxd.DOk);
        if (paramxd.DOk == 0) {
          break label1961;
        }
        paramBoolean = true;
        paramx.ee(paramBoolean);
        if ((paramxd.DOj != 3) && (paramxd.DOj != 4)) {
          break label1966;
        }
        paramArrayOfByte.jI(paramxd.DOj);
        paramx.evo = paramxd.DOj;
      }
      for (;;)
      {
        com.tencent.mm.ak.p.auF().b(paramx);
        az.arV();
        com.tencent.mm.model.c.apM().ad(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1694;
        paramBoolean = false;
        break label1882;
        if (paramxd.DOj == 2)
        {
          paramArrayOfByte.jI(3);
          paramx.evo = 3;
          com.tencent.mm.ak.p.auq();
          com.tencent.mm.ak.e.K(paramxd.mAQ, false);
          com.tencent.mm.ak.p.auq();
          com.tencent.mm.ak.e.K(paramxd.mAQ, true);
          com.tencent.mm.ak.p.auH().vP(paramxd.mAQ);
        }
        else
        {
          paramArrayOfByte.jI(3);
          paramx.evo = 3;
        }
      }
      paramx = (bri)new bri().parseFrom(paramArrayOfByte);
      if (paramx != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramxd = com.tencent.mm.model.u.aqG();
        j = paramx.DPf;
        if (j != 2) {
          break label2349;
        }
        paramxd = com.tencent.mm.storage.af.aHM(paramxd);
        az.arV();
        paramArrayOfByte = (String)com.tencent.mm.model.c.afk().get(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramx.DPi)))
        {
          com.tencent.mm.ak.p.auq();
          com.tencent.mm.ak.e.K(paramxd, true);
          az.arV();
          paramArrayOfByte = com.tencent.mm.model.c.afk();
          if (j != 2) {
            break label2370;
          }
          i = 12553;
          paramArrayOfByte.set(i, paramx.DPi);
          paramBoolean = true;
        }
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramx.DPi, paramx.CVv, paramx.CVw });
        paramArrayOfByte = new i();
        paramArrayOfByte.username = paramxd;
        paramArrayOfByte.gUg = paramx.CVv;
        paramArrayOfByte.gUf = paramx.CVw;
        if (!bt.isNullOrNil(paramArrayOfByte.auy()))
        {
          if (j != 1) {
            break label2378;
          }
          az.arV();
          com.tencent.mm.model.c.afk().set(59, Boolean.TRUE);
        }
      }
      for (;;)
      {
        paramArrayOfByte.ee(false);
        paramArrayOfByte.dtM = 56;
        if (!bt.isNullOrNil(paramx.DPi)) {
          paramArrayOfByte.ee(true);
        }
        com.tencent.mm.ak.p.auF().b(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.ak.f().a(paramxd, new f.c()
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
        az.arV();
        paramArrayOfByte = (String)com.tencent.mm.model.c.afk().get(12297, null);
        break label2105;
        i = 12297;
        break label2152;
        az.arV();
        com.tencent.mm.model.c.afk().set(60, Boolean.TRUE);
      }
      paramx = (diq)new diq().parseFrom(paramArrayOfByte);
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s", new Object[] { Integer.valueOf(paramx.DJb.ijX), Integer.valueOf(paramx.DJb.Eoc), Integer.valueOf(paramx.DJb.Eod) });
      az.arV();
      String str = (String)com.tencent.mm.model.c.afk().get(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(20538);
        return;
      }
      if (com.tencent.mm.plugin.sns.c.o.wzH != null) {
        com.tencent.mm.plugin.sns.c.o.wzH.a(str, paramx.DJb);
      }
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", new Object[] { Integer.valueOf(paramx.EyZ.Ere) });
      ((com.tencent.mm.plugin.story.api.e)g.ad(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str, paramx.EyZ);
      paramArrayOfByte = com.tencent.mm.am.f.ei(com.tencent.mm.model.u.aqG());
      paramxd = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramxd = new com.tencent.mm.api.c();
      }
      paramxd.field_username = str;
      paramxd.field_brandList = paramx.ijW;
      if ((paramxd.Jf()) && (paramxd.bU(false) != null) && (paramxd.bU(false).JH() != null) && (!bt.isNullOrNil(paramxd.Jm())))
      {
        paramxd.field_enterpriseFather = paramxd.Jm();
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramxd.field_enterpriseFather });
      }
      if (!com.tencent.mm.am.af.awe().g(paramxd)) {
        com.tencent.mm.am.af.awe().f(paramxd);
      }
      int i = paramx.EyI;
      int j = paramx.EyJ;
      int k = paramx.EyK;
      ad.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      az.arV();
      com.tencent.mm.model.c.afk().set(135175, Integer.valueOf(i));
      az.arV();
      com.tencent.mm.model.c.afk().set(135176, Integer.valueOf(j));
      az.arV();
      com.tencent.mm.model.c.afk().set(135177, Integer.valueOf(k));
      az.arV();
      com.tencent.mm.model.c.afk().set(144385, Integer.valueOf(paramx.EyO));
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fla, Integer.valueOf(paramx.DpU));
      az.arV();
      com.tencent.mm.model.c.afk().set(339975, Integer.valueOf(paramx.EyW));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramx.EyW), Integer.valueOf(paramx.DpU) });
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fje, bt.by(paramx.evN, ""));
      ad.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramx.evN });
      az.arV();
      com.tencent.mm.model.c.afk().set(147457, Long.valueOf(paramx.EyX));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", new Object[] { Long.valueOf(paramx.EyX) });
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.Fvw, Long.valueOf(paramx.Eza));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PaySetting:%s", new Object[] { Long.toBinaryString(paramx.Eza) });
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FnA, paramx.EyY);
      az.arV();
      com.tencent.mm.model.c.afk().set(ae.a.FvJ, Integer.valueOf(paramx.Ezb));
      ad.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PayBindMobileTransfer:%s", new Object[] { Integer.valueOf(paramx.Ezb) });
      paramxd = new i();
      paramxd.dtM = -1;
      paramxd.username = str;
      paramxd.gUg = paramx.CVv;
      paramxd.gUf = paramx.CVw;
      paramxd.ee(true);
      paramxd.evo = 3;
      ad.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramxd.getUsername(), paramxd.aux(), paramxd.auy() });
      com.tencent.mm.ak.p.auF().b(paramxd);
      paramxd = paramx.DOu;
      paramArrayOfByte = paramx.DOv;
      az.arV();
      com.tencent.mm.model.c.afk().set(274433, paramArrayOfByte);
      az.arV();
      com.tencent.mm.model.c.afk().set(274434, paramxd);
      if (paramx.CxP != null)
      {
        az.arV();
        com.tencent.mm.model.c.afk().set(286721, paramx.CxP.CFE);
        az.arV();
        com.tencent.mm.model.c.afk().set(286722, paramx.CxP.CFF);
        az.arV();
        com.tencent.mm.model.c.afk().set(286723, paramx.CxP.CFG);
      }
      if ((paramx.EyU != null) && (paramx.EyU.DVr != null) && (paramx.EyU.DVr.getILen() > 0))
      {
        ad.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramx.EyU.DVr.getILen()) });
        paramxd = new wd();
        paramxd.dBE.dBF = paramx.EyU;
        com.tencent.mm.sdk.b.a.ESL.l(paramxd);
      }
      AppMethodBeat.o(20538);
      return;
      try
      {
        i = com.tencent.mm.b.o.v(paramArrayOfByte, 0);
        ad.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        AppMethodBeat.o(20538);
        return;
      }
      catch (InterruptedException paramxd)
      {
        ad.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramxd, "", new Object[0]);
        AppMethodBeat.o(20538);
        return;
      }
      paramxd = (bsx)new bsx().parseFrom(paramArrayOfByte);
      ad.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramxd.saz), Long.valueOf(paramxd.uKZ) });
      if (w.sU(paramxd.sdQ))
      {
        paramArrayOfByte = new rg();
        paramArrayOfByte.dwP.msgId = paramxd.uKZ;
        com.tencent.mm.sdk.b.a.ESL.l(paramArrayOfByte);
      }
      AppMethodBeat.o(20538);
      return;
      paramxd = new sx();
      paramxd.dyz.data = paramArrayOfByte;
      com.tencent.mm.sdk.b.a.ESL.l(paramxd);
      AppMethodBeat.o(20538);
      return;
      paramxd = (cpg)new cpg().parseFrom(paramArrayOfByte);
    } while (paramxd == null);
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
    ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().lc(paramxd.mAQ, paramxd.Ddo);
    label1411:
    label1416:
    label2349:
    AppMethodBeat.o(20538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.a
 * JD-Core Version:    0.7.0.1
 */