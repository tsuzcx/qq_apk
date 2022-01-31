package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$15
  implements DialogInterface.OnClickListener
{
  b$15(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16096);
    ((ClipboardManager)this.eug.getSystemService("clipboard")).setText(this.euj);
    AppMethodBeat.o(16096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.b.15
 * JD-Core Version:    0.7.0.1
 */