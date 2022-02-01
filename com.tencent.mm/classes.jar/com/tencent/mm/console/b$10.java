package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$10
  implements DialogInterface.OnClickListener
{
  b$10(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20122);
    ((ClipboardManager)this.fHE.getSystemService("clipboard")).setText(this.val$key);
    Toast.makeText(this.fHE, 2131764864, 0).show();
    AppMethodBeat.o(20122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.10
 * JD-Core Version:    0.7.0.1
 */