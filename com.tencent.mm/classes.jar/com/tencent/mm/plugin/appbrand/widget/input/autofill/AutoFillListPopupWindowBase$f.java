package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AutoFillListPopupWindowBase$f
  implements Runnable
{
  private AutoFillListPopupWindowBase$f(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void run()
  {
    AppMethodBeat.i(123921);
    if ((AutoFillListPopupWindowBase.a(this.jpu) != null) && (AutoFillListPopupWindowBase.a(this.jpu).getCount() > AutoFillListPopupWindowBase.a(this.jpu).getChildCount()) && (AutoFillListPopupWindowBase.a(this.jpu).getChildCount() <= this.jpu.ahg))
    {
      AutoFillListPopupWindowBase.b(this.jpu).setInputMethodMode(2);
      this.jpu.show();
    }
    AppMethodBeat.o(123921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.f
 * JD-Core Version:    0.7.0.1
 */