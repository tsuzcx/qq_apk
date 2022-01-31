package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class GoogleFriendUI$5
  implements DialogInterface.OnCancelListener
{
  GoogleFriendUI$5(GoogleFriendUI paramGoogleFriendUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13654);
    GoogleFriendUI.c(this.gvr);
    g.Rc().a(GoogleFriendUI.d(this.gvr));
    AppMethodBeat.o(13654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.GoogleFriendUI.5
 * JD-Core Version:    0.7.0.1
 */