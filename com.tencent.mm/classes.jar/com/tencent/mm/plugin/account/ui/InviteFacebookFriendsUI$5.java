package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.model.i;

final class InviteFacebookFriendsUI$5
  extends i
{
  InviteFacebookFriendsUI$5(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(124876);
    super.onError(paramInt, paramString);
    if (paramInt == 3) {
      InviteFacebookFriendsUI.c(this.gDx);
    }
    AppMethodBeat.o(124876);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(124875);
    super.u(paramBundle);
    AppMethodBeat.o(124875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.5
 * JD-Core Version:    0.7.0.1
 */