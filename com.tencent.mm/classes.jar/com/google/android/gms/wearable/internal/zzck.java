package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzck
  extends zza
{
  public static final Parcelable.Creator<zzck> CREATOR = new zzcl();
  final int zzaiI;
  public final zzbv zzbTB;
  
  zzck(int paramInt, IBinder paramIBinder)
  {
    this.zzaiI = paramInt;
    if (paramIBinder != null)
    {
      this.zzbTB = zzbv.zza.zzfC(paramIBinder);
      return;
    }
    this.zzbTB = null;
  }
  
  public zzck(zzbv paramzzbv)
  {
    this.zzaiI = 1;
    this.zzbTB = paramzzbv;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzcl.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzAg()
  {
    if (this.zzbTB == null) {
      return null;
    }
    return this.zzbTB.asBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzck
 * JD-Core Version:    0.7.0.1
 */