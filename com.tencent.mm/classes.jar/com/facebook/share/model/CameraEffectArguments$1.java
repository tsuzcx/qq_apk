package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CameraEffectArguments$1
  implements Parcelable.Creator<CameraEffectArguments>
{
  public final CameraEffectArguments createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(97335);
    paramParcel = new CameraEffectArguments(paramParcel);
    AppMethodBeat.o(97335);
    return paramParcel;
  }
  
  public final CameraEffectArguments[] newArray(int paramInt)
  {
    return new CameraEffectArguments[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.model.CameraEffectArguments.1
 * JD-Core Version:    0.7.0.1
 */