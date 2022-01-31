package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.e;

final class CleanMsgUI$6$1
  implements DialogInterface.OnClickListener
{
  CleanMsgUI$6$1(CleanMsgUI.6 param6) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18892);
    CleanMsgUI.a(this.kJq.kJo, new e(d.bgO(), this.kJq.kJo, CleanMsgUI.bhj()));
    CleanMsgUI.b(this.kJq.kJo).start();
    CleanMsgUI.c(this.kJq.kJo).show();
    AppMethodBeat.o(18892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.6.1
 * JD-Core Version:    0.7.0.1
 */