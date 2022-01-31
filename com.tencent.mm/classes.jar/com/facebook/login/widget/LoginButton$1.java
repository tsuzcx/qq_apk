package com.facebook.login.widget;

import android.app.Activity;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LoginButton$1
  implements Runnable
{
  LoginButton$1(LoginButton paramLoginButton, String paramString) {}
  
  public void run()
  {
    AppMethodBeat.i(92632);
    FetchedAppSettings localFetchedAppSettings = FetchedAppSettingsManager.queryAppSettings(this.val$appId, false);
    LoginButton.access$100(this.this$0).runOnUiThread(new LoginButton.1.1(this, localFetchedAppSettings));
    AppMethodBeat.o(92632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.login.widget.LoginButton.1
 * JD-Core Version:    0.7.0.1
 */