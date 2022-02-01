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
    AppMethodBeat.i(11251);
    zzaj.zzf(this.zzhv).signIn(new zzaq(this.zzhv));
    AppMethodBeat.o(11251);
  }
  
  /* Error */
  public final void onConnectionFailed(com.google.android.gms.common.ConnectionResult paramConnectionResult)
  {
    // Byte code:
    //   0: sipush 11252
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   10: invokestatic 53	com/google/android/gms/common/api/internal/zzaj:zzc	(Lcom/google/android/gms/common/api/internal/zzaj;)Ljava/util/concurrent/locks/Lock;
    //   13: invokeinterface 58 1 0
    //   18: aload_0
    //   19: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   22: aload_1
    //   23: invokestatic 62	com/google/android/gms/common/api/internal/zzaj:zzb	(Lcom/google/android/gms/common/api/internal/zzaj;Lcom/google/android/gms/common/ConnectionResult;)Z
    //   26: ifeq +36 -> 62
    //   29: aload_0
    //   30: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   33: invokestatic 65	com/google/android/gms/common/api/internal/zzaj:zzi	(Lcom/google/android/gms/common/api/internal/zzaj;)V
    //   36: aload_0
    //   37: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   40: invokestatic 68	com/google/android/gms/common/api/internal/zzaj:zzj	(Lcom/google/android/gms/common/api/internal/zzaj;)V
    //   43: aload_0
    //   44: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   47: invokestatic 53	com/google/android/gms/common/api/internal/zzaj:zzc	(Lcom/google/android/gms/common/api/internal/zzaj;)Ljava/util/concurrent/locks/Lock;
    //   50: invokeinterface 71 1 0
    //   55: sipush 11252
    //   58: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   66: aload_1
    //   67: invokestatic 75	com/google/android/gms/common/api/internal/zzaj:zza	(Lcom/google/android/gms/common/api/internal/zzaj;Lcom/google/android/gms/common/ConnectionResult;)V
    //   70: goto -27 -> 43
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 14	com/google/android/gms/common/api/internal/zzas:zzhv	Lcom/google/android/gms/common/api/internal/zzaj;
    //   78: invokestatic 53	com/google/android/gms/common/api/internal/zzaj:zzc	(Lcom/google/android/gms/common/api/internal/zzaj;)Ljava/util/concurrent/locks/Lock;
    //   81: invokeinterface 71 1 0
    //   86: sipush 11252
    //   89: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	zzas
    //   0	94	1	paramConnectionResult	com.google.android.gms.common.ConnectionResult
    // Exception table:
    //   from	to	target	type
    //   18	43	73	finally
    //   62	70	73	finally
  }
  
  public final void onConnectionSuspended(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzas
 * JD-Core Version:    0.7.0.1
 */