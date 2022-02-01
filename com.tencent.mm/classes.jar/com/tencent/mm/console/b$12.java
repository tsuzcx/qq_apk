package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$12
  implements DialogInterface.OnClickListener
{
  b$12(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20125);
    ((ClipboardManager)this.fLk.getSystemService("clipboard")).setText(this.fLm);
    AppMethodBeat.o(20125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.12
 * JD-Core Version:    0.7.0.1
 */