package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler
  extends WebLoginMethodHandler
{
  private static final int API_EC_DIALOG_CANCEL = 4201;
  private static final int CHALLENGE_LENGTH = 20;
  private static final String[] CHROME_PACKAGES;
  public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR;
  private static final String CUSTOM_TABS_SERVICE_ACTION = "android.support.customtabs.action.CustomTabsService";
  private static final int CUSTOM_TAB_REQUEST_CODE = 1;
  private String currentPackage;
  private String expectedChallenge;
  
  static
  {
    AppMethodBeat.i(96710);
    CHROME_PACKAGES = new String[] { "com.android.chrome", "com.chrome.beta", "com.chrome.dev" };
    CREATOR = new CustomTabLoginMethodHandler.1();
    AppMethodBeat.o(96710);
  }
  
  CustomTabLoginMethodHandler(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(96708);
    this.expectedChallenge = paramParcel.readString();
    AppMethodBeat.o(96708);
  }
  
  CustomTabLoginMethodHandler(LoginClient paramLoginClient)
  {
    super(paramLoginClient);
    AppMethodBeat.i(96698);
    this.expectedChallenge = Utility.generateRandomString(20);
    AppMethodBeat.o(96698);
  }
  
  private String getChromePackage()
  {
    AppMethodBeat.i(96702);
    if (this.currentPackage != null)
    {
      localObject1 = this.currentPackage;
      AppMethodBeat.o(96702);
      return localObject1;
    }
    Object localObject1 = this.loginClient.getActivity();
    Object localObject2 = new Intent("android.support.customtabs.action.CustomTabsService");
    localObject2 = ((Context)localObject1).getPackageManager().queryIntentServices((Intent)localObject2, 0);
    if (localObject2 != null)
    {
      localObject1 = new HashSet(Arrays.asList(CHROME_PACKAGES));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ServiceInfo localServiceInfo = ((ResolveInfo)((Iterator)localObject2).next()).serviceInfo;
        if ((localServiceInfo != null) && (((Set)localObject1).contains(localServiceInfo.packageName)))
        {
          this.currentPackage = localServiceInfo.packageName;
          localObject1 = this.currentPackage;
          AppMethodBeat.o(96702);
          return localObject1;
        }
      }
    }
    AppMethodBeat.o(96702);
    return null;
  }
  
  private boolean isCustomTabsAllowed()
  {
    AppMethodBeat.i(96700);
    if ((isCustomTabsEnabled()) && (getChromePackage() != null) && (isCustomTabsCompatibleWithAutofill()) && (Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext())))
    {
      AppMethodBeat.o(96700);
      return true;
    }
    AppMethodBeat.o(96700);
    return false;
  }
  
  private boolean isCustomTabsCompatibleWithAutofill()
  {
    AppMethodBeat.i(96703);
    if (!Utility.isAutofillAvailable(this.loginClient.getActivity()))
    {
      AppMethodBeat.o(96703);
      return true;
    }
    AppMethodBeat.o(96703);
    return false;
  }
  
  private boolean isCustomTabsEnabled()
  {
    AppMethodBeat.i(96701);
    FetchedAppSettings localFetchedAppSettings = FetchedAppSettingsManager.getAppSettingsWithoutQuery(Utility.getMetadataApplicationId(this.loginClient.getActivity()));
    if ((localFetchedAppSettings != null) && (localFetchedAppSettings.getCustomTabsEnabled()))
    {
      AppMethodBeat.o(96701);
      return true;
    }
    AppMethodBeat.o(96701);
    return false;
  }
  
  private void onCustomTabComplete(String paramString, LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96705);
    Bundle localBundle;
    String str1;
    String str2;
    if ((paramString != null) && (paramString.startsWith(CustomTabMainActivity.getRedirectUrl())))
    {
      paramString = Uri.parse(paramString);
      localBundle = Utility.parseUrlQueryString(paramString.getQuery());
      localBundle.putAll(Utility.parseUrlQueryString(paramString.getFragment()));
      if (!validateChallengeParam(localBundle))
      {
        super.onComplete(paramRequest, null, new FacebookException("Invalid state parameter"));
        AppMethodBeat.o(96705);
        return;
      }
      paramString = localBundle.getString("error");
      str1 = paramString;
      if (paramString == null) {
        str1 = localBundle.getString("error_type");
      }
      str2 = localBundle.getString("error_msg");
      paramString = str2;
      if (str2 == null) {
        paramString = localBundle.getString("error_message");
      }
      str2 = paramString;
      if (paramString == null) {
        str2 = localBundle.getString("error_description");
      }
      paramString = localBundle.getString("error_code");
      if (Utility.isNullOrEmpty(paramString)) {
        break label307;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString);
        if ((Utility.isNullOrEmpty(str1)) && (Utility.isNullOrEmpty(str2)) && (i == -1))
        {
          super.onComplete(paramRequest, localBundle, null);
          AppMethodBeat.o(96705);
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        i = -1;
        continue;
        if ((str1 != null) && ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException"))))
        {
          super.onComplete(paramRequest, null, new FacebookOperationCanceledException());
          AppMethodBeat.o(96705);
          return;
        }
        if (i == 4201)
        {
          super.onComplete(paramRequest, null, new FacebookOperationCanceledException());
          AppMethodBeat.o(96705);
          return;
        }
        super.onComplete(paramRequest, null, new FacebookServiceException(new FacebookRequestError(i, str1, str2), str2));
      }
      AppMethodBeat.o(96705);
      return;
      label307:
      int i = -1;
    }
  }
  
  private boolean validateChallengeParam(Bundle paramBundle)
  {
    AppMethodBeat.i(96707);
    try
    {
      paramBundle = paramBundle.getString("state");
      if (paramBundle == null)
      {
        AppMethodBeat.o(96707);
        return false;
      }
      boolean bool = new JSONObject(paramBundle).getString("7_challenge").equals(this.expectedChallenge);
      AppMethodBeat.o(96707);
      return bool;
    }
    catch (JSONException paramBundle)
    {
      AppMethodBeat.o(96707);
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  String getNameForLogging()
  {
    return "custom_tab";
  }
  
  protected String getSSODevice()
  {
    return "chrome_custom_tab";
  }
  
  AccessTokenSource getTokenSource()
  {
    return AccessTokenSource.CHROME_CUSTOM_TAB;
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(96704);
    if (paramInt1 != 1)
    {
      boolean bool = super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(96704);
      return bool;
    }
    LoginClient.Request localRequest = this.loginClient.getPendingRequest();
    if (paramInt2 == -1)
    {
      onCustomTabComplete(paramIntent.getStringExtra(CustomTabMainActivity.EXTRA_URL), localRequest);
      AppMethodBeat.o(96704);
      return true;
    }
    super.onComplete(localRequest, null, new FacebookOperationCanceledException());
    AppMethodBeat.o(96704);
    return false;
  }
  
  protected void putChallengeParam(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96706);
    paramJSONObject.put("7_challenge", this.expectedChallenge);
    AppMethodBeat.o(96706);
  }
  
  boolean tryAuthorize(LoginClient.Request paramRequest)
  {
    AppMethodBeat.i(96699);
    if (!isCustomTabsAllowed())
    {
      AppMethodBeat.o(96699);
      return false;
    }
    paramRequest = addExtraParameters(getParameters(paramRequest), paramRequest);
    Intent localIntent = new Intent(this.loginClient.getActivity(), CustomTabMainActivity.class);
    localIntent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, paramRequest);
    localIntent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
    this.loginClient.getFragment().startActivityForResult(localIntent, 1);
    AppMethodBeat.o(96699);
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96709);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.expectedChallenge);
    AppMethodBeat.o(96709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.CustomTabLoginMethodHandler
 * JD-Core Version:    0.7.0.1
 */