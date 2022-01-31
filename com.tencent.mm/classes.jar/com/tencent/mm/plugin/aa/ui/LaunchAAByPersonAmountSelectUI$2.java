package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$2
  implements MenuItem.OnMenuItemClickListener
{
  LaunchAAByPersonAmountSelectUI$2(LaunchAAByPersonAmountSelectUI paramLaunchAAByPersonAmountSelectUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(40789);
    if ((LaunchAAByPersonAmountSelectUI.c(this.gqx) != null) && (LaunchAAByPersonAmountSelectUI.c(this.gqx).size() > 0)) {
      h.a(this.gqx, this.gqx.getString(2131296384), null, this.gqx.getString(2131296388), this.gqx.getString(2131296387), false, new LaunchAAByPersonAmountSelectUI.2.1(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(40788);
          LaunchAAByPersonAmountSelectUI.2.this.gqx.finish();
          AppMethodBeat.o(40788);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(40789);
      return true;
      this.gqx.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.2
 * JD-Core Version:    0.7.0.1
 */