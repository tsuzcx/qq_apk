package com.tencent.mm.plugin.dbbackup;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DBRecoveryUI$4
  implements MenuItem.OnMenuItemClickListener
{
  DBRecoveryUI$4(DBRecoveryUI paramDBRecoveryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(18947);
    if (DBRecoveryUI.f(this.kTI)) {
      DBRecoveryUI.e(this.kTI);
    }
    for (;;)
    {
      AppMethodBeat.o(18947);
      return true;
      this.kTI.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.4
 * JD-Core Version:    0.7.0.1
 */