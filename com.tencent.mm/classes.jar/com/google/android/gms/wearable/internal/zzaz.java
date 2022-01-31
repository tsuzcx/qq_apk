package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaz
  extends zza
{
  public static final Parcelable.Creator<zzaz> CREATOR = new zzba();
  public final int statusCode;
  public final ParcelFileDescriptor zzbUz;
  
  public zzaz(int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.statusCode = paramInt;
    this.zzbUz = paramParcelFileDescriptor;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzba.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaz
 * JD-Core Version:    0.7.0.1
 */