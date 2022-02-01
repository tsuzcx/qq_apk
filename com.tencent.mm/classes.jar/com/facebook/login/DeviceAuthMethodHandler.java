package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.FragmentActivity;
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
    AppMethodBeat.i(7784);
    CREATOR = new Parcelable.Creator()
    {
      public final DeviceAuthMethodHandler createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(7773);
        paramAnonymousParcel = new DeviceAuthMethodHandler(paramAnonymousParcel);
        AppMethodBeat.o(7773);
        return paramAnonymousParcel;
      }
      
      public final DeviceAuthMethodHandler[] newArray(int paramAnonymousInt)
      {
        return new DeviceAuthMethodHandler[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(7784);
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
      AppMethodBeat.i(7782);
      if (backgroundExecutor == null) {
        backgroundExecutor = new ScheduledThreadPoolExecutor(1);
      }
      ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = backgroundExecutor;
      AppMethodBeat.o(7782);
      return localScheduledThreadPoolExecutor;
    }
    finally {}
  }
  
  private void showDialog(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7777);
    DeviceAuthDialog localDeviceAuthDialog = createDeviceAuthDialog();
    localDeviceAuthDialog.show(this.loginClient.getActivity().getSupportFragmentManager(), "login_with_facebook");
    localDeviceAuthDialog.startLogin(paramRequest);
    AppMethodBeat.o(7777);
  }
  
  protected DeviceAuthDialog createDeviceAuthDialog()
  {
    AppMethodBeat.i(7778);
    DeviceAuthDialog localDeviceAuthDialog = new DeviceAuthDialog();
    AppMethodBeat.o(7778);
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
    AppMethodBeat.i(7779);
    LoginClient.Result localResult = LoginClient.Result.createCancelResult(this.loginClient.getPendingRequest(), "User canceled log in.");
    this.loginClient.completeAndValidate(localResult);
    AppMethodBeat.o(7779);
  }
  
  public void onError(Exception paramException)
  {
    AppMethodBeat.i(7780);
    paramException = LoginClient.Result.createErrorResult(this.loginClient.getPendingRequest(), null, paramException.getMessage());
    this.loginClient.completeAndValidate(paramException);
    AppMethodBeat.o(7780);
  }
  
  public void onSuccess(String paramString1, String paramString2, String paramString3, Collection<String> paramCollection1, Collection<String> paramCollection2, AccessTokenSource paramAccessTokenSource, Date paramDate1, Date paramDate2, Date paramDate3)
  {
    AppMethodBeat.i(7781);
    paramString1 = new AccessToken(paramString1, paramString2, paramString3, paramCollection1, paramCollection2, paramAccessTokenSource, paramDate1, paramDate2, paramDate3);
    paramString1 = LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), paramString1);
    this.loginClient.completeAndValidate(paramString1);
    AppMethodBeat.o(7781);
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7776);
    showDialog(paramRequest);
    AppMethodBeat.o(7776);
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(7783);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(7783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.DeviceAuthMethodHandler
 * JD-Core Version:    0.7.0.1
 */