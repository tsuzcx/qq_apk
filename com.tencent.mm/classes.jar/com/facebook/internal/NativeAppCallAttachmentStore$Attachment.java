package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.UUID;

public final class NativeAppCallAttachmentStore$Attachment
{
  private final String attachmentName;
  private final String attachmentUrl;
  private Bitmap bitmap;
  private final UUID callId;
  private boolean isContentUri;
  private Uri originalUri;
  private boolean shouldCreateFile;
  
  private NativeAppCallAttachmentStore$Attachment(UUID paramUUID, Bitmap paramBitmap, Uri paramUri)
  {
    AppMethodBeat.i(72423);
    this.callId = paramUUID;
    this.bitmap = paramBitmap;
    this.originalUri = paramUri;
    if (paramUri != null)
    {
      paramBitmap = paramUri.getScheme();
      if ("content".equalsIgnoreCase(paramBitmap))
      {
        this.isContentUri = true;
        if ((paramUri.getAuthority() != null) && (!paramUri.getAuthority().startsWith("media")))
        {
          this.shouldCreateFile = bool;
          label75:
          if (this.shouldCreateFile) {
            break label201;
          }
          paramBitmap = null;
          label84:
          this.attachmentName = paramBitmap;
          if (this.shouldCreateFile) {
            break label211;
          }
        }
      }
    }
    label201:
    label211:
    for (paramUUID = this.originalUri.toString();; paramUUID = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), paramUUID, this.attachmentName))
    {
      this.attachmentUrl = paramUUID;
      AppMethodBeat.o(72423);
      return;
      bool = false;
      break;
      if ("file".equalsIgnoreCase(paramUri.getScheme()))
      {
        this.shouldCreateFile = true;
        break label75;
      }
      if (Utility.isWebUri(paramUri)) {
        break label75;
      }
      paramUUID = new FacebookException("Unsupported scheme for media Uri : ".concat(String.valueOf(paramBitmap)));
      AppMethodBeat.o(72423);
      throw paramUUID;
      if (paramBitmap != null)
      {
        this.shouldCreateFile = true;
        break label75;
      }
      paramUUID = new FacebookException("Cannot share media without a bitmap or Uri set");
      AppMethodBeat.o(72423);
      throw paramUUID;
      paramBitmap = UUID.randomUUID().toString();
      break label84;
    }
  }
  
  public final String getAttachmentUrl()
  {
    return this.attachmentUrl;
  }
  
  public final Uri getOriginalUri()
  {
    return this.originalUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.internal.NativeAppCallAttachmentStore.Attachment
 * JD-Core Version:    0.7.0.1
 */