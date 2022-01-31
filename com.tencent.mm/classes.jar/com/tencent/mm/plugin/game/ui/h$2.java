package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$2
  implements DialogInterface.OnClickListener
{
  h$2(h paramh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(111800);
    paramDialogInterface.dismiss();
    ab.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
    AppMethodBeat.o(111800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.h.2
 * JD-Core Version:    0.7.0.1
 */