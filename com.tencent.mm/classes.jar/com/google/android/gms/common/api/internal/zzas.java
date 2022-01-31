package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.signin.SignInClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzas
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private zzas(zzaj paramzzaj) {}
  
  public final void onConnected(Bundle paramBundle)
  {
    AppMethodBeat.i(60759);
    zzaj.zzf(this.zzhv).signIn(new zzaq(this.zzhv));
    AppMethodBeat.o(60759);
  }
  
  /* Error */
  public final void onConnectionFailed(com.google.android.gms.common.ConnectionResult paramConnectionResult)
  {
    // Byte code:
    //   0: ldc 51
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   9: invokestatic 55	com/google/android/gms/common/api/internal/zzaj:zzc	(Lcom/google/android/gms/common/api/internal/zzaj;)Ljava/util/concurrent/locks/Lock;
    //   12: invokeinterface 60 1 0
    //   17: aload_0
    //   18: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   21: aload_1
    //   22: invokestatic 64	com/google/android/gms/common/api/internal/zzaj:zzb	(Lcom/google/android/gms/common/api/internal/zzaj;Lcom/google/android/gms/common/ConnectionResult;)Z
    //   25: ifeq +35 -> 60
    //   28: aload_0
    //   29: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   32: invokestatic 67	com/google/android/gms/common/api/internal/zzaj:zzi	(Lcom/google/android/gms/common/api/internal/zzaj;)V
    //   35: aload_0
    //   36: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   39: invokestatic 70	com/google/android/gms/common/api/internal/zzaj:zzj	(Lcom/google/android/gms/common/api/internal/zzaj;)V
    //   42: aload_0
    //   43: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   46: invokestatic 55	com/google/android/gms/common/api/internal/zzaj:zzc	(Lcom/google/android/gms/common/api/internal/zzaj;)Ljava/util/concurrent/locks/Lock;
    //   49: invokeinterface 73 1 0
    //   54: ldc 51
    //   56: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: aload_0
    //   61: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   64: aload_1
    //   65: invokestatic 77	com/google/android/gms/common/api/internal/zzaj:zza	(Lcom/google/android/gms/common/api/internal/zzaj;Lcom/google/android/gms/common/ConnectionResult;)V
    //   68: goto -26 -> 42
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   76: invokestatic 55	com/google/android/gms/common/api/internal/zzaj:zzc	(Lcom/google/android/gms/common/api/internal/zzaj;)Ljava/util/concurrent/locks/Lock;
    //   79: invokeinterface 73 1 0
    //   84: ldc 51
    //   86: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	zzas
    //   0	91	1	paramConnectionResult	com.google.android.gms.common.ConnectionResult
    // Exception table:
    //   from	to	target	type
    //   17	42	71	finally
    //   60	68	71	finally
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzas
 * JD-Core Version:    0.7.0.1
 */