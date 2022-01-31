package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookFriendUI$4
  implements DialogInterface.OnClickListener
{
  FacebookFriendUI$4(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(124810);
    paramDialogInterface = new Intent(this.gDg.getContext(), FacebookAuthUI.class);
    paramDialogInterface.putExtra("is_force_unbind", true);
    this.gDg.getContext().startActivity(paramDialogInterface);
    this.gDg.finish();
    AppMethodBeat.o(124810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.4
 * JD-Core Version:    0.7.0.1
 */