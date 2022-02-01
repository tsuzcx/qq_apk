package com.tencent.mm.live.ui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$c
  implements View.OnClickListener
{
  a$c(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216513);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (this.hcx.isShowing()) {
      this.hcx.cancel();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveMicDialog$wrapSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.a.c
 * JD-Core Version:    0.7.0.1
 */