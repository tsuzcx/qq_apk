package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.sdk.a.a;

final class MobileFriendUI$6
  implements DialogInterface.OnClickListener
{
  MobileFriendUI$6(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110150);
    l.gX(false);
    ((a)h.ag(a.class)).syncUploadMContactStatus(false, true);
    this.mUK.finish();
    AppMethodBeat.o(110150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.6
 * JD-Core Version:    0.7.0.1
 */