package com.facebook.share.internal;

import android.os.Bundle;
import android.util.Pair;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeDialogParameters
{
  private static Bundle create(ShareCameraEffectContent paramShareCameraEffectContent, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(8172);
    Bundle localBundle = createBaseParameters(paramShareCameraEffectContent, paramBoolean);
    Utility.putNonEmptyString(localBundle, "effect_id", paramShareCameraEffectContent.getEffectId());
    if (paramBundle != null) {
      localBundle.putBundle("effect_textures", paramBundle);
    }
    try
    {
      paramShareCameraEffectContent = CameraEffectJSONUtility.convertToJSON(paramShareCameraEffectContent.getArguments());
      if (paramShareCameraEffectContent != null) {
        Utility.putNonEmptyString(localBundle, "effect_arguments", paramShareCameraEffectContent.toString());
      }
      AppMethodBeat.o(8172);
      return localBundle;
    }
    catch (JSONException paramShareCameraEffectContent)
    {
      paramShareCameraEffectContent = new FacebookException("Unable to create a JSON Object from the provided CameraEffectArguments: " + paramShareCameraEffectContent.getMessage());
      AppMethodBeat.o(8172);
      throw paramShareCameraEffectContent;
    }
  }
  
  private static Bundle create(ShareLinkContent paramShareLinkContent, boolean paramBoolean)
  {
    AppMethodBeat.i(8173);
    Bundle localBundle = createBaseParameters(paramShareLinkContent, paramBoolean);
    Utility.putNonEmptyString(localBundle, "TITLE", paramShareLinkContent.getContentTitle());
    Utility.putNonEmptyString(localBundle, "DESCRIPTION", paramShareLinkContent.getContentDescription());
    Utility.putUri(localBundle, "IMAGE", paramShareLinkContent.getImageUrl());
    Utility.putNonEmptyString(localBundle, "QUOTE", paramShareLinkContent.getQuote());
    Utility.putUri(localBundle, "MESSENGER_LINK", paramShareLinkContent.getContentUrl());
    Utility.putUri(localBundle, "TARGET_DISPLAY", paramShareLinkContent.getContentUrl());
    AppMethodBeat.o(8173);
    return localBundle;
  }
  
  private static Bundle create(ShareMediaContent paramShareMediaContent, List<Bundle> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(8176);
    paramShareMediaContent = createBaseParameters(paramShareMediaContent, paramBoolean);
    paramShareMediaContent.putParcelableArrayList("MEDIA", new ArrayList(paramList));
    AppMethodBeat.o(8176);
    return paramShareMediaContent;
  }
  
  private static Bundle create(ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent, boolean paramBoolean)
  {
    AppMethodBeat.i(8178);
    Bundle localBundle = createBaseParameters(paramShareMessengerGenericTemplateContent, paramBoolean);
    try
    {
      MessengerShareContentUtility.addGenericTemplateContent(localBundle, paramShareMessengerGenericTemplateContent);
      AppMethodBeat.o(8178);
      return localBundle;
    }
    catch (JSONException paramShareMessengerGenericTemplateContent)
    {
      paramShareMessengerGenericTemplateContent = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: " + paramShareMessengerGenericTemplateContent.getMessage());
      AppMethodBeat.o(8178);
      throw paramShareMessengerGenericTemplateContent;
    }
  }
  
  private static Bundle create(ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent, boolean paramBoolean)
  {
    AppMethodBeat.i(8180);
    Bundle localBundle = createBaseParameters(paramShareMessengerMediaTemplateContent, paramBoolean);
    try
    {
      MessengerShareContentUtility.addMediaTemplateContent(localBundle, paramShareMessengerMediaTemplateContent);
      AppMethodBeat.o(8180);
      return localBundle;
    }
    catch (JSONException paramShareMessengerMediaTemplateContent)
    {
      paramShareMessengerMediaTemplateContent = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: " + paramShareMessengerMediaTemplateContent.getMessage());
      AppMethodBeat.o(8180);
      throw paramShareMessengerMediaTemplateContent;
    }
  }
  
  private static Bundle create(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent, boolean paramBoolean)
  {
    AppMethodBeat.i(8179);
    Bundle localBundle = createBaseParameters(paramShareMessengerOpenGraphMusicTemplateContent, paramBoolean);
    try
    {
      MessengerShareContentUtility.addOpenGraphMusicTemplateContent(localBundle, paramShareMessengerOpenGraphMusicTemplateContent);
      AppMethodBeat.o(8179);
      return localBundle;
    }
    catch (JSONException paramShareMessengerOpenGraphMusicTemplateContent)
    {
      paramShareMessengerOpenGraphMusicTemplateContent = new FacebookException("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: " + paramShareMessengerOpenGraphMusicTemplateContent.getMessage());
      AppMethodBeat.o(8179);
      throw paramShareMessengerOpenGraphMusicTemplateContent;
    }
  }
  
  private static Bundle create(ShareOpenGraphContent paramShareOpenGraphContent, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(8177);
    Bundle localBundle = createBaseParameters(paramShareOpenGraphContent, paramBoolean);
    Utility.putNonEmptyString(localBundle, "PREVIEW_PROPERTY_NAME", (String)ShareInternalUtility.getFieldNameAndNamespaceFromFullName(paramShareOpenGraphContent.getPreviewPropertyName()).second);
    Utility.putNonEmptyString(localBundle, "ACTION_TYPE", paramShareOpenGraphContent.getAction().getActionType());
    Utility.putNonEmptyString(localBundle, "ACTION", paramJSONObject.toString());
    AppMethodBeat.o(8177);
    return localBundle;
  }
  
  private static Bundle create(SharePhotoContent paramSharePhotoContent, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(8174);
    paramSharePhotoContent = createBaseParameters(paramSharePhotoContent, paramBoolean);
    paramSharePhotoContent.putStringArrayList("PHOTOS", new ArrayList(paramList));
    AppMethodBeat.o(8174);
    return paramSharePhotoContent;
  }
  
  private static Bundle create(ShareStoryContent paramShareStoryContent, Bundle paramBundle1, Bundle paramBundle2, boolean paramBoolean)
  {
    AppMethodBeat.i(8181);
    Bundle localBundle = createBaseParameters(paramShareStoryContent, paramBoolean);
    if (paramBundle1 != null) {
      localBundle.putParcelable("bg_asset", paramBundle1);
    }
    if (paramBundle2 != null) {
      localBundle.putParcelable("interactive_asset_uri", paramBundle2);
    }
    paramBundle1 = paramShareStoryContent.getBackgroundColorList();
    if (!Utility.isNullOrEmpty(paramBundle1)) {
      localBundle.putStringArrayList("top_background_color_list", new ArrayList(paramBundle1));
    }
    Utility.putNonEmptyString(localBundle, "content_url", paramShareStoryContent.getAttributionLink());
    AppMethodBeat.o(8181);
    return localBundle;
  }
  
  private static Bundle create(ShareVideoContent paramShareVideoContent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(8175);
    Bundle localBundle = createBaseParameters(paramShareVideoContent, paramBoolean);
    Utility.putNonEmptyString(localBundle, "TITLE", paramShareVideoContent.getContentTitle());
    Utility.putNonEmptyString(localBundle, "DESCRIPTION", paramShareVideoContent.getContentDescription());
    Utility.putNonEmptyString(localBundle, "VIDEO", paramString);
    AppMethodBeat.o(8175);
    return localBundle;
  }
  
  public static Bundle create(UUID paramUUID, ShareContent paramShareContent, boolean paramBoolean)
  {
    AppMethodBeat.i(8171);
    Validate.notNull(paramShareContent, "shareContent");
    Validate.notNull(paramUUID, "callId");
    Bundle localBundle = null;
    if ((paramShareContent instanceof ShareLinkContent)) {
      localBundle = create((ShareLinkContent)paramShareContent, paramBoolean);
    }
    for (;;)
    {
      AppMethodBeat.o(8171);
      return localBundle;
      if ((paramShareContent instanceof SharePhotoContent))
      {
        paramShareContent = (SharePhotoContent)paramShareContent;
        localBundle = create(paramShareContent, ShareInternalUtility.getPhotoUrls(paramShareContent, paramUUID), paramBoolean);
      }
      else if ((paramShareContent instanceof ShareVideoContent))
      {
        paramShareContent = (ShareVideoContent)paramShareContent;
        localBundle = create(paramShareContent, ShareInternalUtility.getVideoUrl(paramShareContent, paramUUID), paramBoolean);
      }
      else if ((paramShareContent instanceof ShareOpenGraphContent))
      {
        paramShareContent = (ShareOpenGraphContent)paramShareContent;
        try
        {
          localBundle = create(paramShareContent, ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForCall(paramUUID, paramShareContent), false), paramBoolean);
        }
        catch (JSONException paramUUID)
        {
          paramUUID = new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + paramUUID.getMessage());
          AppMethodBeat.o(8171);
          throw paramUUID;
        }
      }
      else if ((paramShareContent instanceof ShareMediaContent))
      {
        paramShareContent = (ShareMediaContent)paramShareContent;
        localBundle = create(paramShareContent, ShareInternalUtility.getMediaInfos(paramShareContent, paramUUID), paramBoolean);
      }
      else if ((paramShareContent instanceof ShareCameraEffectContent))
      {
        paramShareContent = (ShareCameraEffectContent)paramShareContent;
        localBundle = create(paramShareContent, ShareInternalUtility.getTextureUrlBundle(paramShareContent, paramUUID), paramBoolean);
      }
      else if ((paramShareContent instanceof ShareMessengerGenericTemplateContent))
      {
        localBundle = create((ShareMessengerGenericTemplateContent)paramShareContent, paramBoolean);
      }
      else if ((paramShareContent instanceof ShareMessengerOpenGraphMusicTemplateContent))
      {
        localBundle = create((ShareMessengerOpenGraphMusicTemplateContent)paramShareContent, paramBoolean);
      }
      else if ((paramShareContent instanceof ShareMessengerMediaTemplateContent))
      {
        localBundle = create((ShareMessengerMediaTemplateContent)paramShareContent, paramBoolean);
      }
      else if ((paramShareContent instanceof ShareStoryContent))
      {
        paramShareContent = (ShareStoryContent)paramShareContent;
        localBundle = create(paramShareContent, ShareInternalUtility.getBackgroundAssetMediaInfo(paramShareContent, paramUUID), ShareInternalUtility.getStickerUrl(paramShareContent, paramUUID), paramBoolean);
      }
    }
  }
  
  private static Bundle createBaseParameters(ShareContent paramShareContent, boolean paramBoolean)
  {
    AppMethodBeat.i(8182);
    Bundle localBundle = new Bundle();
    Utility.putUri(localBundle, "LINK", paramShareContent.getContentUrl());
    Utility.putNonEmptyString(localBundle, "PLACE", paramShareContent.getPlaceId());
    Utility.putNonEmptyString(localBundle, "PAGE", paramShareContent.getPageId());
    Utility.putNonEmptyString(localBundle, "REF", paramShareContent.getRef());
    localBundle.putBoolean("DATA_FAILURES_FATAL", paramBoolean);
    List localList = paramShareContent.getPeopleIds();
    if (!Utility.isNullOrEmpty(localList)) {
      localBundle.putStringArrayList("FRIENDS", new ArrayList(localList));
    }
    paramShareContent = paramShareContent.getShareHashtag();
    if (paramShareContent != null) {
      Utility.putNonEmptyString(localBundle, "HASHTAG", paramShareContent.getHashtag());
    }
    AppMethodBeat.o(8182);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.NativeDialogParameters
 * JD-Core Version:    0.7.0.1
 */