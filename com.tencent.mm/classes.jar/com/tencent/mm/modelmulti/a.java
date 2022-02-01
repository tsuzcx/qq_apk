package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.ao.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.b.o;
import com.tencent.mm.f.a.ra;
import com.tencent.mm.f.a.tz;
import com.tencent.mm.f.a.wb;
import com.tencent.mm.f.a.ys;
import com.tencent.mm.f.a.zt;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cs;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.protocal.protobuf.czc;
import com.tencent.mm.protocal.protobuf.dce;
import com.tencent.mm.protocal.protobuf.diz;
import com.tencent.mm.protocal.protobuf.dqd;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.edx;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.protocal.protobuf.eqa;
import com.tencent.mm.protocal.protobuf.eza;
import com.tencent.mm.protocal.protobuf.fqg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.ab
{
  public static boolean a(as paramas)
  {
    AppMethodBeat.i(20539);
    if ((paramas == null) || (Util.isNullOrNil(paramas.field_username)))
    {
      if (paramas == null) {}
      for (paramas = "-1";; paramas = paramas.field_username)
      {
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paramas });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    bh.beI();
    Object localObject = com.tencent.mm.model.c.bbL().bwn(paramas.field_username);
    if (Util.isNullOrNil((byte[])localObject))
    {
      paramas = paramas.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paramas, Integer.valueOf(i) });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    try
    {
      localObject = (cyb)new cyb().parseFrom((byte[])localObject);
      bh.beI();
      com.tencent.mm.model.c.bbL().bwo(paramas.field_username);
      if (localObject == null)
      {
        Log.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        AppMethodBeat.o(20539);
        return false;
      }
    }
    catch (Exception localException)
    {
      cyb localcyb;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localcyb = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paramas, localcyb, false);
      AppMethodBeat.o(20539);
      return bool;
    }
  }
  
  public final void a(abu paramabu, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(20538);
    switch (paramabu.SnG)
    {
    default: 
      Log.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramabu.SnG);
    }
    label301:
    label1882:
    label2152:
    label4208:
    do
    {
      AppMethodBeat.o(20538);
      return;
      paramabu = (cmg)new cmg().parseFrom(paramArrayOfByte);
      paramArrayOfByte = new com.tencent.mm.plugin.account.friend.a.p();
      paramArrayOfByte.username = paramabu.UserName;
      paramArrayOfByte.mWp = paramabu.TtY;
      paramArrayOfByte.eZP = ((int)Util.nowSecond());
      com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().b(paramArrayOfByte);
      AppMethodBeat.o(20538);
      return;
      paramabu = (cyo)new cyo().parseFrom(paramArrayOfByte);
      if (1 == paramabu.TGO)
      {
        bh.beI();
        paramArrayOfByte = com.tencent.mm.model.c.bbU();
        paramae = com.tencent.mm.platformtools.z.a(paramabu.SrH);
        if (paramabu.DeleteFlag == 1)
        {
          paramBoolean = true;
          if (paramabu.TGP != 1) {
            break label301;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.i(paramae, paramBoolean, bool);
          AppMethodBeat.o(20538);
          return;
          paramBoolean = false;
          break;
        }
      }
      Log.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramabu.TGO);
      AppMethodBeat.o(20538);
      return;
      paramabu = (cxw)new cxw().parseFrom(paramArrayOfByte);
      if (paramabu != null)
      {
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramabu.SrH + " nickname:" + paramabu.TtX);
        paramae = com.tencent.mm.platformtools.z.a(paramabu.SrH);
        bh.beI();
        paramArrayOfByte = com.tencent.mm.model.c.bbL().RG(paramae);
        paramArrayOfByte.setUsername(paramae);
        paramArrayOfByte.setNickname(com.tencent.mm.platformtools.z.a(paramabu.TtX));
        paramArrayOfByte.It(com.tencent.mm.platformtools.z.a(paramabu.SqW));
        paramArrayOfByte.Iu(com.tencent.mm.platformtools.z.a(paramabu.SqX));
        paramArrayOfByte.pw(paramabu.mVy);
        paramArrayOfByte.Ir(com.tencent.mm.platformtools.z.a(paramabu.TFz));
        paramArrayOfByte.Iw(com.tencent.mm.platformtools.z.a(paramabu.TFB));
        paramArrayOfByte.Ix(com.tencent.mm.platformtools.z.a(paramabu.TFA));
        paramArrayOfByte.pz(paramabu.Sqi);
        paramae = new j();
        paramae.cUP = -1;
        paramae.username = paramArrayOfByte.field_username;
        paramae.lBd = paramabu.SjJ;
        paramae.lBe = paramabu.SjI;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramae.getUsername(), paramae.bhH(), paramae.bhI() });
        paramae.gg(true);
        if ((paramabu.TGb != 3) && (paramabu.TGb != 4)) {
          break label773;
        }
        paramArrayOfByte.pv(paramabu.TGb);
        paramae.hDc = paramabu.TGb;
      }
      for (;;)
      {
        com.tencent.mm.am.q.bhP().b(paramae);
        bh.beI();
        com.tencent.mm.model.c.bbL().au(paramArrayOfByte);
        paramae = af.bjv().Uo(paramArrayOfByte.field_username);
        paramae.field_username = paramArrayOfByte.field_username;
        paramae.field_brandList = paramabu.mVI;
        paramabu = paramabu.TxM;
        if (paramabu != null)
        {
          paramae.field_brandFlag = paramabu.mVM;
          paramae.field_brandInfo = paramabu.mVO;
          paramae.field_brandIconURL = paramabu.mVP;
          paramae.field_extInfo = paramabu.mVN;
          paramae.field_attrSyncVersion = null;
          Log.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", new Object[] { paramae.field_extInfo });
        }
        if (!af.bjv().h(paramae)) {
          af.bjv().g(paramae);
        }
        AppMethodBeat.o(20538);
        return;
        if (paramabu.TGb == 2)
        {
          paramArrayOfByte.pv(3);
          paramae.hDc = 3;
          paramArrayOfByte.pv(3);
          if (!com.tencent.mm.model.z.bcZ().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.am.q.bhz();
            com.tencent.mm.am.f.P(paramArrayOfByte.field_username, false);
            com.tencent.mm.am.q.bhz();
            com.tencent.mm.am.f.P(paramArrayOfByte.field_username, true);
            com.tencent.mm.am.q.bhR().TB(paramArrayOfByte.field_username);
          }
        }
      }
      paramabu = (bmy)new bmy().parseFrom(paramArrayOfByte);
      switch (paramabu.SXP)
      {
      case 2: 
      case 3: 
      default: 
        Log.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramabu.SXP);
        AppMethodBeat.o(20538);
        return;
      case 1: 
        bh.beI();
        com.tencent.mm.model.c.aHp().i(17, Integer.valueOf(paramabu.HmX));
        AppMethodBeat.o(20538);
        return;
      }
      AppMethodBeat.o(20538);
      return;
      paramabu = (eqa)new eqa().parseFrom(paramArrayOfByte);
      if (paramabu != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramabu.UserName).length() <= 0) {
          break label1039;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (as.bvH(paramabu.UserName)) {
          break label1044;
        }
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      bh.beI();
      paramArrayOfByte = com.tencent.mm.model.c.bbL().RG(paramabu.UserName);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.jxt == 0))
      {
        paramArrayOfByte = new as(paramabu.UserName);
        paramArrayOfByte.Ir(paramabu.SjH);
        paramArrayOfByte.pz(1);
        paramArrayOfByte.axu();
        bh.beI();
        if (com.tencent.mm.model.c.bbL().aw(paramArrayOfByte) == -1)
        {
          Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        paramArrayOfByte = paramArrayOfByte.field_username;
        if (paramArrayOfByte == null) {
          Log.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
      }
      for (;;)
      {
        paramArrayOfByte = new ys();
        paramArrayOfByte.fXS.opType = 1;
        paramArrayOfByte.fXS.fPV = paramabu.UserName;
        paramArrayOfByte.fXS.fPW = paramabu.TWT;
        paramArrayOfByte.fXS.fPX = paramabu.Sqp;
        EventCenter.instance.publish(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!paramArrayOfByte.endsWith("@t.qq.com"))
        {
          Log.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
        else
        {
          paramae = new j();
          paramae.username = paramArrayOfByte;
          paramae.hDc = 3;
          paramae.cUP = 3;
          com.tencent.mm.am.q.bhP().b(paramae);
          continue;
          if (!Util.nullAsNil(paramabu.SjH).equals(Util.nullAsNil(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.Ir(paramabu.SjH);
            bh.beI();
            if (com.tencent.mm.model.c.bbL().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
      paramabu = (dqd)new dqd().parseFrom(paramArrayOfByte);
      if (paramabu != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramabu.UserName).length() <= 0) {
          break label1411;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (as.bvJ(paramabu.UserName)) {
          break label1416;
        }
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      bh.beI();
      paramArrayOfByte = com.tencent.mm.model.c.bbL().RG(paramabu.UserName);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.jxt == 0))
      {
        paramArrayOfByte = new as(paramabu.UserName);
        paramArrayOfByte.axu();
        paramArrayOfByte.setNickname(paramabu.SjH);
        paramArrayOfByte.Ir(paramabu.SjH);
        paramArrayOfByte.pz(4);
        bh.beI();
        if (com.tencent.mm.model.c.bbL().aw(paramArrayOfByte) == -1)
        {
          Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        com.tencent.mm.am.d.Tw(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new ra();
        paramArrayOfByte.fPR.opType = 1;
        paramArrayOfByte.fPR.fPV = paramabu.UserName;
        paramArrayOfByte.fPR.fPW = paramabu.TWT;
        paramArrayOfByte.fPR.fPX = paramabu.Sqp;
        EventCenter.instance.publish(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!Util.nullAsNil(paramabu.SjH).equals(Util.nullAsNil(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.setNickname(paramabu.SjH);
          paramArrayOfByte.Ir(paramabu.SjH);
          bh.beI();
          if (com.tencent.mm.model.c.bbL().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
      paramabu = (cxt)new cxt().parseFrom(paramArrayOfByte);
      if (paramabu != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramabu.UserName).length() <= 0) {
          break label1956;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new as();
        paramArrayOfByte.setUsername(paramabu.UserName);
        paramArrayOfByte.setType(paramabu.rWu);
        paramArrayOfByte.pw(paramabu.mVy);
        paramArrayOfByte.IP(RegionCodeDecoder.bl(paramabu.mVH, paramabu.mVz, paramabu.mVA));
        paramArrayOfByte.IJ(paramabu.mVB);
        paramae = new j();
        paramae.cUP = -1;
        paramae.username = paramabu.UserName;
        paramae.lBd = paramabu.SjJ;
        paramae.lBe = paramabu.SjI;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramae.getUsername(), paramae.bhH(), paramae.bhI() });
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramabu.TGb + " hd:" + paramabu.TGc);
        if (paramabu.TGc == 0) {
          break label1961;
        }
        paramBoolean = true;
        paramae.gg(paramBoolean);
        if ((paramabu.TGb != 3) && (paramabu.TGb != 4)) {
          break label1966;
        }
        paramArrayOfByte.pv(paramabu.TGb);
        paramae.hDc = paramabu.TGb;
      }
      for (;;)
      {
        com.tencent.mm.am.q.bhP().b(paramae);
        bh.beI();
        com.tencent.mm.model.c.bbL().at(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1694;
        paramBoolean = false;
        break label1882;
        if (paramabu.TGb == 2)
        {
          paramArrayOfByte.pv(3);
          paramae.hDc = 3;
          com.tencent.mm.am.q.bhz();
          com.tencent.mm.am.f.P(paramabu.UserName, false);
          com.tencent.mm.am.q.bhz();
          com.tencent.mm.am.f.P(paramabu.UserName, true);
          com.tencent.mm.am.q.bhR().TB(paramabu.UserName);
        }
        else
        {
          paramArrayOfByte.pv(3);
          paramae.hDc = 3;
        }
      }
      paramae = (czc)new czc().parseFrom(paramArrayOfByte);
      if (paramae != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramabu = com.tencent.mm.model.z.bcZ();
        j = paramae.TGZ;
        if (j != 2) {
          break label2349;
        }
        paramabu = as.bvW(paramabu);
        bh.beI();
        paramArrayOfByte = (String)com.tencent.mm.model.c.aHp().b(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramae.THc)))
        {
          com.tencent.mm.am.q.bhz();
          com.tencent.mm.am.f.P(paramabu, true);
          bh.beI();
          paramArrayOfByte = com.tencent.mm.model.c.aHp();
          if (j != 2) {
            break label2370;
          }
          i = 12553;
          paramArrayOfByte.i(i, paramae.THc);
          paramBoolean = true;
        }
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramae.THc, paramae.SjI, paramae.SjJ });
        paramArrayOfByte = new j();
        paramArrayOfByte.username = paramabu;
        paramArrayOfByte.lBe = paramae.SjI;
        paramArrayOfByte.lBd = paramae.SjJ;
        if (!Util.isNullOrNil(paramArrayOfByte.bhI()))
        {
          if (j != 1) {
            break label2378;
          }
          bh.beI();
          com.tencent.mm.model.c.aHp().i(59, Boolean.TRUE);
        }
      }
      for (;;)
      {
        paramArrayOfByte.gg(false);
        paramArrayOfByte.cUP = 56;
        if (!Util.isNullOrNil(paramae.THc)) {
          paramArrayOfByte.gg(true);
        }
        com.tencent.mm.am.q.bhP().b(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.am.g().a(paramabu, new g.c()
          {
            public final int dL(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              return 0;
            }
          });
        }
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        bh.beI();
        paramArrayOfByte = (String)com.tencent.mm.model.c.aHp().b(12297, null);
        break label2105;
        i = 12297;
        break label2152;
        bh.beI();
        com.tencent.mm.model.c.aHp().i(60, Boolean.TRUE);
      }
      paramae = (eza)new eza().parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s IMESetting:%s", new Object[] { Integer.valueOf(paramae.TxL.mVJ), Integer.valueOf(paramae.TxL.Unw), Integer.valueOf(paramae.TxL.Unx), Integer.valueOf(paramae.UzF) });
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s, textStatus:%s", new Object[] { Integer.valueOf(paramae.TxL.mVJ), Integer.valueOf(paramae.TxL.Unw), Integer.valueOf(paramae.TxL.Unx), paramae.SjM });
      bh.beI();
      String str = (String)com.tencent.mm.model.c.aHp().b(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(20538);
        return;
      }
      if (com.tencent.mm.plugin.sns.b.p.JPd != null) {
        com.tencent.mm.plugin.sns.b.p.JPd.a(str, paramae.TxL);
      }
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", new Object[] { Integer.valueOf(paramae.Uzv.Ure) });
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str, paramae.Uzv);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "finderSetting:%s", new Object[] { Long.valueOf(paramae.UzE) });
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getFinderSwitchApi().Nd(paramae.UzE);
      paramArrayOfByte = com.tencent.mm.ao.g.gu(com.tencent.mm.model.z.bcZ());
      paramabu = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramabu = new com.tencent.mm.api.c();
      }
      paramabu.field_username = str;
      paramabu.field_brandList = paramae.mVI;
      if ((paramabu.YY()) && (paramabu.dc(false) != null) && (paramabu.dc(false).Zz() != null) && (!Util.isNullOrNil(paramabu.Zf())))
      {
        paramabu.field_enterpriseFather = paramabu.Zf();
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramabu.field_enterpriseFather });
      }
      if (!af.bjv().h(paramabu)) {
        af.bjv().g(paramabu);
      }
      int i = paramae.Uze;
      int j = paramae.Uzf;
      int k = paramae.Uzg;
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      bh.beI();
      com.tencent.mm.model.c.aHp().i(135175, Integer.valueOf(i));
      bh.beI();
      com.tencent.mm.model.c.aHp().i(135176, Integer.valueOf(j));
      bh.beI();
      com.tencent.mm.model.c.aHp().i(135177, Integer.valueOf(k));
      bh.beI();
      com.tencent.mm.model.c.aHp().i(144385, Integer.valueOf(paramae.Uzk));
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VlG, Integer.valueOf(paramae.Tai));
      com.tencent.mm.plugin.base.model.c.cxc();
      bh.beI();
      com.tencent.mm.model.c.aHp().i(339975, Integer.valueOf(paramae.Uzs));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramae.Uzs), Integer.valueOf(paramae.Tai) });
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VjK, Util.nullAs(paramae.hDv, ""));
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramae.hDv });
      bh.beI();
      com.tencent.mm.model.c.aHp().i(147457, Long.valueOf(paramae.Uzt));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", new Object[] { Long.valueOf(paramae.Uzt) });
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VDj, Integer.valueOf(paramae.TWB));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(paramae.TWB) });
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VDk, paramae.Uzy);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.BindXMail:%s", new Object[] { paramae.Uzy });
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Vxr, Long.valueOf(paramae.Uzw));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PaySetting:%s", new Object[] { Long.toBinaryString(paramae.Uzw) });
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.Voj, paramae.Uzu);
      bh.beI();
      com.tencent.mm.model.c.aHp().set(ar.a.VxE, Integer.valueOf(paramae.Uzx));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PayBindMobileTransfer:%s", new Object[] { Integer.valueOf(paramae.Uzx) });
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDu, paramae.TGR);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffix:%s", new Object[] { paramae.TGR });
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDA, Integer.valueOf(paramae.Uid));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(paramae.Uid) });
      com.tencent.mm.plugin.patmsg.c.fB(str, paramae.Uid);
      if ((paramae.Uzt & 0x0) != 0L)
      {
        paramBoolean = true;
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoX, Boolean.valueOf(paramBoolean));
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoY, Integer.valueOf(paramae.Uzz));
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoZ, Integer.valueOf(paramae.UzA));
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vpa, Integer.valueOf(paramae.UzB));
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkt();
        paramabu = new j();
        paramabu.cUP = -1;
        paramabu.username = str;
        paramabu.lBe = paramae.SjI;
        paramabu.lBd = paramae.SjJ;
        paramabu.gg(true);
        paramabu.hDc = 3;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramabu.getUsername(), paramabu.bhH(), paramabu.bhI() });
        com.tencent.mm.am.q.bhP().b(paramabu);
        paramabu = paramae.TGm;
        paramArrayOfByte = paramae.TGn;
        bh.beI();
        com.tencent.mm.model.c.aHp().i(274433, paramArrayOfByte);
        bh.beI();
        com.tencent.mm.model.c.aHp().i(274434, paramabu);
        if (paramae.RIW != null)
        {
          bh.beI();
          com.tencent.mm.model.c.aHp().i(286721, paramae.RIW.RQE);
          bh.beI();
          com.tencent.mm.model.c.aHp().i(286722, paramae.RIW.RQF);
          bh.beI();
          com.tencent.mm.model.c.aHp().i(286723, paramae.RIW.RQG);
        }
        if ((paramae.Uzq != null) && (paramae.Uzq.TQw != null) && (paramae.Uzq.TQw.Ufv > 0))
        {
          Log.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramae.Uzq.TQw.Ufv) });
          paramabu = new zt();
          paramabu.fZa.fZb = paramae.Uzq;
          EventCenter.instance.publish(paramabu);
        }
        Log.i("MicroMsg.BigBallOfMudSyncExtension", "handling xagreement configs");
        if (paramae.UzC != null) {
          cs.z(paramae.UzC.UOb, paramae.UzC.UOc);
        }
        if ((paramae.UzF & 0x1) == 1)
        {
          paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
          if (com.tencent.mm.plugin.hld.f.l.eHB() != null)
          {
            paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
            if (com.tencent.mm.plugin.hld.f.l.eHB().getInt("ime_old_user_guide_show", 0) != 2)
            {
              paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
              if (!com.tencent.mm.plugin.hld.f.l.eHj()) {
                break label4277;
              }
              paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
              if (!com.tencent.mm.plugin.hld.f.l.eHm()) {
                break label4277;
              }
              paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
              if (!com.tencent.mm.plugin.hld.f.l.eHp()) {
                break label4277;
              }
              paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
              com.tencent.mm.plugin.hld.f.l.eHB().putInt("ime_old_user_guide_show", 2);
            }
          }
        }
        paramabu = com.tencent.mm.plugin.hld.f.i.DHq;
        i = paramae.UzF;
        j = com.tencent.mm.plugin.hld.f.i.eGG();
        paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
        paramabu = com.tencent.mm.plugin.hld.f.l.eHB();
        if (paramabu != null) {
          paramabu.putInt("ime_setting", i);
        }
        if (j != i) {
          ((com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.hld.a.d.class)).Uq(j);
        }
        Log.i(com.tencent.mm.plugin.hld.f.i.TAG, "update imesetting oriIMESetting:" + j + " newIMESetting:" + i);
        paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.eHC() != null)
        {
          paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
          if (!com.tencent.mm.plugin.hld.f.l.eHC().getBoolean("ime_active_first_process_privacy_info", false))
          {
            paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
            if (com.tencent.mm.plugin.hld.f.l.eHk())
            {
              paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
              com.tencent.mm.plugin.hld.f.l.eHl();
            }
          }
          paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
          if (!com.tencent.mm.plugin.hld.f.l.eHC().getBoolean("ime_active_second_process_collect_data", false))
          {
            paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
            if (com.tencent.mm.plugin.hld.f.l.eHn())
            {
              paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
              com.tencent.mm.plugin.hld.f.l.eHo();
            }
          }
          paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
          if (!com.tencent.mm.plugin.hld.f.l.eHC().getBoolean("ime_active_fifth_process_choose_keyboard", false))
          {
            paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
            if (com.tencent.mm.plugin.hld.f.l.eHq())
            {
              paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
              com.tencent.mm.plugin.hld.f.l.eHr();
            }
          }
          paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
          if (com.tencent.mm.plugin.hld.f.l.eHj())
          {
            paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
            if (com.tencent.mm.plugin.hld.f.l.eHm())
            {
              paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
              if (com.tencent.mm.plugin.hld.f.l.eHp())
              {
                paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
                com.tencent.mm.plugin.hld.f.l.eHB().putInt("ime_old_user_guide_show", 2);
              }
            }
          }
        }
        paramabu = com.tencent.mm.plugin.hld.f.i.DHq;
        if ((paramae.UzF & 0x4) != 4) {
          break label4316;
        }
        paramBoolean = true;
        com.tencent.mm.plugin.hld.f.i.te(paramBoolean);
        paramabu = com.tencent.mm.plugin.hld.f.i.DHq;
        if ((paramae.UzF & 0x20000) == 131072) {
          break label4321;
        }
        paramBoolean = true;
        com.tencent.mm.plugin.hld.f.i.td(paramBoolean);
        paramabu = com.tencent.mm.plugin.hld.f.i.DHq;
        com.tencent.mm.plugin.hld.f.i.eEm();
        if ((paramae.UzF & 0x2) != 2) {
          break label4326;
        }
      }
      for (i = com.tencent.mm.plugin.hld.keyboard.c.Dyl.ordinal();; i = com.tencent.mm.plugin.hld.keyboard.c.Dym.ordinal())
      {
        paramabu = com.tencent.mm.plugin.hld.f.i.DHq;
        com.tencent.mm.plugin.hld.f.i.UJ(i);
        com.tencent.e.h.ZvG.be(new a.2(this));
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
        if (com.tencent.mm.plugin.hld.f.l.he(MMApplicationContext.getContext())) {
          break label3913;
        }
        Log.i("MicroMsg.BigBallOfMudSyncExtension", "show old user guide");
        paramabu = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.eHB().putInt("ime_old_user_guide_show", 1);
        break label3913;
        paramBoolean = false;
        break label4183;
        paramBoolean = false;
        break label4208;
      }
      try
      {
        i = o.v(paramArrayOfByte, 0);
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        AppMethodBeat.o(20538);
        return;
      }
      catch (InterruptedException paramabu)
      {
        Log.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramabu, "", new Object[0]);
        AppMethodBeat.o(20538);
        return;
      }
      paramabu = (dce)new dce().parseFrom(paramArrayOfByte);
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramabu.COi), Long.valueOf(paramabu.HlH) });
      if (com.tencent.mm.model.ab.QC(paramabu.CRR))
      {
        paramArrayOfByte = new tz();
        paramArrayOfByte.fTn.msgId = paramabu.HlH;
        EventCenter.instance.publish(paramArrayOfByte);
      }
      AppMethodBeat.o(20538);
      return;
      paramabu = new wb();
      paramabu.fVj.data = paramArrayOfByte;
      EventCenter.instance.publish(paramabu);
      AppMethodBeat.o(20538);
      return;
      paramabu = (edx)new edx().parseFrom(paramArrayOfByte);
    } while (paramabu == null);
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
    label4183:
    label4316:
    label4321:
    label4326:
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().nJ(paramabu.UserName, paramabu.HlB);
    label1411:
    label1416:
    label2349:
    label3913:
    AppMethodBeat.o(20538);
    label4277:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.a
 * JD-Core Version:    0.7.0.1
 */