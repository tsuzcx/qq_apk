package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class DBRecoveryUI$7
  implements Runnable
{
  DBRecoveryUI$7(DBRecoveryUI paramDBRecoveryUI, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(18953);
    this.guS.dismiss();
    this.kTI.finish();
    d.biS();
    AppMethodBeat.o(18953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.7
 * JD-Core Version:    0.7.0.1
 */