package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.HardTouchableLayout.b;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabLayoutUIC$onCreate$5", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$e
  implements HardTouchableLayout.b
{
  b$e(b paramb) {}
  
  private static final void e(b paramb)
  {
    AppMethodBeat.i(341256);
    s.u(paramb, "this$0");
    paramb = b.a(paramb);
    if (paramb != null) {
      paramb.eEr();
    }
    AppMethodBeat.o(341256);
  }
  
  public final void c(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(341272);
    s.u(paramView, "view");
    s.u(paramMotionEvent, "e");
    Log.i("NearbyLiveSquareTabLayoutUIC", "onDoubleClick ...");
    h.ahAA.bk(new b.e..ExternalSyntheticLambda0(this.EMs));
    AppMethodBeat.o(341272);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.b.e
 * JD-Core Version:    0.7.0.1
 */