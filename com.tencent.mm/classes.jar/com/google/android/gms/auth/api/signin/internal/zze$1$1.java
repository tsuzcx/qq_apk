package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

class zze$1$1
  extends zza
{
  zze$1$1(zze.1 param1) {}
  
  public void zza(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    if (paramGoogleSignInAccount != null) {
      this.zzakA.zzaky.zzb(paramGoogleSignInAccount, this.zzakA.zzakz);
    }
    this.zzakA.zzb(new GoogleSignInResult(paramGoogleSignInAccount, paramStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zze.1.1
 * JD-Core Version:    0.7.0.1
 */