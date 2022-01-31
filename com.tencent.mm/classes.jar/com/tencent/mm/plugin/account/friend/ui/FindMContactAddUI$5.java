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
    AppMethodBeat.i(108516);
    FindMContactAddUI.q(this.gzd);
    this.gzd.finish();
    AppMethodBeat.o(108516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI.5
 * JD-Core Version:    0.7.0.1
 */