package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$16
  implements DialogInterface.OnClickListener
{
  b$16(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20129);
    ((ClipboardManager)this.fLk.getSystemService("clipboard")).setText(this.fLo);
    AppMethodBeat.o(20129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.16
 * JD-Core Version:    0.7.0.1
 */