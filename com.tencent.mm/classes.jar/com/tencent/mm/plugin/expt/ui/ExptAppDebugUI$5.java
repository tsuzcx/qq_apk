package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class ExptAppDebugUI$5
  implements View.OnClickListener
{
  ExptAppDebugUI$5(ExptAppDebugUI paramExptAppDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(299582);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    com.tencent.mm.plugin.expt.model.a.dMQ().Me(1);
    Toast.makeText(this.zNK.getContext(), "start req expt", 0).show();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptAppDebugUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(299582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptAppDebugUI.5
 * JD-Core Version:    0.7.0.1
 */