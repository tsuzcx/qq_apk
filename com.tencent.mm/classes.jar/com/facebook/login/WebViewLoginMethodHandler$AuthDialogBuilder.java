package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.WebDialog;
import com.facebook.internal.WebDialog.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WebViewLoginMethodHandler$AuthDialogBuilder
  extends WebDialog.Builder
{
  private static final String OAUTH_DIALOG = "oauth";
  private String authType;
  private String e2e;
  private String redirect_uri = "fbconnect://success";
  
  public WebViewLoginMethodHandler$AuthDialogBuilder(Context paramContext, String paramString, Bundle paramBundle)
  {
    super(paramContext, paramString, "oauth", paramBundle);
  }
  
  public WebDialog build()
  {
    AppMethodBeat.i(96934);
    Object localObject = getParameters();
    ((Bundle)localObject).putString("redirect_uri", this.redirect_uri);
    ((Bundle)localObject).putString("client_id", getApplicationId());
    ((Bundle)localObject).putString("e2e", this.e2e);
    ((Bundle)localObject).putString("response_type", "token,signed_request");
    ((Bundle)localObject).putString("return_scopes", "true");
    ((Bundle)localObject).putString("auth_type", this.authType);
    localObject = WebDialog.newInstance(getContext(), "oauth", (Bundle)localObject, getTheme(), getListener());
    AppMethodBeat.o(96934);
    return localObject;
  }
  
  public AuthDialogBuilder setAuthType(String paramString)
  {
    this.authType = paramString;
    return this;
  }
  
  public AuthDialogBuilder setE2E(String paramString)
  {
    this.e2e = paramString;
    return this;
  }
  
  public AuthDialogBuilder setIsChromeOS(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "fbconnect://chrome_os_success";; str = "fbconnect://success")
    {
      this.redirect_uri = str;
      return this;
    }
  }
  
  public AuthDialogBuilder setIsRerequest(boolean paramBoolean)
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.login.WebViewLoginMethodHandler.AuthDialogBuilder
 * JD-Core Version:    0.7.0.1
 */