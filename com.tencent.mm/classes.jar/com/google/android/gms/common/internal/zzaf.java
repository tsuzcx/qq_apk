package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaf
  extends zza
{
  public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
  private boolean zzaBx;
  IBinder zzaEW;
  private ConnectionResult zzaGE;
  private boolean zzaGF;
  final int zzaiI;
  
  zzaf(int paramInt, IBinder paramIBinder, ConnectionResult paramConnectionResult, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzaiI = paramInt;
    this.zzaEW = paramIBinder;
    this.zzaGE = paramConnectionResult;
    this.zzaBx = paramBoolean1;
    this.zzaGF = paramBoolean2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzaf)) {
        return false;
      }
      paramObject = (zzaf)paramObject;
    } while ((this.zzaGE.equals(paramObject.zzaGE)) && (zzyg().equals(paramObject.zzyg())));
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzag.zza(this, paramParcel, paramInt);
  }
  
  public zzr zzyg()
  {
    return zzr.zza.zzbr(this.zzaEW);
  }
  
  public ConnectionResult zzyh()
  {
    return this.zzaGE;
  }
  
  public boolean zzyi()
  {
    return this.zzaBx;
  }
  
  public boolean zzyj()
  {
    return this.zzaGF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzaf
 * JD-Core Version:    0.7.0.1
 */