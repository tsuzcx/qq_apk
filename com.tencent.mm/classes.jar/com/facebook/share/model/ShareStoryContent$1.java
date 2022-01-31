package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareStoryContent$1
  implements Parcelable.Creator<ShareStoryContent>
{
  public final ShareStoryContent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97582);
    paramParcel = new ShareStoryContent(paramParcel);
    AppMethodBeat.o(97582);
    return paramParcel;
  }
  
  public final ShareStoryContent[] newArray(int paramInt)
  {
    return new ShareStoryContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareStoryContent.1
 * JD-Core Version:    0.7.0.1
 */