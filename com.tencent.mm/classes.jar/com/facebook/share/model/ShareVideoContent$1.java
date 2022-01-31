package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareVideoContent$1
  implements Parcelable.Creator<ShareVideoContent>
{
  public final ShareVideoContent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97610);
    paramParcel = new ShareVideoContent(paramParcel);
    AppMethodBeat.o(97610);
    return paramParcel;
  }
  
  public final ShareVideoContent[] newArray(int paramInt)
  {
    return new ShareVideoContent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareVideoContent.1
 * JD-Core Version:    0.7.0.1
 */