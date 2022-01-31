package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$11
  implements DialogInterface.OnClickListener
{
  b$11(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16092);
    ((ClipboardManager)this.eug.getSystemService("clipboard")).setText(this.val$text);
    AppMethodBeat.o(16092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.console.b.11
 * JD-Core Version:    0.7.0.1
 */