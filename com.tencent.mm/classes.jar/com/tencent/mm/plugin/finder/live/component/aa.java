package com.tencent.mm.plugin.finder.live.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.cf;
import com.tencent.mm.plugin.finder.live.report.q.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.m;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubblePresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$Presenter;", "context", "Landroid/content/Context;", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BUBBLE_COMPUTING_STAY_DURATION", "", "getBUBBLE_COMPUTING_STAY_DURATION", "()I", "BUBBLE_STAY_DURATION", "getBUBBLE_STAY_DURATION", "COMPUTING_GET_RECORD_TIME_LIMIT", "getCOMPUTING_GET_RECORD_TIME_LIMIT", "LOTTERY_BUBBLE_CLOSE_TAG", "", "TAG", "getTAG", "()Ljava/lang/String;", "closeBubbleTask", "Ljava/lang/Runnable;", "computingGetLotteryRecordTimes", "getComputingGetLotteryRecordTimes", "setComputingGetLotteryRecordTimes", "(I)V", "remainTimeSecond", "getRemainTimeSecond", "setRemainTimeSecond", "statusResume", "", "getStatusResume", "()Z", "setStatusResume", "(Z)V", "timerLotteryId", "getTimerLotteryId", "setTimerLotteryId", "(Ljava/lang/String;)V", "timerThread", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "viewCallback", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubbleContract$ViewCallback;)V", "checkEnableOpenCard", "customerOpenCard", "", "doLotteryBubbleComputingLogic", "statusChange", "newLottery", "doLotteryBubbleDoneLogic", "doLotteryCardComputingLogic", "doLotteryCardDoneLogic", "endTimer", "msg", "getBubbleStayDuration", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "stayTime", "getPluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "onAttach", "callback", "onBubbleClick", "onDetach", "onTimerEnd", "onTimerRuning", "onTimerUpdate", "resumeStatus", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "showComputingBubble", "showFinishBubble", "startTimer", "statusChangeAction", "lotteryStatus", "resumeState", "updateBubble", "updateCard", "updateLotteryRecord", "updateStatus", "updateStatusImpl", "Lcom/tencent/mm/plugin/finder/live/component/LotteryUpdateStatus;", "updateTimer", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  implements z.a
{
  final com.tencent.mm.plugin.finder.live.model.context.a CvU;
  z.b CyD;
  String CyE;
  private int CyF;
  private final int CyG;
  volatile boolean CyH;
  private final int CyI;
  private final int CyJ;
  private final String CyK;
  private final Runnable CyL;
  int CyM;
  final String TAG;
  private final Context context;
  final com.tencent.mm.live.b.b nfT;
  private MTimerHandler nmZ;
  
  public aa(Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.live.b.b paramb)
  {
    AppMethodBeat.i(353075);
    this.context = paramContext;
    this.CvU = parama;
    this.nfT = paramb;
    this.TAG = "FinderLiveLotteryBubblePresenter";
    this.CyE = "";
    this.CyG = 10;
    paramContext = com.tencent.d.a.a.a.a.a.ahiX;
    this.CyI = ((Number)com.tencent.d.a.a.a.a.a.jSS().bmg()).intValue();
    paramContext = com.tencent.d.a.a.a.a.a.ahiX;
    this.CyJ = ((Number)com.tencent.d.a.a.a.a.a.jST().bmg()).intValue();
    this.CyK = "LOTTERY_BUBBLE_CLOSE_TAG";
    this.CyL = new aa..ExternalSyntheticLambda1(this);
    this.nmZ = new MTimerHandler("LiveLotteryBubble::Timer", new aa..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(353075);
  }
  
  private final int a(boolean paramBoolean, bjc parambjc, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(353160);
    int k;
    int i;
    int m;
    if (!paramBoolean)
    {
      k = cn.getSyncServerTimeSecond();
      if (parambjc == null)
      {
        i = k;
        m = k - i;
        if (m > 0) {
          break label59;
        }
        paramInt *= 1000;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(353160);
      return paramInt;
      i = parambjc.endTime;
      break;
      label59:
      if (m > 0) {
        if (m < paramInt) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label102;
        }
        paramInt = (paramInt - m) * 1000;
        break;
        i = 0;
        continue;
        i = 0;
      }
      label102:
      Log.i(this.TAG, "getBubbleStayDuration serverTime:" + k + ",finishDuration:" + m);
      paramInt = j;
      continue;
      paramInt *= 1000;
    }
  }
  
  private static final void a(aa paramaa)
  {
    AppMethodBeat.i(353175);
    s.u(paramaa, "this$0");
    Object localObject = paramaa.ehM();
    if ((localObject != null) && (!((com.tencent.mm.plugin.finder.live.view.a)localObject).isDestroyed()))
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)paramaa.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if ((localObject == null) || (((m)localObject).CBc != 1)) {
        break label110;
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = paramaa.nfT;
        if (localObject != null) {
          b.b.a((com.tencent.mm.live.b.b)localObject, b.c.nel);
        }
      }
      d.uiThread((kotlin.g.a.a)new a(paramaa));
      AppMethodBeat.o(353175);
      return;
    }
  }
  
  private final void awo(String paramString)
  {
    AppMethodBeat.i(353091);
    Log.i(this.TAG, paramString + ":endTimer remainTimeSecond:" + this.CyM + ", timerLotteryId:" + this.CyE);
    this.nmZ.stopTimer();
    AppMethodBeat.o(353091);
  }
  
  private final void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    AppMethodBeat.i(353147);
    this.CyH = true;
    h.ahAA.bFQ(this.CyK);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    if (localObject1 != null) {
      ((m)localObject1).CBc = paramInt;
    }
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    Object localObject2;
    label168:
    label211:
    boolean bool2;
    Object localObject3;
    boolean bool1;
    if ((localObject1 != null) && (((m)localObject1).CBc == 4))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (localObject1 != null) {
          break label681;
        }
        localObject1 = null;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject2).bB((String)localObject1, false);
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject1 != null) {
        break label709;
      }
      localObject1 = null;
      bool2 = this.nmZ.stopped();
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("updateTimer statusChange:").append(paramBoolean1).append(",newLottery:").append(paramBoolean2).append(",lotteryInfo is null:");
      if (localObject1 != null) {
        break label719;
      }
      bool1 = true;
      label266:
      Log.i((String)localObject2, bool1 + ",timerStoped:" + bool2 + ",resumeState:" + paramBoolean3);
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if ((localObject2 == null) || (((m)localObject2).CBc != 1)) {
        break label725;
      }
      paramInt = 1;
      label346:
      if ((paramInt == 0) || (localObject1 == null)) {
        break label743;
      }
      if ((paramBoolean2) || (paramBoolean3))
      {
        awo("startTimer");
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        this.CyM = com.tencent.mm.plugin.finder.live.utils.a.aB(((bjc)localObject1).TpP, ((bjc)localObject1).endTime, ((bjc)localObject1).CWC);
        if (this.CyM <= 0) {
          break label730;
        }
        localObject3 = ((bjc)localObject1).id;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        this.CyE = ((String)localObject2);
        this.nmZ.startTimer(1000L);
        label441:
        Log.i(this.TAG, "startTimer id:" + ((bjc)localObject1).id + " remainTimeSecond:" + this.CyM + ", timerLotteryId:" + this.CyE);
      }
      label495:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject1 != null) {
        break label753;
      }
      localObject1 = null;
      label530:
      if (localObject1 != null) {
        break label766;
      }
      label535:
      if (localObject1 != null) {
        break label853;
      }
      label540:
      if (localObject1 != null) {
        break label875;
      }
      label545:
      if (localObject1 != null) {
        break label1363;
      }
      label550:
      b.b.a(this.nfT, b.c.nel);
      label560:
      localObject2 = this.TAG;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject1 != null) {
        break label1851;
      }
      localObject1 = null;
      label601:
      Log.i((String)localObject2, s.X("updateCard localStatus:", localObject1));
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject1 != null) {
        break label1864;
      }
      localObject1 = null;
      label649:
      if (localObject1 != null) {
        break label1877;
      }
    }
    label664:
    label681:
    label709:
    label719:
    label725:
    label730:
    label743:
    label753:
    label766:
    Object localObject4;
    label853:
    label875:
    label1003:
    label1018:
    label1406:
    while (((Integer)localObject1).intValue() != 1)
    {
      if (localObject1 != null) {
        break label1893;
      }
      if (localObject1 != null) {
        break label1919;
      }
      if (localObject1 != null) {
        break label2292;
      }
      AppMethodBeat.o(353147);
      return;
      paramInt = 0;
      break;
      localObject1 = ((m)localObject1).Bhm;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label168;
      }
      localObject1 = ((bjc)localObject1).id;
      break label168;
      localObject1 = ((m)localObject1).Bhm;
      break label211;
      bool1 = false;
      break label266;
      paramInt = 0;
      break label346;
      this.CyE = "";
      eim();
      break label441;
      awo("updateTimer");
      break label495;
      localObject1 = Integer.valueOf(((m)localObject1).CBc);
      break label530;
      if (((Integer)localObject1).intValue() != 1) {
        break label535;
      }
      b.b.a(this.nfT, b.c.nek);
      if (paramBoolean1)
      {
        localObject1 = this.CyD;
        if (localObject1 == null) {
          break label560;
        }
        ((z.b)localObject1).aV((kotlin.g.a.a)new e(this));
        break label560;
      }
      localObject1 = this.CyD;
      if (localObject1 == null) {
        break label560;
      }
      ((z.b)localObject1).aW((kotlin.g.a.a)new f(this));
      break label560;
      if (((Integer)localObject1).intValue() != 4) {
        break label540;
      }
      Log.i(this.TAG, "cancel LotteryBubble!");
      break label550;
      if (((Integer)localObject1).intValue() != 2) {
        break label545;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject1 == null)
      {
        paramInt = 0;
        paramBoolean3 = d.ee(paramInt, 1);
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        bool1 = com.tencent.mm.plugin.finder.live.utils.a.bUx();
        Log.i(this.TAG, "doLotteryBubbleComputingLogic isAnchor:" + bool1 + " participated:" + paramBoolean3);
        localObject1 = this.CyD;
        if (localObject1 != null) {
          ((z.b)localObject1).eik();
        }
        localObject1 = this.CvU;
        if (localObject1 != null) {
          break label1272;
        }
        localObject1 = null;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).Egp;
        if (localObject1 != null) {
          break label1288;
        }
        localObject1 = null;
        localObject2 = this.CvU;
        if (localObject2 != null) {
          break label1301;
        }
        localObject2 = null;
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject2).Egp;
        if (localObject2 != null) {
          break label1317;
        }
        localObject2 = null;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (localObject3 != null) {
          break label1330;
        }
        localObject3 = null;
        if (localObject3 != null) {
          break label1340;
        }
      }
      for (localObject4 = null;; localObject4 = ((bjc)localObject3).id)
      {
        paramInt = a(paramBoolean1, (bjc)localObject3, this.CyJ);
        Log.i(this.TAG, "showComputingBubble localLotteryId:" + localObject4 + ",statusChange:" + paramBoolean1 + ",newLottery:" + paramBoolean2 + ",BUBBLE_COMPUTING_STAY_DURATION:" + this.CyJ + ",delayDuration:" + paramInt + ",lastDoneLottery:" + localObject1 + ",cardShowing:" + localObject2);
        if ((localObject4 == null) || (paramInt <= 0)) {
          break label1350;
        }
        h.ahAA.bFQ(this.CyK);
        h.ahAA.a(this.CyL, paramInt, this.CyK);
        b.b.a(this.nfT, b.c.nek);
        break;
        localObject1 = ((m)localObject1).Bhm;
        if (localObject1 == null)
        {
          paramInt = 0;
          break label918;
        }
        paramInt = ((bjc)localObject1).extFlag;
        break label918;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        break label1003;
        localObject1 = Boolean.valueOf(((m)localObject1).EbV);
        break label1018;
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        break label1032;
        localObject2 = Boolean.valueOf(((m)localObject2).EbW);
        break label1047;
        localObject3 = ((m)localObject3).Bhm;
        break label1082;
      }
      b.b.a(this.nfT, b.c.nel);
      break label560;
      if (((Integer)localObject1).intValue() != 3) {
        break label550;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject1 == null)
      {
        paramInt = 0;
        paramBoolean3 = d.ee(paramInt, 1);
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        bool1 = com.tencent.mm.plugin.finder.live.utils.a.bUx();
        Log.i(this.TAG, "doLotteryBubbleDoneLogic isAnchor:" + bool1 + " participated:" + paramBoolean3);
        h.ahAA.bFQ(this.CyK);
        localObject1 = this.CvU;
        if (localObject1 != null) {
          break label1760;
        }
        localObject1 = null;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject1).Egp;
        if (localObject1 != null) {
          break label1776;
        }
        localObject1 = null;
        localObject2 = this.CvU;
        if (localObject2 != null) {
          break label1789;
        }
        localObject2 = null;
        localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject2).Egp;
        if (localObject2 != null) {
          break label1805;
        }
        localObject2 = null;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (localObject3 != null) {
          break label1818;
        }
        localObject3 = null;
        if (localObject3 != null) {
          break label1828;
        }
      }
      for (localObject4 = null;; localObject4 = ((bjc)localObject3).id)
      {
        paramInt = a(paramBoolean1, (bjc)localObject3, this.CyI);
        Log.i(this.TAG, "showFinishBubble localLotteryId:" + localObject4 + ",statusChange:" + paramBoolean1 + ",newLottery:" + paramBoolean2 + ",BUBBLE_STAY_DURATION:" + this.CyI + ",delayDuration:" + paramInt + ",lastDoneLottery:" + localObject1 + ",cardShowing:" + localObject2);
        if ((localObject4 == null) || (paramInt <= 0)) {
          break label1838;
        }
        localObject1 = this.CyD;
        if (localObject1 != null) {
          ((z.b)localObject1).eil();
        }
        h.ahAA.a(this.CyL, paramInt, this.CyK);
        b.b.a(this.nfT, b.c.nek);
        break;
        localObject1 = ((m)localObject1).Bhm;
        if (localObject1 == null)
        {
          paramInt = 0;
          break label1406;
        }
        paramInt = ((bjc)localObject1).extFlag;
        break label1406;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        break label1486;
        localObject1 = Boolean.valueOf(((m)localObject1).EbV);
        break label1501;
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((com.tencent.mm.plugin.finder.live.model.context.a)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
        break label1515;
        localObject2 = Boolean.valueOf(((m)localObject2).EbW);
        break label1530;
        localObject3 = ((m)localObject3).Bhm;
        break label1565;
      }
      b.b.a(this.nfT, b.c.nel);
      break label560;
      localObject1 = Integer.valueOf(((m)localObject1).CBc);
      break label601;
      localObject1 = Integer.valueOf(((m)localObject1).CBc);
      break label649;
    }
    label918:
    label1047:
    label1317:
    label1330:
    label2233:
    label2617:
    for (;;)
    {
      label1082:
      label1272:
      label1530:
      label1789:
      AppMethodBeat.o(353147);
      label1340:
      label1350:
      label1363:
      label1501:
      label1515:
      label1776:
      return;
      label1486:
      label1760:
      label1893:
      if (((Integer)localObject1).intValue() != 4) {
        break;
      }
      label1851:
      label1864:
      label1877:
      b.b.a(this.nfT, b.c.nep);
      AppMethodBeat.o(353147);
      return;
      label1919:
      if (((Integer)localObject1).intValue() != 2) {
        break label664;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject1 == null)
      {
        paramInt = 0;
        paramBoolean2 = d.ee(paramInt, 1);
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramBoolean3 = com.tencent.mm.plugin.finder.live.utils.a.bUx();
        bool1 = ((e)this.CvU.business(e.class)).isLiveStarted();
        localObject2 = this.TAG;
        localObject3 = new StringBuilder("doLotteryCardComputingLogic liveState:").append(((e)this.CvU.business(e.class)).EcT).append(",isAnchor:").append(paramBoolean3).append(" localStatus:");
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (localObject1 != null) {
          break label2233;
        }
      }
      for (localObject1 = null;; localObject1 = Integer.valueOf(((m)localObject1).CBc))
      {
        Log.i((String)localObject2, localObject1 + ",participated:" + paramBoolean2 + ",statusChange:" + paramBoolean1 + ",computingGetLotteryRecordTimes:" + this.CyF);
        if ((!paramBoolean1) || (!bool1) || ((!paramBoolean3) && (!paramBoolean2))) {
          break label2246;
        }
        ein();
        localObject1 = this.nfT;
        localObject2 = b.c.nem;
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", true);
        localObject4 = ah.aiuX;
        ((com.tencent.mm.live.b.b)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
        AppMethodBeat.o(353147);
        return;
        localObject1 = ((m)localObject1).Bhm;
        if (localObject1 == null)
        {
          paramInt = 0;
          break;
        }
        paramInt = ((bjc)localObject1).extFlag;
        break;
      }
      label2246:
      if (bool1)
      {
        paramInt = this.CyF;
        this.CyF = (paramInt + 1);
        if (paramInt < this.CyG) {
          ein();
        }
      }
      b.b.a(this.nfT, b.c.nep);
      AppMethodBeat.o(353147);
      return;
      label2292:
      if (((Integer)localObject1).intValue() == 3)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (localObject1 == null)
        {
          paramInt = 0;
          paramBoolean3 = d.ee(paramInt, 1);
          localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          bool1 = com.tencent.mm.plugin.finder.live.utils.a.bUx();
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
          if (localObject1 != null) {
            break label2608;
          }
        }
        for (paramBoolean2 = false;; paramBoolean2 = ((m)localObject1).EbU)
        {
          bool2 = ((e)((e)this.CvU.business(e.class)).business(e.class)).isLiveStarted();
          Log.i(this.TAG, "doLotteryCardDoneLogic liveState:" + ((e)((e)this.CvU.business(e.class)).business(e.class)).EcT + ",isAnchor:" + bool1 + " participated:" + paramBoolean3 + ",statusChange:" + paramBoolean1 + ", haveLottering:" + paramBoolean2);
          if ((paramBoolean2) || (!bool2) || (!paramBoolean1) || ((!paramBoolean3) && (!bool1))) {
            break label2617;
          }
          ein();
          localObject1 = this.nfT;
          localObject2 = b.c.nem;
          localObject3 = new Bundle();
          ((Bundle)localObject3).putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", true);
          localObject4 = ah.aiuX;
          ((com.tencent.mm.live.b.b)localObject1).statusChange((b.c)localObject2, (Bundle)localObject3);
          AppMethodBeat.o(353147);
          return;
          localObject1 = ((m)localObject1).Bhm;
          if (localObject1 == null)
          {
            paramInt = 0;
            break;
          }
          paramInt = ((bjc)localObject1).extFlag;
          break;
        }
        b.b.a(this.nfT, b.c.nep);
      }
    }
  }
  
  private static final boolean b(aa paramaa)
  {
    AppMethodBeat.i(353183);
    s.u(paramaa, "this$0");
    d.uiThread((kotlin.g.a.a)new c(paramaa));
    AppMethodBeat.o(353183);
    return true;
  }
  
  private final com.tencent.mm.plugin.finder.live.view.a ehM()
  {
    if ((this.nfT instanceof com.tencent.mm.plugin.finder.live.view.a)) {
      return (com.tencent.mm.plugin.finder.live.view.a)this.nfT;
    }
    return null;
  }
  
  private final void ein()
  {
    AppMethodBeat.i(353166);
    Object localObject = ehM();
    ap localap;
    if (localObject != null)
    {
      localap = ((com.tencent.mm.plugin.finder.live.view.a)localObject).getFinderLiveAssistant();
      if (localap != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (localObject != null) {
          break label83;
        }
        localObject = "";
      }
    }
    for (;;)
    {
      localap.a((String)localObject, null, (ad.a)new g(this));
      AppMethodBeat.o(353166);
      return;
      label83:
      localObject = ((m)localObject).Bhm;
      if (localObject == null)
      {
        localObject = "";
      }
      else
      {
        localObject = ((bjc)localObject).id;
        if (localObject == null) {
          localObject = "";
        }
      }
    }
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(353234);
    s.u(paramm, "lotteryInfoWrapper");
    d.uiThread((kotlin.g.a.a)new h(paramm, this));
    AppMethodBeat.o(353234);
  }
  
  public final void b(final m paramm)
  {
    AppMethodBeat.i(353228);
    s.u(paramm, "lotteryInfoWrapper");
    d.uiThread((kotlin.g.a.a)new d(this, paramm));
    AppMethodBeat.o(353228);
  }
  
  public final void eij()
  {
    AppMethodBeat.i(353246);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label204;
      }
      bool = true;
      label44:
      if (bool) {
        break label212;
      }
      Log.i(this.TAG, "customerOpenCard checkEnableOpenCard false!");
    }
    for (;;)
    {
      if (this.nfT.getLiveRole() != 1) {
        break label416;
      }
      j.Dob.a(q.h.DsA, "");
      AppMethodBeat.o(353246);
      return;
      localObject1 = ((m)localObject1).Bhm;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bjc)localObject1).ZSN;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      int i;
      if (((bjd)localObject1).ZSP)
      {
        localObject2 = (CharSequence)((bjd)localObject1).wording;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          label150:
          if (i == 0) {
            break label191;
          }
          localObject1 = this.context.getResources().getString(p.h.CmU);
          label168:
          com.tencent.mm.ui.base.aa.showTextToast(this.context, (String)localObject1);
        }
      }
      for (bool = false;; bool = true)
      {
        localObject1 = Boolean.valueOf(bool);
        break;
        i = 0;
        break label150;
        label191:
        localObject1 = ((bjd)localObject1).wording;
        break label168;
      }
      label204:
      bool = ((Boolean)localObject1).booleanValue();
      break label44;
      label212:
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if ((localObject1 != null) && (((m)localObject1).CBc == 3))
      {
        i = 1;
        label252:
        if (i != 0) {
          break label370;
        }
        localObject1 = ehM();
        if (localObject1 == null) {
          continue;
        }
        localObject2 = ((com.tencent.mm.plugin.finder.live.view.a)localObject1).getFinderLiveAssistant();
        if (localObject2 == null) {
          continue;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (localObject1 != null) {
          break label337;
        }
        localObject1 = "";
      }
      for (;;)
      {
        ((ap)localObject2).a((String)localObject1, null, (ad.a)new b(this));
        break;
        i = 0;
        break label252;
        label337:
        localObject1 = ((m)localObject1).Bhm;
        if (localObject1 == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = ((bjc)localObject1).id;
          if (localObject1 == null) {
            localObject1 = "";
          }
        }
      }
      label370:
      localObject1 = this.nfT;
      Object localObject2 = b.c.nem;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", false);
      ah localah = ah.aiuX;
      ((com.tencent.mm.live.b.b)localObject1).statusChange((b.c)localObject2, localBundle);
    }
    label416:
    if (this.nfT.getLiveRole() == 0) {
      com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFf, "");
    }
    AppMethodBeat.o(353246);
  }
  
  final void eim()
  {
    AppMethodBeat.i(353224);
    awo("onTimerEnd");
    m localm = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    if ((localm != null) && (localm.CBc == 1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        b(true, false, 2, false);
      }
      AppMethodBeat.o(353224);
      return;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(353253);
    Log.i(this.TAG, "onDetach");
    z.b localb = this.CyD;
    if (localb != null) {
      localb.reset();
    }
    this.CyD = null;
    awo("onDetach");
    h.ahAA.bFQ(this.CyK);
    AppMethodBeat.o(353253);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubblePresenter$customerOpenCard$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ad.a
  {
    b(aa paramaa) {}
    
    public final void a(int paramInt1, int paramInt2, bib parambib)
    {
      AppMethodBeat.i(352647);
      s.u(parambib, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CyN.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).a(parambib.Bhm);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CyN.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).d(parambib);
      }
      b.b.a(this.CyN.nfT, b.c.neo);
      parambib = this.CyN.nfT;
      b.c localc = b.c.nem;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", false);
      ah localah = ah.aiuX;
      parambib.statusChange(localc, localBundle);
      AppMethodBeat.o(352647);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(aa paramaa, m paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/component/FinderLiveLotteryBubblePresenter$updateLotteryRecord$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ad.a
  {
    g(aa paramaa) {}
    
    public final void a(int paramInt1, int paramInt2, bib parambib)
    {
      AppMethodBeat.i(352630);
      s.u(parambib, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CyN.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).a(parambib.Bhm);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)this.CyN.CvU.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).d(parambib);
      }
      AppMethodBeat.o(352630);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(m paramm, aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.aa
 * JD-Core Version:    0.7.0.1
 */