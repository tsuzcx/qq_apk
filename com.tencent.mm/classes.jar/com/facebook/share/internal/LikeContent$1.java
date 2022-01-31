package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LikeContent$1
  implements Parcelable.Creator<LikeContent>
{
  public final LikeContent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97088);
    paramParcel = new LikeContent(paramParcel);
    AppMethodBeat.o(97088);
    return paramParcel;
  }
  
  public final LikeContent[] newArray(int paramInt)
  {
    return new LikeContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeContent.1
 * JD-Core Version:    0.7.0.1
 */