package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

final class ExdeviceConnectWifiUI$12
  implements View.OnTouchListener
{
  ExdeviceConnectWifiUI$12(ExdeviceConnectWifiUI paramExdeviceConnectWifiUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ExdeviceConnectWifiUI.c(this.jCy).clearFocus();
    this.jCy.XM();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectWifiUI.12
 * JD-Core Version:    0.7.0.1
 */