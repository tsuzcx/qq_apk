package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ExdeviceAddDataSourceUI$5
  extends ClickableSpan
{
  ExdeviceAddDataSourceUI$5(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void onClick(View paramView)
  {
    f.af(this.jAD.mController.uMN, "https://hw.weixin.qq.com/steprank/step/connect-help.html");
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.5
 * JD-Core Version:    0.7.0.1
 */