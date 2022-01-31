package com.tencent.mm.plugin.dbbackup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DBRecoveryUI$6
  implements DialogInterface.OnClickListener
{
  DBRecoveryUI$6(DBRecoveryUI paramDBRecoveryUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18952);
    this.kTI.finish();
    d.biS();
    AppMethodBeat.o(18952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.6
 * JD-Core Version:    0.7.0.1
 */