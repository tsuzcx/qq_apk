package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class FindMContactIntroUI$10
  implements DialogInterface.OnCancelListener
{
  FindMContactIntroUI$10(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13606);
    if (FindMContactIntroUI.i(this.guX) != null)
    {
      g.Rc().b(431, FindMContactIntroUI.i(this.guX));
      FindMContactIntroUI.j(this.guX);
    }
    AppMethodBeat.o(13606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.10
 * JD-Core Version:    0.7.0.1
 */