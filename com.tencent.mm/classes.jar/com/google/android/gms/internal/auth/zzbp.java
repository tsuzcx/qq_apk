package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbp
  extends zzbg
{
  zzbp(zzbo paramzzbo) {}
  
  public final void zzd(ProxyResponse paramProxyResponse)
  {
    AppMethodBeat.i(10768);
    this.zzed.setResult(new zzbq(paramProxyResponse));
    AppMethodBeat.o(10768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbp
 * JD-Core Version:    0.7.0.1
 */