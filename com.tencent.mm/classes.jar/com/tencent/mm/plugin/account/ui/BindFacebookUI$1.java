package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class BindFacebookUI$1
  implements DialogInterface.OnCancelListener
{
  BindFacebookUI$1(BindFacebookUI paramBindFacebookUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (BindFacebookUI.a(this.flf) != null) {
      g.Dk().c(BindFacebookUI.a(this.flf));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.BindFacebookUI.1
 * JD-Core Version:    0.7.0.1
 */