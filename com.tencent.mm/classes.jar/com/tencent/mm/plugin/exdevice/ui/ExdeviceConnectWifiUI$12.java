package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceConnectWifiUI$12
  implements View.OnTouchListener
{
  ExdeviceConnectWifiUI$12(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(19888);
    ExdeviceConnectWifiUI.c(this.lLW).clearFocus();
    this.lLW.hideVKB();
    AppMethodBeat.o(19888);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.12
 * JD-Core Version:    0.7.0.1
 */