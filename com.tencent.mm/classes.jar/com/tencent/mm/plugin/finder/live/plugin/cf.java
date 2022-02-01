package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback.a;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "clearView", "Landroid/view/View;", "clickTime", "", "downTime", "clearScreeen", "", "clear", "", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "screenAction", "(Ljava/lang/Boolean;)V", "screenClickLogic", "setVisible", "visible", "", "plugin-finder_release"})
public final class cf
  extends d
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private long ksY;
  private long qLu;
  private View ywI;
  
  public cf(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(277556);
    this.kCL = paramb;
    this.TAG = "Finder.LiveScreenClearPlugin";
    this.ywI = ((View)paramViewGroup);
    this.qLu = SystemClock.elapsedRealtime();
    this.ksY = -1L;
    this.ywI.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(291910);
        if (paramAnonymousMotionEvent != null)
        {
          paramAnonymousView = Integer.valueOf(paramAnonymousMotionEvent.getAction());
          if (paramAnonymousView != null) {
            break label37;
          }
          label21:
          if (paramAnonymousView != null) {
            break label57;
          }
        }
        for (;;)
        {
          AppMethodBeat.o(291910);
          return true;
          paramAnonymousView = null;
          break;
          label37:
          if (paramAnonymousView.intValue() != 0) {
            break label21;
          }
          cf.a(this.ywJ, SystemClock.elapsedRealtime());
          continue;
          label57:
          if (paramAnonymousView.intValue() == 1)
          {
            if ((cf.b(this.ywJ) > 0L) && (SystemClock.elapsedRealtime() - cf.b(this.ywJ) <= ViewConfiguration.getTapTimeout())) {
              cf.a(this.ywJ);
            }
            cf.a(this.ywJ, -1L);
          }
        }
      }
    });
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(277556);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += ax.aB(paramViewGroup.getContext());
    AppMethodBeat.o(277556);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(277555);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    q(null);
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(277555);
    return true;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(277553);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(277553);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(277554);
    q(null);
    AppMethodBeat.o(277554);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(277552);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(277552);
    return false;
  }
  
  public final void q(Boolean paramBoolean)
  {
    AppMethodBeat.i(277549);
    Log.i(this.TAG, "screenClickLogic");
    if (SystemClock.elapsedRealtime() - this.qLu < ViewConfiguration.getDoubleTapTimeout())
    {
      AppMethodBeat.o(277549);
      return;
    }
    this.qLu = SystemClock.elapsedRealtime();
    Object localObject = FinderLiveViewCallback.xWi;
    if (FinderLiveViewCallback.dwL())
    {
      paramBoolean = this.TAG;
      localObject = new StringBuilder("[screenAction] inNewGuideStatus:");
      FinderLiveViewCallback.a locala = FinderLiveViewCallback.xWi;
      Log.i(paramBoolean, FinderLiveViewCallback.dwL() + " return");
      AppMethodBeat.o(277549);
      return;
    }
    localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    boolean bool;
    if (paramBoolean != null)
    {
      bool = paramBoolean.booleanValue();
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zfm = bool;
      Log.i(this.TAG, "screenAction business(LiveCommonSlice::class.java).screenClear:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm);
      paramBoolean = new Bundle();
      paramBoolean.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm);
      this.kCL.statusChange(b.c.kAC, paramBoolean);
      if (this.kCL.getLiveRole() == 0) {
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm) {
          break label319;
        }
      }
    }
    label319:
    for (paramBoolean = s.j.yFB;; paramBoolean = s.j.yFC)
    {
      m.yCt.a(paramBoolean);
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm) || (!isLandscape()) || (Build.VERSION.SDK_INT < 21)) {
        break label360;
      }
      paramBoolean = this.kiF.getContext();
      if (paramBoolean != null) {
        break label326;
      }
      paramBoolean = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(277549);
      throw paramBoolean;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfm)
      {
        bool = true;
        break;
      }
      bool = false;
      break;
    }
    label326:
    paramBoolean = ((Activity)paramBoolean).getWindow();
    p.j(paramBoolean, "(root.context as Activity).window");
    paramBoolean = paramBoolean.getDecorView();
    p.j(paramBoolean, "(root.context as Activity).window.decorView");
    paramBoolean.setSystemUiVisibility(3846);
    label360:
    AppMethodBeat.o(277549);
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(277551);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("visibility:");
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      super.tU(paramInt);
      AppMethodBeat.o(277551);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cf
 * JD-Core Version:    0.7.0.1
 */