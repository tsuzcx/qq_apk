package com.tencent.mm.plugin.finder.replay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;", "", "mode", "", "liveId", "", "updateFrequency", "insertFrequency", "parameterGenerator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/Triple;", "(IJIILkotlin/jvm/functions/Function2;)V", "callback", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager$Callback;)V", "countDownCallback", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "getCountDownCallback", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "countDownCallback$delegate", "Lkotlin/Lazy;", "countDownNum", "countDownThreshold", "defaultTimerGenerator", "getDefaultTimerGenerator", "()Lkotlin/jvm/functions/Function2;", "defaultTimerGenerator$delegate", "getLiveId", "()J", "setLiveId", "(J)V", "getMode", "()I", "getParameterGenerator", "setParameterGenerator", "(Lkotlin/jvm/functions/Function2;)V", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "timing", "", "usedTimeSecond", "getCountDownSec", "haveCountDown", "release", "", "running", "startCountDown", "stopCountDown", "updateInfo", "taskOver", "updateTimerInfo", "Callback", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.b Fjz;
  private final int FjA;
  private final int FjB;
  private m<? super Integer, ? super Long, kotlin.u<Integer, Integer, Integer>> FjC;
  public a FjD;
  private int FjE;
  public int FjF;
  private int FjG;
  private boolean FjH;
  private final j FjI;
  private final j FjJ;
  long liveId;
  private final int mode;
  private MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(332763);
    Fjz = new a.b((byte)0);
    AppMethodBeat.o(332763);
  }
  
  private a(long paramLong)
  {
    AppMethodBeat.i(332643);
    this.mode = 1;
    this.liveId = paramLong;
    this.FjA = 5;
    this.FjB = 30;
    this.FjC = null;
    this.FjI = k.cm((kotlin.g.a.a)a.d.FjL);
    this.FjJ = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(332643);
  }
  
  private m<Integer, Long, kotlin.u<Integer, Integer, Integer>> eLp()
  {
    AppMethodBeat.i(332655);
    m localm = (m)this.FjI.getValue();
    AppMethodBeat.o(332655);
    return localm;
  }
  
  private final MTimerHandler.CallBack eLq()
  {
    AppMethodBeat.i(332663);
    MTimerHandler.CallBack localCallBack = (MTimerHandler.CallBack)this.FjJ.getValue();
    AppMethodBeat.o(332663);
    return localCallBack;
  }
  
  private final void tt(boolean paramBoolean)
  {
    AppMethodBeat.i(332681);
    if (!paramBoolean)
    {
      if (this.mode == 1)
      {
        ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage().T(this.liveId, this.FjG);
        AppMethodBeat.o(332681);
        return;
      }
      if (this.mode == 2) {
        ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage().U(this.liveId, this.FjG);
      }
    }
    AppMethodBeat.o(332681);
  }
  
  public final void d(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(332782);
    MTimerHandler localMTimerHandler = this.timer;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    this.FjH = false;
    if ((paramBoolean1) && (paramLong == this.liveId))
    {
      tt(paramBoolean2);
      AppMethodBeat.o(332782);
      return;
    }
    Log.i("FinderLiveFreeTimeManager", "stopCountDown remote liveId:" + paramLong + ",local liveId:" + this.liveId + ", updateInfo:" + paramBoolean1 + ", taskOver:" + paramBoolean2);
    AppMethodBeat.o(332782);
  }
  
  public final boolean eLr()
  {
    return this.FjG > 0;
  }
  
  public final boolean eLs()
  {
    AppMethodBeat.i(332788);
    MTimerHandler localMTimerHandler = this.timer;
    if ((localMTimerHandler != null) && (!localMTimerHandler.stopped()))
    {
      AppMethodBeat.o(332788);
      return true;
    }
    AppMethodBeat.o(332788);
    return false;
  }
  
  public final void exT()
  {
    AppMethodBeat.i(332769);
    Object localObject = this.FjC;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label209;
      }
      localObject = (kotlin.u)eLp().invoke(Integer.valueOf(this.mode), Long.valueOf(this.liveId));
    }
    label209:
    for (;;)
    {
      this.FjE = ((Number)((kotlin.u)localObject).bsC).intValue();
      this.FjG = ((Number)((kotlin.u)localObject).bsD).intValue();
      this.FjF = ((Number)((kotlin.u)localObject).aiuN).intValue();
      localObject = this.FjD;
      if (localObject != null) {
        ((a)localObject).hG(this.FjF, this.FjE);
      }
      localObject = this.timer;
      if (localObject != null) {
        ((MTimerHandler)localObject).stopTimer();
      }
      this.timer = new MTimerHandler(s.X("FinderLiveFreeTimeManager", Integer.valueOf(hashCode())), eLq(), true);
      localObject = this.timer;
      if (localObject != null) {
        ((MTimerHandler)localObject).startTimer(1000L);
      }
      this.FjH = true;
      AppMethodBeat.o(332769);
      return;
      localObject = (kotlin.u)((m)localObject).invoke(Integer.valueOf(this.mode), Long.valueOf(this.liveId));
      break;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(332795);
    d(this.liveId, eLr(), false);
    this.FjD = null;
    AppMethodBeat.o(332795);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager$Callback;", "", "updateTimer", "", "freeTomeToWatch", "", "totalFreeTimeToWatch", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void hG(int paramInt1, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MTimerHandler.CallBack>
  {
    c(a parama)
    {
      super();
    }
    
    private static final boolean h(a parama)
    {
      AppMethodBeat.i(332539);
      s.u(parama, "this$0");
      d.uiThread((kotlin.g.a.a)new a(parama));
      AppMethodBeat.o(332539);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.a
 * JD-Core Version:    0.7.0.1
 */