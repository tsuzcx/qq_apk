package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class ShareToFacebookRedirectUI$4$1
  implements DialogInterface.OnCancelListener
{
  ShareToFacebookRedirectUI$4$1(ShareToFacebookRedirectUI.4 param4) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(125573);
    ShareToFacebookRedirectUI.f(this.gKn.gKl).dismiss();
    this.gKn.gKl.finish();
    AppMethodBeat.o(125573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.4.1
 * JD-Core Version:    0.7.0.1
 */