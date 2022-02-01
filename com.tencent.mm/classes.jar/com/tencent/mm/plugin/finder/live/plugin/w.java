package com.tencent.mm.plugin.finder.live.plugin;

import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.a.b;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorMusicGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "getAnchorMusicGuidePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "setAnchorMusicGuidePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;)V", "enableMusic", "", "getEnableMusic", "()Z", "setEnableMusic", "(Z)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "setGestureDetector", "(Landroid/view/GestureDetector;)V", "musicPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;", "getMusicPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;", "setMusicPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;)V", "checkVisible", "", "enableVolumeGesture", "initGestureDetector", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "plugin-finder_release"})
public final class w
  extends d
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  GestureDetector mBn;
  private boolean ynt;
  private u ynw;
  private t ynx;
  
  public w(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(282091);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveAnchorMusicVolumePlugin";
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    this.ynt = com.tencent.mm.plugin.finder.live.utils.a.dEG();
    AppMethodBeat.o(282091);
  }
  
  private final boolean dAI()
  {
    AppMethodBeat.i(282080);
    Object localObject = ah.yhC;
    localObject = ah.dzB();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((com.tencent.mm.live.core.core.trtc.a)localObject).knH);; localObject = null)
    {
      Log.i(this.TAG, "enableVolumeGesture isPlayingBgMusic:" + localObject + ", enableMusic:" + this.ynt + ", liveStatus:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfv);
      if ((!this.ynt) || (!p.h(localObject, Boolean.TRUE)) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted())) {
        break;
      }
      AppMethodBeat.o(282080);
      return true;
    }
    AppMethodBeat.o(282080);
    return false;
  }
  
  private final void dAJ()
  {
    AppMethodBeat.i(282081);
    if (this.mBn == null)
    {
      this.mBn = new GestureDetector(this.kiF.getContext(), (GestureDetector.OnGestureListener)this);
      GestureDetector localGestureDetector = this.mBn;
      if (localGestureDetector != null) {
        localGestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)this);
      }
      this.kiF.setOnTouchListener((View.OnTouchListener)new a(this));
    }
    AppMethodBeat.o(282081);
  }
  
  public final void dAH()
  {
    AppMethodBeat.i(282082);
    if (dAI())
    {
      dAJ();
      tU(0);
      AppMethodBeat.o(282082);
      return;
    }
    tU(8);
    AppMethodBeat.o(282082);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282089);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(282089);
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
    AppMethodBeat.i(282086);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(282086);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282087);
    if (this.ynx == null) {
      this.ynx = ((t)getPlugin(t.class));
    }
    paramMotionEvent = this.ynx;
    if ((paramMotionEvent != null) && (paramMotionEvent.yaB))
    {
      Object localObject = paramMotionEvent.ynr;
      if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
      {
        Log.i(paramMotionEvent.TAG, "hideGuideView");
        localObject = paramMotionEvent.ynq;
        if (localObject != null) {
          ((PAGView)localObject).stop();
        }
        localObject = paramMotionEvent.ynq;
        if (localObject != null) {
          ((PAGView)localObject).setVisibility(8);
        }
        localObject = paramMotionEvent.ynr;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        paramMotionEvent.tU(8);
      }
    }
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGY();
    if ((dAI()) && (!bool))
    {
      if (this.ynw == null) {
        this.ynw = ((u)getPlugin(u.class));
      }
      paramMotionEvent = this.ynw;
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.xYn;
        if (paramMotionEvent != null) {
          paramMotionEvent.dxb();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(282087);
      return true;
      if (bool) {
        Log.i(this.TAG, "onSingleTapConfirmed isMicLinking!");
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(282085);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(282085);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class a
    implements View.OnTouchListener
  {
    a(w paramw) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(285146);
      paramView = this.yny.mBn;
      if (paramView != null)
      {
        paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aFh(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin$initGestureDetector$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin$initGestureDetector$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(285146);
        return bool;
      }
      AppMethodBeat.o(285146);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.w
 * JD-Core Version:    0.7.0.1
 */