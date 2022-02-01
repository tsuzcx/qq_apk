package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.wearable.zzb;
import com.google.android.gms.internal.wearable.zzc;

public abstract class zzel
  extends zzb
  implements zzek
{
  public zzel()
  {
    super("com.google.android.gms.wearable.internal.IWearableCallbacks");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    case 21: 
    case 24: 
    case 25: 
    default: 
      return false;
    case 2: 
      zza((zzdw)zzc.zza(paramParcel1, zzdw.CREATOR));
    }
    for (;;)
    {
      paramParcel2.writeNoException();
      return true;
      zza((zzdy)zzc.zza(paramParcel1, zzdy.CREATOR));
      continue;
      zza((zzdr)zzc.zza(paramParcel1, zzdr.CREATOR));
      continue;
      zza((zzdv)zzc.zza(paramParcel1, zzdv.CREATOR));
      continue;
      zza((zzdt)zzc.zza(paramParcel1, zzdt.CREATOR));
      continue;
      zza((zzfu)zzc.zza(paramParcel1, zzfu.CREATOR));
      continue;
      zza((zzec)zzc.zza(paramParcel1, zzec.CREATOR));
      continue;
      zzb((DataHolder)zzc.zza(paramParcel1, DataHolder.CREATOR));
      continue;
      zza((zzdg)zzc.zza(paramParcel1, zzdg.CREATOR));
      continue;
      zza((zzga)zzc.zza(paramParcel1, zzga.CREATOR));
      continue;
      zza((zzee)zzc.zza(paramParcel1, zzee.CREATOR));
      continue;
      zza((zzeg)zzc.zza(paramParcel1, zzeg.CREATOR));
      continue;
      zza((zzea)zzc.zza(paramParcel1, zzea.CREATOR));
      continue;
      zza((zzfq)zzc.zza(paramParcel1, zzfq.CREATOR));
      continue;
      zza((zzbt)zzc.zza(paramParcel1, zzbt.CREATOR));
      continue;
      zzb((zzbt)zzc.zza(paramParcel1, zzbt.CREATOR));
      continue;
      zza((zzdm)zzc.zza(paramParcel1, zzdm.CREATOR));
      continue;
      zza((zzdo)zzc.zza(paramParcel1, zzdo.CREATOR));
      continue;
      zza((zzbn)zzc.zza(paramParcel1, zzbn.CREATOR));
      continue;
      zza((zzbp)zzc.zza(paramParcel1, zzbp.CREATOR));
      continue;
      zza((Status)zzc.zza(paramParcel1, Status.CREATOR));
      continue;
      zza((zzge)zzc.zza(paramParcel1, zzge.CREATOR));
      continue;
      zza((zzdk)zzc.zza(paramParcel1, zzdk.CREATOR));
      continue;
      zza((zzdi)zzc.zza(paramParcel1, zzdi.CREATOR));
      continue;
      zza((zzf)zzc.zza(paramParcel1, zzf.CREATOR));
      continue;
      zza((zzfy)zzc.zza(paramParcel1, zzfy.CREATOR));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzel
 * JD-Core Version:    0.7.0.1
 */