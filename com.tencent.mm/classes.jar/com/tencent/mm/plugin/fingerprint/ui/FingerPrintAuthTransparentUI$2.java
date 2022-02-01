package com.tencent.mm.plugin.fingerprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.i;

final class FingerPrintAuthTransparentUI$2
  implements View.OnClickListener
{
  FingerPrintAuthTransparentUI$2(FingerPrintAuthTransparentUI paramFingerPrintAuthTransparentUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64483);
    if (FingerPrintAuthTransparentUI.h(this.rcY) != null) {
      FingerPrintAuthTransparentUI.h(this.rcY).cancel();
    }
    FingerPrintAuthTransparentUI.cuG();
    this.rcY.finish();
    AppMethodBeat.o(64483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.FingerPrintAuthTransparentUI.2
 * JD-Core Version:    0.7.0.1
 */