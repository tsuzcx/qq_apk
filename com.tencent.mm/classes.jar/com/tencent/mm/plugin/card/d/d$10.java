package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class d$10
  implements DialogInterface.OnClickListener
{
  d$10(Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(113762);
    paramDialogInterface.dismiss();
    paramDialogInterface = new kl();
    paramDialogInterface.dPA.context = this.val$context;
    EventCenter.instance.publish(paramDialogInterface);
    Log.i("MicroMsg.CardDialogHelper", "enter to cardhome");
    AppMethodBeat.o(113762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d.10
 * JD-Core Version:    0.7.0.1
 */