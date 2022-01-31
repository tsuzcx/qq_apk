package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class g$1
  implements DialogInterface.OnClickListener
{
  g$1(g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(90609);
    Toast.makeText(ah.getContext(), "OK", 0).show();
    AppMethodBeat.o(90609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.g.1
 * JD-Core Version:    0.7.0.1
 */