package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
public final class u$c
  implements View.OnClickListener
{
  public u$c(d.g.a.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(208794);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshJumpLink$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.qPZ.invoke(Integer.valueOf(24));
    a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardSubscribe$refreshJumpLink$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(208794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.u.c
 * JD-Core Version:    0.7.0.1
 */