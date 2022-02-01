package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.al.ag;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.xm;
import com.tencent.mm.g.a.ym;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cr;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.i.a.ac;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cql;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dtv;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.protocal.protobuf.efy;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.protocal.protobuf.fff;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import junit.framework.Assert;

public final class a
  implements x
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
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSN().bjP(paramas.field_username);
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
      localObject = (cpl)new cpl().parseFrom((byte[])localObject);
      bg.aVF();
      com.tencent.mm.model.c.aSN().bjQ(paramas.field_username);
      if (localObject == null)
      {
        Log.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        AppMethodBeat.o(20539);
        return false;
      }
    }
    catch (Exception localException)
    {
      cpl localcpl;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localcpl = null;
      }
      boolean bool = com.tencent.mm.plugin.bbom.c.a(paramas, localcpl, false);
      AppMethodBeat.o(20539);
      return bool;
    }
  }
  
  public final void a(abn paramabn, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa)
  {
    AppMethodBeat.i(20538);
    switch (paramabn.Lms)
    {
    default: 
      Log.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramabn.Lms);
    }
    label301:
    label1882:
    label2152:
    do
    {
      AppMethodBeat.o(20538);
      return;
      paramabn = (cdm)new cdm().parseFrom(paramArrayOfByte);
      paramArrayOfByte = new com.tencent.mm.plugin.account.friend.a.p();
      paramArrayOfByte.username = paramabn.UserName;
      paramArrayOfByte.keQ = paramabn.Mjk;
      paramArrayOfByte.dii = ((int)Util.nowSecond());
      com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().b(paramArrayOfByte);
      AppMethodBeat.o(20538);
      return;
      paramabn = (cpx)new cpx().parseFrom(paramArrayOfByte);
      if (1 == paramabn.MvQ)
      {
        bg.aVF();
        paramArrayOfByte = com.tencent.mm.model.c.aSW();
        paramaa = com.tencent.mm.platformtools.z.a(paramabn.Lqk);
        if (paramabn.DeleteFlag == 1)
        {
          paramBoolean = true;
          if (paramabn.MvR != 1) {
            break label301;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramArrayOfByte.i(paramaa, paramBoolean, bool);
          AppMethodBeat.o(20538);
          return;
          paramBoolean = false;
          break;
        }
      }
      Log.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramabn.MvQ);
      AppMethodBeat.o(20538);
      return;
      paramabn = (cpg)new cpg().parseFrom(paramArrayOfByte);
      if (paramabn != null)
      {
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramabn.Lqk + " nickname:" + paramabn.Mjj);
        paramaa = com.tencent.mm.platformtools.z.a(paramabn.Lqk);
        bg.aVF();
        paramArrayOfByte = com.tencent.mm.model.c.aSN().Kn(paramaa);
        paramArrayOfByte.setUsername(paramaa);
        paramArrayOfByte.setNickname(com.tencent.mm.platformtools.z.a(paramabn.Mjj));
        paramArrayOfByte.BF(com.tencent.mm.platformtools.z.a(paramabn.LpA));
        paramArrayOfByte.BG(com.tencent.mm.platformtools.z.a(paramabn.LpB));
        paramArrayOfByte.nj(paramabn.kdY);
        paramArrayOfByte.BD(com.tencent.mm.platformtools.z.a(paramabn.MuI));
        paramArrayOfByte.BI(com.tencent.mm.platformtools.z.a(paramabn.MuK));
        paramArrayOfByte.BJ(com.tencent.mm.platformtools.z.a(paramabn.MuJ));
        paramArrayOfByte.nl(paramabn.LoM);
        paramaa = new i();
        paramaa.cSx = -1;
        paramaa.username = paramArrayOfByte.field_username;
        paramaa.iKW = paramabn.Lis;
        paramaa.iKX = paramabn.Lir;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramaa.getUsername(), paramaa.aYt(), paramaa.aYu() });
        paramaa.fv(true);
        if ((paramabn.Mvd != 3) && (paramabn.Mvd != 4)) {
          break label773;
        }
        paramArrayOfByte.ni(paramabn.Mvd);
        paramaa.fuz = paramabn.Mvd;
      }
      for (;;)
      {
        com.tencent.mm.aj.p.aYB().b(paramaa);
        bg.aVF();
        com.tencent.mm.model.c.aSN().ao(paramArrayOfByte);
        paramaa = ag.bah().MT(paramArrayOfByte.field_username);
        paramaa.field_username = paramArrayOfByte.field_username;
        paramaa.field_brandList = paramabn.kei;
        paramabn = paramabn.MmR;
        if (paramabn != null)
        {
          paramaa.field_brandFlag = paramabn.kem;
          paramaa.field_brandInfo = paramabn.keo;
          paramaa.field_brandIconURL = paramabn.kep;
          paramaa.field_extInfo = paramabn.ken;
          paramaa.field_attrSyncVersion = null;
          Log.i("MicroMsg.BigBallOfMudSyncExtension", "update extInfo=%s", new Object[] { paramaa.field_extInfo });
        }
        if (!ag.bah().h(paramaa)) {
          ag.bah().g(paramaa);
        }
        AppMethodBeat.o(20538);
        return;
        if (paramabn.Mvd == 2)
        {
          paramArrayOfByte.ni(3);
          paramaa.fuz = 3;
          paramArrayOfByte.ni(3);
          if (!com.tencent.mm.model.z.aTY().equals(paramArrayOfByte.field_username))
          {
            com.tencent.mm.aj.p.aYn();
            com.tencent.mm.aj.e.N(paramArrayOfByte.field_username, false);
            com.tencent.mm.aj.p.aYn();
            com.tencent.mm.aj.e.N(paramArrayOfByte.field_username, true);
            com.tencent.mm.aj.p.aYD().Mg(paramArrayOfByte.field_username);
          }
        }
      }
      paramabn = (bfx)new bfx().parseFrom(paramArrayOfByte);
      switch (paramabn.LPB)
      {
      case 2: 
      case 3: 
      default: 
        Log.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramabn.LPB);
        AppMethodBeat.o(20538);
        return;
      case 1: 
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(17, Integer.valueOf(paramabn.BsD));
        AppMethodBeat.o(20538);
        return;
      }
      AppMethodBeat.o(20538);
      return;
      paramabn = (efy)new efy().parseFrom(paramArrayOfByte);
      if (paramabn != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramabn.UserName).length() <= 0) {
          break label1039;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (as.bjm(paramabn.UserName)) {
          break label1044;
        }
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      bg.aVF();
      paramArrayOfByte = com.tencent.mm.model.c.aSN().Kn(paramabn.UserName);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.gMZ == 0))
      {
        paramArrayOfByte = new as(paramabn.UserName);
        paramArrayOfByte.BD(paramabn.Liq);
        paramArrayOfByte.nl(1);
        paramArrayOfByte.aqW();
        bg.aVF();
        if (com.tencent.mm.model.c.aSN().aq(paramArrayOfByte) == -1)
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
        paramArrayOfByte = new xm();
        paramArrayOfByte.edJ.opType = 1;
        paramArrayOfByte.edJ.dWq = paramabn.UserName;
        paramArrayOfByte.edJ.dWr = paramabn.MKY;
        paramArrayOfByte.edJ.dWs = paramabn.LoT;
        EventCenter.instance.publish(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!paramArrayOfByte.endsWith("@t.qq.com"))
        {
          Log.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
        }
        else
        {
          paramaa = new i();
          paramaa.username = paramArrayOfByte;
          paramaa.fuz = 3;
          paramaa.cSx = 3;
          com.tencent.mm.aj.p.aYB().b(paramaa);
          continue;
          if (!Util.nullAsNil(paramabn.Liq).equals(Util.nullAsNil(paramArrayOfByte.field_username)))
          {
            paramArrayOfByte.BD(paramabn.Liq);
            bg.aVF();
            if (com.tencent.mm.model.c.aSN().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
              Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
            }
          }
        }
      }
      paramabn = (dgj)new dgj().parseFrom(paramArrayOfByte);
      if (paramabn != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramabn.UserName).length() <= 0) {
          break label1411;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        Assert.assertTrue(paramBoolean);
        if (as.bjo(paramabn.UserName)) {
          break label1416;
        }
        Log.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
      }
      bg.aVF();
      paramArrayOfByte = com.tencent.mm.model.c.aSN().Kn(paramabn.UserName);
      if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.gMZ == 0))
      {
        paramArrayOfByte = new as(paramabn.UserName);
        paramArrayOfByte.aqW();
        paramArrayOfByte.setNickname(paramabn.Liq);
        paramArrayOfByte.BD(paramabn.Liq);
        paramArrayOfByte.nl(4);
        bg.aVF();
        if (com.tencent.mm.model.c.aSN().aq(paramArrayOfByte) == -1)
        {
          Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
          AppMethodBeat.o(20538);
          return;
        }
        com.tencent.mm.aj.c.Mb(paramArrayOfByte.field_username);
      }
      for (;;)
      {
        paramArrayOfByte = new qc();
        paramArrayOfByte.dWm.opType = 1;
        paramArrayOfByte.dWm.dWq = paramabn.UserName;
        paramArrayOfByte.dWm.dWr = paramabn.MKY;
        paramArrayOfByte.dWm.dWs = paramabn.LoT;
        EventCenter.instance.publish(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        if (!Util.nullAsNil(paramabn.Liq).equals(Util.nullAsNil(paramArrayOfByte.field_username)))
        {
          paramArrayOfByte.setNickname(paramabn.Liq);
          paramArrayOfByte.BD(paramabn.Liq);
          bg.aVF();
          if (com.tencent.mm.model.c.aSN().c(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
            Log.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
          }
        }
      }
      paramabn = (cpd)new cpd().parseFrom(paramArrayOfByte);
      if (paramabn != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        if (Util.nullAsNil(paramabn.UserName).length() <= 0) {
          break label1956;
        }
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramArrayOfByte = new as();
        paramArrayOfByte.setUsername(paramabn.UserName);
        paramArrayOfByte.setType(paramabn.oUv);
        paramArrayOfByte.nj(paramabn.kdY);
        paramArrayOfByte.Cb(RegionCodeDecoder.bq(paramabn.keh, paramabn.kdZ, paramabn.kea));
        paramArrayOfByte.BV(paramabn.keb);
        paramaa = new i();
        paramaa.cSx = -1;
        paramaa.username = paramabn.UserName;
        paramaa.iKW = paramabn.Lis;
        paramaa.iKX = paramabn.Lir;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramaa.getUsername(), paramaa.aYt(), paramaa.aYu() });
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramabn.Mvd + " hd:" + paramabn.Mve);
        if (paramabn.Mve == 0) {
          break label1961;
        }
        paramBoolean = true;
        paramaa.fv(paramBoolean);
        if ((paramabn.Mvd != 3) && (paramabn.Mvd != 4)) {
          break label1966;
        }
        paramArrayOfByte.ni(paramabn.Mvd);
        paramaa.fuz = paramabn.Mvd;
      }
      for (;;)
      {
        com.tencent.mm.aj.p.aYB().b(paramaa);
        bg.aVF();
        com.tencent.mm.model.c.aSN().an(paramArrayOfByte);
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label1694;
        paramBoolean = false;
        break label1882;
        if (paramabn.Mvd == 2)
        {
          paramArrayOfByte.ni(3);
          paramaa.fuz = 3;
          com.tencent.mm.aj.p.aYn();
          com.tencent.mm.aj.e.N(paramabn.UserName, false);
          com.tencent.mm.aj.p.aYn();
          com.tencent.mm.aj.e.N(paramabn.UserName, true);
          com.tencent.mm.aj.p.aYD().Mg(paramabn.UserName);
        }
        else
        {
          paramArrayOfByte.ni(3);
          paramaa.fuz = 3;
        }
      }
      paramaa = (cql)new cql().parseFrom(paramArrayOfByte);
      if (paramaa != null)
      {
        paramBoolean = true;
        Assert.assertTrue(paramBoolean);
        paramabn = com.tencent.mm.model.z.aTY();
        j = paramaa.Mwb;
        if (j != 2) {
          break label2349;
        }
        paramabn = as.bjz(paramabn);
        bg.aVF();
        paramArrayOfByte = (String)com.tencent.mm.model.c.azQ().get(12553, null);
        paramBoolean = false;
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramaa.Mwe)))
        {
          com.tencent.mm.aj.p.aYn();
          com.tencent.mm.aj.e.N(paramabn, true);
          bg.aVF();
          paramArrayOfByte = com.tencent.mm.model.c.azQ();
          if (j != 2) {
            break label2370;
          }
          i = 12553;
          paramArrayOfByte.set(i, paramaa.Mwe);
          paramBoolean = true;
        }
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramaa.Mwe, paramaa.Lir, paramaa.Lis });
        paramArrayOfByte = new i();
        paramArrayOfByte.username = paramabn;
        paramArrayOfByte.iKX = paramaa.Lir;
        paramArrayOfByte.iKW = paramaa.Lis;
        if (!Util.isNullOrNil(paramArrayOfByte.aYu()))
        {
          if (j != 1) {
            break label2378;
          }
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(59, Boolean.TRUE);
        }
      }
      for (;;)
      {
        paramArrayOfByte.fv(false);
        paramArrayOfByte.cSx = 56;
        if (!Util.isNullOrNil(paramaa.Mwe)) {
          paramArrayOfByte.fv(true);
        }
        com.tencent.mm.aj.p.aYB().b(paramArrayOfByte);
        if (paramBoolean) {
          new com.tencent.mm.aj.f().a(paramabn, new f.c()
          {
            public final int dp(int paramAnonymousInt1, int paramAnonymousInt2)
            {
              return 0;
            }
          });
        }
        AppMethodBeat.o(20538);
        return;
        paramBoolean = false;
        break;
        bg.aVF();
        paramArrayOfByte = (String)com.tencent.mm.model.c.azQ().get(12297, null);
        break label2105;
        i = 12297;
        break label2152;
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(60, Boolean.TRUE);
      }
      paramaa = (eos)new eos().parseFrom(paramArrayOfByte);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt snsExtFlag:%s, snsExtFlagEx:%s, snsPrivacyRecent:%s, textStatus:%s", new Object[] { Integer.valueOf(paramaa.MmQ.kej), Integer.valueOf(paramaa.MmQ.Nbc), Integer.valueOf(paramaa.MmQ.Nbd), paramaa.Liv });
      bg.aVF();
      String str = (String)com.tencent.mm.model.c.azQ().get(2, null);
      if ((str == null) || (str.length() <= 0))
      {
        AppMethodBeat.o(20538);
        return;
      }
      if (com.tencent.mm.plugin.sns.b.o.DCN != null) {
        com.tencent.mm.plugin.sns.b.o.DCN.a(str, paramaa.MmQ);
      }
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "storyExtFlag:%s", new Object[] { Integer.valueOf(paramaa.NmJ.NeF) });
      ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).updateStoryUserInfo(str, paramaa.NmJ);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "finderSetting:%s", new Object[] { Long.valueOf(paramaa.NmS) });
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).getFinderSwitchApi().Gf(paramaa.NmS);
      paramArrayOfByte = com.tencent.mm.al.g.fJ(com.tencent.mm.model.z.aTY());
      paramabn = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramabn = new com.tencent.mm.api.c();
      }
      paramabn.field_username = str;
      paramabn.field_brandList = paramaa.kei;
      if ((paramabn.UG()) && (paramabn.cG(false) != null) && (paramabn.cG(false).Vh() != null) && (!Util.isNullOrNil(paramabn.UN())))
      {
        paramabn.field_enterpriseFather = paramabn.UN();
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramabn.field_enterpriseFather });
      }
      if (!ag.bah().h(paramabn)) {
        ag.bah().g(paramabn);
      }
      int i = paramaa.Nms;
      int j = paramaa.Nmt;
      int k = paramaa.Nmu;
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(135175, Integer.valueOf(i));
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(135176, Integer.valueOf(j));
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(135177, Integer.valueOf(k));
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(144385, Integer.valueOf(paramaa.Nmy));
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NXG, Integer.valueOf(paramaa.LRD));
      com.tencent.mm.plugin.base.model.c.cjL();
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(339975, Integer.valueOf(paramaa.NmG));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramaa.NmG), Integer.valueOf(paramaa.LRD) });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.NVK, Util.nullAs(paramaa.fuW, ""));
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramaa.fuW });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(147457, Long.valueOf(paramaa.NmH));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.ExtStatus:%s", new Object[] { Long.valueOf(paramaa.NmH) });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.OnT, Integer.valueOf(paramaa.MKH));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.UserStatus:%s", new Object[] { Integer.valueOf(paramaa.MKH) });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.OnU, paramaa.NmM);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.BindXMail:%s", new Object[] { paramaa.NmM });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.Ojb, Long.valueOf(paramaa.NmK));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PaySetting:%s", new Object[] { Long.toBinaryString(paramaa.NmK) });
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.Oah, paramaa.NmI);
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(ar.a.Ojo, Integer.valueOf(paramaa.NmL));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PayBindMobileTransfer:%s", new Object[] { Integer.valueOf(paramaa.NmL) });
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oob, paramaa.MvT);
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffix:%s", new Object[] { paramaa.MvT });
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ooh, Integer.valueOf(paramaa.MVK));
      Log.i("MicroMsg.BigBallOfMudSyncExtension", "userinfoExt.PatSuffixVersion:%d", new Object[] { Integer.valueOf(paramaa.MVK) });
      com.tencent.mm.plugin.patmsg.c.fa(str, paramaa.MVK);
      if ((paramaa.NmH & 0x0) != 0L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaV, Boolean.valueOf(paramBoolean));
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaW, Integer.valueOf(paramaa.NmN));
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaX, Integer.valueOf(paramaa.NmO));
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OaY, Integer.valueOf(paramaa.NmP));
        ((b)com.tencent.mm.kernel.g.af(b.class)).fvq();
        paramabn = new i();
        paramabn.cSx = -1;
        paramabn.username = str;
        paramabn.iKX = paramaa.Lir;
        paramabn.iKW = paramaa.Lis;
        paramabn.fv(true);
        paramabn.fuz = 3;
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramabn.getUsername(), paramabn.aYt(), paramabn.aYu() });
        com.tencent.mm.aj.p.aYB().b(paramabn);
        paramabn = paramaa.Mvo;
        paramArrayOfByte = paramaa.Mvp;
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(274433, paramArrayOfByte);
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(274434, paramabn);
        if (paramaa.KHD != null)
        {
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(286721, paramaa.KHD.KPG);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(286722, paramaa.KHD.KPH);
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(286723, paramaa.KHD.KPI);
        }
        if ((paramaa.NmE != null) && (paramaa.NmE.MEK != null) && (paramaa.NmE.MEK.getILen() > 0))
        {
          Log.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramaa.NmE.MEK.getILen()) });
          paramabn = new ym();
          paramabn.eeL.eeM = paramaa.NmE;
          EventCenter.instance.publish(paramabn);
        }
        Log.i("MicroMsg.BigBallOfMudSyncExtension", "handling xagreement configs");
        if (paramaa.NmQ != null) {
          cr.z(paramaa.NmQ.NAz, paramaa.NmQ.NAA);
        }
        AppMethodBeat.o(20538);
        return;
      }
      try
      {
        i = com.tencent.mm.b.o.v(paramArrayOfByte, 0);
        Log.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          Thread.sleep(i);
        }
        AppMethodBeat.o(20538);
        return;
      }
      catch (InterruptedException paramabn)
      {
        Log.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramabn, "", new Object[0]);
        AppMethodBeat.o(20538);
        return;
      }
      paramabn = (ctf)new ctf().parseFrom(paramArrayOfByte);
      Log.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramabn.xKb), Long.valueOf(paramabn.Brn) });
      if (ab.Jj(paramabn.xNH))
      {
        paramArrayOfByte = new sy();
        paramArrayOfByte.dZu.msgId = paramabn.Brn;
        EventCenter.instance.publish(paramArrayOfByte);
      }
      AppMethodBeat.o(20538);
      return;
      paramabn = new ux();
      paramabn.ebm.data = paramArrayOfByte;
      EventCenter.instance.publish(paramabn);
      AppMethodBeat.o(20538);
      return;
      paramabn = (dtv)new dtv().parseFrom(paramArrayOfByte);
    } while (paramabn == null);
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
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().mS(paramabn.UserName, paramabn.Bri);
    label1411:
    label1416:
    label2349:
    AppMethodBeat.o(20538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelmulti.a
 * JD-Core Version:    0.7.0.1
 */