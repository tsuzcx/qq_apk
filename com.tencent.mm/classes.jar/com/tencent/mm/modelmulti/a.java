package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.po;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bep;
import com.tencent.mm.protocal.protobuf.bfw;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.r
{
  public static boolean a(ad paramad)
  {
    AppMethodBeat.i(16493);
    if ((paramad == null) || (bo.isNullOrNil(paramad.field_username)))
    {
      if (paramad == null) {}
      for (paramad = "-1";; paramad = paramad.field_username)
      {
        ab.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paramad });
        AppMethodBeat.o(16493);
        return false;
      }
    }
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YA().arA(paramad.field_username);
    if (bo.ce((byte[])localObject))
    {
      paramad = paramad.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        ab.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paramad, Integer.valueOf(i) });
        AppMethodBeat.o(16493);
        return false;
      }
    }
    try
    {
      localObject = (bdt)new bdt().parseFrom((byte[])localObject);
      aw.aaz();
      com.tencent.mm.model.c.YA().arB(paramad.field_username);
      if (localObject == null)
      {
        ab.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        AppMethodBeat.o(16493);
        return false;
      }
    }
    catch (Exception localException)
    {
      bdt localbdt;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localbdt = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paramad, localbdt, false);
      AppMethodBeat.o(16493);
      return bool;
    }
  }
  
  public final void a(ud paramud, byte[] paramArrayOfByte, boolean paramBoolean, u paramu)
  {
    AppMethodBeat.i(16492);
    label293:
    label759:
    label1023:
    int j;
    label1028:
    label1395:
    label1400:
    int i;
    switch (paramud.wMC)
    {
    default: 
      ab.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramud.wMC);
      AppMethodBeat.o(16492);
      return;
    case 22: 
      paramud = (aws)new aws().parseFrom(paramArrayOfByte);
      paramArrayOfByte = new p();
      paramArrayOfByte.username = paramud.jJA;
      paramArrayOfByte.gxG = paramud.xmj;
      paramArrayOfByte.fvK = ((int)bo.aox());
      com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(paramArrayOfByte);
      AppMethodBeat.o(16492);
      return;
    case 13: 
      paramud = (bed)new bed().parseFrom(paramArrayOfByte);
      if (1 == paramud.xtS)
      {
        aw.aaz();
        paramArrayOfByte = com.tencent.mm.model.c.YI();
        paramu = aa.a(paramud.wOT);
        if (paramud.DeleteFlag == 1)
        {
          paramBoolean = true;
          if (paramud.xtT != 1) {
            break label293;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.f(paramu, paramBoolean, bool);
          AppMethodBeat.o(16492);
          return;
          paramBoolean = false;
          break;
        }
      }
      ab.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramud.xtS);
      AppMethodBeat.o(16492);
      return;
    case 15: 
      paramud = (bdo)new bdo().parseFrom(paramArrayOfByte);
      if (paramud != null)
      {
        ab.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramud.wOT + " nickname:" + paramud.xmi);
        paramu = aa.a(paramud.wOT);
        aw.aaz();
        paramArrayOfByte = com.tencent.mm.model.c.YA().arw(paramu);
        paramArrayOfByte.setUsername(paramu);
        paramArrayOfByte.jp(aa.a(paramud.xmi));
        paramArrayOfByte.jq(aa.a(paramud.wOv));
        paramArrayOfByte.jr(aa.a(paramud.wOw));
        paramArrayOfByte.hy(paramud.gwP);
        paramArrayOfByte.jn(aa.a(paramud.xsT));
        paramArrayOfByte.jt(aa.a(paramud.xsV));
        paramArrayOfByte.ju(aa.a(paramud.xsU));
        paramArrayOfByte.hA(paramud.wNQ);
        paramu = new h();
        paramu.bsY = -1;
        paramu.username = paramArrayOfByte.field_username;
        paramu.fsk = paramud.wJr;
        paramu.fsl = paramud.wJq;
        ab.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramu.getUsername(), paramu.acX(), paramu.acY() });
        paramu.cM(true);
        if ((paramud.xtk != 3) && (paramud.xtk != 4)) {
          break label759;
        }
        paramArrayOfByte.hx(paramud.xtk);
        paramu.dqB = paramud.xtk;
      }
      for (;;)
      {
        com.tencent.mm.ah.o.adg().b(paramu);
        aw.aaz();
        com.tencent.mm.model.c.YA().X(paramArrayOfByte);
        paramu = com.tencent.mm.aj.z.afi().rK(paramArrayOfByte.field_username);
        paramu.field_username = paramArrayOfByte.field_username;
        paramu.field_brandList = paramud.gwZ;
        paramud = paramud.xpl;
        if (paramud != null)
        {
          paramu.field_brandFlag = paramud.gxd;
          paramu.field_brandInfo = paramud.gxf;
          paramu.field_brandIconURL = paramud.gxg;
          paramu.field_extInfo = paramud.gxe;
          ab.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", new Object[] { paramu.field_extInfo });
        }
        if (!com.tencent.mm.aj.z.afi().e(paramu)) {
          com.tencent.mm.aj.z.afi().d(paramu);
        }
        AppMethodBeat.o(16492);
        return;
        if (paramud.xtk == 2)
        {
          paramArrayOfByte.hx(3);
          paramu.dqB = 3;
          paramArrayOfByte.hx(3);
          if (!com.tencent.mm.model.r.Zn().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.ah.o.acQ();
            com.tencent.mm.ah.d.F(paramArrayOfByte.field_username, false);
            com.tencent.mm.ah.o.acQ();
            com.tencent.mm.ah.d.F(paramArrayOfByte.field_username, true);
            com.tencent.mm.ah.o.adi().qU(paramArrayOfByte.field_username);
          }
        }
      }
    case 23: 
      paramud = (aek)new aek().parseFrom(paramArrayOfByte);
      switch (paramud.wXn)
      {
      case 2: 
      case 3: 
      default: 
        ab.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramud.wXn);
        AppMethodBeat.o(16492);
        return;
      case 1: 
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(17, Integer.valueOf(paramud.pKC));
        AppMethodBeat.o(16492);
        return;
      }
      AppMethodBeat.o(16492);
      return;
    case 25: 
      paramud = (cjd)new cjd().parseFrom(paramArrayOfByte);
      if (paramud != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bo.nullAsNil(paramud.jJA).length() <= 0) {
          break label1023;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (ad.arc(paramud.jJA)) {
          break label1028;
        }
        ab.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        AppMethodBeat.o(16492);
        return;
        paramBoolean = false;
        break;
      }
      aw.aaz();
      paramArrayOfByte = com.tencent.mm.model.c.YA().arw(paramud.jJA);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.euF == 0))
      {
        paramArrayOfByte = new ad(paramud.jJA);
        paramArrayOfByte.jn(paramud.wJp);
        paramArrayOfByte.hA(1);
        paramArrayOfByte.ND();
        aw.aaz();
        if (com.tencent.mm.model.c.YA().Z(paramArrayOfByte) == -1)
        {
          ab.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
          AppMethodBeat.o(16492);
          return;
        }
        paramArrayOfByte = paramArrayOfByte.field_username;
        if (paramArrayOfByte == null) {
          ab.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
      }
      for (;;)
      {
        paramArrayOfByte = new ti();
        paramArrayOfByte.cJM.opType = 1;
        paramArrayOfByte.cJM.cDt = paramud.jJA;
        paramArrayOfByte.cJM.cDu = paramud.xDb;
        paramArrayOfByte.cJM.cDv = paramud.wNX;
        com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte);
        AppMethodBeat.o(16492);
        return;
        if (!paramArrayOfByte.endsWith("@t.qq.com"))
        {
          ab.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
        else
        {
          paramu = new h();
          paramu.username = paramArrayOfByte;
          paramu.dqB = 3;
          paramu.bsY = 3;
          com.tencent.mm.ah.o.adg().b(paramu);
          continue;
          if (!bo.nullAsNil(paramud.wJp).equals(bo.nullAsNil(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.jn(paramud.wJp);
            aw.aaz();
            if (com.tencent.mm.model.c.YA().b(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              ab.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
    case 24: 
      paramud = (boy)new boy().parseFrom(paramArrayOfByte);
      if (paramud != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bo.nullAsNil(paramud.jJA).length() <= 0) {
          break label1395;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (ad.are(paramud.jJA)) {
          break label1400;
        }
        ab.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        AppMethodBeat.o(16492);
        return;
        paramBoolean = false;
        break;
      }
      aw.aaz();
      paramArrayOfByte = com.tencent.mm.model.c.YA().arw(paramud.jJA);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.euF == 0))
      {
        paramArrayOfByte = new ad(paramud.jJA);
        paramArrayOfByte.ND();
        paramArrayOfByte.jp(paramud.wJp);
        paramArrayOfByte.jn(paramud.wJp);
        paramArrayOfByte.hA(4);
        aw.aaz();
        if (com.tencent.mm.model.c.YA().Z(paramArrayOfByte) == -1)
        {
          ab.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          AppMethodBeat.o(16492);
          return;
        }
        b.qQ(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new ne();
        paramArrayOfByte.cDp.opType = 1;
        paramArrayOfByte.cDp.cDt = paramud.jJA;
        paramArrayOfByte.cDp.cDu = paramud.xDb;
        paramArrayOfByte.cDp.cDv = paramud.wNX;
        com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte);
        AppMethodBeat.o(16492);
        return;
        if (!bo.nullAsNil(paramud.wJp).equals(bo.nullAsNil(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.jp(paramud.wJp);
          paramArrayOfByte.jn(paramud.wJp);
          aw.aaz();
          if (com.tencent.mm.model.c.YA().b(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            ab.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
    case 33: 
      paramud = (bdl)new bdl().parseFrom(paramArrayOfByte);
      if (paramud != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (bo.nullAsNil(paramud.jJA).length() <= 0) {
          break label1940;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new ad();
        paramArrayOfByte.setUsername(paramud.jJA);
        paramArrayOfByte.setType(paramud.jKs);
        paramArrayOfByte.hy(paramud.gwP);
        paramArrayOfByte.jL(RegionCodeDecoder.aF(paramud.gwY, paramud.gwQ, paramud.gwR));
        paramArrayOfByte.jF(paramud.gwS);
        paramu = new h();
        paramu.bsY = -1;
        paramu.username = paramud.jJA;
        paramu.fsk = paramud.wJr;
        paramu.fsl = paramud.wJq;
        ab.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramu.getUsername(), paramu.acX(), paramu.acY() });
        ab.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramud.xtk + " hd:" + paramud.xtl);
        if (paramud.xtl == 0) {
          break label1945;
        }
        paramBoolean = true;
        paramu.cM(paramBoolean);
        if ((paramud.xtk != 3) && (paramud.xtk != 4)) {
          break label1950;
        }
        paramArrayOfByte.hx(paramud.xtk);
        paramu.dqB = paramud.xtk;
      }
      for (;;)
      {
        com.tencent.mm.ah.o.adg().b(paramu);
        aw.aaz();
        com.tencent.mm.model.c.YA().W(paramArrayOfByte);
        AppMethodBeat.o(16492);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1678;
        paramBoolean = false;
        break label1866;
        if (paramud.xtk == 2)
        {
          paramArrayOfByte.hx(3);
          paramu.dqB = 3;
          com.tencent.mm.ah.o.acQ();
          com.tencent.mm.ah.d.F(paramud.jJA, false);
          com.tencent.mm.ah.o.acQ();
          com.tencent.mm.ah.d.F(paramud.jJA, true);
          com.tencent.mm.ah.o.adi().qU(paramud.jJA);
        }
        else
        {
          paramArrayOfByte.hx(3);
          paramu.dqB = 3;
        }
      }
    case 35: 
      paramu = (bep)new bep().parseFrom(paramArrayOfByte);
      if (paramu != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramud = com.tencent.mm.model.r.Zn();
        j = paramu.wzY;
        if (j != 2) {
          break label2333;
        }
        paramud = ad.ark(paramud);
        aw.aaz();
        paramArrayOfByte = (String)com.tencent.mm.model.c.Ru().get(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramu.xuf)))
        {
          com.tencent.mm.ah.o.acQ();
          com.tencent.mm.ah.d.F(paramud, true);
          aw.aaz();
          paramArrayOfByte = com.tencent.mm.model.c.Ru();
          if (j != 2) {
            break label2354;
          }
          i = 12553;
          paramArrayOfByte.set(i, paramu.xuf);
          paramBoolean = true;
        }
        ab.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramu.xuf, paramu.wJq, paramu.wJr });
        paramArrayOfByte = new h();
        paramArrayOfByte.username = paramud;
        paramArrayOfByte.fsl = paramu.wJq;
        paramArrayOfByte.fsk = paramu.wJr;
        if (!bo.isNullOrNil(paramArrayOfByte.acY()))
        {
          if (j != 1) {
            break label2362;
          }
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(59, Boolean.TRUE);
        }
      }
      for (;;)
      {
        paramArrayOfByte.cM(false);
        paramArrayOfByte.bsY = 56;
        if (!bo.isNullOrNil(paramu.xuf)) {
          paramArrayOfByte.cM(true);
        }
        com.tencent.mm.ah.o.adg().b(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.ah.e().a(paramud, new a.1(this));
        }
        AppMethodBeat.o(16492);
        return;
        paramBoolean = false;
        break;
        aw.aaz();
        paramArrayOfByte = (String)com.tencent.mm.model.c.Ru().get(12297, null);
        break label2089;
        i = 12297;
        break label2136;
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(60, Boolean.TRUE);
      }
    case 44: 
      paramu = (cph)new cph().parseFrom(paramArrayOfByte);
      ab.i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s", new Object[] { Integer.valueOf(paramu.xpk.gxa), Integer.valueOf(paramu.xpk.xPN), Integer.valueOf(paramu.xpk.xPO) });
      aw.aaz();
      String str = (String)com.tencent.mm.model.c.Ru().get(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(16492);
        return;
      }
      if (n.raR != null) {
        n.raR.a(str, paramu.xpk);
      }
      ab.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", new Object[] { Integer.valueOf(paramu.xYs.xSO) });
      ((com.tencent.mm.plugin.story.api.e)g.G(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str, paramu.xYs);
      paramArrayOfByte = f.rS(com.tencent.mm.model.r.Zn());
      paramud = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramud = new com.tencent.mm.aj.d();
      }
      paramud.field_username = str;
      paramud.field_brandList = paramu.gwZ;
      if ((paramud.aeh()) && (paramud.cU(false) != null) && (paramud.cU(false).aeI() != null) && (!bo.isNullOrNil(paramud.aeo())))
      {
        paramud.field_enterpriseFather = paramud.aeo();
        ab.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramud.field_enterpriseFather });
      }
      if (!com.tencent.mm.aj.z.afi().e(paramud)) {
        com.tencent.mm.aj.z.afi().d(paramud);
      }
      i = paramu.xYb;
      j = paramu.xYc;
      int k = paramu.xYd;
      ab.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(135175, Integer.valueOf(i));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(135176, Integer.valueOf(j));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(135177, Integer.valueOf(k));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(144385, Integer.valueOf(paramu.xYh));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yCE, Integer.valueOf(paramu.wYk));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(339975, Integer.valueOf(paramu.xYp));
      ab.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramu.xYp), Integer.valueOf(paramu.wYk) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yAI, bo.bf(paramu.dqY, ""));
      ab.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramu.dqY });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(147457, Long.valueOf(paramu.xYq));
      ab.d("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", new Object[] { Long.valueOf(paramu.xYq) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yLV, Long.valueOf(paramu.xYt));
      ab.d("MicroMsg.BigBallOfMudSyncExtension", "justin userinfoExt.PaySetting:%s", new Object[] { Long.toBinaryString(paramu.xYt) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yET, paramu.xYr);
      paramud = new h();
      paramud.bsY = -1;
      paramud.username = str;
      paramud.fsl = paramu.wJq;
      paramud.fsk = paramu.wJr;
      paramud.cM(true);
      paramud.dqB = 3;
      ab.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramud.getUsername(), paramud.acX(), paramud.acY() });
      com.tencent.mm.ah.o.adg().b(paramud);
      paramud = paramu.xtv;
      paramArrayOfByte = paramu.xtw;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(274433, paramArrayOfByte);
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(274434, paramud);
      if (paramu.wpi != null)
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(286721, paramu.wpi.wvz);
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(286722, paramu.wpi.wvA);
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(286723, paramu.wpi.wvB);
      }
      if ((paramu.xYn != null) && (paramu.xYn.xzk != null) && (paramu.xYn.xzk.getILen() > 0))
      {
        ab.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramu.xYn.xzk.getILen()) });
        paramud = new ue();
        paramud.cKH.cKI = paramu.xYn;
        com.tencent.mm.sdk.b.a.ymk.l(paramud);
      }
      AppMethodBeat.o(16492);
      return;
    case 999999: 
      try
      {
        i = com.tencent.mm.a.o.r(paramArrayOfByte, 0);
        ab.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        AppMethodBeat.o(16492);
        return;
      }
      catch (InterruptedException paramud)
      {
        ab.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramud, "", new Object[0]);
        AppMethodBeat.o(16492);
        return;
      }
    case 53: 
      label1678:
      label1866:
      label2136:
      paramud = (bfw)new bfw().parseFrom(paramArrayOfByte);
      label1940:
      label1945:
      label1950:
      label2089:
      label2354:
      label2362:
      ab.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramud.nqW), Long.valueOf(paramud.pIG) });
      label2333:
      if (t.ok(paramud.num))
      {
        paramArrayOfByte = new po();
        paramArrayOfByte.cGe.cpO = paramud.pIG;
        com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfByte);
      }
      AppMethodBeat.o(16492);
      return;
    }
    paramud = new re();
    paramud.cHK.data = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.ymk.l(paramud);
    AppMethodBeat.o(16492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelmulti.a
 * JD-Core Version:    0.7.0.1
 */