package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

final class b$10
  implements DialogInterface.OnClickListener
{
  b$10(String paramString, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20122);
    ClipboardHelper.setText(this.val$key);
    Toast.makeText(this.gMA, 2131767303, 0).show();
    AppMethodBeat.o(20122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.b.10
 * JD-Core Version:    0.7.0.1
 */