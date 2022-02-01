package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzx
  extends zzs
{
  private final Context mContext;
  
  public zzx(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private final void zzs()
  {
    AppMethodBeat.i(88356);
    if (!GooglePlayServicesUtil.isGooglePlayServicesUid(this.mContext, Binder.getCallingUid()))
    {
      int i = Binder.getCallingUid();
      SecurityException localSecurityException = new SecurityException(52 + "Calling UID " + i + " is not Google Play services.");
      AppMethodBeat.o(88356);
      throw localSecurityException;
    }
    AppMethodBeat.o(88356);
  }
  
  /* Error */
  public final void zzq()
  {
    // Byte code:
    //   0: ldc 63
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 65	com/google/android/gms/auth/api/signin/internal/zzx:zzs	()V
    //   9: aload_0
    //   10: getfield 13	com/google/android/gms/auth/api/signin/internal/zzx:mContext	Landroid/content/Context;
    //   13: invokestatic 71	com/google/android/gms/auth/api/signin/internal/Storage:getInstance	(Landroid/content/Context;)Lcom/google/android/gms/auth/api/signin/internal/Storage;
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 75	com/google/android/gms/auth/api/signin/internal/Storage:getSavedDefaultGoogleSignInAccount	()Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;
    //   21: astore_2
    //   22: getstatic 81	com/google/android/gms/auth/api/signin/GoogleSignInOptions:DEFAULT_SIGN_IN	Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;
    //   25: astore_1
    //   26: aload_2
    //   27: ifnull +8 -> 35
    //   30: aload_3
    //   31: invokevirtual 85	com/google/android/gms/auth/api/signin/internal/Storage:getSavedDefaultGoogleSignInOptions	()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;
    //   34: astore_1
    //   35: new 87	com/google/android/gms/common/api/GoogleApiClient$Builder
    //   38: dup
    //   39: aload_0
    //   40: getfield 13	com/google/android/gms/auth/api/signin/internal/zzx:mContext	Landroid/content/Context;
    //   43: invokespecial 89	com/google/android/gms/common/api/GoogleApiClient$Builder:<init>	(Landroid/content/Context;)V
    //   46: getstatic 95	com/google/android/gms/auth/api/Auth:GOOGLE_SIGN_IN_API	Lcom/google/android/gms/common/api/Api;
    //   49: aload_1
    //   50: invokevirtual 99	com/google/android/gms/common/api/GoogleApiClient$Builder:addApi	(Lcom/google/android/gms/common/api/Api;Lcom/google/android/gms/common/api/Api$ApiOptions$HasOptions;)Lcom/google/android/gms/common/api/GoogleApiClient$Builder;
    //   53: invokevirtual 103	com/google/android/gms/common/api/GoogleApiClient$Builder:build	()Lcom/google/android/gms/common/api/GoogleApiClient;
    //   56: astore_1
    //   57: aload_1
    //   58: invokevirtual 109	com/google/android/gms/common/api/GoogleApiClient:blockingConnect	()Lcom/google/android/gms/common/ConnectionResult;
    //   61: invokevirtual 115	com/google/android/gms/common/ConnectionResult:isSuccess	()Z
    //   64: ifeq +17 -> 81
    //   67: aload_2
    //   68: ifnull +23 -> 91
    //   71: getstatic 119	com/google/android/gms/auth/api/Auth:GoogleSignInApi	Lcom/google/android/gms/auth/api/signin/GoogleSignInApi;
    //   74: aload_1
    //   75: invokeinterface 125 2 0
    //   80: pop
    //   81: aload_1
    //   82: invokevirtual 128	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   85: ldc 63
    //   87: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: return
    //   91: aload_1
    //   92: invokevirtual 132	com/google/android/gms/common/api/GoogleApiClient:clearDefaultAccountAndReconnect	()Lcom/google/android/gms/common/api/PendingResult;
    //   95: pop
    //   96: goto -15 -> 81
    //   99: astore_2
    //   100: aload_1
    //   101: invokevirtual 128	com/google/android/gms/common/api/GoogleApiClient:disconnect	()V
    //   104: ldc 63
    //   106: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	zzx
    //   25	76	1	localObject1	java.lang.Object
    //   21	47	2	localGoogleSignInAccount	com.google.android.gms.auth.api.signin.GoogleSignInAccount
    //   99	11	2	localObject2	java.lang.Object
    //   16	15	3	localStorage	Storage
    // Exception table:
    //   from	to	target	type
    //   57	67	99	finally
    //   71	81	99	finally
    //   91	96	99	finally
  }
  
  public final void zzr()
  {
    AppMethodBeat.i(88355);
    zzs();
    zzq.zze(this.mContext).clear();
    AppMethodBeat.o(88355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzx
 * JD-Core Version:    0.7.0.1
 */