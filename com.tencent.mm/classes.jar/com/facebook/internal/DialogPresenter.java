package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public class DialogPresenter
{
  public static boolean canPresentNativeDialogWithFeature(DialogFeature paramDialogFeature)
  {
    AppMethodBeat.i(96619);
    if (getProtocolVersionForNativeDialog(paramDialogFeature).getProtocolVersion() != -1)
    {
      AppMethodBeat.o(96619);
      return true;
    }
    AppMethodBeat.o(96619);
    return false;
  }
  
  public static boolean canPresentWebFallbackDialogWithFeature(DialogFeature paramDialogFeature)
  {
    AppMethodBeat.i(96620);
    if (getDialogWebFallbackUri(paramDialogFeature) != null)
    {
      AppMethodBeat.o(96620);
      return true;
    }
    AppMethodBeat.o(96620);
    return false;
  }
  
  private static Uri getDialogWebFallbackUri(DialogFeature paramDialogFeature)
  {
    AppMethodBeat.i(96625);
    Object localObject = paramDialogFeature.name();
    paramDialogFeature = paramDialogFeature.getAction();
    localObject = FetchedAppSettings.getDialogFeatureConfig(FacebookSdk.getApplicationId(), paramDialogFeature, (String)localObject);
    paramDialogFeature = null;
    if (localObject != null) {
      paramDialogFeature = ((FetchedAppSettings.DialogFeatureConfig)localObject).getFallbackUrl();
    }
    AppMethodBeat.o(96625);
    return paramDialogFeature;
  }
  
  public static NativeProtocol.ProtocolVersionQueryResult getProtocolVersionForNativeDialog(DialogFeature paramDialogFeature)
  {
    AppMethodBeat.i(96626);
    String str1 = FacebookSdk.getApplicationId();
    String str2 = paramDialogFeature.getAction();
    paramDialogFeature = NativeProtocol.getLatestAvailableProtocolVersionForAction(str2, getVersionSpecForFeature(str1, str2, paramDialogFeature));
    AppMethodBeat.o(96626);
    return paramDialogFeature;
  }
  
  private static int[] getVersionSpecForFeature(String paramString1, String paramString2, DialogFeature paramDialogFeature)
  {
    AppMethodBeat.i(96627);
    paramString1 = FetchedAppSettings.getDialogFeatureConfig(paramString1, paramString2, paramDialogFeature.name());
    if (paramString1 != null)
    {
      paramString1 = paramString1.getVersionSpec();
      AppMethodBeat.o(96627);
      return paramString1;
    }
    int i = paramDialogFeature.getMinVersion();
    AppMethodBeat.o(96627);
    return new int[] { i };
  }
  
  public static void logDialogActivity(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(96628);
    paramContext = AppEventsLogger.newLogger(paramContext);
    Bundle localBundle = new Bundle();
    localBundle.putString("fb_dialog_outcome", paramString2);
    paramContext.logSdkEvent(paramString1, null, localBundle);
    AppMethodBeat.o(96628);
  }
  
  public static void present(AppCall paramAppCall, Activity paramActivity)
  {
    AppMethodBeat.i(96617);
    paramActivity.startActivityForResult(paramAppCall.getRequestIntent(), paramAppCall.getRequestCode());
    paramAppCall.setPending();
    AppMethodBeat.o(96617);
  }
  
  public static void present(AppCall paramAppCall, FragmentWrapper paramFragmentWrapper)
  {
    AppMethodBeat.i(96618);
    paramFragmentWrapper.startActivityForResult(paramAppCall.getRequestIntent(), paramAppCall.getRequestCode());
    paramAppCall.setPending();
    AppMethodBeat.o(96618);
  }
  
  public static void setupAppCallForCannotShowError(AppCall paramAppCall)
  {
    AppMethodBeat.i(96615);
    setupAppCallForValidationError(paramAppCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    AppMethodBeat.o(96615);
  }
  
  public static void setupAppCallForErrorResult(AppCall paramAppCall, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(96621);
    if (paramFacebookException == null)
    {
      AppMethodBeat.o(96621);
      return;
    }
    Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
    Intent localIntent = new Intent();
    localIntent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    localIntent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
    NativeProtocol.setupProtocolRequestIntent(localIntent, paramAppCall.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(paramFacebookException));
    paramAppCall.setRequestIntent(localIntent);
    AppMethodBeat.o(96621);
  }
  
  public static void setupAppCallForNativeDialog(AppCall paramAppCall, DialogPresenter.ParameterProvider paramParameterProvider, DialogFeature paramDialogFeature)
  {
    AppMethodBeat.i(96624);
    Context localContext = FacebookSdk.getApplicationContext();
    String str = paramDialogFeature.getAction();
    NativeProtocol.ProtocolVersionQueryResult localProtocolVersionQueryResult = getProtocolVersionForNativeDialog(paramDialogFeature);
    int i = localProtocolVersionQueryResult.getProtocolVersion();
    if (i == -1)
    {
      paramAppCall = new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
      AppMethodBeat.o(96624);
      throw paramAppCall;
    }
    if (NativeProtocol.isVersionCompatibleWithBucketedIntent(i)) {}
    for (paramParameterProvider = paramParameterProvider.getParameters();; paramParameterProvider = paramParameterProvider.getLegacyParameters())
    {
      paramDialogFeature = paramParameterProvider;
      if (paramParameterProvider == null) {
        paramDialogFeature = new Bundle();
      }
      paramParameterProvider = NativeProtocol.createPlatformActivityIntent(localContext, paramAppCall.getCallId().toString(), str, localProtocolVersionQueryResult, paramDialogFeature);
      if (paramParameterProvider != null) {
        break;
      }
      paramAppCall = new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
      AppMethodBeat.o(96624);
      throw paramAppCall;
    }
    paramAppCall.setRequestIntent(paramParameterProvider);
    AppMethodBeat.o(96624);
  }
  
  public static void setupAppCallForValidationError(AppCall paramAppCall, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(96616);
    setupAppCallForErrorResult(paramAppCall, paramFacebookException);
    AppMethodBeat.o(96616);
  }
  
  public static void setupAppCallForWebDialog(AppCall paramAppCall, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(96622);
    Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
    Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
    Bundle localBundle = new Bundle();
    localBundle.putString("action", paramString);
    localBundle.putBundle("params", paramBundle);
    paramBundle = new Intent();
    NativeProtocol.setupProtocolRequestIntent(paramBundle, paramAppCall.getCallId().toString(), paramString, NativeProtocol.getLatestKnownVersion(), localBundle);
    paramBundle.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
    paramBundle.setAction("FacebookDialogFragment");
    paramAppCall.setRequestIntent(paramBundle);
    AppMethodBeat.o(96622);
  }
  
  public static void setupAppCallForWebFallbackDialog(AppCall paramAppCall, Bundle paramBundle, DialogFeature paramDialogFeature)
  {
    AppMethodBeat.i(96623);
    Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
    Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
    String str = paramDialogFeature.name();
    Object localObject = getDialogWebFallbackUri(paramDialogFeature);
    if (localObject == null)
    {
      paramAppCall = new FacebookException("Unable to fetch the Url for the DialogFeature : '" + str + "'");
      AppMethodBeat.o(96623);
      throw paramAppCall;
    }
    int i = NativeProtocol.getLatestKnownVersion();
    paramBundle = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(paramAppCall.getCallId().toString(), i, paramBundle);
    if (paramBundle == null)
    {
      paramAppCall = new FacebookException("Unable to fetch the app's key-hash");
      AppMethodBeat.o(96623);
      throw paramAppCall;
    }
    if (((Uri)localObject).isRelative()) {}
    for (paramBundle = Utility.buildUri(ServerProtocol.getDialogAuthority(), ((Uri)localObject).toString(), paramBundle);; paramBundle = Utility.buildUri(((Uri)localObject).getAuthority(), ((Uri)localObject).getPath(), paramBundle))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("url", paramBundle.toString());
      ((Bundle)localObject).putBoolean("is_fallback", true);
      paramBundle = new Intent();
      NativeProtocol.setupProtocolRequestIntent(paramBundle, paramAppCall.getCallId().toString(), paramDialogFeature.getAction(), NativeProtocol.getLatestKnownVersion(), (Bundle)localObject);
      paramBundle.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
      paramBundle.setAction("FacebookDialogFragment");
      paramAppCall.setRequestIntent(paramBundle);
      AppMethodBeat.o(96623);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.DialogPresenter
 * JD-Core Version:    0.7.0.1
 */