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
    AppMethodBeat.i(4579);
    this.zzqu = -1;
    this.mContext = paramContext.getApplicationContext();
    this.zzs = paramAccount;
    AppMethodBeat.o(4579);
  }
  
  public static AccountAccessor fromGoogleAccountName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4577);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = new Account(paramString, "com.google"))
    {
      paramContext = new AccountAccessor(paramContext, paramString);
      AppMethodBeat.o(4577);
      return paramContext;
    }
  }
  
  /* Error */
  public static Account getAccountBinderSafe(IAccountAccessor paramIAccountAccessor)
  {
    // Byte code:
    //   0: sipush 4578
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 4
    //   9: aload 4
    //   11: astore_3
    //   12: aload_0
    //   13: ifnull +18 -> 31
    //   16: invokestatic 64	android/os/Binder:clearCallingIdentity	()J
    //   19: lstore_1
    //   20: aload_0
    //   21: invokeinterface 70 1 0
    //   26: astore_3
    //   27: lload_1
    //   28: invokestatic 74	android/os/Binder:restoreCallingIdentity	(J)V
    //   31: sipush 4578
    //   34: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_3
    //   38: areturn
    //   39: astore_0
    //   40: lload_1
    //   41: invokestatic 74	android/os/Binder:restoreCallingIdentity	(J)V
    //   44: aload 4
    //   46: astore_3
    //   47: goto -16 -> 31
    //   50: astore_0
    //   51: lload_1
    //   52: invokestatic 74	android/os/Binder:restoreCallingIdentity	(J)V
    //   55: sipush 4578
    //   58: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramIAccountAccessor	IAccountAccessor
    //   19	33	1	l	long
    //   11	36	3	localObject1	Object
    //   7	38	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	39	android/os/RemoteException
    //   20	27	50	finally
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4581);
    if (this == paramObject)
    {
      AppMethodBeat.o(4581);
      return true;
    }
    if (!(paramObject instanceof AccountAccessor))
    {
      AppMethodBeat.o(4581);
      return false;
    }
    boolean bool = this.zzs.equals(((AccountAccessor)paramObject).zzs);
    AppMethodBeat.o(4581);
    return bool;
  }
  
  public Account getAccount()
  {
    AppMethodBeat.i(4580);
    int i = Binder.getCallingUid();
    if (i == this.zzqu)
    {
      localObject = this.zzs;
      AppMethodBeat.o(4580);
      return localObject;
    }
    if (GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.mContext, i))
    {
      this.zzqu = i;
      localObject = this.zzs;
      AppMethodBeat.o(4580);
      return localObject;
    }
    Object localObject = new SecurityException("Caller is not GooglePlayServices");
    AppMethodBeat.o(4580);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.internal.AccountAccessor
 * JD-Core Version:    0.7.0.1
 */