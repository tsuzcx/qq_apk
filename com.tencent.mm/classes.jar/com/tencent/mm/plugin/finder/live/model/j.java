package com.tencent.mm.plugin.finder.live.model;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fn;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.i;
import com.tencent.mm.live.core.core.f;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.awx;
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
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveQosReporter;", "", "()V", "TAG", "", "lapCount", "", "lastTimestamp", "", "qosKvTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "cleanClientStatus", "", "doLivePlayReport", "liveStarted", "", "genClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "lagIncrease", "reset", "startQosKvReport", "stopQosKvReport", "toFinderLiveQosInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQoSInfo;", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "plugin-finder_release"})
public final class j
{
  private static final String TAG = "MicroMsg.FinderLiveReporter";
  private static long qzL;
  private static int ujf;
  private static final MTimerHandler ujg;
  public static final j ujh;
  
  static
  {
    AppMethodBeat.i(246174);
    ujh = new j();
    TAG = "MicroMsg.FinderLiveReporter";
    ujg = new MTimerHandler("FinderLiveReporterTimer", (MTimerHandler.CallBack)a.uji, true);
    AppMethodBeat.o(246174);
  }
  
  public static avk d(Long paramLong)
  {
    AppMethodBeat.i(246173);
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = (Iterable)f.hys.aDk();
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label84:
    label115:
    label118:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      long l2 = ((c)localObject3).timestamps;
      long l1;
      if (paramLong != null)
      {
        l1 = paramLong.longValue();
        if (l2 <= l1) {
          break label115;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label118;
        }
        ((Collection)localObject1).add(localObject3);
        break;
        l1 = 0L;
        break label84;
      }
    }
    localObject1 = (List)localObject1;
    Log.i(TAG, "genClientStatus lastTimestamp:" + paramLong + " liveQosInfoQueue.size:" + ((List)localObject1).size());
    paramLong = ((Iterable)localObject1).iterator();
    while (paramLong.hasNext())
    {
      localObject1 = (c)paramLong.next();
      p.h(localObject1, "qosInfo");
      localObject2 = new awx();
      ((awx)localObject2).hyH = ((c)localObject1).hyH;
      ((awx)localObject2).width = ((c)localObject1).width;
      ((awx)localObject2).height = ((c)localObject1).height;
      ((awx)localObject2).hyI = ((c)localObject1).hyI;
      ((awx)localObject2).hyJ = ((c)localObject1).hyJ;
      ((awx)localObject2).hyK = ((c)localObject1).hyK;
      ((awx)localObject2).hyL = ((c)localObject1).hyL;
      ((awx)localObject2).hyM = ((c)localObject1).hyM;
      ((awx)localObject2).hyN = ((c)localObject1).hyN;
      ((awx)localObject2).hyO = ((c)localObject1).hyO;
      ((awx)localObject2).hyP = ((c)localObject1).hyP;
      ((awx)localObject2).hyQ = ((c)localObject1).hyQ;
      ((awx)localObject2).hyR = ((c)localObject1).hyR;
      ((awx)localObject2).hyS = ((c)localObject1).hyS;
      ((awx)localObject2).hyT = ((c)localObject1).hyT;
      ((awx)localObject2).hyU = ((c)localObject1).hyU;
      ((awx)localObject2).LHA = ((int)((c)localObject1).hyV);
      ((awx)localObject2).LHB = ((int)((c)localObject1).hyW);
      ((awx)localObject2).hyX = ((c)localObject1).hyX;
      ((awx)localObject2).hyY = ((c)localObject1).hyY;
      ((awx)localObject2).hyZ = ((c)localObject1).hyZ;
      ((awx)localObject2).hza = ((c)localObject1).hza;
      ((awx)localObject2).hzb = ((c)localObject1).hzb;
      ((awx)localObject2).hzc = ((c)localObject1).hzc;
      ((awx)localObject2).hzd = ((c)localObject1).hzd;
      ((awx)localObject2).hze = ((c)localObject1).hze;
      ((awx)localObject2).hzf = ((c)localObject1).hzf;
      localLinkedList.add(localObject2);
    }
    if (!Util.isNullOrNil((List)localLinkedList))
    {
      localObject1 = (awx)localLinkedList.removeLast();
      Log.i(TAG, "genClientStatus curQosInfo:" + localObject1 + " lastLiveQosInfo.size:" + localLinkedList.size());
      if (localObject1 != null)
      {
        paramLong = new avk();
        paramLong.Loh = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        paramLong.LGb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        paramLong.LGc = CdnLogic.getRecentAverageSpeed(2);
        paramLong.LnW = Build.MODEL;
        paramLong.LGd = Build.BRAND;
        paramLong.LGe = Build.DISPLAY;
        paramLong.Lob = Build.VERSION.RELEASE;
        paramLong.LGf = ((awx)localObject1);
        paramLong.LGg = localLinkedList;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(246173);
      return paramLong;
      paramLong = null;
    }
  }
  
  public static void dfL()
  {
    AppMethodBeat.i(246168);
    qzL = System.currentTimeMillis();
    ujg.stopTimer();
    ujg.startTimer(60000L);
    AppMethodBeat.o(246168);
  }
  
  public static void dfM()
  {
    AppMethodBeat.i(246169);
    ujg.stopTimer();
    AppMethodBeat.o(246169);
  }
  
  public static void dfO()
  {
    AppMethodBeat.i(246172);
    Log.i(TAG, "cleanClientStatus");
    f.hys.aDm();
    AppMethodBeat.o(246172);
  }
  
  public static void dfP()
  {
    ujf += 1;
  }
  
  public static void nm(boolean paramBoolean)
  {
    AppMethodBeat.i(246170);
    long l1 = System.currentTimeMillis();
    long l2 = qzL;
    LinkedList localLinkedList = f.hys.aDk();
    qzL = System.currentTimeMillis();
    Log.i(TAG, "doLivePlayReport qosInfoQueue.size:" + localLinkedList.size() + " liveStarted:" + paramBoolean);
    fn localfn;
    if (!Util.isNullOrNil((List)localLinkedList))
    {
      localfn = new fn();
      localfn.oK((l1 - l2) / 1000L);
      localfn.agy();
      Iterator localIterator = ((Iterable)localLinkedList).iterator();
      if (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (Util.isNullOrNil(localfn.adj())) {
          localfn.su(String.valueOf(localc.hyH));
        }
        if (localfn.getWidth() == 0L) {
          localfn.oi(localc.width);
        }
        if (localfn.getHeight() == 0L) {
          localfn.oj(localc.height);
        }
        if (localfn.agl() == 0L) {
          localfn.ou(localc.hyS);
        }
        if (localfn.agp() == 0L) {
          localfn.oz(localc.hyX);
        }
        if (localfn.agt() == 0L) {
          localfn.oD(localc.hzb);
        }
        Object localObject;
        if (Util.isNullOrNil(localfn.agu()))
        {
          String str = localc.hzc;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          localfn.sv((String)localObject);
        }
        if (localfn.agv() == 0L) {
          localfn.oE(localc.hzd);
        }
        int i;
        if (localfn.agz() == 0L)
        {
          i = localc.role;
          localObject = e.i.hyd;
          if (i == e.i.aCX())
          {
            l1 = 1L;
            label367:
            localfn.oN(l1);
          }
        }
        else
        {
          localfn.oM(localc.netType);
          i = localc.mode;
          localObject = e.a.hxc;
          if (i != e.a.aCf()) {
            break label900;
          }
          l1 = 1L;
        }
        for (;;)
        {
          localfn.oL(l1);
          localfn.ok(localfn.agb() + localc.hyI);
          localfn.ol(localfn.agc() + localc.hyJ);
          localfn.om(localfn.agd() + localc.hyK);
          localfn.on(localfn.age() + localc.hyL);
          localfn.oo(localfn.agf() + localc.hyM);
          localfn.or(localfn.agi() + localc.hyP);
          localfn.ow(localfn.agn() + localc.hyU);
          localfn.oA(localfn.agq() + localc.hyY);
          localfn.oB(localfn.agr() + localc.hyZ);
          localfn.oC(localfn.ags() + localc.hza);
          localObject = localfn.agw();
          localfn.sw((String)localObject + localc.hze);
          localObject = localfn.agx();
          localfn.sx((String)localObject + localc.hzf);
          localfn.op(localfn.agg() + localc.hyN);
          localfn.oq(localfn.agh() + localc.hyO);
          localfn.os(localfn.agj() + localc.hyQ);
          localfn.ot(localfn.agk() + localc.hyR);
          localfn.ox(localc.hyV);
          localfn.oy(localfn.ago() + localc.hyW);
          localfn.ov(kotlin.k.j.aM(localfn.agm(), localc.hyT));
          localfn.oG(kotlin.k.j.aM(localfn.agd(), localc.hyK));
          localfn.oI(kotlin.k.j.aM(localfn.age(), localc.hyL));
          localfn.oH(kotlin.k.j.aN(localfn.agd(), localc.hyK));
          localfn.oI(kotlin.k.j.aN(localfn.age(), localc.hyL));
          break;
          i = localc.role;
          localObject = e.i.hyd;
          if (i == e.i.aCW())
          {
            l1 = 2L;
            break label367;
          }
          l1 = 0L;
          break label367;
          label900:
          i = localc.mode;
          localObject = e.a.hxc;
          if (i == e.a.aCf()) {
            l1 = 2L;
          } else {
            l1 = 0L;
          }
        }
      }
      localfn.oF(ujf);
      localfn.ok(((float)localfn.agb() / localLinkedList.size()));
      localfn.ol(((float)localfn.agc() / localLinkedList.size()));
      localfn.om(((float)localfn.agd() / localLinkedList.size()));
      localfn.on(((float)localfn.age() / localLinkedList.size()));
      localfn.oo(((float)localfn.agf() / localLinkedList.size()));
      localfn.or(((float)localfn.agi() / localLinkedList.size()));
      localfn.ow(((float)localfn.agn() / localLinkedList.size()));
      localfn.oA(((float)localfn.agq() / localLinkedList.size()));
      localfn.oB(((float)localfn.agr() / localLinkedList.size()));
      localfn.oC(((float)localfn.ags() / localLinkedList.size()));
      if (!paramBoolean) {
        break label1168;
      }
      localfn.oJ(0L);
    }
    for (;;)
    {
      localfn.bfK();
      ujf = 0;
      AppMethodBeat.o(246170);
      return;
      label1168:
      localfn.oJ(1L);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    public static final a uji;
    
    static
    {
      AppMethodBeat.i(246167);
      uji = new a();
      AppMethodBeat.o(246167);
    }
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(246166);
      j localj = j.ujh;
      j.dfN();
      localj = j.ujh;
      j.dfO();
      AppMethodBeat.o(246166);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.j
 * JD-Core Version:    0.7.0.1
 */