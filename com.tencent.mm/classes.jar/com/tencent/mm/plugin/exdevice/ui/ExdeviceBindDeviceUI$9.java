package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.f;

final class ExdeviceBindDeviceUI$9
  extends ClickableSpan
{
  ExdeviceBindDeviceUI$9(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(19833);
    f.an(this.lKV.getContext(), "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
    AppMethodBeat.o(19833);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(19834);
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(19834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.9
 * JD-Core Version:    0.7.0.1
 */