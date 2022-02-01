package com.tencent.mm.plugin.finder.live.model;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.b.a.hf;
import com.tencent.mm.live.core.core.c.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.n;
import com.tencent.mm.live.core.core.f;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bbp;
import com.tencent.mm.protocal.protobuf.bbq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveQosReporter;", "", "()V", "TAG", "", "hevcHardDecSupport", "", "lapCount", "lastTimestamp", "", "qosExtInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQoSExtInfo;", "qosKvTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "cleanClientStatus", "", "doLivePlayReport", "liveStarted", "", "genClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "lagIncrease", "reset", "setQosExtInfo", "isEnterRoomFirstTime", "supportHEVCDec", "startQosKvReport", "stopQosKvReport", "toFinderLiveQosInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQoSInfo;", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "plugin-finder_release"})
public final class ac
{
  private static final String TAG = "MicroMsg.FinderLiveReporter";
  private static long tYL;
  private static int ygQ;
  private static bbp ygR;
  private static int ygS;
  private static final MTimerHandler ygT;
  public static final ac ygU;
  
  static
  {
    AppMethodBeat.i(271979);
    ygU = new ac();
    TAG = "MicroMsg.FinderLiveReporter";
    ygT = new MTimerHandler("FinderLiveReporterTimer", (MTimerHandler.CallBack)a.ygV, true);
    AppMethodBeat.o(271979);
  }
  
  public static ayv c(Long paramLong)
  {
    Object localObject1 = null;
    AppMethodBeat.i(271977);
    LinkedList localLinkedList = new LinkedList();
    Object localObject3 = (Iterable)f.kll.aLb();
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    label87:
    label118:
    label121:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      long l2 = ((com.tencent.mm.live.core.core.model.d)localObject4).timestamps;
      long l1;
      if (paramLong != null)
      {
        l1 = paramLong.longValue();
        if (l2 <= l1) {
          break label118;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label121;
        }
        ((Collection)localObject2).add(localObject4);
        break;
        l1 = 0L;
        break label87;
      }
    }
    localObject2 = (List)localObject2;
    Log.i(TAG, "genClientStatus lastTimestamp:" + paramLong + " liveQosInfoQueue.size:" + ((List)localObject2).size());
    paramLong = ygR;
    if ((paramLong != null) && (paramLong.SNn == 1))
    {
      paramLong = ygR;
      if (paramLong != null)
      {
        localObject3 = ah.yhC;
        localObject3 = ah.dzA();
        if (localObject3 != null)
        {
          localObject3 = ((c)localObject3).kqm;
          if (localObject3 != null)
          {
            i = ((com.tencent.mm.live.core.core.d)localObject3).kjh;
            paramLong.SNp = i;
          }
        }
      }
      else
      {
        label229:
        paramLong = ygR;
        if (paramLong != null)
        {
          localObject3 = ah.yhC;
          localObject3 = ah.dzA();
          if (localObject3 == null) {
            break label943;
          }
          localObject3 = ((c)localObject3).kqm;
          if (localObject3 == null) {
            break label943;
          }
          i = ((com.tencent.mm.live.core.core.d)localObject3).kjp;
          label270:
          paramLong.SNo = (i | ygS);
        }
        paramLong = ygR;
        if (paramLong != null)
        {
          localObject3 = ah.yhC;
          localObject3 = ah.dzA();
          if (localObject3 == null) {
            break label948;
          }
          localObject3 = ((c)localObject3).kqm;
          if (localObject3 == null) {
            break label948;
          }
          i = ((com.tencent.mm.live.core.core.d)localObject3).kjq;
          label320:
          paramLong.SNq = i;
        }
        paramLong = ygR;
        if (paramLong != null)
        {
          localObject3 = ah.yhC;
          localObject3 = ah.dzA();
          if (localObject3 == null) {
            break label953;
          }
          localObject3 = ((c)localObject3).kqm;
          if (localObject3 == null) {
            break label953;
          }
          i = ((com.tencent.mm.live.core.core.d)localObject3).kjr;
          label366:
          paramLong.SNr = i;
        }
        localObject3 = TAG;
        localObject4 = new StringBuilder("qosExtInfo stream_quality:");
        paramLong = ygR;
        if (paramLong == null) {
          break label958;
        }
        paramLong = Integer.valueOf(paramLong.SNp);
        label403:
        localObject4 = ((StringBuilder)localObject4).append(paramLong).append(" hevcdec_support:");
        paramLong = ygR;
        if (paramLong == null) {
          break label963;
        }
        paramLong = Integer.valueOf(paramLong.SNo);
        label432:
        localObject4 = ((StringBuilder)localObject4).append(paramLong).append(" is_enteroom_firsttime:");
        paramLong = ygR;
        if (paramLong == null) {
          break label968;
        }
        paramLong = Integer.valueOf(paramLong.SNn);
        label461:
        localObject4 = ((StringBuilder)localObject4).append(paramLong).append(" cdnquality_srvcfg");
        paramLong = ygR;
        if (paramLong == null) {
          break label973;
        }
        paramLong = Integer.valueOf(paramLong.SNq);
        label490:
        localObject4 = ((StringBuilder)localObject4).append(paramLong).append(" cdh265_backcfg");
        paramLong = ygR;
        if (paramLong == null) {
          break label978;
        }
        paramLong = Integer.valueOf(paramLong.SNr);
        label519:
        Log.i((String)localObject3, paramLong + ' ');
        localObject2 = ((Iterable)localObject2).iterator();
        label550:
        if (!((Iterator)localObject2).hasNext()) {
          break label988;
        }
        paramLong = (com.tencent.mm.live.core.core.model.d)((Iterator)localObject2).next();
        p.k(paramLong, "qosInfo");
        localObject3 = new bbq();
        ((bbq)localObject3).klE = paramLong.klE;
        ((bbq)localObject3).width = paramLong.width;
        ((bbq)localObject3).height = paramLong.height;
        ((bbq)localObject3).klF = paramLong.klF;
        ((bbq)localObject3).klG = paramLong.klG;
        ((bbq)localObject3).klH = paramLong.klH;
        ((bbq)localObject3).klI = paramLong.klI;
        ((bbq)localObject3).klJ = paramLong.klJ;
        ((bbq)localObject3).klK = paramLong.klK;
        ((bbq)localObject3).klL = paramLong.klL;
        ((bbq)localObject3).klM = paramLong.klM;
        ((bbq)localObject3).klN = paramLong.klN;
        ((bbq)localObject3).klO = paramLong.klO;
        ((bbq)localObject3).klP = paramLong.klP;
        ((bbq)localObject3).klQ = paramLong.klQ;
        ((bbq)localObject3).klR = paramLong.klR;
        ((bbq)localObject3).SNs = ((int)paramLong.klS);
        ((bbq)localObject3).SNt = ((int)paramLong.klT);
        ((bbq)localObject3).klU = paramLong.klU;
        ((bbq)localObject3).klV = paramLong.klV;
        ((bbq)localObject3).klW = paramLong.klW;
        ((bbq)localObject3).klX = paramLong.klX;
        ((bbq)localObject3).klY = paramLong.klY;
        ((bbq)localObject3).klZ = paramLong.klZ;
        ((bbq)localObject3).kma = paramLong.kma;
        ((bbq)localObject3).kmb = paramLong.kmb;
        ((bbq)localObject3).kmc = paramLong.kmc;
        ((bbq)localObject3).SNv = paramLong.upLoss;
        ((bbq)localObject3).SNw = paramLong.downLoss;
        paramLong = ygR;
        if (paramLong == null) {
          break label983;
        }
      }
    }
    label943:
    label948:
    label953:
    label958:
    label963:
    label968:
    label973:
    label978:
    label983:
    for (paramLong = paramLong.toByteArray();; paramLong = null)
    {
      ((bbq)localObject3).SNx = b.cU(paramLong);
      localLinkedList.add(localObject3);
      break label550;
      i = 0;
      break;
      paramLong = ygR;
      if (paramLong == null) {
        break label229;
      }
      localObject3 = ah.yhC;
      localObject3 = ah.dzA();
      if (localObject3 != null)
      {
        localObject3 = ((c)localObject3).kqm;
        if (localObject3 == null) {}
      }
      for (i = ((com.tencent.mm.live.core.core.d)localObject3).kjg;; i = 0)
      {
        paramLong.SNp = i;
        break;
      }
      i = 0;
      break label270;
      i = 0;
      break label320;
      i = 0;
      break label366;
      paramLong = null;
      break label403;
      paramLong = null;
      break label432;
      paramLong = null;
      break label461;
      paramLong = null;
      break label490;
      paramLong = null;
      break label519;
    }
    label988:
    paramLong = ah.yhC;
    paramLong = ah.dzA();
    if (paramLong != null)
    {
      paramLong = paramLong.kqm;
      if (paramLong != null)
      {
        localObject2 = ygR;
        if (localObject2 == null) {
          break label1196;
        }
      }
    }
    label1196:
    for (int i = ((bbp)localObject2).SNp;; i = 0)
    {
      paramLong.kjh = i;
      paramLong = ygR;
      if (paramLong != null) {
        paramLong.SNn = 0;
      }
      paramLong = localObject1;
      if (!Util.isNullOrNil((List)localLinkedList))
      {
        localObject2 = (bbq)localLinkedList.removeLast();
        Log.i(TAG, "genClientStatus curQosInfo:" + localObject2 + " lastLiveQosInfo.size:" + localLinkedList.size());
        paramLong = localObject1;
        if (localObject2 != null)
        {
          paramLong = new ayv();
          paramLong.SpF = NetStatusUtil.getNetType(MMApplicationContext.getContext());
          paramLong.SKM = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
          paramLong.SKN = CdnLogic.getRecentAverageSpeed(2);
          paramLong.Spt = Build.MODEL;
          paramLong.SvW = Build.BRAND;
          paramLong.SKO = Build.DISPLAY;
          paramLong.Spy = Build.VERSION.RELEASE;
          paramLong.SKP = ((bbq)localObject2);
          paramLong.SKQ = localLinkedList;
        }
      }
      AppMethodBeat.o(271977);
      return paramLong;
    }
  }
  
  public static void dyY()
  {
    AppMethodBeat.i(271970);
    tYL = System.currentTimeMillis();
    ygT.stopTimer();
    ygT.startTimer(60000L);
    AppMethodBeat.o(271970);
  }
  
  public static void dyZ()
  {
    AppMethodBeat.i(271971);
    ygT.stopTimer();
    AppMethodBeat.o(271971);
  }
  
  public static void dzb()
  {
    AppMethodBeat.i(271975);
    Log.i(TAG, "cleanClientStatus");
    f.kll.aLd();
    AppMethodBeat.o(271975);
  }
  
  public static void dzc()
  {
    ygQ += 1;
  }
  
  public static void oL(boolean paramBoolean)
  {
    AppMethodBeat.i(271972);
    long l1 = System.currentTimeMillis();
    long l2 = tYL;
    LinkedList localLinkedList = f.kll.aLb();
    tYL = System.currentTimeMillis();
    Log.i(TAG, "doLivePlayReport qosInfoQueue.size:" + localLinkedList.size() + " liveStarted:" + paramBoolean);
    hf localhf;
    if (!Util.isNullOrNil((List)localLinkedList))
    {
      localhf = new hf();
      localhf.qX((l1 - l2) / 1000L);
      localhf.alB();
      Iterator localIterator = ((Iterable)localLinkedList).iterator();
      if (localIterator.hasNext())
      {
        com.tencent.mm.live.core.core.model.d locald = (com.tencent.mm.live.core.core.model.d)localIterator.next();
        if (Util.isNullOrNil(localhf.ahY())) {
          localhf.wh(String.valueOf(locald.klE));
        }
        if (localhf.getWidth() == 0L) {
          localhf.qv(locald.width);
        }
        if (localhf.getHeight() == 0L) {
          localhf.qw(locald.height);
        }
        if (localhf.alo() == 0L) {
          localhf.qH(locald.klP);
        }
        if (localhf.als() == 0L) {
          localhf.qM(locald.klU);
        }
        if (localhf.alw() == 0L) {
          localhf.qQ(locald.klY);
        }
        Object localObject;
        if (Util.isNullOrNil(localhf.alx()))
        {
          String str = locald.klZ;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localhf.wi((String)localObject);
        }
        if (localhf.aly() == 0L) {
          localhf.qR(locald.kma);
        }
        int i;
        if (localhf.alC() == 0L)
        {
          i = locald.role;
          localObject = e.n.kkL;
          if (i == e.n.aKL())
          {
            l1 = 1L;
            label367:
            localhf.ra(l1);
          }
        }
        else
        {
          localhf.qZ(locald.netType);
          i = locald.mode;
          localObject = e.b.kjz;
          if (i != e.b.aJK()) {
            break label900;
          }
          l1 = 1L;
        }
        for (;;)
        {
          localhf.qY(l1);
          localhf.qx(localhf.ale() + locald.klF);
          localhf.qy(localhf.alf() + locald.klG);
          localhf.qz(localhf.alg() + locald.klH);
          localhf.qA(localhf.alh() + locald.klI);
          localhf.qB(localhf.ali() + locald.klJ);
          localhf.qE(localhf.all() + locald.klM);
          localhf.qJ(localhf.alq() + locald.klR);
          localhf.qN(localhf.alt() + locald.klV);
          localhf.qO(localhf.alu() + locald.klW);
          localhf.qP(localhf.alv() + locald.klX);
          localObject = localhf.alz();
          localhf.wj((String)localObject + locald.kmb);
          localObject = localhf.alA();
          localhf.wk((String)localObject + locald.kmc);
          localhf.qC(localhf.alj() + locald.klK);
          localhf.qD(localhf.alk() + locald.klL);
          localhf.qF(localhf.alm() + locald.klN);
          localhf.qG(localhf.aln() + locald.klO);
          localhf.qK(locald.klS);
          localhf.qL(localhf.alr() + locald.klT);
          localhf.qI(i.be(localhf.alp(), locald.klQ));
          localhf.qT(i.be(localhf.alg(), locald.klH));
          localhf.qV(i.be(localhf.alh(), locald.klI));
          localhf.qU(i.bf(localhf.alg(), locald.klH));
          localhf.qV(i.bf(localhf.alh(), locald.klI));
          break;
          i = locald.role;
          localObject = e.n.kkL;
          if (i == e.n.aKK())
          {
            l1 = 2L;
            break label367;
          }
          l1 = 0L;
          break label367;
          label900:
          i = locald.mode;
          localObject = e.b.kjz;
          if (i == e.b.aJK()) {
            l1 = 2L;
          } else {
            l1 = 0L;
          }
        }
      }
      localhf.qS(ygQ);
      localhf.qx(((float)localhf.ale() / localLinkedList.size()));
      localhf.qy(((float)localhf.alf() / localLinkedList.size()));
      localhf.qz(((float)localhf.alg() / localLinkedList.size()));
      localhf.qA(((float)localhf.alh() / localLinkedList.size()));
      localhf.qB(((float)localhf.ali() / localLinkedList.size()));
      localhf.qE(((float)localhf.all() / localLinkedList.size()));
      localhf.qJ(((float)localhf.alq() / localLinkedList.size()));
      localhf.qN(((float)localhf.alt() / localLinkedList.size()));
      localhf.qO(((float)localhf.alu() / localLinkedList.size()));
      localhf.qP(((float)localhf.alv() / localLinkedList.size()));
      if (!paramBoolean) {
        break label1168;
      }
      localhf.qW(0L);
    }
    for (;;)
    {
      localhf.bpa();
      ygQ = 0;
      AppMethodBeat.o(271972);
      return;
      label1168:
      localhf.qW(1L);
    }
  }
  
  public static void oM(boolean paramBoolean)
  {
    AppMethodBeat.i(271978);
    if (ygR == null) {
      ygR = new bbp();
    }
    bbp localbbp = ygR;
    if (localbbp != null) {
      localbbp.SNn = 1;
    }
    if (paramBoolean) {
      ygS = 1;
    }
    AppMethodBeat.o(271978);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    public static final a ygV;
    
    static
    {
      AppMethodBeat.i(279825);
      ygV = new a();
      AppMethodBeat.o(279825);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(279822);
      ac localac = ac.ygU;
      ac.dza();
      localac = ac.ygU;
      ac.dzb();
      AppMethodBeat.o(279822);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ac
 * JD-Core Version:    0.7.0.1
 */