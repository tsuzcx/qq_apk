package com.tencent.mm.console;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

final class b$16
  implements DialogInterface.OnClickListener
{
  b$16(String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20129);
    ClipboardHelper.setText(this.gMD);
    AppMethodBeat.o(20129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.16
 * JD-Core Version:    0.7.0.1
 */