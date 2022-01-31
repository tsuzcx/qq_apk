package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ab;

final class MobileFriendUI$10
  implements b
{
  MobileFriendUI$10(MobileFriendUI paramMobileFriendUI) {}
  
  public final void cY(boolean paramBoolean)
  {
    AppMethodBeat.i(13728);
    ab.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (MobileFriendUI.b(this.gwb) != null)
      {
        MobileFriendUI.b(this.gwb).dismiss();
        MobileFriendUI.c(this.gwb);
      }
      AppMethodBeat.o(13728);
      return;
    }
    System.currentTimeMillis();
    l.aqv();
    al localal = new al(l.aqz(), l.aqy());
    g.Rc().a(localal, 0);
    AppMethodBeat.o(13728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.10
 * JD-Core Version:    0.7.0.1
 */