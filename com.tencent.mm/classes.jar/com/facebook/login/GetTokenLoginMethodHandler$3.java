package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GetTokenLoginMethodHandler$3
  implements Parcelable.Creator
{
  public final GetTokenLoginMethodHandler createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(96770);
    paramParcel = new GetTokenLoginMethodHandler(paramParcel);
    AppMethodBeat.o(96770);
    return paramParcel;
  }
  
  public final GetTokenLoginMethodHandler[] newArray(int paramInt)
  {
    return new GetTokenLoginMethodHandler[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.login.GetTokenLoginMethodHandler.3
 * JD-Core Version:    0.7.0.1
 */