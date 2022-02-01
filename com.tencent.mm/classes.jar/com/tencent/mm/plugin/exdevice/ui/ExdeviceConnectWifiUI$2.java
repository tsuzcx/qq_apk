package com.tencent.mm.plugin.exdevice.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ExdeviceConnectWifiUI$2
  implements View.OnKeyListener
{
  ExdeviceConnectWifiUI$2(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(179588);
    b localb = new b();
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.bm(paramKeyEvent);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      ExdeviceConnectWifiUI.k(this.rHj);
      a.a(true, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(179588);
      return true;
    }
    a.a(false, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(179588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.2
 * JD-Core Version:    0.7.0.1
 */