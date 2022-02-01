package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class ExdeviceConnectWifiUI$17
  implements View.OnClickListener
{
  ExdeviceConnectWifiUI$17(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179599);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "onClick connectBtn.");
    ExdeviceConnectWifiUI.k(this.rHj);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.17
 * JD-Core Version:    0.7.0.1
 */