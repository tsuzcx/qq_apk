package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;

final class RegByMobileRegAIOUI$6
  implements View.OnClickListener
{
  RegByMobileRegAIOUI$6(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128516);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (com.tencent.mm.pluginsdk.permission.b.a(this.qfw, "android.permission.WRITE_EXTERNAL_STORAGE", 34, "")) {
      com.tencent.mm.plugin.account.sdk.a.pFo.t(this.qfw);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.6
 * JD-Core Version:    0.7.0.1
 */