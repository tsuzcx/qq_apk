package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.account.model.h;
import com.tencent.mm.sdk.platformtools.y;

final class ShareToFacebookRedirectUI$3
  extends h
{
  ShareToFacebookRedirectUI$3(ShareToFacebookRedirectUI paramShareToFacebookRedirectUI) {}
  
  public final void l(Bundle paramBundle)
  {
    super.l(paramBundle);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    y.e(ShareToFacebookRedirectUI.access$000(), "refresh token error. errType:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    super.onError(paramInt, paramString);
    if (paramInt == 3) {
      ShareToFacebookRedirectUI.a(this.fsJ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.3
 * JD-Core Version:    0.7.0.1
 */