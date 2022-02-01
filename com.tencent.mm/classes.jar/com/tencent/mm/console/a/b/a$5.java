package com.tencent.mm.console.a.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$5
  implements DialogInterface.OnClickListener
{
  a$5(a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(20203);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(20203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.console.a.b.a.5
 * JD-Core Version:    0.7.0.1
 */