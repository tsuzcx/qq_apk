package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

class AccessTokenManager$4
  implements GraphRequestBatch.Callback
{
  AccessTokenManager$4(AccessTokenManager paramAccessTokenManager, AccessToken paramAccessToken, AccessToken.AccessTokenRefreshCallback paramAccessTokenRefreshCallback, AtomicBoolean paramAtomicBoolean, AccessTokenManager.RefreshResult paramRefreshResult, Set paramSet1, Set paramSet2) {}
  
  public void onBatchCompleted(GraphRequestBatch paramGraphRequestBatch)
  {
    AppMethodBeat.i(71553);
    Object localObject;
    for (;;)
    {
      try
      {
        if ((AccessTokenManager.getInstance().getCurrentAccessToken() == null) || (AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != this.val$accessToken.getUserId()))
        {
          if (this.val$callback != null) {
            this.val$callback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
          }
          AccessTokenManager.access$200(this.this$0).set(false);
          AppMethodBeat.o(71553);
          return;
        }
        if ((!this.val$permissionsCallSucceeded.get()) && (this.val$refreshResult.accessToken == null) && (this.val$refreshResult.expiresAt == 0))
        {
          if (this.val$callback != null) {
            this.val$callback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
          }
          AccessTokenManager.access$200(this.this$0).set(false);
          AppMethodBeat.o(71553);
          return;
        }
        if (this.val$refreshResult.accessToken != null)
        {
          paramGraphRequestBatch = this.val$refreshResult.accessToken;
          String str1 = this.val$accessToken.getApplicationId();
          String str2 = this.val$accessToken.getUserId();
          if (!this.val$permissionsCallSucceeded.get()) {
            continue;
          }
          localObject = this.val$permissions;
          if (!this.val$permissionsCallSucceeded.get()) {
            continue;
          }
          localSet = this.val$declinedPermissions;
          AccessTokenSource localAccessTokenSource = this.val$accessToken.getSource();
          if (this.val$refreshResult.expiresAt == 0) {
            continue;
          }
          localDate1 = new Date(this.val$refreshResult.expiresAt * 1000L);
          Date localDate3 = new Date();
          if (this.val$refreshResult.dataAccessExpirationTime == null) {
            continue;
          }
          localDate2 = new Date(this.val$refreshResult.dataAccessExpirationTime.longValue() * 1000L);
          localObject = new AccessToken(paramGraphRequestBatch, str1, str2, (Collection)localObject, localSet, localAccessTokenSource, localDate1, localDate3, localDate2);
        }
      }
      finally
      {
        Set localSet;
        Date localDate1;
        Date localDate2;
        localObject = null;
      }
      try
      {
        AccessTokenManager.getInstance().setCurrentAccessToken((AccessToken)localObject);
        AccessTokenManager.access$200(this.this$0).set(false);
        if (this.val$callback == null) {
          break label458;
        }
        this.val$callback.OnTokenRefreshed((AccessToken)localObject);
        AppMethodBeat.o(71553);
        return;
      }
      finally
      {
        break;
      }
      paramGraphRequestBatch = this.val$accessToken.getToken();
      continue;
      localObject = this.val$accessToken.getPermissions();
      continue;
      localSet = this.val$accessToken.getDeclinedPermissions();
      continue;
      localDate1 = this.val$accessToken.getExpires();
      continue;
      localDate2 = this.val$accessToken.getDataAccessExpirationTime();
    }
    AccessTokenManager.access$200(this.this$0).set(false);
    if ((this.val$callback != null) && (localObject != null)) {
      this.val$callback.OnTokenRefreshed((AccessToken)localObject);
    }
    AppMethodBeat.o(71553);
    throw paramGraphRequestBatch;
    label458:
    AppMethodBeat.o(71553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.AccessTokenManager.4
 * JD-Core Version:    0.7.0.1
 */