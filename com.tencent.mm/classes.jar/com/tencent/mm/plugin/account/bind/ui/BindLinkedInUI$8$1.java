package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.ui.base.h;

final class BindLinkedInUI$8$1
  implements DialogInterface.OnClickListener
{
  BindLinkedInUI$8$1(BindLinkedInUI.8 param8) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new c();
    BindLinkedInUI.a(this.fbp.fbn, h.b(this.fbp.fbn, this.fbp.fbn.getString(a.i.loading_tips), false, new BindLinkedInUI.8.1.1(this, paramDialogInterface)));
    g.Dk().a(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.8.1
 * JD-Core Version:    0.7.0.1
 */