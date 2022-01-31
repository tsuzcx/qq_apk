package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$8
  implements DialogInterface.OnClickListener
{
  b$8(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16088);
    ((ClipboardManager)this.eug.getSystemService("clipboard")).setText(this.val$key);
    AppMethodBeat.o(16088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.b.8
 * JD-Core Version:    0.7.0.1
 */