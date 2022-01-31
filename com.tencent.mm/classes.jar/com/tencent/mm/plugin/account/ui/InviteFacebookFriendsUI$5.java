package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.model.h;

final class InviteFacebookFriendsUI$5
  extends h
{
  InviteFacebookFriendsUI$5(InviteFacebookFriendsUI paramInviteFacebookFriendsUI) {}
  
  public final void l(Bundle paramBundle)
  {
    super.l(paramBundle);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    super.onError(paramInt, paramString);
    if (paramInt == 3) {
      InviteFacebookFriendsUI.c(this.fmd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.5
 * JD-Core Version:    0.7.0.1
 */