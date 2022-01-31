package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.support.v4.app.t.a;
import android.support.v4.content.c;
import com.google.android.gms.common.api.GoogleApiClient;

class SignInHubActivity$zza
  implements t.a<Void>
{
  private SignInHubActivity$zza(SignInHubActivity paramSignInHubActivity) {}
  
  public c<Void> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    return new zzb(this.zzakN, GoogleApiClient.zzvm());
  }
  
  public void onLoaderReset(c<Void> paramc) {}
  
  public void zza(c<Void> paramc, Void paramVoid)
  {
    this.zzakN.setResult(SignInHubActivity.zza(this.zzakN), SignInHubActivity.zzb(this.zzakN));
    this.zzakN.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity.zza
 * JD-Core Version:    0.7.0.1
 */