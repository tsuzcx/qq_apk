package com.tencent.mm.plugin.finder.live.b;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper$setBoxCommentActionListener$1", "Landroid/view/GestureDetector$OnGestureListener;", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$f
  implements GestureDetector.OnGestureListener
{
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
    AppMethodBeat.i(370964);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper$setBoxCommentActionListener$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    a.a(this, "com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper$setBoxCommentActionListener$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(370964);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(370954);
    b localb = new b();
    localb.cH(paramMotionEvent);
    a.c("com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper$setBoxCommentActionListener$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    a.a(true, this, "com/tencent/mm/plugin/finder/live/comment/BoxCommentHelper$setBoxCommentActionListener$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(370954);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b.c.f
 * JD-Core Version:    0.7.0.1
 */