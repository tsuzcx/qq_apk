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
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "clearView", "Landroid/view/View;", "clickTime", "", "downTime", "clearScreeen", "", "clear", "", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "screenAction", "(Ljava/lang/Boolean;)V", "screenClickLogic", "setVisible", "visible", "", "plugin-finder_release"})
public final class ba
  extends d
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private final String TAG;
  private long hET;
  private final com.tencent.mm.live.c.b hOp;
  private long nJh;
  private View utw;
  
  public ba(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246965);
    this.hOp = paramb;
    this.TAG = "Finder.LiveScreenClearPlugin";
    this.utw = ((View)paramViewGroup);
    this.nJh = SystemClock.elapsedRealtime();
    this.hET = -1L;
    this.utw.setOnTouchListener((View.OnTouchListener)new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(246957);
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
          AppMethodBeat.o(246957);
          return true;
          paramAnonymousView = null;
          break;
          label37:
          if (paramAnonymousView.intValue() != 0) {
            break label21;
          }
          ba.a(this.utx, SystemClock.elapsedRealtime());
          continue;
          label57:
          if (paramAnonymousView.intValue() == 1)
          {
            if ((ba.b(this.utx) > 0L) && (SystemClock.elapsedRealtime() - ba.b(this.utx) <= ViewConfiguration.getTapTimeout())) {
              ba.a(this.utx);
            }
            ba.a(this.utx, -1L);
          }
        }
      }
    });
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(246965);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += au.aD(paramViewGroup.getContext());
    AppMethodBeat.o(246965);
  }
  
  public final void k(Boolean paramBoolean)
  {
    AppMethodBeat.i(246958);
    Log.i(this.TAG, "screenClickLogic");
    if (SystemClock.elapsedRealtime() - this.nJh < ViewConfiguration.getDoubleTapTimeout())
    {
      AppMethodBeat.o(246958);
      return;
    }
    this.nJh = SystemClock.elapsedRealtime();
    Object localObject = FinderLiveViewCallback.ufM;
    if (FinderLiveViewCallback.deT())
    {
      paramBoolean = this.TAG;
      localObject = new StringBuilder("[screenAction] inNewGuideStatus:");
      FinderLiveViewCallback.a locala = FinderLiveViewCallback.ufM;
      Log.i(paramBoolean, FinderLiveViewCallback.deT() + " return");
      AppMethodBeat.o(246958);
      return;
    }
    localObject = getLiveData();
    boolean bool;
    if (paramBoolean != null)
    {
      bool = paramBoolean.booleanValue();
      ((g)localObject).uDR = bool;
      Log.i(this.TAG, "screenAction liveData.screenClear:" + getLiveData().uDR);
      paramBoolean = new Bundle();
      paramBoolean.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", getLiveData().uDR);
      this.hOp.statusChange(b.c.hNl, paramBoolean);
      if (this.hOp.getLiveRole() == 0) {
        if (!getLiveData().uDR) {
          break label289;
        }
      }
    }
    label289:
    for (paramBoolean = s.h.vnF;; paramBoolean = s.h.vnG)
    {
      localObject = m.vli;
      m.a(paramBoolean);
      if ((!getLiveData().uDR) || (!isLandscape()) || (Build.VERSION.SDK_INT < 21)) {
        break label330;
      }
      paramBoolean = this.hwr.getContext();
      if (paramBoolean != null) {
        break label296;
      }
      paramBoolean = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(246958);
      throw paramBoolean;
      if (!getLiveData().uDR)
      {
        bool = true;
        break;
      }
      bool = false;
      break;
    }
    label296:
    paramBoolean = ((Activity)paramBoolean).getWindow();
    p.g(paramBoolean, "(root.context as Activity).window");
    paramBoolean = paramBoolean.getDecorView();
    p.g(paramBoolean, "(root.context as Activity).window.decorView");
    paramBoolean.setSystemUiVisibility(3846);
    label330:
    AppMethodBeat.o(246958);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(246964);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    k(null);
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(246964);
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
    AppMethodBeat.i(246962);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(246962);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(246963);
    k(null);
    AppMethodBeat.o(246963);
    return true;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(246961);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveScreenClearPlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(246961);
    return false;
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(246960);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("visibility:");
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, bool);
      super.rg(paramInt);
      AppMethodBeat.o(246960);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ba
 * JD-Core Version:    0.7.0.1
 */