package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MobileFriendUI$8
  implements DialogInterface.OnClickListener
{
  MobileFriendUI$8(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13726);
    this.gwb.finish();
    AppMethodBeat.o(13726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.8
 * JD-Core Version:    0.7.0.1
 */