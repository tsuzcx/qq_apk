package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RegSetInfoUI$29
  implements View.OnClickListener
{
  RegSetInfoUI$29(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128695);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    RegSetInfoUI.p(this.jqJ);
    a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.29
 * JD-Core Version:    0.7.0.1
 */