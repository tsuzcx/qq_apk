package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzv<O extends Api.ApiOptions>
  extends GoogleApi<O>
{
  private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
  private final Api.Client zzgd;
  private final zzp zzge;
  private final ClientSettings zzgf;
  
  public zzv(Context paramContext, Api<O> paramApi, Looper paramLooper, Api.Client paramClient, zzp paramzzp, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> paramAbstractClientBuilder)
  {
    super(paramContext, paramApi, paramLooper);
    AppMethodBeat.i(11472);
    this.zzgd = paramClient;
    this.zzge = paramzzp;
    this.zzgf = paramClientSettings;
    this.zzdh = paramAbstractClientBuilder;
    this.zzcq.zza(this);
    AppMethodBeat.o(11472);
  }
  
  public final Api.Client zza(Looper paramLooper, GoogleApiManager.zza<O> paramzza)
  {
    AppMethodBeat.i(11473);
    this.zzge.zza(paramzza);
    paramLooper = this.zzgd;
    AppMethodBeat.o(11473);
    return paramLooper;
  }
  
  public final zzby zza(Context paramContext, Handler paramHandler)
  {
    AppMethodBeat.i(11474);
    paramContext = new zzby(paramContext, paramHandler, this.zzgf, this.zzdh);
    AppMethodBeat.o(11474);
    return paramContext;
  }
  
  public final Api.Client zzae()
  {
    return this.zzgd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzv
 * JD-Core Version:    0.7.0.1
 */