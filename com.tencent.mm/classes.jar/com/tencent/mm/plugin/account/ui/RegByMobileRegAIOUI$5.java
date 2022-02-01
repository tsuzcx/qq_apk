package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;

final class RegByMobileRegAIOUI$5
  implements View.OnClickListener
{
  RegByMobileRegAIOUI$5(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(169148);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (com.tencent.mm.pluginsdk.permission.b.a(this.jsc, "android.permission.WRITE_EXTERNAL_STORAGE", 34, "", "")) {
      com.tencent.mm.plugin.account.a.a.iUA.s(this.jsc);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(169148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.5
 * JD-Core Version:    0.7.0.1
 */