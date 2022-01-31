package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc
  extends zza
{
  public static final Parcelable.Creator<zzc> CREATOR = new zzd();
  public final zzbv zzbTB;
  public final IntentFilter[] zzbTC;
  public final String zzbTD;
  public final String zzbTE;
  
  zzc(IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter, String paramString1, String paramString2)
  {
    if (paramIBinder != null) {}
    for (this.zzbTB = zzbv.zza.zzfC(paramIBinder);; this.zzbTB = null)
    {
      this.zzbTC = paramArrayOfIntentFilter;
      this.zzbTD = paramString1;
      this.zzbTE = paramString2;
      return;
    }
  }
  
  public zzc(zzcy paramzzcy)
  {
    this.zzbTB = paramzzcy;
    this.zzbTC = paramzzcy.zzUy();
    this.zzbTD = paramzzcy.zzUz();
    this.zzbTE = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzAg()
  {
    if (this.zzbTB == null) {
      return null;
    }
    return this.zzbTB.asBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzc
 * JD-Core Version:    0.7.0.1
 */