package com.google.android.gms.internal.measurement;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class zzp
{
  private static final ClassLoader zzql;
  
  static
  {
    AppMethodBeat.i(3534);
    zzql = zzp.class.getClassLoader();
    AppMethodBeat.o(3534);
  }
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(3530);
    if (paramParcel.readInt() == 0)
    {
      AppMethodBeat.o(3530);
      return null;
    }
    paramParcel = (Parcelable)paramCreator.createFromParcel(paramParcel);
    AppMethodBeat.o(3530);
    return paramParcel;
  }
  
  public static void zza(Parcel paramParcel, IInterface paramIInterface)
  {
    AppMethodBeat.i(3532);
    if (paramIInterface == null)
    {
      paramParcel.writeStrongBinder(null);
      AppMethodBeat.o(3532);
      return;
    }
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
    AppMethodBeat.o(3532);
  }
  
  public static void zza(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(3531);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(3531);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(3531);
  }
  
  public static void zza(Parcel paramParcel, boolean paramBoolean)
  {
    AppMethodBeat.i(3529);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      AppMethodBeat.o(3529);
      return;
    }
  }
  
  public static boolean zza(Parcel paramParcel)
  {
    AppMethodBeat.i(3528);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(3528);
      return true;
    }
    AppMethodBeat.o(3528);
    return false;
  }
  
  public static HashMap zzb(Parcel paramParcel)
  {
    AppMethodBeat.i(3533);
    paramParcel = paramParcel.readHashMap(zzql);
    AppMethodBeat.o(3533);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzp
 * JD-Core Version:    0.7.0.1
 */