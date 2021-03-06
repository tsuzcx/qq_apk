package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzf
{
  private static final ClassLoader zzg;
  
  static
  {
    AppMethodBeat.i(10783);
    zzg = zzf.class.getClassLoader();
    AppMethodBeat.o(10783);
  }
  
  public static <T extends Parcelable> T zzd(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(10780);
    if (paramParcel.readInt() == 0)
    {
      AppMethodBeat.o(10780);
      return null;
    }
    paramParcel = (Parcelable)paramCreator.createFromParcel(paramParcel);
    AppMethodBeat.o(10780);
    return paramParcel;
  }
  
  public static void zzd(Parcel paramParcel, IInterface paramIInterface)
  {
    AppMethodBeat.i(10782);
    if (paramIInterface == null)
    {
      paramParcel.writeStrongBinder(null);
      AppMethodBeat.o(10782);
      return;
    }
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
    AppMethodBeat.o(10782);
  }
  
  public static void zzd(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(10781);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(10781);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(10781);
  }
  
  public static void zzd(Parcel paramParcel, boolean paramBoolean)
  {
    AppMethodBeat.i(10779);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      AppMethodBeat.o(10779);
      return;
    }
  }
  
  public static boolean zzd(Parcel paramParcel)
  {
    AppMethodBeat.i(10778);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(10778);
      return true;
    }
    AppMethodBeat.o(10778);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzf
 * JD-Core Version:    0.7.0.1
 */