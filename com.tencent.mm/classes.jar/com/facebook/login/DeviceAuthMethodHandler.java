package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class DeviceAuthMethodHandler
  extends LoginMethodHandler
{
  public static final Parcelable.Creator<DeviceAuthMethodHandler> CREATOR;
  private static ScheduledThreadPoolExecutor backgroundExecutor;
  
  static
  {
    AppMethodBeat.i(96760);
    CREATOR = new DeviceAuthMethodHandler.1();
    AppMethodBeat.o(96760);
  }
  
  protected DeviceAuthMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  DeviceAuthMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  public static ScheduledThreadPoolExecutor getBackgroundExecutor()
  {
    try
    {
      AppMethodBeat.i(96758);
      if (backgroundExecutor == null) {
        backgroundExecutor = new ScheduledThreadPoolExecutor(1);
      }
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = backgroundExecutor;
      AppMethodBeat.o(96758);
      return localScheduledThreadPoolExecutor;
    }
    finally {}
  }
  
  private void showDialog(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96753);
    DeviceAuthDialog localDeviceAuthDialog = createDeviceAuthDialog();
    localDeviceAuthDialog.show(this.loginClient.getActivity().getSupportFragmentManager(), "login_with_facebook");
    localDeviceAuthDialog.startLogin(paramRequest);
    AppMethodBeat.o(96753);
  }
  
  protected DeviceAuthDialog createDeviceAuthDialog()
  {
    AppMethodBeat.i(96754);
    DeviceAuthDialog localDeviceAuthDialog = new DeviceAuthDialog();
    AppMethodBeat.o(96754);
    return localDeviceAuthDialog;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getNameForLogging()
  {
    return "device_auth";
  }
  
  public void onCancel()
  {
    AppMethodBeat.i(96755);
    LoginClient.Result localResult = LoginClient.Result.createCancelResult(this.loginClient.getPendingRequest(), "User canceled log in.");
    this.loginClient.completeAndValidate(localResult);
    AppMethodBeat.o(96755);
  }
  
  public void onError(Exception paramException)
  {
    AppMethodBeat.i(96756);
    paramException = LoginClient.Result.createErrorResult(this.loginClient.getPendingRequest(), null, paramException.getMessage());
    this.loginClient.completeAndValidate(paramException);
    AppMethodBeat.o(96756);
  }
  
  public void onSuccess(String paramString1, String paramString2, String paramString3, Collection<String> paramCollection1, Collection<String> paramCollection2, AccessTokenSource paramAccessTokenSource, Date paramDate1, Date paramDate2, Date paramDate3)
  {
    AppMethodBeat.i(96757);
    paramString1 = new AccessToken(paramString1, paramString2, paramString3, paramCollection1, paramCollection2, paramAccessTokenSource, paramDate1, paramDate2, paramDate3);
    paramString1 = LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), paramString1);
    this.loginClient.completeAndValidate(paramString1);
    AppMethodBeat.o(96757);
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96752);
    showDialog(paramRequest);
    AppMethodBeat.o(96752);
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96759);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(96759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.DeviceAuthMethodHandler
 * JD-Core Version:    0.7.0.1
 */