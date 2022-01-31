package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import com.google.android.gms.common.zzg;

public class zza
  extends zzr.zza
{
  int zzaEV;
  
  /* Error */
  public static Account zza(zzr paramzzr)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnull +18 -> 21
    //   6: invokestatic 16	android/os/Binder:clearCallingIdentity	()J
    //   9: lstore_1
    //   10: aload_0
    //   11: invokeinterface 22 1 0
    //   16: astore_3
    //   17: lload_1
    //   18: invokestatic 26	android/os/Binder:restoreCallingIdentity	(J)V
    //   21: aload_3
    //   22: areturn
    //   23: astore_0
    //   24: lload_1
    //   25: invokestatic 26	android/os/Binder:restoreCallingIdentity	(J)V
    //   28: aconst_null
    //   29: areturn
    //   30: astore_0
    //   31: lload_1
    //   32: invokestatic 26	android/os/Binder:restoreCallingIdentity	(J)V
    //   35: aload_0
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	paramzzr	zzr
    //   9	23	1	l	long
    //   1	21	3	localAccount	Account
    // Exception table:
    //   from	to	target	type
    //   10	17	23	android/os/RemoteException
    //   10	17	30	finally
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zza)) {
      return false;
    }
    throw new NullPointerException();
  }
  
  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == this.zzaEV) {
      return null;
    }
    if (zzg.zzf(null, i))
    {
      this.zzaEV = i;
      return null;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.internal.zza
 * JD-Core Version:    0.7.0.1
 */