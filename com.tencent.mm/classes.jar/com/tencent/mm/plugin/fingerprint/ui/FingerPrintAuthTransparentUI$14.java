package com.tencent.mm.plugin.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.i;

final class FingerPrintAuthTransparentUI$14
  implements View.OnClickListener
{
  FingerPrintAuthTransparentUI$14(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142018);
    if (FingerPrintAuthTransparentUI.e(this.mGQ) != null) {
      FingerPrintAuthTransparentUI.e(this.mGQ).cancel();
    }
    FingerPrintAuthTransparentUI.bzF();
    this.mGQ.finish();
    AppMethodBeat.o(142018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.14
 * JD-Core Version:    0.7.0.1
 */