package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareVideo$1
  implements Parcelable.Creator<ShareVideo>
{
  public final ShareVideo createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97597);
    paramParcel = new ShareVideo(paramParcel);
    AppMethodBeat.o(97597);
    return paramParcel;
  }
  
  public final ShareVideo[] newArray(int paramInt)
  {
    return new ShareVideo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.model.ShareVideo.1
 * JD-Core Version:    0.7.0.1
 */