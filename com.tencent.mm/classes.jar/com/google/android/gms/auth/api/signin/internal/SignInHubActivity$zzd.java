package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.support.v4.app.p.a;
import android.support.v4.content.c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SignInHubActivity$zzd
  implements p.a<Void>
{
  private SignInHubActivity$zzd(SignInHubActivity paramSignInHubActivity) {}
  
  public final c<Void> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(50407);
    paramBundle = new zzf(this.zzfm, GoogleApiClient.getAllClients());
    AppMethodBeat.o(50407);
    return paramBundle;
  }
  
  public final void onLoaderReset(c<Void> paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity.zzd
 * JD-Core Version:    0.7.0.1
 */