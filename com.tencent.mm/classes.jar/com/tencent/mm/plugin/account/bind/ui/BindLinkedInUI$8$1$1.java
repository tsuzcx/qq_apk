package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.c;

final class BindLinkedInUI$8$1$1
  implements DialogInterface.OnCancelListener
{
  BindLinkedInUI$8$1$1(BindLinkedInUI.8.1 param1, c paramc) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.Dk().c(this.fbq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.8.1.1
 * JD-Core Version:    0.7.0.1
 */