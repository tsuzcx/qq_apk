package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.ui.MMActivity.a;

final class c$1$3
  implements MMActivity.a
{
  c$1$3(c.1 param1, a parama) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13696);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      ((MobileFriendUI)c.d(this.gvF.gvE)).b(this.gvG);
    }
    AppMethodBeat.o(13696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c.1.3
 * JD-Core Version:    0.7.0.1
 */