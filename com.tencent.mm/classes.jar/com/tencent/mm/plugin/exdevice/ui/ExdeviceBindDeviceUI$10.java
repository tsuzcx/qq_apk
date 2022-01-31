package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class ExdeviceBindDeviceUI$10
  extends ClickableSpan
{
  ExdeviceBindDeviceUI$10(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void onClick(View paramView)
  {
    this.jBw.finish();
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.10
 * JD-Core Version:    0.7.0.1
 */