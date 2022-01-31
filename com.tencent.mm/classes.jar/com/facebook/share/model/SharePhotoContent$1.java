package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SharePhotoContent$1
  implements Parcelable.Creator<SharePhotoContent>
{
  public final SharePhotoContent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97566);
    paramParcel = new SharePhotoContent(paramParcel);
    AppMethodBeat.o(97566);
    return paramParcel;
  }
  
  public final SharePhotoContent[] newArray(int paramInt)
  {
    return new SharePhotoContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.model.SharePhotoContent.1
 * JD-Core Version:    0.7.0.1
 */