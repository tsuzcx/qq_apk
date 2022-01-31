package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class GetTokenLoginMethodHandler
  extends LoginMethodHandler
{
  public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR;
  private GetTokenClient getTokenClient;
  
  static
  {
    AppMethodBeat.i(96779);
    CREATOR = new GetTokenLoginMethodHandler.3();
    AppMethodBeat.o(96779);
  }
  
  GetTokenLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  GetTokenLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  void cancel()
  {
    AppMethodBeat.i(96773);
    if (this.getTokenClient != null)
    {
      this.getTokenClient.cancel();
      this.getTokenClient.setCompletedListener(null);
      this.getTokenClient = null;
    }
    AppMethodBeat.o(96773);
  }
  
  void complete(LoginClient.Request paramRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(96777);
    String str = paramBundle.getString("com.facebook.platform.extra.USER_ID");
    if ((str == null) || (str.isEmpty()))
    {
      this.loginClient.notifyBackgroundProcessingStart();
      Utility.getGraphMeRequestWithCacheAsync(paramBundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new GetTokenLoginMethodHandler.2(this, paramBundle, paramRequest));
      AppMethodBeat.o(96777);
      return;
    }
    onComplete(paramRequest, paramBundle);
    AppMethodBeat.o(96777);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getNameForLogging()
  {
    return "get_token";
  }
  
  void getTokenCompleted(LoginClient.Request paramRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(96775);
    if (this.getTokenClient != null) {
      this.getTokenClient.setCompletedListener(null);
    }
    this.getTokenClient = null;
    this.loginClient.notifyBackgroundProcessingStop();
    if (paramBundle != null)
    {
      ArrayList localArrayList = paramBundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
      Object localObject = paramRequest.getPermissions();
      if ((localArrayList != null) && ((localObject == null) || (localArrayList.containsAll((Collection)localObject))))
      {
        complete(paramRequest, paramBundle);
        AppMethodBeat.o(96775);
        return;
      }
      paramBundle = new HashSet();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!localArrayList.contains(str)) {
          paramBundle.add(str);
        }
      }
      if (!paramBundle.isEmpty()) {
        addLoggingExtra("new_permissions", TextUtils.join(",", paramBundle));
      }
      paramRequest.setPermissions(paramBundle);
    }
    this.loginClient.tryNextHandler();
    AppMethodBeat.o(96775);
  }
  
  void onComplete(LoginClient.Request paramRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(96776);
    paramRequest = createAccessTokenFromNativeLogin(paramBundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, paramRequest.getApplicationId());
    paramRequest = LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), paramRequest);
    this.loginClient.completeAndValidate(paramRequest);
    AppMethodBeat.o(96776);
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96774);
    this.getTokenClient = new GetTokenClient(this.loginClient.getActivity(), paramRequest.getApplicationId());
    if (!this.getTokenClient.start())
    {
      AppMethodBeat.o(96774);
      return false;
    }
    this.loginClient.notifyBackgroundProcessingStart();
    paramRequest = new GetTokenLoginMethodHandler.1(this, paramRequest);
    this.getTokenClient.setCompletedListener(paramRequest);
    AppMethodBeat.o(96774);
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96778);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(96778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.login.GetTokenLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */