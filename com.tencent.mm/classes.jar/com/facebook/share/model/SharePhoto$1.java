package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SharePhoto$1
  implements Parcelable.Creator<SharePhoto>
{
  public final SharePhoto createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(8575);
    paramParcel = new SharePhoto(paramParcel);
    AppMethodBeat.o(8575);
    return paramParcel;
  }
  
  public final SharePhoto[] newArray(int paramInt)
  {
    return new SharePhoto[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.SharePhoto.1
 * JD-Core Version:    0.7.0.1
 */