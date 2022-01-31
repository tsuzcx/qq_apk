package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class CollectMainUI$8
  implements DialogInterface.OnClickListener
{
  CollectMainUI$8(CollectMainUI paramCollectMainUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(41259);
    CollectMainUI.e(this.kSz);
    h.qsU.e(13944, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(41259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.8
 * JD-Core Version:    0.7.0.1
 */