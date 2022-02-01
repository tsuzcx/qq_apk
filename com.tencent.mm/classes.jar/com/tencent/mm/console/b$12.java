package com.tencent.mm.console;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

final class b$12
  implements DialogInterface.OnClickListener
{
  b$12(String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20125);
    ClipboardHelper.setText(this.val$text);
    AppMethodBeat.o(20125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.12
 * JD-Core Version:    0.7.0.1
 */