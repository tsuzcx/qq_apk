package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import com.google.android.gms.auth.api.accounttransfer.zzw;
import com.google.android.gms.common.api.Status;

public abstract class zzab
  extends zze
  implements zzaa
{
  public zzab()
  {
    super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      zze((Status)zzf.zzd(paramParcel1, Status.CREATOR));
    }
    for (;;)
    {
      return true;
      zzd((Status)zzf.zzd(paramParcel1, Status.CREATOR), (zzw)zzf.zzd(paramParcel1, zzw.CREATOR));
      continue;
      zzd((Status)zzf.zzd(paramParcel1, Status.CREATOR), (zzo)zzf.zzd(paramParcel1, zzo.CREATOR));
      continue;
      zzi();
      continue;
      onFailure((Status)zzf.zzd(paramParcel1, Status.CREATOR));
      continue;
      zzd(paramParcel1.createByteArray());
      continue;
      zzd((DeviceMetaData)zzf.zzd(paramParcel1, DeviceMetaData.CREATOR));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzab
 * JD-Core Version:    0.7.0.1
 */