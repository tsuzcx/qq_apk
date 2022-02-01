package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFixClickIssueRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFixClickIssueRecyclerView
  extends RecyclerView
{
  public FinderLiveFixClickIssueRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(361575);
    AppMethodBeat.o(361575);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(361583);
    s.u(paramMotionEvent, "event");
    if (getScrollState() == 2) {}
    boolean bool;
    for (int i = 1;; i = 0)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      if ((paramMotionEvent.getActionMasked() != 0) || (i == 0)) {
        break;
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      if ((canScrollVertically(-1)) && (canScrollVertically(1))) {
        break;
      }
      JO();
      AppMethodBeat.o(361583);
      return false;
    }
    AppMethodBeat.o(361583);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveFixClickIssueRecyclerView
 * JD-Core Version:    0.7.0.1
 */