package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ac;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.fhe;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.cl;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj
{
  public static void a(evr paramevr, boolean paramBoolean)
  {
    AppMethodBeat.i(134110);
    int j = paramevr.Uxh;
    int i;
    label96:
    Object localObject1;
    Object localObject2;
    label257:
    label269:
    label677:
    Object localObject3;
    String str;
    int k;
    Object localObject4;
    if (paramevr.Uxi == null)
    {
      i = -1;
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramevr.Uxi, paramevr.Uxj, paramevr.Uxk, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (paramevr.Uxi == null)) {
        break label1504;
      }
      i = paramevr.Uxi.vhf;
      z.uI(paramevr.Uxi.RMj);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.sG(i);
      com.tencent.mm.kernel.a.b.e.aIn();
      localObject1 = com.tencent.mm.kernel.h.aHG().aHp();
      ((ao)localObject1).i(256, Boolean.FALSE);
      if ((j & 0x1) != 0)
      {
        if (paramevr.Uxi.RMi <= 0) {
          break label1567;
        }
        ((ao)localObject1).set(ar.a.Vgi, Long.valueOf(paramevr.Uxi.RMi));
        ((ao)localObject1).set(ar.a.Vgk, Long.valueOf(Util.nowSecond()));
        ((ao)localObject1).set(ar.a.Vgj, Long.valueOf(d.RAD));
        Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(paramevr.Uxi.RMi), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1523;
        }
        localObject2 = com.tencent.mm.plugin.report.f.Iyx;
        if (paramevr.Uxi.RMi != 2) {
          break label1515;
        }
        l1 = 19L;
        ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(148L, l1, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1615;
      }
      localObject2 = paramevr.Uxj;
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { p.getString(((ay)localObject2).RFr), Integer.valueOf(((ay)localObject2).rVU), ((ay)localObject2).UserName, ((ay)localObject2).rWI, ((ay)localObject2).RFs, ((ay)localObject2).RFt, ((ay)localObject2).mVD, Integer.valueOf(((ay)localObject2).RFu), Integer.valueOf(((ay)localObject2).RFv), ((ay)localObject2).RFw, Integer.valueOf(((ay)localObject2).RFx), ((ay)localObject2).RFy, ((ay)localObject2).RFy, Integer.valueOf(((ay)localObject2).RFA), ((ay)localObject2).RFB });
      if (!paramBoolean) {
        ((ao)localObject1).i(52, Integer.valueOf(((ay)localObject2).RFv));
      }
      ((ao)localObject1).i(9, Integer.valueOf(((ay)localObject2).RFr));
      ((ao)localObject1).i(7, Integer.valueOf(((ay)localObject2).rVU));
      ((ao)localObject1).i(2, ((ay)localObject2).UserName);
      ((ao)localObject1).i(4, ((ay)localObject2).rWI);
      ((ao)localObject1).i(5, ((ay)localObject2).RFs);
      ((ao)localObject1).i(6, ((ay)localObject2).RFt);
      ((ao)localObject1).i(42, ((ay)localObject2).mVD);
      ((ao)localObject1).i(34, Integer.valueOf(((ay)localObject2).RFu));
      com.tencent.mm.kernel.h.aHG().aHq().bxt(((ay)localObject2).RFw);
      ((ao)localObject1).i(64, Integer.valueOf(((ay)localObject2).RFx));
      ((ao)localObject1).i(21, ((ay)localObject2).RFy);
      ((ao)localObject1).i(22, ((ay)localObject2).RFy);
      ((ao)localObject1).i(17, Integer.valueOf(((ay)localObject2).RFA));
      bg.ltv.aS("login_weixin_username", ((ay)localObject2).UserName);
      bg.ltv.aS("last_login_nick_name", ((ay)localObject2).rWI);
      bg.ltv.j(((ay)localObject2).RFt, ((ay)localObject2).RFr, ((ay)localObject2).RFs);
      if (paramevr.Uxj != null)
      {
        cs.vh(paramevr.Uxj.RFD);
        cs.a(paramevr.Uxj.RFE);
        cs.a(paramevr.Uxj.RFF);
      }
      if ((!paramBoolean) && (com.tencent.mm.kernel.h.aHB())) {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDS, Boolean.TRUE);
      }
      if ((j & 0x1) == 0) {
        break label1772;
      }
      localObject2 = paramevr.Uxi;
      localObject3 = ((ha)localObject2).RMc;
      str = Util.encodeHexString(com.tencent.mm.platformtools.z.a(((ha)localObject2).RMd));
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((ha)localObject2).RMg, Integer.valueOf(((ha)localObject2).RMh), Integer.valueOf(((ha)localObject2).RMi), Integer.valueOf(((ha)localObject2).RMj), Util.secPrint((String)localObject3), Util.secPrint(str), ((ha)localObject2).RFB });
      k = ((ha)localObject2).RLW;
      localObject4 = new p(Util.nullAsNil((Integer)((ao)localObject1).b(9, Integer.valueOf(0))));
      if (((ha)localObject2).RLX != null) {
        break label1626;
      }
      i = -1;
      label893:
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject4, Integer.valueOf(i) });
      if (k != 0)
      {
        if (k != 1) {
          break label1638;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 20L, 1L, false);
        byte[] arrayOfByte = com.tencent.mm.platformtools.z.a(((ha)localObject2).RLX);
        com.tencent.mm.kernel.h.aHE().aGC().a(((p)localObject4).longValue(), arrayOfByte);
        Log.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
        localObject4 = Util.encodeHexString(com.tencent.mm.kernel.h.aHE().aGC().Gr(((p)localObject4).longValue()));
        ((ao)localObject1).i(-1535680990, localObject3);
        ((ao)localObject1).i(46, str);
        ((ao)localObject1).i(72, localObject4);
        ((ao)localObject1).i(29, ((ha)localObject2).RFB);
      }
      label1057:
      if (!paramBoolean)
      {
        localObject3 = ((ha)localObject2).RLX;
        if ((localObject3 == null) || (((eae)localObject3).Ufv == 0))
        {
          Log.i("MicroMsg.HandleAuthResponse", "maybe no qq login");
          if (com.tencent.mm.kernel.h.aHB()) {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VDS, Boolean.FALSE);
          }
        }
      }
      Log.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((ha)localObject2).RLY != null)
      {
        localObject3 = Util.encodeHexString(com.tencent.mm.platformtools.z.a(((ha)localObject2).RLY.RRy));
        if ((localObject3 != null) && (((String)localObject3).length() > 0))
        {
          ((ao)localObject1).i(47, localObject3);
          com.tencent.mm.kernel.h.aHG().kcw.i(18, localObject3);
        }
        Log.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { Util.secPrint((String)localObject3) });
      }
      localObject3 = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.avK()).edit();
      if (((ha)localObject2).RMo != 1) {
        break label1757;
      }
      paramBoolean = true;
      label1239:
      paramBoolean = ((SharedPreferences.Editor)localObject3).putBoolean("auth_info_prefs_use_new_ecdh", paramBoolean).commit();
      k = ((ha)localObject2).RMo;
      if (!paramBoolean) {
        break label1762;
      }
      i = 1;
      label1269:
      Log.i("MicroMsg.HandleAuthResponse", "summerauth get ecdh flag %d, set local cache %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if (((ha)localObject2).RMo != 1) {
        break label1767;
      }
      paramBoolean = true;
      label1307:
      com.tencent.mm.protocal.f.RAO = paramBoolean;
      label1311:
      if ((j & 0x4) == 0) {
        break label1797;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 23L, 1L, false);
      localObject2 = paramevr.Uxk;
      bi.a(false, ((dcb)localObject2).RRi, ((dcb)localObject2).RRj, ((dcb)localObject2).RRh, false, 0);
      label1358:
      ((ao)localObject1).i(3, "");
      ((ao)localObject1).i(19, "");
      ((ao)localObject1).hxT();
      com.tencent.mm.kernel.h.aHG().kcw.setInt(46, 0);
      if (!a.bbF()) {}
    }
    long l2;
    for (;;)
    {
      try
      {
        com.tencent.mm.kernel.h.aHH();
        localObject1 = com.tencent.mm.kernel.h.aHE().kbH;
        com.tencent.mm.kernel.h.aHH();
        localObject2 = com.tencent.mm.kernel.h.aHF().kcd.lCD.biw();
        l2 = Util.nowMilliSecond();
        if (localObject2 != null) {
          continue;
        }
        Log.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(226L, 2L, 1L, false);
      }
      catch (Throwable localThrowable)
      {
        label1504:
        label1515:
        label1523:
        Log.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[] { Util.stackTraceToString(localThrowable) });
        label1567:
        label1615:
        label1626:
        label1638:
        label1767:
        label1772:
        continue;
        label1757:
        label1762:
        localThrowable.lqP = ((com.tencent.mm.network.e)localObject2).bit();
        label1797:
        localObject2 = com.tencent.mm.plugin.report.f.Iyx;
        if (localThrowable.bbE() <= 0) {
          break label2109;
        }
      }
      if ((j & 0x8) == 0) {
        break label2095;
      }
      Log.d("MicroMsg.HandleAuthResponse", "start parse axauth ");
      a(paramevr.Uxl);
      AppMethodBeat.o(134110);
      return;
      i = paramevr.Uxi.RMi;
      break;
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label96;
      l1 = 41L;
      break label257;
      localObject2 = com.tencent.mm.plugin.report.f.Iyx;
      if (paramevr.Uxi.RMi == 2)
      {
        l1 = 10L;
        ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(148L, l1, 1L, true);
        break label269;
      }
      l1 = 11L;
      continue;
      ((ao)localObject1).set(ar.a.Vgi, Long.valueOf(paramevr.Uxi.RMi));
      ((ao)localObject1).set(ar.a.Vgk, Long.valueOf(Util.nowSecond()));
      ((ao)localObject1).set(ar.a.Vgj, Long.valueOf(0L));
      break label269;
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label677;
      i = ((ha)localObject2).RLX.Ufv;
      break label893;
      if (k == 2)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 21L, 1L, false);
        com.tencent.mm.kernel.h.aHE().aGC().Gs(((p)localObject4).longValue());
        localObject4 = Util.encodeHexString(com.tencent.mm.kernel.h.aHE().aGC().Gr(((p)localObject4).longValue()));
        ((ao)localObject1).i(-1535680990, localObject3);
        ((ao)localObject1).i(46, str);
        ((ao)localObject1).i(72, localObject4);
        ((ao)localObject1).i(29, ((ha)localObject2).RFB);
        break label1057;
      }
      Log.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
      break label1057;
      paramBoolean = false;
      break label1239;
      i = 0;
      break label1269;
      paramBoolean = false;
      break label1307;
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 22L, 1L, false);
      break label1311;
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
      break label1358;
      Log.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.network.e)localObject2).biq()), Integer.valueOf(((a)localObject1).bbE()) });
      if (((com.tencent.mm.network.e)localObject2).biq()) {
        continue;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(226L, 3L, 1L, false);
      Log.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
    }
    label2095:
    label2109:
    for (long l1 = 4L;; l1 = 5L)
    {
      ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(226L, l1, 1L, false);
      Log.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(Util.milliSecondsToNow(l2)), Integer.valueOf(localThrowable.bbE()), Long.valueOf(localThrowable.lqQ) });
      if (localThrowable.bbE() <= 0) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.report.f.Iyx;
      if (localThrowable.lqQ > 5L) {}
      for (l1 = 5L;; l1 = localThrowable.lqQ)
      {
        ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(226L, 31L - l1, 1L, false);
        com.tencent.mm.plugin.report.f.Iyx.a(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.lqQ) });
        localThrowable.lqQ = -1L;
        break;
      }
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile axauthsect no set!");
      AppMethodBeat.o(134110);
      return;
    }
  }
  
  public static void a(hw paramhw)
  {
    AppMethodBeat.i(134111);
    if (paramhw == null) {}
    Object localObject1;
    for (int i = -1;; i = paramhw.rVx)
    {
      Log.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.h.aHH();
      localObject1 = com.tencent.mm.kernel.h.aHF().kcd.lCD;
      if ((localObject1 != null) && (((com.tencent.mm.network.g)localObject1).biw() != null)) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    ((com.tencent.mm.network.g)localObject1).biw().biv();
    if ((paramhw == null) || (paramhw.rVx == 0))
    {
      Log.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
      AppMethodBeat.o(134111);
      return;
    }
    LinkedList localLinkedList = paramhw.rVy;
    if ((localLinkedList == null) || (localLinkedList.size() != paramhw.rVx)) {
      if (localLinkedList != null) {
        break label210;
      }
    }
    label210:
    for (i = -1;; i = localLinkedList.size())
    {
      Log.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramhw.rVx) });
      Log.d("MicroMsg.HandleAuthResponse", "axauth list size " + localLinkedList.size());
      if (localLinkedList.size() != 0) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    paramhw = localLinkedList.iterator();
    while (paramhw.hasNext())
    {
      Object localObject2 = (hv)paramhw.next();
      i = ((hv)localObject2).CQK;
      Object localObject3 = ((hv)localObject2).RNm;
      String[] arrayOfString;
      int[] arrayOfInt;
      try
      {
        Log.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i)));
        ((com.tencent.mm.network.g)localObject1).biw().i(i, ((cke)localObject3).toByteArray());
        localObject2 = new String[((cke)localObject3).rVy.size()];
        arrayOfString = new String[((cke)localObject3).rVy.size()];
        arrayOfInt = new int[((cke)localObject3).rVy.size()];
        Log.i("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", new Object[] { Integer.valueOf(((cke)localObject3).rVx) });
        localObject3 = ((cke)localObject3).rVy.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          ckd localckd = (ckd)((Iterator)localObject3).next();
          Log.i("MicroMsg.HandleAuthResponse", "ax host org:%s sub:%s", new Object[] { localckd.TrK, localckd.TrL });
          localObject2[i] = localckd.TrK;
          arrayOfString[i] = localckd.TrL;
          arrayOfInt[i] = localckd.TrM;
          int j = i + 1;
          i = j;
          if (!Util.isNullOrNil(localckd.TrK))
          {
            i = j;
            if (!Util.isNullOrNil(localckd.TrL)) {
              i = j;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.HandleAuthResponse", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        }
      }
      if ((localException.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.g)localObject1).addHostInfo(localException, arrayOfString, arrayOfInt);
      }
    }
    paramhw = localLinkedList.iterator();
    while (paramhw.hasNext())
    {
      localObject1 = (hv)paramhw.next();
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134109);
          Log.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
          com.tencent.mm.kernel.h.aGY().a(new ag(this.ltm), 0);
          AppMethodBeat.o(134109);
        }
      });
    }
    AppMethodBeat.o(134111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.aj
 * JD-Core Version:    0.7.0.1
 */