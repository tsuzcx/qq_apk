package com.tencent.mm.live.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class LiveReplayVideoView$2
  implements View.OnClickListener
{
  LiveReplayVideoView$2(LiveReplayVideoView paramLiveReplayVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(208566);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/live/view/LiveReplayVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    LiveReplayVideoView.f(this.hWU);
    a.a(this, "com/tencent/mm/live/view/LiveReplayVideoView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(208566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveReplayVideoView.2
 * JD-Core Version:    0.7.0.1
 */