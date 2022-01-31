package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;

final class FindMContactLearmMoreUI$4
  implements DialogInterface.OnCancelListener
{
  FindMContactLearmMoreUI$4(FindMContactLearmMoreUI paramFindMContactLearmMoreUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(13625);
    if (FindMContactLearmMoreUI.e(this.gvb) != null)
    {
      g.Rc().b(431, FindMContactLearmMoreUI.e(this.gvb));
      FindMContactLearmMoreUI.f(this.gvb);
    }
    AppMethodBeat.o(13625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.4
 * JD-Core Version:    0.7.0.1
 */