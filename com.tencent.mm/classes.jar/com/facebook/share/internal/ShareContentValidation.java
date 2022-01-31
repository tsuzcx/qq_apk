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
    AppMethodBeat.i(97197);
    if (ApiValidator == null) {
      ApiValidator = new ShareContentValidation.ApiValidator(null);
    }
    Validator localValidator = ApiValidator;
    AppMethodBeat.o(97197);
    return localValidator;
  }
  
  private static Validator getDefaultValidator()
  {
    AppMethodBeat.i(97196);
    if (DefaultValidator == null) {
      DefaultValidator = new Validator(null);
    }
    Validator localValidator = DefaultValidator;
    AppMethodBeat.o(97196);
    return localValidator;
  }
  
  private static Validator getStoryValidator()
  {
    AppMethodBeat.i(97195);
    if (StoryValidator == null) {
      StoryValidator = new ShareContentValidation.StoryShareValidator(null);
    }
    Validator localValidator = StoryValidator;
    AppMethodBeat.o(97195);
    return localValidator;
  }
  
  private static Validator getWebShareValidator()
  {
    AppMethodBeat.i(97198);
    if (WebShareValidator == null) {
      WebShareValidator = new ShareContentValidation.WebShareValidator(null);
    }
    Validator localValidator = WebShareValidator;
    AppMethodBeat.o(97198);
    return localValidator;
  }
  
  private static void validate(ShareContent paramShareContent, Validator paramValidator)
  {
    AppMethodBeat.i(97199);
    if (paramShareContent == null)
    {
      paramShareContent = new FacebookException("Must provide non-null content to share");
      AppMethodBeat.o(97199);
      throw paramShareContent;
    }
    if ((paramShareContent instanceof ShareLinkContent))
    {
      paramValidator.validate((ShareLinkContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof SharePhotoContent))
    {
      paramValidator.validate((SharePhotoContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof ShareVideoContent))
    {
      paramValidator.validate((ShareVideoContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof ShareOpenGraphContent))
    {
      paramValidator.validate((ShareOpenGraphContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof ShareMediaContent))
    {
      paramValidator.validate((ShareMediaContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof ShareCameraEffectContent))
    {
      paramValidator.validate((ShareCameraEffectContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof ShareMessengerOpenGraphMusicTemplateContent))
    {
      paramValidator.validate((ShareMessengerOpenGraphMusicTemplateContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof ShareMessengerMediaTemplateContent))
    {
      paramValidator.validate((ShareMessengerMediaTemplateContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof ShareMessengerGenericTemplateContent))
    {
      paramValidator.validate((ShareMessengerGenericTemplateContent)paramShareContent);
      AppMethodBeat.o(97199);
      return;
    }
    if ((paramShareContent instanceof ShareStoryContent)) {
      paramValidator.validate((ShareStoryContent)paramShareContent);
    }
    AppMethodBeat.o(97199);
  }
  
  private static void validateCameraEffectContent(ShareCameraEffectContent paramShareCameraEffectContent, Validator paramValidator)
  {
    AppMethodBeat.i(97211);
    if (Utility.isNullOrEmpty(paramShareCameraEffectContent.getEffectId()))
    {
      paramShareCameraEffectContent = new FacebookException("Must specify a non-empty effectId");
      AppMethodBeat.o(97211);
      throw paramShareCameraEffectContent;
    }
    AppMethodBeat.o(97211);
  }
  
  public static void validateForApiShare(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97193);
    validate(paramShareContent, getApiValidator());
    AppMethodBeat.o(97193);
  }
  
  public static void validateForMessage(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97190);
    validate(paramShareContent, getDefaultValidator());
    AppMethodBeat.o(97190);
  }
  
  public static void validateForNativeShare(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97191);
    validate(paramShareContent, getDefaultValidator());
    AppMethodBeat.o(97191);
  }
  
  public static void validateForStoryShare(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97194);
    validate(paramShareContent, getStoryValidator());
    AppMethodBeat.o(97194);
  }
  
  public static void validateForWebShare(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97192);
    validate(paramShareContent, getWebShareValidator());
    AppMethodBeat.o(97192);
  }
  
  private static void validateLinkContent(ShareLinkContent paramShareLinkContent, Validator paramValidator)
  {
    AppMethodBeat.i(97201);
    paramShareLinkContent = paramShareLinkContent.getImageUrl();
    if ((paramShareLinkContent != null) && (!Utility.isWebUri(paramShareLinkContent)))
    {
      paramShareLinkContent = new FacebookException("Image Url must be an http:// or https:// url");
      AppMethodBeat.o(97201);
      throw paramShareLinkContent;
    }
    AppMethodBeat.o(97201);
  }
  
  private static void validateMediaContent(ShareMediaContent paramShareMediaContent, Validator paramValidator)
  {
    AppMethodBeat.i(97209);
    paramShareMediaContent = paramShareMediaContent.getMedia();
    if ((paramShareMediaContent == null) || (paramShareMediaContent.isEmpty()))
    {
      paramShareMediaContent = new FacebookException("Must specify at least one medium in ShareMediaContent.");
      AppMethodBeat.o(97209);
      throw paramShareMediaContent;
    }
    if (paramShareMediaContent.size() > 6)
    {
      paramShareMediaContent = new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", new Object[] { Integer.valueOf(6) }));
      AppMethodBeat.o(97209);
      throw paramShareMediaContent;
    }
    paramShareMediaContent = paramShareMediaContent.iterator();
    while (paramShareMediaContent.hasNext()) {
      paramValidator.validate((ShareMedia)paramShareMediaContent.next());
    }
    AppMethodBeat.o(97209);
  }
  
  public static void validateMedium(ShareMedia paramShareMedia, Validator paramValidator)
  {
    AppMethodBeat.i(97210);
    if ((paramShareMedia instanceof SharePhoto))
    {
      paramValidator.validate((SharePhoto)paramShareMedia);
      AppMethodBeat.o(97210);
      return;
    }
    if ((paramShareMedia instanceof ShareVideo))
    {
      paramValidator.validate((ShareVideo)paramShareMedia);
      AppMethodBeat.o(97210);
      return;
    }
    paramShareMedia = new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", new Object[] { paramShareMedia.getClass().getSimpleName() }));
    AppMethodBeat.o(97210);
    throw paramShareMedia;
  }
  
  private static void validateMessengerOpenGraphMusicTemplate(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
  {
    AppMethodBeat.i(97216);
    if (Utility.isNullOrEmpty(paramShareMessengerOpenGraphMusicTemplateContent.getPageId()))
    {
      paramShareMessengerOpenGraphMusicTemplateContent = new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
      AppMethodBeat.o(97216);
      throw paramShareMessengerOpenGraphMusicTemplateContent;
    }
    if (paramShareMessengerOpenGraphMusicTemplateContent.getUrl() == null)
    {
      paramShareMessengerOpenGraphMusicTemplateContent = new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
      AppMethodBeat.o(97216);
      throw paramShareMessengerOpenGraphMusicTemplateContent;
    }
    validateShareMessengerActionButton(paramShareMessengerOpenGraphMusicTemplateContent.getButton());
    AppMethodBeat.o(97216);
  }
  
  private static void validateOpenGraphAction(ShareOpenGraphAction paramShareOpenGraphAction, Validator paramValidator)
  {
    AppMethodBeat.i(97213);
    if (paramShareOpenGraphAction == null)
    {
      paramShareOpenGraphAction = new FacebookException("Must specify a non-null ShareOpenGraphAction");
      AppMethodBeat.o(97213);
      throw paramShareOpenGraphAction;
    }
    if (Utility.isNullOrEmpty(paramShareOpenGraphAction.getActionType()))
    {
      paramShareOpenGraphAction = new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
      AppMethodBeat.o(97213);
      throw paramShareOpenGraphAction;
    }
    paramValidator.validate(paramShareOpenGraphAction, false);
    AppMethodBeat.o(97213);
  }
  
  private static void validateOpenGraphContent(ShareOpenGraphContent paramShareOpenGraphContent, Validator paramValidator)
  {
    AppMethodBeat.i(97212);
    paramValidator.validate(paramShareOpenGraphContent.getAction());
    paramValidator = paramShareOpenGraphContent.getPreviewPropertyName();
    if (Utility.isNullOrEmpty(paramValidator))
    {
      paramShareOpenGraphContent = new FacebookException("Must specify a previewPropertyName.");
      AppMethodBeat.o(97212);
      throw paramShareOpenGraphContent;
    }
    if (paramShareOpenGraphContent.getAction().get(paramValidator) == null)
    {
      paramShareOpenGraphContent = new FacebookException("Property \"" + paramValidator + "\" was not found on the action. The name of the preview property must match the name of an action property.");
      AppMethodBeat.o(97212);
      throw paramShareOpenGraphContent;
    }
    AppMethodBeat.o(97212);
  }
  
  private static void validateOpenGraphKey(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(97221);
    if (!paramBoolean)
    {
      AppMethodBeat.o(97221);
      return;
    }
    String[] arrayOfString = paramString.split(":");
    if (arrayOfString.length < 2)
    {
      paramString = new FacebookException("Open Graph keys must be namespaced: %s", new Object[] { paramString });
      AppMethodBeat.o(97221);
      throw paramString;
    }
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].isEmpty())
      {
        paramString = new FacebookException("Invalid key found in Open Graph dictionary: %s", new Object[] { paramString });
        AppMethodBeat.o(97221);
        throw paramString;
      }
      i += 1;
    }
    AppMethodBeat.o(97221);
  }
  
  private static void validateOpenGraphObject(ShareOpenGraphObject paramShareOpenGraphObject, Validator paramValidator)
  {
    AppMethodBeat.i(97214);
    if (paramShareOpenGraphObject == null)
    {
      paramShareOpenGraphObject = new FacebookException("Cannot share a null ShareOpenGraphObject");
      AppMethodBeat.o(97214);
      throw paramShareOpenGraphObject;
    }
    paramValidator.validate(paramShareOpenGraphObject, true);
    AppMethodBeat.o(97214);
  }
  
  private static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer paramShareOpenGraphValueContainer, Validator paramValidator, boolean paramBoolean)
  {
    AppMethodBeat.i(97215);
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
            AppMethodBeat.o(97215);
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
    AppMethodBeat.o(97215);
  }
  
  private static void validateOpenGraphValueContainerObject(Object paramObject, Validator paramValidator)
  {
    AppMethodBeat.i(97222);
    if ((paramObject instanceof ShareOpenGraphObject))
    {
      paramValidator.validate((ShareOpenGraphObject)paramObject);
      AppMethodBeat.o(97222);
      return;
    }
    if ((paramObject instanceof SharePhoto)) {
      paramValidator.validate((SharePhoto)paramObject);
    }
    AppMethodBeat.o(97222);
  }
  
  private static void validatePhoto(SharePhoto paramSharePhoto)
  {
    AppMethodBeat.i(97203);
    if (paramSharePhoto == null)
    {
      paramSharePhoto = new FacebookException("Cannot share a null SharePhoto");
      AppMethodBeat.o(97203);
      throw paramSharePhoto;
    }
    Bitmap localBitmap = paramSharePhoto.getBitmap();
    paramSharePhoto = paramSharePhoto.getImageUrl();
    if ((localBitmap == null) && (paramSharePhoto == null))
    {
      paramSharePhoto = new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
      AppMethodBeat.o(97203);
      throw paramSharePhoto;
    }
    AppMethodBeat.o(97203);
  }
  
  private static void validatePhotoContent(SharePhotoContent paramSharePhotoContent, Validator paramValidator)
  {
    AppMethodBeat.i(97202);
    paramSharePhotoContent = paramSharePhotoContent.getPhotos();
    if ((paramSharePhotoContent == null) || (paramSharePhotoContent.isEmpty()))
    {
      paramSharePhotoContent = new FacebookException("Must specify at least one Photo in SharePhotoContent.");
      AppMethodBeat.o(97202);
      throw paramSharePhotoContent;
    }
    if (paramSharePhotoContent.size() > 6)
    {
      paramSharePhotoContent = new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", new Object[] { Integer.valueOf(6) }));
      AppMethodBeat.o(97202);
      throw paramSharePhotoContent;
    }
    paramSharePhotoContent = paramSharePhotoContent.iterator();
    while (paramSharePhotoContent.hasNext()) {
      paramValidator.validate((SharePhoto)paramSharePhotoContent.next());
    }
    AppMethodBeat.o(97202);
  }
  
  private static void validatePhotoForApi(SharePhoto paramSharePhoto, Validator paramValidator)
  {
    AppMethodBeat.i(97204);
    validatePhoto(paramSharePhoto);
    Bitmap localBitmap = paramSharePhoto.getBitmap();
    paramSharePhoto = paramSharePhoto.getImageUrl();
    if ((localBitmap == null) && (Utility.isWebUri(paramSharePhoto)) && (!paramValidator.isOpenGraphContent()))
    {
      paramSharePhoto = new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
      AppMethodBeat.o(97204);
      throw paramSharePhoto;
    }
    AppMethodBeat.o(97204);
  }
  
  private static void validatePhotoForNativeDialog(SharePhoto paramSharePhoto, Validator paramValidator)
  {
    AppMethodBeat.i(97205);
    validatePhotoForApi(paramSharePhoto, paramValidator);
    if ((paramSharePhoto.getBitmap() != null) || (!Utility.isWebUri(paramSharePhoto.getImageUrl()))) {
      Validate.hasContentProvider(FacebookSdk.getApplicationContext());
    }
    AppMethodBeat.o(97205);
  }
  
  private static void validatePhotoForWebDialog(SharePhoto paramSharePhoto, Validator paramValidator)
  {
    AppMethodBeat.i(97206);
    validatePhoto(paramSharePhoto);
    AppMethodBeat.o(97206);
  }
  
  private static void validateShareMessengerActionButton(ShareMessengerActionButton paramShareMessengerActionButton)
  {
    AppMethodBeat.i(97219);
    if (paramShareMessengerActionButton == null)
    {
      AppMethodBeat.o(97219);
      return;
    }
    if (Utility.isNullOrEmpty(paramShareMessengerActionButton.getTitle()))
    {
      paramShareMessengerActionButton = new FacebookException("Must specify title for ShareMessengerActionButton");
      AppMethodBeat.o(97219);
      throw paramShareMessengerActionButton;
    }
    if ((paramShareMessengerActionButton instanceof ShareMessengerURLActionButton)) {
      validateShareMessengerURLActionButton((ShareMessengerURLActionButton)paramShareMessengerActionButton);
    }
    AppMethodBeat.o(97219);
  }
  
  private static void validateShareMessengerGenericTemplateContent(ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent)
  {
    AppMethodBeat.i(97217);
    if (Utility.isNullOrEmpty(paramShareMessengerGenericTemplateContent.getPageId()))
    {
      paramShareMessengerGenericTemplateContent = new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
      AppMethodBeat.o(97217);
      throw paramShareMessengerGenericTemplateContent;
    }
    if (paramShareMessengerGenericTemplateContent.getGenericTemplateElement() == null)
    {
      paramShareMessengerGenericTemplateContent = new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
      AppMethodBeat.o(97217);
      throw paramShareMessengerGenericTemplateContent;
    }
    if (Utility.isNullOrEmpty(paramShareMessengerGenericTemplateContent.getGenericTemplateElement().getTitle()))
    {
      paramShareMessengerGenericTemplateContent = new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
      AppMethodBeat.o(97217);
      throw paramShareMessengerGenericTemplateContent;
    }
    validateShareMessengerActionButton(paramShareMessengerGenericTemplateContent.getGenericTemplateElement().getButton());
    AppMethodBeat.o(97217);
  }
  
  private static void validateShareMessengerMediaTemplateContent(ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
  {
    AppMethodBeat.i(97218);
    if (Utility.isNullOrEmpty(paramShareMessengerMediaTemplateContent.getPageId()))
    {
      paramShareMessengerMediaTemplateContent = new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
      AppMethodBeat.o(97218);
      throw paramShareMessengerMediaTemplateContent;
    }
    if ((paramShareMessengerMediaTemplateContent.getMediaUrl() == null) && (Utility.isNullOrEmpty(paramShareMessengerMediaTemplateContent.getAttachmentId())))
    {
      paramShareMessengerMediaTemplateContent = new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
      AppMethodBeat.o(97218);
      throw paramShareMessengerMediaTemplateContent;
    }
    validateShareMessengerActionButton(paramShareMessengerMediaTemplateContent.getButton());
    AppMethodBeat.o(97218);
  }
  
  private static void validateShareMessengerURLActionButton(ShareMessengerURLActionButton paramShareMessengerURLActionButton)
  {
    AppMethodBeat.i(97220);
    if (paramShareMessengerURLActionButton.getUrl() == null)
    {
      paramShareMessengerURLActionButton = new FacebookException("Must specify url for ShareMessengerURLActionButton");
      AppMethodBeat.o(97220);
      throw paramShareMessengerURLActionButton;
    }
    AppMethodBeat.o(97220);
  }
  
  private static void validateStoryContent(ShareStoryContent paramShareStoryContent, Validator paramValidator)
  {
    AppMethodBeat.i(97200);
    if ((paramShareStoryContent == null) || ((paramShareStoryContent.getBackgroundAsset() == null) && (paramShareStoryContent.getStickerAsset() == null)))
    {
      paramShareStoryContent = new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
      AppMethodBeat.o(97200);
      throw paramShareStoryContent;
    }
    if (paramShareStoryContent.getBackgroundAsset() != null) {
      paramValidator.validate(paramShareStoryContent.getBackgroundAsset());
    }
    if (paramShareStoryContent.getStickerAsset() != null) {
      paramValidator.validate(paramShareStoryContent.getStickerAsset());
    }
    AppMethodBeat.o(97200);
  }
  
  private static void validateVideo(ShareVideo paramShareVideo, Validator paramValidator)
  {
    AppMethodBeat.i(97208);
    if (paramShareVideo == null)
    {
      paramShareVideo = new FacebookException("Cannot share a null ShareVideo");
      AppMethodBeat.o(97208);
      throw paramShareVideo;
    }
    paramShareVideo = paramShareVideo.getLocalUrl();
    if (paramShareVideo == null)
    {
      paramShareVideo = new FacebookException("ShareVideo does not have a LocalUrl specified");
      AppMethodBeat.o(97208);
      throw paramShareVideo;
    }
    if ((!Utility.isContentUri(paramShareVideo)) && (!Utility.isFileUri(paramShareVideo)))
    {
      paramShareVideo = new FacebookException("ShareVideo must reference a video that is on the device");
      AppMethodBeat.o(97208);
      throw paramShareVideo;
    }
    AppMethodBeat.o(97208);
  }
  
  private static void validateVideoContent(ShareVideoContent paramShareVideoContent, Validator paramValidator)
  {
    AppMethodBeat.i(97207);
    paramValidator.validate(paramShareVideoContent.getVideo());
    paramShareVideoContent = paramShareVideoContent.getPreviewPhoto();
    if (paramShareVideoContent != null) {
      paramValidator.validate(paramShareVideoContent);
    }
    AppMethodBeat.o(97207);
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
      AppMethodBeat.i(97175);
      ShareContentValidation.access$1100(paramShareCameraEffectContent, this);
      AppMethodBeat.o(97175);
    }
    
    public void validate(ShareLinkContent paramShareLinkContent)
    {
      AppMethodBeat.i(97171);
      ShareContentValidation.access$700(paramShareLinkContent, this);
      AppMethodBeat.o(97171);
    }
    
    public void validate(ShareMedia paramShareMedia)
    {
      AppMethodBeat.i(97182);
      ShareContentValidation.validateMedium(paramShareMedia, this);
      AppMethodBeat.o(97182);
    }
    
    public void validate(ShareMediaContent paramShareMediaContent)
    {
      AppMethodBeat.i(97174);
      ShareContentValidation.access$1000(paramShareMediaContent, this);
      AppMethodBeat.o(97174);
    }
    
    public void validate(ShareMessengerGenericTemplateContent paramShareMessengerGenericTemplateContent)
    {
      AppMethodBeat.i(97184);
      ShareContentValidation.access$1900(paramShareMessengerGenericTemplateContent);
      AppMethodBeat.o(97184);
    }
    
    public void validate(ShareMessengerMediaTemplateContent paramShareMessengerMediaTemplateContent)
    {
      AppMethodBeat.i(97185);
      ShareContentValidation.access$2000(paramShareMessengerMediaTemplateContent);
      AppMethodBeat.o(97185);
    }
    
    public void validate(ShareMessengerOpenGraphMusicTemplateContent paramShareMessengerOpenGraphMusicTemplateContent)
    {
      AppMethodBeat.i(97183);
      ShareContentValidation.access$1800(paramShareMessengerOpenGraphMusicTemplateContent);
      AppMethodBeat.o(97183);
    }
    
    public void validate(ShareOpenGraphAction paramShareOpenGraphAction)
    {
      AppMethodBeat.i(97177);
      ShareContentValidation.access$1300(paramShareOpenGraphAction, this);
      AppMethodBeat.o(97177);
    }
    
    public void validate(ShareOpenGraphContent paramShareOpenGraphContent)
    {
      AppMethodBeat.i(97176);
      this.isOpenGraphContent = true;
      ShareContentValidation.access$1200(paramShareOpenGraphContent, this);
      AppMethodBeat.o(97176);
    }
    
    public void validate(ShareOpenGraphObject paramShareOpenGraphObject)
    {
      AppMethodBeat.i(97178);
      ShareContentValidation.access$1400(paramShareOpenGraphObject, this);
      AppMethodBeat.o(97178);
    }
    
    public void validate(ShareOpenGraphValueContainer paramShareOpenGraphValueContainer, boolean paramBoolean)
    {
      AppMethodBeat.i(97179);
      ShareContentValidation.access$1500(paramShareOpenGraphValueContainer, this, paramBoolean);
      AppMethodBeat.o(97179);
    }
    
    public void validate(SharePhoto paramSharePhoto)
    {
      AppMethodBeat.i(97180);
      ShareContentValidation.access$1600(paramSharePhoto, this);
      AppMethodBeat.o(97180);
    }
    
    public void validate(SharePhotoContent paramSharePhotoContent)
    {
      AppMethodBeat.i(97172);
      ShareContentValidation.access$800(paramSharePhotoContent, this);
      AppMethodBeat.o(97172);
    }
    
    public void validate(ShareStoryContent paramShareStoryContent)
    {
      AppMethodBeat.i(97186);
      ShareContentValidation.access$400(paramShareStoryContent, this);
      AppMethodBeat.o(97186);
    }
    
    public void validate(ShareVideo paramShareVideo)
    {
      AppMethodBeat.i(97181);
      ShareContentValidation.access$1700(paramShareVideo, this);
      AppMethodBeat.o(97181);
    }
    
    public void validate(ShareVideoContent paramShareVideoContent)
    {
      AppMethodBeat.i(97173);
      ShareContentValidation.access$900(paramShareVideoContent, this);
      AppMethodBeat.o(97173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.internal.ShareContentValidation
 * JD-Core Version:    0.7.0.1
 */