package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareLinkContent$1
  implements Parcelable.Creator<ShareLinkContent>
{
  public final ShareLinkContent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97418);
    paramParcel = new ShareLinkContent(paramParcel);
    AppMethodBeat.o(97418);
    return paramParcel;
  }
  
  public final ShareLinkContent[] newArray(int paramInt)
  {
    return new ShareLinkContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareLinkContent.1
 * JD-Core Version:    0.7.0.1
 */