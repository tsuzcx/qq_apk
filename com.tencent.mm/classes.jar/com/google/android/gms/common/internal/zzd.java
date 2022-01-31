package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzd
  extends zza
{
  public static final Parcelable.Creator<zzd> CREATOR = new zze();
  final IBinder zzaEW;
  final Scope[] zzaEX;
  Integer zzaEY;
  Integer zzaEZ;
  final int zzaiI;
  
  zzd(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope, Integer paramInteger1, Integer paramInteger2)
  {
    this.zzaiI = paramInt;
    this.zzaEW = paramIBinder;
    this.zzaEX = paramArrayOfScope;
    this.zzaEY = paramInteger1;
    this.zzaEZ = paramInteger2;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzd
 * JD-Core Version:    0.7.0.1
 */