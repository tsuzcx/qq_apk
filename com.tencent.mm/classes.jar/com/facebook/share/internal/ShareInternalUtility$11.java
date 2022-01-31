package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMedia.Type;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.UUID;

final class ShareInternalUtility$11
  implements Utility.Mapper<ShareMedia, Bundle>
{
  ShareInternalUtility$11(UUID paramUUID, List paramList) {}
  
  public final Bundle apply(ShareMedia paramShareMedia)
  {
    AppMethodBeat.i(97260);
    NativeAppCallAttachmentStore.Attachment localAttachment = ShareInternalUtility.access$000(this.val$appCallId, paramShareMedia);
    this.val$attachments.add(localAttachment);
    Bundle localBundle = new Bundle();
    localBundle.putString("type", paramShareMedia.getMediaType().name());
    localBundle.putString("uri", localAttachment.getAttachmentUrl());
    paramShareMedia = ShareInternalUtility.getUriExtension(localAttachment.getOriginalUri());
    if (paramShareMedia != null) {
      Utility.putNonEmptyString(localBundle, "extension", paramShareMedia);
    }
    AppMethodBeat.o(97260);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.11
 * JD-Core Version:    0.7.0.1
 */