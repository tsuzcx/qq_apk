package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc
{
  private static final ClassLoader zzd;
  
  static
  {
    AppMethodBeat.i(53040);
    zzd = zzc.class.getClassLoader();
    AppMethodBeat.o(53040);
  }
  
  public static void zza(Parcel paramParcel, boolean paramBoolean)
  {
    AppMethodBeat.i(53039);
    paramParcel.writeInt(1);
    AppMethodBeat.o(53039);
  }
  
  public static boolean zza(Parcel paramParcel)
  {
    AppMethodBeat.i(53038);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(53038);
      return true;
    }
    AppMethodBeat.o(53038);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.ads_identifier.zzc
 * JD-Core Version:    0.7.0.1
 */