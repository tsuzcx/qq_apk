package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zzl
  extends zzi.zza
{
  private final Context mContext;
  
  public zzl(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void zzrw()
  {
    if (!GooglePlayServicesUtil.zzf(this.mContext, Binder.getCallingUid()))
    {
      int i = Binder.getCallingUid();
      throw new SecurityException(52 + "Calling UID " + i + " is not Google Play services.");
    }
  }
  
  /* Error */
  private void zzrx()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/google/android/gms/auth/api/signin/internal/zzl:mContext	Landroid/content/Context;
    //   4: invokestatic 59	com/google/android/gms/auth/api/signin/internal/zzn:zzas	(Landroid/content/Context;)Lcom/google/android/gms/auth/api/signin/internal/zzn;
    //   7: astore_3
    //   8: aload_3
    //   9: invokevirtual 63	com/google/android/gms/auth/api/signin/internal/zzn:zzrB	()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   12: astore_2
    //   13: getstatic 69	com/google/android/gms/auth/api/signin/GoogleSignInOptions:DEFAULT_SIGN_IN	Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;
    //   16: astore_1
    //   17: aload_2
    //   18: ifnull +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 73	com/google/android/gms/auth/api/signin/internal/zzn:zzrC	()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;
    //   25: astore_1
    //   26: new 75	com/google/android/gms/common/api/GoogleApiClient$Builder
    //   29: dup
    //   30: aload_0
    //   31: getfield 13	com/google/android/gms/auth/api/signin/internal/zzl:mContext	Landroid/content/Context;
    //   34: invokespecial 77	com/google/android/gms/common/api/GoogleApiClient$Builder:<init>	(Landroid/content/Context;)V
    //   37: getstatic 83	com/google/android/gms/auth/api/Auth:GOOGLE_SIGN_IN_API	Lcom/google/android/gms/common/api/Api;
    //   40: aload_1
    //   41: invokevirtual 87	com/google/android/gms/common/api/GoogleApiClient$Builder:addApi	(Lcom/google/android/gms/common/api/Api;Lcom/google/android/gms/common/api/Api$ApiOptions$HasOptions;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;
    //   44: invokevirtual 91	com/google/android/gms/common/api/GoogleApiClient$Builder:build	()Lcom/google/android/gms/common/api/GoogleApiClient;
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 97	com/google/android/gms/common/api/GoogleApiClient:blockingConnect	()Lcom/google/android/gms/common/ConnectionResult;
    //   52: invokevirtual 103	com/google/android/gms/common/ConnectionResult:isSuccess	()Z
    //   55: ifeq +17 -> 72
    //   58: aload_2
    //   59: ifnull +18 -> 77
    //   62: getstatic 107	com/google/android/gms/auth/api/Auth:GoogleSignInApi	Lcom/google/android/gms/auth/api/signin/GoogleSignInApi;
    //   65: aload_1
    //   66: invokeinterface 113 2 0
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual 116	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   76: return
    //   77: aload_1
    //   78: invokevirtual 120	com/google/android/gms/common/api/GoogleApiClient:clearDefaultAccountAndReconnect	()Lcom/google/android/gms/common/api/PendingResult;
    //   81: pop
    //   82: goto -10 -> 72
    //   85: astore_2
    //   86: aload_1
    //   87: invokevirtual 116	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   90: aload_2
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	zzl
    //   16	71	1	localObject1	java.lang.Object
    //   12	47	2	localGoogleSignInAccount	com.google.android.gms.auth.api.signin.GoogleSignInAccount
    //   85	6	2	localObject2	java.lang.Object
    //   7	15	3	localzzn	zzn
    // Exception table:
    //   from	to	target	type
    //   48	58	85	finally
    //   62	72	85	finally
    //   77	82	85	finally
  }
  
  public void zzrv()
  {
    zzrw();
    zzrx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzl
 * JD-Core Version:    0.7.0.1
 */