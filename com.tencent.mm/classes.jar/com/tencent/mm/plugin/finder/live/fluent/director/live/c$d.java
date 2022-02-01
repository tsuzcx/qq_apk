package com.tencent.mm.plugin.finder.live.fluent.director.live;

import android.animation.Animator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.plugin.finder.live.fluent.animate.a;
import com.tencent.mm.plugin.finder.live.fluent.f;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/fluent/director/live/SwitchOutLiveDirector$switchInLiveRoom$3", "Lcom/tencent/mm/plugin/finder/live/fluent/animate/DefaultAnimatorListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$d
  extends a
{
  c$d(c paramc, LiveVideoView paramLiveVideoView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(352253);
    paramAnimator = ((f)this.CDl.ejN()).CCB;
    if (paramAnimator != null) {
      paramAnimator.setPlayerView((TXCloudVideoView)this.CDm);
    }
    AppMethodBeat.o(352253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.live.c.d
 * JD-Core Version:    0.7.0.1
 */