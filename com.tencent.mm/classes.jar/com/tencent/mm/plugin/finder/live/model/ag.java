package com.tencent.mm.plugin.finder.live.model;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.jc;
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.p;
import com.tencent.mm.live.core.core.f;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.i;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveQosReporter;", "", "()V", "TAG", "", "hevcHardDecSupport", "", "lapCount", "lastTimestamp", "", "qosExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQoSExtInfo;", "qosKvTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "cleanClientStatus", "", "doLivePlayReport", "liveStarted", "", "genClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "lagIncrease", "reset", "setQosExtInfo", "isEnterRoomFirstTime", "supportHEVCDec", "startQosKvReport", "stopQosKvReport", "toFinderLiveQosInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQoSInfo;", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
{
  public static final ag CGN;
  private static int CGO;
  private static blg CGP;
  private static int CGQ;
  private static final MTimerHandler CGR;
  private static final String TAG;
  private static long xcd;
  
  static
  {
    AppMethodBeat.i(359286);
    CGN = new ag();
    TAG = "MicroMsg.FinderLiveReporter";
    CGR = new MTimerHandler("FinderLiveReporterTimer", ag..ExternalSyntheticLambda0.INSTANCE, true);
    AppMethodBeat.o(359286);
  }
  
  public static bgc e(Long paramLong)
  {
    ah localah = null;
    AppMethodBeat.i(359265);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = (Iterable)f.mMm.bed();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label84:
    label118:
    label121:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      long l2 = ((com.tencent.mm.live.core.core.model.e)localObject3).timestamps;
      long l1;
      if (paramLong == null)
      {
        l1 = 0L;
        if (l2 <= l1) {
          break label118;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label121;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        l1 = paramLong.longValue();
        break label84;
      }
    }
    localObject1 = (List)localObject1;
    Log.i(TAG, "genClientStatus lastTimestamp:" + paramLong + " liveQosInfoQueue.size:" + ((List)localObject1).size());
    paramLong = CGP;
    label214:
    label219:
    label244:
    boolean bool;
    if ((paramLong != null) && (paramLong.ZUn == 1))
    {
      i = 1;
      if (i == 0) {
        break label957;
      }
      paramLong = CGP;
      if (paramLong != null)
      {
        localObject2 = aj.CGT;
        localObject2 = aj.elL();
        if (localObject2 != null) {
          break label931;
        }
        i = 0;
        paramLong.ZUp = i;
      }
      paramLong = CGP;
      if (paramLong != null)
      {
        localObject2 = aj.CGT;
        localObject2 = aj.elL();
        if (localObject2 != null) {
          break label1016;
        }
        i = 0;
        paramLong.ZUo = (i | CGQ);
      }
      paramLong = CGP;
      if (paramLong != null)
      {
        localObject2 = aj.CGT;
        localObject2 = aj.elL();
        if (localObject2 != null) {
          break label1042;
        }
        i = 0;
        label278:
        paramLong.ZUq = i;
      }
      paramLong = CGP;
      if (paramLong != null)
      {
        localObject2 = aj.CGT;
        localObject2 = aj.elL();
        if (localObject2 != null) {
          break label1085;
        }
        i = 0;
        label308:
        paramLong.ZUr = i;
      }
      paramLong = CGP;
      if (paramLong != null) {
        paramLong.ZUs = 0;
      }
      if (a.a.bfr().bfn().mTq)
      {
        paramLong = CGP;
        if (paramLong != null) {
          paramLong.ZUs = 1;
        }
      }
      paramLong = aj.CGT;
      paramLong = aj.getLiveCore();
      if (paramLong != null) {
        break label1111;
      }
      bool = false;
      label366:
      if (!bool) {
        break label1135;
      }
      paramLong = CGP;
      if (paramLong != null) {
        paramLong.ZUt = 1;
      }
      label384:
      paramLong = CGP;
      if (paramLong != null) {
        paramLong.platform = 1;
      }
      localObject2 = TAG;
      localObject3 = new StringBuilder("qosExtInfo stream_quality:");
      paramLong = CGP;
      if (paramLong != null) {
        break label1151;
      }
      paramLong = null;
      label423:
      localObject3 = ((StringBuilder)localObject3).append(paramLong).append(" hevcdec_support:");
      paramLong = CGP;
      if (paramLong != null) {
        break label1162;
      }
      paramLong = null;
      label446:
      localObject3 = ((StringBuilder)localObject3).append(paramLong).append(" hevcenc:");
      paramLong = CGP;
      if (paramLong != null) {
        break label1173;
      }
      paramLong = null;
      label469:
      localObject3 = ((StringBuilder)localObject3).append(paramLong).append(" is_enteroom_firsttime:");
      paramLong = CGP;
      if (paramLong != null) {
        break label1184;
      }
      paramLong = null;
      label492:
      localObject3 = ((StringBuilder)localObject3).append(paramLong).append(" cdnquality_srvcfg");
      paramLong = CGP;
      if (paramLong != null) {
        break label1195;
      }
      paramLong = null;
      label515:
      localObject3 = ((StringBuilder)localObject3).append(paramLong).append(" cdh265_backcfg");
      paramLong = CGP;
      if (paramLong != null) {
        break label1206;
      }
      paramLong = null;
      label539:
      localObject3 = ((StringBuilder)localObject3).append(paramLong).append(" isEnterBackGround ");
      paramLong = CGP;
      if (paramLong != null) {
        break label1217;
      }
      paramLong = null;
      label563:
      Log.i((String)localObject2, paramLong + ' ');
      localObject1 = ((Iterable)localObject1).iterator();
      label594:
      if (!((Iterator)localObject1).hasNext()) {
        break label1236;
      }
      paramLong = (com.tencent.mm.live.core.core.model.e)((Iterator)localObject1).next();
      s.u(paramLong, "qosInfo");
      localObject2 = new blh();
      ((blh)localObject2).mMJ = paramLong.mMJ;
      ((blh)localObject2).width = paramLong.width;
      ((blh)localObject2).height = paramLong.height;
      ((blh)localObject2).mMK = paramLong.mMK;
      ((blh)localObject2).mML = paramLong.mML;
      ((blh)localObject2).mMM = paramLong.mMM;
      ((blh)localObject2).mMN = paramLong.mMN;
      ((blh)localObject2).mMO = paramLong.mMO;
      ((blh)localObject2).mMP = paramLong.mMP;
      ((blh)localObject2).mMQ = paramLong.mMQ;
      ((blh)localObject2).mMR = paramLong.mMR;
      ((blh)localObject2).mMS = paramLong.mMS;
      ((blh)localObject2).mMT = paramLong.mMT;
      ((blh)localObject2).mMU = paramLong.mMU;
      ((blh)localObject2).mMV = paramLong.mMV;
      ((blh)localObject2).mMW = paramLong.mMW;
      ((blh)localObject2).ZUu = ((int)paramLong.mMX);
      ((blh)localObject2).ZUv = ((int)paramLong.mMY);
      ((blh)localObject2).mMZ = paramLong.mMZ;
      ((blh)localObject2).mNa = paramLong.mNa;
      ((blh)localObject2).mNb = paramLong.mNb;
      ((blh)localObject2).mNc = paramLong.mNc;
      ((blh)localObject2).mNd = paramLong.mNd;
      ((blh)localObject2).mNe = paramLong.mNe;
      ((blh)localObject2).mNf = paramLong.mNf;
      ((blh)localObject2).mNg = paramLong.mNg;
      ((blh)localObject2).mNh = paramLong.mNh;
      ((blh)localObject2).ZUx = paramLong.upLoss;
      ((blh)localObject2).ZUy = paramLong.downLoss;
      paramLong = CGP;
      if (paramLong != null) {
        break label1228;
      }
    }
    label931:
    label957:
    label1085:
    label1217:
    label1228:
    for (paramLong = null;; paramLong = paramLong.toByteArray())
    {
      ((blh)localObject2).ZUz = b.cX(paramLong);
      localLinkedList.add(localObject2);
      break label594;
      i = 0;
      break;
      localObject2 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn;
      if (localObject2 == null)
      {
        i = 0;
        break label214;
      }
      i = ((com.tencent.mm.live.core.core.d)localObject2).mJL;
      break label214;
      paramLong = CGP;
      if (paramLong == null) {
        break label219;
      }
      localObject2 = aj.CGT;
      localObject2 = aj.elL();
      if (localObject2 == null) {
        i = 0;
      }
      for (;;)
      {
        paramLong.ZUp = i;
        break;
        localObject2 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn;
        if (localObject2 == null) {
          i = 0;
        } else {
          i = ((com.tencent.mm.live.core.core.d)localObject2).mJK;
        }
      }
      label1016:
      localObject2 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn;
      if (localObject2 == null)
      {
        i = 0;
        break label244;
      }
      i = ((com.tencent.mm.live.core.core.d)localObject2).mJT;
      break label244;
      localObject2 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn;
      if (localObject2 == null)
      {
        i = 0;
        break label278;
      }
      localObject2 = ((com.tencent.mm.live.core.core.d)localObject2).mJH;
      if (localObject2 == null)
      {
        i = 0;
        break label278;
      }
      i = ((g)localObject2).mNr;
      break label278;
      localObject2 = ((com.tencent.mm.live.core.core.f.d)localObject2).mUn;
      if (localObject2 == null)
      {
        i = 0;
        break label308;
      }
      i = ((com.tencent.mm.live.core.core.d)localObject2).mJU;
      break label308;
      label1111:
      paramLong = paramLong.mRB;
      if (paramLong == null)
      {
        bool = false;
        break label366;
      }
      bool = paramLong.isFloatMode();
      break label366;
      label1135:
      paramLong = CGP;
      if (paramLong == null) {
        break label384;
      }
      paramLong.ZUt = 0;
      break label384;
      label1151:
      paramLong = Integer.valueOf(paramLong.ZUp);
      break label423;
      paramLong = Integer.valueOf(paramLong.ZUo);
      break label446;
      paramLong = Integer.valueOf(paramLong.ZUs);
      break label469;
      paramLong = Integer.valueOf(paramLong.ZUn);
      break label492;
      paramLong = Integer.valueOf(paramLong.ZUq);
      break label515;
      paramLong = Integer.valueOf(paramLong.ZUr);
      break label539;
      paramLong = Integer.valueOf(paramLong.ZUt);
      break label563;
    }
    label1042:
    label1173:
    label1184:
    label1195:
    label1206:
    label1236:
    paramLong = aj.CGT;
    label1162:
    paramLong = aj.elL();
    if (paramLong != null)
    {
      paramLong = paramLong.mUn;
      if (paramLong != null)
      {
        localObject1 = CGP;
        if (localObject1 != null) {
          break label1445;
        }
      }
    }
    label1445:
    for (int i = 0;; i = ((blg)localObject1).ZUp)
    {
      paramLong.mJL = i;
      paramLong = CGP;
      if (paramLong != null) {
        paramLong.ZUn = 0;
      }
      paramLong = localah;
      if (!Util.isNullOrNil((List)localLinkedList))
      {
        localObject1 = (blh)localLinkedList.removeLast();
        Log.i(TAG, "genClientStatus curQosInfo:" + localObject1 + " lastLiveQosInfo.size:" + localLinkedList.size());
        paramLong = localah;
        if (localObject1 != null)
        {
          paramLong = new bgc();
          paramLong.Zoz = NetStatusUtil.getNetType(MMApplicationContext.getContext());
          paramLong.ZPL = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
          paramLong.ZPM = CdnLogic.getRecentAverageSpeed(2);
          paramLong.Zoi = q.aPo();
          paramLong.Zwf = Build.BRAND;
          paramLong.ZPN = Build.DISPLAY;
          paramLong.Zon = Build.VERSION.RELEASE;
          paramLong.ZPO = ((blh)localObject1);
          paramLong.ZPP = localLinkedList;
          localah = ah.aiuX;
        }
      }
      AppMethodBeat.o(359265);
      return paramLong;
    }
  }
  
  public static void elf()
  {
    AppMethodBeat.i(359212);
    xcd = System.currentTimeMillis();
    CGR.stopTimer();
    CGR.startTimer(60000L);
    AppMethodBeat.o(359212);
  }
  
  public static void elg()
  {
    AppMethodBeat.i(359220);
    CGR.stopTimer();
    AppMethodBeat.o(359220);
  }
  
  public static void elh()
  {
    CGO += 1;
  }
  
  private static final boolean eli()
  {
    AppMethodBeat.i(359281);
    qC(true);
    Log.i(TAG, "cleanClientStatus");
    f.mMm.bef();
    AppMethodBeat.o(359281);
    return true;
  }
  
  public static void qC(boolean paramBoolean)
  {
    AppMethodBeat.i(359243);
    long l1 = System.currentTimeMillis();
    long l2 = xcd;
    LinkedList localLinkedList = f.mMm.bed();
    xcd = System.currentTimeMillis();
    Log.i(TAG, "doLivePlayReport qosInfoQueue.size:" + localLinkedList.size() + " liveStarted:" + paramBoolean);
    jc localjc;
    if (!Util.isNullOrNil((List)localLinkedList))
    {
      localjc = new jc();
      localjc.iSc = ((l1 - l2) / 1000L);
      localjc.iSb = 2L;
      Iterator localIterator = ((Iterable)localLinkedList).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.live.core.core.model.e locale = (com.tencent.mm.live.core.core.model.e)localIterator.next();
        if (Util.isNullOrNil(localjc.iCR)) {
          localjc.iCR = localjc.F("LiveId", String.valueOf(locale.mMJ), true);
        }
        if (localjc.iRw == 0L) {
          localjc.iRw = locale.width;
        }
        if (localjc.iRx == 0L) {
          localjc.iRx = locale.height;
        }
        if (localjc.iRF == 0L) {
          localjc.iRF = locale.mMU;
        }
        if (localjc.iRL == 0L) {
          localjc.ff(locale.mMZ);
        }
        if (localjc.iRP == 0L) {
          localjc.iRP = locale.mNd;
        }
        Object localObject;
        if (Util.isNullOrNil(localjc.iRQ))
        {
          String str = locale.mNe;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localjc.iRQ = localjc.F("CdnSvrIp", (String)localObject, true);
        }
        if (localjc.iRR == 0L) {
          localjc.iRR = locale.mNf;
        }
        int i;
        if (localjc.imY == 0L)
        {
          i = locale.role;
          localObject = e.p.mLE;
          if (i == e.p.bdH())
          {
            l1 = 1L;
            label379:
            localjc.imY = l1;
          }
        }
        else
        {
          localjc.itb = locale.netType;
          i = locale.mode;
          localObject = e.b.mKf;
          if (i != e.b.bcu()) {
            break label879;
          }
          l1 = 1L;
        }
        for (;;)
        {
          localjc.iSd = l1;
          localjc.iry += locale.mMK;
          localjc.iRy += locale.mML;
          localjc.irw += locale.mMM;
          localjc.irx += locale.mMN;
          localjc.iRz += locale.mMO;
          localjc.iRC += locale.mMR;
          localjc.iRH += locale.mMW;
          localjc.fg(localjc.iRM + locale.mNa);
          localjc.iRN += locale.mNb;
          localjc.iRO += locale.mNc;
          localjc.iRS = localjc.F("CpuUsageProcess", s.X(localjc.iRS, Long.valueOf(locale.mNg)), true);
          localjc.iRT = localjc.F("CpuUsageDevice", s.X(localjc.iRT, Long.valueOf(locale.mNh)), true);
          localjc.iRA += locale.mMP;
          localjc.iRB += locale.mMQ;
          localjc.iRD += locale.mMS;
          localjc.iRE += locale.mMT;
          localjc.fd(locale.mMX);
          localjc.fe(localjc.iRJ + locale.mMY);
          localjc.iRG = k.bR(localjc.iRG, locale.mMV);
          localjc.iRW = k.bR(localjc.irw, locale.mMM);
          localjc.iRY = k.bR(localjc.irx, locale.mMN);
          localjc.iRX = k.bS(localjc.irw, locale.mMM);
          localjc.iRY = k.bS(localjc.irx, locale.mMN);
          break;
          i = locale.role;
          localObject = e.p.mLE;
          if (i == e.p.bdG())
          {
            l1 = 2L;
            break label379;
          }
          l1 = 0L;
          break label379;
          label879:
          i = locale.mode;
          localObject = e.b.mKf;
          if (i == e.b.bcu()) {
            l1 = 2L;
          } else {
            l1 = 0L;
          }
        }
      }
      localjc.iRU = CGO;
      localjc.iry = (((float)localjc.iry / localLinkedList.size()));
      localjc.iRy = (((float)localjc.iRy / localLinkedList.size()));
      localjc.irw = (((float)localjc.irw / localLinkedList.size()));
      localjc.irx = (((float)localjc.irx / localLinkedList.size()));
      localjc.iRz = (((float)localjc.iRz / localLinkedList.size()));
      localjc.iRC = (((float)localjc.iRC / localLinkedList.size()));
      localjc.iRH = (((float)localjc.iRH / localLinkedList.size()));
      localjc.fg(((float)localjc.iRM / localLinkedList.size()));
      localjc.iRN = (((float)localjc.iRN / localLinkedList.size()));
      localjc.iRO = (((float)localjc.iRO / localLinkedList.size()));
      if (!paramBoolean) {
        break label1136;
      }
    }
    label1136:
    for (localjc.iSa = 0L;; localjc.iSa = 1L)
    {
      localjc.bMH();
      CGO = 0;
      AppMethodBeat.o(359243);
      return;
    }
  }
  
  public static void qD(boolean paramBoolean)
  {
    AppMethodBeat.i(359271);
    if (CGP == null) {
      CGP = new blg();
    }
    blg localblg = CGP;
    if (localblg != null) {
      localblg.ZUn = 1;
    }
    if (paramBoolean) {
      CGQ = 1;
    }
    AppMethodBeat.o(359271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ag
 * JD-Core Version:    0.7.0.1
 */