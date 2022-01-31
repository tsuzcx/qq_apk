package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.y;

final class MobileFriendUI$10
  implements b
{
  MobileFriendUI$10(MobileFriendUI paramMobileFriendUI) {}
  
  public final void bW(boolean paramBoolean)
  {
    y.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      if (MobileFriendUI.b(this.fes) != null)
      {
        MobileFriendUI.b(this.fes).dismiss();
        MobileFriendUI.c(this.fes);
      }
      return;
    }
    System.currentTimeMillis();
    al localal = new al(l.WW(), l.WV());
    g.Dk().a(localal, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.10
 * JD-Core Version:    0.7.0.1
 */