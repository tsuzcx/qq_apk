package com.tencent.mapsdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gx
{
  private static <T extends Parcelable> T a(T paramT)
  {
    AppMethodBeat.i(225743);
    Parcel localParcel = Parcel.obtain();
    localParcel.writeParcelable(paramT, 0);
    localParcel.setDataPosition(0);
    paramT = localParcel.readParcelable(paramT.getClass().getClassLoader());
    localParcel.recycle();
    AppMethodBeat.o(225743);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gx
 * JD-Core Version:    0.7.0.1
 */