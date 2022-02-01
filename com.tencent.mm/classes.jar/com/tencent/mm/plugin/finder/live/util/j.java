package com.tencent.mm.plugin.finder.live.util;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager;", "", "()V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "clickCnt", "", "comboBatchSize", "comboBatchTimeoutMs", "comboId", "continuousClickTimeThreshHold", "", "lastClickCnt", "lastTouchUpTime", "longClickInstantCallbackInterval", "longClickRunnable", "com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1;", "longClickTimeThreshHold", "longClickTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "onTouchUpOrCancelState", "", "registerView", "Landroid/view/View;", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "timer", "touchListener", "Landroid/view/View$OnTouchListener;", "cancelLongClickState", "", "checkComboBatchSize", "checkIfContinuousClick", "view", "initialValue", "(Landroid/view/View;Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;Ljava/lang/Integer;)V", "unRegisterView", "updateState", "newState", "IContinuousClickCallback", "Mode", "State", "plugin-finder_release"})
public final class j
{
  final String TAG;
  public MTimerHandler timer;
  private final int ujE;
  public final int ujF;
  public volatile String upR;
  public a uwA;
  public volatile View uwB;
  @SuppressLint({"ClickableViewAccessibility"})
  public final View.OnTouchListener uwC;
  final c uwD;
  MTimerHandler uwE;
  private final long uws;
  final long uwt;
  final long uwu;
  public volatile b uwv;
  public volatile int uww;
  public volatile int uwx;
  public volatile long uwy;
  volatile boolean uwz;
  
  public j()
  {
    AppMethodBeat.i(247261);
    this.TAG = "Finder.ContinuousClickManager";
    this.uws = 3000L;
    o localo = o.ujN;
    if (o.dgd() > 0)
    {
      localo = o.ujN;
      i = o.dgd();
      this.ujE = i;
      localo = o.ujN;
      if (o.dge() <= 0) {
        break label188;
      }
      localo = o.ujN;
    }
    label188:
    for (int i = o.dge();; i = 1000)
    {
      this.ujF = i;
      this.uwt = 500L;
      this.uwu = 200L;
      this.uwv = b.uwF;
      this.upR = "";
      this.uwz = true;
      this.uwC = ((View.OnTouchListener)new f(this));
      this.uwD = new c(this);
      this.timer = new MTimerHandler("ContinuousClickManager::Timer", (MTimerHandler.CallBack)new e(this), true);
      this.uwE = new MTimerHandler("ContinuousClickManager::longClickTimer", (MTimerHandler.CallBack)new d(this), true);
      AppMethodBeat.o(247261);
      return;
      i = 5;
      break;
    }
  }
  
  private final void dih()
  {
    AppMethodBeat.i(247260);
    int i = this.uww - this.uwx;
    if (i >= this.ujE)
    {
      Log.i(this.TAG, "checkComboBatchSize: clickCnt = " + this.uww + ", lastClickCnt = " + this.uwx);
      this.uwx = this.uww;
      a locala = this.uwA;
      if (locala != null)
      {
        View localView = this.uwB;
        j.a.a.a(locala, this.uww, i, this.uwv, this.upR);
      }
      if (!this.timer.stopped())
      {
        this.timer.stopTimer();
        this.timer.startTimer(this.ujF);
      }
    }
    AppMethodBeat.o(247260);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(247259);
    Log.i(this.TAG, "updateState: newState = ".concat(String.valueOf(paramb)));
    this.uwv = paramb;
    switch (k.haE[paramb.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247259);
      return;
      this.uww = 0;
      this.uwx = 0;
      this.upR = "";
      AppMethodBeat.o(247259);
      return;
      this.uww += 1;
      a locala = this.uwA;
      View localView;
      if (locala != null)
      {
        localView = this.uwB;
        locala.a(this.uww, paramb, this.upR, this.uww - this.uwx);
      }
      dih();
      AppMethodBeat.o(247259);
      return;
      this.uww += 1;
      locala = this.uwA;
      if (locala != null)
      {
        localView = this.uwB;
        locala.a(this.uww, paramb, this.upR, this.uww - this.uwx);
      }
      dih();
    }
  }
  
  public final void dZ(View paramView)
  {
    AppMethodBeat.i(247257);
    if (this.uwB == null)
    {
      AppMethodBeat.o(247257);
      return;
    }
    Log.i(this.TAG, "unRegisterView view: ".concat(String.valueOf(paramView)));
    if (paramView != null) {
      paramView.setOnTouchListener(null);
    }
    this.uwB = null;
    this.timer.stopTimer();
    dig();
    int i = this.uww - this.uwx;
    if (i > 0)
    {
      paramView = this.uwA;
      if (paramView != null)
      {
        View localView = this.uwB;
        paramView.a(this.uww, i, this.uwv, this.upR, true);
      }
    }
    this.uwA = null;
    a(b.uwF);
    this.uwz = true;
    AppMethodBeat.o(247257);
  }
  
  final void dig()
  {
    AppMethodBeat.i(247258);
    com.tencent.mm.ac.d.C((Runnable)this.uwD);
    this.uwE.stopTimer();
    Log.i(this.TAG, "cancelLongClickState: longClickTimer.stopped = " + this.uwE.stopped());
    AppMethodBeat.o(247258);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$IContinuousClickCallback;", "", "batchCallback", "", "view", "Landroid/view/View;", "clickCnt", "", "diffCnt", "state", "Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "comboId", "", "needCheckBalance", "instantCallback", "onActionUpOrCancel", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void V(MotionEvent paramMotionEvent);
    
    public abstract boolean a(int paramInt1, int paramInt2, j.b paramb, String paramString, boolean paramBoolean);
    
    public abstract boolean a(int paramInt1, j.b paramb, String paramString, int paramInt2);
    
    @l(hxD={1, 1, 16})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/ContinuousClickManager$State;", "", "(Ljava/lang/String;I)V", "NORMAL", "SINGLE_CLICK", "CONTINUOUS_CLICKING", "LONG_CLICK", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(247248);
      b localb1 = new b("NORMAL", 0);
      uwF = localb1;
      b localb2 = new b("SINGLE_CLICK", 1);
      uwG = localb2;
      b localb3 = new b("CONTINUOUS_CLICKING", 2);
      uwH = localb3;
      b localb4 = new b("LONG_CLICK", 3);
      uwI = localb4;
      uwJ = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(247248);
    }
    
    private b() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-finder_release"})
  public static final class c
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(247252);
      this.uwK.a(j.b.uwI);
      if (this.uwK.timer.stopped())
      {
        Log.i(this.uwK.TAG, "long click start timer");
        this.uwK.timer.startTimer(this.uwK.ujF);
      }
      if (this.uwK.uwE.stopped())
      {
        Log.i(this.uwK.TAG, "long click start longClickTimer");
        this.uwK.uwE.startTimer(this.uwK.uwu);
      }
      AppMethodBeat.o(247252);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$longClickTimer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
  public static final class d
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(247254);
      if (this.uwK.uwz)
      {
        AppMethodBeat.o(247254);
        return false;
      }
      Log.i(this.uwK.TAG, "ContinuousClickManager longClickTimer callback: clickCnt = " + this.uwK.uww + ", state = " + this.uwK.uwv.name() + ", lastClickCnt = " + this.uwK.uwx);
      com.tencent.mm.ac.d.h((a)new a(this));
      AppMethodBeat.o(247254);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(j.d paramd)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/util/ContinuousClickManager$timer$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "plugin-finder_release"})
  public static final class e
    implements MTimerHandler.CallBack
  {
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(247255);
      Log.i(this.uwK.TAG, "ContinuousClickManager Timer callback: clickCnt = " + this.uwK.uww + ", state = " + this.uwK.uwv.name() + ", lastClickCnt = " + this.uwK.uwx);
      View localView;
      if (this.uwK.uwx != this.uwK.uww)
      {
        int i = this.uwK.uww - this.uwK.uwx;
        this.uwK.uwx = this.uwK.uww;
        if (i < 0)
        {
          this.uwK.a(j.b.uwF);
          locala = this.uwK.uwA;
          if (locala != null)
          {
            localView = this.uwK.uwB;
            j.a.a.a(locala, this.uwK.uww, 0, j.b.uwF, this.uwK.upR);
          }
          AppMethodBeat.o(247255);
          return false;
        }
        locala = this.uwK.uwA;
        if (locala != null)
        {
          localView = this.uwK.uwB;
          j.a.a.a(locala, this.uwK.uww, i, this.uwK.uwv, this.uwK.upR);
        }
      }
      if (j.a(this.uwK))
      {
        AppMethodBeat.o(247255);
        return true;
      }
      this.uwK.a(j.b.uwF);
      j.a locala = this.uwK.uwA;
      if (locala != null)
      {
        localView = this.uwK.uwB;
        j.a.a.a(locala, this.uwK.uww, 0, j.b.uwF, this.uwK.upR);
      }
      AppMethodBeat.o(247255);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(j paramj) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      StringBuilder localStringBuilder = null;
      AppMethodBeat.i(247256);
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
          AppMethodBeat.o(247256);
          return true;
          paramView = null;
          break;
          if (paramView.intValue() != 0) {
            break label23;
          }
          this.uwK.uwz = false;
          paramView = this.uwK.uwv;
          switch (k.$EnumSwitchMapping$0[paramView.ordinal()])
          {
          }
          for (;;)
          {
            com.tencent.mm.ac.d.a(this.uwK.uwt, (Runnable)this.uwK.uwD);
            break;
            Object localObject;
            if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
            {
              paramView = c.vCb;
              if (1 == ((Number)c.dvW().value()).intValue())
              {
                paramMotionEvent = this.uwK;
                localStringBuilder = new StringBuilder();
                paramView = z.aTY();
                if (paramView != null)
                {
                  localObject = kotlin.n.d.UTF_8;
                  if (paramView == null)
                  {
                    paramView = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(247256);
                    throw paramView;
                  }
                  paramView = paramView.getBytes((Charset)localObject);
                  p.g(paramView, "(this as java.lang.String).getBytes(charset)");
                }
              }
            }
            for (paramMotionEvent.upR = (g.getMessageDigest(paramView) + "_123456");; paramMotionEvent.upR = (g.getMessageDigest(paramView) + '_' + UUID.randomUUID()))
            {
              this.uwK.a(j.b.uwG);
              break;
              paramView = null;
              break label229;
              paramMotionEvent = this.uwK;
              localObject = new StringBuilder();
              String str = z.aTY();
              paramView = localStringBuilder;
              if (str != null)
              {
                paramView = kotlin.n.d.UTF_8;
                if (str == null)
                {
                  paramView = new t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(247256);
                  throw paramView;
                }
                paramView = str.getBytes(paramView);
                p.g(paramView, "(this as java.lang.String).getBytes(charset)");
              }
            }
            if (j.a(this.uwK)) {
              this.uwK.a(j.b.uwH);
            } else {
              this.uwK.a(j.b.uwG);
            }
          }
          if (paramView.intValue() != 2) {
            break label27;
          }
          this.uwK.uwz = false;
        }
      }
      for (;;)
      {
        label398:
        label417:
        Log.i(this.uwK.TAG, "on ACTION_UP or ACTION_CANCEL: ".concat(String.valueOf(paramMotionEvent)));
        this.uwK.uwz = true;
        this.uwK.uwy = System.currentTimeMillis();
        if (this.uwK.timer.stopped())
        {
          Log.i(this.uwK.TAG, "single click start timer");
          this.uwK.timer.startTimer(this.uwK.ujF);
        }
        this.uwK.dig();
        paramView = this.uwK.uwA;
        if (paramView == null) {
          break;
        }
        paramView.V(paramMotionEvent);
        break;
        label534:
        if (paramView.intValue() != 3) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.j
 * JD-Core Version:    0.7.0.1
 */