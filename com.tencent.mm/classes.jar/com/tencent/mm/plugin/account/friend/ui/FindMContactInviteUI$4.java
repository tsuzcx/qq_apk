package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FindMContactInviteUI$4
  implements DialogInterface.OnClickListener
{
  FindMContactInviteUI$4(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(131200);
    FindMContactInviteUI.n(this.mXY);
    this.mXY.finish();
    AppMethodBeat.o(131200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.4
 * JD-Core Version:    0.7.0.1
 */