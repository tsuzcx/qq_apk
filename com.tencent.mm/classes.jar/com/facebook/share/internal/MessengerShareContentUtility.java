package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent.ImageAspectRatio;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent.MediaType;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareMessengerURLActionButton.WebviewHeightRatio;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerShareContentUtility
{
  public static final String ATTACHMENT = "attachment";
  public static final String ATTACHMENT_ID = "attachment_id";
  public static final String ATTACHMENT_PAYLOAD = "payload";
  public static final String ATTACHMENT_TEMPLATE_TYPE = "template";
  public static final String ATTACHMENT_TYPE = "type";
  public static final String BUTTONS = "buttons";
  public static final String BUTTON_TYPE = "type";
  public static final String BUTTON_URL_TYPE = "web_url";
  public static final String DEFAULT_ACTION = "default_action";
  public static final String ELEMENTS = "elements";
  public static final Pattern FACEBOOK_DOMAIN;
  public static final String FALLBACK_URL = "fallback_url";
  public static final String IMAGE_ASPECT_RATIO = "image_aspect_ratio";
  public static final String IMAGE_RATIO_HORIZONTAL = "horizontal";
  public static final String IMAGE_RATIO_SQUARE = "square";
  public static final String IMAGE_URL = "image_url";
  public static final String MEDIA_IMAGE = "image";
  public static final String MEDIA_TYPE = "media_type";
  public static final String MEDIA_VIDEO = "video";
  public static final String MESSENGER_EXTENSIONS = "messenger_extensions";
  public static final String PREVIEW_DEFAULT = "DEFAULT";
  public static final String PREVIEW_OPEN_GRAPH = "OPEN_GRAPH";
  public static final String SHARABLE = "sharable";
  public static final String SHARE_BUTTON_HIDE = "hide";
  public static final String SUBTITLE = "subtitle";
  public static final String TEMPLATE_GENERIC_TYPE = "generic";
  public static final String TEMPLATE_MEDIA_TYPE = "media";
  public static final String TEMPLATE_OPEN_GRAPH_TYPE = "open_graph";
  public static final String TEMPLATE_TYPE = "template_type";
  public static final String TITLE = "title";
  public static final String URL = "url";
  public static final String WEBVIEW_RATIO = "webview_height_ratio";
  public static final String WEBVIEW_RATIO_COMPACT = "compact";
  public static final String WEBVIEW_RATIO_FULL = "full";
  public static final String WEBVIEW_RATIO_TALL = "tall";
  public static final String WEBVIEW_SHARE_BUTTON = "webview_share_button";
  
  static
  {
    AppMethodBeat.i(97146);
    FACEBOOK_DOMAIN = Pattern.compile("^(.+)\\.(facebook\\.com)$");
    AppMethodBeat.o(97146);
  }
  
  private static void addActionButton(Bundle paramBundle, ShareMessengerActionButton paramShareMessengerActionButton, boolean paramBoolean)
  {
    AppMethodBeat.i(97130);
    if (paramShareMessengerActionButton == null)
    {
      AppMethodBeat.o(97130);
      return;
    }
    if ((paramShareMessengerActionButton instanceof ShareMessengerURLActionButton)) {
      addURLActionButton(paramBundle, (ShareMessengerURLActionButton)paramShareMessengerActionButton, paramBoolean);
    }
    AppMethodBeat.o(97130);
  }
  
  public static void addGenericTemplateContent(Bundle paramBundle, ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent)
  {
    AppMethodBeat.i(97124);
    addGenericTemplateElementForPreview(paramBundle, paramShareMessengerGenericTemplateContent.getGenericTemplateElement());
    Utility.putJSONValueInBundle(paramBundle, "MESSENGER_PLATFORM_CONTENT", serializeGenericTemplateContent(paramShareMessengerGenericTemplateContent));
    AppMethodBeat.o(97124);
  }
  
  private static void addGenericTemplateElementForPreview(Bundle paramBundle, ShareMessengerGenericTemplateElement paramShareMessengerGenericTemplateElement)
  {
    AppMethodBeat.i(97127);
    if (paramShareMessengerGenericTemplateElement.getButton() != null) {
      addActionButton(paramBundle, paramShareMessengerGenericTemplateElement.getButton(), false);
    }
    for (;;)
    {
      Utility.putUri(paramBundle, "IMAGE", paramShareMessengerGenericTemplateElement.getImageUrl());
      Utility.putNonEmptyString(paramBundle, "PREVIEW_TYPE", "DEFAULT");
      Utility.putNonEmptyString(paramBundle, "TITLE", paramShareMessengerGenericTemplateElement.getTitle());
      Utility.putNonEmptyString(paramBundle, "SUBTITLE", paramShareMessengerGenericTemplateElement.getSubtitle());
      AppMethodBeat.o(97127);
      return;
      if (paramShareMessengerGenericTemplateElement.getDefaultAction() != null) {
        addActionButton(paramBundle, paramShareMessengerGenericTemplateElement.getDefaultAction(), true);
      }
    }
  }
  
  public static void addMediaTemplateContent(Bundle paramBundle, ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
  {
    AppMethodBeat.i(97126);
    addMediaTemplateContentForPreview(paramBundle, paramShareMessengerMediaTemplateContent);
    Utility.putJSONValueInBundle(paramBundle, "MESSENGER_PLATFORM_CONTENT", serializeMediaTemplateContent(paramShareMessengerMediaTemplateContent));
    AppMethodBeat.o(97126);
  }
  
  private static void addMediaTemplateContentForPreview(Bundle paramBundle, ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
  {
    AppMethodBeat.i(97129);
    addActionButton(paramBundle, paramShareMessengerMediaTemplateContent.getButton(), false);
    Utility.putNonEmptyString(paramBundle, "PREVIEW_TYPE", "DEFAULT");
    Utility.putNonEmptyString(paramBundle, "ATTACHMENT_ID", paramShareMessengerMediaTemplateContent.getAttachmentId());
    if (paramShareMessengerMediaTemplateContent.getMediaUrl() != null) {
      Utility.putUri(paramBundle, getMediaUrlKey(paramShareMessengerMediaTemplateContent.getMediaUrl()), paramShareMessengerMediaTemplateContent.getMediaUrl());
    }
    Utility.putNonEmptyString(paramBundle, "type", getMediaType(paramShareMessengerMediaTemplateContent.getMediaType()));
    AppMethodBeat.o(97129);
  }
  
  public static void addOpenGraphMusicTemplateContent(Bundle paramBundle, ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
  {
    AppMethodBeat.i(97125);
    addOpenGraphMusicTemplateContentForPreview(paramBundle, paramShareMessengerOpenGraphMusicTemplateContent);
    Utility.putJSONValueInBundle(paramBundle, "MESSENGER_PLATFORM_CONTENT", serializeOpenGraphMusicTemplateContent(paramShareMessengerOpenGraphMusicTemplateContent));
    AppMethodBeat.o(97125);
  }
  
  private static void addOpenGraphMusicTemplateContentForPreview(Bundle paramBundle, ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
  {
    AppMethodBeat.i(97128);
    addActionButton(paramBundle, paramShareMessengerOpenGraphMusicTemplateContent.getButton(), false);
    Utility.putNonEmptyString(paramBundle, "PREVIEW_TYPE", "OPEN_GRAPH");
    Utility.putUri(paramBundle, "OPEN_GRAPH_URL", paramShareMessengerOpenGraphMusicTemplateContent.getUrl());
    AppMethodBeat.o(97128);
  }
  
  private static void addURLActionButton(Bundle paramBundle, ShareMessengerURLActionButton paramShareMessengerURLActionButton, boolean paramBoolean)
  {
    AppMethodBeat.i(97131);
    if (paramBoolean) {}
    for (String str = Utility.getUriString(paramShareMessengerURLActionButton.getUrl());; str = paramShareMessengerURLActionButton.getTitle() + " - " + Utility.getUriString(paramShareMessengerURLActionButton.getUrl()))
    {
      Utility.putNonEmptyString(paramBundle, "TARGET_DISPLAY", str);
      Utility.putUri(paramBundle, "ITEM_URL", paramShareMessengerURLActionButton.getUrl());
      AppMethodBeat.o(97131);
      return;
    }
  }
  
  private static String getImageRatioString(ShareMessengerGenericTemplateContent.ImageAspectRatio paramImageAspectRatio)
  {
    AppMethodBeat.i(97143);
    if (paramImageAspectRatio == null)
    {
      AppMethodBeat.o(97143);
      return "horizontal";
    }
    switch (MessengerShareContentUtility.1.$SwitchMap$com$facebook$share$model$ShareMessengerGenericTemplateContent$ImageAspectRatio[paramImageAspectRatio.ordinal()])
    {
    default: 
      AppMethodBeat.o(97143);
      return "horizontal";
    }
    AppMethodBeat.o(97143);
    return "square";
  }
  
  private static String getMediaType(ShareMessengerMediaTemplateContent.MediaType paramMediaType)
  {
    AppMethodBeat.i(97144);
    if (paramMediaType == null)
    {
      AppMethodBeat.o(97144);
      return "image";
    }
    switch (MessengerShareContentUtility.1.$SwitchMap$com$facebook$share$model$ShareMessengerMediaTemplateContent$MediaType[paramMediaType.ordinal()])
    {
    default: 
      AppMethodBeat.o(97144);
      return "image";
    }
    AppMethodBeat.o(97144);
    return "video";
  }
  
  private static String getMediaUrlKey(Uri paramUri)
  {
    AppMethodBeat.i(97141);
    paramUri = paramUri.getHost();
    if ((!Utility.isNullOrEmpty(paramUri)) && (FACEBOOK_DOMAIN.matcher(paramUri).matches()))
    {
      AppMethodBeat.o(97141);
      return "uri";
    }
    AppMethodBeat.o(97141);
    return "IMAGE";
  }
  
  private static String getShouldHideShareButton(ShareMessengerURLActionButton paramShareMessengerURLActionButton)
  {
    AppMethodBeat.i(97145);
    if (paramShareMessengerURLActionButton.getShouldHideWebviewShareButton())
    {
      AppMethodBeat.o(97145);
      return "hide";
    }
    AppMethodBeat.o(97145);
    return null;
  }
  
  private static String getWebviewHeightRatioString(ShareMessengerURLActionButton.WebviewHeightRatio paramWebviewHeightRatio)
  {
    AppMethodBeat.i(97142);
    if (paramWebviewHeightRatio == null)
    {
      AppMethodBeat.o(97142);
      return "full";
    }
    switch (MessengerShareContentUtility.1.$SwitchMap$com$facebook$share$model$ShareMessengerURLActionButton$WebviewHeightRatio[paramWebviewHeightRatio.ordinal()])
    {
    default: 
      AppMethodBeat.o(97142);
      return "full";
    case 1: 
      AppMethodBeat.o(97142);
      return "compact";
    }
    AppMethodBeat.o(97142);
    return "tall";
  }
  
  private static JSONObject serializeActionButton(ShareMessengerActionButton paramShareMessengerActionButton)
  {
    AppMethodBeat.i(97138);
    paramShareMessengerActionButton = serializeActionButton(paramShareMessengerActionButton, false);
    AppMethodBeat.o(97138);
    return paramShareMessengerActionButton;
  }
  
  private static JSONObject serializeActionButton(ShareMessengerActionButton paramShareMessengerActionButton, boolean paramBoolean)
  {
    AppMethodBeat.i(97139);
    if ((paramShareMessengerActionButton instanceof ShareMessengerURLActionButton))
    {
      paramShareMessengerActionButton = serializeURLActionButton((ShareMessengerURLActionButton)paramShareMessengerActionButton, paramBoolean);
      AppMethodBeat.o(97139);
      return paramShareMessengerActionButton;
    }
    AppMethodBeat.o(97139);
    return null;
  }
  
  private static JSONObject serializeGenericTemplateContent(ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent)
  {
    AppMethodBeat.i(97132);
    JSONArray localJSONArray = new JSONArray().put(serializeGenericTemplateElement(paramShareMessengerGenericTemplateContent.getGenericTemplateElement()));
    paramShareMessengerGenericTemplateContent = new JSONObject().put("template_type", "generic").put("sharable", paramShareMessengerGenericTemplateContent.getIsSharable()).put("image_aspect_ratio", getImageRatioString(paramShareMessengerGenericTemplateContent.getImageAspectRatio())).put("elements", localJSONArray);
    paramShareMessengerGenericTemplateContent = new JSONObject().put("type", "template").put("payload", paramShareMessengerGenericTemplateContent);
    paramShareMessengerGenericTemplateContent = new JSONObject().put("attachment", paramShareMessengerGenericTemplateContent);
    AppMethodBeat.o(97132);
    return paramShareMessengerGenericTemplateContent;
  }
  
  private static JSONObject serializeGenericTemplateElement(ShareMessengerGenericTemplateElement paramShareMessengerGenericTemplateElement)
  {
    AppMethodBeat.i(97135);
    JSONObject localJSONObject = new JSONObject().put("title", paramShareMessengerGenericTemplateElement.getTitle()).put("subtitle", paramShareMessengerGenericTemplateElement.getSubtitle()).put("image_url", Utility.getUriString(paramShareMessengerGenericTemplateElement.getImageUrl()));
    if (paramShareMessengerGenericTemplateElement.getButton() != null)
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(serializeActionButton(paramShareMessengerGenericTemplateElement.getButton()));
      localJSONObject.put("buttons", localJSONArray);
    }
    if (paramShareMessengerGenericTemplateElement.getDefaultAction() != null) {
      localJSONObject.put("default_action", serializeActionButton(paramShareMessengerGenericTemplateElement.getDefaultAction(), true));
    }
    AppMethodBeat.o(97135);
    return localJSONObject;
  }
  
  private static JSONObject serializeMediaTemplateContent(ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
  {
    AppMethodBeat.i(97134);
    paramShareMessengerMediaTemplateContent = new JSONArray().put(serializeMediaTemplateElement(paramShareMessengerMediaTemplateContent));
    paramShareMessengerMediaTemplateContent = new JSONObject().put("template_type", "media").put("elements", paramShareMessengerMediaTemplateContent);
    paramShareMessengerMediaTemplateContent = new JSONObject().put("type", "template").put("payload", paramShareMessengerMediaTemplateContent);
    paramShareMessengerMediaTemplateContent = new JSONObject().put("attachment", paramShareMessengerMediaTemplateContent);
    AppMethodBeat.o(97134);
    return paramShareMessengerMediaTemplateContent;
  }
  
  private static JSONObject serializeMediaTemplateElement(ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
  {
    AppMethodBeat.i(97137);
    JSONObject localJSONObject = new JSONObject().put("attachment_id", paramShareMessengerMediaTemplateContent.getAttachmentId()).put("url", Utility.getUriString(paramShareMessengerMediaTemplateContent.getMediaUrl())).put("media_type", getMediaType(paramShareMessengerMediaTemplateContent.getMediaType()));
    if (paramShareMessengerMediaTemplateContent.getButton() != null)
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(serializeActionButton(paramShareMessengerMediaTemplateContent.getButton()));
      localJSONObject.put("buttons", localJSONArray);
    }
    AppMethodBeat.o(97137);
    return localJSONObject;
  }
  
  private static JSONObject serializeOpenGraphMusicTemplateContent(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
  {
    AppMethodBeat.i(97133);
    paramShareMessengerOpenGraphMusicTemplateContent = new JSONArray().put(serializeOpenGraphMusicTemplateElement(paramShareMessengerOpenGraphMusicTemplateContent));
    paramShareMessengerOpenGraphMusicTemplateContent = new JSONObject().put("template_type", "open_graph").put("elements", paramShareMessengerOpenGraphMusicTemplateContent);
    paramShareMessengerOpenGraphMusicTemplateContent = new JSONObject().put("type", "template").put("payload", paramShareMessengerOpenGraphMusicTemplateContent);
    paramShareMessengerOpenGraphMusicTemplateContent = new JSONObject().put("attachment", paramShareMessengerOpenGraphMusicTemplateContent);
    AppMethodBeat.o(97133);
    return paramShareMessengerOpenGraphMusicTemplateContent;
  }
  
  private static JSONObject serializeOpenGraphMusicTemplateElement(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
  {
    AppMethodBeat.i(97136);
    JSONObject localJSONObject = new JSONObject().put("url", Utility.getUriString(paramShareMessengerOpenGraphMusicTemplateContent.getUrl()));
    if (paramShareMessengerOpenGraphMusicTemplateContent.getButton() != null)
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(serializeActionButton(paramShareMessengerOpenGraphMusicTemplateContent.getButton()));
      localJSONObject.put("buttons", localJSONArray);
    }
    AppMethodBeat.o(97136);
    return localJSONObject;
  }
  
  private static JSONObject serializeURLActionButton(ShareMessengerURLActionButton paramShareMessengerURLActionButton, boolean paramBoolean)
  {
    AppMethodBeat.i(97140);
    JSONObject localJSONObject = new JSONObject().put("type", "web_url");
    if (paramBoolean) {}
    for (Object localObject = null;; localObject = paramShareMessengerURLActionButton.getTitle())
    {
      paramShareMessengerURLActionButton = localJSONObject.put("title", localObject).put("url", Utility.getUriString(paramShareMessengerURLActionButton.getUrl())).put("webview_height_ratio", getWebviewHeightRatioString(paramShareMessengerURLActionButton.getWebviewHeightRatio())).put("messenger_extensions", paramShareMessengerURLActionButton.getIsMessengerExtensionURL()).put("fallback_url", Utility.getUriString(paramShareMessengerURLActionButton.getFallbackUrl())).put("webview_share_button", getShouldHideShareButton(paramShareMessengerURLActionButton));
      AppMethodBeat.o(97140);
      return paramShareMessengerURLActionButton;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.MessengerShareContentUtility
 * JD-Core Version:    0.7.0.1
 */