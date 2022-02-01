package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhoto.Builder;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.Builder;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class ShareDialog
  extends FacebookDialogBase<ShareContent, Sharer.Result>
  implements Sharer
{
  private static final int DEFAULT_REQUEST_CODE;
  private static final String FEED_DIALOG = "feed";
  private static final String TAG;
  private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
  public static final String WEB_SHARE_DIALOG = "share";
  private boolean isAutomaticMode;
  private boolean shouldFailOnDataError;
  
  static
  {
    AppMethodBeat.i(8760);
    TAG = ShareDialog.class.getSimpleName();
    DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
    AppMethodBeat.o(8760);
  }
  
  public ShareDialog(Activity paramActivity)
  {
    super(paramActivity, DEFAULT_REQUEST_CODE);
    AppMethodBeat.i(8738);
    this.shouldFailOnDataError = false;
    this.isAutomaticMode = true;
    ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    AppMethodBeat.o(8738);
  }
  
  ShareDialog(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    AppMethodBeat.i(8742);
    this.shouldFailOnDataError = false;
    this.isAutomaticMode = true;
    ShareInternalUtility.registerStaticShareCallback(paramInt);
    AppMethodBeat.o(8742);
  }
  
  public ShareDialog(android.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
    AppMethodBeat.i(8740);
    AppMethodBeat.o(8740);
  }
  
  ShareDialog(android.app.Fragment paramFragment, int paramInt)
  {
    this(new FragmentWrapper(paramFragment), paramInt);
    AppMethodBeat.i(8744);
    AppMethodBeat.o(8744);
  }
  
  public ShareDialog(android.support.v4.app.Fragment paramFragment)
  {
    this(new FragmentWrapper(paramFragment));
    AppMethodBeat.i(8739);
    AppMethodBeat.o(8739);
  }
  
  ShareDialog(android.support.v4.app.Fragment paramFragment, int paramInt)
  {
    this(new FragmentWrapper(paramFragment), paramInt);
    AppMethodBeat.i(8743);
    AppMethodBeat.o(8743);
  }
  
  private ShareDialog(FragmentWrapper paramFragmentWrapper)
  {
    super(paramFragmentWrapper, DEFAULT_REQUEST_CODE);
    AppMethodBeat.i(8741);
    this.shouldFailOnDataError = false;
    this.isAutomaticMode = true;
    ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    AppMethodBeat.o(8741);
  }
  
  private ShareDialog(FragmentWrapper paramFragmentWrapper, int paramInt)
  {
    super(paramFragmentWrapper, paramInt);
    AppMethodBeat.i(8745);
    this.shouldFailOnDataError = false;
    this.isAutomaticMode = true;
    ShareInternalUtility.registerStaticShareCallback(paramInt);
    AppMethodBeat.o(8745);
  }
  
  public static boolean canShow(Class<? extends ShareContent> paramClass)
  {
    AppMethodBeat.i(8734);
    if ((canShowWebTypeCheck(paramClass)) || (canShowNative(paramClass)))
    {
      AppMethodBeat.o(8734);
      return true;
    }
    AppMethodBeat.o(8734);
    return false;
  }
  
  private static boolean canShowNative(Class<? extends ShareContent> paramClass)
  {
    AppMethodBeat.i(8735);
    paramClass = getFeature(paramClass);
    if ((paramClass != null) && (DialogPresenter.canPresentNativeDialogWithFeature(paramClass)))
    {
      AppMethodBeat.o(8735);
      return true;
    }
    AppMethodBeat.o(8735);
    return false;
  }
  
  private static boolean canShowWebCheck(ShareContent paramShareContent)
  {
    AppMethodBeat.i(8737);
    if (!canShowWebTypeCheck(paramShareContent.getClass()))
    {
      AppMethodBeat.o(8737);
      return false;
    }
    if ((paramShareContent instanceof ShareOpenGraphContent)) {
      paramShareContent = (ShareOpenGraphContent)paramShareContent;
    }
    try
    {
      ShareInternalUtility.toJSONObjectForWeb(paramShareContent);
      AppMethodBeat.o(8737);
      return true;
    }
    catch (Exception paramShareContent)
    {
      Utility.logd(TAG, "canShow returned false because the content of the Opem Graph object can't be shared via the web dialog", paramShareContent);
      AppMethodBeat.o(8737);
    }
    return false;
  }
  
  private static boolean canShowWebTypeCheck(Class<? extends ShareContent> paramClass)
  {
    AppMethodBeat.i(8736);
    if ((ShareLinkContent.class.isAssignableFrom(paramClass)) || (ShareOpenGraphContent.class.isAssignableFrom(paramClass)) || ((SharePhotoContent.class.isAssignableFrom(paramClass)) && (AccessToken.isCurrentAccessTokenActive())))
    {
      AppMethodBeat.o(8736);
      return true;
    }
    AppMethodBeat.o(8736);
    return false;
  }
  
  private static DialogFeature getFeature(Class<? extends ShareContent> paramClass)
  {
    AppMethodBeat.i(8751);
    if (ShareLinkContent.class.isAssignableFrom(paramClass))
    {
      paramClass = ShareDialogFeature.SHARE_DIALOG;
      AppMethodBeat.o(8751);
      return paramClass;
    }
    if (SharePhotoContent.class.isAssignableFrom(paramClass))
    {
      paramClass = ShareDialogFeature.PHOTOS;
      AppMethodBeat.o(8751);
      return paramClass;
    }
    if (ShareVideoContent.class.isAssignableFrom(paramClass))
    {
      paramClass = ShareDialogFeature.VIDEO;
      AppMethodBeat.o(8751);
      return paramClass;
    }
    if (ShareOpenGraphContent.class.isAssignableFrom(paramClass))
    {
      paramClass = OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
      AppMethodBeat.o(8751);
      return paramClass;
    }
    if (ShareMediaContent.class.isAssignableFrom(paramClass))
    {
      paramClass = ShareDialogFeature.MULTIMEDIA;
      AppMethodBeat.o(8751);
      return paramClass;
    }
    if (ShareCameraEffectContent.class.isAssignableFrom(paramClass))
    {
      paramClass = CameraEffectFeature.SHARE_CAMERA_EFFECT;
      AppMethodBeat.o(8751);
      return paramClass;
    }
    if (ShareStoryContent.class.isAssignableFrom(paramClass))
    {
      paramClass = ShareStoryFeature.SHARE_STORY_ASSET;
      AppMethodBeat.o(8751);
      return paramClass;
    }
    AppMethodBeat.o(8751);
    return null;
  }
  
  private void logDialogShare(Context paramContext, ShareContent paramShareContent, Mode paramMode)
  {
    AppMethodBeat.i(8752);
    if (this.isAutomaticMode) {
      paramMode = Mode.AUTOMATIC;
    }
    switch (1.$SwitchMap$com$facebook$share$widget$ShareDialog$Mode[paramMode.ordinal()])
    {
    default: 
      paramMode = "unknown";
      paramShareContent = getFeature(paramShareContent.getClass());
      if (paramShareContent == ShareDialogFeature.SHARE_DIALOG) {
        paramShareContent = "status";
      }
      break;
    }
    for (;;)
    {
      paramContext = AppEventsLogger.newLogger(paramContext);
      Bundle localBundle = new Bundle();
      localBundle.putString("fb_share_dialog_show", paramMode);
      localBundle.putString("fb_share_dialog_content_type", paramShareContent);
      paramContext.logSdkEvent("fb_share_dialog_show", null, localBundle);
      AppMethodBeat.o(8752);
      return;
      paramMode = "automatic";
      break;
      paramMode = "web";
      break;
      paramMode = "native";
      break;
      if (paramShareContent == ShareDialogFeature.PHOTOS) {
        paramShareContent = "photo";
      } else if (paramShareContent == ShareDialogFeature.VIDEO) {
        paramShareContent = "video";
      } else if (paramShareContent == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
        paramShareContent = "open_graph";
      } else {
        paramShareContent = "unknown";
      }
    }
  }
  
  public static void show(Activity paramActivity, ShareContent paramShareContent)
  {
    AppMethodBeat.i(8730);
    new ShareDialog(paramActivity).show(paramShareContent);
    AppMethodBeat.o(8730);
  }
  
  public static void show(android.app.Fragment paramFragment, ShareContent paramShareContent)
  {
    AppMethodBeat.i(8732);
    show(new FragmentWrapper(paramFragment), paramShareContent);
    AppMethodBeat.o(8732);
  }
  
  public static void show(android.support.v4.app.Fragment paramFragment, ShareContent paramShareContent)
  {
    AppMethodBeat.i(8731);
    show(new FragmentWrapper(paramFragment), paramShareContent);
    AppMethodBeat.o(8731);
  }
  
  private static void show(FragmentWrapper paramFragmentWrapper, ShareContent paramShareContent)
  {
    AppMethodBeat.i(8733);
    new ShareDialog(paramFragmentWrapper).show(paramShareContent);
    AppMethodBeat.o(8733);
  }
  
  public final boolean canShow(ShareContent paramShareContent, Mode paramMode)
  {
    AppMethodBeat.i(8747);
    Object localObject = paramMode;
    if (paramMode == Mode.AUTOMATIC) {
      localObject = BASE_AUTOMATIC_MODE;
    }
    boolean bool = canShowImpl(paramShareContent, localObject);
    AppMethodBeat.o(8747);
    return bool;
  }
  
  public final AppCall createBaseAppCall()
  {
    AppMethodBeat.i(8749);
    AppCall localAppCall = new AppCall(getRequestCode());
    AppMethodBeat.o(8749);
    return localAppCall;
  }
  
  public final List<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> getOrderedModeHandlers()
  {
    AppMethodBeat.i(8750);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new NativeHandler(null));
    localArrayList.add(new FeedHandler(null));
    localArrayList.add(new WebShareHandler(null));
    localArrayList.add(new CameraEffectHandler(null));
    localArrayList.add(new ShareStoryHandler(null));
    AppMethodBeat.o(8750);
    return localArrayList;
  }
  
  public final boolean getShouldFailOnDataError()
  {
    return this.shouldFailOnDataError;
  }
  
  public final void registerCallbackImpl(CallbackManagerImpl paramCallbackManagerImpl, FacebookCallback<Sharer.Result> paramFacebookCallback)
  {
    AppMethodBeat.i(8746);
    ShareInternalUtility.registerSharerCallback(getRequestCode(), paramCallbackManagerImpl, paramFacebookCallback);
    AppMethodBeat.o(8746);
  }
  
  public final void setShouldFailOnDataError(boolean paramBoolean)
  {
    this.shouldFailOnDataError = paramBoolean;
  }
  
  public final void show(ShareContent paramShareContent, Mode paramMode)
  {
    AppMethodBeat.i(8748);
    if (paramMode == Mode.AUTOMATIC) {}
    for (boolean bool = true;; bool = false)
    {
      this.isAutomaticMode = bool;
      if (this.isAutomaticMode) {
        paramMode = BASE_AUTOMATIC_MODE;
      }
      showImpl(paramShareContent, paramMode);
      AppMethodBeat.o(8748);
      return;
    }
  }
  
  class CameraEffectHandler
    extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
  {
    private CameraEffectHandler()
    {
      super();
    }
    
    public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
    {
      AppMethodBeat.i(8703);
      if (((paramShareContent instanceof ShareCameraEffectContent)) && (ShareDialog.access$500(paramShareContent.getClass())))
      {
        AppMethodBeat.o(8703);
        return true;
      }
      AppMethodBeat.o(8703);
      return false;
    }
    
    public AppCall createAppCall(final ShareContent paramShareContent)
    {
      AppMethodBeat.i(8704);
      ShareContentValidation.validateForNativeShare(paramShareContent);
      final AppCall localAppCall = ShareDialog.this.createBaseAppCall();
      DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
      {
        public Bundle getLegacyParameters()
        {
          AppMethodBeat.i(8702);
          Bundle localBundle = LegacyNativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, this.val$shouldFailOnDataError);
          AppMethodBeat.o(8702);
          return localBundle;
        }
        
        public Bundle getParameters()
        {
          AppMethodBeat.i(8701);
          Bundle localBundle = NativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, this.val$shouldFailOnDataError);
          AppMethodBeat.o(8701);
          return localBundle;
        }
      }, ShareDialog.access$800(paramShareContent.getClass()));
      AppMethodBeat.o(8704);
      return localAppCall;
    }
    
    public Object getMode()
    {
      return ShareDialog.Mode.NATIVE;
    }
  }
  
  class FeedHandler
    extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
  {
    private FeedHandler()
    {
      super();
    }
    
    public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
    {
      return ((paramShareContent instanceof ShareLinkContent)) || ((paramShareContent instanceof ShareFeedContent));
    }
    
    public AppCall createAppCall(ShareContent paramShareContent)
    {
      AppMethodBeat.i(8707);
      ShareDialog.access$700(ShareDialog.this, ShareDialog.access$1100(ShareDialog.this), paramShareContent, ShareDialog.Mode.FEED);
      AppCall localAppCall = ShareDialog.this.createBaseAppCall();
      if ((paramShareContent instanceof ShareLinkContent))
      {
        paramShareContent = (ShareLinkContent)paramShareContent;
        ShareContentValidation.validateForWebShare(paramShareContent);
      }
      for (paramShareContent = WebDialogParameters.createForFeed(paramShareContent);; paramShareContent = WebDialogParameters.createForFeed((ShareFeedContent)paramShareContent))
      {
        DialogPresenter.setupAppCallForWebDialog(localAppCall, "feed", paramShareContent);
        AppMethodBeat.o(8707);
        return localAppCall;
      }
    }
    
    public Object getMode()
    {
      return ShareDialog.Mode.FEED;
    }
  }
  
  public static enum Mode
  {
    static
    {
      AppMethodBeat.i(8712);
      AUTOMATIC = new Mode("AUTOMATIC", 0);
      NATIVE = new Mode("NATIVE", 1);
      WEB = new Mode("WEB", 2);
      FEED = new Mode("FEED", 3);
      $VALUES = new Mode[] { AUTOMATIC, NATIVE, WEB, FEED };
      AppMethodBeat.o(8712);
    }
    
    private Mode() {}
  }
  
  class NativeHandler
    extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
  {
    private NativeHandler()
    {
      super();
    }
    
    public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
    {
      AppMethodBeat.i(8715);
      if ((paramShareContent == null) || ((paramShareContent instanceof ShareCameraEffectContent)) || ((paramShareContent instanceof ShareStoryContent)))
      {
        AppMethodBeat.o(8715);
        return false;
      }
      if (!paramBoolean) {
        if (paramShareContent.getShareHashtag() != null)
        {
          paramBoolean = DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG);
          bool = paramBoolean;
          if ((paramShareContent instanceof ShareLinkContent))
          {
            bool = paramBoolean;
            if (Utility.isNullOrEmpty(((ShareLinkContent)paramShareContent).getQuote())) {}
          }
        }
      }
      for (boolean bool = paramBoolean & DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);; bool = true)
      {
        if ((bool) && (ShareDialog.access$500(paramShareContent.getClass())))
        {
          AppMethodBeat.o(8715);
          return true;
        }
        AppMethodBeat.o(8715);
        return false;
        paramBoolean = true;
        break;
      }
    }
    
    public AppCall createAppCall(final ShareContent paramShareContent)
    {
      AppMethodBeat.i(8716);
      ShareDialog.access$700(ShareDialog.this, ShareDialog.access$600(ShareDialog.this), paramShareContent, ShareDialog.Mode.NATIVE);
      ShareContentValidation.validateForNativeShare(paramShareContent);
      final AppCall localAppCall = ShareDialog.this.createBaseAppCall();
      DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
      {
        public Bundle getLegacyParameters()
        {
          AppMethodBeat.i(8714);
          Bundle localBundle = LegacyNativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, this.val$shouldFailOnDataError);
          AppMethodBeat.o(8714);
          return localBundle;
        }
        
        public Bundle getParameters()
        {
          AppMethodBeat.i(8713);
          Bundle localBundle = NativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, this.val$shouldFailOnDataError);
          AppMethodBeat.o(8713);
          return localBundle;
        }
      }, ShareDialog.access$800(paramShareContent.getClass()));
      AppMethodBeat.o(8716);
      return localAppCall;
    }
    
    public Object getMode()
    {
      return ShareDialog.Mode.NATIVE;
    }
  }
  
  class ShareStoryHandler
    extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
  {
    private ShareStoryHandler()
    {
      super();
    }
    
    public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
    {
      AppMethodBeat.i(8721);
      if (((paramShareContent instanceof ShareStoryContent)) && (ShareDialog.access$500(paramShareContent.getClass())))
      {
        AppMethodBeat.o(8721);
        return true;
      }
      AppMethodBeat.o(8721);
      return false;
    }
    
    public AppCall createAppCall(final ShareContent paramShareContent)
    {
      AppMethodBeat.i(8722);
      ShareContentValidation.validateForStoryShare(paramShareContent);
      final AppCall localAppCall = ShareDialog.this.createBaseAppCall();
      DialogPresenter.setupAppCallForNativeDialog(localAppCall, new DialogPresenter.ParameterProvider()
      {
        public Bundle getLegacyParameters()
        {
          AppMethodBeat.i(8720);
          Bundle localBundle = LegacyNativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, this.val$shouldFailOnDataError);
          AppMethodBeat.o(8720);
          return localBundle;
        }
        
        public Bundle getParameters()
        {
          AppMethodBeat.i(8719);
          Bundle localBundle = NativeDialogParameters.create(localAppCall.getCallId(), paramShareContent, this.val$shouldFailOnDataError);
          AppMethodBeat.o(8719);
          return localBundle;
        }
      }, ShareDialog.access$800(paramShareContent.getClass()));
      AppMethodBeat.o(8722);
      return localAppCall;
    }
    
    public Object getMode()
    {
      return ShareDialog.Mode.NATIVE;
    }
  }
  
  class WebShareHandler
    extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
  {
    private WebShareHandler()
    {
      super();
    }
    
    private SharePhotoContent createAndMapAttachments(SharePhotoContent paramSharePhotoContent, UUID paramUUID)
    {
      AppMethodBeat.i(8727);
      SharePhotoContent.Builder localBuilder = new SharePhotoContent.Builder().readFrom(paramSharePhotoContent);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramSharePhotoContent.getPhotos().size())
      {
        SharePhoto localSharePhoto2 = (SharePhoto)paramSharePhotoContent.getPhotos().get(i);
        Object localObject = localSharePhoto2.getBitmap();
        SharePhoto localSharePhoto1 = localSharePhoto2;
        if (localObject != null)
        {
          localObject = NativeAppCallAttachmentStore.createAttachment(paramUUID, (Bitmap)localObject);
          localSharePhoto1 = new SharePhoto.Builder().readFrom(localSharePhoto2).setImageUrl(Uri.parse(((NativeAppCallAttachmentStore.Attachment)localObject).getAttachmentUrl())).setBitmap(null).build();
          localArrayList2.add(localObject);
        }
        localArrayList1.add(localSharePhoto1);
        i += 1;
      }
      localBuilder.setPhotos(localArrayList1);
      NativeAppCallAttachmentStore.addAttachments(localArrayList2);
      paramSharePhotoContent = localBuilder.build();
      AppMethodBeat.o(8727);
      return paramSharePhotoContent;
    }
    
    private String getActionName(ShareContent paramShareContent)
    {
      if (((paramShareContent instanceof ShareLinkContent)) || ((paramShareContent instanceof SharePhotoContent))) {
        return "share";
      }
      if ((paramShareContent instanceof ShareOpenGraphContent)) {
        return "share_open_graph";
      }
      return null;
    }
    
    public boolean canShow(ShareContent paramShareContent, boolean paramBoolean)
    {
      AppMethodBeat.i(8725);
      if ((paramShareContent != null) && (ShareDialog.access$900(paramShareContent)))
      {
        AppMethodBeat.o(8725);
        return true;
      }
      AppMethodBeat.o(8725);
      return false;
    }
    
    public AppCall createAppCall(ShareContent paramShareContent)
    {
      AppMethodBeat.i(8726);
      ShareDialog.access$700(ShareDialog.this, ShareDialog.access$1000(ShareDialog.this), paramShareContent, ShareDialog.Mode.WEB);
      AppCall localAppCall = ShareDialog.this.createBaseAppCall();
      ShareContentValidation.validateForWebShare(paramShareContent);
      Bundle localBundle;
      if ((paramShareContent instanceof ShareLinkContent)) {
        localBundle = WebDialogParameters.create((ShareLinkContent)paramShareContent);
      }
      for (;;)
      {
        DialogPresenter.setupAppCallForWebDialog(localAppCall, getActionName(paramShareContent), localBundle);
        AppMethodBeat.o(8726);
        return localAppCall;
        if ((paramShareContent instanceof SharePhotoContent)) {
          localBundle = WebDialogParameters.create(createAndMapAttachments((SharePhotoContent)paramShareContent, localAppCall.getCallId()));
        } else {
          localBundle = WebDialogParameters.create((ShareOpenGraphContent)paramShareContent);
        }
      }
    }
    
    public Object getMode()
    {
      return ShareDialog.Mode.WEB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.widget.ShareDialog
 * JD-Core Version:    0.7.0.1
 */