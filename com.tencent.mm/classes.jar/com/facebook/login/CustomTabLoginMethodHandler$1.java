package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CustomTabLoginMethodHandler$1
  implements Parcelable.Creator
{
  public final CustomTabLoginMethodHandler createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96695);
    paramParcel = new CustomTabLoginMethodHandler(paramParcel);
    AppMethodBeat.o(96695);
    return paramParcel;
  }
  
  public final CustomTabLoginMethodHandler[] newArray(int paramInt)
  {
    return new CustomTabLoginMethodHandler[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.login.CustomTabLoginMethodHandler.1
 * JD-Core Version:    0.7.0.1
 */