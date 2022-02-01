package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class RegByMobileRegAIOUI$18
  implements View.OnClickListener
{
  RegByMobileRegAIOUI$18(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128530);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = com.tencent.mm.ax.b.bs(RegByMobileRegAIOUI.c(this.jpj), this.jpj.getString(2131757950));
    com.tencent.mm.plugin.account.a.b.a.b(this.jpj, this.jpj.getString(2131764600, new Object[] { ac.fks(), paramView }), 0, false);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.18
 * JD-Core Version:    0.7.0.1
 */