package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoView$h
  implements View.OnClickListener
{
  MPVideoView$h(MPVideoView paramMPVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7490);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = MPVideoView.h(this.sVn);
    if (paramView == null) {
      p.iCn();
    }
    if (paramView.isPlaying()) {
      this.sVn.pause();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7490);
      return;
      this.sVn.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.h
 * JD-Core Version:    0.7.0.1
 */