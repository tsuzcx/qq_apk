package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.plugin.account.model.l.a;

final class o$9
  implements DialogInterface.OnClickListener
{
  o$9(o paramo) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(128430);
    this.iUu.iUm.finish();
    l.a(l.a.iOy);
    AppMethodBeat.o(128430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o.9
 * JD-Core Version:    0.7.0.1
 */