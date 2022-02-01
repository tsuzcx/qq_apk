package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract class zzbb
  extends zze
  implements zzba
{
  public zzbb()
  {
    super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      zzd((Status)zzf.zzd(paramParcel1, Status.CREATOR), (Credential)zzf.zzd(paramParcel1, Credential.CREATOR));
    }
    for (;;)
    {
      paramParcel2.writeNoException();
      return true;
      zze((Status)zzf.zzd(paramParcel1, Status.CREATOR));
      continue;
      zzd((Status)zzf.zzd(paramParcel1, Status.CREATOR), paramParcel1.readString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbb
 * JD-Core Version:    0.7.0.1
 */