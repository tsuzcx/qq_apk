package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;

final class b$17
  implements DialogInterface.OnClickListener
{
  b$17(String paramString, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20128);
    ClipboardHelper.setText(this.val$key);
    Toast.makeText(this.jwP, R.l.voip_get_key_copy_note, 0).show();
    AppMethodBeat.o(20128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.b.17
 * JD-Core Version:    0.7.0.1
 */