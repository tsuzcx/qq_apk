package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class z$5
  implements DialogInterface.OnClickListener
{
  z$5(Context paramContext, com.tencent.mm.h.a parama, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124586);
    com.tencent.mm.plugin.account.a.b.a.b(this.val$context, this.gjU.url, this.val$requestCode, false);
    AppMethodBeat.o(124586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.z.5
 * JD-Core Version:    0.7.0.1
 */