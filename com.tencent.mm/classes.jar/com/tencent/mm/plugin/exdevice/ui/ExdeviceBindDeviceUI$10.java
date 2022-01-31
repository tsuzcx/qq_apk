package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceBindDeviceUI$10
  extends ClickableSpan
{
  ExdeviceBindDeviceUI$10(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(19835);
    this.lKV.finish();
    AppMethodBeat.o(19835);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(19836);
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(19836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.10
 * JD-Core Version:    0.7.0.1
 */