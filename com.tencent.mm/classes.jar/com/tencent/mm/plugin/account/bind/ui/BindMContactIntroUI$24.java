package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.y;
import com.tencent.mm.ui.base.h;

final class BindMContactIntroUI$24
  implements DialogInterface.OnClickListener
{
  BindMContactIntroUI$24(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((BindMContactIntroUI.e(this.fbF) == null) || (BindMContactIntroUI.e(this.fbF).equals(""))) {
      return;
    }
    paramDialogInterface = new y(y.fgq);
    g.Dk().a(paramDialogInterface, 0);
    paramDialogInterface = this.fbF;
    BindMContactIntroUI localBindMContactIntroUI = this.fbF;
    this.fbF.getString(a.i.app_tip);
    BindMContactIntroUI.a(paramDialogInterface, h.b(localBindMContactIntroUI, this.fbF.getString(a.i.app_loading), true, new BindMContactIntroUI.24.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.24
 * JD-Core Version:    0.7.0.1
 */