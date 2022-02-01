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
    AppMethodBeat.i(5491);
    zzd = zzc.class.getClassLoader();
    AppMethodBeat.o(5491);
  }
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(5487);
    if (paramParcel.readInt() == 0)
    {
      AppMethodBeat.o(5487);
      return null;
    }
    paramParcel = (Parcelable)paramCreator.createFromParcel(paramParcel);
    AppMethodBeat.o(5487);
    return paramParcel;
  }
  
  public static void zza(Parcel paramParcel, IInterface paramIInterface)
  {
    AppMethodBeat.i(5490);
    if (paramIInterface == null)
    {
      paramParcel.writeStrongBinder(null);
      AppMethodBeat.o(5490);
      return;
    }
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
    AppMethodBeat.o(5490);
  }
  
  public static void zza(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(5488);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(5488);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(5488);
  }
  
  public static void zza(Parcel paramParcel, boolean paramBoolean)
  {
    AppMethodBeat.i(5486);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      AppMethodBeat.o(5486);
      return;
    }
  }
  
  public static boolean zza(Parcel paramParcel)
  {
    AppMethodBeat.i(5485);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(5485);
      return true;
    }
    AppMethodBeat.o(5485);
    return false;
  }
  
  public static void zzb(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(5489);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(5489);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 1);
    AppMethodBeat.o(5489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.stable.zzc
 * JD-Core Version:    0.7.0.1
 */