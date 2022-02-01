package com.tencent.mm.live.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class LiveReplayVideoView$1
  implements View.OnClickListener
{
  LiveReplayVideoView$1(LiveReplayVideoView paramLiveReplayVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(212970);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/live/view/LiveReplayVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    localObject = this.hbu.getOnCloseClickListener();
    if (localObject != null)
    {
      p.g(paramView, "it");
      ((d.g.a.b)localObject).invoke(paramView);
    }
    a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(212970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveReplayVideoView.1
 * JD-Core Version:    0.7.0.1
 */