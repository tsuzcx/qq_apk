package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebDialog$Builder
{
  private AccessToken accessToken;
  private String action;
  private String applicationId;
  private Context context;
  private WebDialog.OnCompleteListener listener;
  private Bundle parameters;
  private int theme;
  
  public WebDialog$Builder(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(96659);
    this.accessToken = AccessToken.getCurrentAccessToken();
    if (!AccessToken.isCurrentAccessTokenActive())
    {
      String str = Utility.getMetadataApplicationId(paramContext);
      if (str != null) {
        this.applicationId = str;
      }
    }
    else
    {
      finishInit(paramContext, paramString, paramBundle);
      AppMethodBeat.o(96659);
      return;
    }
    paramContext = new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
    AppMethodBeat.o(96659);
    throw paramContext;
  }
  
  public WebDialog$Builder(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(96660);
    String str = paramString1;
    if (paramString1 == null) {
      str = Utility.getMetadataApplicationId(paramContext);
    }
    Validate.notNullOrEmpty(str, "applicationId");
    this.applicationId = str;
    finishInit(paramContext, paramString2, paramBundle);
    AppMethodBeat.o(96660);
  }
  
  private void finishInit(Context paramContext, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(96662);
    this.context = paramContext;
    this.action = paramString;
    if (paramBundle != null)
    {
      this.parameters = paramBundle;
      AppMethodBeat.o(96662);
      return;
    }
    this.parameters = new Bundle();
    AppMethodBeat.o(96662);
  }
  
  public WebDialog build()
  {
    AppMethodBeat.i(96661);
    if (this.accessToken != null)
    {
      this.parameters.putString("app_id", this.accessToken.getApplicationId());
      this.parameters.putString("access_token", this.accessToken.getToken());
    }
    for (;;)
    {
      WebDialog localWebDialog = WebDialog.newInstance(this.context, this.action, this.parameters, this.theme, this.listener);
      AppMethodBeat.o(96661);
      return localWebDialog;
      this.parameters.putString("app_id", this.applicationId);
    }
  }
  
  public String getApplicationId()
  {
    return this.applicationId;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public WebDialog.OnCompleteListener getListener()
  {
    return this.listener;
  }
  
  public Bundle getParameters()
  {
    return this.parameters;
  }
  
  public int getTheme()
  {
    return this.theme;
  }
  
  public Builder setOnCompleteListener(WebDialog.OnCompleteListener paramOnCompleteListener)
  {
    this.listener = paramOnCompleteListener;
    return this;
  }
  
  public Builder setTheme(int paramInt)
  {
    this.theme = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.WebDialog.Builder
 * JD-Core Version:    0.7.0.1
 */