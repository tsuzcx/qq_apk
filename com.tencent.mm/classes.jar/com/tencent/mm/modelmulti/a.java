package com.tencent.mm.modelmulti;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.a.mj;
import com.tencent.mm.h.a.om;
import com.tencent.mm.h.a.pw;
import com.tencent.mm.h.a.rr;
import com.tencent.mm.h.a.sm;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.account.friend.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.protocal.c.awy;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.axn;
import com.tencent.mm.protocal.c.axw;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.bgs;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.bwu;
import com.tencent.mm.protocal.c.ccb;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import junit.framework.Assert;

public final class a
  implements r
{
  public static boolean a(ad paramad)
  {
    if ((paramad == null) || (bk.bl(paramad.field_username)))
    {
      if (paramad == null) {}
      for (paramad = "-1";; paramad = paramad.field_username)
      {
        y.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s ", new Object[] { paramad });
        return false;
      }
    }
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fw().abp(paramad.field_username);
    if (bk.bE((byte[])localObject))
    {
      paramad = paramad.field_username;
      if (localObject == null) {}
      for (int i = -1;; i = localObject.length)
      {
        y.w("MicroMsg.BigBallOfMudSyncExtension", "dealModContactExtInfo username:%s  buf:%d", new Object[] { paramad, Integer.valueOf(i) });
        return false;
      }
    }
    try
    {
      localObject = (axd)new axd().aH((byte[])localObject);
      au.Hx();
      com.tencent.mm.model.c.Fw().abq(paramad.field_username);
      if (localObject == null)
      {
        y.e("MicroMsg.BigBallOfMudSyncExtension", "dkinit dealModContactExtInfo failed parse buf failed.");
        return false;
      }
    }
    catch (Exception localException)
    {
      axd localaxd;
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", localException, "", new Object[0]);
        localaxd = null;
      }
      return com.tencent.mm.plugin.bbom.c.a(paramad, localaxd, false);
    }
  }
  
  public final void a(qv paramqv, byte[] paramArrayOfByte, boolean paramBoolean, t paramt)
  {
    switch (paramqv.sOA)
    {
    default: 
      y.e("MicroMsg.BigBallOfMudSyncExtension", "doCmd: no processing method, cmd id=" + paramqv.sOA);
    case 22: 
    case 13: 
    case 15: 
    case 23: 
    case 25: 
    case 24: 
    case 33: 
    case 35: 
    case 44: 
    case 999999: 
    case 53: 
      label271:
      label946:
      label951:
      label1759:
      label2023:
      do
      {
        for (;;)
        {
          return;
          paramqv = (aqp)new aqp().aH(paramArrayOfByte);
          paramArrayOfByte = new p();
          paramArrayOfByte.username = paramqv.hPY;
          paramArrayOfByte.ffY = paramqv.tmx;
          paramArrayOfByte.efI = ((int)bk.UX());
          com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().a(paramArrayOfByte);
          return;
          paramqv = (axn)new axn().aH(paramArrayOfByte);
          if (1 == paramqv.ttT)
          {
            au.Hx();
            paramArrayOfByte = com.tencent.mm.model.c.FE();
            paramt = aa.a(paramqv.sQs);
            if (paramqv.ttD == 1)
            {
              paramBoolean = true;
              if (paramqv.ttU != 1) {
                break label271;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              paramArrayOfByte.c(paramt, paramBoolean, bool);
              return;
              paramBoolean = false;
              break;
            }
          }
          y.e("MicroMsg.BigBallOfMudSyncExtension", "unknown micro blog type:" + paramqv.ttT);
          return;
          paramqv = (awy)new awy().aH(paramArrayOfByte);
          if (paramqv != null)
          {
            y.d("MicroMsg.BigBallOfMudSyncExtension", "processModChatRoomMember username:" + paramqv.sQs + " nickname:" + paramqv.tmw);
            paramt = aa.a(paramqv.sQs);
            au.Hx();
            paramArrayOfByte = com.tencent.mm.model.c.Fw().abl(paramt);
            paramArrayOfByte.setUsername(paramt);
            paramArrayOfByte.dk(aa.a(paramqv.tmw));
            paramArrayOfByte.dl(aa.a(paramqv.sQa));
            paramArrayOfByte.dm(aa.a(paramqv.sQb));
            paramArrayOfByte.fm(paramqv.ffh);
            paramArrayOfByte.df(aa.a(paramqv.tsS));
            paramArrayOfByte.jdMethod_do(aa.a(paramqv.tsU));
            paramArrayOfByte.dp(aa.a(paramqv.tsT));
            paramArrayOfByte.fp(paramqv.sPx);
            paramt = new h();
            paramt.bcw = -1;
            paramt.username = paramArrayOfByte.field_username;
            paramt.ebS = paramqv.sLE;
            paramt.ebT = paramqv.sLD;
            y.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl chatmember %s b[%s] s[%s]", new Object[] { paramt.getUsername(), paramt.JX(), paramt.JY() });
            paramt.bK(true);
            if ((paramqv.ttk == 3) || (paramqv.ttk == 4))
            {
              paramArrayOfByte.fl(paramqv.ttk);
              paramt.cCq = paramqv.ttk;
            }
            for (;;)
            {
              o.Kh().a(paramt);
              au.Hx();
              com.tencent.mm.model.c.Fw().U(paramArrayOfByte);
              paramt = com.tencent.mm.ai.z.My().kQ(paramArrayOfByte.field_username);
              paramt.field_username = paramArrayOfByte.field_username;
              paramt.field_brandList = paramqv.ffr;
              paramqv = paramqv.tpn;
              if (paramqv != null)
              {
                paramt.field_brandFlag = paramqv.ffv;
                paramt.field_brandInfo = paramqv.ffx;
                paramt.field_brandIconURL = paramqv.ffy;
                paramt.field_extInfo = paramqv.ffw;
              }
              if (com.tencent.mm.ai.z.My().e(paramt)) {
                break;
              }
              com.tencent.mm.ai.z.My().d(paramt);
              return;
              if (paramqv.ttk == 2)
              {
                paramArrayOfByte.fl(3);
                paramt.cCq = 3;
                paramArrayOfByte.fl(3);
                if (!com.tencent.mm.model.q.Gj().equals(paramArrayOfByte.field_username))
                {
                  o.JQ();
                  com.tencent.mm.ag.d.B(paramArrayOfByte.field_username, false);
                  o.JQ();
                  com.tencent.mm.ag.d.B(paramArrayOfByte.field_username, true);
                  o.Kj().kb(paramArrayOfByte.field_username);
                }
              }
            }
            paramqv = (zr)new zr().aH(paramArrayOfByte);
            switch (paramqv.sYS)
            {
            case 4: 
            case 2: 
            case 3: 
            default: 
              y.e("MicroMsg.BigBallOfMudSyncExtension", "unknown function switch id:" + paramqv.sYS);
              return;
            }
            au.Hx();
            com.tencent.mm.model.c.Dz().o(17, Integer.valueOf(paramqv.nfn));
            return;
            paramqv = (bwu)new bwu().aH(paramArrayOfByte);
            if (paramqv != null)
            {
              paramBoolean = true;
              Assert.assertTrue(paramBoolean);
              if (bk.pm(paramqv.hPY).length() <= 0) {
                break label946;
              }
            }
            for (paramBoolean = true;; paramBoolean = false)
            {
              Assert.assertTrue(paramBoolean);
              if (ad.aaR(paramqv.hPY)) {
                break label951;
              }
              y.w("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: tcontact should ends with @t.qq.com");
              return;
              paramBoolean = false;
              break;
            }
            au.Hx();
            paramArrayOfByte = com.tencent.mm.model.c.Fw().abl(paramqv.hPY);
            if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.dBe == 0))
            {
              paramArrayOfByte = new ad(paramqv.hPY);
              paramArrayOfByte.df(paramqv.sLC);
              paramArrayOfByte.fp(1);
              paramArrayOfByte.AN();
              au.Hx();
              if (com.tencent.mm.model.c.Fw().W(paramArrayOfByte) == -1)
              {
                y.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: insert contact failed");
                return;
              }
              paramArrayOfByte = paramArrayOfByte.field_username;
              if (paramArrayOfByte == null) {
                y.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
              }
            }
            for (;;)
            {
              paramArrayOfByte = new rr();
              paramArrayOfByte.cbj.opType = 1;
              paramArrayOfByte.cbj.bVI = paramqv.hPY;
              paramArrayOfByte.cbj.bVJ = paramqv.tBs;
              paramArrayOfByte.cbj.bVK = paramqv.sPE;
              com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte);
              return;
              if (!paramArrayOfByte.endsWith("@t.qq.com"))
              {
                y.w("MicroMsg.AvatarLogic", "setMBTAvatarImgFlag failed : invalid username");
              }
              else
              {
                paramt = new h();
                paramt.username = paramArrayOfByte;
                paramt.cCq = 3;
                paramt.bcw = 3;
                o.Kh().a(paramt);
                continue;
                if (!bk.pm(paramqv.sLC).equals(bk.pm(paramArrayOfByte.field_username)))
                {
                  paramArrayOfByte.df(paramqv.sLC);
                  au.Hx();
                  if (com.tencent.mm.model.c.Fw().a(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
                    y.e("MicroMsg.BigBallOfMudSyncExtension", "processModTContact: update contact failed");
                  }
                }
              }
            }
            paramqv = (bgs)new bgs().aH(paramArrayOfByte);
            if (paramqv != null)
            {
              paramBoolean = true;
              Assert.assertTrue(paramBoolean);
              if (bk.pm(paramqv.hPY).length() <= 0) {
                break label1300;
              }
            }
            for (paramBoolean = true;; paramBoolean = false)
            {
              Assert.assertTrue(paramBoolean);
              if (ad.aaT(paramqv.hPY)) {
                break label1305;
              }
              y.w("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: qcontact should ends with @t.qq.com");
              return;
              paramBoolean = false;
              break;
            }
            au.Hx();
            paramArrayOfByte = com.tencent.mm.model.c.Fw().abl(paramqv.hPY);
            if ((paramArrayOfByte == null) || ((int)paramArrayOfByte.dBe == 0))
            {
              paramArrayOfByte = new ad(paramqv.hPY);
              paramArrayOfByte.AN();
              paramArrayOfByte.dk(paramqv.sLC);
              paramArrayOfByte.df(paramqv.sLC);
              paramArrayOfByte.fp(4);
              au.Hx();
              if (com.tencent.mm.model.c.Fw().W(paramArrayOfByte) == -1)
              {
                y.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: insert contact failed");
                return;
              }
              com.tencent.mm.ag.b.jX(paramArrayOfByte.field_username);
            }
            for (;;)
            {
              paramArrayOfByte = new mj();
              paramArrayOfByte.bVE.opType = 1;
              paramArrayOfByte.bVE.bVI = paramqv.hPY;
              paramArrayOfByte.bVE.bVJ = paramqv.tBs;
              paramArrayOfByte.bVE.bVK = paramqv.sPE;
              com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte);
              return;
              if (!bk.pm(paramqv.sLC).equals(bk.pm(paramArrayOfByte.field_username)))
              {
                paramArrayOfByte.dk(paramqv.sLC);
                paramArrayOfByte.df(paramqv.sLC);
                au.Hx();
                if (com.tencent.mm.model.c.Fw().a(paramArrayOfByte.field_username, paramArrayOfByte) == -1) {
                  y.e("MicroMsg.BigBallOfMudSyncExtension", "processModQContact: update contact failed");
                }
              }
            }
            paramqv = (awv)new awv().aH(paramArrayOfByte);
            if (paramqv != null)
            {
              paramBoolean = true;
              Assert.assertTrue(paramBoolean);
              if (bk.pm(paramqv.hPY).length() <= 0) {
                break label1827;
              }
              paramBoolean = true;
              Assert.assertTrue(paramBoolean);
              paramArrayOfByte = new ad();
              paramArrayOfByte.setUsername(paramqv.hPY);
              paramArrayOfByte.setType(paramqv.hQR);
              paramArrayOfByte.fm(paramqv.ffh);
              paramArrayOfByte.dF(RegionCodeDecoder.ao(paramqv.ffq, paramqv.ffi, paramqv.ffj));
              paramArrayOfByte.dz(paramqv.ffk);
              paramt = new h();
              paramt.bcw = -1;
              paramt.username = paramqv.hPY;
              paramt.ebS = paramqv.sLE;
              paramt.ebT = paramqv.sLD;
              y.d("MicroMsg.BigBallOfMudSyncExtension", "dkhurl bottle %s b[%s] s[%s]", new Object[] { paramt.getUsername(), paramt.JX(), paramt.JY() });
              y.d("MicroMsg.BigBallOfMudSyncExtension", "bottlecontact imgflag:" + paramqv.ttk + " hd:" + paramqv.ttl);
              if (paramqv.ttl == 0) {
                break label1832;
              }
              paramBoolean = true;
              paramt.bK(paramBoolean);
              if ((paramqv.ttk != 3) && (paramqv.ttk != 4)) {
                break label1837;
              }
              paramArrayOfByte.fl(paramqv.ttk);
              paramt.cCq = paramqv.ttk;
            }
            for (;;)
            {
              o.Kh().a(paramt);
              au.Hx();
              com.tencent.mm.model.c.Fw().T(paramArrayOfByte);
              return;
              paramBoolean = false;
              break;
              paramBoolean = false;
              break label1571;
              paramBoolean = false;
              break label1759;
              if (paramqv.ttk == 2)
              {
                paramArrayOfByte.fl(3);
                paramt.cCq = 3;
                o.JQ();
                com.tencent.mm.ag.d.B(paramqv.hPY, false);
                o.JQ();
                com.tencent.mm.ag.d.B(paramqv.hPY, true);
                o.Kj().kb(paramqv.hPY);
              }
              else
              {
                paramArrayOfByte.fl(3);
                paramt.cCq = 3;
              }
            }
            paramt = (axw)new axw().aH(paramArrayOfByte);
            int j;
            int i;
            if (paramt != null)
            {
              paramBoolean = true;
              Assert.assertTrue(paramBoolean);
              paramqv = com.tencent.mm.model.q.Gj();
              j = paramt.sDZ;
              if (j != 2) {
                break label2215;
              }
              paramqv = ad.aaZ(paramqv);
              au.Hx();
              paramArrayOfByte = (String)com.tencent.mm.model.c.Dz().get(12553, null);
              paramBoolean = false;
              if ((paramArrayOfByte == null) || (!paramArrayOfByte.equals(paramt.tud)))
              {
                o.JQ();
                com.tencent.mm.ag.d.B(paramqv, true);
                au.Hx();
                paramArrayOfByte = com.tencent.mm.model.c.Dz();
                if (j != 2) {
                  break label2236;
                }
                i = 12553;
                paramArrayOfByte.o(i, paramt.tud);
                paramBoolean = true;
              }
              y.d("MicroMsg.BigBallOfMudSyncExtension", "ModUserImg beRemove:%b imgtype:%d md5:%s big:%s sm:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramt.tud, paramt.sLD, paramt.sLE });
              paramArrayOfByte = new h();
              paramArrayOfByte.username = paramqv;
              paramArrayOfByte.ebT = paramt.sLD;
              paramArrayOfByte.ebS = paramt.sLE;
              if (!bk.bl(paramArrayOfByte.JY()))
              {
                if (j != 1) {
                  break label2244;
                }
                au.Hx();
                com.tencent.mm.model.c.Dz().o(59, Boolean.valueOf(true));
              }
            }
            for (;;)
            {
              paramArrayOfByte.bK(false);
              paramArrayOfByte.bcw = 56;
              if (!bk.bl(paramt.tud)) {
                paramArrayOfByte.bK(true);
              }
              o.Kh().a(paramArrayOfByte);
              if (!paramBoolean) {
                break;
              }
              new com.tencent.mm.ag.e().a(paramqv, new a.1(this));
              return;
              paramBoolean = false;
              break label1932;
              au.Hx();
              paramArrayOfByte = (String)com.tencent.mm.model.c.Dz().get(12297, null);
              break label1976;
              i = 12297;
              break label2023;
              au.Hx();
              com.tencent.mm.model.c.Dz().o(60, Boolean.valueOf(true));
            }
            paramt = (ccb)new ccb().aH(paramArrayOfByte);
            y.d("MicroMsg.BigBallOfMudSyncExtension", "snsExtFlag " + paramt.tpm.ffs);
            au.Hx();
            String str = (String)com.tencent.mm.model.c.Dz().get(2, null);
            if ((str != null) && (str.length() > 0))
            {
              if (com.tencent.mm.plugin.sns.b.n.omD != null) {
                com.tencent.mm.plugin.sns.b.n.omD.a(str, paramt.tpm);
              }
              paramArrayOfByte = f.kX(com.tencent.mm.model.q.Gj());
              paramqv = paramArrayOfByte;
              if (paramArrayOfByte == null) {
                paramqv = new com.tencent.mm.ai.d();
              }
              paramqv.field_username = str;
              paramqv.field_brandList = paramt.ffr;
              if ((paramqv.Lz()) && (paramqv.bS(false) != null) && (paramqv.bS(false).Mb() != null) && (!bk.bl(paramqv.LG())))
              {
                paramqv.field_enterpriseFather = paramqv.LG();
                y.d("MicroMsg.BigBallOfMudSyncExtension", "processModUserInfoExt, %s set enterpriseFather %s", new Object[] { str, paramqv.field_enterpriseFather });
              }
              if (!com.tencent.mm.ai.z.My().e(paramqv)) {
                com.tencent.mm.ai.z.My().d(paramqv);
              }
              i = paramt.tRh;
              j = paramt.tRi;
              int k = paramt.tRj;
              y.d("MicroMsg.BigBallOfMudSyncExtension", "roomSize :" + i + " rommquota: " + j + " invite: " + k);
              au.Hx();
              com.tencent.mm.model.c.Dz().o(135175, Integer.valueOf(i));
              au.Hx();
              com.tencent.mm.model.c.Dz().o(135176, Integer.valueOf(j));
              au.Hx();
              com.tencent.mm.model.c.Dz().o(135177, Integer.valueOf(k));
              au.Hx();
              com.tencent.mm.model.c.Dz().o(144385, Integer.valueOf(paramt.tRn));
              au.Hx();
              com.tencent.mm.model.c.Dz().c(ac.a.usE, Integer.valueOf(paramt.sZT));
              au.Hx();
              com.tencent.mm.model.c.Dz().o(339975, Integer.valueOf(paramt.tRv));
              y.i("MicroMsg.BigBallOfMudSyncExtension", "hy: sync do cmd pay wallet type: %d %d", new Object[] { Integer.valueOf(paramt.tRv), Integer.valueOf(paramt.sZT) });
              au.Hx();
              com.tencent.mm.model.c.Dz().c(ac.a.uqI, bk.aM(paramt.cCO, ""));
              y.d("MicroMsg.BigBallOfMudSyncExtension", "weidianinfo:%s", new Object[] { paramt.cCO });
              au.Hx();
              com.tencent.mm.model.c.Dz().o(147457, Long.valueOf(paramt.tRw));
              au.Hx();
              com.tencent.mm.model.c.Dz().c(ac.a.uuM, paramt.tRx);
              paramqv = new h();
              paramqv.bcw = -1;
              paramqv.username = str;
              paramqv.ebT = paramt.sLD;
              paramqv.ebS = paramt.sLE;
              paramqv.bK(true);
              paramqv.cCq = 3;
              y.d("MicroMsg.BigBallOfMudSyncExtension", "dkavatar user:[%s] big:[%s] sm:[%s]", new Object[] { paramqv.getUsername(), paramqv.JX(), paramqv.JY() });
              o.Kh().a(paramqv);
              paramqv = paramt.ttv;
              paramArrayOfByte = paramt.ttw;
              au.Hx();
              com.tencent.mm.model.c.Dz().o(274433, paramArrayOfByte);
              au.Hx();
              com.tencent.mm.model.c.Dz().o(274434, paramqv);
              if (paramt.svV != null)
              {
                au.Hx();
                com.tencent.mm.model.c.Dz().o(286721, paramt.svV.sBf);
                au.Hx();
                com.tencent.mm.model.c.Dz().o(286722, paramt.svV.sBg);
                au.Hx();
                com.tencent.mm.model.c.Dz().o(286723, paramt.svV.sBh);
              }
              if ((paramt.tRt != null) && (paramt.tRt.tyh != null) && (paramt.tRt.tyh.tFK > 0))
              {
                y.i("MicroMsg.BigBallOfMudSyncExtension", "tomgest PatternLockInfo %d", new Object[] { Integer.valueOf(paramt.tRt.tyh.tFK) });
                paramqv = new sm();
                paramqv.ccb.ccc = paramt.tRt;
                com.tencent.mm.sdk.b.a.udP.m(paramqv);
                return;
                try
                {
                  i = com.tencent.mm.a.n.q(paramArrayOfByte, 0);
                  y.d("MicroMsg.BigBallOfMudSyncExtension", "local test synccmd, sleep %d", new Object[] { Integer.valueOf(i) });
                  if (i > 0)
                  {
                    Thread.sleep(i);
                    return;
                  }
                }
                catch (InterruptedException paramqv)
                {
                  y.printErrStackTrace("MicroMsg.BigBallOfMudSyncExtension", paramqv, "", new Object[0]);
                  return;
                }
              }
            }
          }
        }
        paramqv = (ayu)new ayu().aH(paramArrayOfByte);
        y.d("MicroMsg.BigBallOfMudSyncExtension", "rollback, msgtype is %d, msgid is %d", new Object[] { Integer.valueOf(paramqv.kSW), Long.valueOf(paramqv.ndp) });
      } while (!s.hB(paramqv.kWn));
      label1300:
      label1305:
      label1571:
      label1832:
      label1837:
      label1976:
      label2236:
      label2244:
      paramArrayOfByte = new om();
      label1827:
      label2215:
      paramArrayOfByte.bYd.bIt = paramqv.ndp;
      label1932:
      com.tencent.mm.sdk.b.a.udP.m(paramArrayOfByte);
      return;
    }
    paramqv = new pw();
    paramqv.bZv.data = paramArrayOfByte;
    com.tencent.mm.sdk.b.a.udP.m(paramqv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelmulti.a
 * JD-Core Version:    0.7.0.1
 */