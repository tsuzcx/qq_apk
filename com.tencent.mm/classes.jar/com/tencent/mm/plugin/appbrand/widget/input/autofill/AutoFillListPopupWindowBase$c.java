package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AutoFillListPopupWindowBase$c
  extends DataSetObserver
{
  private AutoFillListPopupWindowBase$c(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(123916);
    if (this.jpu.aht.isShowing()) {
      this.jpu.show();
    }
    AppMethodBeat.o(123916);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(123917);
    this.jpu.dismiss();
    AppMethodBeat.o(123917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.c
 * JD-Core Version:    0.7.0.1
 */