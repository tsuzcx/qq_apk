package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.d;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.widget.LikeView.ObjectType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class LikeActionController
{
  @Deprecated
  public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
  @Deprecated
  public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
  @Deprecated
  public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
  @Deprecated
  public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
  private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
  @Deprecated
  public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
  @Deprecated
  public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
  private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
  private static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
  private static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
  private static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
  private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
  private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
  private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
  private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
  private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
  private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
  private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
  private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
  private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
  private static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
  private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
  private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
  private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
  private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
  private static final int MAX_CACHE_SIZE = 128;
  private static final int MAX_OBJECT_SUFFIX = 1000;
  private static final String TAG;
  private static AccessTokenTracker accessTokenTracker;
  private static final ConcurrentHashMap<String, LikeActionController> cache;
  private static FileLruCache controllerDiskCache;
  private static WorkQueue diskIOWorkQueue;
  private static Handler handler;
  private static boolean isInitialized;
  private static WorkQueue mruCacheWorkQueue;
  private static String objectIdForPendingController;
  private static volatile int objectSuffix;
  private AppEventsLogger appEventsLogger;
  private Bundle facebookDialogAnalyticsBundle;
  private boolean isObjectLiked;
  private boolean isObjectLikedOnServer;
  private boolean isPendingLikeOrUnlike;
  private String likeCountStringWithLike;
  private String likeCountStringWithoutLike;
  private String objectId;
  private boolean objectIsPage;
  private LikeView.ObjectType objectType;
  private String socialSentenceWithLike;
  private String socialSentenceWithoutLike;
  private String unlikeToken;
  private String verifiedObjectId;
  
  static
  {
    AppMethodBeat.i(8095);
    TAG = LikeActionController.class.getSimpleName();
    cache = new ConcurrentHashMap();
    mruCacheWorkQueue = new WorkQueue(1);
    diskIOWorkQueue = new WorkQueue(1);
    AppMethodBeat.o(8095);
  }
  
  private LikeActionController(String paramString, LikeView.ObjectType paramObjectType)
  {
    this.objectId = paramString;
    this.objectType = paramObjectType;
  }
  
  private static void broadcastAction(LikeActionController paramLikeActionController, String paramString)
  {
    AppMethodBeat.i(8060);
    broadcastAction(paramLikeActionController, paramString, null);
    AppMethodBeat.o(8060);
  }
  
  private static void broadcastAction(LikeActionController paramLikeActionController, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(8061);
    Intent localIntent = new Intent(paramString);
    paramString = paramBundle;
    if (paramLikeActionController != null)
    {
      paramString = paramBundle;
      if (paramBundle == null) {
        paramString = new Bundle();
      }
      paramString.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", paramLikeActionController.getObjectId());
    }
    if (paramString != null) {
      localIntent.putExtras(paramString);
    }
    d.V(FacebookSdk.getApplicationContext()).b(localIntent);
    AppMethodBeat.o(8061);
  }
  
  private boolean canUseOGPublish()
  {
    AppMethodBeat.i(8074);
    AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
    if ((!this.objectIsPage) && (this.verifiedObjectId != null) && (AccessToken.isCurrentAccessTokenActive()) && (localAccessToken.getPermissions() != null) && (localAccessToken.getPermissions().contains("publish_actions")))
    {
      AppMethodBeat.o(8074);
      return true;
    }
    AppMethodBeat.o(8074);
    return false;
  }
  
  private void clearState()
  {
    AppMethodBeat.i(8072);
    this.facebookDialogAnalyticsBundle = null;
    storeObjectIdForPendingController(null);
    AppMethodBeat.o(8072);
  }
  
  private static void createControllerForObjectIdAndType(String paramString, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    AppMethodBeat.i(8048);
    Object localObject = getControllerFromInMemoryCache(paramString);
    if (localObject != null)
    {
      verifyControllerAndInvokeCallback((LikeActionController)localObject, paramObjectType, paramCreationCallback);
      AppMethodBeat.o(8048);
      return;
    }
    LikeActionController localLikeActionController = deserializeFromDiskSynchronously(paramString);
    localObject = localLikeActionController;
    if (localLikeActionController == null)
    {
      localObject = new LikeActionController(paramString, paramObjectType);
      serializeToDiskAsync((LikeActionController)localObject);
    }
    putControllerInMemoryCache(paramString, (LikeActionController)localObject);
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8008);
        LikeActionController.access$200(this.val$controllerToRefresh);
        AppMethodBeat.o(8008);
      }
    });
    invokeCallbackWithController(paramCreationCallback, (LikeActionController)localObject, null);
    AppMethodBeat.o(8048);
  }
  
  /* Error */
  private static LikeActionController deserializeFromDiskSynchronously(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: sipush 8056
    //   7: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 451	com/facebook/share/internal/LikeActionController:getCacheKeyForObjectId	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_0
    //   15: getstatic 335	com/facebook/share/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
    //   18: aload_0
    //   19: invokevirtual 457	com/facebook/internal/FileLruCache:get	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: aload_2
    //   24: astore_1
    //   25: aload_0
    //   26: ifnull +25 -> 51
    //   29: aload_0
    //   30: invokestatic 463	com/facebook/internal/Utility:readStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   33: astore 4
    //   35: aload_2
    //   36: astore_1
    //   37: aload 4
    //   39: invokestatic 467	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   42: ifne +9 -> 51
    //   45: aload 4
    //   47: invokestatic 470	com/facebook/share/internal/LikeActionController:deserializeFromJson	(Ljava/lang/String;)Lcom/facebook/share/internal/LikeActionController;
    //   50: astore_1
    //   51: aload_1
    //   52: astore_2
    //   53: aload_0
    //   54: ifnull +9 -> 63
    //   57: aload_0
    //   58: invokestatic 474	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   61: aload_1
    //   62: astore_2
    //   63: sipush 8056
    //   66: invokestatic 225	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_2
    //   70: areturn
    //   71: astore_0
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_3
    //   75: astore_2
    //   76: aload_0
    //   77: ifnull -14 -> 63
    //   80: aload_0
    //   81: invokestatic 474	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   84: aload_3
    //   85: astore_2
    //   86: goto -23 -> 63
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokestatic 474	com/facebook/internal/Utility:closeQuietly	(Ljava/io/Closeable;)V
    //   100: sipush 8056
    //   103: invokestatic 225	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_0
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: astore_2
    //   111: aload_1
    //   112: astore_0
    //   113: aload_2
    //   114: astore_1
    //   115: goto -23 -> 92
    //   118: astore_1
    //   119: goto -45 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramString	String
    //   24	73	1	localObject1	Object
    //   108	4	1	localObject2	Object
    //   114	1	1	localObject3	Object
    //   118	1	1	localIOException	IOException
    //   3	111	2	localObject4	Object
    //   1	84	3	localObject5	Object
    //   33	13	4	str	String
    // Exception table:
    //   from	to	target	type
    //   10	23	71	java/io/IOException
    //   10	23	89	finally
    //   29	35	108	finally
    //   37	51	108	finally
    //   29	35	118	java/io/IOException
    //   37	51	118	java/io/IOException
  }
  
  private static LikeActionController deserializeFromJson(String paramString)
  {
    AppMethodBeat.i(8057);
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("com.facebook.share.internal.LikeActionController.version", -1);
      if (i != 3)
      {
        AppMethodBeat.o(8057);
        return null;
      }
      LikeActionController localLikeActionController = new LikeActionController(paramString.getString("object_id"), LikeView.ObjectType.fromInt(paramString.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue())));
      localLikeActionController.likeCountStringWithLike = paramString.optString("like_count_string_with_like", null);
      localLikeActionController.likeCountStringWithoutLike = paramString.optString("like_count_string_without_like", null);
      localLikeActionController.socialSentenceWithLike = paramString.optString("social_sentence_with_like", null);
      localLikeActionController.socialSentenceWithoutLike = paramString.optString("social_sentence_without_like", null);
      localLikeActionController.isObjectLiked = paramString.optBoolean("is_object_liked");
      localLikeActionController.unlikeToken = paramString.optString("unlike_token", null);
      JSONObject localJSONObject = paramString.optJSONObject("facebook_dialog_analytics_bundle");
      paramString = localLikeActionController;
      if (localJSONObject != null)
      {
        localLikeActionController.facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(localJSONObject);
        paramString = localLikeActionController;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    AppMethodBeat.o(8057);
    return paramString;
  }
  
  private void fetchVerifiedObjectId(final RequestCompletionCallback paramRequestCompletionCallback)
  {
    AppMethodBeat.i(8080);
    if (!Utility.isNullOrEmpty(this.verifiedObjectId))
    {
      if (paramRequestCompletionCallback != null) {
        paramRequestCompletionCallback.onComplete();
      }
      AppMethodBeat.o(8080);
      return;
    }
    final GetOGObjectIdRequestWrapper localGetOGObjectIdRequestWrapper = new GetOGObjectIdRequestWrapper(this.objectId, this.objectType);
    final GetPageIdRequestWrapper localGetPageIdRequestWrapper = new GetPageIdRequestWrapper(this.objectId, this.objectType);
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
    localGetOGObjectIdRequestWrapper.addToBatch(localGraphRequestBatch);
    localGetPageIdRequestWrapper.addToBatch(localGraphRequestBatch);
    localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        AppMethodBeat.i(8006);
        LikeActionController.access$1602(LikeActionController.this, localGetOGObjectIdRequestWrapper.verifiedObjectId);
        if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId))
        {
          LikeActionController.access$1602(LikeActionController.this, localGetPageIdRequestWrapper.verifiedObjectId);
          LikeActionController.access$2302(LikeActionController.this, localGetPageIdRequestWrapper.objectIsPage);
        }
        LikeActionController localLikeActionController;
        if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId))
        {
          Logger.log(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", new Object[] { LikeActionController.this.objectId });
          localLikeActionController = LikeActionController.this;
          if (localGetPageIdRequestWrapper.getError() == null) {
            break label155;
          }
        }
        label155:
        for (paramAnonymousGraphRequestBatch = localGetPageIdRequestWrapper.getError();; paramAnonymousGraphRequestBatch = localGetOGObjectIdRequestWrapper.getError())
        {
          LikeActionController.access$2400(localLikeActionController, "get_verified_id", paramAnonymousGraphRequestBatch);
          if (paramRequestCompletionCallback != null) {
            paramRequestCompletionCallback.onComplete();
          }
          AppMethodBeat.o(8006);
          return;
        }
      }
    });
    localGraphRequestBatch.executeAsync();
    AppMethodBeat.o(8080);
  }
  
  private AppEventsLogger getAppEventsLogger()
  {
    AppMethodBeat.i(8063);
    if (this.appEventsLogger == null) {
      this.appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
    }
    AppEventsLogger localAppEventsLogger = this.appEventsLogger;
    AppMethodBeat.o(8063);
    return localAppEventsLogger;
  }
  
  private static String getCacheKeyForObjectId(String paramString)
  {
    AppMethodBeat.i(8059);
    String str = null;
    Object localObject = AccessToken.getCurrentAccessToken();
    if (AccessToken.isCurrentAccessTokenActive()) {
      str = ((AccessToken)localObject).getToken();
    }
    localObject = str;
    if (str != null) {
      localObject = Utility.md5hash(str);
    }
    paramString = String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", new Object[] { paramString, Utility.coerceValueIfNullOrEmpty((String)localObject, ""), Integer.valueOf(objectSuffix) });
    AppMethodBeat.o(8059);
    return paramString;
  }
  
  @Deprecated
  public static void getControllerForObjectId(String paramString, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    AppMethodBeat.i(8046);
    if (!isInitialized) {
      performFirstInitialize();
    }
    LikeActionController localLikeActionController = getControllerFromInMemoryCache(paramString);
    if (localLikeActionController != null)
    {
      verifyControllerAndInvokeCallback(localLikeActionController, paramObjectType, paramCreationCallback);
      AppMethodBeat.o(8046);
      return;
    }
    diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(paramString, paramObjectType, paramCreationCallback));
    AppMethodBeat.o(8046);
  }
  
  private static LikeActionController getControllerFromInMemoryCache(String paramString)
  {
    AppMethodBeat.i(8053);
    paramString = getCacheKeyForObjectId(paramString);
    LikeActionController localLikeActionController = (LikeActionController)cache.get(paramString);
    if (localLikeActionController != null) {
      mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(paramString, false));
    }
    AppMethodBeat.o(8053);
    return localLikeActionController;
  }
  
  private ResultProcessor getResultProcessor(final Bundle paramBundle)
  {
    AppMethodBeat.i(8070);
    paramBundle = new ResultProcessor(null)
    {
      public void onCancel(AppCall paramAnonymousAppCall)
      {
        AppMethodBeat.i(8014);
        onError(paramAnonymousAppCall, new FacebookOperationCanceledException());
        AppMethodBeat.o(8014);
      }
      
      public void onError(AppCall paramAnonymousAppCall, FacebookException paramAnonymousFacebookException)
      {
        AppMethodBeat.i(8013);
        Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", new Object[] { paramAnonymousFacebookException });
        if (paramBundle == null) {}
        for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
        {
          localBundle.putString("call_id", paramAnonymousAppCall.getCallId().toString());
          LikeActionController.access$1400(LikeActionController.this, "present_dialog", localBundle);
          LikeActionController.access$1500(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", NativeProtocol.createBundleForException(paramAnonymousFacebookException));
          AppMethodBeat.o(8013);
          return;
        }
      }
      
      public void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(8012);
        if ((paramAnonymousBundle == null) || (!paramAnonymousBundle.containsKey("object_is_liked")))
        {
          AppMethodBeat.o(8012);
          return;
        }
        boolean bool = paramAnonymousBundle.getBoolean("object_is_liked");
        String str1 = LikeActionController.this.likeCountStringWithLike;
        String str2 = LikeActionController.this.likeCountStringWithoutLike;
        if (paramAnonymousBundle.containsKey("like_count_string"))
        {
          str1 = paramAnonymousBundle.getString("like_count_string");
          str2 = str1;
        }
        String str3 = LikeActionController.this.socialSentenceWithLike;
        String str4 = LikeActionController.this.socialSentenceWithoutLike;
        if (paramAnonymousBundle.containsKey("social_sentence"))
        {
          str3 = paramAnonymousBundle.getString("social_sentence");
          str4 = str3;
        }
        if (paramAnonymousBundle.containsKey("object_is_liked"))
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("unlike_token");
          if (paramBundle != null) {
            break label207;
          }
        }
        label207:
        for (Bundle localBundle = new Bundle();; localBundle = paramBundle)
        {
          localBundle.putString("call_id", paramAnonymousAppCall.getCallId().toString());
          LikeActionController.access$1200(LikeActionController.this).logSdkEvent("fb_like_control_dialog_did_succeed", null, localBundle);
          LikeActionController.access$1300(LikeActionController.this, bool, str1, str2, str3, str4, paramAnonymousBundle);
          AppMethodBeat.o(8012);
          return;
          paramAnonymousBundle = LikeActionController.this.unlikeToken;
          break;
        }
      }
    };
    AppMethodBeat.o(8070);
    return paramBundle;
  }
  
  @Deprecated
  public static boolean handleOnActivityResult(int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(8045);
    if (Utility.isNullOrEmpty(objectIdForPendingController)) {
      objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).getString("PENDING_CONTROLLER_KEY", null);
    }
    if (Utility.isNullOrEmpty(objectIdForPendingController))
    {
      AppMethodBeat.o(8045);
      return false;
    }
    getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new CreationCallback()
    {
      public final void onComplete(LikeActionController paramAnonymousLikeActionController, FacebookException paramAnonymousFacebookException)
      {
        AppMethodBeat.i(8004);
        if (paramAnonymousFacebookException == null)
        {
          LikeActionController.access$000(paramAnonymousLikeActionController, this.val$requestCode, paramInt2, paramIntent);
          AppMethodBeat.o(8004);
          return;
        }
        Utility.logd(LikeActionController.TAG, paramAnonymousFacebookException);
        AppMethodBeat.o(8004);
      }
    });
    AppMethodBeat.o(8045);
    return true;
  }
  
  private static void invokeCallbackWithController(CreationCallback paramCreationCallback, final LikeActionController paramLikeActionController, final FacebookException paramFacebookException)
  {
    AppMethodBeat.i(8050);
    if (paramCreationCallback == null)
    {
      AppMethodBeat.o(8050);
      return;
    }
    handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8010);
        this.val$callback.onComplete(paramLikeActionController, paramFacebookException);
        AppMethodBeat.o(8010);
      }
    });
    AppMethodBeat.o(8050);
  }
  
  private void logAppEventForError(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(8081);
    paramBundle = new Bundle(paramBundle);
    paramBundle.putString("object_id", this.objectId);
    paramBundle.putString("object_type", this.objectType.toString());
    paramBundle.putString("current_action", paramString);
    getAppEventsLogger().logSdkEvent("fb_like_control_error", null, paramBundle);
    AppMethodBeat.o(8081);
  }
  
  private void logAppEventForError(String paramString, FacebookRequestError paramFacebookRequestError)
  {
    AppMethodBeat.i(8082);
    Bundle localBundle = new Bundle();
    if (paramFacebookRequestError != null)
    {
      paramFacebookRequestError = paramFacebookRequestError.getRequestResult();
      if (paramFacebookRequestError != null) {
        localBundle.putString("error", paramFacebookRequestError.toString());
      }
    }
    logAppEventForError(paramString, localBundle);
    AppMethodBeat.o(8082);
  }
  
  private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(8069);
    ShareInternalUtility.handleActivityResult(paramInt1, paramInt2, paramIntent, getResultProcessor(this.facebookDialogAnalyticsBundle));
    clearState();
    AppMethodBeat.o(8069);
  }
  
  /* Error */
  private static void performFirstInitialize()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 8049
    //   6: invokestatic 199	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 585	com/facebook/share/internal/LikeActionController:isInitialized	Z
    //   12: ifeq +13 -> 25
    //   15: sipush 8049
    //   18: invokestatic 225	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: new 437	android/os/Handler
    //   28: dup
    //   29: invokestatic 664	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   32: invokespecial 667	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   35: putstatic 433	com/facebook/share/internal/LikeActionController:handler	Landroid/os/Handler;
    //   38: invokestatic 372	com/facebook/FacebookSdk:getApplicationContext	()Landroid/content/Context;
    //   41: ldc 135
    //   43: iconst_0
    //   44: invokevirtual 616	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   47: ldc 138
    //   49: iconst_1
    //   50: invokeinterface 670 3 0
    //   55: putstatic 327	com/facebook/share/internal/LikeActionController:objectSuffix	I
    //   58: new 453	com/facebook/internal/FileLruCache
    //   61: dup
    //   62: getstatic 207	com/facebook/share/internal/LikeActionController:TAG	Ljava/lang/String;
    //   65: new 672	com/facebook/internal/FileLruCache$Limits
    //   68: dup
    //   69: invokespecial 673	com/facebook/internal/FileLruCache$Limits:<init>	()V
    //   72: invokespecial 676	com/facebook/internal/FileLruCache:<init>	(Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V
    //   75: putstatic 335	com/facebook/share/internal/LikeActionController:controllerDiskCache	Lcom/facebook/internal/FileLruCache;
    //   78: invokestatic 679	com/facebook/share/internal/LikeActionController:registerAccessTokenTracker	()V
    //   81: getstatic 685	com/facebook/internal/CallbackManagerImpl$RequestCodeOffset:Like	Lcom/facebook/internal/CallbackManagerImpl$RequestCodeOffset;
    //   84: invokevirtual 688	com/facebook/internal/CallbackManagerImpl$RequestCodeOffset:toRequestCode	()I
    //   87: new 16	com/facebook/share/internal/LikeActionController$3
    //   90: dup
    //   91: invokespecial 689	com/facebook/share/internal/LikeActionController$3:<init>	()V
    //   94: invokestatic 695	com/facebook/internal/CallbackManagerImpl:registerStaticCallback	(ILcom/facebook/internal/CallbackManagerImpl$Callback;)V
    //   97: iconst_1
    //   98: putstatic 585	com/facebook/share/internal/LikeActionController:isInitialized	Z
    //   101: sipush 8049
    //   104: invokestatic 225	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: goto -86 -> 21
    //   110: astore_0
    //   111: ldc 2
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   110	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	21	110	finally
    //   25	107	110	finally
  }
  
  private void presentLikeDialog(Activity paramActivity, FragmentWrapper paramFragmentWrapper, Bundle paramBundle)
  {
    AppMethodBeat.i(8068);
    Object localObject;
    if (LikeDialog.canShowNativeDialog())
    {
      localObject = "fb_like_control_did_present_dialog";
      if (localObject != null)
      {
        if (this.objectType == null) {
          break label146;
        }
        localObject = this.objectType.toString();
        label38:
        localObject = new LikeContent.Builder().setObjectId(this.objectId).setObjectType((String)localObject).build();
        if (paramFragmentWrapper == null) {
          break label157;
        }
        new LikeDialog(paramFragmentWrapper).show((LikeContent)localObject);
      }
    }
    for (;;)
    {
      saveState(paramBundle);
      getAppEventsLogger().logSdkEvent("fb_like_control_did_present_dialog", null, paramBundle);
      AppMethodBeat.o(8068);
      return;
      if (LikeDialog.canShowWebFallback())
      {
        localObject = "fb_like_control_did_present_fallback_dialog";
        break;
      }
      logAppEventForError("present_dialog", paramBundle);
      Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
      broadcastAction(null, "com.facebook.sdk.LikeActionController.UPDATED");
      localObject = null;
      break;
      label146:
      localObject = LikeView.ObjectType.UNKNOWN.toString();
      break label38;
      label157:
      new LikeDialog(paramActivity).show((LikeContent)localObject);
    }
  }
  
  private void publishAgainIfNeeded(Bundle paramBundle)
  {
    AppMethodBeat.i(8079);
    if ((this.isObjectLiked != this.isObjectLikedOnServer) && (!publishLikeOrUnlikeAsync(this.isObjectLiked, paramBundle))) {
      if (this.isObjectLiked) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      publishDidError(bool);
      AppMethodBeat.o(8079);
      return;
    }
  }
  
  private void publishDidError(boolean paramBoolean)
  {
    AppMethodBeat.i(8065);
    updateLikeState(paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
    broadcastAction(this, "com.facebook.sdk.LikeActionController.DID_ERROR", localBundle);
    AppMethodBeat.o(8065);
  }
  
  private void publishLikeAsync(final Bundle paramBundle)
  {
    AppMethodBeat.i(8075);
    this.isPendingLikeOrUnlike = true;
    fetchVerifiedObjectId(new RequestCompletionCallback()
    {
      public void onComplete()
      {
        AppMethodBeat.i(8016);
        if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
          LikeActionController.access$1500(LikeActionController.this, "com.facebook.sdk.LikeActionController.DID_ERROR", (Bundle)localObject);
          AppMethodBeat.o(8016);
          return;
        }
        Object localObject = new GraphRequestBatch();
        final LikeActionController.PublishLikeRequestWrapper localPublishLikeRequestWrapper = new LikeActionController.PublishLikeRequestWrapper(LikeActionController.this, LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
        localPublishLikeRequestWrapper.addToBatch((GraphRequestBatch)localObject);
        ((GraphRequestBatch)localObject).addCallback(new GraphRequestBatch.Callback()
        {
          public void onBatchCompleted(GraphRequestBatch paramAnonymous2GraphRequestBatch)
          {
            AppMethodBeat.i(8015);
            LikeActionController.access$1802(LikeActionController.this, false);
            if (localPublishLikeRequestWrapper.getError() != null)
            {
              LikeActionController.access$1900(LikeActionController.this, false);
              AppMethodBeat.o(8015);
              return;
            }
            LikeActionController.access$1102(LikeActionController.this, Utility.coerceValueIfNullOrEmpty(localPublishLikeRequestWrapper.unlikeToken, null));
            LikeActionController.access$2002(LikeActionController.this, true);
            LikeActionController.access$1200(LikeActionController.this).logSdkEvent("fb_like_control_did_like", null, LikeActionController.7.this.val$analyticsParameters);
            LikeActionController.access$2100(LikeActionController.this, LikeActionController.7.this.val$analyticsParameters);
            AppMethodBeat.o(8015);
          }
        });
        ((GraphRequestBatch)localObject).executeAsync();
        AppMethodBeat.o(8016);
      }
    });
    AppMethodBeat.o(8075);
  }
  
  private boolean publishLikeOrUnlikeAsync(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(8064);
    if (canUseOGPublish()) {
      if (paramBoolean)
      {
        publishLikeAsync(paramBundle);
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(8064);
      return paramBoolean;
      if (!Utility.isNullOrEmpty(this.unlikeToken))
      {
        publishUnlikeAsync(paramBundle);
        paramBoolean = bool;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  private void publishUnlikeAsync(final Bundle paramBundle)
  {
    AppMethodBeat.i(8076);
    this.isPendingLikeOrUnlike = true;
    GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
    final PublishUnlikeRequestWrapper localPublishUnlikeRequestWrapper = new PublishUnlikeRequestWrapper(this.unlikeToken);
    localPublishUnlikeRequestWrapper.addToBatch(localGraphRequestBatch);
    localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
    {
      public void onBatchCompleted(GraphRequestBatch paramAnonymousGraphRequestBatch)
      {
        AppMethodBeat.i(8017);
        LikeActionController.access$1802(LikeActionController.this, false);
        if (localPublishUnlikeRequestWrapper.getError() != null)
        {
          LikeActionController.access$1900(LikeActionController.this, true);
          AppMethodBeat.o(8017);
          return;
        }
        LikeActionController.access$1102(LikeActionController.this, null);
        LikeActionController.access$2002(LikeActionController.this, false);
        LikeActionController.access$1200(LikeActionController.this).logSdkEvent("fb_like_control_did_unlike", null, paramBundle);
        LikeActionController.access$2100(LikeActionController.this, paramBundle);
        AppMethodBeat.o(8017);
      }
    });
    localGraphRequestBatch.executeAsync();
    AppMethodBeat.o(8076);
  }
  
  private static void putControllerInMemoryCache(String paramString, LikeActionController paramLikeActionController)
  {
    AppMethodBeat.i(8052);
    paramString = getCacheKeyForObjectId(paramString);
    mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(paramString, true));
    cache.put(paramString, paramLikeActionController);
    AppMethodBeat.o(8052);
  }
  
  private void refreshStatusAsync()
  {
    AppMethodBeat.i(8077);
    if (!AccessToken.isCurrentAccessTokenActive())
    {
      refreshStatusViaService();
      AppMethodBeat.o(8077);
      return;
    }
    fetchVerifiedObjectId(new RequestCompletionCallback()
    {
      public void onComplete()
      {
        AppMethodBeat.i(8019);
        switch (LikeActionController.12.$SwitchMap$com$facebook$share$widget$LikeView$ObjectType[LikeActionController.this.objectType.ordinal()])
        {
        }
        for (Object localObject = new LikeActionController.GetOGObjectLikesRequestWrapper(LikeActionController.this, LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);; localObject = new LikeActionController.GetPageLikesRequestWrapper(LikeActionController.this, LikeActionController.this.verifiedObjectId))
        {
          final LikeActionController.GetEngagementRequestWrapper localGetEngagementRequestWrapper = new LikeActionController.GetEngagementRequestWrapper(LikeActionController.this, LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
          GraphRequestBatch localGraphRequestBatch = new GraphRequestBatch();
          ((LikeActionController.LikeRequestWrapper)localObject).addToBatch(localGraphRequestBatch);
          localGetEngagementRequestWrapper.addToBatch(localGraphRequestBatch);
          localGraphRequestBatch.addCallback(new GraphRequestBatch.Callback()
          {
            public void onBatchCompleted(GraphRequestBatch paramAnonymous2GraphRequestBatch)
            {
              AppMethodBeat.i(8018);
              if ((this.val$likeRequestWrapper.getError() != null) || (localGetEngagementRequestWrapper.getError() != null))
              {
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Unable to refresh like state for id: '%s'", new Object[] { LikeActionController.this.objectId });
                AppMethodBeat.o(8018);
                return;
              }
              LikeActionController.access$1300(LikeActionController.this, this.val$likeRequestWrapper.isObjectLiked(), localGetEngagementRequestWrapper.likeCountStringWithLike, localGetEngagementRequestWrapper.likeCountStringWithoutLike, localGetEngagementRequestWrapper.socialSentenceStringWithLike, localGetEngagementRequestWrapper.socialSentenceStringWithoutLike, this.val$likeRequestWrapper.getUnlikeToken());
              AppMethodBeat.o(8018);
            }
          });
          localGraphRequestBatch.executeAsync();
          AppMethodBeat.o(8019);
          return;
        }
      }
    });
    AppMethodBeat.o(8077);
  }
  
  private void refreshStatusViaService()
  {
    AppMethodBeat.i(8078);
    LikeStatusClient localLikeStatusClient = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
    if (!localLikeStatusClient.start())
    {
      AppMethodBeat.o(8078);
      return;
    }
    localLikeStatusClient.setCompletedListener(new PlatformServiceClient.CompletedListener()
    {
      public void completed(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(8005);
        if ((paramAnonymousBundle == null) || (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")))
        {
          AppMethodBeat.o(8005);
          return;
        }
        boolean bool = paramAnonymousBundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
        String str1;
        String str2;
        label66:
        String str3;
        label83:
        String str4;
        if (paramAnonymousBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE"))
        {
          str1 = paramAnonymousBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
            break label150;
          }
          str2 = paramAnonymousBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
            break label162;
          }
          str3 = paramAnonymousBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
            break label174;
          }
          str4 = paramAnonymousBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
          label100:
          if (!paramAnonymousBundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
            break label186;
          }
        }
        label150:
        label162:
        label174:
        label186:
        for (paramAnonymousBundle = paramAnonymousBundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");; paramAnonymousBundle = LikeActionController.this.unlikeToken)
        {
          LikeActionController.access$1300(LikeActionController.this, bool, str1, str2, str3, str4, paramAnonymousBundle);
          AppMethodBeat.o(8005);
          return;
          str1 = LikeActionController.this.likeCountStringWithLike;
          break;
          str2 = LikeActionController.this.likeCountStringWithoutLike;
          break label66;
          str3 = LikeActionController.this.socialSentenceWithLike;
          break label83;
          str4 = LikeActionController.this.socialSentenceWithoutLike;
          break label100;
        }
      }
    });
    AppMethodBeat.o(8078);
  }
  
  private static void registerAccessTokenTracker()
  {
    AppMethodBeat.i(8051);
    accessTokenTracker = new AccessTokenTracker()
    {
      public final void onCurrentAccessTokenChanged(AccessToken paramAnonymousAccessToken1, AccessToken paramAnonymousAccessToken2)
      {
        AppMethodBeat.i(8011);
        paramAnonymousAccessToken1 = FacebookSdk.getApplicationContext();
        if (paramAnonymousAccessToken2 == null)
        {
          LikeActionController.access$302((LikeActionController.objectSuffix + 1) % 1000);
          paramAnonymousAccessToken1.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putInt("OBJECT_SUFFIX", LikeActionController.objectSuffix).apply();
          LikeActionController.cache.clear();
          LikeActionController.controllerDiskCache.clearCache();
        }
        LikeActionController.access$600(null, "com.facebook.sdk.LikeActionController.DID_RESET");
        AppMethodBeat.o(8011);
      }
    };
    AppMethodBeat.o(8051);
  }
  
  private void saveState(Bundle paramBundle)
  {
    AppMethodBeat.i(8071);
    storeObjectIdForPendingController(this.objectId);
    this.facebookDialogAnalyticsBundle = paramBundle;
    serializeToDiskAsync(this);
    AppMethodBeat.o(8071);
  }
  
  private static void serializeToDiskAsync(LikeActionController paramLikeActionController)
  {
    AppMethodBeat.i(8054);
    String str = serializeToJson(paramLikeActionController);
    paramLikeActionController = getCacheKeyForObjectId(paramLikeActionController.objectId);
    if ((!Utility.isNullOrEmpty(str)) && (!Utility.isNullOrEmpty(paramLikeActionController))) {
      diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(paramLikeActionController, str));
    }
    AppMethodBeat.o(8054);
  }
  
  private static void serializeToDiskSynchronously(String paramString1, String paramString2)
  {
    AppMethodBeat.i(8055);
    String str2 = null;
    String str1 = null;
    try
    {
      paramString1 = controllerDiskCache.openPutStream(paramString1);
      str1 = paramString1;
      str2 = paramString1;
      paramString1.write(paramString2.getBytes());
      return;
    }
    catch (IOException paramString1)
    {
      return;
    }
    finally
    {
      if (str2 != null) {
        Utility.closeQuietly(str2);
      }
      AppMethodBeat.o(8055);
    }
    AppMethodBeat.o(8055);
  }
  
  private static String serializeToJson(LikeActionController paramLikeActionController)
  {
    AppMethodBeat.i(8058);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("com.facebook.share.internal.LikeActionController.version", 3);
      localJSONObject.put("object_id", paramLikeActionController.objectId);
      localJSONObject.put("object_type", paramLikeActionController.objectType.getValue());
      localJSONObject.put("like_count_string_with_like", paramLikeActionController.likeCountStringWithLike);
      localJSONObject.put("like_count_string_without_like", paramLikeActionController.likeCountStringWithoutLike);
      localJSONObject.put("social_sentence_with_like", paramLikeActionController.socialSentenceWithLike);
      localJSONObject.put("social_sentence_without_like", paramLikeActionController.socialSentenceWithoutLike);
      localJSONObject.put("is_object_liked", paramLikeActionController.isObjectLiked);
      localJSONObject.put("unlike_token", paramLikeActionController.unlikeToken);
      if (paramLikeActionController.facebookDialogAnalyticsBundle != null)
      {
        paramLikeActionController = BundleJSONConverter.convertToJSON(paramLikeActionController.facebookDialogAnalyticsBundle);
        if (paramLikeActionController != null) {
          localJSONObject.put("facebook_dialog_analytics_bundle", paramLikeActionController);
        }
      }
      paramLikeActionController = localJSONObject.toString();
      AppMethodBeat.o(8058);
      return paramLikeActionController;
    }
    catch (JSONException paramLikeActionController)
    {
      AppMethodBeat.o(8058);
    }
    return null;
  }
  
  private static void storeObjectIdForPendingController(String paramString)
  {
    AppMethodBeat.i(8073);
    objectIdForPendingController = paramString;
    FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0).edit().putString("PENDING_CONTROLLER_KEY", objectIdForPendingController).apply();
    AppMethodBeat.o(8073);
  }
  
  private void updateLikeState(boolean paramBoolean)
  {
    AppMethodBeat.i(8066);
    updateState(paramBoolean, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
    AppMethodBeat.o(8066);
  }
  
  private void updateState(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(8067);
    paramString1 = Utility.coerceValueIfNullOrEmpty(paramString1, null);
    paramString2 = Utility.coerceValueIfNullOrEmpty(paramString2, null);
    paramString3 = Utility.coerceValueIfNullOrEmpty(paramString3, null);
    paramString4 = Utility.coerceValueIfNullOrEmpty(paramString4, null);
    paramString5 = Utility.coerceValueIfNullOrEmpty(paramString5, null);
    if ((paramBoolean != this.isObjectLiked) || (!Utility.areObjectsEqual(paramString1, this.likeCountStringWithLike)) || (!Utility.areObjectsEqual(paramString2, this.likeCountStringWithoutLike)) || (!Utility.areObjectsEqual(paramString3, this.socialSentenceWithLike)) || (!Utility.areObjectsEqual(paramString4, this.socialSentenceWithoutLike)) || (!Utility.areObjectsEqual(paramString5, this.unlikeToken))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(8067);
      return;
    }
    this.isObjectLiked = paramBoolean;
    this.likeCountStringWithLike = paramString1;
    this.likeCountStringWithoutLike = paramString2;
    this.socialSentenceWithLike = paramString3;
    this.socialSentenceWithoutLike = paramString4;
    this.unlikeToken = paramString5;
    serializeToDiskAsync(this);
    broadcastAction(this, "com.facebook.sdk.LikeActionController.UPDATED");
    AppMethodBeat.o(8067);
  }
  
  private static void verifyControllerAndInvokeCallback(LikeActionController paramLikeActionController, LikeView.ObjectType paramObjectType, CreationCallback paramCreationCallback)
  {
    AppMethodBeat.i(8047);
    LikeView.ObjectType localObjectType = ShareInternalUtility.getMostSpecificObjectType(paramObjectType, paramLikeActionController.objectType);
    if (localObjectType == null)
    {
      paramObjectType = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", new Object[] { paramLikeActionController.objectId, paramLikeActionController.objectType.toString(), paramObjectType.toString() });
      paramLikeActionController = null;
    }
    for (;;)
    {
      invokeCallbackWithController(paramCreationCallback, paramLikeActionController, paramObjectType);
      AppMethodBeat.o(8047);
      return;
      paramLikeActionController.objectType = localObjectType;
      paramObjectType = null;
    }
  }
  
  @Deprecated
  public String getLikeCountString()
  {
    if (this.isObjectLiked) {
      return this.likeCountStringWithLike;
    }
    return this.likeCountStringWithoutLike;
  }
  
  @Deprecated
  public String getObjectId()
  {
    return this.objectId;
  }
  
  @Deprecated
  public String getSocialSentence()
  {
    if (this.isObjectLiked) {
      return this.socialSentenceWithLike;
    }
    return this.socialSentenceWithoutLike;
  }
  
  @Deprecated
  public boolean isObjectLiked()
  {
    return this.isObjectLiked;
  }
  
  @Deprecated
  public boolean shouldEnableView()
  {
    return false;
  }
  
  @Deprecated
  public void toggleLike(Activity paramActivity, FragmentWrapper paramFragmentWrapper, Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(8062);
    if (!this.isObjectLiked) {
      bool1 = true;
    }
    while (canUseOGPublish())
    {
      updateLikeState(bool1);
      if (this.isPendingLikeOrUnlike)
      {
        getAppEventsLogger().logSdkEvent("fb_like_control_did_undo_quickly", null, paramBundle);
        AppMethodBeat.o(8062);
        return;
        bool1 = false;
      }
      else
      {
        if (publishLikeOrUnlikeAsync(bool1, paramBundle)) {
          break label96;
        }
        if (bool1) {
          break label103;
        }
      }
    }
    label96:
    label103:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      updateLikeState(bool1);
      presentLikeDialog(paramActivity, paramFragmentWrapper, paramBundle);
      AppMethodBeat.o(8062);
      return;
    }
  }
  
  abstract class AbstractRequestWrapper
    implements LikeActionController.RequestWrapper
  {
    protected FacebookRequestError error;
    protected String objectId;
    protected LikeView.ObjectType objectType;
    private GraphRequest request;
    
    protected AbstractRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      this.objectId = paramString;
      this.objectType = paramObjectType;
    }
    
    public void addToBatch(GraphRequestBatch paramGraphRequestBatch)
    {
      paramGraphRequestBatch.add(this.request);
    }
    
    public FacebookRequestError getError()
    {
      return this.error;
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error running request for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
    }
    
    protected abstract void processSuccess(GraphResponse paramGraphResponse);
    
    protected void setRequest(GraphRequest paramGraphRequest)
    {
      this.request = paramGraphRequest;
      paramGraphRequest.setVersion(FacebookSdk.getGraphApiVersion());
      paramGraphRequest.setCallback(new GraphRequest.Callback()
      {
        public void onCompleted(GraphResponse paramAnonymousGraphResponse)
        {
          AppMethodBeat.i(8020);
          LikeActionController.AbstractRequestWrapper.this.error = paramAnonymousGraphResponse.getError();
          if (LikeActionController.AbstractRequestWrapper.this.error != null)
          {
            LikeActionController.AbstractRequestWrapper.this.processError(LikeActionController.AbstractRequestWrapper.this.error);
            AppMethodBeat.o(8020);
            return;
          }
          LikeActionController.AbstractRequestWrapper.this.processSuccess(paramAnonymousGraphResponse);
          AppMethodBeat.o(8020);
        }
      });
    }
  }
  
  static class CreateLikeActionControllerWorkItem
    implements Runnable
  {
    private LikeActionController.CreationCallback callback;
    private String objectId;
    private LikeView.ObjectType objectType;
    
    CreateLikeActionControllerWorkItem(String paramString, LikeView.ObjectType paramObjectType, LikeActionController.CreationCallback paramCreationCallback)
    {
      this.objectId = paramString;
      this.objectType = paramObjectType;
      this.callback = paramCreationCallback;
    }
    
    public void run()
    {
      AppMethodBeat.i(8021);
      LikeActionController.access$2700(this.objectId, this.objectType, this.callback);
      AppMethodBeat.o(8021);
    }
  }
  
  @Deprecated
  public static abstract interface CreationCallback
  {
    public abstract void onComplete(LikeActionController paramLikeActionController, FacebookException paramFacebookException);
  }
  
  class GetEngagementRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    String likeCountStringWithLike;
    String likeCountStringWithoutLike;
    String socialSentenceStringWithLike;
    String socialSentenceStringWithoutLike;
    
    GetEngagementRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      AppMethodBeat.i(8022);
      this.likeCountStringWithLike = LikeActionController.this.likeCountStringWithLike;
      this.likeCountStringWithoutLike = LikeActionController.this.likeCountStringWithoutLike;
      this.socialSentenceStringWithLike = LikeActionController.this.socialSentenceWithLike;
      this.socialSentenceStringWithoutLike = LikeActionController.this.socialSentenceWithoutLike;
      this$1 = new Bundle();
      LikeActionController.this.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
      LikeActionController.this.putString("locale", Locale.getDefault().toString());
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, LikeActionController.this, HttpMethod.GET));
      AppMethodBeat.o(8022);
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      AppMethodBeat.i(8024);
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "get_engagement", paramFacebookRequestError);
      AppMethodBeat.o(8024);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      AppMethodBeat.i(8023);
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), "engagement");
      if (paramGraphResponse != null)
      {
        this.likeCountStringWithLike = paramGraphResponse.optString("count_string_with_like", this.likeCountStringWithLike);
        this.likeCountStringWithoutLike = paramGraphResponse.optString("count_string_without_like", this.likeCountStringWithoutLike);
        this.socialSentenceStringWithLike = paramGraphResponse.optString("social_sentence_with_like", this.socialSentenceStringWithLike);
        this.socialSentenceStringWithoutLike = paramGraphResponse.optString("social_sentence_without_like", this.socialSentenceStringWithoutLike);
      }
      AppMethodBeat.o(8023);
    }
  }
  
  class GetOGObjectIdRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    String verifiedObjectId;
    
    GetOGObjectIdRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      AppMethodBeat.i(8025);
      this$1 = new Bundle();
      LikeActionController.this.putString("fields", "og_object.fields(id)");
      LikeActionController.this.putString("ids", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", LikeActionController.this, HttpMethod.GET));
      AppMethodBeat.o(8025);
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      AppMethodBeat.i(8026);
      if (paramFacebookRequestError.getErrorMessage().contains("og_object"))
      {
        this.error = null;
        AppMethodBeat.o(8026);
        return;
      }
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
      AppMethodBeat.o(8026);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      AppMethodBeat.i(8027);
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), this.objectId);
      if (paramGraphResponse != null)
      {
        paramGraphResponse = paramGraphResponse.optJSONObject("og_object");
        if (paramGraphResponse != null) {
          this.verifiedObjectId = paramGraphResponse.optString("id");
        }
      }
      AppMethodBeat.o(8027);
    }
  }
  
  class GetOGObjectLikesRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
    implements LikeActionController.LikeRequestWrapper
  {
    private final String objectId;
    private boolean objectIsLiked;
    private final LikeView.ObjectType objectType;
    private String unlikeToken;
    
    GetOGObjectLikesRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      AppMethodBeat.i(8028);
      this.objectIsLiked = LikeActionController.this.isObjectLiked;
      this.objectId = paramString;
      this.objectType = paramObjectType;
      this$1 = new Bundle();
      LikeActionController.this.putString("fields", "id,application");
      LikeActionController.this.putString("object", this.objectId);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", LikeActionController.this, HttpMethod.GET));
      AppMethodBeat.o(8028);
    }
    
    public String getUnlikeToken()
    {
      return this.unlikeToken;
    }
    
    public boolean isObjectLiked()
    {
      return this.objectIsLiked;
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      AppMethodBeat.i(8030);
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "get_og_object_like", paramFacebookRequestError);
      AppMethodBeat.o(8030);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      AppMethodBeat.i(8029);
      paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
      if (paramGraphResponse != null)
      {
        int i = 0;
        while (i < paramGraphResponse.length())
        {
          JSONObject localJSONObject1 = paramGraphResponse.optJSONObject(i);
          if (localJSONObject1 != null)
          {
            this.objectIsLiked = true;
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject("application");
            AccessToken localAccessToken = AccessToken.getCurrentAccessToken();
            if ((localJSONObject2 != null) && (AccessToken.isCurrentAccessTokenActive()) && (Utility.areObjectsEqual(localAccessToken.getApplicationId(), localJSONObject2.optString("id")))) {
              this.unlikeToken = localJSONObject1.optString("id");
            }
          }
          i += 1;
        }
      }
      AppMethodBeat.o(8029);
    }
  }
  
  class GetPageIdRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    boolean objectIsPage;
    String verifiedObjectId;
    
    GetPageIdRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      AppMethodBeat.i(8031);
      this$1 = new Bundle();
      LikeActionController.this.putString("fields", "id");
      LikeActionController.this.putString("ids", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", LikeActionController.this, HttpMethod.GET));
      AppMethodBeat.o(8031);
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      AppMethodBeat.i(8033);
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
      AppMethodBeat.o(8033);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      AppMethodBeat.i(8032);
      paramGraphResponse = Utility.tryGetJSONObjectFromResponse(paramGraphResponse.getJSONObject(), this.objectId);
      if (paramGraphResponse != null)
      {
        this.verifiedObjectId = paramGraphResponse.optString("id");
        if (Utility.isNullOrEmpty(this.verifiedObjectId)) {
          break label56;
        }
      }
      label56:
      for (boolean bool = true;; bool = false)
      {
        this.objectIsPage = bool;
        AppMethodBeat.o(8032);
        return;
      }
    }
  }
  
  class GetPageLikesRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
    implements LikeActionController.LikeRequestWrapper
  {
    private boolean objectIsLiked;
    private String pageId;
    
    GetPageLikesRequestWrapper(String paramString)
    {
      super(paramString, LikeView.ObjectType.PAGE);
      AppMethodBeat.i(8034);
      this.objectIsLiked = LikeActionController.this.isObjectLiked;
      this.pageId = paramString;
      this$1 = new Bundle();
      LikeActionController.this.putString("fields", "id");
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/".concat(String.valueOf(paramString)), LikeActionController.this, HttpMethod.GET));
      AppMethodBeat.o(8034);
    }
    
    public String getUnlikeToken()
    {
      return null;
    }
    
    public boolean isObjectLiked()
    {
      return this.objectIsLiked;
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      AppMethodBeat.i(8036);
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", new Object[] { this.pageId, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "get_page_like", paramFacebookRequestError);
      AppMethodBeat.o(8036);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      AppMethodBeat.i(8035);
      paramGraphResponse = Utility.tryGetJSONArrayFromResponse(paramGraphResponse.getJSONObject(), "data");
      if ((paramGraphResponse != null) && (paramGraphResponse.length() > 0)) {
        this.objectIsLiked = true;
      }
      AppMethodBeat.o(8035);
    }
  }
  
  static abstract interface LikeRequestWrapper
    extends LikeActionController.RequestWrapper
  {
    public abstract String getUnlikeToken();
    
    public abstract boolean isObjectLiked();
  }
  
  static class MRUCacheWorkItem
    implements Runnable
  {
    private static ArrayList<String> mruCachedItems;
    private String cacheItem;
    private boolean shouldTrim;
    
    static
    {
      AppMethodBeat.i(8038);
      mruCachedItems = new ArrayList();
      AppMethodBeat.o(8038);
    }
    
    MRUCacheWorkItem(String paramString, boolean paramBoolean)
    {
      this.cacheItem = paramString;
      this.shouldTrim = paramBoolean;
    }
    
    public void run()
    {
      AppMethodBeat.i(8037);
      if (this.cacheItem != null)
      {
        mruCachedItems.remove(this.cacheItem);
        mruCachedItems.add(0, this.cacheItem);
      }
      if ((this.shouldTrim) && (mruCachedItems.size() >= 128)) {
        while (64 < mruCachedItems.size())
        {
          Object localObject = mruCachedItems;
          localObject = (String)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
          LikeActionController.cache.remove(localObject);
        }
      }
      AppMethodBeat.o(8037);
    }
  }
  
  class PublishLikeRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    String unlikeToken;
    
    PublishLikeRequestWrapper(String paramString, LikeView.ObjectType paramObjectType)
    {
      super(paramString, paramObjectType);
      AppMethodBeat.i(8039);
      this$1 = new Bundle();
      LikeActionController.this.putString("object", paramString);
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", LikeActionController.this, HttpMethod.POST));
      AppMethodBeat.o(8039);
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      AppMethodBeat.i(8041);
      if (paramFacebookRequestError.getErrorCode() == 3501)
      {
        this.error = null;
        AppMethodBeat.o(8041);
        return;
      }
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", new Object[] { this.objectId, this.objectType, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "publish_like", paramFacebookRequestError);
      AppMethodBeat.o(8041);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse)
    {
      AppMethodBeat.i(8040);
      this.unlikeToken = Utility.safeGetStringFromResponse(paramGraphResponse.getJSONObject(), "id");
      AppMethodBeat.o(8040);
    }
  }
  
  class PublishUnlikeRequestWrapper
    extends LikeActionController.AbstractRequestWrapper
  {
    private String unlikeToken;
    
    PublishUnlikeRequestWrapper(String paramString)
    {
      super(null, null);
      AppMethodBeat.i(8042);
      this.unlikeToken = paramString;
      setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), paramString, null, HttpMethod.DELETE));
      AppMethodBeat.o(8042);
    }
    
    protected void processError(FacebookRequestError paramFacebookRequestError)
    {
      AppMethodBeat.i(8043);
      Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", new Object[] { this.unlikeToken, paramFacebookRequestError });
      LikeActionController.access$2400(LikeActionController.this, "publish_unlike", paramFacebookRequestError);
      AppMethodBeat.o(8043);
    }
    
    protected void processSuccess(GraphResponse paramGraphResponse) {}
  }
  
  static abstract interface RequestCompletionCallback
  {
    public abstract void onComplete();
  }
  
  static abstract interface RequestWrapper
  {
    public abstract void addToBatch(GraphRequestBatch paramGraphRequestBatch);
    
    public abstract FacebookRequestError getError();
  }
  
  static class SerializeToDiskWorkItem
    implements Runnable
  {
    private String cacheKey;
    private String controllerJson;
    
    SerializeToDiskWorkItem(String paramString1, String paramString2)
    {
      this.cacheKey = paramString1;
      this.controllerJson = paramString2;
    }
    
    public void run()
    {
      AppMethodBeat.i(8044);
      LikeActionController.access$2600(this.cacheKey, this.controllerJson);
      AppMethodBeat.o(8044);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController
 * JD-Core Version:    0.7.0.1
 */