package com.google.android.gms.internal.auth;

import android.os.IInterface;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import com.google.android.gms.auth.api.accounttransfer.zzw;
import com.google.android.gms.common.api.Status;

public abstract interface zzaa
  extends IInterface
{
  public abstract void onFailure(Status paramStatus);
  
  public abstract void zzd(DeviceMetaData paramDeviceMetaData);
  
  public abstract void zzd(Status paramStatus, zzo paramzzo);
  
  public abstract void zzd(Status paramStatus, zzw paramzzw);
  
  public abstract void zzd(byte[] paramArrayOfByte);
  
  public abstract void zze(Status paramStatus);
  
  public abstract void zzi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzaa
 * JD-Core Version:    0.7.0.1
 */