package com.tencent.mm.plugin.exdevice.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.f;

final class ExdeviceAddDataSourceUI$5
  extends ClickableSpan
{
  ExdeviceAddDataSourceUI$5(ExdeviceAddDataSourceUI paramExdeviceAddDataSourceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(19778);
    f.an(this.lKc.getContext(), "https://hw.weixin.qq.com/steprank/step/connect-help.html");
    AppMethodBeat.o(19778);
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(19779);
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
    AppMethodBeat.o(19779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceAddDataSourceUI.5
 * JD-Core Version:    0.7.0.1
 */