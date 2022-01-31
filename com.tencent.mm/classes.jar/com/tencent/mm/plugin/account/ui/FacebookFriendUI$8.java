package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.i;

final class FacebookFriendUI$8
  extends i
{
  FacebookFriendUI$8(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(124815);
    super.onError(paramInt, paramString);
    if (paramInt == 3) {
      FacebookFriendUI.f(this.gDg);
    }
    AppMethodBeat.o(124815);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(124814);
    super.u(paramBundle);
    AppMethodBeat.o(124814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.8
 * JD-Core Version:    0.7.0.1
 */