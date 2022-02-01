package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ExdeviceConnectWifiUI$16
  implements View.OnTouchListener
{
  ExdeviceConnectWifiUI$16(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179598);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    ExdeviceConnectWifiUI.c(this.qqc).clearFocus();
    this.qqc.hideVKB();
    a.a(false, this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceConnectWifiUI$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(179598);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.16
 * JD-Core Version:    0.7.0.1
 */