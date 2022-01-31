package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(cm paramcm) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(73916);
    if (paramInt == -2) {
      b.b(this.mvp);
    }
    AppMethodBeat.o(73916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.1
 * JD-Core Version:    0.7.0.1
 */