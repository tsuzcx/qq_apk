package com.facebook.share.internal;

import android.graphics.Bitmap;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ShareContentValidation
{
  private static Validator ApiValidator;
  private static Validator DefaultValidator;
  private static Validator StoryValidator;
  private static Validator WebShareValidator;
  
  private static Validator getApiValidator()
  {
    AppMethodBeat.i(8221);
    if (ApiValidator == null) {
      ApiValidator = new ApiValidator(null);
    }
    Validator localValidator = ApiValidator;
    AppMethodBeat.o(8221);
    return localValidator;
  }
  
  private static Validator getDefaultValidator()
  {
    AppMethodBeat.i(8220);
    if (DefaultValidator == null) {
      DefaultValidator = new Validator(null);
    }
    Validator localValidator = DefaultValidator;
    AppMethodBeat.o(8220);
    return localValidator;
  }
  
  private static Validator getStoryValidator()
  {
    AppMethodBeat.i(8219);
    if (StoryValidator == null) {
      StoryValidator = new StoryShareValidator(null);
    }
    Validator localValidator = StoryValidator;
    AppMethodBeat.o(8219);
    return localValidator;
  }
  
  private static Validator getWebShareValidator()
  {
    AppMethodBeat.i(8222);
    if (WebShareValidator == null) {
      WebShareValidator = new WebShareValidator(null);
    }
    Validator localValidator = WebShareValidator;
    AppMethodBeat.o(8222);
    return localValidator;
  }
  
  private static void validate(ShareContent paramShareContent, Validator paramValidator)
  {
    AppMethodBeat.i(8223);
    if (paramShareContent == null)
    {
      paramShareContent = new FacebookException("Must provide non-null content to share");
      AppMethodBeat.o(8223);
      throw paramShareContent;
    }
    if ((paramShareContent instanceof ShareLinkContent))
    {
      paramValidator.validate((ShareLinkContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof SharePhotoContent))
    {
      paramValidator.validate((SharePhotoContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof ShareVideoContent))
    {
      paramValidator.validate((ShareVideoContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof ShareOpenGraphContent))
    {
      paramValidator.validate((ShareOpenGraphContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof ShareMediaContent))
    {
      paramValidator.validate((ShareMediaContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof ShareCameraEffectContent))
    {
      paramValidator.validate((ShareCameraEffectContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof ShareMessengerOpenGraphMusicTemplateContent))
    {
      paramValidator.validate((ShareMessengerOpenGraphMusicTemplateContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof ShareMessengerMediaTemplateContent))
    {
      paramValidator.validate((ShareMessengerMediaTemplateContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof ShareMessengerGenericTemplateContent))
    {
      paramValidator.validate((ShareMessengerGenericTemplateContent)paramShareContent);
      AppMethodBeat.o(8223);
      return;
    }
    if ((paramShareContent instanceof ShareStoryContent)) {
      paramValidator.validate((ShareStoryContent)paramShareContent);
    }
    AppMethodBeat.o(8223);
  }
  
  private static void validateCameraEffectContent(ShareCameraEffectContent paramShareCameraEffectContent, Validator paramValidator)
  {
    AppMethodBeat.i(8235);
    if (Utility.isNullOrEmpty(paramShareCameraEffectContent.getEffectId()))
    {
      paramShareCameraEffectContent = new FacebookException("Must specify a non-empty effectId");
      AppMethodBeat.o(8235);
      throw paramShareCameraEffectContent;
    }
    AppMethodBeat.o(8235);
  }
  
  public static void validateForApiShare(ShareContent paramShareContent)
  {
    AppMethodBeat.i(8217);
    validate(paramShareContent, getApiValidator());
    AppMethodBeat.o(8217);
  }
  
  public static void validateForMessage(ShareContent paramShareContent)
  {
    AppMethodBeat.i(8214);
    validate(paramShareContent, getDefaultValidator());
    AppMethodBeat.o(8214);
  }
  
  public static void validateForNativeShare(ShareContent paramShareContent)
  {
    AppMethodBeat.i(8215);
    validate(paramShareContent, getDefaultValidator());
    AppMethodBeat.o(8215);
  }
  
  public static void validateForStoryShare(ShareContent paramShareContent)
  {
    AppMethodBeat.i(8218);
    validate(paramShareContent, getStoryValidator());
    AppMethodBeat.o(8218);
  }
  
  public static void validateForWebShare(ShareContent paramShareContent)
  {
    AppMethodBeat.i(8216);
    validate(paramShareContent, getWebShareValidator());
    AppMethodBeat.o(8216);
  }
  
  private static void validateLinkContent(ShareLinkContent paramShareLinkContent, Validator paramValidator)
  {
    AppMethodBeat.i(8225);
    paramShareLinkContent = paramShareLinkContent.getImageUrl();
    if ((paramShareLinkContent != null) && (!Utility.isWebUri(paramShareLinkContent)))
    {
      paramShareLinkContent = new FacebookException("Image Url must be an http:// or https:// url");
      AppMethodBeat.o(8225);
      throw paramShareLinkContent;
    }
    AppMethodBeat.o(8225);
  }
  
  private static void validateMediaContent(ShareMediaContent paramShareMediaContent, Validator paramValidator)
  {
    AppMethodBeat.i(8233);
    paramShareMediaContent = paramShareMediaContent.getMedia();
    if ((paramShareMediaContent == null) || (paramShareMediaContent.isEmpty()))
    {
      paramShareMediaContent = new FacebookException("Must specify at least one medium in ShareMediaContent.");
      AppMethodBeat.o(8233);
      throw paramShareMediaContent;
    }
    if (paramShareMediaContent.size() > 6)
    {
      paramShareMediaContent = new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", new Object[] { Integer.valueOf(6) }));
      AppMethodBeat.o(8233);
      throw paramShareMediaContent;
    }
    paramShareMediaContent = paramShareMediaContent.iterator();
    while (paramShareMediaContent.hasNext()) {
      paramValidator.validate((ShareMedia)paramShareMediaContent.next());
    }
    AppMethodBeat.o(8233);
  }
  
  public static void validateMedium(ShareMedia paramShareMedia, Validator paramValidator)
  {
    AppMethodBeat.i(8234);
    if ((paramShareMedia instanceof SharePhoto))
    {
      paramValidator.validate((SharePhoto)paramShareMedia);
      AppMethodBeat.o(8234);
      return;
    }
    if ((paramShareMedia instanceof ShareVideo))
    {
      paramValidator.validate((ShareVideo)paramShareMedia);
      AppMethodBeat.o(8234);
      return;
    }
    paramShareMedia = new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", new Object[] { paramShareMedia.getClass().getSimpleName() }));
    AppMethodBeat.o(8234);
    throw paramShareMedia;
  }
  
  private static void validateMessengerOpenGraphMusicTemplate(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
  {
    AppMethodBeat.i(8240);
    if (Utility.isNullOrEmpty(paramShareMessengerOpenGraphMusicTemplateContent.getPageId()))
    {
      paramShareMessengerOpenGraphMusicTemplateContent = new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
      AppMethodBeat.o(8240);
      throw paramShareMessengerOpenGraphMusicTemplateContent;
    }
    if (paramShareMessengerOpenGraphMusicTemplateContent.getUrl() == null)
    {
      paramShareMessengerOpenGraphMusicTemplateContent = new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
      AppMethodBeat.o(8240);
      throw paramShareMessengerOpenGraphMusicTemplateContent;
    }
    validateShareMessengerActionButton(paramShareMessengerOpenGraphMusicTemplateContent.getButton());
    AppMethodBeat.o(8240);
  }
  
  private static void validateOpenGraphAction(ShareOpenGraphAction paramShareOpenGraphAction, Validator paramValidator)
  {
    AppMethodBeat.i(8237);
    if (paramShareOpenGraphAction == null)
    {
      paramShareOpenGraphAction = new FacebookException("Must specify a non-null ShareOpenGraphAction");
      AppMethodBeat.o(8237);
      throw paramShareOpenGraphAction;
    }
    if (Utility.isNullOrEmpty(paramShareOpenGraphAction.getActionType()))
    {
      paramShareOpenGraphAction = new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
      AppMethodBeat.o(8237);
      throw paramShareOpenGraphAction;
    }
    paramValidator.validate(paramShareOpenGraphAction, false);
    AppMethodBeat.o(8237);
  }
  
  private static void validateOpenGraphContent(ShareOpenGraphContent paramShareOpenGraphContent, Validator paramValidator)
  {
    AppMethodBeat.i(8236);
    paramValidator.validate(paramShareOpenGraphContent.getAction());
    paramValidator = paramShareOpenGraphContent.getPreviewPropertyName();
    if (Utility.isNullOrEmpty(paramValidator))
    {
      paramShareOpenGraphContent = new FacebookException("Must specify a previewPropertyName.");
      AppMethodBeat.o(8236);
      throw paramShareOpenGraphContent;
    }
    if (paramShareOpenGraphContent.getAction().get(paramValidator) == null)
    {
      paramShareOpenGraphContent = new FacebookException("Property \"" + paramValidator + "\" was not found on the action. The name of the preview property must match the name of an action property.");
      AppMethodBeat.o(8236);
      throw paramShareOpenGraphContent;
    }
    AppMethodBeat.o(8236);
  }
  
  private static void validateOpenGraphKey(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(8245);
    if (!paramBoolean)
    {
      AppMethodBeat.o(8245);
      return;
    }
    String[] arrayOfString = paramString.split(":");
    if (arrayOfString.length < 2)
    {
      paramString = new FacebookException("Open Graph keys must be namespaced: %s", new Object[] { paramString });
      AppMethodBeat.o(8245);
      throw paramString;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].isEmpty())
      {
        paramString = new FacebookException("Invalid key found in Open Graph dictionary: %s", new Object[] { paramString });
        AppMethodBeat.o(8245);
        throw paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(8245);
  }
  
  private static void validateOpenGraphObject(ShareOpenGraphObject paramShareOpenGraphObject, Validator paramValidator)
  {
    AppMethodBeat.i(8238);
    if (paramShareOpenGraphObject == null)
    {
      paramShareOpenGraphObject = new FacebookException("Cannot share a null ShareOpenGraphObject");
      AppMethodBeat.o(8238);
      throw paramShareOpenGraphObject;
    }
    paramValidator.validate(paramShareOpenGraphObject, true);
    AppMethodBeat.o(8238);
  }
  
  private static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer paramShareOpenGraphValueContainer, Validator paramValidator, boolean paramBoolean)
  {
    AppMethodBeat.i(8239);
    Iterator localIterator = paramShareOpenGraphValueContainer.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      validateOpenGraphKey((String)localObject1, paramBoolean);
      localObject1 = paramShareOpenGraphValueContainer.get((String)localObject1);
      if ((localObject1 instanceof List))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          if (localObject2 == null)
          {
            paramShareOpenGraphValueContainer = new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
            AppMethodBeat.o(8239);
            throw paramShareOpenGraphValueContainer;
          }
          validateOpenGraphValueContainerObject(localObject2, paramValidator);
        }
      }
      else
      {
        validateOpenGraphValueContainerObject(localObject1, paramValidator);
      }
    }
    AppMethodBeat.o(8239);
  }
  
  private static void validateOpenGraphValueContainerObject(Object paramObject, Validator paramValidator)
  {
    AppMethodBeat.i(8246);
    if ((paramObject instanceof ShareOpenGraphObject))
    {
      paramValidator.validate((ShareOpenGraphObject)paramObject);
      AppMethodBeat.o(8246);
      return;
    }
    if ((paramObject instanceof SharePhoto)) {
      paramValidator.validate((SharePhoto)paramObject);
    }
    AppMethodBeat.o(8246);
  }
  
  private static void validatePhoto(SharePhoto paramSharePhoto)
  {
    AppMethodBeat.i(8227);
    if (paramSharePhoto == null)
    {
      paramSharePhoto = new FacebookException("Cannot share a null SharePhoto");
      AppMethodBeat.o(8227);
      throw paramSharePhoto;
    }
    Bitmap localBitmap = paramSharePhoto.getBitmap();
    paramSharePhoto = paramSharePhoto.getImageUrl();
    if ((localBitmap == null) && (paramSharePhoto == null))
    {
      paramSharePhoto = new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
      AppMethodBeat.o(8227);
      throw paramSharePhoto;
    }
    AppMethodBeat.o(8227);
  }
  
  private static void validatePhotoContent(SharePhotoContent paramSharePhotoContent, Validator paramValidator)
  {
    AppMethodBeat.i(8226);
    paramSharePhotoContent = paramSharePhotoContent.getPhotos();
    if ((paramSharePhotoContent == null) || (paramSharePhotoContent.isEmpty()))
    {
      paramSharePhotoContent = new FacebookException("Must specify at least one Photo in SharePhotoContent.");
      AppMethodBeat.o(8226);
      throw paramSharePhotoContent;
    }
    if (paramSharePhotoContent.size() > 6)
    {
      paramSharePhotoContent = new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", new Object[] { Integer.valueOf(6) }));
      AppMethodBeat.o(8226);
      throw paramSharePhotoContent;
    }
    paramSharePhotoContent = paramSharePhotoContent.iterator();
    while (paramSharePhotoContent.hasNext()) {
      paramValidator.validate((SharePhoto)paramSharePhotoContent.next());
    }
    AppMethodBeat.o(8226);
  }
  
  private static void validatePhotoForApi(SharePhoto paramSharePhoto, Validator paramValidator)
  {
    AppMethodBeat.i(8228);
    validatePhoto(paramSharePhoto);
    Bitmap localBitmap = paramSharePhoto.getBitmap();
    paramSharePhoto = paramSharePhoto.getImageUrl();
    if ((localBitmap == null) && (Utility.isWebUri(paramSharePhoto)) && (!paramValidator.isOpenGraphContent()))
    {
      paramSharePhoto = new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
      AppMethodBeat.o(8228);
      throw paramSharePhoto;
    }
    AppMethodBeat.o(8228);
  }
  
  private static void validatePhotoForNativeDialog(SharePhoto paramSharePhoto, Validator paramValidator)
  {
    AppMethodBeat.i(8229);
    validatePhotoForApi(paramSharePhoto, paramValidator);
    if ((paramSharePhoto.getBitmap() != null) || (!Utility.isWebUri(paramSharePhoto.getImageUrl()))) {
      Validate.hasContentProvider(FacebookSdk.getApplicationContext());
    }
    AppMethodBeat.o(8229);
  }
  
  private static void validatePhotoForWebDialog(SharePhoto paramSharePhoto, Validator paramValidator)
  {
    AppMethodBeat.i(8230);
    validatePhoto(paramSharePhoto);
    AppMethodBeat.o(8230);
  }
  
  private static void validateShareMessengerActionButton(ShareMessengerActionButton paramShareMessengerActionButton)
  {
    AppMethodBeat.i(8243);
    if (paramShareMessengerActionButton == null)
    {
      AppMethodBeat.o(8243);
      return;
    }
    if (Utility.isNullOrEmpty(paramShareMessengerActionButton.getTitle()))
    {
      paramShareMessengerActionButton = new FacebookException("Must specify title for ShareMessengerActionButton");
      AppMethodBeat.o(8243);
      throw paramShareMessengerActionButton;
    }
    if ((paramShareMessengerActionButton instanceof ShareMessengerURLActionButton)) {
      validateShareMessengerURLActionButton((ShareMessengerURLActionButton)paramShareMessengerActionButton);
    }
    AppMethodBeat.o(8243);
  }
  
  private static void validateShareMessengerGenericTemplateContent(ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent)
  {
    AppMethodBeat.i(8241);
    if (Utility.isNullOrEmpty(paramShareMessengerGenericTemplateContent.getPageId()))
    {
      paramShareMessengerGenericTemplateContent = new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
      AppMethodBeat.o(8241);
      throw paramShareMessengerGenericTemplateContent;
    }
    if (paramShareMessengerGenericTemplateContent.getGenericTemplateElement() == null)
    {
      paramShareMessengerGenericTemplateContent = new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
      AppMethodBeat.o(8241);
      throw paramShareMessengerGenericTemplateContent;
    }
    if (Utility.isNullOrEmpty(paramShareMessengerGenericTemplateContent.getGenericTemplateElement().getTitle()))
    {
      paramShareMessengerGenericTemplateContent = new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
      AppMethodBeat.o(8241);
      throw paramShareMessengerGenericTemplateContent;
    }
    validateShareMessengerActionButton(paramShareMessengerGenericTemplateContent.getGenericTemplateElement().getButton());
    AppMethodBeat.o(8241);
  }
  
  private static void validateShareMessengerMediaTemplateContent(ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
  {
    AppMethodBeat.i(8242);
    if (Utility.isNullOrEmpty(paramShareMessengerMediaTemplateContent.getPageId()))
    {
      paramShareMessengerMediaTemplateContent = new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
      AppMethodBeat.o(8242);
      throw paramShareMessengerMediaTemplateContent;
    }
    if ((paramShareMessengerMediaTemplateContent.getMediaUrl() == null) && (Utility.isNullOrEmpty(paramShareMessengerMediaTemplateContent.getAttachmentId())))
    {
      paramShareMessengerMediaTemplateContent = new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
      AppMethodBeat.o(8242);
      throw paramShareMessengerMediaTemplateContent;
    }
    validateShareMessengerActionButton(paramShareMessengerMediaTemplateContent.getButton());
    AppMethodBeat.o(8242);
  }
  
  private static void validateShareMessengerURLActionButton(ShareMessengerURLActionButton paramShareMessengerURLActionButton)
  {
    AppMethodBeat.i(8244);
    if (paramShareMessengerURLActionButton.getUrl() == null)
    {
      paramShareMessengerURLActionButton = new FacebookException("Must specify url for ShareMessengerURLActionButton");
      AppMethodBeat.o(8244);
      throw paramShareMessengerURLActionButton;
    }
    AppMethodBeat.o(8244);
  }
  
  private static void validateStoryContent(ShareStoryContent paramShareStoryContent, Validator paramValidator)
  {
    AppMethodBeat.i(8224);
    if ((paramShareStoryContent == null) || ((paramShareStoryContent.getBackgroundAsset() == null) && (paramShareStoryContent.getStickerAsset() == null)))
    {
      paramShareStoryContent = new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
      AppMethodBeat.o(8224);
      throw paramShareStoryContent;
    }
    if (paramShareStoryContent.getBackgroundAsset() != null) {
      paramValidator.validate(paramShareStoryContent.getBackgroundAsset());
    }
    if (paramShareStoryContent.getStickerAsset() != null) {
      paramValidator.validate(paramShareStoryContent.getStickerAsset());
    }
    AppMethodBeat.o(8224);
  }
  
  private static void validateVideo(ShareVideo paramShareVideo, Validator paramValidator)
  {
    AppMethodBeat.i(8232);
    if (paramShareVideo == null)
    {
      paramShareVideo = new FacebookException("Cannot share a null ShareVideo");
      AppMethodBeat.o(8232);
      throw paramShareVideo;
    }
    paramShareVideo = paramShareVideo.getLocalUrl();
    if (paramShareVideo == null)
    {
      paramShareVideo = new FacebookException("ShareVideo does not have a LocalUrl specified");
      AppMethodBeat.o(8232);
      throw paramShareVideo;
    }
    if ((!Utility.isContentUri(paramShareVideo)) && (!Utility.isFileUri(paramShareVideo)))
    {
      paramShareVideo = new FacebookException("ShareVideo must reference a video that is on the device");
      AppMethodBeat.o(8232);
      throw paramShareVideo;
    }
    AppMethodBeat.o(8232);
  }
  
  private static void validateVideoContent(ShareVideoContent paramShareVideoContent, Validator paramValidator)
  {
    AppMethodBeat.i(8231);
    paramValidator.validate(paramShareVideoContent.getVideo());
    paramShareVideoContent = paramShareVideoContent.getPreviewPhoto();
    if (paramShareVideoContent != null) {
      paramValidator.validate(paramShareVideoContent);
    }
    AppMethodBeat.o(8231);
  }
  
  static class ApiValidator
    extends ShareContentValidation.Validator
  {
    private ApiValidator()
    {
      super();
    }
    
    public void validate(ShareLinkContent paramShareLinkContent)
    {
      AppMethodBeat.i(8193);
      if (!Utility.isNullOrEmpty(paramShareLinkContent.getQuote()))
      {
        paramShareLinkContent = new FacebookException("Cannot share link content with quote using the share api");
        AppMethodBeat.o(8193);
        throw paramShareLinkContent;
      }
      AppMethodBeat.o(8193);
    }
    
    public void validate(ShareMediaContent paramShareMediaContent)
    {
      AppMethodBeat.i(8192);
      paramShareMediaContent = new FacebookException("Cannot share ShareMediaContent using the share api");
      AppMethodBeat.o(8192);
      throw paramShareMediaContent;
    }
    
    public void validate(SharePhoto paramSharePhoto)
    {
      AppMethodBeat.i(8190);
      ShareContentValidation.access$600(paramSharePhoto, this);
      AppMethodBeat.o(8190);
    }
    
    public void validate(ShareVideoContent paramShareVideoContent)
    {
      AppMethodBeat.i(8191);
      if (!Utility.isNullOrEmpty(paramShareVideoContent.getPlaceId()))
      {
        paramShareVideoContent = new FacebookException("Cannot share video content with place IDs using the share api");
        AppMethodBeat.o(8191);
        throw paramShareVideoContent;
      }
      if (!Utility.isNullOrEmpty(paramShareVideoContent.getPeopleIds()))
      {
        paramShareVideoContent = new FacebookException("Cannot share video content with people IDs using the share api");
        AppMethodBeat.o(8191);
        throw paramShareVideoContent;
      }
      if (!Utility.isNullOrEmpty(paramShareVideoContent.getRef()))
      {
        paramShareVideoContent = new FacebookException("Cannot share video content with referrer URL using the share api");
        AppMethodBeat.o(8191);
        throw paramShareVideoContent;
      }
      AppMethodBeat.o(8191);
    }
  }
  
  static class StoryShareValidator
    extends ShareContentValidation.Validator
  {
    private StoryShareValidator()
    {
      super();
    }
    
    public void validate(ShareStoryContent paramShareStoryContent)
    {
      AppMethodBeat.i(8194);
      ShareContentValidation.access$400(paramShareStoryContent, this);
      AppMethodBeat.o(8194);
    }
  }
  
  static class Validator
  {
    private boolean isOpenGraphContent = false;
    
    public boolean isOpenGraphContent()
    {
      return this.isOpenGraphContent;
    }
    
    public void validate(ShareCameraEffectContent paramShareCameraEffectContent)
    {
      AppMethodBeat.i(8199);
      ShareContentValidation.access$1100(paramShareCameraEffectContent, this);
      AppMethodBeat.o(8199);
    }
    
    public void validate(ShareLinkContent paramShareLinkContent)
    {
      AppMethodBeat.i(8195);
      ShareContentValidation.access$700(paramShareLinkContent, this);
      AppMethodBeat.o(8195);
    }
    
    public void validate(ShareMedia paramShareMedia)
    {
      AppMethodBeat.i(8206);
      ShareContentValidation.validateMedium(paramShareMedia, this);
      AppMethodBeat.o(8206);
    }
    
    public void validate(ShareMediaContent paramShareMediaContent)
    {
      AppMethodBeat.i(8198);
      ShareContentValidation.access$1000(paramShareMediaContent, this);
      AppMethodBeat.o(8198);
    }
    
    public void validate(ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent)
    {
      AppMethodBeat.i(8208);
      ShareContentValidation.access$1900(paramShareMessengerGenericTemplateContent);
      AppMethodBeat.o(8208);
    }
    
    public void validate(ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
    {
      AppMethodBeat.i(8209);
      ShareContentValidation.access$2000(paramShareMessengerMediaTemplateContent);
      AppMethodBeat.o(8209);
    }
    
    public void validate(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
    {
      AppMethodBeat.i(8207);
      ShareContentValidation.access$1800(paramShareMessengerOpenGraphMusicTemplateContent);
      AppMethodBeat.o(8207);
    }
    
    public void validate(ShareOpenGraphAction paramShareOpenGraphAction)
    {
      AppMethodBeat.i(8201);
      ShareContentValidation.access$1300(paramShareOpenGraphAction, this);
      AppMethodBeat.o(8201);
    }
    
    public void validate(ShareOpenGraphContent paramShareOpenGraphContent)
    {
      AppMethodBeat.i(8200);
      this.isOpenGraphContent = true;
      ShareContentValidation.access$1200(paramShareOpenGraphContent, this);
      AppMethodBeat.o(8200);
    }
    
    public void validate(ShareOpenGraphObject paramShareOpenGraphObject)
    {
      AppMethodBeat.i(8202);
      ShareContentValidation.access$1400(paramShareOpenGraphObject, this);
      AppMethodBeat.o(8202);
    }
    
    public void validate(ShareOpenGraphValueContainer paramShareOpenGraphValueContainer, boolean paramBoolean)
    {
      AppMethodBeat.i(8203);
      ShareContentValidation.access$1500(paramShareOpenGraphValueContainer, this, paramBoolean);
      AppMethodBeat.o(8203);
    }
    
    public void validate(SharePhoto paramSharePhoto)
    {
      AppMethodBeat.i(8204);
      ShareContentValidation.access$1600(paramSharePhoto, this);
      AppMethodBeat.o(8204);
    }
    
    public void validate(SharePhotoContent paramSharePhotoContent)
    {
      AppMethodBeat.i(8196);
      ShareContentValidation.access$800(paramSharePhotoContent, this);
      AppMethodBeat.o(8196);
    }
    
    public void validate(ShareStoryContent paramShareStoryContent)
    {
      AppMethodBeat.i(8210);
      ShareContentValidation.access$400(paramShareStoryContent, this);
      AppMethodBeat.o(8210);
    }
    
    public void validate(ShareVideo paramShareVideo)
    {
      AppMethodBeat.i(8205);
      ShareContentValidation.access$1700(paramShareVideo, this);
      AppMethodBeat.o(8205);
    }
    
    public void validate(ShareVideoContent paramShareVideoContent)
    {
      AppMethodBeat.i(8197);
      ShareContentValidation.access$900(paramShareVideoContent, this);
      AppMethodBeat.o(8197);
    }
  }
  
  static class WebShareValidator
    extends ShareContentValidation.Validator
  {
    private WebShareValidator()
    {
      super();
    }
    
    public void validate(ShareMediaContent paramShareMediaContent)
    {
      AppMethodBeat.i(8212);
      paramShareMediaContent = new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
      AppMethodBeat.o(8212);
      throw paramShareMediaContent;
    }
    
    public void validate(SharePhoto paramSharePhoto)
    {
      AppMethodBeat.i(8213);
      ShareContentValidation.access$500(paramSharePhoto, this);
      AppMethodBeat.o(8213);
    }
    
    public void validate(ShareVideoContent paramShareVideoContent)
    {
      AppMethodBeat.i(8211);
      paramShareVideoContent = new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
      AppMethodBeat.o(8211);
      throw paramShareVideoContent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.ShareContentValidation
 * JD-Core Version:    0.7.0.1
 */