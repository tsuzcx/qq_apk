package com.tencent.mm.plugin.card.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

final class d$7
  implements DialogInterface.OnClickListener
{
  d$7(MMActivity paramMMActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(88832);
    paramDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
    this.val$activity.startActivity(paramDialogInterface);
    AppMethodBeat.o(88832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d.7
 * JD-Core Version:    0.7.0.1
 */