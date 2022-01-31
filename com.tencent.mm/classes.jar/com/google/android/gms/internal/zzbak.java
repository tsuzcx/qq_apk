package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzbak
  extends zza
  implements Result
{
  public static final Parcelable.Creator<zzbak> CREATOR = new zzbal();
  final int zzaiI;
  private int zzbEr;
  private Intent zzbEs;
  
  public zzbak()
  {
    this(0, null);
  }
  
  zzbak(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.zzaiI = paramInt1;
    this.zzbEr = paramInt2;
    this.zzbEs = paramIntent;
  }
  
  public zzbak(int paramInt, Intent paramIntent)
  {
    this(2, paramInt, paramIntent);
  }
  
  public Status getStatus()
  {
    if (this.zzbEr == 0) {
      return Status.zzazx;
    }
    return Status.zzazB;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbal.zza(this, paramParcel, paramInt);
  }
  
  public int zzPO()
  {
    return this.zzbEr;
  }
  
  public Intent zzPP()
  {
    return this.zzbEs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzbak
 * JD-Core Version:    0.7.0.1
 */