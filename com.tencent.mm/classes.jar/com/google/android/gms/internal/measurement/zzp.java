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
    AppMethodBeat.i(40324);
    zzql = zzp.class.getClassLoader();
    AppMethodBeat.o(40324);
  }
  
  public static <T extends Parcelable> T zza(Parcel paramParcel, Parcelable.Creator<T> paramCreator)
  {
    AppMethodBeat.i(40320);
    if (paramParcel.readInt() == 0)
    {
      AppMethodBeat.o(40320);
      return null;
    }
    paramParcel = (Parcelable)paramCreator.createFromParcel(paramParcel);
    AppMethodBeat.o(40320);
    return paramParcel;
  }
  
  public static void zza(Parcel paramParcel, IInterface paramIInterface)
  {
    AppMethodBeat.i(40322);
    if (paramIInterface == null)
    {
      paramParcel.writeStrongBinder(null);
      AppMethodBeat.o(40322);
      return;
    }
    paramParcel.writeStrongBinder(paramIInterface.asBinder());
    AppMethodBeat.o(40322);
  }
  
  public static void zza(Parcel paramParcel, Parcelable paramParcelable)
  {
    AppMethodBeat.i(40321);
    if (paramParcelable == null)
    {
      paramParcel.writeInt(0);
      AppMethodBeat.o(40321);
      return;
    }
    paramParcel.writeInt(1);
    paramParcelable.writeToParcel(paramParcel, 0);
    AppMethodBeat.o(40321);
  }
  
  public static void zza(Parcel paramParcel, boolean paramBoolean)
  {
    AppMethodBeat.i(40319);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      AppMethodBeat.o(40319);
      return;
    }
  }
  
  public static boolean zza(Parcel paramParcel)
  {
    AppMethodBeat.i(40318);
    if (paramParcel.readInt() != 0)
    {
      AppMethodBeat.o(40318);
      return true;
    }
    AppMethodBeat.o(40318);
    return false;
  }
  
  public static HashMap zzb(Parcel paramParcel)
  {
    AppMethodBeat.i(40323);
    paramParcel = paramParcel.readHashMap(zzql);
    AppMethodBeat.o(40323);
    return paramParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzp
 * JD-Core Version:    0.7.0.1
 */