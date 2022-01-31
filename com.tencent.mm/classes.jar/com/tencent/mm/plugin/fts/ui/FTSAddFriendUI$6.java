package com.tencent.mm.plugin.fts.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;

final class FTSAddFriendUI$6
  implements DialogInterface.OnCancelListener
{
  FTSAddFriendUI$6(FTSAddFriendUI paramFTSAddFriendUI, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(61730);
    g.Rc().a(this.mWB);
    g.Rc().b(106, FTSAddFriendUI.i(this.mWA));
    FTSAddFriendUI.j(this.mWA);
    AppMethodBeat.o(61730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.6
 * JD-Core Version:    0.7.0.1
 */