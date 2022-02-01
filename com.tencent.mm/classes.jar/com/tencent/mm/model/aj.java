package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.am.s;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.protobuf.gdq;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.co;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj
{
  public static void a(frg paramfrg, boolean paramBoolean)
  {
    AppMethodBeat.i(134110);
    int j = paramfrg.abQP;
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
    if (paramfrg.abQQ == null)
    {
      i = -1;
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramfrg.abQQ, paramfrg.abQR, paramfrg.abQS, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (paramfrg.abQQ == null)) {
        break label1504;
      }
      i = paramfrg.abQQ.yth;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.sC(i);
      com.tencent.mm.kernel.a.b.e.bbi();
      localObject1 = com.tencent.mm.kernel.h.baE().ban();
      ((aq)localObject1).B(256, Boolean.FALSE);
      z.uU(paramfrg.abQQ.YJx);
      if ((j & 0x1) != 0)
      {
        if (paramfrg.abQQ.YJw <= 0) {
          break label1567;
        }
        ((aq)localObject1).set(at.a.acHx, Long.valueOf(paramfrg.abQQ.YJw));
        ((aq)localObject1).set(at.a.acHz, Long.valueOf(Util.nowSecond()));
        ((aq)localObject1).set(at.a.acHy, Long.valueOf(d.Yxh));
        Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(paramfrg.abQQ.YJw), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1523;
        }
        localObject2 = com.tencent.mm.plugin.report.f.Ozc;
        if (paramfrg.abQQ.YJw != 2) {
          break label1515;
        }
        l1 = 19L;
        ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(148L, l1, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1615;
      }
      localObject2 = paramfrg.abQR;
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { p.getString(((ba)localObject2).YBU), Integer.valueOf(((ba)localObject2).vhk), ((ba)localObject2).UserName, ((ba)localObject2).vhX, ((ba)localObject2).YBV, ((ba)localObject2).YBW, ((ba)localObject2).pSk, Integer.valueOf(((ba)localObject2).YBX), Integer.valueOf(((ba)localObject2).YBY), ((ba)localObject2).YBZ, Integer.valueOf(((ba)localObject2).YCa), ((ba)localObject2).YCb, ((ba)localObject2).YCb, Integer.valueOf(((ba)localObject2).YCd), ((ba)localObject2).YCe });
      if (!paramBoolean) {
        ((aq)localObject1).B(52, Integer.valueOf(((ba)localObject2).YBY));
      }
      ((aq)localObject1).B(9, Integer.valueOf(((ba)localObject2).YBU));
      ((aq)localObject1).B(7, Integer.valueOf(((ba)localObject2).vhk));
      ((aq)localObject1).B(2, ((ba)localObject2).UserName);
      ((aq)localObject1).B(4, ((ba)localObject2).vhX);
      ((aq)localObject1).B(5, ((ba)localObject2).YBV);
      ((aq)localObject1).B(6, ((ba)localObject2).YBW);
      ((aq)localObject1).B(42, ((ba)localObject2).pSk);
      ((aq)localObject1).B(34, Integer.valueOf(((ba)localObject2).YBX));
      com.tencent.mm.kernel.h.baE().bao().byL(((ba)localObject2).YBZ);
      ((aq)localObject1).B(64, Integer.valueOf(((ba)localObject2).YCa));
      ((aq)localObject1).B(21, ((ba)localObject2).YCb);
      ((aq)localObject1).B(22, ((ba)localObject2).YCb);
      ((aq)localObject1).B(17, Integer.valueOf(((ba)localObject2).YCd));
      bg.okT.bc("login_weixin_username", ((ba)localObject2).UserName);
      bg.okT.bc("last_login_nick_name", ((ba)localObject2).vhX);
      bg.okT.k(((ba)localObject2).YBW, ((ba)localObject2).YBU, ((ba)localObject2).YBV);
      if (paramfrg.abQR != null)
      {
        ct.vr(paramfrg.abQR.YCg);
        ct.a(paramfrg.abQR.YCh);
        ct.a(paramfrg.abQR.YCi);
      }
      if ((!paramBoolean) && (com.tencent.mm.kernel.h.baz())) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adgT, Boolean.TRUE);
      }
      if ((j & 0x1) == 0) {
        break label1772;
      }
      localObject2 = paramfrg.abQQ;
      localObject3 = ((hw)localObject2).YJq;
      str = Util.encodeHexString(w.a(((hw)localObject2).YJr));
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((hw)localObject2).YJu, Integer.valueOf(((hw)localObject2).YJv), Integer.valueOf(((hw)localObject2).YJw), Integer.valueOf(((hw)localObject2).YJx), Util.secPrint((String)localObject3), Util.secPrint(str), ((hw)localObject2).YCe });
      k = ((hw)localObject2).YJk;
      localObject4 = new p(Util.nullAsNil((Integer)((aq)localObject1).d(9, Integer.valueOf(0))));
      if (((hw)localObject2).YJl != null) {
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
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 20L, 1L, false);
        byte[] arrayOfByte = w.a(((hw)localObject2).YJl);
        com.tencent.mm.kernel.h.baC().aZE().b(((p)localObject4).longValue(), arrayOfByte);
        Log.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
        localObject4 = Util.encodeHexString(com.tencent.mm.kernel.h.baC().aZE().iB(((p)localObject4).longValue()));
        ((aq)localObject1).B(-1535680990, localObject3);
        ((aq)localObject1).B(46, str);
        ((aq)localObject1).B(72, localObject4);
        ((aq)localObject1).B(29, ((hw)localObject2).YCe);
      }
      label1057:
      if (!paramBoolean)
      {
        localObject3 = ((hw)localObject2).YJl;
        if ((localObject3 == null) || (((gol)localObject3).abwJ == 0))
        {
          Log.i("MicroMsg.HandleAuthResponse", "maybe no qq login");
          if (com.tencent.mm.kernel.h.baz()) {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adgT, Boolean.FALSE);
          }
        }
      }
      Log.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((hw)localObject2).YJm != null)
      {
        localObject3 = Util.encodeHexString(w.a(((hw)localObject2).YJm.YOQ));
        if ((localObject3 != null) && (((String)localObject3).length() > 0))
        {
          ((aq)localObject1).B(47, localObject3);
          com.tencent.mm.kernel.h.baE().mCE.B(18, localObject3);
        }
        Log.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { Util.secPrint((String)localObject3) });
      }
      localObject3 = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.aQe()).edit();
      if (((hw)localObject2).YJC != 1) {
        break label1757;
      }
      paramBoolean = true;
      label1239:
      paramBoolean = ((SharedPreferences.Editor)localObject3).putBoolean("auth_info_prefs_use_new_ecdh", paramBoolean).commit();
      k = ((hw)localObject2).YJC;
      if (!paramBoolean) {
        break label1762;
      }
      i = 1;
      label1269:
      Log.i("MicroMsg.HandleAuthResponse", "summerauth get ecdh flag %d, set local cache %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if (((hw)localObject2).YJC != 1) {
        break label1767;
      }
      paramBoolean = true;
      label1307:
      com.tencent.mm.protocal.f.Yxs = paramBoolean;
      label1311:
      if ((j & 0x4) == 0) {
        break label1797;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 23L, 1L, false);
      localObject2 = paramfrg.abQS;
      bj.a(false, ((dtt)localObject2).YOA, ((dtt)localObject2).YOB, ((dtt)localObject2).YOz, false, 0);
      label1358:
      ((aq)localObject1).B(3, "");
      ((aq)localObject1).B(19, "");
      ((aq)localObject1).iZy();
      com.tencent.mm.kernel.h.baE().mCE.setInt(46, 0);
      if (!a.bzt()) {}
    }
    long l2;
    for (;;)
    {
      try
      {
        com.tencent.mm.kernel.h.baF();
        localObject1 = com.tencent.mm.kernel.h.baC().mBN;
        com.tencent.mm.kernel.h.baF();
        localObject2 = com.tencent.mm.kernel.h.baD().mCm.oun.bGg();
        l2 = Util.nowMilliSecond();
        if (localObject2 != null) {
          continue;
        }
        Log.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(226L, 2L, 1L, false);
      }
      finally
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
        localThrowable.oiq = ((com.tencent.mm.network.e)localObject2).bGd();
        label1797:
        localObject2 = com.tencent.mm.plugin.report.f.Ozc;
        if (localThrowable.bzs() <= 0) {
          break label2109;
        }
      }
      if ((j & 0x8) == 0) {
        break label2095;
      }
      Log.d("MicroMsg.HandleAuthResponse", "start parse axauth ");
      a(paramfrg.abQT);
      AppMethodBeat.o(134110);
      return;
      i = paramfrg.abQQ.YJw;
      break;
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label96;
      l1 = 41L;
      break label257;
      localObject2 = com.tencent.mm.plugin.report.f.Ozc;
      if (paramfrg.abQQ.YJw == 2)
      {
        l1 = 10L;
        ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(148L, l1, 1L, true);
        break label269;
      }
      l1 = 11L;
      continue;
      ((aq)localObject1).set(at.a.acHx, Long.valueOf(paramfrg.abQQ.YJw));
      ((aq)localObject1).set(at.a.acHz, Long.valueOf(Util.nowSecond()));
      ((aq)localObject1).set(at.a.acHy, Long.valueOf(0L));
      break label269;
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label677;
      i = ((hw)localObject2).YJl.abwJ;
      break label893;
      if (k == 2)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 21L, 1L, false);
        com.tencent.mm.kernel.h.baC().aZE().iC(((p)localObject4).longValue());
        localObject4 = Util.encodeHexString(com.tencent.mm.kernel.h.baC().aZE().iB(((p)localObject4).longValue()));
        ((aq)localObject1).B(-1535680990, localObject3);
        ((aq)localObject1).B(46, str);
        ((aq)localObject1).B(72, localObject4);
        ((aq)localObject1).B(29, ((hw)localObject2).YCe);
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
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 22L, 1L, false);
      break label1311;
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
      break label1358;
      Log.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.network.e)localObject2).bGa()), Integer.valueOf(((a)localObject1).bzs()) });
      if (((com.tencent.mm.network.e)localObject2).bGa()) {
        continue;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(226L, 3L, 1L, false);
      Log.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
    }
    label2095:
    label2109:
    for (long l1 = 4L;; l1 = 5L)
    {
      ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(226L, l1, 1L, false);
      Log.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", new Object[] { Long.valueOf(Util.milliSecondsToNow(l2)), Integer.valueOf(localThrowable.bzs()), Long.valueOf(localThrowable.oir) });
      if (localThrowable.bzs() <= 0) {
        break;
      }
      localObject2 = com.tencent.mm.plugin.report.f.Ozc;
      if (localThrowable.oir > 5L) {}
      for (l1 = 5L;; l1 = localThrowable.oir)
      {
        ((com.tencent.mm.plugin.report.f)localObject2).idkeyStat(226L, 31L - l1, 1L, false);
        com.tencent.mm.plugin.report.f.Ozc.b(11098, new Object[] { Integer.valueOf(2000), Long.valueOf(localThrowable.oir) });
        localThrowable.oir = -1L;
        break;
      }
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile axauthsect no set!");
      AppMethodBeat.o(134110);
      return;
    }
  }
  
  public static void a(is paramis)
  {
    AppMethodBeat.i(134111);
    if (paramis == null) {}
    Object localObject1;
    for (int i = -1;; i = paramis.vgN)
    {
      Log.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.h.baF();
      localObject1 = com.tencent.mm.kernel.h.baD().mCm.oun;
      if ((localObject1 != null) && (((com.tencent.mm.network.g)localObject1).bGg() != null)) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    ((com.tencent.mm.network.g)localObject1).bGg().bGf();
    if ((paramis == null) || (paramis.vgN == 0))
    {
      Log.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
      AppMethodBeat.o(134111);
      return;
    }
    LinkedList localLinkedList = paramis.vgO;
    if ((localLinkedList == null) || (localLinkedList.size() != paramis.vgN)) {
      if (localLinkedList != null) {
        break label210;
      }
    }
    label210:
    for (i = -1;; i = localLinkedList.size())
    {
      Log.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramis.vgN) });
      Log.d("MicroMsg.HandleAuthResponse", "axauth list size " + localLinkedList.size());
      if (localLinkedList.size() != 0) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    paramis = localLinkedList.iterator();
    while (paramis.hasNext())
    {
      Object localObject2 = (ir)paramis.next();
      i = ((ir)localObject2).IKW;
      Object localObject3 = ((ir)localObject2).YKA;
      String[] arrayOfString;
      int[] arrayOfInt;
      try
      {
        Log.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i)));
        ((com.tencent.mm.network.g)localObject1).bGg().i(i, ((dal)localObject3).toByteArray());
        localObject2 = new String[((dal)localObject3).vgO.size()];
        arrayOfString = new String[((dal)localObject3).vgO.size()];
        arrayOfInt = new int[((dal)localObject3).vgO.size()];
        Log.i("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", new Object[] { Integer.valueOf(((dal)localObject3).vgN) });
        localObject3 = ((dal)localObject3).vgO.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          dak localdak = (dak)((Iterator)localObject3).next();
          Log.i("MicroMsg.HandleAuthResponse", "ax host org:%s sub:%s", new Object[] { localdak.aaFW, localdak.aaFX });
          localObject2[i] = localdak.aaFW;
          arrayOfString[i] = localdak.aaFX;
          arrayOfInt[i] = localdak.aaFY;
          int j = i + 1;
          i = j;
          if (!Util.isNullOrNil(localdak.aaFW))
          {
            i = j;
            if (!Util.isNullOrNil(localdak.aaFX)) {
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
    paramis = localLinkedList.iterator();
    while (paramis.hasNext())
    {
      localObject1 = (ir)paramis.next();
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134109);
          Log.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
          com.tencent.mm.kernel.h.aZW().a(new ah(aj.this), 0);
          AppMethodBeat.o(134109);
        }
      });
    }
    AppMethodBeat.o(134111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.aj
 * JD-Core Version:    0.7.0.1
 */