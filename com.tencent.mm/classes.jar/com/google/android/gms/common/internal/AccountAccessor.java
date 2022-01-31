package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountAccessor
  extends IAccountAccessor.Stub
{
  private Context mContext;
  private int zzqu;
  private Account zzs;
  
  public AccountAccessor(Context paramContext, Account paramAccount)
  {
    AppMethodBeat.i(89557);
    this.zzqu = -1;
    this.mContext = paramContext.getApplicationContext();
    this.zzs = paramAccount;
    AppMethodBeat.o(89557);
  }
  
  public static AccountAccessor fromGoogleAccountName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89555);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = new Account(paramString, "com.google"))
    {
      paramContext = new AccountAccessor(paramContext, paramString);
      AppMethodBeat.o(89555);
      return paramContext;
    }
  }
  
  /* Error */
  public static Account getAccountBinderSafe(IAccountAccessor paramIAccountAccessor)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aload 4
    //   10: astore_3
    //   11: aload_0
    //   12: ifnull +18 -> 30
    //   15: invokestatic 67	android/os/Binder:clearCallingIdentity	()J
    //   18: lstore_1
    //   19: aload_0
    //   20: invokeinterface 73 1 0
    //   25: astore_3
    //   26: lload_1
    //   27: invokestatic 77	android/os/Binder:restoreCallingIdentity	(J)V
    //   30: ldc 61
    //   32: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_3
    //   36: areturn
    //   37: astore_0
    //   38: lload_1
    //   39: invokestatic 77	android/os/Binder:restoreCallingIdentity	(J)V
    //   42: aload 4
    //   44: astore_3
    //   45: goto -15 -> 30
    //   48: astore_0
    //   49: lload_1
    //   50: invokestatic 77	android/os/Binder:restoreCallingIdentity	(J)V
    //   53: ldc 61
    //   55: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_0
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramIAccountAccessor	IAccountAccessor
    //   18	32	1	l	long
    //   10	35	3	localObject1	Object
    //   6	37	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	26	37	android/os/RemoteException
    //   19	26	48	finally
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(89559);
    if (this == paramObject)
    {
      AppMethodBeat.o(89559);
      return true;
    }
    if (!(paramObject instanceof AccountAccessor))
    {
      AppMethodBeat.o(89559);
      return false;
    }
    boolean bool = this.zzs.equals(((AccountAccessor)paramObject).zzs);
    AppMethodBeat.o(89559);
    return bool;
  }
  
  public Account getAccount()
  {
    AppMethodBeat.i(89558);
    int i = Binder.getCallingUid();
    if (i == this.zzqu)
    {
      localObject = this.zzs;
      AppMethodBeat.o(89558);
      return localObject;
    }
    if (GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.mContext, i))
    {
      this.zzqu = i;
      localObject = this.zzs;
      AppMethodBeat.o(89558);
      return localObject;
    }
    Object localObject = new SecurityException("Caller is not GooglePlayServices");
    AppMethodBeat.o(89558);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.AccountAccessor
 * JD-Core Version:    0.7.0.1
 */