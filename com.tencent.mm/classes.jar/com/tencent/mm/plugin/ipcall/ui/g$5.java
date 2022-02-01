package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class g$5
  implements View.OnClickListener
{
  g$5(g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25773);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    g.g(this.JNt);
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallFeedbackDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.5
 * JD-Core Version:    0.7.0.1
 */