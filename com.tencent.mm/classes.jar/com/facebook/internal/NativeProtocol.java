package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeProtocol
{
  public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
  public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
  public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
  public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
  public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
  public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
  public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
  public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
  public static final String AUDIENCE_EVERYONE = "everyone";
  public static final String AUDIENCE_FRIENDS = "friends";
  public static final String AUDIENCE_ME = "only_me";
  public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
  public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
  public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
  public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
  public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
  public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
  public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
  public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
  private static final String CONTENT_SCHEME = "content://";
  public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
  public static final String ERROR_NETWORK_ERROR = "NetworkError";
  public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
  public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
  public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
  public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
  public static final String ERROR_USER_CANCELED = "UserCanceled";
  public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
  public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
  public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
  public static final String EXTRA_ARGS_PROFILE = "com.facebook.platform.extra.PROFILE";
  public static final String EXTRA_ARGS_PROFILE_FIRST_NAME = "com.facebook.platform.extra.PROFILE_FIRST_NAME";
  public static final String EXTRA_ARGS_PROFILE_LAST_NAME = "com.facebook.platform.extra.PROFILE_LAST_NAME";
  public static final String EXTRA_ARGS_PROFILE_LINK = "com.facebook.platform.extra.PROFILE_LINK";
  public static final String EXTRA_ARGS_PROFILE_MIDDLE_NAME = "com.facebook.platform.extra.PROFILE_MIDDLE_NAME";
  public static final String EXTRA_ARGS_PROFILE_NAME = "com.facebook.platform.extra.PROFILE_NAME";
  public static final String EXTRA_ARGS_PROFILE_USER_ID = "com.facebook.platform.extra.PROFILE_USER_ID";
  public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
  public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
  public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
  public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
  public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
  public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
  public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
  public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
  public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
  public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
  public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
  public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
  public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
  public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
  static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
  public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
  public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
  private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
  public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
  public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
  public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
  public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
  private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
  public static final String IMAGE_URL_KEY = "url";
  public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
  static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
  static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
  private static final List<Integer> KNOWN_PROTOCOL_VERSIONS;
  public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
  public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
  public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
  public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
  public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
  public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
  public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
  public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
  public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
  public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
  static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
  public static final int NO_PROTOCOL_AVAILABLE = -1;
  public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
  private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
  private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
  private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
  public static final int PROTOCOL_VERSION_20121101 = 20121101;
  public static final int PROTOCOL_VERSION_20130502 = 20130502;
  public static final int PROTOCOL_VERSION_20130618 = 20130618;
  public static final int PROTOCOL_VERSION_20131107 = 20131107;
  public static final int PROTOCOL_VERSION_20140204 = 20140204;
  public static final int PROTOCOL_VERSION_20140324 = 20140324;
  public static final int PROTOCOL_VERSION_20140701 = 20140701;
  public static final int PROTOCOL_VERSION_20141001 = 20141001;
  public static final int PROTOCOL_VERSION_20141028 = 20141028;
  public static final int PROTOCOL_VERSION_20141107 = 20141107;
  public static final int PROTOCOL_VERSION_20141218 = 20141218;
  public static final int PROTOCOL_VERSION_20160327 = 20160327;
  public static final int PROTOCOL_VERSION_20170213 = 20170213;
  public static final int PROTOCOL_VERSION_20170411 = 20170411;
  public static final int PROTOCOL_VERSION_20170417 = 20170417;
  public static final int PROTOCOL_VERSION_20171115 = 20171115;
  public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
  public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
  public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
  public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
  public static final String RESULT_ARGS_PERMISSIONS = "permissions";
  public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
  public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
  public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
  public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
  public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
  public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
  private static final String TAG;
  public static final String WEB_DIALOG_ACTION = "action";
  public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
  public static final String WEB_DIALOG_PARAMS = "params";
  public static final String WEB_DIALOG_URL = "url";
  private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;
  private static final List<NativeAppInfo> effectCameraAppInfoList;
  private static final List<NativeAppInfo> facebookAppInfoList;
  private static final AtomicBoolean protocolVersionsAsyncUpdating;
  
  static
  {
    AppMethodBeat.i(17908);
    TAG = NativeProtocol.class.getName();
    facebookAppInfoList = buildFacebookAppList();
    effectCameraAppInfoList = buildEffectCameraAppInfoList();
    actionToAppInfoMap = buildActionToAppInfoMap();
    protocolVersionsAsyncUpdating = new AtomicBoolean(false);
    KNOWN_PROTOCOL_VERSIONS = Arrays.asList(new Integer[] { Integer.valueOf(20170417), Integer.valueOf(20160327), Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101) });
    AppMethodBeat.o(17908);
  }
  
  private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap()
  {
    AppMethodBeat.i(17878);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new MessengerAppInfo(null));
    localHashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.FEED_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", facebookAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", localArrayList);
    localHashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", localArrayList);
    localHashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", effectCameraAppInfoList);
    localHashMap.put("com.facebook.platform.action.request.SHARE_STORY", facebookAppInfoList);
    AppMethodBeat.o(17878);
    return localHashMap;
  }
  
  private static List<NativeAppInfo> buildEffectCameraAppInfoList()
  {
    AppMethodBeat.i(17877);
    ArrayList localArrayList = new ArrayList(buildFacebookAppList());
    localArrayList.add(0, new EffectTestAppInfo(null));
    AppMethodBeat.o(17877);
    return localArrayList;
  }
  
  private static List<NativeAppInfo> buildFacebookAppList()
  {
    AppMethodBeat.i(17876);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KatanaAppInfo(null));
    localArrayList.add(new WakizashiAppInfo(null));
    AppMethodBeat.o(17876);
    return localArrayList;
  }
  
  private static Uri buildPlatformProviderVersionURI(NativeAppInfo paramNativeAppInfo)
  {
    AppMethodBeat.i(17906);
    paramNativeAppInfo = Uri.parse("content://" + paramNativeAppInfo.getPackage() + ".provider.PlatformProvider/versions");
    AppMethodBeat.o(17906);
    return paramNativeAppInfo;
  }
  
  public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> paramTreeSet, int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(17905);
    int i = paramArrayOfInt.length;
    paramTreeSet = paramTreeSet.descendingIterator();
    int j = -1;
    i -= 1;
    while (paramTreeSet.hasNext())
    {
      int k = ((Integer)paramTreeSet.next()).intValue();
      j = Math.max(j, k);
      while ((i >= 0) && (paramArrayOfInt[i] > k)) {
        i -= 1;
      }
      if (i < 0)
      {
        AppMethodBeat.o(17905);
        return -1;
      }
      if (paramArrayOfInt[i] == k)
      {
        if (i % 2 == 0)
        {
          paramInt = Math.min(j, paramInt);
          AppMethodBeat.o(17905);
          return paramInt;
        }
        AppMethodBeat.o(17905);
        return -1;
      }
    }
    AppMethodBeat.o(17905);
    return -1;
  }
  
  public static Bundle createBundleForException(FacebookException paramFacebookException)
  {
    AppMethodBeat.i(17899);
    if (paramFacebookException == null)
    {
      AppMethodBeat.o(17899);
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("error_description", paramFacebookException.toString());
    if ((paramFacebookException instanceof FacebookOperationCanceledException)) {
      localBundle.putString("error_type", "UserCanceled");
    }
    AppMethodBeat.o(17899);
    return localBundle;
  }
  
  public static Intent createFacebookLiteIntent(Context paramContext, String paramString1, Collection<String> paramCollection, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DefaultAudience paramDefaultAudience, String paramString3, String paramString4)
  {
    AppMethodBeat.i(17881);
    FBLiteAppInfo localFBLiteAppInfo = new FBLiteAppInfo(null);
    paramContext = validateActivityIntent(paramContext, createNativeAppIntent(localFBLiteAppInfo, paramString1, paramCollection, paramString2, paramBoolean1, paramBoolean2, paramDefaultAudience, paramString3, paramString4), localFBLiteAppInfo);
    AppMethodBeat.o(17881);
    return paramContext;
  }
  
  private static Intent createNativeAppIntent(NativeAppInfo paramNativeAppInfo, String paramString1, Collection<String> paramCollection, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DefaultAudience paramDefaultAudience, String paramString3, String paramString4)
  {
    AppMethodBeat.i(17882);
    String str = paramNativeAppInfo.getLoginActivity();
    if (str == null)
    {
      AppMethodBeat.o(17882);
      return null;
    }
    paramNativeAppInfo = new Intent().setClassName(paramNativeAppInfo.getPackage(), str).putExtra("client_id", paramString1);
    paramNativeAppInfo.putExtra("facebook_sdk_version", FacebookSdk.getSdkVersion());
    if (!Utility.isNullOrEmpty(paramCollection)) {
      paramNativeAppInfo.putExtra("scope", TextUtils.join(",", paramCollection));
    }
    if (!Utility.isNullOrEmpty(paramString2)) {
      paramNativeAppInfo.putExtra("e2e", paramString2);
    }
    paramNativeAppInfo.putExtra("state", paramString3);
    paramNativeAppInfo.putExtra("response_type", "token,signed_request");
    paramNativeAppInfo.putExtra("return_scopes", "true");
    if (paramBoolean2) {
      paramNativeAppInfo.putExtra("default_audience", paramDefaultAudience.getNativeProtocolAudience());
    }
    paramNativeAppInfo.putExtra("legacy_override", FacebookSdk.getGraphApiVersion());
    paramNativeAppInfo.putExtra("auth_type", paramString4);
    AppMethodBeat.o(17882);
    return paramNativeAppInfo;
  }
  
  public static Intent createPlatformActivityIntent(Context paramContext, String paramString1, String paramString2, ProtocolVersionQueryResult paramProtocolVersionQueryResult, Bundle paramBundle)
  {
    AppMethodBeat.i(17887);
    if (paramProtocolVersionQueryResult == null)
    {
      AppMethodBeat.o(17887);
      return null;
    }
    NativeAppInfo localNativeAppInfo = paramProtocolVersionQueryResult.nativeAppInfo;
    if (localNativeAppInfo == null)
    {
      AppMethodBeat.o(17887);
      return null;
    }
    paramContext = validateActivityIntent(paramContext, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(localNativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), localNativeAppInfo);
    if (paramContext == null)
    {
      AppMethodBeat.o(17887);
      return null;
    }
    setupProtocolRequestIntent(paramContext, paramString1, paramString2, paramProtocolVersionQueryResult.protocolVersion, paramBundle);
    AppMethodBeat.o(17887);
    return paramContext;
  }
  
  public static Intent createPlatformServiceIntent(Context paramContext)
  {
    AppMethodBeat.i(17890);
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      localObject = validateServiceIntent(paramContext, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(((NativeAppInfo)localObject).getPackage()).addCategory("android.intent.category.DEFAULT"), (NativeAppInfo)localObject);
      if (localObject != null)
      {
        AppMethodBeat.o(17890);
        return localObject;
      }
    }
    AppMethodBeat.o(17890);
    return null;
  }
  
  public static Intent createProtocolResultIntent(Intent paramIntent, Bundle paramBundle, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(17889);
    UUID localUUID = getCallIdFromIntent(paramIntent);
    if (localUUID == null)
    {
      AppMethodBeat.o(17889);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", getProtocolVersionFromIntent(paramIntent));
    paramIntent = new Bundle();
    paramIntent.putString("action_id", localUUID.toString());
    if (paramFacebookException != null) {
      paramIntent.putBundle("error", createBundleForException(paramFacebookException));
    }
    localIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", paramIntent);
    if (paramBundle != null) {
      localIntent.putExtra("com.facebook.platform.protocol.RESULT_ARGS", paramBundle);
    }
    AppMethodBeat.o(17889);
    return localIntent;
  }
  
  public static Intent createProxyAuthIntent(Context paramContext, String paramString1, Collection<String> paramCollection, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DefaultAudience paramDefaultAudience, String paramString3, String paramString4)
  {
    AppMethodBeat.i(17883);
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      localObject = validateActivityIntent(paramContext, createNativeAppIntent((NativeAppInfo)localObject, paramString1, paramCollection, paramString2, paramBoolean1, paramBoolean2, paramDefaultAudience, paramString3, paramString4), (NativeAppInfo)localObject);
      if (localObject != null)
      {
        AppMethodBeat.o(17883);
        return localObject;
      }
    }
    AppMethodBeat.o(17883);
    return null;
  }
  
  public static Intent createTokenRefreshIntent(Context paramContext)
  {
    AppMethodBeat.i(17884);
    Iterator localIterator = facebookAppInfoList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NativeAppInfo)localIterator.next();
      localObject = validateServiceIntent(paramContext, new Intent().setClassName(((NativeAppInfo)localObject).getPackage(), "com.facebook.katana.platform.TokenRefreshService"), (NativeAppInfo)localObject);
      if (localObject != null)
      {
        AppMethodBeat.o(17884);
        return localObject;
      }
    }
    AppMethodBeat.o(17884);
    return null;
  }
  
  /* Error */
  private static TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo paramNativeAppInfo)
  {
    // Byte code:
    //   0: sipush 17904
    //   3: invokestatic 354	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 476	java/util/TreeSet
    //   9: dup
    //   10: invokespecial 661	java/util/TreeSet:<init>	()V
    //   13: astore_2
    //   14: invokestatic 665	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   17: invokevirtual 671	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore_1
    //   21: aload_0
    //   22: invokestatic 673	com/facebook/internal/NativeProtocol:buildPlatformProviderVersionURI	(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Landroid/net/Uri;
    //   25: astore_3
    //   26: invokestatic 665	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   29: invokevirtual 677	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   32: astore 4
    //   34: new 453	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 678	java/lang/StringBuilder:<init>	()V
    //   41: aload_0
    //   42: invokevirtual 459	com/facebook/internal/NativeProtocol$NativeAppInfo:getPackage	()Ljava/lang/String;
    //   45: invokevirtual 463	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 256
    //   51: invokevirtual 463	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 466	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_0
    //   58: aload 4
    //   60: aload_0
    //   61: iconst_0
    //   62: invokevirtual 684	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull +100 -> 167
    //   70: aload_1
    //   71: aload_3
    //   72: iconst_1
    //   73: anewarray 686	java/lang/String
    //   76: dup
    //   77: iconst_0
    //   78: ldc_w 262
    //   81: aastore
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: invokevirtual 692	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore_0
    //   89: aload_0
    //   90: astore_1
    //   91: aload_0
    //   92: ifnull +77 -> 169
    //   95: aload_0
    //   96: astore_1
    //   97: aload_0
    //   98: invokeinterface 697 1 0
    //   103: ifeq +66 -> 169
    //   106: aload_2
    //   107: aload_0
    //   108: aload_0
    //   109: ldc_w 262
    //   112: invokeinterface 701 2 0
    //   117: invokeinterface 705 2 0
    //   122: invokestatic 393	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokevirtual 706	java/util/TreeSet:add	(Ljava/lang/Object;)Z
    //   128: pop
    //   129: goto -34 -> 95
    //   132: astore_2
    //   133: aload_0
    //   134: astore_1
    //   135: aload_2
    //   136: astore_0
    //   137: aload_1
    //   138: ifnull +9 -> 147
    //   141: aload_1
    //   142: invokeinterface 709 1 0
    //   147: sipush 17904
    //   150: invokestatic 404	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload_0
    //   154: athrow
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_0
    //   158: goto -92 -> 66
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_0
    //   164: goto -75 -> 89
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +9 -> 179
    //   173: aload_1
    //   174: invokeinterface 709 1 0
    //   179: sipush 17904
    //   182: invokestatic 404	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_2
    //   186: areturn
    //   187: astore_0
    //   188: goto -26 -> 162
    //   191: astore_0
    //   192: goto -30 -> 162
    //   195: astore_0
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -61 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramNativeAppInfo	NativeAppInfo
    //   20	178	1	localObject	Object
    //   13	94	2	localTreeSet	TreeSet
    //   132	54	2	localTreeSet1	TreeSet<Integer>
    //   25	47	3	localUri	Uri
    //   32	27	4	localPackageManager	PackageManager
    // Exception table:
    //   from	to	target	type
    //   97	129	132	finally
    //   58	66	155	java/lang/RuntimeException
    //   70	89	161	java/lang/NullPointerException
    //   70	89	187	java/lang/SecurityException
    //   70	89	191	java/lang/IllegalArgumentException
    //   26	58	195	finally
    //   58	66	195	finally
    //   70	89	195	finally
  }
  
  public static Bundle getBridgeArgumentsFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(17893);
    if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent)))
    {
      AppMethodBeat.o(17893);
      return null;
    }
    paramIntent = paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
    AppMethodBeat.o(17893);
    return paramIntent;
  }
  
  public static UUID getCallIdFromIntent(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(17892);
    if (paramIntent == null)
    {
      AppMethodBeat.o(17892);
      return null;
    }
    if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent)))
    {
      paramIntent = paramIntent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
      if (paramIntent == null) {
        break label83;
      }
    }
    label83:
    for (paramIntent = paramIntent.getString("action_id");; paramIntent = null) {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (paramIntent != null) {}
        try
        {
          localObject1 = UUID.fromString(paramIntent);
          AppMethodBeat.o(17892);
          return localObject1;
          paramIntent = paramIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        catch (IllegalArgumentException paramIntent)
        {
          for (;;)
          {
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public static Bundle getErrorDataFromResultIntent(Intent paramIntent)
  {
    AppMethodBeat.i(17897);
    if (!isErrorResult(paramIntent))
    {
      AppMethodBeat.o(17897);
      return null;
    }
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null)
    {
      paramIntent = localBundle.getBundle("error");
      AppMethodBeat.o(17897);
      return paramIntent;
    }
    paramIntent = paramIntent.getExtras();
    AppMethodBeat.o(17897);
    return paramIntent;
  }
  
  public static FacebookException getExceptionFromErrorData(Bundle paramBundle)
  {
    AppMethodBeat.i(17898);
    if (paramBundle == null)
    {
      AppMethodBeat.o(17898);
      return null;
    }
    Object localObject2 = paramBundle.getString("error_type");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramBundle.getString("com.facebook.platform.status.ERROR_TYPE");
    }
    String str = paramBundle.getString("error_description");
    localObject2 = str;
    if (str == null) {
      localObject2 = paramBundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
    }
    if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("UserCanceled")))
    {
      paramBundle = new FacebookOperationCanceledException((String)localObject2);
      AppMethodBeat.o(17898);
      return paramBundle;
    }
    paramBundle = new FacebookException((String)localObject2);
    AppMethodBeat.o(17898);
    return paramBundle;
  }
  
  public static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(17901);
    paramString = getLatestAvailableProtocolVersionForAppInfoList((List)actionToAppInfoMap.get(paramString), paramArrayOfInt);
    AppMethodBeat.o(17901);
    return paramString;
  }
  
  private static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<NativeAppInfo> paramList, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(17902);
    updateAllAvailableProtocolVersionsAsync();
    if (paramList == null)
    {
      paramList = ProtocolVersionQueryResult.createEmpty();
      AppMethodBeat.o(17902);
      return paramList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      NativeAppInfo localNativeAppInfo = (NativeAppInfo)paramList.next();
      int i = computeLatestAvailableVersionFromVersionSpec(localNativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), paramArrayOfInt);
      if (i != -1)
      {
        paramList = ProtocolVersionQueryResult.create(localNativeAppInfo, i);
        AppMethodBeat.o(17902);
        return paramList;
      }
    }
    paramList = ProtocolVersionQueryResult.createEmpty();
    AppMethodBeat.o(17902);
    return paramList;
  }
  
  public static int getLatestAvailableProtocolVersionForService(int paramInt)
  {
    AppMethodBeat.i(17900);
    paramInt = getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[] { paramInt }).getProtocolVersion();
    AppMethodBeat.o(17900);
    return paramInt;
  }
  
  public static final int getLatestKnownVersion()
  {
    AppMethodBeat.i(17885);
    int i = ((Integer)KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
    AppMethodBeat.o(17885);
    return i;
  }
  
  public static Bundle getMethodArgumentsFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(17894);
    if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(paramIntent)))
    {
      paramIntent = paramIntent.getExtras();
      AppMethodBeat.o(17894);
      return paramIntent;
    }
    paramIntent = paramIntent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    AppMethodBeat.o(17894);
    return paramIntent;
  }
  
  public static int getProtocolVersionFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(17891);
    int i = paramIntent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    AppMethodBeat.o(17891);
    return i;
  }
  
  public static Bundle getSuccessResultsFromIntent(Intent paramIntent)
  {
    AppMethodBeat.i(17895);
    int i = getProtocolVersionFromIntent(paramIntent);
    paramIntent = paramIntent.getExtras();
    if ((!isVersionCompatibleWithBucketedIntent(i)) || (paramIntent == null))
    {
      AppMethodBeat.o(17895);
      return paramIntent;
    }
    paramIntent = paramIntent.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
    AppMethodBeat.o(17895);
    return paramIntent;
  }
  
  public static boolean isErrorResult(Intent paramIntent)
  {
    AppMethodBeat.i(17896);
    Bundle localBundle = getBridgeArgumentsFromIntent(paramIntent);
    if (localBundle != null)
    {
      bool = localBundle.containsKey("error");
      AppMethodBeat.o(17896);
      return bool;
    }
    boolean bool = paramIntent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
    AppMethodBeat.o(17896);
    return bool;
  }
  
  public static boolean isVersionCompatibleWithBucketedIntent(int paramInt)
  {
    AppMethodBeat.i(17886);
    if ((KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(paramInt))) && (paramInt >= 20140701))
    {
      AppMethodBeat.o(17886);
      return true;
    }
    AppMethodBeat.o(17886);
    return false;
  }
  
  public static void setupProtocolRequestIntent(Intent paramIntent, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(17888);
    String str2 = FacebookSdk.getApplicationId();
    String str1 = FacebookSdk.getApplicationName();
    paramIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", paramInt).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", paramString2).putExtra("com.facebook.platform.extra.APPLICATION_ID", str2);
    if (isVersionCompatibleWithBucketedIntent(paramInt))
    {
      paramString2 = new Bundle();
      paramString2.putString("action_id", paramString1);
      Utility.putNonEmptyString(paramString2, "app_name", str1);
      paramIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", paramString2);
      paramString1 = paramBundle;
      if (paramBundle == null) {
        paramString1 = new Bundle();
      }
      paramIntent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", paramString1);
      AppMethodBeat.o(17888);
      return;
    }
    paramIntent.putExtra("com.facebook.platform.protocol.CALL_ID", paramString1);
    if (!Utility.isNullOrEmpty(str1)) {
      paramIntent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", str1);
    }
    paramIntent.putExtras(paramBundle);
    AppMethodBeat.o(17888);
  }
  
  public static void updateAllAvailableProtocolVersionsAsync()
  {
    AppMethodBeat.i(17903);
    if (!protocolVersionsAsyncUpdating.compareAndSet(false, true))
    {
      AppMethodBeat.o(17903);
      return;
    }
    FacebookSdk.getExecutor().execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(17873);
        try
        {
          Iterator localIterator = NativeProtocol.facebookAppInfoList.iterator();
          while (localIterator.hasNext()) {
            NativeProtocol.NativeAppInfo.access$1000((NativeProtocol.NativeAppInfo)localIterator.next(), true);
          }
          NativeProtocol.protocolVersionsAsyncUpdating.set(false);
        }
        finally
        {
          NativeProtocol.protocolVersionsAsyncUpdating.set(false);
          AppMethodBeat.o(17873);
        }
        AppMethodBeat.o(17873);
      }
    });
    AppMethodBeat.o(17903);
  }
  
  static Intent validateActivityIntent(Context paramContext, Intent paramIntent, NativeAppInfo paramNativeAppInfo)
  {
    AppMethodBeat.i(17879);
    if (paramIntent == null)
    {
      AppMethodBeat.o(17879);
      return null;
    }
    paramNativeAppInfo = paramContext.getPackageManager().resolveActivity(paramIntent, 0);
    if (paramNativeAppInfo == null)
    {
      AppMethodBeat.o(17879);
      return null;
    }
    if (!FacebookSignatureValidator.validateSignature(paramContext, paramNativeAppInfo.activityInfo.packageName))
    {
      AppMethodBeat.o(17879);
      return null;
    }
    AppMethodBeat.o(17879);
    return paramIntent;
  }
  
  static Intent validateServiceIntent(Context paramContext, Intent paramIntent, NativeAppInfo paramNativeAppInfo)
  {
    AppMethodBeat.i(17880);
    if (paramIntent == null)
    {
      AppMethodBeat.o(17880);
      return null;
    }
    paramNativeAppInfo = paramContext.getPackageManager().resolveService(paramIntent, 0);
    if (paramNativeAppInfo == null)
    {
      AppMethodBeat.o(17880);
      return null;
    }
    if (!FacebookSignatureValidator.validateSignature(paramContext, paramNativeAppInfo.serviceInfo.packageName))
    {
      AppMethodBeat.o(17880);
      return null;
    }
    AppMethodBeat.o(17880);
    return paramIntent;
  }
  
  static class EffectTestAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String EFFECT_TEST_APP_PACKAGE = "com.facebook.arstudio.player";
    
    private EffectTestAppInfo()
    {
      super();
    }
    
    protected String getLoginActivity()
    {
      return null;
    }
    
    protected String getPackage()
    {
      return "com.facebook.arstudio.player";
    }
  }
  
  static class FBLiteAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String FACEBOOK_LITE_ACTIVITY = "com.facebook.lite.platform.LoginGDPDialogActivity";
    static final String FBLITE_PACKAGE = "com.facebook.lite";
    
    private FBLiteAppInfo()
    {
      super();
    }
    
    protected String getLoginActivity()
    {
      return "com.facebook.lite.platform.LoginGDPDialogActivity";
    }
    
    protected String getPackage()
    {
      return "com.facebook.lite";
    }
  }
  
  static class KatanaAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String KATANA_PACKAGE = "com.facebook.katana";
    
    private KatanaAppInfo()
    {
      super();
    }
    
    protected String getLoginActivity()
    {
      return "com.facebook.katana.ProxyAuth";
    }
    
    protected String getPackage()
    {
      return "com.facebook.katana";
    }
  }
  
  static class MessengerAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String MESSENGER_PACKAGE = "com.facebook.orca";
    
    private MessengerAppInfo()
    {
      super();
    }
    
    protected String getLoginActivity()
    {
      return null;
    }
    
    protected String getPackage()
    {
      return "com.facebook.orca";
    }
  }
  
  static abstract class NativeAppInfo
  {
    private TreeSet<Integer> availableVersions;
    
    private void fetchAvailableVersions(boolean paramBoolean)
    {
      if (!paramBoolean) {}
      try
      {
        if (this.availableVersions == null) {
          this.availableVersions = NativeProtocol.access$000(this);
        }
        return;
      }
      finally {}
    }
    
    public TreeSet<Integer> getAvailableVersions()
    {
      if (this.availableVersions == null) {
        fetchAvailableVersions(false);
      }
      return this.availableVersions;
    }
    
    protected abstract String getLoginActivity();
    
    protected abstract String getPackage();
  }
  
  public static class ProtocolVersionQueryResult
  {
    private NativeProtocol.NativeAppInfo nativeAppInfo;
    private int protocolVersion;
    
    public static ProtocolVersionQueryResult create(NativeProtocol.NativeAppInfo paramNativeAppInfo, int paramInt)
    {
      AppMethodBeat.i(17874);
      ProtocolVersionQueryResult localProtocolVersionQueryResult = new ProtocolVersionQueryResult();
      localProtocolVersionQueryResult.nativeAppInfo = paramNativeAppInfo;
      localProtocolVersionQueryResult.protocolVersion = paramInt;
      AppMethodBeat.o(17874);
      return localProtocolVersionQueryResult;
    }
    
    public static ProtocolVersionQueryResult createEmpty()
    {
      AppMethodBeat.i(17875);
      ProtocolVersionQueryResult localProtocolVersionQueryResult = new ProtocolVersionQueryResult();
      localProtocolVersionQueryResult.protocolVersion = -1;
      AppMethodBeat.o(17875);
      return localProtocolVersionQueryResult;
    }
    
    public NativeProtocol.NativeAppInfo getAppInfo()
    {
      return this.nativeAppInfo;
    }
    
    public int getProtocolVersion()
    {
      return this.protocolVersion;
    }
  }
  
  static class WakizashiAppInfo
    extends NativeProtocol.NativeAppInfo
  {
    static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";
    
    private WakizashiAppInfo()
    {
      super();
    }
    
    protected String getLoginActivity()
    {
      return "com.facebook.katana.ProxyAuth";
    }
    
    protected String getPackage()
    {
      return "com.facebook.wakizashi";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.internal.NativeProtocol
 * JD-Core Version:    0.7.0.1
 */