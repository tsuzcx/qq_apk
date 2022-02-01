package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$15
  implements DialogInterface.OnClickListener
{
  b$15(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20128);
    ((ClipboardManager)this.fLk.getSystemService("clipboard")).setText(this.val$key);
    Toast.makeText(this.fLk, 2131764864, 0).show();
    AppMethodBeat.o(20128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.15
 * JD-Core Version:    0.7.0.1
 */