package com.google.android.gms.internal.gcm;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zze
{
  private static final ClassLoader zzf;
  
  static
  {
    AppMethodBeat.i(2576);
    zzf = zze.class.getClassLoader();
    AppMethodBeat.o(2576);
  }
  
  public static void zzd(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(2575);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(2575);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(2575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zze
 * JD-Core Version:    0.7.0.1
 */