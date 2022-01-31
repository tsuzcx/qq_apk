package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.ui.base.h;

final class StartUnbindQQ$2$1
  implements DialogInterface.OnClickListener
{
  StartUnbindQQ$2$1(StartUnbindQQ.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new d("");
    g.Dk().a(paramDialogInterface, 0);
    paramDialogInterface = this.feK.feJ;
    StartUnbindQQ localStartUnbindQQ = this.feK.feJ;
    this.feK.feJ.getString(a.i.app_tip);
    StartUnbindQQ.a(paramDialogInterface, h.b(localStartUnbindQQ, this.feK.feJ.getString(a.i.setting_unbinding_qq), true, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ.2.1
 * JD-Core Version:    0.7.0.1
 */