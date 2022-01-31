package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

class zzaar$zze
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private zzaar$zze(zzaar paramzzaar) {}
  
  public void onConnected(Bundle paramBundle)
  {
    zzaar.zzf(this.zzaBA).zza(new zzaar.zzd(this.zzaBA));
  }
  
  /* Error */
  public void onConnectionFailed(com.google.android.gms.common.ConnectionResult paramConnectionResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/google/android/gms/internal/zzaar$zze:zzaBA	Lcom/google/android/gms/internal/zzaar;
    //   4: invokestatic 45	com/google/android/gms/internal/zzaar:zzc	(Lcom/google/android/gms/internal/zzaar;)Ljava/util/concurrent/locks/Lock;
    //   7: invokeinterface 50 1 0
    //   12: aload_0
    //   13: getfield 17	com/google/android/gms/internal/zzaar$zze:zzaBA	Lcom/google/android/gms/internal/zzaar;
    //   16: aload_1
    //   17: invokestatic 54	com/google/android/gms/internal/zzaar:zzb	(Lcom/google/android/gms/internal/zzaar;Lcom/google/android/gms/common/ConnectionResult;)Z
    //   20: ifeq +30 -> 50
    //   23: aload_0
    //   24: getfield 17	com/google/android/gms/internal/zzaar$zze:zzaBA	Lcom/google/android/gms/internal/zzaar;
    //   27: invokestatic 57	com/google/android/gms/internal/zzaar:zzi	(Lcom/google/android/gms/internal/zzaar;)V
    //   30: aload_0
    //   31: getfield 17	com/google/android/gms/internal/zzaar$zze:zzaBA	Lcom/google/android/gms/internal/zzaar;
    //   34: invokestatic 60	com/google/android/gms/internal/zzaar:zzj	(Lcom/google/android/gms/internal/zzaar;)V
    //   37: aload_0
    //   38: getfield 17	com/google/android/gms/internal/zzaar$zze:zzaBA	Lcom/google/android/gms/internal/zzaar;
    //   41: invokestatic 45	com/google/android/gms/internal/zzaar:zzc	(Lcom/google/android/gms/internal/zzaar;)Ljava/util/concurrent/locks/Lock;
    //   44: invokeinterface 63 1 0
    //   49: return
    //   50: aload_0
    //   51: getfield 17	com/google/android/gms/internal/zzaar$zze:zzaBA	Lcom/google/android/gms/internal/zzaar;
    //   54: aload_1
    //   55: invokestatic 66	com/google/android/gms/internal/zzaar:zza	(Lcom/google/android/gms/internal/zzaar;Lcom/google/android/gms/common/ConnectionResult;)V
    //   58: goto -21 -> 37
    //   61: astore_1
    //   62: aload_0
    //   63: getfield 17	com/google/android/gms/internal/zzaar$zze:zzaBA	Lcom/google/android/gms/internal/zzaar;
    //   66: invokestatic 45	com/google/android/gms/internal/zzaar:zzc	(Lcom/google/android/gms/internal/zzaar;)Ljava/util/concurrent/locks/Lock;
    //   69: invokeinterface 63 1 0
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	zze
    //   0	76	1	paramConnectionResult	com.google.android.gms.common.ConnectionResult
    // Exception table:
    //   from	to	target	type
    //   12	37	61	finally
    //   50	58	61	finally
  }
  
  public void onConnectionSuspended(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzaar.zze
 * JD-Core Version:    0.7.0.1
 */