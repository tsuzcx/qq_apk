package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

class FacebookLiteLoginMethodHandler
  extends NativeAppLoginMethodHandler
{
  public static final Parcelable.Creator<FacebookLiteLoginMethodHandler> CREATOR;
  
  static
  {
    AppMethodBeat.i(96766);
    CREATOR = new FacebookLiteLoginMethodHandler.1();
    AppMethodBeat.o(96766);
  }
  
  FacebookLiteLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  FacebookLiteLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getNameForLogging()
  {
    return "fb_lite_login";
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96764);
    String str = LoginClient.getE2E();
    paramRequest = NativeProtocol.createFacebookLiteIntent(this.loginClient.getActivity(), paramRequest.getApplicationId(), paramRequest.getPermissions(), str, paramRequest.isRerequest(), paramRequest.hasPublishPermission(), paramRequest.getDefaultAudience(), getClientState(paramRequest.getAuthId()), paramRequest.getAuthType());
    addLoggingExtra("e2e", str);
    boolean bool = tryIntent(paramRequest, LoginClient.getLoginRequestCode());
    AppMethodBeat.o(96764);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96765);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(96765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.FacebookLiteLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */