package com.facebook.share.internal;

import android.net.Uri;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.model.SharePhoto;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebDialogParameters$1
  implements Utility.Mapper<SharePhoto, String>
{
  public final String apply(SharePhoto paramSharePhoto)
  {
    AppMethodBeat.i(97311);
    paramSharePhoto = paramSharePhoto.getImageUrl().toString();
    AppMethodBeat.o(97311);
    return paramSharePhoto;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.internal.WebDialogParameters.1
 * JD-Core Version:    0.7.0.1
 */