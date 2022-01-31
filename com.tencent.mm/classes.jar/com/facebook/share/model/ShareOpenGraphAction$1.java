package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShareOpenGraphAction$1
  implements Parcelable.Creator<ShareOpenGraphAction>
{
  public final ShareOpenGraphAction createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97518);
    paramParcel = new ShareOpenGraphAction(paramParcel);
    AppMethodBeat.o(97518);
    return paramParcel;
  }
  
  public final ShareOpenGraphAction[] newArray(int paramInt)
  {
    return new ShareOpenGraphAction[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphAction.1
 * JD-Core Version:    0.7.0.1
 */