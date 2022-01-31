package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareMediaContent$1
  implements Parcelable.Creator<ShareMediaContent>
{
  public final ShareMediaContent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97434);
    paramParcel = new ShareMediaContent(paramParcel);
    AppMethodBeat.o(97434);
    return paramParcel;
  }
  
  public final ShareMediaContent[] newArray(int paramInt)
  {
    return new ShareMediaContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.model.ShareMediaContent.1
 * JD-Core Version:    0.7.0.1
 */