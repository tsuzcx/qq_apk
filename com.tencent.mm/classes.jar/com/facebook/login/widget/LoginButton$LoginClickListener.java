package com.facebook.login.widget;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.login.LoginManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LoginButton$LoginClickListener
  implements View.OnClickListener
{
  protected LoginButton$LoginClickListener(LoginButton paramLoginButton) {}
  
  protected LoginManager getLoginManager()
  {
    AppMethodBeat.i(92642);
    LoginManager localLoginManager = LoginManager.getInstance();
    localLoginManager.setDefaultAudience(this.this$0.getDefaultAudience());
    localLoginManager.setLoginBehavior(this.this$0.getLoginBehavior());
    localLoginManager.setAuthType(this.this$0.getAuthType());
    AppMethodBeat.o(92642);
    return localLoginManager;
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(92639);
    LoginButton.access$300(this.this$0, paramView);
    paramView = AccessToken.getCurrentAccessToken();
    AppEventsLogger localAppEventsLogger;
    Bundle localBundle;
    if (AccessToken.isCurrentAccessTokenActive())
    {
      performLogout(this.this$0.getContext());
      localAppEventsLogger = AppEventsLogger.newLogger(this.this$0.getContext());
      localBundle = new Bundle();
      if (paramView == null) {
        break label115;
      }
      i = 0;
      label63:
      localBundle.putInt("logging_in", i);
      if (!AccessToken.isCurrentAccessTokenActive()) {
        break label120;
      }
    }
    label115:
    label120:
    for (int i = j;; i = 0)
    {
      localBundle.putInt("access_token_expired", i);
      localAppEventsLogger.logSdkEvent(LoginButton.access$400(this.this$0), null, localBundle);
      AppMethodBeat.o(92639);
      return;
      performLogin();
      break;
      i = 1;
      break label63;
    }
  }
  
  protected void performLogin()
  {
    AppMethodBeat.i(92640);
    LoginManager localLoginManager = getLoginManager();
    if (LoginAuthorizationType.PUBLISH.equals(LoginButton.LoginButtonProperties.access$600(LoginButton.access$500(this.this$0))))
    {
      if (this.this$0.getFragment() != null)
      {
        localLoginManager.logInWithPublishPermissions(this.this$0.getFragment(), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this.this$0)));
        AppMethodBeat.o(92640);
        return;
      }
      if (this.this$0.getNativeFragment() != null)
      {
        localLoginManager.logInWithPublishPermissions(this.this$0.getNativeFragment(), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this.this$0)));
        AppMethodBeat.o(92640);
        return;
      }
      localLoginManager.logInWithPublishPermissions(LoginButton.access$800(this.this$0), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this.this$0)));
      AppMethodBeat.o(92640);
      return;
    }
    if (this.this$0.getFragment() != null)
    {
      localLoginManager.logInWithReadPermissions(this.this$0.getFragment(), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this.this$0)));
      AppMethodBeat.o(92640);
      return;
    }
    if (this.this$0.getNativeFragment() != null)
    {
      localLoginManager.logInWithReadPermissions(this.this$0.getNativeFragment(), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this.this$0)));
      AppMethodBeat.o(92640);
      return;
    }
    localLoginManager.logInWithReadPermissions(LoginButton.access$900(this.this$0), LoginButton.LoginButtonProperties.access$700(LoginButton.access$500(this.this$0)));
    AppMethodBeat.o(92640);
  }
  
  protected void performLogout(Context paramContext)
  {
    AppMethodBeat.i(92641);
    final LoginManager localLoginManager = getLoginManager();
    if (LoginButton.access$1000(this.this$0))
    {
      String str1 = this.this$0.getResources().getString(2131296316);
      String str2 = this.this$0.getResources().getString(2131296312);
      Object localObject = Profile.getCurrentProfile();
      if ((localObject != null) && (((Profile)localObject).getName() != null)) {}
      for (localObject = String.format(this.this$0.getResources().getString(2131296318), new Object[] { ((Profile)localObject).getName() });; localObject = this.this$0.getResources().getString(2131296319))
      {
        paramContext = new AlertDialog.Builder(paramContext);
        paramContext.setMessage((CharSequence)localObject).setCancelable(true).setPositiveButton(str1, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(92638);
            localLoginManager.logOut();
            AppMethodBeat.o(92638);
          }
        }).setNegativeButton(str2, null);
        paramContext.create().show();
        AppMethodBeat.o(92641);
        return;
      }
    }
    localLoginManager.logOut();
    AppMethodBeat.o(92641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.login.widget.LoginButton.LoginClickListener
 * JD-Core Version:    0.7.0.1
 */