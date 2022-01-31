package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.ui.base.h;

final class BindLinkedInUI$8$1
  implements DialogInterface.OnClickListener
{
  BindLinkedInUI$8$1(BindLinkedInUI.8 param8) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(13394);
    paramDialogInterface = new c();
    BindLinkedInUI.a(this.gth.gtf, h.b(this.gth.gtf, this.gth.gtf.getString(2131301086), false, new BindLinkedInUI.8.1.1(this, paramDialogInterface)));
    g.Rc().a(paramDialogInterface, 0);
    AppMethodBeat.o(13394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.8.1
 * JD-Core Version:    0.7.0.1
 */