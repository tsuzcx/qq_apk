package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.fragment.app.Fragment;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import java.util.Collection;

abstract class NativeAppLoginMethodHandler
  extends LoginMethodHandler
{
  NativeAppLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  NativeAppLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
  }
  
  private String getError(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("error");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString("error_type");
    }
    return str1;
  }
  
  private String getErrorMessage(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("error_message");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramBundle.getString("error_description");
    }
    return str1;
  }
  
  private LoginClient.Result handleResultCancel(LoginClient.Request paramRequest, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    String str = getError(localBundle);
    if (localBundle.get("error_code") != null) {}
    for (paramIntent = localBundle.get("error_code").toString(); "CONNECTION_FAILURE".equals(paramIntent); paramIntent = null) {
      return LoginClient.Result.createErrorResult(paramRequest, str, getErrorMessage(localBundle), paramIntent);
    }
    return LoginClient.Result.createCancelResult(paramRequest, str);
  }
  
  private LoginClient.Result handleResultOk(LoginClient.Request paramRequest, Intent paramIntent)
  {
    LoginClient.Result localResult = null;
    Bundle localBundle = paramIntent.getExtras();
    String str1 = getError(localBundle);
    String str2;
    if (localBundle.get("error_code") != null)
    {
      paramIntent = localBundle.get("error_code").toString();
      str2 = getErrorMessage(localBundle);
      String str3 = localBundle.getString("e2e");
      if (!Utility.isNullOrEmpty(str3)) {
        logWebLoginCompleted(str3);
      }
      if ((str1 != null) || (paramIntent != null) || (str2 != null)) {
        break label121;
      }
    }
    label121:
    while (ServerProtocol.errorsProxyAuthDisabled.contains(str1))
    {
      try
      {
        localResult = LoginClient.Result.createTokenResult(paramRequest, createAccessTokenFromWebBundle(paramRequest.getPermissions(), localBundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, paramRequest.getApplicationId()));
        return localResult;
      }
      catch (FacebookException paramIntent)
      {
        return LoginClient.Result.createErrorResult(paramRequest, null, paramIntent.getMessage());
      }
      paramIntent = null;
      break;
    }
    if (ServerProtocol.errorsUserCanceled.contains(str1)) {
      return LoginClient.Result.createCancelResult(paramRequest, null);
    }
    return LoginClient.Result.createErrorResult(paramRequest, str1, str2, paramIntent);
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    LoginClient.Request localRequest = this.loginClient.getPendingRequest();
    if (paramIntent == null)
    {
      paramIntent = LoginClient.Result.createCancelResult(localRequest, "Operation canceled");
      if (paramIntent == null) {
        break label78;
      }
      this.loginClient.completeAndValidate(paramIntent);
    }
    for (;;)
    {
      return true;
      if (paramInt2 == 0)
      {
        paramIntent = handleResultCancel(localRequest, paramIntent);
        break;
      }
      if (paramInt2 != -1)
      {
        paramIntent = LoginClient.Result.createErrorResult(localRequest, "Unexpected resultCode from authorization.", null);
        break;
      }
      paramIntent = handleResultOk(localRequest, paramIntent);
      break;
      label78:
      this.loginClient.tryNextHandler();
    }
  }
  
  abstract boolean tryAuthorize(LoginClient.Request paramRequest);
  
  protected boolean tryIntent(Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {
      return false;
    }
    try
    {
      this.loginClient.getFragment().startActivityForResult(paramIntent, paramInt);
      return true;
    }
    catch (ActivityNotFoundException paramIntent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.NativeAppLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */