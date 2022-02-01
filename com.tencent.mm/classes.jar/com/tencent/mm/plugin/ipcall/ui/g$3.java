package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class g$3
  implements View.OnClickListener
{
  g$3(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25771);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView == g.b(this.DWk)) {
      g.a(this.DWk, 1);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(25771);
      return;
      if (paramView == g.c(this.DWk)) {
        g.a(this.DWk, 2);
      } else if (paramView == g.d(this.DWk)) {
        g.a(this.DWk, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.3
 * JD-Core Version:    0.7.0.1
 */