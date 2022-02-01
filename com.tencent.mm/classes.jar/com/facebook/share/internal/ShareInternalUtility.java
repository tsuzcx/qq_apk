package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Type;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView.ObjectType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareInternalUtility
{
  public static final String MY_PHOTOS = "me/photos";
  private static final String MY_STAGING_RESOURCES = "me/staging_resources";
  private static final String STAGING_PARAM = "file";
  
  private static AppCall getAppCallFromActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(8305);
    paramIntent = NativeProtocol.getCallIdFromIntent(paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(8305);
      return null;
    }
    paramIntent = AppCall.finishPendingCall(paramIntent, paramInt1);
    AppMethodBeat.o(8305);
    return paramIntent;
  }
  
  private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID paramUUID, Uri paramUri, Bitmap paramBitmap)
  {
    AppMethodBeat.i(8318);
    Object localObject = null;
    if (paramBitmap != null) {
      paramBitmap = NativeAppCallAttachmentStore.createAttachment(paramUUID, paramBitmap);
    }
    for (;;)
    {
      AppMethodBeat.o(8318);
      return paramBitmap;
      paramBitmap = localObject;
      if (paramUri != null) {
        paramBitmap = NativeAppCallAttachmentStore.createAttachment(paramUUID, paramUri);
      }
    }
  }
  
  private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID paramUUID, ShareMedia paramShareMedia)
  {
    AppMethodBeat.i(8317);
    Bitmap localBitmap;
    if ((paramShareMedia instanceof SharePhoto))
    {
      paramShareMedia = (SharePhoto)paramShareMedia;
      localBitmap = paramShareMedia.getBitmap();
      paramShareMedia = paramShareMedia.getImageUrl();
    }
    for (;;)
    {
      paramUUID = getAttachment(paramUUID, paramShareMedia, localBitmap);
      AppMethodBeat.o(8317);
      return paramUUID;
      if ((paramShareMedia instanceof ShareVideo))
      {
        paramShareMedia = ((ShareVideo)paramShareMedia).getLocalUrl();
        localBitmap = null;
      }
      else
      {
        paramShareMedia = null;
        localBitmap = null;
      }
    }
  }
  
  public static Bundle getBackgroundAssetMediaInfo(final ShareStoryContent paramShareStoryContent, UUID paramUUID)
  {
    AppMethodBeat.i(8329);
    if ((paramShareStoryContent == null) || (paramShareStoryContent.getBackgroundAsset() == null))
    {
      AppMethodBeat.o(8329);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramShareStoryContent.getBackgroundAsset());
    paramShareStoryContent = new ArrayList();
    paramUUID = Utility.map(localArrayList, new Utility.Mapper()
    {
      public final Bundle apply(ShareMedia paramAnonymousShareMedia)
      {
        AppMethodBeat.i(8284);
        NativeAppCallAttachmentStore.Attachment localAttachment = ShareInternalUtility.access$000(this.val$appCallId, paramAnonymousShareMedia);
        paramShareStoryContent.add(localAttachment);
        Bundle localBundle = new Bundle();
        localBundle.putString("type", paramAnonymousShareMedia.getMediaType().name());
        localBundle.putString("uri", localAttachment.getAttachmentUrl());
        paramAnonymousShareMedia = ShareInternalUtility.getUriExtension(localAttachment.getOriginalUri());
        if (paramAnonymousShareMedia != null) {
          Utility.putNonEmptyString(localBundle, "extension", paramAnonymousShareMedia);
        }
        AppMethodBeat.o(8284);
        return localBundle;
      }
    });
    NativeAppCallAttachmentStore.addAttachments(paramShareStoryContent);
    paramShareStoryContent = (Bundle)paramUUID.get(0);
    AppMethodBeat.o(8329);
    return paramShareStoryContent;
  }
  
  public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String paramString)
  {
    AppMethodBeat.i(8316);
    Object localObject2 = null;
    int i = paramString.indexOf(':');
    Object localObject1 = localObject2;
    String str = paramString;
    if (i != -1)
    {
      localObject1 = localObject2;
      str = paramString;
      if (paramString.length() > i + 1)
      {
        localObject1 = paramString.substring(0, i);
        str = paramString.substring(i + 1);
      }
    }
    paramString = new Pair(localObject1, str);
    AppMethodBeat.o(8316);
    return paramString;
  }
  
  public static List<Bundle> getMediaInfos(final ShareMediaContent paramShareMediaContent, UUID paramUUID)
  {
    AppMethodBeat.i(8310);
    List localList;
    if (paramShareMediaContent != null)
    {
      localList = paramShareMediaContent.getMedia();
      if (localList != null) {}
    }
    else
    {
      AppMethodBeat.o(8310);
      return null;
    }
    paramShareMediaContent = new ArrayList();
    paramUUID = Utility.map(localList, new Utility.Mapper()
    {
      public final Bundle apply(ShareMedia paramAnonymousShareMedia)
      {
        AppMethodBeat.i(8292);
        NativeAppCallAttachmentStore.Attachment localAttachment = ShareInternalUtility.access$000(this.val$appCallId, paramAnonymousShareMedia);
        paramShareMediaContent.add(localAttachment);
        Bundle localBundle = new Bundle();
        localBundle.putString("type", paramAnonymousShareMedia.getMediaType().name());
        localBundle.putString("uri", localAttachment.getAttachmentUrl());
        AppMethodBeat.o(8292);
        return localBundle;
      }
    });
    NativeAppCallAttachmentStore.addAttachments(paramShareMediaContent);
    AppMethodBeat.o(8310);
    return paramUUID;
  }
  
  public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType paramObjectType1, LikeView.ObjectType paramObjectType2)
  {
    if (paramObjectType1 == paramObjectType2) {}
    do
    {
      return paramObjectType1;
      if (paramObjectType1 == LikeView.ObjectType.UNKNOWN) {
        return paramObjectType2;
      }
    } while (paramObjectType2 == LikeView.ObjectType.UNKNOWN);
    return null;
  }
  
  public static String getNativeDialogCompletionGesture(Bundle paramBundle)
  {
    AppMethodBeat.i(8301);
    if (paramBundle.containsKey("completionGesture"))
    {
      paramBundle = paramBundle.getString("completionGesture");
      AppMethodBeat.o(8301);
      return paramBundle;
    }
    paramBundle = paramBundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
    AppMethodBeat.o(8301);
    return paramBundle;
  }
  
  public static List<String> getPhotoUrls(SharePhotoContent paramSharePhotoContent, UUID paramUUID)
  {
    AppMethodBeat.i(8308);
    if (paramSharePhotoContent != null)
    {
      paramSharePhotoContent = paramSharePhotoContent.getPhotos();
      if (paramSharePhotoContent != null) {}
    }
    else
    {
      AppMethodBeat.o(8308);
      return null;
    }
    paramSharePhotoContent = Utility.map(paramSharePhotoContent, new Utility.Mapper()
    {
      public final NativeAppCallAttachmentStore.Attachment apply(SharePhoto paramAnonymousSharePhoto)
      {
        AppMethodBeat.i(8288);
        paramAnonymousSharePhoto = ShareInternalUtility.access$000(this.val$appCallId, paramAnonymousSharePhoto);
        AppMethodBeat.o(8288);
        return paramAnonymousSharePhoto;
      }
    });
    paramUUID = Utility.map(paramSharePhotoContent, new Utility.Mapper()
    {
      public final String apply(NativeAppCallAttachmentStore.Attachment paramAnonymousAttachment)
      {
        AppMethodBeat.i(8290);
        paramAnonymousAttachment = paramAnonymousAttachment.getAttachmentUrl();
        AppMethodBeat.o(8290);
        return paramAnonymousAttachment;
      }
    });
    NativeAppCallAttachmentStore.addAttachments(paramSharePhotoContent);
    AppMethodBeat.o(8308);
    return paramUUID;
  }
  
  public static String getShareDialogPostId(Bundle paramBundle)
  {
    AppMethodBeat.i(8302);
    if (paramBundle.containsKey("postId"))
    {
      paramBundle = paramBundle.getString("postId");
      AppMethodBeat.o(8302);
      return paramBundle;
    }
    if (paramBundle.containsKey("com.facebook.platform.extra.POST_ID"))
    {
      paramBundle = paramBundle.getString("com.facebook.platform.extra.POST_ID");
      AppMethodBeat.o(8302);
      return paramBundle;
    }
    paramBundle = paramBundle.getString("post_id");
    AppMethodBeat.o(8302);
    return paramBundle;
  }
  
  public static ResultProcessor getShareResultProcessor(final FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    AppMethodBeat.i(8304);
    paramFacebookCallback = new ResultProcessor(paramFacebookCallback)
    {
      public final void onCancel(AppCall paramAnonymousAppCall)
      {
        AppMethodBeat.i(8280);
        ShareInternalUtility.invokeOnCancelCallback(paramFacebookCallback);
        AppMethodBeat.o(8280);
      }
      
      public final void onError(AppCall paramAnonymousAppCall, FacebookException paramAnonymousFacebookException)
      {
        AppMethodBeat.i(8281);
        ShareInternalUtility.invokeOnErrorCallback(paramFacebookCallback, paramAnonymousFacebookException);
        AppMethodBeat.o(8281);
      }
      
      public final void onSuccess(AppCall paramAnonymousAppCall, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(8279);
        if (paramAnonymousBundle != null)
        {
          paramAnonymousAppCall = ShareInternalUtility.getNativeDialogCompletionGesture(paramAnonymousBundle);
          if ((paramAnonymousAppCall == null) || ("post".equalsIgnoreCase(paramAnonymousAppCall)))
          {
            paramAnonymousAppCall = ShareInternalUtility.getShareDialogPostId(paramAnonymousBundle);
            ShareInternalUtility.invokeOnSuccessCallback(paramFacebookCallback, paramAnonymousAppCall);
            AppMethodBeat.o(8279);
            return;
          }
          if ("cancel".equalsIgnoreCase(paramAnonymousAppCall))
          {
            ShareInternalUtility.invokeOnCancelCallback(paramFacebookCallback);
            AppMethodBeat.o(8279);
            return;
          }
          ShareInternalUtility.invokeOnErrorCallback(paramFacebookCallback, new FacebookException("UnknownError"));
        }
        AppMethodBeat.o(8279);
      }
    };
    AppMethodBeat.o(8304);
    return paramFacebookCallback;
  }
  
  public static Bundle getStickerUrl(ShareStoryContent paramShareStoryContent, UUID paramUUID)
  {
    AppMethodBeat.i(8328);
    if ((paramShareStoryContent == null) || (paramShareStoryContent.getStickerAsset() == null))
    {
      AppMethodBeat.o(8328);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramShareStoryContent.getStickerAsset());
    paramShareStoryContent = Utility.map(localArrayList, new Utility.Mapper()
    {
      public final NativeAppCallAttachmentStore.Attachment apply(SharePhoto paramAnonymousSharePhoto)
      {
        AppMethodBeat.i(8296);
        paramAnonymousSharePhoto = ShareInternalUtility.access$000(this.val$appCallId, paramAnonymousSharePhoto);
        AppMethodBeat.o(8296);
        return paramAnonymousSharePhoto;
      }
    });
    paramUUID = Utility.map(paramShareStoryContent, new Utility.Mapper()
    {
      public final Bundle apply(NativeAppCallAttachmentStore.Attachment paramAnonymousAttachment)
      {
        AppMethodBeat.i(8282);
        Bundle localBundle = new Bundle();
        localBundle.putString("uri", paramAnonymousAttachment.getAttachmentUrl());
        paramAnonymousAttachment = ShareInternalUtility.getUriExtension(paramAnonymousAttachment.getOriginalUri());
        if (paramAnonymousAttachment != null) {
          Utility.putNonEmptyString(localBundle, "extension", paramAnonymousAttachment);
        }
        AppMethodBeat.o(8282);
        return localBundle;
      }
    });
    NativeAppCallAttachmentStore.addAttachments(paramShareStoryContent);
    paramShareStoryContent = (Bundle)paramUUID.get(0);
    AppMethodBeat.o(8328);
    return paramShareStoryContent;
  }
  
  public static Bundle getTextureUrlBundle(ShareCameraEffectContent paramShareCameraEffectContent, UUID paramUUID)
  {
    AppMethodBeat.i(8311);
    if (paramShareCameraEffectContent != null)
    {
      paramShareCameraEffectContent = paramShareCameraEffectContent.getTextures();
      if (paramShareCameraEffectContent != null) {}
    }
    else
    {
      AppMethodBeat.o(8311);
      return null;
    }
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramShareCameraEffectContent.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      NativeAppCallAttachmentStore.Attachment localAttachment = getAttachment(paramUUID, paramShareCameraEffectContent.getTextureUri(str), paramShareCameraEffectContent.getTextureBitmap(str));
      localArrayList.add(localAttachment);
      localBundle.putString(str, localAttachment.getAttachmentUrl());
    }
    NativeAppCallAttachmentStore.addAttachments(localArrayList);
    AppMethodBeat.o(8311);
    return localBundle;
  }
  
  public static String getUriExtension(Uri paramUri)
  {
    AppMethodBeat.i(8330);
    if (paramUri == null)
    {
      AppMethodBeat.o(8330);
      return null;
    }
    paramUri = paramUri.toString();
    int i = paramUri.lastIndexOf('.');
    if (i == -1)
    {
      AppMethodBeat.o(8330);
      return null;
    }
    paramUri = paramUri.substring(i);
    AppMethodBeat.o(8330);
    return paramUri;
  }
  
  public static String getVideoUrl(ShareVideoContent paramShareVideoContent, UUID paramUUID)
  {
    AppMethodBeat.i(8309);
    if ((paramShareVideoContent == null) || (paramShareVideoContent.getVideo() == null))
    {
      AppMethodBeat.o(8309);
      return null;
    }
    paramShareVideoContent = NativeAppCallAttachmentStore.createAttachment(paramUUID, paramShareVideoContent.getVideo().getLocalUrl());
    paramUUID = new ArrayList(1);
    paramUUID.add(paramShareVideoContent);
    NativeAppCallAttachmentStore.addAttachments(paramUUID);
    paramShareVideoContent = paramShareVideoContent.getAttachmentUrl();
    AppMethodBeat.o(8309);
    return paramShareVideoContent;
  }
  
  public static boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent, ResultProcessor paramResultProcessor)
  {
    AppMethodBeat.i(8303);
    AppCall localAppCall = getAppCallFromActivityResult(paramInt1, paramInt2, paramIntent);
    if (localAppCall == null)
    {
      AppMethodBeat.o(8303);
      return false;
    }
    NativeAppCallAttachmentStore.cleanupAttachmentsForCall(localAppCall.getCallId());
    if (paramResultProcessor == null)
    {
      AppMethodBeat.o(8303);
      return true;
    }
    FacebookException localFacebookException = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(paramIntent));
    if (localFacebookException != null) {
      if ((localFacebookException instanceof FacebookOperationCanceledException)) {
        paramResultProcessor.onCancel(localAppCall);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(8303);
      return true;
      paramResultProcessor.onError(localAppCall, localFacebookException);
      continue;
      paramResultProcessor.onSuccess(localAppCall, NativeProtocol.getSuccessResultsFromIntent(paramIntent));
    }
  }
  
  public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    AppMethodBeat.i(8299);
    invokeOnErrorCallback(paramFacebookCallback, paramString);
    AppMethodBeat.o(8299);
  }
  
  public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> paramFacebookCallback, Exception paramException)
  {
    AppMethodBeat.i(8298);
    if ((paramException instanceof FacebookException))
    {
      invokeOnErrorCallback(paramFacebookCallback, (FacebookException)paramException);
      AppMethodBeat.o(8298);
      return;
    }
    invokeCallbackWithError(paramFacebookCallback, "Error preparing share content: " + paramException.getLocalizedMessage());
    AppMethodBeat.o(8298);
  }
  
  public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(8300);
    Object localObject = paramGraphResponse.getError();
    if (localObject != null)
    {
      localObject = ((FacebookRequestError)localObject).getErrorMessage();
      paramString = (String)localObject;
      if (Utility.isNullOrEmpty((String)localObject)) {
        paramString = "Unexpected error sharing.";
      }
      invokeOnErrorCallback(paramFacebookCallback, paramGraphResponse, paramString);
      AppMethodBeat.o(8300);
      return;
    }
    invokeOnSuccessCallback(paramFacebookCallback, paramString);
    AppMethodBeat.o(8300);
  }
  
  static void invokeOnCancelCallback(FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    AppMethodBeat.i(8319);
    logShareResult("cancelled", null);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onCancel();
    }
    AppMethodBeat.o(8319);
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(8323);
    logShareResult("error", paramFacebookException.getMessage());
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(paramFacebookException);
    }
    AppMethodBeat.o(8323);
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, GraphResponse paramGraphResponse, String paramString)
  {
    AppMethodBeat.i(8321);
    logShareResult("error", paramString);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(new FacebookGraphResponseException(paramGraphResponse, paramString));
    }
    AppMethodBeat.o(8321);
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    AppMethodBeat.i(8322);
    logShareResult("error", paramString);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(new FacebookException(paramString));
    }
    AppMethodBeat.o(8322);
  }
  
  static void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    AppMethodBeat.i(8320);
    logShareResult("succeeded", null);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onSuccess(new Sharer.Result(paramString));
    }
    AppMethodBeat.o(8320);
  }
  
  private static void logShareResult(String paramString1, String paramString2)
  {
    AppMethodBeat.i(8324);
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
    Bundle localBundle = new Bundle();
    localBundle.putString("fb_share_dialog_outcome", paramString1);
    if (paramString2 != null) {
      localBundle.putString("error_message", paramString2);
    }
    localAppEventsLogger.logSdkEvent("fb_share_dialog_result", null, localBundle);
    AppMethodBeat.o(8324);
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, Bitmap paramBitmap, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(8325);
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramBitmap);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(8325);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, Uri paramUri, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(8327);
    if (Utility.isFileUri(paramUri))
    {
      paramAccessToken = newUploadStagingResourceWithImageRequest(paramAccessToken, new File(paramUri.getPath()), paramCallback);
      AppMethodBeat.o(8327);
      return paramAccessToken;
    }
    if (!Utility.isContentUri(paramUri))
    {
      paramAccessToken = new FacebookException("The image Uri must be either a file:// or content:// Uri");
      AppMethodBeat.o(8327);
      throw paramAccessToken;
    }
    paramUri = new GraphRequest.ParcelableResourceWithMimeType(paramUri, "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramUri);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(8327);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, File paramFile, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(8326);
    paramFile = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(paramFile, 268435456), "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramFile);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(8326);
    return paramAccessToken;
  }
  
  public static void registerSharerCallback(int paramInt, CallbackManager paramCallbackManager, final FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    AppMethodBeat.i(8307);
    if (!(paramCallbackManager instanceof CallbackManagerImpl))
    {
      paramCallbackManager = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      AppMethodBeat.o(8307);
      throw paramCallbackManager;
    }
    ((CallbackManagerImpl)paramCallbackManager).registerCallback(paramInt, new CallbackManagerImpl.Callback()
    {
      public final boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(8287);
        boolean bool = ShareInternalUtility.handleActivityResult(this.val$requestCode, paramAnonymousInt, paramAnonymousIntent, ShareInternalUtility.getShareResultProcessor(paramFacebookCallback));
        AppMethodBeat.o(8287);
        return bool;
      }
    });
    AppMethodBeat.o(8307);
  }
  
  public static void registerStaticShareCallback(int paramInt)
  {
    AppMethodBeat.i(8306);
    CallbackManagerImpl.registerStaticCallback(paramInt, new CallbackManagerImpl.Callback()
    {
      public final boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(8286);
        boolean bool = ShareInternalUtility.handleActivityResult(this.val$requestCode, paramAnonymousInt, paramAnonymousIntent, ShareInternalUtility.getShareResultProcessor(null));
        AppMethodBeat.o(8286);
        return bool;
      }
    });
    AppMethodBeat.o(8306);
  }
  
  public static JSONArray removeNamespacesFromOGJsonArray(JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(8314);
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.get(i);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = removeNamespacesFromOGJsonArray((JSONArray)localObject2, paramBoolean);
      }
      for (;;)
      {
        localJSONArray.put(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = removeNamespacesFromOGJsonObject((JSONObject)localObject2, paramBoolean);
        }
      }
    }
    AppMethodBeat.o(8314);
    return localJSONArray;
  }
  
  public static JSONObject removeNamespacesFromOGJsonObject(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(8315);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(8315);
      return null;
    }
    for (;;)
    {
      JSONObject localJSONObject1;
      JSONObject localJSONObject2;
      int i;
      String str1;
      Object localObject1;
      Object localObject2;
      String str2;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
        JSONArray localJSONArray = paramJSONObject.names();
        i = 0;
        if (i >= localJSONArray.length()) {
          break label262;
        }
        str1 = localJSONArray.getString(i);
        localObject1 = paramJSONObject.get(str1);
        if ((localObject1 instanceof JSONObject))
        {
          localObject1 = removeNamespacesFromOGJsonObject((JSONObject)localObject1, true);
          localObject2 = getFieldNameAndNamespaceFromFullName(str1);
          str2 = (String)((Pair)localObject2).first;
          localObject2 = (String)((Pair)localObject2).second;
          if (!paramBoolean) {
            break label222;
          }
          if ((str2 != null) && (str2.equals("fbsdk")))
          {
            localJSONObject1.put(str1, localObject1);
            break label293;
          }
        }
        else
        {
          if (!(localObject1 instanceof JSONArray)) {
            break label290;
          }
          localObject1 = removeNamespacesFromOGJsonArray((JSONArray)localObject1, true);
          continue;
        }
        if ((str2 == null) || (str2.equals("og"))) {
          localJSONObject1.put((String)localObject2, localObject1);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject = new FacebookException("Failed to create json object from share content");
        AppMethodBeat.o(8315);
        throw paramJSONObject;
      }
      localJSONObject2.put((String)localObject2, localObject1);
      break label293;
      label222:
      if ((str2 != null) && (str2.equals("fb")))
      {
        localJSONObject1.put(str1, localObject1);
      }
      else
      {
        localJSONObject1.put((String)localObject2, localObject1);
        break label293;
        if (localJSONObject2.length() > 0) {
          localJSONObject1.put("data", localJSONObject2);
        }
        AppMethodBeat.o(8315);
        return localJSONObject1;
        continue;
      }
      label262:
      label290:
      label293:
      i += 1;
    }
  }
  
  public static JSONObject toJSONObjectForCall(UUID paramUUID, ShareOpenGraphContent paramShareOpenGraphContent)
  {
    AppMethodBeat.i(8312);
    Object localObject = paramShareOpenGraphContent.getAction();
    final ArrayList localArrayList = new ArrayList();
    localObject = OpenGraphJSONUtility.toJSONObject((ShareOpenGraphAction)localObject, new OpenGraphJSONUtility.PhotoJSONProcessor()
    {
      public final JSONObject toJSONObject(SharePhoto paramAnonymousSharePhoto)
      {
        AppMethodBeat.i(8294);
        NativeAppCallAttachmentStore.Attachment localAttachment = ShareInternalUtility.access$000(this.val$callId, paramAnonymousSharePhoto);
        if (localAttachment == null)
        {
          AppMethodBeat.o(8294);
          return null;
        }
        localArrayList.add(localAttachment);
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("url", localAttachment.getAttachmentUrl());
          if (paramAnonymousSharePhoto.getUserGenerated()) {
            localJSONObject.put("user_generated", true);
          }
          AppMethodBeat.o(8294);
          return localJSONObject;
        }
        catch (JSONException paramAnonymousSharePhoto)
        {
          paramAnonymousSharePhoto = new FacebookException("Unable to attach images", paramAnonymousSharePhoto);
          AppMethodBeat.o(8294);
          throw paramAnonymousSharePhoto;
        }
      }
    });
    NativeAppCallAttachmentStore.addAttachments(localArrayList);
    if ((paramShareOpenGraphContent.getPlaceId() != null) && (Utility.isNullOrEmpty(((JSONObject)localObject).optString("place")))) {
      ((JSONObject)localObject).put("place", paramShareOpenGraphContent.getPlaceId());
    }
    if (paramShareOpenGraphContent.getPeopleIds() != null)
    {
      paramUUID = ((JSONObject)localObject).optJSONArray("tags");
      if (paramUUID == null) {}
      for (paramUUID = new HashSet();; paramUUID = Utility.jsonArrayToSet(paramUUID))
      {
        paramShareOpenGraphContent = paramShareOpenGraphContent.getPeopleIds().iterator();
        while (paramShareOpenGraphContent.hasNext()) {
          paramUUID.add((String)paramShareOpenGraphContent.next());
        }
      }
      ((JSONObject)localObject).put("tags", new JSONArray(paramUUID));
    }
    AppMethodBeat.o(8312);
    return localObject;
  }
  
  public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent paramShareOpenGraphContent)
  {
    AppMethodBeat.i(8313);
    paramShareOpenGraphContent = OpenGraphJSONUtility.toJSONObject(paramShareOpenGraphContent.getAction(), new OpenGraphJSONUtility.PhotoJSONProcessor()
    {
      public final JSONObject toJSONObject(SharePhoto paramAnonymousSharePhoto)
      {
        AppMethodBeat.i(8295);
        paramAnonymousSharePhoto = paramAnonymousSharePhoto.getImageUrl();
        if (!Utility.isWebUri(paramAnonymousSharePhoto))
        {
          paramAnonymousSharePhoto = new FacebookException("Only web images may be used in OG objects shared via the web dialog");
          AppMethodBeat.o(8295);
          throw paramAnonymousSharePhoto;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("url", paramAnonymousSharePhoto.toString());
          AppMethodBeat.o(8295);
          return localJSONObject;
        }
        catch (JSONException paramAnonymousSharePhoto)
        {
          paramAnonymousSharePhoto = new FacebookException("Unable to attach images", paramAnonymousSharePhoto);
          AppMethodBeat.o(8295);
          throw paramAnonymousSharePhoto;
        }
      }
    });
    AppMethodBeat.o(8313);
    return paramShareOpenGraphContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility
 * JD-Core Version:    0.7.0.1
 */