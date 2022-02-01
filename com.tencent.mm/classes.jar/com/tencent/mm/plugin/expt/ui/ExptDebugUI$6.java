package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.List;

final class ExptDebugUI$6
  implements View.OnClickListener
{
  ExptDebugUI$6(ExptDebugUI paramExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(122476);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new ArrayList();
    paramView.add(Integer.valueOf(ExptDebugUI.c(this.zNN)));
    com.tencent.mm.plugin.expt.model.a.dMQ();
    com.tencent.mm.plugin.expt.model.a.a(0, paramView, null, null);
    ExptDebugUI.d(this.zNN).setText(" del :" + ExptDebugUI.c(this.zNN));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/expt/ui/ExptDebugUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(122476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.6
 * JD-Core Version:    0.7.0.1
 */