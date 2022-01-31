package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class BindGoogleContactUI$8
  implements DialogInterface.OnCancelListener
{
  BindGoogleContactUI$8(BindGoogleContactUI paramBindGoogleContactUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    BindGoogleContactUI.f(this.faN);
    if (BindGoogleContactUI.g(this.faN) != null) {
      g.Dk().c(BindGoogleContactUI.g(this.faN));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.8
 * JD-Core Version:    0.7.0.1
 */