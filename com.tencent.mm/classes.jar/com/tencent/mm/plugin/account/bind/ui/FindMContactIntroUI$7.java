package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.l;

final class FindMContactIntroUI$7
  implements DialogInterface.OnClickListener
{
  FindMContactIntroUI$7(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(110027);
    l.gX(true);
    FindMContactIntroUI.f(this.mTI);
    AppMethodBeat.o(110027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.7
 * JD-Core Version:    0.7.0.1
 */