package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareInternalUtility$10
  implements Utility.Mapper<NativeAppCallAttachmentStore.Attachment, Bundle>
{
  public final Bundle apply(NativeAppCallAttachmentStore.Attachment paramAttachment)
  {
    AppMethodBeat.i(97258);
    Bundle localBundle = new Bundle();
    localBundle.putString("uri", paramAttachment.getAttachmentUrl());
    paramAttachment = ShareInternalUtility.getUriExtension(paramAttachment.getOriginalUri());
    if (paramAttachment != null) {
      Utility.putNonEmptyString(localBundle, "extension", paramAttachment);
    }
    AppMethodBeat.o(97258);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.10
 * JD-Core Version:    0.7.0.1
 */