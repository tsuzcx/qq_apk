package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookFriendUI$12
  implements View.OnClickListener
{
  FacebookFriendUI$12(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(124819);
    this.gDg.startActivity(new Intent(this.gDg, FacebookAuthUI.class));
    AppMethodBeat.o(124819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.12
 * JD-Core Version:    0.7.0.1
 */