package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.model.h;

final class FacebookFriendUI$8
  extends h
{
  FacebookFriendUI$8(FacebookFriendUI paramFacebookFriendUI) {}
  
  public final void l(Bundle paramBundle)
  {
    super.l(paramBundle);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    super.onError(paramInt, paramString);
    if (paramInt == 3) {
      FacebookFriendUI.f(this.flO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookFriendUI.8
 * JD-Core Version:    0.7.0.1
 */