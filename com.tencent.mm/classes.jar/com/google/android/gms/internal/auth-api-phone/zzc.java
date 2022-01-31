package com.google.android.gms.internal.auth-api-phone;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzc
{
  private static final ClassLoader zzd;
  
  static
  {
    AppMethodBeat.i(80430);
    zzd = zzc.class.getClassLoader();
    AppMethodBeat.o(80430);
  }
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(80428);
    if (paramParcel.readInt() == 0)
    {
      AppMethodBeat.o(80428);
      return null;
    }
    paramParcel = (Parcelable)paramCreator.createFromParcel(paramParcel);
    AppMethodBeat.o(80428);
    return paramParcel;
  }
  
  public static void zza(Parcel paramParcel, IInterface paramIInterface)
  {
    AppMethodBeat.i(80429);
    if (paramIInterface == null)
    {
      paramParcel.writeStrongBinder(null);
      AppMethodBeat.o(80429);
      return;
    }
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
    AppMethodBeat.o(80429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api-phone.zzc
 * JD-Core Version:    0.7.0.1
 */