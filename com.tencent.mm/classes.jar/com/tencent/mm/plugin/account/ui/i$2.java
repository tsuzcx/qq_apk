package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.ui.base.n.d;

final class i$2
  implements n.d
{
  i$2(i parami) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(125097);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125097);
      return;
      i.a(this.gFx);
      AppMethodBeat.o(125097);
      return;
      paramMenuItem = this.gFx;
      paramMenuItem.gDn.cXw = 1L;
      paramMenuItem.gDn.cRH = 10L;
      paramMenuItem.gDn.ake();
      Intent localIntent = new Intent(paramMenuItem.gFq, FacebookLoginUI.class);
      paramMenuItem.gFq.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i.2
 * JD-Core Version:    0.7.0.1
 */