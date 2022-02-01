package com.tencent.mm.plugin.finder.live.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager;", "", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "clickCnt", "", "comboBatchSize", "comboBatchTimeoutMs", "comboId", "continuousClickTimeThreshHold", "", "lastClickCnt", "lastTouchUpTime", "longClickInstantCallbackInterval", "longClickRunnable", "com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1;", "longClickTimeThreshHold", "longClickTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onTouchUpOrCancelState", "", "registerView", "Landroid/view/View;", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "timer", "touchListener", "Landroid/view/View$OnTouchListener;", "cancelLongClickState", "", "checkComboBatchSize", "checkIfContinuousClick", "view", "initialValue", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;Ljava/lang/Integer;)V", "unRegisterView", "updateState", "newState", "IContinuousClickCallback", "Mode", "State", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  private final int CHg;
  public final int CHh;
  private final long DIF;
  private final long DIG;
  final long DIH;
  public volatile b DII;
  public volatile int DIJ;
  public volatile int DIK;
  public volatile long DIL;
  volatile boolean DIM;
  public a DIN;
  public volatile View DIO;
  public final View.OnTouchListener DIP;
  private final d DIQ;
  MTimerHandler DIR;
  public volatile String Dbx;
  final String TAG;
  public MTimerHandler timer;
  
  public j()
  {
    AppMethodBeat.i(351335);
    this.TAG = "Finder.ContinuousClickManager";
    this.DIF = 3000L;
    aj localaj = aj.CGT;
    if (aj.elu() > 0)
    {
      localaj = aj.CGT;
      i = aj.elu();
      this.CHg = i;
      localaj = aj.CGT;
      if (aj.elv() <= 0) {
        break label185;
      }
      localaj = aj.CGT;
    }
    label185:
    for (int i = aj.elv();; i = 1000)
    {
      this.CHh = i;
      this.DIG = 500L;
      this.DIH = 200L;
      this.DII = b.DIS;
      this.Dbx = "";
      this.DIM = true;
      this.DIP = new j..ExternalSyntheticLambda0(this);
      this.DIQ = new d(this);
      this.timer = new MTimerHandler("ContinuousClickManager::Timer", (MTimerHandler.CallBack)new f(this), true);
      this.DIR = new MTimerHandler("ContinuousClickManager::longClickTimer", (MTimerHandler.CallBack)new e(this), true);
      AppMethodBeat.o(351335);
      return;
      i = 5;
      break;
    }
  }
  
  private static final boolean a(j paramj, View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = null;
    int i = 0;
    AppMethodBeat.i(351400);
    s.u(paramj, "this$0");
    if (paramMotionEvent == null)
    {
      paramView = null;
      if (paramView != null) {
        break label142;
      }
      label26:
      if (paramView != null) {
        break label396;
      }
      label30:
      if (paramView != null) {
        break label412;
      }
      label34:
      if (paramView != null) {
        break label425;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        Log.i(paramj.TAG, s.X("on ACTION_UP or ACTION_CANCEL: ", paramMotionEvent));
        paramj.DIM = true;
        paramj.DIL = System.currentTimeMillis();
        if (paramj.timer.stopped())
        {
          Log.i(paramj.TAG, "single click start timer");
          paramj.timer.startTimer(paramj.CHh);
        }
        paramj.eus();
        paramj = paramj.DIN;
        if (paramj != null)
        {
          s.s(paramMotionEvent, "event");
          paramj.ac(paramMotionEvent);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(351400);
        return true;
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        label142:
        if (paramView.intValue() != 0) {
          break label26;
        }
        paramj.DIM = false;
        paramView = paramj.DII;
        switch (c.$EnumSwitchMapping$0[paramView.ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.ae.d.a(paramj.DIG, (Runnable)paramj.DIQ);
          break;
          if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
          {
            paramView = com.tencent.d.a.a.a.a.a.ahiX;
            if (1 == ((Number)com.tencent.d.a.a.a.a.a.jSq().bmg()).intValue())
            {
              paramView = z.bAM();
              if (paramView == null) {
                paramView = null;
              }
              for (;;)
              {
                paramj.Dbx = s.X(g.getMessageDigest(paramView), "_123456");
                paramj.a(b.DIT);
                break;
                paramView = paramView.getBytes(kotlin.n.d.UTF_8);
                s.s(paramView, "(this as java.lang.String).getBytes(charset)");
              }
            }
          }
          paramMotionEvent = new StringBuilder();
          paramView = z.bAM();
          if (paramView == null) {
            paramView = localObject;
          }
          for (;;)
          {
            paramj.Dbx = (g.getMessageDigest(paramView) + '_' + UUID.randomUUID());
            break;
            paramView = paramView.getBytes(kotlin.n.d.UTF_8);
            s.s(paramView, "(this as java.lang.String).getBytes(charset)");
          }
          if (paramj.eut()) {
            paramj.a(b.DIU);
          } else {
            paramj.a(b.DIT);
          }
        }
        label396:
        if (paramView.intValue() != 2) {
          break label30;
        }
        paramj.DIM = false;
      }
      label412:
      if (paramView.intValue() != 1) {
        break label34;
      }
      i = 1;
      continue;
      label425:
      if (paramView.intValue() == 3) {
        i = 1;
      }
    }
  }
  
  private final void eus()
  {
    AppMethodBeat.i(351349);
    com.tencent.mm.ae.d.H((Runnable)this.DIQ);
    this.DIR.stopTimer();
    Log.i(this.TAG, s.X("cancelLongClickState: longClickTimer.stopped = ", Boolean.valueOf(this.DIR.stopped())));
    AppMethodBeat.o(351349);
  }
  
  private final void euu()
  {
    AppMethodBeat.i(351365);
    int i = this.DIJ - this.DIK;
    if (i >= this.CHg)
    {
      Log.i(this.TAG, "checkComboBatchSize: clickCnt = " + this.DIJ + ", lastClickCnt = " + this.DIK);
      this.DIK = this.DIJ;
      a locala = this.DIN;
      if (locala != null)
      {
        View localView = this.DIO;
        j.a.a.a(locala, this.DIJ, i, this.DII, this.Dbx);
      }
      if (!this.timer.stopped())
      {
        this.timer.stopTimer();
        this.timer.startTimer(this.CHh);
      }
    }
    AppMethodBeat.o(351365);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(351451);
    Log.i(this.TAG, s.X("updateState: newState = ", paramb));
    this.DII = paramb;
    switch (c.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(351451);
      return;
      this.DIJ = 0;
      this.DIK = 0;
      this.Dbx = "";
      AppMethodBeat.o(351451);
      return;
      this.DIJ += 1;
      a locala = this.DIN;
      View localView;
      if (locala != null)
      {
        localView = this.DIO;
        locala.a(this.DIJ, paramb, this.Dbx, this.DIJ - this.DIK);
      }
      euu();
      AppMethodBeat.o(351451);
      return;
      this.DIJ += 1;
      locala = this.DIN;
      if (locala != null)
      {
        localView = this.DIO;
        locala.a(this.DIJ, paramb, this.Dbx, this.DIJ - this.DIK);
      }
      euu();
    }
  }
  
  final boolean eut()
  {
    AppMethodBeat.i(351460);
    if ((!this.DIM) || (System.currentTimeMillis() - this.DIL < this.DIF))
    {
      AppMethodBeat.o(351460);
      return true;
    }
    AppMethodBeat.o(351460);
    return false;
  }
  
  public final void gd(View paramView)
  {
    AppMethodBeat.i(351436);
    if (this.DIO == null)
    {
      AppMethodBeat.o(351436);
      return;
    }
    Log.i(this.TAG, s.X("unRegisterView view: ", paramView));
    if (paramView != null) {
      paramView.setOnTouchListener(null);
    }
    this.DIO = null;
    this.timer.stopTimer();
    eus();
    int i = this.DIJ - this.DIK;
    if (i > 0)
    {
      paramView = this.DIN;
      if (paramView != null)
      {
        View localView = this.DIO;
        paramView.a(this.DIJ, i, this.DII, this.Dbx, true);
      }
    }
    this.DIN = null;
    a(b.DIS);
    this.DIM = true;
    AppMethodBeat.o(351436);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "", "batchCallback", "", "view", "Landroid/view/View;", "clickCnt", "", "diffCnt", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "comboId", "", "needCheckBalance", "instantCallback", "onActionUpOrCancel", "", "event", "Landroid/view/MotionEvent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract boolean a(int paramInt1, int paramInt2, j.b paramb, String paramString, boolean paramBoolean);
    
    public abstract boolean a(int paramInt1, j.b paramb, String paramString, int paramInt2);
    
    public abstract void ac(MotionEvent paramMotionEvent);
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "", "(Ljava/lang/String;I)V", "NORMAL", "SINGLE_CLICK", "CONTINUOUS_CLICKING", "LONG_CLICK", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(351325);
      DIS = new b("NORMAL", 0);
      DIT = new b("SINGLE_CLICK", 1);
      DIU = new b("CONTINUOUS_CLICKING", 2);
      DIV = new b("LONG_CLICK", 3);
      DIW = new b[] { DIS, DIT, DIU, DIV };
      AppMethodBeat.o(351325);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Runnable
  {
    d(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(351273);
      this.DIX.a(j.b.DIV);
      if (this.DIX.timer.stopped())
      {
        Log.i(this.DIX.TAG, "long click start timer");
        this.DIX.timer.startTimer(this.DIX.CHh);
      }
      if (this.DIX.DIR.stopped())
      {
        Log.i(this.DIX.TAG, "long click start longClickTimer");
        this.DIX.DIR.startTimer(this.DIX.DIH);
      }
      AppMethodBeat.o(351273);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MTimerHandler.CallBack
  {
    e(j paramj) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(351278);
      if (this.DIX.DIM)
      {
        AppMethodBeat.o(351278);
        return false;
      }
      Log.i(this.DIX.TAG, "ContinuousClickManager longClickTimer callback: clickCnt = " + this.DIX.DIJ + ", state = " + this.DIX.DII.name() + ", lastClickCnt = " + this.DIX.DIK);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.DIX));
      AppMethodBeat.o(351278);
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(j paramj)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements MTimerHandler.CallBack
  {
    f(j paramj) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(351305);
      Log.i(this.DIX.TAG, "ContinuousClickManager Timer callback: clickCnt = " + this.DIX.DIJ + ", state = " + this.DIX.DII.name() + ", lastClickCnt = " + this.DIX.DIK);
      View localView;
      if (this.DIX.DIK != this.DIX.DIJ)
      {
        int i = this.DIX.DIJ - this.DIX.DIK;
        this.DIX.DIK = this.DIX.DIJ;
        if (i < 0)
        {
          this.DIX.a(j.b.DIS);
          locala = this.DIX.DIN;
          if (locala != null)
          {
            localView = this.DIX.DIO;
            j.a.a.a(locala, this.DIX.DIJ, 0, j.b.DIS, this.DIX.Dbx);
          }
          AppMethodBeat.o(351305);
          return false;
        }
        locala = this.DIX.DIN;
        if (locala != null)
        {
          localView = this.DIX.DIO;
          j.a.a.a(locala, this.DIX.DIJ, i, this.DIX.DII, this.DIX.Dbx);
        }
      }
      if (this.DIX.eut())
      {
        AppMethodBeat.o(351305);
        return true;
      }
      this.DIX.a(j.b.DIS);
      j.a locala = this.DIX.DIN;
      if (locala != null)
      {
        localView = this.DIX.DIO;
        j.a.a.a(locala, this.DIX.DIJ, 0, j.b.DIS, this.DIX.Dbx);
      }
      AppMethodBeat.o(351305);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.j
 * JD-Core Version:    0.7.0.1
 */