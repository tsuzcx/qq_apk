package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ExdeviceBindDeviceUI$9
  extends ClickableSpan
{
  ExdeviceBindDeviceUI$9(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void onClick(View paramView)
  {
    f.af(this.jBw.mController.uMN, "http://o2o.gtimg.com/mydevice/page/deviceHelp.html");
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.9
 * JD-Core Version:    0.7.0.1
 */