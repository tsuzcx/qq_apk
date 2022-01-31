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
    AppMethodBeat.i(97281);
    paramIntent = NativeProtocol.getCallIdFromIntent(paramIntent);
    if (paramIntent == null)
    {
      AppMethodBeat.o(97281);
      return null;
    }
    paramIntent = AppCall.finishPendingCall(paramIntent, paramInt1);
    AppMethodBeat.o(97281);
    return paramIntent;
  }
  
  private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID paramUUID, Uri paramUri, Bitmap paramBitmap)
  {
    AppMethodBeat.i(97294);
    Object localObject = null;
    if (paramBitmap != null) {
      paramBitmap = NativeAppCallAttachmentStore.createAttachment(paramUUID, paramBitmap);
    }
    for (;;)
    {
      AppMethodBeat.o(97294);
      return paramBitmap;
      paramBitmap = localObject;
      if (paramUri != null) {
        paramBitmap = NativeAppCallAttachmentStore.createAttachment(paramUUID, paramUri);
      }
    }
  }
  
  private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID paramUUID, ShareMedia paramShareMedia)
  {
    AppMethodBeat.i(97293);
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
      AppMethodBeat.o(97293);
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
  
  public static Bundle getBackgroundAssetMediaInfo(ShareStoryContent paramShareStoryContent, UUID paramUUID)
  {
    AppMethodBeat.i(97305);
    if ((paramShareStoryContent == null) || (paramShareStoryContent.getBackgroundAsset() == null))
    {
      AppMethodBeat.o(97305);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramShareStoryContent.getBackgroundAsset());
    paramShareStoryContent = new ArrayList();
    paramUUID = Utility.map(localArrayList, new ShareInternalUtility.11(paramUUID, paramShareStoryContent));
    NativeAppCallAttachmentStore.addAttachments(paramShareStoryContent);
    paramShareStoryContent = (Bundle)paramUUID.get(0);
    AppMethodBeat.o(97305);
    return paramShareStoryContent;
  }
  
  public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String paramString)
  {
    AppMethodBeat.i(97292);
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
    AppMethodBeat.o(97292);
    return paramString;
  }
  
  public static List<Bundle> getMediaInfos(final ShareMediaContent paramShareMediaContent, UUID paramUUID)
  {
    AppMethodBeat.i(97286);
    List localList;
    if (paramShareMediaContent != null)
    {
      localList = paramShareMediaContent.getMedia();
      if (localList != null) {}
    }
    else
    {
      AppMethodBeat.o(97286);
      return null;
    }
    paramShareMediaContent = new ArrayList();
    paramUUID = Utility.map(localList, new Utility.Mapper()
    {
      public final Bundle apply(ShareMedia paramAnonymousShareMedia)
      {
        AppMethodBeat.i(97268);
        NativeAppCallAttachmentStore.Attachment localAttachment = ShareInternalUtility.access$000(this.val$appCallId, paramAnonymousShareMedia);
        paramShareMediaContent.add(localAttachment);
        Bundle localBundle = new Bundle();
        localBundle.putString("type", paramAnonymousShareMedia.getMediaType().name());
        localBundle.putString("uri", localAttachment.getAttachmentUrl());
        AppMethodBeat.o(97268);
        return localBundle;
      }
    });
    NativeAppCallAttachmentStore.addAttachments(paramShareMediaContent);
    AppMethodBeat.o(97286);
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
    AppMethodBeat.i(97277);
    if (paramBundle.containsKey("completionGesture"))
    {
      paramBundle = paramBundle.getString("completionGesture");
      AppMethodBeat.o(97277);
      return paramBundle;
    }
    paramBundle = paramBundle.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
    AppMethodBeat.o(97277);
    return paramBundle;
  }
  
  public static List<String> getPhotoUrls(SharePhotoContent paramSharePhotoContent, UUID paramUUID)
  {
    AppMethodBeat.i(97284);
    if (paramSharePhotoContent != null)
    {
      paramSharePhotoContent = paramSharePhotoContent.getPhotos();
      if (paramSharePhotoContent != null) {}
    }
    else
    {
      AppMethodBeat.o(97284);
      return null;
    }
    paramSharePhotoContent = Utility.map(paramSharePhotoContent, new Utility.Mapper()
    {
      public final NativeAppCallAttachmentStore.Attachment apply(SharePhoto paramAnonymousSharePhoto)
      {
        AppMethodBeat.i(97264);
        paramAnonymousSharePhoto = ShareInternalUtility.access$000(this.val$appCallId, paramAnonymousSharePhoto);
        AppMethodBeat.o(97264);
        return paramAnonymousSharePhoto;
      }
    });
    paramUUID = Utility.map(paramSharePhotoContent, new Utility.Mapper()
    {
      public final String apply(NativeAppCallAttachmentStore.Attachment paramAnonymousAttachment)
      {
        AppMethodBeat.i(97266);
        paramAnonymousAttachment = paramAnonymousAttachment.getAttachmentUrl();
        AppMethodBeat.o(97266);
        return paramAnonymousAttachment;
      }
    });
    NativeAppCallAttachmentStore.addAttachments(paramSharePhotoContent);
    AppMethodBeat.o(97284);
    return paramUUID;
  }
  
  public static String getShareDialogPostId(Bundle paramBundle)
  {
    AppMethodBeat.i(97278);
    if (paramBundle.containsKey("postId"))
    {
      paramBundle = paramBundle.getString("postId");
      AppMethodBeat.o(97278);
      return paramBundle;
    }
    if (paramBundle.containsKey("com.facebook.platform.extra.POST_ID"))
    {
      paramBundle = paramBundle.getString("com.facebook.platform.extra.POST_ID");
      AppMethodBeat.o(97278);
      return paramBundle;
    }
    paramBundle = paramBundle.getString("post_id");
    AppMethodBeat.o(97278);
    return paramBundle;
  }
  
  public static ResultProcessor getShareResultProcessor(FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    AppMethodBeat.i(97280);
    paramFacebookCallback = new ShareInternalUtility.1(paramFacebookCallback, paramFacebookCallback);
    AppMethodBeat.o(97280);
    return paramFacebookCallback;
  }
  
  public static Bundle getStickerUrl(ShareStoryContent paramShareStoryContent, UUID paramUUID)
  {
    AppMethodBeat.i(97304);
    if ((paramShareStoryContent == null) || (paramShareStoryContent.getStickerAsset() == null))
    {
      AppMethodBeat.o(97304);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramShareStoryContent.getStickerAsset());
    paramShareStoryContent = Utility.map(localArrayList, new ShareInternalUtility.9(paramUUID));
    paramUUID = Utility.map(paramShareStoryContent, new ShareInternalUtility.10());
    NativeAppCallAttachmentStore.addAttachments(paramShareStoryContent);
    paramShareStoryContent = (Bundle)paramUUID.get(0);
    AppMethodBeat.o(97304);
    return paramShareStoryContent;
  }
  
  public static Bundle getTextureUrlBundle(ShareCameraEffectContent paramShareCameraEffectContent, UUID paramUUID)
  {
    AppMethodBeat.i(97287);
    if (paramShareCameraEffectContent != null)
    {
      paramShareCameraEffectContent = paramShareCameraEffectContent.getTextures();
      if (paramShareCameraEffectContent != null) {}
    }
    else
    {
      AppMethodBeat.o(97287);
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
    AppMethodBeat.o(97287);
    return localBundle;
  }
  
  public static String getUriExtension(Uri paramUri)
  {
    AppMethodBeat.i(97306);
    if (paramUri == null)
    {
      AppMethodBeat.o(97306);
      return null;
    }
    paramUri = paramUri.toString();
    int i = paramUri.lastIndexOf('.');
    if (i == -1)
    {
      AppMethodBeat.o(97306);
      return null;
    }
    paramUri = paramUri.substring(i);
    AppMethodBeat.o(97306);
    return paramUri;
  }
  
  public static String getVideoUrl(ShareVideoContent paramShareVideoContent, UUID paramUUID)
  {
    AppMethodBeat.i(97285);
    if ((paramShareVideoContent == null) || (paramShareVideoContent.getVideo() == null))
    {
      AppMethodBeat.o(97285);
      return null;
    }
    paramShareVideoContent = NativeAppCallAttachmentStore.createAttachment(paramUUID, paramShareVideoContent.getVideo().getLocalUrl());
    paramUUID = new ArrayList(1);
    paramUUID.add(paramShareVideoContent);
    NativeAppCallAttachmentStore.addAttachments(paramUUID);
    paramShareVideoContent = paramShareVideoContent.getAttachmentUrl();
    AppMethodBeat.o(97285);
    return paramShareVideoContent;
  }
  
  public static boolean handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent, ResultProcessor paramResultProcessor)
  {
    AppMethodBeat.i(97279);
    AppCall localAppCall = getAppCallFromActivityResult(paramInt1, paramInt2, paramIntent);
    if (localAppCall == null)
    {
      AppMethodBeat.o(97279);
      return false;
    }
    NativeAppCallAttachmentStore.cleanupAttachmentsForCall(localAppCall.getCallId());
    if (paramResultProcessor == null)
    {
      AppMethodBeat.o(97279);
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
      AppMethodBeat.o(97279);
      return true;
      paramResultProcessor.onError(localAppCall, localFacebookException);
      continue;
      paramResultProcessor.onSuccess(localAppCall, NativeProtocol.getSuccessResultsFromIntent(paramIntent));
    }
  }
  
  public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    AppMethodBeat.i(97275);
    invokeOnErrorCallback(paramFacebookCallback, paramString);
    AppMethodBeat.o(97275);
  }
  
  public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> paramFacebookCallback, Exception paramException)
  {
    AppMethodBeat.i(97274);
    if ((paramException instanceof FacebookException))
    {
      invokeOnErrorCallback(paramFacebookCallback, (FacebookException)paramException);
      AppMethodBeat.o(97274);
      return;
    }
    invokeCallbackWithError(paramFacebookCallback, "Error preparing share content: " + paramException.getLocalizedMessage());
    AppMethodBeat.o(97274);
  }
  
  public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString, GraphResponse paramGraphResponse)
  {
    AppMethodBeat.i(97276);
    Object localObject = paramGraphResponse.getError();
    if (localObject != null)
    {
      localObject = ((FacebookRequestError)localObject).getErrorMessage();
      paramString = (String)localObject;
      if (Utility.isNullOrEmpty((String)localObject)) {
        paramString = "Unexpected error sharing.";
      }
      invokeOnErrorCallback(paramFacebookCallback, paramGraphResponse, paramString);
      AppMethodBeat.o(97276);
      return;
    }
    invokeOnSuccessCallback(paramFacebookCallback, paramString);
    AppMethodBeat.o(97276);
  }
  
  static void invokeOnCancelCallback(FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    AppMethodBeat.i(97295);
    logShareResult("cancelled", null);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onCancel();
    }
    AppMethodBeat.o(97295);
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(97299);
    logShareResult("error", paramFacebookException.getMessage());
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(paramFacebookException);
    }
    AppMethodBeat.o(97299);
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, GraphResponse paramGraphResponse, String paramString)
  {
    AppMethodBeat.i(97297);
    logShareResult("error", paramString);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(new FacebookGraphResponseException(paramGraphResponse, paramString));
    }
    AppMethodBeat.o(97297);
  }
  
  static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    AppMethodBeat.i(97298);
    logShareResult("error", paramString);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onError(new FacebookException(paramString));
    }
    AppMethodBeat.o(97298);
  }
  
  static void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> paramFacebookCallback, String paramString)
  {
    AppMethodBeat.i(97296);
    logShareResult("succeeded", null);
    if (paramFacebookCallback != null) {
      paramFacebookCallback.onSuccess(new Sharer.Result(paramString));
    }
    AppMethodBeat.o(97296);
  }
  
  private static void logShareResult(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97300);
    AppEventsLogger localAppEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
    Bundle localBundle = new Bundle();
    localBundle.putString("fb_share_dialog_outcome", paramString1);
    if (paramString2 != null) {
      localBundle.putString("error_message", paramString2);
    }
    localAppEventsLogger.logSdkEvent("fb_share_dialog_result", null, localBundle);
    AppMethodBeat.o(97300);
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, Bitmap paramBitmap, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(97301);
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramBitmap);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(97301);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, Uri paramUri, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(97303);
    if (Utility.isFileUri(paramUri))
    {
      paramAccessToken = newUploadStagingResourceWithImageRequest(paramAccessToken, new File(paramUri.getPath()), paramCallback);
      AppMethodBeat.o(97303);
      return paramAccessToken;
    }
    if (!Utility.isContentUri(paramUri))
    {
      paramAccessToken = new FacebookException("The image Uri must be either a file:// or content:// Uri");
      AppMethodBeat.o(97303);
      throw paramAccessToken;
    }
    paramUri = new GraphRequest.ParcelableResourceWithMimeType(paramUri, "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramUri);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(97303);
    return paramAccessToken;
  }
  
  public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken paramAccessToken, File paramFile, GraphRequest.Callback paramCallback)
  {
    AppMethodBeat.i(97302);
    paramFile = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(paramFile, 268435456), "image/png");
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("file", paramFile);
    paramAccessToken = new GraphRequest(paramAccessToken, "me/staging_resources", localBundle, HttpMethod.POST, paramCallback);
    AppMethodBeat.o(97302);
    return paramAccessToken;
  }
  
  public static void registerSharerCallback(int paramInt, CallbackManager paramCallbackManager, final FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    AppMethodBeat.i(97283);
    if (!(paramCallbackManager instanceof CallbackManagerImpl))
    {
      paramCallbackManager = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      AppMethodBeat.o(97283);
      throw paramCallbackManager;
    }
    ((CallbackManagerImpl)paramCallbackManager).registerCallback(paramInt, new CallbackManagerImpl.Callback()
    {
      public final boolean onActivityResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(97263);
        boolean bool = ShareInternalUtility.handleActivityResult(this.val$requestCode, paramAnonymousInt, paramAnonymousIntent, ShareInternalUtility.getShareResultProcessor(paramFacebookCallback));
        AppMethodBeat.o(97263);
        return bool;
      }
    });
    AppMethodBeat.o(97283);
  }
  
  public static void registerStaticShareCallback(int paramInt)
  {
    AppMethodBeat.i(97282);
    CallbackManagerImpl.registerStaticCallback(paramInt, new ShareInternalUtility.2(paramInt));
    AppMethodBeat.o(97282);
  }
  
  public static JSONArray removeNamespacesFromOGJsonArray(JSONArray paramJSONArray, boolean paramBoolean)
  {
    AppMethodBeat.i(97290);
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
    AppMethodBeat.o(97290);
    return localJSONArray;
  }
  
  public static JSONObject removeNamespacesFromOGJsonObject(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(97291);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(97291);
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
        AppMethodBeat.o(97291);
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
        AppMethodBeat.o(97291);
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
    AppMethodBeat.i(97288);
    Object localObject = paramShareOpenGraphContent.getAction();
    ArrayList localArrayList = new ArrayList();
    localObject = OpenGraphJSONUtility.toJSONObject((ShareOpenGraphAction)localObject, new ShareInternalUtility.7(paramUUID, localArrayList));
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
    AppMethodBeat.o(97288);
    return localObject;
  }
  
  public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent paramShareOpenGraphContent)
  {
    AppMethodBeat.i(97289);
    paramShareOpenGraphContent = OpenGraphJSONUtility.toJSONObject(paramShareOpenGraphContent.getAction(), new ShareInternalUtility.8());
    AppMethodBeat.o(97289);
    return paramShareOpenGraphContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility
 * JD-Core Version:    0.7.0.1
 */