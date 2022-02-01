package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzk
  extends zzd
{
  zzk(zzj paramzzj) {}
  
  public final void zzd(GoogleSignInAccount paramGoogleSignInAccount, Status paramStatus)
  {
    AppMethodBeat.i(88341);
    if (paramGoogleSignInAccount != null) {
      zzq.zze(this.zzex.val$context).zzd(this.zzex.zzew, paramGoogleSignInAccount);
    }
    this.zzex.setResult(new GoogleSignInResult(paramGoogleSignInAccount, paramStatus));
    AppMethodBeat.o(88341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzk
 * JD-Core Version:    0.7.0.1
 */