package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoView$e
  implements View.OnClickListener
{
  MPVideoView$e(MPVideoView paramMPVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7487);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (!this.oAG.bnx()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView = this.oAG;
      paramView.q(bool, MPVideoView.y(paramView));
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$initControlBar$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(7487);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.e
 * JD-Core Version:    0.7.0.1
 */