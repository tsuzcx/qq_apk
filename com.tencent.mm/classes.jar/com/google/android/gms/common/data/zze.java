package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zze
  implements Parcelable.Creator<DataHolder>
{
  static void zza(DataHolder paramDataHolder, Parcel paramParcel, int paramInt)
  {
    int i = zzc.zzaZ(paramParcel);
    zzc.zza(paramParcel, 1, paramDataHolder.zzxl(), false);
    zzc.zza(paramParcel, 2, paramDataHolder.zzxm(), paramInt, false);
    zzc.zzc(paramParcel, 3, paramDataHolder.getStatusCode());
    zzc.zza(paramParcel, 4, paramDataHolder.zzxf(), false);
    zzc.zzc(paramParcel, 1000, paramDataHolder.zzaiI);
    zzc.zzJ(paramParcel, i);
  }
  
  public DataHolder zzaO(Parcel paramParcel)
  {
    int k = zzb.zzaY(paramParcel);
    Bundle localBundle = null;
    int i = 0;
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zzb.zzaX(paramParcel);
      switch (zzb.zzdc(m))
      {
      default: 
        zzb.zzb(paramParcel, m);
        break;
      case 1: 
        arrayOfString = zzb.zzC(paramParcel, m);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])zzb.zzb(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3: 
        i = zzb.zzg(paramParcel, m);
        break;
      case 4: 
        localBundle = zzb.zzs(paramParcel, m);
        break;
      case 1000: 
        j = zzb.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zzb.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    paramParcel = new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
    paramParcel.zzxk();
    return paramParcel;
  }
  
  public DataHolder[] zzcL(int paramInt)
  {
    return new DataHolder[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.data.zze
 * JD-Core Version:    0.7.0.1
 */