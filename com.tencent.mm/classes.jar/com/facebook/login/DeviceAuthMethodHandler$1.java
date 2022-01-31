package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DeviceAuthMethodHandler$1
  implements Parcelable.Creator
{
  public final DeviceAuthMethodHandler createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96749);
    paramParcel = new DeviceAuthMethodHandler(paramParcel);
    AppMethodBeat.o(96749);
    return paramParcel;
  }
  
  public final DeviceAuthMethodHandler[] newArray(int paramInt)
  {
    return new DeviceAuthMethodHandler[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.login.DeviceAuthMethodHandler.1
 * JD-Core Version:    0.7.0.1
 */