package com.tencent.mm.plugin.account.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacebookFriendUI$6
  implements d.a
{
  FacebookFriendUI$6(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final void mQ(int paramInt)
  {
    AppMethodBeat.i(124812);
    if (paramInt > 0)
    {
      FacebookFriendUI.d(this.gDg).setVisibility(8);
      AppMethodBeat.o(124812);
      return;
    }
    FacebookFriendUI.d(this.gDg).setVisibility(0);
    AppMethodBeat.o(124812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.6
 * JD-Core Version:    0.7.0.1
 */