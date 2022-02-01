package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiSuccUI$1
  implements View.OnClickListener
{
  FreeWifiSuccUI$1(FreeWifiSuccUI paramFreeWifiSuccUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25145);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.tqZ.finish();
    FreeWifiSuccUI.a(this.tqZ);
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.1
 * JD-Core Version:    0.7.0.1
 */