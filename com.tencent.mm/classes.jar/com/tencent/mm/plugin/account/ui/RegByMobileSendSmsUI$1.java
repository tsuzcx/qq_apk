package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class RegByMobileSendSmsUI$1
  implements View.OnClickListener
{
  RegByMobileSendSmsUI$1(RegByMobileSendSmsUI paramRegByMobileSendSmsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128562);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    RegByMobileSendSmsUI.a(this.jpq);
    a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.1
 * JD-Core Version:    0.7.0.1
 */