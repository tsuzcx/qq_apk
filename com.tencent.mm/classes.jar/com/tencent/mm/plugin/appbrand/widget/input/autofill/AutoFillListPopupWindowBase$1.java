package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AutoFillListPopupWindowBase$1
  implements Runnable
{
  AutoFillListPopupWindowBase$1(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void run()
  {
    AppMethodBeat.i(136647);
    View localView = this.mHl.apl;
    if ((localView != null) && (localView.getWindowToken() != null)) {
      this.mHl.show();
    }
    AppMethodBeat.o(136647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.1
 * JD-Core Version:    0.7.0.1
 */