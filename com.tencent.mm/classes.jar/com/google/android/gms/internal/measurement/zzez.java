package com.google.android.gms.internal.measurement;

import android.os.Parcel;

public abstract class zzez
  extends zzo
  implements zzey
{
  public zzez()
  {
    super("com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    case 3: 
    case 8: 
    default: 
      return false;
    case 1: 
      zza((zzeu)zzp.zza(paramParcel1, zzeu.CREATOR), (zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
    }
    for (;;)
    {
      return true;
      zza((zzjx)zzp.zza(paramParcel1, zzjx.CREATOR), (zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza((zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zza((zzeu)zzp.zza(paramParcel1, zzeu.CREATOR), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      zzb((zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
      continue;
      paramParcel1 = zza((zzdz)zzp.zza(paramParcel1, zzdz.CREATOR), zzp.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      continue;
      paramParcel1 = zza((zzeu)zzp.zza(paramParcel1, zzeu.CREATOR), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      continue;
      zza(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      continue;
      paramParcel1 = zzc((zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      continue;
      zza((zzed)zzp.zza(paramParcel1, zzed.CREATOR), (zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zzb((zzed)zzp.zza(paramParcel1, zzed.CREATOR));
      paramParcel2.writeNoException();
      continue;
      paramParcel1 = zza(paramParcel1.readString(), paramParcel1.readString(), zzp.zza(paramParcel1), (zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      continue;
      paramParcel1 = zza(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), zzp.zza(paramParcel1));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      continue;
      paramParcel1 = zza(paramParcel1.readString(), paramParcel1.readString(), (zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      continue;
      paramParcel1 = zze(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      continue;
      zzd((zzdz)zzp.zza(paramParcel1, zzdz.CREATOR));
      paramParcel2.writeNoException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzez
 * JD-Core Version:    0.7.0.1
 */