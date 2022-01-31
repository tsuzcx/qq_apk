package com.google.android.gms.internal.gcm;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zze
{
  private static final ClassLoader zzf;
  
  static
  {
    AppMethodBeat.i(57622);
    zzf = zze.class.getClassLoader();
    AppMethodBeat.o(57622);
  }
  
  public static void zzd(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(57621);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(57621);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(57621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.gcm.zze
 * JD-Core Version:    0.7.0.1
 */