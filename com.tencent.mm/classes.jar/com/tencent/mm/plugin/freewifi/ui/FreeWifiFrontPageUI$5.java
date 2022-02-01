package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiFrontPageUI$5
  implements View.OnClickListener
{
  FreeWifiFrontPageUI$5(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25022);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    FreeWifiFrontPageUI.b(this.tpQ);
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.5
 * JD-Core Version:    0.7.0.1
 */