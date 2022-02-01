package com.tencent.mm.plugin.finder.live.util;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager;", "", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "clickCnt", "", "comboBatchSize", "comboBatchTimeoutMs", "comboId", "continuousClickTimeThreshHold", "", "lastClickCnt", "lastTouchUpTime", "longClickInstantCallbackInterval", "longClickRunnable", "com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1;", "longClickTimeThreshHold", "longClickTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onTouchUpOrCancelState", "", "registerView", "Landroid/view/View;", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "timer", "touchListener", "Landroid/view/View$OnTouchListener;", "cancelLongClickState", "", "checkComboBatchSize", "checkIfContinuousClick", "view", "initialValue", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;Ljava/lang/Integer;)V", "unRegisterView", "updateState", "newState", "IContinuousClickCallback", "Mode", "State", "plugin-finder_release"})
public final class j
{
  final String TAG;
  public MTimerHandler timer;
  private final long yPZ;
  final long yQa;
  final long yQb;
  public volatile b yQc;
  public volatile int yQd;
  public volatile int yQe;
  public volatile long yQf;
  volatile boolean yQg;
  public a yQh;
  public volatile View yQi;
  @SuppressLint({"ClickableViewAccessibility"})
  public final View.OnTouchListener yQj;
  final c yQk;
  MTimerHandler yQl;
  private final int yhm;
  public final int yhn;
  public volatile String yru;
  
  public j()
  {
    AppMethodBeat.i(287806);
    this.TAG = "Finder.ContinuousClickManager";
    this.yPZ = 3000L;
    ah localah = ah.yhC;
    if (ah.dzn() > 0)
    {
      localah = ah.yhC;
      i = ah.dzn();
      this.yhm = i;
      localah = ah.yhC;
      if (ah.dzo() <= 0) {
        break label188;
      }
      localah = ah.yhC;
    }
    label188:
    for (int i = ah.dzo();; i = 1000)
    {
      this.yhn = i;
      this.yQa = 500L;
      this.yQb = 200L;
      this.yQc = b.yQm;
      this.yru = "";
      this.yQg = true;
      this.yQj = ((View.OnTouchListener)new f(this));
      this.yQk = new c(this);
      this.timer = new MTimerHandler("ContinuousClickManager::Timer", (MTimerHandler.CallBack)new e(this), true);
      this.yQl = new MTimerHandler("ContinuousClickManager::longClickTimer", (MTimerHandler.CallBack)new d(this), true);
      AppMethodBeat.o(287806);
      return;
      i = 5;
      break;
    }
  }
  
  private final void dEt()
  {
    AppMethodBeat.i(287805);
    int i = this.yQd - this.yQe;
    if (i >= this.yhm)
    {
      Log.i(this.TAG, "checkComboBatchSize: clickCnt = " + this.yQd + ", lastClickCnt = " + this.yQe);
      this.yQe = this.yQd;
      a locala = this.yQh;
      if (locala != null)
      {
        View localView = this.yQi;
        j.a.a.a(locala, this.yQd, i, this.yQc, this.yru);
      }
      if (!this.timer.stopped())
      {
        this.timer.stopTimer();
        this.timer.startTimer(this.yhn);
      }
    }
    AppMethodBeat.o(287805);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(287804);
    Log.i(this.TAG, "updateState: newState = ".concat(String.valueOf(paramb)));
    this.yQc = paramb;
    switch (k.jLJ[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287804);
      return;
      this.yQd = 0;
      this.yQe = 0;
      this.yru = "";
      AppMethodBeat.o(287804);
      return;
      this.yQd += 1;
      a locala = this.yQh;
      View localView;
      if (locala != null)
      {
        localView = this.yQi;
        locala.a(this.yQd, paramb, this.yru, this.yQd - this.yQe);
      }
      dEt();
      AppMethodBeat.o(287804);
      return;
      this.yQd += 1;
      locala = this.yQh;
      if (locala != null)
      {
        localView = this.yQi;
        locala.a(this.yQd, paramb, this.yru, this.yQd - this.yQe);
      }
      dEt();
    }
  }
  
  final void dEs()
  {
    AppMethodBeat.i(287802);
    com.tencent.mm.ae.d.C((Runnable)this.yQk);
    this.yQl.stopTimer();
    Log.i(this.TAG, "cancelLongClickState: longClickTimer.stopped = " + this.yQl.stopped());
    AppMethodBeat.o(287802);
  }
  
  public final void ez(View paramView)
  {
    AppMethodBeat.i(287801);
    if (this.yQi == null)
    {
      AppMethodBeat.o(287801);
      return;
    }
    Log.i(this.TAG, "unRegisterView view: ".concat(String.valueOf(paramView)));
    if (paramView != null) {
      paramView.setOnTouchListener(null);
    }
    this.yQi = null;
    this.timer.stopTimer();
    dEs();
    int i = this.yQd - this.yQe;
    if (i > 0)
    {
      paramView = this.yQh;
      if (paramView != null)
      {
        View localView = this.yQi;
        paramView.a(this.yQd, i, this.yQc, this.yru, true);
      }
    }
    this.yQh = null;
    a(b.yQm);
    this.yQg = true;
    AppMethodBeat.o(287801);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "", "batchCallback", "", "view", "Landroid/view/View;", "clickCnt", "", "diffCnt", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "comboId", "", "needCheckBalance", "instantCallback", "onActionUpOrCancel", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean a(int paramInt1, int paramInt2, j.b paramb, String paramString, boolean paramBoolean);
    
    public abstract boolean a(int paramInt1, j.b paramb, String paramString, int paramInt2);
    
    public abstract void ab(MotionEvent paramMotionEvent);
    
    @l(iBK={1, 1, 16})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "", "(Ljava/lang/String;I)V", "NORMAL", "SINGLE_CLICK", "CONTINUOUS_CLICKING", "LONG_CLICK", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(290237);
      b localb1 = new b("NORMAL", 0);
      yQm = localb1;
      b localb2 = new b("SINGLE_CLICK", 1);
      yQn = localb2;
      b localb3 = new b("CONTINUOUS_CLICKING", 2);
      yQo = localb3;
      b localb4 = new b("LONG_CLICK", 3);
      yQp = localb4;
      yQq = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(290237);
    }
    
    private b() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class c
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(290136);
      this.yQr.a(j.b.yQp);
      if (this.yQr.timer.stopped())
      {
        Log.i(this.yQr.TAG, "long click start timer");
        this.yQr.timer.startTimer(this.yQr.yhn);
      }
      if (this.yQr.yQl.stopped())
      {
        Log.i(this.yQr.TAG, "long click start longClickTimer");
        this.yQr.yQl.startTimer(this.yQr.yQb);
      }
      AppMethodBeat.o(290136);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
  public static final class d
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(281670);
      if (this.yQr.yQg)
      {
        AppMethodBeat.o(281670);
        return false;
      }
      Log.i(this.yQr.TAG, "ContinuousClickManager longClickTimer callback: clickCnt = " + this.yQr.yQd + ", state = " + this.yQr.yQc.name() + ", lastClickCnt = " + this.yQr.yQe);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(281670);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(j.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
  public static final class e
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(272519);
      Log.i(this.yQr.TAG, "ContinuousClickManager Timer callback: clickCnt = " + this.yQr.yQd + ", state = " + this.yQr.yQc.name() + ", lastClickCnt = " + this.yQr.yQe);
      View localView;
      if (this.yQr.yQe != this.yQr.yQd)
      {
        int i = this.yQr.yQd - this.yQr.yQe;
        this.yQr.yQe = this.yQr.yQd;
        if (i < 0)
        {
          this.yQr.a(j.b.yQm);
          locala = this.yQr.yQh;
          if (locala != null)
          {
            localView = this.yQr.yQi;
            j.a.a.a(locala, this.yQr.yQd, 0, j.b.yQm, this.yQr.yru);
          }
          AppMethodBeat.o(272519);
          return false;
        }
        locala = this.yQr.yQh;
        if (locala != null)
        {
          localView = this.yQr.yQi;
          j.a.a.a(locala, this.yQr.yQd, i, this.yQr.yQc, this.yQr.yru);
        }
      }
      if (j.a(this.yQr))
      {
        AppMethodBeat.o(272519);
        return true;
      }
      this.yQr.a(j.b.yQm);
      j.a locala = this.yQr.yQh;
      if (locala != null)
      {
        localView = this.yQr.yQi;
        j.a.a.a(locala, this.yQr.yQd, 0, j.b.yQm, this.yQr.yru);
      }
      AppMethodBeat.o(272519);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(j paramj) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      StringBuilder localStringBuilder = null;
      AppMethodBeat.i(273888);
      if (paramMotionEvent != null)
      {
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        if (paramView != null) {
          break label47;
        }
        label23:
        if (paramView != null) {
          break label398;
        }
        label27:
        if (paramView != null) {
          break label417;
        }
      }
      label47:
      label229:
      while (paramView.intValue() != 1)
      {
        if (paramView != null) {
          break label534;
        }
        for (;;)
        {
          AppMethodBeat.o(273888);
          return true;
          paramView = null;
          break;
          if (paramView.intValue() != 0) {
            break label23;
          }
          this.yQr.yQg = false;
          paramView = this.yQr.yQc;
          switch (k.$EnumSwitchMapping$0[paramView.ordinal()])
          {
          }
          for (;;)
          {
            com.tencent.mm.ae.d.a(this.yQr.yQa, (Runnable)this.yQr.yQk);
            break;
            Object localObject;
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
            {
              paramView = com.tencent.c.a.a.a.a.a.Zlt;
              if (1 == ((Number)com.tencent.c.a.a.a.a.a.ilO().aSr()).intValue())
              {
                paramMotionEvent = this.yQr;
                localStringBuilder = new StringBuilder();
                paramView = z.bcZ();
                if (paramView != null)
                {
                  localObject = kotlin.n.d.UTF_8;
                  if (paramView == null)
                  {
                    paramView = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(273888);
                    throw paramView;
                  }
                  paramView = paramView.getBytes((Charset)localObject);
                  p.j(paramView, "(this as java.lang.String).getBytes(charset)");
                }
              }
            }
            for (paramMotionEvent.yru = (g.getMessageDigest(paramView) + "_123456");; paramMotionEvent.yru = (g.getMessageDigest(paramView) + '_' + UUID.randomUUID()))
            {
              this.yQr.a(j.b.yQn);
              break;
              paramView = null;
              break label229;
              paramMotionEvent = this.yQr;
              localObject = new StringBuilder();
              String str = z.bcZ();
              paramView = localStringBuilder;
              if (str != null)
              {
                paramView = kotlin.n.d.UTF_8;
                if (str == null)
                {
                  paramView = new t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(273888);
                  throw paramView;
                }
                paramView = str.getBytes(paramView);
                p.j(paramView, "(this as java.lang.String).getBytes(charset)");
              }
            }
            if (j.a(this.yQr)) {
              this.yQr.a(j.b.yQo);
            } else {
              this.yQr.a(j.b.yQn);
            }
          }
          if (paramView.intValue() != 2) {
            break label27;
          }
          this.yQr.yQg = false;
        }
      }
      for (;;)
      {
        label398:
        label417:
        Log.i(this.yQr.TAG, "on ACTION_UP or ACTION_CANCEL: ".concat(String.valueOf(paramMotionEvent)));
        this.yQr.yQg = true;
        this.yQr.yQf = System.currentTimeMillis();
        if (this.yQr.timer.stopped())
        {
          Log.i(this.yQr.TAG, "single click start timer");
          this.yQr.timer.startTimer(this.yQr.yhn);
        }
        this.yQr.dEs();
        paramView = this.yQr.yQh;
        if (paramView == null) {
          break;
        }
        paramView.ab(paramMotionEvent);
        break;
        label534:
        if (paramView.intValue() != 3) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.j
 * JD-Core Version:    0.7.0.1
 */