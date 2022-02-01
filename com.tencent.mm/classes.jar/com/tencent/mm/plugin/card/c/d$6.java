package com.tencent.mm.plugin.card.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class d$6
  implements DialogInterface.OnClickListener
{
  d$6(boolean paramBoolean, MMActivity paramMMActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(113759);
    paramDialogInterface.dismiss();
    if (this.wKt) {
      this.val$activity.finish();
    }
    AppMethodBeat.o(113759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.d.6
 * JD-Core Version:    0.7.0.1
 */