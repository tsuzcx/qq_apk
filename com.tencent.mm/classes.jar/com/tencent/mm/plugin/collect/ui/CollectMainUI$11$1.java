package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CollectMainUI$11$1
  implements DialogInterface.OnClickListener
{
  CollectMainUI$11$1(CollectMainUI.11 param11) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(142001);
    ab.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
    AppMethodBeat.o(142001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.11.1
 * JD-Core Version:    0.7.0.1
 */