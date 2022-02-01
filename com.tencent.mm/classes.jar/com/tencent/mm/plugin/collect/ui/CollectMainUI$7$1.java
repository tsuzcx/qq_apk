package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class CollectMainUI$7$1
  implements DialogInterface.OnClickListener
{
  CollectMainUI$7$1(CollectMainUI.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(186994);
    ad.i("MicroMsg.CollectMainUI", "RealnameVerifyUtil cancel");
    AppMethodBeat.o(186994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.7.1
 * JD-Core Version:    0.7.0.1
 */