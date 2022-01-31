package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class BindQQUI$7$2
  implements n.d
{
  BindQQUI$7$2(BindQQUI.7 param7) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(13550);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13550);
      return;
      paramMenuItem = this.guA.guz;
      y localy = new y(y.gxX);
      g.Rc().a(localy, 0);
      paramMenuItem.getString(2131297087);
      paramMenuItem.tipDialog = h.b(paramMenuItem, paramMenuItem.getString(2131296987), true, new BindQQUI.2(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI.7.2
 * JD-Core Version:    0.7.0.1
 */