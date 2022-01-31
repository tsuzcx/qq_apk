package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;

final class MobileFriendUI$9
  implements DialogInterface.OnCancelListener
{
  MobileFriendUI$9(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (MobileFriendUI.a(this.fes) != null) {
      g.Dk().c(MobileFriendUI.a(this.fes));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.9
 * JD-Core Version:    0.7.0.1
 */