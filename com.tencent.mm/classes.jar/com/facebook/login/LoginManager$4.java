package com.facebook.login;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Date;

class LoginManager$4
  implements PlatformServiceClient.CompletedListener
{
  LoginManager$4(LoginManager paramLoginManager, String paramString1, LoginLogger paramLoginLogger, LoginStatusCallback paramLoginStatusCallback, String paramString2) {}
  
  public void completed(Bundle paramBundle)
  {
    AppMethodBeat.i(96873);
    String str;
    Date localDate1;
    ArrayList localArrayList;
    Date localDate2;
    if (paramBundle != null)
    {
      localObject = paramBundle.getString("com.facebook.platform.status.ERROR_TYPE");
      str = paramBundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
      if (localObject != null)
      {
        LoginManager.access$100((String)localObject, str, this.val$loggerRef, this.val$logger, this.val$responseCallback);
        AppMethodBeat.o(96873);
        return;
      }
      str = paramBundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
      localDate1 = Utility.getBundleLongAsDate(paramBundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
      localArrayList = paramBundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
      localObject = paramBundle.getString("signed request");
      localDate2 = Utility.getBundleLongAsDate(paramBundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
      if (Utility.isNullOrEmpty((String)localObject)) {
        break label268;
      }
    }
    label268:
    for (Object localObject = LoginMethodHandler.getUserIDFromSignedRequest((String)localObject);; localObject = null)
    {
      if ((!Utility.isNullOrEmpty(str)) && (localArrayList != null) && (!localArrayList.isEmpty()) && (!Utility.isNullOrEmpty((String)localObject)))
      {
        localObject = new AccessToken(str, this.val$applicationId, (String)localObject, localArrayList, null, null, localDate1, null, localDate2);
        AccessToken.setCurrentAccessToken((AccessToken)localObject);
        paramBundle = LoginManager.access$200(paramBundle);
        if (paramBundle != null) {
          Profile.setCurrentProfile(paramBundle);
        }
        for (;;)
        {
          this.val$logger.logLoginStatusSuccess(this.val$loggerRef);
          this.val$responseCallback.onCompleted((AccessToken)localObject);
          AppMethodBeat.o(96873);
          return;
          Profile.fetchProfileForCurrentAccessToken();
        }
      }
      this.val$logger.logLoginStatusFailure(this.val$loggerRef);
      this.val$responseCallback.onFailure();
      AppMethodBeat.o(96873);
      return;
      this.val$logger.logLoginStatusFailure(this.val$loggerRef);
      this.val$responseCallback.onFailure();
      AppMethodBeat.o(96873);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.login.LoginManager.4
 * JD-Core Version:    0.7.0.1
 */