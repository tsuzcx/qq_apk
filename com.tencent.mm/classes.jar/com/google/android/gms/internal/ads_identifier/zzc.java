package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc
{
  private static final ClassLoader zzd;
  
  static
  {
    AppMethodBeat.i(115350);
    zzd = zzc.class.getClassLoader();
    AppMethodBeat.o(115350);
  }
  
  public static void zza(Parcel paramParcel, boolean paramBoolean)
  {
    AppMethodBeat.i(115349);
    paramParcel.writeInt(1);
    AppMethodBeat.o(115349);
  }
  
  public static boolean zza(Parcel paramParcel)
  {
    AppMethodBeat.i(115348);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(115348);
      return true;
    }
    AppMethodBeat.o(115348);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.ads_identifier.zzc
 * JD-Core Version:    0.7.0.1
 */