package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class zzbh
  extends zza
{
  public static final Parcelable.Creator<zzbh> CREATOR = new zzbi();
  public final int statusCode;
  public final ConnectionConfiguration zzbUD;
  
  public zzbh(int paramInt, ConnectionConfiguration paramConnectionConfiguration)
  {
    this.statusCode = paramInt;
    this.zzbUD = paramConnectionConfiguration;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbi.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbh
 * JD-Core Version:    0.7.0.1
 */