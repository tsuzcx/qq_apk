package com.facebook;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AccessToken$2
  implements Parcelable.Creator
{
  public final AccessToken createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(16946);
    paramParcel = new AccessToken(paramParcel);
    AppMethodBeat.o(16946);
    return paramParcel;
  }
  
  public final AccessToken[] newArray(int paramInt)
  {
    return new AccessToken[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.AccessToken.2
 * JD-Core Version:    0.7.0.1
 */