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
    AppMethodBeat.i(23056);
    if (DBRecoveryUI.f(this.xiC)) {
      DBRecoveryUI.e(this.xiC);
    }
    for (;;)
    {
      AppMethodBeat.o(23056);
      return true;
      this.xiC.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.DBRecoveryUI.4
 * JD-Core Version:    0.7.0.1
 */