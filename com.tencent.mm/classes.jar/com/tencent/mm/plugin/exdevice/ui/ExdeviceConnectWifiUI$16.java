package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceConnectWifiUI$16
  implements View.OnTouchListener
{
  ExdeviceConnectWifiUI$16(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179598);
    ExdeviceConnectWifiUI.c(this.rHj).clearFocus();
    this.rHj.hideVKB();
    AppMethodBeat.o(179598);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.16
 * JD-Core Version:    0.7.0.1
 */