package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaf;

public class zzbaw
  extends zza
{
  public static final Parcelable.Creator<zzbaw> CREATOR = new zzbax();
  private final ConnectionResult zzaGE;
  final int zzaiI;
  private final zzaf zzbEy;
  
  public zzbaw(int paramInt)
  {
    this(new ConnectionResult(paramInt, null), null);
  }
  
  zzbaw(int paramInt, ConnectionResult paramConnectionResult, zzaf paramzzaf)
  {
    this.zzaiI = paramInt;
    this.zzaGE = paramConnectionResult;
    this.zzbEy = paramzzaf;
  }
  
  public zzbaw(ConnectionResult paramConnectionResult, zzaf paramzzaf)
  {
    this(1, paramConnectionResult, paramzzaf);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbax.zza(this, paramParcel, paramInt);
  }
  
  public zzaf zzPT()
  {
    return this.zzbEy;
  }
  
  public ConnectionResult zzyh()
  {
    return this.zzaGE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzbaw
 * JD-Core Version:    0.7.0.1
 */