package com.google.android.gms.internal.wearable;

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
    AppMethodBeat.i(100656);
    zzd = zzc.class.getClassLoader();
    AppMethodBeat.o(100656);
  }
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(100653);
    if (paramParcel.readInt() == 0)
    {
      AppMethodBeat.o(100653);
      return null;
    }
    paramParcel = (Parcelable)paramCreator.createFromParcel(paramParcel);
    AppMethodBeat.o(100653);
    return paramParcel;
  }
  
  public static void zza(Parcel paramParcel, IInterface paramIInterface)
  {
    AppMethodBeat.i(100655);
    if (paramIInterface == null)
    {
      paramParcel.writeStrongBinder(null);
      AppMethodBeat.o(100655);
      return;
    }
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
    AppMethodBeat.o(100655);
  }
  
  public static void zza(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(100654);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(100654);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(100654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzc
 * JD-Core Version:    0.7.0.1
 */