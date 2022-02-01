package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ExptDebugUI$3
  implements View.OnClickListener
{
  ExptDebugUI$3(ExptDebugUI paramExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(122472);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ExptDebugUI.b(this.zNN);
    a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(122472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.3
 * JD-Core Version:    0.7.0.1
 */