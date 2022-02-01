package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LegacyNativeDialogParameters
{
  private static Bundle create(ShareLinkContent paramShareLinkContent, boolean paramBoolean)
  {
    AppMethodBeat.i(8000);
    Bundle localBundle = createBaseParameters(paramShareLinkContent, paramBoolean);
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.TITLE", paramShareLinkContent.getContentTitle());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.DESCRIPTION", paramShareLinkContent.getContentDescription());
    Utility.putUri(localBundle, "com.facebook.platform.extra.IMAGE", paramShareLinkContent.getImageUrl());
    AppMethodBeat.o(8000);
    return localBundle;
  }
  
  private static Bundle create(ShareOpenGraphContent paramShareOpenGraphContent, JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(8002);
    Bundle localBundle = createBaseParameters(paramShareOpenGraphContent, paramBoolean);
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.PREVIEW_PROPERTY_NAME", paramShareOpenGraphContent.getPreviewPropertyName());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.ACTION_TYPE", paramShareOpenGraphContent.getAction().getActionType());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.ACTION", paramJSONObject.toString());
    AppMethodBeat.o(8002);
    return localBundle;
  }
  
  private static Bundle create(SharePhotoContent paramSharePhotoContent, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(8001);
    paramSharePhotoContent = createBaseParameters(paramSharePhotoContent, paramBoolean);
    paramSharePhotoContent.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(paramList));
    AppMethodBeat.o(8001);
    return paramSharePhotoContent;
  }
  
  private static Bundle create(ShareVideoContent paramShareVideoContent, boolean paramBoolean)
  {
    return null;
  }
  
  public static Bundle create(UUID paramUUID, ShareContent paramShareContent, boolean paramBoolean)
  {
    AppMethodBeat.i(7999);
    Validate.notNull(paramShareContent, "shareContent");
    Validate.notNull(paramUUID, "callId");
    Bundle localBundle = null;
    if ((paramShareContent instanceof ShareLinkContent)) {
      localBundle = create((ShareLinkContent)paramShareContent, paramBoolean);
    }
    for (;;)
    {
      AppMethodBeat.o(7999);
      return localBundle;
      if ((paramShareContent instanceof SharePhotoContent))
      {
        paramShareContent = (SharePhotoContent)paramShareContent;
        localBundle = create(paramShareContent, ShareInternalUtility.getPhotoUrls(paramShareContent, paramUUID), paramBoolean);
        continue;
      }
      if ((paramShareContent instanceof ShareVideoContent))
      {
        localBundle = create((ShareVideoContent)paramShareContent, paramBoolean);
        continue;
      }
      if (!(paramShareContent instanceof ShareOpenGraphContent)) {
        continue;
      }
      paramShareContent = (ShareOpenGraphContent)paramShareContent;
      try
      {
        localBundle = create(paramShareContent, ShareInternalUtility.toJSONObjectForCall(paramUUID, paramShareContent), paramBoolean);
      }
      catch (JSONException paramUUID)
      {
        paramUUID = new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + paramUUID.getMessage());
        AppMethodBeat.o(7999);
        throw paramUUID;
      }
    }
  }
  
  private static Bundle createBaseParameters(ShareContent paramShareContent, boolean paramBoolean)
  {
    AppMethodBeat.i(8003);
    Bundle localBundle = new Bundle();
    Utility.putUri(localBundle, "com.facebook.platform.extra.LINK", paramShareContent.getContentUrl());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.PLACE", paramShareContent.getPlaceId());
    Utility.putNonEmptyString(localBundle, "com.facebook.platform.extra.REF", paramShareContent.getRef());
    localBundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", paramBoolean);
    paramShareContent = paramShareContent.getPeopleIds();
    if (!Utility.isNullOrEmpty(paramShareContent)) {
      localBundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(paramShareContent));
    }
    AppMethodBeat.o(8003);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.internal.LegacyNativeDialogParameters
 * JD-Core Version:    0.7.0.1
 */