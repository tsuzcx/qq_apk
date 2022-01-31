package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class CleanChattingUI$8
  implements Runnable
{
  CleanChattingUI$8(CleanChattingUI paramCleanChattingUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(18787);
    CleanChattingUI.g(this.kIi).dismiss();
    h.b(this.kIi, this.kIi.getString(2131298375, new Object[] { bo.hk(this.kIc) }), "", true);
    CleanChattingUI.e(this.kIi).setText(this.kIi.getString(2131296534, new Object[] { " " }));
    AppMethodBeat.o(18787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.8
 * JD-Core Version:    0.7.0.1
 */