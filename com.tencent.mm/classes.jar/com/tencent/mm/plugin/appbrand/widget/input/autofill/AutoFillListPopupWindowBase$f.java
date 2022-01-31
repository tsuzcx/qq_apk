package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.PopupWindow;

final class AutoFillListPopupWindowBase$f
  implements Runnable
{
  private AutoFillListPopupWindowBase$f(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void run()
  {
    if ((AutoFillListPopupWindowBase.a(this.hxk) != null) && (AutoFillListPopupWindowBase.a(this.hxk).getCount() > AutoFillListPopupWindowBase.a(this.hxk).getChildCount()) && (AutoFillListPopupWindowBase.a(this.hxk).getChildCount() <= this.hxk.aeR))
    {
      AutoFillListPopupWindowBase.b(this.hxk).setInputMethodMode(2);
      this.hxk.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.f
 * JD-Core Version:    0.7.0.1
 */