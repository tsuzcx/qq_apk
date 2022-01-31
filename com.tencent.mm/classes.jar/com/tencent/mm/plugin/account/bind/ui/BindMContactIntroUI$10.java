package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;

final class BindMContactIntroUI$10
  implements DialogInterface.OnCancelListener
{
  BindMContactIntroUI$10(BindMContactIntroUI paramBindMContactIntroUI, x paramx) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13424);
    g.Rc().a(this.gtx);
    AppMethodBeat.o(13424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.10
 * JD-Core Version:    0.7.0.1
 */