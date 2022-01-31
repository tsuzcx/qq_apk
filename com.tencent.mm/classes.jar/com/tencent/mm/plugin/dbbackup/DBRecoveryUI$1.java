package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DBRecoveryUI$1
  implements DialogInterface.OnClickListener
{
  DBRecoveryUI$1(DBRecoveryUI paramDBRecoveryUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18943);
    if (DBRecoveryUI.a(this.kTI) != 0)
    {
      DBRecoveryUI.b(this.kTI).setVisibility(0);
      DBRecoveryUI.c(this.kTI).setVisibility(8);
      AppMethodBeat.o(18943);
      return;
    }
    d.biS();
    AppMethodBeat.o(18943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.1
 * JD-Core Version:    0.7.0.1
 */