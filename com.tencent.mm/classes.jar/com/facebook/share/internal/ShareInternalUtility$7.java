package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.share.model.SharePhoto;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

final class ShareInternalUtility$7
  implements OpenGraphJSONUtility.PhotoJSONProcessor
{
  ShareInternalUtility$7(UUID paramUUID, ArrayList paramArrayList) {}
  
  public final JSONObject toJSONObject(SharePhoto paramSharePhoto)
  {
    AppMethodBeat.i(97270);
    NativeAppCallAttachmentStore.Attachment localAttachment = ShareInternalUtility.access$000(this.val$callId, paramSharePhoto);
    if (localAttachment == null)
    {
      AppMethodBeat.o(97270);
      return null;
    }
    this.val$attachments.add(localAttachment);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", localAttachment.getAttachmentUrl());
      if (paramSharePhoto.getUserGenerated()) {
        localJSONObject.put("user_generated", true);
      }
      AppMethodBeat.o(97270);
      return localJSONObject;
    }
    catch (JSONException paramSharePhoto)
    {
      paramSharePhoto = new FacebookException("Unable to attach images", paramSharePhoto);
      AppMethodBeat.o(97270);
      throw paramSharePhoto;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.ShareInternalUtility.7
 * JD-Core Version:    0.7.0.1
 */