package com.tencent.mm.console;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

final class a$14
  implements DialogInterface.OnClickListener
{
  a$14(String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20125);
    ClipboardHelper.setText(this.val$text);
    AppMethodBeat.o(20125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.14
 * JD-Core Version:    0.7.0.1
 */