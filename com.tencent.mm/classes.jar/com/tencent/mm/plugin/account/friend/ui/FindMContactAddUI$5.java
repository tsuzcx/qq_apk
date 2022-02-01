package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FindMContactAddUI$5
  implements DialogInterface.OnClickListener
{
  FindMContactAddUI$5(FindMContactAddUI paramFindMContactAddUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(131177);
    FindMContactAddUI.q(this.iMs);
    this.iMs.finish();
    AppMethodBeat.o(131177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.5
 * JD-Core Version:    0.7.0.1
 */