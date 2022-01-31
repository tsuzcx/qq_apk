package com.tencent.mm.plugin.account.bind.ui;

import android.widget.Button;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;

final class BindMContactIntroUI$18
  implements Runnable
{
  BindMContactIntroUI$18(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void run()
  {
    if (l.WN())
    {
      BindMContactIntroUI.Wd();
      BindMContactIntroUI.j(this.fbF).setText(this.fbF.getString(a.i.bind_mcontact_friend_btn_text));
      BindMContactIntroUI.a(this.fbF, l.a.ffT);
      boolean bool = bk.a((Boolean)g.DP().Dz().get(12322, Boolean.valueOf(false)), false);
      if ((BindMContactIntroUI.i(this.fbF)) && (bool)) {
        h.nFQ.f(11002, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.18
 * JD-Core Version:    0.7.0.1
 */