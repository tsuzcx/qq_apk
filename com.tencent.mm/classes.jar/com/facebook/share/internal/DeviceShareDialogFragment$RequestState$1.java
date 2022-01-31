package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DeviceShareDialogFragment$RequestState$1
  implements Parcelable.Creator<DeviceShareDialogFragment.RequestState>
{
  public final DeviceShareDialogFragment.RequestState createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96956);
    paramParcel = new DeviceShareDialogFragment.RequestState(paramParcel);
    AppMethodBeat.o(96956);
    return paramParcel;
  }
  
  public final DeviceShareDialogFragment.RequestState[] newArray(int paramInt)
  {
    return new DeviceShareDialogFragment.RequestState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.share.internal.DeviceShareDialogFragment.RequestState.1
 * JD-Core Version:    0.7.0.1
 */