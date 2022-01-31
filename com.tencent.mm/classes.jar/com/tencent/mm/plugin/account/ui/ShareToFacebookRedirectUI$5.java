package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareToFacebookRedirectUI$5
  implements DialogInterface.OnClickListener
{
  ShareToFacebookRedirectUI$5(ShareToFacebookRedirectUI paramShareToFacebookRedirectUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(125575);
    paramDialogInterface = new Intent(this.gKl.getContext(), FacebookAuthUI.class);
    paramDialogInterface.putExtra("is_force_unbind", true);
    this.gKl.getContext().startActivityForResult(paramDialogInterface, 0);
    AppMethodBeat.o(125575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.5
 * JD-Core Version:    0.7.0.1
 */