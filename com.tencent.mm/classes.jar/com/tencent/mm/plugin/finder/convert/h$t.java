package com.tencent.mm.plugin.finder.convert;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HardTouchableLayout.c;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$onCreateViewHolder$2$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnInterceptTouchEventCallback;", "isIntercept", "", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
public final class h$t
  implements HardTouchableLayout.c
{
  public final boolean O(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(201763);
    p.h(paramMotionEvent, "event");
    AppMethodBeat.o(201763);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h.t
 * JD-Core Version:    0.7.0.1
 */