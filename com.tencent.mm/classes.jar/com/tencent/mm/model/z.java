package com.tencent.mm.model;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.c.chw;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bs;

public final class z
{
  public static void a(bzo parambzo, boolean paramBoolean)
  {
    int j = parambzo.tPu;
    int i;
    label91:
    com.tencent.mm.storage.z localz;
    Object localObject1;
    long l;
    label245:
    boolean bool;
    label257:
    label665:
    String str1;
    String str2;
    int k;
    Object localObject2;
    if (parambzo.tPv == null)
    {
      i = -1;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), parambzo.tPv, parambzo.tPw, parambzo.tPx, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (parambzo.tPv == null)) {
        break label1238;
      }
      i = parambzo.tPv.jwX;
      g.DQ();
      g.hx(i);
      com.tencent.mm.kernel.a.b.e.Ej().stop();
      localz = g.DP().Dz();
      localz.o(256, Boolean.valueOf(false));
      if ((j & 0x1) != 0)
      {
        if (parambzo.tPv.syv <= 0) {
          break label1301;
        }
        localz.c(ac.a.unA, Long.valueOf(parambzo.tPv.syv));
        localz.c(ac.a.unC, Long.valueOf(bk.UX()));
        localz.c(ac.a.unB, Long.valueOf(com.tencent.mm.protocal.d.spa));
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(parambzo.tPv.syv), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1257;
        }
        localObject1 = f.nEG;
        if (parambzo.tPv.syv != 2) {
          break label1249;
        }
        l = 19L;
        ((f)localObject1).a(148L, l, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1349;
      }
      localObject1 = parambzo.tPw;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { o.getString(((ar)localObject1).stM), Integer.valueOf(((ar)localObject1).hQq), ((ar)localObject1).hPY, ((ar)localObject1).hRf, ((ar)localObject1).stN, ((ar)localObject1).stO, ((ar)localObject1).ffm, Integer.valueOf(((ar)localObject1).stP), Integer.valueOf(((ar)localObject1).stQ), ((ar)localObject1).stR, Integer.valueOf(((ar)localObject1).stS), ((ar)localObject1).stT, ((ar)localObject1).stT, Integer.valueOf(((ar)localObject1).stV), ((ar)localObject1).stW });
      if (!paramBoolean) {
        localz.o(52, Integer.valueOf(((ar)localObject1).stQ));
      }
      localz.o(9, Integer.valueOf(((ar)localObject1).stM));
      localz.o(7, Integer.valueOf(((ar)localObject1).hQq));
      localz.o(2, ((ar)localObject1).hPY);
      localz.o(4, ((ar)localObject1).hRf);
      localz.o(5, ((ar)localObject1).stN);
      localz.o(6, ((ar)localObject1).stO);
      localz.o(42, ((ar)localObject1).ffm);
      localz.o(34, Integer.valueOf(((ar)localObject1).stP));
      g.DP().DA().acq(((ar)localObject1).stR);
      localz.o(64, Integer.valueOf(((ar)localObject1).stS));
      localz.o(21, ((ar)localObject1).stT);
      localz.o(22, ((ar)localObject1).stT);
      localz.o(17, Integer.valueOf(((ar)localObject1).stV));
      at.dVC.Y("login_weixin_username", ((ar)localObject1).hPY);
      at.dVC.Y("last_login_nick_name", ((ar)localObject1).hRf);
      at.dVC.c(((ar)localObject1).stO, ((ar)localObject1).stM, ((ar)localObject1).stN);
      bool = false;
      if ((j & 0x1) == 0) {
        break label1497;
      }
      localObject1 = parambzo.tPv;
      str1 = ((eq)localObject1).syp;
      str2 = bk.bG(aa.a(((eq)localObject1).syq));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((eq)localObject1).syt, Integer.valueOf(((eq)localObject1).syu), Integer.valueOf(((eq)localObject1).syv), Integer.valueOf(((eq)localObject1).syw), bk.aac(str1), bk.aac(str2), ((eq)localObject1).stW });
      k = ((eq)localObject1).syj;
      localObject2 = new o(bk.g((Integer)localz.get(9, Integer.valueOf(0))));
      if (((eq)localObject1).syk != null) {
        break label1360;
      }
      i = -1;
      label821:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject2, Integer.valueOf(i) });
      if (k == 0) {
        break label1491;
      }
      if (k != 1) {
        break label1372;
      }
      f.nEG.a(148L, 20L, 1L, false);
      byte[] arrayOfByte = aa.a(((eq)localObject1).syk);
      bool = g.DN().CU().a(((o)localObject2).longValue(), arrayOfByte);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      localObject2 = bk.bG(g.DN().CU().bI(((o)localObject2).longValue()));
      localz.o(-1535680990, str1);
      localz.o(46, str2);
      localz.o(72, localObject2);
      localz.o(29, ((eq)localObject1).stW);
      label986:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((eq)localObject1).syl != null)
      {
        localObject1 = bk.bG(aa.a(((eq)localObject1).syl.sBT));
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localz.o(47, localObject1);
          g.DP().dKo.set(18, localObject1);
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { bk.aac((String)localObject1) });
      }
      label1085:
      if ((j & 0x4) == 0) {
        break label1522;
      }
      f.nEG.a(148L, 23L, 1L, false);
      parambzo = parambzo.tPx;
      av.a(false, parambzo.sBE, parambzo.sBF, parambzo.sBD);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        i = 4;
        parambzo = q.Gj();
        if (bool)
        {
          i = 1;
          parambzo = q.Gi();
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.b.d.r(1, i, parambzo);
      }
      localz.o(3, "");
      localz.o(19, "");
      localz.mC(true);
      g.DP().dKo.setInt(46, 0);
      a.Fq();
      return;
      i = parambzo.tPv.syv;
      break;
      label1238:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label91;
      label1249:
      l = 41L;
      break label245;
      label1257:
      localObject1 = f.nEG;
      if (parambzo.tPv.syv == 2) {}
      for (l = 10L;; l = 11L)
      {
        ((f)localObject1).a(148L, l, 1L, true);
        break;
      }
      label1301:
      localz.c(ac.a.unA, Long.valueOf(parambzo.tPv.syv));
      localz.c(ac.a.unC, Long.valueOf(bk.UX()));
      localz.c(ac.a.unB, Long.valueOf(0L));
      break label257;
      label1349:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label665;
      label1360:
      i = ((eq)localObject1).syk.tFK;
      break label821;
      label1372:
      if (k == 2)
      {
        f.nEG.a(148L, 21L, 1L, false);
        g.DN().CU().bJ(((o)localObject2).longValue());
        localObject2 = bk.bG(g.DN().CU().bI(((o)localObject2).longValue()));
        localz.o(-1535680990, str1);
        localz.o(46, str2);
        localz.o(72, localObject2);
        localz.o(29, ((eq)localObject1).stW);
        bool = false;
        break label986;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
      label1491:
      bool = false;
      break label986;
      label1497:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      f.nEG.a(148L, 22L, 1L, false);
      break label1085;
      label1522:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.z
 * JD-Core Version:    0.7.0.1
 */