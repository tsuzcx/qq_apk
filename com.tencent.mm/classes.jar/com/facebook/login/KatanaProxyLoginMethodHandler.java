package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

class KatanaProxyLoginMethodHandler
  extends NativeAppLoginMethodHandler
{
  public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR;
  
  static
  {
    AppMethodBeat.i(7809);
    CREATOR = new Parcelable.Creator()
    {
      public final KatanaProxyLoginMethodHandler createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(7804);
        paramAnonymousParcel = new KatanaProxyLoginMethodHandler(paramAnonymousParcel);
        AppMethodBeat.o(7804);
        return paramAnonymousParcel;
      }
      
      public final KatanaProxyLoginMethodHandler[] newArray(int paramAnonymousInt)
      {
        return new KatanaProxyLoginMethodHandler[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(7809);
  }
  
  KatanaProxyLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  KatanaProxyLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getNameForLogging()
  {
    return "katana_proxy_auth";
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7807);
    String str = LoginClient.getE2E();
    paramRequest = NativeProtocol.createProxyAuthIntent(this.loginClient.getActivity(), paramRequest.getApplicationId(), paramRequest.getPermissions(), str, paramRequest.isRerequest(), paramRequest.hasPublishPermission(), paramRequest.getDefaultAudience(), getClientState(paramRequest.getAuthId()), paramRequest.getAuthType());
    addLoggingExtra("e2e", str);
    boolean bool = tryIntent(paramRequest, LoginClient.getLoginRequestCode());
    AppMethodBeat.o(7807);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(7808);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(7808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.KatanaProxyLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */