package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.a.aal;
import com.tencent.mm.autogen.a.abq;
import com.tencent.mm.autogen.a.sp;
import com.tencent.mm.autogen.a.vp;
import com.tencent.mm.autogen.a.xs;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.b.o;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ct;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.f.d;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.friend.model.m;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dqj;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.eiy;
import com.tencent.mm.protocal.protobuf.exo;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.fjk;
import com.tencent.mm.protocal.protobuf.fld;
import com.tencent.mm.protocal.protobuf.fvb;
import com.tencent.mm.protocal.protobuf.gnp;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import junit.framework.Assert;

public final class a
  implements ab
{
  public static boolean a(au paramau)
  {
    AppMethodBeat.i(20539);
    if ((paramau == null) || (Util.isNullOrNil(paramau.field_username)))
    {
      if (paramau == null) {}
      for (paramau = "-1";; paramau = paramau.field_username)
      {
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paramau });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.bzA().bxA(paramau.field_username);
    if (Util.isNullOrNil((byte[])localObject))
    {
      paramau = paramau.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paramau, Integer.valueOf(i) });
        AppMethodBeat.o(20539);
        return false;
      }
    }
    try
    {
      localObject = (dph)new dph().parseFrom((byte[])localObject);
      bh.bCz();
      com.tencent.mm.model.c.bzA().bxB(paramau.field_username);
      if (localObject == null)
      {
        Log.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        AppMethodBeat.o(20539);
        return false;
      }
    }
    catch (Exception localException)
    {
      dph localdph;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localdph = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paramau, localdph, false);
      AppMethodBeat.o(20539);
      return bool;
    }
  }
  
  public final void a(adw paramadw, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae)
  {
    AppMethodBeat.i(20538);
    switch (paramadw.Zmc)
    {
    default: 
      Log.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramadw.Zmc);
    }
    label301:
    label1876:
    label2146:
    do
    {
      AppMethodBeat.o(20538);
      return;
      paramadw = (dcs)new dcs().parseFrom(paramArrayOfByte);
      paramArrayOfByte = new m();
      paramArrayOfByte.username = paramadw.UserName;
      paramArrayOfByte.pSV = paramadw.aaIA;
      paramArrayOfByte.hdp = ((int)Util.nowSecond());
      com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().b(paramArrayOfByte);
      AppMethodBeat.o(20538);
      return;
      paramadw = (dpu)new dpu().parseFrom(paramArrayOfByte);
      if (1 == paramadw.aaWv)
      {
        bh.bCz();
        paramArrayOfByte = com.tencent.mm.model.c.bzJ();
        paramae = w.a(paramadw.ZqL);
        if (paramadw.DeleteFlag == 1)
        {
          paramBoolean = true;
          if (paramadw.aaWw != 1) {
            break label301;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.k(paramae, paramBoolean, bool);
          AppMethodBeat.o(20538);
          return;
          paramBoolean = false;
          break;
        }
      }
      Log.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramadw.aaWv);
      AppMethodBeat.o(20538);
      return;
      paramadw = (dpb)new dpb().parseFrom(paramArrayOfByte);
      if (paramadw != null)
      {
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramadw.ZqL + " nickname:" + paramadw.aaIz);
        paramae = w.a(paramadw.ZqL);
        bh.bCz();
        paramArrayOfByte = com.tencent.mm.model.c.bzA().JE(paramae);
        paramArrayOfByte.setUsername(paramae);
        paramArrayOfByte.setNickname(w.a(paramadw.aaIz));
        paramArrayOfByte.AY(w.a(paramadw.ZpX));
        paramArrayOfByte.AZ(w.a(paramadw.ZpY));
        paramArrayOfByte.pv(paramadw.pSf);
        paramArrayOfByte.AW(w.a(paramadw.aaVg));
        paramArrayOfByte.Bb(w.a(paramadw.aaVi));
        paramArrayOfByte.Bc(w.a(paramadw.aaVh));
        paramArrayOfByte.py(paramadw.Zpe);
        paramae = new j();
        paramae.eQp = -1;
        paramae.username = paramArrayOfByte.field_username;
        paramae.osM = paramadw.ZhP;
        paramae.osN = paramadw.ZhO;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramae.getUsername(), paramae.bFw(), paramae.bFx() });
        paramae.gX(true);
        if ((paramadw.aaVH != 3) && (paramadw.aaVH != 4)) {
          break label773;
        }
        paramArrayOfByte.pu(paramadw.aaVH);
        paramae.jZY = paramadw.aaVH;
      }
      for (;;)
      {
        com.tencent.mm.modelavatar.q.bFE().b(paramae);
        bh.bCz();
        com.tencent.mm.model.c.bzA().aA(paramArrayOfByte);
        paramae = af.bHf().Mn(paramArrayOfByte.field_username);
        paramae.field_username = paramArrayOfByte.field_username;
        paramae.field_brandList = paramadw.pSp;
        paramadw = paramadw.aaMt;
        if (paramadw != null)
        {
          paramae.field_brandFlag = paramadw.pSt;
          paramae.field_brandInfo = paramadw.pSv;
          paramae.field_brandIconURL = paramadw.pSw;
          paramae.field_extInfo = paramadw.pSu;
          paramae.field_attrSyncVersion = null;
          Log.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", new Object[] { paramae.field_extInfo });
        }
        if (!af.bHf().h(paramae)) {
          af.bHf().g(paramae);
        }
        AppMethodBeat.o(20538);
        return;
        if (paramadw.aaVH == 2)
        {
          paramArrayOfByte.pu(3);
          paramae.jZY = 3;
          paramArrayOfByte.pu(3);
          if (!z.bAM().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.modelavatar.q.bFp();
            AvatarStorage.T(paramArrayOfByte.field_username, false);
            com.tencent.mm.modelavatar.q.bFp();
            AvatarStorage.T(paramArrayOfByte.field_username, true);
            com.tencent.mm.modelavatar.q.bFG().LB(paramArrayOfByte.field_username);
          }
        }
      }
      paramadw = (cas)new cas().parseFrom(paramArrayOfByte);
      switch (paramadw.aajJ)
      {
      case 2: 
      case 3: 
      default: 
        Log.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramadw.aajJ);
        AppMethodBeat.o(20538);
        return;
      case 1: 
        bh.bCz();
        com.tencent.mm.model.c.ban().B(17, Integer.valueOf(paramadw.NkL));
        AppMethodBeat.o(20538);
        return;
      }
      AppMethodBeat.o(20538);
      return;
      paramadw = (fld)new fld().parseFrom(paramArrayOfByte);
      if (paramadw != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramadw.UserName).length() <= 0) {
          break label1039;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (au.bwL(paramadw.UserName)) {
          break label1044;
        }
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      bh.bCz();
      paramArrayOfByte = com.tencent.mm.model.c.bzA().JE(paramadw.UserName);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.maN == 0))
      {
        paramArrayOfByte = new au(paramadw.UserName);
        paramArrayOfByte.AW(paramadw.ZhN);
        paramArrayOfByte.py(1);
        paramArrayOfByte.aRU();
        bh.bCz();
        if (com.tencent.mm.model.c.bzA().aC(paramArrayOfByte) == -1)
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
        paramArrayOfByte = new aal();
        paramArrayOfByte.idS.opType = 1;
        paramArrayOfByte.idS.hVQ = paramadw.UserName;
        paramArrayOfByte.idS.hVR = paramadw.abnL;
        paramArrayOfByte.idS.hVS = paramadw.Zpl;
        paramArrayOfByte.publish();
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
          paramae.jZY = 3;
          paramae.eQp = 3;
          com.tencent.mm.modelavatar.q.bFE().b(paramae);
          continue;
          if (!Util.nullAsNil(paramadw.ZhN).equals(Util.nullAsNil(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.AW(paramadw.ZhN);
            bh.bCz();
            if (com.tencent.mm.model.c.bzA().d(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
      paramadw = (eiy)new eiy().parseFrom(paramArrayOfByte);
      if (paramadw != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramadw.UserName).length() <= 0) {
          break label1408;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (au.bwN(paramadw.UserName)) {
          break label1413;
        }
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      bh.bCz();
      paramArrayOfByte = com.tencent.mm.model.c.bzA().JE(paramadw.UserName);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.maN == 0))
      {
        paramArrayOfByte = new au(paramadw.UserName);
        paramArrayOfByte.aRU();
        paramArrayOfByte.setNickname(paramadw.ZhN);
        paramArrayOfByte.AW(paramadw.ZhN);
        paramArrayOfByte.py(4);
        bh.bCz();
        if (com.tencent.mm.model.c.bzA().aC(paramArrayOfByte) == -1)
        {
          Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        com.tencent.mm.modelavatar.d.Ly(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new sp();
        paramArrayOfByte.hVM.opType = 1;
        paramArrayOfByte.hVM.hVQ = paramadw.UserName;
        paramArrayOfByte.hVM.hVR = paramadw.abnL;
        paramArrayOfByte.hVM.hVS = paramadw.Zpl;
        paramArrayOfByte.publish();
        AppMethodBeat.o(20538);
        return;
        if (!Util.nullAsNil(paramadw.ZhN).equals(Util.nullAsNil(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.setNickname(paramadw.ZhN);
          paramArrayOfByte.AW(paramadw.ZhN);
          bh.bCz();
          if (com.tencent.mm.model.c.bzA().d(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
      paramadw = (doy)new doy().parseFrom(paramArrayOfByte);
      if (paramadw != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramadw.UserName).length() <= 0) {
          break label1950;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new au();
        paramArrayOfByte.setUsername(paramadw.UserName);
        paramArrayOfByte.setType(paramadw.vhJ);
        paramArrayOfByte.pv(paramadw.pSf);
        paramArrayOfByte.Bu(RegionCodeDecoder.bI(paramadw.pSo, paramadw.pSg, paramadw.pSh));
        paramArrayOfByte.Bo(paramadw.pSi);
        paramae = new j();
        paramae.eQp = -1;
        paramae.username = paramadw.UserName;
        paramae.osM = paramadw.ZhP;
        paramae.osN = paramadw.ZhO;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramae.getUsername(), paramae.bFw(), paramae.bFx() });
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramadw.aaVH + " hd:" + paramadw.aaVI);
        if (paramadw.aaVI == 0) {
          break label1955;
        }
        paramBoolean = true;
        paramae.gX(paramBoolean);
        if ((paramadw.aaVH != 3) && (paramadw.aaVH != 4)) {
          break label1960;
        }
        paramArrayOfByte.pu(paramadw.aaVH);
        paramae.jZY = paramadw.aaVH;
      }
      for (;;)
      {
        com.tencent.mm.modelavatar.q.bFE().b(paramae);
        bh.bCz();
        com.tencent.mm.model.c.bzA().az(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1688;
        paramBoolean = false;
        break label1876;
        if (paramadw.aaVH == 2)
        {
          paramArrayOfByte.pu(3);
          paramae.jZY = 3;
          com.tencent.mm.modelavatar.q.bFp();
          AvatarStorage.T(paramadw.UserName, false);
          com.tencent.mm.modelavatar.q.bFp();
          AvatarStorage.T(paramadw.UserName, true);
          com.tencent.mm.modelavatar.q.bFG().LB(paramadw.UserName);
        }
        else
        {
          paramArrayOfByte.pu(3);
          paramae.jZY = 3;
        }
      }
      paramae = (dqj)new dqj().parseFrom(paramArrayOfByte);
      if (paramae != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramadw = z.bAM();
        j = paramae.aaWH;
        if (j != 2) {
          break label2343;
        }
        paramadw = au.bxd(paramadw);
        bh.bCz();
        paramArrayOfByte = (String)com.tencent.mm.model.c.ban().d(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramae.aaWK)))
        {
          com.tencent.mm.modelavatar.q.bFp();
          AvatarStorage.T(paramadw, true);
          bh.bCz();
          paramArrayOfByte = com.tencent.mm.model.c.ban();
          if (j != 2) {
            break label2364;
          }
          i = 12553;
          paramArrayOfByte.B(i, paramae.aaWK);
          paramBoolean = true;
        }
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramae.aaWK, paramae.ZhO, paramae.ZhP });
        paramArrayOfByte = new j();
        paramArrayOfByte.username = paramadw;
        paramArrayOfByte.osN = paramae.ZhO;
        paramArrayOfByte.osM = paramae.ZhP;
        if (!Util.isNullOrNil(paramArrayOfByte.bFx()))
        {
          if (j != 1) {
            break label2372;
          }
          bh.bCz();
          com.tencent.mm.model.c.ban().B(59, Boolean.TRUE);
        }
      }
      for (;;)
      {
        paramArrayOfByte.gX(false);
        paramArrayOfByte.eQp = 56;
        if (!Util.isNullOrNil(paramae.aaWK)) {
          paramArrayOfByte.gX(true);
        }
        com.tencent.mm.modelavatar.q.bFE().b(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.modelavatar.f().a(paramadw, new f.d()
          {
            public final int resultCallback(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              return 0;
            }
          });
        }
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        bh.bCz();
        paramArrayOfByte = (String)com.tencent.mm.model.c.ban().d(12297, null);
        break label2099;
        i = 12297;
        break label2146;
        bh.bCz();
        com.tencent.mm.model.c.ban().B(60, Boolean.TRUE);
      }
      paramae = (fvb)new fvb().parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s IMESetting:%s", new Object[] { Integer.valueOf(paramae.aaMs.pSq), Integer.valueOf(paramae.aaMs.abFF), Integer.valueOf(paramae.aaMs.abFG), Integer.valueOf(paramae.abTu) });
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s, textStatus:%s", new Object[] { Integer.valueOf(paramae.aaMs.pSq), Integer.valueOf(paramae.aaMs.abFF), Integer.valueOf(paramae.aaMs.abFG), paramae.ZhS });
      bh.bCz();
      String str = (String)com.tencent.mm.model.c.ban().d(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(20538);
        return;
      }
      if (com.tencent.mm.plugin.sns.c.q.Qki != null) {
        com.tencent.mm.plugin.sns.c.q.Qki.a(str, paramae.aaMs);
      }
      if (com.tencent.mm.plugin.sns.c.q.Qkp != null) {
        com.tencent.mm.plugin.sns.c.q.Qkp.a(str, paramae.aaMs);
      }
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", new Object[] { Integer.valueOf(paramae.abTk.abKd) });
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str, paramae.abTk);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "finderSetting:%s", new Object[] { Long.valueOf(paramae.abTt) });
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderSwitchApi().qG(paramae.abTt);
      paramArrayOfByte = com.tencent.mm.an.g.hU(z.bAM());
      paramadw = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramadw = new com.tencent.mm.api.c();
      }
      paramadw.field_username = str;
      paramadw.field_brandList = paramae.pSp;
      if ((paramadw.aAQ()) && (paramadw.dO(false) != null) && (paramadw.dO(false).aBr() != null) && (!Util.isNullOrNil(paramadw.aAX())))
      {
        paramadw.field_enterpriseFather = paramadw.aAX();
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramadw.field_enterpriseFather });
      }
      if (!af.bHf().h(paramadw)) {
        af.bHf().g(paramadw);
      }
      int i = paramae.abST;
      int j = paramae.abSU;
      int k = paramae.abSV;
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      bh.bCz();
      com.tencent.mm.model.c.ban().B(135175, Integer.valueOf(i));
      bh.bCz();
      com.tencent.mm.model.c.ban().B(135176, Integer.valueOf(j));
      bh.bCz();
      com.tencent.mm.model.c.ban().B(135177, Integer.valueOf(k));
      bh.bCz();
      com.tencent.mm.model.c.ban().B(144385, Integer.valueOf(paramae.abSZ));
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acNa, Integer.valueOf(paramae.aang));
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acNb, Integer.valueOf(paramae.abTw));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "sync do cmd smcrypto flag:%d", new Object[] { Integer.valueOf(paramae.abTw) });
      com.tencent.mm.plugin.base.model.c.cZN();
      bh.bCz();
      com.tencent.mm.model.c.ban().B(339975, Integer.valueOf(paramae.abTh));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramae.abTh), Integer.valueOf(paramae.aang) });
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acLe, Util.nullAs(paramae.kaq, ""));
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramae.kaq });
      bh.bCz();
      com.tencent.mm.model.c.ban().B(147457, Long.valueOf(paramae.abTi));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", new Object[] { Long.valueOf(paramae.abTi) });
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.adhU, Long.valueOf(paramae.abTA));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus2:%s", new Object[] { Long.valueOf(paramae.abTA) });
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.adge, Integer.valueOf(paramae.abnq));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(paramae.abnq) });
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.adgf, paramae.abTn);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.BindXMail:%s", new Object[] { paramae.abTn });
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acZd, Long.valueOf(paramae.abTl));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PaySetting:%s", new Object[] { Long.toBinaryString(paramae.abTl) });
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acPF, paramae.abTj);
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acZr, Integer.valueOf(paramae.abTm));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PayBindMobileTransfer:%s", new Object[] { Integer.valueOf(paramae.abTm) });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgr, paramae.aaWy);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffix:%s", new Object[] { paramae.aaWy });
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adgx, Integer.valueOf(paramae.abzt));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(paramae.abzt) });
      com.tencent.mm.plugin.patmsg.c.gu(str, paramae.abzt);
      if ((paramae.abTi & 0x0) != 0L)
      {
        paramBoolean = true;
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acQt, Boolean.valueOf(paramBoolean));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acQu, Integer.valueOf(paramae.abTo));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acQv, Integer.valueOf(paramae.abTp));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acQw, Integer.valueOf(paramae.abTq));
        ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEs();
        if ((paramae.abTi & 0x0) == 0L) {
          break label4496;
        }
        paramBoolean = true;
        Log.i("MicroMsg.BigBallOfMudSyncExtension", "dancy test isCareMode:%s, local:%s, value:%s, ExtStatus:%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(com.tencent.mm.ce.b.iRp()), Long.valueOf(paramae.abTi & 0x0), Long.valueOf(paramae.abTi) });
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acQy, Boolean.valueOf(paramBoolean));
        com.tencent.mm.ce.b.Kn(true);
        if ((paramae.abTi & 0x4000000) == 0L) {
          break label4501;
        }
        paramBoolean = true;
        if (paramBoolean) {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acQC, Boolean.valueOf(paramBoolean));
        }
        paramadw = new j();
        paramadw.eQp = -1;
        paramadw.username = str;
        paramadw.osN = paramae.ZhO;
        paramadw.osM = paramae.ZhP;
        paramadw.gX(true);
        paramadw.jZY = 3;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramadw.getUsername(), paramadw.bFw(), paramadw.bFx() });
        com.tencent.mm.modelavatar.q.bFE().b(paramadw);
        paramadw = paramae.aaVS;
        paramArrayOfByte = paramae.aaVT;
        bh.bCz();
        com.tencent.mm.model.c.ban().B(274433, paramArrayOfByte);
        bh.bCz();
        com.tencent.mm.model.c.ban().B(274434, paramadw);
        if (paramae.YGk != null)
        {
          bh.bCz();
          com.tencent.mm.model.c.ban().B(286721, paramae.YGk.YNT);
          bh.bCz();
          com.tencent.mm.model.c.ban().B(286722, paramae.YGk.YNU);
          bh.bCz();
          com.tencent.mm.model.c.ban().B(286723, paramae.YGk.YNV);
        }
        if ((paramae.abTf != null) && (paramae.abTf.abgV != null) && (paramae.abTf.abgV.abwJ > 0))
        {
          Log.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramae.abTf.abgV.abwJ) });
          paramadw = new abq();
          paramadw.ifg.ifh = paramae.abTf;
          paramadw.publish();
        }
        Log.i("MicroMsg.BigBallOfMudSyncExtension", "handling xagreement configs");
        if (paramae.abTr != null) {
          ct.V(paramae.abTr.aciD, paramae.abTr.aciE);
        }
        if ((paramae.abTu & 0x1) == 1)
        {
          paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
          if (com.tencent.mm.plugin.hld.f.l.fPk() != null)
          {
            paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
            if (com.tencent.mm.plugin.hld.f.l.fPk().getInt("ime_old_user_guide_show", 0) != 2)
            {
              paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
              if (!com.tencent.mm.plugin.hld.f.l.fOS()) {
                break label4506;
              }
              paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
              if (!com.tencent.mm.plugin.hld.f.l.fOV()) {
                break label4506;
              }
              paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
              if (!com.tencent.mm.plugin.hld.f.l.fOY()) {
                break label4506;
              }
              paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
              com.tencent.mm.plugin.hld.f.l.fPk().putInt("ime_old_user_guide_show", 2);
            }
          }
        }
        paramadw = com.tencent.mm.plugin.hld.f.i.JyA;
        i = paramae.abTu;
        j = com.tencent.mm.plugin.hld.f.i.fOs();
        paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
        paramadw = com.tencent.mm.plugin.hld.f.l.fPk();
        if (paramadw != null) {
          paramadw.putInt("ime_setting", i);
        }
        if (j != i) {
          ((com.tencent.mm.plugin.hld.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.hld.a.d.class)).Ym(j);
        }
        Log.i(com.tencent.mm.plugin.hld.f.i.TAG, "update imesetting oriIMESetting:" + j + " newIMESetting:" + i);
        paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
        if (com.tencent.mm.plugin.hld.f.l.fPl() != null)
        {
          paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
          if (!com.tencent.mm.plugin.hld.f.l.fPl().getBoolean("ime_active_first_process_privacy_info", false))
          {
            paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
            if (com.tencent.mm.plugin.hld.f.l.fOT())
            {
              paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
              com.tencent.mm.plugin.hld.f.l.fOU();
            }
          }
          paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
          if (!com.tencent.mm.plugin.hld.f.l.fPl().getBoolean("ime_active_second_process_collect_data", false))
          {
            paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
            if (com.tencent.mm.plugin.hld.f.l.fOW())
            {
              paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
              com.tencent.mm.plugin.hld.f.l.fOX();
            }
          }
          paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
          if (!com.tencent.mm.plugin.hld.f.l.fPl().getBoolean("ime_active_fifth_process_choose_keyboard", false))
          {
            paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
            if (com.tencent.mm.plugin.hld.f.l.fOZ())
            {
              paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
              com.tencent.mm.plugin.hld.f.l.fPa();
            }
          }
          paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
          if (com.tencent.mm.plugin.hld.f.l.fOS())
          {
            paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
            if (com.tencent.mm.plugin.hld.f.l.fOV())
            {
              paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
              if (com.tencent.mm.plugin.hld.f.l.fOY())
              {
                paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
                com.tencent.mm.plugin.hld.f.l.fPk().putInt("ime_old_user_guide_show", 2);
              }
            }
          }
        }
        paramadw = com.tencent.mm.plugin.hld.f.i.JyA;
        if ((paramae.abTu & 0x4) != 4) {
          break label4545;
        }
        paramBoolean = true;
        com.tencent.mm.plugin.hld.f.i.xp(paramBoolean);
        paramadw = com.tencent.mm.plugin.hld.f.i.JyA;
        if ((paramae.abTu & 0x20000) == 131072) {
          break label4550;
        }
        paramBoolean = true;
        com.tencent.mm.plugin.hld.f.i.xo(paramBoolean);
        if ((paramae.abTu & 0x2) != 2) {
          break label4555;
        }
      }
      for (i = com.tencent.mm.plugin.hld.keyboard.c.Jrp.ordinal();; i = com.tencent.mm.plugin.hld.keyboard.c.Jrq.ordinal())
      {
        paramadw = com.tencent.mm.plugin.hld.f.i.JyA;
        com.tencent.mm.plugin.hld.f.i.YH(i);
        com.tencent.threadpool.h.ahAA.bm(new a.2(this));
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label3625;
        paramBoolean = false;
        break label3715;
        paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
        if (com.tencent.mm.plugin.hld.f.l.iz(MMApplicationContext.getContext())) {
          break label4140;
        }
        Log.i("MicroMsg.BigBallOfMudSyncExtension", "show old user guide");
        paramadw = com.tencent.mm.plugin.hld.f.l.JyV;
        com.tencent.mm.plugin.hld.f.l.fPk().putInt("ime_old_user_guide_show", 1);
        break label4140;
        paramBoolean = false;
        break label4410;
        paramBoolean = false;
        break label4435;
      }
      try
      {
        i = o.t(paramArrayOfByte, 0);
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        AppMethodBeat.o(20538);
        return;
      }
      catch (InterruptedException paramadw)
      {
        Log.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramadw, "", new Object[0]);
        AppMethodBeat.o(20538);
        return;
      }
      paramadw = (dtw)new dtw().parseFrom(paramArrayOfByte);
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramadw.IIs), Long.valueOf(paramadw.Njv) });
      if (au.bwg(paramadw.IMh))
      {
        paramArrayOfByte = new vp();
        paramArrayOfByte.hZl.msgId = paramadw.Njv;
        paramArrayOfByte.publish();
      }
      AppMethodBeat.o(20538);
      return;
      paramadw = new xs();
      paramadw.ibg.data = paramArrayOfByte;
      paramadw.publish();
      AppMethodBeat.o(20538);
      return;
      paramadw = (exo)new exo().parseFrom(paramArrayOfByte);
    } while (paramadw == null);
    label773:
    label1039:
    label1044:
    label1688:
    label1950:
    label1955:
    label1960:
    label2099:
    label2364:
    label2372:
    label4435:
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().pI(paramadw.UserName, paramadw.Njp);
    label1408:
    label1413:
    label2343:
    label3625:
    label4140:
    label4410:
    label4545:
    label4550:
    label4555:
    AppMethodBeat.o(20538);
    label3715:
    label4496:
    label4501:
    label4506:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.a
 * JD-Core Version:    0.7.0.1
 */