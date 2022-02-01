package com.tencent.mm.plugin.card.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class CardInvalidTicketListUI$l$2
  implements DialogInterface.OnClickListener
{
  public static final 2 tCn;
  
  static
  {
    AppMethodBeat.i(112487);
    tCn = new 2();
    AppMethodBeat.o(112487);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(112486);
    paramDialogInterface.dismiss();
    h.IzE.a(16322, new Object[] { Integer.valueOf(12) });
    AppMethodBeat.o(112486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.l.2
 * JD-Core Version:    0.7.0.1
 */