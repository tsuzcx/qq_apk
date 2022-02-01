package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WebViewLoginMethodHandler
  extends WebLoginMethodHandler
{
  public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR;
  private String e2e;
  private WebDialog loginDialog;
  
  static
  {
    AppMethodBeat.i(7964);
    CREATOR = new Parcelable.Creator()
    {
      public final WebViewLoginMethodHandler createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(7955);
        paramAnonymousParcel = new WebViewLoginMethodHandler(paramAnonymousParcel);
        AppMethodBeat.o(7955);
        return paramAnonymousParcel;
      }
      
      public final WebViewLoginMethodHandler[] newArray(int paramAnonymousInt)
      {
        return new WebViewLoginMethodHandler[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(7964);
  }
  
  WebViewLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(7962);
    this.e2e = paramParcel.readString();
    AppMethodBeat.o(7962);
  }
  
  WebViewLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  void cancel()
  {
    AppMethodBeat.i(7959);
    if (this.loginDialog != null)
    {
      this.loginDialog.cancel();
      this.loginDialog = null;
    }
    AppMethodBeat.o(7959);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getNameForLogging()
  {
    return "web_view";
  }
  
  AccessTokenSource getTokenSource()
  {
    return AccessTokenSource.WEB_VIEW;
  }
  
  boolean needsInternetPermission()
  {
    return true;
  }
  
  void onWebDialogComplete(LoginClient.Request paramRequest, Bundle paramBundle, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(7961);
    super.onComplete(paramRequest, paramBundle, paramFacebookException);
    AppMethodBeat.o(7961);
  }
  
  boolean tryAuthorize(final LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7960);
    Bundle localBundle = getParameters(paramRequest);
    WebDialog.OnCompleteListener local1 = new WebDialog.OnCompleteListener()
    {
      public void onComplete(Bundle paramAnonymousBundle, FacebookException paramAnonymousFacebookException)
      {
        AppMethodBeat.i(7954);
        WebViewLoginMethodHandler.this.onWebDialogComplete(paramRequest, paramAnonymousBundle, paramAnonymousFacebookException);
        AppMethodBeat.o(7954);
      }
    };
    this.e2e = LoginClient.getE2E();
    addLoggingExtra("e2e", this.e2e);
    FragmentActivity localFragmentActivity = this.loginClient.getActivity();
    boolean bool = Utility.isChromeOS(localFragmentActivity);
    this.loginDialog = new AuthDialogBuilder(localFragmentActivity, paramRequest.getApplicationId(), localBundle).setE2E(this.e2e).setIsChromeOS(bool).setAuthType(paramRequest.getAuthType()).setOnCompleteListener(local1).build();
    paramRequest = new FacebookDialogFragment();
    paramRequest.setRetainInstance(true);
    paramRequest.setDialog(this.loginDialog);
    paramRequest.show(localFragmentActivity.getSupportFragmentManager(), "FacebookDialogFragment");
    AppMethodBeat.o(7960);
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(7963);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.e2e);
    AppMethodBeat.o(7963);
  }
  
  static class AuthDialogBuilder
    extends WebDialog.Builder
  {
    private static final String OAUTH_DIALOG = "oauth";
    private String authType;
    private String e2e;
    private String redirect_uri = "fbconnect://success";
    
    public AuthDialogBuilder(Context paramContext, String paramString, Bundle paramBundle)
    {
      super(paramString, "oauth", paramBundle);
    }
    
    public WebDialog build()
    {
      AppMethodBeat.i(7958);
      Object localObject = getParameters();
      ((Bundle)localObject).putString("redirect_uri", this.redirect_uri);
      ((Bundle)localObject).putString("client_id", getApplicationId());
      ((Bundle)localObject).putString("e2e", this.e2e);
      ((Bundle)localObject).putString("response_type", "token,signed_request");
      ((Bundle)localObject).putString("return_scopes", "true");
      ((Bundle)localObject).putString("auth_type", this.authType);
      localObject = WebDialog.newInstance(getContext(), "oauth", (Bundle)localObject, getTheme(), getListener());
      AppMethodBeat.o(7958);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.WebViewLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */