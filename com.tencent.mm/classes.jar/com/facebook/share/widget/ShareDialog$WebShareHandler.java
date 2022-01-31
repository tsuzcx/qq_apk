package com.facebook.share.widget;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhoto.Builder;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class ShareDialog$WebShareHandler
  extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler
{
  private ShareDialog$WebShareHandler(ShareDialog paramShareDialog)
  {
    super(paramShareDialog);
  }
  
  private SharePhotoContent createAndMapAttachments(SharePhotoContent paramSharePhotoContent, UUID paramUUID)
  {
    AppMethodBeat.i(97703);
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
    AppMethodBeat.o(97703);
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
    AppMethodBeat.i(97701);
    if ((paramShareContent != null) && (ShareDialog.access$900(paramShareContent)))
    {
      AppMethodBeat.o(97701);
      return true;
    }
    AppMethodBeat.o(97701);
    return false;
  }
  
  public AppCall createAppCall(ShareContent paramShareContent)
  {
    AppMethodBeat.i(97702);
    ShareDialog.access$700(this.this$0, ShareDialog.access$1000(this.this$0), paramShareContent, ShareDialog.Mode.WEB);
    AppCall localAppCall = this.this$0.createBaseAppCall();
    ShareContentValidation.validateForWebShare(paramShareContent);
    Bundle localBundle;
    if ((paramShareContent instanceof ShareLinkContent)) {
      localBundle = WebDialogParameters.create((ShareLinkContent)paramShareContent);
    }
    for (;;)
    {
      DialogPresenter.setupAppCallForWebDialog(localAppCall, getActionName(paramShareContent), localBundle);
      AppMethodBeat.o(97702);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.widget.ShareDialog.WebShareHandler
 * JD-Core Version:    0.7.0.1
 */