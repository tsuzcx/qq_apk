package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.ui.MMActivity.a;

final class d$1$3
  implements MMActivity.a
{
  d$1$3(d.1 param1, a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13708);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      ((MobileFriendUI)d.d(this.gvO.gvN)).b(this.gvG);
    }
    AppMethodBeat.o(13708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.d.1.3
 * JD-Core Version:    0.7.0.1
 */