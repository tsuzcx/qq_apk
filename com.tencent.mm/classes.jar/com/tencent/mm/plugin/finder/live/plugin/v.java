package com.tencent.mm.plugin.finder.live.plugin;

import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.j.b;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "anchorMusicGuidePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "getAnchorMusicGuidePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;", "setAnchorMusicGuidePlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicGuidePlugin;)V", "enableMusic", "", "getEnableMusic", "()Z", "setEnableMusic", "(Z)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "setGestureDetector", "(Landroid/view/GestureDetector;)V", "musicPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;", "getMusicPlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;", "setMusicPlugin", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicPlugin;)V", "checkVisible", "", "enableVolumeGesture", "initGestureDetector", "onDoubleTap", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends b
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener
{
  private boolean CWm;
  private u CWp;
  private t CWq;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private GestureDetector nwZ;
  
  public v(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353816);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveAnchorMusicVolumePlugin";
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    this.CWm = com.tencent.mm.plugin.finder.live.utils.a.euF();
    AppMethodBeat.o(353816);
  }
  
  private static final boolean a(v paramv, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(353844);
    s.u(paramv, "this$0");
    paramv = paramv.nwZ;
    if (paramv == null)
    {
      AppMethodBeat.o(353844);
      return false;
    }
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramv, paramView.aYi(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "initGestureDetector$lambda-0", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramv, paramv.onTouchEvent((MotionEvent)paramView.sb(0)), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "initGestureDetector$lambda-0", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin;Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(353844);
    return bool;
  }
  
  private final boolean epr()
  {
    AppMethodBeat.i(353825);
    Object localObject = aj.CGT;
    localObject = aj.elM();
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((com.tencent.mm.live.core.core.trtc.a)localObject).mRI))
    {
      Log.i(this.TAG, "enableVolumeGesture isPlayingBgMusic:" + localObject + ", enableMusic:" + this.CWm + ", liveStatus:" + ((e)business(e.class)).EcT);
      if ((!this.CWm) || (!s.p(localObject, Boolean.TRUE)) || (!((e)business(e.class)).isLiveStarted())) {
        break;
      }
      AppMethodBeat.o(353825);
      return true;
    }
    AppMethodBeat.o(353825);
    return false;
  }
  
  private final void eps()
  {
    AppMethodBeat.i(353832);
    if (this.nwZ == null)
    {
      this.nwZ = new GestureDetector(this.mJe.getContext(), (GestureDetector.OnGestureListener)this);
      GestureDetector localGestureDetector = this.nwZ;
      if (localGestureDetector != null) {
        localGestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)this);
      }
      this.mJe.setOnTouchListener(new v..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(353832);
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(353855);
    if (epr())
    {
      eps();
      tO(0);
      AppMethodBeat.o(353855);
      return;
    }
    tO(8);
    AppMethodBeat.o(353855);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(353915);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(353915);
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
    AppMethodBeat.i(353887);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(353887);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(353903);
    if (this.CWq == null) {
      this.CWq = ((t)getPlugin(t.class));
    }
    paramMotionEvent = this.CWq;
    int i;
    if (paramMotionEvent != null)
    {
      Object localObject = paramMotionEvent.CyU;
      s.s(localObject, "isPagEnable");
      if (((Boolean)localObject).booleanValue())
      {
        localObject = paramMotionEvent.CWk;
        if ((localObject == null) || (((TextView)localObject).getVisibility() != 0)) {
          break label228;
        }
        i = 1;
        if (i != 0)
        {
          Log.i(paramMotionEvent.TAG, "hideGuideView");
          localObject = paramMotionEvent.CWj;
          if (localObject != null) {
            ((PAGView)localObject).stop();
          }
          localObject = paramMotionEvent.CWj;
          if (localObject != null) {
            ((PAGView)localObject).setVisibility(8);
          }
          localObject = paramMotionEvent.CWk;
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
          paramMotionEvent.tO(8);
        }
      }
    }
    boolean bool = ((e)business(e.class)).eyK();
    if ((epr()) && (!bool))
    {
      if (this.CWp == null) {
        this.CWp = ((u)getPlugin(u.class));
      }
      paramMotionEvent = this.CWp;
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.CwH;
        if (paramMotionEvent != null) {
          paramMotionEvent.ehI();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(353903);
      return true;
      label228:
      i = 0;
      break;
      if (bool) {
        Log.i(this.TAG, "onSingleTapConfirmed isMicLinking!");
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(353874);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorMusicVolumePlugin", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(353874);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.v
 * JD-Core Version:    0.7.0.1
 */