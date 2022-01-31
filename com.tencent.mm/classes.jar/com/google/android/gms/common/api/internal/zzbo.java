package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbo<O extends Api.ApiOptions>
  extends zzaf
{
  private final GoogleApi<O> zzks;
  
  public zzbo(GoogleApi<O> paramGoogleApi)
  {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    this.zzks = paramGoogleApi;
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    AppMethodBeat.i(60843);
    paramT = this.zzks.doRead(paramT);
    AppMethodBeat.o(60843);
    return paramT;
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    AppMethodBeat.i(60844);
    paramT = this.zzks.doWrite(paramT);
    AppMethodBeat.o(60844);
    return paramT;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(60846);
    Context localContext = this.zzks.getApplicationContext();
    AppMethodBeat.o(60846);
    return localContext;
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(60845);
    Looper localLooper = this.zzks.getLooper();
    AppMethodBeat.o(60845);
    return localLooper;
  }
  
  public final void zza(zzch paramzzch) {}
  
  public final void zzb(zzch paramzzch) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzbo
 * JD-Core Version:    0.7.0.1
 */