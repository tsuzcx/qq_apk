package com.google.android.gms.internal.auth-api-phone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class zzh
  extends zzb
  implements zzg
{
  public zzh()
  {
    super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      zza((Status)zzc.zza(paramParcel1, Status.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.auth-api-phone.zzh
 * JD-Core Version:    0.7.0.1
 */