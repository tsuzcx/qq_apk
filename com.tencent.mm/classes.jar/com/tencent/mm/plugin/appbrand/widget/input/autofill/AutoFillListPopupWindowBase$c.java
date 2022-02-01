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
    AppMethodBeat.i(136657);
    if (this.mHl.apw.isShowing()) {
      this.mHl.show();
    }
    AppMethodBeat.o(136657);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(136658);
    this.mHl.dismiss();
    AppMethodBeat.o(136658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.c
 * JD-Core Version:    0.7.0.1
 */