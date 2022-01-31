package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareHashtag$1
  implements Parcelable.Creator<ShareHashtag>
{
  public final ShareHashtag createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97406);
    paramParcel = new ShareHashtag(paramParcel);
    AppMethodBeat.o(97406);
    return paramParcel;
  }
  
  public final ShareHashtag[] newArray(int paramInt)
  {
    return new ShareHashtag[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.model.ShareHashtag.1
 * JD-Core Version:    0.7.0.1
 */