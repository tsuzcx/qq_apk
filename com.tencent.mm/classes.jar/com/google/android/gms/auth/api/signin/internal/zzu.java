package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zze;
import com.google.android.gms.internal.auth.zzf;

public abstract class zzu
  extends zze
  implements zzt
{
  public zzu()
  {
    super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 101: 
      zzd((GoogleSignInAccount)zzf.zzd(paramParcel1, GoogleSignInAccount.CREATOR), (Status)zzf.zzd(paramParcel1, Status.CREATOR));
    }
    for (;;)
    {
      paramParcel2.writeNoException();
      return true;
      zzg((Status)zzf.zzd(paramParcel1, Status.CREATOR));
      continue;
      zzh((Status)zzf.zzd(paramParcel1, Status.CREATOR));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzu
 * JD-Core Version:    0.7.0.1
 */