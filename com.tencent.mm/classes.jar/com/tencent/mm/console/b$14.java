package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$14
  implements DialogInterface.OnClickListener
{
  b$14(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(16095);
    ((ClipboardManager)this.eug.getSystemService("clipboard")).setText(this.val$key);
    Toast.makeText(this.eug, 2131304688, 0).show();
    AppMethodBeat.o(16095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.console.b.14
 * JD-Core Version:    0.7.0.1
 */