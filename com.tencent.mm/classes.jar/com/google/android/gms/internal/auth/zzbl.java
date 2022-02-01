package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbl
  extends zzd
  implements zzbk
{
  zzbl(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.auth.api.internal.IAuthService");
  }
  
  public final void zzd(zzbi paramzzbi, ProxyRequest paramProxyRequest)
  {
    AppMethodBeat.i(10765);
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzf.zzd(localParcel, paramzzbi);
    zzf.zzd(localParcel, paramProxyRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
    AppMethodBeat.o(10765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzbl
 * JD-Core Version:    0.7.0.1
 */