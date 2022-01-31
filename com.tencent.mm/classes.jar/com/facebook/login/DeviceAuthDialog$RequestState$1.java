package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DeviceAuthDialog$RequestState$1
  implements Parcelable.Creator<DeviceAuthDialog.RequestState>
{
  public final DeviceAuthDialog.RequestState createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96718);
    paramParcel = new DeviceAuthDialog.RequestState(paramParcel);
    AppMethodBeat.o(96718);
    return paramParcel;
  }
  
  public final DeviceAuthDialog.RequestState[] newArray(int paramInt)
  {
    return new DeviceAuthDialog.RequestState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.login.DeviceAuthDialog.RequestState.1
 * JD-Core Version:    0.7.0.1
 */