package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbe
  extends zza
{
  public static final Parcelable.Creator<zzbe> CREATOR = new zzbd();
  public final int statusCode;
  public final boolean zzbUB;
  public final boolean zzbUC;
  
  public zzbe(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.statusCode = paramInt;
    this.zzbUB = paramBoolean1;
    this.zzbUC = paramBoolean2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbd.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbe
 * JD-Core Version:    0.7.0.1
 */