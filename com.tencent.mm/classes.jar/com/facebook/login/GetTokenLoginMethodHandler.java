package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class GetTokenLoginMethodHandler
  extends LoginMethodHandler
{
  public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR;
  private GetTokenClient getTokenClient;
  
  static
  {
    AppMethodBeat.i(7803);
    CREATOR = new GetTokenLoginMethodHandler.3();
    AppMethodBeat.o(7803);
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
    AppMethodBeat.i(7797);
    if (this.getTokenClient != null)
    {
      this.getTokenClient.cancel();
      this.getTokenClient.setCompletedListener(null);
      this.getTokenClient = null;
    }
    AppMethodBeat.o(7797);
  }
  
  void complete(final LoginClient.Request paramRequest, final Bundle paramBundle)
  {
    AppMethodBeat.i(7801);
    String str = paramBundle.getString("com.facebook.platform.extra.USER_ID");
    if ((str == null) || (str.isEmpty()))
    {
      this.loginClient.notifyBackgroundProcessingStart();
      Utility.getGraphMeRequestWithCacheAsync(paramBundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new Utility.GraphMeRequestWithCacheCallback()
      {
        public void onFailure(FacebookException paramAnonymousFacebookException)
        {
          AppMethodBeat.i(7793);
          GetTokenLoginMethodHandler.this.loginClient.complete(LoginClient.Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient.getPendingRequest(), "Caught exception", paramAnonymousFacebookException.getMessage()));
          AppMethodBeat.o(7793);
        }
        
        public void onSuccess(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(7792);
          try
          {
            paramAnonymousJSONObject = paramAnonymousJSONObject.getString("id");
            paramBundle.putString("com.facebook.platform.extra.USER_ID", paramAnonymousJSONObject);
            GetTokenLoginMethodHandler.this.onComplete(paramRequest, paramBundle);
            AppMethodBeat.o(7792);
            return;
          }
          catch (JSONException paramAnonymousJSONObject)
          {
            GetTokenLoginMethodHandler.this.loginClient.complete(LoginClient.Result.createErrorResult(GetTokenLoginMethodHandler.this.loginClient.getPendingRequest(), "Caught exception", paramAnonymousJSONObject.getMessage()));
            AppMethodBeat.o(7792);
          }
        }
      });
      AppMethodBeat.o(7801);
      return;
    }
    onComplete(paramRequest, paramBundle);
    AppMethodBeat.o(7801);
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
    AppMethodBeat.i(7799);
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
        AppMethodBeat.o(7799);
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
    AppMethodBeat.o(7799);
  }
  
  void onComplete(LoginClient.Request paramRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(7800);
    paramRequest = createAccessTokenFromNativeLogin(paramBundle, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, paramRequest.getApplicationId());
    paramRequest = LoginClient.Result.createTokenResult(this.loginClient.getPendingRequest(), paramRequest);
    this.loginClient.completeAndValidate(paramRequest);
    AppMethodBeat.o(7800);
  }
  
  boolean tryAuthorize(final LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(7798);
    this.getTokenClient = new GetTokenClient(this.loginClient.getActivity(), paramRequest.getApplicationId());
    if (!this.getTokenClient.start())
    {
      AppMethodBeat.o(7798);
      return false;
    }
    this.loginClient.notifyBackgroundProcessingStart();
    paramRequest = new PlatformServiceClient.CompletedListener()
    {
      public void completed(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(7791);
        GetTokenLoginMethodHandler.this.getTokenCompleted(paramRequest, paramAnonymousBundle);
        AppMethodBeat.o(7791);
      }
    };
    this.getTokenClient.setCompletedListener(paramRequest);
    AppMethodBeat.o(7798);
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(7802);
    super.writeToParcel(paramParcel, paramInt);
    AppMethodBeat.o(7802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.GetTokenLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */