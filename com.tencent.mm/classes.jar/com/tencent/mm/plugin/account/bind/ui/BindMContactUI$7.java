package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.b;

final class BindMContactUI$7
  implements Runnable
{
  BindMContactUI$7(BindMContactUI paramBindMContactUI) {}
  
  public final void run()
  {
    String str = this.fcb.getString(a.i.gdpr_login_verifybirthday_url, new Object[] { x.cqJ() });
    a.b(this.fcb, str, 30765, true);
    b.gL(this.fcb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI.7
 * JD-Core Version:    0.7.0.1
 */