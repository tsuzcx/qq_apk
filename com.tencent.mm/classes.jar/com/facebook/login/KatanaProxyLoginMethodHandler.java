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
    AppMethodBeat.i(96785);
    CREATOR = new KatanaProxyLoginMethodHandler.1();
    AppMethodBeat.o(96785);
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
    AppMethodBeat.i(96783);
    String str = LoginClient.getE2E();
    paramRequest = NativeProtocol.createProxyAuthIntent(this.loginClient.getActivity(), paramRequest.getApplicationId(), paramRequest.getPermissions(), str, paramRequest.isRerequest(), paramRequest.hasPublishPermission(), paramRequest.getDefaultAudience(), getClientState(paramRequest.getAuthId()), paramRequest.getAuthType());
    addLoggingExtra("e2e", str);
    boolean bool = tryIntent(paramRequest, LoginClient.getLoginRequestCode());
    AppMethodBeat.o(96783);
    return bool;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96784);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(96784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.login.KatanaProxyLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */