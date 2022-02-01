package com.tencent.mm.plugin.brandservice.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class MPVideoView$d
  implements View.OnClickListener
{
  MPVideoView$d(MPVideoView paramMPVideoView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7486);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.oAG.start();
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/widget/MPVideoView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(7486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView.d
 * JD-Core Version:    0.7.0.1
 */