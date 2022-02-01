package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SafeParcelReader$ParseException
  extends RuntimeException
{
  public SafeParcelReader$ParseException(String paramString, Parcel paramParcel)
  {
    super(String.valueOf(paramString).length() + 41 + paramString + " Parcel: pos=" + i + " size=" + j);
    AppMethodBeat.i(4751);
    AppMethodBeat.o(4751);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException
 * JD-Core Version:    0.7.0.1
 */