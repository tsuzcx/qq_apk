package com.tencent.mm.plugin.finder.live.b;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.plugin.cy;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper$setBoxCommentActionListener$2$1", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onSingleTapConfirmed", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$g
  implements GestureDetector.OnDoubleTapListener
{
  c$g(com.tencent.mm.plugin.finder.live.viewmodel.data.a.b paramb, j paramj, View paramView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(370972);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper$setBoxCommentActionListener$2$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    paramMotionEvent = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveGroupCommentHelper", s.X("boxCommentLikeTrack onDoubleTap selfLike:", Boolean.valueOf(this.ZuR.akga)));
    if (this.ZuR.akga)
    {
      paramMotionEvent = this.wHm.getRecyclerView().getTag();
      if (paramMotionEvent == null)
      {
        paramMotionEvent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.plugin.FinderLiveBoxCommentPlugin");
        AppMethodBeat.o(370972);
        throw paramMotionEvent;
      }
      if (((cy)paramMotionEvent).jdv().b(this.ZuR)) {
        k.Doi.aa(19, this.ZuR.kKZ(), this.ZuR.getContent());
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper$setBoxCommentActionListener$2$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(370972);
      return true;
      paramMotionEvent = this.wHm.getRecyclerView().getTag();
      if (paramMotionEvent == null)
      {
        paramMotionEvent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.plugin.FinderLiveBoxCommentPlugin");
        AppMethodBeat.o(370972);
        throw paramMotionEvent;
      }
      if (((cy)paramMotionEvent).jdv().a(this.ZuR)) {
        k.Doi.aa(16, this.ZuR.kKZ(), this.ZuR.getContent());
      }
    }
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(370958);
    paramMotionEvent = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.hQ("FinderLiveGroupCommentHelper", s.X("boxCommentLikeTrack onSingleTapConfirmed selfLike:", Boolean.valueOf(this.ZuR.akga)));
    paramMotionEvent = this.wHm.getRecyclerView().getTag();
    if (paramMotionEvent == null)
    {
      paramMotionEvent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.plugin.FinderLiveBoxCommentPlugin");
      AppMethodBeat.o(370958);
      throw paramMotionEvent;
    }
    ((cy)paramMotionEvent).jdv().a(this.CGw, this.ZuR, this.$view);
    AppMethodBeat.o(370958);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b.c.g
 * JD-Core Version:    0.7.0.1
 */