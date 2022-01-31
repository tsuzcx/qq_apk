package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.internal.WebDialog.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WebViewLoginMethodHandler
  extends WebLoginMethodHandler
{
  public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR;
  private String e2e;
  private WebDialog loginDialog;
  
  static
  {
    AppMethodBeat.i(96940);
    CREATOR = new WebViewLoginMethodHandler.2();
    AppMethodBeat.o(96940);
  }
  
  WebViewLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(96938);
    this.e2e = paramParcel.readString();
    AppMethodBeat.o(96938);
  }
  
  WebViewLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  void cancel()
  {
    AppMethodBeat.i(96935);
    if (this.loginDialog != null)
    {
      this.loginDialog.cancel();
      this.loginDialog = null;
    }
    AppMethodBeat.o(96935);
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
    AppMethodBeat.i(96937);
    super.onComplete(paramRequest, paramBundle, paramFacebookException);
    AppMethodBeat.o(96937);
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96936);
    Bundle localBundle = getParameters(paramRequest);
    WebViewLoginMethodHandler.1 local1 = new WebViewLoginMethodHandler.1(this, paramRequest);
    this.e2e = LoginClient.getE2E();
    addLoggingExtra("e2e", this.e2e);
    FragmentActivity localFragmentActivity = this.loginClient.getActivity();
    boolean bool = Utility.isChromeOS(localFragmentActivity);
    this.loginDialog = new WebViewLoginMethodHandler.AuthDialogBuilder(localFragmentActivity, paramRequest.getApplicationId(), localBundle).setE2E(this.e2e).setIsChromeOS(bool).setAuthType(paramRequest.getAuthType()).setOnCompleteListener(local1).build();
    paramRequest = new FacebookDialogFragment();
    paramRequest.setRetainInstance(true);
    paramRequest.setDialog(this.loginDialog);
    paramRequest.show(localFragmentActivity.getSupportFragmentManager(), "FacebookDialogFragment");
    AppMethodBeat.o(96936);
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96939);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.e2e);
    AppMethodBeat.o(96939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.login.WebViewLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */