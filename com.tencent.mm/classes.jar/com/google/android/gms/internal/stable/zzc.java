package com.google.android.gms.internal.stable;

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
    AppMethodBeat.i(90470);
    zzd = zzc.class.getClassLoader();
    AppMethodBeat.o(90470);
  }
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(90466);
    if (paramParcel.readInt() == 0)
    {
      AppMethodBeat.o(90466);
      return null;
    }
    paramParcel = (Parcelable)paramCreator.createFromParcel(paramParcel);
    AppMethodBeat.o(90466);
    return paramParcel;
  }
  
  public static void zza(Parcel paramParcel, IInterface paramIInterface)
  {
    AppMethodBeat.i(90469);
    if (paramIInterface == null)
    {
      paramParcel.writeStrongBinder(null);
      AppMethodBeat.o(90469);
      return;
    }
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
    AppMethodBeat.o(90469);
  }
  
  public static void zza(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(90467);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(90467);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(90467);
  }
  
  public static void zza(Parcel paramParcel, boolean paramBoolean)
  {
    AppMethodBeat.i(90465);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      AppMethodBeat.o(90465);
      return;
    }
  }
  
  public static boolean zza(Parcel paramParcel)
  {
    AppMethodBeat.i(90464);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(90464);
      return true;
    }
    AppMethodBeat.o(90464);
    return false;
  }
  
  public static void zzb(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(90468);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(90468);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 1);
    AppMethodBeat.o(90468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzc
 * JD-Core Version:    0.7.0.1
 */