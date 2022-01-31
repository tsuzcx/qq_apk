package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FindMContactInviteUI$3
  implements DialogInterface.OnClickListener
{
  FindMContactInviteUI$3(FindMContactInviteUI paramFindMContactInviteUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(108538);
    this.gzf.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    FindMContactInviteUI.n(this.gzf);
    this.gzf.finish();
    AppMethodBeat.o(108538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.FindMContactInviteUI.3
 * JD-Core Version:    0.7.0.1
 */