package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzacm;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcb.zza;
import com.google.android.gms.internal.zzvv;
import java.io.IOException;

final class zze$1
  implements zze.zza<TokenData>
{
  zze$1(Account paramAccount, String paramString, Bundle paramBundle) {}
  
  public final TokenData zzat(IBinder paramIBinder)
  {
    Object localObject1 = (Bundle)zze.zzo(zzcb.zza.zza(paramIBinder).zza(this.zzaiB, this.zzaiC, this.val$options));
    paramIBinder = TokenData.zzd((Bundle)localObject1, "tokenDetails");
    if (paramIBinder != null) {
      return paramIBinder;
    }
    paramIBinder = ((Bundle)localObject1).getString("Error");
    localObject1 = (Intent)((Bundle)localObject1).getParcelable("userRecoveryIntent");
    Object localObject2 = zzvv.zzcE(paramIBinder);
    if (zzvv.zza((zzvv)localObject2))
    {
      zzacm localzzacm = zze.zzqN();
      localObject2 = String.valueOf(localObject2);
      localzzacm.zzf("GoogleAuthUtil", new Object[] { String.valueOf(localObject2).length() + 31 + "isUserRecoverableError status: " + (String)localObject2 });
      throw new UserRecoverableAuthException(paramIBinder, (Intent)localObject1);
    }
    if (zzvv.zzb((zzvv)localObject2)) {
      throw new IOException(paramIBinder);
    }
    throw new GoogleAuthException(paramIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.zze.1
 * JD-Core Version:    0.7.0.1
 */